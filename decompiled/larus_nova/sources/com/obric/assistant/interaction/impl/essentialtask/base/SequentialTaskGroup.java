package com.obric.assistant.interaction.impl.essentialtask.base;

import android.content.Context;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\rH\u0094@¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/SequentialTaskGroup;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "taskName", "", "taskList", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "getTaskList", "()Ljava/util/List;", "internalExecute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalNeedExecute", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SequentialTaskGroup extends EssentialTask {
    public static final Companion Companion = null;
    private static final String TAG = "EssentialTaskSequentialTaskGroup";
    private final List<EssentialTask> taskList;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/SequentialTaskGroup$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.base.SequentialTaskGroup$internalExecute$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.SequentialTaskGroup", f = "SequentialTaskGroup.kt", i = {0, 0}, l = {24}, m = "internalExecute", n = {"subTask", DyPayConstant.KEY_START_TIME}, s = {"L$2", "J$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SequentialTaskGroup this$0;

        public AnonymousClass1(SequentialTaskGroup r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.internalExecute(this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask
    public boolean internalNeedExecute() {
        List<EssentialTask> r100 = this.taskList;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((EssentialTask) r101.next()).needExecute() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    public final List<EssentialTask> getTaskList() {
        return this.taskList;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bf -> B:48:0x00c8). Please report as a decompilation issue!!! */
    @Override // com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask
    public Object internalExecute(Continuation<? super ExecuteResult> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        long r104 = r100.J$0;
        EssentialTask r105 = (EssentialTask) r100.L$2;
        Iterator r106 = (Iterator) r100.L$1;
        Iterable r112 = (Iterable) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L44
        Iterable r113 = r112;
        Iterator r114 = r106;
        long r107 = r104;
        EssentialTask r108 = r105;
        Object r109 = r102;
        AnonymousClass1 r115 = r100;
        SequentialTaskGroup r116 = this;
    L48:
        ExecuteResult r117 = (ExecuteResult) r111;     // Catch: Throwable -> L37
        if (r117.isSuccess() == true) goto L36;
        FLogger r118 = FLogger.f375446a;     // Catch: Throwable -> L37
        r118.w(TAG, "task " + r108 + " execute failed");     // Catch: Throwable -> L37
        r118.i(TAG, "SequentialTaskGroup " + r116.getTaskName() + " finished. execute time: " + (SystemClock.elapsedRealtime() - r107));
        return r117;
    L36:
        SequentialTaskGroup r119 = r116;
        r100 = r115;
        r102 = r109;
        long r120 = r107;
        Iterator r121 = r114;
        Iterable r122 = r113;
    L51:
    L42:
        th = move-exception;
        r116 = r119;
        th = th;
    L46:
        FLogger.f375446a.i(TAG, "SequentialTaskGroup " + r116.getTaskName() + " finished. execute time: " + (SystemClock.elapsedRealtime() - r120));
        throw th;
    L26:
        if (r121.hasNext() == false) goto L39;
        EssentialTask r123 = (EssentialTask) r121.next();     // Catch: Throwable -> L42
        r100.L$0 = r122;     // Catch: Throwable -> L42
        r100.L$1 = r121;     // Catch: Throwable -> L42
        r100.L$2 = r123;     // Catch: Throwable -> L42
        r100.J$0 = r120;     // Catch: Throwable -> L42
        r100.label = 1;     // Catch: Throwable -> L42
        Object r124 = r123.execute(r100);     // Catch: Throwable -> L42
        if (r124 != r102) goto L30;
        return r102;
    L30:
        AnonymousClass1 r125 = r100;
        r116 = r119;
        r111 = r124;
        r113 = r122;
        r114 = r121;
        r107 = r120;
        r108 = r123;
        r109 = r102;
        r115 = r125;
        goto L48
    L39:
        List r126 = (List) r122;     // Catch: Throwable -> L42
        FLogger.f375446a.i(TAG, "SequentialTaskGroup " + r119.getTaskName() + " finished. execute time: " + (SystemClock.elapsedRealtime() - r120));
        return new ExecuteResult.Succeed();
    L37:
        th = th;
        r120 = r107;
        goto L46
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r111);
        FLogger.f375446a.i(TAG, "SequentialTaskGroup " + getTaskName() + " start execute. taskList size: " + this.taskList.size());
        r120 = SystemClock.elapsedRealtime();
        List<EssentialTask> r127 = this.taskList;     // Catch: Throwable -> L44
        ArrayList r128 = new ArrayList();     // Catch: Throwable -> L44
        Iterator<T> r129 = r127.iterator();     // Catch: Throwable -> L44
    L19:
        if (r129.hasNext() == false) goto L24;
        Object r130 = r129.next();     // Catch: Throwable -> L44
        if (((EssentialTask) r130).needExecute() == false) goto L19;
        r128.add(r130);     // Catch: Throwable -> L44
        goto L19
    L24:
        r121 = r128.iterator();     // Catch: Throwable -> L44
        r122 = r128;
        r119 = this;
    L44:
        th = th;
        r116 = this;
    L7:
        r100 = new AnonymousClass1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SequentialTaskGroup(Context r100, String r101, List<? extends EssentialTask> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Intrinsics.checkNotNullParameter(r102, "taskList");
        super(r100, r101);
        this.taskList = r102;
    }
}
