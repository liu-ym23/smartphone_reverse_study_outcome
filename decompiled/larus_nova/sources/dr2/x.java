package dr2;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import io.reactivex.subjects.PublishSubject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class x implements ILiveFaceCertCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i.b f469746a;

    public x(com.bytedance.android.live.wallet.platform.business.verify.f r100) {
        this.f469746a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback
    public final void onVerifyResult(LiveCertResult r110) {
        if (r110 == null) goto L33;
        LiveCertStatus r100 = r110.getStatus();
        if (r100 == null) goto L6;
        int r101 = r100.getCertStatus();
    L7:
        LiveCertStatus r102 = r110.getStatus();
        if (r102 == null) goto L10;
        int r103 = r102.getManualStatus();
    L11:
        LiveCertStatus r104 = r110.getStatus();
        if (r104 == null) goto L14;
        int r105 = r104.getAgeRange();
    L15:
        i.a r106 = new i.a(r101, r103, r105);
        int r107 = r110.getErrorCode();
        String r108 = r110.getErrorMsg();
        String r109 = r110.getTicket();
        JSONObject r111 = r110.getExtraData();
        i.b r112 = this.f469746a;
        if (r112 == null) goto L34;
        com.bytedance.android.live.wallet.platform.business.verify.f r113 = (com.bytedance.android.live.wallet.platform.business.verify.f) r112;
        com.bytedance.android.live.wallet.platform.business.verify.h r114 = r113.f102723a;
        boolean r115 = r113.f102724b;
        ApiServerException r116 = r113.f102725c;
        PublishSubject r117 = r113.f102726d;
        if (r114.f102730b == true) goto L35;
        StringBuilder r118 = new StringBuilder("diamond buy verify result, result=");
        r118.append("RevLiveCertResult(status=" + r106 + ", errorCode=" + r107 + ", errorMsg=" + r108 + ", ticket=" + r109 + ", extraData=" + r111 + ')');
        ALogger.i("DiamondBuyVerifyTransformer", r118.toString());
        if (r115 == false) goto L25;
        if (r107 != 0) goto L24;
        r114.f102732d.put("two_factory_auth_verify_info", r116.getExtra());
        r117.onNext(1);
        r114.b(true, "");
    L31:
        r114.f102730b = true;
        return;
    L24:
        r117.onError(r116.setProcessAndReturn(true));
        r114.b(false, r108);
        goto L31
    L25:
        if (r101 != 1) goto L27;
        boolean r119 = true;
    L28:
        if (r119 == false) goto L30;
        r114.f102732d.put("two_factory_auth_verify_info", r116.getExtra());
        r117.onNext(1);
        r114.b(true, "");
        goto L31
    L30:
        r117.onError(r116.setProcessAndReturn(true));
        r114.b(false, r108);
        goto L31
    L27:
        r119 = false;
        goto L28
    L35:
        return;
    L34:
        return;
    L14:
        r105 = 0;
        goto L15
    L10:
        r103 = 0;
        goto L11
    L6:
        r101 = 0;
        goto L7
    }
}
