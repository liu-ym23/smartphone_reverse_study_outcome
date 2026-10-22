package com.bytedance.awemeopen.infra.plugs.applog;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends q64.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f198827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f198829c;

    @Override // q64.d
    public final long c() {
        return this.f198827a.length;
    }

    public final String toString() {
        return "ByteArrayRequestBody(bytes=" + this.f198827a.length + ", fileName=" + this.f198828b + ", realContentType='" + this.f198829c + "')";
    }

    @Override // q64.d
    public final String a() {
        return this.f198829c;
    }

    @Override // q64.d
    public final String b() {
        return this.f198828b;
    }

    public b(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        this.f198827a = r100;
        this.f198828b = null;
        this.f198829c = "application/unknown";
    }

    @Override // q64.d
    public final void d(OutputStream r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
        r100.write(this.f198827a);
    }
}
