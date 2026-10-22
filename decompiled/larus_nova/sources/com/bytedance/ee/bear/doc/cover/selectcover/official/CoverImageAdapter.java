package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.ee.bear.f;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.widgets.u;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lt7.d;
import my4.g;
import sbb.e;
import w85.c;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003()*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0016\u0010\u0015\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000bJ@\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0002J:\u0010&\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter$CoverImageViewHolder;", "containerWidth", "", "<init>", "(I)V", "mCoverItemList", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverItem;", "mCoverClickListener", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OnOfficialCoverClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "setData", "coverItemList", "", "setOnCoverClickListener", "listener", "driveLoadImage", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "token", "", "imageView", "Landroid/widget/ImageView;", "width", "height", "skeleton", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "priority", "renderCoverImage", "localPath", "ViewTarget", "CoverImageViewHolder", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoverImageAdapter extends RecyclerView.Adapter<CoverImageViewHolder> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f217821d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f217822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<OfficialCoverData.CoverItem> f217823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f217824c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter$CoverImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter;Landroid/view/View;)V", "image", "Landroidx/appcompat/widget/AppCompatImageView;", "getImage", "()Landroidx/appcompat/widget/AppCompatImageView;", "setImage", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CoverImageViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatImageView f217825a;

        public CoverImageViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f217825a = (AppCompatImageView) r100.findViewById(R.id.cover_image);
        }
    }

    public static final class a {
    }

    public final class b extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f217826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f217827b;

        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            this.f217827b.a();
            this.f217826a.setImageDrawable(r100);
        }

        public b(ImageView r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "img");
            Intrinsics.checkNotNullParameter(r101, "skeleton");
            this.f217826a = r100;
            this.f217827b = r101;
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onResourceReady(Object r100, Transition r101) {
            Bitmap r102 = (Bitmap) r100;
            Intrinsics.checkNotNullParameter(r102, "resource");
            this.f217827b.a();
            this.f217826a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f217826a.setImageBitmap(r102);
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f217823b).size();
    }

    public CoverImageAdapter(int r100) {
        this.f217822a = r100;
        this.f217823b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        CoverImageViewHolder r112 = (CoverImageViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        OfficialCoverData.CoverItem r113 = (OfficialCoverData.CoverItem) ListProtector.get(this.f217823b, r111);
        d.a r100 = u.a(r112.f217825a);
        r100.a(R.color.lkui_N200);
        r100.f510707b = R.layout.doc_cover_skeleton_view;
        d r101 = r100.b();
        View r102 = r112.itemView;
        int r103 = this.f217822a;
        if (r103 > 0) goto L6;
        r103 = n.w(r102.getContext());
    L6:
        int r104 = r102.getResources().getDimensionPixelSize(R.dimen.doc_cover_padding);
        int r105 = (((r103 - r104) - r102.getResources().getDimensionPixelSize(R.dimen.doc_cover_padding)) - (r102.getResources().getDimensionPixelSize(R.dimen.doc_cover_item_space) * 4)) / 4;
        int r106 = (int) (r105 * 0.68f);
        r102.setLayoutParams(new ViewGroup.LayoutParams(r105, r106));
        String r107 = r113.getToken();
        if (r107 == null) goto L10;
        Context r108 = r112.itemView.getContext();
        AppCompatImageView r109 = r112.f217825a;
        Intrinsics.checkNotNull(r101);
        int r114 = r113.getPriority();
        my4.a r115 = new my4.a(this, r108, r109, r105, r106, r101);
        w85.a.C8081a r116 = new w85.a.C8081a();
        r116.f558639a = true;
        r116.f558643e = r107;
        r116.f558640b = DownloadRequestInfo.DownloadType.COVER;
        r116.f558649k = new DownloadRequestInfo.b(360, 360, "near", true);
        r116.f558645g = ((f) org.koin.java.a.c(f.class, null, null, 6)).d(e.f541304o.getType());
        r116.f558650l = r114;
        r116.f558648j = r115;
        ((c) org.koin.java.a.c(c.class, null, null, 6)).d(new w85.a(r116));
        r112.f217825a.setOnClickListener(new com.bytedance.ee.bear.doc.cover.selectcover.official.a(this, r107, r113));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_cover_image_item, null);
        Intrinsics.checkNotNull(r102);
        return new CoverImageViewHolder(r102);
    }
}
