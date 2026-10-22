package com.bytedance.lark.lark_rust_sdk_integrator_android;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/io/OutputStream;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class BufferCallStatus$Companion$panic$1 extends Lambda implements Function1<OutputStream, Unit> {
    final /* synthetic */ byte[] $bytes;

    public BufferCallStatus$Companion$panic$1(byte[] r1) {
        this.$bytes = r1;
        super(1);
    }

    public final void invoke(OutputStream r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.write(this.$bytes);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((OutputStream) r1);
        return Unit.INSTANCE;
    }
}
