package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.shopping.anchorv4.bottom.AppointmentMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonElement;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottom.BottomCustomTextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityTime;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityVO;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "Lcom/bytedance/android/shopping/anchorv4/bottom/BottomCustomTextWithOneIconElementView;", "d", "Lkotlin/Lazy;", "getCustomSubTitleView", "()Lcom/bytedance/android/shopping/anchorv4/bottom/BottomCustomTextWithOneIconElementView;", "customSubTitleView", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomButtonElementView extends LinearLayout implements ActionHubAccessor, l1.a {
    public BottomButtonElement a;
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d b;
    public boolean c;
    public final Lazy d;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a e;
    public final String f;

    public BottomButtonElementView(Context r7) {
        this(r7, null, 0, null, 30);
    }

    public BottomButtonElementView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, null, 28);
    }

    public BottomButtonElementView(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, null, 24);
    }

    private final BottomCustomTextWithOneIconElementView getCustomSubTitleView() {
        return (BottomCustomTextWithOneIconElementView) this.d.getValue();
    }

    public final void onStart() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        BottomButtonElement r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAction();
    }

    public final void onFinish() {
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.refresh(null);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final void b(long r5) {
        int r0 = c2.h;
        c2 r6 = c2.a.a(getContext(), r5, this.c);
        Object r7 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        BottomButtonElement r2 = this.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        String r3 = r2.getCountDownTemplate();     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        if (StringsKt.contains$default(r3, "%s", false, 2, null) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
        String r8 = String.format(r3, Arrays.copyOf(new Object[]{r6.g}, 1));     // Catch: Throwable -> L16
    L14:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r9) == true) goto L22;
        r7 = r9;
    L22:
        String r10 = (String) r7;
        if (r10 != null) goto L25;
        return;
    L25:
        getCustomSubTitleView().d(r10);
        return;
    L13:
        r8 = null;
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        super.dispatchTouchEvent(r2);
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    public final void onTick(long r1) {
        b(r1);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.e = r2;
    }

    public final void a(BottomButtonElement r20, BottomButtonVO r21, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r22) {
        Intrinsics.checkNotNullParameter(r22, "anchorV4VM");
        this.a = r20;
        this.b = r22;
        if (r20 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        Long r3 = r20.getIntervalTime();
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        this.c = r4;
        ExtensionsKt.j(this, r20.getBackground());
        TextWithOneIconElement r5 = r20.getMainTitle();
        if (r5 == null) goto L16;
        TextWithOneIconElementView r6 = new TextWithOneIconElementView(getContext(), null, 0, this.f, 14);
        TextWithOneIconElementView.b(r6, r5, null, false, null, 14);
        addView(r6);
    L16:
        TextWithOneIconElement r14 = r20.getSubTitle();
        AppointmentMeta r7 = null;
        if (r14 != null) goto L19;
    L42:
        Action r8 = r20.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r8);
        if (r20.getDisplayAsCountDown() == true) goto L49;
        if (r21 == null) goto L48;
        BottomButtonMeta r1 = r21.getBottomButtonMetaValue();
        if (r1 == null) goto L48;
        r7 = r1.getAppointMeta();
    L48:
        if (r7 != null) goto L49;
        return;
    L49:
        r22.A(this);
        return;
    L19:
        if (r20.getDisplayAsCountDown() == false) goto L21;
        BottomCustomTextWithOneIconElementView r9 = getCustomSubTitleView();
        r9.getClass();
        Intrinsics.checkNotNullParameter("monospace", "fontFamily");
        r9.i = "monospace";
        TextElementView r10 = r9.getTextElementView();
        r10.getClass();
        Intrinsics.checkNotNullParameter("monospace", "fontFamily");
        r10.c = "monospace";
    L21:
        BottomCustomTextWithOneIconElementView r11 = getCustomSubTitleView();
        TextWithOneIconElementView.b(r11, r14, null, false, null, 14);
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(-2, -2);
        r12.topMargin = com.bytedance.android.shopping.extensions.b.b(2);
        Unit r13 = Unit.INSTANCE;
        addView(r11, r12);
        if (r20.getDisplayAsCountDown() == false) goto L42;
        ActivityVO r15 = r22.X();
        if (r15 == null) goto L28;
        ActivityTime r16 = r15.getActivityTime();
        if (r16 == null) goto L28;
        Long r17 = Long.valueOf(r16.getEndTime());
    L29:
        ActivityVO r18 = r22.X();
        if (r18 == null) goto L34;
        ActivityTime r19 = r18.getActivityTime();
        if (r19 == null) goto L34;
        Long r23 = Long.valueOf(r19.getServerTime());
    L35:
        if (r17 == null) goto L42;
        if (r17.longValue() <= 0) goto L42;
        if (r23 == null) goto L42;
        if (r23.longValue() <= 0) goto L42;
        b((r17.longValue() - (System.currentTimeMillis() / ((long) 1000))) * 1000);
    L34:
        r23 = null;
    L28:
        r17 = null;
        goto L29
    L10:
        if (r3.longValue() != 100) goto L12;
        r4 = true;
        goto L13
    }

    public BottomButtonElementView(final Context r3, AttributeSet r4, int r5, String r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.e = null;
        this.f = r6;
        this.d = LazyKt.lazy(new BottomButtonElementView$customSubTitleView$2(this, r3));
        setOrientation(1);
        setGravity(17);
    }
}
