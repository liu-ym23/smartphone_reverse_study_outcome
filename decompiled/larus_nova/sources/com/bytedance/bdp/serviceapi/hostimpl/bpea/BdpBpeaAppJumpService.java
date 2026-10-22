package com.bytedance.bdp.serviceapi.hostimpl.bpea;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaAppJumpService;", "Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaService;", "startActivity", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "token", "", "customInfo", "", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface BdpBpeaAppJumpService extends BdpBpeaService {
    void startActivity(Activity r100, Intent r101, String r102) throws ActivityNotFoundException;

    void startActivity(Activity r100, Intent r101, String r102, Map<String, ? extends Object> r103) throws ActivityNotFoundException;

    void startActivity(Context r100, Intent r101, String r102) throws ActivityNotFoundException;

    void startActivity(Context r100, Intent r101, String r102, Map<String, ? extends Object> r103) throws ActivityNotFoundException;
}
