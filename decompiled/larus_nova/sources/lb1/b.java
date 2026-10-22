package lb1;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f508311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f508312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f508313c;

    public b(a r100, ArrayList r101, String r102) {
        this.f508311a = r100;
        this.f508312b = r101;
        this.f508313c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r210) {
        Intrinsics.checkNotNullParameter(r210, "it");
        a r100 = this.f508311a;
        ArrayList r101 = this.f508312b;
        String r102 = this.f508313c;
        r100.getClass();
        ByteBuffer r103 = ByteBuffer.allocate(1048576);
        Iterator r104 = r101.iterator();
        int r105 = 0;
        boolean r110 = false;
        MediaFormat r111 = null;
    L4:
        if (r104.hasNext() == false) goto L75;
        String r106 = (String) r104.next();
        MediaExtractor r107 = new MediaExtractor();
        r107.setDataSource(r106);     // Catch: Exception -> L8
    L10:
        if (r110 == true) goto L21;
        int r108 = r107.getTrackCount();
        int r112 = 0;
    L12:
        if (r112 >= r108) goto L17;
        if (r107.getTrackFormat(r112).getString("mime").startsWith("video/") == true) goto L18;
        r112 = r112 + 1;
    L18:
        if (r112 < 0) goto L21;
        r107.selectTrack(r112);
        r111 = r107.getTrackFormat(r112);
        r110 = true;
        goto L21
    L17:
        r112 = -1;
    L21:
        r107.release();
        if (r110 == false) goto L4;
    L8:
        e = move-exception;
        e.printStackTrace();
    L75:
        MediaMuxer r109 = new MediaMuxer(r102, 0);     // Catch: IOException -> L25
    L26:
        if (r110 == true) goto L79;
        int r113 = 0;
    L32:
        r109.start();
        Iterator r114 = r101.iterator();
        long r115 = 0;
    L34:
        if (r114.hasNext() == false) goto L71;
        String r116 = (String) r114.next();
        MediaExtractor r117 = new MediaExtractor();
        r117.setDataSource(r116);     // Catch: Exception -> L38
    L40:
        int r118 = r117.getTrackCount();
        int r119 = 0;
    L41:
        if (r119 >= r118) goto L46;
        if (r117.getTrackFormat(r119).getString("mime").startsWith("video/") == true) goto L47;
        r119 = r119 + 1;
    L47:
        if (r119 >= 0) goto L49;
        boolean r120 = false;
    L50:
        r117.selectTrack(r119);
        long r121 = 0;
    L51:
        if (r120 == false) goto L52;
        r103.rewind();
        int r122 = r117.readSampleData(r103, r105);
        if (r122 >= 0) goto L57;
        r120 = false;
    L63:
        r114 = r114;
        r105 = 0;
        goto L51
    L57:
        if (r117.getSampleTrackIndex() == r119) goto L59;
        r117.getSampleTrackIndex();
    L59:
        r121 = r117.getSampleTime();
        MediaCodec.BufferInfo r123 = new MediaCodec.BufferInfo();
        r123.offset = 0;
        r123.size = r122;
        boolean r124 = r120;
        r123.presentationTimeUs = r115 + r121;
        if ((r117.getSampleFlags() & 1) == 0) goto L62;
        r123.flags = 1;
    L62:
        r103.rewind();
        String.format("write sample track %d, size %d, pts %d flag %d", new Object[]{Integer.valueOf(r113), Integer.valueOf(r123.size), Long.valueOf(r123.presentationTimeUs), Integer.valueOf(r123.flags)});
        r109.writeSampleData(r113, r103, r123);
        r117.advance();
        r120 = r124;
        goto L63
    L52:
        r115 = (r115 + r121) + 10000;
        r117.release();
        goto L34
    L49:
        r120 = true;
        goto L50
    L46:
        r119 = -1;
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L71:
        r109.stop();     // Catch: Exception -> L69
        r109.release();     // Catch: Exception -> L69
    L65:
        if (r102 == null) goto L67;
        r210.onNext(r102);
        return;
    L67:
        r210.onError(new Throwable("pre load error"));
        return;
    L79:
        if (r111.containsKey("rotation-degrees") == false) goto L30;
        r109.setOrientationHint(r111.getInteger("rotation-degrees"));     // Catch: Exception -> L70
    L30:
        r113 = r109.addTrack(r111);
    L25:
        r109 = null;
        goto L26
    }
}
