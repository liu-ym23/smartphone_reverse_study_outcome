package zv8;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f573760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f573761b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<m> f573762c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<EntrancePage> f573763d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<EntranceGroup, LinkedList<e>> f573764e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<Map<EntranceGroup, LinkedList<e>>> f573765f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f573766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f573767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<EntranceGroup, LinkedList<e>> f573768i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<Map<EntranceGroup, LinkedList<e>>> f573769j = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f573770a = null;

        static {
            int[] r100 = new int[EntrancePage.values().length];
            r100[EntrancePage.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[EntrancePage.RECENTLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f573770a = r100;
        }
    }

    public k() {
    }

    static {
        f573760a = new k();
        f573761b = Keva.getRepo("debug_entrance_data");
        f573762c = new ArrayList();
        f573763d = CollectionsKt.listOf(new EntrancePage[]{EntrancePage.ALL, EntrancePage.RECENTLY, EntrancePage.FAVORITE});
        f573764e = new EnumMap(EntranceGroup.class);
        f573765f = new ArrayList();
        f573766g = "";
        f573767h = "";
        f573768i = new EnumMap(EntranceGroup.class);
        f573769j = new ArrayList();
    }

    public static List c(EntrancePage r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        int r101 = a.f573770a[r100.ordinal()];
        boolean r102 = false;
        if (r101 == 1) goto L29;
        if (r101 == 2) goto L18;
        if (aw8.c.f16596d.length() != 0) goto L9;
        r102 = true;
    L9:
        if (r102 == false) goto L11;
        List<Map<EntranceGroup, LinkedList<e>>> r103 = aw8.c.f16593a;
    L12:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L38;
        r104.add((EntranceGroup) CollectionsKt.first(((Map) r105.next()).keySet()));
        goto L14
    L38:
        return CollectionsKt.toMutableList(r104);
    L11:
        r103 = aw8.c.f16597e;
        goto L12
    L18:
        if (f573767h.length() != 0) goto L20;
        r102 = true;
    L20:
        if (r102 == false) goto L22;
        List<Map<EntranceGroup, LinkedList<e>>> r106 = f573765f;
    L23:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L25:
        if (r108.hasNext() == false) goto L39;
        r107.add((EntranceGroup) CollectionsKt.first(((Map) r108.next()).keySet()));
        goto L25
    L39:
        return CollectionsKt.toMutableList(r107);
    L22:
        r106 = f573769j;
        goto L23
    L29:
        if (f573766g.length() != 0) goto L31;
        r102 = true;
    L31:
        if (r102 == false) goto L33;
        Map<EntranceGroup, LinkedList<e>> r109 = f573764e;
    L35:
        return CollectionsKt.toMutableList(r109.keySet());
    L33:
        r109 = f573768i;
        goto L35
    }

    @JvmStatic
    public static final void e(e r110) {
        Intrinsics.checkNotNullParameter(r110, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        EntranceGroup r100 = r110.b();
        Intrinsics.checkNotNullParameter(r110, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        List<Map<EntranceGroup, LinkedList<e>>> r101 = f573765f;
        Object r102 = null;
        if (((ArrayList) r101).size() != 0) goto L5;
    L4:
        boolean r103 = false;
    L16:
        if (r103 == false) goto L18;
        return;
    L18:
        Iterator<T> r104 = r101.iterator();
    L20:
        if (r104.hasNext() == false) goto L33;
        Object r105 = r104.next();
        Iterator r106 = ((Map) r105).keySet().iterator();
    L23:
        if (r106.hasNext() == false) goto L27;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((EntranceGroup) r107).getDes(), r100.getDes()) == false) goto L23;
    L28:
        if (r107 == null) goto L30;
        boolean r108 = true;
    L31:
        if (r108 == false) goto L20;
        r102 = r105;
        goto L33
    L30:
        r108 = false;
        goto L31
    L27:
        r107 = null;
    L33:
        Map r109 = (Map) r102;
        if (r109 == null) goto L47;
        List r111 = (LinkedList) r109.get(r100);
        if (r111 != null) goto L39;
        r111 = CollectionsKt.emptyList();
    L39:
        LinkedList r112 = new LinkedList();
        r112.add(r110);
        Iterator r113 = r111.iterator();
    L41:
        if (r113.hasNext() == false) goto L46;
        e r114 = (e) r113.next();
        if (Intrinsics.areEqual(r114.c(), r110.c()) == true) goto L41;
        r112.add(r114);
        goto L41
    L46:
        List<Map<EntranceGroup, LinkedList<e>>> r115 = f573765f;
        ((ArrayList) r115).remove(r109);
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put(r100, r112);
        Unit r117 = Unit.INSTANCE;
        ListProtector.add(r115, 0, r116);
    L48:
        JSONArray r118 = new JSONArray();
        Iterator<T> r119 = f573765f.iterator();
    L50:
        if (r119.hasNext() == false) goto L66;
        Map r120 = (Map) r119.next();
        Iterator r121 = r120.keySet().iterator();
    L53:
        if (r121.hasNext() == false) goto L50;
        EntranceGroup r122 = (EntranceGroup) r121.next();
        JSONArray r123 = new JSONArray();
        LinkedList r124 = (LinkedList) r120.get(r122);
        if (r124 == null) goto L60;
        Collection r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10));
        Iterator r126 = r124.iterator();
    L58:
        if (r126.hasNext() == false) goto L61;
        r125.add(((e) r126.next()).c());
    L61:
        Iterator r127 = r125.iterator();
    L63:
        if (r127.hasNext() == false) goto L65;
        r123.put((String) r127.next());
        goto L63
    L65:
        JSONObject r128 = new JSONObject();
        r128.put(r122.getDes(), r123);
        r118.put(r128);
        goto L53
    L60:
        r125 = CollectionsKt.emptyList();
        goto L61
    L66:
        f573761b.storeString("KEVA_KEY_RECENTLY_USED_ENTRANCE", r118.toString());
        Iterator<T> r129 = f573762c.iterator();
    L68:
        if (r129.hasNext() == false) goto L70;
        ((m) r129.next()).b();
        goto L68
    L70:
        return;
    L47:
        List<Map<EntranceGroup, LinkedList<e>>> r130 = f573765f;
        LinkedHashMap r131 = new LinkedHashMap();
        LinkedList r132 = new LinkedList();
        r132.add(r110);
        Unit r133 = Unit.INSTANCE;
        r131.put(r100, r132);
        ListProtector.add(r130, 0, r131);
        goto L48
    L5:
        Map r134 = (Map) ListProtector.get(r101, 0);
        if (r134.isEmpty() == true) goto L4;
        LinkedList r135 = (LinkedList) r134.get((EntranceGroup) ListProtector.get(CollectionsKt.toList(r134.keySet()), 0));
        if (r135 == null) goto L4;
        if ((!r135.isEmpty()) == true) goto L14;
        r135 = null;
    L14:
        if (r135 == null) goto L4;
        r103 = Intrinsics.areEqual(((e) r135.get(0)).toString(), r110.toString());
        goto L16
    }

    public static Map b(String r210, Map r211) {
        LinkedHashMap r100 = new LinkedHashMap();
        if (r210.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r100;
    L8:
        Iterator r102 = r211.keySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L22;
        EntranceGroup r103 = (EntranceGroup) r102.next();
        LinkedList r104 = new LinkedList();
        LinkedList r105 = (LinkedList) r211.get(r103);
        if (r105 == null) goto L20;
        Iterator r106 = r105.iterator();
    L15:
        if (r106.hasNext() == false) goto L20;
        e r107 = (e) r106.next();
        r107.getClass();
        if (StringsKt.contains$default((r107.b().getDes() + r107.c() + CollectionsKt.joinToString$default(r107.e(), null, null, null, 0, null, null, 63, null)).toLowerCase(Locale.getDefault()), r210.toLowerCase(Locale.getDefault()), false, 2, null) == false) goto L15;
        r104.add(r107);
    L20:
        if ((!r104.isEmpty()) == false) goto L10;
        r100.put(r103, r104);
        goto L10
    L22:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public static Pair a(String r110, List r111, List r112) {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r111.iterator();
    L3:
        Map r103 = null;
        if (r102.hasNext() == false) goto L11;
        Map r104 = (Map) r102.next();
        f573760a.getClass();
        Map r105 = b(r110, r104);
        if ((true ^ r105.isEmpty()) == false) goto L8;
        r103 = r105;
    L8:
        if (r103 == null) goto L3;
        r101.add(r103);
        goto L3
    L11:
        if (r101.isEmpty() == true) goto L13;
        ArrayList r106 = (ArrayList) r112;
        if (r101.size() == r106.size()) goto L17;
        boolean r107 = true;
    L18:
        Iterator r108 = r101.iterator();
    L20:
        if (r108.hasNext() == false) goto L63;
        Map r109 = (Map) r108.next();
        Iterator r113 = r109.keySet().iterator();
    L23:
        if (r113.hasNext() == false) goto L20;
        EntranceGroup r114 = (EntranceGroup) r113.next();
        Iterator r115 = r106.iterator();
    L26:
        if (r115.hasNext() == false) goto L41;
        Object r116 = r115.next();
        Iterator r117 = ((Map) r116).keySet().iterator();
    L29:
        if (r117.hasNext() == false) goto L34;
        Object r118 = r117.next();
        if (Intrinsics.areEqual(((EntranceGroup) r118).getDes(), r114.getDes()) == false) goto L29;
    L35:
        if (r118 == null) goto L37;
        boolean r119 = true;
    L38:
        if (r119 == false) goto L26;
    L42:
        Map r120 = (Map) r116;
        if (r120 == null) goto L61;
        List r121 = (LinkedList) r109.get(r114);
        if (r121 != null) goto L48;
        r121 = CollectionsKt.emptyList();
    L48:
        List r122 = (LinkedList) r120.get(r114);
        if (r122 != null) goto L53;
        r122 = CollectionsKt.emptyList();
    L53:
        if (r121.size() != r122.size()) goto L61;
        int r123 = r121.size();
        int r124 = 0;
    L56:
        if (r124 >= r123) goto L23;
        if (Intrinsics.areEqual(((e) ListProtector.get(r121, r124)).toString(), ((e) ListProtector.get(r122, r124)).toString()) == false) goto L61;
        r124 = r124 + 1;
    L61:
        r107 = true;
        goto L23
    L37:
        r119 = false;
        goto L38
    L34:
        r118 = null;
        goto L35
    L41:
        r116 = null;
        goto L42
    L63:
        if (r107 == false) goto L66;
        r100.clear();
        r100.addAll(r101);
    L66:
        return TuplesKt.to(r100, Boolean.valueOf(r107));
    L17:
        r107 = false;
        goto L18
    L13:
        return TuplesKt.to(r100, Boolean.TRUE);
    }

    public static List d(EntrancePage r100, EntranceGroup r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        Intrinsics.checkNotNullParameter(r101, "group");
        int r103 = a.f573770a[r100.ordinal()];
        boolean r104 = false;
        if (r103 == 1) goto L65;
        Object r105 = null;
        if (r103 == 2) goto L35;
        if (aw8.c.f16596d.length() != 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L12;
        List<Map<EntranceGroup, LinkedList<e>>> r107 = aw8.c.f16593a;
    L13:
        Iterator<T> r108 = r107.iterator();
    L15:
        if (r108.hasNext() == false) goto L28;
        Object r109 = r108.next();
        Iterator r110 = ((Map) r109).keySet().iterator();
    L18:
        if (r110.hasNext() == false) goto L22;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((EntranceGroup) r111).getDes(), r101.getDes()) == false) goto L18;
    L23:
        if (r111 == null) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L15;
        r105 = r109;
        goto L28
    L25:
        r112 = false;
        goto L26
    L22:
        r111 = null;
    L28:
        Map r113 = (Map) r105;
        if (r113 == null) goto L93;
        LinkedList r114 = (LinkedList) r113.get(r101);
        if (r114 == null) goto L93;
        return r114;
    L93:
        return CollectionsKt.emptyList();
    L12:
        r107 = aw8.c.f16597e;
        goto L13
    L9:
        r106 = false;
        goto L10
    L35:
        if (f573767h.length() != 0) goto L37;
        boolean r115 = true;
    L38:
        if (r115 == true) goto L42;
        if (r102 == true) goto L42;
        List<Map<EntranceGroup, LinkedList<e>>> r116 = f573769j;
    L43:
        Iterator<T> r117 = r116.iterator();
    L45:
        if (r117.hasNext() == false) goto L58;
        Object r118 = r117.next();
        Iterator r119 = ((Map) r118).keySet().iterator();
    L48:
        if (r119.hasNext() == false) goto L52;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((EntranceGroup) r120).getDes(), r101.getDes()) == false) goto L48;
    L53:
        if (r120 == null) goto L55;
        boolean r121 = true;
    L56:
        if (r121 == false) goto L45;
        r105 = r118;
        goto L58
    L55:
        r121 = false;
        goto L56
    L52:
        r120 = null;
    L58:
        Map r122 = (Map) r105;
        if (r122 == null) goto L94;
        LinkedList r123 = (LinkedList) r122.get(r101);
        if (r123 == null) goto L94;
        return r123;
    L94:
        return CollectionsKt.emptyList();
    L42:
        r116 = f573765f;
        goto L43
    L37:
        r115 = false;
        goto L38
    L65:
        if (f573766g.length() != 0) goto L67;
        r104 = true;
    L67:
        if (r104 == true) goto L71;
        if (r102 == true) goto L71;
        Map<EntranceGroup, LinkedList<e>> r124 = f573768i;
    L72:
        LinkedList<e> r125 = r124.get(r101);
        if (r125 == null) goto L76;
        return r125;
    L76:
        return CollectionsKt.emptyList();
    L71:
        r124 = f573764e;
        goto L72
    }
}
