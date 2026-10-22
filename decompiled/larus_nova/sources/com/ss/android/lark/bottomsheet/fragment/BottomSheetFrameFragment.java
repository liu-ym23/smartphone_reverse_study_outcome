package com.ss.android.lark.bottomsheet.fragment;

import android.app.assist.AssistContent;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.bottomsheet.view.j;
import com.ss.android.lark.bottomsheet.view.k;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u00100\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010,H&J\b\u00101\u001a\u00020.H\u0002J\u0012\u00102\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00103\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00104\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00068"}, d2 = {"Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFrameFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/bottomsheet/fragment/IFragmentHandler;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IBottomSheetFunction;", "<init>", "()V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "roundContainer", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "getRoundContainer", "()Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "setRoundContainer", "(Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;)V", "contentContainer", "Landroid/widget/FrameLayout;", "viewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel;", "getViewModel", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "titleBarHeightUpdate", "Lcom/ss/android/lark/bottomsheet/view/ITitleBarHeightUpdate;", "getTitleBarHeightUpdate", "()Lcom/ss/android/lark/bottomsheet/view/ITitleBarHeightUpdate;", "setTitleBarHeightUpdate", "(Lcom/ss/android/lark/bottomsheet/view/ITitleBarHeightUpdate;)V", "radiusTopContainer", "", "getRadiusTopContainer", "()F", "setRadiusTopContainer", "(F)V", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initContentContainer", "initViewModel", "registerBottomSheetBarOverLapView", "registerBottomSheetTitleBarView", "enableBottomSheet", "enable", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BottomSheetFrameFragment extends BaseFragment implements d, com.ss.android.lark.chat.chatwindow.chat.v2.component.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f410704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LKUIRoundableLayout f410705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f410706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f410707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f410708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f410709i;

    public static final class a {
    }

    static {
    }

    public abstract void T90(FrameLayout r100, Bundle r101);

    @Override // com.ss.android.lark.bottomsheet.fragment.d
    public /* synthetic */ void aP(AssistContent r100) {
    }

    public BottomSheetFrameFragment() {
        this.f410707g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new BottomSheetFrameFragment$special$$inlined$activityViewModels$default$1(this), new BottomSheetFrameFragment$special$$inlined$activityViewModels$default$2(this));
        this.f410709i = 12.0f;
    }

    public float S90() {
        return this.f410709i;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.b
    public final void registerBottomSheetTitleBarView(View r100) {
        if (r100 == null) goto L7;
        j r101 = this.f410708h;
        if (r101 == null) goto L8;
        r101.a(r100);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f410704d;
        FrameLayout r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r102 = null;
    L6:
        LKUIRoundableLayout r104 = (LKUIRoundableLayout) r102.findViewById(R.id.round_container);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f410705e = r104;
        View r105 = this.f410704d;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r105 = null;
    L10:
        this.f410706f = (FrameLayout) r105.findViewById(R.id.root_container);
        Context r106 = getContext();
        if (r106 == null) goto L13;
        this.f410708h = new k(r106);
    L13:
        FrameLayout r107 = this.f410706f;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    L17:
        T90(r103, r101);
        ((BottomSheetViewModel) this.f410707g.getValue()).getState().observe(getViewLifecycleOwner(), new b(this));
        ((BottomSheetViewModel) this.f410707g.getValue()).getUiAnimFraction().observe(getViewLifecycleOwner(), new c(this));
        return;
    L16:
        r103 = r107;
        goto L17
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_bottom_sheet_base, r101, false);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f410704d = r103;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L7:
        return r103;
    }
}
