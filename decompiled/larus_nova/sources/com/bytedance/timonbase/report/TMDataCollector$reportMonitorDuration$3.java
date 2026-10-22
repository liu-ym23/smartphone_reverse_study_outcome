package com.bytedance.timonbase.report;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.timon.foundation.interfaces.IEventMonitor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import vg7.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "extraParams", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TMDataCollector$reportMonitorDuration$3 extends Lambda implements Function1<Map<String, ? extends String>, Unit> {
    final /* synthetic */ JSONObject $duration;
    final /* synthetic */ JSONObject $logExtra;
    final /* synthetic */ String $serviceName;
    final /* synthetic */ int $status;

    public TMDataCollector$reportMonitorDuration$3(JSONObject r100, String r101, int r102, JSONObject r103) {
        this.$logExtra = r100;
        this.$serviceName = r101;
        this.$status = r102;
        this.$duration = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, String> r100) {
        JSONObject r101 = this.$logExtra;
        if (r101 != null) goto L6;
        r101 = new JSONObject();
    L6:
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, String> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        goto L8
    L10:
        IEventMonitor r104 = a.f554737d;
        if (r104 != null) goto L14;
        r104 = (IEventMonitor) ServiceManager.get().getService(IEventMonitor.class);
        a.f554737d = r104;
    L14:
        r104.monitorStatusAndDuration(this.$serviceName, this.$status, this.$duration, r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
