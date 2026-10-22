package com.bytedance.ttcnpa;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tt_cnpa_sdk.proto.FuncParamsXa8ad6510a6f5e22c;
import tt_cnpa_sdk.proto.FuncReturnX761cd52bf4d57b0f;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ttcnpa_release"}, k = 2, mv = {1, 7, 1})
public final class Tt_cnpa_sdkKt {
    public static final TtCnpaResult b(tt_cnpa_sdk.proto.TtCnpaResult r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        long r100 = r110.error_code.longValue();
        String r101 = r110.error_desc;
        tt_cnpa_sdk.proto.TtCnpaManifest r102 = r110.result_manifest;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        return new TtCnpaResult(r100, r101, new TtCnpaManifest(r102.label, r102.content_producer, r102.produce_id, r102.reserved_code1, r102.content_propagator, r102.propagate_id, r102.reserved_code2), r110.raw_json_manifest);
    }

    public static final TtCnpaManager a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter("", "localConfigDir");
        Intrinsics.checkNotNullParameter(r100, "contentProducer");
        Intrinsics.checkNotNullParameter(r101, "contentPropagator");
        FuncParamsXa8ad6510a6f5e22c r103 = new FuncParamsXa8ad6510a6f5e22c("", r100, r101, Boolean.valueOf(r102));
        int r104 = FuncParamsXa8ad6510a6f5e22c.ADAPTER.encodedSize(r103);
        if (r104 <= 0) goto L5;
        ByteBuffer r105 = ByteBuffer.allocateDirect(r104);
        r103.encode(new ByteBufferOutputStream(r105));
    L6:
        MoltenFfiTtCnpaSdk.f271033a.getClass();
        ByteBuffer r106 = MoltenFfiTtCnpaSdk.MoltenFfiNativeCreateTtcnpaManagerX6049856645594224295(r105);
        if (r106 != null) goto L9;
        InputStream r107 = new ByteArrayInputStream(new byte[0]);
    L18:
        Long r108 = FuncReturnX761cd52bf4d57b0f.ADAPTER.decode(r107).ret;     // Catch: Exception -> L12
    L14:
        if (r106 == null) goto L17;
        MoltenFfiTtCnpaSdk.f271033a.getClass();
        MoltenFfiTtCnpaSdk.freeNativeMemory(r106);
    L17:
        return new TtCnpaManager(new ArcHandle.LongHandle(r108.longValue()));
    L12:
        e = move-exception;
        e.printStackTrace();
        r108 = FuncReturnX761cd52bf4d57b0f.ADAPTER.decode(new byte[0]).ret;
        goto L14
    L9:
        Intrinsics.checkNotNull(r106);
        r107 = new ByteBufferInputStream(r106);
        goto L18
    L5:
        r105 = ByteBuffer.allocateDirect(0);
        goto L6
    }
}
