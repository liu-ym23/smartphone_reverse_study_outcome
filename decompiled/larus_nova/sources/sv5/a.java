package sv5;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static String a(String r100) {
        if (r100.endsWith(".js") == false) goto L6;
        return "application/x-javascript";
    L6:
        if (r100.endsWith(InvRouter.FLOW_SUFFIX) == false) goto L9;
        return "application/json";
    L9:
        if (r100.endsWith(".css") == false) goto L12;
        return "text/css";
    L12:
        if (r100.endsWith(".html") == false) goto L15;
        return "text/html";
    L15:
        if (r100.endsWith(".ico") == false) goto L18;
        return "image/x-icon";
    L18:
        if (r100.endsWith(".jpeg") == false) goto L20;
    L38:
        return "image/jpeg";
    L20:
        if (r100.endsWith(".jpg") == true) goto L38;
        if (r100.endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L26;
        return "image/png";
    L26:
        if (r100.endsWith(EffectConstants.GIF_FILE_SUFFIX) == false) goto L29;
        return MimeType.GIF;
    L29:
        if (r100.endsWith(".woff") == false) goto L32;
        return "font/woff";
    L32:
        if (r100.endsWith(".svg") == false) goto L35;
        return "image/svg+xml";
    L35:
        if (r100.endsWith(".ttf") == false) goto L37;
        return "font/ttf";
    L37:
        return "";
    }
}
