package com.larus.dora.obric.device_management.device_bind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.t0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0017\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u000eH\u0002J \u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\tH\u0002J\b\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/dora/obric/device_management/device_bind/DoraObricDeviceBindFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "isChecking", "", "onboardingDialogFragment", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "prePage", "", "gpsDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "pendingCheckAction", "Lkotlin/Function0;", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "productID", "", "Ljava/lang/Integer;", "buryPointSource", "pageRenderer", "Lcom/larus/dora/obric/device_management/device_bind/DoraObricBindPageRenderer;", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDestroyView", "getCurrentPageName", "buildContentView", "buildNativePageContent", "Lcom/larus/dora/obric/device_management/device_bind/DoraObricBindPageRenderer$Content;", "buildBuyUrl", "productId", "isGlassesProduct", "(Ljava/lang/Integer;)Z", "openBuyPage", "url", "startBind", "checkReady", "from", "doNext", "handlePermissionDenied", "reason", "launchOnboarding", "resolveProductId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceBindFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f338938o = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f338939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BottomSheetDialogFragment f338940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f338941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommonDialog f338942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f338943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f338944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f338945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f338946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f338947n;

    public static final class a {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "DoraObricDeviceBindFragment";
    }

    static {
        f338938o = new int[]{ProductNameType.DORA_G.f204375id, ProductNameType.DORA_G2.f204375id, ProductNameType.DORA_G_AIR.f204375id, ProductNameType.DORA_G_PIN.f204375id};
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        f r100 = this.f338947n;
        if (r100 == null) goto L5;
        r100.f338987e = null;
        r100.f338988f = null;
        r100.f338989g = null;
        r100.f338990h = null;
        r100.f338991i = null;
        r100.f338992j = null;
        r100.f338993k = null;
    L5:
        this.f338947n = null;
        super.onDestroyView();
    }

    public DoraObricDeviceBindFragment() {
        this.f338943j = new g();
        this.f338946m = "";
    }

    public final int Z90() {
        Integer r100 = t0.a(getArguments(), "product_id");
        if (r100 != null) goto L7;
        int r101 = ProductNameType.DORA_LITE.f204375id;
        g49.d.e("DoraObricDeviceBindFragment", "resolveProductId missing or invalid, use Dora Lite");
        return r101;
    L7:
        return r100.intValue();
    }

    public static boolean Y90(Integer r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (ArraysKt.contains(f338938o, r100.intValue()) == false) goto L6;
        return true;
    }

    public final void X90(String r100) {
        g49.d.d("DoraObricDeviceBindFragment", "handlePermissionDenied: ".concat(r100));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        this.f338944k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i(this));
    }

    public final void W90(String r100, Function0<Unit> r101) {
        g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + r100 + " start");
        if (Intrinsics.areEqual(r100, "check_from_MAIN") == true) goto L5;
    L8:
        this.f338939f = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricDeviceBindFragment$checkReady$1(r100, r101, this, null), 3, null);
        return;
    L5:
        if (this.f338939f == false) goto L8;
        g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + r100 + " isChecking");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        f r100 = this.f338947n;
        boolean r101 = false;
        if (r100 == null) goto L30;
        Integer r102 = this.f338945l;
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        boolean r104 = Y90(Integer.valueOf(r103));
        if (r104 == false) goto L11;
        int r105 = R.string.larus_dora_o_glasses_slogan_title_cn;
    L12:
        if (r104 == false) goto L14;
        int r106 = R.string.larus_dora_o_glasses_slogan_subtitle_cn;
    L15:
        String r110 = getString(r105);
        String r111 = getString(r106);
        if (r104 == false) goto L18;
        int r112 = 0;
    L19:
        if (r104 == false) goto L21;
        String r113 = "larus_dora_obric_device_bind_img_glasses";
    L22:
        String r114 = getString(R.string.larus_dora_bind_device_button_title_cn);
        if (r104 == false) goto L25;
        String r115 = null;
    L26:
        if (r104 == false) goto L28;
        String r116 = null;
    L29:
        r100.d(new f.b(r110, r111, r112, r113, r114, true, r115, r116, !r104, 256));
        goto L30
    L28:
        r116 = UriProtector.parse("sslocal://flow/webview").buildUpon().appendQueryParameter("product_id", String.valueOf(r103)).appendQueryParameter("link_url", "https://www.olafriend.cn/product?allows_inline_media_playback=1").build().toString();
        goto L29
    L25:
        r115 = getString(R.string.larus_dora_lite_bind_device_buy_button_title_cn);
        goto L26
    L21:
        r113 = null;
        goto L22
    L18:
        r112 = R.drawable.larus_dora_obric_device_bind_img_lite;
        goto L19
    L14:
        r106 = R.string.larus_dora_o_earphone_slogan_subtitle_cn;
        goto L15
    L11:
        r105 = R.string.larus_dora_o_earphone_slogan_title_cn;
        goto L12
    L7:
        r103 = ProductNameType.DORA_LITE.f204375id;
    L30:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        Bundle r107 = getArguments();
        if (r107 != null) goto L33;
    L35:
        if (r101 == false) goto L38;
        W90("check_from_MAIN", new j(this));
        return;
    L38:
        return;
    L33:
        if (r107.getBoolean("key_dora_onboarding_auto_connect") != true) goto L35;
        r101 = true;
        goto L35
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Bundle r103 = getArguments();
        String r104 = "";
        if (r103 == null) goto L6;
        String r105 = r103.getString("device_manage", "");
        if (r105 == null) goto L6;
    L7:
        this.f338941h = r105;
        this.f338945l = Integer.valueOf(Z90());
        Bundle r106 = getArguments();
        if (r106 == null) goto L10;
        String r107 = r106.getString("bury_point_source");
    L11:
        if (r107 == null) goto L14;
        r104 = r107;
    L14:
        this.f338946m = r104;
        f r108 = new f(requireContext(), new h(this), new DoraObricDeviceBindFragment$buildContentView$2(this), new DoraObricDeviceBindFragment$buildContentView$3(this));
        this.f338947n = r108;
        return r108.b();
    L10:
        r107 = null;
    L6:
        r105 = "";
        goto L7
    }
}
