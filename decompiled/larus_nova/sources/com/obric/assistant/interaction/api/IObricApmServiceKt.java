package com.obric.assistant.interaction.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"ObricApmServiceDelegate", "Lcom/obric/assistant/interaction/api/IObricApmService;", "getObricApmServiceDelegate", "()Lcom/obric/assistant/interaction/api/IObricApmService;", "ObricApmServiceDelegate$delegate", "Lkotlin/Lazy;", "api_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IObricApmServiceKt {
    private static final Lazy ObricApmServiceDelegate$delegate = null;

    public static /* synthetic */ IObricApmService a() {
        return ObricApmServiceDelegate_delegate$lambda$0();
    }

    static {
        ObricApmServiceDelegate$delegate = LazyKt.lazy(new d());
    }

    private static final IObricApmService ObricApmServiceDelegate_delegate$lambda$0() {
        return (IObricApmService) ServiceManager.get().getService(IObricApmService.class);
    }

    public static final IObricApmService getObricApmServiceDelegate() {
        return (IObricApmService) ObricApmServiceDelegate$delegate.getValue();
    }
}
