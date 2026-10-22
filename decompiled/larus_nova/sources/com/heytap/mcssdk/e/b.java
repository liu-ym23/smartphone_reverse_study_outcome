package com.heytap.mcssdk.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b extends c {
    public b() {
    }

    @Override // com.heytap.mcssdk.e.d
    public BaseMode a(Context r100, int r101, Intent r102) {
        if (4103 != r101) goto L5;
    L11:
        BaseMode r103 = a(r102, r101);
        com.heytap.mcssdk.g.a.a(r100, com.heytap.mcssdk.constant.c.a.f276378b, (DataMessage) r103);
        return r103;
    L5:
        if (4098 == r101) goto L11;
        if (4108 == r101) goto L11;
        return null;
    }

    @Override // com.heytap.mcssdk.e.c
    public BaseMode a(Intent r100, int r101) {
        DataMessage r102 = new DataMessage();     // Catch: Exception -> L12
        r102.setMessageID(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276353c)));     // Catch: Exception -> L12
        r102.setTaskID(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276354d)));     // Catch: Exception -> L12
        r102.setGlobalId(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276358h)));     // Catch: Exception -> L12
        r102.setAppPackage(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276355e)));     // Catch: Exception -> L12
        r102.setTitle(com.heytap.mcssdk.utils.b.d(r100.getStringExtra("title")));     // Catch: Exception -> L12
        r102.setContent(com.heytap.mcssdk.utils.b.d(r100.getStringExtra("content")));     // Catch: Exception -> L12
        r102.setDescription(com.heytap.mcssdk.utils.b.d(r100.getStringExtra("description")));     // Catch: Exception -> L12
        String r103 = com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276360j));     // Catch: Exception -> L12
        int r104 = 0;
        if (TextUtils.isEmpty(r103) == false) goto L5;
        int r105 = 0;
    L6:
        r102.setNotifyID(r105);     // Catch: Exception -> L12
        r102.setMiniProgramPkg(com.heytap.mcssdk.utils.b.d(r100.getStringExtra("miniProgramPkg")));     // Catch: Exception -> L12
        r102.setMessageType(r101);     // Catch: Exception -> L12
        r102.setEventId(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276361k)));     // Catch: Exception -> L12
        r102.setStatisticsExtra(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276362l)));     // Catch: Exception -> L12
        String r106 = com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276363m));     // Catch: Exception -> L12
        r102.setDataExtra(r106);     // Catch: Exception -> L12
        String r107 = a(r106);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r107) == true) goto L10;
        r104 = CastIntegerProtector.parseInt(r107);     // Catch: Exception -> L12
    L10:
        r102.setMsgCommand(r104);     // Catch: Exception -> L12
        r102.setBalanceTime(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276364n)));     // Catch: Exception -> L12
        r102.setStartDate(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276369s)));     // Catch: Exception -> L12
        r102.setEndDate(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276370t)));     // Catch: Exception -> L12
        r102.setTimeRanges(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276365o)));     // Catch: Exception -> L12
        r102.setRule(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276366p)));     // Catch: Exception -> L12
        r102.setForcedDelivery(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276367q)));     // Catch: Exception -> L12
        r102.setDistinctContent(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276368r)));     // Catch: Exception -> L12
        r102.setAppId(com.heytap.mcssdk.utils.b.d(r100.getStringExtra(com.heytap.mcssdk.constant.b.f276371u)));     // Catch: Exception -> L12
        return r102;
    L5:
        r105 = CastIntegerProtector.parseInt(r103);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage());
        return null;
    }

    public String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return new JSONObject(r100).optString(com.heytap.mcssdk.constant.b.f276372v);
    L7:
        e = move-exception;
        com.heytap.mcssdk.utils.d.b(e.getMessage());
        return "";
    }
}
