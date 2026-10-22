package z60;

import android.content.SharedPreferences;
import android.os.Handler;
import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class a implements c {

    /* JADX INFO: renamed from: z60.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"z60/a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final class C8424a extends TypeToken<HashMap<String, Object>> {
        public C8424a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"z60/a$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<HashMap<String, Object>> {
        public b() {
        }
    }

    public a() {
    }

    public void a(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101) {
    }

    public final boolean update(Map<String, ? extends Object> r100, Map<String, ? extends Object> r110) {
        a70.b.f("ColdStrategy_update_sp");
        a(r100, r110);
        LinkedHashMap r101 = null;
        if (r100 == null) goto L15;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        if (r104.getKey() != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L6;
        r102.put(r104.getKey(), r104.getValue());
        goto L6
    L10:
        if (r104.getValue() == null) goto L12;
        r105 = true;
    L16:
        if (r110 == null) goto L28;
        r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r106 = r110.entrySet().iterator();
    L19:
        if (r106.hasNext() == false) goto L28;
        Map.Entry<String, ? extends Object> r111 = r106.next();
        if (r111.getKey() != null) goto L23;
    L25:
        boolean r107 = false;
    L26:
        if (r107 == false) goto L19;
        r101.put(r111.getKey(), r111.getValue());
        goto L19
    L23:
        if (r111.getValue() == null) goto L25;
        r107 = true;
    L28:
        if (r102 == null) goto L30;
        boolean r108 = SettingIncStrategy.f65434a.update(ICacheManger.CacheType.LOCAL_CACHE, ICacheManger.Operation.MINUS, r102);
    L31:
        if (r101 == null) goto L33;
        boolean r112 = SettingIncStrategy.f65434a.update(ICacheManger.CacheType.LOCAL_CACHE, ICacheManger.Operation.PLUS, r101);
    L34:
        a70.b.a("ColdStrategy_update_sp");
        a70.b.f("ColdStrategy_clear_not_sp_cache");
        if (r101 == null) goto L37;
        w60.b r109 = SettingIncStrategy.f65434a;
        ICacheManger.CacheType r113 = ICacheManger.CacheType.OBJECT;
        ICacheManger.Operation r114 = ICacheManger.Operation.MINUS;
        r109.update(r113, r114, r101);
        r109.update(ICacheManger.CacheType.TRANSIENT, r114, r101);
        r109.update(ICacheManger.CacheType.PRELOAD_CACHE, r114, r101);
    L37:
        if (r102 == null) goto L39;
        w60.b r115 = SettingIncStrategy.f65434a;
        ICacheManger.CacheType r116 = ICacheManger.CacheType.OBJECT;
        ICacheManger.Operation r117 = ICacheManger.Operation.MINUS;
        r115.update(r116, r117, r102);
        r115.update(ICacheManger.CacheType.TRANSIENT, r117, r102);
        r115.update(ICacheManger.CacheType.PRELOAD_CACHE, r117, r102);
    L39:
        a70.b.a("ColdStrategy_clear_not_sp_cache");
        if (r112 == false) goto L43;
        if (r108 == false) goto L43;
        return true;
    L43:
        return false;
    L33:
        r112 = true;
        goto L34
    L30:
        r108 = true;
        goto L31
    L15:
        r102 = null;
        goto L16
    }

    @Override // z60.c
    public boolean update(JsonObject r100, JsonObject r101, c70.a r102) {
        a70.b.f("ColdStrategy_gson");
        String r103 = null;
        if (r101 == null) goto L7;
        JsonElement r104 = r101.get("setting_update_mode");
        if (r104 == null) goto L7;
        String r105 = r104.getAsString();
    L8:
        boolean r106 = Intrinsics.areEqual(r105, "full");
        if (r106 == false) goto L27;
        w60.b r107 = SettingIncStrategy.f65434a;
        r107.f558394b.clear();
        r107.f558396d.clear();
        r107.f558397e.clear();
        y60.d r108 = r107.f558393a;
        r108.f566312c = false;
        r108.f566316g = false;
        Handler r109 = r108.f566314e;
        if (r109 == null) goto L13;
        r109.removeCallbacks(r108.f566317h);
    L13:
        r108.f566313d = null;
        y60.b r110 = r108.f566310a;
        r110.f();
        int r111 = x60.c.f562577a;
        if (wa1.d.f558805c.f562579b == false) goto L22;
        SharedPreferences r112 = r110.f566299c;
        if (r112 == null) goto L22;
        SharedPreferences.Editor r113 = r112.edit();
        if (r113 == null) goto L22;
        SharedPreferences.Editor r114 = r113.clear();
        if (r114 == null) goto L22;
        r114.commit();
    L22:
        SharedPreferences.Editor r115 = r110.c();
        if (r115 == null) goto L27;
        SharedPreferences.Editor r116 = r115.clear();
        if (r116 == null) goto L27;
        r116.commit();
    L27:
        Map<String, ? extends Object> r117 = new LinkedHashMap();
        Map<String, ? extends Object> r118 = new LinkedHashMap();
        if (r100 == null) goto L30;
        r117 = (Map) GsonProtectorUtils.fromJson(x60.b.f562576a, r100.toString(), new C8424a().getType());
        r117.remove("_setting_extra");
    L30:
        if (r101 == null) goto L36;
        JsonObject r119 = r101.getAsJsonObject("to_delete_keys");
        if (r119 == null) goto L34;
        r103 = r119.toString();
    L34:
        if (r103 == null) goto L36;
        r118 = (Map) GsonProtectorUtils.fromJson(x60.b.f562576a, r103, new b().getType());
    L36:
        a70.b.a("ColdStrategy_gson");
        boolean r120 = update(r118, r117);
        b(r120, r106, r118, r117);
        return r120;
    L7:
        r105 = null;
        goto L8
    }

    public void b(boolean r100, boolean r110, Map<String, ? extends Object> r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r111, "deleteMap");
        Intrinsics.checkNotNullParameter(r112, "updateOrAdd");
        int r101 = !r100 ? 1 : 0;
        if (r110 == false) goto L5;
        String r102 = "full";
    L6:
        a70.c.a(r101, r102, "clod", a70.b.b(), r112.size(), r111.size(), "update数据");
        return;
    L5:
        r102 = "incr";
        goto L6
    }
}
