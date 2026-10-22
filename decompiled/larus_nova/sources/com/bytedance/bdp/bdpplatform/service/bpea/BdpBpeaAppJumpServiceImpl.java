package com.bytedance.bdp.bdpplatform.service.bpea;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaAppJumpService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/bdp/bdpplatform/service/bpea/BdpBpeaAppJumpServiceImpl;", "Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaAppJumpService;", "Lcom/bytedance/bdp/bdpplatform/service/bpea/BdpBpeaServiceImpl;", "()V", "startActivity", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "token", "", "customInfo", "", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bdp-service_release"}, k = 1, mv = {1, 1, 18})
public final class BdpBpeaAppJumpServiceImpl extends BdpBpeaServiceImpl implements BdpBpeaAppJumpService {
    public BdpBpeaAppJumpServiceImpl() {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaAppJumpService
    public void startActivity(Activity r100, Intent r101, String r102) {
        r100.startActivity(r101);
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaAppJumpService
    public void startActivity(Context r100, Intent r101, String r102) {
        r100.startActivity(r101);
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaAppJumpService
    public void startActivity(Activity r100, Intent r101, String r102, Map<String, ? extends Object> r103) {
        r100.startActivity(r101);
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaAppJumpService
    public void startActivity(Context r100, Intent r101, String r102, Map<String, ? extends Object> r103) {
        r100.startActivity(r101);
    }
}
