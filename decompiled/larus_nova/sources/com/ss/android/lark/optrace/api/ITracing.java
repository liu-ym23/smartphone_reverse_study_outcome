package com.ss.android.lark.optrace.api;

import com.ss.android.lark.optrace.extension.TracingExtension;
import com.ss.android.lark.optrace.extension.TracingExtensionEnum;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public interface ITracing extends Serializable {
    void addExtension(TracingExtensionEnum r100, TracingExtension r101);

    long clientDuration(String r100);

    void clientDurationEndAll();

    long clientDurationTagEnd(String r100);

    void clientDurationTagStart(String r100);

    long createTime();

    String getRequestId();

    String getTracingID();

    void setRequestId(String r100);
}
