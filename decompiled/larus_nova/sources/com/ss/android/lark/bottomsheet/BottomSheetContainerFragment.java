package com.ss.android.lark.bottomsheet;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseForsetiFragment;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.bottomsheet.view.ExpandValueAnimatorInForseti;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010:\u001a\u0002012\u0006\u0010;\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u000103H\u0016J\b\u0010@\u001a\u000201H\u0002J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002J\b\u0010D\u001a\u000201H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u000201H\u0016J\u0012\u0010M\u001a\u0002012\b\u0010;\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010N\u001a\u0002012\b\u0010;\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010O\u001a\u0002012\u0006\u0010P\u001a\u00020QH\u0016J\u0012\u0010R\u001a\u00020Q2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u000e\u0010%\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010(\u001a\r\u0012\t\u0012\u00070*¢\u0006\u0002\b+0)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006V"}, d2 = {"Lcom/ss/android/lark/bottomsheet/BottomSheetContainerFragment;", "Lcom/ss/android/lark/bottomsheet/BottomSheetContainerBaseFragment;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IBottomSheetFunction;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "mFragmentContainerView", "Landroid/widget/FrameLayout;", "viewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel;", "getViewModel", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "expandAnimator", "Lcom/ss/android/lark/bottomsheet/view/ExpandValueAnimatorInForseti;", "fragmentFactory", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFragmentFactory;", "getFragmentFactory", "()Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFragmentFactory;", "fragmentFactory$delegate", "chainManager", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "getChainManager", "()Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "chainManager$delegate", "conversationTabKey", "", "getConversationTabKey", "()Ljava/lang/String;", "conversationTabKey$delegate", "halfScreenHeight", "", "getHalfScreenHeight", "()I", "fullScreenHeight", "getFullScreenHeight", "lastCompactState", "disposable", "Lcom/ss/android/lark/api/api/Disposable;", "fragmentProviders", "", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFragmentFactory$IBottomSheetFragmentProvider;", "Lkotlin/jvm/JvmSuppressWildcards;", "getFragmentProviders", "()Ljava/util/List;", "setFragmentProviders", "(Ljava/util/List;)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "loadFragment", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "arguments", "initFragmentFactory", "initView", "initListeners", "finishInternal", "initViewModel", SendEventContainerMethodParamModel.EventKinds.openPage, "performAnim", "createAnimConfig", "Lcom/ss/android/lark/bottomsheet/view/ExpandValueAnimatorInForseti$AnimatorConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "registerBottomSheetBarOverLapView", "registerBottomSheetTitleBarView", "enableBottomSheet", "enable", "", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
public final class BottomSheetContainerFragment extends Hilt_BottomSheetContainerFragment implements com.ss.android.lark.chat.chatwindow.chat.v2.component.b, zsb.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f410674u = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f410675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f410676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ExpandValueAnimatorInForseti f410677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f410678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f410679p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f410680q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f410681r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public tua.a f410682s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Inject
    public List<com.ss.android.lark.bottomsheet.fragment.a.c> f410683t;

    public static final class a {
    }

    static {
    }

    public final tua.b X90() {
        return (tua.b) this.f410679p.getValue();
    }

    public final BottomSheetViewModel Z90() {
        return (BottomSheetViewModel) this.f410676m.getValue();
    }

    public BottomSheetContainerFragment() {
        this.f410676m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new BottomSheetContainerFragment$special$$inlined$activityViewModels$default$1(this), new BottomSheetContainerFragment$special$$inlined$activityViewModels$default$2(this));
        this.f410678o = LazyKt.lazy(BottomSheetContainerFragment$fragmentFactory$2.INSTANCE);
        this.f410679p = LazyKt.lazy(new BottomSheetContainerFragment$chainManager$2(this));
        this.f410680q = LazyKt.lazy(BottomSheetContainerFragment$conversationTabKey$2.INSTANCE);
        this.f410681r = 1;
    }

    public final ExpandValueAnimatorInForseti.b W90() {
        Integer r100 = Z90().getOrientation().getValue();
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        long r101 = 300;
    L15:
        return new ExpandValueAnimatorInForseti.b((int) (Y90() * 0.8f), Y90(), r101);
    L11:
        if (r100.intValue() != 2) goto L13;
        r101 = 100;
        goto L15
    L6:
        if (r100.intValue() != 1) goto L8;
        goto L8
    }

    public final int Y90() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L13;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L13;
        View r102 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L11:
        if (r102 == null) goto L13;
        return r102.getHeight();
    L13:
        return 0;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ExpandValueAnimatorInForseti r100 = this.f410677n;
        if (r100 != null) goto L5;
    L7:
        int r101 = 1;
        Z90().getBottomSheetStateChangeEvent().postValue(new BottomSheetViewModel.a(1));
        Z90().updateState(1);
        Z90().updateExpandAnimStatus(0.0f);
        BottomSheetViewModel r102 = Z90();
        Integer r103 = Z90().getOrientation().getValue();
        if (r103 == null) goto L10;
        r101 = r103.intValue();
    L10:
        r102.updateOrientation(r101);
        tua.a r104 = this.f410682s;
        if (r104 == null) goto L13;
        r104.dispose();
    L13:
        this.f410682s = null;
        return;
    L5:
        if (r100.a().isRunning() == false) goto L7;
        r100.a().cancel();
        goto L7
    }

    public static final /* synthetic */ Context U90(BottomSheetContainerFragment r100) {
        return r100.mContext;
    }

    public static final void V90(BottomSheetContainerFragment r100) {
        Bundle r101 = r100.getArguments();
        Object r102 = null;
        if (r101 == null) goto L5;
        r101.putBoolean("key_launch_main_in_forseti", true);
        r101.putBoolean("key_bottom_sheet_container_start", false);
    L6:
        ((vwa.b) r100.f409766f.getValue()).a(r100);
        ChatCoreModule.a().launchMainWindow(r100.mContext, (String) r100.f410680q.getValue(), r101);
        if (r101 != null) goto L9;
        Log.e("BottomSheetContainerFragment", "openPage bundle is null, failed to open page.");
        return;
    L9:
        String r103 = r101.getString("key_bottom_sheet_content_class");
        List<com.ss.android.lark.bottomsheet.fragment.a.c> r104 = r100.f410683t;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentProviders");
        r104 = null;
    L13:
        Iterator<T> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((com.ss.android.lark.bottomsheet.fragment.a.c) r106).clazz(), r103) == false) goto L15;
        r102 = r106;
    L19:
        com.ss.android.lark.bottomsheet.fragment.a.c r107 = (com.ss.android.lark.bottomsheet.fragment.a.c) r102;
        if (r107 == null) goto L27;
        r107.c(r100.mContext, r101);
        return;
    L27:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // zsb.d
    public final boolean Cy(Notice r100) {
        ActivityResultCaller r101 = getChildFragmentManager().findFragmentByTag("installed_fragment");
        if ((r101 instanceof com.ss.android.lark.bottomsheet.fragment.d) == false) goto L5;
        com.ss.android.lark.bottomsheet.fragment.d r102 = (com.ss.android.lark.bottomsheet.fragment.d) r101;
    L6:
        if (r102 != null) goto L10;
        return true;
    L10:
        return r102.y30(r100);
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        int r101 = r100.orientation;
        Integer r102 = Z90().getOrientation().getValue();
        if (r102 != null) goto L6;
    L7:
        Z90().getOrientation().postValue(Integer.valueOf(r100.orientation));
        return;
    L6:
        if (r101 != r102.intValue()) goto L7;
    }

    @Override // com.ss.android.lark.bottomsheet.BottomSheetContainerBaseFragment, com.ss.android.lark.base.fragment.BaseForsetiFragment, com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        Object r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getString("key_bottom_sheet_content_class");
    L6:
        List<com.ss.android.lark.bottomsheet.fragment.a.c> r104 = this.f410683t;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentProviders");
        r104 = null;
    L10:
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((com.ss.android.lark.bottomsheet.fragment.a.c) r106).clazz(), r103) == false) goto L12;
        r102 = r106;
    L16:
        com.ss.android.lark.bottomsheet.fragment.a.c r107 = (com.ss.android.lark.bottomsheet.fragment.a.c) r102;
        if (r107 == null) goto L23;
        r107.a(this);
        return;
    L23:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.b
    public final void registerBottomSheetTitleBarView(View r100) {
        ActivityResultCaller r101 = getChildFragmentManager().findFragmentByTag("installed_fragment");
        if ((r101 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.b) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.b r102 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.b) r101;
    L6:
        if (r102 == null) goto L9;
        r102.registerBottomSheetTitleBarView(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void aa0(FragmentManager r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "childFragmentManager");
        FragmentTransaction r102 = r100.beginTransaction();
        com.ss.android.lark.bottomsheet.fragment.a r103 = (com.ss.android.lark.bottomsheet.fragment.a) this.f410678o.getValue();
        if (r101 != null) goto L5;
        r101 = requireArguments();
    L5:
        Pair<BottomSheetFrameFragment, com.ss.android.lark.bottomsheet.fragment.a.b> r104 = r103.a(r101);
        FrameLayout r105 = null;
        if (r104 == null) goto L8;
        BottomSheetFrameFragment r106 = r104.getFirst();
    L9:
        if (r106 != null) goto L11;
        ((vwa.b) this.f409766f.getValue()).a(this);
    L19:
        r102.commitNowAllowingStateLoss();
        return;
    L11:
        FrameLayout r107 = this.f410675l;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFragmentContainerView");
    L15:
        int r108 = r105.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "installed_fragment", r108) == true) goto L19;
        r102.replace(r108, r106, "installed_fragment");
        goto L19
    L14:
        r105 = r107;
        goto L15
    L8:
        r106 = null;
        goto L9
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Z90().getOrientation().setValue(Integer.valueOf(getResources().getConfiguration().orientation));
        Log.i("BottomSheetContainerFragment", "load bottom sheet fragment start");
        List<com.ss.android.lark.bottomsheet.fragment.a.c> r102 = this.f410683t;
        com.ss.android.lark.forseti.global.a r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentProviders");
        r102 = null;
    L6:
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        com.ss.android.lark.bottomsheet.fragment.a.c r105 = (com.ss.android.lark.bottomsheet.fragment.a.c) r104.next();
        com.ss.android.lark.bottomsheet.fragment.a r106 = (com.ss.android.lark.bottomsheet.fragment.a) this.f410678o.getValue();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, ShortVideoSegments.KEY_PROP_PROVIDER);
        ((HashMap) r106.f410710a).put(r105.clazz(), r105);
        goto L8
    L10:
        FragmentManager r107 = getChildFragmentManager();
        Bundle r108 = getArguments();
        Intrinsics.checkNotNullParameter(r107, "childFragmentManager");
        if (r107.findFragmentByTag("installed_fragment") != null) goto L13;
        aa0(r107, r108);
    L14:
        Z90().getState().observe(getViewLifecycleOwner(), new m(this));
        Z90().getStatusBarColorChangeEvent().observe(this, new n(this));
        Z90().getBottomSheetStateChangeEvent().observe(getViewLifecycleOwner(), new o(this));
        Z90().getOrientation().observe(getViewLifecycleOwner(), new p(this));
        tua.b r109 = X90();
        if (r109 == null) goto L17;
        r103 = r109.K(new BottomSheetContainerFragment$initListeners$1(this), false);
    L17:
        this.f410682s = r103;
        BaseForsetiFragment.T90(this);
        return;
    L13:
        Log.i("BottomSheetContainerBaseFragment", "fragment container recreated");
        goto L14
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.bottom_sheet_fragment_container, r101, false);
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.fragment_container);
        this.f410675l = r104;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFragmentContainerView");
        r104 = null;
    L5:
        this.f410677n = new ExpandValueAnimatorInForseti(r104, W90(), X90());
        tua.b r105 = X90();
        if (r105 == null) goto L8;
        r105.b((int) (Y90() * 0.8f));
    L8:
        tua.b r106 = X90();
        if (r106 == null) goto L11;
        r106.C();
    L11:
        return r103;
    }
}
