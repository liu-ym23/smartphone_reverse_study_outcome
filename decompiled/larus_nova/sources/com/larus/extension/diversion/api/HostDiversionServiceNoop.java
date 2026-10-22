package com.larus.extension.diversion.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/extension/diversion/api/HostDiversionServiceNoop;", "Lcom/larus/extension/diversion/api/IHostDiversionService;", "<init>", "()V", "jumpToMarket", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "openFlowApp", "isAppInstalled", "", "jumpToMarketOrFlowApp", "showDialog", "extraMobParams", "Lorg/json/JSONObject;", "mobClick", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HostDiversionServiceNoop implements IHostDiversionService {
    public HostDiversionServiceNoop() {
    }

    @Override // com.larus.extension.diversion.api.IHostDiversionService
    public final void a(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "extraMobParams");
    }
}
