package com.bytedance.lark.lark_bitable_android;

import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.FuncParamsX5f7e843510e32e23;
import lark_bitable.proto.FuncParamsX6a546484e25fe16c;
import okio.ByteString;

/* JADX INFO: loaded from: classes43.dex */
public final class u0 implements t0, q0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f253117b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0 f253118a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_bitable_android.t0
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordData");
        this.f253118a.a(r100);
    }

    @Override // com.bytedance.lark.lark_bitable_android.t0
    public final void b(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f253118a.b(r100, r101);
    }

    public u0(yo4.a r100) {
        this.f253118a = r100;
    }

    @Override // com.bytedance.lark.lark_bitable_android.q0
    public final BufferCallStatus c(long r100, RustBuffer.ByValue r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != (-5762565832228033837L)) goto L10;
        ProtoAdapter<FuncParamsX5f7e843510e32e23> r102 = FuncParamsX5f7e843510e32e23.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r103 = RustBuffer.a.b(r101);
        Intrinsics.checkNotNull(r103);
        FuncParamsX5f7e843510e32e23 r104 = r102.decode(r103);
        NativeLib.Companion r105 = NativeLib.Companion;
        ByteString r106 = r104._molten_ctx;
        r105.getClass();
        a(r104.record_data);     // Catch: Exception -> L7
        BufferCallStatus r107 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L7
    L8:
        NativeLib.Companion.getClass();
        return r107;
    L7:
        BufferCallStatus.Companion.getClass();
        r107 = BufferCallStatus.Companion.a("");
        goto L8
    L10:
        if (r100 != (-261539941716752714L)) goto L16;
        ProtoAdapter<FuncParamsX6a546484e25fe16c> r108 = FuncParamsX6a546484e25fe16c.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r109 = RustBuffer.a.b(r101);
        Intrinsics.checkNotNull(r109);
        FuncParamsX6a546484e25fe16c r110 = r108.decode(r109);
        NativeLib.Companion r111 = NativeLib.Companion;
        ByteString r112 = r110._molten_ctx;
        r111.getClass();
        b(r110.error_code.longValue(), r110.msg);     // Catch: Exception -> L14
        BufferCallStatus r113 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L14
    L15:
        NativeLib.Companion.getClass();
        return r113;
    L14:
        BufferCallStatus.Companion.getClass();
        r113 = BufferCallStatus.Companion.a("");
        goto L15
    L16:
        String r114 = "Unknown method[" + r100 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r114);
    }
}
