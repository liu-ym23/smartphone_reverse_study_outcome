package com.bytedance.sdk.open.aweme.commonbase.net.mime;

import com.bytedance.sdk.open.aweme.commonbase.net.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class JsonRequestBody extends ByteArrayRequestBody {
    public JsonRequestBody(JSONObject r100) {
        super("application/json; charset=UTF-8", b.a(r100.toString()), null);
    }
}
