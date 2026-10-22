package rj4;

import android.os.SystemClock;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import pk4.l;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f538037h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static d f538038i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, ConcurrentSkipListSet<rj4.a>> f538039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f538040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f538041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f538042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f538043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ByteBuffer f538044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, a> f538045g;

    public interface a {
        void a(int r100, byte[] r101, int r102);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f538046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f538047b;

        public b(byte[] r100, long r101) {
            this.f538046a = r100;
            this.f538047b = r101;
        }
    }

    static {
        f538037h = d.class.getSimpleName();
    }

    public static synchronized d e() {
        monitor-enter(d.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f538038i != null) goto L7;
        f538038i = new d();     // Catch: Throwable -> L10
    L7:
        d r100 = f538038i;     // Catch: Throwable -> L10
        monitor-exit(d.class);
        return r100;
    }

    public final void d() {
        ArrayList r100 = new ArrayList();
        monitor-enter(this);
        a r101 = this.f538045g.get(3158016);     // Catch: Throwable -> L31
        if (r101 != null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L8:
        long r102 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L31
        if (this.f538042d == true) goto L11;
    L15:
        this.f538042d = false;     // Catch: Throwable -> L31
        this.f538043e = 0;     // Catch: Throwable -> L31
        if (this.f538040b.isEmpty() == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L20:
        if (this.f538040b.isEmpty() == true) goto L25;
        b r103 = this.f538040b.removeFirst();     // Catch: Throwable -> L31
        int r110 = this.f538041c;     // Catch: Throwable -> L31
        byte[] r111 = r103.f538046a;     // Catch: Throwable -> L31
        this.f538041c = r110 - r111.length;     // Catch: Throwable -> L31
        if ((r102 - r103.f538047b) <= 15000) goto L23;
        nj4.b.c(AiBotPollingAuthResult.STATUS_EXPIRED, r111.length, 1, this.f538040b.size(), this.f538041c);     // Catch: Throwable -> L31
        goto L20
    L23:
        r100.add(r103);     // Catch: Throwable -> L31
        goto L20
    L25:
        monitor-exit(this);     // Catch: Throwable -> L31
        Iterator r104 = r100.iterator();
    L28:
        if (r104.hasNext() == false) goto L30;
        b r105 = (b) r104.next();
        int r106 = (int) Math.max(0, SystemClock.elapsedRealtime() - r105.f538047b);
        byte[] r107 = r105.f538046a;
        r101.a(0, r107, r107.length);
        Map<String, Object> r108 = nj4.b.b(4, r105.f538046a.length, r100.size(), 0);
        Integer r109 = Integer.valueOf(r106);
        ((HashMap) r108).put("age_ms", r109);
        l.c("d_bt_rtc_error", r108);
        goto L28
    L30:
        return;
    L11:
        if ((r102 - this.f538043e) <= 15000) goto L15;
        c("window_expired");     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public d() {
        this.f538039a = new ConcurrentHashMap();
        this.f538040b = new ArrayDeque();
        this.f538041c = 0;
        this.f538042d = false;
        this.f538043e = 0;
        this.f538045g = new ConcurrentHashMap();
    }

    public final synchronized void g() {
        monitor-enter(this);
        c("spp_connected");     // Catch: Throwable -> L7
        this.f538042d = true;     // Catch: Throwable -> L7
        this.f538043e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        qj4.a.c(f538037h, "open pending RTC sink window, reason=spp_connected");     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(String r100) {
        monitor-enter(this);
        c(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void c(String r100) {
        this.f538042d = false;
        this.f538043e = 0;
        if (this.f538040b.isEmpty() == false) goto L5;
        return;
    L5:
        int r101 = this.f538040b.size();
        int r102 = this.f538041c;
        this.f538040b.clear();
        this.f538041c = 0;
        nj4.b.c(r100, r102, r101, 0, 0);
    }

    public final synchronized void h(rj4.a r100) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (r100.i() == true) goto L9;
        ByteBuffer r101 = ByteBuffer.allocate(r100.g());     // Catch: Throwable -> L31
        r100.a(r101);     // Catch: Throwable -> L31
        f(r100.d(), r100.f(), r100.b(), r101);     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L9:
        ConcurrentSkipListSet<rj4.a> r102 = this.f538039a.get(Integer.valueOf(r100.c()));     // Catch: Throwable -> L31
        if (r102 != null) goto L12;
        r102 = new ConcurrentSkipListSet(Comparator.comparingInt(new c()));     // Catch: Throwable -> L31
        this.f538039a.put(Integer.valueOf(r100.c()), r102);     // Catch: Throwable -> L31
    L12:
        r102.add(r100);     // Catch: Throwable -> L31
        if (r100.j() == false) goto L29;
        rj4.a r103 = r102.first();     // Catch: Throwable -> L31
        if (r103.h() == true) goto L19;
        qj4.a.b(f538037h, "first fragment not recv, remove this pkt seq: " + r103.e() + " fragSeq: " + r103.f538008b.d());     // Catch: Throwable -> L31
        this.f538039a.remove(Integer.valueOf(r100.c()));     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L19:
        ByteBuffer r104 = ByteBuffer.allocate(r103.g());     // Catch: Throwable -> L31
        Iterator<rj4.a> r105 = r102.iterator();     // Catch: Exception -> L26 Throwable -> L31
    L22:
        if (r105.hasNext() == false) goto L25;
        r105.next().a(r104);     // Catch: Exception -> L26 Throwable -> L31
    L25:
        f(r100.d(), r100.f(), r100.b(), r104);     // Catch: Throwable -> L31
        this.f538039a.remove(Integer.valueOf(r100.c()));     // Catch: Throwable -> L31
    L26:
        qj4.a.b(f538037h, "assemble packet failed, remove this pkt seq: " + r103.e() + " fragSeq: " + r103.f538008b.d());     // Catch: Throwable -> L31
        this.f538039a.remove(Integer.valueOf(r100.c()));     // Catch: Throwable -> L31
        return;
    L29:
        monitor-exit(this);
    }

    public final synchronized void k(byte r100) {
        monitor-enter(this);
        this.f538045g.remove(Integer.valueOf(3158016 | r100));     // Catch: Throwable -> L8
        if (r100 != 0) goto L6;
        c("unregister_callback");     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void i(byte[] r100, short r101) {
        monitor-enter(this);
        ByteBuffer r102 = this.f538044f;     // Catch: Throwable -> L41
        if (r102 != null) goto L6;
    L11:
        ByteBuffer r103 = ByteBuffer.allocate(r101);     // Catch: Throwable -> L41
        this.f538044f = r103;     // Catch: Throwable -> L41
        r103.order(ByteOrder.BIG_ENDIAN);     // Catch: Throwable -> L41
        this.f538044f.put(r100, 0, r101);     // Catch: Throwable -> L41
    L12:
        this.f538044f.flip();     // Catch: Throwable -> L41
    L14:
        if (this.f538044f.remaining() < 12) goto L39;
        ByteBuffer r104 = this.f538044f;     // Catch: Throwable -> L41
        short r105 = r104.getShort(r104.position());     // Catch: Throwable -> L41
        if (r105 == 23130) goto L32;
        qj4.a.b(f538037h, "BWDLPacket Sof not match, sof: 0x" + Integer.toHexString(r105));     // Catch: Throwable -> L41
        int r106 = 0;
    L19:
        if (this.f538044f.remaining() < 2) goto L24;
        ByteBuffer r107 = this.f538044f;     // Catch: Throwable -> L41
        if (r107.getShort(r107.position()) == 23130) goto L24;
        ByteBuffer r108 = this.f538044f;     // Catch: Throwable -> L41
        r108.position(r108.position() + 1);     // Catch: Throwable -> L41
        r106 = r106 + 1;     // Catch: Throwable -> L41
    L24:
        if (this.f538044f.remaining() < 2) goto L39;
        ByteBuffer r109 = this.f538044f;     // Catch: Throwable -> L41
        if (r109.getShort(r109.position()) != 23130) goto L28;
        if (this.f538044f.remaining() >= 12) goto L32;
    L28:
        qj4.a.b(f538037h, "BWDLPacket Sof still not match after " + r106 + " bytes search");     // Catch: Throwable -> L41
        this.f538044f = null;     // Catch: Throwable -> L41
    L32:
        ByteBuffer r110 = this.f538044f;     // Catch: Throwable -> L41
        int r111 = r110.getShort(r110.position() + 2);     // Catch: Throwable -> L41
        if (r111 > this.f538044f.remaining()) goto L39;
        byte[] r112 = new byte[r111];     // Catch: Throwable -> L41
        this.f538044f.get(r112);     // Catch: Throwable -> L41
        rj4.a r113 = new rj4.a(r112, r111);     // Catch: Throwable -> L41
        if (r113.k() == true) goto L36;
        qj4.a.b(f538037h, "BWDLPacket is not valid");     // Catch: Throwable -> L41
        goto L14
    L36:
        h(r113);     // Catch: Throwable -> L41
    L39:
        monitor-exit(this);
        return;
    L6:
        if (r102.remaining() == 0) goto L11;
        if (this.f538044f.remaining() <= 0) goto L12;
        ByteBuffer r114 = ByteBuffer.allocate(this.f538044f.remaining() + r101);     // Catch: Throwable -> L41
        r114.order(ByteOrder.BIG_ENDIAN);     // Catch: Throwable -> L41
        r114.put(this.f538044f);     // Catch: Throwable -> L41
        r114.put(r100, 0, r101);     // Catch: Throwable -> L41
        this.f538044f = r114;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    public final synchronized void j(byte r100, a r101) {
        monitor-enter(this);
        qj4.a.c(f538037h, "registerRecvDataCb, dstSessionId: 48 srcSessionId: 48 channelId: " + r100);     // Catch: Throwable -> L7
        this.f538045g.put(Integer.valueOf(r100 | 3158016), r101);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean a(byte r110, byte r111, byte r112, ByteBuffer r113) {
        int r100 = 0;
        if (r110 != 48) goto L39;
        if (r111 != 48) goto L39;
        if (r112 != 0) goto L39;
        if (this.f538042d == false) goto L39;
        int r114 = r113.limit();
        long r115 = SystemClock.elapsedRealtime();
        if ((r115 - this.f538043e) <= 15000) goto L14;
        c("window_expired");
        return false;
    L14:
        if (r114 > 0) goto L16;
    L37:
        nj4.b.c("packet_too_large", r114, 1, this.f538040b.size(), this.f538041c);
        return true;
    L16:
        if (r114 > 16384) goto L37;
        int r101 = 0;
        int r102 = 0;
    L20:
        if (this.f538040b.isEmpty() == true) goto L24;
        if ((r115 - this.f538040b.peekFirst().f538047b) <= 15000) goto L24;
        r101 = r101 + 1;
        byte[] r103 = this.f538040b.removeFirst().f538046a;
        r102 = r102 + r103.length;
        this.f538041c -= r103.length;
    L24:
        if (r101 <= 0) goto L26;
        nj4.b.c(AiBotPollingAuthResult.STATUS_EXPIRED, r102, r101, this.f538040b.size(), this.f538041c);
    L26:
        byte[] r104 = new byte[r114];
        ByteBuffer r116 = r113.duplicate();
        r116.position(0);
        r116.limit(r114);
        r116.get(r104);
        this.f538040b.addLast(new b(r104, r115));
        this.f538041c += r114;
        int r117 = 0;
    L28:
        if (this.f538040b.size() > 16) goto L36;
        if (this.f538041c > 65536) goto L36;
        if (r100 <= 0) goto L34;
        nj4.b.c("overflow", r117, r100, this.f538040b.size(), this.f538041c);
    L34:
        qj4.a.c(f538037h, "buffer pending RTC sink packet, len=" + r114 + ", count=" + this.f538040b.size() + ", bytes=" + this.f538041c);
        l.c("d_bt_rtc_error", nj4.b.b(3, r114, this.f538040b.size(), this.f538041c));
        return true;
    L36:
        r100 = r100 + 1;
        byte[] r118 = this.f538040b.removeFirst().f538046a;
        r117 = r117 + r118.length;
        this.f538041c -= r118.length;
    L39:
        return false;
    }

    public final synchronized void f(byte r100, byte r101, byte r102, ByteBuffer r103) {
        monitor-enter(this);
        String r104 = f538037h;     // Catch: Throwable -> L16
        qj4.a.c(r104, "notifyDataRecv, dstSessionId: " + r100 + " srcSessionId: " + r101 + " channelId: " + r102 + " data.limit: " + r103.limit());     // Catch: Throwable -> L16
        a r105 = this.f538045g.get(Integer.valueOf(((r100 << 16) | (r101 << 8)) | r102));     // Catch: Throwable -> L16
        if (r105 != null) goto L13;
        qj4.a.b(r104, "BWDLRecvDataCallback is null");     // Catch: Throwable -> L16
        if (a(r100, r101, r102, r103) == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        int r106 = r103.limit();     // Catch: Throwable -> L16
        Map<String, Object> r107 = nj4.b.a(1);     // Catch: Throwable -> L16
        ((HashMap) r107).put("data_len", Integer.valueOf(r106));     // Catch: Throwable -> L16
        l.c("d_bt_rtc_error", r107);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        r105.a(r102, r103.array(), r103.limit());     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
