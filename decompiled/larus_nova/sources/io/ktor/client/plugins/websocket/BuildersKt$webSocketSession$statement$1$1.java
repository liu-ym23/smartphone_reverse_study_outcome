package io.ktor.client.plugins.websocket;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.http.g0;
import io.ktor.http.j0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/ktor/http/g0;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/http/g0;Lio/ktor/http/g0;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class BuildersKt$webSocketSession$statement$1$1 extends Lambda implements Function2<g0, g0, Unit> {
    public static final BuildersKt$webSocketSession$statement$1$1 INSTANCE = null;

    static {
        INSTANCE = new BuildersKt$webSocketSession$statement$1$1();
    }

    public BuildersKt$webSocketSession$statement$1$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(g0 r100, g0 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$url");
        Intrinsics.checkNotNullParameter(r101, "it");
        j0 r102 = j0.f491877c;
        r100.f(j0.f491878d);
        r100.f491864c = r100.f491862a.f491882b;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(g0 r100, g0 r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
