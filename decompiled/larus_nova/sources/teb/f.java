package teb;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements UIFeedCard.DataObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f545655d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f545656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<FeedListAdapter> f545657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f545658c;

    static {
        f545655d = new Object();
    }

    public f(FeedListAdapter r100) {
        this.f545656a = new ConcurrentHashMap();
        this.f545657b = new WeakReference(r100);
        this.f545658c = new Handler(Looper.getMainLooper());
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard.DataObserver
    public final void onChanged(String r100) {
        this.f545656a.put(r100, f545655d);
        Iterator<String> r101 = this.f545656a.keySet().iterator();
        HashSet r102 = new HashSet();
    L4:
        if (r101.hasNext() == false) goto L6;
        r102.add(r101.next());
        r101.remove();
        goto L4
    L6:
        this.f545658c.post(new e(this, r102));
    }
}
