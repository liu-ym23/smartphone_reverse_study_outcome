package com.ss.android.lark.audio.recorder;

import android.media.AudioRecord;
import android.os.Build;
import android.util.SparseArray;
import com.ss.android.lark.log.Log;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f409136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile AudioRecord f409137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f409138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f409139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f409140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f409141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f409142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f409143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f409144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f409145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile m f409146l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f409147m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SparseArray<m> f409148n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public r f409149o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Semaphore f409150p;

    public static final class a {
    }

    static {
    }

    public final int e() {
        m r100 = this.f409146l;
        if ((r100 instanceof StartingRecorderState) == false) goto L6;
        return 1;
    L6:
        if ((r100 instanceof s) == false) goto L9;
        return 2;
    L9:
        if ((r100 instanceof o) == false) goto L12;
        return 3;
    L12:
        if ((r100 instanceof t) == false) goto L14;
        return 4;
    L14:
        return 0;
    }

    public final boolean g() {
        Object r100 = this.f409147m;
        monitor-enter(r100);
        boolean r101 = this.f409146l.a();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void i() {
        if (this.f409137c != null) goto L5;
        return;
    L5:
        Object r100 = this.f409147m;
        monitor-enter(r100);
        this.f409146l.f(this);     // Catch: Throwable -> L14
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
        k r102 = this.f409142h;
        if (r102 == null) goto L12;
        r102.a1();
    L12:
        this.f409146l.c(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void j() {
        Object r100 = this.f409147m;
        monitor-enter(r100);
        this.f409146l.b(this);     // Catch: Throwable -> L14
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
        this.f409148n.clear();
        if (Build.VERSION.SDK_INT < 29) goto L19;
        AudioRecord r102 = this.f409137c;
        if (r102 == null) goto L20;
        r r103 = this.f409149o;
        if (r103 == null) goto L21;
        r102.unregisterAudioRecordingCallback(r103);
        this.f409149o = null;
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void c(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    public final m a(int r110) {
        m r100 = this.f409148n.get(r110);
        if (r100 == null) goto L5;
        return r100;
    L5:
        if (r110 != 0) goto L7;
        m r101 = new n();
    L20:
        this.f409148n.put(r110, r101);
        return r101;
    L7:
        if (r110 != 1) goto L9;
        r101 = new StartingRecorderState(this.f409137c, this.f409141g, this.f409135a);
        goto L20
    L9:
        if (r110 != 2) goto L11;
        r101 = new s(this.f409138d, this.f409144j, this.f409137c, this.f409141g, this.f409139e, this.f409140f);
        goto L20
    L11:
        if (r110 != 3) goto L13;
        r101 = new o(this.f409137c, this.f409141g);
        goto L20
    L13:
        if (r110 == 4) goto L15;
        r101 = new n();
        goto L20
    L15:
        r101 = new t(this.f409137c, this.f409141g);
        goto L20
    }

    public final void b(m r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Object r101 = this.f409147m;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f409146l, r100) == true) goto L7;
        this.f409146l = r100;     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
    }

    public final boolean d(AtomicInteger r100) {
        Intrinsics.checkNotNullParameter(r100, "curRecorderVersion");
        if (this.f409136b.get() == r100.get()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void h(ErrorInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        k r101 = this.f409142h;
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    public p(String r100, AtomicInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "mRecordFilePath");
        Intrinsics.checkNotNullParameter(r101, "mRecorderVersion");
        this.f409135a = r100;
        this.f409136b = r101;
        this.f409139e = 100;
        this.f409140f = -1;
        this.f409146l = new n();
        this.f409147m = new Object();
        this.f409148n = new SparseArray();
        this.f409150p = new Semaphore(0);
    }

    public final int f(c r110, k r111, j r112) {
        Intrinsics.checkNotNullParameter(r110, "recorderConfig");
        if (this.f409137c == null) goto L6;
        if (r112 == null) goto L6;
        return 1;
    L6:
        this.f409138d = r110.f409110b.f409107a.invoke(Integer.valueOf(AudioRecord.getMinBufferSize(r110.f409115g, r110.f409116h, r110.f409117i))).intValue();
        Log.i("RecordTask", "[initRecordInfNeed]mBufferSize:" + this.f409138d);
        this.f409137c = new AudioRecord(r110.f409118j, r110.f409115g, r110.f409116h, r110.f409117i, this.f409138d);     // Catch: Exception -> L26
        AudioRecord r100 = this.f409137c;     // Catch: Exception -> L26
        if (r100 != null) goto L10;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L16;
        Log.e("RecordTask", "[init] init audioRecord failed");     // Catch: Exception -> L26
        return 0;
    L16:
        this.f409143i = r110.f409111c;
        this.f409144j = r110.f409110b;
        this.f409139e = r110.f409112d;
        this.f409140f = r110.f409113e * 1024;
        this.f409142h = r111;
        this.f409141g = r112;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        r r113 = new r(this);
        this.f409149o = r113;
        AudioRecord r114 = this.f409137c;
        if (r114 == null) goto L21;
        r114.registerAudioRecordingCallback(q.f409151a, r113);
    L21:
        j r115 = this.f409141g;
        if (r115 != null) goto L24;
        return 1;
    L24:
        return r115.d(this.f409135a);
    L10:
        if (r100.getState() != 1) goto L12;
        r101 = true;
    L26:
        e = move-exception;
        Log.e("RecordTask", "[init]RecordTaskItem init failed:" + e);
        return 0;
    }
}
