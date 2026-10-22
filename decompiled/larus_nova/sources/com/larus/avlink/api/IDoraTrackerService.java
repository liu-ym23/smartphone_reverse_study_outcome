package com.larus.avlink.api;

import com.larus.avlink.api.model.DoraEvent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\bH&¨\u0006\f"}, d2 = {"Lcom/larus/avlink/api/IDoraTrackerService;", "", "getTraceInfo", "", DBDefinition.TASK_ID, "getCurTaskId", "getCurCallId", "info", "", "doraEvent", "Lcom/larus/avlink/api/model/DoraEvent;", "logForAutoTest", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraTrackerService {
    String a();

    void b(DoraEvent r100);

    String c();
}
