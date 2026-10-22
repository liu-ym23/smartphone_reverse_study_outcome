package com.ss.android.download.api.runtime;

import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.download.api.config.IDownloadFileCallback;
import com.ss.android.download.api.config.IHttpCallback;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&JH\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\fH&J6\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\fH&¨\u0006\u0010"}, d2 = {"Lcom/ss/android/download/api/runtime/IAdNetworkProvider;", "Lcom/ss/android/download/api/config/DownloadNetworkFactory;", "downloadFile", "", "url", "", "queryMap", "", "httpCallback", "Lcom/ss/android/download/api/config/IDownloadFileCallback;", "postForm", "fieldMap", "Lcom/ss/android/download/api/config/IHttpCallback;", "postJson", "extraJson", "Lorg/json/JSONObject;", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface IAdNetworkProvider extends DownloadNetworkFactory {
    void downloadFile(String r100, Map<String, String> r101, IDownloadFileCallback r102);

    void postForm(String r100, Map<String, String> r101, Map<String, String> r102, IHttpCallback r103);

    void postJson(String r100, Map<String, String> r101, JSONObject r102, IHttpCallback r103);
}
