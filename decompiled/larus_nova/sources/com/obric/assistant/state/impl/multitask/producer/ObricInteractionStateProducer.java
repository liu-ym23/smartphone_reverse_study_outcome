package com.obric.assistant.state.impl.multitask.producer;

import aha.n;
import aha.o;
import com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService;
import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0016J.\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J,\u0010\u001b\u001a\u00020\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/ObricInteractionStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowStateProducer;", "Lcom/obric/assistant/state/api/multitask/producer/IObricInteractionStateProducerService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeInteractions", "", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionState;", "Lcom/obric/assistant/state/impl/multitask/producer/ObricInteractionStateProducer$ActiveInteraction;", "interactionsLock", "Lkotlinx/coroutines/sync/Mutex;", "dispatchPolicy", "Lcom/obric/assistant/state/multitask/core/TaskFlowDispatchPolicy;", "activateInteraction", "", "ownerId", "", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionStateType;", "ext", "", "", "deactivateInteraction", "clearInteractions", "endInteraction", DBDefinition.TASK_ID, "ActiveInteraction", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionStateProducer implements jha.j, IObricInteractionStateProducerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f393099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<jha.g<n>, a> f393100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutexImpl f393101c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ObricInteractionStateType f393103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jha.l<n> f393104c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393102a, r101.f393102a) == true) goto L12;
            return false;
        L12:
            if (this.f393103b == r101.f393103b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393104c, r101.f393104c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f393102a.hashCode() * 31) + this.f393103b.hashCode()) * 31) + this.f393104c.hashCode();
        }

        public final String toString() {
            return "ActiveInteraction(ownerId=" + this.f393102a + ", interactionType=" + this.f393103b + ", handle=" + this.f393104c + ')';
        }

        public a(String r100, ObricInteractionStateType r101, jha.l<n> r102) {
            Intrinsics.checkNotNullParameter(r100, "ownerId");
            Intrinsics.checkNotNullParameter(r101, "interactionType");
            Intrinsics.checkNotNullParameter(r102, "handle");
            this.f393102a = r100;
            this.f393103b = r101;
            this.f393104c = r102;
        }
    }

    public ObricInteractionStateProducer() {
        this.f393099a = jha.f.f499128b;
        this.f393100b = new LinkedHashMap();
        this.f393101c = kotlinx.coroutines.sync.b.a();
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f393099a, null, CoroutineStart.UNDISPATCHED, new ObricInteractionStateProducer$clearInteractions$1(this, r100, null), 1, null);
    }

    public static final void d(ObricInteractionStateProducer r100, jha.g r101, Map r102) {
        a r103 = r100.f393100b.remove(r101);
        if (r103 == null) goto L7;
        TaskFlowDslKt.c(r103.f393104c, new n.b(r103.f393102a, r103.f393103b, r102));
        return;
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void b(String r110, ObricInteractionStateType r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r110, "ownerId");
        Intrinsics.checkNotNullParameter(r111, "interactionType");
        Intrinsics.checkNotNullParameter(r112, "ext");
        if (StringsKt.isBlank(r110) == false) goto L5;
        return;
    L5:
        n.a r100 = new n.a(r110, r111, MapsKt.toMap(r112));
        jha.g<n> r101 = o.a(r110, r111);
        BuildersKt.launch$default(this.f393099a, null, CoroutineStart.UNDISPATCHED, new ObricInteractionStateProducer$activateInteraction$1(this, r101, r100, r110, r111, null), 1, null);
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void c(String r100, ObricInteractionStateType r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        Intrinsics.checkNotNullParameter(r101, "interactionType");
        Intrinsics.checkNotNullParameter(r102, "ext");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        Map r103 = MapsKt.toMap(r102);
        jha.g<n> r104 = o.a(r100, r101);
        BuildersKt.launch$default(this.f393099a, null, CoroutineStart.UNDISPATCHED, new ObricInteractionStateProducer$deactivateInteraction$1(this, r104, r103, null), 1, null);
    }
}
