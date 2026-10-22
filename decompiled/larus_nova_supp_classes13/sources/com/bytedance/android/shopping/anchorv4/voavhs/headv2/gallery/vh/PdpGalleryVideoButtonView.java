package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/vh/PdpGalleryVideoButtonView;", "Landroid/widget/FrameLayout;", "", "resId", "", "setImageResource", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpGalleryVideoButtonView extends FrameLayout {
    public final ImageView a;

    public PdpGalleryVideoButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PdpGalleryVideoButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setImageResource(int r2) {
        this.a.setImageResource(r2);
    }

    public PdpGalleryVideoButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ImageView r5 = new ImageView(r2);
        this.a = r5;
        r5.setScaleType(ImageView.ScaleType.FIT_XY);
        Unit r6 = Unit.INSTANCE;
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(32), com.bytedance.android.shopping.extensions.b.a(32));
        r7.gravity = 17;
        addView(r5, r7);
    }

    public /* synthetic */ PdpGalleryVideoButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
