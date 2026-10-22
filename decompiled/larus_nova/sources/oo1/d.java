package oo1;

import android.graphics.Paint;
import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.view.Surface;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Surface f524522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaMuxer f524523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MediaCodec f524524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MediaCodec.BufferInfo f524525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaCodec f524526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaCodec.BufferInfo f524527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f524528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f524529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f524530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f524531j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f524532k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public oo1.a f524533l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f524534m;

    public interface a {
        void b(int r100);

        void c(String r100, String r101, int r102);

        void d(int r100);
    }

    public final void a() {
        AtomicBoolean r100 = e.f524539e;
        r100.set(true);
        AtomicBoolean r101 = e.f524538d;
        r101.set(true);
        oo1.a r102 = this.f524533l;
        if (r102 == null) goto L5;
        r101.set(true);
        r102.f524517y = true;
    L5:
        h r103 = this.f524534m;
        if (r103 == null) goto L8;
        r100.set(true);
        r103.f524554y = true;
    L8:
        this.f524533l = null;
        this.f524534m = null;
    }

    public d() {
        this.f524528g = new Paint();
    }
}
