package com.ss.android.lark.audio.recorder;

import android.media.AudioRecord;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class t implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioRecord f409163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f409164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f409165c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final boolean a() {
        return false;
    }

    public static void g(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "recordTask");
        StringBuilder r101 = new StringBuilder("[onStop] recorder.state:");
        AudioRecord r102 = this.f409163a;
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.getState());
    L6:
        r101.append(r103);
        r101.append(" hashCode:");
        r101.append(hashCode());
        Log.i("StopRecordState", r101.toString());
        Object r104 = this.f409165c;
        monitor-enter(r104);
        AudioRecord r105 = this.f409163a;     // Catch: Throwable -> L22
        boolean r106 = false;
        if (r105 != null) goto L11;
    L13:
        if (r106 == true) goto L17;
        AudioRecord r107 = this.f409163a;     // Catch: Throwable -> L22
        if (r107 == null) goto L17;
        g(r107);     // Catch: Throwable -> L22
    L17:
        j r108 = this.f409164b;     // Catch: Throwable -> L22
        if (r108 == null) goto L20;
        r108.c();     // Catch: Throwable -> L22
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        monitor-exit(r104);
        return;
    L11:
        if (r105.getState() != 0) goto L13;
        r106 = true;
    L22:
        th = move-exception;
        throw th;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void c(p r100) {
        Intrinsics.checkNotNullParameter(r100, "recordTask");
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void d(p r100) {
        Intrinsics.checkNotNullParameter(r100, "recordTask");
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void e(p r100) {
        m.a.a(r100);
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void f(p r100) {
        Intrinsics.checkNotNullParameter(r100, "recordTask");
        Log.i("StopRecordState", "[onStart]last session occur exception hashCode:" + hashCode());
        m r101 = r100.a(1);
        r100.b(r101);
        r101.f(r100);
    }

    public t(AudioRecord r100, j r101) {
        this.f409163a = r100;
        this.f409164b = r101;
        this.f409165c = new Object();
    }
}
