package io.ktor.utils.io.core;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ByteReadPacketExtensionsKt$ByteReadPacket$2 extends Lambda implements Function1<ByteBuffer, Unit> {
    public static final ByteReadPacketExtensionsKt$ByteReadPacket$2 INSTANCE = null;

    static {
        INSTANCE = new ByteReadPacketExtensionsKt$ByteReadPacket$2();
    }

    public ByteReadPacketExtensionsKt$ByteReadPacket$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
