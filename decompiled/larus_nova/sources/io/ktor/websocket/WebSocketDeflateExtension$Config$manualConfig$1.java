package io.ktor.websocket;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lio/ktor/websocket/l;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class WebSocketDeflateExtension$Config$manualConfig$1 extends Lambda implements Function1<List<l>, Unit> {
    public static final WebSocketDeflateExtension$Config$manualConfig$1 INSTANCE = null;

    static {
        INSTANCE = new WebSocketDeflateExtension$Config$manualConfig$1();
    }

    public WebSocketDeflateExtension$Config$manualConfig$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<l> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<l> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
