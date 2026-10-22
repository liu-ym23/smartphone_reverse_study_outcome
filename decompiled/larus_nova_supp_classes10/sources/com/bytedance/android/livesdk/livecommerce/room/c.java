package com.bytedance.android.livesdk.livecommerce.room;

import android.util.Base64;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealStartLiveController;
import com.bytedance.android.livesdk.livecommerce.room.controller.t;
import com.bytedance.android.livesdk.livecommerce.room.controller.v;
import com.bytedance.android.livesdk.livecommerce.room.controller.x;
import com.bytedance.android.livesdkapi.message.IExternalMessageInject;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Random;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements ISaasLiveRoomControllerProvider, i<ISaasLiveRoomController, IStartLivePreviewController> {
    public static final c a = null;

    public c() {
    }

    public final String businessType() {
        return "LiveRoomProviderV2";
    }

    static {
        a = new c();
    }

    public final Object a() {
        return new v(new RealStartLiveController());
    }

    public final IStartLivePreviewController getStartLivePreviewController() {
        Lazy r0 = LiveRoomProvider.a;
        Intrinsics.checkNotNullParameter(this, "factory");
        Object r1 = LiveRoomProvider.f;
        if (r1 != null) goto L6;
        r1 = a();
        LiveRoomProvider.f = r1;
    L6:
        return (IStartLivePreviewController) r1;
    }

    public final String getInjectionLicense() {
        long r0 = System.currentTimeMillis();
        int r2 = new Random(r0).nextInt(99999);
        String r3 = r0 + "::" + r2 + "::" + (r0 % ((long) DeviceStatus$DiffDimension.DIFF_LOCATION_MODE));
        MessageDigest r5 = MessageDigest.getInstance("MD5");
        Charset r6 = Charsets.UTF_8;
        if (r3 == null) goto L7;
        return r0 + "::" + r2 + "::" + Base64.encodeToString(r5.digest(r3.getBytes(r6)), 0);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final void onMessageInjectionAllow(IExternalMessageInject r2) {
        Intrinsics.checkNotNullParameter(r2, "injectionStub");
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L6;
        r1.injectMessageOnSaas(r2);
        return;
    }

    public final ILiveRoomController getController(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "uniqueKey");
        Lazy r0 = LiveRoomProvider.a;
        return (ILiveRoomController) LiveRoomProvider.d(r2, r3, LiveRoomProvider.ECProviderSource.DEFAULT, this);
    }

    public final void onInjectFinished(boolean r1, String r2) {
        ISaasLiveRoomControllerProvider.DefaultImpls.onInjectFinished(this, r1, r2);
    }

    public final void substituteClearLiveRoomController(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "uniqueKey");
        Lazy r2 = LiveRoomProvider.a;
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "uniqueKey");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.i
    public final ISaasLiveRoomController b(String r4, String r5, LiveRoomProvider.ECProviderSource r6) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "uniqueKey");
        Intrinsics.checkNotNullParameter(r6, "env");
        if (r6 == LiveRoomProvider.ECProviderSource.PREVIEW) goto L5;
    L7:
        com.bytedance.android.livesdk.livecommerce.room.api.b r0 = new RealRoomController(r4, r5, r6, false);
    L9:
        return new t(new com.bytedance.android.livesdk.livecommerce.room.api.i(r4, r5, r6), r0);
    L5:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FORBID_PREVIEW_CONTROLLER() == false) goto L7;
        r0 = new x(r4, r5, r6);
        goto L9
    }
}
