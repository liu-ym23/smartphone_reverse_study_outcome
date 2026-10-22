package i87;

import android.content.Context;
import com.bytedance.push.settings.LocalFrequencySettings;
import j77.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Integer, y67.f> f488670a;

    public static void a(Context r100) {
        if (f488670a == null) goto L5;
        return;
    L5:
        List<y67.f> r101 = ((LocalFrequencySettings) i.a(r100, LocalFrequencySettings.class)).n0();
        if (r101 != null) goto L9;
        f488670a = new HashMap();
        return;
    L9:
        HashMap r102 = new HashMap();
        Iterator<y67.f> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        y67.f r104 = r103.next();
        if (r104 == null) goto L11;
        r102.put(Integer.valueOf(r104.f566393e), r104);
        goto L11
    L16:
        f488670a = r102;
    }

    public static synchronized y67.f b(Context r100, int r101) {
        monitor-enter(d.class);
        a(r100);     // Catch: Throwable -> L12
        Map<Integer, y67.f> r102 = f488670a;     // Catch: Throwable -> L12
        if (r102 != null) goto L9;
        monitor-exit(d.class);
        return null;
    L9:
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L12
        y67.f r104 = (y67.f) r103.get(Integer.valueOf(r101));     // Catch: Throwable -> L12
        monitor-exit(d.class);
        return r104;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void c(Context r100, y67.f r101) {
        monitor-enter(d.class);
        a(r100);     // Catch: Throwable -> L11
        Map<Integer, y67.f> r102 = f488670a;     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        monitor-exit(d.class);
        return;
    L8:
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L11
        r103.put(Integer.valueOf(r101.f566393e), r101);     // Catch: Throwable -> L11
        ((LocalFrequencySettings) i.a(r100, LocalFrequencySettings.class)).c0(new ArrayList(((HashMap) f488670a).values()));     // Catch: Throwable -> L11
        monitor-exit(d.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
