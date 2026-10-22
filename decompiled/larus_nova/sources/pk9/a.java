package pk9;

import android.support.v4.media.session.MediaSessionCompat;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f529679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<MediaSessionCompat, InterfaceC7208a> f529680b = null;

    /* JADX INFO: renamed from: pk9.a$a, reason: collision with other inner class name */
    public interface InterfaceC7208a {
        void a();
    }

    public a() {
    }

    static {
        f529679a = new a();
        f529680b = new ConcurrentHashMap();
    }

    public final synchronized void a(MediaSessionCompat r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "mediaSession");     // Catch: Throwable -> L17
        Iterator r101 = CollectionsKt.iterator(new ConcurrentHashMap(f529680b).keys());     // Catch: Throwable -> L17
    L5:
        if (r101.hasNext() == false) goto L14;
        MediaSessionCompat r102 = (MediaSessionCompat) r101.next();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r102, r100) == true) goto L5;
        if (r102.isActive() == false) goto L5;
        InterfaceC7208a r103 = f529680b.get(r102);     // Catch: Throwable -> L17
        if (r103 == null) goto L13;
        r103.a();     // Catch: Throwable -> L17
    L13:
        r102.setActive(false);     // Catch: Throwable -> L17
        goto L5
    L14:
        r100.setActive(true);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static void b(MediaSessionCompat r100, InterfaceC7208a r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaSession");
        Intrinsics.checkNotNullParameter(r101, "callback");
        f529680b.put(r100, r101);
    }
}
