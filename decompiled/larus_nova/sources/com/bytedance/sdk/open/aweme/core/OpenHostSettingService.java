package com.bytedance.sdk.open.aweme.core;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public interface OpenHostSettingService extends IOpenService {
    List<String> getExposeVids();

    JSONObject getSettingJson(String r100);

    boolean setExposeVids(List<String> r100);
}
