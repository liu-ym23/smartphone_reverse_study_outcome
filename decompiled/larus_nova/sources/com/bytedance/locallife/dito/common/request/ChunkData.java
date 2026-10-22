package com.bytedance.locallife.dito.common.request;

import com.google.gson.Gson;
import java.io.InputStream;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class ChunkData {
    private final Lazy charset$delegate;
    private Object data;
    private final Map<String, Object> extra;
    private final int index;
    private final InputStream inputStream;
    private final String mimeType;
    private final InputStream originStream;

    public abstract <T> T covert(Gson r100, Class<T> r101);

    public final String getCharset() {
        return (String) this.charset$delegate.getValue();
    }

    public final Object getData() {
        return this.data;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final int getIndex() {
        return this.index;
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final InputStream getOriginStream() {
        return this.originStream;
    }

    public final /* synthetic */ <R> R autoConvert(Gson r100) {
        Intrinsics.reifiedOperationMarker(4, "R");
        return (R) covert(r100, Object.class);
    }

    public final void setData(Object r100) {
        this.data = r100;
    }

    public ChunkData(int r100, InputStream r101, String r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "originStream");
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.index = r100;
        this.originStream = r101;
        this.mimeType = r102;
        this.extra = r103;
        this.inputStream = r101;
        this.charset$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ChunkData$charset$2(this));
    }

    public static /* synthetic */ Object autoConvert$default(ChunkData r100, Gson r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        Intrinsics.reifiedOperationMarker(4, "R");
        return r100.covert(r101, Object.class);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoConvert");
    }
}
