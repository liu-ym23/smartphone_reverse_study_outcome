package com.obric.assistant.wakeup.statistics.api;

import android.os.Bundle;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.obric.assistant.session.lifecycle.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/api/IWakeupStatisticsAPI;", "", "init", "", "uploader", "Lkotlin/Function2;", "", "Lorg/json/JSONObject;", MapMonitorConst.EVENT_DESTROY, "setBundle", "bundle", "Landroid/os/Bundle;", "onEvent", "event", "end", "", "time", "", "clear", "setStartTime", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWakeupStatisticsAPI {
    void a(f r100);

    void b(String r100, boolean r101, long r102);

    void clear();

    void destroy();

    void setBundle(Bundle r100);

    void setStartTime(long r100);
}
