package com.bytedance.ee.bear.middleground.record.viewhistory;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c7c.b;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.widgets.tagview.DisplayTagInfoV1;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.LengthType;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ViewHistoryBaseViewHolder extends RecyclerView.ViewHolder {
    public final UDAvatar a;
    public final SpaceTagTitleView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final Context f;
    public final String g;

    public class a implements View.OnClickListener {
        public final /* synthetic */ RecordListResult.a a;

        public a(RecordListResult.a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.a.k == false) goto L6;
            ((k) org.koin.java.a.a(k.class)).e(this.a.a, null);
            return;
        }
    }

    public final void U3(RecordListResult.a r4) {
        T3(r4, false, true);
        if (r4.j == true) goto L7;
        this.c.setVisibility(0);
        this.c.setText(r4.g);
        if (TextUtils.isEmpty(r4.g) == false) goto L9;
        this.c.setVisibility(8);
        return;
    L9:
        return;
    L7:
        this.c.setVisibility(8);
    }

    public ViewHistoryBaseViewHolder(View r2, String r3) {
        super(r2);
        this.f = r2.getContext();
        this.g = r3;
        this.a = r2.findViewById(2131383759);
        this.b = (SpaceTagTitleView) r2.findViewById(2131383761);
        this.c = (TextView) r2.findViewById(2131383760);
        this.d = (TextView) r2.findViewById(2131383762);
        this.e = r2.findViewById(2131369197);
    }

    public final void T3(RecordListResult.a r10, boolean r11, boolean r12) {
        this.a.setAvatarSize(-2);
        Glide.with(this.a.getContext()).load(r10.f).placeholder(2131235295).into(this.a);
        this.b.setTitle(ou5.a.a(this.g, r10.d, r10.b, r10.c));
        TextView r0 = this.d;
        Context r1 = this.f;
        long r2 = r10.h * 1000;
        Map r4 = zu5.a.a;
        if (r1 == null) goto L5;
        boolean r6 = false;
    L6:
        String r7 = "";
        if (r6 == false) goto L10;
        String r3 = "";
    L19:
        r0.setText(r3);
        this.e.setVisibility(0);
        this.a.setOnClickListener(new a(r10));
        SpaceTagTitleView r5 = this.b;
        SpaceTagType[] r8 = new SpaceTagType[2];
        DisplayTagInfoV1 r9 = r10.e;
        if (r9 == null) goto L22;
        r7 = r9.tag_value;
    L22:
        if (r12 == true) goto L24;
    L26:
        boolean r13 = false;
    L27:
        int r14 = SpaceTagType.e;
        r8[0] = SpaceTagType.Companion.f(r7, r13, true);
        r8[1] = SpaceTagType.a(r11);
        r5.setLabels(r8);
        return;
    L24:
        if (r10.j == false) goto L26;
        r13 = true;
        goto L27
    L10:
        if (zu5.a.h(r1, r2) == false) goto L13;
        r3 = r1.getResources().getString(2131888291);
        goto L19
    L13:
        if (zu5.a.i(r2) == false) goto L16;
        r3 = r1.getResources().getString(2131888294);
        goto L19
    L16:
        if (zu5.a.g(r1, r2) == false) goto L18;
        c7c.a r15 = new c7c.a();
        r15.c(LengthType.SHORT);
        r15.a(DatePreciseness.DAY);
        r3 = b.a(r1, new Date(r2), r15);
        goto L19
    L18:
        r3 = b.a(r1, new Date(r2), null);
        goto L19
    L5:
        r6 = true;
        goto L6
    }
}
