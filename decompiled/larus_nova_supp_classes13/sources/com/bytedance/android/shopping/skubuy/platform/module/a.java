package com.bytedance.android.shopping.skubuy.platform.module;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.WidgetName;
import kotlin.jvm.internal.Intrinsics;
import n43.c;
import s33.b;
import w33.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<STATE extends g> extends b<STATE, yh3.a> {
    public final String b;
    public int c;
    public C0184a d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.skubuy.platform.module.a$a, reason: collision with other inner class name */
    public static final class C0184a implements SlcKeyboardMonitor.c {
        public final /* synthetic */ a a;

        public final void a() {
            c r0 = (c) ((b) this.a).a.e.g.get(WidgetName.BODY.getValue());
            if (r0 == null) goto L8;
            View r1 = r0.getView();
            if (r1 == null) goto L9;
            r1.setPadding(0, 0, 0, 0);
            return;
        L9:
            return;
        }

        public C0184a(a r1) {
            this.a = r1;
        }

        public final void b(int r5) {
            c r0 = (c) ((b) this.a).a.e.g.get(WidgetName.FOOTER.getValue());
            if (r0 == null) goto L7;
            View r1 = r0.getView();
            if (r1 == null) goto L7;
            int r2 = r1.getHeight();
        L8:
            c r3 = (c) ((b) this.a).a.e.g.get(WidgetName.BODY.getValue());
            if (r3 == null) goto L14;
            View r4 = r3.getView();
            if (r4 == null) goto L15;
            r4.setPadding(0, 0, 0, r5 - r2);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r2 = 0;
            goto L8
        }
    }

    public final void A() {
        C0184a r0 = this.d;
        if (r0 == null) goto L6;
        ((b) this).a.d.r().a(r0);
        this.d = null;
        return;
    }

    public final void x() {
        Window r0 = ((b) this).a.f.f7();     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.setSoftInputMode(48);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void y() {
        Window r0 = ((b) this).a.f.f7();
        if (r0 == null) goto L7;
        WindowManager.LayoutParams r1 = r0.getAttributes();
        if (r1 == null) goto L7;
        int r2 = r1.softInputMode;
    L8:
        this.c = r2;
        if (r0 == null) goto L11;
        r0.setSoftInputMode(48);
    L11:
        C0184a r3 = new C0184a(this);
        this.d = r3;
        ((b) this).a.d.r().c(r3);
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public final void z() {
        Window r0 = ((b) this).a.f.f7();     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.setSoftInputMode(this.c);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final String j() {
        return this.b;
    }

    public a(l33.b<STATE, yh3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "containerContext");
        super(r2);
        this.b = "KeyboardControlModule";
    }
}
