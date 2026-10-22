package com.dtf.face.api;

import android.content.Context;
import android.os.Message;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import hs7.a;

/* JADX INFO: loaded from: classes22.dex */
public class DTFacadeSec {

    /* JADX INFO: renamed from: com.dtf.face.api.DTFacadeSec$1, reason: invalid class name */
    public static class AnonymousClass1 implements SgomInfoManager.ITokenUpdate {
        public final /* synthetic */ long val$alipayDeviceStartTime;
        public final /* synthetic */ APICallback val$apiCallback;

        @Override // com.alipay.zoloz.toyger.SgomInfoManager.ITokenUpdate
        public void onUpdate(Message r110) {
            String r100 = (String) r110.obj;
            int r101 = r110.what;
            r110.recycle();
            long r102 = System.currentTimeMillis() - this.val$alipayDeviceStartTime;
            if (r101 == 0) goto L7;
            a.h().f486993e = "";
            RecordService.getInstance().recordEvent(4, "deviceTokenInit", new String[]{"status", "false", "errCode", String.valueOf(r101), "initCost", String.valueOf(r102)});
            APICallback r111 = this.val$apiCallback;
            if (r111 == null) goto L11;
            r111.onError(String.valueOf(r101), null, null);
            return;
        L11:
            return;
        L7:
            a.h().f486993e = r100;
            RecordService.getInstance().recordEvent(4, "deviceTokenInit", new String[]{"status", "true", "initCost", String.valueOf(r102)});
            APICallback r112 = this.val$apiCallback;
            if (r112 == null) goto L13;
            r112.onSuccess(r100);
            return;
        }

        public AnonymousClass1(long r100, APICallback r101) {
            this.val$alipayDeviceStartTime = r100;
            this.val$apiCallback = r101;
        }
    }

    static {
        ytc.a.b();
    }

    public static native String initApdid(Context r100, APICallback<String> r101);

    public DTFacadeSec() {
    }
}
