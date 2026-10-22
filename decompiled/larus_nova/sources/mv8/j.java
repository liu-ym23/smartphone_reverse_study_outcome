package mv8;

import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements zc.g {
    public j() {
    }

    @Override // zc.g
    public final void a(String r100, JSONObject r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        if (r101 == null) goto L5;
        r101.putOpt("update_version_code", Integer.valueOf(AppHost.f326268a.getUpdateVersionCode()));
    L5:
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r100, r101, null, r102);
    }
}
