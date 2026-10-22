package com.bytedance.ee.bear.drive.core.thumbnail;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import com.bytedance.lark.lark_markdown_render_android.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0006\u0010\u0019\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/DrivePreviewThumbnailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/bytedance/ee/bear/drive/core/thumbnail/DrivePreviewThumbnailItem;", "onItemClick", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "imageProvider", "Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailImageProvider;", "placeholder", "Landroid/graphics/drawable/ColorDrawable;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "onViewRecycled", BuildConfig.BUILD_TYPE, "Companion", "ViewHolder", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewThumbnailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<f> a;
    public final Function1<Integer, Unit> b;
    public final DriveThumbnailImageProvider c;
    public final ColorDrawable d;

    public static final class a {
    }

    public final class b extends RecyclerView.ViewHolder {
        public final ImageView a;
        public int b;
        public Disposable c;
        public final /* synthetic */ DrivePreviewThumbnailAdapter d;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ DrivePreviewThumbnailAdapter b;

            public a(b r1, DrivePreviewThumbnailAdapter r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                int r3 = this.a.getBindingAdapterPosition();
                if (r3 == (-1)) goto L6;
                this.b.b.invoke(Integer.valueOf(r3));
                return;
            }
        }

        public final Activity T3(Context r2) {
            if ((r2 instanceof Activity) == false) goto L6;
            return (Activity) r2;
        L6:
            if ((r2 instanceof ContextWrapper) == true) goto L11;
            return null;
        L11:
            return T3(((ContextWrapper) r2).getBaseContext());
        }

        public b(DrivePreviewThumbnailAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.d = r2;
            super(r3);
            this.a = (ImageView) r3.findViewById(2131370334);
            this.b = -1;
            r3.setOnClickListener(new a(this, r2));
        }
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r7) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        if ((r7 instanceof b) == false) goto L5;
        b r0 = (b) r7;
    L6:
        if (r0 == null) goto L28;
        r0.b = -1;
        Disposable r2 = r0.c;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        r0.c = null;
        ImageView r1 = r0.a;
        Activity r3 = r0.T3(r1.getContext());
        boolean r4 = true;
        if (r3 != null) goto L13;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L21;
    L23:
        r4 = false;
    L24:
        if (r4 == false) goto L26;
        Glide.with(r0.a).clear(r0.a);
    L27:
        r0.a.setImageDrawable(r0.d.d);
        goto L28
    L26:
        tt5.a.h("DrivePreviewThumbnailAdapter", "recycle skip glide clear: invalidContext");
        goto L27
    L21:
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L23;
    L13:
        if (r3.isFinishing() == false) goto L15;
    L17:
        r5 = false;
        goto L19
    L15:
        if (r3.isDestroyed() == true) goto L17;
    L28:
        super.onViewRecycled(r7);
        return;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DrivePreviewThumbnailAdapter(List<f> r2, Function1<? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r3, "onItemClick");
        this.a = r2;
        this.b = r3;
        this.c = new DriveThumbnailImageProvider();
        this.d = new ColorDrawable(Color.argb(72, 255, 255, 255));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        if ((r12 instanceof b) == false) goto L5;
        b r14 = (b) r12;
    L6:
        if (r14 == null) goto L36;
        final f r3 = (f) ListProtector.get(this.a, r13);
        Intrinsics.checkNotNullParameter(r3, "item");
        r14.b = -1;
        Disposable r16 = r14.c;
        if (r16 == null) goto L10;
        r16.dispose();
    L10:
        r14.c = null;
        ImageView r17 = r14.a;
        Activity r0 = r14.T3(r17.getContext());
        boolean r1 = true;
        if (r0 != null) goto L13;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == true) goto L21;
    L23:
        boolean r18 = false;
    L24:
        if (r18 == false) goto L26;
        Glide.with(r14.a).clear(r14.a);
    L26:
        r14.b = r3.b;
        r14.a.setImageDrawable(r14.d.d);
        if (r3.c != MimeTypeCategory.VIDEO) goto L29;
        int r8 = 360;
    L30:
        final int r6 = ((RecyclerView.ViewHolder) r14).itemView.getResources().getDimensionPixelSize(2131166321);
        DriveThumbnailImageProvider r19 = r14.d.c;
        String r4 = r3.a.getFileId();
        if (r3.c == MimeTypeCategory.IMAGE) goto L34;
        r1 = false;
    L34:
        final DrivePreviewThumbnailAdapter r7 = r14.d;
        final b r5 = r14;
        final int r9 = r8;
        r14.c = r19.d(r4, true, r1, r8, new DrivePreviewThumbnailAdapter$ViewHolder$bind$1(r3, r5, r9, r6, r7));
        return;
    L29:
        r8 = 120;
        goto L30
    L21:
        if (ViewCompat.isAttachedToWindow(r17) == false) goto L23;
        r18 = true;
        goto L24
    L13:
        if (r0.isFinishing() == false) goto L15;
    L17:
        r2 = false;
        goto L19
    L15:
        if (r0.isDestroyed() == true) goto L17;
    L36:
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131560220, r3, false);
        Intrinsics.checkNotNull(r5);
        return new b(this, r5);
    }
}
