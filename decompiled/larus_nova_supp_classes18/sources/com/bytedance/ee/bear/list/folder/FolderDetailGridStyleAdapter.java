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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import uc5.l3;
import uc5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderDetailGridStyleAdapter extends GridStyleAdapter {
    public static final /* synthetic */ int j = 0;
    public l3 h;
    public boolean i;

    public class a extends t {
        public final /* synthetic */ BaseViewHolder c;
        public final /* synthetic */ Document d;
        public final /* synthetic */ FolderDetailGridStyleAdapter e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            FolderDetailGridStyleAdapter r0 = this.e;
            int r1 = FolderDetailGridStyleAdapter.j;
            if (r0.b == null) goto L6;
            int r2 = this.c.getLayoutPosition() - this.e.getHeaderLayoutCount();
            this.e.b.D(r5, r2, this.d, true);
            return;
        }

        public a(FolderDetailGridStyleAdapter r1, BaseViewHolder r2, Document r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final boolean A2() {
        if (this.i == false) goto L6;
        return false;
    L6:
        return true;
    }

    public final int getDefItemViewType(int r3) {
        Document r0 = (Document) getItem(r3);
        if (r0 != null) goto L7;
        tt5.a.h("FolderDetailGridStyleAdapter", "getDefItemViewType()...document is null, position = " + r3);
        return 0;
    L7:
        if (r0.p1 == false) goto L9;
        return 11;
    L9:
        return 33;
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        z2(r1, (Document) r2);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r4, int r5) {
        if (r5 != 33) goto L7;
        return new NoPermissionGridStyleViewHolder(LayoutInflater.from(((BaseQuickAdapter) this).mContext).inflate(2131563507, r4, false));
    L7:
        return super.onCreateDefViewHolder(r4, r5);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final void z2(BaseViewHolder r4, Document r5) {
        super.z2(r4, r5);
        if ((r4 instanceof NoPermissionGridStyleViewHolder) == false) goto L6;
        NoPermissionGridStyleViewHolder r0 = (NoPermissionGridStyleViewHolder) r4;
        r0.b.setImageResource(kac.a.b(2131254659));
        r0.a.setVisibility(0);
        r0.a.setTag(r5);
        r0.a.setOnClickListener(new a(this, r4, r5));
        return;
    }

    public FolderDetailGridStyleAdapter(String r1, boolean r2, ce5.a r3) {
        super(r1, r3);
        this.i = r2;
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final void y2(GridStyleViewHolder r3, Document r4, int r5) {
        super.y2(r3, r4, r5);
        AppCompatImageView r6 = r3.j;
        int r1 = 0;
        if (this.d == true) goto L5;
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
        r6.setOnClickListener(new n(this, r5, r4));
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
}
