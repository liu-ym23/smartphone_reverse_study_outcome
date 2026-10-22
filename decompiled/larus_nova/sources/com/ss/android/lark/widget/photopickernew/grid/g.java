package com.ss.android.lark.widget.photopickernew.grid;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photopickerimpl.view.grid.GridComponent;
import com.ss.android.lark.widget.photopickernew.storage.PhotoPartialStoragePermissionNotice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rdc.q;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements ldc.f<List<t>, GridComponent.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f447932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f447933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GridComponent.b f447934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f447935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f447936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f447937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ListPopupWindow f447938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PhotoPartialStoragePermissionNotice f447939h;

    public static final class a {
    }

    public interface b {
    }

    public static final class c implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f447940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<com.ss.android.lark.widget.photopickerimpl.bean.b> f447941b;

        public c(g r100, List<com.ss.android.lark.widget.photopickerimpl.bean.b> r101) {
            this.f447940a = r100;
            this.f447941b = r101;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
            b r104 = this.f447940a.f447933b;
            int r105 = ((com.ss.android.lark.widget.photopickerimpl.bean.b) ListProtector.get(this.f447941b, r102)).f447751a;
            String r106 = ((com.ss.android.lark.widget.photopickerimpl.bean.b) ListProtector.get(this.f447941b, r102)).f447752b;
            com.ss.android.lark.widget.photopickerimpl.model.c r107 = ((q) r104).f537376b;
            r107.getClass();
            if (r105 != 4096) goto L6;
            r106 = null;
        L6:
            if (Intrinsics.areEqual(r106, r107.f447789h) == true) goto L8;
        L11:
            boolean r108 = true;
        L12:
            r107.f447790i = r105;
            r107.f447789h = r106;
            if (r108 == false) goto L15;
            r107.g(r106, r105);
        L15:
            Button r109 = this.f447940a.f447936e;
            if (r109 == null) goto L18;
            r109.setText(((com.ss.android.lark.widget.photopickerimpl.bean.b) ListProtector.get(this.f447941b, r102)).f447752b);
        L18:
            ListPopupWindow r110 = this.f447940a.f447938g;
            if (r110 == null) goto L22;
            r110.dismiss();
            return;
        L22:
            return;
        L8:
            if (r105 != r107.f447790i) goto L11;
            r108 = false;
            goto L12
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f447942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<com.ss.android.lark.widget.photopickerimpl.bean.b> f447943b;

        public d(g r100, List<com.ss.android.lark.widget.photopickerimpl.bean.b> r101) {
            this.f447942a = r100;
            this.f447943b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            g r101 = this.f447942a;
            ListPopupWindow r102 = r101.f447938g;
            if (r102 == null) goto L22;
            List<com.ss.android.lark.widget.photopickerimpl.bean.b> r103 = this.f447943b;
            if (r102.isShowing() == false) goto L8;
            r102.dismiss();
            return;
        L8:
            if (r101.f447932a.isFinishing() == true) goto L24;
            int r104 = r103.size();
            if (r104 >= 0) goto L12;
        L14:
            boolean r105 = false;
        L15:
            if (r105 == false) goto L17;
            int r106 = -2;
        L18:
            r102.setHeight(r106);
            r102.setWidth(-1);
            r102.setDropDownGravity(48);
            r102.setBackgroundDrawable(UIHelper.getDrawable(R.drawable.__picker_bg_bottom_shadow));
            r102.show();
            ListView r107 = r102.getListView();
            if (r107 == null) goto L25;
            r107.setOverScrollMode(2);
            return;
        L25:
            return;
        L17:
            r106 = r101.f447932a.getResources().getDimensionPixelOffset(R.dimen.__picker_item_directory_height) * 6;
            goto L18
        L12:
            if (r104 >= 7) goto L14;
            r105 = true;
            goto L15
        L24:
            return;
        }
    }

    public static final class e implements StoragePermissionUtils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f447944a;

        public e(g r100) {
            this.f447944a = r100;
        }

        @Override // com.ss.android.lark.permission.StoragePermissionUtils.a
        public final void b(StoragePermissionUtils.c r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            int r101 = r100.f438544a;
            if (r101 != 0) goto L5;
        L6:
            q r102 = (q) this.f447944a.f447933b;
            if (r102.f537377c.getActivity() == null) goto L11;
            r102.f537377c.getActivity().recreate();
            return;
        L11:
            return;
        L5:
            if (r101 == 1) goto L6;
        }
    }

    static {
    }

    @Override // ldc.f
    public final boolean onActivityResult(int r100, int r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
        return false;
    }

    @Override // ldc.f
    public final void onResume() {
    }

    @Override // ldc.f
    public final void onStop() {
    }

    @Override // ldc.f
    public final void a(List<t> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ImageView r101 = this.f447935d;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new h(this));
        return;
    }

    @Override // ldc.f
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.photo_picker_new_grid_top_tool, r100, false);
        this.f447935d = (ImageView) r101.findViewById(R.id.btn_back);
        this.f447936e = (Button) r101.findViewById(R.id.button);
        this.f447937f = r101.findViewById(R.id.popup_anchor);
        this.f447939h = (PhotoPartialStoragePermissionNotice) r101.findViewById(R.id.partial_permission_notice);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    @Override // ldc.f
    public final void c(Map<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "dirInfos");
        Set<Map.Entry<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b>> r111 = r110.entrySet();
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L6;
        r100.add((com.ss.android.lark.widget.photopickerimpl.bean.b) ((Map.Entry) r112.next()).getValue());
        goto L4
    L6:
        i r113 = new i(r100);
        ListPopupWindow r101 = new ListPopupWindow(this.f447932a);
        r101.setAdapter(r113);
        r101.setAnchorView(this.f447937f);
        r101.setModal(true);
        r101.setOnItemClickListener(new c(this, r100));
        this.f447938g = r101;
        Button r102 = this.f447936e;
        if (r102 == null) goto L9;
        r102.setOnClickListener(new d(this, r100));
    L9:
        PhotoPartialStoragePermissionNotice r103 = this.f447939h;
        int r104 = 4;
        if (r103 == null) goto L21;
        Activity r105 = this.f447932a;
        int r106 = 0;
        String[] r107 = new String[0];
        HashMap r108 = new HashMap();
        int r109 = StoragePermissionUtils.a(r105, StoragePermissionUtils.d(r105, 2));
        StoragePermissionUtils.a(r105, StoragePermissionUtils.d(r105, 4));
        StoragePermissionUtils.d(r105, 8);
        StoragePermissionUtils.e(r105);
        int r114 = r107.length;
        int r115 = 0;
    L12:
        if (r115 >= r114) goto L14;
        String r116 = r107[r115];
        r108.put(r116, Boolean.valueOf(com.ss.android.lark.permission.a.a(r105, r116)));
        r115 = r115 + 1;
        goto L12
    L14:
        if (r109 != 1) goto L16;
        boolean r117 = true;
    L17:
        if (r117 == true) goto L20;
        r106 = 8;
    L20:
        r103.setVisibility(r106);
        goto L21
    L16:
        r117 = false;
    L21:
        PhotoPartialStoragePermissionNotice r118 = this.f447939h;
        if (r118 == null) goto L30;
        int r119 = ((q) this.f447933b).f537377c.f447877f.f447557b;
        if (r119 != 0) goto L26;
        r104 = 2;
    L29:
        r118.setMediaType(r104);
        goto L30
    L26:
        if (r119 == 1) goto L29;
        r104 = 6;
    L30:
        PhotoPartialStoragePermissionNotice r120 = this.f447939h;
        if (r120 == null) goto L36;
        r120.setOnUserSelectResultListener(new e(this));
        return;
    }

    @Override // ldc.f
    public final void d(GridComponent.b r100) {
        this.f447934c = r100;
    }

    public g(FragmentActivity r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "support");
        this.f447932a = r100;
        this.f447933b = r101;
    }
}
