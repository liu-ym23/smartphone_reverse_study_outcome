package io.ktor.client.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/client/plugins/q$b;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/plugins/q$b;I)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpRequestRetry$Configuration$delayMillis$1 extends Lambda implements Function2<q.b, Integer, Long> {
    final /* synthetic */ Function2<q.b, Integer, Long> $block;
    final /* synthetic */ boolean $respectRetryAfterHeader;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequestRetry$Configuration$delayMillis$1(boolean r100, Function2<? super q.b, ? super Integer, Long> r101) {
        this.$respectRetryAfterHeader = r100;
        this.$block = r101;
        super(2);
    }

    public final Long invoke(q.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
        if (this.$respectRetryAfterHeader == false) goto L5;
        r100.getClass();
        long r102 = Math.max(this.$block.invoke(r100, Integer.valueOf(r101)).longValue(), 0);
    L7:
        return Long.valueOf(r102);
    L5:
        r102 = this.$block.invoke(r100, Integer.valueOf(r101)).longValue();
        goto L7
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Long invoke(q.b r100, Integer r101) {
        return invoke(r100, r101.intValue());
    }
}
