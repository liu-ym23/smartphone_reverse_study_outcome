package sh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.TnsBlockResult;
import com.google.gson.Gson;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String a(Throwable r100) {
    L10:
        th = move-exception;
        tt5.a.f("PermissionErrorCode", th, false);
    L12:
        return "";
    L4:
        if ((r100 instanceof NetService.ServerErrorException) == false) goto L12;
        String r101 = ((NetService.ServerErrorException) r100).getJson();     // Catch: Throwable -> L10
        String r102 = ((TnsBlockResult) new Gson().fromJson(r101, TnsBlockResult.class)).getUrl();     // Catch: Throwable -> L10
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    }
}
