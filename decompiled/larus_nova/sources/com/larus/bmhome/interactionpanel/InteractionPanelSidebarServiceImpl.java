package com.larus.bmhome.interactionpanel;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J\f\u0010\n\u001a\u00020\t*\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelSidebarServiceImpl;", "Lcom/larus/bmhome/interactionpanel/IInteractionPanelSidebarService;", "<init>", "()V", "manager", "Lcom/larus/bmhome/interactionpanel/IInteractionPanelQueueManager;", "observeSidebar", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/larus/bmhome/interactionpanel/SidebarPendingSummary;", "toSidebarSummary", "Lcom/larus/bmhome/interactionpanel/InteractionPanelPendingSummary;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionPanelSidebarServiceImpl implements IInteractionPanelSidebarService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f312280c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f312281b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.interactionpanel.IInteractionPanelSidebarService
    public final Flow<List<v0>> a() {
        final StateFlowImpl r100 = this.f312281b.a();
        return new InteractionPanelSidebarServiceImpl$observeSidebar$$inlined$map$1(r100, this);
    }

    public InteractionPanelSidebarServiceImpl() {
        this.f312281b = s.a();
    }
}
