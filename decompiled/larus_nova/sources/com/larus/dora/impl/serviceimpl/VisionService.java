package com.larus.dora.impl.serviceimpl;

import android.util.ArrayMap;
import com.bytedance.dora.transfer.DoraDeviceLinkType;
import com.bytedance.dora.transfer.DoraTransferDirection;
import com.larus.applog.api.IApplog;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.impl.core.s0;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.util.b0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes4.dex */
public final class VisionService implements IDoraService.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<h49.g> f337989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<h49.f> f337990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f337991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Pair<Integer, Integer> f337992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile z f337993e;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.api.IDoraService.i
    public final FlowDoraVideoRecordConfig b() {
        ArrayMap<Integer, hk4.b> r100 = qk4.g.f533513j;
        qk4.g r101 = qk4.g.a.f533523a;
        r101.f533515b.h(1, 4, pk4.n.b(1, 4, 26), new byte[]{26, 0});
        return i(r101.f533521h);
    }

    public final void f() {
        IDoraService.B1.getClass();
        BuildersKt.launch$default(IDoraService.b.f331727b, null, null, new VisionService$asyncCameraEvent$1(this, 21, 0, 0, null), 3, null);
    }

    public final void g() {
        IDoraService.B1.getClass();
        BuildersKt.launch$default(IDoraService.b.f331727b, null, null, new VisionService$asyncStartRecordingEvent$1(null), 3, null);
    }

    public final Pair<Integer, Integer> l() {
        Pair<Integer, Integer> r100 = this.f337992d;
        if (r100 == null) goto L7;
        FLogger.f375446a.d("VisionService", "Hit cache: images=" + r100.getFirst().intValue() + ", videos=" + r100.getSecond().intValue());
        return r100;
    L7:
        return new Pair(0, 0);
    }

    public final int m() {
        b0.f338123a.getClass();
        return b0.j().getInt("dora_burst_take_image_interval", 5);
    }

    public final boolean n() {
        IDoraPageConfig r100 = (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.d("dora_g_config_key_precapture_upload_enable", false);
    }

    public final boolean p() {
        b0.f338123a.getClass();
        return b0.x();
    }

    public final boolean q() {
        b0.f338123a.getClass();
        return b0.y();
    }

    public VisionService() {
        this.f337989a = new CopyOnWriteArrayList();
        this.f337990b = new CopyOnWriteArrayList();
        this.f337991c = new AtomicBoolean(false);
    }

    public final boolean h() {
        if (kj4.a.g().f503709d.l() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean y() {
        if (kj4.a.g().f503709d.n() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static FlowDoraVideoRecordConfig i(byte[] r100) {
        if (r100 != null) goto L4;
    L13:
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("byteArrayToVideoRecordConfig failed : ");
        if (r100 == null) goto L16;
        int r103 = r100.length;
    L17:
        r102.append(r103);
        r101.i("VisionService", r102.toString());
        return null;
    L16:
        r103 = -1;
        goto L17
    L4:
        if (r100.length != 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L13;
        if (r100.length < 4) goto L13;
        return new FlowDoraVideoRecordConfig(o(new byte[]{r100[1], r100[0]}), r100[2], r100[3]);
    L6:
        r104 = false;
        goto L7
    }

    public static int o(byte[] r100) {
        if (r100.length == 2) goto L5;
        return 0;
    L5:
        int r101 = (r100[0] & UByte.MAX_VALUE) << 8;
        return (r100[1] & UByte.MAX_VALUE) | r101;
    }

    @Override // com.larus.dora.api.IDoraService.i
    public final void a(h49.g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f337989a.remove(r100);
    }

    @Override // com.larus.dora.api.IDoraService.i
    public final void c(h49.g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f337993e != null) goto L7;
        z r101 = new z(this);     // Catch: Throwable -> L10
        ArrayMap<Integer, hk4.b> r102 = qk4.g.f533513j;     // Catch: Throwable -> L10
        ((CopyOnWriteArraySet) qk4.g.a.f533523a.f533517d).add(r101);     // Catch: Throwable -> L10
        this.f337993e = r101;     // Catch: Throwable -> L10
    L7:
        monitor-exit(this);
        this.f337989a.add(r100);
    }

    @Override // com.larus.dora.api.IDoraService.i
    public final int d(FlowDoraVideoRecordConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        ArrayMap<Integer, hk4.b> r101 = qk4.g.f533513j;
        qk4.g r102 = qk4.g.a.f533523a;
        int r103 = r100.f331755a;
        byte[] r104 = ArraysKt.plus(ArraysKt.plus(new byte[]{(byte) (r103 & 255), (byte) ((r103 >> 8) & 255)}, new byte[]{(byte) r100.f331756b}), new byte[]{(byte) r100.f331757c});
        return r102.f533515b.i(1, 4, pk4.n.u(new byte[]{26, (byte) r104.length}, r104));
    }

    public final void r(h49.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f337990b.contains(r100) == true) goto L6;
        this.f337990b.add(r100);
        return;
    }

    public final void s(h49.d r100) {
        t69.k.f544689a.add(r100);
    }

    public final void t(h49.d r100) {
        t69.k.f544689a.remove(r100);
    }

    public final Object u(Continuation<? super b49.b> r110) {
        if ((r110 instanceof VisionService$requestAlbumListSync$1) == false) goto L7;
        VisionService$requestAlbumListSync$1 r100 = (VisionService$requestAlbumListSync$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        int r104 = 1;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L31:
        v39.b r112 = (v39.b) r111;
    L33:
        if ((r112 instanceof v39.b.f) == false) goto L36;
        return new b49.b.C0263b(((v39.b.f) r112).f552961b.f552952d, r104);
    L36:
        return new b49.b.a(r112.f552955a, r112.toString());
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r105 = r100.I$0;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L20:
        r112 = (v39.b) r111;
        if ((r112 instanceof v39.b.e) == false) goto L23;
    L28:
        FLogger.f375446a.e("VisionService", "requestAlbumListSync: data is null, retry once. response: ".concat(r112.getClass().getSimpleName()));
        s0 r113 = s0.f332257a;
        qk4.c r107 = new qk4.c(r106);
        r100.L$0 = null;
        r100.label = 2;
        r111 = r113.a(r107, 20000, r100);
        if (r111 != r102) goto L31;
        return r102;
    L23:
        if ((r112 instanceof v39.b.c) == true) goto L28;
        if ((r112 instanceof v39.b.C7961b) == true) goto L28;
        r104 = r105;
        goto L33
    L16:
        ResultKt.throwOnFailure(r111);
        r106 = IApplog.f287053a.getUserID();
        s0 r114 = s0.f332257a;
        qk4.c r108 = new qk4.c(r106);
        r100.L$0 = r106;
        r100.I$0 = 0;
        r100.label = 1;
        r111 = r114.a(r108, 20000, r100);
        if (r111 != r102) goto L19;
        return r102;
    L19:
        r105 = 0;
    L7:
        r100 = new VisionService$requestAlbumListSync$1(this, r110);
        goto L8
    }

    public final String w(int r100) {
        DoraWifiLinkWrapper.f332292a.getClass();
        if (vk4.e.d.f555490a.e() == false) goto L5;
        DoraDeviceLinkType r101 = DoraDeviceLinkType.WIFI_SOFT_AP;
    L6:
        if (r100 != 0) goto L8;
        ok4.a r102 = ok4.a.f523634c;
    L10:
        return ok4.b.a.f523640a.c(r101, r102, DoraTransferDirection.UPLINK);
    L8:
        r102 = ok4.a.f523635d;
        goto L10
    L5:
        r101 = DoraDeviceLinkType.WIFI_P2P;
        goto L6
    }

    public final void z(h49.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f337990b.remove(r100);
    }

    public final void A(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        ok4.e r102 = ok4.b.a.f523640a;
        DoraTransferDirection r103 = DoraTransferDirection.UPLINK;
        r102.d(r100, r101);
    }

    public static final void e(VisionService r100, int r101, int r102) {
        r100.getClass();
        FLogger.f375446a.i("VisionService", "Write cache: images=" + r101 + ", videos=" + r102);
        r100.f337992d = new Pair(Integer.valueOf(r101), Integer.valueOf(r102));
    }

    public final void k(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        ok4.e r103 = ok4.b.a.f523640a;
        ok4.a.b r104 = ok4.a.f523634c;
        if (r101 == false) goto L5;
        ok4.f r105 = ok4.f.f523665b;
    L6:
        r103.b(r100, r104, r105);
        return;
    L5:
        r105 = new ok4.f.a(r102);
        goto L6
    }

    public final int x(int r100, int r101, int r102) {
        kj4.a r103 = kj4.a.g();
        uj4.j r104 = new uj4.j(r100, r101, r102);
        return r103.f503709d.g(r104);
    }

    public final Object j(String r210, long[] r211, long[] r212, Continuation<? super Boolean> r213) {
        if ((r213 instanceof VisionService$deleteAlbum$1) == false) goto L7;
        VisionService$deleteAlbum$1 r100 = (VisionService$deleteAlbum$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        VisionService$deleteAlbum$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L27:
        v39.b r104 = (v39.b) r102;
    L29:
        return Boxing.boxBoolean(r104 instanceof v39.b.f);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r105 = (String) r110.L$2;
        long[] r106 = (long[]) r110.L$1;
        long[] r107 = (long[]) r110.L$0;
        ResultKt.throwOnFailure(r102);
        String r108 = r105;
        String r109 = "VisionService";
    L20:
        r104 = (v39.b) r102;
        if ((r104 instanceof v39.b.e) == false) goto L23;
    L24:
        FLogger.f375446a.e(r109, "deleteAlbum timeout, retry once. response: ".concat(r104.getClass().getSimpleName()));
        s0 r112 = s0.f332257a;
        qk4.a r113 = new qk4.a(r108, r107, r106);
        r110.L$0 = null;
        r110.L$1 = null;
        r110.L$2 = null;
        r110.label = 2;
        r102 = r112.a(r113, 10000, r110);
        if (r102 != r111) goto L27;
        return r111;
    L23:
        if ((r104 instanceof v39.b.c) == false) goto L29;
    L16:
        ResultKt.throwOnFailure(r102);
        String r114 = IApplog.f287053a.getUserID();
        r109 = "VisionService";
        FLogger.f375446a.i(r109, "deleteAlbum uid: " + r210 + ", mediaIds: " + ArraysKt.joinToString$default(r211, ",", null, null, 0, null, null, 62, null) + ", createTimes: " + ArraysKt.joinToString$default(r212, ",", null, null, 0, null, null, 62, null));
        s0 r115 = s0.f332257a;
        qk4.a r116 = new qk4.a(r114, r211, r212);
        r110.L$0 = r211;
        r110.L$1 = r212;
        r110.L$2 = r114;
        r110.label = 1;
        r102 = r115.a(r116, 10000, r110);
        if (r102 != r111) goto L19;
        return r111;
    L19:
        r108 = r114;
        r107 = r211;
        r106 = r212;
    L7:
        r100 = new VisionService$deleteAlbum$1(this, r213);
        goto L8
    }

    public final Object v(long r210, long r211, byte r212, long r213, Continuation<? super b49.b> r214) {
        long r100 = r210;
        long r101 = r211;
        byte r110 = r212;
        if ((r214 instanceof VisionService$requestAlbumThumbnailDataSync$1) == false) goto L7;
        VisionService$requestAlbumThumbnailDataSync$1 r102 = (VisionService$requestAlbumThumbnailDataSync$1) r214;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        VisionService$requestAlbumThumbnailDataSync$1 r111 = r102;
        Object r104 = r111.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r111.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        byte r107 = r111.B$0;
        ResultKt.throwOnFailure(r104);
    L34:
        v39.b r108 = (v39.b) r104;
        ok4.e r109 = ok4.b.a.f523640a;
        DoraDeviceLinkType r112 = DoraDeviceLinkType.SPP;
        if (r107 != 1) goto L37;
        ok4.a r113 = ok4.a.f523638g;
    L38:
        String r114 = r109.c(r112, r113, DoraTransferDirection.UPLINK);
        int r115 = 1;
    L40:
        if ((r108 instanceof v39.b.f) == false) goto L42;
        ok4.e r116 = ok4.b.a.f523640a;
        v39.b.f r117 = (v39.b.f) r108;
        int r118 = r117.f552961b.f552952d.length;
        DoraTransferDirection r119 = DoraTransferDirection.UPLINK;
        r116.d(r114, r118);
        r116.b(r114, ok4.a.f523637f, ok4.f.f523665b);
        return new b49.b.C0263b(r117.f552961b.f552952d, r115);
    L42:
        ok4.b.a.f523640a.b(r114, ok4.a.f523637f, new ok4.f.a(String.valueOf(r108.f552955a)));
        return new b49.b.a(r108.f552955a, r108.toString());
    L37:
        r113 = ok4.a.f523637f;
        goto L38
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r120 = r111.I$0;
        long r121 = r111.J$2;
        byte r122 = r111.B$0;
        r101 = r111.J$1;
        long r123 = r111.J$0;
        String r124 = (String) r111.L$1;
        String r125 = (String) r111.L$0;
        ResultKt.throwOnFailure(r104);
        r115 = r120;
        String r126 = r125;
        r114 = r124;
        Object r127 = r104;
        Object r128 = r105;
        long r129 = r121;
        r100 = r123;
        r110 = r122;
    L24:
        r108 = (v39.b) r127;
        if ((r108 instanceof v39.b.e) == false) goto L27;
    L30:
        FLogger.f375446a.e("VisionService", "requestAlbumThumbnailDataSync: data is null, retry once. mediaId: " + r100 + ", response: " + r108.getClass().getSimpleName());
        ok4.b.a.f523640a.b(r114, ok4.a.f523637f, new ok4.f.a(String.valueOf(r108.f552955a)));
        s0 r130 = s0.f332257a;
        qk4.d r131 = new qk4.d(r126, r100, r101, r110);
        r111.L$0 = null;
        r111.L$1 = null;
        r111.B$0 = r110;
        r111.label = 2;
        r104 = r130.a(r131, r129, r111);
        if (r104 != r128) goto L33;
        return r128;
    L33:
        r107 = r110;
        goto L34
    L27:
        if ((r108 instanceof v39.b.c) == true) goto L30;
        if ((r108 instanceof v39.b.C7961b) == false) goto L40;
    L16:
        ResultKt.throwOnFailure(r104);
        String r132 = IApplog.f287053a.getUserID();
        FLogger.f375446a.i("VisionService", "requestAlbumThumbnailDataSync: mediaId: " + r100 + ", createTime: " + r101 + ", type: " + r110 + ", timeout: " + r213);
        ok4.e r133 = ok4.b.a.f523640a;
        DoraDeviceLinkType r134 = DoraDeviceLinkType.SPP;
        if (r110 != 1) goto L19;
        ok4.a r135 = ok4.a.f523638g;
    L20:
        String r136 = r133.c(r134, r135, DoraTransferDirection.UPLINK);
        s0 r137 = s0.f332257a;
        r126 = r132;
        r128 = r105;
        qk4.d r138 = new qk4.d(r132, r210, r211, r110);
        r111.L$0 = r126;
        r111.L$1 = r136;
        r111.J$0 = r100;
        r111.J$1 = r101;
        r111.B$0 = r110;
        r129 = r213;
        r114 = r136;
        r111.J$2 = r129;
        r111.I$0 = 0;
        r111.label = 1;
        r127 = r137.a(r138, r129, r111);
        if (r127 != r128) goto L23;
        return r128;
    L23:
        r115 = 0;
        goto L24
    L19:
        r135 = ok4.a.f523637f;
    L7:
        r102 = new VisionService$requestAlbumThumbnailDataSync$1(this, r214);
        goto L8
    }
}
