package com.ss.android.lark.widget.photopickerimpl.view.grid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import com.ss.android.lark.widget.photopickernew.grid.g;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import ldc.f;
import ldc.h;
import rdc.p;

/* JADX INFO: loaded from: classes38.dex */
public class GridComponent<DATA extends Photo> extends odc.a<DATA> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final odc.b<DATA, pdc.a<DATA, ? extends RecyclerView.ViewHolder>> f447818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f<List<DATA>, b> f447819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f<List<DATA>, b> f447820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f447821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GridPhotoAdapter<DATA> f447822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GridLayoutManager f447823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f447824i;

    public static final class a {
    }

    public interface b {
        void a(KClass<? extends odc.a<?>> r100, com.ss.android.lark.widget.photopickerimpl.bean.c r101);

        void b(com.ss.android.lark.widget.photopickerimpl.bean.c r100);
    }

    public static final class c implements CommonRecyclerView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridComponent<DATA> f447825a;

        public c(GridComponent<DATA> r100) {
            this.f447825a = r100;
        }

        @Override // com.ss.android.lark.widget.recyclerview.CommonRecyclerView.b
        public final void a(double r100) {
            Log.i(this.f447825a.f447821f, "current fps:" + r100);
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridComponent<DATA> f447826a;

        public d(GridComponent<DATA> r100) {
            this.f447826a = r100;
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.view.grid.GridComponent.b
        public final void b(com.ss.android.lark.widget.photopickerimpl.bean.c r100) {
            odc.a.InterfaceC7038a r101 = this.f447826a.f522914b;
            Intrinsics.checkNotNull(r101);
            r101.b(this.f447826a, r100);
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.view.grid.GridComponent.b
        public final void a(KClass<? extends odc.a<?>> r100, com.ss.android.lark.widget.photopickerimpl.bean.c r101) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.TO);
            GridComponent<DATA> r102 = this.f447826a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.TO);
            odc.a.InterfaceC7038a r103 = r102.f522914b;
            if (r103 == null) goto L6;
            r103.c(r100, r101);
            return;
        }
    }

    static {
    }

    @Override // odc.a
    public void b() {
        odc.a.InterfaceC7038a r100 = this.f522914b;
        Intrinsics.checkNotNull(r100);
        r100.d(this);
    }

    @Override // odc.a
    public final void d() {
        GridPhotoAdapter<DATA> r100 = this.f447822g;
        if (r100 == null) goto L8;
        Iterator<Map.Entry<Integer, pdc.a<DATA, ? extends RecyclerView.ViewHolder>>> r101 = r100.f447832c.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        r101.next().getValue().c();
        goto L6
    L10:
        return;
    }

    @Override // odc.a
    public final void f() {
        f<List<DATA>, b> r100 = this.f447819d;
        if (r100 == null) goto L5;
        r100.onStop();
    L5:
        f<List<DATA>, b> r101 = this.f447820e;
        if (r101 == null) goto L9;
        r101.onStop();
        return;
    }

    @Override // odc.a
    public final View c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.pp_grid_component_view, r100, false);
        Context r102 = r100.getContext();
        CommonRecyclerView r103 = (CommonRecyclerView) r101.findViewById(R.id.rv);
        r103.setSceneTag("album_gird_component");
        if (this.f447818c.getColumnCount() <= 0) goto L5;
        int r104 = this.f447818c.getColumnCount();
    L6:
        final GridLayoutManager r105 = new GridLayoutManager(r102, r104);
        final GridPhotoAdapter<DATA> r106 = new GridPhotoAdapter(this.f447818c);
        com.ss.android.lark.widget.photopickerimpl.view.grid.a r107 = new com.ss.android.lark.widget.photopickerimpl.view.grid.a(this, r106);
        Intrinsics.checkNotNullParameter(r107, "listener");
        r106.f447833d = r107;
        r103.setLayoutManager(r105);
        r103.setAdapter(r106);
        r103.addOnScrollListener(new GridComponent$onCreateView$1(this, r105, r106));
        r103.setFpsCallback(new c(this));
        this.f447822g = r106;
        this.f447823h = r105;
        ViewGroup r108 = (ViewGroup) r101.findViewById(R.id.fl_top_container);
        ViewGroup r109 = (ViewGroup) r101.findViewById(R.id.fl_bottom_container);
        d r110 = new d(this);
        f<List<DATA>, b> r111 = this.f447819d;
        if (r111 == null) goto L9;
        r111.d(r110);
    L9:
        f<List<DATA>, b> r112 = this.f447820e;
        if (r112 == null) goto L12;
        r112.d(r110);
    L12:
        f<List<DATA>, b> r113 = this.f447819d;
        if (r113 == null) goto L17;
        Intrinsics.checkNotNull(r108);
        View r114 = r113.b(r108);
        if (r114 == null) goto L17;
        r108.addView(r114);
    L17:
        f<List<DATA>, b> r115 = this.f447820e;
        if (r115 == null) goto L29;
        Intrinsics.checkNotNull(r109);
        View r116 = r115.b(r109);
        if (r116 == null) goto L29;
        r109.addView(r116);
        if (Intrinsics.areEqual(r116.getTag(R.id.layout_photo_insert_message_new), Boolean.TRUE) == false) goto L29;
        ViewGroup.LayoutParams r117 = r103.getLayoutParams();
        if ((r117 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r117;
    L27:
        if (r118 == null) goto L29;
        r118.bottomToTop = R.id.bottom_toolbar_content_anchor;
        r103.setLayoutParams(r118);
        goto L29
    L26:
        r118 = null;
    L29:
        this.f447824i = r101;
        r101.setVisibility(8);
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        r104 = 4;
        goto L6
    }

    @Override // odc.a
    public final void e(com.ss.android.lark.widget.photopickerimpl.bean.c r100) {
        View r101 = this.f447824i;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        f<List<DATA>, b> r102 = this.f447819d;
        if (r102 == null) goto L8;
        r102.onResume();
    L8:
        f<List<DATA>, b> r103 = this.f447820e;
        if (r103 == null) goto L12;
        r103.onResume();
        return;
    }

    @Override // odc.a
    public final void h(Map<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "dirInfos");
        f<List<DATA>, b> r101 = this.f447819d;
        if (r101 == null) goto L5;
        r101.c(r100);
    L5:
        f<List<DATA>, b> r102 = this.f447820e;
        if (r102 == null) goto L9;
        r102.c(r100);
        return;
    }

    public GridComponent(p r100, g r101, com.ss.android.lark.widget.photopickernew.grid.a r102) {
        Intrinsics.checkNotNullParameter(r100, "mFactory");
        this.f447818c = r100;
        this.f447819d = r101;
        this.f447820e = r102;
        this.f447821f = "PP_GridComponent";
    }

    @Override // odc.a
    public final void a(int r100, int r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
        f<List<DATA>, b> r103 = this.f447819d;
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.onActivityResult(r100, r101, r102) != true) goto L7;
    L8:
        if (r104 == false) goto L10;
        return;
    L10:
        f<List<DATA>, b> r105 = this.f447820e;
        if (r105 == null) goto L14;
        r105.onActivityResult(r100, r101, r102);
        return;
    L14:
        return;
    L7:
        r104 = false;
        goto L8
    }

    @Override // odc.a
    public final void g(List<DATA> r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r103 = h.f508886a;
        String r104 = this.f447821f;
        String r105 = " updateData size = " + r100.size() + " , append = " + r101;
        Intrinsics.checkNotNullParameter(r104, "tag");
        Intrinsics.checkNotNullParameter(r105, "msg");
        Intrinsics.checkNotNullParameter(r104, "tag");
        Intrinsics.checkNotNullParameter(r105, "msg");
        Log.i(r104, r105);
        GridPhotoAdapter<DATA> r106 = this.f447822g;
        if (r106 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "list");
        r106.f447831b.clear();
        r106.f447831b.addAll(r100);
        r106.notifyDataSetChanged();
    L5:
        f<List<DATA>, b> r107 = this.f447819d;
        if (r107 == null) goto L8;
        r107.a(r100);
    L8:
        f<List<DATA>, b> r108 = this.f447820e;
        if (r108 == null) goto L12;
        r108.a(r100);
        return;
    }
}
