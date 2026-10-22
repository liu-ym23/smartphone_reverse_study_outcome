package ey7;

import by7.j;
import com.ixigua.lib.track.FrozenTrackNode;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, j> f474811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Object, String> f474812b = null;

    static {
        f474811a = new ConcurrentHashMap();
        f474812b = new WeakHashMap();
    }

    public static String a(by7.e r100) {
    L2:
        if (r100 == null) goto L18;
        if ((r100 instanceof FrozenTrackNode) == true) goto L6;
        WeakHashMap<Object, String> r101 = f474812b;
        if (r101.containsKey(r100) == true) goto L10;
        if ((r100 instanceof by7.c) == false) goto L17;
        by7.e r102 = r100.referrerTrackNode();
        if (r102 == null) goto L17;
        return a(r102);
    L17:
        r100 = r100.parentTrackNode();
        goto L2
    L10:
        return r101.get(r100);
    L6:
        return ((FrozenTrackNode) r100).getTrackThreadId();
    L18:
        return null;
    }
}
