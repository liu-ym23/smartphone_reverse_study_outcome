package x60;

import com.bytedance.android.live.core.setting.v2.helper.MapDeserializerDoubleAsIntFix;
import com.bytedance.android.live.core.setting.v2.helper.SettingBooleanTypeAdapter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f562576a = null;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"x60/b$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<HashMap<String, Object>> {
        public a() {
        }
    }

    static {
        f562576a = new GsonBuilder().registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix()).registerTypeAdapter(Boolean.TYPE, new SettingBooleanTypeAdapter()).create();
    }

    public static Object a(Object r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(r101, String.class) == false) goto L5;
    L8:
        Gson r102 = f562576a;
        return GsonProtectorUtils.fromJson(r102, GsonProtectorUtils.toJson(r102, r100.toString()), r101);
    L5:
        if (Intrinsics.areEqual(r101, null) == true) goto L8;
        return GsonProtectorUtils.fromJson(f562576a, r100.toString(), r101);
    }
}
