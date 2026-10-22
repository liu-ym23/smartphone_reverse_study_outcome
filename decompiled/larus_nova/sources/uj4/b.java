package uj4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.spp.DoraSppLink;
import com.bytedance.dora.logEngine.KeyLogUtils;
import com.bytedance.dora.protocol.jni_entity.DoraGImageTrack;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import pk4.l;
import pk4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements hk4.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final qk4.g f550325h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ak4.a f550326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f550327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f550328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f550329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile byte[] f550330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f550331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f550332g;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f550333a;

        @Override // android.os.Handler
        public final void handleMessage(Message r410) {
            super.handleMessage(r410);
            if (r410.what != 1) goto L26;
            pk4.j.d("DoraCamera", "camera timeout: " + r410.what);
            int r100 = r410.getData().getInt("key_camera_image_uuid", -1);
            r410.getData().getInt("key_camera_image_stage", -1);
            int r101 = r410.getData().getInt("key_wkr_id", -1);
            int r310 = r410.getData().getInt("key_vui_id", -1);
            int r311 = r410.getData().getInt("key_camera_image_count", -1);
            int r411 = r410.getData().getInt("key_camera_side", -1);
            int r412 = r410.getData().getInt("key_camera_mode", -1);
            int r413 = r410.getData().getInt("key_image_width", -1);
            int r414 = r410.getData().getInt("key_image_height", -1);
            int r415 = r410.getData().getInt("key_image_quality_value", -1);
            int r102 = r410.getData().getInt("key_image_definition_value", -1);
            if (this.f550333a.f550327b == null) goto L23;
            pk4.j.d("DoraCamera", "camera timeout  doraCameraTimeOutInfo: " + this.f550333a.f550327b.toString());
            e r103 = this.f550333a.f550327b;
            int r104 = r103.f550341d;
            int r105 = r103.f550342e;
            if (r104 == r105) goto L21;
            if (r104 == 1) goto L11;
        L22:
            b r106 = this.f550333a;
            d r107 = r106.f550328c;
            e r108 = r106.f550327b;
            r107.getClass();
            HashMap r109 = new HashMap();
            r109.put("image_uuid", Integer.valueOf(r100));
            r109.put("image_mode", Integer.valueOf(r108.f550340c));
            r109.put("side", Integer.valueOf(r411));
            r109.put("is_sequence_error", Integer.valueOf(r107.f550337c ? 1 : 0));
            r109.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r108.f550342e));
            r109.put("image_index", Integer.valueOf(r108.f550341d));
            r109.put(LocationMonitorConst.IS_TIMEOUT, Integer.valueOf(r108.f550339b ? 1 : 0));
            r109.put("timeout_duration", 15000);
            l.c(l.f529651s, r109);
            int r110 = 1;
            this.f550333a.f550327b.f550339b = true;
        L24:
            this.f550333a.f550329d.removeMessages(r110);
            return;
        L11:
            if (r105 != 2) goto L22;
            qk4.g r111 = b.f550325h;
            r111.e(new g(r100, null, 0, 0, 0, r411, 1, r412, 0), new uj4.a(9, ""));
            r111.b(3, r100, r101, r310, r311, r411, r412, 9, r413, r414, r415, r102, 0, 0, 0, 1, 0, this.f550333a.f550327b.f550349l);
            if (r411 != 0) goto L15;
            int r112 = 1;
        L16:
            r111.e(new g(r100, null, 0, 0, 0, r112, 1, r412, 0), new uj4.a(9, ""));
            if (r411 != 0) goto L19;
            int r113 = 1;
        L20:
            r111.b(3, r100, r101, r310, r311, r113, r412, 9, r413, r414, r415, r102, 0, 0, 0, 1, 0, this.f550333a.f550327b.f550349l);
            goto L22
        L19:
            r113 = 0;
            goto L20
        L15:
            r112 = 0;
            goto L16
        L21:
            qk4.g r114 = b.f550325h;
            r114.e(new g(r100, null, 0, 0, 0, r411, 1, r412, 0), new uj4.a(9, ""));
            r114.b(3, r100, r101, r310, r311, r411, r412, 9, r413, r414, r415, r102, 0, 0, 0, 1, 0, this.f550333a.f550327b.f550349l);
            goto L22
        L23:
            r110 = 1;
            goto L24
        }

        public a(b r100, Looper r101) {
            this.f550333a = r100;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: uj4.b$b, reason: collision with other inner class name */
    public static class C7891b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f550334a = null;

        static {
            f550334a = new b();
        }
    }

    @Override // hk4.b
    public final void B(byte[] r100) {
    }

    @Override // hk4.b
    public final void m(byte[] r100) {
    }

    @Override // hk4.b
    public final void t(byte[] r100) {
    }

    @Override // hk4.b
    public final void z(byte[] r100) {
    }

    static {
        ArrayMap<Integer, hk4.b> r100 = qk4.g.f533513j;
        f550325h = qk4.g.a.f533523a;
    }

    public final int c() {
        byte[] r100 = this.f550330e;
        if (r100 != null) goto L7;
        return n();
    L7:
        if (r100.length < 1) goto L10;
        pk4.j.a("DoraCamera", "checkTakeImageEnable updateBurstTakeImageConfig: " + r100[0]);
        return r100[0];
    L10:
        return -1;
    }

    public b() {
        this.f550326a = ak4.a.d();
        this.f550328c = new d();
        this.f550329d = new a(this, Looper.getMainLooper());
        this.f550330e = null;
        this.f550331f = null;
        this.f550332g = null;
    }

    public static Boolean e() {
        DoraDevice r100 = kj4.a.g().c();
        if (r100 == null) goto L11;
        if (r100.productId != ProductNameType.DORA_E.getId()) goto L7;
    L8:
        pk4.j.a("DoraCamera", "isSupportCamera: true");
        return Boolean.TRUE;
    L7:
        if (ProductNameType.isDoraGSeriesProduct(r100.productId) == true) goto L8;
    L11:
        return Boolean.FALSE;
    }

    public final int b() {
        if (c() != (-1)) goto L5;
        return -1;
    L5:
        byte[] r100 = this.f550331f;
        if (r100 != null) goto L10;
        return l();
    L10:
        if (r100.length < 1) goto L13;
        pk4.j.a("DoraCamera", "checkBurstTakeImageEnable updateBurstTakeImageConfig: " + r100[0]);
        return r100[0];
    L13:
        return -1;
    }

    public final byte d() {
        if (e().booleanValue() == true) goto L7;
        pk4.j.a("DoraCamera", "getVpuEnable: RET_FAIL_OR_NONSUPPORT_CAMERA -1");
        return -1;
    L7:
        if (this.f550332g != null) goto L9;
        this.f550326a.h(1, 4, n.b(1, 4, 12), new byte[]{12, 0});
    L9:
        byte[] r100 = this.f550332g;
        if (r100 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r100.length < 1) goto L15;
        pk4.j.a("DoraCamera", "getVpuEnable: " + r100[0]);
        return r100[0];
    }

    public final byte l() {
        if (e().booleanValue() == true) goto L7;
        pk4.j.a("DoraCamera", "takeBurstTakeImageEnable return RET_FAIL_OR_NONSUPPORT_CAMERA isNotSupportCamera");
        return -1;
    L7:
        if (c() != (-1)) goto L11;
        pk4.j.a("DoraCamera", "takeBurstTakeImageEnable return RET_FAIL_OR_NONSUPPORT_CAMERA first");
        return -1;
    L11:
        if (this.f550331f != null) goto L13;
        this.f550326a.h(1, 4, n.b(1, 4, 8), new byte[]{8, 0});
    L13:
        byte[] r100 = this.f550331f;
        if (r100 != null) goto L16;
    L19:
        pk4.j.a("DoraCamera", "takeBurstTakeImageEnable return RET_FAIL_OR_NONSUPPORT_CAMERA last");
        return -1;
    L16:
        if (r100.length < 1) goto L19;
        pk4.j.a("DoraCamera", "takeBurstTakeImageEnable updateBurstTakeImageConfig: " + r100[0]);
        return r100[0];
    }

    public final byte n() {
        if (e().booleanValue() == true) goto L5;
        return -1;
    L5:
        byte[] r100 = this.f550330e;
        if (r100 != null) goto L8;
        this.f550326a.h(1, 4, n.b(1, 4, 7), new byte[]{7, 0});
        r100 = this.f550330e;
    L8:
        if (r100 != null) goto L10;
    L13:
        return -1;
    L10:
        if (r100.length < 1) goto L13;
        return r100[0];
    }

    @Override // hk4.b
    public final void a(int r100) {
        f550325h.a(r100);
    }

    public final int f(byte r100) {
        int r101 = this.f550326a.i(1, 4, new byte[]{8, 1, r100});
        if (r101 != 0) goto L5;
        pk4.j.a("DoraCamera", "syncBurstTakeImageEnable isEnable: " + r100);
        this.f550331f = new byte[]{r100};
    L5:
        return r101;
    }

    public final int g(c r110) {
        pk4.j.a("DoraCamera", "syncCameraEvent: " + r110);
        if ((r110 instanceof k) == false) goto L6;
        ak4.a r100 = this.f550326a;
        byte[] r111 = {52, 1, (byte) ((k) r110).f550378a};
        DoraSppLink r101 = r100.f4000a;
        r101.getClass();
        return r101.E(2, 5, n.c(2, 5, r111), 0, r111);
    L6:
        ArrayList r102 = new ArrayList();
        e r103 = this.f550327b;
        if (r103 == null) goto L9;
        int r104 = r103.f550338a;
    L11:
        if ((r110 instanceof i) == false) goto L14;
        KeyLogUtils.LogType r112 = KeyLogUtils.LogType.ERROR;
        String r113 = String.valueOf(0);
        KeyLogUtils.DataLink r114 = KeyLogUtils.DataLink.IMAGE;
        String r115 = String.valueOf(r104);
        KeyLogUtils.DataFlowDirection r116 = KeyLogUtils.DataFlowDirection.DOWNLINK;
        KeyLogUtils.a r105 = new KeyLogUtils.a();
        i r117 = (i) r110;
        r105.a("error_code", 0);
        KeyLogUtils.a(r112, r113, r114, r115, r116, "pic_transfer_error", r105, "picture transfer error");
        n.d(r102, new byte[][]{new byte[]{-112, 9}, new byte[]{1, 1, (byte) 0}, n.u(new byte[]{2, 4}, n.l(0))});
    L14:
        if ((r110 instanceof j) == false) goto L21;
        KeyLogUtils.LogType r106 = KeyLogUtils.LogType.KEY;
        String r118 = String.valueOf(0);
        KeyLogUtils.DataLink r119 = KeyLogUtils.DataLink.IMAGE;
        String r120 = String.valueOf(r104);
        KeyLogUtils.DataFlowDirection r121 = KeyLogUtils.DataFlowDirection.DOWNLINK;
        KeyLogUtils.a r122 = new KeyLogUtils.a();
        j r107 = (j) r110;
        r122.a("mode", r107.f550375a);
        r122.f204495a.put("timeInterval", r107.f550376b);     // Catch: JSONException -> L18
    L20:
        r122.a("definitionValue", r107.f550377c);
        KeyLogUtils.a(r106, r118, r119, r120, r121, "take_cmd", r122, "-");
        n.d(r102, new byte[][]{new byte[]{-113, 12}, new byte[]{1, 1, (byte) r107.f550375a}, n.u(new byte[]{2, 4}, n.l(r107.f550376b)), new byte[]{3, 1, (byte) r107.f550377c}});
    L18:
        e = move-exception;
        pk4.j.b("KeyLogUtils", "JSONBuilder add field error, key: timeInterval, exception: " + e);
    L21:
        ak4.a r108 = this.f550326a;
        byte[] r109 = n.w(r102);
        DoraSppLink r123 = r108.f4000a;
        r123.getClass();
        return r123.E(2, 7, n.c(2, 7, r109), 0, r109);
    L9:
        r104 = 0;
        goto L11
    }

    public final int h(boolean r100) {
        ak4.a r101 = this.f550326a;
        byte[] r102 = new byte[3];
        r102[0] = 30;
        r102[1] = 1;
        if (r100 == false) goto L5;
        int r103 = 2;
    L6:
        r102[2] = (byte) r103;
        return r101.i(1, 4, r102);
    L5:
        r103 = 1;
        goto L6
    }

    public final int i(boolean r100) {
        byte r101 = r100 ? 1 : 0;
        return this.f550326a.h(2, 13, n.b(2, 13, 4), new byte[]{4, 1, r101});
    }

    public final int j(byte r100) {
        int r101 = this.f550326a.i(1, 4, new byte[]{7, 1, r100});
        if (r101 != 0) goto L5;
        this.f550330e = new byte[]{r100};
    L5:
        return r101;
    }

    @Override // hk4.b
    public final void u(byte[] r100) {
        this.f550330e = r100;
    }

    @Override // hk4.b
    public final void v(byte[] r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        StringBuilder r102 = new StringBuilder("updateBurstTakeImageConfig: data: ");
        if (r100 != null) goto L10;
        r101 = true;
    L10:
        r102.append(r101);
        pk4.j.a("DoraCamera", r102.toString());
        this.f550331f = r100;
        return;
    L5:
        if (r100.length < 1) goto L7;
        pk4.j.a("DoraCamera", "updateBurstTakeImageConfig: " + r100[0]);
        goto L7
    }

    @Override // hk4.b
    public final void x(byte[] r100) {
        if (r100 != null) goto L5;
    L7:
        pk4.j.a("DoraCamera", "updateVpuConfig: " + r100);
        this.f550332g = r100;
        return;
    L5:
        if (r100.length < 1) goto L7;
        pk4.j.a("DoraCamera", "updateVpuConfig: " + r100[0]);
        goto L7
    }

    @Override // hk4.b
    public final void p(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117) {
        e r100 = this.f550327b;
        if (r100 == null) goto L6;
        this.f550328c.e(r100, r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    }

    @Override // hk4.b
    public final void o(int r210, byte[] r211, int r212, int r213, int r214, int r215, int r216, int r217, int r310, int r311, long r312) {
        e r100 = this.f550327b;
        if (r100 != null) goto L5;
        f550325h.e(new g(r210, r211, r214, r215, 0, r217, 1, r311, r312), new uj4.a(1, ""));
        return;
    L5:
        if (TextUtils.isEmpty(r100.f550359v) == false) goto L7;
    L15:
        f550325h.e(new g(r210, r211, r214, r215, 0, r217, 1, r311, r312), new uj4.a(1, ""));
    L16:
        this.f550328c.c(this.f550327b, r210, r212, r214, r215, r216, r217);
        return;
    L7:
        if (this.f550327b.f550359v.length() != 64) goto L15;
        if (this.f550327b.f550338a != r210) goto L15;
        long r101 = System.currentTimeMillis();
        String r102 = n.q(r211);
        long r110 = System.currentTimeMillis() - r101;
        if (TextUtils.equals(r102, this.f550327b.f550359v) == false) goto L13;
        this.f550327b.f550348k = 1;
        f550325h.e(new g(r210, r211, r214, r215, 0, r217, 1, r311, r312), new uj4.a(1, ""));
    L14:
        e r103 = this.f550327b;
        r103.f550360w = r102;
        r103.f550357t = r110;
        goto L16
    L13:
        this.f550327b.f550348k = 0;
        f550325h.e(new g(r210, r211, r214, r215, 0, r217, 1, r311, r312), new uj4.a(11, ""));
        goto L14
    }

    @Override // hk4.b
    public final void y(int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r310, int r311, int r312, int r313, int r314) {
        e r100 = this.f550327b;
        if (r100 != null) goto L5;
    L9:
        e r101 = new e(r211, r216, r214, r311, r312);
        this.f550327b = r101;
        r101.f550349l = r314;
        this.f550329d.removeMessages(1);
        Message r102 = this.f550329d.obtainMessage(1);
        r102.getData().putInt("key_camera_image_stage", r210);
        r102.getData().putInt("key_camera_image_uuid", r211);
        r102.getData().putInt("key_wkr_id", r212);
        r102.getData().putInt("key_vui_id", r213);
        r102.getData().putInt("key_camera_image_count", r214);
        r102.getData().putInt("key_camera_side", r215);
        r102.getData().putInt("key_camera_mode", r216);
        r102.getData().putInt("key_image_width", r217);
        r102.getData().putInt("key_image_height", r310);
        r102.getData().putInt("key_image_quality_value", r311);
        r102.getData().putInt("key_image_definition_value", r312);
        this.f550329d.sendMessageDelayed(r102, 15000);
        f550325h.b(r210, r211, r212, r213, r214, r215, r216, 1, r217, r310, r311, r312, r313, 0, 0, 1, 0, r314);
        this.f550328c.b(this.f550327b, r211, r213, r214, r215, r216, r217, r310, r311, r312, r313);
        return;
    L5:
        if (r100.f550338a != r211) goto L9;
        f550325h.b(r210, r211, r212, r213, r214, r215, r216, 1, r217, r310, r311, r312, r313, 0, 0, 1, 0, r314);
    }

    @Override // hk4.b
    public final void s(int r310, int r311, int r312, int r313, int r314, int r410, int r411, int r412, int r413, int r414, int r415, int r416, int r417, Map<String, Object> r418, DoraGImageTrack r419) {
        e r100 = this.f550327b;
        if (r100 == null) goto L5;
        int r210 = r100.f550347j;
    L6:
        int r315 = ((Integer) n.p(r418, "camera_output_strategy", Integer.class, 0)).intValue();
        int r316 = ((Integer) n.p(r418, "ocr_text_lines", Integer.class, 0)).intValue();
        qk4.g r110 = f550325h;
        e r101 = this.f550327b;
        if (r101 == null) goto L9;
        int r317 = r101.f550349l;
    L10:
        r110.b(r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r415, r416, r417, r210, 0, r315, r316, r317);
        e r102 = this.f550327b;
        if (r102 == null) goto L14;
        this.f550328c.d(this.f550329d, r102, r311, r314, r410, r412, r413, r414, r415, r416, r417, r418, r419);
        return;
    L14:
        return;
    L9:
        r317 = 0;
        goto L10
    L5:
        r210 = 0;
        goto L6
    }

    @Override // hk4.b
    public final void k(int r310, int r410, int r411, int r412, int r413, int r414, int r415, int r416, String r417, int r418, int r419, int r510, int r511, int r512, int r513, long r514, Map<String, Object> r515) {
        int r210 = ((Integer) n.p(r515, "camera_output_strategy", Integer.class, 0)).intValue();
        int r211 = ((Integer) n.p(r515, "ocr_text_lines", Integer.class, 0)).intValue();
        String r100 = (String) n.p(r515, "sha256", String.class, "");
        long r110 = ((Long) n.p(r515, "sha256_cost", Long.class, 0L)).longValue();
        qk4.g r101 = f550325h;
        e r102 = this.f550327b;
        if (r102 == null) goto L5;
        int r212 = r102.f550349l;
    L6:
        r101.b(r310, r410, r411, r412, r413, r414, r415, 1, r418, r419, r510, r511, r512, r513, r514, r210, r211, r212);
        e r103 = this.f550327b;
        if (r103 == null) goto L10;
        r103.f550347j = r513;
        r103.f550359v = r100;
        r103.f550356s = r110;
        this.f550328c.f(r103, r410, r412, r413, r414, r415, r416, r418, r419, r510, r511, r512);
        return;
    L10:
        return;
    L5:
        r212 = 0;
        goto L6
    }
}
