package com.obric.assistant.audio;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.obric.assistant.spi.audio.IObricEnrollTraceParamService;
import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/audio/ObricEnrollTraceParamServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricEnrollTraceParamService;", "<init>", "()V", "putEnterPageEventPara", "", "jsonObject", "Lorg/json/JSONObject;", "currentPage", "", "previousPage", "enterFrom", "putClickPageEventPara", ReportConstant.COMMON_ACTION_TYPE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrollTraceParamServiceImpl implements IObricEnrollTraceParamService {
    public ObricEnrollTraceParamServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollTraceParamService
    public final void a(JSONObject r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        IObricTraceParam r104 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollTraceParamService
    public final void b(JSONObject r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        IObricTraceParam r104 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r104 == null) goto L6;
        r104.b(r100, r101, r102, r103);
        return;
    }
}
