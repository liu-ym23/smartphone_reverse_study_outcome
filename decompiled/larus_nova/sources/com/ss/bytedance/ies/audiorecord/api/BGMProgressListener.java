package com.ss.bytedance.ies.audiorecord.api;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\u0003H'¨\u0006\b"}, d2 = {"Lcom/ss/bytedance/ies/audiorecord/api/BGMProgressListener;", "", "onProgress", "", "progress", "", WidgetCostModule.TYPE_ON_START, "onStop", "audiorecord-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 1, 16})
public interface BGMProgressListener {
    void onProgress(long r100);

    void onStart();

    void onStop();
}
