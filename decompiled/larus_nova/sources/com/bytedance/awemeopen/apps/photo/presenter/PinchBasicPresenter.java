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
import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.bytedance.awemeopen.apps.photo.viewmodel.FlowPagePinchVM;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class PinchBasicPresenter extends f04.a<Unit> implements PinchStableView.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f197914s = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a14.a f197915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qz3.d f197916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PinchStableView f197917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f197918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SlidesPhotosViewPager f197919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f197920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f197921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f197922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f197923l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f197924m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f197925n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f197926o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a1 f197927p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b1 f197928q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PinchBasicPresenter$pageChangeListener$1 f197929r;

    @Override // f04.a
    public final void k() {
        SlidesPhotosViewPager r100 = this.f197919h;
        if (r100 == null) goto L8;
        PinchBasicPresenter$pageChangeListener$1 r101 = this.f197929r;
        List<ViewPager.OnPageChangeListener> r102 = r100.R;
        if (r102 == null) goto L9;
        ((ArrayList) r102).remove(r101);
        return;
    L9:
        return;
    }

    public final FlowPagePinchVM q() {
        return (FlowPagePinchVM) this.f197922k.getValue();
    }

    @Override // com.bytedance.awemeopen.apps.photo.pinch.PinchStableView.c
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "gesture");
        if (this.f197926o == true) goto L5;
    L16:
        return false;
    L5:
        if (this.f197925n == true) goto L16;
        Pair<String, Boolean> r101 = this.f197916e.f535339g.getValue();
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L16;
        p(true, r100);
        return true;
    L9:
        if (r101.getSecond().booleanValue() != true) goto L11;
        r102 = true;
        goto L12
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        PinchStableView r101 = (PinchStableView) i(R.id.pinch_stable_view);
        r101.setGestureListener(this);
        r101.setOnClickListener(new w0());
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f197917f = r101;
        this.f197918g = (ViewGroup) this.f197915d.f1367b.findViewById(R.id.fl_pinch_photos_view);
        SlidesPhotosViewPager r102 = (SlidesPhotosViewPager) i(R.id.photos_viewpager);
        this.f197919h = r102;
        if (r102 == null) goto L6;
        r102.b(this.f197929r);
    L6:
        if (this.f197926o == true) goto L12;
        SlidesPhotosViewPager r103 = this.f197919h;
        if (r103 == null) goto L11;
        r103.setOnClickListener(this.f197928q);
    L11:
        this.f197920i = (ViewGroup) i(R.id.photos_container);
    L12:
        this.f197916e.i(this.f197915d.f1369d, new x0(this));
        qz3.d r104 = this.f197916e;
        LifecycleOwner r105 = this.f197915d.f1369d;
        Observer<? super Pair<Integer, Boolean>> r106 = new y0(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r106, "observer");
        if (r105 == null) goto L16;
        r104.f535335c.observe(r105, r106);
    L16:
        MutableLiveData<String> r107 = q().getStableCloseClick();
        LifecycleOwner r108 = this.f197915d.f1369d;
        final Function1<String, Unit> r109 = new PinchBasicPresenter$onBind$4(this);
        r107.observe(r108, new z0(r109));
    }

    public final void m(boolean r100) {
        if (r100 == false) goto L6;
        Activity r101 = this.f197915d.getActivity();
        if (r101 == null) goto L10;
        z04.a.b(r101, ((Number) this.f197924m.getValue()).intValue(), Boolean.FALSE);
        return;
    L10:
        return;
    L6:
        Activity r102 = this.f197915d.getActivity();
        if (r102 == null) goto L12;
        z04.a.b(r102, ((Number) this.f197923l.getValue()).intValue(), Boolean.valueOf(!com.bytedance.awemeopen.apps.framework.utils.n0.c(this.f197915d.getActivity())));
        return;
    }

    public final void n(boolean r100) {
        Activity r101 = this.f197915d.getActivity();
        Window r102 = r101.getWindow();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        z04.b.b(r101, false);
        r102.setStatusBarColor(((Number) this.f197924m.getValue()).intValue());
        return;
    L7:
        z04.b.b(r101, !com.bytedance.awemeopen.apps.framework.utils.n0.c(r101));
        r102.setStatusBarColor(((Number) this.f197923l.getValue()).intValue());
    }

    public final void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "zoomType");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("enter_from", this.f197915d.f1368c.sceneId());
        r101.put("group_id", this.f197915d.f1366a.c());
        User r102 = this.f197915d.f1366a.f();
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = r102.u();
        if (r104 == null) goto L6;
    L7:
        r101.put("author_id", r104);
        String r105 = q().getEnterMethod();
        if (r105 == null) goto L11;
        r103 = r105;
    L11:
        r101.put("enter_method", r103);
        r101.put("aweme_type", Integer.valueOf(this.f197915d.f1366a.i()));
        r101.put("zoom_type", r100);
        AosEventReporter.s(AosEventReporter.f194596a, "pinch_zoom", r101, null, null, null, 28);
        return;
    L6:
        r104 = "";
        goto L7
    }

    public final void s(boolean r100) {
        PinchStableView r101 = null;
        if (r100 == false) goto L10;
        PinchStableView r102 = this.f197917f;
        if (r102 == null) goto L7;
        r101 = r102;
    L8:
        r101.setBackgroundColor(ContextCompat.getColor(this.f197915d.getActivity(), R.color.aos_transparent));
        return;
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("stableView");
        goto L8
    L10:
        PinchStableView r103 = this.f197917f;
        if (r103 == null) goto L13;
        r101 = r103;
    L14:
        r101.setBackgroundColor(((Number) this.f197924m.getValue()).intValue());
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("stableView");
        goto L14
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.awemeopen.apps.photo.presenter.a1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.awemeopen.apps.photo.presenter.PinchBasicPresenter$pageChangeListener$1] */
    public PinchBasicPresenter(a14.a r100, qz3.d r101) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        Intrinsics.checkNotNullParameter(r101, "corePinchVM");
        super(r100.f1367b);
        this.f197915d = r100;
        this.f197916e = r101;
        this.f197922k = LazyKt.lazy(new PinchBasicPresenter$pagePinchVM$2(this));
        this.f197923l = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchBasicPresenter$autoBgColor$2(this));
        this.f197924m = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchBasicPresenter$darkBgColor$2(this));
        this.f197927p = new a1(this);
        this.f197928q = new b1(this);
        this.f197929r = new PinchBasicPresenter$pageChangeListener$1(this);
    }

    public final void o(boolean r110, boolean r111) {
        if (r110 != this.f197926o) goto L6;
        return;
    L6:
        if (this.f197919h != null) goto L8;
        return;
    L8:
        z r100 = (z) g(z.class);
        PinchStableView r101 = null;
        if (r100 == null) goto L11;
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r102 = r100.f198035g;
    L13:
        if ((r102 instanceof com.bytedance.awemeopen.apps.framework.feed.pinch.utils.d) == true) goto L16;
        r102 = null;
    L16:
        if (r102 == null) goto L18;
        r102.f195852m = r110;
    L18:
        final String r103 = this.f197915d.f1366a.c();
        ViewGroup r104 = this.f197920i;
        if (r104 != null) goto L21;
        return;
    L21:
        int[] r105 = new int[2];
        r104.getLocationOnScreen(r105);
        s(false);
        if (r110 == false) goto L49;
        this.f197926o = true;
        q().setInStableView(true);
        q().onStableViewEvent(new PinchStableViewEvent(r103, PinchStableViewEvent.State.ENTER_START));
        n(true);
        m(true);
        ViewGroup r112 = this.f197920i;
        if (r112 == null) goto L32;
        View r106 = r112.getChildAt(0);
        if (r106 == null) goto L32;
        r112.removeView(r106);
        ViewGroup r113 = this.f197918g;
        if (r113 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("stablePhotosViewRoot");
        r113 = null;
    L31:
        r113.addView(r106);
        this.f197921j = r106;
    L32:
        PinchStableView r114 = this.f197917f;
        if (r114 == null) goto L35;
        r101 = r114;
    L36:
        r101.i(r104.getHeight(), r105[1], r111, new PinchBasicPresenter$execEnterOrExit$2(this, r103));
        String r115 = q().getEnterMethod();
        if (Intrinsics.areEqual(r115, "click") == false) goto L55;
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("enter_from", this.f197915d.f1368c.sceneId());
        r107.put("group_id", this.f197915d.f1366a.c());
        User r116 = this.f197915d.f1366a.f();
        if (r116 == null) goto L43;
        String r117 = r116.u();
        if (r117 == null) goto L43;
    L44:
        r107.put("author_id", r117);
        if (r115 != null) goto L47;
        r115 = "";
    L47:
        r107.put("enter_method", r115);
        r107.put("aweme_type", Integer.valueOf(this.f197915d.f1366a.i()));
        AosEventReporter.s(AosEventReporter.f194596a, "enter_clear_screen_mode", r107, null, null, null, 28);
        return;
    L43:
        r117 = "";
        goto L44
    L55:
        return;
    L35:
        Intrinsics.throwUninitializedPropertyAccessException("stableView");
        goto L36
    L49:
        q().onStableViewEvent(new PinchStableViewEvent(r103, PinchStableViewEvent.State.EXIT_START));
        m(false);
        PinchStableView r118 = this.f197917f;
        if (r118 == null) goto L52;
        r101 = r118;
    L53:
        ViewParent r119 = r104.getParent();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.view.ViewGroup");
        r101.j(((ViewGroup) r119).getHeight(), r105[1], r111, new PinchBasicPresenter$execEnterOrExit$3(this));
        return;
    L52:
        Intrinsics.throwUninitializedPropertyAccessException("stableView");
        goto L53
    L11:
        r102 = null;
        goto L13
    }

    public final void p(boolean r100, String r110) {
        o(false, r100);
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("enter_from", this.f197915d.f1368c.sceneId());
        r101.put("group_id", this.f197915d.f1366a.c());
        User r102 = this.f197915d.f1366a.f();
        if (r102 == null) goto L6;
        String r103 = r102.u();
        if (r103 == null) goto L6;
    L7:
        r101.put("author_id", r103);
        if (r110 != null) goto L10;
        r110 = "";
    L10:
        r101.put("enter_method", r110);
        r101.put("aweme_type", Integer.valueOf(this.f197915d.f1366a.i()));
        AosEventReporter.s(AosEventReporter.f194596a, "quit_clear_screen_mode", r101, null, null, null, 28);
        return;
    L6:
        r103 = "";
        goto L7
    }
}
