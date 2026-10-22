package wa4;

import android.content.Context;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.live.livecontainer.meta.metainfo.MetaFetchException;
import com.bytedance.bdp.serviceapi.defaults.network.BdpNetworkService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public a() {
    }

    public static void a(Context r100, b r101) throws Exception {
        UriProtector.parse(r101.f558811c).buildUpon().appendQueryParameter("device_id", r101.f558820l).appendQueryParameter("channel", r101.f558821m).appendQueryParameter("app_version", r101.f558816h).appendQueryParameter("device_platform", r101.f558815g).appendQueryParameter("ttcode", r101.f558812d).appendQueryParameter("bdp_sdk_version", "6.7.0").appendQueryParameter("aid", r101.f558817i).appendQueryParameter("version", r101.f558813e).appendQueryParameter("app_id", r101.f558814f).appendQueryParameter("token", r101.f558822n).build().toString();
        BdpNetworkService r102 = (BdpNetworkService) BdpManager.getInst().getService(BdpNetworkService.class);
        if (r102 == null) goto L7;
        new HashMap();
        r102.request();
        throw null;
    L7:
        throw new MetaFetchException("MetaInfoFetcher.fetchInfo: error. BdpAppNetService is not register to BdpManager", null, 2, null);
    }
}
