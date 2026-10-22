package com.bytedance.locallife.poi.newdetail.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.poi.newdetail.widget.PoiRepeatTextureBgView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiDetailModalBar;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/dito/model/a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDetailModalBar extends BaseDitoView<com.bytedance.locallife.dito.model.a> {
    public final int A;
    public final FrameLayout.LayoutParams B;
    public int C;
    public int D;
    public final int E;
    public com.bytedance.locallife.poi.newdetail.k F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f263037y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f263038z;

    public static final class a {
    }

    static {
    }

    public PoiDetailModalBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiDetailModalBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        Object r100 = getDitoViewModel().A.get("poi_detail");
        if ((r100 instanceof PoiDetail) == false) goto L5;
        PoiDetail r101 = (PoiDetail) r100;
    L5:
        Object r102 = getDitoViewModel().A.get("skin_style");
        PoiRepeatTextureBgView.a r103 = null;
        if ((r102 instanceof com.bytedance.locallife.poi.newdetail.k) == false) goto L8;
        com.bytedance.locallife.poi.newdetail.k r104 = (com.bytedance.locallife.poi.newdetail.k) r102;
    L9:
        this.F = r104;
        Object r105 = getDitoViewModel().A.get("inflater_manager");
        if ((r105 instanceof sy6.b) == false) goto L12;
        sy6.b r106 = (sy6.b) r105;
    L13:
        if (r106 == null) goto L15;
        View r107 = r106.a(getContext(), R.layout.saas_poi_detail_modal_head, this);
    L16:
        this.f263037y = r107;
        com.bytedance.locallife.poi.newdetail.k r108 = this.F;
        if (r108 == null) goto L21;
        com.bytedance.locallife.poi.newdetail.c r109 = r108.f263276c;
        if (r109 == null) goto L21;
        String r110 = r109.a();
    L23:
        if (TextUtils.isEmpty(r110) == false) goto L25;
        int r111 = ContextCompat.getColor(getContext(), R.color.POIBgPrimary);
    L32:
        View r112 = this.f263037y;
        if (r112 == null) goto L35;
        r112.setBackgroundColor(r111);
    L35:
        View r113 = this.f263037y;
        if (r113 == null) goto L38;
        PoiRepeatTextureBgView r114 = (PoiRepeatTextureBgView) r113.findViewById(R.id.texture_background);
    L39:
        if (r114 == null) goto L44;
        com.bytedance.locallife.poi.newdetail.k r115 = this.F;
        if (r115 == null) goto L43;
        r103 = r115.f263279f;
    L43:
        r114.setManager(r103);
    L44:
        addView(this.f263037y, this.B);
        if (this.D != 0) goto L54;
        Integer r116 = getDataCenter().P().getValue();
        if (r116 != null) goto L49;
        r116 = 0;
    L49:
        int r117 = r116.intValue();
        if (r117 != 0) goto L53;
        r117 = com.bytedance.locallife.poi.newdetail.h.f263262a.e();
    L53:
        this.D = r117;
        this.C = r117 - this.E;
    L54:
        getDataCenter().R().observe(this, new d(this));
        getDataCenter().S().observe(this, new e(this));
        return;
    L38:
        r114 = null;
        goto L39
    L25:
        int r118 = com.bytedance.locallife.poi.dito.util.a.f262546a;
        com.bytedance.locallife.poi.newdetail.k r119 = this.F;
        if (r119 == null) goto L30;
        com.bytedance.locallife.poi.newdetail.c r120 = r119.f263276c;
        if (r120 == null) goto L30;
        String r121 = r120.a();
    L31:
        r111 = com.bytedance.locallife.poi.dito.util.a.a(r121);
    L30:
        r121 = null;
    L21:
        r110 = null;
        goto L23
    L15:
        r107 = null;
        goto L16
    L12:
        r106 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    public PoiDetailModalBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263038z = 1;
        int r103 = (int) UIUtils.dip2Px(r100, 12.0f);
        this.A = r103;
        this.B = new FrameLayout.LayoutParams(-1, r103);
        this.E = 50;
    }

    public /* synthetic */ PoiDetailModalBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
