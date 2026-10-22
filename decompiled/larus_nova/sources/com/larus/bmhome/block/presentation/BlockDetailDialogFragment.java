package com.larus.bmhome.block.presentation;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.ClarificationAnswerDetailFragment;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.m;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.nova.R;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import kc8.c;
import kc8.y;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rb8.d;
import rb8.e;
import v19.c7;
import v19.m7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b*\u0001\f\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\nH\u0016J\n\u0010$\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u00102\u001a\u00020\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/block/presentation/BlockDetailDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailNavigationHost;", "<init>", "()V", "pendingRequest", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailRequest;", "pendingGlobalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "hasReachedExpandedState", "", "childPageBackCallback", "com/larus/bmhome/block/presentation/BlockDetailDialogFragment$childPageBackCallback$1", "Lcom/larus/bmhome/block/presentation/BlockDetailDialogFragment$childPageBackCallback$1;", "childPageBackStackListener", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_CREATE, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", WidgetCostModule.TYPE_ON_START, "pushBlockDetail", "request", "popBlockDetail", "provideBlockDetailGlobalConfig", "setupBackStack", "showBlockDetailPage", "createDetailFragment", "Lkotlin/Pair;", "Landroidx/fragment/app/Fragment;", "", "popChildPage", "canPopChildPage", "setupBottomSheet", "dispatchBottomSheetChanged", "bottomSheet", "clearBottomSheetBackground", "setClipViewTopCornerRadius", "onDestroyView", "Companion", "Holder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockDetailDialogFragment extends BottomSheetDialogFragment implements c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f296402i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BlockDetailRequest f296403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f296404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f296405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BlockDetailDialogFragment$childPageBackCallback$1 f296406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final rb8.a f296407h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static y f296408a;

        static {
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    @Override // kc8.c
    public final y XK() {
        y r100 = this.f296404e;
        if (r100 == null) goto L5;
        y.a r101 = r100.b();
        r101.C = this;
        return r101.a();
    L5:
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.block.presentation.BlockDetailDialogFragment$childPageBackCallback$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [rb8.a] */
    public BlockDetailDialogFragment() {
        this.f296406g = new BlockDetailDialogFragment$childPageBackCallback$1(this);
        this.f296407h = new rb8.a(this);
    }

    public final boolean S90() {
        if (isAdded() == true) goto L5;
    L7:
        return false;
    L5:
        if (getChildFragmentManager().getBackStackEntryCount() <= 0) goto L7;
        return true;
    }

    public final boolean U90() {
        if (S90() == true) goto L6;
        return false;
    L6:
        getChildFragmentManager().popBackStack();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        getChildFragmentManager().removeOnBackStackChangedListener(this.f296407h);
        super.onDestroyView();
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
        r101.setOnShowListener(new rb8.b(this, r102));
        BottomSheetBehavior r111 = BottomSheetBehavior.from(r102);
        r111.setPeekHeight(r106);
        r111.setState(4);
        r111.setSkipCollapsed(false);
        r102.setBackgroundResource(R.drawable.larus_bg_floating_think_bottom_sheet);
        r102.setOutlineProvider(new d(c7.b(16)));
        r102.setClipToOutline(true);
        r111.setBottomSheetCallback(new e(this, r111));
        r102.post(new rb8.c(this, r102));
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
        return U90();
    }

    @Override // kc8.c
    public final boolean FV(BlockDetailRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (isAdded() == true) goto L6;
        return false;
    L6:
        V90(r100);
        return true;
    }

    public final void T90(View r100) {
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

    public final void V90(BlockDetailRequest r110) {
        if (getChildFragmentManager().isStateSaved() == false) goto L5;
        return;
    L5:
        if (getChildFragmentManager().isDestroyed() == true) goto L44;
        boolean r100 = false;
        if (getChildFragmentManager().findFragmentById(R.id.detail_fragment_container) == null) goto L10;
        boolean r101 = true;
    L11:
        Block r102 = (Block) CollectionsKt.lastOrNull(r110.getBlock());
        InteractionAskBlock r103 = null;
        if (r102 != null) goto L14;
    L24:
        if (r103 == null) goto L26;
        InteractionAskBlock r104 = ClarificationAnswerDetailFragment.f309079j;
        Pair r111 = TuplesKt.to(ClarificationAnswerDetailFragment.c.a(r103, XK(), r110.getMessage()), "ClarificationAnswerDetailFragment");
    L27:
        Fragment r105 = (Fragment) r111.component1();
        String r112 = (String) r111.component2();
        FragmentTransaction r106 = getChildFragmentManager().beginTransaction();
        if (r101 == false) goto L31;
        r106.setCustomAnimations(R.anim.larus_slide_in_right, R.anim.larus_slide_out_left, R.anim.larus_slide_in_left, R.anim.larus_slide_out_right);
    L31:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r106, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r112, R.id.detail_fragment_container) == true) goto L34;
        r106.replace(R.id.detail_fragment_container, r105, r112);
    L34:
        if (r101 == false) goto L36;
        r106.addToBackStack("block_detail_child_page");
    L36:
        r106.commitAllowingStateLoss();
        BlockDetailDialogFragment$childPageBackCallback$1 r113 = this.f296406g;
        if (r101 == false) goto L39;
    L40:
        r100 = true;
    L41:
        r113.setEnabled(r100);
        return;
    L39:
        if (S90() == false) goto L41;
    L26:
        int r107 = BlockToolDetailFragment.f296411j;
        Intrinsics.checkNotNullParameter(r110, "request");
        BlockToolDetailFragment r108 = new BlockToolDetailFragment();
        r108.f296412d = r110;
        r111 = TuplesKt.to(r108, "BlockDetailFragment");
        goto L27
    L14:
        if (r102.getBlockType() != j.f302436q0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == true) goto L20;
        r102 = null;
    L20:
        if (r102 == null) goto L24;
        BlockContent r114 = r102.getContent();
        if (r114 == null) goto L24;
        r103 = r114.getInteractionAskBlock();
        goto L24
    L16:
        r109 = false;
        goto L17
    L10:
        r101 = false;
        goto L11
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        Serializable r102 = r101.getSerializable("arg_block_detail_request");
    L7:
        if ((r102 instanceof BlockDetailRequest) == false) goto L9;
        BlockDetailRequest r103 = (BlockDetailRequest) r102;
    L10:
        this.f296403d = r103;
        y r104 = b.f296408a;
        this.f296404e = b.f296408a;
        b.f296408a = null;
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        final Context r101 = requireContext();
        return new AnonymousClass1(this, r101);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        r100.setOutlineProvider(new d(c7.b(16)));
        r100.setClipToOutline(true);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.f296406g);
        getChildFragmentManager().addOnBackStackChangedListener(this.f296407h);
        if (r101 != null) goto L8;
        BlockDetailRequest r102 = this.f296403d;
        if (r102 == null) goto L9;
        V90(r102);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.larus_fragment_compress_deep_think_detail_root, r101, false);
    }
}
