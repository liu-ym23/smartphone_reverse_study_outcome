package qk4;

import android.util.ArrayMap;
import com.bytedance.dora.camera.model.DoraVisionQueryTrackInfo;
import com.bytedance.dora.logEngine.KeyLogUtils;
import com.bytedance.dora.protocol.jni_entity.DoraGImageTrack;
import com.bytedance.dora.vision.DoraDataFrame;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements k, i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArrayMap<Integer, hk4.b> f533513j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f533514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ak4.a f533515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<uj4.h> f533516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<j> f533517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<h> f533518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile byte[] f533519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Byte f533520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile byte[] f533521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile byte[] f533522i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f533523a = null;

        static {
            f533523a = new g();
        }
    }

    static {
        ArrayMap<Integer, hk4.b> r100 = new ArrayMap();
        f533513j = r100;
        g r101 = uj4.b.f550325h;
        r100.put(1, uj4.b.C7891b.f550334a);
        g r102 = f.f533497h;
        r100.put(2, f.b.f533512a);
    }

    public static hk4.b i() {
        hk4.b r100 = f533513j.get(2);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return uj4.b.C7891b.f550334a;
    }

    public g() {
        this.f533514a = 0;
        this.f533515b = ak4.a.d();
        this.f533516c = new CopyOnWriteArraySet();
        this.f533517d = new CopyOnWriteArraySet();
        this.f533518e = new CopyOnWriteArraySet();
        this.f533519f = null;
        this.f533520g = null;
        this.f533521h = null;
        this.f533522i = null;
    }

    @Override // hk4.b
    public final void B(byte[] r100) {
        i().B(r100);
    }

    @Override // hk4.b
    public final void a(int r100) {
        i().a(r100);
    }

    @Override // qk4.j
    public final void c(byte[] r100) {
        Iterator r101 = ((CopyOnWriteArraySet) this.f533517d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((j) r101.next()).c(r100);
        goto L4
    }

    @Override // uj4.h
    public final void d(DoraDataFrame r110) {
        pk4.j.d("DoraVisionCore", "onDoraDataFrame: scene=" + r110.scene);
        if (r110.scene != 1) goto L15;
        int r100 = r110.stage;
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L8;
        String r101 = "ocr_transfer_start";
    L10:
        KeyLogUtils.LogType r102 = KeyLogUtils.LogType.KEY;
        String r103 = String.valueOf(this.f533514a);
        KeyLogUtils.DataLink r104 = KeyLogUtils.DataLink.IMAGE;
        String r105 = String.valueOf(r110.f204666id);
        KeyLogUtils.DataFlowDirection r106 = KeyLogUtils.DataFlowDirection.UPLINK;
        KeyLogUtils.a r107 = new KeyLogUtils.a();
        r107.a("scene", r110.scene);
        r107.a("id", r110.f204666id);
        r107.a("type", r110.type);
        r107.a(OnekeyLoginConstants.CU_KEY_SEQ, r110.seq);
        r107.a("count", r110.count);
        r107.a("assId", r110.assId);
        KeyLogUtils.a(r102, r103, r104, r105, r106, r101, r107, "-");
        Iterator r108 = ((CopyOnWriteArraySet) this.f533516c).iterator();
    L12:
        if (r108.hasNext() == false) goto L50;
        ((uj4.h) r108.next()).d(r110);
        goto L12
    L50:
        return;
    L8:
        r101 = "ocr_transfer_end";
        goto L10
    L9:
        r101 = "ocr_transferring";
        goto L10
    L15:
        if (r110.stage != 3) goto L35;
        int r109 = r110.assId;
        if (r109 != 1) goto L26;
        Iterator r111 = ((CopyOnWriteArraySet) this.f533518e).iterator();
    L20:
        if (r111.hasNext() == false) goto L51;
        h r112 = (h) r111.next();
        r112.a(r110);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        pk4.j.c("DoraVisionCore", "onDoraDataFrame: callback ERROR " + r112, th);
        goto L20
    L51:
        return;
    L26:
        if (r109 != 2) goto L49;
        Iterator r113 = ((CopyOnWriteArraySet) this.f533518e).iterator();
    L29:
        if (r113.hasNext() == false) goto L52;
        h r114 = (h) r113.next();
        r114.b(r110);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        pk4.j.c("DoraVisionCore", "onDoraDataFrame: callback ERROR " + r114, th);
        goto L29
    L52:
        return;
    L49:
        return;
    }

    @Override // qk4.j
    public final void f(byte[] r100) {
        Iterator r101 = ((CopyOnWriteArraySet) this.f533517d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((j) r101.next()).f(r100);
        goto L4
    }

    @Override // uj4.h
    public final void g(DoraVisionQueryTrackInfo r100) {
        Iterator r101 = ((CopyOnWriteArraySet) this.f533516c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((uj4.h) r101.next()).g(r100);
        goto L4
    }

    @Override // qk4.j
    public final void h(byte[] r100) {
        Iterator r101 = ((CopyOnWriteArraySet) this.f533517d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((j) r101.next()).h(r100);
        goto L4
    }

    @Override // hk4.b
    public final void m(byte[] r100) {
        i().m(r100);
    }

    @Override // hk4.b
    public final void t(byte[] r100) {
        i().t(r100);
    }

    @Override // hk4.b
    public final void u(byte[] r100) {
        i().u(r100);
    }

    @Override // hk4.b
    public final void v(byte[] r100) {
        i().v(r100);
    }

    @Override // hk4.b
    public final void x(byte[] r100) {
        i().x(r100);
    }

    @Override // hk4.b
    public final void z(byte[] r100) {
        i().z(r100);
    }

    @Override // uj4.h
    public final void e(uj4.g r100, uj4.a r101) {
        Iterator r102 = ((CopyOnWriteArraySet) this.f533516c).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((uj4.h) r102.next()).e(r100, r101);
        goto L4
    }

    @Override // uj4.h
    public final void j(boolean r100, int r101, byte r102) {
        Iterator r103 = ((CopyOnWriteArraySet) this.f533516c).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((uj4.h) r103.next()).j(r100, r101, r102);
        goto L4
    }

    @Override // hk4.b
    public final void p(int r110, int r111, int r112, int r210, int r211, int r212, int r213, int r214) {
        if (r111 != 0) goto L5;
    L8:
        if (r111 != 0) goto L10;
        String r100 = PortraitEngine.LABEL_FIRST_FRAME;
    L11:
        KeyLogUtils.LogType r101 = KeyLogUtils.LogType.KEY;
        String r102 = String.valueOf(this.f533514a);
        KeyLogUtils.DataLink r103 = KeyLogUtils.DataLink.IMAGE;
        String r104 = String.valueOf(r110);
        KeyLogUtils.DataFlowDirection r105 = KeyLogUtils.DataFlowDirection.UPLINK;
        KeyLogUtils.a r113 = new KeyLogUtils.a();
        r113.a("current_index", r111);
        r113.a("total_indexes", r112);
        r113.a("width", r211);
        r113.a("height", r212);
        r113.a(SubInfo.KEY_FORMAT, r213);
        r113.a("side", r214);
        r113.a("link_type", 2);
        KeyLogUtils.a(r101, r102, r103, r104, r105, r100, r113, "-");
    L12:
        i().p(r110, r111, r112, r210, r211, r212, r213, r214);
        return;
    L10:
        r100 = "last_frame";
        goto L11
    L5:
        if (r111 != (r112 - 1)) goto L12;
        goto L8
    }

    @Override // hk4.b
    public final void o(int r210, byte[] r211, int r212, int r213, int r214, int r215, int r216, int r310, int r311, int r312, long r313) {
        KeyLogUtils.LogType r100 = KeyLogUtils.LogType.KEY;
        String r101 = String.valueOf(this.f533514a);
        KeyLogUtils.DataLink r102 = KeyLogUtils.DataLink.IMAGE;
        String r103 = String.valueOf(r210);
        KeyLogUtils.DataFlowDirection r104 = KeyLogUtils.DataFlowDirection.UPLINK;
        KeyLogUtils.a r105 = new KeyLogUtils.a();
        r105.a("width", r214);
        r105.a("height", r215);
        r105.a("side", r310);
        r105.a("len", r212);
        r105.a(SubInfo.KEY_FORMAT, r216);
        r105.a("link_type", 2);
        KeyLogUtils.a(r100, r101, r102, r103, r104, "complete_image", r105, "-");
        i().o(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313);
    }

    @Override // hk4.b
    public final void y(int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r310, int r311, int r312, int r313, int r314, int r315) {
        KeyLogUtils.LogType r100 = KeyLogUtils.LogType.KEY;
        String r101 = String.valueOf(r213);
        KeyLogUtils.DataLink r102 = KeyLogUtils.DataLink.IMAGE;
        String r103 = String.valueOf(r211);
        KeyLogUtils.DataFlowDirection r104 = KeyLogUtils.DataFlowDirection.UPLINK;
        KeyLogUtils.a r105 = new KeyLogUtils.a();
        r105.a("image_stage", r210);
        r105.a("wkr_id", r212);
        r105.a(FrescoMonitorConst.IMAGE_COUNT, r214);
        r105.a("mode", r216);
        r105.a("width", r310);
        r105.a("height", r311);
        r105.a(SubInfo.KEY_FORMAT, r314);
        r105.a("obs_submode", r315);
        r105.a("link_type", 2);
        KeyLogUtils.a(r100, r101, r102, r103, r104, "take_start", r105, "-");
        this.f533514a = r213;
        i().y(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315);
    }

    @Override // hk4.b
    public final void s(int r210, int r211, int r212, int r213, int r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, int r318, Map<String, Object> r319, DoraGImageTrack r410) {
        KeyLogUtils.LogType r100 = KeyLogUtils.LogType.KEY;
        String r101 = String.valueOf(r213);
        KeyLogUtils.DataLink r102 = KeyLogUtils.DataLink.IMAGE;
        String r103 = String.valueOf(r211);
        KeyLogUtils.DataFlowDirection r104 = KeyLogUtils.DataFlowDirection.UPLINK;
        KeyLogUtils.a r105 = new KeyLogUtils.a();
        r105.a("image_stage", r210);
        r105.a("image_index", r310);
        r105.a("mode", r312);
        r105.a("width", r314);
        r105.a("height", r315);
        r105.a("q_value", r316);
        r105.a("d_value", r317);
        r105.a(SubInfo.KEY_FORMAT, r318);
        r105.a("link_type", 2);
        KeyLogUtils.a(r100, r101, r102, r103, r104, "image_transmit_end", r105, "-");
        i().s(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
        if (this.f533514a != r213) goto L6;
        this.f533514a = 0;
        return;
    }

    @Override // hk4.b
    public final void k(int r210, int r211, int r310, int r311, int r312, int r313, int r314, int r315, String r316, int r317, int r318, int r319, int r410, int r411, int r412, long r413, Map<String, Object> r414) {
        KeyLogUtils.LogType r100 = KeyLogUtils.LogType.KEY;
        String r110 = String.valueOf(r311);
        KeyLogUtils.DataLink r212 = KeyLogUtils.DataLink.IMAGE;
        String r213 = String.valueOf(r211);
        KeyLogUtils.DataFlowDirection r214 = KeyLogUtils.DataFlowDirection.UPLINK;
        KeyLogUtils.a r101 = new KeyLogUtils.a();
        r101.a("image_stage", r210);
        r101.a("mode", r314);
        r101.a("width", r317);
        r101.a("height", r318);
        r101.a("q_value", r319);
        r101.a("d_value", r410);
        r101.a(SubInfo.KEY_FORMAT, r411);
        r101.a("link_type", 2);
        KeyLogUtils.a(r100, r110, r212, r213, r214, "image_transmit_start", r101, "-");
        i().k(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    @Override // uj4.h
    public final void b(int r210, int r211, int r212, int r213, int r214, int r215, int r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, long r318, int r410, int r411, int r412) {
        Iterator r100 = ((CopyOnWriteArraySet) this.f533516c).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        ((uj4.h) r100.next()).b(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        pk4.j.c("DoraVisionCore", "onTakeImageState: ERROR", th);
        goto L4
    }
}
