package com.bytedance.locallife.live.goodsshelves.view;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.live.util.j0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/LiveLifeShelfProductImgContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeShelfProductImgContainerView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SmartImageView f260201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SmartImageView f260202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxTextView f260203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SmartImageView f260204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SmartImageView f260205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f260206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LottieAnimationView f260207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DuxTextView f260208h;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeShelfProductImgContainerView f260209a;

        public a(LiveLifeShelfProductImgContainerView r100) {
            this.f260209a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            if (this.f260209a.getAlpha() < 0.0f) goto L5;
            r101.setAlpha(this.f260209a.getAlpha());
        L5:
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), j0.c(8));
        }
    }

    public static final class b {
    }

    static {
    }

    public LiveLifeShelfProductImgContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLifeShelfProductImgContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public LiveLifeShelfProductImgContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.saas_live_life_shelf_product_img_container, this, true);
        setClipToOutline(true);
        setOutlineProvider(new a(this));
        this.f260201a = (SmartImageView) findViewById(R.id.live_life_shelf_product_img_iv);
        this.f260202b = (SmartImageView) findViewById(R.id.live_life_shelf_product_img_border_iv);
        this.f260203c = (DuxTextView) findViewById(R.id.live_life_shelf_product_serial_number);
        this.f260204d = (SmartImageView) findViewById(R.id.live_life_shelf_product_image_tag);
        this.f260205e = (SmartImageView) findViewById(R.id.live_life_shelf_product_image_new_tag);
        this.f260206f = (ViewGroup) findViewById(R.id.live_life_shelf_product_explaining_container);
        this.f260207g = (LottieAnimationView) findViewById(R.id.live_life_shelf_product_explaining_lottie);
        this.f260208h = (DuxTextView) findViewById(R.id.live_life_shelf_product_status_tv);
    }

    public /* synthetic */ LiveLifeShelfProductImgContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
