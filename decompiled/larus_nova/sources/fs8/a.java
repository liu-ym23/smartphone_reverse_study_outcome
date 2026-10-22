package fs8;

import com.bytedance.keva.Keva;
import com.larus.home.impl.sdk.d;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.o;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f478664a = null;

    static {
        f478664a = Keva.getRepo("image_upload_keva", 0);
    }

    public static String a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L7;
        r100.getAccountService();
        boolean r101 = true;
        if (d.f346150a.a() != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        return "_minor";
    L10:
        return "";
    L7:
        r101 = false;
        goto L8
    }

    public static void b(boolean r100) {
        o r101 = o.f365780a;
        JSONObject r102 = new JSONObject();
        if (r100 == false) goto L5;
        String r103 = "1";
    L6:
        r102.put("cached", r103);
        r102.put("resource_center_enabled", false);
        Unit r104 = Unit.INSTANCE;
        r101.reportEvent("uploader_token_used", r102);
        return;
    L5:
        r103 = "0";
        goto L6
    }
}
