package com.bytedance.creativex.mediaimport.view.internal.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.IFolderItem;
import com.larus.photopicker.impl.ui.s0;
import com.larus.photopicker.impl.ui.t0;
import java.util.LinkedHashMap;
import java.util.Map;
import ki4.a0;
import ki4.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class x implements ti4.v<ki4.r, IFolderItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f204154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ki4.r, ki4.a> f204155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f204156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ti4.n f204157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ti4.p<IFolderItem> f204158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ti4.m<ki4.r> f204159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ti4.t<z> f204160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f204161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<a0, ti4.r<ki4.r>> f204162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f204163j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function2<? super IFolderItem, ? super a0, Boolean> f204164a;

        public a() {
            this(null);
        }

        public a(Object r100) {
            this.f204164a = null;
        }
    }

    @Override // ti4.v
    public final ti4.q c() {
        return (ti4.q) this.f204163j.getValue();
    }

    @Override // ti4.v
    public final ti4.m<ki4.r> b() {
        return this.f204159f;
    }

    @Override // ti4.v
    public final ti4.t<z> d() {
        return this.f204160g;
    }

    @Override // ti4.v
    public final ti4.n e() {
        return this.f204157d;
    }

    @Override // ti4.v
    public final ti4.p<IFolderItem> f() {
        return this.f204158e;
    }

    @Override // ti4.v
    public final ti4.r<ki4.r> a(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        LinkedHashMap r101 = (LinkedHashMap) this.f204162i;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L10;
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        ti4.p<IFolderItem> r103 = this.f204158e;
        if (r103 == null) goto L7;
        r102 = new MediaSelectListViewModel(this.f204154a, r100, r103);
    L8:
        r101.put(r100, r102);
        goto L10
    L7:
        r102 = null;
    L10:
        return (ti4.r) r102;
    }

    @Override // ti4.v
    public final void requestData(boolean r100) {
        ti4.p<IFolderItem> r101 = this.f204158e;
        if (r101 == null) goto L6;
        r101.requestData(r100);
        return;
    }

    public x(LifecycleOwner r100, oi4.c r101, s0 r102, BuiltInMaterialType r103, MediaSelectFolderListViewModel r104, MaterialIndexedSelectorViewModel r105, t0 r110) {
        MediaCategoryViewModel r106 = new MediaCategoryViewModel(r100, r101);
        v r107 = new v();
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "mediaRepository");
        Intrinsics.checkNotNullParameter(r102, "folderKeyProvider");
        Intrinsics.checkNotNullParameter(r103, "categoryType");
        this.f204154a = r100;
        this.f204155b = r102;
        this.f204156c = r103;
        this.f204157d = r106;
        this.f204158e = r104;
        this.f204159f = r105;
        this.f204160g = r107;
        a r108 = new a(null);
        this.f204161h = r108;
        r110.invoke(r108);
        this.f204162i = new LinkedHashMap();
        this.f204163j = LazyKt.lazy(new w(this));
    }
}
