package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public boolean b;
    public boolean c;
    public float d;

    public final class a extends ff5.a<ef5.i> {
        public final /* synthetic */ x a;

        public a(x r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r4) {
            Intrinsics.checkNotNullParameter((ef5.i) r4, "event");
            af5.b r5 = this.a.getContext().getConfig().Q;
            if (r5 == null) goto L12;
            com.bytedance.ee.bear.middleground.comment.performance.b r6 = r5.c();
            if (r6 == null) goto L13;
            p1 r0 = this.a.getContext().c();
            if (r0 == null) goto L14;
            View r1 = r0.getRootView();
            if (r1 == null) goto L15;
            r1.getViewTreeObserver().addOnDrawListener(new w(r6, r1));
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class b {
    }

    public final class c extends ff5.a<ef5.q> {
        public final /* synthetic */ x a;

        public c(x r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            Intrinsics.checkNotNullParameter((ef5.q) r2, "event");
            x r3 = this.a;
            r3.b = false;
            r3.c = false;
        }
    }

    public final class d extends ff5.a<ef5.t> {
        public final /* synthetic */ x a;

        public d(x r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r4) {
            ef5.t r5 = (ef5.t) r4;
            Intrinsics.checkNotNullParameter(r5, "event");
            af5.b r0 = this.a.getContext().getConfig().Q;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.d() == null) goto L9;
            x r1 = this.a;
            View r6 = r5.a.getRootView();
            r1.b = false;
            r6.getViewTreeObserver().addOnDrawListener(new y(r1, r6));
            return;
        }
    }

    public final class e extends ff5.a<ef5.y> {
        public final /* synthetic */ x a;

        public e(x r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            ef5.y r3 = (ef5.y) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            af5.b r0 = this.a.getContext().getConfig().Q;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.d() == null) goto L13;
            x r1 = this.a;
            if (r3.b <= 0) goto L9;
        L10:
            r1.c = true;
            x.c(r1);
            return;
        L9:
            if (rcb.b.a(r1.getContext().getConfig().getActivity()) == true) goto L10;
            return;
        }
    }

    public final class f extends ff5.a<ef5.z> {
        public final /* synthetic */ x a;

        public f(x r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r5) {
            ef5.z r6 = (ef5.z) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            af5.b r0 = this.a.getContext().getConfig().Q;
            if (r0 == null) goto L6;
            x r1 = this.a;
            r6.a.setFpsCallback(new z(r0, r1, r6));
            return;
        }
    }

    public final class g extends ff5.a<ef5.d0> {
        public final /* synthetic */ x a;

        public g(x r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r8) {
            ef5.d0 r9 = (ef5.d0) r8;
            Intrinsics.checkNotNullParameter(r9, "event");
            af5.b r0 = this.a.getContext().getConfig().Q;
            if (r0 == null) goto L12;
            com.bytedance.ee.bear.middleground.comment.performance.a r1 = r0.d();
            if (r1 != null) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual("REPLY", r9.a) == false) goto L9;
        L10:
            r1.c(System.currentTimeMillis(), "part_comment", r9.a.toLowerCase(Locale.ROOT), "reaction_menu");
            return;
        L9:
            if (Intrinsics.areEqual("EDIT", r9.a) == true) goto L10;
            return;
        }
    }

    public final class h extends ff5.a<ef5.f0> {
        public final /* synthetic */ x a;

        public h(x r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r7) {
            Intrinsics.checkNotNullParameter((ef5.f0) r7, "event");
            af5.b r8 = this.a.getContext().getConfig().Q;
            if (r8 == null) goto L8;
            com.bytedance.ee.bear.middleground.comment.performance.a r0 = r8.d();
            if (r0 == null) goto L9;
            r0.c(System.currentTimeMillis(), "part_comment", "reply", "reply_area");
            return;
        L9:
            return;
        }
    }

    static {
    }

    public x() {
        this.d = 60.0f;
    }

    public static final void c(x r1) {
        if (r1.b == true) goto L5;
        return;
    L5:
        if (r1.c == false) goto L13;
        af5.b r2 = r1.getContext().getConfig().Q;
        if (r2 == null) goto L14;
        com.bytedance.ee.bear.middleground.comment.performance.a r3 = r2.d();
        if (r3 == null) goto L15;
        r3.b();
        return;
    L15:
        return;
    L14:
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x009a -> B:15:0x009c). Please report as a decompilation issue!!! */
    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r4, "host");
        this.a = r4;
        r4.b(ef5.t.class, new d(this));
        r4.b(ef5.q.class, new c(this));
        r4.b(ef5.y.class, new e(this));
        r4.b(ef5.z.class, new f(this));
        r4.b(ef5.i.class, new a(this));
        r4.b(ef5.d0.class, new g(this));
        r4.b(ef5.f0.class, new h(this));
    L12:
        th = move-exception;
        tt5.a.e("Comment#PerfRecordAddin", "get refresh rate exception!", th, true);
    L14:
        float r5 = 60.0f;
    L15:
        this.d = r5;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 30) goto L8;
        Display r6 = getContext().getConfig().getActivity().getDisplay();     // Catch: Throwable -> L12
        if (r6 == null) goto L14;
        r5 = r6.getRefreshRate();     // Catch: Throwable -> L12
        goto L15
    L8:
        Object r7 = getContext().getConfig().getActivity().getSystemService("window");     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Throwable -> L12
        Display r8 = ((WindowManager) r7).getDefaultDisplay();     // Catch: Throwable -> L12
        if (r8 == null) goto L14;
        r5 = r8.getRefreshRate();     // Catch: Throwable -> L12
        goto L15
    }
}
