package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SizeF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0004)*+,B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tJ\b\u0010\u001e\u001a\u00020\u001aH\u0007J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\tH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pageCount", "", "pageSizeF", "Landroid/util/SizeF;", "pageLoader", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/IPDFPageLoader;", "selectedPage", "thumbAdapter", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView$PDFThumbnailAdapter;", "spanCount", "thumbSpacing", "viewDelegate", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView$ViewDelegate;)V", "updatePageSize", "", "init", "setSelected", "page", "notifyItem", "setVisible", "visible", "", "initView", "gridSpacing", "addScrollListener", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "PDFThumbnailAdapter", "PageViewHolder", "ViewDelegate", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFThumbnailView extends RecyclerView {
    public int a;
    public SizeF b;
    public com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a c;
    public int d;
    public final b e;
    public final int f;
    public d g;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {
        public final /* synthetic */ PDFThumbnailView a;

        public final int getItemCount() {
            return this.a.a;
        }

        public b(PDFThumbnailView r1) {
            this.a = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            c r10 = (c) r8;
            Intrinsics.checkNotNullParameter(r10, "holder");
            t0.b(r10.a, this.a.f);
            r10.c.setText(String.valueOf(r9 + 1));
            TextView r0 = r10.c;
            if (r9 != this.a.d) goto L5;
            boolean r1 = true;
        L6:
            r0.setSelected(r1);
            r10.a.setOnClickListener(new s0(this.a, r9));
            RelativeLayout r2 = r10.a;
            SizeF r3 = this.a.b;
            if (r3 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("pageSizeF");
            r3 = null;
        L9:
            SizeF r4 = t0.a(r2, r3);
            com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a r5 = this.a.c;
            if (r5 == null) goto L13;
            r5.b(r10.b, new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a.C0184a(r9, (int) r4.getWidth(), (int) r4.getHeight(), new RectF(0.0f, 0.0f, 1.0f, 1.0f)));
            return;
        L13:
            return;
        L5:
            r1 = false;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            return new c(LayoutInflater.from(r3.getContext()).inflate(2131560186, r3, false));
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final RelativeLayout a;
        public final ImageView b;
        public final TextView c;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (RelativeLayout) r2.findViewById(2131375776);
            this.b = (ImageView) r2.findViewById(2131375775);
            this.c = (TextView) r2.findViewById(2131375863);
        }
    }

    public interface d {
        void onItemClick(int r1);
    }

    static {
    }

    public final d getViewDelegate() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSelected(int r3) {
        if (getVisibility() != 8) goto L5;
        return;
    L5:
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 >= this.a) goto L15;
        int r0 = this.d;
        this.d = r3;
        this.e.notifyItemChanged(r0);
        this.e.notifyItemChanged(r3);
        RecyclerView.LayoutManager r1 = getLayoutManager();
        if (r1 == null) goto L14;
        r1.scrollToPosition(r3);
        return;
    L14:
        return;
    }

    public final void setViewDelegate(d r1) {
        this.g = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setVisible(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PDFThumbnailView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.d = -1;
        b r6 = new b(this);
        this.e = r6;
        this.f = 3;
        int r0 = com.bytedance.ee.util.ui.n.d(4);
        setHasFixedSize(true);
        setLayoutManager(new GridLayoutManager(getContext(), 3));
        addItemDecoration(new PDFThumbnailItemDecoration(r0));
        setAdapter(r6);
        setNestedScrollingEnabled(false);
        addOnScrollListener(new PDFThumbnailView$addScrollListener$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super/*android.view.ViewGroup*/.onVisibilityChanged(r2, r3);
        if (Intrinsics.areEqual(r2, this) == false) goto L9;
        if (r3 == 0) goto L10;
        tt5.a.h("PDFThumbnailView", "PDFThumbnailView.GONE, cancel all thumbnail request. ");
        com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a r4 = this.c;
        if (r4 == null) goto L11;
        r4.a();
        return;
    L11:
        return;
    L10:
        return;
    }
}
