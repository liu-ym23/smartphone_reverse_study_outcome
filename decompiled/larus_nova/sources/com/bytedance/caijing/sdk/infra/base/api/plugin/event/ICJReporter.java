package com.bytedance.caijing.sdk.infra.base.api.plugin.event;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH&J&\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H&J8\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/event/ICJReporter;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "reportBizEvent", "", "eventName", "", "evtParams", "", "", "occurrenceTime", "", "ignoreActionHash", "", "reportCJBizModuleStart", "bizModule", "eventParams", "", "reportMonitorEvent", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJReporter extends ICJService {

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ void a(ICJReporter r100, String r101, Map r102) {
            r100.reportBizEvent(r101, r102, -1, false);
        }
    }

    void reportBizEvent(String r100, Map<String, ? extends Object> r101, long r102, boolean r103);

    void reportCJBizModuleStart(String r100, Map<String, Object> r101);

    void reportMonitorEvent(String r100, Map<String, ? extends Object> r101, long r102, boolean r103);
}
