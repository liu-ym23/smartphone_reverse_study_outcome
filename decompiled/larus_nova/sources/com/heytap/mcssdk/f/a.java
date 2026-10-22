package com.heytap.mcssdk.f;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* JADX INFO: loaded from: classes3.dex */
public class a implements c {
    public a() {
    }

    private void a(com.heytap.mcssdk.c.b r100, PushService r101) {
        if (r100 != null) goto L6;
        String r102 = "message is null , please check param of parseCommandMessage(2)";
    L4:
        d.e(r102);
        return;
    L6:
        if (r101 != null) goto L9;
        r102 = "pushService is null , please check param of parseCommandMessage(2)";
        goto L4
    L9:
        if (r101.getPushCallback() != null) goto L11;
        r102 = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        goto L4
    L11:
        int r103 = r100.e();
        if (r103 != 12287) goto L14;
        ICallBackResultService r104 = r101.getPushCallback();
        if (r104 == null) goto L57;
        r104.onError(r100.g(), r100.f(), r100.i(), r100.h());
        return;
    L57:
        return;
    L14:
        if (r103 != 12298) goto L16;
        r101.getPushCallback().onSetPushTime(r100.g(), r100.f());
        return;
    L16:
        if (r103 != 12306) goto L18;
        r101.getPushCallback().onGetPushStatus(r100.g(), Utils.parseInt(r100.f()));
        return;
    L18:
        if (r103 != 12309) goto L20;
        r101.getPushCallback().onGetNotificationStatus(r100.g(), Utils.parseInt(r100.f()));
        return;
    L20:
        if (r103 == 12289) goto L36;
        if (r103 == 12290) goto L34;
        switch(r103) {
            case 12316: goto L31;
            case 12317: goto L31;
            case 12318: goto L46;
            default: goto L58;
        };
    L31:
        ISetAppNotificationCallBackService r105 = r101.getPushSetAppNotificationCallBack();
        if (r105 == null) goto L50;
        r105.onSetAppNotificationSwitch(r100.g());
        return;
    L50:
        return;
    L46:
        int r106 = CastIntegerProtector.parseInt(r100.f());     // Catch: Exception -> L27
    L28:
        IGetAppNotificationCallBackService r107 = r101.getPushGetAppNotificationCallBack();
        if (r107 == null) goto L48;
        r107.onGetAppNotificationSwitch(r100.g(), r106);
        return;
    L48:
        return;
    L27:
        r106 = 0;
        goto L28
    L58:
        return;
    L34:
        r101.getPushCallback().onUnRegister(r100.g(), r100.i(), r100.h());
        return;
    L36:
        if (r100.g() != 0) goto L38;
        r101.setRegisterID(r100.f());
    L38:
        r101.getPushCallback().onRegister(r100.g(), r100.f(), r100.i(), r100.h());
    }

    public static /* synthetic */ void a(a r100, com.heytap.mcssdk.c.b r101, PushService r102) {
        r100.a(r101, r102);
    }

    @Override // com.heytap.mcssdk.f.c
    public void a(Context r100, BaseMode r101, IDataMessageCallBackService r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getType() != 4105) goto L8;
        final com.heytap.mcssdk.c.b r103 = (com.heytap.mcssdk.c.b) r101;
        d.b("mcssdk-CallBackResultProcessor:" + r103.toString());
        f.a(new AnonymousClass1(this, r103));
        return;
    }
}
