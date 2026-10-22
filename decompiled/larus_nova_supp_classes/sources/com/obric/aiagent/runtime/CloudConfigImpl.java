package com.obric.aiagent.runtime;

import android.util.EventsUtils;
import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.assistant.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/runtime/CloudConfigImpl;", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "<init>", "()V", "getSettingsConfig", "Lorg/json/JSONObject;", "key", XmlPullParser.NO_NAMESPACE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class CloudConfigImpl implements ICloudConfig {
    public CloudConfigImpl() {
    }

    @Override // com.obric.aiagent.platform.depend.ICloudConfig
    public final JSONObject a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        JsonObject r3 = t1.a.getObricCloudConfig(r2);
        if (r3 == null) goto L7;
        String r4 = r3.toString();
        if (r4 == null) goto L7;
        return new JSONObject(r4);
    L7:
        return null;
    }
}
