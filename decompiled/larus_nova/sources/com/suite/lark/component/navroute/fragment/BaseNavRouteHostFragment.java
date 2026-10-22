package com.suite.lark.component.navroute.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.component.navroute.api.BaseNavRouteHost;
import com.suite.lark.component.navroute.api.a;
import com.suite.lark.component.navroute.group.g;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\b\u0010 \u001a\u00020\u0011H\u0016R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X¤\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/suite/lark/component/navroute/fragment/BaseNavRouteHostFragment;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/suite/lark/component/navroute/api/IRouter;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "navHostDelegate", "Lcom/suite/lark/component/navroute/api/BaseNavRouteHost;", "getNavHostDelegate", "()Lcom/suite/lark/component/navroute/api/BaseNavRouteHost;", "viewParent", "Landroid/view/View;", "containerId", "", "getContainerId", "()I", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onPrimaryNavigationFragmentChanged", "isPrimaryNavigationFragment", "", "onDestroyView", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseNavRouteHostFragment<T extends com.suite.lark.component.navroute.api.a<?, ?>> extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f460350d;

    public abstract BaseNavRouteHost<T> S90();

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f460350d = null;
    }

    public BaseNavRouteHostFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        BaseNavRouteHost<T> r101 = S90();
        Lifecycle r102 = getLifecycle();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r102.addObserver(r101.f460243f);
        r101.f460241d = new WeakReference(r102);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPrimaryNavigationFragmentChanged(boolean r100) {
        BaseNavRouteHost<T> r101 = S90();
        if (r101.f460238a == null) goto L5;
        r101.getNavController().f460215c.enableOnBackPressed(r100);
        return;
    L5:
        r101.f460240c = r100;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if ((r100 instanceof ViewGroup) == false) goto L15;
        g r102 = g.f460389a;
        BaseNavRouteHost<T> r103 = S90();
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "navHost");
        r100.setTag(R.id.nav_route_controller_view_tag, new WeakReference(r103));
        ViewGroup r104 = (ViewGroup) r100;
        if (r104.getParent() == null) goto L13;
        Object r105 = r104.getParent();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.View");
        View r106 = (View) r105;
        this.f460350d = r106;
        Intrinsics.checkNotNull(r106);
        if (r106.getId() != getId()) goto L16;
        View r107 = this.f460350d;
        if (r107 == null) goto L12;
        BaseNavRouteHost<T> r108 = S90();
        Intrinsics.checkNotNullParameter(r107, "view");
        Intrinsics.checkNotNullParameter(r108, "navHost");
        r107.setTag(R.id.nav_route_controller_view_tag, new WeakReference(r108));
        return;
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L16:
        return;
    L13:
        return;
    L15:
        throw new IllegalStateException(("created host view " + r100 + " is not a ViewGroup").toString());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FragmentContainerView r103 = new FragmentContainerView(r100.getContext());
        int r104 = getId();
        if (r104 != 0) goto L5;
    L7:
        r104 = R.id.nav_route_host_fragment_container;
    L8:
        r103.setId(r104);
        return r103;
    L5:
        if (r104 == (-1)) goto L7;
        goto L7
    }
}
