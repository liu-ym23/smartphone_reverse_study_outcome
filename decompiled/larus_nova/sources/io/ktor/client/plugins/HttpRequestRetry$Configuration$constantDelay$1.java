package io.ktor.client.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/client/plugins/q$b;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/plugins/q$b;I)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpRequestRetry$Configuration$constantDelay$1 extends Lambda implements Function2<q.b, Integer, Long> {
    final /* synthetic */ long $millis;
    final /* synthetic */ long $randomizationMs;
    final /* synthetic */ q.a this$0;

    public HttpRequestRetry$Configuration$constantDelay$1(long r100, q.a r101, long r102) {
        this.$millis = r100;
        this.this$0 = r101;
        this.$randomizationMs = r102;
        super(2);
    }

    public final Long invoke(q.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$delayMillis");
        long r102 = this.$millis;
        q.a r103 = this.this$0;
        long r104 = this.$randomizationMs;
        r103.getClass();
        long r105 = 0;
        if (r104 == 0) goto L7;
        r105 = Random.Default.nextLong(r104);
    L7:
        return Long.valueOf(r102 + r105);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Long invoke(q.b r100, Integer r101) {
        return invoke(r100, r101.intValue());
    }
}
