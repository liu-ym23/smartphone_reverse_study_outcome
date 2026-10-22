package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key Key = null;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void releaseInterceptedContinuation(ContinuationInterceptor r100, Continuation<?> r101) {
            Intrinsics.checkNotNullParameter(r101, "continuation");
        }

        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor r100, CoroutineContext.Key<E> r101) {
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
            if (ContinuationInterceptor.Key != r101) goto L14;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return r100;
        L14:
            return null;
        }

        public static CoroutineContext minusKey(ContinuationInterceptor r100, CoroutineContext.Key<?> r101) {
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
            if (ContinuationInterceptor.Key == r101) goto L13;
            return r100;
        L13:
            return EmptyCoroutineContext.INSTANCE;
        }

        public static CoroutineContext plus(ContinuationInterceptor r100, CoroutineContext r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return CoroutineContext.Element.DefaultImpls.plus(r100, r101);
        }

        public static <R> R fold(ContinuationInterceptor r100, R r101, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r102) {
            Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
            return (R) CoroutineContext.Element.DefaultImpls.fold(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100);

    <T> Continuation<T> interceptContinuation(Continuation<? super T> r100);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    CoroutineContext minusKey(CoroutineContext.Key<?> r100);

    void releaseInterceptedContinuation(Continuation<?> r100);
}
