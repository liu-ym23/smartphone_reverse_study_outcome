package com.bytedance.lark.base.open.pkm;

import com.squareup.wire.ProtoAdapter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import open_pkm.proto.FuncParamsXaca3906521a30e25;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class d implements c, g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7227b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7228a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.base.open.pkm.c
    public final void onEvent(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "payload");
        this.f7228a.onEvent(r2, r3);
    }

    public d(c r1) {
        this.f7228a = r1;
    }

    @Override // com.bytedance.lark.base.open.pkm.g
    public final BufferCallStatus a(long r4, RustBuffer.ByValue r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r4 != 8676999426260406052L) goto L9;
        ProtoAdapter r5 = FuncParamsXaca3906521a30e25.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r7 = RustBuffer.a.b(r6);
        Intrinsics.checkNotNull(r7);
        FuncParamsXaca3906521a30e25 r8 = (FuncParamsXaca3906521a30e25) r5.decode(r7);
        NativeLib.Companion r9 = NativeLib.Companion;
        ByteString r10 = r8._molten_ctx;
        r9.getClass();
        onEvent(r8.event, r8.payload);     // Catch: Exception -> L7
        BufferCallStatus.Companion r11 = BufferCallStatus.Companion;     // Catch: Exception -> L7
        RustBuffer.ByValue r12 = new RustBuffer.ByValue();     // Catch: Exception -> L7
        r11.getClass();     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r12, "data");     // Catch: Exception -> L7
        BufferCallStatus r13 = new BufferCallStatus(0, r12);     // Catch: Exception -> L7
    L8:
        NativeLib.Companion.getClass();
        return r13;
    L7:
        BufferCallStatus.Companion.getClass();
        r13 = BufferCallStatus.Companion.a("");
        goto L8
    L9:
        String r14 = "Unknown method[" + r4 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r14);
    }
}
