package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.IECWidgetType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnLayout;
import com.bytedance.android.ec.model.response.ECFloatWindowDetailInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xd.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class FloatWindowView extends ak2.b implements IECWidgetType, IWidgetType, bk2.d {
    public final a a;
    public final Lazy b;
    public boolean c;
    public boolean d;
    public boolean e;
    public ECFloatWindowInfo f;
    public final Lazy g;
    public final Context h;
    public final ECContext i;
    public final LiveRoomParams j;
    public final com.bytedance.android.livesdk.livecommerce.room.api.e k;
    public final bk2.d l;

    @Override // bk2.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.l.add(r2);
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.l.clearDisposable();
    }

    @Override // bk2.d
    public final Disposable ignore(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.l.ignore(r2);
    }

    @Override // ak2.b
    public final void onLoad() {
        this.d = true;
    }

    @Override // ak2.b
    public final void onUnload() {
        this.d = false;
    }

    @Override // ak2.b
    public final void onViewDetached() {
        this.e = false;
        int r1 = ph.b.a;
        ph.b.a(getView(), false);
    }

    @Override // ak2.b
    public final void onViewWillDetach() {
    }

    @Override // bk2.d
    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.l.remove(r2);
    }

    public final View getView() {
        if (this.c == true) goto L5;
        a r0 = this.a;
        c r1 = r0.f;
        if (r1 == null) goto L13;
        ECFloatWindowInfo r2 = r1.a;
        if (r2 == null) goto L13;
        ECFloatWindowDetailInfo r3 = r2.getDetailInfo();
        if (r3 == null) goto L13;
        ECFloatWindowColumnLayout r4 = r3.getLayout();
    L14:
        r0.e(r4);
        View r5 = r0.a;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        return r5;
    L13:
        r4 = null;
        goto L14
    L5:
        return ((QUIManager) this.b.getValue()).p();
    }

    public final IWidgetType.ExternalWidgetType getWidgetType() {
        ECUIPromotion r0 = (ECUIPromotion) this.i.getExplainPromotion().getValue();
        if (r0 == null) goto L17;
        ECFloatWindowInfo r1 = r0.floatWindowInfo;
        if (r1 == null) goto L17;
        Integer r2 = r1.getType();
        if (r2 == null) goto L17;
        int r3 = r2.intValue();
        IWidgetType.ExternalWidgetType r4 = IWidgetType.ExternalWidgetType.ECOMMERCE_SIZE_COMPONENTS;
        if (r3 == r4.getValue()) goto L15;
        r4 = IWidgetType.ExternalWidgetType.ECOMMERCE_PROPERTY_COMPONENTS;
        if (r3 == r4.getValue()) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L17;
        return r4;
    L17:
        return IWidgetType.ExternalWidgetType.ECOMMERCE_SIZE_COMPONENTS;
    }

    public final IECWidgetType.ECExternalWidgetType j() {
        ECUIPromotion r0 = (ECUIPromotion) this.i.getExplainPromotion().getValue();
        if (r0 == null) goto L17;
        ECFloatWindowInfo r1 = r0.floatWindowInfo;
        if (r1 == null) goto L17;
        Integer r2 = r1.getType();
        if (r2 == null) goto L17;
        int r3 = r2.intValue();
        IECWidgetType.ECExternalWidgetType r4 = IECWidgetType.ECExternalWidgetType.ECOMMERCE_SIZE_COMPONENTS;
        if (r3 == r4.getValue()) goto L15;
        r4 = IECWidgetType.ECExternalWidgetType.ECOMMERCE_PROPERTY_COMPONENTS;
        if (r3 == r4.getValue()) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L17;
        return r4;
    L17:
        return IECWidgetType.ECExternalWidgetType.ECOMMERCE_SIZE_COMPONENTS;
    }

    public final void v() {
        this.k.K(this);
        ((QUIManager) this.b.getValue()).r(kk2.a.class);
    }

    public final Context getContext() {
        return this.h;
    }

    @Override // ak2.b
    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        this.e = true;
        int r0 = ph.b.a;
        ph.b.a(getView(), true);
    }

    @Override // ak2.b
    public final void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        gk2.a.a(getView());
    }

    public final void u(c r22) {
        Handler r2 = UtilityKotlinExtentionsKt.b;
        r2.removeCallbacks((FloatWindowView$hideWidgetAction$2.a) this.g.getValue());
        if (r22 == null) goto L5;
        ECFloatWindowInfo r4 = r22.a;
    L6:
        if (r4 == null) goto L8;
        List r8 = r4.getCarouselDetailInfos();
    L9:
        if (r4 == null) goto L11;
        ECFloatWindowDetailInfo r5 = r4.getDetailInfo();
    L13:
        if (r8 != null) goto L15;
        if (r5 == null) goto L144;
        boolean r3 = this.c;
        this.c = false;
        a r13 = this.a;
        r13.f = r22;
        if (r22 == null) goto L125;
        ECFloatWindowInfo r7 = r22.a;
        if (r7 == null) goto L125;
        ECFloatWindowDetailInfo r9 = r7.getDetailInfo();
        if (r9 == null) goto L125;
        r13.e(r9.getLayout());
        ECNetImageView r10 = r13.b;
        if (r10 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("ivProductCover");
    L51:
        ECLiveImageUtils.ECNetImageInfo r11 = new ECLiveImageUtils.ECNetImageInfo();
        String r12 = r9.getImage();
        String r14 = "";
        if (r12 != null) goto L54;
        r12 = "";
    L54:
        r11.url = r12;
        r11.height = -3;
        r11.width = (int) UIUtils.dip2Px(r13.g, 24.0f);
        r11.autoScaleOneSide = true;
        r11.disableFade = true;
        r11.disablePlaceholder = true;
        r11.roundDp = 2;
        Unit r15 = Unit.INSTANCE;
        ECLiveImageUtils.b(r10, r11);
        ECNetImageView r16 = r13.c;
        if (r16 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("ivTitle");
    L57:
        ECLiveImageUtils.ECNetImageInfo r17 = new ECLiveImageUtils.ECNetImageInfo();
        ECUrlModel r18 = r9.getTitleImage();
        if (r18 == null) goto L60;
        String r19 = r18.getFirstUrl();
    L61:
        if (r19 != null) goto L63;
        r19 = "";
    L63:
        r17.url = r19;
        r17.height = -3;
        r17.width = (int) UIUtils.dip2Px(r13.g, 52.0f);
        r17.autoScaleOneSide = true;
        r17.disableFade = true;
        r17.disablePlaceholder = true;
        ECLiveImageUtils.b(r16, r17);
        ECFloatWindowDetailInfo r110 = r7.getDetailInfo();
        if (r110 == null) goto L125;
        Integer r20 = r7.getType();
        if (r20 != null) goto L70;
    L72:
        boolean r111 = false;
    L73:
        LinearLayout r21 = r13.e;
        if (r21 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L76:
        r21.removeAllViewsInLayout();
        final StringBuilder r112 = new StringBuilder();
        List r23 = r110.getColumnInfos();
        if (r23 == null) goto L81;
        ECFloatWindowColumnInfo r24 = (ECFloatWindowColumnInfo) CollectionsKt.firstOrNull(r23);
        if (r24 == null) goto L81;
        String r25 = r24.getTitle();
    L82:
        if (r25 != null) goto L84;
        String r113 = "";
    L85:
        List r26 = r110.getColumnInfos();
        if (r26 == null) goto L90;
        ECFloatWindowColumnInfo r27 = (ECFloatWindowColumnInfo) CollectionsKt.lastOrNull(r26);
        if (r27 == null) goto L90;
        String r28 = r27.getTitle();
    L91:
        if (r28 == null) goto L94;
        r14 = r28;
    L94:
        LinearLayout r29 = r13.e;
        if (r29 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L97:
        r29.addView(r13.c(r113, r14, true, r111, r110.getLayout().getCenterMargin()));
        r112.append(r113);
        r112.append(",");
        r112.append(r14);
        List r1 = r110.getColumnInfos();
        if (r1 == null) goto L103;
        ECFloatWindowColumnInfo r6 = (ECFloatWindowColumnInfo) CollectionsKt.firstOrNull(r1);
        if (r6 == null) goto L103;
        List r30 = r6.getElements();
        if (r30 == null) goto L103;
    L104:
        List r31 = r110.getColumnInfos();
        if (r31 == null) goto L110;
        ECFloatWindowColumnInfo r32 = (ECFloatWindowColumnInfo) CollectionsKt.lastOrNull(r31);
        if (r32 == null) goto L110;
        List r33 = r32.getElements();
        if (r33 == null) goto L110;
    L111:
        int r34 = r30.size();
        int r114 = 0;
    L112:
        if (r114 >= r34) goto L121;
        if (r114 >= r33.size()) goto L119;
        LinearLayout r115 = r13.e;
        if (r115 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L118:
        int r35 = r114;
        r115.addView(r13.c((String) ListProtector.get(r30, r114), (String) ListProtector.get(r33, r114), false, r111, r110.getLayout().getCenterMargin()));
        UtilityKotlinExtentionsKt.f(CollectionsKt.getOrNull(r30, r35), CollectionsKt.getOrNull(r33, r35), new FloatWindowPanelViewManager$bindContent$1(r112));
    L120:
        r114 = r35 + 1;
        r34 = r34;
        goto L112
    L119:
        r35 = r114;
        goto L120
    L121:
        LinearLayout r36 = r13.e;
        if (r36 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L124:
        r36.setContentDescription(r112);
    L110:
        r33 = CollectionsKt.emptyList();
    L103:
        r30 = CollectionsKt.emptyList();
    L90:
        r28 = null;
        goto L91
    L84:
        r113 = r25;
    L81:
        r25 = null;
        goto L82
    L70:
        if (r20.intValue() != 2) goto L72;
        r111 = true;
        goto L73
    L60:
        r19 = null;
    L125:
        ECFloatWindowInfo r37 = this.f;
        if (r37 == null) goto L128;
        Integer r38 = r37.getType();
    L130:
        if ((!Intrinsics.areEqual(r38, r4.getType())) == true) goto L133;
        if (r3 == true) goto L133;
    L136:
        if (this.d == true) goto L138;
        this.k.L(this, j.a);
    L138:
        this.k.O(this);
        if (r22 == null) goto L142;
        oh.a.b("recordSizeInfoShowEvent", new d(this, r22));
    L142:
        this.f = r4;
        return;
    L133:
        if (this.e == false) goto L136;
        v();
        goto L136
    L128:
        r38 = null;
        goto L130
    L144:
        if (this.e == false) goto L153;
        if (r22 != null) goto L153;
        ECFloatWindowInfo r39 = this.f;
        if (r39 == null) goto L151;
        Long r40 = r39.getKeepTime();
        if (r40 == null) goto L151;
        long r41 = r40.longValue();
    L152:
        r2.postDelayed((FloatWindowView$hideWidgetAction$2.a) this.g.getValue(), r41 * ((long) 1000));
        return;
    L151:
        r41 = 5;
    L153:
        v();
        return;
    L15:
        if (this.c == false) goto L17;
    L19:
        this.c = true;
        QUIManager r42 = (QUIManager) this.b.getValue();
        if (r4 == null) goto L22;
        Integer r43 = r4.getStatus();
    L23:
        if (r4 == null) goto L25;
        Long r44 = Long.valueOf(r4.getCarouselInterval());
    L26:
        if (r22 == null) goto L28;
        String r116 = r22.b;
    L29:
        if (r22 == null) goto L31;
        String r117 = r22.c;
    L32:
        if (r22 == null) goto L34;
        String r118 = r22.d;
    L35:
        r42.c(kk2.a.class, new lk2.a(r43, r8, r44, r116, r117, r118, this.j));
        if (this.d == true) goto L38;
        this.k.L(this, j.a);
    L38:
        this.k.O(this);
        this.f = r4;
        return;
    L34:
        r118 = null;
        goto L35
    L31:
        r117 = null;
        goto L32
    L28:
        r116 = null;
        goto L29
    L25:
        r44 = null;
        goto L26
    L22:
        r43 = null;
        goto L23
    L17:
        if (this.e == false) goto L19;
        v();
        goto L19
    L11:
        r5 = null;
        goto L13
    L8:
        r8 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    @Override // ak2.b
    public final void onViewAttached(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        this.e = true;
        int r0 = ph.b.a;
        ph.b.a(getView(), true);
    }

    @Override // ak2.b
    public final void onViewWillAttach(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        gk2.a.a(getView());
    }

    public FloatWindowView(Context r2, ECContext r3, LiveRoomParams r4, com.bytedance.android.livesdk.livecommerce.room.api.e r5, bk2.d r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "ecContext");
        Intrinsics.checkNotNullParameter(r5, "iLiveRoomViewHandler");
        Intrinsics.checkNotNullParameter(r6, "disposableContext");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.a = new a(r2, r3);
        this.b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new FloatWindowView$uiManager$2(this));
        this.g = LazyKt.lazy(new FloatWindowView$hideWidgetAction$2(this));
    }
}
