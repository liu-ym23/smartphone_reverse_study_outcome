package com.larus.gallery.tracker;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.larus.gallery.impl.databinding.LarusGalleryThumbnailImageViewBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0014\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bJ\u0014\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bJ\u0014\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bJ\u0016\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000bJ \u0010\"\u001a\u00020\u000e2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/gallery/tracker/ThumbnailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/gallery/tracker/ThumbnailAdapter$ViewHolder;", "<init>", "()V", "tag", "", "items", "", "Lcom/larus/gallery/api/GalleryData;", "selectedPosition", "", "onItemClickListener", "Lkotlin/Function2;", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "onViewRecycled", "onViewDetachedFromWindow", "setItems", "newItems", "", "appendItems", "prependItems", "replaceItem", MapController.ITEM_LAYER_TAG, "setSelectedPosition", "getSelectedPosition", "setOnItemClickListener", "listener", "getItem", "ViewHolder", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.larus.gallery.api.k> f343994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Integer, ? super com.larus.gallery.api.k, Unit> f343995c;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\u0012\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/gallery/tracker/ThumbnailAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/gallery/impl/databinding/LarusGalleryThumbnailImageViewBinding;", "<init>", "(Lcom/larus/gallery/impl/databinding/LarusGalleryThumbnailImageViewBinding;)V", "tag", "", "MAX_RETRY_COUNT", "", DBDefinition.RETRY_COUNT, "lastUri", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/gallery/api/GalleryData;", "loadImage", "url", "cancelLoading", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f343996d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusGalleryThumbnailImageViewBinding f343997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f343998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f343999c;

        public ViewHolder(LarusGalleryThumbnailImageViewBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f343970a);
            this.f343997a = r100;
            this.f343998b = "ThumbnailAdapter_ViewHolder_" + hashCode();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f343994b).size();
    }

    public ThumbnailAdapter() {
        this.f343993a = "ThumbnailAdapter";
        this.f343994b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        ImageLoaderKt.e(r101.f343997a.f343972c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        final ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        FLogger r103 = FLogger.f375446a;
        r103.i(this.f343993a, "onBindViewHolder position:" + r101 + ", holder:" + r102);
        com.larus.gallery.api.k r104 = (com.larus.gallery.api.k) ListProtector.get(this.f343994b, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        r103.i(r102.f343998b, "bind");
        final String r105 = cb9.a.a(r104);
        com.larus.gallery.api.h r106 = r104.f343862d;
        boolean r107 = false;
        if (r106 != null) goto L5;
    L7:
        boolean r108 = false;
    L8:
        ImageView r109 = r102.f343997a.f343971b;
        if (r108 == false) goto L11;
        int r110 = 0;
    L12:
        r109.setVisibility(r110);
        if (r108 == true) goto L24;
        if (r105 != null) goto L16;
    L17:
        r107 = true;
    L18:
        if (r107 == true) goto L24;
        if (Intrinsics.areEqual(r102.f343999c, r105) == true) goto L23;
        ImageLoaderKt.e(r102.f343997a.f343972c);
    L23:
        final ImageDecodeOptions r111 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).setForceStaticImage(true).build();
        ImageLoaderKt.y(r102.f343997a.f343972c, r105, "common.photo_dialog_preview_tracker", new c(r105, r102, r111), 4);
        r102.f343999c = r105;
        return;
    L16:
        if (r105.length() != 0) goto L18;
    L24:
        ImageLoaderKt.e(r102.f343997a.f343972c);
        r102.f343999c = null;
        return;
    L11:
        r110 = 8;
        goto L12
    L5:
        if (r106.f343857c != true) goto L7;
        r108 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_gallery_thumbnail_image_view, r100, false);
        int r103 = R.id.blocked_placeholder;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r102, R.id.blocked_placeholder);
        if (r104 == null) goto L9;
        r103 = R.id.content;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.content);
        if (r105 == null) goto L9;
        GalleryRoundedFrameLayout r106 = (GalleryRoundedFrameLayout) r102;
        final ViewHolder r107 = new ViewHolder(new LarusGalleryThumbnailImageViewBinding(r106, r104, r105));
        e1.d(r106, new b(r107, this));
        return r107;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
