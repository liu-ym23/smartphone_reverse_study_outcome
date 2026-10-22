package com.larus.bmhome.chat.deepsearch.component;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.deepsearch.DeepSearchParam;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.component.DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1", f = "DeepSearchContentComponent.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 203}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
final class DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fromMsgId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeepSearchContentComponent this$0;

    public DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1(String r100, DeepSearchContentComponent r101, Continuation<? super DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1> r102) {
        this.$fromMsgId = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1(this.$fromMsgId, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.bmhome.chat.deepsearch.component.h] */
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
        String r102 = "";
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        ResultKt.throwOnFailure(r110);
    L49:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r103 = (String) this.L$1;
        final DeepSearchContentComponent r104 = (DeepSearchContentComponent) this.L$0;
        ResultKt.throwOnFailure(r110);
        String r105 = r103;
    L22:
        Iterator r111 = ((List) r110).iterator();
    L24:
        if (r111.hasNext() == false) goto L38;
        Message r106 = (Message) r111.next();
        Map<String, String> r107 = r106.getExt();
        if (r107 == null) goto L28;
        String r108 = r107.get("deep_search_from_id");
    L30:
        if (Intrinsics.areEqual(r108, r105) == false) goto L24;
        String r112 = r106.getMessageId();
        if (r112 == null) goto L35;
        r102 = r112;
    L35:
        int r113 = DeepSearchContentComponent.f302637s;
        r104.getClass();
        if (o0.d(r102) == false) goto L49;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new DeepSearchContentComponent$showDeepSearchMessageByMsgId$1(r102, r104, null), 2, null);
        goto L49
    L28:
        r108 = null;
        goto L30
    L38:
        com.larus.bmhome.chat.deepsearch.m r109 = com.larus.bmhome.chat.deepsearch.m.f302674a;
        int r114 = DeepSearchContentComponent.f302637s;
        DeepSearchParam r115 = r104.Y2();
        if (r115 == null) goto L41;
        String r116 = r115.f302627c;
    L42:
        if (r116 != null) goto L44;
        String r117 = "";
    L45:
        ChatPageContext r118 = (ChatPageContext) s1a.d.a(r104).a(ChatPageContext.class);
        ?? r119 = new h(r104);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (r109.a(r105, r117, r118, r119, this) != r100) goto L49;
        return r100;
    L44:
        r117 = r116;
        goto L45
    L41:
        r116 = null;
        goto L42
    L10:
        ResultKt.throwOnFailure(r110);
        String r120 = this.$fromMsgId;
        if (r120 == null) goto L49;
        DeepSearchContentComponent r121 = this.this$0;
        IChatRepoService r122 = zh8.a.f572196a;
        int r123 = DeepSearchContentComponent.f302637s;
        DeepSearchParam r124 = r121.Y2();
        if (r124 == null) goto L15;
        String r125 = r124.f302627c;
    L16:
        if (r125 != null) goto L18;
        r125 = "";
    L18:
        this.L$0 = r121;
        this.L$1 = r120;
        this.label = 1;
        Object r126 = r122.o1(r125, 0, this);
        if (r126 != r100) goto L21;
        return r100;
    L21:
        r105 = r120;
        r104 = r121;
        r110 = r126;
        goto L22
    L15:
        r125 = null;
        goto L16
    }
}
