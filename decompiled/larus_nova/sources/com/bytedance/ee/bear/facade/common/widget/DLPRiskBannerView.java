package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0014\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\"\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/widget/DLPRiskBannerView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "riskTips", "Landroid/widget/TextView;", "seeDeatil", "closeAction", "Landroid/widget/ImageView;", "hasAdd", "", "seeDetailListener", "Lkotlin/Function0;", "", "closeActionListener", "mSafeClickListener", "com/bytedance/ee/bear/facade/common/widget/DLPRiskBannerView$mSafeClickListener$1", "Lcom/bytedance/ee/bear/facade/common/widget/DLPRiskBannerView$mSafeClickListener$1;", "initView", "setClick", "seeDetail", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DLPRiskBannerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f226470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f226471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f226472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f226473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f226474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f226475f;

    public static final class a extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DLPRiskBannerView f226476c;

        public a(DLPRiskBannerView r100) {
            this.f226476c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            boolean r101 = true;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            this.f226476c.f226474e.invoke();
            return;
        L10:
            if (r100 != null) goto L12;
        L14:
            r101 = false;
        L15:
            if (r101 == false) goto L19;
            this.f226476c.f226475f.invoke();
            this.f226476c.setVisibility(8);
            return;
        L19:
            return;
        L12:
            if (r100.getId() != R.id.close_icon) goto L14;
        L5:
            if (r100.getId() != R.id.see_detail) goto L7;
            r102 = true;
            goto L8
        }
    }

    public DLPRiskBannerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNull(r100);
        super(r100, r101, 0);
        this.f226474e = DLPRiskBannerView$seeDetailListener$1.INSTANCE;
        this.f226475f = DLPRiskBannerView$closeActionListener$1.INSTANCE;
        a r102 = new a(this);
        if (this.f226473d == true) goto L7;
        this.f226473d = true;
        FrameLayout.inflate(getContext(), R.layout.dlp_risk_banner_tips_layout, this);
        this.f226470a = (TextView) findViewById(R.id.risk_banner_txt);
        this.f226471b = (TextView) findViewById(R.id.see_detail);
        this.f226472c = (ImageView) findViewById(R.id.close_icon);
        TextView r103 = this.f226471b;
        Intrinsics.checkNotNull(r103);
        r103.setOnClickListener(r102);
        ImageView r104 = this.f226472c;
        Intrinsics.checkNotNull(r104);
        r104.setOnClickListener(r102);
        TextView r105 = this.f226470a;
        Intrinsics.checkNotNull(r105);
        r105.setText(getContext().getString(R.string.LarkCCM_Docs_DLP_ExternalSharing_Off));
        return;
    }
}
