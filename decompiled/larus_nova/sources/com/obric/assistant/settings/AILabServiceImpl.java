package com.obric.assistant.settings;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0013\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0017J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0097@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\rH\u0097@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0006H\u0083@¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0003J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/settings/AILabServiceImpl;", "Lcom/obric/assistant/settings/IAILabService;", "<init>", "()V", "cachedSettings", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/settings/AILabSettingItem;", "", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "init", "", "isSettingEnabled", "", MapController.ITEM_LAYER_TAG, "(Lcom/obric/assistant/settings/AILabSettingItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAILabEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contentObserver", "com/obric/assistant/settings/AILabServiceImpl$contentObserver$1", "Lcom/obric/assistant/settings/AILabServiceImpl$contentObserver$1;", "queryFromCP", "unstableQueryFromCP", "uri", "Landroid/net/Uri;", "fallbackToCachedOrDefault", "reason", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AILabServiceImpl implements IAILabService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f391690d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<AILabSettingItem, Integer> f391691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f391692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AILabServiceImpl$contentObserver$1 f391693c;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.AILabServiceImpl$init$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.AILabServiceImpl$init$3", f = "AILabServiceImpl.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AILabServiceImpl this$0;

        public AnonymousClass3(AILabServiceImpl r100, Continuation<? super AnonymousClass3> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            Iterator r103 = (Iterator) this.L$1;
            AILabServiceImpl r104 = (AILabServiceImpl) this.L$0;
            ResultKt.throwOnFailure(r100);
        L17:
            if (r103.hasNext() == false) goto L22;
            AILabSettingItem r105 = (AILabSettingItem) r103.next();
            this.L$0 = r104;
            this.L$1 = r103;
            this.label = 1;
            int r106 = AILabServiceImpl.f391690d;
            if (r104.e(r105, this) != r101) goto L17;
            return r101;
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            EnumEntries<AILabSettingItem> r107 = AILabSettingItem.getEntries();
            ArrayList r108 = new ArrayList();
            Iterator<AILabSettingItem> r109 = r107.iterator();
        L10:
            if (r109.hasNext() == false) goto L14;
            AILabSettingItem r110 = r109.next();
            if (r110.getAutoUpdate() == false) goto L10;
            r108.add(r110);
            goto L10
        L14:
            AILabServiceImpl r111 = this.this$0;
            r103 = r108.iterator();
            r104 = r111;
            goto L17
        }
    }

    static {
    }

    @Override // com.obric.assistant.settings.IAILabService
    public final void init() {
        FLogger r100 = FLogger.f375446a;
        r100.i("AILabServiceImpl", "init");
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        r100.w("AILabServiceImpl", "init: sdk < N, skip CP observer/query");
        return;
    L6:
        EnumEntries<AILabSettingItem> r101 = AILabSettingItem.getEntries();
        ArrayList r102 = new ArrayList();
        Iterator<AILabSettingItem> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        AILabSettingItem r104 = r103.next();
        if (r104.getAutoUpdate() == false) goto L8;
        r102.add(r104);
        goto L8
    L12:
        Iterator r105 = r102.iterator();
    L14:
        if (r105.hasNext() == false) goto L23;
        Uri r106 = UriProtector.parse("content://com.obric.memorydata.memory.ailabprovider/" + ((AILabSettingItem) r105.next()).getUriKey());
        FLogger.f375446a.i("AILabServiceImpl", "observe " + r106);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L18
        AppHost.f326268a.getApplication().getContentResolver().registerContentObserver(r106, false, this.f391693c);     // Catch: Throwable -> L18
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L14;
        FLogger.f375446a.w("AILabServiceImpl", "observe failed, uri = " + r106 + ", error = " + r109.getMessage(), r109);
    L18:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L23:
        BuildersKt.launch$default(this.f391692b, null, null, new AnonymousClass3(this, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.settings.AILabServiceImpl$contentObserver$1] */
    public AILabServiceImpl() {
        this.f391691a = new ConcurrentHashMap();
        this.f391692b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        final Handler r100 = com.larus.utils.t0.f375468a;
        this.f391693c = new AILabServiceImpl$contentObserver$1(this, r100);
    }

    @Override // com.obric.assistant.settings.IAILabService
    public final Object a(Continuation<? super Boolean> r100) {
        if ((r100 instanceof AILabServiceImpl$isAILabEnabled$1) == false) goto L7;
        AILabServiceImpl$isAILabEnabled$1 r101 = (AILabServiceImpl$isAILabEnabled$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L35:
        if (((Number) r103).intValue() == 4) goto L37;
    L36:
        r106 = true;
    L37:
        FLogger.f375446a.i("AILabServiceImpl", "isAILabEnabled(): aiLabStatusEnable is " + r106);
        return Boxing.boxBoolean(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L20:
        if (((Number) r103).intValue() != 1) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == true) goto L26;
        FLogger.f375446a.i("AILabServiceImpl", "isAILabEnabled(): hasMemoryPermission is false, return false");
        return Boxing.boxBoolean(false);
    L26:
        ConcurrentHashMap<AILabSettingItem, Integer> r108 = this.f391691a;
        AILabSettingItem r109 = AILabSettingItem.AILabStatus;
        Integer r110 = r108.get(r109);
        if (r110 != null) goto L29;
        r101.label = 2;
        r103 = e(r109, r101);
        if (r103 != r104) goto L35;
        return r104;
    L29:
        if (r110.intValue() == 4) goto L37;
    L22:
        r107 = false;
        goto L23
    L16:
        ResultKt.throwOnFailure(r103);
        AILabSettingItem r111 = AILabSettingItem.MemoryPermissonStatus;
        r101.label = 1;
        r103 = e(r111, r101);
        if (r103 != r104) goto L20;
        return r104;
    L7:
        r101 = new AILabServiceImpl$isAILabEnabled$1(this, r100);
        goto L8
    }

    public static ContentProviderClient c(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.obric.assistant.settings.IAILabService
    public final Object b(AILabSettingItem r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof AILabServiceImpl$isSettingEnabled$1) == false) goto L7;
        AILabServiceImpl$isSettingEnabled$1 r102 = (AILabServiceImpl$isSettingEnabled$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L25:
        if (((Number) r104).intValue() != 1) goto L28;
        r107 = true;
    L28:
        return Boxing.boxBoolean(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Integer r108 = this.f391691a.get(r100);
        if (r108 == null) goto L21;
        FLogger.f375446a.i("AILabServiceImpl", "isSettingEnabled: use cached " + r108);
        if (r108.intValue() != 1) goto L20;
        r107 = true;
    L20:
        return Boxing.boxBoolean(r107);
    L21:
        r102.label = 1;
        r104 = e(r100, r102);
        if (r104 != r105) goto L25;
        return r105;
    L7:
        r102 = new AILabServiceImpl$isSettingEnabled$1(this, r101);
        goto L8
    }

    public final int d(AILabSettingItem r100, String r101) {
        Integer r102 = this.f391691a.get(r100);
        if (r102 == null) goto L6;
        FLogger.f375446a.i("AILabServiceImpl", "queryFromCP: use cached fallback. " + r100.getUriKey() + ", reason = " + r101 + ", cachedValue = " + r102);
        return r102.intValue();
    L6:
        FLogger.f375446a.i("AILabServiceImpl", "queryFromCP: use default fallback. " + r100.getUriKey() + ", reason = " + r101);
        return -100;
    }

    public final Object e(AILabSettingItem r100, Continuation<? super Integer> r101) {
        return BuildersKt.async$default(this.f391692b, null, null, new AILabServiceImpl$queryFromCP$2(r100, this, null), 3, null).await(r101);
    }
}
