package com.bytedance.lark.open_app_android;

import com.squareup.wire.ProtoAdapter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import open_app.proto.FuncParamsX310f8ba646d34cdb;
import open_app.proto.FuncParamsX3f39ac3f95fbfef9;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements d, h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f253424b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f253425a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.open_app_android.d
    public final void onFailed(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        this.f253425a.onFailed(r100, r101);
    }

    @Override // com.bytedance.lark.open_app_android.d
    public final void onSuccess(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f253425a.onSuccess(r100);
    }

    public e(d r100) {
        this.f253425a = r100;
    }

    @Override // com.bytedance.lark.open_app_android.h
    public final BufferCallStatus a(long r100, RustBuffer.ByValue r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != (-5091960232379487529L)) goto L10;
        ProtoAdapter<FuncParamsX3f39ac3f95fbfef9> r102 = FuncParamsX3f39ac3f95fbfef9.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r103 = RustBuffer.a.b(r101);
        Intrinsics.checkNotNull(r103);
        FuncParamsX3f39ac3f95fbfef9 r104 = r102.decode(r103);
        NativeLib.Companion r105 = NativeLib.Companion;
        ByteString r106 = r104._molten_ctx;
        r105.getClass();
        onSuccess(r104.data);     // Catch: Exception -> L7
        BufferCallStatus.Companion r107 = BufferCallStatus.Companion;     // Catch: Exception -> L7
        RustBuffer.ByValue r108 = new RustBuffer.ByValue();     // Catch: Exception -> L7
        r107.getClass();     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r108, "data");     // Catch: Exception -> L7
        BufferCallStatus r109 = new BufferCallStatus(0, r108);     // Catch: Exception -> L7
    L8:
        NativeLib.Companion.getClass();
        return r109;
    L7:
        BufferCallStatus.Companion.getClass();
        r109 = BufferCallStatus.Companion.a("");
        goto L8
    L10:
        if (r100 != (-920892131232469726L)) goto L16;
        ProtoAdapter<FuncParamsX310f8ba646d34cdb> r110 = FuncParamsX310f8ba646d34cdb.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r111 = RustBuffer.a.b(r101);
        Intrinsics.checkNotNull(r111);
        FuncParamsX310f8ba646d34cdb r112 = r110.decode(r111);
        NativeLib.Companion r113 = NativeLib.Companion;
        ByteString r114 = r112._molten_ctx;
        r113.getClass();
        onFailed(r112.error_code.intValue(), r112.error_msg);     // Catch: Exception -> L14
        BufferCallStatus.Companion r115 = BufferCallStatus.Companion;     // Catch: Exception -> L14
        RustBuffer.ByValue r116 = new RustBuffer.ByValue();     // Catch: Exception -> L14
        r115.getClass();     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r116, "data");     // Catch: Exception -> L14
        BufferCallStatus r117 = new BufferCallStatus(0, r116);     // Catch: Exception -> L14
    L15:
        NativeLib.Companion.getClass();
        return r117;
    L14:
        BufferCallStatus.Companion.getClass();
        r117 = BufferCallStatus.Companion.a("");
        goto L15
    L16:
        String r118 = "Unknown method[" + r100 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r118);
    }
}
