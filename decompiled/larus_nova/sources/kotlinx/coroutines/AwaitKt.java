package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class AwaitKt {
    public static final <T> Object a(Collection<? extends Deferred<? extends T>> r100, Continuation<? super List<? extends T>> r101) {
        if (r100.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return new c((Deferred[]) r100.toArray(new Deferred[0])).a(r101);
    }

    public static final <T> Object b(Deferred<? extends T>[] r100, Continuation<? super List<? extends T>> r101) {
        if (r100.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        return CollectionsKt.emptyList();
    L10:
        return new c(r100).a(r101);
    L5:
        r102 = false;
        goto L6
    }

    public static final Object c(Collection<? extends Job> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AwaitKt$joinAll$3) == false) goto L7;
        AwaitKt$joinAll$3 r102 = (AwaitKt$joinAll$3) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Iterator r107 = (Iterator) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L16:
        if (r107.hasNext() == false) goto L21;
        Job r108 = (Job) r107.next();
        r102.L$0 = r107;
        r102.label = 1;
        if (r108.join(r102) != r105) goto L16;
        return r105;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r107 = r100.iterator();
    L7:
        r102 = new AwaitKt$joinAll$3(r101);
        goto L8
    }
}
