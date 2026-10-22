package com.larus.network.http;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.retrofit2.mime.TypedByteArray;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class x extends TypedByteArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f360200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f360201b;

    @Override // com.bytedance.retrofit2.mime.TypedByteArray, com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public final void writeTo(OutputStream r100) {
        byte[] r101 = new byte[1024];
        ByteArrayInputStream r102 = new ByteArrayInputStream(this.f360200a);
        int r103 = 0;
    L3:
        int r104 = r102.read(r101);
        if (r104 == (-1)) goto L8;
        if (r100 == null) goto L7;
        r100.write(r101, 0, r104);
    L7:
        r103 = r103 + r104;
        this.f360201b.G0((r103 * 100.0f) / this.f360200a.length);
        goto L3
    L8:
        r102.close();
    }

    public x(String r100, byte[] r101, v r102) {
        Intrinsics.checkNotNullParameter(r101, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r102, "changeListener");
        super(r100, r101, new String[0]);
        this.f360200a = r101;
        this.f360201b = r102;
    }
}
