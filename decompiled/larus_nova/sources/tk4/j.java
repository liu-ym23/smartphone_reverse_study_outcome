package tk4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.dora.utils.OPUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes15.dex */
public final class j extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f546493a;

    @Override // android.os.Handler
    public final void handleMessage(Message r110) {
        if (r110.what != 0) goto L91;
        k r100 = this.f546493a;
        int r101 = r100.f546497d / 960;
        int r102 = Math.min(r100.f546500g, Math.min(Math.max(5, r100.f546499f), r101));
        if (r102 > 0) goto L10;
        pk4.j.a("DoraRtosPlayer", "No available frames, available frame count=" + r101 + ", totalBytes=" + r100.f546497d + ", credits=" + r100.f546499f);
        r100.f546505l = false;
        if (r100.f546498e == false) goto L92;
        r100.c();
        return;
    L92:
        return;
    L10:
        if (r100.f546504k < 5) goto L12;
    L14:
        int r103 = r102 * 960;
        if (r103 > 0) goto L17;
    L34:
        byte[] r104 = new byte[0];
    L36:
        if (r104.length != 0) goto L38;
        pk4.j.f("DoraRtosPlayer", "joinPCMFrames failed: empty pcmData");
        r100.f546505l = false;
        return;
    L38:
        ArrayList r105 = new ArrayList();
        if (r104.length != 0) goto L41;
        byte[] r106 = new byte[0];
    L64:
        if (r106.length != 0) goto L66;
        pk4.j.f("DoraRtosPlayer", "opusEncodeFrames failed: empty payload");
        r100.f546505l = false;
        return;
    L66:
        pk4.j.a("DoraRtosPlayer", "Sent frames -- seq " + r100.f546503j + ", round seq " + r100.f546504k + ",frame count=" + r102 + ", pcm len=" + r104.length + ", payloadSize=" + r106.length + ", -- totalBytes=" + r100.f546497d + ", credits=" + r100.f546499f);
        int r107 = r100.f546503j;
        if (r106.length != 0) goto L69;
        pk4.j.f("DoraRtosPlayer", "txSendAudioFrames failed: empty payload");
    L71:
        if (r100.f546503j != 0) goto L73;
        r100.f546510q = (int) (System.currentTimeMillis() - r100.f546509p);
    L73:
        r100.f546497d -= r104.length;
        r100.f546499f -= r102;
        r100.f546503j++;
        r100.f546504k++;
        r100.f546505l = false;
        r100.b(true);
        return;
    L69:
        byte[] r108 = pk4.n.v(new byte[][]{new byte[]{1, 4}, pk4.n.l(r107), new byte[]{2, 1, (byte) r102}, new byte[]{3, 1, (byte) 1}, new byte[]{4, 2}, pk4.n.k(r106.length), new byte[]{5}, pk4.n.s(r106.length), r106});
        ak4.a.d().g(2, 3, pk4.n.v(new byte[][]{new byte[]{-125}, pk4.n.s(r108.length), r108}));
        goto L71
    L41:
        int r111 = a.f546481a;
        long r112 = System.currentTimeMillis();
        int r113 = 0;
        int r114 = 0;
    L42:
        if (r113 >= r102) goto L56;
        int r115 = r113 + 1;
        if ((r115 * 960) > r104.length) goto L45;
        byte[] r109 = new byte[960];
        System.arraycopy(r104, r113 * 960, r109, 0, 960);
        byte[] r116 = OPUtils.OPE_encode(r109, 480, 192);
        if (r116 != null) goto L49;
    L50:
        pk4.j.f("DoraRtosPlayer", "encodeOpusFrame failed: empty opus data");
        r116 = null;
    L51:
        if (r116 == null) goto L54;
        r114 = r114 + r116.length;
        r105.add(r116);
    L54:
        r113 = r115;
        goto L42
    L49:
        if (r116.length != 0) goto L51;
    L45:
        pk4.j.f("DoraRtosPlayer", "opusEncodeFrames failed: pcm data is shorter than frameCount");
    L56:
        if (r100.f546511r != 0) goto L58;
        r100.f546511r = (int) (System.currentTimeMillis() - r112);
        pk4.j.a("DoraRtosPlayer", "opusEncodeFrames opus cost time " + r100.f546511r);
    L58:
        r106 = new byte[r114];
        Iterator r117 = r105.iterator();
        int r118 = 0;
    L60:
        if (r117.hasNext() == false) goto L62;
        byte[] r119 = (byte[]) r117.next();
        System.arraycopy(r119, 0, r106, r118, r119.length);
        r118 = r118 + r119.length;
        goto L60
    L62:
        int r120 = a.f546481a;
        goto L64
    L17:
        if (((ArrayDeque) r100.f546496c).isEmpty() == true) goto L34;
        ByteArrayOutputStream r121 = new ByteArrayOutputStream(r103);
    L20:
        if (r103 <= 0) goto L33;
        byte[] r122 = (byte[]) ((ArrayDeque) r100.f546496c).poll();
        if (r122 == null) goto L20;
        if (r122.length == 0) goto L20;
        int r123 = Math.min(r122.length, r103);
        r121.write(r122, 0, r123);     // Catch: RuntimeException -> L31
        r103 = r103 - r123;
        if (r123 >= r122.length) goto L20;
        int r124 = r122.length - r123;
        byte[] r125 = new byte[r124];
        System.arraycopy(r122, r123, r125, 0, r124);
        ((ArrayDeque) r100.f546496c).addFirst(r125);
    L31:
        e = move-exception;
        pk4.j.c("DoraRtosPlayer", "Error writing to ByteArrayOutputStream", e);
    L33:
        r104 = r121.toByteArray();
        goto L36
    L12:
        if (r102 >= Math.min(3, r100.f546500g)) goto L14;
        pk4.j.a("DoraRtosPlayer", "No available frames, lower than initial packet size, framesToSend = " + r102 + ", available frame count=" + r101 + ", totalBytes=" + r100.f546497d + ", credits=" + r100.f546499f);
        r100.f546505l = false;
        return;
    }

    public j(k r100, Looper r101) {
        this.f546493a = r100;
        super(r101);
    }
}
