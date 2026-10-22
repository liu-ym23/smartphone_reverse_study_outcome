package com.ss.android.ugc.effectmanager.knadapt;

import com.ss.android.ugc.effectmanager.common.listener.IMonitorService;
import java.util.Iterator;
import java.util.Map;
import klc.a;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNMonitorService;", "Lklc/a;", "", "serviceName", "", "status", "", "", "logExtraMap", "", "monitorStatusRate", "Lcom/ss/android/ugc/effectmanager/common/listener/IMonitorService;", "iMonitorService", "Lcom/ss/android/ugc/effectmanager/common/listener/IMonitorService;", "<init>", "(Lcom/ss/android/ugc/effectmanager/common/listener/IMonitorService;)V", "effectmanager_release"}, k = 1, mv = {1, 4, 0})
public final class KNMonitorService implements a {
    private final IMonitorService iMonitorService;

    public KNMonitorService(IMonitorService r100) {
        this.iMonitorService = r100;
    }

    @Override // klc.a
    public void monitorStatusRate(String r100, int r101, Map<String, ? extends Object> r102) {
        JSONObject r103 = new JSONObject();
        Iterator<Map.Entry<String, ? extends Object>> r104 = r102.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r105 = r104.next();
        r103.put(r105.getKey(), r105.getValue());
        goto L4
    L6:
        this.iMonitorService.monitorStatusRate(r100, r101, r103);
    }
}
