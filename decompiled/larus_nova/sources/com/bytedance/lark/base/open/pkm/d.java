package com.bytedance.lark.base.open.pkm;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.ProtoAdapter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import open_pkm.proto.FuncParamsXaca3906521a30e25;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements c, g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f252894b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f252895a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.base.open.pkm.c
    public final void onEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        this.f252895a.onEvent(r100, r101);
    }

    public d(c r100) {
        this.f252895a = r100;
    }

    @Override // com.bytedance.lark.base.open.pkm.g
    public final BufferCallStatus a(long r100, RustBuffer.ByValue r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != 8676999426260406052L) goto L9;
        ProtoAdapter<FuncParamsXaca3906521a30e25> r102 = FuncParamsXaca3906521a30e25.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r103 = RustBuffer.a.b(r101);
        Intrinsics.checkNotNull(r103);
        FuncParamsXaca3906521a30e25 r104 = r102.decode(r103);
        NativeLib.Companion r105 = NativeLib.Companion;
        ByteString r106 = r104._molten_ctx;
        r105.getClass();
        onEvent(r104.event, r104.payload);     // Catch: Exception -> L7
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
    L9:
        String r110 = "Unknown method[" + r100 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r110);
    }
}
