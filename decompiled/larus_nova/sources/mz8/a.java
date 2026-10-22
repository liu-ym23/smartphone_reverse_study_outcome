package mz8;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.collection.impl.bean.CollectionListRequest;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    public static JSONObject a(CollectionListRequest r100) {
        Gson r101 = new Gson();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "gson");
        return new JSONObject(GsonProtectorUtils.toJson(r101, r100));
    }
}
