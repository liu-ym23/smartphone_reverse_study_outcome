package com.larus.extension.diversion.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J!\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/larus/extension/diversion/api/HostDiversionServiceDelegate;", "Lcom/larus/extension/diversion/api/IHostDiversionService;", "<init>", "()V", "isAppInstalled", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "jumpToMarket", "", "jumpToMarketOrFlowApp", "openFlowApp", "showDialog", "extraMobParams", "Lorg/json/JSONObject;", "mobClick", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HostDiversionServiceDelegate implements IHostDiversionService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HostDiversionServiceDelegate f342903b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IHostDiversionService f342904a;

    static {
        f342903b = new HostDiversionServiceDelegate();
    }

    @Override // com.larus.extension.diversion.api.IHostDiversionService
    public final void a(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "extraMobParams");
        this.f342904a.a(r100, r101);
    }

    private HostDiversionServiceDelegate() {
        IHostDiversionService r100 = (IHostDiversionService) ServiceManager.get().getService(IHostDiversionService.class);
        if (r100 != null) goto L5;
        r100 = new HostDiversionServiceNoop();
    L5:
        this.f342904a = r100;
    }
}
