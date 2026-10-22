package com.larus.dora.impl.device.settings.unbind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraUnbindBinding;
import com.larus.dora.impl.device.settings.DoraUnbindBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindFragment;", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraUnbindBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindViewModel;", "model$delegate", "Lkotlin/Lazy;", "getCurrentPageName", "", "getPageMaskView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showUnbindConfirmDialog", "showLowPowerConfirmDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraUnbindFragment extends DoraUnbindBaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f334927i = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusDoraUnbindBinding f334928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f334929h;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraUnbindFragment f334930a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f334931a = null;

            static {
                int[] r100 = new int[DoraUnbindState.values().length];
                r100[DoraUnbindState.SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[DoraUnbindState.NO_DEVICE_CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[DoraUnbindState.SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[DoraUnbindState.SPP_DISCONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[DoraUnbindState.UNBIND_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f334931a = r100;
            }
        }

        public b(DoraUnbindFragment r100) {
            this.f334930a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.util.ArrayList] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r110) {
            Pair r101 = (Pair) r100;
            int r111 = a.f334931a[((DoraUnbindState) r101.getFirst()).ordinal()];
            boolean r102 = true;
            if (r111 != 1) goto L5;
            s r103 = s.f544207a;
            Context r112 = this.f334930a.getContext();
            String r104 = this.f334930a.getString(R.string.larus_dora_g_recovery_network_error_fail_cn);
            r103.getClass();
            s.c(r112, r104);
        L78:
            return Unit.INSTANCE;
        L5:
            if (r111 != 2) goto L7;
        L75:
            s r105 = s.f544207a;
            Context r113 = this.f334930a.getContext();
            String r106 = this.f334930a.getString(R.string.larus_dora_g_recovery_unbind_failed_cn);
            r105.getClass();
            s.c(r113, r106);
            goto L78
        L7:
            if (r111 == 3) goto L75;
            if (r111 == 4) goto L75;
            if (r111 != 5) goto L74;
            FragmentActivity r114 = this.f334930a.getActivity();
            if (r114 == null) goto L78;
            DoraUnbindFragment r107 = this.f334930a;
            Intent r108 = new Intent("action.DEVICE_UNBIND");
            r108.setPackage(r114.getPackageName());
            DoraDevice r109 = (DoraDevice) r101.getSecond();
            String r115 = null;
            if (r109 == null) goto L17;
            String r116 = r109.f204389mac;
        L19:
            if (TextUtils.isEmpty(r116) == true) goto L26;
            DoraDevice r117 = (DoraDevice) r101.getSecond();
            if (r117 == null) goto L24;
            String r118 = r117.f204389mac;
            if (r118 == null) goto L24;
        L25:
            r108.putExtra("mac", r118);
        L24:
            r118 = "";
        L26:
            LocalBroadcastManager.getInstance(r114).sendBroadcast(r108);
            DoraDevice r119 = (DoraDevice) r101.getSecond();
            List<DoraDevice> r120 = kj4.a.g().getDoraBindList();
            if (r120 == null) goto L38;
            ?? r121 = new ArrayList();
            Iterator<T> r122 = r120.iterator();
        L30:
            if (r122.hasNext() == false) goto L39;
            T r123 = r122.next();
            String r124 = ((DoraDevice) r123).f204389mac;
            if (r119 == null) goto L34;
            String r125 = r119.f204389mac;
        L36:
            if ((!Intrinsics.areEqual(r124, r125)) == false) goto L30;
            r121.add(r123);
            goto L30
        L34:
            r125 = null;
        L39:
            Iterable r126 = (Iterable) r121;
            if ((r126 instanceof Collection) == true) goto L42;
        L44:
            Iterator<T> r127 = r126.iterator();
        L46:
            if (r127.hasNext() == false) goto L53;
            if (((DoraDevice) r127.next()).productId != ProductNameType.DORA_G.f204375id) goto L50;
            boolean r128 = true;
        L51:
            if (r128 == false) goto L46;
        L55:
            if (com.larus.dora.impl.util.s.a() == false) goto L61;
            if (r102 == false) goto L61;
            i r129 = SmartRouter.buildRoute(r107.getContext(), "//dora_g_device_management");
            r129.f267554c.addFlags(335544320);
            r129.d();
            FragmentActivity r130 = r107.getActivity();
            if (r130 == null) goto L78;
            r130.finish();
        L61:
            if (r121.isEmpty() == false) goto L70;
            i r131 = SmartRouter.buildRoute(r107.getContext(), "//flow/dora/bind_device");
            r131.f267554c.addFlags(268435456);
            DoraDevice r132 = (DoraDevice) r101.getSecond();
            if (r132 == null) goto L65;
            Integer r133 = Boxing.boxInt(r132.productId);
        L66:
            r131.f267554c.putExtra("product_id", String.valueOf(r133));
            DoraDevice r134 = (DoraDevice) r101.getSecond();
            if (r134 == null) goto L69;
            r115 = r134.model;
        L69:
            r131.f267554c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r115);
            r131.f267554c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "bind_device_v2");
            r131.f267555d = R.anim.larus_router_slide_in_right;
            r131.f267556e = R.anim.larus_router_no_anim;
            r131.d();
            goto L78
        L65:
            r133 = null;
            goto L66
        L70:
            FragmentActivity r135 = r107.getActivity();
            if (r135 == null) goto L78;
            r135.finish();
            goto L78
        L50:
            r128 = false;
        L53:
            r102 = false;
            goto L55
        L42:
            if (((Collection) r126).isEmpty() == false) goto L44;
        L38:
            r121 = CollectionsKt.emptyList();
            goto L39
        L17:
            r116 = null;
            goto L19
        L74:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "dora_unbind";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraUnbindBinding r100 = this.f334928g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f333304b;
    }

    public DoraUnbindFragment() {
        this.f334929h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraUnbindViewModel.class), new DoraUnbindFragment$special$$inlined$activityViewModels$default$1(this), new DoraUnbindFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public static void W90(CommonDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }

    @Override // com.larus.dora.impl.device.settings.DoraUnbindBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDoraUnbindBinding r102 = this.f334928g;
        if (r102 == null) goto L7;
        NovaTitleBarEx r103 = r102.f333306d;
        if (r103 == null) goto L7;
        NovaTitleBarEx.Y5(r103, getString(R.string.larus_dora_g_recovery_unbind_device_new_cn), null, null, 6);
        NovaTitleBarEx.b6(r103, R.drawable.larus_dora_ic_left_back, false, null, null, new com.larus.dora.impl.device.settings.unbind.a(this), 14);
    L7:
        LarusDoraUnbindBinding r104 = this.f334928g;
        if (r104 == null) goto L10;
        DoraTextView r105 = r104.f333305c;
    L11:
        e1.d(r105, new com.larus.dora.impl.device.settings.unbind.b(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraUnbindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        return;
    L10:
        r105 = null;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dora_unbind, r101, false);
        int r104 = R.id.dora_page_mask;
        View r105 = ViewBindings.findChildViewById(r103, R.id.dora_page_mask);
        if (r105 == null) goto L11;
        r104 = R.id.larus_dora_g_unbind_button;
        DoraTextView r106 = (DoraTextView) ViewBindings.findChildViewById(r103, R.id.larus_dora_g_unbind_button);
        if (r106 == null) goto L11;
        r104 = R.id.title;
        NovaTitleBarEx r107 = (NovaTitleBarEx) ViewBindings.findChildViewById(r103, R.id.title);
        if (r107 == null) goto L11;
        ConstraintLayout r108 = (ConstraintLayout) r103;
        this.f334928g = new LarusDoraUnbindBinding(r108, r105, r106, r107);
        return r108;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
