package com.obric.assistant.state.impl.multitask.producer;

import androidx.lifecycle.LiveData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.assistant.t1;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kl9.p;
import kl9.u;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/ObricAigcGenerationStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeTasks", "Ljava/util/LinkedHashMap;", "", "Lcom/obric/assistant/state/impl/multitask/producer/ObricAigcGenerationStateProducer$ActiveTask;", "Lkotlin/collections/LinkedHashMap;", "initProducer", "", "handleTaskList", "tasks", "", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveConversationId", "taskInfo", "resolveConversationIdFromTarget", PickerReporterConstants.KEY.TARGET, "taskFlowId", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/api/multitask/state/ObricAigcGenerationTaskState;", DBDefinition.TASK_ID, "Companion", "ActiveTask", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAigcGenerationStateProducer implements TaskFlowAutoInitProducer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f393087c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f393088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, a> f393089b;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jha.l<aha.g> f393090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u f393091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f393092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final aha.u f393093d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393090a, r101.f393090a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393091b, r101.f393091b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393092c, r101.f393092c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f393093d, r101.f393093d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f393090a.hashCode() * 31) + this.f393091b.hashCode()) * 31) + this.f393092c.hashCode()) * 31) + this.f393093d.hashCode();
        }

        public final String toString() {
            return "ActiveTask(handle=" + this.f393090a + ", taskInfo=" + this.f393091b + ", conversationId=" + this.f393092c + ", taskMetadata=" + this.f393093d + ')';
        }

        public a(jha.l<aha.g> r100, u r101, String r102, aha.u r103) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            Intrinsics.checkNotNullParameter(r101, "taskInfo");
            Intrinsics.checkNotNullParameter(r102, "conversationId");
            Intrinsics.checkNotNullParameter(r103, "taskMetadata");
            this.f393090a = r100;
            this.f393091b = r101;
            this.f393092c = r102;
            this.f393093d = r103;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b {
    }

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        il9.a r100 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r100 != null) goto L6;
        FLogger.f375446a.e("ObricAigcGenerationStateProducer", "IMultiTaskManager is unavailable");
        return;
    L6:
        BuildersKt.launch$default(this.f393088a, null, null, new ObricAigcGenerationStateProducer$initProducer$1(r100, this, null), 3, null);
    }

    public ObricAigcGenerationStateProducer() {
        ExecutorCoroutineDispatcher r100 = jha.f.f499127a;
        Intrinsics.checkNotNullParameter("ObricAigcGenerationStateProducer", "orderingDomain");
        this.f393088a = jha.f.b("ObricAigcGenerationStateProducer").f499132b;
        this.f393089b = new LinkedHashMap();
    }

    public static String b(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Object r103 = null;
        if (r102 == false) goto L34;
        return null;
    L34:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L23
        String r105 = UriProtector.getQueryParameter(UriProtector.parse(r100), "target_cvs_id");     // Catch: Throwable -> L23
        if (r105 != null) goto L15;
    L20:
        r105 = null;
    L21:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L23
    L25:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L29;
        FLogger.f375446a.w("ObricAigcGenerationStateProducer", "parse task target failed, target=" + r100, r107);
    L29:
        if (Result.m9455isFailureimpl(r106) == true) goto L33;
        r103 = r106;
    L33:
        return (String) r103;
    L15:
        if (r105.length() > 0) goto L18;
        r101 = false;
    L18:
        if (r101 == false) goto L20;
    L23:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x0287 -> B:118:0x0288). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:129:0x0320 -> B:130:0x0322). Please report as a decompilation issue!!! */
    public static final Object a(ObricAigcGenerationStateProducer r110, List r111, Continuation r112) {
        final ObricAigcGenerationStateProducer r100 = r110;
        r110.getClass();
        if ((r112 instanceof ObricAigcGenerationStateProducer$handleTaskList$1) == false) goto L7;
        ObricAigcGenerationStateProducer$handleTaskList$1 r101 = (ObricAigcGenerationStateProducer$handleTaskList$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        int r106 = 1;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r107 = (String) r101.L$5;
        aha.g.a r113 = (aha.g.a) r101.L$4;
        aha.u r114 = (aha.u) r101.L$3;
        u r115 = (u) r101.L$2;
        String r116 = (String) r101.L$1;
        Iterator r117 = (Iterator) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L118:
        jha.m r108 = (jha.m) r103;
        if (r108 == null) goto L130;
        r100.f393089b.put(r116, new a(r108.f499141a, r115, r107, r114));
        if (r108.f499142b == true) goto L124;
        TaskFlowDslKt.f(r108.f499141a, r113);
    L124:
        FLogger.f375446a.i("ObricAigcGenerationStateProducer", "start taskId=" + r116 + ", taskKey=" + r115.f503998t + ", conversationId=" + r107);
    L130:
        r106 = 1;
    L45:
        if (r117.hasNext() == false) goto L132;
        Map.Entry r109 = (Map.Entry) r117.next();
        r116 = (String) r109.getKey();
        r115 = (u) r109.getValue();
        a r118 = r100.f393089b.get(r116);
        if (r118 == null) goto L50;
        String r119 = r118.f393092c;
        if (r119 == null) goto L50;
    L106:
        if (r118 == null) goto L111;
        aha.u r120 = r118.f393093d;
        if (r120 == null) goto L111;
        r114 = r120;
    L112:
        r113 = new aha.g.a(r115.f503998t, r115, r119, r114);
        if (r118 != null) goto L126;
        String r121 = "multitask:" + r116;
        Intrinsics.checkNotNullParameter(r121, DBDefinition.TASK_ID);
        jha.g r122 = TaskFlowDslKt.b(aha.f.f3548a, r121);
        jha.c r123 = jha.j.a.a(r100);
        r101.L$0 = r117;
        r101.L$1 = r116;
        r101.L$2 = r115;
        r101.L$3 = r114;
        r101.L$4 = r113;
        r101.L$5 = r119;
        r101.label = r106;
        r103 = TaskFlowDslKt.e(r122, r113, r123, r101);
        if (r103 == r104) goto L150;
        r107 = r119;
        goto L118
    L150:
        return r104;
    L126:
        if (Intrinsics.areEqual(r118.f393091b, r115) == true) goto L130;
        LinkedHashMap<String, a> r124 = r100.f393089b;
        jha.l<aha.g> r125 = r118.f393090a;
        String r126 = r118.f393092c;
        aha.u r127 = r118.f393093d;
        ObricAigcGenerationStateProducer r128 = r100;
        Intrinsics.checkNotNullParameter(r125, "handle");
        Intrinsics.checkNotNullParameter(r115, "taskInfo");
        Intrinsics.checkNotNullParameter(r126, "conversationId");
        Intrinsics.checkNotNullParameter(r127, "taskMetadata");
        r124.put(r116, new a(r125, r115, r126, r127));
        TaskFlowDslKt.f(r118.f393090a, r113);
        FLogger.f375446a.i("ObricAigcGenerationStateProducer", "update taskId=" + r116 + ", taskKey=" + r115.f503998t + ", conversationId=" + r119);
        r100 = r128;
    L111:
        r114 = m.d(r119, null, null, 14);
    L50:
        Map<String, String> r129 = r115.f503997s;
        if (r129 == null) goto L63;
        r119 = r129.get("conversation_id");
        if (r119 == null) goto L63;
        if (r119.length() != 0) goto L57;
        int r130 = 1;
    L59:
        if ((r130 ^ r106) != 0) goto L62;
        r119 = null;
    L62:
        if (r119 == null) goto L63;
    L102:
        if (r119 != null) goto L104;
        FLogger.f375446a.e("ObricAigcGenerationStateProducer", "ignore task without conversationId, taskId=" + r115.f503979a);
    L104:
        if (r119 != null) goto L106;
        r100 = r100;
        goto L130
    L57:
        r130 = 0;
    L63:
        Map<String, String> r131 = r115.f503995q;
        if (r131 == null) goto L74;
        r119 = r131.get("conversation_id");
        if (r119 == null) goto L74;
        if (r119.length() != 0) goto L70;
        int r132 = 1;
    L72:
        if ((r132 ^ r106) == 0) goto L74;
    L75:
        if (r119 != null) goto L102;
        p r133 = r115.f503989k;
        if (r133 == null) goto L79;
        String r134 = r133.f503961d;
    L80:
        r119 = b(r134);
        if (r119 != null) goto L102;
        List<p> r135 = r115.f503988j;
        if (r135 != null) goto L85;
        r135 = CollectionsKt.emptyList();
    L85:
        r119 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(r135), new k(r100)));
        if (r119 != null) goto L102;
        IAuthModelService r136 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r136 == null) goto L101;
        LiveData<wc9.e> r137 = r136.y();
        if (r137 == null) goto L101;
        wc9.e r138 = r137.getValue();
        if (r138 == null) goto L101;
        r119 = r138.f559198a;
        if (r119 == null) goto L101;
        if (r119.length() <= 0) goto L98;
        boolean r139 = true;
    L99:
        if (r139 == false) goto L101;
    L98:
        r139 = false;
    L101:
        r119 = null;
        goto L102
    L79:
        r134 = null;
        goto L80
    L70:
        r132 = 0;
    L74:
        r119 = null;
        goto L75
    L132:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        final Set r140 = CollectionsKt.toSet(t1.f393353a.getObricAigcGenerationStateConfig().getResolvedSupportedTaskKeys());
        Sequence r141 = SequencesKt.filter(CollectionsKt.asSequence(r111), new j(r140));
        LinkedHashMap r142 = new LinkedHashMap();
        Iterator r143 = r141.iterator();
    L16:
        if (r143.hasNext() == false) goto L18;
        Object r144 = r143.next();
        r142.put(((u) r144).f503979a, r144);
        goto L16
    L18:
        LinkedHashMap r145 = new LinkedHashMap();
        Iterator r146 = r142.entrySet().iterator();
    L20:
        if (r146.hasNext() == false) goto L27;
        Map.Entry r147 = (Map.Entry) r146.next();
        if (((u) r147.getValue()).f503985g != TaskStatus.RUNNING) goto L24;
        boolean r148 = true;
    L25:
        if (r148 == false) goto L20;
        r145.put(r147.getKey(), r147.getValue());
        goto L20
    L24:
        r148 = false;
        goto L25
    L27:
        Set<String> r149 = r100.f393089b.keySet();
        ArrayList r150 = new ArrayList();
        Iterator<T> r151 = r149.iterator();
    L29:
        if (r151.hasNext() == false) goto L33;
        Object r152 = r151.next();
        if ((!r145.containsKey((String) r152)) == false) goto L29;
        r150.add(r152);
        goto L29
    L33:
        Iterator r153 = CollectionsKt.toList(r150).iterator();
    L35:
        if (r153.hasNext() == false) goto L43;
        String r154 = (String) r153.next();
        a r155 = r100.f393089b.remove(r154);
        if (r155 == null) goto L35;
        u r156 = (u) r142.get(r154);
        if (r156 != null) goto L42;
        r156 = r155.f393091b;
    L42:
        FLogger.f375446a.i("ObricAigcGenerationStateProducer", "end taskId=" + r154 + ", taskKey=" + r156.f503998t + ", conversationId=" + r155.f393092c);
        TaskFlowDslKt.c(r155.f393090a, new aha.g.b(r156.f503998t, r156, r155.f393092c, r155.f393093d));
        goto L35
    L43:
        r117 = r145.entrySet().iterator();
    L7:
        r101 = new ObricAigcGenerationStateProducer$handleTaskList$1(r100, r112);
        goto L8
    }
}
