package com.bytedance.android.shopping.product.flow.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttvideoengine.utils.Error;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "d", "VolumeView", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoBannerHolder extends BannerHolder {
    public final ECVideoPlayer a;
    public final SimpleDraweeView b;
    public final VolumeView c;
    public yg3.b d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$VolumeView;", "Landroid/widget/FrameLayout;", "", "value", "b", "Z", "isMute", "()Z", "setMute", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VolumeView extends FrameLayout {
        public final ImageView a;
        public boolean b;

        public VolumeView(Context r4) {
            AttributeSet r2 = null;
            this(r4, r2, 6, 0);
        }

        public VolumeView(Context r3, AttributeSet r4) {
            this(r3, r4, 4, 0);
        }

        public final void setMute(boolean r6) {
            if (r6 == false) goto L5;
            ViewGroup.LayoutParams r1 = this.a.getLayoutParams();
            float r2 = 16;
            Resources r3 = Resources.getSystem();
            r1.width = MathKt.roundToInt(TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
            ViewGroup.LayoutParams r4 = this.a.getLayoutParams();
            Resources r5 = Resources.getSystem();
            r4.height = MathKt.roundToInt(TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())));
            this.a.setImageResource(2131233558);
        L6:
            this.b = r6;
            return;
        L5:
            ViewGroup.LayoutParams r7 = this.a.getLayoutParams();
            Resources r8 = Resources.getSystem();
            r7.width = MathKt.roundToInt(TypedValue.applyDimension(1, 14, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics())));
            ViewGroup.LayoutParams r9 = this.a.getLayoutParams();
            Resources r10 = Resources.getSystem();
            r9.height = MathKt.roundToInt(TypedValue.applyDimension(1, 11, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics())));
            this.a.setImageResource(2131233559);
            goto L6
        }

        public VolumeView(Context r2, AttributeSet r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2, r3, r4);
            LayoutInflater.from(r2).inflate(2131564694, this);
            this.a = (ImageView) findViewById(2131392782);
        }

        public /* synthetic */ VolumeView(Context r1, AttributeSet r2, int r3, int r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2, 0);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VideoBannerHolder a;

        public a(VideoBannerHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getClass();
        }
    }

    public static final class b implements com.bytedance.android.shopping.widget.ecvideoplayer.b {
        public final /* synthetic */ VideoBannerHolder a;

        public final void E() {
        }

        public final void g() {
        }

        public final void h(int r1, int r2) {
        }

        public final void onError(Error r1) {
        }

        public final void onIdle() {
        }

        public final void onPaused() {
        }

        public final void onPlaying() {
        }

        public final void onRelease() {
        }

        public final void onVideoSizeChanged(int r1, int r2) {
        }

        public final void w() {
        }

        public final void onRenderStart() {
            this.a.b.setVisibility(8);
        }

        public b(VideoBannerHolder r1) {
            this.a = r1;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ VideoBannerHolder a;

        public c(VideoBannerHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            VolumeView r3 = this.a.c;
            r3.setMute(!r3.b);
            ECVideoPlayer r4 = this.a.a;
            if (r4 == null) goto L6;
            r4.o(!r4.j);
            return;
        }
    }

    public interface d {
    }

    public VideoBannerHolder(View r7) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        super(r7);
        this.b = r7.findViewById(2131392289);
        VolumeView r0 = (VolumeView) r7.findViewById(2131392785);
        this.c = r0;
        View r1 = new ECVideoView(r7.getContext(), null, 6, 0);
        ViewGroup r2 = (ViewGroup) r7;
        r2.addView(r1, 0, new ViewGroup.LayoutParams(-1, -1));
        ECVideoPlayer r3 = new ECVideoPlayer(r2.getContext());
        r1.setPlayer(r3);
        Unit r4 = Unit.INSTANCE;
        this.a = r3;
        View r8 = r7.findViewById(2131392778);
        if (r8 == null) goto L5;
        r8.setOnClickListener(new a(this));
    L5:
        r3.a(new b(this));
        r0.setOnClickListener(new c(this));
    }
}
