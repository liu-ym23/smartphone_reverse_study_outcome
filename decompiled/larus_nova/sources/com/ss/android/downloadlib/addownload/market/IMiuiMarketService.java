package com.ss.android.downloadlib.addownload.market;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/ss/android/downloadlib/addownload/market/IMiuiMarketService;", "", "queryMiuiContentResolver", "Lorg/json/JSONObject;", "nativeDownloadModel", "Lcom/ss/android/downloadad/api/model/NativeDownloadModel;", "registerMiuiBroadcast", "", "unRegisterMiuiBroadcast", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public interface IMiuiMarketService {
    JSONObject queryMiuiContentResolver(NativeDownloadModel r100);

    void registerMiuiBroadcast();

    void unRegisterMiuiBroadcast();
}
