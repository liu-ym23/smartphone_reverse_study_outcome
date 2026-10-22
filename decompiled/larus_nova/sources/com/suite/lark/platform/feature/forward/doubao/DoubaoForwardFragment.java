package com.suite.lark.platform.feature.forward.doubao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.doubao.DoubaoWorkSearchResultAdapterKt;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.forwardv3.utils.ConfigUtils;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModelFactory;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0013H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/DoubaoForwardFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "forwardTemplateNew", "Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "viewModel", "Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel;", "chatPicker", "Lcom/ss/android/lark/forwardv3/dependency/IForwardChatPicker;", "confirmBtn", "Landroid/widget/TextView;", "closeBtn", "Landroid/widget/ImageView;", "activityStartTime", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "emptyViewLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onDestroyView", "installSearchEmptyViewFix", "pickerContainer", "installSearchEmptyViewFixWithRetry", "remaining", "", "clampEmptyViewIntoParent", "emptyView", "initViewModel", "templateNew", "initChatPicker", "dealBusinessConsumeClick", "", "data", "observeViewModel", "updateConfirmButton", "selectedCount", "hideKeyboardAfterPick", "errorToast", "errorMsg", "", "Companion", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoForwardFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ForwardTemplateNew f461238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ForwardV3ViewModel f461239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public tib.e f461240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f461241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f461242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f461243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IGetDataCallback<List<SearchBaseInfo>> f461244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q f461245k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubaoForwardFragment f461246a;

        public b(DoubaoForwardFragment r100) {
            this.f461246a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            FragmentActivity r101 = this.f461246a.getActivity();
            if ((r101 instanceof ForwardDoubaoActivity) == false) goto L5;
            ForwardDoubaoActivity r102 = (ForwardDoubaoActivity) r101;
        L6:
            if (r102 == null) goto L9;
            KeyboardUtils.hideKeyboard(r102);
            r102.finish();
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubaoForwardFragment f461247a;

        public c(DoubaoForwardFragment r100) {
            this.f461247a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ForwardV3ViewModel r101 = this.f461247a.f461239e;
            View r102 = null;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r101 = null;
        L5:
            List<SearchBaseInfo> r103 = r101.getSelectedItemList();
            if (r103.isEmpty() == false) goto L8;
            return;
        L8:
            FragmentActivity r104 = this.f461247a.getActivity();
            if ((r104 instanceof ForwardDoubaoActivity) == false) goto L11;
            ForwardDoubaoActivity r105 = (ForwardDoubaoActivity) r104;
        L12:
            if (r105 == null) goto L29;
            Intrinsics.checkNotNullParameter(r103, "items");
            Fragment r106 = r105.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (r106 != null) goto L17;
            return;
        L17:
            if (r105.getSupportFragmentManager().findFragmentByTag("DoubaoForwardConfirmFragment") == null) goto L19;
            Log.w("ForwardDoubaoActivity", "openConfirmFragment skip: already attached");
            return;
        L19:
            KeyboardUtils.hideKeyboard(r105);
            DoubaoForwardConfirmFragment r107 = new DoubaoForwardConfirmFragment();
            FragmentTransaction r108 = r105.getSupportFragmentManager().beginTransaction().hide(r106);
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r108, r107, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "DoubaoForwardConfirmFragment", R.id.fragment_container) == true) goto L23;
            r108 = r108.add(R.id.fragment_container, r107, "DoubaoForwardConfirmFragment");
        L23:
            r108.addToBackStack("DoubaoForwardConfirmFragment").commitAllowingStateLoss();
            r105.f461266o = true;
            View r109 = r105.f461263l;
            if (r109 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        L27:
            r102.post(new d0(r105));
            return;
        L26:
            r102 = r109;
            goto L27
        L29:
            return;
        L11:
            r105 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.suite.lark.platform.feature.forward.doubao.DoubaoForwardFragment$onActivityCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.DoubaoForwardFragment$onActivityCreated$1", f = "DoubaoForwardFragment.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoubaoForwardFragment this$0;

        public AnonymousClass1(DoubaoForwardFragment r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
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
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ForwardV3ViewModel r103 = this.this$0.f461239e;
            if (r103 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r103 = null;
        L11:
            this.label = 1;
            if (r103.asyncLoadMessageParams(this) != r101) goto L15;
            return r101;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        q r100 = this.f461245k;
        if (r100 == null) goto L9;
        View r101 = getView();
        if (r101 == null) goto L9;
        View r102 = r101.findViewById(R.id.search_result_empty);
        if (r102 == null) goto L9;
        r102.removeOnLayoutChangeListener(r100);
    L9:
        this.f461245k = null;
        tib.e r103 = this.f461240f;
        if (r103 == null) goto L12;
        r103.destroy();
    L12:
        super.onDestroyView();
    }

    public DoubaoForwardFragment() {
    }

    public final void T90(int r100) {
        if (r100 <= 0) goto L4;
        boolean r101 = true;
    L5:
        TextView r102 = this.f461241g;
        TextView r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        r102 = null;
    L8:
        r102.setEnabled(r101);
        TextView r104 = this.f461241g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        r104 = null;
    L11:
        r104.setCompoundDrawables(null, null, null, null);
        TextView r105 = this.f461241g;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        r105 = null;
    L14:
        Context r106 = requireContext();
        if (r101 == false) goto L17;
        int r107 = R.color.flow_ud_primary_50;
    L18:
        r105.setTextColor(ContextCompat.getColor(r106, r107));
        TextView r108 = this.f461241g;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
    L22:
        if (r100 <= 0) goto L24;
        String r109 = y9c.d.j(R.string.Lark_Legacy_PickerConfirmWithCount, "count", String.valueOf(r100));
    L25:
        r103.setText(r109);
        return;
    L24:
        r109 = y9c.d.h(R.string.Lark_Legacy_ConfirmInfo);
        goto L25
    L21:
        r103 = r108;
        goto L22
    L17:
        r107 = R.color.ud_N500;
        goto L18
    L4:
        r101 = false;
        goto L5
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r310) {
        super.onActivityCreated(r310);
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        ForwardTemplateNew r101 = (ForwardTemplateNew) r100.getParcelable("key_intent_forward_template_new");
    L6:
        if (r101 != null) goto L11;
        Log.e("DoubaoForwardFragment", "ForwardTemplateNew is null, finish");
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L86;
        r102.finish();
        return;
    L86:
        return;
    L11:
        Bundle r103 = getArguments();
        if (r103 == null) goto L14;
        long r104 = r103.getLong("activity_start_time");
    L15:
        this.f461243i = r104;
        this.f461238d = r101;
        ForwardV3ViewModel r105 = (ForwardV3ViewModel) new ViewModelProvider(requireActivity(), new ForwardV3ViewModelFactory(r101)).get(ForwardV3ViewModel.class);
        this.f461239e = r105;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r105 = null;
    L18:
        r105.init();
        m r110 = new m(this);
        n r111 = new n(this);
        ForwardV3ViewModel r106 = this.f461239e;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r106 = null;
    L21:
        ConfigUtils.b r107 = r106.getSearchPickerParams();
        k r112 = new k(this);
        l r113 = new l(this);
        int r108 = 0;
        boolean r109 = com.ss.android.lark.forwardv3.utils.b.a("im.forward.disabledoubaosearch", false);
        Log.i("FGUtils", "FG key: im.forward.disabledoubaosearch: " + r109);
        if (r109 == true) goto L40;
        Intent r114 = requireActivity().getIntent();
        if (r114 == null) goto L26;
        String r115 = r114.getStringExtra("extra_external_forward_send_mode");
    L27:
        ExternalForwardSendMode[] r116 = ExternalForwardSendMode.values();
        int r117 = r116.length;
    L28:
        if (r108 >= r117) goto L33;
        ExternalForwardSendMode r118 = r116[r108];
        if (Intrinsics.areEqual(r118.name(), r115) == true) goto L34;
        r108 = r108 + 1;
    L34:
        if (r118 != null) goto L36;
        r118 = ExternalForwardSendMode.DOUBAO_ENTRY;
    L36:
        ForwardTemplateNew r119 = this.f461238d;
        if (r119 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r119 = null;
    L39:
        com.ss.android.lark.forwardv3.doubao.d r120 = DoubaoWorkSearchResultAdapterKt.a(r119.getForwardTargetConfig().f425196c, r118, ForwardModuleV3.a());
    L41:
        tib.e r121 = this.f461240f;
        if (r121 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        tib.e r122 = null;
    L45:
        if (r120 == null) goto L47;
        Boolean r123 = Boolean.valueOf(r120.f425344a);
    L48:
        if (r120 == null) goto L50;
        SearchResultAdapter r210 = r120.f425345b;
    L51:
        List r124 = CollectionsKt.listOf(ActionType.SHARE_MESSAGE_SELECT_USER);
        ForwardV3ViewModel r125 = this.f461239e;
        if (r125 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r125 = null;
    L54:
        boolean r126 = !r125.getDefaultSingleSelectMode();
        ForwardV3ViewModel r127 = this.f461239e;
        if (r127 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r127 = null;
    L57:
        boolean r128 = r127.getEnableChatPreview();
        ForwardTemplateNew r129 = this.f461238d;
        if (r129 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r129 = null;
    L60:
        IncludeConfig r130 = r129.getForwardTargetConfig().f425197d;
        ForwardTemplateNew r131 = this.f461238d;
        if (r131 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r131 = null;
    L63:
        boolean r132 = r131.getForwardTargetConfig().f425196c;
        r122.g(new tib.b("forward_doubao", r124, Boolean.valueOf(r126), Boolean.valueOf(r128), Boolean.TRUE, r111, r110, r113, new tib.d(r107.f425539a, r107.f425540b, r107.f425541c, r107.f425542d, r107.f425543e, r107.f425544f), r130, r132, r112, null, null, r123, r210, 1262640));
        tib.e r133 = this.f461240f;
        if (r133 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r133 = null;
    L66:
        r133.e();
        ForwardV3ViewModel r134 = this.f461239e;
        if (r134 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r134 = null;
    L69:
        r134.getSelectedItem().observe(getViewLifecycleOwner(), new s(this));
        ForwardV3ViewModel r135 = this.f461239e;
        if (r135 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r135 = null;
    L72:
        r135.getRecommendData().observe(getViewLifecycleOwner(), new t(this));
        ForwardV3ViewModel r136 = this.f461239e;
        if (r136 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r136 = null;
    L75:
        IForwardContent r137 = r136.getForwardContent();
        if ((r137 instanceof SingleMessageForwardContent) == false) goto L78;
        return;
    L78:
        if ((r137 instanceof MergeMessageForwardContent) == false) goto L80;
        return;
    L80:
        if ((r137 instanceof OneByOneMessageForwardContent) == true) goto L89;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L89:
        return;
    L50:
        r210 = null;
        goto L51
    L47:
        r123 = null;
        goto L48
    L44:
        r122 = r121;
        goto L45
    L33:
        r118 = null;
        goto L34
    L26:
        r115 = null;
        goto L27
    L40:
        r120 = null;
        goto L41
    L14:
        r104 = 0;
        goto L15
    L5:
        r101 = null;
        goto L6
    }

    public static final void S90(DoubaoForwardFragment r100, View r101) {
        r100.getClass();
        Object r102 = r101.getParent();
        if ((r102 instanceof View) == false) goto L5;
        View r103 = (View) r102;
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.getHeight() > 0) goto L11;
        return;
    L11:
        if (r101.getHeight() <= 0) goto L26;
        float r104 = r103.getPaddingTop();
        float r105 = (r103.getHeight() - r103.getPaddingBottom()) - r101.getHeight();
        if (r105 <= r104) goto L27;
        float r106 = r101.getTop() + r101.getTranslationY();
        float r107 = RangesKt.coerceIn(r106, r104, r105);
        if (r107 != r106) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == true) goto L24;
        r101.setTranslationY(r101.getTranslationY() + (r107 - r106));
        return;
    L24:
        return;
    L19:
        r108 = false;
        goto L20
    L27:
        return;
    L26:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_forward_doubao, r101, false);
        this.f461241g = (TextView) r103.findViewById(R.id.forward_confirm_btn);
        ImageView r104 = (ImageView) r103.findViewById(R.id.forward_close_btn);
        this.f461242h = r104;
        tib.e r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
        r104 = null;
    L5:
        r104.setImageResource(R.drawable.ud_icon_close_small_outlined);
        ImageView r106 = this.f461242h;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
        r106 = null;
    L8:
        r106.setOnClickListener(new b(this));
        TextView r107 = this.f461241g;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        r107 = null;
    L11:
        r107.setOnClickListener(new c(this));
        ViewGroup r108 = (ViewGroup) r103.findViewById(R.id.forward_chat_picker);
        r108.removeAllViews();
        tib.c r109 = ForwardModuleV3.a().createForwardChatPicker(requireContext());
        r108.addView(r109.f546355a, new ViewGroup.LayoutParams(-1, -1));
        tib.e r110 = r109.f546356b;
        this.f461240f = r110;
        if (r110 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
    L15:
        r105.setConsumeResultLayoutClickWhenEmpty(true);
        Intrinsics.checkNotNull(r108);
        View r111 = r108.findViewById(R.id.search_result_empty);
        if (r111 == null) goto L22;
        r111.setOnClickListener(o.f461362a);
        q r112 = new q(this);
        q r113 = this.f461245k;
        if (r113 == null) goto L21;
        r111.removeOnLayoutChangeListener(r113);
    L21:
        this.f461245k = r112;
        r111.addOnLayoutChangeListener(r112);
        r111.post(new p(this, r111));
    L22:
        T90(0);
        return r103;
    L14:
        r105 = r110;
        goto L15
    }
}
