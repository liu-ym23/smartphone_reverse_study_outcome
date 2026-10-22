package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.list.list.NoPermissionListStyleViewHolder;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.l;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import uc5.l3;
import uc5.o;

/* JADX INFO: loaded from: classes18.dex */
public class FolderDetailListStyleAdapter extends ListStyleAdapter {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f227966q = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l3 f227967o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f227968p;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FolderDetailListStyleAdapter f227969c;

        public a(FolderDetailListStyleAdapter r100) {
            this.f227969c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Toast.showText(FolderDetailListStyleAdapter.I2(this.f227969c), R.string.Doc_Permission_DeleteNoPermission);
            this.f227969c.D2();
        }
    }

    public class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f227970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Document f227971d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FolderDetailListStyleAdapter f227972e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            FolderDetailListStyleAdapter r101 = this.f227972e;
            int r102 = FolderDetailListStyleAdapter.f227966q;
            if (r101.f228481b == null) goto L6;
            int r103 = this.f227970c.getLayoutPosition() - this.f227972e.getHeaderLayoutCount();
            this.f227972e.f228481b.D(r100, r103, this.f227971d, false);
            return;
        }

        public b(FolderDetailListStyleAdapter r100, BaseViewHolder r101, Document r102) {
            this.f227972e = r100;
            this.f227970c = r101;
            this.f227971d = r102;
        }
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final boolean F2() {
        if (this.f227968p == false) goto L6;
        return false;
    L6:
        return true;
    }

    public static /* synthetic */ Context I2(FolderDetailListStyleAdapter r100) {
        return r100.mContext;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final int getDefItemViewType(int r100) {
        Document r101 = getItem(r100);
        if (r101 != null) goto L7;
        tt5.a.h("FolderDetailListStyleAdapter", "getDefItemViewType()...document is null, position = " + r100);
        return 0;
    L7:
        if (r101.f227893p1 == false) goto L9;
        return 11;
    L9:
        return 33;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void E2(BaseViewHolder r100, Document r101) {
        super.E2(r100, r101);
        if ((r100 instanceof NoPermissionListStyleViewHolder) == false) goto L6;
        NoPermissionListStyleViewHolder r102 = (NoPermissionListStyleViewHolder) r100;
        r102.f228523a.setVisibility(0);
        r102.f228523a.setTag(r101);
        r102.f228523a.setOnClickListener(new b(this, r100, r101));
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Document r101) {
        E2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        if (r101 != 33) goto L7;
        return new NoPermissionListStyleViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.list_no_permission_item_content_list_style, r100, false));
    L7:
        return super.onCreateDefViewHolder(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r100, Document r101) {
        if (this.f228487h != FolderSort.CREATED_TIME.getRank()) goto L5;
        r100.f228502d.setText(t0.C(this.mContext, r101));
        return;
    L5:
        r100.f228502d.setText(t0.D(this.mContext, r101));
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void A2(ListStyleViewHolder r100, Document r101, int r102) {
        super.A2(r100, r101, r102);
        AppCompatImageView r103 = r100.f228513o;
        int r104 = 0;
        if (this.f228485f == true) goto L5;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == true) goto L13;
        r104 = 8;
    L13:
        r103.setVisibility(r104);
        r103.setImageResource(R.drawable.ud_icon_warning_outlined);
        if (t0.w(r101, this.f228480a) == false) goto L16;
        int r106 = R.color.primary_fill_default;
    L17:
        l.c(r103, r106);
        r103.setOnClickListener(new o(this, r102, r101));
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

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r100, int r101, Document r102) {
        super.B2(r100, r101, r102);
        if (r102.b() == false) goto L5;
        return;
    L5:
        String[] r103 = t0.f229767a;
        boolean r104 = true;
        if (FolderVersion.isShareFolderV1(r102.L1) == true) goto L8;
    L13:
        if (r104 == false) goto L15;
        r100.f228508j.setAlpha(1.0f);
        return;
    L15:
        r100.f228508j.setAlpha(0.3f);
        r100.f228508j.setOnClickListener(new a(this));
        return;
    L8:
        if (qc5.a.b(r102.L1) == true) goto L13;
        if (r102.U > 1) goto L13;
        r104 = false;
        goto L13
    }

    public FolderDetailListStyleAdapter(String r100, String r101, DocsLinearLayoutManager r102, boolean r110, ce5.a r111) {
        super(r100, r101, r102, r111, null);
        this.f227968p = r110;
    }
}
