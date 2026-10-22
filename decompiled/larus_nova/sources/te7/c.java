package te7;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f545587a = null;

    static {
        f545587a = new Gson();
    }

    public static String b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return GsonProtectorUtils.toJson(f545587a, r100);
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeClass");
        return GsonProtectorUtils.fromJson(f545587a, r100, r101);
    }
}
