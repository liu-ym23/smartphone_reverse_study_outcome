package com.larus.uaigc.api;

import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.model.upload.UploadDataType;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class o {
    public static final Object a(List<String> r110, boolean r111, Continuation<? super com.larus.network.http.a<s>> r112) {
        JSONObject r100 = new JSONObject();
        r100.put("urls", new JSONArray(r110));
        r100.put("need_resource_meta", r111);
        Unit r113 = Unit.INSTANCE;
        return HttpExtKt.k(ServiceType.UGC, s.class, "/alice/resource/explain_resource_urls", r100, null, null, false, null, null, null, r112, 1008);
    }

    public static final Object b(List<String> r110, UploadDataType r111, Continuation<? super com.larus.network.http.a<FileUrlRespData>> r112) {
        JSONObject r100 = new JSONObject();
        r100.put("uris", new JSONArray(r110));
        r100.put("type", r111.getType());
        Unit r113 = Unit.INSTANCE;
        return HttpExtKt.k(ServiceType.UGC, FileUrlRespData.class, "/alice/message/get_file_url", r100, null, null, false, null, null, null, r112, 1008);
    }
}
