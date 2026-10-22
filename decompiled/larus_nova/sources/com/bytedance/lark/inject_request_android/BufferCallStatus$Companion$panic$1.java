package com.bytedance.lark.inject_request_android;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/io/OutputStream;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class BufferCallStatus$Companion$panic$1 extends Lambda implements Function1<OutputStream, Unit> {
    final /* synthetic */ byte[] $bytes;

    public BufferCallStatus$Companion$panic$1(byte[] r100) {
        this.$bytes = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OutputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.write(this.$bytes);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OutputStream r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
