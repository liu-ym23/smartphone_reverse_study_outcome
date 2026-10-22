package com.bytedance.bdp.serviceapi.hostimpl.bpea;

import android.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaPermissionService;", "Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaService;", "Landroid/app/Fragment;", WidgetService.PARAM_FRAGMENT, "", "", ComplianceResult.JsonKey.PERMISSIONS, "", "requestCode", "token", "", "requestPermissions", "(Landroid/app/Fragment;[Ljava/lang/String;ILjava/lang/String;)V", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public interface BdpBpeaPermissionService extends BdpBpeaService {
    void requestPermissions(Fragment r100, String[] r101, int r102, String r103);
}
