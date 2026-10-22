package com.larus.bmhome.chat.api;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.actionbar.model.x0;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.z2;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class BotApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<BotApi> f297150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Pair<String, ? extends com.larus.network.http.a<x0>> f297151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function1<? super com.larus.network.http.a<x0>, Unit> f297152c;

    public static final class a {
        public static String a(int r100) {
            if (r100 != 1) goto L5;
            return "chat_list_preset";
        L5:
            if (r100 != 2) goto L7;
            return "bot_list_discover";
        L7:
            if (r100 != 4) goto L9;
            return "chatlist_board";
        L9:
            if (r100 != 7) goto L11;
            return "chat_action_bar";
        L11:
            if (r100 != 9) goto L13;
        L15:
            return "chat_list_rec";
        L13:
            if (r100 == 10) goto L15;
            return null;
        }
    }

    public BotApi() {
    }

    static {
        f297150a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new b());
        f297151b = new Pair("", null);
        f297152c = new c();
    }

    public static Object a(IBotRepoService.c r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$reportActionBarModeSwitch$2(r100, null), r101);
    }

    public static Object b(IBotRepoService.d r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$reportCustomActionBarOperation$2(r100, null), r101);
    }

    public static Object d(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$requireBotFirstMet$2(r100, null), r101);
    }

    public static Object i(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$requireSubjectBotInfo$2(r100, null), r101);
    }

    public static Object j(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$resetBotSubject$2(r100, null), r101);
    }

    public static Object k(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$sendCancelLikeBotAction$2(r100, null), r101);
    }

    public static Object l(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$sendLikeBotAction$2(r100, null), r101);
    }

    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: com.larus.bmhome.actionbar.model.x0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: com.larus.bmhome.actionbar.model.x0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v4 ??, new type: com.larus.bmhome.actionbar.model.x0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v5 ??, new type: com.larus.bmhome.actionbar.model.x0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v6 ??, new type: java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v7 ??, new type: com.larus.bmhome.actionbar.model.x0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v11 ??, new type: com.larus.bmhome.actionbar.model.y0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v8 ??, new type: com.larus.bmhome.actionbar.model.y0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v8 ??, new type: com.larus.bmhome.actionbar.model.y0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: java.lang.Object
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public final java.lang.Object e(com.larus.bmhome.chat.model.repo.IBotRepoService.a r18, kotlin.coroutines.Continuation<? super com.larus.network.http.a<com.larus.bmhome.actionbar.model.x0>> r19) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0090: IGET (r5v3 ?? I:T) = (r4v12 com.larus.network.http.y) A[DECLARE_VAR] (LINE:33554576) com.larus.network.http.a.b java.lang.Object in method: com.larus.bmhome.chat.api.BotApi.e(com.larus.bmhome.chat.model.repo.IBotRepoService$a, kotlin.coroutines.Continuation<? super com.larus.network.http.a<com.larus.bmhome.actionbar.model.x0>>):java.lang.Object, file: classes25.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.bmhome.chat.api.BotApi.e(com.larus.bmhome.chat.model.repo.IBotRepoService$a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object f(IBotRepoService.a r110, Continuation<? super com.larus.network.http.a<x0>> r111) {
        if ((r111 instanceof BotApi$requireCustomActionBarConfV3$1) == false) goto L7;
        BotApi$requireCustomActionBarConfV3$1 r100 = (BotApi$requireCustomActionBarConfV3$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        BotApi$requireCustomActionBarConfV3$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r110 = (IBotRepoService.a) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L37:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;
        f297152c.invoke(r113);
        f297152c = new d();
        f297151b = new Pair(r110.f307694c, r113);
        return r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        f297151b = new Pair("", null);
        LinkedHashMap r105 = new LinkedHashMap();
        z2 r114 = z2.f365865a;
        if (r114.z3().a() == false) goto L17;
        r105.put("resource-slot", "slot_api");
    L17:
        ouc.e0 r106 = new ouc.e0();
        r106.b("language_code", ouc.k.c(r110.f307692a));
        r106.b("bot_id", ouc.k.c(r110.f307693b));
        r106.b("conversation_id", ouc.k.c(r110.f307694c));
        if (com.larus.utils.o0.d(r110.f307695d) == false) goto L20;
        r106.b("page_scene", ouc.k.c(r110.f307695d));
    L20:
        LinkedHashMap r107 = new LinkedHashMap();
        boolean r108 = r114.V3();
        boolean r115 = r114.A0();
        Map<Integer, Integer> r109 = wa8.g.f558857a;
        if (r115 == false) goto L23;
        int r116 = 2606241;
    L25:
        Map<Integer, Integer> r117 = MapsKt.toMutableMap(wa8.g.f558857a);
        r117.put(1, Integer.valueOf(r116));
    L27:
        Iterator<Map.Entry<Integer, Integer>> r118 = r117.entrySet().iterator();
    L29:
        if (r118.hasNext() == false) goto L31;
        Map.Entry<Integer, Integer> r119 = r118.next();
        int r120 = r119.getKey().intValue();
        int r121 = r119.getValue().intValue();
        String r122 = String.valueOf(r120);
        ouc.g0 r123 = ouc.k.b(Integer.valueOf(r121));
        Intrinsics.checkNotNullParameter(r122, "key");
        Intrinsics.checkNotNullParameter(r123, "element");
        ouc.i r124 = (ouc.i) r107.put(r122, r123);
        goto L29
    L31:
        Unit r125 = Unit.INSTANCE;
        r106.b("instruction_code_version", new ouc.d0(r107));
        String r126 = r110.f307696e;
        if (r126 == null) goto L34;
        r106.b("through_token", ouc.k.c(r126));
    L34:
        ouc.d0 r127 = r106.a();
        juc.d<ouc.d0> r128 = ouc.d0.Companion.serializer();
        juc.d<x0> r129 = x0.Companion.serializer();
        r102.L$0 = r110;
        r102.label = 1;
        r112 = HttpExtKt.j(x0.class, "/alice/bot/action_bar_v3/list", r127, r128, r129, r105, r102, 3648);
        if (r112 != r103) goto L37;
        return r103;
    L23:
        if (r108 == false) goto L26;
        r116 = 2606242;
        goto L25
    L26:
        r117 = wa8.g.f558857a;
    L7:
        r100 = new BotApi$requireCustomActionBarConfV3$1(this, r111);
        goto L8
    }

    public static Object c(String r100, OnboardingActionCardData.CardScene r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$requireBotActionCard$2(r100, r101, null), r102);
    }

    public static Object g(long r100, List r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApi$requireCustomActionBarCustomize$2(r100, r101, null), r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object h(int r210, int r211, int r212, Long r213, boolean r214, String r215, String r216, String r217, String r218, DowngradeSource r310, Continuation<? super ic8.o0> r311) {
        int r100 = r210;
        if ((r311 instanceof BotApi$requireRecommendBotData$1) == false) goto L7;
        BotApi$requireRecommendBotData$1 r101 = (BotApi$requireRecommendBotData$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r100 = r101.I$0;
        ResultKt.throwOnFailure(r103);
    L35:
        ic8.o0 r105 = (ic8.o0) ((com.larus.network.http.a) r103).f360135b;
        if (r105 == null) goto L39;
        r105.i(a.a(r100));
        return r105;
    L39:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Map r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE, String.valueOf(r210))});
        if (r216 == null) goto L17;
        r106.put("trigger_type", r216);
    L17:
        if (r213 == null) goto L19;
        r106.put("tab_id", r213.toString());
    L19:
        if (r217 == null) goto L21;
        r106.put("tab", r217);
    L21:
        FlowDowngradeServiceDelegate r107 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r111 = new JSONObject();
        r111.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE, r100);
        r111.put("page_index", r211);
        r111.put("page_size", r212);
        r111.put("with_onboarding", r214);
        if (r215 == null) goto L24;
        r111.put("old_bot_id", r215);
    L24:
        if (r213 == null) goto L26;
        r111.put("tag_id", r213.longValue());
    L26:
        if (r218 == null) goto L28;
        r111.put("first_bot_id", r218);
    L28:
        Unit r108 = Unit.INSTANCE;
        if (r310 == null) goto L31;
        Map r112 = MapsKt.mapOf(TuplesKt.to("source", r310.getValue()));
    L32:
        r101.I$0 = r100;
        r101.label = 1;
        r103 = IFlowDowngradeService.a.b(r107, ServiceType.UGC, ic8.o0.class, "/alice/bot/recommend", r111, null, true, r106, r112, r101, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MINISDP_Custom_PARAMS);
        if (r103 != r110) goto L35;
        return r110;
    L31:
        r112 = null;
    L7:
        r101 = new BotApi$requireRecommendBotData$1(this, r311);
        goto L8
    }
}
