package com.larus.trace.tracespan.span;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements b {
    @Override // com.larus.trace.tracespan.span.b
    public final String a() {
        return "empty";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void cancel(boolean r100) {
    }

    @Override // com.larus.trace.tracespan.span.b
    public final b d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        return this;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String f() {
        return "empty";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void g(Integer r100, String r101) {
    }

    @Override // com.larus.trace.tracespan.span.b
    public final b getParent() {
        return null;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String getTag() {
        return "empty";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String getTraceId() {
        return "empty";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final boolean hasEnd() {
        return true;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void setTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    public a() {
    }
}
