package ksa;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.utils.CertLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaMuxer f505968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f505969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f505970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f505971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f505972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f505973f;

    public final synchronized boolean b() {
        monitor-enter(this);
        boolean r100 = this.f505971d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c() {
        monitor-enter(this);
        int r100 = this.f505970c + 1;     // Catch: Throwable -> L10
        this.f505970c = r100;     // Catch: Throwable -> L10
        int r101 = this.f505969b;     // Catch: Throwable -> L10
        if (r101 <= 0) goto L7;
        if (r100 != r101) goto L7;
        this.f505968a.start();     // Catch: Throwable -> L10
        this.f505971d = true;     // Catch: Throwable -> L10
        notifyAll();     // Catch: Throwable -> L10
    L7:
        boolean r102 = this.f505971d;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
    }

    public d(String r100) throws IOException {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        Object r101 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.VIDEO_RECORD_PARAMS_MOOV_PREFIX);
        if ((r101 instanceof Boolean) == false) goto L12;
        if (((Boolean) r101).booleanValue() == false) goto L12;
        Class r102 = Integer.TYPE;     // Catch: Exception -> L10
        MediaMuxer r103 = (MediaMuxer) MediaMuxer.class.getConstructor(new Class[]{String.class, r102, r102}).newInstance(new Object[]{r100, 0, 1});     // Catch: Exception -> L10
    L13:
        this.f505968a = r103;
        this.f505970c = 0;
        this.f505969b = 0;
        this.f505971d = false;
        return;
    L10:
        e = move-exception;
        CertLog.e("MediaRecorder", "createMediaMuxer", e);
    L12:
        r103 = new MediaMuxer(r100, 0);
        goto L13
    }

    public final synchronized int a(MediaFormat r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f505971d == true) goto L9;
        int r101 = this.f505968a.addTrack(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L9:
        throw new IllegalStateException("muxer already started");     // Catch: Throwable -> L10
    }

    public final synchronized void d(int r100, ByteBuffer r101, MediaCodec.BufferInfo r102) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f505970c <= 0) goto L6;
        this.f505968a.writeSampleData(r100, r101, r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
