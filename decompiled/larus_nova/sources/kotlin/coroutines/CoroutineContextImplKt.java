package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, d2 = {"getPolymorphicElement", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element r100, CoroutineContext.Key<E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if ((r101 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r102 = (AbstractCoroutineContextKey) r101;
        if (r102.isSubKey$kotlin_stdlib(r100.getKey()) == false) goto L15;
        E r103 = (E) r102.tryCast$kotlin_stdlib(r100);
        if ((r103 instanceof CoroutineContext.Element) == true) goto L9;
        return null;
    L9:
        return r103;
    L15:
        return null;
    L11:
        if (r100.getKey() != r101) goto L14;
        return r100;
    L14:
        return null;
    }

    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element r100, CoroutineContext.Key<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if ((r101 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r102 = (AbstractCoroutineContextKey) r101;
        if (r102.isSubKey$kotlin_stdlib(r100.getKey()) == true) goto L7;
        return r100;
    L7:
        if (r102.tryCast$kotlin_stdlib(r100) != null) goto L9;
        return r100;
    L9:
        return EmptyCoroutineContext.INSTANCE;
    L11:
        if (r100.getKey() == r101) goto L13;
        return r100;
    L13:
        return EmptyCoroutineContext.INSTANCE;
    }
}
