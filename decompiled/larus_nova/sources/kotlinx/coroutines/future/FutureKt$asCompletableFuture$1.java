package kotlinx.coroutines.future;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class FutureKt$asCompletableFuture$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableFuture<Object> $future;
    final /* synthetic */ Deferred<Object> $this_asCompletableFuture;

    public FutureKt$asCompletableFuture$1(CompletableFuture<Object> r100, Deferred<Object> r101) {
        this.$future = r100;
        this.$this_asCompletableFuture = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        this.$future.complete(this.$this_asCompletableFuture.getCompleted());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.$future.completeExceptionally(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
