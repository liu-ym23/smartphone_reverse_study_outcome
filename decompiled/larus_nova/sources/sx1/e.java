package sx1;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import g80.g;

/* JADX INFO: loaded from: classes8.dex */
public final class e {
    public static String a(Context r100, TokenCert r101) {
        if (r100 == null) goto L6;
        String r102 = g.b(r101);
        if (r102 == null) goto L6;
    L8:
        if ("46000".equals(r102) == false) goto L10;
    L29:
        char r103 = 3;
    L30:
        if (r103 == 1) goto L39;
        if (r103 == 2) goto L37;
        if (r103 == 3) goto L35;
        return UserProfileEvent.POSITION_NONE;
    L35:
        return "mobile";
    L37:
        return OnekeyLoginConstants.UNICOM;
    L39:
        return OnekeyLoginConstants.TELECOM;
    L10:
        if ("46002".equals(r102) == true) goto L29;
        if ("46007".equals(r102) == true) goto L29;
        if ("46001".equals(r102) == false) goto L17;
    L28:
        r103 = 2;
        goto L30
    L17:
        if ("46006".equals(r102) == true) goto L28;
        if ("46003".equals(r102) == false) goto L22;
    L27:
        r103 = 1;
        goto L30
    L22:
        if ("46005".equals(r102) == true) goto L27;
        if ("46011".equals(r102) == true) goto L27;
        r103 = 0;
    L6:
        r102 = "-1";
        goto L8
    }
}
