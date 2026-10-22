package com.larus.avlink.e.mock;

import com.facebook.imagepipeline.producers.DecodeProducer;
import com.larus.avlink.e.mock.scenario.TimingStrategy;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f291807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h49.d f291808b;

    public static final class a {
    }

    static {
    }

    public f() {
        new c();
        new AtomicBoolean(false);
        this.f291807a = new AtomicBoolean(false);
        new AtomicBoolean(true);
    }

    public final void c(CameraCallbackRecord r100) {
        h49.d r101 = this.f291808b;     // Catch: Exception -> L48
        if (r101 != null) goto L7;
        return;
    L7:
        if (r100.getParams() != null) goto L9;
        return;
    L9:
        String r102 = r100.getCallbackType();     // Catch: Exception -> L48
        if (r102 != null) goto L12;
    L45:
        FLogger.f375446a.w("CameraMockPlayer", "Unknown callback type: " + r100.getCallbackType());     // Catch: Exception -> L48
    L46:
        FLogger.f375446a.i("CameraMockPlayer", "Playback callback: " + r100.getCallbackType() + ", seq=" + r100.getSequence());     // Catch: Exception -> L48
        return;
    L12:
        switch(r102.hashCode()) {
            case -417316668: goto L42;
            case -103534882: goto L27;
            case -57227364: goto L23;
            case 637830808: goto L19;
            case 1975921694: goto L15;
            default: goto L45;
        };     // Catch: Exception -> L48
    L15:
        if (r102.equals("onCameraCompleteImage") == false) goto L45;
        d(r101, r100.getParams());     // Catch: Exception -> L48
        goto L46
    L19:
        if (r102.equals("onImageOcrStateUpdate") == false) goto L45;
        f(r101, r100.getParams());     // Catch: Exception -> L48
        goto L46
    L23:
        if (r102.equals("onTakeImageState") == false) goto L45;
        g(r101, r100.getParams());     // Catch: Exception -> L48
        goto L46
    L27:
        if (r102.equals("onTakeImageHotWordIDReceived") == false) goto L45;
        Object r103 = r100.getParams().get("hotWordId");     // Catch: Exception -> L39
        if ((r103 instanceof Number) == false) goto L33;
        Number r104 = (Number) r103;     // Catch: Exception -> L39
    L34:
        if (r104 == null) goto L36;
        int r105 = r104.intValue();     // Catch: Exception -> L39
    L37:
        r101.a(r105);     // Catch: Exception -> L39
    L36:
        r105 = 0;
        goto L37
    L33:
        r104 = null;
    L39:
        e = move-exception;
        FLogger.f375446a.e("CameraMockPlayer", "playbackOnTakeImageHotWordID failed", e);     // Catch: Exception -> L48
        goto L46
    L42:
        if (r102.equals("onDataFrame") == false) goto L45;
        e(r101, r100.getParams());     // Catch: Exception -> L48
    L48:
        e = move-exception;
        FLogger.f375446a.e("CameraMockPlayer", "playbackCallback failed for type=" + r100.getCallbackType(), e);
    }

    public static void d(h49.d r100, Map r101) {
        Object r102 = r101.get("imageInfo");     // Catch: Exception -> L32
        b49.d r103 = null;
        if ((r102 instanceof Map) == false) goto L5;
        Map r104 = (Map) r102;     // Catch: Exception -> L32
    L6:
        if (r104 != null) goto L8;
        return;
    L8:
        Object r105 = r101.get("error");     // Catch: Exception -> L32
        if ((r105 instanceof Map) == false) goto L11;
        Map r106 = (Map) r105;     // Catch: Exception -> L32
    L12:
        b49.h r107 = h.b((CameraImageInfoJson) h.c(h.d(r104), CameraImageInfoJson.class));     // Catch: Exception -> L32
        if (r107 != null) goto L15;
        return;
    L15:
        if (r106 == null) goto L30;
        CameraErrorJson r108 = (CameraErrorJson) h.c(h.d(r106), CameraErrorJson.class);     // Catch: Exception -> L32
        if (r108 == null) goto L30;
        Integer r109 = r108.getCode();     // Catch: Exception -> L28
        if (r109 == null) goto L22;
        int r110 = r109.intValue();     // Catch: Exception -> L28
    L23:
        String r111 = r108.getMessage();     // Catch: Exception -> L28
        if (r111 != null) goto L26;
        r111 = "";
    L26:
        r103 = new b49.d(r110, r111);     // Catch: Exception -> L28
        goto L30
    L22:
        r110 = 0;
    L28:
        e = move-exception;
        FLogger.f375446a.e("CameraMockSerializer", "deserializeError failed", e);     // Catch: Exception -> L32
    L30:
        r100.c(r107, r103);     // Catch: Exception -> L32
        return;
    L11:
        r106 = null;
        goto L12
    L5:
        r104 = null;
    L32:
        e = move-exception;
        FLogger.f375446a.e("CameraMockPlayer", "playbackOnCameraCompleteImage failed", e);
    }

    public static void e(h49.d r100, Map r101) {
        Object r102 = r101.get("frame");     // Catch: Exception -> L10
        if ((r102 instanceof Map) == false) goto L5;
        Map r103 = (Map) r102;     // Catch: Exception -> L10
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        r100.d(h.a((CameraDataFrameJson) h.c(h.d(r103), CameraDataFrameJson.class)));     // Catch: Exception -> L10
        return;
    L5:
        r103 = null;
    L10:
        e = move-exception;
        FLogger.f375446a.e("CameraMockPlayer", "playbackOnDataFrame failed", e);
    }

    public static void f(h49.d r100, Map r101) {
        Object r102 = r101.get("result");     // Catch: Exception -> L17
        Number r103 = null;
        if ((r102 instanceof Boolean) == false) goto L5;
        Boolean r104 = (Boolean) r102;     // Catch: Exception -> L17
    L6:
        int r105 = 0;
        if (r104 == null) goto L9;
        boolean r106 = r104.booleanValue();     // Catch: Exception -> L17
    L10:
        Object r107 = r101.get("imageUuid");     // Catch: Exception -> L17
        if ((r107 instanceof Number) == false) goto L13;
        r103 = (Number) r107;     // Catch: Exception -> L17
    L13:
        if (r103 == null) goto L15;
        r105 = r103.intValue();     // Catch: Exception -> L17
    L15:
        r100.j(r106, r105, (byte) 48);     // Catch: Exception -> L17
        return;
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = null;
    L17:
        e = move-exception;
        FLogger.f375446a.e("CameraMockPlayer", "playbackOnImageOcrStateUpdate failed", e);
    }

    public static void g(h49.d r210, Map r211) {
        Object r100 = r211.get("imageState");     // Catch: Exception -> L131
        Number r101 = null;
        if ((r100 instanceof Number) == false) goto L6;
        Number r102 = (Number) r100;     // Catch: Exception -> L131
    L8:
        if (r102 == null) goto L10;
        int r103 = r102.intValue();     // Catch: Exception -> L131
    L11:
        Object r104 = r211.get("imageUuid");     // Catch: Exception -> L131
        if ((r104 instanceof Number) == false) goto L14;
        Number r105 = (Number) r104;     // Catch: Exception -> L131
    L15:
        if (r105 == null) goto L17;
        int r106 = r105.intValue();     // Catch: Exception -> L131
    L18:
        Object r107 = r211.get("wkrId");     // Catch: Exception -> L131
        if ((r107 instanceof Number) == false) goto L21;
        Number r108 = (Number) r107;     // Catch: Exception -> L131
    L22:
        if (r108 == null) goto L24;
        int r109 = r108.intValue();     // Catch: Exception -> L131
    L25:
        Object r110 = r211.get("vuiId");     // Catch: Exception -> L131
        if ((r110 instanceof Number) == false) goto L28;
        Number r111 = (Number) r110;     // Catch: Exception -> L131
    L29:
        if (r111 == null) goto L31;
        int r112 = r111.intValue();     // Catch: Exception -> L131
    L32:
        Object r113 = r211.get(DecodeProducer.EXTRA_IMAGE_COUNT);     // Catch: Exception -> L131
        if ((r113 instanceof Number) == false) goto L35;
        Number r114 = (Number) r113;     // Catch: Exception -> L131
    L36:
        if (r114 == null) goto L38;
        int r115 = r114.intValue();     // Catch: Exception -> L131
    L39:
        Object r116 = r211.get("side");     // Catch: Exception -> L131
        if ((r116 instanceof Number) == false) goto L42;
        Number r117 = (Number) r116;     // Catch: Exception -> L131
    L43:
        if (r117 == null) goto L45;
        int r118 = r117.intValue();     // Catch: Exception -> L131
    L46:
        Object r119 = r211.get("mode");     // Catch: Exception -> L131
        if ((r119 instanceof Number) == false) goto L49;
        Number r120 = (Number) r119;     // Catch: Exception -> L131
    L50:
        if (r120 == null) goto L52;
        int r121 = r120.intValue();     // Catch: Exception -> L131
    L53:
        Object r122 = r211.get("transmitResult");     // Catch: Exception -> L131
        if ((r122 instanceof Number) == false) goto L56;
        Number r123 = (Number) r122;     // Catch: Exception -> L131
    L57:
        if (r123 == null) goto L59;
        int r124 = r123.intValue();     // Catch: Exception -> L131
    L60:
        Object r125 = r211.get("imageWidth");     // Catch: Exception -> L131
        if ((r125 instanceof Number) == false) goto L63;
        Number r126 = (Number) r125;     // Catch: Exception -> L131
    L64:
        if (r126 == null) goto L66;
        int r127 = r126.intValue();     // Catch: Exception -> L131
    L67:
        Object r128 = r211.get("imageHeight");     // Catch: Exception -> L131
        if ((r128 instanceof Number) == false) goto L70;
        Number r129 = (Number) r128;     // Catch: Exception -> L131
    L71:
        if (r129 == null) goto L73;
        int r130 = r129.intValue();     // Catch: Exception -> L131
    L74:
        Object r131 = r211.get("qualityValue");     // Catch: Exception -> L131
        if ((r131 instanceof Number) == false) goto L77;
        Number r132 = (Number) r131;     // Catch: Exception -> L131
    L78:
        if (r132 == null) goto L80;
        int r133 = r132.intValue();     // Catch: Exception -> L131
    L81:
        Object r134 = r211.get("definitionValue");     // Catch: Exception -> L131
        if ((r134 instanceof Number) == false) goto L84;
        Number r135 = (Number) r134;     // Catch: Exception -> L131
    L85:
        if (r135 == null) goto L87;
        int r136 = r135.intValue();     // Catch: Exception -> L131
    L88:
        Object r137 = r211.get(SubInfo.KEY_FORMAT);     // Catch: Exception -> L131
        if ((r137 instanceof Number) == false) goto L91;
        Number r138 = (Number) r137;     // Catch: Exception -> L131
    L92:
        if (r138 == null) goto L94;
        int r139 = r138.intValue();     // Catch: Exception -> L131
    L95:
        Object r140 = r211.get("hasOcr");     // Catch: Exception -> L131
        if ((r140 instanceof Number) == false) goto L98;
        Number r141 = (Number) r140;     // Catch: Exception -> L131
    L99:
        if (r141 == null) goto L101;
        int r142 = r141.intValue();     // Catch: Exception -> L131
    L102:
        Object r143 = r211.get("imageCreateTimeStamp");     // Catch: Exception -> L131
        if ((r143 instanceof Number) == false) goto L105;
        Number r144 = (Number) r143;     // Catch: Exception -> L131
    L106:
        if (r144 == null) goto L108;
        long r145 = r144.longValue();     // Catch: Exception -> L131
    L109:
        Object r146 = r211.get("cameraOutputStrategy");     // Catch: Exception -> L131
        if ((r146 instanceof Number) == false) goto L112;
        Number r147 = (Number) r146;     // Catch: Exception -> L131
    L113:
        if (r147 == null) goto L115;
        int r212 = r147.intValue();     // Catch: Exception -> L131
    L116:
        Object r148 = r211.get("ocrTextLines");     // Catch: Exception -> L131
        if ((r148 instanceof Number) == false) goto L119;
        Number r149 = (Number) r148;     // Catch: Exception -> L131
    L120:
        if (r149 == null) goto L122;
        int r213 = r149.intValue();     // Catch: Exception -> L131
    L123:
        Object r150 = r211.get("obsSubMode");     // Catch: Exception -> L131
        if ((r150 instanceof Number) == false) goto L126;
        r101 = (Number) r150;     // Catch: Exception -> L131
    L126:
        if (r101 == null) goto L128;
        int r214 = r101.intValue();     // Catch: Exception -> L131
    L129:
        r210.b(r103, r106, r109, r112, r115, r118, r121, r124, r127, r130, r133, r136, r139, r142, r145, r212, r213, r214);     // Catch: Exception -> L131
        return;
    L128:
        r214 = 0;
        goto L129
    L122:
        r213 = 0;
        goto L123
    L119:
        r149 = null;
        goto L120
    L115:
        r212 = 0;
        goto L116
    L112:
        r147 = null;
        goto L113
    L108:
        r145 = 0;
        goto L109
    L105:
        r144 = null;
        goto L106
    L101:
        r142 = 0;
        goto L102
    L98:
        r141 = null;
        goto L99
    L94:
        r139 = 2;
        goto L95
    L91:
        r138 = null;
        goto L92
    L87:
        r136 = 0;
        goto L88
    L84:
        r135 = null;
        goto L85
    L80:
        r133 = 0;
        goto L81
    L77:
        r132 = null;
        goto L78
    L73:
        r130 = 0;
        goto L74
    L70:
        r129 = null;
        goto L71
    L66:
        r127 = 0;
        goto L67
    L63:
        r126 = null;
        goto L64
    L59:
        r124 = 0;
        goto L60
    L56:
        r123 = null;
        goto L57
    L52:
        r121 = 0;
        goto L53
    L49:
        r120 = null;
        goto L50
    L45:
        r118 = 0;
        goto L46
    L42:
        r117 = null;
        goto L43
    L38:
        r115 = 0;
        goto L39
    L35:
        r114 = null;
        goto L36
    L31:
        r112 = 0;
        goto L32
    L28:
        r111 = null;
        goto L29
    L24:
        r109 = 0;
        goto L25
    L21:
        r108 = null;
        goto L22
    L17:
        r106 = 0;
        goto L18
    L14:
        r105 = null;
        goto L15
    L10:
        r103 = 0;
        goto L11
    L6:
        r102 = null;
    L131:
        e = move-exception;
        FLogger.f375446a.e("CameraMockPlayer", "playbackOnTakeImageState failed", e);
    }

    public static final List a(f r100, List r101, Map r110) {
        r100.getClass();
        if (r110.isEmpty() == true) goto L26;
        List r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L19;
        CameraCallbackRecord r105 = (CameraCallbackRecord) r104.next();
        Map<String, Object> r106 = r105.getParams();
        if (r106 == null) goto L25;
        Map r107 = MapsKt.toMutableMap(r106);
        if (r107 == null) goto L25;
        Iterator r108 = r110.entrySet().iterator();
    L15:
        if (r108.hasNext() == false) goto L17;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.put((String) r109.getKey(), r109.getValue());
        goto L15
    L17:
        r103.add(CameraCallbackRecord.copy$default(r105, null, null, null, r107, 7, null));
    L25:
        return CollectionsKt.emptyList();
    L19:
        FLogger.f375446a.i("CameraMockPlayer", "Applied parameter mapping to " + r103.size() + " callbacks");
        return r103;
    L26:
        return r101;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d1 -> B:39:0x00f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00de -> B:39:0x00f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00f0 -> B:38:0x00f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x015a -> B:53:0x015e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0166 -> B:55:0x0167). Please report as a decompilation issue!!! */
    public static final Object b(f r110, List r111, TimingStrategy r112, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof CameraMockPlayer$playbackCallbacksWithTiming$1) == false) goto L7;
        CameraMockPlayer$playbackCallbacksWithTiming$1 r100 = (CameraMockPlayer$playbackCallbacksWithTiming$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r105 = r100.I$0;
        CameraCallbackRecord r106 = (CameraCallbackRecord) r100.L$3;
        Iterator r107 = (Iterator) r100.L$2;
        TimingStrategy r113 = (TimingStrategy) r100.L$1;
        List r114 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L53:
        TimingStrategy r108 = r113;
        CameraCallbackRecord r115 = r106;
        int r109 = r105;
        List r116 = r114;
        CameraCallbackRecord r117 = r115;
    L55:
        r110.c(r117);
    L46:
        if (r107.hasNext() == false) goto L56;
        int r118 = r109 + 1;
        r117 = (CameraCallbackRecord) r107.next();
        if (r109 <= 0) goto L54;
        ((TimingStrategy.a) r108).getClass();
        r100.L$0 = r116;
        r100.L$1 = r108;
        r100.L$2 = r107;
        r100.L$3 = r117;
        r100.I$0 = r118;
        r100.label = 2;
        if (DelayKt.delay(0, r100) == r103) goto L64;
        r106 = r117;
        r114 = r116;
        r105 = r118;
        r113 = r108;
        goto L53
    L64:
        return r103;
    L54:
        r109 = r118;
        goto L55
    L56:
        FLogger r119 = FLogger.f375446a;
        ((TimingStrategy.a) r108).getClass();
        r119.i("CameraMockPlayer", "Executed " + r116.size() + " callbacks with custom delay: 0ms");
    L58:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        CameraCallbackRecord r120 = (CameraCallbackRecord) r100.L$2;
        Iterator r121 = (Iterator) r100.L$1;
        List r122 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L38:
        CameraCallbackRecord r123 = r120;
        List r124 = r122;
    L39:
        r110.c(r123);
        long r125 = r123.getTimestamp().longValue();
    L27:
        if (r121.hasNext() == false) goto L41;
        r123 = (CameraCallbackRecord) r121.next();
        Long r126 = r123.getTimestamp();
        if (r126 == null) goto L62;
        r126.longValue();
        if (r123.getTimestamp().longValue() <= r125) goto L39;
        long r127 = r123.getTimestamp().longValue() - r125;
        if (r127 <= 0) goto L39;
        r100.L$0 = r124;
        r100.L$1 = r121;
        r100.L$2 = r123;
        r100.label = 1;
        if (DelayKt.delay(r127, r100) == r103) goto L63;
        r122 = r124;
        r120 = r123;
        goto L38
    L63:
        return r103;
    L62:
        return Unit.INSTANCE;
    L41:
        FLogger.f375446a.i("CameraMockPlayer", "Executed " + r124.size() + " callbacks in realtime mode");
        goto L58
    L16:
        ResultKt.throwOnFailure(r102);
        if (Intrinsics.areEqual(r112, TimingStrategy.b.f291820a) == false) goto L24;
        Iterator r128 = r111.iterator();
    L20:
        if (r128.hasNext() == false) goto L22;
        r110.c((CameraCallbackRecord) r128.next());
        goto L20
    L22:
        FLogger.f375446a.i("CameraMockPlayer", "Executed " + r111.size() + " callbacks immediately");
        goto L58
    L24:
        if (Intrinsics.areEqual(r112, TimingStrategy.c.f291821a) == false) goto L43;
        r121 = r111.iterator();
        r125 = 0;
        r124 = r111;
        goto L27
    L43:
        if ((r112 instanceof TimingStrategy.a) == false) goto L60;
        r109 = 0;
        r107 = r111.iterator();
        r108 = r112;
        r116 = r111;
        goto L46
    L60:
        throw new NoWhenBranchMatchedException();
    L7:
        r100 = new CameraMockPlayer$playbackCallbacksWithTiming$1(r110, r210);
        goto L8
    }
}
