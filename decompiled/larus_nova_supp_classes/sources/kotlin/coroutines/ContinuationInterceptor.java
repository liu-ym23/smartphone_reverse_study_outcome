package kotlin.coroutines;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", XmlPullParser.NO_NAMESPACE, "Key", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key Key = null;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class DefaultImpls {
        public static void releaseInterceptedContinuation(ContinuationInterceptor r0, Continuation<?> r1) {
            Intrinsics.checkNotNullParameter(r1, "continuation");
        }

        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor r2, CoroutineContext.Key<E> r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            if ((r3 instanceof AbstractCoroutineContextKey) == false) goto L11;
            AbstractCoroutineContextKey r4 = (AbstractCoroutineContextKey) r3;
            if (r4.isSubKey$kotlin_stdlib(r2.getKey()) == false) goto L15;
            E r5 = (E) r4.tryCast$kotlin_stdlib(r2);
            if ((r5 instanceof CoroutineContext.Element) == true) goto L9;
            return null;
        L9:
            return r5;
        L15:
            return null;
        L11:
            if (ContinuationInterceptor.Key != r3) goto L14;
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return r2;
        L14:
            return null;
        }

        public static CoroutineContext minusKey(ContinuationInterceptor r1, CoroutineContext.Key<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            if ((r2 instanceof AbstractCoroutineContextKey) == false) goto L11;
            AbstractCoroutineContextKey r3 = (AbstractCoroutineContextKey) r2;
            if (r3.isSubKey$kotlin_stdlib(r1.getKey()) == true) goto L7;
            return r1;
        L7:
            if (r3.tryCast$kotlin_stdlib(r1) != null) goto L9;
            return r1;
        L9:
            return EmptyCoroutineContext.INSTANCE;
        L11:
            if (ContinuationInterceptor.Key == r2) goto L13;
            return r1;
        L13:
            return EmptyCoroutineContext.INSTANCE;
        }

        public static CoroutineContext plus(ContinuationInterceptor r1, CoroutineContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return CoroutineContext.Element.DefaultImpls.plus(r1, r2);
        }

        public static <R> R fold(ContinuationInterceptor r1, R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r3) {
            Intrinsics.checkNotNullParameter(r3, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(r1, r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Key $$INSTANCE = null;

        static {
            $$INSTANCE = new Key();
        }

        private Key() {
        }
    }

    static {
        Key = Key.$$INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1);

    <T> Continuation<T> interceptContinuation(Continuation<? super T> r1);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    CoroutineContext minusKey(CoroutineContext.Key<?> r1);

    void releaseInterceptedContinuation(Continuation<?> r1);
}
