package com.bytedance.bdp.bdpplatform.service.bpea;

import android.app.Fragment;
import com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaPermissionService;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bdp/bdpplatform/service/bpea/BdpBpeaPermissionServicImpl;", "Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaPermissionService;", "Lcom/bytedance/bdp/bdpplatform/service/bpea/BdpBpeaServiceImpl;", "Landroid/app/Fragment;", WidgetService.PARAM_FRAGMENT, "", "", ComplianceResult.JsonKey.PERMISSIONS, "", "requestCode", "token", "", "requestPermissions", "(Landroid/app/Fragment;[Ljava/lang/String;ILjava/lang/String;)V", "<init>", "()V", "bdp-service_release"}, k = 1, mv = {1, 4, 0})
public final class BdpBpeaPermissionServicImpl extends BdpBpeaServiceImpl implements BdpBpeaPermissionService {
    public BdpBpeaPermissionServicImpl() {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaPermissionService
    public void requestPermissions(Fragment r100, String[] r101, int r102, String r103) {
        r100.requestPermissions(r101, r102);
    }
}
