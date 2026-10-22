package com.obric.assistant.special_input.instruction;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.assistant.idl.s;
import com.obric.aiagent.ipc.utils.g;
import com.obric.assistant.ComplexTaskCaseFromPCConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import vea.q;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/special_input/instruction/PanelInstructionItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadPanelItems$2", f = "PanelInstructionLoader.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3}, l = {56, 60, 61, 63}, m = "invokeSuspend", n = {"config", "shortcuts", "memory", "appFilterPolicy", "config", "memory", "appFilterPolicy", WikiFolderPushPlugin.OPT, "config", "appFilterPolicy", WikiFolderPushPlugin.OPT, "config"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0"})
public final class PanelInstructionLoader$loadPanelItems$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PanelInstructionItem>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ PanelInstructionLoader this$0;

    public PanelInstructionLoader$loadPanelItems$2(PanelInstructionLoader r100, Continuation<? super PanelInstructionLoader$loadPanelItems$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        PanelInstructionLoader$loadPanelItems$2 r102 = new PanelInstructionLoader$loadPanelItems$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends PanelInstructionItem>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<PanelInstructionItem>> r101) {
        return ((PanelInstructionLoader$loadPanelItems$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.obric.assistant.special_input.instruction.b, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L14;
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L11;
        if (r101 != 4) goto L10;
        PanelInstructionLoader r102 = (PanelInstructionLoader) this.L$1;
        ComplexTaskCaseFromPCConfig r103 = (ComplexTaskCaseFromPCConfig) this.L$0;
        ResultKt.throwOnFailure(r210);
        Object r104 = r210;
    L60:
        r102.f392736e = (com.obric.assistant.settings.d) r104;
        List<PanelInstructionItem> r105 = this.this$0.a(r103);
        final PanelInstructionLoader r106 = this.this$0;
        r106.f392737f = r105;
        if (r106.f392738g == true) goto L67;
        r106.f392738g = true;
        if (s.a(Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class)) == null) goto L66;
        BuildersKt.launch$default(r106.f392739h, null, null, new PanelInstructionLoader$registerTaskAppIpcRefreshCallback$1(r106, null), 3, null);
        goto L67
    L66:
        KClass r107 = Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class);
        ?? r108 = new b(r106);
        Intrinsics.checkNotNullParameter(r107, "<this>");
        Intrinsics.checkNotNullParameter(r108, "action");
        g r109 = g.f384740a;
        r r110 = new r(r108);
        r109.getClass();
        g.a(IAgentTaskAppIDL.class, r110, true);
    L67:
        return r105;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        PanelInstructionLoader r111 = (PanelInstructionLoader) this.L$3;
        List<PanelInstructionItem> r112 = (List) this.L$2;
        Deferred r113 = (Deferred) this.L$1;
        ComplexTaskCaseFromPCConfig r114 = (ComplexTaskCaseFromPCConfig) this.L$0;
        ResultKt.throwOnFailure(r210);
        Object r115 = r210;
        List<PanelInstructionItem> r116 = r112;
    L56:
        r111.f392734c = (List) r115;
        PanelInstructionLoader r117 = this.this$0;
        r117.f392735d = r116;
        this.L$0 = r114;
        this.L$1 = r117;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 4;
        r104 = r113.await(this);
        if (r104 != r100) goto L59;
        return r100;
    L59:
        r102 = r117;
        r103 = r114;
        goto L60
    L12:
        PanelInstructionLoader r118 = (PanelInstructionLoader) this.L$4;
        List<PanelInstructionItem> r119 = (List) this.L$3;
        Deferred r120 = (Deferred) this.L$2;
        Deferred r121 = (Deferred) this.L$1;
        ComplexTaskCaseFromPCConfig r122 = (ComplexTaskCaseFromPCConfig) this.L$0;
        ResultKt.throwOnFailure(r210);
        Object r123 = r210;
        List<PanelInstructionItem> r124 = r119;
        r113 = r120;
    L52:
        r118.f392733b = (List) r123;
        r111 = this.this$0;
        this.L$0 = r122;
        this.L$1 = r113;
        this.L$2 = r124;
        this.L$3 = r111;
        this.L$4 = null;
        this.label = 3;
        r115 = r121.await(this);
        if (r115 != r100) goto L55;
        return r100;
    L55:
        r114 = r122;
        r116 = r124;
        goto L56
    L13:
        PanelInstructionLoader r125 = (PanelInstructionLoader) this.L$4;
        Deferred r126 = (Deferred) this.L$3;
        Deferred r127 = (Deferred) this.L$2;
        Deferred r128 = (Deferred) this.L$1;
        ComplexTaskCaseFromPCConfig r129 = (ComplexTaskCaseFromPCConfig) this.L$0;
        ResultKt.throwOnFailure(r210);
        Deferred r130 = r127;
        Deferred r131 = r128;
        r122 = r129;
        PanelInstructionLoader r132 = r125;
        Object r133 = r210;
    L18:
        Lazy<Gson> r134 = PanelInstructionLoader.f392731i;
        r132.getClass();
        ArrayList r135 = new ArrayList();
        Iterator r136 = ((List) r133).iterator();
    L20:
        if (r136.hasNext() == false) goto L31;
        Object r137 = r136.next();
        String r138 = ((q) r137).b();
        if (r138 == null) goto L28;
        String r139 = StringsKt.trim(r138).toString();
        if (r139 == null) goto L28;
        if (StringsKt.equals(r139, WikiFolderPushPlugin.OPT, true) != true) goto L28;
        boolean r140 = true;
    L29:
        if (r140 == false) goto L20;
        r135.add(r137);
    L28:
        r140 = false;
        goto L29
    L31:
        ArrayList r141 = new ArrayList();
        Iterator r142 = r135.iterator();
    L33:
        if (r142.hasNext() == false) goto L42;
        String r143 = ((q) r142.next()).a();
        if (r143 == null) goto L39;
        e r144 = PanelInstructionLoader.g(r143);
        if (r144 == null) goto L39;
        PanelInstructionItem r145 = PanelInstructionLoader.f(r144, PanelInstructionType.RECOMMEND_OPERATION);
    L40:
        if (r145 == null) goto L33;
        r141.add(r145);
    L39:
        r145 = null;
        goto L40
    L42:
        boolean r146 = r141.isEmpty();
        List<PanelInstructionItem> r147 = r141;
        if (r146 == false) goto L46;
        r147 = null;
    L46:
        if (r147 != null) goto L48;
        PanelInstructionLoader r148 = this.this$0;
        int r149 = r122.getLocalLimitCount();
        r148.getClass();
        r147 = PanelInstructionLoader.d(r149);
    L48:
        PanelInstructionLoader r150 = this.this$0;
        this.L$0 = r122;
        this.L$1 = r130;
        this.L$2 = r126;
        this.L$3 = r147;
        this.L$4 = r150;
        this.label = 2;
        r123 = r131.await(this);
        if (r123 != r100) goto L51;
        return r100;
    L51:
        r113 = r126;
        Deferred r211 = r130;
        r124 = r147;
        r118 = r150;
        r121 = r211;
        goto L52
    L14:
        ResultKt.throwOnFailure(r210);
        CoroutineScope r151 = (CoroutineScope) this.L$0;
        ComplexTaskCaseFromPCConfig r152 = this.this$0.f392732a.invoke();
        r131 = BuildersKt.async$default(r151, null, null, new PanelInstructionLoader$loadPanelItems$2$shortcuts$1(this.this$0, r152, null), 3, null);
        r130 = BuildersKt.async$default(r151, null, null, new PanelInstructionLoader$loadPanelItems$2$memory$1(this.this$0, r152, null), 3, null);
        Deferred r153 = BuildersKt.async$default(r151, null, null, new PanelInstructionLoader$loadPanelItems$2$operationData$1(this.this$0, null), 3, null);
        r126 = BuildersKt.async$default(r151, null, null, new PanelInstructionLoader$loadPanelItems$2$appFilterPolicy$1(this.this$0, null), 3, null);
        r132 = this.this$0;
        this.L$0 = r152;
        this.L$1 = r131;
        this.L$2 = r130;
        this.L$3 = r126;
        this.L$4 = r132;
        this.label = 1;
        r133 = r153.await(this);
        if (r133 != r100) goto L17;
        return r100;
    L17:
        r122 = r152;
        goto L18
    }
}
