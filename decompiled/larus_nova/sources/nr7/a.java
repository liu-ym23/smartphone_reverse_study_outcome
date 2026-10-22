package nr7;

import android.content.Context;
import com.ccit.SecureCredential.CoreComponent.SoftMethods;
import com.ccit.tiktok.CCITResultVo;
import com.ccit.tiktok.ResultCodeConstant;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoftMethods f520200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f520201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f520202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f520203d;

    public a() {
        this.f520201b = "";
        this.f520202c = "";
        this.f520203d = "";
        this.f520200a = SoftMethods.getInstance();
    }

    public static String a(String r100) {
        String[] r101 = r100.trim().split(",");
        String r102 = "";
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L12;
        String[] r104 = r101[r103].trim().split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r104.length != 2) goto L10;
        if (r104[1].equals("") == true) goto L10;
        r102 = r102 + r101[r103] + ",";
    L10:
        r103 = r103 + 1;
        goto L4
    L12:
        return r102.substring(0, r102.length() - 1).trim();
    }

    public static CCITResultVo b(Context r100) {
        CCITResultVo r101 = new CCITResultVo();
        if (r100 != null) goto L5;
        StringBuilder r102 = new StringBuilder();
        ResultCodeConstant r103 = ResultCodeConstant.CONTEXT_ERROR;
        r102.append(r103.getResultCode());
        r102.append("");
        r101.setResultCode(r102.toString());
        r101.setResultMsg(r103.getResultDesc());
    L6:
        return r101;
    L5:
        r101.setResultCode(AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON);
        r101.setResultMsg(ResultCodeConstant.SAR_OK.getResultDesc());
        goto L6
    }
}
