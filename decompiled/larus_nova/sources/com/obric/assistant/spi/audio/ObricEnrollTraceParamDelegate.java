package com.obric.assistant.spi.audio;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0096\u0001J-\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricEnrollTraceParamDelegate;", "Lcom/obric/assistant/spi/audio/IObricEnrollTraceParamService;", "<init>", "()V", "putClickPageEventPara", "", "jsonObject", "Lorg/json/JSONObject;", "currentPage", "", ReportConstant.COMMON_ACTION_TYPE, "enterFrom", "putEnterPageEventPara", "previousPage", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrollTraceParamDelegate implements IObricEnrollTraceParamService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricEnrollTraceParamDelegate f392837b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricEnrollTraceParamService f392838a;

    static {
        f392837b = new ObricEnrollTraceParamDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollTraceParamService
    public final void a(JSONObject r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        this.f392838a.a(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollTraceParamService
    public final void b(JSONObject r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        this.f392838a.b(r100, r101, r102, r103);
    }

    private ObricEnrollTraceParamDelegate() {
        IObricEnrollTraceParamService r100 = (IObricEnrollTraceParamService) ServiceManager.get().getService(IObricEnrollTraceParamService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricEnrollTraceParamServiceImpl();
    L5:
        this.f392838a = r100;
    }
}
