package com.bytedance.awemeopen.export.api.host;

import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH&¨\u0006\r"}, d2 = {"Lcom/bytedance/awemeopen/export/api/host/IHandleBySdkCallback;", "", "handleBySdk", "", "buttonType", "", "extraInfo", "Lorg/json/JSONObject;", "handleByHostCallback", "Lcom/bytedance/awemeopen/export/api/host/IHandleByHostCallback;", "notifyShowButtonNames", "buttonList", "", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IHandleBySdkCallback {
    void handleBySdk(String r100, JSONObject r101, IHandleByHostCallback r102);

    void notifyShowButtonNames(List<String> r100);
}
