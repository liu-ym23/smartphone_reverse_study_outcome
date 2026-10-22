package r18;

import android.text.TextUtils;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class b {
    public static String b(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getClass().getCanonicalName();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return r100.getClass().getName();
    }

    public static String c(LKBaseResponseModel r100) {
        if (r100 != null) goto L7;
        Log.i("PluginUtils", "responseModel is null");
        return null;
    L7:
        if (r100.getApiErrCode() != null) goto L11;
        Log.i("PluginUtils", "apiErrCode in responseModel is null");
        return null;
    L11:
        if (TextUtils.isEmpty(r100.getCustomErrMsg()) == true) goto L15;
        Log.i("PluginUtils", "customErrMsg in responseModel is valid:" + r100.getCustomErrMsg());
        return r100.getCustomErrMsg();
    L15:
        return r100.getApiErrCode().f516674b;
    }

    public static void a(JSONObject r100, LKBaseResponseModel r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.findRemovedParams() != null) goto L6;
        return;
    L6:
        if (r101.findRemovedParams().isEmpty() == true) goto L20;
        Iterator<String> r102 = r101.findRemovedParams().iterator();
    L9:
        if (r102.hasNext() == false) goto L21;
        String r103 = r102.next();
        if (r100.has(r103) == false) goto L9;
        r100.remove(r103);
        Log.i("PluginUtils", "check & remove params for : " + r101 + " key : " + r103);
        goto L9
    L21:
        return;
    }
}
