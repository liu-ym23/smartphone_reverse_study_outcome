package com.bytedance.lark.ccm_nexus_android;

import ccm_nexus.proto.FuncParamsXe6545313fa89638d;
import ccm_nexus.proto.FuncReturnX3dc8b8542df1cbb1;
import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;

/* JADX INFO: loaded from: classes17.dex */
public final class f implements e, k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f252913b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f252914a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.ccm_nexus_android.e
    public final boolean b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "rawData");
        return this.f252914a.b(r100, r101);
    }

    public f(e r100) {
        this.f252914a = r100;
    }

    @Override // com.bytedance.lark.ccm_nexus_android.k
    public final BufferCallStatus a(long r100, RustBuffer.ByValue r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != (-2823504293631739557L)) goto L9;
        ProtoAdapter<FuncParamsXe6545313fa89638d> r102 = FuncParamsXe6545313fa89638d.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r103 = RustBuffer.a.b(r101);
        Intrinsics.checkNotNull(r103);
        FuncParamsXe6545313fa89638d r104 = r102.decode(r103);
        NativeLib.Companion r105 = NativeLib.Companion;
        ByteString r106 = r104._molten_ctx;
        r105.getClass();
        final FuncReturnX3dc8b8542df1cbb1 r107 = new FuncReturnX3dc8b8542df1cbb1(Boolean.valueOf(b(r104.module, r104.raw_data)), null);     // Catch: Exception -> L7
        RustBuffer.ByValue r108 = g.a(FuncReturnX3dc8b8542df1cbb1.ADAPTER.encodedSize(r107), new CcmNexusPushCallbackProxy$invokeOnPushReceivedXf44a395b$rustBuf$1(r107));     // Catch: Exception -> L7
        BufferCallStatus.Companion.getClass();     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r108, "data");     // Catch: Exception -> L7
        BufferCallStatus r109 = new BufferCallStatus(0, r108);     // Catch: Exception -> L7
    L8:
        NativeLib.Companion.getClass();
        return r109;
    L7:
        BufferCallStatus.Companion.getClass();
        Intrinsics.checkNotNullParameter("", "msg");
        final byte[] r110 = "".getBytes(Charsets.UTF_8);
        r109 = new BufferCallStatus(2, g.a(r110.length, new BufferCallStatus$Companion$panic$1(r110)));
        goto L8
    L9:
        String r111 = "Unknown method[" + r100 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        Intrinsics.checkNotNullParameter(r111, "msg");
        final byte[] r112 = r111.getBytes(Charsets.UTF_8);
        return new BufferCallStatus(2, g.a(r112.length, new BufferCallStatus$Companion$panic$1(r112)));
    }
}
