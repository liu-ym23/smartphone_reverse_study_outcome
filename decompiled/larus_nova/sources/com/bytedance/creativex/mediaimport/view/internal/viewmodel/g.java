package com.bytedance.creativex.mediaimport.view.internal.viewmodel;

import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import java.util.HashMap;
import ki4.a0;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class g<DATA> implements ti4.h<DATA>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, MaterialSelectedState> f204133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, MaterialSelectedState> f204134b;

    public static class a extends g<ki4.r> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.validator.d.a f204135c;

        public a() {
            this.f204135c = com.bytedance.creativex.mediaimport.view.internal.validator.d.f204098o1;
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final String getPath(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204135c.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return r101.getPath();
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final boolean isVideo(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204135c.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return com.bytedance.creativex.mediaimport.repository.api.a.d(r101);
        }
    }

    public g() {
        this.f204133a = new HashMap();
        this.f204134b = new HashMap();
    }

    @Override // ti4.h
    public final MaterialSelectedState a(DATA r100) {
        a r101 = (a) this;
        if (r101.isVideo(r100) == false) goto L5;
        HashMap<String, MaterialSelectedState> r102 = this.f204134b;
    L6:
        String r103 = r101.getPath(r100);
        MaterialSelectedState r104 = MaterialSelectedState.SELECTED;
        r102.put(r103, r104);
        return r104;
    L5:
        r102 = this.f204133a;
        goto L6
    }

    @Override // ti4.h
    public final MaterialSelectedState b(DATA r100) {
        a r101 = (a) this;
        if (r101.isVideo(r100) == false) goto L5;
        HashMap<String, MaterialSelectedState> r102 = this.f204134b;
    L7:
        return r102.get(r101.getPath(r100));
    L5:
        r102 = this.f204133a;
        goto L7
    }

    @Override // ti4.h
    public final boolean c(DATA r100) {
        return !ti4.k.a(this, r100).isSelected();
    }

    @Override // ti4.h
    public final void d(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        if (r100 != BuiltInMaterialType.ALL) goto L6;
        this.f204134b.clear();
        this.f204133a.clear();
        return;
    L6:
        if (r100 != BuiltInMaterialType.VIDEO) goto L9;
        this.f204134b.clear();
        return;
    L9:
        if (r100 != BuiltInMaterialType.IMAGE) goto L13;
        this.f204133a.clear();
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
        HashMap<String, MaterialSelectedState> r102 = this.f204134b;
    L6:
        String r103 = r101.getPath(r100);
        MaterialSelectedState r104 = MaterialSelectedState.NON_SELECTED;
        r102.put(r103, r104);
        return r104;
    L5:
        r102 = this.f204133a;
        goto L6
    }
}
