package ey7;

import by7.g;
import by7.h;
import com.ixigua.lib.track.TrackParams;
import java.util.LinkedHashMap;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f474808a = 0;

    static {
    }

    @JvmStatic
    public static final void a(by7.e r100, TrackParams r101) {
    L2:
        if (r100 == null) goto L7;
        r100.fillTrackParams(r101);
        if ((r100 instanceof by7.c) == false) goto L6;
        b((by7.c) r100, r101);
    L6:
        r100 = r100.parentTrackNode();
        goto L2
    }

    @JvmStatic
    public static final void b(by7.c r100, TrackParams r101) {
        TrackParams r102 = h.e(r100);
        if (r102 == null) goto L11;
        r100.te();
        LinkedHashMap<String, String> r103 = g.f21472c;
        if ((!r103.isEmpty()) == false) goto L8;
        r101.mergeWithKeyMap(r102, r103);
    L8:
        if (r100.et() == false) goto L12;
        r101.merge(r102);
        return;
    L12:
        return;
    }
}
