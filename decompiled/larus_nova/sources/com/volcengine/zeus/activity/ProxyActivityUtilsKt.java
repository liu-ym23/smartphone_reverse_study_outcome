package com.volcengine.zeus.activity;

import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0002\b\u00030\tj\u0006\u0012\u0002\b\u0003`\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0002J\u0019\u0010\u0013\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0002J0\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\nH\u0002J*\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/volcengine/zeus/activity/ProxyActivityUtilsKt;", "", "()V", "KEY_ACTIVITY_RESULT", "", "KEY_SAVED_STATE_REGISTRY", "MAX_FILTER_DEPTH", "", "filterArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", ToygerFaceAlgorithmConfig.DEPTH, "filterBundle", "Landroid/os/Bundle;", "inBundle", "isAllowedArray", "", "value", "isAllowedBoxedArray", "", "([Ljava/lang/Object;)Z", "isAllowedScalar", "putFilteredArrayList", "", Argument.OUT, "key", "putFilteredValue", "safeGetBundle", "bundle", "trimSavedInstanceState", "outState", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public final class ProxyActivityUtilsKt {
    public static final ProxyActivityUtilsKt INSTANCE = null;
    private static final String KEY_ACTIVITY_RESULT = "android:support:activity-result";
    private static final String KEY_SAVED_STATE_REGISTRY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private static final int MAX_FILTER_DEPTH = 20;

    private ProxyActivityUtilsKt() {
    }

    static {
        INSTANCE = new ProxyActivityUtilsKt();
    }

    private final boolean isAllowedArray(Object r100) {
        if ((r100 instanceof boolean[]) == false) goto L5;
    L26:
        return true;
    L5:
        if ((r100 instanceof byte[]) == true) goto L26;
        if ((r100 instanceof char[]) == true) goto L26;
        if ((r100 instanceof short[]) == true) goto L26;
        if ((r100 instanceof int[]) == true) goto L26;
        if ((r100 instanceof long[]) == true) goto L26;
        if ((r100 instanceof float[]) == true) goto L26;
        if ((r100 instanceof double[]) == true) goto L26;
        if ((r100 instanceof Object[]) == false) goto L25;
        Object[] r101 = (Object[]) r100;
        if ((r101 instanceof String[]) == true) goto L26;
        if (isAllowedBoxedArray(r101) == true) goto L26;
    L25:
        return false;
    }

    private final boolean isAllowedBoxedArray(Object[] r100) {
        Class<?> r101 = r100.getClass().getComponentType();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r101, Boolean.class) == false) goto L7;
    L20:
        return true;
    L7:
        if (Intrinsics.areEqual(r101, Byte.class) == true) goto L20;
        if (Intrinsics.areEqual(r101, Character.class) == true) goto L20;
        if (Intrinsics.areEqual(r101, Short.class) == true) goto L20;
        if (Intrinsics.areEqual(r101, Integer.class) == true) goto L20;
        if (Intrinsics.areEqual(r101, Long.class) == true) goto L20;
        if (Intrinsics.areEqual(r101, Float.class) == true) goto L20;
        if (Intrinsics.areEqual(r101, Double.class) == true) goto L20;
        return false;
    }

    private final boolean isAllowedScalar(Object r100) {
        if ((r100 instanceof String) == false) goto L5;
    L22:
        return true;
    L5:
        if ((r100 instanceof Boolean) == true) goto L22;
        if ((r100 instanceof Byte) == true) goto L22;
        if ((r100 instanceof Character) == true) goto L22;
        if ((r100 instanceof Short) == true) goto L22;
        if ((r100 instanceof Integer) == true) goto L22;
        if ((r100 instanceof Long) == true) goto L22;
        if ((r100 instanceof Float) == true) goto L22;
        if ((r100 instanceof Double) == true) goto L22;
        return false;
    }

    @JvmStatic
    public static final void trimSavedInstanceState(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Bundle r101 = new Bundle();
        Bundle r102 = INSTANCE.safeGetBundle(r100, KEY_SAVED_STATE_REGISTRY);
        if (r102 == null) goto L10;
        Bundle r103 = new Bundle();
        Object r104 = r102.get(KEY_ACTIVITY_RESULT);
        if ((r104 instanceof Bundle) == false) goto L9;
        r103.putBundle(KEY_ACTIVITY_RESULT, (Bundle) r104);
    L9:
        r101.putBundle(KEY_SAVED_STATE_REGISTRY, r103);
    L10:
        Iterator<String> r105 = r100.keySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L20;
        String r106 = r105.next();
        if (Intrinsics.areEqual(KEY_SAVED_STATE_REGISTRY, r106) == true) goto L12;
        Object r107 = r100.get(r106);     // Catch: Throwable -> L18
    L19:
        INSTANCE.putFilteredValue(r101, r106, r107, 0);
    L18:
        r107 = null;
        goto L19
    L20:
        r100.clear();
        r100.putAll(r101);
    }

    private final ArrayList<Object> filterArrayList(ArrayList<?> r100, int r101) {
        if (r101 <= 20) goto L5;
        return null;
    L5:
        ArrayList<Object> r102 = new ArrayList(r100.size());
        Iterator<?> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L23;
        Object r104 = r103.next();
        if (r104 == null) goto L7;
        if (isAllowedScalar(r104) == true) goto L21;
        if (isAllowedArray(r104) == true) goto L21;
        if ((r104 instanceof ArrayList) == false) goto L7;
        ArrayList<Object> r105 = filterArrayList((ArrayList) r104, r101 + 1);
        if (r105 == null) goto L7;
        r102.add(r105);
    L21:
        r102.add(r104);
        goto L7
    L23:
        if (r102.isEmpty() == false) goto L26;
        return null;
    L26:
        return r102;
    }

    private final Bundle filterBundle(Bundle r100, int r101) {
        Bundle r102 = new Bundle();
        if (r101 <= 20) goto L5;
        return r102;
    L5:
        Iterator<String> r103 = r100.keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        String r104 = r103.next();
        Object r105 = r100.get(r104);     // Catch: Throwable -> L11
    L12:
        putFilteredValue(r102, r104, r105, r101);
    L11:
        r105 = null;
        goto L12
    L13:
        return r102;
    }

    private final Bundle safeGetBundle(Bundle r100, String r101) {
        Object r102 = r100.get(r101);     // Catch: Throwable -> L9
        if ((r102 instanceof Bundle) == true) goto L6;
        r102 = null;
    L6:
        return (Bundle) r102;
    L12:
        return null;
    }

    private final void putFilteredArrayList(Bundle r100, String r101, ArrayList<Object> r102) {
        boolean r103 = r102 instanceof Collection;
        boolean r104 = false;
        if (r103 == true) goto L5;
    L7:
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L6;
        if ((r105.next() instanceof String) == true) goto L9;
        boolean r106 = false;
    L14:
        if (r106 == false) goto L25;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r108 = r102.iterator();
    L17:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();
        if (r109 == null) goto L22;
        r107.add((String) r109);
        goto L17
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L23:
        r100.putStringArrayList(r101, new ArrayList(r107));
        return;
    L25:
        if (r103 == true) goto L27;
    L29:
        Iterator<T> r110 = r102.iterator();
    L31:
        if (r110.hasNext() == false) goto L28;
        if ((r110.next() instanceof Integer) == true) goto L31;
    L34:
        if (r104 == false) goto L45;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r112 = r102.iterator();
    L37:
        if (r112.hasNext() == false) goto L43;
        Object r113 = r112.next();
        if (r113 == null) goto L42;
        r111.add(Integer.valueOf(((Integer) r113).intValue()));
        goto L37
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L43:
        r100.putIntegerArrayList(r101, new ArrayList(r111));
        return;
    L45:
        r100.putSerializable(r101, r102);
        return;
    L28:
        r104 = true;
        goto L34
    L27:
        if (r102.isEmpty() == false) goto L29;
    L6:
        r106 = true;
        goto L14
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L6
    }

    private final void putFilteredValue(Bundle r100, String r101, Object r102, int r103) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r103 <= 20) goto L7;
        return;
    L7:
        if ((r102 instanceof String) == false) goto L10;
        r100.putString(r101, (String) r102);
        return;
    L10:
        if ((r102 instanceof Boolean) == false) goto L13;
        r100.putBoolean(r101, ((Boolean) r102).booleanValue());
        return;
    L13:
        if ((r102 instanceof Byte) == false) goto L16;
        r100.putByte(r101, ((Number) r102).byteValue());
        return;
    L16:
        if ((r102 instanceof Character) == false) goto L19;
        r100.putChar(r101, ((Character) r102).charValue());
        return;
    L19:
        if ((r102 instanceof Short) == false) goto L22;
        r100.putShort(r101, ((Number) r102).shortValue());
        return;
    L22:
        if ((r102 instanceof Integer) == false) goto L25;
        r100.putInt(r101, ((Number) r102).intValue());
        return;
    L25:
        if ((r102 instanceof Long) == false) goto L28;
        r100.putLong(r101, ((Number) r102).longValue());
        return;
    L28:
        if ((r102 instanceof Float) == false) goto L31;
        r100.putFloat(r101, ((Number) r102).floatValue());
        return;
    L31:
        if ((r102 instanceof Double) == false) goto L34;
        r100.putDouble(r101, ((Number) r102).doubleValue());
        return;
    L34:
        if ((r102 instanceof boolean[]) == false) goto L37;
        r100.putBooleanArray(r101, (boolean[]) r102);
        return;
    L37:
        if ((r102 instanceof byte[]) == false) goto L40;
        r100.putByteArray(r101, (byte[]) r102);
        return;
    L40:
        if ((r102 instanceof char[]) == false) goto L43;
        r100.putCharArray(r101, (char[]) r102);
        return;
    L43:
        if ((r102 instanceof short[]) == false) goto L46;
        r100.putShortArray(r101, (short[]) r102);
        return;
    L46:
        if ((r102 instanceof int[]) == false) goto L49;
        r100.putIntArray(r101, (int[]) r102);
        return;
    L49:
        if ((r102 instanceof long[]) == false) goto L52;
        r100.putLongArray(r101, (long[]) r102);
        return;
    L52:
        if ((r102 instanceof float[]) == false) goto L55;
        r100.putFloatArray(r101, (float[]) r102);
        return;
    L55:
        if ((r102 instanceof double[]) == false) goto L58;
        r100.putDoubleArray(r101, (double[]) r102);
        return;
    L58:
        if ((r102 instanceof Object[]) == false) goto L66;
        Object[] r104 = (Object[]) r102;
        if ((r104 instanceof String[]) == false) goto L63;
        r100.putStringArray(r101, (String[]) r102);
        return;
    L63:
        if (isAllowedBoxedArray(r104) == false) goto L94;
        r100.putSerializable(r101, (Serializable) r102);
        return;
    L94:
        return;
    L66:
        if ((r102 instanceof ArrayList) == false) goto L72;
        ArrayList<Object> r105 = filterArrayList((ArrayList) r102, r103 + 1);
        if (r105 == null) goto L70;
        putFilteredArrayList(r100, r101, r105);
        return;
    L70:
        return;
    L72:
        if ((r102 instanceof Bundle) == false) goto L97;
        r100.putBundle(r101, filterBundle((Bundle) r102, r103 + 1));
        return;
    }
}
