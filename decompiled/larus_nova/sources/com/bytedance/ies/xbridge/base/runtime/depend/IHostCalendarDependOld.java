package com.bytedance.ies.xbridge.base.runtime.depend;

import android.content.Context;
import com.heytap.mcssdk.constant.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostCalendarDependOld;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lr56/b;", "event", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostCalendarEventCallback;", "callback", "", "insertOrUpdate", "", b.f276361k, "deleteEvent", "readEvent", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostCalendarDependOld {
    void deleteEvent(Context r100, String r101, IHostCalendarEventCallback r102);

    void insertOrUpdate(Context r100, r56.b r101, IHostCalendarEventCallback r102);

    r56.b readEvent(Context r100, String r101);
}
