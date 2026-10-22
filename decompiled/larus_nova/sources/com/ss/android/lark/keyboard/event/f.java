package com.ss.android.lark.keyboard.event;

import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends T>, Set<Class<? extends T>>> f429298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<? extends T>, Set<Class<? extends T>>> f429299b;

    public static final class a {
    }

    static {
    }

    public f() {
        this.f429298a = new LinkedHashMap();
        this.f429299b = new LinkedHashMap();
    }

    public final Set<Class<? extends T>> a(Class<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Log.d(ObricActionBarTrackType.KEY_BOARD, "handleNotifyType: method called");
        if (this.f429299b.containsKey(r100) == false) goto L16;
        Log.d(ObricActionBarTrackType.KEY_BOARD, "handleNotifyType: findSelect type, method return");
        StringBuilder r101 = new StringBuilder("select type is : ");
        Set r102 = ((LinkedHashMap) this.f429298a).keySet();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r103.add(((Class) r104.next()).getName());
        goto L6
    L8:
        r101.append(r103);
        r101.append("; notify type is: ");
        Set r105 = ((LinkedHashMap) this.f429299b).keySet();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r106.add(((Class) r107.next()).getName());
        goto L10
    L12:
        r101.append(r106);
        Log.d(ObricActionBarTrackType.KEY_BOARD, r101.toString());
        Set<Class<? extends T>> r108 = (Set) ((LinkedHashMap) this.f429299b).get(r100);
        if (r108 == null) goto L15;
        return r108;
    L15:
        return SetsKt.emptySet();
    L16:
        Set r109 = ((LinkedHashMap) this.f429298a).keySet();
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r109.iterator();
    L18:
        if (r111.hasNext() == false) goto L22;
        T r112 = r111.next();
        if (((Class) r112).isAssignableFrom(r100) == false) goto L18;
        r110.add(r112);
        goto L18
    L22:
        Set<Class<? extends T>> r113 = CollectionsKt.toMutableSet(r110);
        this.f429299b.put(r100, r113);
        Iterator<T> r114 = r113.iterator();
    L24:
        if (r114.hasNext() == false) goto L28;
        Class r115 = (Class) r114.next();
        Set r116 = (Set) ((LinkedHashMap) this.f429298a).get(r115);
        if (r116 == null) goto L24;
        r116.add(r100);
        goto L24
    L28:
        StringBuilder r117 = new StringBuilder("select type is : ");
        Set r118 = ((LinkedHashMap) this.f429298a).keySet();
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator<T> r120 = r118.iterator();
    L30:
        if (r120.hasNext() == false) goto L32;
        r119.add(((Class) r120.next()).getName());
        goto L30
    L32:
        r117.append(r119);
        r117.append("; notify type is: ");
        Set r121 = ((LinkedHashMap) this.f429299b).keySet();
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L34:
        if (r123.hasNext() == false) goto L36;
        r122.add(((Class) r123.next()).getName());
        goto L34
    L36:
        r117.append(r122);
        Log.d(ObricActionBarTrackType.KEY_BOARD, r117.toString());
        return r113;
    }

    public final void b(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Log.d(ObricActionBarTrackType.KEY_BOARD, "handleSelectType: method called");
        if (this.f429298a.containsKey(r100) == false) goto L16;
        Log.d(ObricActionBarTrackType.KEY_BOARD, "handleSelectType: findSelect type, method return");
        StringBuilder r101 = new StringBuilder("select type is : ");
        Set r102 = ((LinkedHashMap) this.f429298a).keySet();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r103.add(((Class) r104.next()).getName());
        goto L6
    L8:
        r101.append(r103);
        r101.append("; notify type is: ");
        Set r105 = ((LinkedHashMap) this.f429299b).keySet();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r106.add(((Class) r107.next()).getName());
        goto L10
    L12:
        r101.append(r106);
        Log.d(ObricActionBarTrackType.KEY_BOARD, r101.toString());
        if (((Set) ((LinkedHashMap) this.f429298a).get(r100)) != null) goto L52;
        SetsKt.emptySet();
        return;
    L52:
        return;
    L16:
        Set r108 = ((LinkedHashMap) this.f429299b).keySet();
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L18:
        if (r110.hasNext() == false) goto L22;
        T r111 = r110.next();
        if (r100.isAssignableFrom((Class) r111) == false) goto L18;
        r109.add(r111);
        goto L18
    L22:
        Set<Class<? extends T>> r112 = CollectionsKt.toMutableSet(r109);
        this.f429298a.put(r100, r112);
        Iterator<T> r113 = r112.iterator();
    L24:
        if (r113.hasNext() == false) goto L28;
        Class r114 = (Class) r113.next();
        Set r115 = (Set) ((LinkedHashMap) this.f429299b).get(r114);
        if (r115 == null) goto L24;
        r115.add(r100);
        goto L24
    L28:
        StringBuilder r116 = new StringBuilder("select type is : ");
        Set r117 = ((LinkedHashMap) this.f429298a).keySet();
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L30:
        if (r119.hasNext() == false) goto L32;
        r118.add(((Class) r119.next()).getName());
        goto L30
    L32:
        r116.append(r118);
        r116.append("; notify type is: ");
        Set r120 = ((LinkedHashMap) this.f429299b).keySet();
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator<T> r122 = r120.iterator();
    L34:
        if (r122.hasNext() == false) goto L36;
        r121.add(((Class) r122.next()).getName());
        goto L34
    L36:
        r116.append(r121);
        Log.d(ObricActionBarTrackType.KEY_BOARD, r116.toString());
    }
}
