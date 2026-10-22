package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class j0 {
    public static final Object a(List<String> r110, Continuation<? super com.larus.network.http.a<SignImgWmData>> r111) {
        JSONObject r100 = new JSONObject();
        r100.put("uris", new JSONArray(r110));
        Unit r112 = Unit.INSTANCE;
        return HttpExtKt.k(ServiceType.UGC, SignImgWmData.class, "/creativity/tool/sign_img_wm", r100, null, null, false, null, null, null, r111, 1008);
    }
}
