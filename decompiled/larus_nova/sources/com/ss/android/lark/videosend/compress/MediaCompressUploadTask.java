package com.ss.android.lark.videosend.compress;

import com.bytedance.lark.pb.media.v1.ChunkyUploadCode;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class MediaCompressUploadTask implements Runnable, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.videosend.compress.a f444880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f444881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f444882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ChunkyUploadCode f444883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f444884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f444885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f444886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f444887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f444888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f444889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f444890k;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.videosend.compress.c
    public final void a() {
        Log.i("MediaCompressUploadTask", "onCompressFinish");
        this.f444886g = true;
        byte[] r100 = this.f444887h;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f444888i == null) goto L9;
        Intrinsics.checkNotNull(r100);
        Long r101 = this.f444888i;
        Intrinsics.checkNotNull(r101);
        b(r100, r101.longValue(), true);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((f) this.f444890k.getValue()).run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public MediaCompressUploadTask(com.ss.android.lark.videosend.compress.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f444880a = r100;
        this.f444881b = r100.f444926a;
        this.f444884e = new byte[0];
        this.f444889j = LazyKt.lazy(MediaCompressUploadTask$uploadExecutor$2.INSTANCE);
        this.f444890k = LazyKt.lazy(new MediaCompressUploadTask$mInnerTask$2(this));
    }

    public final void b(byte[] r110, long r111, boolean r112) {
        boolean r100 = false;
        if (r112 == false) goto L5;
    L19:
        byte[] r101 = this.f444884e;
        if (r101.length != 0) goto L22;
        boolean r102 = true;
    L24:
        if ((true ^ r102) == false) goto L29;
        byte[] r103 = ArraysKt.plus(new byte[0], r101);
        long r104 = this.f444885f;
        Executor r105 = (Executor) this.f444889j.getValue();
        if (r105 == null) goto L28;
        r105.execute(new g(this, r103, r104, false));
    L28:
        this.f444884e = new byte[0];
        this.f444885f = 0;
    L29:
        Executor r106 = (Executor) this.f444889j.getValue();
        if (r106 == null) goto L35;
        r106.execute(new g(this, r110, r111, r112));
        return;
    L35:
        return;
    L22:
        r102 = false;
        goto L24
    L5:
        if (r111 < this.f444885f) goto L19;
        byte[] r113 = this.f444884e;
        if ((r113.length + r110.length) <= 102400) goto L13;
        byte[] r107 = ArraysKt.plus(new byte[0], r113);
        long r108 = this.f444885f;
        Executor r114 = (Executor) this.f444889j.getValue();
        if (r114 == null) goto L12;
        r114.execute(new g(this, r107, r108, false));
    L12:
        this.f444884e = new byte[0];
        this.f444885f = 0;
    L13:
        byte[] r115 = this.f444884e;
        if (r115.length != 0) goto L16;
        r100 = true;
    L16:
        if (r100 == false) goto L18;
        this.f444884e = r110;
        this.f444885f = r111;
        return;
    L18:
        this.f444884e = ArraysKt.plus(r115, r110);
    }

    @Override // com.ss.android.vesdk.VEListener.VEEncoderListener
    public final void onEncoderDataAvailable(byte[] r100, long r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r103 == false) goto L5;
        Log.i("MediaCompressUploadTask", "onEncoderDataAvailable finish");
    L5:
        if (r103 == true) goto L7;
    L9:
        b(r100, r101, r103);
        return;
    L7:
        if (this.f444886g == true) goto L9;
        this.f444887h = r100;
        this.f444888i = Long.valueOf(r101);
    }
}
