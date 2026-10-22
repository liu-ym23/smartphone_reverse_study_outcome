package dl0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class f {
    public static final String a(List<? extends LinkPlayerInfo> r100, List<? extends LinkPlayerInfo> r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "anchorUsers");
        Intrinsics.checkNotNullParameter(r101, "anchorOppoUsers");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "guestAnchorId");
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L34
        JSONArray r105 = new JSONArray();     // Catch: JSONException -> L34
        boolean r106 = false;
        if (r102.length() <= 0) goto L6;
        boolean r107 = true;
    L7:
        if (r107 == false) goto L19;
        Iterator<T> r108 = r100.iterator();     // Catch: JSONException -> L34
    L10:
        if (r108.hasNext() == false) goto L17;
        IBaseUser r109 = ((LinkPlayerInfo) r108.next()).getUser();     // Catch: JSONException -> L34
        if (r109 == null) goto L15;
        String r110 = r109.getIdString();     // Catch: JSONException -> L34
        if (r110 == null) goto L15;
    L16:
        r105.put(r110);     // Catch: JSONException -> L34
    L15:
        r110 = "";
        goto L16
    L17:
        r104.put(r102, r105);     // Catch: JSONException -> L34
    L19:
        if (r103.length() <= 0) goto L21;
        r106 = true;
    L21:
        if (r106 == false) goto L32;
        JSONArray r111 = new JSONArray();     // Catch: JSONException -> L34
        Iterator<T> r112 = r101.iterator();     // Catch: JSONException -> L34
    L24:
        if (r112.hasNext() == false) goto L31;
        IBaseUser r113 = ((LinkPlayerInfo) r112.next()).getUser();     // Catch: JSONException -> L34
        if (r113 == null) goto L29;
        String r114 = r113.getIdString();     // Catch: JSONException -> L34
        if (r114 == null) goto L29;
    L30:
        r111.put(r114);     // Catch: JSONException -> L34
    L29:
        r114 = "";
        goto L30
    L31:
        r104.put(r103, r111);     // Catch: JSONException -> L34
    L32:
        return r104.toString();
    L6:
        r107 = false;
    L34:
        return "";
    }
}
