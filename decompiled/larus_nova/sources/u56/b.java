package u56;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f548842a = null;

    static {
        f548842a = new Gson();
    }

    public static String b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return GsonProtectorUtils.toJson(f548842a, r100);
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeClass");
        return GsonProtectorUtils.fromJson(f548842a, r100, r101);
    }
}
