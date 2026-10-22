package l30;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;

/* JADX INFO: loaded from: classes45.dex */
public final class h {
    public static String a(Context r100, TokenCert r101) {
        String r102 = g80.g.b(r101);
        if (r102 != null) goto L6;
        r102 = "-1";
    L6:
        if ("46000".equals(r102) == false) goto L8;
    L27:
        char r103 = 3;
    L28:
        if (r103 == 1) goto L37;
        if (r103 == 2) goto L35;
        if (r103 == 3) goto L33;
        return UserProfileEvent.POSITION_NONE;
    L33:
        return "mobile";
    L35:
        return OnekeyLoginConstants.UNICOM;
    L37:
        return OnekeyLoginConstants.TELECOM;
    L8:
        if ("46002".equals(r102) == true) goto L27;
        if ("46007".equals(r102) == true) goto L27;
        if ("46001".equals(r102) == false) goto L15;
    L26:
        r103 = 2;
        goto L28
    L15:
        if ("46006".equals(r102) == true) goto L26;
        if ("46003".equals(r102) == false) goto L20;
    L25:
        r103 = 1;
        goto L28
    L20:
        if ("46005".equals(r102) == true) goto L25;
        if ("46011".equals(r102) == true) goto L25;
        r103 = 0;
        goto L28
    }
}
