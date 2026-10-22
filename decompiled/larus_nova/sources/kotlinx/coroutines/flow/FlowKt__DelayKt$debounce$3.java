package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "emittedItem", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Ljava/lang/Long;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class FlowKt__DelayKt$debounce$3 extends Lambda implements Function1<Object, Long> {
    final /* synthetic */ Function1<Object, Duration> $timeout;

    public FlowKt__DelayKt$debounce$3(Function1<Object, Duration> r100) {
        this.$timeout = r100;
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(Object r100) {
        return Long.valueOf(DelayKt.m10957toDelayMillisLRDsOJo(this.$timeout.invoke(r100).m10848unboximpl()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Object r100) {
        return invoke(r100);
    }
}
