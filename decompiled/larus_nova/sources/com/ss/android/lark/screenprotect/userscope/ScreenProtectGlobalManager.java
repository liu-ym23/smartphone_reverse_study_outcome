package com.ss.android.lark.screenprotect.userscope;

import android.app.Activity;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.passportc.api.g;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.screenprotect.model.FlagState;
import com.ss.android.lark.screenprotect.screenshot.ShareScreenshotUtil;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes38.dex */
public final class ScreenProtectGlobalManager implements com.ss.android.lark.screenprotect.userscope.a, com.ss.android.lark.screenprotect.userscope.b, g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f439830l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f439831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.security.compliance.infra.network.userscpoe.a f439832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f439833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f439834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Boolean> f439835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f439836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<Boolean> f439837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f439838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f439839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f439840j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f439841k;

    public static final class a {
    }

    public static final class b extends com.ss.android.lark.appcontext.applifecycle.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenProtectGlobalManager f439842a;

        public b(ScreenProtectGlobalManager r100) {
            this.f439842a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = ScsLogger.f440428a;
            ScsLogger.d("ScreenshotProtection_US", "onActivityPaused: current activity is " + r100);
            if (Intrinsics.areEqual(this.f439842a.f439834d.getValue(), Boolean.FALSE) == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(this.f439842a.f439835e.getValue(), Boolean.TRUE) == false) goto L9;
            r100.getWindow().addFlags(8192);
            ScsLogger.d("ScreenshotProtection_US", "onActivityPaused: vc share screen and admin ban screenshot ,add flag");
            return;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = ScsLogger.f440428a;
            ScsLogger.d("ScreenshotProtection_US", "onActivityResumed: current activity is " + r100);
            int r102 = r100.getIntent().getIntExtra("SCS_FLAG_STATE", FlagState.None.getValue());
            if (r102 != FlagState.Original.getValue()) goto L5;
        L9:
            ScsLogger.d("ScreenshotProtection_US", "onActivityResumed: scs is not allowed to clear flag");
            return;
        L5:
            if (r102 == FlagState.Ban.getValue()) goto L9;
            r100.getWindow().clearFlags(8192);
            ScsLogger.d("ScreenshotProtection_US", "onActivityResumed: clear flag done");
        }
    }

    public static final class c implements hwa.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenProtectGlobalManager f439843a;

        @Override // hwa.a
        public final String moduleName() {
            return "screen-protect,screenshot_protection";
        }

        public c(ScreenProtectGlobalManager r100) {
            this.f439843a = r100;
        }

        @Override // hwa.a
        public final void a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "currentUid");
            ScsLogger.d("ScreenshotProtection_US", "onAuthorizationUpdate: audit sdk callback starts,update data");
            int r100 = AuditManager.getInstance().checkAuthority(22);
            if (r100 == 0) goto L7;
            if (r100 == 3) goto L7;
            if (r100 == 4) goto L7;
        L8:
            ScreenProtectGlobalManager r101 = this.f439843a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r110, "userId");
            int r102 = AuditManager.getInstance().checkAuthority(22);
            ScsLogger.d("ScreenshotProtection_US", "getSwitchFromAuditOrSP:  audit return is " + r102);
            if (r102 != 0) goto L11;
        L19:
            ScsLogger.d("ScreenshotProtection_US", "getSwitchFromAuditOrSP: screen protection return value is unknown 0  or error 4， now  getSwitchInSP");
            BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new ScreenProtectGlobalManager$getSwitchFromAuditOrSP$1(r101, r110, null), 3, null);
            return;
        L11:
            if (r102 != 1) goto L13;
            ScsLogger.d("ScreenshotProtection_US", "getSwitchFromAuditOrSP: audit return value is deny 1 ，the switch is ：open，ban screenshot");
            CoroutineScope r103 = com.ss.android.lark.security.compliance.infra.base.a.f440424a;
            BuildersKt.launch$default(r103, null, null, new ScreenProtectGlobalManager$getSwitchFromAuditOrSP$2(r101, r110, null), 3, null);
            r101.f439835e.setValue(Boolean.TRUE);
            BuildersKt.launch$default(r103, null, null, new ScreenProtectGlobalManager$getSwitchFromAuditOrSP$3(r101, r110, null), 3, null);
            return;
        L13:
            if (r102 == 2) goto L17;
            if (r102 == 3) goto L17;
            if (r102 == 4) goto L19;
            return;
        L17:
            ScsLogger.d("ScreenshotProtection_US", "getSwitchFromAuditOrSP: screen protection return value is  ALLOW 2 or NULL 3,the switch is：close，allow screenshot");
            r101.f439835e.setValue(Boolean.FALSE);
            BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new ScreenProtectGlobalManager$getSwitchFromAuditOrSP$4(r101, r110, null), 3, null);
            return;
        L7:
            String r104 = u4c.a.f548750a;
            u4c.a.a("scs_screenshot_audit_callback_result", MapsKt.mapOf(TuplesKt.to("result", Integer.valueOf(r100))), null, null, 0, 28);
            goto L8
        }
    }

    public static final class d extends com.ss.android.lark.appcontext.applifecycle.a {
        public d() {
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = ScsLogger.f440428a;
            ScsLogger.d("ScreenshotProtection_US", "onActivityResumed: current activity is " + r100);
            int r102 = r100.getIntent().getIntExtra("SCS_FLAG_STATE", FlagState.None.getValue());
            if (r102 != FlagState.Original.getValue()) goto L5;
        L9:
            ScsLogger.d("ScreenshotProtection_US", "onActivityResumed: scs is not allowed to add flag");
            return;
        L5:
            if (r102 == FlagState.Allow.getValue()) goto L9;
            r100.getWindow().addFlags(8192);
            ScsLogger.d("ScreenshotProtection_US", "onActivityResumed: add flag");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.screenprotect.userscope.ScreenProtectGlobalManager$onUserChanged$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.screenprotect.userscope.ScreenProtectGlobalManager$onUserChanged$1", f = "ScreenProtectGlobalManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenProtectGlobalManager this$0;

        public AnonymousClass1(ScreenProtectGlobalManager r100, Continuation<? super AnonymousClass1> r101) {
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            ScreenProtectGlobalManager r101 = this.this$0;
            int r102 = ScreenProtectGlobalManager.f439830l;
            r101.c(true);
            ScsLogger.d("ScreenshotProtection_US", "init: OnLogoutListener now logout all users,allowScreenshots() done");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.screenprotect.userscope.ScreenProtectGlobalManager$onUserChanged$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.screenprotect.userscope.ScreenProtectGlobalManager$onUserChanged$2", f = "ScreenProtectGlobalManager.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ f0c.g $currentUserPayload;
        int label;
        final /* synthetic */ ScreenProtectGlobalManager this$0;

        public AnonymousClass2(ScreenProtectGlobalManager r100, f0c.g r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$currentUserPayload = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$currentUserPayload, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            boolean r103 = ((Boolean) r100).booleanValue();
            this.this$0.f439835e.setValue(Boxing.boxBoolean(r103));
            if (r103 == false) goto L14;
            this.this$0.d(true);
        L16:
            return Unit.INSTANCE;
        L14:
            this.this$0.c(false);
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ScreenProtectGlobalManager r104 = this.this$0;
            String r105 = this.$currentUserPayload.f475033a.userId;
            this.label = 1;
            r100 = ScreenProtectGlobalManager.a(r104, r105, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.screenprotect.userscope.ScreenProtectGlobalManager$onUserOnline$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.screenprotect.userscope.ScreenProtectGlobalManager$onUserOnline$1", f = "ScreenProtectGlobalManager.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C121141(Continuation<? super C121141> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121141(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121141) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ShareScreenshotUtil r103 = ShareScreenshotUtil.f439806a;
            this.label = 1;
            if (ShareScreenshotUtil.e(this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.screenprotect.userscope.b
    public final boolean getSwitchStatusFromAdmin() {
        Boolean r100 = this.f439835e.getValue();
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("ScreenshotProtection_US", "SwitchData.getSwitchStatusFromAdmin:" + r101);
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.screenprotect.userscope.b
    public final boolean getSwitchStatusFromCurrentApp() {
        int r100 = ScsLogger.f440428a;
        ScsLogger.d("ScreenshotProtection_US", "SwitchData.getSwitchStatusFromCurrentApp:" + this.f439836f);
        return this.f439836f;
    }

    @Override // com.ss.android.lark.screenprotect.userscope.a
    public final void init() {
        if (this.f439833c == false) goto L5;
        return;
    L5:
        ScsLogger.d("ScreenshotProtection_US", "init: start");
        if (w4c.c.a().s0() == false) goto L8;
        ScsLogger.d("ScreenshotProtection_US", "isScreenProtectionDisabled: APP setting return result true");
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        ScsLogger.d("ScreenshotProtection_US", "appsetting return result is true，do not run screenshot protection module");
        return;
    L12:
        ScsLogger.d("ScreenshotProtection_US", "appsetting return result is false，running screenshot protection module");
        this.f439834d.observeForever(new com.ss.android.lark.screenprotect.userscope.c(this));
        this.f439835e.observeForever(new com.ss.android.lark.screenprotect.userscope.d(this));
        this.f439837g.observeForever(new e(this));
        AuditManager.getInstance().addAuthorizationUpdateListener(this.f439841k);
        ScsLogger.d("ScreenshotProtection_US", "addAuthorizationUpdateListener:  add audit sdk listener");
        ((com.ss.android.lark.screenprotect.common.e) this.f439838h.getValue()).registerReceiver();
        this.f439833c = true;
        ScsLogger.d("ScreenshotProtection_US", "init: end");
        return;
    L8:
        ScsLogger.d("ScreenshotProtection_US", "isScreenProtectionDisabled: APP setting return result false");
        r100 = false;
        goto L9
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final j getPassport() {
        return this.f439831a;
    }

    public static final void b(ScreenProtectGlobalManager r100) {
        if (Intrinsics.areEqual(r100.f439834d.getValue(), Boolean.FALSE) == false) goto L5;
        r100.c(true);
        return;
    L5:
        Boolean r101 = r100.f439835e.getValue();
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L8;
    L11:
        r100.d(true);
        return;
    L8:
        if (Intrinsics.areEqual(r100.f439837g.getValue(), r102) == true) goto L11;
        r100.c(true);
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L13;
        Activity r101 = AppLifecycle.a.f408803a.f();
        if (r101 == null) goto L13;
        int r102 = r101.getIntent().getIntExtra("SCS_FLAG_STATE", FlagState.None.getValue());
        if (r102 != FlagState.Original.getValue()) goto L9;
    L12:
        ScsLogger.d("ScreenshotProtection_US", "MonitorActivity.allowScreenshots: scs is not allowed to clear flag");
        goto L13
    L9:
        if (r102 == FlagState.Ban.getValue()) goto L12;
        r101.getWindow().clearFlags(8192);
        ScsLogger.d("ScreenshotProtection_US", "MonitorActivity.allowScreenshots: topActivity clear flags done");
    L13:
        AppLifecycle r103 = AppLifecycle.a.f408803a;
        r103.j(this.f439839i);
        r103.b(this.f439840j);
        this.f439836f = false;
        ScsLogger.d("ScreenshotProtection_US", "allowScreenshots: done");
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L8;
        Activity r101 = com.ss.android.lark.appcontext.applifecycle.c.a.f408832a.a();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L8;
        r102.addFlags(8192);
    L8:
        AppLifecycle r103 = AppLifecycle.a.f408803a;
        r103.j(this.f439840j);
        r103.b(this.f439839i);
        this.f439836f = true;
        ScsLogger.d("ScreenshotProtection_US", "banScreenshots: done");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new C121141(null), 3, null);
    }

    public ScreenProtectGlobalManager(j r100, com.ss.android.lark.security.compliance.infra.network.userscpoe.a r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "requestService");
        this.f439831a = r100;
        this.f439832b = r101;
        this.f439834d = new MutableLiveData(Boolean.TRUE);
        Boolean r102 = Boolean.FALSE;
        this.f439835e = new MutableLiveData(r102);
        new ConcurrentHashMap();
        this.f439837g = new MutableLiveData(r102);
        this.f439838h = LazyKt.lazy(new ScreenProtectGlobalManager$registerVCBroadcast$2(this));
        this.f439839i = new d();
        this.f439840j = new b(this);
        this.f439841k = new c(this);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r110, f0c.b r111) {
        Intrinsics.checkNotNullParameter(r111, "currentState");
        Intrinsics.checkNotNullParameter(r111, "currentState");
        f0c.g r112 = r111.a();
        if (r112 != null) goto L6;
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L6:
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new AnonymousClass2(this, r112, null), 3, null);
    }

    public static final Object a(ScreenProtectGlobalManager r100, String r101, Continuation r102) {
        r100.getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new ScreenProtectGlobalManager$getSwitchInSP$2(r101, null), r102);
    }
}
