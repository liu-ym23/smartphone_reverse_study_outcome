package com.bytedance.awemeopen.infra.base.net.mime;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends q64.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f198702a;

    @Override // q64.d
    public final String a() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // q64.d
    public final String b() {
        return null;
    }

    @Override // q64.d
    public final long c() {
        return this.f198702a.size();
    }

    public b() {
        this.f198702a = new ByteArrayOutputStream();
    }

    @Override // q64.d
    public final void d(OutputStream r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
        r100.write(this.f198702a.toByteArray());
    }
}
