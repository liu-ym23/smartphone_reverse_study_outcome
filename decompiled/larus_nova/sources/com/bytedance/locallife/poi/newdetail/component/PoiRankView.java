package com.bytedance.locallife.poi.newdetail.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiRankView;", "Landroid/widget/LinearLayout;", "", "supportFontScale", "", "setSupportFontScale", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiRankView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f263104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f263105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxTextView f263106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f263107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f263108e;

    public PoiRankView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiRankView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        boolean r100 = PoiBigFontExperiment.a();
        if (this.f263108e == false) goto L7;
        if (r100 == false) goto L6;
        com.bytedance.dux.largefont.a.a(this.f263105b, 14, 14);
        goto L7
    L6:
        ImageView r101 = this.f263105b;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        int r103 = this.f263107d;
        r102.width = r103;
        r102.height = r103;
        r101.setLayoutParams(r102);
    L7:
        DuxTextView r104 = this.f263106c;
        if (this.f263108e == false) goto L12;
        if (r100 == false) goto L11;
        com.bytedance.dux.largefont.a.c(r104, 11.0f);
    L13:
        requestLayout();
        return;
    L11:
        r104.setTextSize(2, 11.0f);
        goto L13
    L12:
        r104.setTextSize(1, 11.0f);
        goto L13
    }

    public final void setSupportFontScale(boolean r100) {
        this.f263108e = r100;
        a();
    }

    public PoiRankView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.saas_poi_rank_view, this);
        this.f263104a = r103;
        this.f263105b = (ImageView) r103.findViewById(R.id.poi_rank_icon);
        this.f263106c = (DuxTextView) r103.findViewById(R.id.poi_rank_text);
        this.f263107d = (int) UIUtils.sp2px(r100, 14.0f);
        this.f263108e = true;
        setMinimumHeight((int) UIUtils.dip2Px(r100, 20.0f));
        setOrientation(0);
        setBackgroundResource(R.drawable.poi_bg_rank_view);
        a();
    }

    public /* synthetic */ PoiRankView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
