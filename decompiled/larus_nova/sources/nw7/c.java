package nw7;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f521011a = null;

    static {
        f521011a = new ArrayList();
        String[] r100 = {"userid", "password", "siteid", "plmn", "mobilephone", "deviceinfo", ST.UUID_DEVICE, "deviceid2", "secretdigest", "salt", "emmcid", "secretdigesttype", "clientip", "deviceid", "device_id", OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, "securityemail", BaseHttpRequestInfo.KEY_COOKIE, "devicetype", "useremail", "email", "servicetoken", "oldpassword", "newpassword", "thirdtoken", "smsauthcode", "phone", "access_token", SRStrategy.KEY_SR_STRATEGY_CONFIG, "sso_st", "token", TTVideoEngineInterface.PLAY_API_KEY_AC, "pw", "dvid", "pl", "dvid2", SRStrategy.KEY_SR_STRATEGY_CONFIG, "emid", "sct", "c", Segment.JsonKey.START, "app", "uid", "imsi", "thirdopenid", "thirdaccesstoken", "accountName", "useraccount", "fulluseraccount", "nickName", "uniquelynickname", "loginusername", "thirdnickname", "fingerST"};
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        String r103 = r100[r102];
        if (TextUtils.isEmpty(r103) == true) goto L7;
        List<String> r104 = f521011a;
        ArrayList r105 = (ArrayList) r104;
        r105.add(r103.toLowerCase(Locale.ENGLISH));
    L7:
        r102 = r102 + 1;
        goto L3
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        if (r100.length() != 1) goto L10;
        return "*";
    L10:
        int r101 = (int) Math.ceil(((double) (r100.length() * 50)) / 100.0d);
        StringBuilder r102 = new StringBuilder();
        StringBuffer r103 = new StringBuffer(r101);
        int r104 = 0;
    L11:
        if (r104 >= r101) goto L13;
        r103.append('*');
        r104 = r104 + 1;
        goto L11
    L13:
        r102.append(r103.toString());
        r102.append(r100.substring(r101));
        return r102.toString();
    }
}
