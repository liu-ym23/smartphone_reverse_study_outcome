package kotlinx.coroutines;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlinx.coroutines.internal.m;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0005R\u0012\u0010\u0003\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "limitedParallelism", "parallelism", XmlPullParser.NO_NAMESPACE, "toString", XmlPullParser.NO_NAMESPACE, "toStringInternalImpl", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher getImmediate();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String r0 = toStringInternalImpl();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getClass().getSimpleName() + '@' + b0.a(this);
    }

    public final String toStringInternalImpl() {
        MainCoroutineDispatcher r0 = Dispatchers.getMain();
        if (this != r0) goto L14;
        return "Dispatchers.Main";
    L14:
        MainCoroutineDispatcher r1 = r0.getImmediate();     // Catch: UnsupportedOperationException -> L9
    L10:
        if (this != r1) goto L13;
        return "Dispatchers.Main.immediate";
    L13:
        return null;
    L9:
        r1 = null;
        goto L10
    }

    public MainCoroutineDispatcher() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r1) {
        m.a(r1);
        return this;
    }
}
