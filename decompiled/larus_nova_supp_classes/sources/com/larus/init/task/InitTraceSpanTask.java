package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.settings.value.e10;
import com.larus.settings.value.mu;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/init/task/InitTraceSpanTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "TAG", "TRACK_EVENT_PREFIX", "runInternal", XmlPullParser.NO_NAMESPACE, "FlowSpanLogService", "FlowSpanTrackService", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitTraceSpanTask extends d implements bg9.i {
    public final String a;
    public final String b;
    public final String c;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r0 = FLogger.a;
        String r1 = this.b;
        StringBuilder r2 = new StringBuilder("enabled: ");
        e10 r3 = e10.a;
        int r4 = l0.a;
        Boolean r5 = Boolean.TRUE;
        r2.append(((Boolean) l0.a(r5, new mu())).booleanValue());
        r0.d(r1, r2.toString());
        yx9.a.a.getClass();
        yx9.a.a r6 = yx9.a.a.a;
        yx9.d.a.getClass();
        yx9.d.a r7 = yx9.d.a.a;
        a r8 = new a();
        Intrinsics.checkNotNullParameter(r8, "logService");
        b r9 = new b();
        Intrinsics.checkNotNullParameter(r9, "trackService");
        String r10 = this.c;
        Intrinsics.checkNotNullParameter(r10, "trackPrefix");
        boolean r11 = ((Boolean) l0.a(r5, new mu())).booleanValue();
        vx9.b.a.getClass();
        if (vx9.b.c != null) goto L7;
        vx9.b.d = r8;
        vx9.b.e = r9;
        vx9.b.f = r10;
        vx9.b.g = r11;
        return;
    }

    public InitTraceSpanTask() {
        this.a = "Infra";
        this.b = "INIT_TRACE_SPAN_TASK";
        this.c = "flow_trace_";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }
}
