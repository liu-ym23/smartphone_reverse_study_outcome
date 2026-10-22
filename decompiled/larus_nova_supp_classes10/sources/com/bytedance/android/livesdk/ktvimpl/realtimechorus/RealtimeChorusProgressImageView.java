package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;", "Landroid/widget/FrameLayout;", "", "text", "", "setText", "", "color", "setTextColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealtimeChorusProgressImageView extends FrameLayout {
    public RoundCornerProgressBar a;
    public TextView b;
    public HSImageView c;
    public Drawable d;
    public HSImageView e;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.core.utils.q0 {
        public final /* synthetic */ RealtimeChorusProgressImageView a;
        public final /* synthetic */ py.k b;

        public final void d(ImageInfo r4) {
            if ((r4 instanceof CloseableStaticBitmap) == false) goto L13;
            Bitmap r5 = ((CloseableStaticBitmap) r4).getUnderlyingBitmap();
            if (r5 != null) goto L7;
            return;
        L7:
            if (r5.isRecycled() == true) goto L15;
            Bitmap.Config r0 = r5.getConfig();
            if (r0 != null) goto L11;
            r0 = Bitmap.Config.ARGB_8888;
        L11:
            Bitmap r6 = r5.copy(r0, true);
            RealtimeChorusProgressImageView r1 = this.a;
            r1.d = new BitmapDrawable(s1.getResources(), r6);
            return;
        L15:
            return;
        }

        public b(RealtimeChorusProgressImageView r1, py.k r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public RealtimeChorusProgressImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealtimeChorusProgressImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(py.k r7) {
        HSImageView r0 = this.c;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r0);
        com.bytedance.android.live.ui.k.d(r0, r7, this.d, ImageView.ScaleType.FIT_XY, 0, new b(this, r7));
        return;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setTextColor(int r2) {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    public RealtimeChorusProgressImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ RealtimeChorusProgressImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
