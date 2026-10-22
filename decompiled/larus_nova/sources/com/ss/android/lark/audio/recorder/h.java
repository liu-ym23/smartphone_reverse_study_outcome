package com.ss.android.lark.audio.recorder;

import androidx.camera.video.AudioStats;
import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f409127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f409128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f409129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue<ByteBuffer> f409130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f409131e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<ByteBuffer> f409132a;

        /* JADX INFO: renamed from: com.ss.android.lark.audio.recorder.h$a$a, reason: collision with other inner class name */
        public static final class C4751a {
        }

        static {
        }

        public a() {
            this.f409132a = new ArrayDeque(50);
        }
    }

    @Override // com.ss.android.lark.audio.recorder.i
    public final void onStop() {
        this.f409131e.f409132a.clear();
    }

    public h(int r100) {
        this.f409127a = r100;
        this.f409128b = System.currentTimeMillis();
        this.f409130d = new ConcurrentLinkedQueue();
        this.f409131e = new a();
    }

    @Override // com.ss.android.lark.audio.recorder.i
    public final void a(com.ss.android.lark.audio.recorder.a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioFrameDataContext");
        c(r100);
        if ((System.currentTimeMillis() - this.f409128b) < this.f409127a) goto L6;
        Log.d("RecordingRecordState", "[onRecording]onUpdateRecordData buffer:" + r100.f409105f + "  encodeLength:" + r100.f409106g + " lastEncodeLength:" + this.f409129c);
        ByteBuffer r101 = e(false, r100.f409100a);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f409100a = r101;
        d(r100, false);
        return;
    }

    public final void c(com.ss.android.lark.audio.recorder.a r100) {
        r100.f409100a.flip();
        a r101 = this.f409131e;
        int r102 = r100.f409100a.capacity();
        ArrayDeque<ByteBuffer> r103 = r101.f409132a;
        monitor-enter(r103);
        Iterator<ByteBuffer> r104 = r101.f409132a.iterator();     // Catch: Throwable -> L14
    L6:
        if (r104.hasNext() == false) goto L10;
        ByteBuffer r105 = r104.next();     // Catch: Throwable -> L14
        if (r105.capacity() < r102) goto L6;
        r104.remove();     // Catch: Throwable -> L14
        r105.clear();     // Catch: Throwable -> L14
    L11:
        monitor-exit(r103);
        r105.put(r100.f409100a.duplicate());
        r105.flip();
        this.f409130d.offer(r105);
        return;
    L10:
        r105 = ByteBuffer.allocateDirect(r102);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.audio.recorder.i
    public final void b(com.ss.android.lark.audio.recorder.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "audioFrameDataContext");
        c(r100);
        long r102 = r100.f409106g - this.f409129c;
        if (r100.f409105f <= 0) goto L5;
        Log.d("RecordingRecordState", "[onRecording]onUpdateRecordData remainLength:" + r102 + " encodeLength:" + r100.f409106g + " lastEncodeLength:" + this.f409129c);
    L5:
        ByteBuffer r103 = e(true, r100.f409100a);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r100.f409100a = r103;
        d(r100, true);
    }

    public final void d(com.ss.android.lark.audio.recorder.a r110, boolean r111) {
        long r100 = r110.f409106g - this.f409129c;
        Integer r101 = null;
        byte[] r102 = null;
        if (r100 > 0) goto L7;
        if (r111 == true) goto L7;
        Log.d("RecordingRecordState", "[onRecording] result size :0 lastEncodeLength:" + this.f409129c + " encodeLength:" + r110.f409106g);
    L13:
        this.f409128b = System.currentTimeMillis();
        p r112 = r110.f409101b;
        int r103 = r110.f409104e;
        b r104 = r110.f409103d;
        if (r104 == null) goto L16;
        ByteBuffer r105 = r110.f409100a;
        double r106 = r104.f409108b.invoke(r105, Integer.valueOf(r105.limit())).doubleValue();
    L17:
        double r107 = r106;
        ByteBuffer r108 = r110.f409100a;
        if (r102 == null) goto L20;
        ByteBuffer r113 = ByteBuffer.wrap(r102);
    L21:
        ByteBuffer r109 = r113;
        k r114 = r112.f409142h;
        if (r114 == null) goto L25;
        r114.k(r103, r107, r108, r109);
        return;
    L25:
        return;
    L20:
        r113 = ByteBuffer.allocateDirect(0);
        goto L21
    L16:
        r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        if (r100 >= 0) goto L9;
        Log.e("RecordingRecordState", "[onRecording] remainLength:" + r100);
    L9:
        byte[] r115 = r110.f409102c.a(r111);
        StringBuilder r116 = new StringBuilder("[onRecording] result size :");
        if (r115 == null) goto L12;
        r101 = Integer.valueOf(r115.length);
    L12:
        r116.append(r101);
        r116.append(" lastEncodeLength:");
        r116.append(this.f409129c);
        r116.append(" encodeLength:");
        r116.append(r110.f409106g);
        Log.d("RecordingRecordState", r116.toString());
        this.f409129c = r110.f409106g;
        r102 = r115;
        goto L13
    }

    public final ByteBuffer e(boolean r100, ByteBuffer r101) {
        ArrayList r102 = new ArrayList();
    L4:
        if ((!this.f409130d.isEmpty()) == false) goto L9;
        ByteBuffer r103 = this.f409130d.poll();
        if (r103 == null) goto L4;
        r102.add(r103);
        goto L4
    L9:
        if ((!r102.isEmpty()) == true) goto L13;
        if (r100 == true) goto L13;
        return r101;
    L13:
        Iterator r104 = r102.iterator();
        int r105 = 0;
    L15:
        if (r104.hasNext() == false) goto L17;
        r105 = r105 + ((ByteBuffer) r104.next()).remaining();
        goto L15
    L17:
        ByteBuffer r106 = ByteBuffer.allocateDirect(r105);
        Iterator r107 = r102.iterator();
    L19:
        if (r107.hasNext() == false) goto L21;
        r106.put(((ByteBuffer) r107.next()).duplicate());
        goto L19
    L21:
        r106.flip();
        Iterator r108 = r102.iterator();
    L23:
        if (r108.hasNext() == false) goto L35;
        ByteBuffer r109 = (ByteBuffer) r108.next();
        a r110 = this.f409131e;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r109, "buffer");
        ArrayDeque<ByteBuffer> r111 = r110.f409132a;
        monitor-enter(r111);
        if (r110.f409132a.size() >= 50) goto L29;
        r110.f409132a.add(r109);     // Catch: Throwable -> L32
    L29:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r111);
    L32:
        th = move-exception;
        throw th;
    L35:
        return r106;
    }
}
