package goa;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<coa.a> f481959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f481960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f481961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile C6045b f481962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Integer> f481963e;

    public static final class a {
    }

    /* JADX INFO: renamed from: goa.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes34.dex */
    public static final class C6045b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f481964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f481965b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6045b) == true) goto L8;
            return false;
        L8:
            C6045b r101 = (C6045b) r100;
            if (this.f481964a == r101.f481964a) goto L12;
            return false;
        L12:
            if (this.f481965b == r101.f481965b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f481964a * 31;
            long r101 = this.f481965b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "UpdateCacheRecord(versionCode=" + this.f481964a + ", expireAtMs=" + this.f481965b + ')';
        }

        public C6045b(int r100, long r101) {
            this.f481964a = r100;
            this.f481965b = r101;
        }
    }

    static {
    }

    public b() {
        this.f481959a = new CopyOnWriteArrayList();
        this.f481960b = -1;
        this.f481963e = SetsKt.setOf(new Integer[]{2, 3, 6});
    }

    public final void a(int r100) {
        FLogger.f375446a.i("UpdateStateHolder", "publishProgress:" + r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        this.f481961c = r100;     // Catch: Throwable -> L9
        Iterator<T> r102 = this.f481959a.iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        ((coa.a) r102.next()).onProgress(r100);     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        FLogger.f375446a.e("UpdateStateHolder", "publishProgress fail:" + r104);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void b(int r100) {
        FLogger.f375446a.i("UpdateStateHolder", "transitTo:" + r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        this.f481960b = r100;     // Catch: Throwable -> L9
        Iterator<T> r102 = this.f481959a.iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        ((coa.a) r102.next()).onStateUpdate(r100);     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        FLogger.f375446a.i("UpdateStateHolder", "transitTo fail:" + r104);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
