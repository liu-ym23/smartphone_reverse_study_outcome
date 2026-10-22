package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.SlidesPhotosViewPager;
import com.bytedance.awemeopen.apps.photo.event.PinchStableViewEvent;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.bytedance.awemeopen.apps.photo.viewmodel.FlowPagePinchVM;
import com.bytedance.awemeopen.bizmodels.profile.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PinchBasicPresenter extends f04.a<Unit> implements PinchStableView.c {
    public static final /* synthetic */ int s = 0;
    public final a14.a d;
    public final qz3.d e;
    public PinchStableView f;
    public ViewGroup g;
    public SlidesPhotosViewPager h;
    public ViewGroup i;
    public View j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public boolean n;
    public boolean o;
    public final a1 p;
    public final b1 q;
    public final PinchBasicPresenter$pageChangeListener$1 r;

    @Override // f04.a
    public final void k() {
        SlidesPhotosViewPager r0 = this.h;
        if (r0 == null) goto L8;
        PinchBasicPresenter$pageChangeListener$1 r1 = this.r;
        List<ViewPager.OnPageChangeListener> r2 = r0.R;
        if (r2 == null) goto L9;
        ((ArrayList) r2).remove(r1);
        return;
    L9:
        return;
    }

    public final FlowPagePinchVM q() {
        return (FlowPagePinchVM) this.k.getValue();
    }

    @Override // com.bytedance.awemeopen.apps.photo.pinch.PinchStableView.c
    public final boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "gesture");
        if (this.o == true) goto L5;
    L16:
        return false;
    L5:
        if (this.n == true) goto L16;
        Pair r0 = (Pair) this.e.g.getValue();
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L16;
        p(true, r4);
        return true;
    L9:
        if (((Boolean) r0.getSecond()).booleanValue() != true) goto L11;
        r1 = true;
        goto L12
    }

    @Override // f04.a
    public final void j(Unit r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        PinchStableView r5 = (PinchStableView) i(2131382329);
        r5.setGestureListener(this);
        r5.setOnClickListener(new w0());
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f = r5;
        this.g = (ViewGroup) this.d.b.findViewById(2131372806);
        SlidesPhotosViewPager r6 = (SlidesPhotosViewPager) i(2131382259);
        this.h = r6;
        if (r6 == null) goto L6;
        r6.b(this.r);
    L6:
        if (this.o == true) goto L12;
        SlidesPhotosViewPager r7 = this.h;
        if (r7 == null) goto L11;
        r7.setOnClickListener(this.q);
    L11:
        this.i = (ViewGroup) i(2131382254);
    L12:
        this.e.i(this.d.d, new x0(this));
        qz3.d r8 = this.e;
        LifecycleOwner r0 = this.d.d;
        Observer r1 = new y0(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        if (r0 == null) goto L16;
        r8.c.observe(r0, r1);
    L16:
        MutableLiveData<String> r9 = q().getStableCloseClick();
        LifecycleOwner r2 = this.d.d;
        final Function1<String, Unit> r3 = new PinchBasicPresenter$onBind$4(this);
        r9.observe(r2, new z0(r3));
    }

    public final void m(boolean r3) {
        if (r3 == false) goto L6;
        Activity r4 = this.d.getActivity();
        if (r4 == null) goto L10;
        z04.a.b(r4, ((Number) this.m.getValue()).intValue(), Boolean.FALSE);
        return;
    L10:
        return;
    L6:
        Activity r5 = this.d.getActivity();
        if (r5 == null) goto L12;
        z04.a.b(r5, ((Number) this.l.getValue()).intValue(), Boolean.valueOf(!com.bytedance.awemeopen.apps.framework.utils.n0.c(this.d.getActivity())));
        return;
    }

    public final void n(boolean r3) {
        Activity r0 = this.d.getActivity();
        Window r1 = r0.getWindow();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        z04.b.b(r0, false);
        r1.setStatusBarColor(((Number) this.m.getValue()).intValue());
        return;
    L7:
        z04.b.b(r0, !com.bytedance.awemeopen.apps.framework.utils.n0.c(r0));
        r1.setStatusBarColor(((Number) this.l.getValue()).intValue());
    }

    public final void r(String r9) {
        Intrinsics.checkNotNullParameter(r9, "zoomType");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("enter_from", this.d.c.sceneId());
        r3.put("group_id", this.d.a.c());
        User r0 = this.d.a.f();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.u();
        if (r2 == null) goto L6;
    L7:
        r3.put("author_id", r2);
        String r4 = q().getEnterMethod();
        if (r4 == null) goto L11;
        r1 = r4;
    L11:
        r3.put("enter_method", r1);
        r3.put("aweme_type", Integer.valueOf(this.d.a.i()));
        r3.put("zoom_type", r9);
        AosEventReporter.s(AosEventReporter.a, "pinch_zoom", r3, null, null, null, 28);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public final void s(boolean r3) {
        PinchStableView r0 = null;
        if (r3 == false) goto L10;
        PinchStableView r4 = this.f;
        if (r4 == null) goto L7;
        r0 = r4;
    L8:
        r0.setBackgroundColor(ContextCompat.getColor(this.d.getActivity(), 2131100345));
        return;
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("stableView");
        goto L8
    L10:
        PinchStableView r5 = this.f;
        if (r5 == null) goto L13;
        r0 = r5;
    L14:
        r0.setBackgroundColor(((Number) this.m.getValue()).intValue());
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("stableView");
        goto L14
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.awemeopen.apps.photo.presenter.a1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.awemeopen.apps.photo.presenter.PinchBasicPresenter$pageChangeListener$1] */
    public PinchBasicPresenter(a14.a r2, qz3.d r3) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        Intrinsics.checkNotNullParameter(r3, "corePinchVM");
        super(r2.b);
        this.d = r2;
        this.e = r3;
        this.k = LazyKt.lazy(new PinchBasicPresenter$pagePinchVM$2(this));
        this.l = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchBasicPresenter$autoBgColor$2(this));
        this.m = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchBasicPresenter$darkBgColor$2(this));
        this.p = new a1(this);
        this.q = new b1(this);
        this.r = new PinchBasicPresenter$pageChangeListener$1(this);
    }

    public final void o(boolean r10, boolean r11) {
        if (r10 != this.o) goto L6;
        return;
    L6:
        if (this.h != null) goto L8;
        return;
    L8:
        z r0 = (z) g(z.class);
        PinchStableView r1 = null;
        if (r0 == null) goto L11;
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r2 = r0.g;
    L13:
        if ((r2 instanceof com.bytedance.awemeopen.apps.framework.feed.pinch.utils.d) == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        r2.m = r10;
    L18:
        final String r3 = this.d.a.c();
        ViewGroup r4 = this.i;
        if (r4 != null) goto L21;
        return;
    L21:
        int[] r5 = new int[2];
        r4.getLocationOnScreen(r5);
        s(false);
        if (r10 == false) goto L49;
        this.o = true;
        q().setInStableView(true);
        q().onStableViewEvent(new PinchStableViewEvent(r3, PinchStableViewEvent.State.ENTER_START));
        n(true);
        m(true);
        ViewGroup r12 = this.i;
        if (r12 == null) goto L32;
        View r6 = r12.getChildAt(0);
        if (r6 == null) goto L32;
        r12.removeView(r6);
        ViewGroup r13 = this.g;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("stablePhotosViewRoot");
        r13 = null;
    L31:
        r13.addView(r6);
        this.j = r6;
    L32:
        PinchStableView r14 = this.f;
        if (r14 == null) goto L35;
        r1 = r14;
    L36:
        r1.i(r4.getHeight(), r5[1], r11, new PinchBasicPresenter$execEnterOrExit$2(this, r3));
        String r15 = q().getEnterMethod();
        if (Intrinsics.areEqual(r15, PinchEnterMethod.CLICK) == false) goto L55;
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("enter_from", this.d.c.sceneId());
        r7.put("group_id", this.d.a.c());
        User r16 = this.d.a.f();
        if (r16 == null) goto L43;
        String r17 = r16.u();
        if (r17 == null) goto L43;
    L44:
        r7.put("author_id", r17);
        if (r15 != null) goto L47;
        r15 = "";
    L47:
        r7.put("enter_method", r15);
        r7.put("aweme_type", Integer.valueOf(this.d.a.i()));
        AosEventReporter.s(AosEventReporter.a, "enter_clear_screen_mode", r7, null, null, null, 28);
        return;
    L43:
        r17 = "";
        goto L44
    L55:
        return;
    L35:
        Intrinsics.throwUninitializedPropertyAccessException("stableView");
        goto L36
    L49:
        q().onStableViewEvent(new PinchStableViewEvent(r3, PinchStableViewEvent.State.EXIT_START));
        m(false);
        PinchStableView r18 = this.f;
        if (r18 == null) goto L52;
        r1 = r18;
    L53:
        ViewParent r19 = r4.getParent();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.view.ViewGroup");
        r1.j(((ViewGroup) r19).getHeight(), r5[1], r11, new PinchBasicPresenter$execEnterOrExit$3(this));
        return;
    L52:
        Intrinsics.throwUninitializedPropertyAccessException("stableView");
        goto L53
    L11:
        r2 = null;
        goto L13
    }

    public final void p(boolean r9, String r10) {
        o(false, r9);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("enter_from", this.d.c.sceneId());
        r3.put("group_id", this.d.a.c());
        User r11 = this.d.a.f();
        if (r11 == null) goto L6;
        String r12 = r11.u();
        if (r12 == null) goto L6;
    L7:
        r3.put("author_id", r12);
        if (r10 != null) goto L10;
        r10 = "";
    L10:
        r3.put("enter_method", r10);
        r3.put("aweme_type", Integer.valueOf(this.d.a.i()));
        AosEventReporter.s(AosEventReporter.a, "quit_clear_screen_mode", r3, null, null, null, 28);
        return;
    L6:
        r12 = "";
        goto L7
    }
}
