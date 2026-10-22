package com.ss.android.ugc.aweme.lazydata;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/lazydata/LazyDataManager;", "", "<init>", "()V", "lazydata_release"}, k = 1, mv = {1, 4, 1})
public final class LazyDataManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Keva, Keva>> f450960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f450961b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f450962c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f450963d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LazyDataManager f450964e = null;

    private LazyDataManager() {
    }

    static {
        f450964e = new LazyDataManager();
        f450960a = new ConcurrentHashMap();
        f450961b = LazyKt.lazy(LazyDataManager$firstRepo$2.INSTANCE);
        f450962c = LazyKt.lazy(LazyDataManager$secondRepo$2.INSTANCE);
        f450963d = LazyKt.lazy(LazyDataManager$gson$2.INSTANCE);
    }

    public static Pair a() {
        Lazy r100 = f450961b;
        long r101 = ((Keva) r100.getValue()).getLong("lazy_data_update_time-btm_sdk_config", 0);
        Lazy r102 = f450962c;
        if (r101 <= ((Keva) r102.getValue()).getLong("lazy_data_update_time-btm_sdk_config", 0)) goto L6;
        return new Pair((Keva) r100.getValue(), (Keva) r102.getValue());
    L6:
        return new Pair((Keva) r102.getValue(), (Keva) r100.getValue());
    }

    public static Keva b() {
        ConcurrentHashMap<String, Pair<Keva, Keva>> r100 = f450960a;
        Pair<Keva, Keva> r101 = r100.get("btm_sdk_config");
        if (r101 != null) goto L9;
        f450964e.getClass();
        r101 = a();
        Pair<Keva, Keva> r102 = r100.putIfAbsent("btm_sdk_config", r101);
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        return r101.getSecond();
    }

    public static boolean c(String r100, Object r101, Keva r102) {
        if (r101 == null) goto L4;
        return true;
    L4:
        if (r102.contains(r100) == false) goto L10;
        r102.erase(r100);
        return false;
    L10:
        return false;
    }

    public static void d(String r210, Object r211, Class r212, Keva r213) {
        String r100 = r210;
        if (r212 == null) goto L5;
        Class r101 = r212;
    L8:
        String r102 = "-boolean";
        String r103 = "-float";
        String r110 = "null cannot be cast to non-null type kotlin.String";
        if (r101 != null) goto L11;
        String r111 = "-int";
        String r104 = "-string";
    L117:
        boolean r105 = true;
    L118:
        if (r105 == true) goto L266;
        if (r212 == null) goto L123;
        Field[] r106 = r212.getDeclaredFields();
        if (r106 == null) goto L123;
    L126:
        if (r106 == null) goto L284;
        String r112 = "null cannot be cast to non-null type kotlin.Int";
        int r113 = r106.length;
        String r114 = "null cannot be cast to non-null type kotlin.Float";
        int r115 = 0;
    L128:
        if (r115 >= r113) goto L285;
        int r214 = r113;
        Field r116 = r106[r115];
        if (r116 != null) goto L135;
        Field[] r117 = r106;
    L132:
        int r215 = r115;
    L134:
        String r118 = r102;
    L265:
        r113 = r214;
        r112 = r112;
        r111 = r111;
        r102 = r118;
        r106 = r117;
        r115 = r215 + 1;
        r114 = r114;
        r100 = r210;
        r103 = r103;
        r110 = r110;
        goto L128
    L135:
        r117 = r106;
        r116.setAccessible(true);
        SerializedName r107 = (SerializedName) r116.getAnnotation(SerializedName.class);
        if (r107 == null) goto L132;
        r215 = r115;
        StringBuilder r119 = new StringBuilder();
        r119.append(r100);
        String r108 = "-";
        r119.append("-");
        r119.append(r107.value());
        String r109 = r119.toString();
        String r216 = r103;
        if (Intrinsics.areEqual(r116.getType(), Integer.TYPE) == false) goto L140;
    L255:
        r110 = r110;
        r114 = r114;
        r103 = r216;
        StringBuilder r120 = new StringBuilder();
        r120.append(r109);
        r111 = r111;
        r120.append(r111);
        r118 = r102;
        if (c(r120.toString(), r116.get(r211), r213) == false) goto L265;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        String r121 = r109 + r111;
        Object r122 = r116.get(r211);
        if (r122 == null) goto L263;
        r213.storeInt(r121, ((Integer) r122).intValue());
        goto L265
    L263:
        throw new NullPointerException(r112);
    L140:
        if (Intrinsics.areEqual(r116.getType(), Integer.class) == true) goto L255;
        if (Intrinsics.areEqual(r116.getType(), Float.TYPE) == false) goto L145;
    L247:
        r110 = r110;
        StringBuilder r123 = new StringBuilder();
        r123.append(r109);
        r103 = r216;
        r123.append(r103);
        if (c(r123.toString(), r116.get(r211), r213) == false) goto L134;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        String r124 = r109 + r103;
        Object r125 = r116.get(r211);
        if (r125 == null) goto L254;
        r213.storeFloat(r124, ((Float) r125).floatValue());
        goto L134
    L254:
        throw new NullPointerException(r114);
    L145:
        if (Intrinsics.areEqual(r116.getType(), Float.class) == true) goto L247;
        if (Intrinsics.areEqual(r116.getType(), Boolean.TYPE) == false) goto L150;
    L239:
        r110 = r110;
        if (c(r109 + r102, r116.get(r211), r213) == true) goto L242;
    L241:
        r103 = r216;
        goto L134
    L242:
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        String r126 = r109 + r102;
        Object r127 = r116.get(r211);
        if (r127 == null) goto L246;
        r213.storeBoolean(r126, ((Boolean) r127).booleanValue());
        goto L241
    L246:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L150:
        if (Intrinsics.areEqual(r116.getType(), Boolean.class) == true) goto L239;
        if (Intrinsics.areEqual(r116.getType(), Double.TYPE) == false) goto L155;
    L231:
        r110 = r110;
        if (c(r109 + "-double", r116.get(r211), r213) == false) goto L241;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        String r128 = r109 + "-double";
        Object r129 = r116.get(r211);
        if (r129 == null) goto L238;
        r213.storeDouble(r128, ((Double) r129).doubleValue());
        goto L241
    L238:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L155:
        if (Intrinsics.areEqual(r116.getType(), Double.class) == true) goto L231;
        if (Intrinsics.areEqual(r116.getType(), byte[].class) == false) goto L160;
    L230:
        r110 = r110;
        goto L241
    L160:
        if (Intrinsics.areEqual(r116.getType(), Long.TYPE) == false) goto L162;
    L222:
        r110 = r110;
        if (c(r109 + "-long", r116.get(r211), r213) == false) goto L241;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        String r130 = r109 + "-long";
        Object r131 = r116.get(r211);
        if (r131 == null) goto L229;
        r213.storeLong(r130, ((Long) r131).longValue());
        goto L241
    L229:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L162:
        if (Intrinsics.areEqual(r116.getType(), Long.class) == true) goto L222;
        if (Intrinsics.areEqual(r116.getType(), String.class) == false) goto L175;
        if (c(r109 + r104, r116.get(r211), r213) == false) goto L230;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        String r132 = r109 + r104;
        Object r133 = r116.get(r211);
        if (r133 == null) goto L173;
        r213.storeString(r132, (String) r133);
        goto L230
    L173:
        throw new NullPointerException(r110);
    L175:
        if (Object[].class.isAssignableFrom(r116.getType()) == false) goto L194;
        r110 = r110;
        if (c(r109 + "-size", r116.get(r211), r213) == false) goto L241;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        String r134 = r109 + "-size";
        Object r135 = r116.get(r211);
        if (r135 == null) goto L193;
        r213.storeInt(r134, ((Object[]) r135).length);
        Object r136 = r116.get(r211);
        if (r136 == null) goto L191;
        Object[] r137 = (Object[]) r136;
        int r138 = r137.length;
        int r139 = 0;
    L184:
        if (r139 >= r138) goto L241;
        Object r140 = r137[r139];
        Object[] r217 = r137;
        String r141 = r109 + "-" + r139;
        if (r140 == null) goto L188;
        Class<?> r142 = r140.getClass();
    L189:
        d(r141, r140, r142, r213);
        r139 = r139 + 1;
        r137 = r217;
        r138 = r138;
        goto L184
    L188:
        r142 = null;
        goto L189
    L191:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
    L193:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
    L194:
        r110 = r110;
        if (Map.class.isAssignableFrom(r116.getType()) == false) goto L201;
        if (c(r109 + "-size", r116.get(r211), r213) == false) goto L241;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        r213.storeString(r109 + r104, GsonProtectorUtils.toJson((Gson) f450963d.getValue(), r116.get(r211)));
        goto L241
    L201:
        if (Collection.class.isAssignableFrom(r116.getType()) == true) goto L203;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        d(r109, r116.get(r211), r116.getType(), r213);
        goto L241
    L203:
        if (c(r109 + "-size", r116.get(r211), r213) == false) goto L241;
        r116.getName();
        Objects.toString(r116.getType());
        Objects.toString(r116.get(r211));
        String r143 = r109 + "-size";
        Object r144 = r116.get(r211);
        if (r144 == null) goto L220;
        r213.storeInt(r143, ((Collection) r144).size());
        Object r145 = r116.get(r211);
        if (r145 == null) goto L218;
        Iterator r146 = ((Collection) r145).iterator();
        int r147 = 0;
    L211:
        if (r146.hasNext() == false) goto L241;
        Object r148 = r146.next();
        String r149 = r109 + r108 + r147;
        if (r148 == null) goto L215;
        Class<?> r150 = r148.getClass();
    L216:
        d(r149, r148, r150, r213);
        r147 = r147 + 1;
        r108 = r108;
        goto L211
    L215:
        r150 = null;
        goto L216
    L218:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Collection<*>");
    L220:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Collection<*>");
    L285:
        return;
    L284:
        return;
    L123:
        if (r211 == null) goto L125;
        r106 = r211.getClass().getDeclaredFields();
        goto L126
    L125:
        r106 = null;
        goto L126
    L266:
        return;
    L11:
        if (Intrinsics.areEqual(r101, Integer.class) == true) goto L16;
        if (Intrinsics.areEqual(r101, Integer.TYPE) == true) goto L16;
        if (Intrinsics.areEqual(r101, Float.class) == true) goto L35;
        if (Intrinsics.areEqual(r101, Float.TYPE) == true) goto L35;
        if (Intrinsics.areEqual(r101, Boolean.class) == true) goto L52;
        if (Intrinsics.areEqual(r101, Boolean.TYPE) == true) goto L52;
        if (Intrinsics.areEqual(r101, Double.class) == true) goto L69;
        if (Intrinsics.areEqual(r101, Double.TYPE) == true) goto L69;
        r111 = "-int";
        if (Intrinsics.areEqual(r101, byte[].class) == false) goto L84;
    L26:
        r104 = "-string";
        goto L117
    L84:
        if (Intrinsics.areEqual(r101, Long.class) == true) goto L89;
        if (Intrinsics.areEqual(r101, Long.TYPE) == true) goto L89;
        if (Intrinsics.areEqual(r101, String.class) == false) goto L115;
        StringBuilder r151 = new StringBuilder();
        r151.append(r100);
        r104 = "-string";
        r151.append(r104);
        if (c(r151.toString(), r211, r213) == false) goto L117;
        if (r211 == null) goto L108;
        Class<?> r152 = r211.getClass();
    L109:
        Objects.toString(r152);
        Objects.toString(r211);
        String r153 = r100 + r104;
        if (r211 == null) goto L114;
        r213.storeString(r153, (String) r211);
        goto L117
    L114:
        throw new NullPointerException(r110);
    L108:
        r152 = null;
        goto L109
    L115:
        r110 = r110;
        r104 = "-string";
        r105 = false;
    L89:
        if (c(r100 + "-long", r211, r213) == false) goto L26;
        if (r211 == null) goto L94;
        Class<?> r154 = r211.getClass();
    L95:
        Objects.toString(r154);
        Objects.toString(r211);
        String r155 = r100 + "-long";
        if (r211 == null) goto L99;
        r213.storeLong(r155, ((Long) r211).longValue());
        goto L26
    L99:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L94:
        r154 = null;
    L69:
        if (c(r100 + "-double", r211, r213) == true) goto L72;
    L25:
        r111 = "-int";
        goto L26
    L72:
        if (r211 == null) goto L74;
        Class<?> r156 = r211.getClass();
    L75:
        Objects.toString(r156);
        Objects.toString(r211);
        String r157 = r100 + "-double";
        if (r211 == null) goto L79;
        r111 = "-int";
        r213.storeDouble(r157, ((Double) r211).doubleValue());
        goto L26
    L79:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L74:
        r156 = null;
    L52:
        if (c(r100 + "-boolean", r211, r213) == false) goto L25;
        if (r211 == null) goto L57;
        Class<?> r158 = r211.getClass();
    L58:
        Objects.toString(r158);
        Objects.toString(r211);
        String r159 = r100 + "-boolean";
        if (r211 == null) goto L62;
        r213.storeBoolean(r159, ((Boolean) r211).booleanValue());
        goto L25
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L57:
        r158 = null;
    L35:
        if (c(r100 + "-float", r211, r213) == false) goto L25;
        if (r211 == null) goto L40;
        Class<?> r160 = r211.getClass();
    L41:
        Objects.toString(r160);
        Objects.toString(r211);
        String r161 = r100 + "-float";
        if (r211 == null) goto L45;
        r213.storeFloat(r161, ((Float) r211).floatValue());
        goto L25
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L40:
        r160 = null;
    L16:
        if (c(r100 + "-int", r211, r213) == false) goto L25;
        if (r211 == null) goto L21;
        Class<?> r162 = r211.getClass();
    L22:
        Objects.toString(r162);
        Objects.toString(r211);
        String r163 = r100 + "-int";
        if (r211 == null) goto L28;
        r213.storeInt(r163, ((Integer) r211).intValue());
        goto L25
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L21:
        r162 = null;
        goto L22
    L5:
        if (r211 == null) goto L7;
        r101 = r211.getClass();
        goto L8
    L7:
        r101 = null;
        goto L8
    }
}
