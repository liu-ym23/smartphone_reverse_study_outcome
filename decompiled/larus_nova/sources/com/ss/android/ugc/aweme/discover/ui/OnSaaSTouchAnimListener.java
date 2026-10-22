package com.ss.android.ugc.aweme.discover.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.ies.dmt.ui.widget.DmtEditText;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.view.ECSearchEditView;
import com.ss.android.ugc.aweme.search.common.view.ECSearchEditView$initView$6;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/OnSaaSTouchAnimListener;", "Landroid/view/View$OnTouchListener;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OnSaaSTouchAnimListener implements View.OnTouchListener {
    public OnSaaSTouchAnimListener() {
    }

    public abstract Animator a(View r100);

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View r110, final MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r111, "event");
        int r100 = r111.getAction();
        CharSequence r101 = null;
        if (r100 == 0) goto L25;
        final boolean r102 = false;
        if (r100 != 1) goto L7;
        int r103 = ViewConfiguration.get(r110.getContext()).getScaledTouchSlop();
        float r104 = r111.getX();
        float r105 = r111.getY();
        float r106 = r103;
        float r107 = -r106;
        if (r104 >= r107) goto L17;
    L23:
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "event");
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "event");
        Animator r108 = a(r110);
        r108.addListener(new AnonymousClass2(this, r110, r111, r102));
        r108.start();
        return true;
    L17:
        if (r105 < r107) goto L23;
        if (r104 >= ((r110.getRight() - r110.getLeft()) + r106)) goto L23;
        if (r105 >= ((r110.getBottom() - r110.getTop()) + r106)) goto L23;
        r102 = true;
        goto L23
    L7:
        if (r100 == 3) goto L9;
        return false;
    L9:
        ECSearchEditView$initView$6 r109 = (ECSearchEditView$initView$6) this;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "event");
        if (r109.f452375a == null) goto L12;
        Logger.b("ECSearchPrefetch", "beforeTouchCancelAnimStart predict search missed!");
        r109.f452375a = null;
    L12:
        r109.f452376b = 0;
        Animator r112 = a(r110);
        r112.addListener(new AnonymousClass3(this, r110, r111));
        r112.start();
        return false;
    L25:
        ECSearchEditView$initView$6 r113 = (ECSearchEditView$initView$6) this;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "event");
        r113.f452376b = System.currentTimeMillis();
        Logger.a("ECSearchPrefetch", "beforeTouchDownAnimStart predictTime = " + r113.f452376b);
        ITradeSearchHostService r114 = TradeSearch.c(TradeSearch.f453393a);
        if (r114 == null) goto L30;
        ITradeSearchAwemeHostService r115 = r114.getITradeSearchAwemeHostService();
        if (r115 == null) goto L30;
        String r116 = r115.nextPredictId();
    L31:
        r113.f452375a = r116;
        DmtEditText r117 = r113.f452377c.f452346f;
        if (r117 == null) goto L34;
        Editable r118 = r117.getText();
    L35:
        String r119 = ECSearchEditView.b(String.valueOf(r118));
        ECSearchEditView r120 = r113.f452377c;
        ECSearchEditView.OnSearchEditViewListener r121 = r120.f452341a;
        if (r121 == null) goto L41;
        DmtEditText r122 = r120.f452346f;
        if (r122 == null) goto L40;
        r101 = r122.getHint();
    L40:
        r121.onSearchBtnPredictSearch(String.valueOf(r101), r119);
    L41:
        Intrinsics.checkNotNullParameter(r110, "view");
        ObjectAnimator r123 = ObjectAnimator.ofFloat(r110, "alpha", new float[]{1.0f, 0.5f});
        r123.setDuration(150);
        r123.addListener(new AnonymousClass1(this, r110, r111));
        r123.start();
        return true;
    L34:
        r118 = null;
    L30:
        r116 = null;
        goto L31
    }
}
