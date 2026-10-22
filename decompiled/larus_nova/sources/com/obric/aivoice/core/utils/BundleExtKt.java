package com.obric.aivoice.core.utils;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.obric.aivoice.core.data.IdlKeys;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f¨\u0006\u0012"}, d2 = {"bundle2json", "Lorg/json/JSONObject;", "args", "Landroid/os/Bundle;", "json2Bundle", "compressFloat", "", "saveArr", "", "arr", "Lorg/json/JSONArray;", "key", "", "bundle", "setErr", "code", "", "errInfo", "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BundleExtKt {
    public static final JSONObject bundle2json(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L78;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof Integer) == true) goto L7;
        if ((r104 instanceof int[]) == true) goto L10;
        if ((r104 instanceof Long) == true) goto L17;
        if ((r104 instanceof long[]) == true) goto L20;
        if ((r104 instanceof Boolean) == true) goto L27;
        if ((r104 instanceof boolean[]) == true) goto L30;
        if ((r104 instanceof Double) == true) goto L37;
        if ((r104 instanceof double[]) == true) goto L40;
        if ((r104 instanceof Float) == true) goto L47;
        if ((r104 instanceof float[]) == true) goto L50;
        if ((r104 instanceof String) == true) goto L57;
        if ((r104 instanceof Bundle) == true) goto L60;
        if ((r104 instanceof Object[]) == false) goto L4;
        Object[] r105 = (Object[]) r104;
        if (r105.length <= 0) goto L78;
        if ((r105[0] instanceof Bundle) == true) goto L68;
        JSONArray r106 = new JSONArray();
        Iterator<Integer> r107 = RangesKt.until(0, r105.length).iterator();
    L75:
        if (r107.hasNext() == false) goto L77;
        int r108 = ((IntIterator) r107).nextInt();
        r106.put(r108, r105[r108]);
        goto L75
    L77:
        Unit r109 = Unit.INSTANCE;
        r101.put(r103, r106);
        goto L4
    L68:
        JSONArray r110 = new JSONArray();
        Iterator<Integer> r111 = RangesKt.until(0, r105.length).iterator();
    L70:
        if (r111.hasNext() == false) goto L72;
        int r112 = ((IntIterator) r111).nextInt();
        Object r113 = r105[r112];
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.os.Bundle");
        r110.put(r112, bundle2json((Bundle) r113));
        goto L70
    L72:
        Unit r114 = Unit.INSTANCE;
        r101.put(r103, r110);
        goto L4
    L60:
        r101.put(r103, bundle2json((Bundle) r104));
        goto L4
    L57:
        r101.put(r103, r104);
        goto L4
    L50:
        JSONArray r115 = new JSONArray();
        float[] r116 = (float[]) r104;
        Iterator<Integer> r117 = RangesKt.until(0, r116.length).iterator();
    L52:
        if (r117.hasNext() == false) goto L54;
        int r118 = ((IntIterator) r117).nextInt();
        r115.put(r118, Float.valueOf(r116[r118]));
        goto L52
    L54:
        Unit r119 = Unit.INSTANCE;
        r101.put(r103, r115);
        goto L4
    L47:
        r101.put(r103, r104);
        goto L4
    L40:
        JSONArray r120 = new JSONArray();
        double[] r121 = (double[]) r104;
        Iterator<Integer> r122 = RangesKt.until(0, r121.length).iterator();
    L42:
        if (r122.hasNext() == false) goto L44;
        int r123 = ((IntIterator) r122).nextInt();
        r120.put(r123, r121[r123]);
        goto L42
    L44:
        Unit r124 = Unit.INSTANCE;
        r101.put(r103, r120);
        goto L4
    L37:
        r101.put(r103, ((Number) r104).doubleValue());
        goto L4
    L30:
        JSONArray r125 = new JSONArray();
        boolean[] r126 = (boolean[]) r104;
        Iterator<Integer> r127 = RangesKt.until(0, r126.length).iterator();
    L32:
        if (r127.hasNext() == false) goto L34;
        int r128 = ((IntIterator) r127).nextInt();
        r125.put(r128, r126[r128]);
        goto L32
    L34:
        Unit r129 = Unit.INSTANCE;
        r101.put(r103, r125);
        goto L4
    L27:
        r101.put(r103, ((Boolean) r104).booleanValue());
        goto L4
    L20:
        JSONArray r130 = new JSONArray();
        long[] r131 = (long[]) r104;
        Iterator<Integer> r132 = RangesKt.until(0, r131.length).iterator();
    L22:
        if (r132.hasNext() == false) goto L24;
        int r133 = ((IntIterator) r132).nextInt();
        r130.put(r133, r131[r133]);
        goto L22
    L24:
        Unit r134 = Unit.INSTANCE;
        r101.put(r103, r130);
        goto L4
    L17:
        r101.put(r103, ((Number) r104).longValue());
        goto L4
    L10:
        JSONArray r135 = new JSONArray();
        int[] r136 = (int[]) r104;
        Iterator<Integer> r137 = RangesKt.until(0, r136.length).iterator();
    L12:
        if (r137.hasNext() == false) goto L14;
        int r138 = ((IntIterator) r137).nextInt();
        r135.put(r138, r136[r138]);
        goto L12
    L14:
        Unit r139 = Unit.INSTANCE;
        r101.put(r103, r135);
        goto L4
    L7:
        r101.put(r103, ((Number) r104).intValue());
    L78:
        return r101;
    }

    public static final Bundle json2Bundle(JSONObject r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Bundle r102 = new Bundle();
        Iterator<String> r103 = r100.keys();
    L4:
        if (r103.hasNext() == false) goto L28;
        String r104 = r103.next();
        Object r105 = r100.get(r104);
        if ((r105 instanceof String) == true) goto L7;
        if ((r105 instanceof Integer) == true) goto L10;
        if ((r105 instanceof Long) == true) goto L13;
        if ((r105 instanceof Boolean) == true) goto L16;
        if ((r105 instanceof Double) == true) goto L19;
        if ((r105 instanceof JSONArray) == true) goto L24;
        if ((r105 instanceof JSONObject) == false) goto L4;
        r102.putBundle(r104, json2Bundle((JSONObject) r105, r101));
        goto L4
    L24:
        saveArr((JSONArray) r105, r104, r102, r101);
        goto L4
    L19:
        if (r101 == true) goto L20;
        r102.putDouble(r104, ((Number) r105).doubleValue());
        goto L4
    L20:
        r102.putFloat(r104, (float) ((Number) r105).doubleValue());
        goto L4
    L16:
        r102.putBoolean(r104, ((Boolean) r105).booleanValue());
        goto L4
    L13:
        r102.putLong(r104, ((Number) r105).longValue());
        goto L4
    L10:
        r102.putInt(r104, ((Number) r105).intValue());
        goto L4
    L7:
        r102.putString(r104, (String) r105);
        goto L4
    L28:
        return r102;
    }

    public static final Bundle setErr(Bundle r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.putInt(IdlKeys.ErrorCode, r101);
        r100.putString(IdlKeys.ErrorInfo, r102);
        r100.putBoolean(IdlKeys.IsFinish, true);
        return r100;
    }

    public static /* synthetic */ Bundle json2Bundle$default(JSONObject r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = true;
    L6:
        return json2Bundle(r100, r101);
    }

    public static final void saveArr(JSONArray r100, String r101, Bundle r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "arr");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "bundle");
        if (r100.length() != 0) goto L5;
        return;
    L5:
        Object r104 = r100.opt(0);
        if (r104 != null) goto L8;
        return;
    L8:
        IntRange r105 = new IntRange(0, r100.length() - 1);
        if ((r104 instanceof String) == false) goto L16;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r107 = r105.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        r106.add(JSONArrayProtectorUtils.getString(r100, ((IntIterator) r107).nextInt()));
        goto L12
    L14:
        r102.putStringArray(r101, (String[]) r106.toArray(new String[0]));
        return;
    L16:
        if ((r104 instanceof Integer) == false) goto L23;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r109 = r105.iterator();
    L19:
        if (r109.hasNext() == false) goto L21;
        r108.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r100, ((IntIterator) r109).nextInt())));
        goto L19
    L21:
        r102.putIntArray(r101, CollectionsKt.toIntArray(r108));
        return;
    L23:
        if ((r104 instanceof Long) == false) goto L30;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r111 = r105.iterator();
    L26:
        if (r111.hasNext() == false) goto L28;
        r110.add(Long.valueOf(JSONArrayProtectorUtils.getLong(r100, ((IntIterator) r111).nextInt())));
        goto L26
    L28:
        r102.putLongArray(r101, CollectionsKt.toLongArray(r110));
        return;
    L30:
        if ((r104 instanceof Boolean) == false) goto L37;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r113 = r105.iterator();
    L33:
        if (r113.hasNext() == false) goto L35;
        r112.add(Boolean.valueOf(JSONArrayProtectorUtils.getBoolean(r100, ((IntIterator) r113).nextInt())));
        goto L33
    L35:
        r102.putBooleanArray(r101, CollectionsKt.toBooleanArray(r112));
        return;
    L37:
        if ((r104 instanceof Double) == false) goto L50;
        if (r103 == false) goto L44;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r115 = r105.iterator();
    L41:
        if (r115.hasNext() == false) goto L43;
        r114.add(Float.valueOf((float) JSONArrayProtectorUtils.getDouble(r100, ((IntIterator) r115).nextInt())));
        goto L41
    L43:
        r102.putFloatArray(r101, CollectionsKt.toFloatArray(r114));
        return;
    L44:
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r117 = r105.iterator();
    L46:
        if (r117.hasNext() == false) goto L48;
        r116.add(Double.valueOf(JSONArrayProtectorUtils.getDouble(r100, ((IntIterator) r117).nextInt())));
        goto L46
    L48:
        r102.putDoubleArray(r101, CollectionsKt.toDoubleArray(r116));
        return;
    L50:
        if ((r104 instanceof JSONObject) == false) goto L56;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r119 = r105.iterator();
    L53:
        if (r119.hasNext() == false) goto L55;
        r118.add(json2Bundle(JSONArrayProtectorUtils.getJSONObject(r100, ((IntIterator) r119).nextInt()), r103));
        goto L53
    L55:
        r102.putParcelableArray(r101, (Parcelable[]) r118.toArray(new Bundle[0]));
        return;
    L56:
        boolean r120 = r104 instanceof JSONArray;
    }
}
