package com.ss.android.download.api.runtime;

import com.ss.android.download.api.model.DownloadEventModel;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/ss/android/download/api/runtime/IAdEventProvider;", "", "onAdEvent", "", "eventModel", "Lcom/ss/android/download/api/model/DownloadEventModel;", "onAdV3Event", "sendUserEvent", "label", "", "extJson", "Lorg/json/JSONObject;", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface IAdEventProvider {
    void onAdEvent(DownloadEventModel r100);

    void onAdV3Event(DownloadEventModel r100);

    void sendUserEvent(String r100, JSONObject r101);
}
