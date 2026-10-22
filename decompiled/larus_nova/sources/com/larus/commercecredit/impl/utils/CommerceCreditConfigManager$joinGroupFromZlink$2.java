package com.larus.commercecredit.impl.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.minor.api.IMinorService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import qz8.m;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$joinGroupFromZlink$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceCreditConfigManager$joinGroupFromZlink$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    final /* synthetic */ String $text;
    Object L$0;
    Object L$1;
    int label;

    public CommerceCreditConfigManager$joinGroupFromZlink$2(String r100, String r101, Continuation<? super CommerceCreditConfigManager$joinGroupFromZlink$2> r102) {
        this.$text = r100;
        this.$scene = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommerceCreditConfigManager$joinGroupFromZlink$2(this.$text, this.$scene, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommerceCreditConfigManager$joinGroupFromZlink$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.commercecredit.impl.utils.d] */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, qz8.m] */
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
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        String r102 = (String) this.L$1;
        m r103 = (m) this.L$0;
        ResultKt.throwOnFailure(r110);
    L95:
        FLogger.f375446a.i("CommerceCreditConfigManager", "joinGroupFromZlink final from server scene=" + r102 + " res=" + ((String) r110));
        CommerceCreditConfigManager.f325802b.set(false);
    L98:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        String r104 = this.$text;
        final String r105 = "";
        if (r104 == null) goto L27;
        String r106 = this.$scene;
        CommerceCreditConfigManager r112 = CommerceCreditConfigManager.f325801a;
        Regex r113 = new Regex("(?<=invite_code=)[^&\\s]+");
        Regex r114 = new Regex("(?<=campaign_key=)[^&\\s]+");
        MatchResult r115 = Regex.find$default(r113, r104, 0, 2, null);
        if (r115 == null) goto L14;
        String r116 = r115.getValue();
        if (r116 == null) goto L14;
    L15:
        MatchResult r107 = Regex.find$default(r114, r104, 0, 2, null);
        if (r107 == null) goto L19;
        String r108 = r107.getValue();
        if (r108 == null) goto L19;
    L20:
        ?? r117 = new m(r116, r108);
        FLogger.f375446a.i("CommerceCreditConfigManager", "joinGroupFromZlink parseInviteCodeAndCampaignKey scene=" + r106 + " inviteCode=" + r117.b() + " campaignKey=" + r117.a());
        if (o0.d(r117.b()) == true) goto L23;
    L25:
        r111.element = r117;
        goto L27
    L23:
        if (o0.d(r117.a()) == false) goto L25;
        i.b(r117);
    L19:
        r108 = "";
    L14:
        r116 = "";
    L27:
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L31;
        FLogger.f375446a.i("CommerceCreditConfigManager", "joinGroupFromZlink: not login scene=" + this.$scene);
        return Unit.INSTANCE;
    L31:
        if (IMinorService.f359156a.a() == false) goto L35;
        FLogger.f375446a.i("CommerceCreditConfigManager", "joinGroupFromZlink: minor mode scene=" + this.$scene);
        return Unit.INSTANCE;
    L35:
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L38;
        FLogger.f375446a.i("CommerceCreditConfigManager", "joinGroupFromZlink: no network with scene=" + this.$scene);
        return Unit.INSTANCE;
    L38:
        m r109 = (m) r111.element;
        if (r109 == null) goto L41;
        String r118 = r109.b();
    L42:
        if (r118 != null) goto L44;
    L47:
        boolean r119 = true;
    L48:
        if (r119 == true) goto L60;
        m r120 = (m) r111.element;
        if (r120 == null) goto L52;
        String r121 = r120.a();
    L53:
        if (r121 != null) goto L55;
    L58:
        boolean r122 = true;
    L59:
        if (r122 == true) goto L60;
    L68:
        m r123 = (m) r111.element;
        if (r123 == null) goto L98;
        final String r124 = this.$scene;
        String r125 = r123.b();
        if (r125 != null) goto L73;
        r125 = "";
    L73:
        String r126 = r123.a();
        if (r126 == null) goto L78;
        r105 = r126;
    L78:
        if (r125.length() != 0) goto L80;
        boolean r127 = true;
    L81:
        if (r127 == false) goto L83;
    L96:
        FLogger.f375446a.i("CommerceCreditConfigManager", "joinGroupFromZlink scene=" + r124 + " inviteCode=" + r125 + " campaignKey=" + r105);
        goto L98
    L83:
        if (r105.length() != 0) goto L85;
        boolean r128 = true;
    L86:
        if (r128 == true) goto L96;
        if (CommerceCreditConfigManager.f325802b.compareAndSet(false, true) == true) goto L91;
        FLogger.f375446a.i("CommerceCreditConfigManager", "joinGroupFromZlink: request already in progress, skip duplicate scene=" + r124);
        goto L98
    L91:
        final long r129 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r130 = com.larus.commercecredit.impl.model.c.f325721a;
        ?? r131 = new d(r124, r129, r105);
        this.L$0 = r123;
        this.L$1 = r124;
        this.label = 1;
        r110 = r130.d(r125, r105, r131, this);
        if (r110 != r100) goto L94;
        return r100;
    L94:
        r102 = r124;
        goto L95
    L85:
        r128 = false;
        goto L86
    L80:
        r127 = false;
        goto L81
    L55:
        if (r121.length() == 0) goto L58;
        r122 = false;
        goto L59
    L52:
        r121 = null;
    L60:
        Keva r132 = i.a();
        if (r132 == null) goto L63;
        String r133 = r132.getString("zlink_invite_info", "");
    L64:
        m r134 = (m) GsonProtectorUtils.fromJson((Gson) i.f325824a.getValue(), r133, m.class);
        T r135 = r134;
        if (r134 != null) goto L67;
        r135 = new m(null, null);
    L67:
        r111.element = r135;
        goto L68
    L63:
        r133 = null;
        goto L64
    L44:
        if (r118.length() == 0) goto L47;
        r119 = false;
        goto L48
    L41:
        r118 = null;
        goto L42
    }
}
