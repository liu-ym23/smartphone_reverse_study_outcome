package com.bytedance.awemeopen.apps.framework.feed.ui.information.ad;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.infra.util.g;
import com.bytedance.awemeopen.infra.util.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AdElement extends BaseElement<b, c, tz3.a, jz3.a> {
    public final Activity g;
    public final LifecycleOwner h;
    public final o i;
    public final l14.c j;
    public final Lazy k;
    public boolean l;
    public final a m;

    public static final class a extends j {
        public final /* synthetic */ AdElement c;

        /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.ui.information.ad.AdElement$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0085a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Lifecycle.Event.values().length];
                r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a(AdElement r1) {
            this.c = r1;
        }

        public final void a(LifecycleOwner r2, Lifecycle.Event r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (this.c.l == true) goto L5;
            return;
        L5:
            int r4 = C0085a.a[r3.ordinal()];
            if (r4 != 1) goto L8;
            l14.c r5 = this.c.j;
            if (r5 == null) goto L26;
            r5.onResume();
            return;
        L26:
            return;
        L8:
            if (r4 != 2) goto L10;
            l14.c r6 = this.c.j;
            if (r6 == null) goto L24;
            r6.onPause();
            return;
        L24:
            return;
        L10:
            if (r4 != 3) goto L27;
            l14.c r7 = this.c.j;
            if (r7 == null) goto L22;
            r7.onDestroy();
            return;
        L22:
            return;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new c();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return (com.bytedance.awemeopen.apps.framework.feed.ui.information.ad.a) this.k.getValue();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        if (this.l == false) goto L8;
        l14.c r0 = this.j;
        if (r0 == null) goto L9;
        r0.u();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        if (this.l == false) goto L8;
        l14.c r0 = this.j;
        if (r0 == null) goto L9;
        r0.b();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        if (this.l == false) goto L8;
        Lifecycle r0 = this.h.getLifecycle();
        a r1 = this.m;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.removeObserver(((j) r1).b);
        l14.c r2 = this.j;
        if (r2 == null) goto L9;
        r2.o();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.a;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r13) {
        jz3.a r14 = r13;
        Intrinsics.checkNotNullParameter(r14, "data");
        j();
        d14.a r0 = b14.a.a;
        boolean r1 = b14.a.a(l24.c.class).a(r14.a);
        this.l = r1;
        if (r1 == false) goto L28;
        g.a(this.h.getLifecycle(), this.m);
        l14.c r2 = this.j;
        if (r2 == null) goto L29;
        p();
        l14.d r3 = b14.a.a(l24.c.class).L0(r14.a);
        if (r3 == null) goto L30;
        t24.a r4 = b14.a.a(t24.a.class);
        String r5 = this.i.sceneId();
        User r6 = r14.a.f();
        if (r6 == null) goto L12;
        String r7 = r6.u();
        if (r7 == null) goto L12;
    L13:
        String r8 = r14.a.c();
        String r9 = r14.a.r().c;
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        a0 r10 = r14.a.d;
        if (r10 == null) goto L19;
        String r11 = r10.a();
    L20:
        if (r11 != null) goto L22;
        r11 = "";
    L22:
        String r12 = GsonProtectorUtils.toJson(GsonHolder.a(), r14.a.d);
        User r15 = r14.a.f();
        if (r15 == null) goto L25;
        boolean r16 = r15.O();
    L26:
        AosEventReporter r17 = AosEventReporter.a;
        String r18 = this.i.sceneId();
        r17.getClass();
        String r19 = r7;
        t24.a.a.a(r4, r5, r19, r8, r9, r11, r12, r16, AosEventReporter.a(r18, r14));
        r2.g(((com.bytedance.awemeopen.apps.framework.feed.ui.information.ad.a) this.k.getValue()).b(), r3);
        return;
    L25:
        r16 = false;
        goto L26
    L19:
        r11 = null;
    L12:
        r7 = "";
        goto L13
    L30:
        return;
    L29:
        return;
    }

    public AdElement(Activity r2, LifecycleOwner r3, o r4, l14.c r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = LazyKt.lazy(new AdElement$adElementView$2(this));
        this.m = new a(this);
    }
}
