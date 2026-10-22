package com.bytedance.ee.bear.bitable.core.infoarch;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.infoarch.BitableInfoArchPlugin;
import com.bytedance.ee.bear.bitable.infoarch.block.BlockCatalogModel;
import com.bytedance.ee.bear.bitable.infoarch.header.HeaderContainerModel;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.infoarch.toolbar.ToolbarContainerModel;
import com.bytedance.ee.bear.bitable.infoarch.view.ViewContainerModel;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitableAnalytic f210551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.bitable.core.infoarch.arch.h> f210552b;

    public SceneModel a() {
        return null;
    }

    public abstract String b();

    public void c(String r100) {
    }

    public abstract void d(SceneModel r100);

    public void e(BlockCatalogModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "actionHandler");
    }

    public void f(HeaderContainerModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "actionHandler");
    }

    public void g(CardViewData r100, BitableInfoArchPlugin.d.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "handler");
    }

    public abstract void h(BitableNativeViewData r100, gv4.a r101, m r102);

    public abstract void i(GalleryViewData r100, BitableInfoArchPlugin.e.a r101);

    public abstract void j(GridViewData r100, BitableInfoArchPlugin.f.a r101);

    public abstract void k(ToolbarContainerModel r100, gv4.a r101);

    public abstract void l(ViewContainerModel r100, gv4.a r101);

    public void m(EmptyData r100, gv4.d r101) {
    }

    public abstract void n(zs4.d r100, m r101, Map<String, ? extends tb5.i<String>> r102);

    public void o(BitableInfoArchPlugin.s r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
    }

    public void p() {
    }

    public f() {
        this.f210552b = new ArrayList();
    }
}
