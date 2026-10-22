package com.larus.luckydog.impl;

import android.app.Activity;
import android.net.Uri;
import android.widget.FrameLayout;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.common.apphost.AppHost;
import com.larus.luckydog.api.ILuckyDogService;
import com.larus.luckydog.api.LuckyDogCountTaskType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;
import tx9.x3;
import ym7.l;
import ym7.n;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\u000e\u0010\u0015\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010*\u001a\u00020\tH\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010-\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\tH\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/larus/luckydog/impl/LuckyDogServiceImpl;", "Lcom/larus/luckydog/api/ILuckyDogService;", "<init>", "()V", "isLuckyDogInit", "", "initMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkInit", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pendantShowCount", "", "pendingReport", "settingUpdateListener", "Lkotlin/Function0;", "Lkotlin/Result;", "topActivity", "Landroid/app/Activity;", "getTopActivity", "()Landroid/app/Activity;", "handleSdkInit", "updateSettings", "addCustomInterceptor", "isLuckyDogSchema", "uri", "Landroid/net/Uri;", "handleLuckyDogSchema", "schema", "", "isFromHandleDeeplink", "recognizeLuckyTaskType", "dealJumpLoginForNewUser", "recognizeLuckyDogModel", "onPrivacyOk", "reportTaskCompleted", "calledType", "Lcom/larus/luckydog/api/LuckyDogCountTaskType;", "showLuckDogPendantView", "frameLayout", "Landroid/widget/FrameLayout;", "dismissLuckDogPendantView", "initLuckDogSdk", "settings", "Lorg/json/JSONObject;", "updateSettingsInner", "isNewUserAcquisition", "isUserReactivation", "preInit", "isActivity", "activityName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LuckyDogServiceImpl implements ILuckyDogService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f358405f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f358406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f358407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f358408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f358409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f358410e;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final boolean e() {
        boolean r100 = ek9.a.f472952b.get();
        FLogger.f375446a.d("LuckyDogModel", "read isUserReactivation=" + r100);
        return r100;
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final boolean g() {
        AtomicBoolean r100 = ek9.a.f472951a;
        boolean r101 = ek9.a.f472951a.get();
        FLogger.f375446a.d("LuckyDogModel", "read isNewUserAcquisition=" + r101);
        return r101;
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final void h() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LuckyDogServiceImpl$initLuckDogSdk$1(this, null), 2, null);
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final void preInit() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Set<String> r101 = to7.a.f546943k;     // Catch: Throwable -> L4
        to7.a.d.f546961a.i(AppHost.f326268a.getApplication(), false);     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.e("LuckyDogServiceImpl", "preInit failed", r103);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public LuckyDogServiceImpl() {
        this.f358407b = kotlinx.coroutines.sync.b.a();
        this.f358410e = new h(this);
    }

    public static final void i(LuckyDogServiceImpl r100) {
        r100.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (z2.f365865a.r0() == false) goto L6;
        RetrofitUtils.addInterceptor(new fk9.a());     // Catch: Throwable -> L8
    L6:
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L16;
        FLogger.f375446a.e("LuckyDogServiceImpl", "Error in addCustomInterceptor", r103);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static boolean l(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        Activity r102 = AppHost.f326268a.a().getCurrentActivity();     // Catch: Throwable -> L10
        if (r102 == null) goto L15;
        if (StringsKt.contains$default(r102.getClass().getName(), r100, false, 2, null) != true) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L10:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return false;
    }

    public static void m(JSONObject r100) {
        FLogger.f375446a.i("LuckyDogServiceImpl", "updateSettings called is null: false");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LuckyDogServiceImpl$updateSettingsInner$1(r100, null), 2, null);
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final void a(LuckyDogCountTaskType r110) {
        Intrinsics.checkNotNullParameter(r110, "calledType");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L37
        FLogger r101 = FLogger.f375446a;     // Catch: Throwable -> L37
        r101.i("LuckyDogServiceImpl", "reportTaskCompleted called calledType: " + r110 + ' ');     // Catch: Throwable -> L37
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L7;
        r101.i("LuckyDogServiceImpl", "reportTaskCompleted return for not login");     // Catch: Throwable -> L37
        return;
    L7:
        ek9.b r102 = ek9.b.f472953a;     // Catch: Throwable -> L37
        LuckyDogCountTaskType r103 = ek9.b.a();     // Catch: Throwable -> L37
        if (r103 != r110) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L22;
        LuckyDogCountTaskType r105 = LuckyDogCountTaskType.WRITE_WISHES;     // Catch: Throwable -> L37
        if (r103 == r105) goto L17;
        if (r103 != LuckyDogCountTaskType.COLLECT_PRIZE) goto L22;
    L17:
        if (r110 == LuckyDogCountTaskType.DO_CREATION) goto L21;
        if (r110 == r105) goto L21;
        if (r110 != LuckyDogCountTaskType.COLLECT_PRIZE) goto L22;
    L21:
        r104 = true;
    L22:
        if (r104 == true) goto L25;
        r101.i("LuckyDogServiceImpl", "taskType: " + r103 + ", calledType: " + r110);     // Catch: Throwable -> L37
        return;
    L25:
        boolean r111 = ek9.a.f472952b.get();     // Catch: Throwable -> L37
        r101.d("LuckyDogModel", "read isUserReactivation=" + r111);     // Catch: Throwable -> L37
        if (r111 == true) goto L28;
        return;
    L28:
        r101.i("LuckyDogServiceImpl", "reportAddCountEvent handle");     // Catch: Throwable -> L37
        e r112 = e.f358413a;     // Catch: Throwable -> L37
        Unit r113 = null;
        e.f358415c = null;     // Catch: Throwable -> L37
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LuckyDogMessageObserver$clearSPCache$1(null), 2, null);     // Catch: Throwable -> L37
        if (this.f358408c > 0) goto L32;
        this.f358409d = true;     // Catch: Throwable -> L37
        return;
    L32:
        xm7.g r106 = (xm7.g) wm7.g.a(xm7.g.class);     // Catch: Throwable -> L37
        if (r106 == null) goto L35;
        r106.a(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L37
        r113 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L35:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L37
    L39:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L44;
        FLogger.f375446a.e("LuckyDogServiceImpl", "reportTaskCompleted failed", r115);
        return;
    L44:
        return;
    L10:
        r104 = false;
    L37:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final void b(FrameLayout r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        FLogger.f375446a.i("LuckyDogServiceImpl", "dismissLuckyDogPendantView handle");     // Catch: Throwable -> L11
        if (this.f358408c <= 0) goto L6;
        this.f358408c--;     // Catch: Throwable -> L11
    L6:
        l r102 = (l) wm7.g.a(l.class);     // Catch: Throwable -> L11
        Unit r103 = null;
        if (r102 == null) goto L9;
        r102.c("default", new n(r100, null, 6));     // Catch: Throwable -> L11
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L19;
        FLogger.f375446a.e("LuckyDogServiceImpl", "Error in dismissLuckyDogPendantView", r105);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final void c(FrameLayout r100) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LuckyDogServiceImpl$showLuckDogPendantView$1(r100, this, null), 2, null);
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final boolean d(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return vm7.a.a().isLuckySchema(y0.k(r100), new String[]{"doubao"});
    }

    public final Object k(Continuation<? super Unit> r100) {
        if ((r100 instanceof LuckyDogServiceImpl$handleSdkInit$1) == false) goto L7;
        LuckyDogServiceImpl$handleSdkInit$1 r101 = (LuckyDogServiceImpl$handleSdkInit$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        Throwable r106 = Result.m9452exceptionOrNullimpl(((Result) r103).m9458unboximpl());
        if (r106 == null) goto L21;
        FLogger.f375446a.e("LuckyDogServiceImpl", "sdkInit Failed", r106);
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        LuckyDogServiceImpl$handleSdkInit$2 r108 = new LuckyDogServiceImpl$handleSdkInit$2(this, null);
        r101.label = 1;
        r103 = BuildersKt.withContext(r107, r108, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new LuckyDogServiceImpl$handleSdkInit$1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.luckydog.impl.LuckyDogServiceImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r6v8, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static final Object j(LuckyDogServiceImpl r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof LuckyDogServiceImpl$checkInit$1) == false) goto L7;
        LuckyDogServiceImpl$checkInit$1 r102 = (LuckyDogServiceImpl$checkInit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        ?? r107 = (kotlinx.coroutines.sync.a) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
        ?? r108 = r106;
        r107 = r107;
    L34:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r107.unlock(null);
        r105 = Unit.INSTANCE;
        ?? r110 = r108;
    L44:
        return r105;
    L38:
        th = move-exception;
        th = th;
        ?? r111 = r110;
    L40:
        r111.unlock(null);
        throw th;
    L15:
        th = th;
        r111 = r107;
        goto L40
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r112 = (kotlinx.coroutines.sync.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r110 = r112;
    L45:
        if (r100.f358406a == false) goto L30;
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L38
        r110.unlock(null);
        r110 = r110;
        goto L44
    L30:
        r102.L$0 = r110;     // Catch: Throwable -> L38
        r102.label = 2;     // Catch: Throwable -> L38
        r110 = r110;
        if (r100.k(r102) == r105) goto L44;
        r107 = r110;
        r108 = r110;
        goto L34
    L20:
        ResultKt.throwOnFailure(r104);
        if (r100.f358406a == true) goto L47;
        MutexImpl r113 = r100.f358407b;
        r102.L$0 = r113;
        r102.label = 1;
        Object r114 = r113.a(null, r102);
        r110 = r113;
        if (r114 != r105) goto L45;
        return r105;
    L47:
        return Unit.INSTANCE;
    L7:
        r102 = new LuckyDogServiceImpl$checkInit$1(r100, r101);
        goto L8
    }

    @Override // com.larus.luckydog.api.ILuckyDogService
    public final void f(String r110, boolean r111) {
        x3.a("luckydog", "handle_lucky_dog_schema", null);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new LuckyDogServiceImpl$handleLuckyDogSchema$1(r111, r110, this, null), 2, null);
    }
}
