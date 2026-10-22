package com.bytedance.locallife.live.goodsshelves.view;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.live.util.j0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/LiveLifeShelfBrandContainerView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeShelfBrandContainerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SmartImageView f260163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f260164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f260165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxTextView f260166d;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeShelfBrandContainerView f260167a;

        public a(LiveLifeShelfBrandContainerView r100) {
            this.f260167a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            if (this.f260167a.getAlpha() < 0.0f) goto L5;
            r101.setAlpha(this.f260167a.getAlpha());
        L5:
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), j0.c(4));
        }
    }

    public LiveLifeShelfBrandContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLifeShelfBrandContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public LiveLifeShelfBrandContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.saas_live_life_shelf_product_brand_container, this, true);
        setOrientation(0);
        setGravity(16);
        SmartImageView r103 = (SmartImageView) findViewById(R.id.live_life_shelf_product_brand_icon);
        this.f260163a = r103;
        this.f260164b = (DuxTextView) findViewById(R.id.live_life_shelf_product_brand_id_tv);
        this.f260165c = findViewById(R.id.live_life_shelf_product_brand_splitter);
        this.f260166d = (DuxTextView) findViewById(R.id.live_life_shelf_product_brand_special_id_tv);
        r103.setClipToOutline(true);
        r103.setOutlineProvider(new a(this));
    }

    public /* synthetic */ LiveLifeShelfBrandContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
