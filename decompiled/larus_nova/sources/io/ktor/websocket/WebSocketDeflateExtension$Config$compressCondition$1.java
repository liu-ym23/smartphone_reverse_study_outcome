package io.ktor.websocket;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/ktor/websocket/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/websocket/c;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class WebSocketDeflateExtension$Config$compressCondition$1 extends Lambda implements Function1<c, Boolean> {
    public static final WebSocketDeflateExtension$Config$compressCondition$1 INSTANCE = null;

    static {
        INSTANCE = new WebSocketDeflateExtension$Config$compressCondition$1();
    }

    public WebSocketDeflateExtension$Config$compressCondition$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.TRUE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(c r100) {
        return invoke2(r100);
    }
}
