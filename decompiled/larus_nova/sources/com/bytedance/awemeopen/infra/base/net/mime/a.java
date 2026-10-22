package com.bytedance.awemeopen.infra.base.net.mime;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class a extends q64.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f198699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f198701c;

    @Override // q64.d
    public final long c() {
        return this.f198699a.length;
    }

    public final String toString() {
        return "ByteArrayRequestBody(bytes=" + this.f198699a.length + ", fileName=" + this.f198700b + ", realContentType='" + this.f198701c + "')";
    }

    @Override // q64.d
    public final String a() {
        return this.f198701c;
    }

    @Override // q64.d
    public final String b() {
        return this.f198700b;
    }

    public a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        this.f198699a = r100;
        this.f198700b = null;
        this.f198701c = "application/json; charset=UTF-8";
    }

    @Override // q64.d
    public final void d(OutputStream r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
        r100.write(this.f198699a);
    }
}
