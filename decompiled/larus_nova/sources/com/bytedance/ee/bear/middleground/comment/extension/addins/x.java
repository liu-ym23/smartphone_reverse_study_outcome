package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.bear.at.AtConstant$Zone;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f231562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f231563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f231564d;

    public final class a extends ff5.a<ef5.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f231565a;

        public a(x r100) {
            this.f231565a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            Intrinsics.checkNotNullParameter((ef5.i) r100, "event");
            af5.b r101 = this.f231565a.getContext().getConfig().Q;
            if (r101 == null) goto L12;
            com.bytedance.ee.bear.middleground.comment.performance.b r102 = r101.c();
            if (r102 == null) goto L13;
            p1 r103 = this.f231565a.getContext().c();
            if (r103 == null) goto L14;
            View r104 = r103.getRootView();
            if (r104 == null) goto L15;
            r104.getViewTreeObserver().addOnDrawListener(new w(r102, r104));
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f231566a;

        public c(x r100) {
            this.f231566a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            Intrinsics.checkNotNullParameter((ef5.q) r100, "event");
            x r101 = this.f231566a;
            r101.f231562b = false;
            r101.f231563c = false;
        }
    }

    public final class d extends ff5.a<ef5.t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f231567a;

        public d(x r100) {
            this.f231567a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.t r101 = (ef5.t) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            af5.b r102 = this.f231567a.getContext().getConfig().Q;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.d() == null) goto L9;
            x r103 = this.f231567a;
            View r104 = r101.f472504a.getRootView();
            r103.f231562b = false;
            r104.getViewTreeObserver().addOnDrawListener(new y(r103, r104));
            return;
        }
    }

    public final class e extends ff5.a<ef5.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f231568a;

        public e(x r100) {
            this.f231568a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.y r101 = (ef5.y) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            af5.b r102 = this.f231568a.getContext().getConfig().Q;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.d() == null) goto L13;
            x r103 = this.f231568a;
            if (r101.f472518b <= 0) goto L9;
        L10:
            r103.f231563c = true;
            x.c(r103);
            return;
        L9:
            if (rcb.b.a(r103.getContext().getConfig().getActivity()) == true) goto L10;
            return;
        }
    }

    public final class f extends ff5.a<ef5.z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f231569a;

        public f(x r100) {
            this.f231569a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.z r101 = (ef5.z) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            af5.b r102 = this.f231569a.getContext().getConfig().Q;
            if (r102 == null) goto L6;
            x r103 = this.f231569a;
            r101.f472520a.setFpsCallback(new z(r102, r103, r101));
            return;
        }
    }

    public final class g extends ff5.a<ef5.d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f231570a;

        public g(x r100) {
            this.f231570a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.d0 r101 = (ef5.d0) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            af5.b r102 = this.f231570a.getContext().getConfig().Q;
            if (r102 == null) goto L12;
            com.bytedance.ee.bear.middleground.comment.performance.a r103 = r102.d();
            if (r103 != null) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual("REPLY", r101.f472452a) == false) goto L9;
        L10:
            r103.c(System.currentTimeMillis(), AtConstant$Zone.PART_COMMENT, r101.f472452a.toLowerCase(Locale.ROOT), "reaction_menu");
            return;
        L9:
            if (Intrinsics.areEqual("EDIT", r101.f472452a) == true) goto L10;
            return;
        }
    }

    public final class h extends ff5.a<ef5.f0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f231571a;

        public h(x r100) {
            this.f231571a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            Intrinsics.checkNotNullParameter((ef5.f0) r100, "event");
            af5.b r101 = this.f231571a.getContext().getConfig().Q;
            if (r101 == null) goto L8;
            com.bytedance.ee.bear.middleground.comment.performance.a r102 = r101.d();
            if (r102 == null) goto L9;
            r102.c(System.currentTimeMillis(), AtConstant$Zone.PART_COMMENT, "reply", "reply_area");
            return;
        L9:
            return;
        }
    }

    static {
    }

    public x() {
        this.f231564d = 60.0f;
    }

    public static final void c(x r100) {
        if (r100.f231562b == true) goto L5;
        return;
    L5:
        if (r100.f231563c == false) goto L13;
        af5.b r101 = r100.getContext().getConfig().Q;
        if (r101 == null) goto L14;
        com.bytedance.ee.bear.middleground.comment.performance.a r102 = r101.d();
        if (r102 == null) goto L15;
        r102.b();
        return;
    L15:
        return;
    L14:
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x009a -> B:15:0x009c). Please report as a decompilation issue!!! */
    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f231427a = r100;
        r100.b(ef5.t.class, new d(this));
        r100.b(ef5.q.class, new c(this));
        r100.b(ef5.y.class, new e(this));
        r100.b(ef5.z.class, new f(this));
        r100.b(ef5.i.class, new a(this));
        r100.b(ef5.d0.class, new g(this));
        r100.b(ef5.f0.class, new h(this));
    L12:
        th = move-exception;
        tt5.a.e("Comment#PerfRecordAddin", "get refresh rate exception!", th, true);
    L14:
        float r101 = 60.0f;
    L15:
        this.f231564d = r101;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 30) goto L8;
        Display r102 = getContext().getConfig().getActivity().getDisplay();     // Catch: Throwable -> L12
        if (r102 == null) goto L14;
        r101 = r102.getRefreshRate();     // Catch: Throwable -> L12
        goto L15
    L8:
        Object r103 = getContext().getConfig().getActivity().getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Throwable -> L12
        Display r104 = ((WindowManager) r103).getDefaultDisplay();     // Catch: Throwable -> L12
        if (r104 == null) goto L14;
        r101 = r104.getRefreshRate();     // Catch: Throwable -> L12
        goto L15
    }
}
