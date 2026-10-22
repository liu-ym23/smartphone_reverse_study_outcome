package com.bytedance.creativex.mediaimport.view.internal.viewmodel;

import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ki4.a0;
import ki4.e0;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class j<DATA> implements ti4.i<DATA>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<DATA> f204138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<DATA> f204139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<DATA> f204140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<e0, List<DATA>> f204141d;

    public static class a extends j<ki4.r> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.validator.d.a f204142e;

        public a() {
            this.f204142e = com.bytedance.creativex.mediaimport.view.internal.validator.d.f204098o1;
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final String getPath(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204142e.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return r101.getPath();
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final e0 getSourceType(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204142e.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return r101.getSourceType();
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final boolean isVideo(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204142e.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return com.bytedance.creativex.mediaimport.repository.api.a.d(r101);
        }
    }

    public j() {
        this.f204138a = new ArrayList();
        this.f204139b = new ArrayList();
        this.f204140c = new ArrayList();
        this.f204141d = new LinkedHashMap();
    }

    @Override // ti4.i
    public final List<DATA> a() {
        return this.f204138a;
    }

    @Override // ti4.i
    public final List<DATA> c() {
        return this.f204139b;
    }

    @Override // ti4.i
    public final List<DATA> d() {
        return this.f204140c;
    }

    @Override // ti4.i
    public final List<DATA> b(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        if (r100 != BuiltInMaterialType.ALL) goto L10;
        List<DATA> r101 = CollectionsKt.toList(this.f204138a);
        ((ArrayList) this.f204138a).clear();
        Iterator r102 = ((LinkedHashMap) this.f204141d).values().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((List) r102.next()).clear();
        goto L6
    L8:
        ((ArrayList) this.f204140c).clear();
        ((ArrayList) this.f204139b).clear();
        return r101;
    L10:
        if (r100 != BuiltInMaterialType.VIDEO) goto L13;
        List<DATA> r103 = CollectionsKt.toList(this.f204140c);
        ((ArrayList) this.f204140c).clear();
        CollectionsKt.removeAll(this.f204138a, new h(this));
        return r103;
    L13:
        if (r100 != BuiltInMaterialType.IMAGE) goto L17;
        List<DATA> r104 = CollectionsKt.toList(this.f204139b);
        ((ArrayList) this.f204139b).clear();
        CollectionsKt.removeAll(this.f204138a, new i(this));
        return r104;
    L17:
        throw new NotImplementedError("An operation is not implemented: XXY clearSelectState");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ti4.i
    public int getSelectIndex(DATA r100) {
        Iterator r101 = ((ArrayList) this.f204138a).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(getPath(r101.next()), getPath(r100)) == true) goto L13;
        r102 = r102 + 1;
        goto L4
    L13:
        return r102;
    L9:
        return -1;
    }

    @Override // ti4.i
    public final boolean remove(DATA r100) {
        boolean r101 = ((ArrayList) this.f204138a).remove(r100);
        Map<e0, List<DATA>> r102 = this.f204141d;
        e0 r103 = getSourceType(r100);
        LinkedHashMap r104 = (LinkedHashMap) r102;
        Object r105 = r104.get(r103);
        if (r105 != null) goto L5;
        r105 = new ArrayList();
        r104.put(r103, r105);
    L5:
        ((List) r105).remove(r100);
        if (isVideo(r100) == false) goto L8;
        ((ArrayList) this.f204140c).remove(r100);
    L9:
        return r101;
    L8:
        ((ArrayList) this.f204139b).remove(r100);
        goto L9
    }

    @Override // ti4.i
    public final DATA removeAt(int r100) {
        DATA r101 = (DATA) ListProtector.remove(this.f204138a, r100);
        Map<e0, List<DATA>> r102 = this.f204141d;
        e0 r103 = getSourceType(r101);
        LinkedHashMap r104 = (LinkedHashMap) r102;
        Object r105 = r104.get(r103);
        if (r105 != null) goto L5;
        r105 = new ArrayList();
        r104.put(r103, r105);
    L5:
        ((List) r105).remove(r101);
        if (isVideo(r101) == false) goto L8;
        ((ArrayList) this.f204140c).remove(r101);
    L9:
        return r101;
    L8:
        ((ArrayList) this.f204139b).remove(r101);
        goto L9
    }

    @Override // ti4.i
    public void add(DATA r100, int r101) {
        if (r101 < 0) goto L4;
        ListProtector.add(this.f204138a, r101, r100);
    L5:
        Map<e0, List<DATA>> r102 = this.f204141d;
        e0 r103 = getSourceType(r100);
        LinkedHashMap r104 = (LinkedHashMap) r102;
        Object r105 = r104.get(r103);
        if (r105 != null) goto L8;
        r105 = new ArrayList();
        r104.put(r103, r105);
    L8:
        ((List) r105).add(r100);
        if (isVideo(r100) == false) goto L11;
        ((ArrayList) this.f204140c).add(r100);
        return;
    L11:
        ((ArrayList) this.f204139b).add(r100);
        return;
    L4:
        ((ArrayList) this.f204138a).add(r100);
        goto L5
    }
}
