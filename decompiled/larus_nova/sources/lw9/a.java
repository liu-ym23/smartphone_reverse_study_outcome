package lw9;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements jn7.a {
    public a() {
    }

    @Override // jn7.a
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("enable_hidden_watermark", false);
        r100.put("hide_save_image_preview_dialog", true);
        return r100;
    }

    @Override // jn7.a
    public final String getAppId() {
        return String.valueOf(AppHost.f326268a.getAppId());
    }

    @Override // jn7.a
    public final String getDeviceId() {
        return o.f365780a.getDeviceId();
    }

    @Override // jn7.a
    public final void b(Context r100, String r101) {
        SmartRouter.buildRoute(r100, r101).d();
    }
}
