package com.larus.bmhome.music.save_video;

import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f313129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f313130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f313131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f313132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f313133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f313134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f313135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f313136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f313137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f313138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f313139k;

    public /* synthetic */ q(File r110, int r111, int r112, String r113, int r114, float r210, int r211, int r212, int r213) {
        if ((r213 & 2) == 0) goto L5;
        int r100 = 320;
    L7:
        if ((r213 & 4) == 0) goto L9;
        int r101 = 240;
    L11:
        if ((r213 & 8) == 0) goto L13;
        String r102 = KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
    L15:
        if ((r213 & 16) == 0) goto L17;
        int r103 = 1;
    L19:
        if ((r213 & 32) == 0) goto L21;
        float r104 = 10.0f;
    L23:
        if ((r213 & 64) == 0) goto L25;
        int r105 = 1500000;
    L27:
        if ((r213 & 128) == 0) goto L29;
        int r115 = 10;
    L31:
        if ((r213 & 256) == 0) goto L33;
        long r106 = 1000;
    L34:
        this(r110, r100, r101, r102, r103, r104, r105, r115, r106, false);
        return;
    L33:
        r106 = 0;
        goto L34
    L29:
        r115 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public q(File r100, int r101, int r102, String r103, int r104, float r105, int r106, int r107, long r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r103, DBDefinition.MIME_TYPE);
        this.f313129a = r100;
        this.f313130b = r101;
        this.f313131c = r102;
        this.f313132d = r103;
        this.f313133e = r104;
        this.f313134f = r105;
        this.f313135g = r106;
        this.f313136h = r107;
        this.f313137i = r110;
        this.f313138j = r111;
    }
}
