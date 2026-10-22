package com.bytedance.creativex.mediaimport.view.internal.viewmodel;

import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import java.util.HashMap;
import ki4.a0;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public abstract class e<DATA> implements ti4.h<DATA>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Integer> f204128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Integer> f204129b;

    public static class a extends e<ki4.r> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.validator.d.a f204130c;

        public a() {
            this.f204130c = com.bytedance.creativex.mediaimport.view.internal.validator.d.f204098o1;
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final String getPath(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204130c.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return r101.getPath();
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final boolean isVideo(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204130c.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return com.bytedance.creativex.mediaimport.repository.api.a.d(r101);
        }
    }

    @Override // ti4.h
    public final boolean c(DATA r100) {
        return true;
    }

    public e() {
        this.f204128a = new HashMap();
        this.f204129b = new HashMap();
    }

    @Override // ti4.h
    public final MaterialSelectedState a(DATA r100) {
        a r101 = (a) this;
        if (r101.isVideo(r100) == false) goto L5;
        HashMap<String, Integer> r102 = this.f204128a;
    L6:
        Integer r103 = r102.get(r101.getPath(r100));
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        Integer r105 = Integer.valueOf(r104 + 1);
        r102.put(r101.getPath(r100), r105);
        return MaterialSelectedState.SELECTED;
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = this.f204129b;
        goto L6
    }

    @Override // ti4.h
    public final MaterialSelectedState b(DATA r100) {
        a r101 = (a) this;
        if (r101.isVideo(r100) == false) goto L5;
        HashMap<String, Integer> r102 = this.f204128a;
    L6:
        Integer r103 = r102.get(r101.getPath(r100));
        if (r103 != null) goto L9;
        return null;
    L9:
        if (r103.intValue() <= 0) goto L15;
        return MaterialSelectedState.SELECTED;
    L15:
        return MaterialSelectedState.NON_SELECTED;
    L5:
        r102 = this.f204129b;
        goto L6
    }

    @Override // ti4.h
    public final void d(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        if (r100 != BuiltInMaterialType.ALL) goto L6;
        this.f204128a.clear();
        this.f204129b.clear();
        return;
    L6:
        if (r100 != BuiltInMaterialType.VIDEO) goto L9;
        this.f204128a.clear();
        return;
    L9:
        if (r100 != BuiltInMaterialType.IMAGE) goto L13;
        this.f204129b.clear();
        return;
    L13:
        throw new NotImplementedError("An operation is not implemented: XXY clearSelectState");
    }

    @Override // ti4.h
    public final boolean e(DATA r100) {
        return ti4.k.a(this, r100).isSelected();
    }

    @Override // ti4.h
    public final MaterialSelectedState f(DATA r100) {
        a r101 = (a) this;
        if (r101.isVideo(r100) == false) goto L5;
        HashMap<String, Integer> r102 = this.f204128a;
    L6:
        Integer r103 = r102.get(r101.getPath(r100));
        if (r103 == null) goto L14;
        int r104 = r103.intValue();
        int r105 = RangesKt.coerceIn(r104 - 1, 0, r104);
        r102.put(r101.getPath(r100), Integer.valueOf(r105));
        if (r105 <= 0) goto L12;
        return MaterialSelectedState.SELECTED;
    L12:
        return MaterialSelectedState.NON_SELECTED;
    L14:
        return MaterialSelectedState.NON_SELECTED;
    L5:
        r102 = this.f204129b;
        goto L6
    }
}
