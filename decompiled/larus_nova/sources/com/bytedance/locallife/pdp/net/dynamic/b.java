package com.bytedance.locallife.pdp.net.dynamic;

import com.byted.cast.common.Constants;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends RequestBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f261602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaType f261603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f261604c;

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        String r100 = this.f261604c;
        Charset r101 = Charsets.UTF_8;
        if (r100 == null) goto L7;
        return r100.getBytes(r101).length;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.f261603b;
    }

    public final String toString() {
        return this.f261604c;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        String r101 = this.f261604c;
        Charset r102 = Charsets.UTF_8;
        if (r101 == null) goto L7;
        byte[] r103 = r101.getBytes(r102);
        r100.write(r103, 0, r103.length);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public b(Map<String, String> r100, MediaType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f261602a = r100;
        this.f261603b = r101;
        this.f261604c = r102;
    }
}
