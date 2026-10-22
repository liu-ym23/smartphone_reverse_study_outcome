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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lt7.d;
import my4.g;
import sbb.e;
import w85.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003()*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0016\u0010\u0015\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000bJ@\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0002J:\u0010&\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter$CoverImageViewHolder;", "containerWidth", "", "<init>", "(I)V", "mCoverItemList", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverItem;", "mCoverClickListener", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OnOfficialCoverClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "setData", "coverItemList", "", "setOnCoverClickListener", "listener", "driveLoadImage", "context", "Landroid/content/Context;", "token", "", "imageView", "Landroid/widget/ImageView;", "width", "height", "skeleton", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "priority", "renderCoverImage", "localPath", "ViewTarget", "CoverImageViewHolder", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoverImageAdapter extends RecyclerView.Adapter<CoverImageViewHolder> {
    public static final /* synthetic */ int d = 0;
    public final int a;
    public final List<OfficialCoverData.CoverItem> b;
    public g c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter$CoverImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter;Landroid/view/View;)V", "image", "Landroidx/appcompat/widget/AppCompatImageView;", "getImage", "()Landroidx/appcompat/widget/AppCompatImageView;", "setImage", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CoverImageViewHolder extends RecyclerView.ViewHolder {
        public final AppCompatImageView a;

        public CoverImageViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131368153);
        }
    }

    public static final class a {
    }

    public final class b extends SimpleTarget<Bitmap> {
        public final ImageView a;
        public final d b;

        public final void onLoadFailed(Drawable r2) {
            super/*com.bumptech.glide.request.target.BaseTarget*/.onLoadFailed(r2);
            this.b.a();
            this.a.setImageDrawable(r2);
        }

        public b(ImageView r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "img");
            Intrinsics.checkNotNullParameter(r3, "skeleton");
            this.a = r2;
            this.b = r3;
        }

        public final void onResourceReady(Object r2, Transition r3) {
            Bitmap r4 = (Bitmap) r2;
            Intrinsics.checkNotNullParameter(r4, "resource");
            this.b.a();
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.a.setImageBitmap(r4);
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public CoverImageAdapter(int r1) {
        this.a = r1;
        this.b = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        CoverImageViewHolder r13 = (CoverImageViewHolder) r11;
        Intrinsics.checkNotNullParameter(r13, "holder");
        OfficialCoverData.CoverItem r14 = (OfficialCoverData.CoverItem) ListProtector.get(this.b, r12);
        d.a r0 = u.a(r13.a);
        r0.a(2131103452);
        r0.b = 2131560078;
        d r8 = r0.b();
        View r1 = ((RecyclerView.ViewHolder) r13).itemView;
        int r2 = this.a;
        if (r2 > 0) goto L6;
        r2 = n.w(r1.getContext());
    L6:
        int r3 = r1.getResources().getDimensionPixelSize(2131165831);
        int r6 = (((r2 - r3) - r1.getResources().getDimensionPixelSize(2131165831)) - (r1.getResources().getDimensionPixelSize(2131165830) * 4)) / 4;
        int r7 = (int) (r6 * 0.68f);
        r1.setLayoutParams(new ViewGroup.LayoutParams(r6, r7));
        String r4 = r14.getToken();
        if (r4 == null) goto L10;
        Context r5 = ((RecyclerView.ViewHolder) r13).itemView.getContext();
        AppCompatImageView r9 = r13.a;
        Intrinsics.checkNotNull(r8);
        int r10 = r14.getPriority();
        my4.a r16 = new my4.a(this, r5, r9, r6, r7, r8);
        w85.a.C0319a r17 = new w85.a.C0319a();
        r17.a = true;
        r17.e = r4;
        r17.b = DownloadRequestInfo.DownloadType.COVER;
        r17.k = new DownloadRequestInfo.b(360, 360, "near", true);
        r17.g = ((f) org.koin.java.a.c(f.class, null, null, 6)).d(e.o.getType());
        r17.l = r10;
        r17.j = r16;
        ((c) org.koin.java.a.c(c.class, null, null, 6)).d(new w85.a(r17));
        r13.a.setOnClickListener(new com.bytedance.ee.bear.doc.cover.selectcover.official.a(this, r4, r14));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r4 = LayoutInflater.from(r2.getContext()).inflate(2131560073, null);
        Intrinsics.checkNotNull(r4);
        return new CoverImageViewHolder(r4);
    }
}
