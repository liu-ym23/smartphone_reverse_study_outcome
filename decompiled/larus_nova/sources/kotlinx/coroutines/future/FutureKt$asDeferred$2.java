package kotlinx.coroutines.future;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.CompletionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00032\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u0001H\u0003H\u00032\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "value", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class FutureKt$asDeferred$2 extends Lambda implements Function2<Object, Throwable, Object> {
    final /* synthetic */ CompletableDeferred<Object> $result;

    public FutureKt$asDeferred$2(CompletableDeferred<Object> r100) {
        this.$result = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r100, Throwable r101) {
        if (r101 != null) goto L4;
        boolean r102 = this.$result.complete(r100);     // Catch: Throwable -> L16
    L14:
        return Boolean.valueOf(r102);
    L4:
        CompletableDeferred<Object> r103 = this.$result;     // Catch: Throwable -> L16
        if ((r101 instanceof CompletionException) == false) goto L7;
        CompletionException r104 = (CompletionException) r101;     // Catch: Throwable -> L16
    L8:
        if (r104 == null) goto L13;
        Throwable r105 = r104.getCause();     // Catch: Throwable -> L16
        if (r105 == null) goto L13;
        r101 = r105;
    L13:
        r102 = r103.completeExceptionally(r101);     // Catch: Throwable -> L16
        goto L14
    L7:
        r104 = null;
    L16:
        th = move-exception;
        y.a(EmptyCoroutineContext.INSTANCE, th);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Throwable r101) {
        return invoke2(r100, r101);
    }
}
