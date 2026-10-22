package com.ss.android.lark.optrace.api;

import com.ss.android.lark.optrace.extension.TracingExtension;
import com.ss.android.lark.optrace.extension.TracingExtensionEnum;
import hyb.a;
import hyb.b;
import java.io.Serializable;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes37.dex */
public interface TracingCoreSpan extends Serializable, ITracing, a {
    /* synthetic */ void addExtension(TracingExtensionEnum r100, TracingExtension r101);

    /* synthetic */ long clientDuration(String r100);

    /* synthetic */ void clientDurationEndAll();

    /* synthetic */ long clientDurationTagEnd(String r100);

    /* synthetic */ void clientDurationTagStart(String r100);

    /* synthetic */ long createTime();

    /* synthetic */ void d(String r100, Object... r101);

    /* synthetic */ void e(String r100, Object... r101);

    @Deprecated(message = "use subTrace")
    TracingCoreSpan generateSpan();

    /* synthetic */ String getRequestId();

    /* synthetic */ String getTracingID();

    /* synthetic */ void i(String r100, Object... r101);

    /* synthetic */ <T> void linkTracing(ITracing r100, T r101, b<T> r102);

    /* synthetic */ void setRequestId(String r100);

    TracingCoreSpan subTrace();

    /* synthetic */ void w(String r100, Object... r101);
}
