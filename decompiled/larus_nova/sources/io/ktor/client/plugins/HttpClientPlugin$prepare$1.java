package io.ktor.client.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002 \u0001*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "TConfig", "", "TPlugin", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientPlugin$prepare$1 extends Lambda implements Function1<Object, Unit> {
    public static final HttpClientPlugin$prepare$1 INSTANCE = null;

    static {
        INSTANCE = new HttpClientPlugin$prepare$1();
    }

    public HttpClientPlugin$prepare$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
