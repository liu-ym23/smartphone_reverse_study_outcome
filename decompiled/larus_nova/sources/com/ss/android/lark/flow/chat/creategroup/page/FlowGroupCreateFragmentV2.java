package com.ss.android.lark.flow.chat.creategroup.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.doubao.LarkPicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u00021=\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00103\u001a\u000204H\u0016J\"\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u001aH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>¨\u0006@"}, d2 = {"Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "mPickerContainer", "Landroid/widget/FrameLayout;", "mPicker", "Lcom/ss/android/lark/picker/Picker;", "confirmBottomContainer", "Landroid/view/ViewGroup;", "mConfirmBT", "Landroid/widget/TextView;", "viewModel", "Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "onViewCreated", "view", "initView", "picker", "Lcom/ss/android/lark/picker/doubao/LarkPicker;", "initPicker", "initObserver", "initListener", "businessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "getBusinessConsumeItem", "()Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, "pickerListener", "com/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2$pickerListener$1", "Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2$pickerListener$1;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "setupBottomInsets", "pullerCallback", "com/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2$pullerCallback$1", "Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2$pullerCallback$1;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowGroupCreateFragmentV2 extends Hilt_FlowGroupCreateFragmentV2 implements d0c.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f422078n = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Inject
    public v f422079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f422080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f422081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f422082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f422083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f422084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f422085l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f422086m;

    public static final class a {
    }

    public static final class b implements SearchResultView.IOnBusinessConsumeItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowGroupCreateFragmentV2 f422087a;

        @Override // com.ss.android.lark.picker.base.view.SearchResultView.IOnBusinessConsumeItem
        public final boolean onBusinessConsumeItemClick(SearchBaseInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            return false;
        }

        public b(FlowGroupCreateFragmentV2 r100) {
            this.f422087a = r100;
        }

        @Override // com.ss.android.lark.picker.base.view.SearchResultView.IOnBusinessConsumeItem
        public final SearchResultView.CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            FlowGroupCreateFragmentV2 r101 = this.f422087a;
            int r102 = FlowGroupCreateFragmentV2.f422078n;
            return r101.T90().getCheckBoxBindStatus(r100);
        }
    }

    public static final class c extends BasePicker.IOnPickNotify {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowGroupCreateFragmentV2 f422088a;

        @Override // com.ss.android.lark.picker.base.widget.BasePicker.IOnPickNotify
        public final void onChanged(List<String> r100, List<SearchBaseInfo> r101) {
            Intrinsics.checkNotNullParameter(r100, "ids");
            Intrinsics.checkNotNullParameter(r101, "infoList");
        }

        public c(FlowGroupCreateFragmentV2 r100) {
            this.f422088a = r100;
        }

        @Override // com.ss.android.lark.picker.base.widget.BasePicker.IOnPickNotify
        public final void onDeSelected(String r100, SearchBaseInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "info");
            FlowGroupCreateFragmentV2 r102 = this.f422088a;
            int r103 = FlowGroupCreateFragmentV2.f422078n;
            r102.T90().removeSelectedUser(r101);
        }

        @Override // com.ss.android.lark.picker.base.widget.BasePicker.IOnPickNotify
        public final void onSelected(String r100, SearchBaseInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "info");
            FlowGroupCreateFragmentV2 r102 = this.f422088a;
            int r103 = FlowGroupCreateFragmentV2.f422078n;
            r102.T90().selectUser(r101);
        }
    }

    public static final class d implements com.ss.android.lark.flow.chat.creategroup.data.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowGroupCreateFragmentV2 f422089a;

        @Override // com.ss.android.lark.flow.chat.creategroup.data.f
        public final Long getChatId() {
            FlowGroupCreateFragmentV2 r100 = this.f422089a;
            int r101 = FlowGroupCreateFragmentV2.f422078n;
            String r102 = r100.T90().getChatId();
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L10:
            if (r103 == false) goto L15;
            return null;
        L15:
            return Long.valueOf(CastLongProtector.parseLong(r102));
        L17:
            return null;
        L5:
            if (r102.length() == 0) goto L8;
            r103 = false;
            goto L10
        }

        public d(FlowGroupCreateFragmentV2 r100) {
            this.f422089a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateFragmentV2$onActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateFragmentV2$onActivityResult$1", f = "FlowGroupCreateFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $data;
        int label;
        final /* synthetic */ FlowGroupCreateFragmentV2 this$0;

        public AnonymousClass1(Intent r100, FlowGroupCreateFragmentV2 r101, Continuation<? super AnonymousClass1> r102) {
            this.$data = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$data, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            Serializable r101 = this.$data.getSerializableExtra("selectedMember");
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.contact.entity.SelectedData>");
            FlowGroupCreateFragmentV2 r102 = this.this$0;
            int r103 = FlowGroupCreateFragmentV2.f422078n;
            FlowGroupCreateViewModel r104 = r102.T90();
            r104.resetSelectedUser((List) r101);
            this.this$0.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("mPicker");
            throw null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final FlowGroupCreateViewModel T90() {
        return (FlowGroupCreateViewModel) this.f422083j.getValue();
    }

    @Inject
    public FlowGroupCreateFragmentV2() {
        Function0<ViewModelProvider.Factory> r100 = new FlowGroupCreateFragmentV2$viewModel$2(this);
        final Function0<Fragment> r101 = new FlowGroupCreateFragmentV2$special$$inlined$viewModels$default$1(this);
        this.f422083j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowGroupCreateViewModel.class), new FlowGroupCreateFragmentV2$special$$inlined$viewModels$default$2(r101), r100);
        this.f422084k = new b(this);
        this.f422085l = new c(this);
        this.f422086m = new d(this);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        T90().initData(getArguments());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f422081h = (ViewGroup) r100.findViewById(R.id.confirm_bottom_container);
        this.f422080g = (FrameLayout) r100.findViewById(R.id.picker_container);
        TextView r102 = (TextView) r100.findViewById(R.id.confirm);
        this.f422082i = r102;
        ViewGroup r103 = null;
        Object[] r104 = 0;
        Object[] r105 = 0;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r102 = null;
    L5:
        r102.setText(UIUtils.getString(getContext(), R.string.LarkIM_Group_CreateGroupChat_Title));
        TextView r106 = this.f422082i;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r106 = null;
    L8:
        r106.setEnabled(false);
        final FragmentActivity r107 = getActivity();
        if ((r107 instanceof FragmentActivity) == true) goto L12;
        r107 = null;
    L12:
        if (r107 == null) goto L18;
        PickerConfig r108 = new PickerConfig(new Dependency(r107, r107.getSupportFragmentManager()), new Permissions(CollectionsKt.listOf(ActionType.INVITE_SAME_CHAT)));
        r108.extra(new FlowGroupCreateFragmentV2$initPicker$pickerConfig$1$1(r107, this));
        r108.searcher(FlowGroupCreateFragmentV2$initPicker$pickerConfig$1$2.INSTANCE);
        r108.recommendList(new FlowGroupCreateFragmentV2$initPicker$pickerConfig$1$3(this));
        LarkPicker r109 = new LarkPicker(requireContext(), r105 == true ? 1 : 0, 2, r104 == true ? 1 : 0);
        LarkPicker.attachRecommendEmptyViewConfig$default(r109, Integer.valueOf(R.drawable.img_flow_create_group_search_empty), null, 2, null);
        r109.init(r107, r108);
        r109.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r109.setConsumeResultLayoutClickWhenEmpty(true);
        FrameLayout r110 = this.f422080g;
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mPickerContainer");
        r110 = null;
    L17:
        r110.addView(r109);
    L18:
        T90().getSelectUserCountData().observe(getViewLifecycleOwner(), new e(this));
        T90().getEnableConfirmBtn().observe(getViewLifecycleOwner(), new f(this));
        TextView r111 = this.f422082i;
        if (r111 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r111 = null;
    L21:
        r111.setOnClickListener(new FlowGroupCreateFragmentV2$initListener$1(this));
        ViewGroup r112 = this.f422081h;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBottomContainer");
        r112 = null;
    L24:
        int r113 = r112.getPaddingBottom();
        ViewGroup r114 = this.f422081h;
        if (r114 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBottomContainer");
        r114 = null;
    L27:
        ViewCompat.setOnApplyWindowInsetsListener(r114, new g(r113));
        ViewGroup r115 = this.f422081h;
        if (r115 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBottomContainer");
    L31:
        ViewCompat.requestApplyInsets(r103);
        return;
    L30:
        r103 = r115;
        goto L31
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r101 != (-1)) goto L10;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r100 != 18) goto L11;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass1(r102, this, null), 2, null);
        return;
    L11:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_flow_group_create, r101, false);
    }
}
