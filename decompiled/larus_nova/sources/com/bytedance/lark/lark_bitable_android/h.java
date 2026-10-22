package com.bytedance.lark.lark_bitable_android;

import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.BitableMarketplaceInstallResult;
import lark_bitable.proto.FuncParamsXdcd35689da80097a;
import okio.ByteString;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements g, q0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f253039b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f253040a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_bitable_android.g
    public final void a(i r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        this.f253040a.a(r100, r101, r102);
    }

    public h(us4.p r100) {
        this.f253040a = r100;
    }

    @Override // com.bytedance.lark.lark_bitable_android.q0
    public final BufferCallStatus c(long r100, RustBuffer.ByValue r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != (-4311183418244402384L)) goto L13;
        ProtoAdapter<FuncParamsXdcd35689da80097a> r102 = FuncParamsXdcd35689da80097a.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r103 = RustBuffer.a.b(r101);
        Intrinsics.checkNotNull(r103);
        FuncParamsXdcd35689da80097a r104 = r102.decode(r103);
        NativeLib.Companion r105 = NativeLib.Companion;
        ByteString r106 = r104._molten_ctx;
        r105.getClass();
        BitableMarketplaceInstallResult r107 = r104.data;     // Catch: Exception -> L11
        if (r107 == null) goto L8;
        Intrinsics.checkNotNullParameter(r107, "<this>");     // Catch: Exception -> L11
        i r108 = new i(r107.url, r107.base_app_token);     // Catch: Exception -> L11
    L9:
        a(r108, r104.error_code.longValue(), r104.msg);     // Catch: Exception -> L11
        BufferCallStatus r109 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L11
    L12:
        NativeLib.Companion.getClass();
        return r109;
    L8:
        r108 = null;
    L11:
        BufferCallStatus.Companion.getClass();
        r109 = BufferCallStatus.Companion.a("");
        goto L12
    L13:
        String r110 = "Unknown method[" + r100 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r110);
    }
}
