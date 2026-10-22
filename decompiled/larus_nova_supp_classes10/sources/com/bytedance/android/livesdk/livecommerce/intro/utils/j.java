package com.bytedance.android.livesdk.livecommerce.intro.utils;

import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.w;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements com.bytedance.android.livesdk.livecommerce.room.model.e {
    public final /* synthetic */ Map a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String a() {
        return "";
    }

    public final String d() {
        return BDLocationException.ERROR_TIMEOUT;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final boolean isAnchor() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String b() {
        int r0 = RoomContextController.h;
        return RoomContextController.a.b(this.c, null).I();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String getGroupId() {
        return (String) this.a.get("group_id");
    }

    public final String c() {
        return this.d;
    }

    public final String roomId() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.model.e
    public final String e(String r8) {
        Intrinsics.checkNotNullParameter(r8, "carrierType");
        ECEventUtilsV2 r0 = ECEventUtilsV2.b;
        Map r2 = this.a;
        Map r3 = this.b;
        int r1 = w.h;
        String r6 = w.a.c(r3);
        r0.getClass();
        return ECEventUtilsV2.b(r8, r2, r3, null, null, r6);
    }

    public j(Map r1, Map r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
