package com.bytedance.locallife.live.goodsshelves.view;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.live.util.j0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/LiveLifeShelfProductMarketingContainerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeShelfProductMarketingContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f260219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SmartImageView f260220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxTextView f260221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f260222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f260223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DuxTextView f260224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f260225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DuxTextView f260226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SmartImageView f260227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DuxTextView f260228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f260229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SmartImageView f260230l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f260231m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SmartImageView f260232n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DuxTextView f260233o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SmartImageView f260234p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DuxTextView f260235q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f260236r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SmartImageView f260237s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f260238t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SmartImageView f260239u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DuxTextView f260240v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SmartImageView f260241w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DuxTextView f260242x;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeShelfProductMarketingContainerView f260243a;

        public a(LiveLifeShelfProductMarketingContainerView r100) {
            this.f260243a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            if (this.f260243a.getAlpha() < 0.0f) goto L5;
            r101.setAlpha(this.f260243a.getAlpha());
        L5:
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), j0.c(2));
        }
    }

    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeShelfProductMarketingContainerView f260244a;

        public b(LiveLifeShelfProductMarketingContainerView r100) {
            this.f260244a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            if (this.f260244a.getAlpha() < 0.0f) goto L5;
            r101.setAlpha(this.f260244a.getAlpha());
        L5:
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), j0.c(2));
        }
    }

    public static final class c extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeShelfProductMarketingContainerView f260245a;

        public c(LiveLifeShelfProductMarketingContainerView r100) {
            this.f260245a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            if (this.f260245a.getAlpha() < 0.0f) goto L5;
            r101.setAlpha(this.f260245a.getAlpha());
        L5:
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), j0.c(2));
        }
    }

    public static final class d extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeShelfProductMarketingContainerView f260246a;

        public d(LiveLifeShelfProductMarketingContainerView r100) {
            this.f260246a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            if (this.f260246a.getAlpha() < 0.0f) goto L5;
            r101.setAlpha(this.f260246a.getAlpha());
        L5:
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), j0.c(2));
        }
    }

    public LiveLifeShelfProductMarketingContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLifeShelfProductMarketingContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public LiveLifeShelfProductMarketingContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.saas_live_life_shelf_product_marketing_container, this, true);
        View r103 = findViewById(R.id.marketing_style_1_container);
        this.f260219a = r103;
        this.f260220b = (SmartImageView) findViewById(R.id.marketing_style_1_prefix_icon);
        this.f260221c = (DuxTextView) findViewById(R.id.marketing_style_1_left_tv);
        this.f260222d = findViewById(R.id.marketing_style_1_left_splitter_container);
        this.f260223e = findViewById(R.id.marketing_style_1_left_splitter);
        this.f260224f = (DuxTextView) findViewById(R.id.marketing_style_1_left_extend_tv);
        View r104 = findViewById(R.id.marketing_style_2_container);
        this.f260225g = r104;
        this.f260226h = (DuxTextView) findViewById(R.id.marketing_style_2_left_tv);
        this.f260227i = (SmartImageView) findViewById(R.id.marketing_style_2_left_curve_iv);
        this.f260228j = (DuxTextView) findViewById(R.id.marketing_style_2_right_tv);
        View r105 = findViewById(R.id.marketing_style_3_container);
        this.f260229k = r105;
        this.f260230l = (SmartImageView) findViewById(R.id.marketing_style_3_prefix_icon);
        this.f260231m = findViewById(R.id.marketing_style_3_content_container);
        this.f260232n = (SmartImageView) findViewById(R.id.marketing_style_3_left_bg_iv);
        this.f260233o = (DuxTextView) findViewById(R.id.marketing_style_3_left_tv);
        this.f260234p = (SmartImageView) findViewById(R.id.marketing_style_3_left_curve_iv);
        this.f260235q = (DuxTextView) findViewById(R.id.marketing_style_3_right_tv);
        View r106 = findViewById(R.id.marketing_style_4_container);
        this.f260236r = r106;
        this.f260237s = (SmartImageView) findViewById(R.id.marketing_style_4_prefix_icon);
        this.f260238t = findViewById(R.id.marketing_style_4_left_container);
        this.f260239u = (SmartImageView) findViewById(R.id.marketing_style_4_left_bg_iv);
        this.f260240v = (DuxTextView) findViewById(R.id.marketing_style_4_left_tv);
        this.f260241w = (SmartImageView) findViewById(R.id.marketing_style_4_left_curve_iv);
        this.f260242x = (DuxTextView) findViewById(R.id.marketing_style_4_right_tv);
        r103.setClipToOutline(true);
        r103.setOutlineProvider(new a(this));
        r104.setClipToOutline(true);
        r104.setOutlineProvider(new b(this));
        r105.setClipToOutline(true);
        r105.setOutlineProvider(new c(this));
        r106.setClipToOutline(true);
        r106.setOutlineProvider(new d(this));
    }

    public /* synthetic */ LiveLifeShelfProductMarketingContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
