package com.larus.dora.impl.ota.connector;

import android.os.Handler;
import android.os.Looper;
import androidx.collection.SieveCacheKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.transfer.DoraDeviceLinkType;
import com.bytedance.dora.transfer.DoraTransferDirection;
import com.bytedance.dora.wlan.DoraWifiLinkStrategy;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.ttnetuploader.uploader.api.IUploadCallback;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ResultInfo;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.api.Uploader;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraOTAWifiConnector implements g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f337431i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f337432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f337433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f337434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f337435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f337436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f337437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f337438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f337439h;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b implements IUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraOTAWifiConnector f337440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f337441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f337442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f337443d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f337444e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ h f337445f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ok4.b f337446g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f337447h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f337448i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f337449j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Long f337450k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f337451l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f337452m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f337453n;

        @Override // com.ttnetuploader.uploader.api.IUploadCallback
        public final void onFailed(ResultInfo r210) {
            Intrinsics.checkNotNullParameter(r210, "uploadInfo");
            Object r100 = this.f337440a.f337434c;
            Ref.IntRef r101 = this.f337449j;
            monitor-enter(r100);
            int r102 = r101.element;     // Catch: Throwable -> L64
            monitor-exit(r100);
            g49.d.b("DoraOTAWifiConnector", "dataTransfer: onFailed: code=" + r210.code + ", retryCount=" + r102);
            final DoraOTAWifiConnector r103 = this.f337440a;
            Object r104 = r103.f337434c;
            final int r105 = this.f337441b;
            final Ref.BooleanRef r110 = this.f337442c;
            final Ref.BooleanRef r111 = this.f337448i;
            final Ref.LongRef r112 = this.f337443d;
            final Long r106 = this.f337450k;
            final Ref.IntRef r113 = this.f337449j;
            final String r114 = this.f337451l;
            String r115 = this.f337452m;
            final String r107 = this.f337453n;
            final Ref.IntRef r108 = this.f337444e;
            final h r109 = this.f337445f;
            final ok4.b r116 = this.f337446g;
            final String r117 = this.f337447h;
            monitor-enter(r104);
            boolean r118 = false;
            if (r103.f337437f == r105) goto L72;
        L52:
            ResultInfo r119 = r210;
        L53:
            monitor-exit(r104);
            if (r118 == false) goto L57;
            return;
        L57:
            if (DoraOTAWifiConnector.e(this.f337440a, this.f337441b, this.f337442c, this.f337448i, this.f337449j) == true) goto L59;
            return;
        L59:
            k.a("upload_failed");
            ok4.b r120 = this.f337446g;
            String r121 = this.f337447h;
            DoraOTAWifiConnector r122 = this.f337440a;
            long r123 = this.f337443d.element;
            r122.getClass();
            int r124 = (int) RangesKt.coerceIn(r123, 0, SieveCacheKt.NodeLinkMask);
            DoraTransferDirection r125 = DoraTransferDirection.UPLINK;
            ((ok4.e) r120).d(r121, r124);
            ((ok4.e) this.f337446g).b(this.f337447h, ok4.a.f523633b, new ok4.f.a(String.valueOf(r119.code)));
            this.f337445f.a(r119.uploadId, r119.code, r210.getUploadLog());
            return;
        L72:
        L50:
            th = th;
        L62:
            monitor-exit(r104);
            throw th;
        L13:
            if (r110.element == true) goto L52;
            if (r111.element == false) goto L18;
            r119 = r210;
        L49:
            r118 = true;
            goto L53
        L18:
            r103.f337432a = null;     // Catch: Throwable -> L50
            r112.element = Math.max(r112.element, r210.uploadedLen);     // Catch: Throwable -> L50
            int r126 = r210.code;     // Catch: Throwable -> L50
            if (r126 != 1038) goto L21;
            boolean r211 = true;
        L22:
            if (r211 == false) goto L24;
            r103.f337432a = r106;     // Catch: Throwable -> L50
        L24:
            int r127 = DoraOTAWifiConnector.f337431i;     // Catch: Throwable -> L50
            String r128 = r210.getUploadLog();     // Catch: Throwable -> L50
            if (r128 != null) goto L27;
            r128 = "";
        L27:
            int r129 = r113.element;     // Catch: Throwable -> L50
            Intrinsics.checkNotNullParameter(r128, "uploadLog");     // Catch: Throwable -> L50
            if (r126 != 1038) goto L30;
            boolean r130 = true;
        L32:
            if (r126 != 1009) goto L36;
            String r212 = r115;
            if (StringsKt.contains(r128, "task duplicate", true) == false) goto L37;
            boolean r131 = true;
        L38:
            if (r131 == false) goto L40;
            int r132 = 4;
        L42:
            if (r126 == 1009) goto L44;
            if (r130 == true) goto L44;
        L45:
            Long r133 = null;
        L47:
            if (r133 == null) goto L52;
            int r134 = r113.element + 1;     // Catch: Throwable -> L50
            r113.element = r134;     // Catch: Throwable -> L50
            r103.f337438g = r134;     // Catch: Throwable -> L50
            final boolean r135 = r211;
            final String r213 = r212;
            Runnable r136 = new f(r103, r135, r106, r105, r110, r111, r114, r213, r107, r112, r108, r109, r116, r117, r113);     // Catch: Throwable -> L50
            r103.f337436e = r136;     // Catch: Throwable -> L50
            r111.element = true;     // Catch: Throwable -> L50
            r103.f337435d.postDelayed(r136, r133.longValue());     // Catch: Throwable -> L50
            StringBuilder r137 = new StringBuilder("dataTransfer: retry for code=");     // Catch: Throwable -> L50
            r119 = r210;
            r137.append(r119.code);     // Catch: Throwable -> L50
            r137.append(", retryCount=");     // Catch: Throwable -> L50
            r137.append(r113.element);     // Catch: Throwable -> L50
            r137.append(", delayMs=");     // Catch: Throwable -> L50
            r137.append(r133);     // Catch: Throwable -> L50
            g49.d.d("DoraOTAWifiConnector", r137.toString());     // Catch: Throwable -> L50
        L44:
            if (r129 >= r132) goto L45;
            r133 = Long.valueOf((1 << r129) * 2000);     // Catch: Throwable -> L50
            goto L47
        L40:
            r132 = 3;
        L37:
            r131 = false;
            goto L38
        L36:
            r212 = r115;
            goto L37
        L30:
            r130 = false;
            goto L32
        L21:
            r211 = false;
        L61:
            th = th;
        L64:
            th = move-exception;
            throw th;
        }

        @Override // com.ttnetuploader.uploader.api.IUploadCallback
        public final void onSuccess(ResultInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "uploadInfo");
            g49.d.b("DoraOTAWifiConnector", "dataTransfer: onSuccess uploadInfo=" + r100 + ", code=" + r100.code);
            if (DoraOTAWifiConnector.e(this.f337440a, this.f337441b, this.f337442c, this.f337448i, this.f337449j) == true) goto L5;
            return;
        L5:
            k.a("upload_success");
            ok4.b r101 = this.f337446g;
            String r102 = this.f337447h;
            int r103 = (int) r100.totalLen;
            DoraTransferDirection r104 = DoraTransferDirection.UPLINK;
            ((ok4.e) r101).d(r102, r103);
            ((ok4.e) this.f337446g).b(this.f337447h, ok4.a.f523633b, ok4.f.f523665b);
            this.f337445f.onSuccess(r100.uploadId);
        }

        @Override // com.ttnetuploader.uploader.api.IUploadCallback
        public final void onProgress(long r100, long r101, long r102, long r110) {
            g49.d.d("DoraOTAWifiConnector", "dataTransfer: onProgress uploadId=" + r100 + ", uploadedLen=" + r101 + ", totalLen=" + r102 + ", speed=" + r110);
            DoraOTAWifiConnector r111 = this.f337440a;
            Object r112 = r111.f337434c;
            int r103 = this.f337441b;
            Ref.BooleanRef r104 = this.f337442c;
            Ref.LongRef r105 = this.f337443d;
            Ref.IntRef r106 = this.f337444e;
            monitor-enter(r112);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (r111.f337437f == r103) goto L7;
        L16:
            Integer r107 = null;
        L17:
            monitor-exit(r112);
            if (r107 == null) goto L25;
            this.f337445f.b(r100, r107.intValue());
            return;
        L25:
            return;
        L7:
            if (r104.element == true) goto L16;
            r105.element = Math.max(r105.element, r101);     // Catch: Throwable -> L14
            int r113 = 0;
            if (r102 <= 0) goto L12;
            r113 = RangesKt.coerceIn((int) ((r101 * ((long) 100)) / r102), 0, 100);     // Catch: Throwable -> L14
        L12:
            int r108 = Math.max(r106.element, r113);     // Catch: Throwable -> L14
            r106.element = r108;     // Catch: Throwable -> L14
            r107 = Integer.valueOf(r108);     // Catch: Throwable -> L14
            goto L17
        }

        public b(DoraOTAWifiConnector r100, int r101, Ref.BooleanRef r102, Ref.LongRef r103, Ref.IntRef r104, h r105, ok4.b r106, String r107, Ref.BooleanRef r108, Ref.IntRef r110, Long r111, String r112, String r113, String r114) {
            this.f337440a = r100;
            this.f337441b = r101;
            this.f337442c = r102;
            this.f337443d = r103;
            this.f337444e = r104;
            this.f337445f = r105;
            this.f337446g = r106;
            this.f337447h = r107;
            this.f337448i = r108;
            this.f337449j = r110;
            this.f337450k = r111;
            this.f337451l = r112;
            this.f337452m = r113;
            this.f337453n = r114;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.ota.connector.g
    public final void disconnect() {
        g(null);
    }

    @Override // com.larus.dora.impl.ota.connector.g
    public final int a() {
        Object r100 = this.f337434c;
        monitor-enter(r100);
        int r101 = this.f337438g;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public DoraOTAWifiConnector() {
        this.f337433b = new AtomicBoolean(false);
        this.f337434c = new Object();
        this.f337435d = new Handler(Looper.getMainLooper());
        ULLog.setLogLevel(3);
        ULLog.registerLogHandler(new com.larus.dora.impl.ota.connector.b());
    }

    public static void g(String r100) {
        g49.d.d("DoraOTAWifiConnector", "disconnect");
        DoraWifiLinkWrapper r101 = DoraWifiLinkWrapper.f332292a;
        DoraWifiScene r102 = DoraWifiScene.OTA;
        r101.getClass();
        DoraWifiLinkWrapper.d(r102, r100);
    }

    @Override // com.larus.dora.impl.ota.connector.g
    public final Object b(Continuation<? super com.larus.dora.impl.ota.c> r100) {
        return h(null, null, r100);
    }

    @Override // com.larus.dora.impl.ota.connector.g
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Object r101 = this.f337434c;
        monitor-enter(r101);
        g49.d.d("DoraOTAWifiConnector", "stopDataTransfer: from=" + r100 + ", uploadId=" + this.f337432a);     // Catch: Throwable -> L16
        this.f337437f = this.f337437f + 1;     // Catch: Throwable -> L16
        Runnable r102 = this.f337436e;     // Catch: Throwable -> L16
        if (r102 == null) goto L7;
        this.f337435d.removeCallbacks(r102);     // Catch: Throwable -> L16
    L7:
        this.f337436e = null;     // Catch: Throwable -> L16
        Long r103 = this.f337432a;     // Catch: Throwable -> L16
        this.f337432a = null;     // Catch: Throwable -> L16
        e r104 = this.f337439h;     // Catch: Throwable -> L16
        this.f337439h = null;     // Catch: Throwable -> L16
        Pair r105 = TuplesKt.to(r103, r104);     // Catch: Throwable -> L16
        monitor-exit(r101);
        Long r106 = (Long) r105.component1();
        Function1 r107 = (Function1) r105.component2();
        if (r106 == null) goto L12;
        long r108 = r106.longValue();
        gd9.i r109 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r109);
        Uploader.getInstance(r109.getApplication()).suspend(r108);
    L12:
        if (r107 == null) goto L14;
        r107.invoke("cancelled_" + r100);
    L14:
        Lazy r110 = k.f337480a;
        k.a("stop_data_transfer_" + r100);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static Object j(String r100, Continuation r101) {
        g49.d.e("DoraOTAWifiConnector", "resetOtaWifi: reason=".concat(r100));
        DoraWifiLinkWrapper r102 = DoraWifiLinkWrapper.f332292a;
        DoraWifiScene r103 = DoraWifiScene.OTA;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "scene");
        DoraWifiLinkWrapper.d(r103, null);
        Object r104 = DelayKt.delay(300, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [com.larus.dora.impl.ota.connector.e] */
    @Override // com.larus.dora.impl.ota.connector.g
    public final void d(String r210, String r211, h r212) {
        Intrinsics.checkNotNullParameter(r210, "otaFileSavePath");
        Intrinsics.checkNotNullParameter(r211, "otaFileName");
        Intrinsics.checkNotNullParameter(r212, "callback");
        Object r100 = this.f337434c;
        monitor-enter(r100);
        Runnable r101 = this.f337436e;     // Catch: Throwable -> L44
        if (r101 == null) goto L7;
        this.f337435d.removeCallbacks(r101);     // Catch: Throwable -> L44
    L7:
        this.f337436e = null;     // Catch: Throwable -> L44
        int r102 = this.f337437f + 1;     // Catch: Throwable -> L44
        this.f337437f = r102;     // Catch: Throwable -> L44
        this.f337438g = 0;     // Catch: Throwable -> L44
        Long r103 = this.f337432a;     // Catch: Throwable -> L44
        this.f337432a = null;     // Catch: Throwable -> L44
        e r104 = this.f337439h;     // Catch: Throwable -> L44
        this.f337439h = null;     // Catch: Throwable -> L44
        Triple r105 = new Triple(Integer.valueOf(r102), r103, r104);     // Catch: Throwable -> L44
        monitor-exit(r100);
        int r106 = ((Number) r105.component1()).intValue();
        Long r110 = (Long) r105.component2();
        Function1 r107 = (Function1) r105.component3();
        if (r107 == null) goto L12;
        r107.invoke("replaced");
    L12:
        if (r110 == null) goto L14;
        long r108 = r110.longValue();
        g49.d.d("DoraOTAWifiConnector", "startDataTransfer: suspend previous uploadId=" + r108);
        gd9.i r109 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r109);
        Uploader.getInstance(r109.getApplication()).suspend(r108);
    L14:
        vk4.e r111 = vk4.e.d.f555490a;
        String r112 = r111.c();
        if (r112 != null) goto L17;
    L20:
        boolean r113 = true;
    L21:
        if (r113 == false) goto L24;
        g49.d.b("DoraOTAWifiConnector", "startDataTransfer: ERROR because host=" + r112);
        r212.a(0, -1, "host is null or empty");
        return;
    L24:
        String r114 = (String) CollectionsKt.first(StringsKt.split$default(r112, new String[]{":"}, false, 0, 6, null));
        String r115 = r210 + '/' + r211;
        final ok4.e r116 = ok4.b.a.f523640a;
        DoraWifiLinkWrapper.f332292a.getClass();
        if (r111.e() == false) goto L27;
        DoraDeviceLinkType r117 = DoraDeviceLinkType.WIFI_SOFT_AP;
    L28:
        ok4.a.C7062a r118 = ok4.a.f523633b;
        final String r119 = r116.c(r117, r118, DoraTransferDirection.DOWNLINK);
        g49.d.d("DoraOTAWifiConnector", "startDataTransfer: begin");
        Ref.IntRef r120 = new Ref.IntRef();
        final Ref.LongRef r121 = new Ref.LongRef();
        Ref.IntRef r122 = new Ref.IntRef();
        Ref.BooleanRef r123 = new Ref.BooleanRef();
        Ref.BooleanRef r124 = new Ref.BooleanRef();
        Object r125 = this.f337434c;
        monitor-enter(r125);
    L41:
        th = move-exception;
        throw th;
    L31:
        if (this.f337437f == r106) goto L33;
        boolean r126 = true;
    L35:
        monitor-exit(r125);
        if (r126 == false) goto L39;
        r116.b(r119, r118, new ok4.f.a("cancelled_before_start"));
        return;
    L39:
        k(this, r114, r115, r211, r106, r123, r121, r122, r212, r116, r119, r124, r120, r110);
        return;
    L33:
        this.f337439h = new e(r116, r119, this, r121);     // Catch: Throwable -> L41
        r126 = false;
        goto L35
    L27:
        r117 = DoraDeviceLinkType.WIFI_P2P;
        goto L28
    L17:
        if (r112.length() == 0) goto L20;
        r113 = false;
    L44:
        th = move-exception;
        throw th;
    }

    public final Object h(String r100, Function0<Unit> r101, Continuation<? super com.larus.dora.impl.ota.c> r102) {
        if ((r102 instanceof DoraOTAWifiConnector$prepareConnector$2) == false) goto L7;
        DoraOTAWifiConnector$prepareConnector$2 r103 = (DoraOTAWifiConnector$prepareConnector$2) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        x39.b r108 = (x39.b) r105;
        g49.d.d("DoraOTAWifiConnector", "prepareConnector: connectResult=" + r108);
        if ((r108 instanceof x39.b.a) == false) goto L21;
        return new com.larus.dora.impl.ota.connector.a.e(((x39.b.a) r108).f562396b);
    L21:
        if (Intrinsics.areEqual(r108, x39.b.C8192b.f562397b) == false) goto L24;
        return com.larus.dora.impl.ota.connector.a.b.f337455a;
    L24:
        if (Intrinsics.areEqual(r108, x39.b.c.f562398b) == false) goto L27;
        return com.larus.dora.impl.ota.connector.a.C4275a.f337454a;
    L27:
        if (Intrinsics.areEqual(r108, x39.b.g.f562402b) == false) goto L30;
        return com.larus.dora.impl.ota.a.g.f337422a;
    L30:
        if (Intrinsics.areEqual(r108, x39.b.h.f562403b) == false) goto L33;
        return com.larus.dora.impl.ota.connector.a.f.f337460a;
    L33:
        if (Intrinsics.areEqual(r108, x39.b.e.f562400b) == false) goto L36;
        return com.larus.dora.impl.ota.connector.a.d.f337457a;
    L36:
        if (Intrinsics.areEqual(r108, x39.b.d.f562399b) == false) goto L39;
        return com.larus.dora.impl.ota.connector.a.c.f337456a;
    L39:
        if ((r108 instanceof x39.b.f) == false) goto L43;
        return com.larus.dora.impl.ota.c.a.f337426a;
    L43:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.label = 1;
        r105 = f(true, r100, r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new DoraOTAWifiConnector$prepareConnector$2(this, r102);
        goto L8
    }

    public final Object i(String r100, com.larus.dora.impl.ota.g2.a r101, Continuation r102) {
        if ((r102 instanceof DoraOTAWifiConnector$prepareConnectorWithoutPermissionRequest$1) == false) goto L7;
        DoraOTAWifiConnector$prepareConnectorWithoutPermissionRequest$1 r103 = (DoraOTAWifiConnector$prepareConnectorWithoutPermissionRequest$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        x39.b r108 = (x39.b) r105;
        g49.d.d("DoraOTAWifiConnector", "prepareConnectorWithoutPermissionRequest: connectResult=" + r108);
        if ((r108 instanceof x39.b.a) == false) goto L21;
        return new com.larus.dora.impl.ota.connector.a.e(((x39.b.a) r108).f562396b);
    L21:
        if (Intrinsics.areEqual(r108, x39.b.C8192b.f562397b) == false) goto L24;
        return com.larus.dora.impl.ota.connector.a.b.f337455a;
    L24:
        if (Intrinsics.areEqual(r108, x39.b.c.f562398b) == false) goto L27;
        return com.larus.dora.impl.ota.connector.a.C4275a.f337454a;
    L27:
        if (Intrinsics.areEqual(r108, x39.b.g.f562402b) == false) goto L30;
        return com.larus.dora.impl.ota.a.g.f337422a;
    L30:
        if (Intrinsics.areEqual(r108, x39.b.h.f562403b) == false) goto L33;
        return com.larus.dora.impl.ota.connector.a.f.f337460a;
    L33:
        if (Intrinsics.areEqual(r108, x39.b.e.f562400b) == false) goto L36;
        return com.larus.dora.impl.ota.connector.a.d.f337457a;
    L36:
        if (Intrinsics.areEqual(r108, x39.b.d.f562399b) == false) goto L39;
        return com.larus.dora.impl.ota.connector.a.c.f337456a;
    L39:
        if ((r108 instanceof x39.b.f) == false) goto L43;
        return com.larus.dora.impl.ota.c.a.f337426a;
    L43:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.label = 1;
        r105 = f(false, r100, r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new DoraOTAWifiConnector$prepareConnectorWithoutPermissionRequest$1(this, r102);
        goto L8
    }

    public final Object f(boolean r210, String r211, Function0<Unit> r212, Continuation<? super x39.b> r213) {
        if ((r213 instanceof DoraOTAWifiConnector$connectWithRecovery$1) == false) goto L7;
        DoraOTAWifiConnector$connectWithRecovery$1 r100 = (DoraOTAWifiConnector$connectWithRecovery$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r102);
    L101:
        return r102;
    L13:
        ResultKt.throwOnFailure(r102);
    L97:
        return r102;
    L14:
        ResultKt.throwOnFailure(r102);
    L90:
        return r102;
    L15:
        boolean r103 = r100.Z$0;
        Function0<Unit> r104 = (Function0) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L16:
        Function0<Unit> r106 = r104;
        String r107 = r105;
        if (r103 == false) goto L98;
        if (r107 != null) goto L91;
        DoraWifiLinkWrapper r108 = DoraWifiLinkWrapper.f332292a;
        DoraWifiScene r109 = DoraWifiScene.OTA;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 6;
        r102 = r108.b(r109, null, true, null, null, r100);
        if (r102 != r110) goto L90;
        return r110;
    L91:
        DoraWifiLinkWrapper r111 = DoraWifiLinkWrapper.f332292a;
        DoraWifiScene r112 = DoraWifiScene.OTA;
        if (r106 != null) goto L94;
        r106 = new d();
    L94:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 7;
        r102 = r111.b(r112, null, true, r107, r106, r100);
        if (r102 != r110) goto L97;
        return r110;
    L98:
        DoraWifiLinkWrapper r113 = DoraWifiLinkWrapper.f332292a;
        DoraWifiScene r114 = DoraWifiScene.OTA;
        DoraWifiLinkStrategy r115 = DoraWifiLinkStrategy.P2P_ONLY;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 8;
        r102 = r113.b(r114, r115, false, r107, r106, r100);
        if (r102 != r110) goto L101;
        return r110;
    L17:
        r103 = r100.Z$0;
        r104 = (Function0) r100.L$1;
        r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L76:
        r102 = (x39.b) r102;
    L78:
        if ((r102 instanceof x39.b.a) == false) goto L101;
        if (Intrinsics.areEqual(((x39.b.a) r102).f562396b, FlowDoraConnectReason.SOFT_AP_HOTSPOT_OPEN_TIMEOUT) == false) goto L101;
        r100.L$0 = r105;
        r100.L$1 = r104;
        r100.Z$0 = r103;
        r100.label = 5;
        if (j("retry_after_hotspotOpenTimeout", r100) != r110) goto L16;
        return r110;
    L18:
        r103 = r100.Z$0;
        r104 = (Function0) r100.L$1;
        r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L71:
        r102 = (x39.b) r102;
        goto L78
    L19:
        r103 = r100.Z$0;
        r104 = (Function0) r100.L$1;
        r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L62:
        r102 = (x39.b) r102;
        goto L78
    L20:
        boolean r116 = r100.Z$0;
        Function0<Unit> r117 = (Function0) r100.L$1;
        String r118 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        boolean r119 = r116;
        Function0<Unit> r120 = r117;
        String r121 = r118;
    L56:
        if (r119 == false) goto L72;
        if (r121 != null) goto L63;
        DoraWifiLinkWrapper r122 = DoraWifiLinkWrapper.f332292a;
        DoraWifiScene r123 = DoraWifiScene.OTA;
        r100.L$0 = r121;
        r100.L$1 = r120;
        r100.Z$0 = r119;
        r100.label = 2;
        Object r124 = r122.b(r123, null, true, null, null, r100);
        if (r124 != r110) goto L61;
        return r110;
    L61:
        r105 = r121;
        r104 = r120;
        r103 = r119;
        r102 = r124;
        goto L62
    L63:
        DoraWifiLinkWrapper r125 = DoraWifiLinkWrapper.f332292a;
        DoraWifiScene r126 = DoraWifiScene.OTA;
        if (r120 != null) goto L66;
        Function0<Unit> r127 = new c();
    L67:
        r100.L$0 = r121;
        r100.L$1 = r120;
        r100.Z$0 = r119;
        r100.label = 3;
        Object r128 = r125.b(r126, null, true, r121, r127, r100);
        if (r128 != r110) goto L70;
        return r110;
    L70:
        r105 = r121;
        r104 = r120;
        r103 = r119;
        r102 = r128;
        goto L71
    L66:
        r127 = r120;
        goto L67
    L72:
        DoraWifiLinkWrapper r129 = DoraWifiLinkWrapper.f332292a;
        DoraWifiScene r130 = DoraWifiScene.OTA;
        DoraWifiLinkStrategy r131 = DoraWifiLinkStrategy.P2P_ONLY;
        r100.L$0 = r121;
        r100.L$1 = r120;
        r100.Z$0 = r119;
        r100.label = 4;
        Object r132 = r129.b(r130, r131, false, r121, r120, r100);
        if (r132 != r110) goto L75;
        return r110;
    L75:
        r105 = r121;
        r104 = r120;
        r103 = r119;
        r102 = r132;
        goto L76
    L21:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = r211;
        r100.L$1 = r212;
        r100.Z$0 = r210;
        r100.label = 1;
        if (com.larus.platform.service.i.f365746a.b() == 0) goto L24;
        Object r133 = Unit.INSTANCE;
    L53:
        if (r133 != r110) goto L55;
        return r110;
    L55:
        r121 = r211;
        r120 = r212;
        r119 = r210;
        goto L56
    L24:
        DoraDevice r134 = kj4.a.g().c();
        if (r134 == null) goto L27;
        String r135 = r134.f204390sn;
    L29:
        if (r135 != null) goto L31;
        r135 = "";
    L31:
        Lazy r136 = k.f337480a;
        Intrinsics.checkNotNullParameter(r135, "sn");
        if (StringsKt.isBlank(r135) == true) goto L43;
        String r137 = k.b().getString("sn", "");
        long r138 = k.b().getLong("mark_time", 0);
        if (Intrinsics.areEqual(r137, r135) == false) goto L43;
        if (r138 <= 0) goto L43;
        long r139 = System.currentTimeMillis() - r138;
        if (r139 <= 7200000) goto L42;
        g49.d.d("OtaWifiRecoveryStore", "hasInterruptedUpload: expired, device=" + k.c(r135) + ", age=" + r139);
        k.a(AiBotPollingAuthResult.STATUS_EXPIRED);
        goto L43
    L42:
        g49.d.e("OtaWifiRecoveryStore", "hasInterruptedUpload: true, device=" + k.c(r135) + ", fileName=" + k.b().getString("file_name", "") + ", age=" + r139);
        boolean r140 = true;
    L44:
        if (r140 == true) goto L47;
        r133 = Unit.INSTANCE;
        goto L53
    L47:
        if (this.f337433b.compareAndSet(false, true) == true) goto L49;
        r133 = Unit.INSTANCE;
        goto L53
    L49:
        r133 = j("recover_interrupted_upload", r100);
        if (r133 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L53;
        r133 = Unit.INSTANCE;
    L43:
        r140 = false;
        goto L44
    L27:
        r135 = null;
        goto L29
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new DoraOTAWifiConnector$connectWithRecovery$1(this, r213);
        goto L8
    }

    public static final boolean e(DoraOTAWifiConnector r100, int r101, Ref.BooleanRef r102, Ref.BooleanRef r103, Ref.IntRef r104) {
        Object r105 = r100.f337434c;
        monitor-enter(r105);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r100.f337437f == r101) goto L7;
    L15:
        monitor-exit(r105);
        return false;
    L7:
        if (r102.element == true) goto L15;
        r102.element = true;     // Catch: Throwable -> L17
        Runnable r106 = r100.f337436e;     // Catch: Throwable -> L17
        if (r106 == null) goto L12;
        r100.f337435d.removeCallbacks(r106);     // Catch: Throwable -> L17
    L12:
        r100.f337436e = null;     // Catch: Throwable -> L17
        r100.f337432a = null;     // Catch: Throwable -> L17
        r100.f337439h = null;     // Catch: Throwable -> L17
        r103.element = false;     // Catch: Throwable -> L17
        r100.f337438g = r104.element;     // Catch: Throwable -> L17
        monitor-exit(r105);
        return true;
    }

    public static final void k(DoraOTAWifiConnector r210, String r211, String r212, String r213, int r214, Ref.BooleanRef r215, Ref.LongRef r216, Ref.IntRef r217, h r218, ok4.b r310, String r311, Ref.BooleanRef r312, Ref.IntRef r313, Long r314) {
        Object r100 = r210.f337434c;
        monitor-enter(r100);
    L54:
        th = move-exception;
        throw th;
    L5:
        if (r210.f337437f == r214) goto L7;
    L51:
        g49.d.d("DoraOTAWifiConnector", "dataTransfer: ignore stale doTransfer");     // Catch: Throwable -> L54
        monitor-exit(r100);
        return;
    L7:
        if (r215.element == true) goto L51;
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L54
        monitor-exit(r100);
        Parameters r110 = new Parameters(1, r211, r212, null, new b(r210, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r211, r212, r213));
        r110.setUserKey(r213);
        boolean r102 = true;
        r110.setIsHttp(true);
        r110.setTaskRetryTimes(3);
        DoraWifiLinkWrapper.f332292a.getClass();
        if (vk4.e.d.f555490a.e() == false) goto L14;
        r110.setNetLibType(1);
        r110.setForceWifi(true);
    L14:
        Object r103 = r210.f337434c;
        monitor-enter(r103);
    L48:
        th = move-exception;
        throw th;
    L17:
        if (r210.f337437f != r214) goto L29;
        Ref.BooleanRef r104 = r215;
        if (r104.element == true) goto L30;
        r210.f337432a = Long.valueOf(r110.getUploadId());     // Catch: Throwable -> L48
        g49.d.d("DoraOTAWifiConnector", "startDataTransfer: uploadId=" + r210.f337432a + ", retryCount=" + r313.element);     // Catch: Throwable -> L48
        Lazy r105 = k.f337480a;     // Catch: Throwable -> L48
        DoraDevice r106 = kj4.a.g().c();     // Catch: Throwable -> L48
        if (r106 == null) goto L24;
        String r107 = r106.f204390sn;     // Catch: Throwable -> L48
    L25:
        if (r107 != null) goto L27;
        r107 = "";
    L27:
        k.d(r107, r213);     // Catch: Throwable -> L48
        boolean r108 = true;
    L31:
        monitor-exit(r103);
        if (r108 == false) goto L47;
        gd9.i r109 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r109);
        Uploader.getInstance(r109.getApplication()).start(r110);
        Object r111 = r210.f337434c;
        monitor-enter(r111);
    L44:
        th = move-exception;
        throw th;
    L36:
        if (r210.f337437f != r214) goto L41;
        if (r104.element == true) goto L41;
        r102 = false;
    L41:
        monitor-exit(r111);
        if (r102 == false) goto L62;
        gd9.i r112 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r112);
        Uploader.getInstance(r112.getApplication()).suspend(r110.getUploadId());
        return;
    L62:
        return;
    L47:
        return;
    L24:
        r107 = null;
    L30:
        r108 = false;
        goto L31
    L29:
        r104 = r215;
        goto L30
    }
}
