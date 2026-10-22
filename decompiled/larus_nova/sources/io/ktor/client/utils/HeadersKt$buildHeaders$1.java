package io.ktor.client.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.http.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/http/o;", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/http/o;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HeadersKt$buildHeaders$1 extends Lambda implements Function1<o, Unit> {
    public static final HeadersKt$buildHeaders$1 INSTANCE = null;

    static {
        INSTANCE = new HeadersKt$buildHeaders$1();
    }

    public HeadersKt$buildHeaders$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(o r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(o r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
