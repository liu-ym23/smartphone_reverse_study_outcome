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
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0004)*+,B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tJ\b\u0010\u001e\u001a\u00020\u001aH\u0007J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\tH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pageCount", "", "pageSizeF", "Landroid/util/SizeF;", "pageLoader", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/IPDFPageLoader;", "selectedPage", "thumbAdapter", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView$PDFThumbnailAdapter;", "spanCount", "thumbSpacing", "viewDelegate", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView$ViewDelegate;)V", "updatePageSize", "", "init", "setSelected", "page", "notifyItem", "setVisible", "visible", "", "initView", "gridSpacing", "addScrollListener", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "PDFThumbnailAdapter", "PageViewHolder", "ViewDelegate", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFThumbnailView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f225281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SizeF f225282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a f225283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f225284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f225285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f225286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f225287g;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PDFThumbnailView f225289a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f225289a.f225281a;
        }

        public b(PDFThumbnailView r100) {
            this.f225289a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            t0.b(r102.f225290a, this.f225289a.f225286f);
            r102.f225292c.setText(String.valueOf(r101 + 1));
            TextView r103 = r102.f225292c;
            if (r101 != this.f225289a.f225284d) goto L5;
            boolean r104 = true;
        L6:
            r103.setSelected(r104);
            r102.f225290a.setOnClickListener(new s0(this.f225289a, r101));
            RelativeLayout r105 = r102.f225290a;
            SizeF r106 = this.f225289a.f225282b;
            if (r106 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("pageSizeF");
            r106 = null;
        L9:
            SizeF r107 = t0.a(r105, r106);
            com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a r108 = this.f225289a.f225283c;
            if (r108 == null) goto L13;
            r108.b(r102.f225291b, new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a.C3240a(r101, (int) r107.getWidth(), (int) r107.getHeight(), new RectF(0.0f, 0.0f, 1.0f, 1.0f)));
            return;
        L13:
            return;
        L5:
            r104 = false;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new c(LayoutInflater.from(r100.getContext()).inflate(R.layout.drive_controls_thumbnails_view_grid_item, r100, false));
        }
    }

    public static final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RelativeLayout f225290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f225291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f225292c;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f225290a = (RelativeLayout) r100.findViewById(R.id.item_image_layout);
            this.f225291b = (ImageView) r100.findViewById(R.id.item_image);
            this.f225292c = (TextView) r100.findViewById(R.id.item_text);
        }
    }

    public interface d {
        void onItemClick(int r100);
    }

    static {
    }

    public final d getViewDelegate() {
        return this.f225287g;
    }

    public final void setSelected(int r100) {
        if (getVisibility() != 8) goto L5;
        return;
    L5:
        if (r100 >= 0) goto L7;
        return;
    L7:
        if (r100 >= this.f225281a) goto L15;
        int r101 = this.f225284d;
        this.f225284d = r100;
        this.f225285e.notifyItemChanged(r101);
        this.f225285e.notifyItemChanged(r100);
        RecyclerView.LayoutManager r102 = getLayoutManager();
        if (r102 == null) goto L14;
        r102.scrollToPosition(r100);
        return;
    L14:
        return;
    }

    public final void setViewDelegate(d r100) {
        this.f225287g = r100;
    }

    public final void setVisible(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public PDFThumbnailView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f225284d = -1;
        b r102 = new b(this);
        this.f225285e = r102;
        this.f225286f = 3;
        int r103 = com.bytedance.ee.util.ui.n.d(4);
        setHasFixedSize(true);
        setLayoutManager(new GridLayoutManager(getContext(), 3));
        addItemDecoration(new PDFThumbnailItemDecoration(r103));
        setAdapter(r102);
        setNestedScrollingEnabled(false);
        addOnScrollListener(new PDFThumbnailView$addScrollListener$1(this));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (Intrinsics.areEqual(r100, this) == false) goto L9;
        if (r101 == 0) goto L10;
        tt5.a.h("PDFThumbnailView", "PDFThumbnailView.GONE, cancel all thumbnail request. ");
        com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a r102 = this.f225283c;
        if (r102 == null) goto L11;
        r102.a();
        return;
    L11:
        return;
    L10:
        return;
    }
}
