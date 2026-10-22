package kotlin.jvm.internal;

import android.util.EventsUtils;
import java.util.Iterator;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"iterator", XmlPullParser.NO_NAMESPACE, "T", "array", XmlPullParser.NO_NAMESPACE, "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ArrayIteratorKt {
    public static final <T> Iterator<T> iterator(T[] r1) {
        Intrinsics.checkNotNullParameter(r1, "array");
        return new ArrayIterator(r1);
    }
}
