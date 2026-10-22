package kotlin.sequences;

import android.util.EventsUtils;
import java.util.Iterator;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010(\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¨\u0006\u0005"}, d2 = {"Lkotlin/sequences/Sequence;", "T", XmlPullParser.NO_NAMESPACE, "iterator", XmlPullParser.NO_NAMESPACE, "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface Sequence<T> {
    Iterator<T> iterator();
}
