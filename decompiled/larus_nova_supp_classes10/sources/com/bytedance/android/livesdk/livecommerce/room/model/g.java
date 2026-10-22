package com.bytedance.android.livesdk.livecommerce.room.model;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements e {
    public final RoomContextController a;
    public final ECContext b;

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String a() {
        return this.a.D();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String b() {
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L8;
        String r0 = this.a.I();
        if (r0 != null) goto L12;
        return BDLocationException.ERROR_TIMEOUT;
    L12:
        return r0;
    L8:
        if (this.a.v() == false) goto L11;
        return this.a.I();
    L11:
        return this.a.I();
    }

    public final String c() {
        return (String) this.b.getAnchorId().getValue();
    }

    public final String d() {
        return (String) this.b.getAnchorSecId().getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String getGroupId() {
        if (this.a.v() == false) goto L7;
        LiveRoomParams r0 = this.a.l();
        if (r0 != null) goto L12;
        return null;
    L12:
        return r0.getGroupId();
    L7:
        LiveRoomParams r1 = this.a.l();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getGroupId();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final boolean isAnchor() {
        return ((Boolean) this.b.isAnchor().getValue()).booleanValue();
    }

    public final String roomId() {
        return (String) this.b.getRoomId().getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "carrierType");
        Object r1 = null;
        if (ECLiveABUtils.INSTANCE.getFIX_LIVE_ROOM_ENTRANCE_INFO().booleanValue() == false) goto L21;
        ECEventUtilsV2 r0 = ECEventUtilsV2.b;
        LiveRoomParams r2 = this.a.l();
        if (r2 == null) goto L9;
        JSONObject r3 = r2.getEntranceInfo();
        if (r3 == null) goto L9;
        Map r4 = z1.j(r3);
    L10:
        LiveRoomParams r5 = this.a.l();
        if (r5 == null) goto L13;
        Map r6 = r5.getEcomLiveParamsEventParams();
    L14:
        if (r6 != null) goto L16;
        r6 = MapsKt.emptyMap();
    L16:
        Map r7 = r6;
        LiveRoomParams r8 = this.a.l();
        if (r8 == null) goto L19;
        r1 = r8.getEcomSceneId();
    L19:
        r0.getClass();
        return ECEventUtilsV2.b(r10, r4, r7, null, null, r1);
    L13:
        r6 = null;
    L9:
        r4 = null;
        goto L10
    L21:
        if (this.a.v() == false) goto L26;
        LiveRoomParams r11 = this.a.l();
        if (r11 == null) goto L29;
        r1 = r11.getEntranceInfo();
    L29:
        return String.valueOf(r1);
    L26:
        ECEventUtilsV2.b.getClass();
        return ECEventUtilsV2.a(r10);
    }

    public g(ECContext r2, RoomContextController r3) {
        Intrinsics.checkNotNullParameter(r2, "ecContext");
        this.b = r2;
        if (r3 != null) goto L5;
        int r4 = RoomContextController.h;
        r3 = RoomContextController.a.a();
    L5:
        this.a = r3;
    }
}
