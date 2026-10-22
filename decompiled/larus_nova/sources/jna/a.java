package jna;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f499790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f499791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Pair<String, Long>> f499792c = null;

    static {
        f499792c = Collections.synchronizedList(new ArrayList());
    }

    public static long c() {
        List<Pair<String, Long>> r100 = f499792c;
        monitor-enter(r100);
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L11
        long r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L8;
        r102 = r102 + (SystemClock.uptimeMillis() - Math.max(f499791b, ((Number) ((Pair) r101.next()).getSecond()).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r103 = r102 + f499790a;     // Catch: Throwable -> L11
        f499790a = 0;     // Catch: Throwable -> L11
        f499791b = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r100);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, ShortVideoSegments.KEY_CAMERA_ID);
        List<Pair<String, Long>> r100 = f499792c;
        Intrinsics.checkNotNull(r100);
        monitor-enter(r100);
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L19
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(((Pair) r102).getFirst(), r110) == false) goto L6;
    L11:
        Pair r103 = (Pair) r102;     // Catch: Throwable -> L19
        if (r103 != null) goto L15;
        monitor-exit(r100);
        return;
    L15:
        f499790a += SystemClock.uptimeMillis() - Math.max(f499791b, ((Number) r103.getSecond()).longValue());     // Catch: Throwable -> L19
        f499792c.remove(r103);     // Catch: Throwable -> L19
        monitor-exit(r100);
        ILogDepend.f384986a.d("PowerMonitor", "CameraMonitor onClose: " + r110 + ", cameraOpenTime: " + f499790a);
        return;
    L10:
        r102 = null;
    L19:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_CAMERA_ID);
        List<Pair<String, Long>> r101 = f499792c;
        Intrinsics.checkNotNull(r101);
        List<Pair<String, Long>> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        r103.add((String) ((Pair) r104.next()).getFirst());
        goto L4
    L7:
        if (r103.contains(r100) == false) goto L9;
        return;
    L9:
        f499792c.add(new Pair(r100, Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.f384986a.d("PowerMonitor", "CameraMonitor onOpen: " + r100);
    }
}
