package com.larus.avlink.gallery.view;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.nova.R;
import com.tencent.connect.share.QzonePublish;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/avlink/gallery/view/AlbumVideoItemHolder;", "Lcom/larus/avlink/gallery/view/AlbumViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "<init>", "(Landroid/view/View;Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "image", "Lcom/larus/bmhome/chat/plugin/image4/view/ImageViewWithLastMotion;", "selectedCheckBox", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", BuyNowCloseMethod.MASK, "lastTouchX", "", "lastTouchY", "hasRecordedTouch", "", "bindData", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/bigimg/MediaItem;", "loadThumbnailImage", "thumbnailPath", "", "setUIDisplay", "setupClickListeners", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumVideoItemHolder extends AlbumViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f292862k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f292863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleCoroutineScope f292864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageViewWithLastMotion f292865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f292866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f292867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f292868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f292869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f292870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f292871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f292872j;

    public static final class a {
    }

    static {
    }

    public AlbumVideoItemHolder(ConstraintLayout r100, f r101, LifecycleCoroutineScope r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "lifecycleScope");
        super(r100);
        this.f292863a = r101;
        this.f292864b = r102;
        this.f292865c = (ImageViewWithLastMotion) r100.findViewById(R.id.image);
        this.f292866d = r100.findViewById(R.id.album_item_select);
        this.f292867e = (TextView) r100.findViewById(R.id.duration);
        this.f292868f = (ProgressBar) r100.findViewById(R.id.album_item_processing);
        this.f292869g = r100.findViewById(R.id.gallery_mask);
    }
}
