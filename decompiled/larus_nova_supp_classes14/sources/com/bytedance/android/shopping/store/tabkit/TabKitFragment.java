package com.bytedance.android.shopping.store.tabkit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.extensions.m;
import com.bytedance.android.shopping.store.tabkit.container.BottomSheetTransparentActivity;
import com.bytedance.android.shopping.store.tabkit.container.TabKitActivity;
import com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior;
import com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetFragment;
import com.bytedance.android.shopping.store.tabkit.container.TabKitCompactActivity;
import com.bytedance.android.shopping.store.tabkit.container.TabKitDialogFragment;
import com.bytedance.android.shopping.store.tabkit.container.TabKitFoldFragment;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.tabkit.view.PadAdapterFrameLayout;
import com.bytedance.android.shopping.store.utils.o;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lcom/bytedance/android/shopping/store/tabkit/f;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TabKitFragment extends Fragment implements QViewModelOwner, f {
    public static final /* synthetic */ int h = 0;
    public TabKitViewModel d;
    public Window e;
    public final TabKitPresenter f;
    public float g;

    public static final class a {
        public static void a(Context r10, Class r11, Bundle r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "tabKitFragmentClass");
            Serializable r2 = r12.getSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS);
            Context r4 = null;
            if ((r2 instanceof TabKitRouterParams) == true) goto L5;
            r2 = null;
        L5:
            TabKitRouterParams r3 = (TabKitRouterParams) r2;
            if (r3 == null) goto L8;
            Integer r5 = r3.getPageModal();
        L9:
            boolean r8 = true;
            if (r5 != null) goto L13;
        L18:
            dm.a.a("TabKitFragment").i("open tabkit full-page, enable lite: " + r13);
            if (r13 == false) goto L52;
            boolean r14 = TabKitDialogFragment.j;
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "tabKitFragmentClazz");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L47
            long r1 = r12.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);     // Catch: Throwable -> L47
            Map<Long, TabkitFirstFramePref> r6 = ok3.a.e;     // Catch: Throwable -> L47
            TabkitFirstFramePref r7 = ok3.a.C0149a.a(r1);     // Catch: Throwable -> L47
            if (r7 == null) goto L25;
            TabkitFramePref.recordTime$default(r7, "t_route_lite_page_start", null, 2, null);     // Catch: Throwable -> L47
        L25:
            if ((r10 instanceof FragmentActivity) == false) goto L28;
            r4 = r10;
        L28:
            FragmentActivity r9 = (FragmentActivity) r4;     // Catch: Throwable -> L47
            if (r9 == null) goto L49;
            FragmentManager r15 = r9.getSupportFragmentManager();     // Catch: Throwable -> L47
            if (r15 == null) goto L49;
            String r16 = UUID.randomUUID().toString();     // Catch: Throwable -> L47
            TabKitDialogFragment r17 = new TabKitDialogFragment();     // Catch: Throwable -> L47
            Bundle r18 = new Bundle();     // Catch: Throwable -> L47
            r18.putSerializable("tabkit_fragment_clazz", r11);     // Catch: Throwable -> L47
            r18.putBundle("biz_arguments", r12);     // Catch: Throwable -> L47
            r18.putString("key_tabkit_root_fragment_id", r16);     // Catch: Throwable -> L47
            Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L47
            r17.setArguments(r18);     // Catch: Throwable -> L47
            com.bytedance.android.shopping.store.tabkit.container.i.a("show fragment now, unique id: " + r16);     // Catch: Throwable -> L47
            if (TabKitDialogFragment.j == false) goto L41;
            LandscapeRestrictionOperation r110 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Throwable -> L47
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r17, "tabkit_dialog_fragment", r110);     // Catch: Throwable -> L47
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r17, r110) == false) goto L59;
        L50:
            if (r8 == true) goto L62;
            int r111 = TabKitActivity.e;
            TabKitActivity.a.a(r10, r11, r12);
            return;
        L62:
            return;
        L59:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54 Throwable -> L47
        L40:
            r17.showNow(r15, "tabkit_dialog_fragment");     // Catch: Throwable -> L47
            goto L50
        L41:
            LandscapeRestrictionOperation r112 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L47
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r17, "tabkit_dialog_fragment", r112);     // Catch: Throwable -> L47
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r17, r112) == true) goto L50;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55 Throwable -> L47
        L45:
            r17.show(r15, "tabkit_dialog_fragment");     // Catch: Throwable -> L47
        L49:
            r8 = false;
        L47:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L49
        L52:
            int r113 = TabKitActivity.e;
            TabKitActivity.a.a(r10, r11, r12);
            return;
        L13:
            if (r5.intValue() != 1) goto L18;
            int r114 = BottomSheetTransparentActivity.e;
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "tabKitFragmentClass");
            long r21 = r12.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
            Map<Long, TabkitFirstFramePref> r115 = ok3.a.e;
            TabkitFirstFramePref r116 = ok3.a.C0149a.a(r21);
            if (r116 == null) goto L17;
            TabkitFramePref.recordTime$default(r116, "t_route_activity_start", null, 2, null);
        L17:
            Intent r117 = new Intent(r10, BottomSheetTransparentActivity.class);
            r117.putExtra("tabkit_fragment_clazz", r11);
            r117.putExtra("biz_arguments", r12);
            Unit r118 = Unit.INSTANCE;
            r10.startActivity(r117);
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    static {
    }

    public Integer tv() {
        return null;
    }

    public ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public TabKitFragment() {
        this.f = new TabKitPresenter(this);
        this.g = 1.0f;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final void Ju() {
        Fragment r0 = getParentFragment();
        if ((r0 instanceof TabKitBottomSheetFragment) == true) goto L5;
        r0 = null;
    L5:
        TabKitBottomSheetFragment r1 = (TabKitBottomSheetFragment) r0;
        if (r1 == null) goto L11;
        r1.i = false;
        TabKitBottomSheetBehavior<View> r2 = r1.d;
        if (r2 == null) goto L12;
        r2.setHideable(false);
        return;
    L12:
        return;
    }

    public void S90() {
        Mc().W(2);
    }

    public void finish() {
        if ((getActivity() instanceof TabKitActivity) == false) goto L5;
    L41:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L56;
        r0.finish();
        return;
    L56:
        return;
    L5:
        if ((getActivity() instanceof TabKitCompactActivity) == true) goto L41;
        if ((getParentFragment() instanceof TabKitBottomSheetFragment) == false) goto L21;
        TabKitBottomSheetFragment r1 = getParentFragment();
        if (r1 == null) goto L19;
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L49;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L49:
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetFragment");
    L21:
        if ((getParentFragment() instanceof TabKitDialogFragment) == false) goto L34;
        TabKitDialogFragment r3 = getParentFragment();
        if (r3 == null) goto L32;
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L51;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L51:
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.container.TabKitDialogFragment");
    L34:
        if ((getParentFragment() instanceof TabKitFoldFragment) == false) goto L53;
        nj.d r5 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r5 == null) goto L54;
        getActivity();
        TabKitViewModel r6 = this.d;
        if (r6 == null) goto L40;
        r6.getFoldType();
    L40:
        r5.m();
        return;
    L54:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final void jC() {
        Fragment r0 = getParentFragment();
        if ((r0 instanceof TabKitBottomSheetFragment) == true) goto L5;
        r0 = null;
    L5:
        TabKitBottomSheetFragment r1 = (TabKitBottomSheetFragment) r0;
        if (r1 == null) goto L11;
        r1.j = false;
        TabKitBottomSheetBehavior<View> r2 = r1.d;
        if (r2 == null) goto L12;
        r2.e = false;
        return;
    L12:
        return;
    }

    public void onDestroy() {
        super.onDestroy();
        Mc().unbind();
        Configuration r0 = getResources().getConfiguration();
        r0.fontScale = this.g;
        Resources r1 = requireActivity().getResources();
        Resources r2 = requireActivity().getResources();
        r1.updateConfiguration(r0, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()));
    }

    public TabKitPresenter Mc() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final TabKitViewModel getTabKitViewModel() {
        return this.d;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final void ay(boolean r2) {
        Window r0 = this.e;
        if (r0 == null) goto L6;
        m.a(r0, r2);
        return;
    }

    public void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        TabKitViewModel r3 = new ViewModelProvider(this, o6()).get(TabKitViewModel.class);
        this.d = r3;
        if (r3 == null) goto L6;
        r3.prepare(getArguments());
        return;
    }

    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        TabKitViewModel r5 = this.d;
        if (r5 == null) goto L5;
        r5.init(getArguments());
    L5:
        Configuration r6 = getResources().getConfiguration();
        this.g = r6.fontScale;
        r6.fontScale = o.a;
        Resources r0 = requireActivity().getResources();
        Resources r1 = requireActivity().getResources();
        r0.updateConfiguration(r6, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
        cl.d.a.getClass();
        cl.d r7 = cl.d.a.b();
        if (r7 == null) goto L9;
        r7.n();
        return;
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Mc().J(null, r2, null);
        TabKitViewModel r4 = this.d;
        if (r4 == null) goto L10;
        TabKitRouterParams r5 = r4.getRouterParams();
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.getEnableGrey() != true) goto L12;
        int r6 = com.bytedance.android.ec.hybrid.list.a.a;
        com.bytedance.android.ec.hybrid.list.a.b(getView());
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final void z5(int r2, boolean r3) {
        Fragment r4 = getParentFragment();
        if ((r4 instanceof TabKitBottomSheetFragment) == true) goto L5;
        r4 = null;
    L5:
        TabKitBottomSheetFragment r5 = (TabKitBottomSheetFragment) r4;
        if (r5 != null) goto L9;
        return;
    L9:
        if (r2 != 1) goto L11;
        r5.X90(1);
        return;
    L11:
        r5.X90(2);
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        Mc().getClass();
    }

    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        TabKitViewModel r7 = this.d;
        if (r7 == null) goto L5;
        r7.clearFragments();
    L5:
        ShoppingAsyncInflater.a r8 = ShoppingAsyncInflater.e;
        Context r0 = requireContext();
        r8.getClass();
        boolean r1 = false;
        View r9 = ShoppingAsyncInflater.a.a(r0).aU(2131560979, r5, false);
        PadAdapterFrameLayout r10 = new PadAdapterFrameLayout(r4.getContext(), null, 6, 0);
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TabKitViewModel r11 = this.d;
        if (r11 == null) goto L12;
        TabKitRouterParams r12 = r11.getRouterParams();
        if (r12 == null) goto L12;
        if (r12.getEnablePadAdapter() != true) goto L12;
        r1 = true;
    L12:
        r10.setEnablePadAdapter(r1);
        TabKitViewModel r13 = this.d;
        if (r13 == null) goto L17;
        TabKitRouterParams r14 = r13.getRouterParams();
        if (r14 == null) goto L17;
        r10.setRatio(r14.getPadRatio());
    L17:
        r10.addView(r9);
        return r10;
    }
}
