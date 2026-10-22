package com.bytedance.locallife.live.goodsshelves.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/LiveLifeShelfCoreContainerView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/locallife/live/goodsshelves/view/c;", "listener", "", "setOnShelfListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeShelfCoreContainerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveLifeShelfProductImgContainerView f260168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveLifeShelfProductInfoContainerView f260169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f260170c;

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeShelfCoreContainerView f260171a;

        public a(LiveLifeShelfCoreContainerView r100) {
            this.f260171a = r100;
        }

        @Override // com.bytedance.locallife.live.goodsshelves.view.c
        public final void a(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "position");
            c r102 = this.f260171a.f260170c;
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }
    }

    public LiveLifeShelfCoreContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLifeShelfCoreContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnShelfListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f260170c = r100;
    }

    public LiveLifeShelfCoreContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.saas_live_life_goods_shelves_core_container, this, true);
        this.f260168a = (LiveLifeShelfProductImgContainerView) findViewById(R.id.live_life_shelf_product_img_container);
        LiveLifeShelfProductInfoContainerView r103 = (LiveLifeShelfProductInfoContainerView) findViewById(R.id.live_life_shelf_product_info_container);
        this.f260169b = r103;
        r103.setOnShelfListener(new a(this));
    }

    public /* synthetic */ LiveLifeShelfCoreContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
