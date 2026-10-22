package faceverify;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.dtf.face.api.IDTResponseCode;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.network.model.ZimValidateResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements APICallback<Map<String, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ns7.a f476108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f476109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f476110c;

    @Override // com.dtf.face.network.APICallback
    public void onSuccess(Map<String, Object> r110) {
        Map<String, Object> r111 = r110;
        if (hs7.a.h().b(this.f476108a.f520321b, "zimValidate", System.currentTimeMillis() - this.f476109b) == true) goto L37;
        if (r111 != null) goto L7;
        return;
    L7:
        if (r111.size() == 0) goto L38;
        String r112 = (String) r111.get("data");
        ZimValidateResponse r100 = new ZimValidateResponse();
        String r101 = null;
        ZimValidateResponse r102 = (ZimValidateResponse) JSON.parseObject(r112, ZimValidateResponse.class);     // Catch: Throwable -> L29
        r102.fixParams();     // Catch: Throwable -> L13
    L15:
        FaceDataFrameInfo.info_cache = "" + this.f476108a.f520321b + "." + r102.productRetCode + "." + r102.validationRetCode;
        SgomInfoManager.updateSgomInfo(294245281, null);
        RecordService.getInstance().recordEvent(1, "faceVerifyValidate", new String[]{"status", "success", "content", r112});
        ms7.a r103 = (ms7.a) this.f476110c.get("zimValidateCallback");
        if (r103 != null) goto L19;
        return;
    L19:
        if (IDTResponseCode.ZIM_NET_VERIFY_SUCCESS.equals(r102.retCodeSub) == false) goto L22;
        RecordService.getInstance().recordEvent(2, "netVerifyRes", new String[]{"status", "success", "verify", "success"});
        r103.onSuccess();
        return;
    L22:
        if (String.valueOf(3003).equals(r102.validationRetCode) == false) goto L27;
        JSONObject r113 = JSON.parseObject(r102.extParams);
        if (r113 == null) goto L26;
        r101 = r113.getString("phoneNo");
    L26:
        r103.a(r101);
        return;
    L27:
        RecordService.getInstance().recordEvent(2, "netVerifyRes", new String[]{"status", "success", "verify", "false", "msg", "Face Compare onValidateFail, retCodeSub=" + r102.retCodeSub + " retMessageSub=" + r102.retMessageSub + " srvRes=" + r112});
        r103.b(r102.retCodeSub, r102.retMessageSub, r112);
        return;
    L13:
        r100 = r102;
    L14:
        r100.validationRetCode = null;
        r102 = r100;
        goto L15
    L38:
        return;
    }

    public e(ns7.a r100, long r101, Map r102) {
        this.f476108a = r100;
        this.f476109b = r101;
        this.f476110c = r102;
    }

    @Override // com.dtf.face.network.APICallback
    public void onError(String r110, String r111, String r112) {
        if (hs7.a.h().b(this.f476108a.f520321b, "zimValidate", System.currentTimeMillis() - this.f476109b) == false) goto L5;
        return;
    L5:
        FaceDataFrameInfo.info_cache = "" + this.f476108a.f520321b + "." + r110 + ".";
        SgomInfoManager.updateSgomInfo(294245281, null);
        RecordService.getInstance().recordEvent(4, "faceVerifyValidate", new String[]{"status", "error", "errCode", r110, "errMsg", r111});
        ms7.a r100 = (ms7.a) this.f476110c.get("zimValidateCallback");
        if (r100 != null) goto L8;
        return;
    L8:
        if (HTTP.SERVER.equals(r112) == false) goto L10;
        RecordService.getInstance().recordEvent(4, "netVerifyRes", new String[]{"status", "fail", "msg", "Server Internal onError, code=" + r110 + " errMsg=" + r111});
        r100.onServerError(r110, r111);
        return;
    L10:
        RecordService.getInstance().recordEvent(4, "netVerifyRes", new String[]{"status", "fail", "msg", "Face Compare onError, code=" + r110 + " errMsg=" + r111});
        r100.onError(r110, r111);
    }
}
