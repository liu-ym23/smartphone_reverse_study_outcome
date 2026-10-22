package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH¦@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\b\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0086@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/sequences/SequenceScope;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "yield", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", SlcElement.KEY_ELEMENTS, "", "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iterator", "", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SequenceScope<T> {
    public abstract Object yield(T r100, Continuation<? super Unit> r101);

    public abstract Object yieldAll(Iterator<? extends T> r100, Continuation<? super Unit> r101);

    public SequenceScope() {
    }

    public final Object yieldAll(Iterable<? extends T> r100, Continuation<? super Unit> r101) {
        if ((r100 instanceof Collection) == true) goto L5;
    L8:
        Object r102 = yieldAll(r100.iterator(), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r102;
    L12:
        return Unit.INSTANCE;
    L5:
        if (((Collection) r100).isEmpty() == false) goto L8;
        return Unit.INSTANCE;
    }

    public final Object yieldAll(Sequence<? extends T> r100, Continuation<? super Unit> r101) {
        Object r102 = yieldAll(r100.iterator(), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
