package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.block.presentation.BlockToolDetailFragment;
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.nova.R;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.crypto.CryptoServicesPermission;
import v19.c7;
import v19.m7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000e\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010'\u001a\u00020\u0014H\u0016J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\fH\u0016J\n\u00100\u001a\u0004\u0018\u00010\nH\u0016J\b\u00101\u001a\u00020\u0014H\u0002J\b\u00102\u001a\u00020\u0014H\u0002J\u0006\u00103\u001a\u00020\fJ\b\u00104\u001a\u00020\fH\u0002J\u0006\u00105\u001a\u00020\u0014J\b\u00106\u001a\u0004\u0018\u00010\bJ\n\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020\u0014H\u0002J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020 H\u0002J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010;\u001a\u00020 H\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010&\u001a\u00020 H\u0002J\b\u0010>\u001a\u00020\u0014H\u0016J\u0010\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006D"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailRootFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailNavigationHost;", "<init>", "()V", "blockModel", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkBlockBizModel;", "titleText", "", CryptoServicesPermission.GLOBAL_CONFIG, "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "hasReachedExpandedState", "", "childPageBackCallback", "com/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailRootFragment$childPageBackCallback$1", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailRootFragment$childPageBackCallback$1;", "childPageBackStackListener", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "onDismissCallback", "Lkotlin/Function0;", "", "getOnDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", WidgetCostModule.TYPE_ON_START, "updateData", "showClarificationAnswerDetail", "interactionAskBlock", "Lcom/larus/im/bean/message/block/InteractionAskBlock;", "pushBlockDetail", "request", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailRequest;", "popBlockDetail", "provideBlockDetailGlobalConfig", "setupBackStack", "showCotDetailPage", "popChildPage", "canPopChildPage", "dismissFromChild", "getCotTitle", "findCotDetailFragment", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailFragment;", "setupBottomSheet", "dispatchBottomSheetChanged", "bottomSheet", "clearBottomSheetBackground", "setClipViewTopCornerRadius", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingThinkDetailRootFragment extends BottomSheetDialogFragment implements kc8.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f309114j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f309115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kc8.y f309116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f309117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FloatingThinkDetailRootFragment$childPageBackCallback$1 f309118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v f309119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f309120i;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    @Override // kc8.c
    public final kc8.y XK() {
        kc8.y r100 = this.f309116e;
        if (r100 == null) goto L5;
        kc8.y.a r101 = r100.b();
        r101.C = this;
        return r101.a();
    L5:
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.FloatingThinkDetailRootFragment$childPageBackCallback$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.v] */
    public FloatingThinkDetailRootFragment() {
        this.f309118g = new FloatingThinkDetailRootFragment$childPageBackCallback$1(this);
        this.f309119h = new v(this);
    }

    public final boolean T90() {
        if (isAdded() == true) goto L6;
    L8:
        boolean r100 = false;
    L9:
        if (r100 == true) goto L11;
        return false;
    L11:
        getChildFragmentManager().popBackStack();
        return true;
    L6:
        if (getChildFragmentManager().getBackStackEntryCount() <= 0) goto L8;
        r100 = true;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f309115d = null;
        this.f309116e = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f309117f = false;
        getChildFragmentManager().removeOnBackStackChangedListener(this.f309119h);
        setEnabled(false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if ((r100 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r101 = (BottomSheetDialog) r100;
    L6:
        if (r101 == null) goto L25;
        final View r102 = r101.findViewById(R.id.design_bottom_sheet);
        if (r102 == null) goto L25;
        View r103 = r101.findViewById(R.id.coordinator);
        int r104 = m0.f375450a;
        int r105 = m0.a(getContext());
        i0.f375410a.getClass();
        int r106 = ((r105 - i0.g()) * 5) / 10;
        ViewGroup.LayoutParams r107 = r102.getLayoutParams();
        if (r107 == null) goto L14;
        r107.height = -1;
    L14:
        r102.setLayoutParams(r102.getLayoutParams());
        if (r103 == null) goto L24;
        ViewGroup.LayoutParams r108 = r103.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
    L20:
        int r110 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12));
        if (r109 == null) goto L23;
        r109.topMargin = r110;
    L23:
        r103.setLayoutParams(r109);
        goto L24
    L19:
        r109 = null;
    L24:
        r102.setBackground(null);
        r102.setBackgroundColor(0);
        r101.setOnShowListener(new w(this, r102));
        BottomSheetBehavior r111 = BottomSheetBehavior.from(r102);
        r111.setPeekHeight(r106);
        r111.setState(4);
        r111.setSkipCollapsed(false);
        r102.setBackgroundResource(R.drawable.larus_bg_floating_think_bottom_sheet);
        r102.setOutlineProvider(new y(c7.b(16)));
        r102.setClipToOutline(true);
        r111.setBottomSheetCallback(new z(this, r111));
        r102.post(new x(this, r102));
    L25:
        Dialog r112 = getDialog();
        if (r112 == null) goto L31;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L32;
        m7.a(r113);
        return;
    L32:
        return;
    L31:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // kc8.c
    public final boolean rx() {
        return T90();
    }

    @Override // kc8.c
    public final boolean FV(BlockDetailRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (isAdded() == true) goto L5;
        return false;
    L5:
        if (getChildFragmentManager().isStateSaved() == false) goto L7;
        return false;
    L7:
        if (getChildFragmentManager().isDestroyed() == true) goto L18;
        FragmentTransaction r101 = getChildFragmentManager().beginTransaction();
        r101.setCustomAnimations(R.anim.larus_slide_in_right, R.anim.larus_slide_out_left, R.anim.larus_slide_in_left, R.anim.larus_slide_out_right);
        int r102 = BlockToolDetailFragment.f296411j;
        Intrinsics.checkNotNullParameter(r100, "request");
        BlockToolDetailFragment r103 = new BlockToolDetailFragment();
        r103.f296412d = r100;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r101, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "BlockDetailFragment", R.id.detail_fragment_container) == true) goto L13;
        r101.replace(R.id.detail_fragment_container, r103, "BlockDetailFragment");
    L13:
        r101.addToBackStack("floating_think_child_page");
        r101.commitAllowingStateLoss();
        setEnabled(true);
        return true;
    L18:
        return false;
    }

    public final void S90(View r100) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        ActivityResultCaller r101 = getChildFragmentManager().findFragmentById(R.id.detail_fragment_container);
        if ((r101 instanceof m) == false) goto L8;
        m r102 = (m) r101;
    L9:
        if (r102 == null) goto L12;
        r102.BG(r100);
        return;
    L12:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void U90(g r100) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        g r101 = this.f309115d;
        if (r101 != null) goto L5;
    L11:
        this.f309115d = r100;
        if (isAdded() == false) goto L17;
        Fragment r102 = getChildFragmentManager().findFragmentByTag("FloatingThinkCotDetailFragment");
        if ((r102 instanceof FloatingThinkDetailFragment) == false) goto L17;
        FloatingThinkDetailFragment r103 = (FloatingThinkDetailFragment) r102;
    L18:
        if (r103 == null) goto L23;
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        r103.f309101d = r100;
        r103.T90();
        return;
    L23:
        return;
    L17:
        r103 = null;
        goto L18
    L5:
        if (Intrinsics.areEqual(r101.j().getMessageId(), r100.j().getMessageId()) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r101.j().getConversationId(), r100.j().getConversationId()) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r101.f498145a.getBlockId(), r100.f498145a.getBlockId()) == true) goto L11;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        final Context r101 = requireContext();
        return new AnonymousClass1(this, r101);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L8
        super.onDismiss(r100);     // Catch: Throwable -> L8
        Function0<Unit> r101 = this.f309120i;     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        r101.invoke();     // Catch: Throwable -> L8
    L5:
        this.f309120i = null;     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        r100.setOutlineProvider(new y(c7.b(16)));
        r100.setClipToOutline(true);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.f309118g);
        getChildFragmentManager().addOnBackStackChangedListener(this.f309119h);
        if (r101 != null) goto L13;
        g r102 = this.f309115d;
        if (r102 == null) goto L14;
        FragmentTransaction r103 = getChildFragmentManager().beginTransaction();
        int r104 = FloatingThinkDetailFragment.f309100n;
        kc8.y r105 = this.f309116e;
        Intrinsics.checkNotNullParameter(r102, "blockModel");
        FloatingThinkDetailFragment r106 = new FloatingThinkDetailFragment();
        r106.f309101d = r102;
        r106.f309102e = r105;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "FloatingThinkCotDetailFragment", R.id.detail_fragment_container) == true) goto L11;
        r103.replace(R.id.detail_fragment_container, r106, "FloatingThinkCotDetailFragment");
    L11:
        r103.commitAllowingStateLoss();
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.larus_fragment_compress_deep_think_detail_root, r101, false);
    }
}
