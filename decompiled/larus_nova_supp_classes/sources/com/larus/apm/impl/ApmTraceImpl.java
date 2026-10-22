package com.larus.apm.impl;

import android.util.EventsUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.crash.Npth;
import com.larus.apm.api.IApmTrace;
import com.larus.applog.api.IApplog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import st3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J,\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/apm/impl/ApmTraceImpl;", "Lcom/larus/apm/api/IApmTrace;", "<init>", "()V", "addPerfTag", XmlPullParser.NO_NAMESPACE, "key", XmlPullParser.NO_NAMESPACE, "value", "addTag", "traceAll", "reportApmEvent", "category", "Lorg/json/JSONObject;", "metric", "extra", "reportTeaEvent", "startApmScene", "scene", "stopApmScene", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ApmTraceImpl implements IApmTrace {
    public ApmTraceImpl() {
    }

    @Override // com.larus.apm.api.IApmTrace
    public final void b() {
        Intrinsics.checkNotNullParameter("TYPEWRITER", "key");
        Intrinsics.checkNotNullParameter("STOP", "value");
        ApmAgent.addPerfTag("TYPEWRITER", "STOP");
    }

    @Override // com.larus.apm.api.IApmTrace
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        a.b().d(r2);
    }

    @Override // com.larus.apm.api.IApmTrace
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        a.b().c(r2);
    }

    @Override // com.larus.apm.api.IApmTrace
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        Npth.addTag(r2, r3);
    }

    @Override // com.larus.apm.api.IApmTrace
    public final void c(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        IApplog.a.reportEvent(r2, r3);
    }

    @Override // com.larus.apm.api.IApmTrace
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        ApmAgent.addPerfTag(r2, r3);
        Npth.addTag(r2, r3);
    }

    @Override // com.larus.apm.api.IApmTrace
    public final void f(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "category");
        ApmAgent.monitorEvent(r2, r3, r4, r5);
    }
}
