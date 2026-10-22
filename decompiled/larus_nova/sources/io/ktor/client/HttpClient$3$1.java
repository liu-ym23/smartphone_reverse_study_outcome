package io.ktor.client;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.client.plugins.DefaultTransformKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/client/a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/a;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpClient$3$1 extends Lambda implements Function1<a, Unit> {
    public static final HttpClient$3$1 INSTANCE = null;

    static {
        INSTANCE = new HttpClient$3$1();
    }

    public HttpClient$3$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$install");
        DefaultTransformKt.a(r100);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
