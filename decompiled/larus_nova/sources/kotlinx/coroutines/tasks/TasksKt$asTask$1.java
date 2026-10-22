package kotlinx.coroutines.tasks;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import dv7.a;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class TasksKt$asTask$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ a $cancellation;
    final /* synthetic */ TaskCompletionSource<Object> $source;
    final /* synthetic */ Deferred<Object> $this_asTask;

    public TasksKt$asTask$1(a r100, Deferred<Object> r101, TaskCompletionSource<Object> r102) {
        this.$this_asTask = r101;
        this.$source = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Exception r101 = null;
        if ((r100 instanceof CancellationException) == true) goto L14;
        Throwable r102 = this.$this_asTask.getCompletionExceptionOrNull();
        if (r102 != null) goto L7;
        this.$source.setResult(this.$this_asTask.getCompleted());
        return;
    L7:
        TaskCompletionSource<Object> r103 = this.$source;
        if ((r102 instanceof Exception) == false) goto L10;
        r101 = (Exception) r102;
    L10:
        if (r101 != null) goto L12;
        r101 = new RuntimeExecutionException(r102);
    L12:
        r103.setException(r101);
        return;
    L14:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
