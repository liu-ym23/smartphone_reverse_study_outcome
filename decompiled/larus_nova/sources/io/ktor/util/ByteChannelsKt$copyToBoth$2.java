package io.ktor.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ByteChannelsKt$copyToBoth$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ io.ktor.utils.io.d $first;
    final /* synthetic */ io.ktor.utils.io.d $second;

    public ByteChannelsKt$copyToBoth$2(io.ktor.utils.io.d r100, io.ktor.utils.io.d r101) {
        this.$first = r100;
        this.$second = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.$first.close(r100);
        this.$second.close(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
