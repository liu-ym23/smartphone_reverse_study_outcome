package com.ss.android.lark.passport.flow.verify.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.flow.passport.ui.widget.common.CodeView;
import com.ss.android.lark.flow.passport.ui.widget.common.CommonUiContainer;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseFragment;
import com.ss.android.lark.flow.passport.ui.widget.common.g;
import com.ss.android.lark.flow.passport.ui.widget.layout.MaxWidthLinerLayout;
import com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt;
import com.ss.android.lark.flow.passport.ui.widget.verifycode.VerifyCodeEditText;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.network.handler.h;
import com.ss.android.lark.passport.flow.core.router.PassportRouterResult;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.ButtonBean;
import com.ss.android.lark.passport.flow.verify.entity.SwitchButton;
import com.ss.android.lark.passport.flow.verify.viewmodel.AuthListViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCommonViewModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import uzb.l;
import uzb.m;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00172\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020*H\u0002J\u0018\u00100\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0002R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\r\u001a\u0004\b\f\u0010\bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\u0011\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/view/VerifyCodeFragment;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "<init>", "()V", "commonViewModel", "Lkotlin/Lazy;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "getCommonViewModel", "()Lkotlin/Lazy;", "commonViewModel$delegate", "authListViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel;", "getAuthListViewModel", "authListViewModel$delegate", "viewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel;", "getViewModel", "viewModel$delegate", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "uiContainer", "Lcom/ss/android/lark/flow/passport/ui/widget/common/CommonUiContainer;", "verifyEditText", "Lcom/ss/android/lark/flow/passport/ui/widget/verifycode/VerifyCodeEditText;", "preCode", "", "mOnTextChangeListener", "Lcom/ss/android/lark/flow/passport/ui/widget/verifycode/VerifyCodeEditText$OnTextChangeListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setApplyCodeText", "tvCountDown", "Landroid/widget/TextView;", "initVerifyEditText", "countDownViewUpdate", "time", "", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VerifyCodeFragment extends FlowBaseFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f437945m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f437946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f437947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f437948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommonUiContainer f437949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VerifyCodeEditText f437950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f437951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f437952l;

    public static final class a {
    }

    public static final class b implements VerifyCodeEditText.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerifyCodeFragment f437953a;

        public b(VerifyCodeFragment r100) {
            this.f437953a = r100;
        }

        @Override // com.ss.android.lark.flow.passport.ui.widget.verifycode.VerifyCodeEditText.e
        public final void a(String r100) {
            if (TextUtils.equals(this.f437953a.f437951k, r100) == false) goto L5;
            return;
        L5:
            VerifyCodeFragment r101 = this.f437953a;
            Intrinsics.checkNotNull(r100);
            r101.f437951k = r100;
            if (TextUtils.isEmpty(r100) == false) goto L8;
            return;
        L8:
            if (r100.length() != 6) goto L12;
            uzb.f.b(this.f437953a.getContext());
            int r102 = VerifyCodeFragment.V90(this.f437953a).f565477a;
            this.f437953a.W90().getValue().reduce(new VerifyCodeViewModel.a.c(r102, r100));
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel$ViewState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$1", f = "VerifyCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<VerifyCodeViewModel.d, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $tvCountDown;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyCodeFragment this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$1$a */
        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VerifyCodeFragment f437954a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LinearLayout f437955b;

            public a(VerifyCodeFragment r100, LinearLayout r101) {
                this.f437954a = r100;
                this.f437955b = r101;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                PassportLog.d("VerifyCodeFragment", "Recover account clicked");
                VerifyCodeFragment r101 = this.f437954a;
                int r102 = VerifyCodeFragment.f437945m;
                r101.W90().getValue().reduce(VerifyCodeViewModel.a.b.f438004a);
                uzb.f.b(this.f437955b.getContext());
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$1$b */
        public static final class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SwitchButton f437956a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VerifyCodeFragment f437957b;

            public b(SwitchButton r100, VerifyCodeFragment r101) {
                this.f437956a = r100;
                this.f437957b = r101;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                if (this.f437956a.getActionType() != ButtonType.SWITCH_AUTH.getValue()) goto L6;
                ((AuthListViewModel) ((Lazy) this.f437957b.f437947g.getValue()).getValue()).reduce(AuthListViewModel.a.C5230a.f437996a);
                return;
            L6:
                if (VerifyCodeFragment.V90(this.f437957b).d(this.f437956a.getActionType()) == false) goto L11;
                String r101 = VerifyCodeFragment.V90(this.f437957b).a(this.f437956a.getActionType());
                if (r101 == null) goto L15;
                UDToast.show(this.f437957b.requireContext(), r101);
                return;
            L15:
                return;
            L11:
                AuthMethod r102 = VerifyCodeFragment.V90(this.f437957b).b(this.f437956a.getActionType());
                if (r102 == null) goto L17;
                VerifyCodeFragment r103 = this.f437957b;
                ((AuthListViewModel) ((Lazy) r103.f437947g.getValue()).getValue()).reduce(new AuthListViewModel.a.b(r103.requireContext(), r102));
                return;
            }
        }

        public AnonymousClass1(VerifyCodeFragment r100, TextView r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$tvCountDown = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, this.$tvCountDown, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(VerifyCodeViewModel.d r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(VerifyCodeViewModel.d r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L49;
            ResultKt.throwOnFailure(r110);
            VerifyCodeViewModel.d r111 = (VerifyCodeViewModel.d) this.L$0;
            if ((r111 instanceof VerifyCodeViewModel.d.b) == false) goto L45;
            PassportLog.d("VerifyCodeFragment", "collect viewState: " + r111);
            CommonUiContainer r100 = this.this$0.f437949i;
            if (r100 == null) goto L9;
            r100.b(((VerifyCodeViewModel.d.b) r111).f438017a.getTitle());
        L9:
            CommonUiContainer r101 = this.this$0.f437949i;
            if (r101 == null) goto L12;
            r101.a(((VerifyCodeViewModel.d.b) r111).f438017a.getSubTitle());
        L12:
            ViewGroup r102 = this.this$0.getRootView();
            if (r102 == null) goto L25;
            TextView r103 = (TextView) r102.findViewById(R.id.tv_countdown);
            if (r103 == null) goto L25;
            VerifyCodeFragment r104 = this.this$0;
            TextView r105 = this.$tvCountDown;
            xyb.a r106 = VerifyCodeFragment.V90(r104);
            r106.getClass();
            boolean r107 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(ButtonType.VERIFY_PHONE.getValue()), Integer.valueOf(ButtonType.VERIFY_EMAIL.getValue())}).contains(Integer.valueOf(r106.f565477a));
            PassportLog.d("VerifyCodeFragment", "needCountDown: " + r107);
            if (r107 == false) goto L19;
            int r108 = 0;
        L20:
            r103.setVisibility(r108);
            if (r107 == false) goto L25;
            if (r105 == null) goto L24;
            VerifyCodeFragment.U90(r104, r105, r104.W90().getValue().getCurTime());
        L24:
            r104.W90().getValue().reduce(VerifyCodeViewModel.a.C5231a.f438003a);
            goto L25
        L19:
            r108 = 8;
        L25:
            ViewGroup r109 = this.this$0.getRootView();
            if (r109 == null) goto L37;
            LinearLayout r112 = (LinearLayout) r109.findViewById(R.id.ll_recover);
            if (r112 == null) goto L37;
            VerifyCodeFragment r113 = this.this$0;
            ButtonBean r114 = ((VerifyCodeViewModel.d.b) r111).f438017a.getRetrieveButton();
            if (r114 == null) goto L36;
            r112.setVisibility(0);
            ((TextView) r112.findViewById(R.id.tv_recover)).setText(r114.getText());
            TextView r115 = (TextView) r112.findViewById(R.id.tv_recover_click);
            if (VerifyCodeFragment.V90(r113).f565477a != ButtonType.VERIFY_OTP.getValue()) goto L34;
            r115.setText(R.string.Lark_Passport_OTPVerify_ResetOTP);
        L35:
            m.a(r115, new a(r113, r112));
            goto L37
        L34:
            r115.setText(R.string.Lark_Login_RecoverAccountTextLink);
            goto L35
        L36:
            r112.setVisibility(8);
        L37:
            ViewGroup r116 = this.this$0.getRootView();
            if (r116 == null) goto L47;
            TextView r117 = (TextView) r116.findViewById(R.id.tv_switch_code);
            if (r117 == null) goto L47;
            VerifyCodeFragment r118 = this.this$0;
            SwitchButton r119 = ((VerifyCodeViewModel.d.b) r111).f438017a.getSwitchButton();
            if (r119 == null) goto L44;
            r117.setVisibility(0);
            r117.setText(r119.getText());
            m.a(r117, new b(r119, r118));
            goto L47
        L44:
            r117.setVisibility(8);
        L47:
            return Unit.INSTANCE;
        L45:
            PassportLog.b("VerifyCodeFragment", "collect viewState missed");
            goto L47
        L49:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Triple;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$2", f = "VerifyCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Triple<? extends Integer, ? extends Integer, ? extends Integer>, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $tvCountDown;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyCodeFragment this$0;

        public AnonymousClass2(TextView r100, VerifyCodeFragment r101, Continuation<? super AnonymousClass2> r102) {
            this.$tvCountDown = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.$tvCountDown, this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Triple<? extends Integer, ? extends Integer, ? extends Integer> r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Triple<Integer, Integer, Integer> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r100);
            Triple r101 = (Triple) this.L$0;
            TextView r102 = this.$tvCountDown;
            if (r102 == null) goto L21;
            if (r102.getVisibility() != 0) goto L21;
            int r103 = VerifyCodeFragment.V90(this.this$0).f565477a;
            if (r103 != ButtonType.VERIFY_PHONE.getValue()) goto L13;
            VerifyCodeFragment.U90(this.this$0, this.$tvCountDown, ((Number) r101.getFirst()).intValue());
        L19:
            return Unit.INSTANCE;
        L13:
            if (r103 != ButtonType.VERIFY_SPARE.getValue()) goto L16;
            VerifyCodeFragment.U90(this.this$0, this.$tvCountDown, ((Number) r101.getSecond()).intValue());
            goto L19
        L16:
            if (r103 != ButtonType.VERIFY_EMAIL.getValue()) goto L19;
            VerifyCodeFragment.U90(this.this$0, this.$tvCountDown, ((Number) r101.getThird()).intValue());
        L21:
            return Unit.INSTANCE;
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel$UIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$3", f = "VerifyCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<VerifyCodeViewModel.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $tvCountDown;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyCodeFragment this$0;

        public AnonymousClass3(VerifyCodeFragment r100, TextView r101, Continuation<? super AnonymousClass3> r102) {
            this.this$0 = r100;
            this.$tvCountDown = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass3 r102 = new AnonymousClass3(this.this$0, this.$tvCountDown, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(VerifyCodeViewModel.c r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(VerifyCodeViewModel.c r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L60;
            ResultKt.throwOnFailure(r100);
            VerifyCodeViewModel.c r101 = (VerifyCodeViewModel.c) this.L$0;
            if ((r101 instanceof VerifyCodeViewModel.c.a) == false) goto L20;
            VerifyCodeEditText r102 = this.this$0.f437950j;
            if (r102 == null) goto L15;
            r102.f423913a.setText("");
            int r103 = 0;
        L10:
            if (r103 >= r102.f423917e) goto L15;
            r102.f423916d[r103].c();
            if (r103 != 0) goto L14;
            r102.f423916d[r103].e();
        L14:
            r103 = r103 + 1;
        L15:
            VerifyCodeEditText r104 = this.this$0.f437950j;
            if (r104 == null) goto L18;
            r104.b();
        L18:
            this.this$0.f437951k = "";
        L56:
            return Unit.INSTANCE;
        L20:
            if ((r101 instanceof VerifyCodeViewModel.c.i) == false) goto L23;
            this.this$0.T90();
            goto L56
        L23:
            if ((r101 instanceof VerifyCodeViewModel.c.b) == false) goto L26;
            this.this$0.S90();
            goto L56
        L26:
            if ((r101 instanceof VerifyCodeViewModel.c.d) == false) goto L31;
            VerifyCodeEditText r105 = this.this$0.f437950j;
            if (r105 == null) goto L56;
            r105.b();
            goto L56
        L31:
            if ((r101 instanceof VerifyCodeViewModel.c.g) == false) goto L38;
            AtomicReference<syb.b> r106 = com.ss.android.lark.passport.flow.core.router.a.f437790c;
            VerifyCodeViewModel.c.g r107 = (VerifyCodeViewModel.c.g) r101;
            PassportRouterResult r108 = com.ss.android.lark.passport.flow.core.router.a.C5229a.a(this.this$0.requireContext(), r107.f438013a.getNextStep(), r107.f438013a.getStepInfo());
            this.this$0.S90();
            if (r108.a() == false) goto L56;
            FragmentActivity r109 = this.this$0.getActivity();
            if (r109 == null) goto L56;
            r109.finish();
            goto L56
        L38:
            if ((r101 instanceof VerifyCodeViewModel.c.e) == false) goto L43;
            this.this$0.S90();
            FragmentActivity r110 = this.this$0.getActivity();
            if (r110 == null) goto L56;
            r110.finish();
            goto L56
        L43:
            if ((r101 instanceof VerifyCodeViewModel.c.h) == false) goto L48;
            Context r111 = this.this$0.getContext();
            if (r111 == null) goto L56;
            UDToast.show(r111, ((VerifyCodeViewModel.c.h) r101).f438014a);
            goto L56
        L48:
            if ((r101 instanceof VerifyCodeViewModel.c.f) == false) goto L51;
            int r112 = h.f437774a;
            Boxing.boxBoolean(h.b(this.this$0.getContext(), ((VerifyCodeViewModel.c.f) r101).f438012a));
            goto L56
        L51:
            if ((r101 instanceof VerifyCodeViewModel.c.C5232c) == false) goto L58;
            TextView r113 = this.$tvCountDown;
            if (r113 == null) goto L56;
            VerifyCodeFragment r114 = this.this$0;
            int r115 = VerifyCodeFragment.f437945m;
            r113.setText(l.getResources(r114.getContext()).getString(R.string.Lark_Login_V3_ResendVerifyCode));
            r113.setTextColor(l.b(r114.getContext(), R.color.primary_fill_default));
            r113.setEnabled(true);
            m.a(r113, new com.ss.android.lark.passport.flow.verify.view.b(r114));
            goto L56
        L58:
            throw new NoWhenBranchMatchedException();
        L60:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final Lazy<VerifyCodeViewModel> W90() {
        return (Lazy) this.f437948h.getValue();
    }

    public final ViewGroup getRootView() {
        CommonUiContainer r100 = this.f437949i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f423836b;
    }

    public VerifyCodeFragment() {
        this.f437946f = LazyKt.lazy(new VerifyCodeFragment$commonViewModel$2(this));
        this.f437947g = LazyKt.lazy(new VerifyCodeFragment$authListViewModel$2(this));
        this.f437948h = LazyKt.lazy(new VerifyCodeFragment$viewModel$2(this));
        this.f437951k = "";
        this.f437952l = new b(this);
    }

    public static final xyb.a V90(VerifyCodeFragment r100) {
        return ((VerifyCommonViewModel) ((Lazy) r100.f437946f.getValue()).getValue()).getRepo().getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        PassportLog.d("VerifyCodeFragment", "VerifyCodeFragment onViewCreated start");
        ViewGroup r100 = getRootView();
        if (r100 == null) goto L5;
        VerifyCodeEditText r101 = (VerifyCodeEditText) r100.findViewById(R.id.vr_code_edit);
    L6:
        this.f437950j = r101;
        int r102 = 0;
        if (r101 == null) goto L9;
        r101.setVisibility(0);
    L9:
        VerifyCodeEditText r103 = this.f437950j;
        if (r103 == null) goto L30;
        Context r104 = getContext();
        Color.rgb(51, 119, 255);
        Color.rgb(20, 31, 51);
        Color.rgb(VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS, VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS, 240);
        Color.rgb(51, 119, 255);
        Color.rgb(255, 91, 76);
        int r105 = l.b(r104, R.color.primary_fill_default);
        int r106 = l.b(r104, R.color.text_title);
        int r107 = l.b(r104, R.color.line_border_component);
        int r108 = l.b(r104, R.color.primary_fill_default);
        int r112 = l.b(r104, R.color.function_warning_fill_default);
        r103.f423917e = 6;
        SCEditText r109 = new SCEditText(r103.f423914b);
        r103.f423913a = r109;
        r109.setId(R.id.signin_sdk_input_verify_code_edit_text);
        Field r113 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
        r113.setAccessible(true);     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
        r113.set(r103.f423913a, Integer.valueOf(R.drawable.signin_sdk_verify_code_cursor_bg));     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
    L18:
        r103.f423913a.setCursorVisible(false);
        r103.f423913a.setBackgroundColor(0);
        r103.f423913a.setTextSize(0.0f);
        r103.f423913a.setInputType(2);
        r103.f423913a.setImeOptions(6);
        r103.f423913a.addTextChangedListener(new com.ss.android.lark.flow.passport.ui.widget.verifycode.a(r103));
        r103.f423913a.setOnEditorActionListener(new com.ss.android.lark.flow.passport.ui.widget.verifycode.b(r103));
        r103.addView(r103.f423913a, new RelativeLayout.LayoutParams(-1, -1));
        r103.f423913a.setOnLongClickListener(new uhb.a(r103));
        r103.f423913a.setOnClickListener(new com.ss.android.lark.flow.passport.ui.widget.verifycode.c(r103));
        r103.f423913a.setOnFocusChangeListener(new com.ss.android.lark.flow.passport.ui.widget.verifycode.d(r103));
        MaxWidthLinerLayout r114 = new MaxWidthLinerLayout(r103.f423914b);
        r103.f423915c = r114;
        r114.setBackgroundColor(0);
        r103.f423915c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        r103.f423915c.setOrientation(0);
        r103.f423915c.setClipChildren(false);
        r103.setClipChildren(false);
        r103.addView(r103.f423915c);
        r103.f423916d = new CodeView[r103.f423917e];
        CodeView.a r115 = new CodeView.a(r103.getContext());
        r115.f423809c = r105;
        r115.f423808b = true;
        r115.f423813g = r108;
        r115.f423812f = r107;
        r115.f423807a = true;
        r115.f423810d = 22;
        r115.f423811e = r106;
        r115.f423815i = 2;
        r115.f423814h = r112;
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(0, -2);
        r116.weight = 1.0f;
        int r117 = 17;
        r116.gravity = 17;
        float r118 = 10;
        Resources r119 = r103.f423914b.getResources();
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams((int) ((WindowDisplayMetricsOverride.apply(r119, r119.getDisplayMetrics()).density * r118) + 0.5f), -1);
        int r121 = r103.f423916d.length;
        int r122 = 0;
    L19:
        if (r122 >= r121) goto L29;
        r103.f423916d[r122] = new CodeView(r103.f423914b);
        CodeView r123 = r103.f423916d[r122];
        r123.removeAllViews();
        r123.f423805d = r115;
        r123.f423806e.a(g.f423843a, r115.f423812f);
        r123.f423806e.a(g.f423844b, r123.f423805d.f423813g);
        r123.f423806e.a(g.f423845c, r123.f423805d.f423814h);
        r123.f423802a = new TextView(r123.getContext());
        RelativeLayout.LayoutParams r124 = new RelativeLayout.LayoutParams(-2, -1);
        r124.addRule(14, -1);
        r123.f423802a.setTextColor(r115.f423811e);
        r123.f423802a.setTextSize(r115.f423810d);
        TextView r125 = r123.f423802a;
        int r126 = h18.e.f483540a;
        r125.setTypeface(h18.e.b(r123.getContext(), 1));
        r123.f423802a.setGravity(r117);
        r123.f423802a.setId(R.id.signin_sdk_cv_text_id);
        r123.f423802a.setInputType(r115.f423815i);
        r123.addView(r123.f423802a, r124);
        r123.f423803b = new View(r123.getContext());
        RelativeLayout.LayoutParams r127 = new RelativeLayout.LayoutParams(r123.a(1.5f), -1);
        r127.addRule(1, R.id.signin_sdk_cv_text_id);
        r127.bottomMargin = r123.a(10.0f);
        r127.topMargin = r123.a(10.0f);
        r123.f423803b.setBackgroundColor(r115.f423809c);
        r123.addView(r123.f423803b, r127);
        r123.setBackground(r123.f423806e);
        r123.c();
        if ((r121 / 2) != r122) goto L24;
        View r128 = new View(r103.f423914b);
        LinearLayout.LayoutParams r129 = new LinearLayout.LayoutParams(l.a(r103.f423914b, 10.0f), l.a(r103.f423914b, 2.0f));
        r129.gravity = 16;
        r128.setBackgroundColor(r103.f423914b.getResources().getColor(R.color.text_title));
        r103.f423915c.addView(r128, r129);
        Resources r130 = r103.f423914b.getResources();
        LinearLayout.LayoutParams r131 = new LinearLayout.LayoutParams((int) ((WindowDisplayMetricsOverride.apply(r130, r130.getDisplayMetrics()).density * r118) + 0.5f), -1);
        View r132 = new View(r103.f423914b);
        r132.setBackgroundColor(0);
        r103.f423915c.addView(r132, r131);
    L24:
        r103.f423915c.addView(r103.f423916d[r122], r116);
        if (r122 >= (r103.f423916d.length - 1)) goto L27;
        View r133 = new View(r103.f423914b);
        r102 = 0;
        r133.setBackgroundColor(0);
        r103.f423915c.addView(r133, r120);
    L28:
        r122 = r122 + 1;
        r117 = 17;
        goto L19
    L27:
        r102 = 0;
        goto L28
    L29:
        r103.a(r103.f423913a.getText());
        r103.f423913a.post(new uhb.b(r103));
        goto L30
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = move-exception;
        e.printStackTrace();
    L30:
        VerifyCodeEditText r134 = this.f437950j;
        if (r134 == null) goto L33;
        r134.setOnTextFinishListener(new com.ss.android.lark.passport.flow.verify.view.a(this));
    L33:
        VerifyCodeEditText r135 = this.f437950j;
        if (r135 == null) goto L36;
        r135.setOnTextChangeListener(this.f437952l);
    L36:
        VerifyCodeEditText r136 = this.f437950j;
        if (r136 == null) goto L39;
        r136.b();
    L39:
        VerifyCodeEditText r137 = this.f437950j;
        if (r137 == null) goto L51;
        CodeView[] r138 = r137.f423916d;
        if (r138 == null) goto L51;
        int r139 = r138.length;
    L45:
        if (r102 >= r139) goto L51;
        r138[r102].d();
        int r140 = r137.f423913a.getText().length();
        int r141 = r137.f423917e;
        if (r140 < r141) goto L49;
        r137.f423916d[r141 - 1].f();
    L50:
        r102 = r102 + 1;
        goto L45
    L49:
        r137.f423916d[r140].f();
    L51:
        ViewGroup r142 = getRootView();
        if (r142 == null) goto L54;
        TextView r143 = (TextView) r142.findViewById(R.id.tv_countdown);
    L55:
        FlowUtilKt.c(this, W90().getValue().getViewState(), new AnonymousClass1(this, r143, null));
        FlowUtilKt.c(this, W90().getValue().getCountDownTime(), new AnonymousClass2(r143, this, null));
        FlowUtilKt.c(this, W90().getValue().getEventState(), new AnonymousClass3(this, r143, null));
        W90().getValue().init();
        return;
    L54:
        r143 = null;
        goto L55
    L5:
        r101 = null;
        goto L6
    }

    public static final void U90(VerifyCodeFragment r100, TextView r101, int r102) {
        Context r103 = r100.getContext();
        String r104 = String.valueOf(r102);
        String r105 = l.getResources(r103).getString(R.string.Lark_Login_DescOfAuthentication);
        if (r104 == null) goto L10;
        HashMap r106 = new HashMap(1);
        r106.put("time", r104);
        r105 = com.samskivert.mustache.e.a().b().a(r105).b(r106);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        PassportLog.c("UIUtils", "mustacheFormat error", e);
    L10:
        r101.setText(r105);
        r101.setTextColor(l.b(r100.getContext(), R.color.text_placeholder));
        r101.setEnabled(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.f437949i != null) goto L5;
        int r103 = CommonUiContainer.f423816j;
        this.f437949i = CommonUiContainer.b.a(requireActivity(), R.layout.signin_sdk_fragment_verify_list, r101);
    L5:
        CommonUiContainer r104 = this.f437949i;
        if (r104 != null) goto L10;
        return null;
    L10:
        return r104.f423836b;
    }
}
