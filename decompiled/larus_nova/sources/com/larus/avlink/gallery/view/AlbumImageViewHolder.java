package com.larus.avlink.gallery.view;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/gallery/view/AlbumImageViewHolder;", "Lcom/larus/avlink/gallery/view/AlbumViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "<init>", "(Landroid/view/View;Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "image", "Lcom/larus/bmhome/chat/plugin/image4/view/ImageViewWithLastMotion;", "selectedCheckBox", "progressBar", "Landroid/widget/ProgressBar;", BuyNowCloseMethod.MASK, "lastTouchX", "", "lastTouchY", "hasRecordedTouch", "", "bindData", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/bigimg/MediaItem;", "setUIDisplay", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumImageViewHolder extends AlbumViewHolder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f292831i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f292832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageViewWithLastMotion f292833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f292834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f292835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f292836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f292837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f292838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f292839h;

    public static final class a {
    }

    static {
    }

    public AlbumImageViewHolder(ConstraintLayout r100, f r101, LifecycleCoroutineScope r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "lifecycleScope");
        super(r100);
        this.f292832a = r101;
        this.f292833b = (ImageViewWithLastMotion) r100.findViewById(R.id.image);
        this.f292834c = r100.findViewById(R.id.album_item_select);
        this.f292835d = (ProgressBar) r100.findViewById(R.id.album_item_processing);
        this.f292836e = r100.findViewById(R.id.gallery_mask);
    }
}
