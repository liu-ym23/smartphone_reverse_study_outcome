package sh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.TnsBlockResult;
import com.google.gson.Gson;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String a(Throwable r3) {
    L10:
        th = move-exception;
        tt5.a.f("PermissionErrorCode", th, false);
    L12:
        return "";
    L4:
        if ((r3 instanceof NetService.ServerErrorException) == false) goto L12;
        String r4 = ((NetService.ServerErrorException) r3).getJson();     // Catch: Throwable -> L10
        String r5 = ((TnsBlockResult) new Gson().fromJson(r4, TnsBlockResult.class)).getUrl();     // Catch: Throwable -> L10
        if (r5 != null) goto L9;
        return "";
    L9:
        return r5;
    }
}
