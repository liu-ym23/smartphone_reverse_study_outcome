package com.larus.bmhome.chat.manager;

import com.bytedance.keva.Keva;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.QuotaConfig;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.model.TitleQuotaModel;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.IUserSettingCacheService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.c2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes25.dex */
public final class Gpt4SwitchManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f306667a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ISettingRepoService f306668b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f306669c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f306670d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f306671e = null;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.Gpt4SwitchManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.Gpt4SwitchManager$1", f = "Gpt4SwitchManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
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
            CoroutineScope r101 = Gpt4SwitchManager.f306667a;
            ((Keva) Gpt4SwitchManager.f306669c.getValue()).registerChangeListener(new k0());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.Gpt4SwitchManager$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.Gpt4SwitchManager$2", f = "Gpt4SwitchManager.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.Gpt4SwitchManager$2$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f306672a = null;

            static {
                f306672a = new a();
            }

            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                UserConfigKey r102 = (UserConfigKey) r100;
                FLogger.f375446a.d("OgfSwitchManager", "OgfSwitchManager.init userConfigUpdatedFlow:" + r102);
                if (r102 != UserConfigKey.USE_OFG_SWITCH) goto L9;
                Object r103 = BuildersKt.withContext(Dispatchers.getMain(), new Gpt4SwitchManager$2$1$1(null), r101);
                if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
                return r103;
            L10:
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(Continuation<? super AnonymousClass2> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(r101);
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
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            IUserSettingCacheService r103 = (IUserSettingCacheService) ServiceManager.get().getService(IUserSettingCacheService.class);
            if (r103 == null) goto L18;
            d1<UserConfigKey> r104 = r103.i();
            if (r104 == null) goto L18;
            FlowCollector<? super UserConfigKey> r105 = a.f306672a;
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L16;
            return r101;
        L18:
            return Unit.INSTANCE;
        }
    }

    public Gpt4SwitchManager() {
    }

    static {
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        f306667a = r100;
        f306668b = RepoDispatcherDelegate.f307737b.c();
        f306669c = LazyKt.lazy(new h0());
        f306670d = LazyKt.lazy(new i0());
        f306671e = LazyKt.lazy(new j0());
        BuildersKt.launch$default(r100, Dispatchers.getMain(), null, new AnonymousClass1(null), 2, null);
        BuildersKt.launch$default(r100, null, null, new AnonymousClass2(null), 3, null);
    }

    public static final void a() {
        int r100 = ((Keva) f306669c.getValue()).getInt(TitleQuotaModel.KEY_LEFT_QUOTA_COUNT, 0);
        boolean r101 = f306668b.y0();
        Iterator r102 = ((List) f306670d.getValue()).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Function2 r103 = (Function2) ((WeakReference) r102.next()).get();
        if (r103 == null) goto L4;
        r103.invoke(Boolean.valueOf(r101), Integer.valueOf(r100));
        goto L4
    }

    public static boolean c() {
        return ((Keva) f306669c.getValue()).getBoolean("key_has_sub_benefits_".concat(AccountService.f365697a.getSecUserId()), false);
    }

    public static void b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        BuildersKt.launch$default(f306667a, Dispatchers.getMain(), null, new Gpt4SwitchManager$addShowGpt4LoadingTextMessageId$1(r100, null), 2, null);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static boolean d(String r100) {
        LaunchInfo r101 = AuthModelDelegate.f297134b.x().getValue();
        if (r101 == null) goto L53;
        QuotaConfig r102 = r101.b1();
        if (r102 == null) goto L53;
        boolean r103 = true;
        if (f306668b.y0() == true) goto L10;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L17;
        return false;
    L17:
        if (r100 != null) goto L19;
    L22:
        BotModel r105 = null;
        if (r103 == true) goto L30;
        BotModel r106 = BotInfoCache.INSTANCE.get(r100);
        if (r106 == null) goto L29;
        r105 = r106;
    L29:
        r105 = r105;
    L30:
        List<Long> r107 = r102.g();
        if (r107 != null) goto L33;
        r107 = CollectionsKt.emptyList();
    L33:
        List<String> r108 = r102.a();
        if (r108 != null) goto L36;
        r108 = CollectionsKt.emptyList();
    L36:
        if (r105 == null) goto L40;
        Integer r109 = r105.getBotType();
        if (r109 == null) goto L40;
        long r110 = r109.intValue();
    L41:
        if (r105 == null) goto L44;
        String r111 = r105.getBotId();
        if (r111 == null) goto L44;
    L46:
        if (r107.contains(Long.valueOf(r110)) == true) goto L49;
        return false;
    L49:
        if (r108.contains(r111) == false) goto L52;
        return false;
    L52:
        return r102.e();
    L44:
        r111 = "";
    L40:
        r110 = -1;
        goto L41
    L19:
        if (r100.length() == 0) goto L22;
        r103 = false;
        goto L22
    L10:
        if (((Keva) f306669c.getValue()).getInt(TitleQuotaModel.KEY_LEFT_QUOTA_COUNT, 0) <= 0) goto L12;
    L13:
        r104 = true;
        goto L15
    L12:
        if (c2.f365725a.a() == false) goto L14;
    L53:
        return false;
    }
}
