package com.larus.commercecredit.impl.utils;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2", f = "CommerceCreditConfigManager.kt", i = {0, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 307, 322}, m = "invokeSuspend", n = {"localCampaignInfo", "localCampaignInfo"}, s = {"L$0", "L$0"})
public final class CommerceCreditConfigManager$getGroupInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<qz8.d, qz8.d, Boolean, Unit> $callback;
    final /* synthetic */ String $campaignKey;
    final /* synthetic */ boolean $isSupportFromLocal;
    final /* synthetic */ String $scene;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$1", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.d, qz8.d, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.d> $localCampaignInfo;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super qz8.d, ? super qz8.d, ? super Boolean, Unit> r100, Ref.ObjectRef<qz8.d> r101, Continuation<? super AnonymousClass1> r102) {
            this.$callback = r100;
            this.$localCampaignInfo = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$callback, this.$localCampaignInfo, r101);
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
            if (this.label != 0) goto L9;
            ResultKt.throwOnFailure(r100);
            Function3<qz8.d, qz8.d, Boolean, Unit> r101 = this.$callback;
            if (r101 == null) goto L10;
            r101.invoke(this.$localCampaignInfo.element, null, Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L10:
            return null;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.d, qz8.d, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.d> $localCampaignInfo;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super qz8.d, ? super qz8.d, ? super Boolean, Unit> r100, Ref.ObjectRef<qz8.d> r101, Continuation<? super AnonymousClass2> r102) {
            this.$callback = r100;
            this.$localCampaignInfo = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.$callback, this.$localCampaignInfo, r101);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L9;
            ResultKt.throwOnFailure(r100);
            Context r101 = AppHost.f326268a.getApplication().getApplicationContext();
            s.j(s.f544207a, r101, r101.getString(R.string.larus_log_in_internet_error), null, false, 28);
            Function3<qz8.d, qz8.d, Boolean, Unit> r102 = this.$callback;
            if (r102 == null) goto L10;
            r102.invoke(this.$localCampaignInfo.element, null, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L10:
            return null;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$3", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.d, qz8.d, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.d> $localCampaignInfo;
        final /* synthetic */ qz8.d $remoteCampaignInfo;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function3<? super qz8.d, ? super qz8.d, ? super Boolean, Unit> r100, Ref.ObjectRef<qz8.d> r101, qz8.d r102, Continuation<? super AnonymousClass3> r103) {
            this.$callback = r100;
            this.$localCampaignInfo = r101;
            this.$remoteCampaignInfo = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.$callback, this.$localCampaignInfo, this.$remoteCampaignInfo, r101);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            Function3<qz8.d, qz8.d, Boolean, Unit> r101 = this.$callback;
            if (r101 == null) goto L7;
            r101.invoke(this.$localCampaignInfo.element, this.$remoteCampaignInfo, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$getGroupInfo$2(boolean r100, String r101, String r102, Function3<? super qz8.d, ? super qz8.d, ? super Boolean, Unit> r103, Continuation<? super CommerceCreditConfigManager$getGroupInfo$2> r104) {
        this.$isSupportFromLocal = r100;
        this.$campaignKey = r101;
        this.$scene = r102;
        this.$callback = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommerceCreditConfigManager$getGroupInfo$2(this.$isSupportFromLocal, this.$campaignKey, this.$scene, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommerceCreditConfigManager$getGroupInfo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, qz8.d] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.larus.commercecredit.impl.utils.b] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L14;
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L11;
        if (r101 != 4) goto L10;
        ResultKt.throwOnFailure(r210);
    L77:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        Ref.ObjectRef r102 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r210);
        Object r103 = r210;
    L53:
        qz8.d r104 = (qz8.d) r103;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("getGroupInfoFromRemote: scene=");
        r106.append(this.$scene);
        r106.append(" campaignKey=");
        r106.append(this.$campaignKey);
        r106.append(" title=");
        if (r104 == null) goto L58;
        qz8.b r107 = r104.a();
        if (r107 == null) goto L58;
        String r108 = r107.h();
    L59:
        r106.append(r108);
        r106.append(' ');
        if (r104 == null) goto L64;
        qz8.b r109 = r104.a();
        if (r109 == null) goto L64;
        String r110 = r109.i();
    L65:
        r106.append(r110);
        r106.append(" desc=");
        if (r104 == null) goto L70;
        qz8.b r111 = r104.a();
        if (r111 == null) goto L70;
        String r112 = r111.e();
    L71:
        r106.append(r112);
        r105.i("CommerceCreditConfigManager", r106.toString());
        if (r104 == null) goto L77;
        MainCoroutineDispatcher r113 = Dispatchers.getMain();
        AnonymousClass3 r114 = new AnonymousClass3(this.$callback, r102, r104, null);
        this.L$0 = null;
        this.label = 4;
        if (BuildersKt.withContext(r113, r114, this) != r100) goto L77;
        return r100;
    L70:
        r112 = null;
    L64:
        r110 = null;
    L58:
        r108 = null;
        goto L59
    L12:
        ResultKt.throwOnFailure(r210);
    L48:
        FLogger.f375446a.i("CommerceCreditConfigManager", "getGroupInfoFromRemote: no network scene=" + this.$scene + " campaignKey=" + this.$campaignKey);
        return Unit.INSTANCE;
    L13:
        r102 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r210);
    L44:
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L50;
        MainCoroutineDispatcher r115 = Dispatchers.getMain();
        AnonymousClass2 r116 = new AnonymousClass2(this.$callback, r102, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r115, r116, this) != r100) goto L48;
        return r100;
    L50:
        final long r117 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r118 = com.larus.commercecredit.impl.model.c.f325721a;
        final String r119 = this.$campaignKey;
        final String r120 = this.$scene;
        final Ref.ObjectRef r121 = r102;
        ?? r122 = new b(r121, r120, r117, r119);
        this.L$0 = r102;
        this.label = 3;
        r103 = r118.g(r119, r122, this);
        if (r103 != r100) goto L53;
        return r100;
    L14:
        ResultKt.throwOnFailure(r210);
        r102 = new Ref.ObjectRef();
        if (this.$isSupportFromLocal == false) goto L44;
        com.larus.commercecredit.impl.model.c r123 = com.larus.commercecredit.impl.model.c.f325721a;
        String r124 = this.$campaignKey;
        Intrinsics.checkNotNullParameter(r124, "campaignKey");
        FLogger r125 = FLogger.f375446a;
        r125.i("CommerceCreditRepo", "getGroupInfoFromLocal start, campaignKey: " + r124);
        Gson r126 = com.larus.commercecredit.impl.model.c.b();
        Keva r127 = com.larus.commercecredit.impl.model.c.c();
        if (r127 == null) goto L19;
        String r128 = r127.getString("group_info_" + r124, "");
    L20:
        ?? r129 = (qz8.d) GsonProtectorUtils.fromJson(r126, r128, qz8.d.class);
        r125.i("CommerceCreditRepo", "getGroupInfoFromLocal end");
        r102.element = r129;
        StringBuilder r130 = new StringBuilder("getGroupInfoFromLocal: scene=");
        r130.append(this.$scene);
        r130.append(" campaignKey=");
        r130.append(this.$campaignKey);
        r130.append(" isSupportFromLocal=true title=");
        qz8.d r131 = (qz8.d) r102.element;
        if (r131 == null) goto L25;
        qz8.b r132 = r131.a();
        if (r132 == null) goto L25;
        String r133 = r132.h();
    L26:
        r130.append(r133);
        r130.append(' ');
        qz8.d r134 = (qz8.d) r102.element;
        if (r134 == null) goto L31;
        qz8.b r135 = r134.a();
        if (r135 == null) goto L31;
        String r136 = r135.i();
    L32:
        r130.append(r136);
        r130.append(" desc=");
        qz8.d r137 = (qz8.d) r102.element;
        if (r137 == null) goto L37;
        qz8.b r138 = r137.a();
        if (r138 == null) goto L37;
        String r139 = r138.e();
    L38:
        r130.append(r139);
        r125.i("CommerceCreditConfigManager", r130.toString());
        if (r102.element == 0) goto L44;
        MainCoroutineDispatcher r140 = Dispatchers.getMain();
        AnonymousClass1 r141 = new AnonymousClass1(this.$callback, r102, null);
        this.L$0 = r102;
        this.label = 1;
        if (BuildersKt.withContext(r140, r141, this) != r100) goto L44;
        return r100;
    L37:
        r139 = null;
    L31:
        r136 = null;
    L25:
        r133 = null;
        goto L26
    L19:
        r128 = null;
        goto L20
    }
}
