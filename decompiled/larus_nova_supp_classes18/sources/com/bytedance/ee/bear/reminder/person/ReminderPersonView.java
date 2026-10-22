package com.bytedance.ee.bear.reminder.person;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.reminder.model.ReminderUserEntity;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReminderPersonView extends LinearLayout {
    public PersonMoreItemView a;

    public ReminderPersonView(Context r2) {
        this(r2, null);
    }

    public void setUserEntityList(List<ReminderUserEntity> r9) {
        removeAllViews();
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.isEmpty() == true) goto L21;
        int r0 = Math.min(3, r9.size());
        int r3 = 0;
    L9:
        if (r3 >= r0) goto L12;
        PersonItemView r5 = new PersonItemView(getContext(), null);
        Glide.with(r5.getContext()).load(new BearGlideUrl(((ReminderUserEntity) ListProtector.get(r9, r3)).getAvatarUrl())).placeholder(2131235295).error(2131235295).into(r5.a);
        addView(r5);
        r3 = r3 + 1;
        goto L9
    L12:
        if (r9.size() > 3) goto L14;
        return;
    L14:
        if (this.a != null) goto L16;
        this.a = new PersonMoreItemView(getContext(), null);
    L16:
        PersonMoreItemView r1 = this.a;
        r1.a.setText(String.format("%s+", new Object[]{Integer.valueOf(r9.size() - 3)}));
        addView(this.a);
        return;
    }

    public ReminderPersonView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ReminderPersonView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setOrientation(0);
    }
}
