package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import h18.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceEmptyState extends UDEmptyState {
    public SpaceEmptyState(Context r2) {
        this(r2, null);
    }

    public SpaceEmptyState(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SpaceEmptyState(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpaceEmptyState(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, 2131953440);
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
        return;
    L5:
        if (c.a.a.g("ccm_mobile_ccm_space_at_doubao_reverse_in_feishu") == true) goto L15;
        TextView r5 = (TextView) findViewById(2131364625);
        if (r5 == null) goto L16;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L12;
        r6.height = -2;
        r5.setLayoutParams(r6);
    L12:
        int r7 = getResources().getDimensionPixelSize(2131165489);
        int r8 = getResources().getDimensionPixelSize(2131165490);
        r5.setGravity(17);
        r5.setPadding(r7, r8, r7, r8);
        r5.setTextSize(0, getResources().getDimension(2131165492));
        int r9 = e.a;
        r5.setTypeface(e.b(getContext(), 1));
        r5.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131100777));
        r5.setBackgroundResource(2131232578);
        return;
    L16:
        return;
    }
}
