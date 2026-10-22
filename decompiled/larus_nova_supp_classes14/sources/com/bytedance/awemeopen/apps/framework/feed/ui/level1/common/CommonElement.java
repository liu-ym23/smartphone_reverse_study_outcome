package com.bytedance.awemeopen.apps.framework.feed.ui.level1.common;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.collect.serviceapi.AoViewInjectService;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CommonElement extends BaseElement<com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.a, b, Object, jz3.a> {
    public static final /* synthetic */ int q = 0;
    public final Activity g;
    public final o h;
    public final Lazy i;
    public final Lazy j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        this.k = false;
        this.m = false;
        this.l = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new c(getContext(), g(), h());
    }

    public final void q() {
        if (this.m == false) goto L5;
        return;
    L5:
        if (this.l == false) goto L9;
        String r0 = this.h.getPageConfig().getHostEnterFrom();
        String r1 = this.h.sceneId();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("enter_from", r1);
        r2.put("host_enter_from", r0);
        r2.put("request_id", "");
        r2.put("impr_id", "");
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        tz3.b<Pair<Boolean, Boolean>> r0 = h().a;
        Boolean r2 = Boolean.FALSE;
        r0.b(new Pair(r2, r2));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final d e() {
        return xz3.a.a;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r7) {
        jz3.a r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "data");
        r14.c r9 = r8.a;
        String r0 = this.h.sceneId();
        if (Intrinsics.areEqual(r0, "homepage_hot") == true) goto L5;
    L46:
        j();
        return;
    L5:
        if (((AoViewInjectService) this.i.getValue()) == null) goto L46;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.i == false) goto L46;
        d14.a r1 = b14.a.a;
        User r2 = b14.a.a(k34.b.class).b();
        if (r2 == null) goto L11;
        String r3 = r2.u();
    L13:
        if (com.bytedance.awemeopen.bizmodels.user.d.c(r9, r3) == true) goto L46;
        Integer r4 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.c(r9);
        if (r4 == null) goto L18;
        int r5 = r4.intValue();
    L20:
        if (r5 != 1) goto L22;
    L24:
        String r6 = this.h.getPageConfig().getHostEnterFrom();
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("enter_from", r0);
        r10.put("host_enter_from", r6);
        String r11 = r9.l;
        String r12 = "";
        if (r11 != null) goto L27;
        r11 = "";
    L27:
        r10.put("request_id", r11);
        a0 r13 = r9.d;
        if (r13 == null) goto L33;
        String r14 = r13.a();
        if (r14 == null) goto L33;
        r12 = r14;
    L33:
        r10.put("impr_id", r12);
        if (r5 != 1) goto L36;
        AoViewInjectService r15 = (AoViewInjectService) this.i.getValue();
        Intrinsics.checkNotNull(r15);
        this.h.sceneId();
        Integer r16 = r15.e2();
    L40:
        if (r16 != null) goto L42;
    L45:
        j();
        return;
    L42:
        if (r16.intValue() < 0) goto L45;
        AoViewInjectService r17 = (AoViewInjectService) this.i.getValue();
        Intrinsics.checkNotNull(r17);
        View r18 = i().b();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r19 = (ViewGroup) r18;
        Function0 r20 = (Function0) this.j.getValue();
        r17.I();
        j();
        return;
    L36:
        AoViewInjectService r21 = (AoViewInjectService) this.i.getValue();
        Intrinsics.checkNotNull(r21);
        this.h.sceneId();
        List r22 = r9.v();
        if (r22 == null) goto L39;
        r22.size();
    L39:
        r16 = r21.e2();
        goto L40
    L22:
        if (r5 == 3) goto L24;
        j();
        return;
    L18:
        int r23 = h.a;
        r5 = h.c(r9);
        goto L20
    L11:
        r3 = null;
        goto L13
    }

    public CommonElement(Activity r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = LazyKt.lazy(CommonElement$viewInjectService$2.INSTANCE);
        this.j = LazyKt.lazy(new CommonElement$closeCallback$2(this));
        this.n = LazyKt.lazy(new CommonElement$playProgressChangeListener$2(this));
        this.o = LazyKt.lazy(new CommonElement$onSeekBarChangeListener$2(this));
        this.p = LazyKt.lazy(new CommonElement$slidesProgressPositionObserver$2(this));
    }
}
