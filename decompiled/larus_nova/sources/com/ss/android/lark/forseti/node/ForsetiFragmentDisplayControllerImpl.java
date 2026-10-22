package com.ss.android.lark.forseti.node;

import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.chain.ForsetiChainHelper;
import com.ss.android.lark.forseti.global.j;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiFragmentDisplayControllerImpl implements tua.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f424485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ForsetiChainHelper f424486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f424487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f424488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ForsetiNode f424489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final tua.b f424490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final zua.a f424491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f424492h;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiFragmentDisplayControllerImpl f424493a;

        public a(ForsetiFragmentDisplayControllerImpl r100) {
            this.f424493a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ForsetiFragmentDisplayControllerImpl.e(this.f424493a);
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiFragmentDisplayControllerImpl f424494a;

        public b(ForsetiFragmentDisplayControllerImpl r100) {
            this.f424494a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ForsetiFragmentDisplayControllerImpl.e(this.f424494a);
        }
    }

    public final boolean f() {
        return ((Boolean) this.f424487c.getValue()).booleanValue();
    }

    public static final void e(ForsetiFragmentDisplayControllerImpl r100) {
        boolean r101 = false;
        if (r100.f424489e == null) goto L13;
        tua.b r102 = r100.f424490f;
        if (r102 == null) goto L8;
        ForsetiWidth r103 = r102.F(r100.f424485a);
    L10:
        if (r103 != ForsetiWidth.FULL) goto L13;
        r101 = true;
        goto L13
    L8:
        r103 = null;
    L13:
        if (r101 == r100.f424492h) goto L18;
        r100.f424492h = r101;
        Iterator<tua.c.a> r104 = r100.f424491g.f573669a.iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        r104.next().a(r101);
        goto L16
    L20:
        return;
    }

    @Override // tua.c
    public final void a(tua.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (f() == true) goto L6;
        zua.a r101 = this.f424491g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f573669a.remove(r100);
        return;
    L6:
        List<tua.c.a> r102 = j.f424484a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) j.f424484a).remove(r100);
    }

    @Override // tua.c
    public final void b(tua.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (f() == true) goto L8;
        zua.a r101 = this.f424491g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (r101.f573669a.contains(r100) == true) goto L12;
        r101.f573669a.add(r100);
        return;
    L12:
        return;
    L8:
        List<tua.c.a> r102 = j.f424484a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ArrayList r103 = (ArrayList) j.f424484a;
        if (r103.contains(r100) == true) goto L13;
        r103.add(r100);
        return;
    }

    @Override // tua.c
    public final void c(boolean r100) {
        ForsetiNode r101 = this.f424489e;
        if (r101 != null) goto L5;
        return;
    L5:
        ForsetiChainHelper r102 = this.f424486b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "srcNode");
        com.ss.android.lark.forseti.util.dragging.d r103 = com.ss.android.lark.forseti.util.dragging.d.f424619a;
        r103.getClass();
        ForsetiWidth r104 = com.ss.android.lark.forseti.util.dragging.d.f424621c;
        ForsetiNode r105 = r102.f424353j;
        if (r105 == null) goto L12;
        if (Intrinsics.areEqual(r105, r101) == false) goto L12;
        r101 = r102.f424353j;
    L12:
        if (r102.f424356m == true) goto L18;
        ForsetiWidth r106 = r102.f424354k;
        if (r106 == null) goto L18;
        r104 = r106;
    L18:
        int r107 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.full_screen_switch_disabled") == false) goto L28;
        if (r104 != null) goto L22;
        ForsetiWidth r108 = ForsetiWidth.AVERAGE_LEVEL;
    L23:
        com.ss.android.lark.forseti.util.dragging.d.f424621c = r108;
        ForsetiColumnsDraggingHelper r109 = r102.f424349f;
        if (r109 == null) goto L26;
        ForsetiWidth r110 = r109.a(r104);
    L27:
        com.ss.android.lark.forseti.util.dragging.d.f424620b = r110;
        goto L28
    L26:
        r110 = null;
        goto L27
    L22:
        r108 = r104;
    L28:
        if (r100 == false) goto L39;
        if (r101 == null) goto L39;
        ForsetiWidth r111 = ForsetiChainHelper.d(r101);
        r103.getClass();
        ForsetiWidth r112 = com.ss.android.lark.forseti.util.dragging.d.f424621c;
        if (r111 == null) goto L37;
        if (r112 == null) goto L37;
        ForsetiChainFragment.b r113 = r101.f424495a.f424470c;
        if (r113 == null) goto L39;
        r113.a(r111, r112);
    L37:
        Log.e("FST_Node", "startAdsorptionAnimation failed, from or to is null.");
    L39:
        if (f() == true) goto L41;
        return;
    L41:
        j.a(false);
    }

    @Override // tua.c
    public final void d(boolean r100) {
        ForsetiNode r101 = this.f424489e;
        if (r101 != null) goto L5;
        return;
    L5:
        ForsetiChainHelper r102 = this.f424486b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "srcNode");
        ForsetiWidth r103 = ForsetiChainHelper.d(r101);
        r102.f424353j = r101;
        r102.f424354k = r103;
        int r104 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.full_screen_switch_disabled") == true) goto L23;
        ForsetiNode r105 = r102.f424353j;
        if (r105 != null) goto L10;
    L13:
        if (r100 == false) goto L28;
        if (r101 == null) goto L28;
        ForsetiWidth r106 = ForsetiChainHelper.d(r101);
        ForsetiWidth r107 = ForsetiWidth.FULL;
        if (r106 == null) goto L22;
        if (r107 == null) goto L22;
        ForsetiChainFragment.b r108 = r101.f424495a.f424470c;
        if (r108 == null) goto L28;
        r108.a(r106, r107);
    L22:
        Log.e("FST_Node", "startAdsorptionAnimation failed, from or to is null.");
    L28:
        if (f() == true) goto L30;
        return;
    L30:
        j.a(true);
        return;
    L10:
        if (Intrinsics.areEqual(r105, r101) == false) goto L13;
        r101 = r102.f424353j;
        goto L13
    L23:
        com.ss.android.lark.forseti.util.dragging.d r109 = com.ss.android.lark.forseti.util.dragging.d.f424619a;
        ForsetiWidth r110 = ForsetiWidth.FULL;
        r109.getClass();
        if (r110 != null) goto L26;
        r110 = ForsetiWidth.AVERAGE_LEVEL;
    L26:
        com.ss.android.lark.forseti.util.dragging.d.f424621c = r110;
        com.ss.android.lark.forseti.util.dragging.d.f424620b = r103;
        goto L28
    }

    public ForsetiFragmentDisplayControllerImpl(Fragment r100, ForsetiChainHelper r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "chainHelper");
        this.f424485a = r100;
        this.f424486b = r101;
        this.f424487c = LazyKt.lazy(ForsetiFragmentDisplayControllerImpl$forsetiNotificationNotUseObjectDisabled$2.INSTANCE);
        Lazy r102 = LazyKt.lazy(ForsetiFragmentDisplayControllerImpl$forsetiMemoryLeakFixDisabled$2.INSTANCE);
        this.f424488d = r102;
        ForsetiNode r103 = r101.c(r100);
        ForsetiWidth r104 = null;
        if (r103 != null) goto L5;
        r103 = null;
    L12:
        this.f424489e = r103;
        tua.b r105 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100.getActivity());
        this.f424490f = r105;
        this.f424491g = new zua.a();
        boolean r106 = false;
        if (r103 == null) goto L20;
        if (r105 == null) goto L18;
        r104 = r105.F(r100);
    L18:
        if (r104 != ForsetiWidth.FULL) goto L20;
        r106 = true;
    L20:
        this.f424492h = r106;
        return;
    L5:
        if (f() == true) goto L12;
        if (((Boolean) r102.getValue()).booleanValue() == true) goto L10;
        com.ss.android.lark.api.util.c.b(r103.f424502h, new a(this));
        goto L12
    L10:
        com.ss.android.lark.api.util.c.a(r103.f424502h, new b(this));
        goto L12
    }
}
