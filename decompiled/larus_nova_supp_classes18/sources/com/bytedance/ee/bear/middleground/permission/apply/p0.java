package com.bytedance.ee.bear.middleground.permission.apply;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p0 implements p {
    public final View a;
    public final BaseTitleBar b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final TextView f;
    public final SpaceEditText g;
    public final TextView h;
    public n i;

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final void b() {
        this.g.setText("");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final String getReason() {
        Editable r0 = this.g.getText();
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final View getRootView() {
        return this.a;
    }

    public p0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.a = r2;
        this.b = (BaseTitleBar) r2.findViewById(2131382173);
        this.c = (TextView) r2.findViewById(2131381371);
        this.d = (TextView) r2.findViewById(2131381367);
        this.e = (LinearLayout) r2.findViewById(2131382178);
        this.f = (TextView) r2.findViewById(2131382177);
        this.g = (SpaceEditText) r2.findViewById(2131371423);
        this.h = (TextView) r2.findViewById(2131385928);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.f.setText(r2);
    }

    public final void d(o r13) {
        Intrinsics.checkNotNullParameter(r13, "state");
        int r1 = 0;
        this.b.setDividerVisible(false);
        this.b.setLeftIconVisibility(r13.g);
        BaseTitleBar r0 = this.b;
        if (r13.h == false) goto L5;
        int r2 = 8;
    L6:
        r0.setVisibility(r2);
        this.c.setText(r13.a);
        TextView r3 = this.d;
        SpannableString r4 = new SpannableString(r13.b);
        String r5 = r4.toString();
        String r11 = r13.c;
        int r6 = StringsKt.indexOf$default(r5, r11, 0, false, 6, null);
        int r7 = r11.length() + r6;
        if (r11.length() != 0) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == true) goto L16;
        if (r6 < 0) goto L16;
        if (r7 > r5.length()) goto L16;
        r4.setSpan(new l0(this), r6, r7, 33);
    L16:
        r3.setText(r4);
        this.d.setMovementMethod(LinkMovementMethod.getInstance());
        this.d.setHighlightColor(0);
        LinearLayout r9 = this.e;
        if (r13.d == true) goto L20;
        r1 = 8;
    L20:
        r9.setVisibility(r1);
        this.f.setText(r13.e);
        this.h.setText(r13.f);
        this.h.setEnabled(true);
        this.h.setBackgroundResource(2131244707);
        return;
    L9:
        r8 = false;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void e(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        ImageView r0 = this.b.getLeftImage();
        if (r0 == null) goto L6;
        r0.setImageDrawable(r2);
        return;
    }

    public final void f(g r3) {
        Intrinsics.checkNotNullParameter(r3, "callbacks");
        this.i = r3;
        this.b.setLeftClickListener(new m0(r3));
        this.e.setOnClickListener(new n0(r3));
        this.h.setOnClickListener(new o0(r3, this));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final void a(boolean r3, int r4) {
        this.h.setEnabled(!r3);
        if (r3 == false) goto L5;
        this.h.setText(2131889694);
        this.h.setBackgroundResource(2131244709);
        return;
    L5:
        this.h.setText(r4);
        this.h.setBackgroundResource(2131244707);
    }
}
