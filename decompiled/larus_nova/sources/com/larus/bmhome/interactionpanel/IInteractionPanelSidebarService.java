package com.larus.bmhome.interactionpanel;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/interactionpanel/IInteractionPanelSidebarService;", "", "observeSidebar", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/larus/bmhome/interactionpanel/SidebarPendingSummary;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IInteractionPanelSidebarService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f312256a = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/interactionpanel/IInteractionPanelSidebarService$Companion;", "Lcom/larus/bmhome/interactionpanel/IInteractionPanelSidebarService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/bmhome/interactionpanel/IInteractionPanelSidebarService;", "impl$delegate", "Lkotlin/Lazy;", "observeSidebar", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/larus/bmhome/interactionpanel/SidebarPendingSummary;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IInteractionPanelSidebarService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f312257b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IInteractionPanelSidebarService> f312258c = null;

        private Companion() {
        }

        static {
            f312257b = new Companion();
            f312258c = LazyKt.lazy(new h());
        }

        @Override // com.larus.bmhome.interactionpanel.IInteractionPanelSidebarService
        public final Flow<List<v0>> a() {
            IInteractionPanelSidebarService r100 = f312258c.getValue();
            if (r100 == null) goto L7;
            Flow<List<v0>> r101 = r100.a();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return i.f312354a;
        }
    }

    static {
        f312256a = Companion.f312257b;
    }

    Flow<List<v0>> a();
}
