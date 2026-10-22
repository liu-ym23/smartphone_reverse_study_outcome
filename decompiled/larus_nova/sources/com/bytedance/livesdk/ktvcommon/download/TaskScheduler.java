package com.bytedance.livesdk.ktvcommon.download;

import com.bytedance.livesdk.ktvcommon.download.api.f;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.livesdk.ktvcommon.download.model.o;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import defpackage.p;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import yk6.g;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<d> f255918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f255919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, com.bytedance.livesdk.ktvcommon.download.model.e> f255920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f255921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.livesdk.ktvcommon.download.d f255922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.livesdk.ktvcommon.download.b f255923f;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((d) r101).f255927c, ((d) r100).f255927c);
        }
    }

    public static final class b<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f255924a;

        public b(a r100) {
            this.f255924a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f255924a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(((d) r100).f255928d), Long.valueOf(((d) r101).f255928d));
        }
    }

    public static final class c {
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f255925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bytedance.livesdk.ktvcommon.download.model.e> f255926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DownloadPriority f255927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f255928d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L14;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f255925a, r101.f255925a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f255926b, r101.f255926b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f255927c, r101.f255927c) == true) goto L12;
            return false;
        L12:
            if (this.f255928d == r101.f255928d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f255925a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<com.bytedance.livesdk.ktvcommon.download.model.e> r104 = this.f255926b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            DownloadPriority r107 = this.f255927c;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            int r108 = (r106 + r101) * 31;
            long r109 = this.f255928d;
            return r108 + ((int) (r109 ^ (r109 >>> 32)));
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "PendingBatch(batchId=" + this.f255925a + ", tasks=" + this.f255926b + ", priority=" + this.f255927c + ", addTime=" + this.f255928d + ")";
        }

        public d(String r100, List<com.bytedance.livesdk.ktvcommon.download.model.e> r101, DownloadPriority r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "batchId");
            Intrinsics.checkNotNullParameter(r101, "tasks");
            Intrinsics.checkNotNullParameter(r102, "priority");
            this.f255925a = r100;
            this.f255926b = r101;
            this.f255927c = r102;
            this.f255928d = r103;
        }
    }

    static {
    }

    public final void c() {
        f.f255932b.getClass();
        f.a().a().a(new TaskScheduler$checkAndScheduleBatches$1(this));
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        monitor-enter(this);
        com.bytedance.livesdk.ktvcommon.download.model.e r101 = this.f255920c.remove(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        if (r101 == null) goto L16;
        String r102 = r101.f255973k;
        if (r102 == null) goto L17;
        f.f255932b.getClass();
        f.a().getDownloader().a(r102, r101.f255966d.f255982i);
        return;
    L17:
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static final void a(TaskScheduler r100, d r101) {
        r100.getClass();
        Iterator<T> r102 = r101.f255926b.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        com.bytedance.livesdk.ktvcommon.download.model.e r103 = (com.bytedance.livesdk.ktvcommon.download.model.e) r102.next();
        if (r100.f255920c.containsKey(r103.f255963a) == false) goto L4;
        DownloadState r104 = DownloadState.CANCELLED;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f255967e = r104;
        f.f255932b.getClass();
        f.a().getDownloader().a(r103.f255973k, r103.f255966d.f255982i);
        r100.f255920c.remove(r103.f255963a);
        r100.f255923f.a(r103);
        goto L4
    L8:
        monitor-enter(r100);
        o<d> r105 = r100.f255918a;     // Catch: Throwable -> L12
        com.bytedance.live.kmp.util.c r106 = com.bytedance.live.kmp.util.c.f255167a;     // Catch: Throwable -> L12
        long r107 = System.currentTimeMillis();     // Catch: Throwable -> L12
        String r108 = r101.f255925a;     // Catch: Throwable -> L12
        List<com.bytedance.livesdk.ktvcommon.download.model.e> r109 = r101.f255926b;     // Catch: Throwable -> L12
        DownloadPriority r110 = r101.f255927c;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r108, "batchId");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r109, "tasks");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r110, "priority");     // Catch: Throwable -> L12
        d r111 = new d(r108, r109, r110, r107);     // Catch: Throwable -> L12
        r105.f256005a.add(r111);     // Catch: Throwable -> L12
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static final void b(TaskScheduler r100, d r101) {
        r100.getClass();
        int r102 = g.f568232a;
        g.a("KTV-Download-Scheduler", "Starting batch " + r101.f255925a + " with " + r101.f255926b.size() + " tasks (priority " + r101.f255927c.name() + ')');
        Iterator<T> r103 = r101.f255926b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        com.bytedance.livesdk.ktvcommon.download.model.e r104 = (com.bytedance.livesdk.ktvcommon.download.model.e) r103.next();
        DownloadState r105 = DownloadState.DOWNLOADING;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f255967e = r105;
        com.bytedance.live.kmp.util.c r106 = com.bytedance.live.kmp.util.c.f255167a;
        r104.f255970h = System.currentTimeMillis();
        r100.f255920c.put(r104.f255963a, r104);
        f.f255932b.getClass();
        String r107 = f.a().getDownloader().c(r104.f255963a, r104.f255966d, new e(r100));
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r104.f255973k = r107;
        goto L4
    }

    public TaskScheduler(p r100, com.bytedance.livesdk.ktvcommon.download.d r101, com.bytedance.livesdk.ktvcommon.download.b r102) {
        Intrinsics.checkNotNullParameter(r100, "batchManager");
        Intrinsics.checkNotNullParameter(r101, "taskManager");
        Intrinsics.checkNotNullParameter(r102, "callbackManager");
        this.f255921d = r100;
        this.f255922e = r101;
        this.f255923f = r102;
        this.f255918a = new o(new b(new a()));
        this.f255919b = new ArrayList();
        this.f255920c = new HashMap();
    }
}
