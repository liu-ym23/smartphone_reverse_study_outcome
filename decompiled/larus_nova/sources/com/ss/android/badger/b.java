package com.ss.android.badger;

import com.bytedance.badger.network.a0;
import com.bytedance.badger.network.b0;
import com.bytedance.badger.network.v;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.ss.android.account.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import wqa.f;
import wqa.i;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements v {
    public b() {
    }

    @Override // com.bytedance.badger.network.v
    public final String getHost() {
        f r100 = k.f406318b;
        if (r100 == null) goto L7;
        String r101 = r100.S();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
    @Override // com.bytedance.badger.network.v
    public final b0 a(a0 r100) {
        String r101 = r100.f199070a;
        List<Pair<String, String>> r102 = r100.f199071b;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Pair r105 = (Pair) r104.next();
        r103.add(new i((String) r105.getFirst(), (String) r105.getSecond()));
        goto L4
    L6:
        sa7.k r106 = k.d().a();
        boolean r107 = false;
        if (r106 == null) goto L9;
        wqa.k r108 = r106.e(r101, r103, 0);
    L10:
        int r109 = r108.f560778a;
        if (r109 >= 200) goto L13;
    L15:
        List<i> r110 = r108.f560779b;
        if (r110 == null) goto L21;
        List<i> r111 = r110;
        ?? r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
    L19:
        if (r113.hasNext() == false) goto L23;
        i r114 = (i) r113.next();
        r112.add(TuplesKt.to(r114.f560775a, r114.f560776b));
    L23:
        return new b0(r107, r109, r112, r108.f560780c);
    L21:
        r112 = CollectionsKt.emptyList();
        goto L23
    L13:
        if (r109 >= 300) goto L15;
        r107 = true;
        goto L15
    L9:
        r108 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    @Override // com.bytedance.badger.network.v
    public final b0 b(a0 r100) {
        String r101 = r100.f199070a;
        Map<String, String> r102 = r100.f199072c;
        List<Pair<String, String>> r103 = r100.f199071b;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Pair r106 = (Pair) r105.next();
        r104.add(new i((String) r106.getFirst(), (String) r106.getSecond()));
        goto L4
    L6:
        wqa.k r107 = NetworkUtils.b(r101, r102, r104);
        int r108 = r107.f560778a;
        if (r108 >= 200) goto L9;
    L11:
        boolean r109 = false;
    L12:
        List<i> r110 = r107.f560779b;
        if (r110 == null) goto L18;
        List<i> r111 = r110;
        ?? r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
    L16:
        if (r113.hasNext() == false) goto L20;
        i r114 = (i) r113.next();
        r112.add(TuplesKt.to(r114.f560775a, r114.f560776b));
    L20:
        return new b0(r109, r108, r112, r107.f560780c);
    L18:
        r112 = CollectionsKt.emptyList();
        goto L20
    L9:
        if (r108 >= 300) goto L11;
        r109 = true;
        goto L12
    }
}
