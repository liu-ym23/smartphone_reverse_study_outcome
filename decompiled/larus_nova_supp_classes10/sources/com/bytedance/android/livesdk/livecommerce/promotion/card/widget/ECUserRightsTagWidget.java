package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECUserRightsTagWidget;", "Landroid/widget/LinearLayout;", "Lij2/a;", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tagList", "", "setUserRightsAssuranceTagArea", "", "getCurrentContentDescription", "getType", "()Ljava/lang/String;", LocationMonitorConst.TYPE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUserRightsTagWidget extends LinearLayout implements ij2.a {
    public List<ECRitTag> a;
    public StringBuilder b;
    public final fj2.b c;

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

    @Override // ij2.a
    public String getType() {
        return "user_right_tag_widget";
    }

    @Override // ij2.a
    public final void release() {
    }

    @Override // ij2.a
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

    @Override // ij2.a
    public final boolean a() {
        return ij2.a.C0143a.b(this);
    }

    @Override // ij2.a
    public ij2.b getParentContainer() {
        return ij2.a.C0143a.a(this);
    }

    private final void setUserRightsAssuranceTagArea(List<ECRitTag> r14) {
        if ((!Intrinsics.areEqual(this.a, r14)) == false) goto L66;
        this.a = r14;
        removeAllViews();
        Iterator<T> r15 = r14.iterator();
        int r2 = 0;
    L6:
        if (r15.hasNext() == false) goto L74;
        Object r3 = r15.next();
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
        addView(this.c.a(new h(this)));
    L46:
        ECUrlModel r8 = r5.getTextIcon();
        if (r8 == null) goto L52;
        if (r2 == 0) goto L50;
        boolean r9 = true;
    L51:
        addView(c(r8, r9, cg4.a.a(r5.getFirstText())));
        goto L52
    L50:
        r9 = false;
    L52:
        String r10 = r5.getFirstText();
        if (r10 == null) goto L65;
        boolean r11 = cg4.a.a(r5.getFirstIconUrl());
        TextView r12 = (TextView) this.c.a(new j(this));
        r12.setText(r10);
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if ((r13 instanceof LinearLayout.LayoutParams) == false) goto L58;
        r7 = r13;
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
        TextView r18 = (TextView) this.c.a(new i(this));
        int r19 = s.a;
        r18.setTextColor(s.a(r6.getTextColor(), th.a.a(r18.getContext(), 2131106228)));
        addView(r18);
    L38:
        ECUrlModel r20 = r5.getTextIcon();
        if (r20 == null) goto L41;
        addView(c(r20, false, cg4.a.a(r5.getFirstText())));
    L41:
        String r21 = r5.getFirstText();
        if (r21 == null) goto L65;
        TextView r22 = (TextView) this.c.a(new l(this));
        r22.setText(r21);
        int r23 = s.a;
        r22.setTextColor(s.a(r6.getTextColor(), th.a.a(r22.getContext(), 2131106228)));
        addView(r22);
        goto L65
    L13:
        if (r6.getTextSplitorStyle() != 0) goto L33;
        ECUrlModel r110 = r5.getTextIcon();
        if (r110 == null) goto L20;
        if (r2 == 0) goto L18;
        boolean r111 = true;
    L19:
        addView(c(r110, r111, cg4.a.a(r5.getFirstText())));
        goto L20
    L18:
        r111 = false;
    L20:
        String r24 = r5.getFirstText();
        if (r24 == null) goto L65;
        View r112 = this.c.a(new k(this));
        TextView r113 = (TextView) r112;
        r113.setText(r24);
        ViewGroup.LayoutParams r25 = r113.getLayoutParams();
        if ((r25 instanceof LinearLayout.LayoutParams) == false) goto L26;
        r7 = r25;
    L26:
        LinearLayout.LayoutParams r26 = (LinearLayout.LayoutParams) r7;
        if (r26 == null) goto L32;
        if (r2 <= 0) goto L30;
        int r27 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L31:
        r26.leftMargin = r27;
        goto L32
    L30:
        r27 = 0;
    L32:
        int r28 = s.a;
        r113.setTextColor(s.a(r6.getTextColor(), th.a.a(r113.getContext(), 2131106228)));
        GradientDrawable r29 = new GradientDrawable();
        r29.setCornerRadius(UtilityKotlinExtentionsKt.c(2));
        r29.setColor(s.a(r6.getTextBgColor(), th.a.a(r113.getContext(), 2131106155)));
        Unit r30 = Unit.INSTANCE;
        r113.setBackgroundDrawable(r29);
        addView(r112);
        goto L65
    L74:
        return;
    }

    @Override // ij2.a
    public final void b(com.bytedance.android.ec.common.api.jump.model.e r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        ECUIPromotion r4 = r3.a;
        this.b = new StringBuilder();
        Map r5 = r4.getRitTag();
        if (r5 == null) goto L17;
        List<ECRitTag> r6 = (List) r5.get("live_room_good_list_user_right");
        if (r6 != null) goto L7;
        return;
    L7:
        if ((!r6.isEmpty()) == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L24;
        setUserRightsAssuranceTagArea(r6);
        Iterator<T> r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L25;
        RitTagTrack r0 = ((ECRitTag) r7.next()).getTagTrack();
        if (r0 == null) goto L13;
        r0.setVisibile(true);
        goto L13
    L25:
        return;
    L24:
        return;
    }

    public ECUserRightsTagWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new fj2.b();
        setGravity(8388627);
        setOrientation(0);
    }

    public final View c(ECUrlModel r6, boolean r7, boolean r8) {
        ECDraweeView r0 = this.c.a(new b(this));
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
