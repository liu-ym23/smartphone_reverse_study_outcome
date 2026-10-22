package uj4;

import android.text.TextUtils;
import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.dora.camera.DoraCameraEventSequenceError;
import com.bytedance.dora.camera.DoraCameraTrackEvent;
import com.bytedance.dora.protocol.jni_entity.DoraGBtLinkStatus;
import com.bytedance.dora.protocol.jni_entity.DoraGDeviceStatus;
import com.bytedance.dora.protocol.jni_entity.DoraGImageTrack;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pk4.l;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f550335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Object f550336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile transient boolean f550337c;

    public d() {
        this.f550335a = new ArrayList();
        this.f550336b = new Object();
        this.f550337c = false;
    }

    public final Pair<DoraCameraEventSequenceError, Double> a(f r110) {
        Object r100 = this.f550336b;
        monitor-enter(r100);
    L128:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f550335a).isEmpty() == true) goto L125;
        boolean r101 = false;
        DoraCameraTrackEvent r102 = ((f) ((ArrayList) this.f550335a).get(0)).f550362b;     // Catch: Throwable -> L128
        r102.getClass();     // Catch: Throwable -> L128
        int[] r103 = DoraCameraTrackEvent.a.f204388a;     // Catch: Throwable -> L128
        int r104 = r103[r102.f204385a.ordinal()];     // Catch: Throwable -> L128
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 == 3) goto L15;
        if (r104 == 4) goto L14;
        if (r104 == 5) goto L13;
        String r105 = "unknown_event";
    L19:
        if (TextUtils.equals(r105, "dora_take_image_start") == false) goto L125;
        List<f> r106 = this.f550335a;     // Catch: Throwable -> L128
        f r107 = (f) ((ArrayList) r106).get(((ArrayList) r106).size() - 1);     // Catch: Throwable -> L128
        int r108 = ((ArrayList) this.f550335a).size();     // Catch: Throwable -> L128
        ((ArrayList) this.f550335a).add(r110);     // Catch: Throwable -> L128
        monitor-exit(r100);     // Catch: Throwable -> L128
        DoraCameraTrackEvent r109 = r110.f550362b;
        DoraCameraTrackEvent r111 = r107.f550362b;
        r109.getClass();
        int r112 = r103[r109.f204385a.ordinal()];
        if (r112 == 1) goto L51;
        if (r112 == 2) goto L45;
        if (r112 == 3) goto L40;
        if (r112 == 4) goto L35;
        if (r112 != 5) goto L50;
        int r113 = r109.f204386b;
        if (r113 != 1) goto L33;
        Integer r114 = 4;
    L52:
        if (r114 != null) goto L54;
    L118:
        DoraCameraEventSequenceError r115 = DoraCameraEventSequenceError.OUT_OF_ORDER;
    L119:
        pk4.j.d("DoraCameraEventHelper", "sequenceError : " + r115);
        DoraCameraEventSequenceError r116 = DoraCameraEventSequenceError.NONE;
        if (r115 == r116) goto L122;
        this.f550337c = true;
        return new Pair(r115, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
    L122:
        return new Pair(r116, Double.valueOf(r110.f550363c - r107.f550363c));
    L54:
        if (r114.intValue() != r108) goto L118;
        if (r111 == null) goto L115;
        int r117 = r103[r109.f204385a.ordinal()];
        if (r117 == 1) goto L114;
        if (r117 == 2) goto L104;
        if (r117 == 3) goto L91;
        if (r117 == 4) goto L78;
        if (r117 != 5) goto L115;
        int r118 = r109.f204386b;
        if (r118 == 1) goto L68;
    L72:
        if (r118 != 2) goto L115;
        if (r111.f204385a != DoraCameraTrackEvent.EventType.LAST_FRAME) goto L115;
        if (r111.f204386b != 2) goto L115;
    L68:
        if (r111.f204385a != DoraCameraTrackEvent.EventType.LAST_FRAME) goto L72;
        if (r111.f204386b != 1) goto L72;
    L78:
        int r119 = r109.f204386b;
        if (r119 == 1) goto L81;
    L85:
        if (r119 != 2) goto L115;
        if (r111.f204385a != DoraCameraTrackEvent.EventType.FIRST_FRAME) goto L115;
        if (r111.f204386b != 2) goto L115;
    L81:
        if (r111.f204385a != DoraCameraTrackEvent.EventType.FIRST_FRAME) goto L85;
        if (r111.f204386b != 1) goto L85;
    L91:
        int r120 = r109.f204386b;
        if (r120 == 1) goto L94;
    L98:
        if (r120 != 2) goto L115;
        if (r111.f204385a != DoraCameraTrackEvent.EventType.TRANSMIT_START) goto L115;
        if (r111.f204386b != 2) goto L115;
    L94:
        if (r111.f204385a != DoraCameraTrackEvent.EventType.TRANSMIT_START) goto L98;
        if (r111.f204386b != 1) goto L98;
    L104:
        int r121 = r109.f204386b;
        if (r121 == 1) goto L107;
    L109:
        if (r121 != 2) goto L115;
        if (r111.f204385a != DoraCameraTrackEvent.EventType.TRANSMIT_END) goto L115;
        if (r111.f204386b != 1) goto L115;
    L107:
        if (r111.f204385a != DoraCameraTrackEvent.EventType.TAKE_IMAGE_START) goto L109;
    L114:
        r101 = true;
    L115:
        if (r101 == false) goto L117;
        r115 = DoraCameraEventSequenceError.NONE;
        goto L119
    L117:
        r115 = DoraCameraEventSequenceError.PRE_EVENT_ERROR;
        goto L119
    L33:
        if (r113 != 2) goto L50;
        r114 = 8;
    L50:
        r114 = null;
        goto L52
    L35:
        int r122 = r109.f204386b;
        if (r122 != 1) goto L38;
        r114 = 3;
        goto L52
    L38:
        if (r122 != 2) goto L50;
        r114 = 7;
        goto L52
    L40:
        int r123 = r109.f204386b;
        if (r123 != 1) goto L43;
        r114 = 2;
        goto L52
    L43:
        if (r123 != 2) goto L50;
        r114 = 6;
        goto L52
    L45:
        int r124 = r109.f204386b;
        if (r124 != 1) goto L48;
        r114 = 1;
        goto L52
    L48:
        if (r124 != 2) goto L50;
        r114 = 5;
        goto L52
    L51:
        r114 = 0;
        goto L52
    L13:
        r105 = "dora_image_transmit_end";
        goto L19
    L14:
        r105 = "dora_image_last_frame";
        goto L19
    L15:
        r105 = "dora_image_first_frame";
        goto L19
    L16:
        r105 = "dora_image_transmit_start";
        goto L19
    L17:
        r105 = "dora_take_image_start";
    L125:
        ((ArrayList) this.f550335a).add(r110);     // Catch: Throwable -> L128
        pk4.j.d("DoraCameraEventHelper", "trackItems size: " + ((ArrayList) this.f550335a).size() + ", eventName: dora_take_image_start");     // Catch: Throwable -> L128
        this.f550337c = true;     // Catch: Throwable -> L128
        Pair<DoraCameraEventSequenceError, Double> r125 = new Pair(DoraCameraEventSequenceError.LOSS_TAKE_IMAGE_EVENT, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));     // Catch: Throwable -> L128
        monitor-exit(r100);     // Catch: Throwable -> L128
        return r125;
    }

    public final void c(e r110, int r111, int r112, int r113, int r114, int r115, int r210) {
        if (r110 == null) goto L10;
        long r116 = System.currentTimeMillis();
        Pair<DoraCameraEventSequenceError, Double> r100 = a(new f(r111, new DoraCameraTrackEvent(DoraCameraTrackEvent.EventType.LAST_FRAME, r110.f550341d), r116, r110.f550340c, r210));
        HashMap r101 = new HashMap();
        long r117 = r116 - r110.f550354q;
        r101.put("image_uuid", Integer.valueOf(r111));
        r101.put("image_mode", Integer.valueOf(r110.f550340c));
        r101.put("side", Integer.valueOf(r210));
        r101.put(ILoadStallMonitor.START_TIME, Long.valueOf(System.currentTimeMillis()));
        r101.put("height", Integer.valueOf(r114));
        r101.put("width", Integer.valueOf(r113));
        r101.put("data_length", Integer.valueOf(r112));
        r101.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r110.f550342e));
        r101.put("is_sequence_error", Integer.valueOf(this.f550337c ? 1 : 0));
        r101.put("sequence_error_code", Integer.valueOf(((DoraCameraEventSequenceError) r100.first).getCode()));
        r101.put("image_index", Integer.valueOf(r110.f550341d));
        r101.put("duration", Long.valueOf(r117));
        r101.put(LocationMonitorConst.IS_TIMEOUT, Integer.valueOf(r110.f550339b ? 1 : 0));
        r101.put("timeout_duration", 15000);
        r101.put("quality_value", Integer.valueOf(r110.f550343f));
        r101.put("definition_value", Integer.valueOf(r110.f550344g));
        r101.put("link_type", Integer.valueOf(r110.f550345h));
        r101.put(SubInfo.KEY_FORMAT, Integer.valueOf(r115));
        if (r117 <= 0) goto L8;
        if (r112 <= 0) goto L8;
        double r102 = ((double) (r112 * 1000)) / (r117 * 1024);
        r101.put("receive_speed", Double.valueOf(r102));
        r110.f550358u = r102;
    L8:
        pk4.j.a("DoraCameraEventHelper", "onImageFrame :" + r110.toString());
        l.c(l.f529649q, r101);
        return;
    }

    public final void e(e r110, int r111, int r112, int r210, int r211, int r212, int r213, int r214, int r215) {
        long r100 = System.currentTimeMillis();
        if (r112 != 0) goto L25;
        if (r110 != null) goto L7;
        int r101 = 1;
    L8:
        DoraCameraTrackEvent r102 = new DoraCameraTrackEvent(DoraCameraTrackEvent.EventType.FIRST_FRAME, r101);
        if (r110 != null) goto L11;
        int r103 = 0;
    L12:
        Pair<DoraCameraEventSequenceError, Double> r104 = a(new f(r111, r102, r100, r103, r215));
        if (r110 == null) goto L29;
        int r105 = r110.f550342e;
        r110.f550346i = r211;
        HashMap r106 = new HashMap();
        r106.put("image_uuid", Integer.valueOf(r111));
        r106.put("image_mode", Integer.valueOf(r110.f550340c));
        r106.put("side", Integer.valueOf(r215));
        r106.put(ILoadStallMonitor.START_TIME, Long.valueOf(r100));
        r106.put("height", Integer.valueOf(r213));
        r106.put("width", Integer.valueOf(r212));
        if (r105 != 1) goto L18;
        r106.put("duration", Long.valueOf(r100 - r110.f550351n));
    L23:
        r106.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r110.f550342e));
        r106.put("image_index", Integer.valueOf(r110.f550341d));
        r106.put(LocationMonitorConst.IS_TIMEOUT, Integer.valueOf(r110.f550339b ? 1 : 0));
        r106.put("timeout_duration", 15000);
        r106.put("is_sequence_error", Integer.valueOf(this.f550337c ? 1 : 0));
        r106.put("sequence_error_code", Integer.valueOf(((DoraCameraEventSequenceError) r104.first).getCode()));
        r106.put("quality_value", Integer.valueOf(r110.f550343f));
        r106.put("definition_value", Integer.valueOf(r110.f550344g));
        r106.put("link_type", Integer.valueOf(r110.f550345h));
        r106.put("image_format", Integer.valueOf(r214));
        r106.put("image_mode", Integer.valueOf(r110.f550340c));
        r106.put("width", Integer.valueOf(r212));
        r106.put("height", Integer.valueOf(r213));
        r106.put("data_length", Integer.valueOf(r211));
        pk4.j.a("DoraCameraEventHelper", "onImageFrame :" + r110.toString());
        l.c(l.f529648p, r106);
        r110.f550354q = r100;
        return;
    L18:
        if (r105 != 2) goto L23;
        if (r110.f550341d != 1) goto L22;
        r106.put("duration", Long.valueOf(r100 - r110.f550351n));
        goto L23
    L22:
        r106.put("duration", Long.valueOf(r100 - r110.f550352o));
        goto L23
    L29:
        return;
    L11:
        r103 = r110.f550340c;
        goto L12
    L7:
        r101 = r110.f550341d;
        goto L8
    L25:
        if (r112 != (r210 - 1)) goto L31;
        if (r110 == null) goto L32;
        r110.f550355r = r100;
        pk4.j.a("DoraCameraEventHelper", "set lastFrameImageTimeMillis :" + r100);
        return;
    L32:
        return;
    }

    public final void b(e r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210) {
        long r100 = System.currentTimeMillis();
        HashMap r101 = new HashMap();
        r110.f550350m = r100;
        ak4.a r102 = vk4.f.f555491c;
        int r103 = vk4.f.a.f555494a.f555492a.f555500f;
        r101.put("image_uuid", Integer.valueOf(r111));
        r101.put("vui_id", Integer.valueOf(r112));
        r101.put("side", Integer.valueOf(r114));
        r101.put(ILoadStallMonitor.START_TIME, Long.valueOf(r100));
        r101.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r113));
        r101.put("is_sequence_error", Integer.valueOf(this.f550337c ? 1 : 0));
        r101.put("definition_value", Integer.valueOf(r119));
        r101.put("link_type", Integer.valueOf(r103));
        r101.put(SubInfo.KEY_FORMAT, Integer.valueOf(r210));
        r101.put("image_mode", Integer.valueOf(r115));
        r101.put("quality_value", Integer.valueOf(r118));
        r101.put("width", Integer.valueOf(r116));
        r101.put("height", Integer.valueOf(r117));
        l.c(l.f529646n, r101);
        pk4.j.a("DoraCameraEventHelper", "image_start doraCameraTimeOutInfo :" + r110.toString());
        f r104 = new f(r111, new DoraCameraTrackEvent(DoraCameraTrackEvent.EventType.TAKE_IMAGE_START, r110.f550341d), r100, r115, r114);
        Object r105 = this.f550336b;
        monitor-enter(r105);
        pk4.j.d("DoraCameraEventHelper", "clear");     // Catch: Throwable -> L7
        ((ArrayList) this.f550335a).clear();     // Catch: Throwable -> L7
        this.f550337c = false;     // Catch: Throwable -> L7
        ((ArrayList) this.f550335a).add(r104);     // Catch: Throwable -> L7
        monitor-exit(r105);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f(e r110, int r111, int r112, int r113, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217) {
        long r114 = System.currentTimeMillis();
        if (r110 != null) goto L5;
        int r100 = 1;
    L6:
        Pair<DoraCameraEventSequenceError, Double> r101 = a(new f(r111, new DoraCameraTrackEvent(DoraCameraTrackEvent.EventType.TRANSMIT_START, r100), r114, r211, r210));
        if (r110 != null) goto L9;
        pk4.j.b("DoraCameraEventHelper", "onCameraImageTransmitStart error onTakeImageState doraCameraTimeOutInfo is null");
        return;
    L9:
        if (r110.f550341d != 1) goto L11;
        r110.f550351n = System.currentTimeMillis();
    L12:
        pk4.j.a("DoraCameraEventHelper", "onCameraImageTransmitStart firstTransFinishTimeMillis doraCameraTimeOutInfo :" + r110.toString());
        pk4.j.d("DoraCameraEventHelper", "onCameraImageTransmitStart imageStage : ---------,imageUuid:" + r111);
        if (r110.f550339b == false) goto L16;
        pk4.j.d("DoraCameraEventHelper", "onCameraImageTransmitStart hasTimeOut : ---------,imageUuid:" + r111 + "-" + r110.f550339b);
        return;
    L16:
        int r102 = r110.f550341d;
        r110.f550345h = r212;
        HashMap r103 = new HashMap();
        r103.put("image_uuid", Integer.valueOf(r111));
        r103.put("vui_id", Integer.valueOf(r112));
        r103.put("image_mode", Integer.valueOf(r211));
        r103.put("side", Integer.valueOf(r210));
        r103.put(ILoadStallMonitor.START_TIME, Long.valueOf(r114));
        r103.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r110.f550342e));
        r103.put("image_index", Integer.valueOf(r102));
        if (r113 != 1) goto L20;
        r103.put("duration", Long.valueOf(r114 - r110.f550350m));
    L24:
        r103.put("is_sequence_error", Integer.valueOf(this.f550337c ? 1 : 0));
        r103.put("sequence_error_code", Integer.valueOf(((DoraCameraEventSequenceError) r101.first).getCode()));
        r103.put(LocationMonitorConst.IS_TIMEOUT, Integer.valueOf(r110.f550339b ? 1 : 0));
        r103.put("timeout_duration", 15000);
        r103.put("definition_value", Integer.valueOf(r216));
        r103.put("link_type", Integer.valueOf(r212));
        r103.put(SubInfo.KEY_FORMAT, Integer.valueOf(r217));
        r103.put("image_mode", Integer.valueOf(r211));
        r103.put("quality_value", Integer.valueOf(r215));
        r103.put("width", Integer.valueOf(r213));
        r103.put("height", Integer.valueOf(r214));
        r103.put("data_length", Integer.valueOf(r110.f550346i));
        r103.put("has_ocr", Integer.valueOf(r110.f550347j));
        pk4.j.a("DoraCameraEventHelper", "onCameraImageTransmitStart doraCameraTimeOutInfo :" + r110);
        l.c(l.f529647o, r103);
        return;
    L20:
        if (r113 != 2) goto L24;
        if (r102 != 1) goto L23;
        r103.put("duration", Long.valueOf(r114 - r110.f550350m));
        goto L24
    L23:
        r103.put("duration", Long.valueOf(r114 - r110.f550353p));
        goto L24
    L11:
        r110.f550352o = System.currentTimeMillis();
        goto L12
    L5:
        r100 = r110.f550341d;
        goto L6
    }

    public final void d(b.a r110, e r111, int r112, int r113, int r114, int r115, int r210, int r211, int r212, int r213, int r214, Map r215, DoraGImageTrack r216) {
        long r100 = System.currentTimeMillis();
        if (r111 != null) goto L5;
        int r101 = 1;
    L6:
        DoraCameraTrackEvent r102 = new DoraCameraTrackEvent(DoraCameraTrackEvent.EventType.TRANSMIT_END, r101);
        if (r111 != null) goto L9;
        int r103 = 0;
    L10:
        Pair<DoraCameraEventSequenceError, Double> r104 = a(new f(r112, r102, r100, r103, r114));
        if (r111 != null) goto L13;
        pk4.j.b("DoraCameraEventHelper", "onCameraImageTransmitEnd reportTransmitEnd doraCameraTimeOutInfo is null");
    L77:
        if (r111 != null) goto L79;
        pk4.j.b("DoraCameraEventHelper", "onCameraImageTransmitEnd error onTakeImageState doraCameraTimeOutInfo is null");
        return;
    L79:
        if (r111.f550341d != 1) goto L81;
        r111.f550353p = System.currentTimeMillis();
        pk4.j.a("DoraCameraEventHelper", "onCameraImageTransmitEnd firstTransFinishTimeMillis doraCameraTimeOutInfo :" + r111.toString());
    L81:
        pk4.j.a("DoraCameraEventHelper", "onCameraImageTransmitEnd imageTransmitEnd doraCameraTimeOutInfo :" + r111.toString());
        int r105 = r111.f550341d;
        if (r105 != r111.f550342e) goto L84;
        r110.removeMessages(1);
        r111.f550338a = 0;
        r111.f550340c = 0;
        r111.f550339b = false;
        r111.f550341d = 1;
        r111.f550342e = 0;
        r111.f550345h = 0;
        r111.f550346i = 0;
        r111.f550347j = 0;
        r111.f550350m = 0;
        r111.f550343f = 0;
        r111.f550344g = 0;
        return;
    L84:
        r111.f550341d = r105 + 1;
        return;
    L13:
        long r106 = System.currentTimeMillis();
        HashMap r107 = new HashMap();
        r107.put("image_uuid", Integer.valueOf(r112));
        r107.put("side", Integer.valueOf(r114));
        r107.put(ILoadStallMonitor.START_TIME, Long.valueOf(System.currentTimeMillis()));
        r107.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r111.f550342e));
        r107.put("image_index", Integer.valueOf(r113));
        r107.put("result", Integer.valueOf(r115));
        r107.put("duration", Long.valueOf(r106 - r111.f550355r));
        r107.put("total_duration", Long.valueOf(r106 - r111.f550350m));
        r107.put(LocationMonitorConst.IS_TIMEOUT, Integer.valueOf(r111.f550339b ? 1 : 0));
        r107.put("is_sequence_error", Integer.valueOf(this.f550337c ? 1 : 0));
        r107.put("sequence_error_code", Integer.valueOf(((DoraCameraEventSequenceError) r104.first).getCode()));
        r107.put("timeout_duration", 15000);
        r107.put("definition_value", Integer.valueOf(r213));
        r107.put("link_type", Integer.valueOf(r111.f550345h));
        r107.put(SubInfo.KEY_FORMAT, Integer.valueOf(r214));
        r107.put("image_mode", Integer.valueOf(r111.f550340c));
        r107.put("quality_value", Integer.valueOf(r212));
        r107.put("width", Integer.valueOf(r210));
        r107.put("height", Integer.valueOf(r211));
        r107.put("data_length", Integer.valueOf(r111.f550346i));
        r107.put("has_ocr", Integer.valueOf(r111.f550347j));
        String r108 = r111.f550359v;
        String r109 = "";
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        r107.put("sha256", r108);
        r107.put("sha256_cost", Long.valueOf(r111.f550356s));
        r107.put("is_sha256_equal", Integer.valueOf(r111.f550348k));
        r107.put("phone_sha256_cost", Long.valueOf(r111.f550357t));
        if (r111.f550348k != 0) goto L23;
        String r116 = r111.f550360w;
        if (r116 == null) goto L22;
        r109 = r116;
    L22:
        r107.put("phone_sha256", r109);
    L23:
        if (r216 == null) goto L25;
        int r117 = r216.startCmd2800ToAr1Duration;
    L26:
        r107.put("start_cmd_2800_to_ar1_duration", Integer.valueOf(r117));
        if (r216 == null) goto L29;
        int r118 = r216.finishCmdAr1To2800Duration;
    L30:
        r107.put("finish_cmd_ar1_to_2800_duration", Integer.valueOf(r118));
        if (r216 == null) goto L33;
        int r119 = r216.captureTotal;
    L34:
        r107.put("capture_total", Integer.valueOf(r119));
        if (r216 == null) goto L37;
        int r120 = r216.transferTotal;
    L38:
        r107.put("transfer_total", Integer.valueOf(r120));
        if (r216 == null) goto L41;
        int r121 = r216.spiFirstFrameReceiveDuration;
    L42:
        r107.put("spi_first_frame_receive_duration", Integer.valueOf(r121));
        if (r216 == null) goto L45;
        int r122 = r216.spiReceiveDuration;
    L46:
        r107.put("spi_receive_duration", Integer.valueOf(r122));
        if (r216 == null) goto L49;
        int r123 = r216.bluetoothSendDuration;
    L50:
        r107.put("bluetooth_send_duration", Integer.valueOf(r123));
        if (r216 == null) goto L53;
        int r124 = r216.bluetoothSendSize;
    L54:
        r107.put("bluetooth_send_size", Integer.valueOf(r124));
        if (r216 == null) goto L57;
        int r125 = r216.wifiSendDuration;
    L58:
        r107.put("wifi_send_duration", Integer.valueOf(r125));
        if (r216 == null) goto L69;
        DoraGDeviceStatus r126 = r216.deviceStatus;
        if (r126 == null) goto L69;
        r107.put("rtos_cpu_usage_rate", Integer.valueOf(r126.cpuload));
        r107.put("vui_mode", Integer.valueOf(r216.deviceStatus.vuiMode));
        r107.put("plt_uplink_loss_rate", Integer.valueOf(r216.deviceStatus.pltUplinkLossRate));
        r107.put("ar1_wifi_state", Integer.valueOf(r216.deviceStatus.ar1WifiState));
        r107.put("ble_adv_state", Integer.valueOf(r216.deviceStatus.bleAdvState));
        r107.put("access_mode", Integer.valueOf(r216.deviceStatus.accessMode));
        r107.put("bt_link_num", Integer.valueOf(r216.deviceStatus.btLinkNum));
        DoraGBtLinkStatus r127 = r216.deviceStatus.currBtLinkStatus;
        if (r127 == null) goto L65;
        r107.put("curr_bt_link_id", Integer.valueOf(r127.f204662id));
        r107.put("curr_bt_link_rssi", Integer.valueOf(r216.deviceStatus.currBtLinkStatus.rssi));
        r107.put("curr_bt_link_tx_power", Integer.valueOf(r216.deviceStatus.currBtLinkStatus.txPower));
        r107.put("curr_bt_link_ll_packet_lost_rate", Integer.valueOf(r216.deviceStatus.currBtLinkStatus.packetLost));
        r107.put("curr_bt_link_mode", Integer.valueOf(r216.deviceStatus.currBtLinkStatus.sniffState));
        r107.put("curr_bt_link_a2dp_state", Integer.valueOf(r216.deviceStatus.currBtLinkStatus.a2dpState));
        r107.put("curr_bt_link_hfp_state", Integer.valueOf(r216.deviceStatus.currBtLinkStatus.hfpState));
        r107.put("curr_bt_link_dh35_rate", Integer.valueOf(r216.deviceStatus.currBtLinkStatus._3dh5Rate));
    L65:
        DoraGBtLinkStatus r128 = r216.deviceStatus.nextBtLinkStatus;
        if (r128 == null) goto L68;
        r107.put("next_bt_link_id", Integer.valueOf(r128.f204662id));
        r107.put("next_bt_link_rssi", Integer.valueOf(r216.deviceStatus.nextBtLinkStatus.rssi));
        r107.put("next_bt_link_tx_power", Integer.valueOf(r216.deviceStatus.nextBtLinkStatus.txPower));
        r107.put("next_bt_link_ll_packet_lost_rate", Integer.valueOf(r216.deviceStatus.nextBtLinkStatus.packetLost));
        r107.put("next_bt_link_mode", Integer.valueOf(r216.deviceStatus.nextBtLinkStatus.sniffState));
        r107.put("next_bt_link_a2dp_state", Integer.valueOf(r216.deviceStatus.nextBtLinkStatus.a2dpState));
        r107.put("next_bt_link_hfp_state", Integer.valueOf(r216.deviceStatus.nextBtLinkStatus.hfpState));
        r107.put("next_bt_link_dh35_rate", Integer.valueOf(r216.deviceStatus.nextBtLinkStatus._3dh5Rate));
    L68:
        r107.put("obs_submode", Integer.valueOf(r216.deviceStatus.obsSubmode));
        r107.put("obs_interval", Long.valueOf(r216.deviceStatus.obsInterval));
    L69:
        r107.put("receive_speed", Double.valueOf(r111.f550358u));
        if (r216 == null) goto L76;
        int r129 = r216.bluetoothSendSize;
        if (r129 <= 0) goto L76;
        int r130 = r216.bluetoothSendDuration;
        if (r130 <= 0) goto L76;
        r107.put("send_speed", Double.valueOf(((double) r129) / ((double) r130)));
    L76:
        r107.putAll(r215);
        l.c(l.f529650r, r107);
        goto L77
    L57:
        r125 = 0;
        goto L58
    L53:
        r124 = 0;
        goto L54
    L49:
        r123 = 0;
        goto L50
    L45:
        r122 = 0;
        goto L46
    L41:
        r121 = 0;
        goto L42
    L37:
        r120 = 0;
        goto L38
    L33:
        r119 = 0;
        goto L34
    L29:
        r118 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L9:
        r103 = r111.f550340c;
        goto L10
    L5:
        r101 = r111.f550341d;
        goto L6
    }
}
