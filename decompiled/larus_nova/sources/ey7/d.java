package ey7;

import com.ixigua.lib.track.FrozenTrackNode;
import com.ixigua.lib.track.TrackParams;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, FrozenTrackNode> f474810a = null;

    static {
        f474810a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final FrozenTrackNode a(by7.e r100) {
        if ((r100 instanceof FrozenTrackNode) == true) goto L5;
        String r101 = b(r100);
        TrackParams r102 = new TrackParams();
        b.a(r100, r102);
        by7.e r103 = r100.referrerTrackNode();
        if ((r103 instanceof FrozenTrackNode) == true) goto L9;
        r103 = null;
    L9:
        FrozenTrackNode r104 = new FrozenTrackNode(r101, r102, (FrozenTrackNode) r103);
        f474810a.put(r101, r104);
        String r105 = e.a(r100);
        if (r105 == null) goto L12;
        r104.setTrackThreadId(r105);
        e.f474812b.put(r104, r105);
    L12:
        int r106 = c.f474809a;
        return r104;
    L5:
        return (FrozenTrackNode) r100;
    }

    public static String b(Object r100) {
        return "fn_" + r100.getClass().getSimpleName() + "__" + r100.hashCode() + "__" + System.currentTimeMillis();
    }
}
