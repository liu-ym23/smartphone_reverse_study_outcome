package yy6;

import android.text.TextUtils;
import com.bytedance.locallife.poi.settings.IPoiSetting;
import com.ss.android.ugc.aweme.poi.mob.PoiDynamicParamsConfig;
import com.ss.android.ugc.aweme.poi.mob.SingleParamsConfig;
import com.ss.android.ugc.aweme.poi.settings.PoiSetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, a> f569482e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f569483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, SingleParamsConfig> f569484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, SingleParamsConfig> f569485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PoiDynamicParamsConfig f569486d;

    /* JADX INFO: renamed from: yy6.a$a, reason: collision with other inner class name */
    public static final class C8403a {
        public static a a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            return a.f569482e.get(r100);
        }
    }

    static {
        f569482e = new HashMap();
    }

    public a() {
        this.f569483a = new ConcurrentHashMap();
        this.f569484b = new ConcurrentHashMap();
        this.f569485c = new ConcurrentHashMap();
        PoiSetting r100 = IPoiSetting.a();
        if (r100 == null) goto L5;
        PoiDynamicParamsConfig r101 = r100.e();
    L6:
        this.f569486d = r101;
        if (r101 != null) goto L9;
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_fata_error", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene_type", "poi_dynamic_params_error"), TuplesKt.to("error_description", "poi_dynamic_settings_error")}));
    L9:
        if (r101 == null) goto L20;
        List<SingleParamsConfig> r103 = r101.c();
        if (r103 == null) goto L28;
        Iterator<T> r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L29;
        SingleParamsConfig r105 = (SingleParamsConfig) r104.next();
        String r106 = r105.c();
        if (r106 == null) goto L14;
        if (TextUtils.isEmpty(r105.c()) == true) goto L14;
        this.f569485c.put(r106, r105);
        goto L14
    L29:
        return;
    L28:
        return;
    L20:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void d(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        PoiDynamicParamsConfig r101 = this.f569486d;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.a() != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, String> r104 = r103.next();
        c(r104.getKey(), r104.getValue());
        goto L12
    L14:
        return;
    L7:
        r102 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(HashMap<String, String> r100, HashMap<String, String> r101) {
        if (r100 != null) goto L4;
        Map r102 = this.f569483a;
    L4:
        Iterator r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L25;
        Map.Entry r104 = (Map.Entry) r103.next();
        SingleParamsConfig r105 = this.f569484b.get(r104.getKey());
        if (r105 == null) goto L6;
        if (r105.a() == true) goto L6;
        if (r105.b() == 0) goto L14;
        r101.put(r104.getKey(), r104.getValue());
        goto L6
    L14:
        if (r101.containsKey(r104.getKey()) == false) goto L23;
        CharSequence r106 = (CharSequence) r101.get(r104.getKey());
        if (r106 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L6;
    L18:
        if (r106.length() == 0) goto L21;
        r107 = false;
    L23:
        r101.put(r104.getKey(), r104.getValue());
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(HashMap<String, String> r100, ConcurrentHashMap<String, String> r101) {
        if (r101 != 0) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
        Map r102 = this.f569483a;
    L6:
        Iterator r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L31;
        Map.Entry r104 = (Map.Entry) r103.next();
        SingleParamsConfig r105 = this.f569484b.get(r104.getKey());
        if (r105 == null) goto L8;
        if (r105.a() == true) goto L8;
        String r106 = "";
        if (r105.d() == 0) goto L16;
        Object r107 = r104.getKey();
        String r108 = (String) r104.getValue();
        if (r108 == null) goto L30;
        r106 = r108;
    L30:
        r101.put(r107, r106);
        goto L8
    L16:
        if (r101.containsKey(r104.getKey()) == false) goto L21;
        if (Intrinsics.areEqual(r101.get(r104.getKey()), "") == true) goto L21;
        int r109 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_fata_error", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene_type", "poi_dynamic_params_error"), TuplesKt.to("error_description", r104.getKey())}));
    L21:
        Object r110 = r104.getKey();
        String r111 = (String) r104.getValue();
        if (r111 == null) goto L25;
        r106 = r111;
    L25:
        r101.put(r110, r106);
        goto L8
    }

    public final void c(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.f569483a.put(r100, r101);
        if (this.f569484b.containsKey(r100) == false) goto L7;
        return;
    L7:
        if (this.f569485c.containsKey(r100) == false) goto L11;
        SingleParamsConfig r102 = this.f569485c.get(r100);
        if (r102 == null) goto L14;
        this.f569484b.put(r100, r102);
        return;
    L14:
        return;
    L11:
        this.f569484b.put(r100, new SingleParamsConfig(r100, false, 0, 0));
    }
}
