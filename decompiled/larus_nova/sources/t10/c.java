package t10;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.ies.web.jsbridge2.q;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements q {
    public c() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.q
    public final <T> String a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Class<?> r101 = r100.getClass();
        if (Intrinsics.areEqual(r101, JsonObject.class) == true) goto L12;
        if (Intrinsics.areEqual(r101, JsonArray.class) == true) goto L12;
        if (Intrinsics.areEqual(r101, String.class) == false) goto L14;
        return r100.toString();
    L14:
        return GsonProtectorUtils.toJson(GsonHelper.get(), r100);
    L12:
        return r100.toString();
    }

    @Override // com.bytedance.ies.web.jsbridge2.q
    public final <T> T b(String r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "type");
        return (T) GsonProtectorUtils.fromJson(GsonHelper.get(), r100, r101);
    }
}
