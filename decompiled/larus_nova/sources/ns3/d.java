package ns3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.launch.DefaultLaunchMode;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f520291a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f520292b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f520293c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f520294d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f520295e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Intent f520296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f520297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f520298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static DefaultLaunchMode f520299i;

    public static class a implements ff7.c {
        public a() {
        }

        @Override // ff7.c
        public final void onActivityResume(Activity r100) {
        }

        @Override // ff7.c
        public final void onChange(Activity r100, Fragment r101) {
        }

        @Override // ff7.c
        public final void onActivityPause(Activity r100) {
            d.f520295e = r100.getComponentName().getClassName();
        }

        @Override // ff7.c
        public final void onActivityStarted(Activity r100) {
            d.f520298h = System.currentTimeMillis();
        }

        @Override // ff7.c
        public final void onBackground(Activity r100) {
            d.f520291a = true;
            d.f520293c = false;
            d.f520294d = "";
        }

        @Override // ff7.c
        public final void onFront(Activity r100) {
            d.f520294d = r100.getComponentName().getClassName();
        }

        @Override // ff7.c
        public final void onActivityCreated(Activity r100, Bundle r101) {
            d.f520297g = System.currentTimeMillis();
            if (r101 == null) goto L5;
            boolean r102 = true;
        L6:
            d.f520292b = r102;
            d.f520293c = true;
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public static void b() {
        MessageQueue r100 = (MessageQueue) d27.b.b(Looper.getMainLooper(), "mQueue");     // Catch: Throwable -> L42
        monitor-enter(r100);     // Catch: Throwable -> L42
        Message r101 = (Message) d27.b.b(r100, "mMessages");     // Catch: Throwable -> L39
        if (r101 != null) goto L7;
    L18:
        Field r102 = d27.b.a(Message.class, TeaEventTrack.ACTION_DRAMA_NEXT);     // Catch: Throwable -> L39
        r102.setAccessible(true);     // Catch: Throwable -> L39
    L19:
        if (r101 == null) goto L37;
        if (r102.isAccessible() == true) goto L23;
        r102.setAccessible(true);     // Catch: Throwable -> L39
    L23:
        r101 = (Message) r102.get(r101);     // Catch: Throwable -> L39
        if (r101 == null) goto L19;
        if (r101.getTarget() != d27.a.e()) goto L19;
        Set<Integer> r103 = d27.a.f466535e;     // Catch: Throwable -> L39
        HashSet r104 = (HashSet) r103;     // Catch: Throwable -> L39
        if (r104.contains(Integer.valueOf(r101.what)) == false) goto L19;
        int r105 = r101.what;     // Catch: Throwable -> L39
        if (r105 == 100) goto L33;
        if (r105 != 159) goto L19;
    L33:
        Intent r106 = f.a(r101);     // Catch: Throwable -> L39
        if (r106 == null) goto L19;
        monitor-exit(r100);     // Catch: Throwable -> L39
        Intent r107 = r106;
    L45:
        f520296f = r107;
        ActivityLifeObserver.getInstance().register(new a());
        return;
    L37:
        monitor-exit(r100);     // Catch: Throwable -> L39
    L44:
        r107 = null;
        goto L45
    L7:
        if (r101.getTarget() != d27.a.e()) goto L18;
        Set<Integer> r108 = d27.a.f466535e;     // Catch: Throwable -> L39
        HashSet r109 = (HashSet) r108;     // Catch: Throwable -> L39
        if (r109.contains(Integer.valueOf(r101.what)) == false) goto L18;
        int r110 = r101.what;     // Catch: Throwable -> L39
        if (r110 == 100) goto L14;
        if (r110 != 159) goto L18;
    L14:
        r107 = f.a(r101);     // Catch: Throwable -> L39
        if (r107 == null) goto L18;
        monitor-exit(r100);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();
        goto L44
    }

    public static Pair<DefaultLaunchMode, Long> a(String r100) {
        long r101 = 0;
        if (f520299i != null) goto L23;
        if (f520296f == null) goto L13;
        f520299i = DefaultLaunchMode.CLOD_LAUNCH;
        DefaultLaunchMode r102 = f520299i;
        ct3.f r103 = ct3.a.f465312a;
        if (r103 == null) goto L11;
        r101 = r103.f465340a;
    L11:
        return new Pair(r102, Long.valueOf(r101));
    L13:
        if (r100.equals(f520295e) == true) goto L17;
        f520299i = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(f520299i, 0L);
    L17:
        if (r100.equals(f520294d) == true) goto L20;
        f520299i = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(f520299i, 0L);
    L20:
        f520299i = DefaultLaunchMode.WARM_LAUNCH;
        return new Pair(f520299i, Long.valueOf(f520297g));
    L23:
        if (f520291a == false) goto L41;
        f520291a = false;
        if (r100.equals(f520295e) == true) goto L29;
        f520299i = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(f520299i, 0L);
    L29:
        if (r100.equals(f520294d) == true) goto L32;
        f520299i = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(f520299i, 0L);
    L32:
        boolean r104 = f520293c;
        if (r104 == true) goto L35;
    L38:
        if (r104 == true) goto L41;
        f520299i = DefaultLaunchMode.HOT_LAUNCH;
        return new Pair(f520299i, Long.valueOf(f520298h));
    L35:
        if (f520292b == true) goto L38;
        f520299i = DefaultLaunchMode.WARM_LAUNCH;
        return new Pair(f520299i, Long.valueOf(f520297g));
    L41:
        f520299i = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(f520299i, 0L);
    }
}
