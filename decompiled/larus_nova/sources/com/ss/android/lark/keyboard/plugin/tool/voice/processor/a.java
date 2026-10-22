package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f430791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f430792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f430793c;

    public a() {
    }

    public final synchronized int a() {
        monitor-enter(this);
        this.f430791a++;     // Catch: Throwable -> L6
        int r100 = this.f430791a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void e() {
        this.f430791a = 0;
        this.f430793c = "";
    }

    public final boolean b() {
        b r100 = this.f430792b;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.f430794a != null) goto L7;
        return true;
    L7:
        if (r100.f430795b == null) goto L29;
        String r101 = r100.f430796c;
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L30;
        String r103 = r100.f430797d;
        if (r103 != null) goto L19;
    L22:
        boolean r104 = true;
    L23:
        if (r104 == true) goto L31;
        return false;
    L31:
        return true;
    L19:
        if (r103.length() == 0) goto L22;
        r104 = false;
        goto L23
    L30:
        return true;
    L11:
        if (r101.length() == 0) goto L14;
        r102 = false;
        goto L15
    L29:
        return true;
    }

    public boolean c(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "strFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        b r103 = this.f430792b;
        if (r103 == null) goto L6;
        r103.f430798e = r102;
    L6:
        if (b() == false) goto L9;
        Log.w("AudioRecordDataProcessor", "[onAudioRecorded] mAudioMessage is null");
        return false;
    L9:
        return true;
    }

    public void d(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "strFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        Log.d("AudioRecordDataProcessor", "[onStartRecord]:" + r100 + '/' + r101);
    }
}
