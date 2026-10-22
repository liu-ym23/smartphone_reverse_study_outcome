package kotlinx.coroutines;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", XmlPullParser.NO_NAMESPACE, "context", "Lkotlin/coroutines/CoroutineContext;", "exception", XmlPullParser.NO_NAMESPACE, "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    public static final Key Key = null;

    static {
        Key = Key.$$INSTANCE;
    }

    void handleException(CoroutineContext r1, Throwable r2);
}
