package io.ktor.client.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/client/plugins/b$a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/plugins/b$a;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class DefaultRequestKt$defaultRequest$1 extends Lambda implements Function1<b.a, Unit> {
    final /* synthetic */ Function1<b.a, Unit> $block;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultRequestKt$defaultRequest$1(Function1<? super b.a, Unit> r100) {
        this.$block = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$install");
        this.$block.invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(b.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
