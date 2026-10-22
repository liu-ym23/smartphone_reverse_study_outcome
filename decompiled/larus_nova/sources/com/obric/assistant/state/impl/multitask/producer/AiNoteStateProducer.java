package com.obric.assistant.state.impl.multitask.producer;

import com.larus.audio.AudioServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\t\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/AiNoteStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeRecording", "Lcom/obric/assistant/state/impl/multitask/producer/AiNoteStateProducer$ActiveRecording;", "recordingListener", "com/obric/assistant/state/impl/multitask/producer/AiNoteStateProducer$recordingListener$1", "Lcom/obric/assistant/state/impl/multitask/producer/AiNoteStateProducer$recordingListener$1;", "initProducer", "", "startRecording", "meetingId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endRecording", "reasonExt", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ActiveRecording", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiNoteStateProducer implements TaskFlowAutoInitProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f393034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f393035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AiNoteStateProducer$recordingListener$1 f393036c;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jha.l<aha.b> f393038b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393037a, r101.f393037a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393038b, r101.f393038b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393037a.hashCode() * 31) + this.f393038b.hashCode();
        }

        public final String toString() {
            return "ActiveRecording(meetingId=" + this.f393037a + ", handle=" + this.f393038b + ')';
        }

        public a(String r100, jha.l<aha.b> r101) {
            Intrinsics.checkNotNullParameter(r100, "meetingId");
            Intrinsics.checkNotNullParameter(r101, "handle");
            this.f393037a = r100;
            this.f393038b = r101;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b {
    }

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        FLogger.f375446a.i("AiNoteStateProducer", "initProducer");
        AudioServiceDelegate.f288288a.P().j(this.f393036c);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        FLogger.f375446a.e("AiNoteStateProducer", "failed to add recording status listener", th);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.state.impl.multitask.producer.AiNoteStateProducer$recordingListener$1] */
    public AiNoteStateProducer() {
        ExecutorCoroutineDispatcher r100 = jha.f.f499127a;
        this.f393034a = jha.f.f499128b;
        this.f393036c = new AiNoteStateProducer$recordingListener$1(this);
    }

    public static final Unit a(AiNoteStateProducer r100, Map r101) {
        a r102 = r100.f393035b;
        if (r102 != null) goto L5;
        FLogger.f375446a.i("AiNoteStateProducer", "endRecording ignored, no active recording");
        return Unit.INSTANCE;
    L5:
        r100.f393035b = null;
        TaskFlowDslKt.c(r102.f393038b, new aha.b.a(r102.f393037a, r101));
        return Unit.INSTANCE;
    }

    public static final Object b(AiNoteStateProducer r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof AiNoteStateProducer$startRecording$1) == false) goto L7;
        AiNoteStateProducer$startRecording$1 r103 = (AiNoteStateProducer$startRecording$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        aha.b.C0069b r108 = (aha.b.C0069b) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
        aha.b.C0069b r110 = r108;
        r101 = r109;
    L19:
        jha.m r111 = (jha.m) r105;
        if (r111 != null) goto L22;
        FLogger.f375446a.e("AiNoteStateProducer", "startRecording failed to acquire task handle");
        return Unit.INSTANCE;
    L22:
        r100.f393035b = new a(r101, r111.f499141a);
        if (r111.f499142b == true) goto L27;
        TaskFlowDslKt.f(r111.f499141a, r110);
    L27:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        aha.a r112 = aha.a.f3460a;
        int r113 = com.obric.assistant.state.multitask.ext.f.f393299a;
        jha.g r114 = TaskFlowDslKt.b(r112, "ai_note_singleton");
        r110 = new aha.b.C0069b(r101);
        a r115 = r100.f393035b;
        if (r115 != null) goto L25;
        jha.c r116 = jha.j.a.a(r100);
        r103.L$0 = r101;
        r103.L$1 = r110;
        r103.label = 1;
        r105 = TaskFlowDslKt.e(r114, r110, r116, r103);
        if (r105 != r106) goto L19;
        return r106;
    L25:
        FLogger.f375446a.w("AiNoteStateProducer", "startRecording while another recording is active, previous=" + r115.f393037a + ", new=" + r101 + ", fallback to update");
        jha.l<aha.b> r117 = r115.f393038b;
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r117, "handle");
        r100.f393035b = new a(r101, r117);
        TaskFlowDslKt.f(r115.f393038b, r110);
    L7:
        r103 = new AiNoteStateProducer$startRecording$1(r100, r102);
        goto L8
    }
}
