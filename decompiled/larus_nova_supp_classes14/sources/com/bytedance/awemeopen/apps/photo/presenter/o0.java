package com.bytedance.awemeopen.apps.photo.presenter;

import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o0 extends f04.a<Unit> {
    public final a14.a d;
    public final LinearLayout e;
    public final DuxTextView f;

    @Override // f04.a
    public final void k() {
    }

    public o0(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = (LinearLayout) i(2131378859);
        this.f = (DuxTextView) i(2131391415);
    }

    @Override // f04.a
    public final void j(Unit r6) {
        Intrinsics.checkNotNullParameter(r6, "unit");
        this.e.setOnClickListener(new n0(this));
        d14.a r7 = b14.a.a;
        if (b14.a.a(i34.a.class).l() == true) goto L5;
        this.e.setVisibility(8);
        return;
    L5:
        r14.c r8 = this.d.a;
        x14.a r1 = r8.J();
        String r2 = null;
        if (r1 == null) goto L8;
        String r3 = r1.d();
    L9:
        x14.a r4 = r8.J();
        if (r4 == null) goto L12;
        String r5 = r4.a();
    L13:
        x14.a r9 = r8.J();
        if (r9 == null) goto L16;
        r2 = r9.c();
    L16:
        boolean r10 = true;
        if (r3 != null) goto L19;
    L22:
        boolean r11 = true;
    L23:
        if (r11 == true) goto L39;
        if (r5 != null) goto L26;
    L29:
        boolean r12 = true;
    L30:
        if (r12 == true) goto L39;
        if (r2 != null) goto L33;
    L36:
        boolean r13 = true;
    L37:
        if (r13 == true) goto L39;
    L40:
        if (r10 == false) goto L47;
        this.e.setVisibility(0);
        r14.j r14 = this.d.a.L();
        if (r14 == null) goto L50;
        long r0 = r14.e();
        if (r0 > 0) goto L46;
        this.f.setText(2131894277);
        return;
    L46:
        x04.a.a(this.f, r0);
        return;
    L50:
        return;
    L47:
        this.e.setVisibility(8);
        return;
    L33:
        if (r2.length() == 0) goto L36;
        r13 = false;
        goto L37
    L26:
        if (r5.length() == 0) goto L29;
        r12 = false;
    L39:
        r10 = false;
        goto L40
    L19:
        if (r3.length() == 0) goto L22;
        r11 = false;
        goto L23
    L12:
        r5 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }
}
