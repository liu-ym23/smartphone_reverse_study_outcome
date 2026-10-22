package com.obric.assistant.state.api.v2;

import bha.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "即将删除或移走，平台化的思路下，不允许豆包模块调用O模块，O模块间的调用API放到O模块下")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/assistant/state/api/v2/ObricStateService;", "Lcom/obric/assistant/state/api/v2/IObricStateApi;", "<init>", "()V", "impl", "isRealtimeCalling", "", "registerRealtimeCallStateObserver", "", "observer", "Lcom/obric/assistant/state/api/v2/RealtimeCallStateObserver;", "unregisterRealtimeCallStateObserver", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStateService implements IObricStateApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricStateService f392961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IObricStateApi f392962b = null;

    private ObricStateService() {
    }

    static {
        f392961a = new ObricStateService();
        f392962b = (IObricStateApi) ServiceManager.get().getService(IObricStateApi.class);
    }

    @Override // com.obric.assistant.state.api.v2.IObricStateApi
    public final boolean a() {
        IObricStateApi r100 = f392962b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.obric.assistant.state.api.v2.IObricStateApi
    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        IObricStateApi r101 = f392962b;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
