package com.larus.minor.impl.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.minor.api.IMinorService;
import com.larus.minor.impl.api.MinorApi;
import com.larus.minor.impl.k;
import com.larus.minor.impl.v;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import dm9.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;
import t19.s;
import wk9.b;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0006\u0010\u001e\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020\u0017J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larus/minor/impl/viewmodel/MinorPasswordViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "PASSWORD_MAX_LENGTH", "", "TAG", "", "_firstStepPassword", "Landroidx/lifecycle/MutableLiveData;", "_secondStepPassword", "_exitStepPassword", "_currentState", "Lcom/larus/minor/impl/model/PasswordState;", "needReportInputPassword", "", "currentState", "Landroidx/lifecycle/LiveData;", "getCurrentState", "()Landroidx/lifecycle/LiveData;", "isInMinorMode", "()Z", "enableInputPasswordTrace", "", "initState", "getPasswordInputScene", "getPasswordInputStatus", "updatePassword", "password", "verificationPassword", "nextStep", "preStep", "confirm", "getToastString", "enter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinorPasswordViewModel extends ViewModel {
    private final int PASSWORD_MAX_LENGTH;
    private final String TAG;
    private final MutableLiveData<b> _currentState;
    private final MutableLiveData<String> _exitStepPassword;
    private final MutableLiveData<String> _firstStepPassword;
    private final MutableLiveData<String> _secondStepPassword;
    private final LiveData<b> currentState;
    private final boolean isInMinorMode;
    private volatile boolean needReportInputPassword;

    /* JADX INFO: renamed from: com.larus.minor.impl.viewmodel.MinorPasswordViewModel$confirm$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.minor.impl.viewmodel.MinorPasswordViewModel$confirm$1", f = "MinorPasswordViewModel.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MinorPasswordViewModel this$0;

        public AnonymousClass1(MinorPasswordViewModel r100, Continuation<? super AnonymousClass1> r101) {
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            a r103 = (a) r100;
            String r104 = "";
            if ((r103 instanceof a.b) == true) goto L14;
        L20:
            xk9.a.b("turn_on_minor_mode", false, "off", "");
            s r105 = s.f544207a;
            Application r106 = AppHost.f326268a.getApplication();
            String r107 = MinorPasswordViewModel.access$getToastString(this.this$0, true);
            if (r107 == null) goto L24;
            r104 = r107;
        L24:
            r105.getClass();
            s.t(r106, r104);
            v r108 = v.f359217a;
            v.e();
        L26:
            return Unit.INSTANCE;
        L14:
            if (((a.b) r103).f469231a.isSuccess() == false) goto L20;
            xk9.a.b("turn_on_minor_mode", true, "on", "");
            MutableLiveData r109 = MinorPasswordViewModel.access$get_currentState$p(this.this$0);
            String r110 = (String) MinorPasswordViewModel.access$get_secondStepPassword$p(this.this$0).getValue();
            if (r110 == null) goto L19;
            r104 = r110;
        L19:
            r109.postValue(new b(7, r104, 4));
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            String r111 = k.a((String) MinorPasswordViewModel.access$get_secondStepPassword$p(this.this$0).getValue());
            MinorApi.a r112 = MinorApi.f359163a;
            MinorPasswordViewModel$confirm$1$result$1 r113 = new MinorPasswordViewModel$confirm$1$result$1(r111, null);
            this.label = 1;
            r112.getClass();
            r100 = MinorApi.a.a(r113, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.minor.impl.viewmodel.MinorPasswordViewModel$verificationPassword$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.minor.impl.viewmodel.MinorPasswordViewModel$verificationPassword$1", f = "MinorPasswordViewModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $password;
        final /* synthetic */ String $passwordSHA;
        int label;
        final /* synthetic */ MinorPasswordViewModel this$0;

        public C114791(MinorPasswordViewModel r100, String r101, String r102, Continuation<? super C114791> r103) {
            this.this$0 = r100;
            this.$password = r101;
            this.$passwordSHA = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114791(this.this$0, this.$password, this.$passwordSHA, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114791) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L11:
            a r111 = (a) r110;
            boolean r102 = r111 instanceof a.b;
            String r103 = "";
            if (r102 == true) goto L14;
        L16:
            v r104 = v.f359217a;
            v.e();
            if (r102 == true) goto L19;
        L21:
            if (r102 == true) goto L23;
        L25:
            xk9.a.b("turn_off_minor_mode", false, "on", "");
            s r112 = s.f544207a;
            Application r105 = AppHost.f326268a.getApplication();
            String r106 = MinorPasswordViewModel.access$getToastString(this.this$0, false);
            if (r106 == null) goto L29;
            r103 = r106;
        L29:
            r112.getClass();
            s.t(r105, r103);
        L30:
            FLogger.f375446a.e(MinorPasswordViewModel.access$getTAG$p(this.this$0), "request quit minor mode fail !!");
        L32:
            return Unit.INSTANCE;
        L23:
            if (((a.b) r111).f469231a.getCode() != 710172001) goto L25;
            s r113 = s.f544207a;
            AppHost.Companion r107 = AppHost.f326268a;
            Application r108 = r107.getApplication();
            String r109 = r107.getApplication().getString(R.string.larus_teenagerMode_passcodeMax_errToast_cn);
            r113.getClass();
            s.t(r108, r109);
            xk9.a.b("turn_off_minor_mode", false, "on", "max_attempts_exceeded");
            goto L30
        L19:
            if (((a.b) r111).f469231a.getCode() != 710172000) goto L21;
            s r114 = s.f544207a;
            AppHost.Companion r115 = AppHost.f326268a;
            Application r116 = r115.getApplication();
            String r117 = r115.getApplication().getString(R.string.larus_teenagerMode_turnOff_errToast_passcode_cn);
            r114.getClass();
            s.t(r116, r117);
            xk9.a.b("turn_off_minor_mode", false, "on", "password_error");
            goto L30
        L14:
            if (((a.b) r111).f469231a.isSuccess() == false) goto L16;
            xk9.a.b("turn_off_minor_mode", true, "off", "");
            MinorPasswordViewModel.access$get_currentState$p(this.this$0).postValue(new b(8, this.$password, 4));
            goto L32
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            MinorApi.a r118 = MinorApi.f359163a;
            MinorPasswordViewModel$verificationPassword$1$result$1 r119 = new MinorPasswordViewModel$verificationPassword$1$result$1(this.$passwordSHA, null);
            this.label = 1;
            r118.getClass();
            r110 = MinorApi.a.a(r119, this);
            if (r110 != r100) goto L11;
            return r100;
        }
    }

    public final void enableInputPasswordTrace() {
        this.needReportInputPassword = true;
    }

    public final void nextStep() {
        this.needReportInputPassword = false;
        this._currentState.setValue(new b(3, "", true));
    }

    public final void preStep() {
        boolean r100 = false;
        this.needReportInputPassword = false;
        String r101 = "";
        this._secondStepPassword.setValue("");
        String r102 = this._firstStepPassword.getValue();
        if (r102 == null) goto L7;
        r101 = r102;
    L7:
        if (r101.length() != this.PASSWORD_MAX_LENGTH) goto L9;
        r100 = true;
    L9:
        if (r100 == false) goto L11;
        int r103 = 2;
    L12:
        this._currentState.setValue(new b(r103, r101, true));
        return;
    L11:
        r103 = 1;
        goto L12
    }

    private final String getPasswordInputScene() {
        if (this.isInMinorMode == false) goto L5;
        return "turn_off_minor_mode";
    L5:
        return "turn_on_minor_mode";
    }

    private final String getPasswordInputStatus() {
        b r100 = this._currentState.getValue();
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.f560140a);
    L7:
        if (r101 != null) goto L10;
    L11:
        if (r101 != null) goto L14;
    L16:
        if (r101 != null) goto L19;
    L20:
        if (r101 != null) goto L23;
    L24:
        if (r101 != null) goto L27;
        return "enter_new_password";
    L27:
        if (r101.intValue() != 5) goto L31;
    L28:
        return "confirm_password";
    L31:
        return "enter_new_password";
    L23:
        if (r101.intValue() == 4) goto L28;
    L19:
        if (r101.intValue() == 3) goto L28;
    L14:
        if (r101.intValue() != 2) goto L16;
        return "enter_new_password";
    L10:
        if (r101.intValue() != 1) goto L11;
        return "enter_new_password";
    L5:
        r101 = null;
        goto L7
    }

    private final void verificationPassword() {
        String r100 = this._exitStepPassword.getValue();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        String r102 = k.a(r100);
        this._currentState.postValue(new b(6, null, 6));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C114791(this, r100, r102, null), 3, null);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void confirm() {
        if (Intrinsics.areEqual(this._firstStepPassword.getValue(), this._secondStepPassword.getValue()) == false) goto L15;
        String r100 = this._secondStepPassword.getValue();
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L15;
        this._currentState.postValue(new b(6, null, 6));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
    L15:
        s r102 = s.f544207a;
        AppHost.Companion r103 = AppHost.f326268a;
        Application r104 = r103.getApplication();
        String r105 = r103.getApplication().getString(R.string.larus_teenagerMode_confirmParentPasscode_errToast_notMatch_cn);
        r102.getClass();
        s.t(r104, r105);
        xk9.a.b("turn_on_minor_mode", false, "off", "password_error");
    }

    public final void initState() {
        this._firstStepPassword.setValue("");
        this._secondStepPassword.setValue("");
        MutableLiveData<b> r100 = this._currentState;
        if (this.isInMinorMode == false) goto L5;
        int r101 = 5;
    L6:
        r100.setValue(new b(r101, "", 4));
        return;
    L5:
        r101 = 1;
        goto L6
    }

    public MinorPasswordViewModel() {
        this.PASSWORD_MAX_LENGTH = 4;
        this.TAG = "MinorPasswordViewModel";
        this._firstStepPassword = new MutableLiveData("");
        this._secondStepPassword = new MutableLiveData("");
        this._exitStepPassword = new MutableLiveData("");
        MutableLiveData<b> r100 = new MutableLiveData(new b(1, "", 4));
        this._currentState = r100;
        this.needReportInputPassword = true;
        this.currentState = r100;
        this.isInMinorMode = IMinorService.f359156a.a();
    }

    public final LiveData<b> getCurrentState() {
        return this.currentState;
    }

    public final boolean isInMinorMode() {
        return this.isInMinorMode;
    }

    public static final /* synthetic */ String access$getTAG$p(MinorPasswordViewModel r100) {
        return r100.TAG;
    }

    public static final /* synthetic */ MutableLiveData access$get_currentState$p(MinorPasswordViewModel r100) {
        return r100._currentState;
    }

    public static final /* synthetic */ MutableLiveData access$get_secondStepPassword$p(MinorPasswordViewModel r100) {
        return r100._secondStepPassword;
    }

    private final String getToastString(boolean r100) {
        String r101 = null;
        if (z2.f365865a.I() != 1) goto L7;
        Application r102 = AppHost.f326268a.getApplication();
        if (r102 == null) goto L10;
        r101 = r102.getString(R.string.larus_teenagerMode_modeName_parent_cn);
    L10:
        Application r103 = AppHost.f326268a.getApplication();
        if (r103 == null) goto L17;
        if (r100 == false) goto L14;
        int r104 = R.string.larus_teenagerMode_turnedOn_errToast_cn;
    L15:
        String r105 = r103.getString(r104);
        if (r105 == null) goto L17;
    L18:
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        return String.format(r105, Arrays.copyOf(new Object[]{r101}, 1));
    L14:
        r104 = R.string.larus_teenagerMode_turnOff_errToast_failed_cn;
    L17:
        r105 = "";
        goto L18
    L7:
        Application r107 = AppHost.f326268a.getApplication();
        if (r107 == null) goto L10;
        r101 = r107.getString(R.string.larus_teenagerMode_modeName_teenager_cn);
        goto L10
    }

    public final void updatePassword(String r100) {
        Intrinsics.checkNotNullParameter(r100, "password");
        boolean r101 = false;
        if (this.needReportInputPassword == false) goto L14;
        this.needReportInputPassword = false;
        String r102 = getPasswordInputScene();
        String r103 = getPasswordInputStatus();
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("current_page", "minor_mode_setting");     // Catch: JSONException -> L11
        if (r102 == null) goto L8;
        r104.put("password_input_scene", r102);     // Catch: JSONException -> L11
    L8:
        if (r103 == null) goto L13;
        r104.put("password_input_status", r103);     // Catch: JSONException -> L11
    L13:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("input_password");
        r106.f21463a.merge(r105);
        r106.b();
    L11:
        e = move-exception;
        FLogger.f375446a.e("CaseTraceHelper", "error in CaseTraceHelper mobMinorModeInputPassword " + e.getLocalizedMessage());
    L14:
        String r107 = "";
        if (this._currentState.getValue() == null) goto L52;
        b r108 = this._currentState.getValue();
        if (r108 != null) goto L19;
    L21:
        boolean r109 = false;
    L22:
        if (r109 == true) goto L52;
        b r110 = this._currentState.getValue();
        if (r110 != null) goto L26;
    L28:
        boolean r111 = false;
    L29:
        if (r111 == true) goto L52;
        b r112 = this._currentState.getValue();
        if (r112 != null) goto L34;
    L36:
        if (r101 == false) goto L40;
        this._exitStepPassword.setValue(r100);
        if (r100.length() != this.PASSWORD_MAX_LENGTH) goto L67;
        verificationPassword();
        return;
    L67:
        return;
    L40:
        this._secondStepPassword.setValue(r100);
        if (r100.length() != this.PASSWORD_MAX_LENGTH) goto L47;
        MutableLiveData<b> r113 = this._currentState;
        String r114 = this._secondStepPassword.getValue();
        if (r114 == null) goto L46;
        r107 = r114;
    L46:
        r113.setValue(new b(4, r107, 4));
        return;
    L47:
        MutableLiveData<b> r115 = this._currentState;
        String r116 = this._secondStepPassword.getValue();
        if (r116 == null) goto L51;
        r107 = r116;
    L51:
        r115.setValue(new b(3, r107, 4));
        return;
    L34:
        if (r112.f560140a != 5) goto L36;
        r101 = true;
        goto L36
    L26:
        if (r110.f560140a != 1) goto L28;
        r111 = true;
        goto L29
    L19:
        if (r108.f560140a != 2) goto L21;
        r109 = true;
    L52:
        this._firstStepPassword.setValue(r100);
        if (r100.length() != this.PASSWORD_MAX_LENGTH) goto L59;
        MutableLiveData<b> r117 = this._currentState;
        String r118 = this._firstStepPassword.getValue();
        if (r118 == null) goto L58;
        r107 = r118;
    L58:
        r117.setValue(new b(2, r107, 4));
        return;
    L59:
        MutableLiveData<b> r119 = this._currentState;
        String r120 = this._firstStepPassword.getValue();
        if (r120 == null) goto L63;
        r107 = r120;
    L63:
        r119.setValue(new b(1, r107, 4));
    }

    public static final /* synthetic */ String access$getToastString(MinorPasswordViewModel r100, boolean r101) {
        return r100.getToastString(r101);
    }
}
