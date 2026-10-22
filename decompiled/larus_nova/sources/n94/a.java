package n94;

import com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher;
import com.bytedance.bdp.appbase.service.domains.DomainServiceImpl;
import com.bytedance.bdp.appbase.service.permission.PermissionServiceImpl;
import com.bytedance.bdp.appbase.service.permission.SafeCheckServiceImpl;
import com.bytedance.bdp.appbase.service.protocol.device.DeviceServiceCn;
import com.bytedance.bdp.appbase.service.protocol.domains.DomainService;
import com.bytedance.bdp.appbase.service.protocol.permission.PermissionService;
import com.bytedance.bdp.appbase.service.protocol.permission.SafeCheckService;
import com.bytedance.bdp.appbase.ui.contextservice.BasicUiService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends AbsContextServiceFetcher {
    @Override // com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher
    public final HashMap b() {
        HashMap r100 = new HashMap();
        r100.put(DomainService.class, DomainServiceImpl.class);
        r100.put(PermissionService.class, PermissionServiceImpl.class);
        r100.put(SafeCheckService.class, SafeCheckServiceImpl.class);
        r100.put(DeviceServiceCn.class, DeviceServiceCn.class);
        r100.put(BasicUiService.class, BasicUiService.class);
        return r100;
    }

    public a() {
    }
}
