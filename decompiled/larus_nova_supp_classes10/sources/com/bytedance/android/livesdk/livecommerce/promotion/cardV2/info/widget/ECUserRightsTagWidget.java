package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECUserRightsTagWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/a;", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tagList", "", "setUserRightsAssuranceTagArea", "", "getCurrentContentDescription", "getType", "()Ljava/lang/String;", LocationMonitorConst.TYPE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUserRightsTagWidget extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {
    public List<ECRitTag> a;
    public StringBuilder b;
    public com.bytedance.android.livesdk.livecommerce.promotion.card.k c;
    public final fj2.b d;

    public static final class a {
    }

    public static final class b implements fj2.a<ECDraweeView> {
        public final /* synthetic */ ECUserRightsTagWidget a;

        @Override // fj2.a
        public final String type() {
            return "tag_item_image";
        }

        @Override // fj2.a
        public final ECDraweeView create() {
            ECDraweeView r6 = new ECDraweeView(this.a.getContext(), null, 0, 6, null);
            r6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            return r6;
        }

        public b(ECUserRightsTagWidget r1) {
            this.a = r1;
        }
    }

    static {
    }

    public ECUserRightsTagWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECUserRightsTagWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "user_right_tag_widget";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.b;
        if (r0 == null) goto L5;
        StringsKt.clear(r0);
    L5:
        List<ECRitTag> r1 = this.a;
        if (r1 == null) goto L17;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        List r3 = ((ECRitTag) r2.next()).getText();
        if (r3 == null) goto L9;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L9;
        StringBuilder r5 = this.b;
        if (r5 == null) goto L9;
        r5.append(r4);
    L17:
        StringBuilder r6 = this.b;
        if (r6 != null) goto L31;
        return "";
    L31:
        return String.valueOf(r6);
    }

    private final void setUserRightsAssuranceTagArea(List<ECRitTag> r13) {
        if ((!Intrinsics.areEqual(this.a, r13)) == false) goto L77;
        this.a = r13;
        removeAllViews();
        Iterator<T> r14 = r13.iterator();
        int r2 = 0;
    L6:
        if (r14.hasNext() == false) goto L67;
        Object r3 = r14.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ECRitTag r5 = (ECRitTag) r3;
        ECUIConfig r6 = r5.getUiConfig();
        ViewGroup.LayoutParams r7 = null;
        if (r6 != null) goto L13;
    L33:
        if (r6 != null) goto L35;
    L44:
        if (r2 <= 0) goto L46;
        addView(this.d.a(new p(this)));
    L46:
        ECUrlModel r8 = r5.getTextIcon();
        if (r8 == null) goto L52;
        if (r2 == 0) goto L50;
        boolean r9 = true;
    L51:
        addView(b(r8, r9, cg4.a.a(r5.getFirstText())));
        goto L52
    L50:
        r9 = false;
    L52:
        String r10 = r5.getFirstText();
        if (r10 == null) goto L65;
        boolean r11 = cg4.a.a(r5.getFirstIconUrl());
        TextView r12 = (TextView) this.d.a(new r(this));
        r12.setText(r10);
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if ((r15 instanceof LinearLayout.LayoutParams) == false) goto L58;
        r7 = r15;
    L58:
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r7;
        if (r16 == null) goto L64;
        if (r11 == false) goto L62;
        int r17 = 0;
    L63:
        r16.leftMargin = r17;
        goto L64
    L62:
        r17 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L64:
        addView(r12);
    L65:
        r2 = r4;
        goto L6
    L35:
        if (r6.getTextSplitorStyle() != 2) goto L44;
        if (r2 <= 0) goto L38;
        TextView r18 = (TextView) this.d.a(new q(this));
        int r19 = com.bytedance.android.ec.core.utils.s.a;
        r18.setTextColor(com.bytedance.android.ec.core.utils.s.a(r6.getTextColor(), th.a.a(r18.getContext(), 2131106228)));
        addView(r18);
    L38:
        ECUrlModel r20 = r5.getTextIcon();
        if (r20 == null) goto L41;
        addView(b(r20, false, cg4.a.a(r5.getFirstText())));
    L41:
        String r21 = r5.getFirstText();
        if (r21 == null) goto L65;
        TextView r22 = (TextView) this.d.a(new t(this));
        r22.setText(r21);
        int r23 = com.bytedance.android.ec.core.utils.s.a;
        r22.setTextColor(com.bytedance.android.ec.core.utils.s.a(r6.getTextColor(), th.a.a(r22.getContext(), 2131106228)));
        addView(r22);
        goto L65
    L13:
        if (r6.getTextSplitorStyle() != 0) goto L33;
        ECUrlModel r24 = r5.getTextIcon();
        if (r24 == null) goto L20;
        if (r2 == 0) goto L18;
        boolean r110 = true;
    L19:
        addView(b(r24, r110, cg4.a.a(r5.getFirstText())));
        goto L20
    L18:
        r110 = false;
    L20:
        String r25 = r5.getFirstText();
        if (r25 == null) goto L65;
        View r26 = this.d.a(new s(this));
        TextView r111 = (TextView) r26;
        r111.setText(r25);
        ViewGroup.LayoutParams r27 = r111.getLayoutParams();
        if ((r27 instanceof LinearLayout.LayoutParams) == false) goto L26;
        r7 = r27;
    L26:
        LinearLayout.LayoutParams r28 = (LinearLayout.LayoutParams) r7;
        if (r28 == null) goto L32;
        if (r2 <= 0) goto L30;
        int r29 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L31:
        r28.leftMargin = r29;
        goto L32
    L30:
        r29 = 0;
    L32:
        int r30 = com.bytedance.android.ec.core.utils.s.a;
        r111.setTextColor(com.bytedance.android.ec.core.utils.s.a(r6.getTextColor(), th.a.a(r111.getContext(), 2131106228)));
        GradientDrawable r31 = new GradientDrawable();
        r31.setCornerRadius(UtilityKotlinExtentionsKt.c(3));
        r31.setColor(com.bytedance.android.ec.core.utils.s.a(r6.getTextBgColor(), th.a.a(r111.getContext(), 2131106784)));
        r31.setStroke(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), com.bytedance.android.ec.core.utils.s.a(r6.getTextBorderColor(), th.a.a(r111.getContext(), 2131106784)));
        Unit r32 = Unit.INSTANCE;
        r111.setBackgroundDrawable(r31);
        addView(r26);
        goto L65
    L67:
        if (getChildCount() <= 0) goto L78;
        addView(new Space(getContext()), new LinearLayout.LayoutParams(1, 0));
        return;
    L78:
        return;
    }

    public final void a(List<ECRitTag> r2, com.bytedance.android.livesdk.livecommerce.promotion.card.k r3) {
        Intrinsics.checkNotNullParameter(r2, "tagList");
        Intrinsics.checkNotNullParameter(r3, "uiConfig");
        this.b = new StringBuilder();
        this.c = r3;
        if ((!r2.isEmpty()) == true) goto L6;
        r2 = null;
    L6:
        if (r2 == null) goto L13;
        setUserRightsAssuranceTagArea(r2);
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        RitTagTrack r5 = ((ECRitTag) r4.next()).getTagTrack();
        if (r5 == null) goto L9;
        r5.setVisibile(true);
        goto L9
    L19:
        return;
    }

    public ECUserRightsTagWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new fj2.b();
        setGravity(8388627);
        setOrientation(0);
    }

    public final View b(ECUrlModel r6, boolean r7, boolean r8) {
        ECDraweeView r0 = this.d.a(new b(this));
        ECDraweeView r1 = r0;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r2 = null;
    L5:
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
        if (r3 == null) goto L15;
        int r4 = 0;
        if (r8 == false) goto L10;
        int r9 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L11:
        r3.rightMargin = r9;
        if (r7 == false) goto L14;
        r4 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L14:
        r3.leftMargin = r4;
        goto L15
    L10:
        r9 = 0;
    L15:
        String r10 = r6.getFirstUrl();
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        y.g(r1, r10, UtilityKotlinExtentionsKt.d(Integer.valueOf(r6.getWidth())), UtilityKotlinExtentionsKt.d(Integer.valueOf(r6.getHeight())));
        return r0;
    }

    public /* synthetic */ ECUserRightsTagWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        int r8 = getChildCount() - 1;
    L3:
        if (r8 < 0) goto L19;
        View r9 = getChildAt(r8);
        if (r9.getVisibility() == 8) goto L12;
        if ((r9.getLeft() + r9.getMeasuredWidth()) < getMeasuredWidth()) goto L10;
        r9.layout(r4, r5, r4, r7);
        goto L12
    L10:
        if (Intrinsics.areEqual(r9.getTag(), "divider") == false) goto L13;
        r9.layout(r4, r5, r4, r7);
        return;
    L13:
        return;
    L12:
        r8 = r8 - 1;
        goto L3
    }
}
