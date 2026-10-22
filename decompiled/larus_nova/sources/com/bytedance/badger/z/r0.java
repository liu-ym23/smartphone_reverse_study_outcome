package com.bytedance.badger.z;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.helper.MiDetectHelper;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class r0 extends u0 {
    public r0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r100, BadgerModuleBase.BadgerRequestData r101) {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") == true) goto L10;
        String r102 = Build.BRAND;
        if (r102.equalsIgnoreCase("XIAOMI") == true) goto L10;
        if (r102.equalsIgnoreCase("REDMI") == true) goto L10;
        boolean r103 = false;
    L11:
        if (r103 == false) goto L23;
        CountDownLatch r104 = new CountDownLatch(1);
        JSONObject r105 = new JSONObject();
        if (MiDetectHelper.init(r100, MiDetectHelper.DOUYIN_APP_ID, MiDetectHelper.DOUYIN_APP_KEY) == false) goto L20;
        MiDetectHelper.getTrustDeviceStatus(UUID.randomUUID().toString(), new q0(this, r105, r104));
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r106 = com.bytedance.badger.v.d.L;
        KProperty r107 = com.bytedance.badger.v.d.f199311a[38];
        com.bytedance.badger.v.w r108 = (com.bytedance.badger.v.w) r106.a();
        if (r104.await(r108.f199356a, r108.f199357b) == false) goto L19;
        return new BadgerResult.Success(new DataString(r105.toString()));
    L19:
        throw new TimeoutException("timeout");
    L20:
        r104.countDown();
        throw new RuntimeException("service bind error");
    L23:
        throw new RuntimeException("not support");
    L10:
        r103 = true;
        goto L11
    }

    public static final void c(r0 r100, JSONObject r101, String r102, int r103, String r104) {
        r100.getClass();
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = "";
    L8:
        r105.putOpt("result", r102);     // Catch: Exception -> L12
        r105.putOpt("code", Integer.valueOf(r103));     // Catch: Exception -> L12
        r105.putOpt("error", r104);     // Catch: Exception -> L12
        r101.putOpt("trust_device_info", r105);     // Catch: Exception -> L12
        return;
    }
}
