package com.larus.avlink.e.mock;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f291809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f291810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f291811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f291812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, ConcurrentHashMap<String, AtomicInteger>> f291813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, List<CallbackSequenceItem>> f291814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Long> f291815g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.avlink.e.mock.j
    public final void c(b49.k r100) {
        Intrinsics.checkNotNullParameter(r100, "trackInfo");
    }

    public final void g() {
        List r100 = CollectionsKt.toList(this.f291814f.keySet());
        if ((!r100.isEmpty()) == false) goto L27;
        FLogger.f375446a.i("CameraMockRecorder", "💾 Flushing " + r100.size() + " pending imageUuid recordings: " + r100);
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L19;
        Integer r102 = (Integer) r101.next();
        Intrinsics.checkNotNull(r102);
        int r103 = r102.intValue();
        int r104 = this.f291811c.get();
        int r105 = this.f291812d.get();
        List<CallbackSequenceItem> r106 = this.f291814f.get(Integer.valueOf(r103));
        if (r106 == null) goto L18;
        if ((!r106.isEmpty()) == false) goto L18;
        monitor-enter(r106);
        this.f291809a.c(r104, r105, r103, CollectionsKt.toList(r106));     // Catch: Throwable -> L15
        FLogger.f375446a.i("CameraMockRecorder", "✅ Finished recording for imageUuid=" + r103 + " (" + r106.size() + " callbacks)");     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r106);
    L15:
        th = move-exception;
        throw th;
    L18:
        this.f291813e.remove(Integer.valueOf(r103));
        this.f291814f.remove(Integer.valueOf(r103));
        this.f291815g.remove(Integer.valueOf(r103));
        goto L6
    L19:
        FLogger.f375446a.i("CameraMockRecorder", "✅ All pending imageUuid recordings flushed");
        return;
    }

    public final void i() {
        this.f291810b.set(true);
        FLogger.f375446a.i("CameraMockRecorder", "📹 Recording enabled: true (currentMode=" + this.f291811c.get() + ", dataSetId=" + this.f291812d.get() + ')');
    }

    public g() {
        this.f291809a = new c();
        this.f291810b = new AtomicBoolean(false);
        this.f291811c = new AtomicInteger(0);
        this.f291812d = new AtomicInteger(1);
        this.f291813e = new ConcurrentHashMap();
        this.f291814f = new ConcurrentHashMap();
        this.f291815g = new ConcurrentHashMap();
    }

    @Override // com.larus.avlink.e.mock.j
    public final void a(int r100) {
        if (this.f291810b.get() == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("CameraMockRecorder", "interceptOnTakeImageHotWordIDReceived: hotWordId=" + r100);
    }

    @Override // com.larus.avlink.e.mock.j
    public final void f(b49.g r110) {
        if (this.f291810b.get() == true) goto L5;
        return;
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        boolean r100 = true;
        Integer r101 = k.a("onDataFrame", new Object[]{r110});
        if (r101 != null) goto L10;
    L12:
        r100 = false;
    L14:
        if (r100 == true) goto L17;
        FLogger.f375446a.w("CameraMockRecorder", "interceptOnDataFrame: invalid imageUuid=" + r101 + " (assId=" + r110.f17666h + ')');
        return;
    L17:
        Intrinsics.checkNotNull(r101);
        int r102 = r101.intValue();
        Gson r103 = h.f291816a;
        h(r102, "onDataFrame", MapsKt.mapOf(TuplesKt.to("frame", new CameraDataFrameJson(Integer.valueOf(r110.f17659a), Integer.valueOf(r110.f17660b), Integer.valueOf(r110.f17661c), Integer.valueOf(r110.getType()), Integer.valueOf(r110.f17663e), Integer.valueOf(r110.f17664f), Base64.encodeToString(r110.f17665g, 0), Integer.valueOf(r110.f17666h), Base64.encodeToString(r110.f17667i, 0)))));
        FLogger.f375446a.d("CameraMockRecorder", "Intercepted onDataFrame: imageUuid=" + r101 + ", scene=" + r110.f17660b);
        return;
    L10:
        if (r101.intValue() == 0) goto L12;
        goto L12
    }

    @Override // com.larus.avlink.e.mock.j
    public final void d(b49.h r210, b49.d r211) {
        Intrinsics.checkNotNullParameter(r210, "imageInfo");
        if (this.f291810b.get() == true) goto L5;
        return;
    L5:
        Integer r100 = k.a("onCameraCompleteImage", new Object[]{r210, r211});
        if (r100 != null) goto L8;
    L10:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L15;
        FLogger.f375446a.w("CameraMockRecorder", "interceptOnCameraCompleteImage: invalid imageUuid=" + r100);
        return;
    L15:
        Intrinsics.checkNotNull(r100);
        int r102 = r100.intValue();
        Gson r110 = h.f291816a;
        Intrinsics.checkNotNullParameter(r210, "imageInfo");
        Pair[] r103 = new Pair[2];
        Integer r111 = Integer.valueOf(r210.f17668a);
        Integer r112 = Integer.valueOf(r210.f17673f);
        byte[] r113 = r210.f17669b;
        if (r113 == null) goto L18;
        int r114 = r113.length;
    L19:
        int r115 = r210.f17672e;
        int r104 = r210.f17670c;
        int r105 = r210.f17671d;
        int r106 = r210.f17674g;
        if (r113 == null) goto L22;
        String r212 = Base64.encodeToString(r113, 0);
    L23:
        r103[0] = TuplesKt.to("imageInfo", new CameraImageInfoJson(r111, r112, r114, r115, r104, r105, r106, r212));
        if (r211 != null) goto L26;
        CameraErrorJson r107 = null;
    L27:
        r103[1] = TuplesKt.to("error", r107);
        h(r102, "onCameraCompleteImage", MapsKt.mapOf(r103));
        FLogger.f375446a.d("CameraMockRecorder", "Intercepted onCameraCompleteImage: imageUuid=" + r100);
        return;
    L26:
        r107 = new CameraErrorJson(Integer.valueOf(r211.f17653a), r211.f17654b);
        goto L27
    L22:
        r212 = null;
        goto L23
    L18:
        r114 = 0;
        goto L19
    L8:
        if (r100.intValue() == 0) goto L10;
        r101 = true;
        goto L12
    }

    @Override // com.larus.avlink.e.mock.j
    public final void e(boolean r100, int r101) {
        if (this.f291810b.get() == true) goto L5;
        return;
    L5:
        int r102 = k.f291818a;
        Integer r103 = Integer.valueOf(r101);
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L15;
        FLogger.f375446a.w("CameraMockRecorder", "interceptOnImageOcrStateUpdate: invalid imageUuid=" + r101);
        return;
    L15:
        Gson r105 = h.f291816a;
        h(r101, "onImageOcrStateUpdate", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(r100)), TuplesKt.to("imageUuid", Integer.valueOf(r101))}));
        FLogger.f375446a.d("CameraMockRecorder", "Intercepted onImageOcrStateUpdate: imageUuid=" + r101 + ", result=" + r100);
        return;
    L8:
        if (r103.intValue() == 0) goto L10;
        r104 = true;
        goto L12
    }

    public final void h(int r110, String r210, Map<String, ? extends Object> r211) {
        int r100 = this.f291811c.get();
        int r101 = this.f291812d.get();
        if (this.f291814f.containsKey(Integer.valueOf(r110)) == true) goto L5;
        FLogger.f375446a.i("CameraMockRecorder", "📹 Starting recording for imageUuid=" + r110 + " -> mode_" + r100 + "/dataSet_" + r101);
    L5:
        ConcurrentHashMap<Integer, ConcurrentHashMap<String, AtomicInteger>> r102 = this.f291813e;
        Integer r103 = Integer.valueOf(r110);
        ConcurrentHashMap<String, AtomicInteger> r104 = r102.get(r103);
        if (r104 != null) goto L11;
        r104 = new ConcurrentHashMap();
        ConcurrentHashMap<String, AtomicInteger> r105 = r102.putIfAbsent(r103, r104);
        if (r105 == null) goto L11;
        r104 = r105;
    L11:
        ConcurrentHashMap<String, AtomicInteger> r106 = r104;
        ConcurrentHashMap<Integer, List<CallbackSequenceItem>> r107 = this.f291814f;
        Integer r108 = Integer.valueOf(r110);
        List<CallbackSequenceItem> r109 = r107.get(r108);
        if (r109 != null) goto L17;
        r109 = new ArrayList();
        List<CallbackSequenceItem> r111 = r107.putIfAbsent(r108, r109);
        if (r111 == null) goto L17;
        r109 = r111;
    L17:
        List<CallbackSequenceItem> r112 = r109;
        ConcurrentHashMap<Integer, Long> r113 = this.f291815g;
        Integer r114 = Integer.valueOf(r110);
        Long r115 = r113.get(r114);
        if (r115 != null) goto L23;
        r115 = Long.valueOf(System.currentTimeMillis());
        Long r116 = r113.putIfAbsent(r114, r115);
        if (r116 == null) goto L23;
        r115 = r116;
    L23:
        Long r117 = r115;
        Intrinsics.checkNotNull(r106);
        AtomicInteger r118 = r106.get(r210);
        if (r118 != null) goto L29;
        r118 = new AtomicInteger(0);
        AtomicInteger r119 = r106.putIfAbsent(r210, r118);
        if (r119 == null) goto L29;
        r118 = r119;
    L29:
        int r120 = r118.incrementAndGet();
        long r121 = System.currentTimeMillis();
        Intrinsics.checkNotNull(r117);
        long r122 = r121 - r117.longValue();
        String r123 = r210 + '_' + r120 + InvRouter.FLOW_SUFFIX;
        c r124 = this.f291809a;
        r124.getClass();
        Intrinsics.checkNotNullParameter(r210, "callbackType");
        Intrinsics.checkNotNullParameter(r211, "params");
        PolarisFileWrapper r125 = r124.b(r100, r101, r110);     // Catch: Exception -> L32
        String r126 = r210 + '_' + r120 + InvRouter.FLOW_SUFFIX;     // Catch: Exception -> L32
        FilesKt.writeText$default(new PolarisFileWrapper(r125, r126), h.e(MapsKt.mapOf(new Pair[]{TuplesKt.to("callbackType", r210), TuplesKt.to("callIndex", Integer.valueOf(r120)), TuplesKt.to("params", r211)})), null, 2, null);     // Catch: Exception -> L32
        FLogger.f375446a.d("CameraMockFileManager", "Callback saved to imageUuid dir: " + r126 + " -> index_" + r110);     // Catch: Exception -> L32
    L34:
        Intrinsics.checkNotNull(r112);
        monitor-enter(r112);
        r112.add(new CallbackSequenceItem(Integer.valueOf(r112.size() + 1), r123, Long.valueOf(r122)));     // Catch: Throwable -> L40
        monitor-exit(r112);
        FLogger.f375446a.d("CameraMockRecorder", "📝 Recorded: imageUuid=" + r110 + ", " + r210 + " #" + r120 + " (seq=" + r112.size() + ", ts=" + r122 + "ms)");
        return;
    L40:
        th = move-exception;
        throw th;
    L32:
        e = move-exception;
        FLogger.f375446a.e("CameraMockFileManager", "saveCallbackRecordToImageUuidDir failed: imageUuid=" + r110 + ", " + r210 + " #" + r120, e);
        goto L34
    }

    @Override // com.larus.avlink.e.mock.j
    public final void b(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, int r211, int r212, int r213, long r214, int r215, int r216, int r217) {
        if (this.f291810b.get() == true) goto L5;
        return;
    L5:
        int r100 = k.f291818a;
        Integer r101 = Integer.valueOf(r111);
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L16;
        FLogger.f375446a.w("CameraMockRecorder", "interceptOnTakeImageState: invalid imageUuid=" + r111);
        return;
    L16:
        if (this.f291811c.get() == r116) goto L18;
        this.f291811c.set(r116);
        FLogger.f375446a.i("CameraMockRecorder", "📹 Updated recording mode from callback: mode=" + r116);
    L18:
        Gson r103 = h.f291816a;
        h(r111, "onTakeImageState", MapsKt.mapOf(new Pair[]{TuplesKt.to("imageState", Integer.valueOf(r110)), TuplesKt.to("imageUuid", Integer.valueOf(r111)), TuplesKt.to("wkrId", Integer.valueOf(r112)), TuplesKt.to("vuiId", Integer.valueOf(r113)), TuplesKt.to(DecodeProducer.EXTRA_IMAGE_COUNT, Integer.valueOf(r114)), TuplesKt.to("side", Integer.valueOf(r115)), TuplesKt.to("mode", Integer.valueOf(r116)), TuplesKt.to("transmitResult", Integer.valueOf(r117)), TuplesKt.to("imageWidth", Integer.valueOf(r118)), TuplesKt.to("imageHeight", Integer.valueOf(r119)), TuplesKt.to("qualityValue", Integer.valueOf(r210)), TuplesKt.to("definitionValue", Integer.valueOf(r211)), TuplesKt.to(SubInfo.KEY_FORMAT, Integer.valueOf(r212)), TuplesKt.to("hasOcr", Integer.valueOf(r213)), TuplesKt.to("imageCreateTimeStamp", Long.valueOf(r214)), TuplesKt.to("cameraOutputStrategy", Integer.valueOf(r215)), TuplesKt.to("ocrTextLines", Integer.valueOf(r216)), TuplesKt.to("obsSubMode", Integer.valueOf(r217))}));
        FLogger.f375446a.d("CameraMockRecorder", "Intercepted onTakeImageState: imageUuid=" + r111 + ", stage=" + r110 + ", mode=" + r116);
        return;
    L8:
        if (r101.intValue() == 0) goto L10;
        r102 = true;
        goto L12
    }
}
