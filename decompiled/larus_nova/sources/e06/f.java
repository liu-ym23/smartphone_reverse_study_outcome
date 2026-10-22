package e06;

import com.bytedance.helios.sdk.detector.o;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Integer> f470645a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<Integer, qz5.a> f470646b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Integer> f470647c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<qz5.a> f470648d = null;

    static {
        f470645a = new HashMap(ApiHookConfig.f245611b.size());
        f470646b = new HashMap(ApiHookConfig.f245611b.size());
        f470647c = SetsKt.setOf(new Integer[]{100106, 100205, 100404, 100405, 200000, 200001, 200002, 200004, 100496, 100497, 100498, 100499});
        f470648d = CollectionsKt.listOf(new qz5.a[]{new qz5.a(200000, null, "Location", "loc", null, 0, CollectionsKt.listOf("location"), null, 370), new qz5.a(200001, null, "Location", "loc", null, 0, CollectionsKt.listOf("location"), null, 370), new qz5.a(200002, null, "Location", "loc", null, 0, CollectionsKt.listOf("location"), null, 370), new qz5.a(200004, null, "Location", "loc", null, 0, CollectionsKt.listOf("location"), null, 370), new qz5.a(100496, null, "NativeAudioRecord", "nar", null, 0, CollectionsKt.listOf("audio"), null, 370), new qz5.a(100497, null, "NativeAudioRecord", "nar", null, 0, CollectionsKt.listOf("audio"), null, 370), new qz5.a(100498, null, "NativeAudioRecord", "nar", null, 0, CollectionsKt.listOf("audio"), null, 370), new qz5.a(100499, null, "NativeAudioRecord", "nar", null, 0, CollectionsKt.listOf("audio"), null, 370)});
        Iterator<g06.a> r100 = ApiHookConfig.f245611b.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        g06.a r101 = r100.next();
        int r110 = r101.f479465a;
        if (f470647c.contains(Integer.valueOf(r110)) == true) goto L9;
        f470646b.put(Integer.valueOf(r110), new qz5.a(r110, r101.f479466b, r101.f479468d, r101.f479467c, r101.f479469e, r101.f479470f, ArraysKt.toList(r101.f479471g), r101.f479474j, 64));
        f470645a.put(r101.f479466b, Integer.valueOf(r110));
        goto L4
    L9:
        throw new IllegalArgumentException("Sensitive API Monitor Business use " + r110 + " as a virtual API ID. Please reconfigure a new ID.");
    L10:
        Iterator<T> r102 = f470648d.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        qz5.a r103 = (qz5.a) r102.next();
        f470646b.put(Integer.valueOf(r103.f535345a), r103);
        goto L12
    L14:
        Iterator<Map.Entry<String, o.a>> r104 = o.f245540b.entrySet().iterator();
    L16:
        if (r104.hasNext() == false) goto L34;
        Map.Entry<String, o.a> r105 = r104.next();
        String r106 = r105.getKey();
        int r107 = r105.getValue().f245543b;
        String r108 = r105.getValue().f245542a;
        if (r108 == null) goto L33;
        List r111 = CollectionsKt.listOf(r108.toLowerCase());
        String r109 = r105.getValue().f245542a;
        String r112 = r105.getValue().f245542a;
        if (r112 == null) goto L31;
        qz5.a r113 = new qz5.a(r107, null, r109, r112.toLowerCase(), null, 0, r111, null, 370);
        HashMap<Integer, qz5.a> r114 = f470646b;
        r114.put(Integer.valueOf(r105.getValue().f245543b), r113);
        int r115 = r105.getValue().f245544c;
        String r116 = r105.getValue().f245542a;
        if (r116 == null) goto L29;
        List r210 = CollectionsKt.listOf(r116.toLowerCase());
        String r117 = r105.getValue().f245542a;
        String r118 = r105.getValue().f245542a;
        if (r118 == null) goto L27;
        r114.put(Integer.valueOf(r105.getValue().f245544c), new qz5.a(r115, null, r117, r118.toLowerCase(), null, 0, r210, null, 370));
        goto L16
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static qz5.a a(int r100) {
        HashMap<Integer, qz5.a> r101 = f470646b;
        switch(r100) {
            case 100106: goto L8;
            case 100205: goto L7;
            case 100404: goto L6;
            case 100405: goto L5;
            default: goto L10;
        };
    L5:
        r100 = 100403;
        goto L10
    L6:
        r100 = 100401;
        goto L10
    L7:
        r100 = 100201;
        goto L10
    L8:
        r100 = 100101;
    L10:
        return r101.get(Integer.valueOf(r100));
    }

    public static Integer b(Integer r100) {
        if (r100 != null) goto L5;
    L8:
        if (r100 != null) goto L11;
    L14:
        if (r100 != null) goto L17;
    L20:
        if (r100 != null) goto L23;
        return r100;
    L23:
        if (r100.intValue() == 200004) goto L25;
        return r100;
    L25:
        return 100004;
    L17:
        if (r100.intValue() != 200002) goto L20;
        return 100002;
    L11:
        if (r100.intValue() != 200001) goto L14;
        return 100001;
    L5:
        if (r100.intValue() != 200000) goto L8;
        return 100000;
    }
}
