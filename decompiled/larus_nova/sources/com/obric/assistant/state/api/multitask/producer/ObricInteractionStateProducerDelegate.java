package com.obric.assistant.state.api.multitask.producer;

import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J/\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/state/api/multitask/producer/ObricInteractionStateProducerDelegate;", "Lcom/obric/assistant/state/api/multitask/producer/IObricInteractionStateProducerService;", "<init>", "()V", "activateInteraction", "", "ownerId", "", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionStateType;", "ext", "", "", "clearInteractions", "deactivateInteraction", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionStateProducerDelegate implements IObricInteractionStateProducerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricInteractionStateProducerDelegate f392949b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricInteractionStateProducerService f392950a;

    static {
        f392949b = new ObricInteractionStateProducerDelegate();
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        this.f392950a.a(r100);
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void b(String r100, ObricInteractionStateType r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        Intrinsics.checkNotNullParameter(r101, "interactionType");
        Intrinsics.checkNotNullParameter(r102, "ext");
        this.f392950a.b(r100, r101, r102);
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void c(String r100, ObricInteractionStateType r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        Intrinsics.checkNotNullParameter(r101, "interactionType");
        Intrinsics.checkNotNullParameter(r102, "ext");
        this.f392950a.c(r100, r101, r102);
    }

    private ObricInteractionStateProducerDelegate() {
        this.f392950a = (IObricInteractionStateProducerService) ServiceManager.get().getService(IObricInteractionStateProducerService.class);
    }
}
