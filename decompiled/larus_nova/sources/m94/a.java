package m94;

import com.bytedance.bdp.appbase.address.conetextservice.AddressService;
import com.bytedance.bdp.appbase.adsite.contextservice.AdSiteService;
import com.bytedance.bdp.appbase.approute.contextservice.AppRouterService;
import com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher;
import com.bytedance.bdp.appbase.cpapi.contextservice.CpApiService;
import com.bytedance.bdp.appbase.cpapi.impl.CpApiServiceImpl;
import com.bytedance.bdp.appbase.launchoption.contextservice.LaunchInfoService;
import com.bytedance.bdp.appbase.route.contextservice.RouterService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends AbsContextServiceFetcher {
    @Override // com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher
    public final HashMap b() {
        HashMap r100 = new HashMap();
        r100.put(AddressService.class, AddressService.class);
        r100.put(AdSiteService.class, AdSiteService.class);
        r100.put(AppRouterService.class, AppRouterService.class);
        r100.put(CpApiService.class, CpApiServiceImpl.class);
        r100.put(LaunchInfoService.class, LaunchInfoService.class);
        r100.put(RouterService.class, RouterService.class);
        return r100;
    }

    public a() {
    }
}
