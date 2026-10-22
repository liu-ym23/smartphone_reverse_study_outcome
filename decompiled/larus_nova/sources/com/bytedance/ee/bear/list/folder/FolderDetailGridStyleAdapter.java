package com.bytedance.ee.bear.list.folder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.list.GridStyleViewHolder;
import com.bytedance.ee.bear.list.list.NoPermissionGridStyleViewHolder;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.l;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import uc5.l3;
import uc5.n;

/* JADX INFO: loaded from: classes18.dex */
public class FolderDetailGridStyleAdapter extends GridStyleAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f227958j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l3 f227959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f227960i;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f227961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Document f227962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FolderDetailGridStyleAdapter f227963e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            FolderDetailGridStyleAdapter r101 = this.f227963e;
            int r102 = FolderDetailGridStyleAdapter.f227958j;
            if (r101.f228456b == null) goto L6;
            int r103 = this.f227961c.getLayoutPosition() - this.f227963e.getHeaderLayoutCount();
            this.f227963e.f228456b.D(r100, r103, this.f227962d, true);
            return;
        }

        public a(FolderDetailGridStyleAdapter r100, BaseViewHolder r101, Document r102) {
            this.f227963e = r100;
            this.f227961c = r101;
            this.f227962d = r102;
        }
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final boolean A2() {
        if (this.f227960i == false) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final int getDefItemViewType(int r100) {
        Document r101 = getItem(r100);
        if (r101 != null) goto L7;
        tt5.a.h("FolderDetailGridStyleAdapter", "getDefItemViewType()...document is null, position = " + r100);
        return 0;
    L7:
        if (r101.f227893p1 == false) goto L9;
        return 11;
    L9:
        return 33;
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Document r101) {
        z2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        if (r101 != 33) goto L7;
        return new NoPermissionGridStyleViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.list_no_permission_item_content_grid_style, r100, false));
    L7:
        return super.onCreateDefViewHolder(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final void z2(BaseViewHolder r100, Document r101) {
        super.z2(r100, r101);
        if ((r100 instanceof NoPermissionGridStyleViewHolder) == false) goto L6;
        NoPermissionGridStyleViewHolder r102 = (NoPermissionGridStyleViewHolder) r100;
        r102.f228522b.setImageResource(kac.a.b(R.drawable.ud_icon_file_round_nopermission_colorful));
        r102.f228521a.setVisibility(0);
        r102.f228521a.setTag(r101);
        r102.f228521a.setOnClickListener(new a(this, r100, r101));
        return;
    }

    public FolderDetailGridStyleAdapter(String r100, boolean r101, ce5.a r102) {
        super(r100, r102);
        this.f227960i = r101;
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final void y2(GridStyleViewHolder r100, Document r101, int r102) {
        super.y2(r100, r101, r102);
        AppCompatImageView r103 = r100.f228477j;
        int r104 = 0;
        if (this.f228458d == true) goto L5;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == true) goto L13;
        r104 = 8;
    L13:
        r103.setVisibility(r104);
        r103.setImageResource(R.drawable.ud_icon_warning_outlined);
        if (t0.w(r101, this.f228455a) == false) goto L16;
        int r106 = R.color.primary_fill_default;
    L17:
        l.c(r103, r106);
        r103.setOnClickListener(new n(this, r102, r101));
        return;
    L16:
        r106 = R.color.icon_disable;
        goto L17
    L5:
        if (FolderVersion.isShareFolderV1(r101.L1) == false) goto L9;
        if (r101.f227901v1 == false) goto L9;
        r105 = true;
        goto L10
    }
}
