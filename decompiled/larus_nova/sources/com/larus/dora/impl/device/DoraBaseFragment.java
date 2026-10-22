package com.larus.dora.impl.device;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ixigua.lib.track.TrackParams;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0017J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/device/DoraBaseFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "doraLinkCallback", "com/larus/dora/impl/device/DoraBaseFragment$doraLinkCallback$1", "Lcom/larus/dora/impl/device/DoraBaseFragment$doraLinkCallback$1;", WidgetCostModule.TYPE_ON_START, "", "onStop", "loadConnectState", "onDoraConnectStateChanged", "isConnected", "", "getPageMaskView", "Landroid/view/View;", "autoLogEnterPage", "logEnterPage", TeaEventTrack.ACTION_DRAMA_NEXT, WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraBaseFragment extends TraceFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraBaseFragment$doraLinkCallback$1 f333450e;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public boolean S90() {
        return !(this instanceof DoraObricDeviceHomeFragment);
    }

    public View U90() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.impl.device.DoraBaseFragment$doraLinkCallback$1] */
    public DoraBaseFragment() {
        this.f333450e = new DoraBaseFragment$doraLinkCallback$1(this);
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public void T90() {
        String r100 = k();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L22;
        DoraBuryPointManager r102 = DoraBuryPointManager.f331862a;
        Pair[] r103 = new Pair[3];
        r103[0] = TuplesKt.to("current_page", r100);
        TrackParams r104 = by7.h.e(this);
        if (r104 == null) goto L17;
        HashMap<String, Object> r105 = r104.getParams();
        if (r105 == null) goto L17;
        Object r106 = r105.get("current_page");
        if (r106 == null) goto L17;
        String r107 = r106.toString();
    L18:
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        r103[1] = TuplesKt.to("previous_page", r107);
        r103[2] = TuplesKt.to("enter_method", DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        r102.L(CheckPointType.ENTER_PAGE, MapsKt.mapOf(r103));
        return;
    L17:
        r107 = null;
        goto L18
    L22:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        kj4.a.g().registerDoraLinkCallback(this.f333450e);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraBaseFragment$loadConnectState$1(this, null), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        kj4.a.g().unregisterDoraLinkCallback(this.f333450e);
    }

    public void V90(boolean r100) {
        Context r101 = getContext();
        if (r101 == null) goto L18;
        View r102 = U90();
        if (r102 == null) goto L19;
        if (r100 == false) goto L12;
        e1.o(r102);
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L20;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L21;
        r104.setNavigationBarColor(Color.argb(1, 255, 255, 255));
        return;
    L21:
        return;
    L20:
        return;
    L12:
        e1.x(r102);
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L23;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L24;
        r106.setNavigationBarColor(r101.getResources().getColor(R.color.larus_dora_page_mask_color));
        return;
    L24:
        return;
    L23:
        return;
    L19:
        return;
    }
}
