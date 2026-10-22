package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0014\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\"\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/widget/DLPRiskBannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "riskTips", "Landroid/widget/TextView;", "seeDeatil", "closeAction", "Landroid/widget/ImageView;", "hasAdd", "", "seeDetailListener", "Lkotlin/Function0;", "", "closeActionListener", "mSafeClickListener", "com/bytedance/ee/bear/facade/common/widget/DLPRiskBannerView$mSafeClickListener$1", "Lcom/bytedance/ee/bear/facade/common/widget/DLPRiskBannerView$mSafeClickListener$1;", "initView", "setClick", "seeDetail", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DLPRiskBannerView extends FrameLayout {
    public TextView a;
    public TextView b;
    public ImageView c;
    public boolean d;
    public Function0<Unit> e;
    public Function0<Unit> f;

    public static final class a extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ DLPRiskBannerView c;

        public a(DLPRiskBannerView r1) {
            this.c = r1;
        }

        public final void a(View r5) {
            boolean r0 = true;
            if (r5 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L10;
            this.c.e.invoke();
            return;
        L10:
            if (r5 != null) goto L12;
        L14:
            r0 = false;
        L15:
            if (r0 == false) goto L19;
            this.c.f.invoke();
            this.c.setVisibility(8);
            return;
        L19:
            return;
        L12:
            if (r5.getId() != 2131366997) goto L14;
        L5:
            if (r5.getId() != 2131385745) goto L7;
            r2 = true;
            goto L8
        }
    }

    public DLPRiskBannerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNull(r2);
        super(r2, r3, 0);
        this.e = DLPRiskBannerView$seeDetailListener$1.INSTANCE;
        this.f = DLPRiskBannerView$closeActionListener$1.INSTANCE;
        com.bytedance.ee.bear.widgets.t r4 = new a(this);
        if (this.d == true) goto L7;
        this.d = true;
        FrameLayout.inflate(getContext(), 2131560062, this);
        this.a = (TextView) findViewById(2131384651);
        this.b = (TextView) findViewById(2131385745);
        this.c = (ImageView) findViewById(2131366997);
        TextView r5 = this.b;
        Intrinsics.checkNotNull(r5);
        r5.setOnClickListener(r4);
        ImageView r6 = this.c;
        Intrinsics.checkNotNull(r6);
        r6.setOnClickListener(r4);
        TextView r7 = this.a;
        Intrinsics.checkNotNull(r7);
        r7.setText(getContext().getString(2131889024));
        return;
    }
}
