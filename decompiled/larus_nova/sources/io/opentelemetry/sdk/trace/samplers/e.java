package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.trace.SpanKind;
import itc.g;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public interface e {
    String getDescription();

    f shouldSample(io.opentelemetry.context.b r100, String r101, String r102, SpanKind r103, g r104, List<Object> r105);
}
