package com.obric.aiagent.runtime;

import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.assistant.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/runtime/CloudConfigImpl;", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "<init>", "()V", "getSettingsConfig", "Lorg/json/JSONObject;", "key", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloudConfigImpl implements ICloudConfig {
    public CloudConfigImpl() {
    }

    @Override // com.obric.aiagent.platform.depend.ICloudConfig
    public final JSONObject a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        JsonObject r101 = t1.f393353a.getObricCloudConfig(r100);
        if (r101 == null) goto L7;
        String r102 = r101.toString();
        if (r102 == null) goto L7;
        return new JSONObject(r102);
    L7:
        return null;
    }
}
