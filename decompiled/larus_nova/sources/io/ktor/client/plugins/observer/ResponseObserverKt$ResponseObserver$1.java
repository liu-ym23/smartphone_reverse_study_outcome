package io.ktor.client.plugins.observer;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/observer/ResponseObserver$Config;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ResponseObserverKt$ResponseObserver$1 extends Lambda implements Function1<ResponseObserver.Config, Unit> {
    final /* synthetic */ Function2<io.ktor.client.statement.b, Continuation<? super Unit>, Object> $block;

    /* JADX WARN: Multi-variable type inference failed */
    public ResponseObserverKt$ResponseObserver$1(Function2<? super io.ktor.client.statement.b, ? super Continuation<? super Unit>, ? extends Object> r100) {
        this.$block = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ResponseObserver.Config r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$install");
        Function2<io.ktor.client.statement.b, Continuation<? super Unit>, Object> r101 = this.$block;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f491729a = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ResponseObserver.Config r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
