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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import uc5.l3;
import uc5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderDetailListStyleAdapter extends ListStyleAdapter {
    public static final /* synthetic */ int q = 0;
    public l3 o;
    public boolean p;

    public class a extends t {
        public final /* synthetic */ FolderDetailListStyleAdapter c;

        public a(FolderDetailListStyleAdapter r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            Toast.showText(FolderDetailListStyleAdapter.I2(this.c), 2131888085);
            this.c.D2();
        }
    }

    public class b extends t {
        public final /* synthetic */ BaseViewHolder c;
        public final /* synthetic */ Document d;
        public final /* synthetic */ FolderDetailListStyleAdapter e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            FolderDetailListStyleAdapter r0 = this.e;
            int r1 = FolderDetailListStyleAdapter.q;
            if (r0.b == null) goto L6;
            int r2 = this.c.getLayoutPosition() - this.e.getHeaderLayoutCount();
            this.e.b.D(r5, r2, this.d, false);
            return;
        }

        public b(FolderDetailListStyleAdapter r1, BaseViewHolder r2, Document r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final boolean F2() {
        if (this.p == false) goto L6;
        return false;
    L6:
        return true;
    }

    public static /* synthetic */ Context I2(FolderDetailListStyleAdapter r0) {
        return ((BaseQuickAdapter) r0).mContext;
    }

    public final int getDefItemViewType(int r3) {
        Document r0 = (Document) getItem(r3);
        if (r0 != null) goto L7;
        tt5.a.h("FolderDetailListStyleAdapter", "getDefItemViewType()...document is null, position = " + r3);
        return 0;
    L7:
        if (r0.p1 == false) goto L9;
        return 11;
    L9:
        return 33;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void E2(BaseViewHolder r4, Document r5) {
        super.E2(r4, r5);
        if ((r4 instanceof NoPermissionListStyleViewHolder) == false) goto L6;
        NoPermissionListStyleViewHolder r0 = (NoPermissionListStyleViewHolder) r4;
        r0.a.setVisibility(0);
        r0.a.setTag(r5);
        r0.a.setOnClickListener(new b(this, r4, r5));
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        E2(r1, (Document) r2);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r4, int r5) {
        if (r5 != 33) goto L7;
        return new NoPermissionListStyleViewHolder(LayoutInflater.from(((BaseQuickAdapter) this).mContext).inflate(2131563508, r4, false));
    L7:
        return super.onCreateDefViewHolder(r4, r5);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r3, Document r4) {
        if (this.h != FolderSort.CREATED_TIME.getRank()) goto L5;
        r3.d.setText(t0.C(((BaseQuickAdapter) this).mContext, r4));
        return;
    L5:
        r3.d.setText(t0.D(((BaseQuickAdapter) this).mContext, r4));
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void A2(ListStyleViewHolder r3, Document r4, int r5) {
        super.A2(r3, r4, r5);
        AppCompatImageView r6 = r3.o;
        int r1 = 0;
        if (this.f == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L13;
        r1 = 8;
    L13:
        r6.setVisibility(r1);
        r6.setImageResource(2131256189);
        if (t0.w(r4, this.a) == false) goto L16;
        int r2 = 2131105548;
    L17:
        l.c(r6, r2);
        r6.setOnClickListener(new o(this, r5, r4));
        return;
    L16:
        r2 = 2131102416;
        goto L17
    L5:
        if (FolderVersion.isShareFolderV1(r4.L1) == false) goto L9;
        if (r4.v1 == false) goto L9;
        r0 = true;
        goto L10
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r2, int r3, Document r4) {
        super.B2(r2, r3, r4);
        if (r4.b() == false) goto L5;
        return;
    L5:
        String[] r5 = t0.a;
        boolean r0 = true;
        if (FolderVersion.isShareFolderV1(r4.L1) == true) goto L8;
    L13:
        if (r0 == false) goto L15;
        r2.j.setAlpha(1.0f);
        return;
    L15:
        r2.j.setAlpha(0.3f);
        r2.j.setOnClickListener(new a(this));
        return;
    L8:
        if (qc5.a.b(r4.L1) == true) goto L13;
        if (r4.U > 1) goto L13;
        r0 = false;
        goto L13
    }

    public FolderDetailListStyleAdapter(String r7, String r8, DocsLinearLayoutManager r9, boolean r10, ce5.a r11) {
        super(r7, r8, r9, r11, null);
        this.p = r10;
    }
}
