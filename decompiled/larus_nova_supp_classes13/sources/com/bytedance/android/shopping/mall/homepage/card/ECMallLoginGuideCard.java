package com.bytedance.android.shopping.mall.homepage.card;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.h;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.Priority;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import yj.l;
import yj.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/ECMallLoginGuideCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallLoginGuideCard extends BaseViewHolder {
    public static final Lazy s = null;
    public static final a t = null;
    public String o;
    public final SimpleDraweeView p;
    public final View q;
    public final View r;

    public static final class a {
        public a() {
        }

        public static void a(String r10) {
            IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
            if (r0 == null) goto L11;
            l r1 = r0.getIHybridHostFrescoService();
            if (r1 == null) goto L12;
            String r11 = b0.k(r10);
            if (r11 != null) goto L9;
            r11 = (String) ECMallLoginGuideCard.s.getValue();
        L9:
            l.b.b(r1, r11, Priority.IMMEDIATE, "ec_na_mall", "ec_mall_login_guide_card", null, true, "ec_mall_image_cache", 400);
            return;
        L12:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ECMallLoginGuideCard a;
        public final /* synthetic */ Ref.ObjectRef b;

        public b(ECMallLoginGuideCard r1, Ref.ObjectRef r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            Activity r1 = ECHybridExtensionsKt.a(((RecyclerView.ViewHolder) this.a).itemView.getContext());
            if (r1 == null) goto L5;
            s r0 = h.b.getIHybridHostUserService();
            Bundle r8 = (Bundle) this.b.element;
            r0.e(r1, "legou_login_guide_bottom_card", "legou_login_guide_click", null, null);
        L5:
            ECMallLoginGuideCard r9 = this.a;
            Lazy r2 = ECMallLoginGuideCard.s;
            r9.getClass();
            LinkedHashMap r3 = new LinkedHashMap();
            r3.put("EVENT_ORIGIN_FEATURE", "TEMAI");
            r3.put("bcm_description", MapsKt.mapOf(TuplesKt.to("type", "login_guide")));
            String r4 = r9.q4();
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r3.put("login_theme_id", r4);
            ToolsKt.x(r9, "click_mall_login_guide_card", "c28255.d0", r3, new JSONObject().put("type", "login_guide"));
        }
    }

    public final boolean C3() {
        return false;
    }

    public final void onHide() {
        r4(false);
    }

    public final void onShow() {
        r4(true);
        ECHybridListItemVO r0 = ((BaseViewHolder) this).c;
        if (r0 != null) goto L5;
    L7:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r1.put("bcm_description", MapsKt.mapOf(TuplesKt.to("type", "login_guide")));
        String r3 = q4();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r1.put("login_theme_id", r3);
        ECHybridListItemVO r4 = ((BaseViewHolder) this).c;
        if (r4 == null) goto L13;
        r4.K = false;
    L13:
        ToolsKt.x(this, "show_mall_login_guide_card", "c28255.d0", r1, new JSONObject().put("type", "login_guide"));
        return;
    L5:
        if (r0.K == true) goto L7;
    }

    static {
        t = new a();
        s = LazyKt.lazy(ECMallLoginGuideCard$Companion$defaultBannerUrl$2.INSTANCE);
    }

    public final String q4() {
        ECHybridListItemVO r0 = ((BaseViewHolder) this).c;
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.d();
    L7:
        if ((r2 instanceof JSONObject) == true) goto L9;
        r2 = null;
    L9:
        JSONObject r3 = (JSONObject) r2;
        if (r3 == null) goto L12;
        Object r4 = r3.opt("theme_id");
    L14:
        if ((r4 instanceof String) == false) goto L18;
        r1 = r4;
    L18:
        return (String) r1;
    L12:
        r4 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    public ECMallLoginGuideCard(View r2) {
        super(r2);
        this.p = r2.findViewById(2131370784);
        this.q = r2.findViewById(2131370785);
        this.r = r2.findViewById(2131370786);
    }

    public final void r4(boolean r11) {
        long r2 = System.currentTimeMillis();
        String r0 = this.o;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.mall.loginGuideCardVisibilityChange", r2, r0, false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("isVisible", Boolean.valueOf(r11))}), false, 32));
    }

    public final void b4(Object r6, String r7, k.a r8) {
        Intrinsics.checkNotNullParameter(r7, "itemId");
        super.b4(r6, r7, r8);
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        ViewGroup.LayoutParams r10 = null;
        r9.element = null;
        if ((r6 instanceof JSONObject) == false) goto L23;
        JSONObject r11 = (JSONObject) r6;
        Object r0 = r11.opt("banner_url");
        if ((r0 instanceof String) == true) goto L7;
        r0 = null;
    L7:
        String r1 = (String) r0;
        r9.element = new Bundle();
        Object r2 = r11.opt("theme_id");
        if ((r2 instanceof String) == true) goto L10;
        r2 = null;
    L10:
        String r3 = (String) r2;
        if (r3 == null) goto L15;
        String r4 = b0.k(r3);
        if (r4 == null) goto L15;
        ((Bundle) r9.element).putString("themeId", r4);
    L15:
        Object r12 = r11.opt("login_desc");
        if ((r12 instanceof String) == true) goto L18;
        r12 = null;
    L18:
        String r13 = (String) r12;
        if (r13 == null) goto L24;
        String r14 = b0.k(r13);
        if (r14 == null) goto L24;
        ((Bundle) r9.element).putString("loginDesc", r14);
    L24:
        boolean r15 = true;
        if (r1 != null) goto L27;
    L30:
        boolean r5 = true;
    L31:
        if (r5 == false) goto L34;
        t.getClass();
        r1 = (String) s.getValue();
    L34:
        if (this.p != null) goto L36;
    L45:
        Lazy r16 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L50;
        View r17 = this.q;
        if (r17 == null) goto L90;
        GradientDrawable r18 = new GradientDrawable();
        r18.setColor((int) 4294916946L);
        r18.setCornerRadius(b0.c(8));
        Unit r19 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r17, "$this$setBackgroundCompat");
        r17.setBackground(r18);
    L90:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new b(this, r9));
        return;
    L50:
        SimpleDraweeView r20 = this.p;
        if (r20 == null) goto L53;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
    L55:
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == true) goto L57;
        r21 = null;
    L57:
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        if (r22 == null) goto L62;
        r22.bottomMargin = b0.c(12);
        SimpleDraweeView r23 = this.p;
        if (r23 == null) goto L62;
        r23.setLayoutParams(r22);
    L62:
        View r24 = this.q;
        if (r24 == null) goto L65;
        GradientDrawable r25 = new GradientDrawable();
        r25.setColor((int) 4294916946L);
        r25.setCornerRadius(b0.c(22));
        Unit r26 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r24, "$this$setBackgroundCompat");
        r24.setBackground(r25);
    L65:
        View r27 = this.q;
        if (r27 == null) goto L68;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
    L70:
        if ((r28 instanceof ViewGroup.MarginLayoutParams) == true) goto L72;
        r28 = null;
    L72:
        ViewGroup.MarginLayoutParams r29 = (ViewGroup.MarginLayoutParams) r28;
        if (r29 == null) goto L77;
        r29.leftMargin = b0.c(29);
        r29.rightMargin = b0.c(29);
        View r30 = this.q;
        if (r30 == null) goto L77;
        r30.setLayoutParams(r29);
    L77:
        View r31 = this.r;
        if (r31 == null) goto L80;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
    L82:
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == false) goto L85;
        r10 = r32;
    L85:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r10;
        if (r33 == null) goto L90;
        r33.topMargin = b0.c(12);
        View r34 = this.r;
        if (r34 == null) goto L90;
        r34.setLayoutParams(r33);
        goto L90
    L80:
        r32 = null;
        goto L82
    L68:
        r28 = null;
        goto L70
    L53:
        r21 = null;
        goto L55
    L36:
        if (r1.length() > 0) goto L39;
        r15 = false;
    L39:
        if (r15 == false) goto L45;
        SimpleDraweeView r35 = this.p;
        Intrinsics.checkNotNull(r35);
        if (d0.b(r35, r1, "ec_na_mall", "ec_mall_login_guide_card") == true) goto L45;
        SimpleDraweeView r36 = this.p;
        if (r36 == null) goto L45;
        r36.setImageURI(r1);
        goto L45
    L27:
        if (r1.length() == 0) goto L30;
        r5 = false;
        goto L31
    L23:
        r1 = null;
        goto L24
    }
}
