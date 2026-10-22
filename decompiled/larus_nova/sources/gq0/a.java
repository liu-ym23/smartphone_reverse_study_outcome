package gq0;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import is2.b;
import jc1.k;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements b {
    public a() {
    }

    @Override // is2.b
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // is2.b
    public final /* synthetic */ boolean c() {
        return false;
    }

    @Override // is2.b
    public final void d() {
    }

    @Override // is2.b
    public final /* synthetic */ boolean f() {
        return false;
    }

    @Override // is2.b
    public final String getPath() {
        return "backend_microapp_shelf_info_request";
    }

    @Override // is2.b
    public final boolean enable() {
        return de0.f120026a.getValue().o();
    }

    @Override // is2.b
    public final Class<tq0.a> getModelClass() {
        return tq0.a.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", 2);
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L6;
        String r104 = r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_REQUEST_ID);
        if (r104 == null) goto L6;
    L7:
        BaseMonitor.add(r103, "req_id", r104);
        Unit r105 = Unit.INSTANCE;
        BaseMonitor.add(r102, "client_extra", r103.toString());
        IHostContext r106 = (IHostContext) k.f(IHostContext.class);
        if (r106 != null) goto L10;
    L12:
        return r102;
    L10:
        if (r106.isOpSandboxDevMode() != true) goto L12;
        BaseMonitor.add(r102, "rpc-persist-sandbox", "1");
    L6:
        r104 = "";
        goto L7
    }
}
