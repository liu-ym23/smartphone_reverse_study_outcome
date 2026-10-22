package zo0;

import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f573090d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f573091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f573092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573093c;

    public static final class a {
    }

    public interface b<T extends f> {
        void a(T r100);

        void onFailure();
    }

    static {
    }

    public final void b() {
        l(VideoEventOneOutSync.END_TYPE_FINISH, null);
    }

    public final synchronized void n() {
        monitor-enter(this);
        ((ArrayList) this.f573091a).clear();     // Catch: Throwable -> L6
        this.f573092b.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void o() {
        l("start", null);
    }

    public final long f() {
        return k(VideoEventOneOutSync.END_TYPE_FINISH);
    }

    public final long h() {
        return k("start");
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f573093c = r100;
        this.f573091a = new ArrayList();
        this.f573092b = new Bundle();
    }

    public static /* synthetic */ long e(f r100) {
        return r100.d(VideoEventOneOutSync.END_TYPE_FINISH, "start");
    }

    public final synchronized boolean c(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L6
        boolean r101 = this.f573092b.getBoolean(r100, false);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized long g(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L6
        long r101 = this.f573092b.getLong(r100, 0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String i(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter("click_source", "key");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r100, "defaultValue");     // Catch: Throwable -> L7
        String r101 = this.f573092b.getString("click_source", r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized int j(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L13
        Iterator r101 = ((ArrayList) this.f573091a).iterator();     // Catch: Throwable -> L13
        int r102 = 0;
    L5:
        if (r101.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((e) r101.next()).f573088a, r100) == true) goto L11;
        r102 = r102 + 1;
    L11:
        monitor-exit(this);
        return r102;
    L10:
        r102 = -1;
    L13:
        th = move-exception;
        throw th;
    }

    public final long k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L14
        int r101 = j(r100);     // Catch: Throwable -> L14
        if (r101 == (-1)) goto L8;
        e r102 = (e) ListProtector.get(this.f573091a, r101);     // Catch: Throwable -> L14
    L9:
        monitor-exit(this);
        if (r102 != null) goto L19;
        return 0;
    L19:
        return r102.f573089b;
    L8:
        r102 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public static void a(f r100, b r101) {
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter("start", "beginEvent");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(VideoEventOneOutSync.END_TYPE_FINISH, "endEvent");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r101, "callback");     // Catch: Throwable -> L16
        int r102 = r100.j("start");     // Catch: Throwable -> L16
        int r103 = r100.j(VideoEventOneOutSync.END_TYPE_FINISH);     // Catch: Throwable -> L16
        if (r102 >= 0) goto L7;
    L13:
        r101.onFailure();     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L7:
        if (r103 >= ((ArrayList) r100.f573091a).size()) goto L13;
        if (r102 >= r103) goto L13;
        List r104 = CollectionsKt.slice(r100.f573091a, new IntRange(r102, r103));     // Catch: Throwable -> L16
        f r105 = new f(r100.f573093c);     // Catch: Throwable -> L16
        ArrayList r106 = (ArrayList) r105.f573091a;     // Catch: Throwable -> L16
        r106.addAll(r104);     // Catch: Throwable -> L16
        r105.f573092b.putAll(r100.f573092b);     // Catch: Throwable -> L16
        r101.a(r105);     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized long d(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "endEvent");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r101, "beginEvent");     // Catch: Throwable -> L7
        long r102 = k(r100) - k(r101);
        monitor-exit(this);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void l(String r100, Long r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L34
        if ((!Intrinsics.areEqual(r100, "start")) == false) goto L22;
        e r102 = (e) CollectionsKt.firstOrNull(this.f573091a);     // Catch: Throwable -> L34
        Object r103 = null;
        if (r102 == null) goto L8;
        String r104 = r102.f573088a;     // Catch: Throwable -> L34
    L10:
        if (Intrinsics.areEqual(r104, "start") == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        Iterator r105 = ((ArrayList) this.f573091a).iterator();     // Catch: Throwable -> L34
    L15:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(((e) r106).f573088a, r100) == false) goto L15;
        r103 = r106;
    L19:
        if (r103 == null) goto L22;
        monitor-exit(this);
        return;
    L8:
        r104 = null;
    L22:
        if (r101 == null) goto L24;
        long r107 = r101.longValue();     // Catch: Throwable -> L34
    L26:
        if (Intrinsics.areEqual(r100, "start") == false) goto L29;
        n();     // Catch: Throwable -> L34
    L29:
        if (v.a() == true) goto L31;
    L31:
        ((ArrayList) this.f573091a).add(new e(r100, r107));     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L24:
        r107 = SystemClock.uptimeMillis();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final synchronized void m(String r100, boolean r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L6
        this.f573092b.putBoolean(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
