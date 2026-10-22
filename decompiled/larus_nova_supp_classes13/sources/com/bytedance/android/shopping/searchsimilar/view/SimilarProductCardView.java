package com.bytedance.android.shopping.searchsimilar.view;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ECCouponView;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDepositPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.searchsimilar.adapter.SimilarProductCardAdapter;
import com.bytedance.android.shopping.searchsimilar.model.DislikeType;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import d63.j;
import gh3.g;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/SimilarProductCardView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "", "setImage", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "coupons", "setCoupons", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductCardView extends FrameLayout {
    public final FrameLayout a;
    public final SquareImageView b;
    public final TextView c;
    public final LinearLayout d;
    public final ECCouponView e;
    public final ECCouponView f;
    public final PriceView g;
    public final SimilarProductFeedbackView h;
    public final TextView i;
    public final RoundedLinearLayout j;
    public final PriceView k;
    public rd3.a l;
    public Integer m;
    public SimilarProductVM n;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SimilarProductCardView a;
        public final /* synthetic */ Context b;

        public a(SimilarProductCardView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            SimilarProductCardView r12 = this.a;
            SimilarProductFeedbackView r0 = r12.h;
            if (r0 == null) goto L5;
            r0.a(r12);
        L5:
            SimilarProductFeedbackView r13 = this.a.h;
            if (r13 != null) goto L8;
        L13:
            int r14 = g.a;
            Context r15 = this.b;
            Integer r1 = this.a.m;
            String r2 = null;
            if (r1 == null) goto L16;
            String r3 = String.valueOf(r1.intValue() + 1);
        L17:
            SimilarProductCardView r4 = this.a;
            g.a(r15, "click_product", r3, r4.n, r4.l);
            int r16 = com.bytedance.android.shopping.searchsimilar.utils.g.a;
            SimilarProductCardView r17 = this.a;
            rd3.a r5 = r17.l;
            SimilarProductVM r18 = r17.n;
            if (r18 == null) goto L60;
            if (r5 == null) goto L60;
            Promotion r6 = r5.f();
            if (r6 == null) goto L60;
            String r7 = r6.getLink();
            if (r7 == null) goto L60;
            Uri r8 = UriProtector.parse(r7);
            JSONObject r9 = k.w(UriProtector.getQueryParameter(r8, "meta_params"));
            if (r9 != null) goto L28;
            r9 = new JSONObject();
        L28:
            JSONObject r10 = k.w(r9.optString("entrance_info"));
            if (r10 != null) goto L31;
            r10 = new JSONObject();
        L31:
            SimilarProductParam r19 = r18.getSimilarProductParam();
            if (r19 == null) goto L34;
            String r20 = r19.getEnterFrom();
        L35:
            r10.put("carrier_source", r20);
            r10.put("source_method", "similar_product_homepage");
            r10.put("ecom_group_type", "product_card");
            r10.put("key_id", r18.getProductFrameId());
            r10.put("key_rank", r18.getFrameRank());
            Promotion r21 = r5.f();
            if (r21 == null) goto L42;
            PromotionProductStruct r22 = r21.getPromotionInfo();
            if (r22 == null) goto L42;
            PromotionProductExtraStruct r23 = r22.getExtraInfo();
            if (r23 == null) goto L42;
            String r24 = r23.getSimilarProductType();
        L43:
            r10.put("similar_type", r24);
            r9.put("entrance_info", r10.toString());
            Set r25 = j1.b(r8);
            Uri.Builder r26 = r8.buildUpon().clearQuery();
            if (r25 == null) goto L52;
            Iterator r27 = r25.iterator();
        L47:
            if (r27.hasNext() == false) goto L52;
            String r28 = (String) r27.next();
            if (StringsKt.equals$default(r28, "meta_params", false, 2, null) == false) goto L50;
            r26.appendQueryParameter("meta_params", r9.toString());
            goto L47
        L50:
            r26.appendQueryParameter(r28, UriProtector.getQueryParameter(r8, r28));
        L52:
            SimilarProductParam r29 = r18.getSimilarProductParam();
            if (r29 == null) goto L55;
            String r30 = r29.getAwemeId();
        L56:
            Uri.Builder r31 = r26.appendQueryParameter(PdpOpenThirdParam.KEY_ITEM_ID, r30);
            SimilarProductParam r110 = r18.getSimilarProductParam();
            if (r110 == null) goto L59;
            r2 = r110.getAuthorId();
        L59:
            r2 = r31.appendQueryParameter("kol_id", r2).build().toString();
            goto L60
        L55:
            r30 = null;
        L42:
            r24 = null;
            goto L43
        L34:
            r20 = null;
        L60:
            p.a.openSchema(this.b, r2);
            return;
        L16:
            r3 = null;
            goto L17
        L8:
            if (r13.getVisibility() != 0) goto L13;
            SimilarProductCardView r111 = this.a;
            SimilarProductFeedbackView r32 = r111.h;
            if (r32 == null) goto L68;
            r32.b(false, r111);
            return;
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ SimilarProductCardView a;

        public b(SimilarProductCardView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            SimilarProductCardView r4 = this.a;
            SimilarProductFeedbackView r0 = r4.h;
            if (r0 == null) goto L5;
            r0.b(true, r4);
        L5:
            return true;
        }
    }

    public static final class c {
    }

    static {
    }

    public SimilarProductCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SimilarProductCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setCoupons(List<PromotionDiscountLabel> r12) {
        if (r12 == null) goto L4;
        PromotionDiscountLabel r0 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r12);
    L6:
        if (r0 == null) goto L43;
        LinearLayout r2 = this.d;
        if (r2 == null) goto L10;
        r2.setVisibility(0);
    L10:
        ECCouponView r3 = this.e;
        if (r3 == null) goto L13;
        r3.setVisibility(0);
    L13:
        ECCouponView r4 = this.e;
        if (r4 == null) goto L16;
        ECCouponView.a(r4, r0.getTag(), r0.getTagHeader(), true, null, 24);
    L16:
        ECCouponView r1 = this.e;
        if (r1 == null) goto L24;
        TextView r5 = r1.b;
        if (r5 == null) goto L21;
        r5.setTextSize(1, 10.0f);
    L21:
        TextView r6 = r1.a;
        if (r6 == null) goto L24;
        r6.setTextSize(1, 10.0f);
    L24:
        PromotionDiscountLabel r13 = (PromotionDiscountLabel) CollectionsKt.getOrNull(r12, 1);
        if (r13 == null) goto L40;
        ECCouponView r7 = this.f;
        if (r7 == null) goto L29;
        r7.setVisibility(0);
    L29:
        ECCouponView r8 = this.f;
        if (r8 == null) goto L32;
        ECCouponView.a(r8, r13.getTag(), r13.getTagHeader(), true, null, 24);
    L32:
        ECCouponView r14 = this.f;
        if (r14 == null) goto L50;
        TextView r9 = r14.b;
        if (r9 == null) goto L37;
        r9.setTextSize(1, 10.0f);
    L37:
        TextView r15 = r14.a;
        if (r15 == null) goto L51;
        r15.setTextSize(1, 10.0f);
        return;
    L51:
        return;
    L50:
        return;
    L40:
        ECCouponView r16 = this.f;
        if (r16 == null) goto L53;
        r16.setVisibility(8);
        return;
    L53:
        return;
    L43:
        ECCouponView r17 = this.e;
        if (r17 == null) goto L46;
        r17.setVisibility(8);
    L46:
        LinearLayout r18 = this.d;
        if (r18 == null) goto L55;
        r18.setVisibility(8);
        return;
    L55:
        return;
    L4:
        r0 = null;
        goto L6
    }

    private final void setImage(ECUrlModel r5) {
        if (r5 == null) goto L7;
        List r1 = r5.getUrlList();
        if (r1 == null) goto L7;
        String r2 = (String) CollectionsKt.firstOrNull(r1);
    L9:
        if (k.c(r2) == false) goto L18;
        SquareImageView r3 = this.b;
        int r4 = -1;
        if (r5 == null) goto L13;
        int r6 = r5.getWidth();
    L14:
        if (r5 == null) goto L16;
        r4 = r5.getHeight();
    L16:
        y.c(r3, r5, r6, r4, null);
        return;
    L13:
        r6 = -1;
        goto L14
    L18:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public SimilarProductCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560659, this, true);
        FrameLayout r5 = (FrameLayout) findViewById(2131371009);
        this.a = r5;
        this.b = findViewById(2131371006);
        this.c = (TextView) findViewById(2131371012);
        this.d = (LinearLayout) findViewById(2131371001);
        this.e = findViewById(2131371005);
        this.f = findViewById(2131371011);
        this.g = findViewById(2131371007);
        this.h = (SimilarProductFeedbackView) findViewById(2131371004);
        this.i = (TextView) findViewById(2131371010);
        this.j = findViewById(2131371003);
        this.k = findViewById(2131371002);
        if (r5 == null) goto L5;
        r5.setOnClickListener(new a(this, r2));
    L5:
        if (r5 == null) goto L8;
        r5.setOnLongClickListener(new b(this));
        return;
    }

    public /* synthetic */ SimilarProductCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(rd3.a r19, SimilarProductVM r20, Integer r21, RecyclerView r22, SimilarProductCardAdapter r23, Function0<Unit> r24) {
        Intrinsics.checkNotNullParameter(r20, "vm");
        Intrinsics.checkNotNullParameter(r23, "adapter");
        this.l = r19;
        this.m = r21;
        this.n = r20;
        ViewGroup r11 = null;
        if (r19 == null) goto L13;
        Promotion r4 = r19.f();
        if (r4 == null) goto L13;
        PromotionProductStruct r5 = r4.getPromotionInfo();
        if (r5 == null) goto L13;
        PromotionProductBaseStruct r6 = r5.getBaseInfo();
        if (r6 == null) goto L13;
        List r7 = r6.getImages();
        if (r7 == null) goto L13;
        ECUrlModel r8 = (ECUrlModel) CollectionsKt.firstOrNull(r7);
    L14:
        setImage(r8);
        if (r19 == null) goto L23;
        Promotion r9 = r19.f();
        if (r9 == null) goto L23;
        PromotionProductStruct r10 = r9.getPromotionInfo();
        if (r10 == null) goto L23;
        PromotionProductBaseStruct r12 = r10.getBaseInfo();
        if (r12 == null) goto L23;
        String r13 = r12.getTitle();
    L24:
        if (r19 == null) goto L36;
        Promotion r14 = r19.f();
        if (r14 == null) goto L36;
        PromotionProductStruct r15 = r14.getPromotionInfo();
        if (r15 == null) goto L36;
        PromotionProductPrivilegesStruct r16 = r15.getPrivilegeInfo();
        if (r16 == null) goto L36;
        PromotionProductActivitiesStruct r17 = r16.getActivities();
        if (r17 == null) goto L36;
        PromotionMarketFloor r18 = r17.getPlatformTextActivity();
        if (r18 == null) goto L36;
        ECUrlModel r25 = r18.getIcon();
    L37:
        if (r25 == null) goto L41;
        List r26 = r25.getUrlList();
        if (r26 == null) goto L41;
        String r27 = (String) CollectionsKt.firstOrNull(r26);
    L43:
        if (k.c(r27) == false) goto L45;
        y.l(r25, 0, 0, new com.bytedance.android.shopping.searchsimilar.view.b(this, new SpannableStringBuilder(), r13));
    L48:
        if (r19 == null) goto L54;
        Promotion r28 = r19.f();
        if (r28 == null) goto L54;
        PromotionProductStruct r29 = r28.getPromotionInfo();
        if (r29 == null) goto L54;
        final ActivityVO r30 = f53.a.c(r29);
    L55:
        if (r19 == null) goto L61;
        Promotion r31 = r19.f();
        if (r31 == null) goto L61;
        PromotionProductStruct r32 = r31.getPromotionInfo();
        if (r32 == null) goto L61;
        final j r33 = d63.k.a(r32);
    L62:
        if (r33 == null) goto L70;
        if (r30 == null) goto L70;
        PriceView r34 = this.g;
        if (r34 == null) goto L67;
        r34.C(new SimilarProductCardView$updatePrefixText$1(this, r30, r33));
    L67:
        PriceView r35 = this.g;
        if (r35 == null) goto L73;
        r35.C(new SimilarProductCardView$updatePrice$1(this, r33));
    L73:
        if (r19 == null) goto L83;
        Promotion r36 = r19.f();
        if (r36 == null) goto L83;
        PromotionProductStruct r37 = r36.getPromotionInfo();
        if (r37 == null) goto L83;
        PromotionProductPriceStruct r38 = r37.getProductPrice();
        if (r38 == null) goto L83;
        PromotionDepositPrice r39 = r38.getDepositPrice();
        if (r39 == null) goto L83;
        final Long r40 = Long.valueOf(r39.getDepositPrice());
    L84:
        PriceView r41 = this.k;
        if (r41 == null) goto L87;
        r41.C(new SimilarProductCardView$setDepositPresalePrice$1(this, r30, r40));
    L87:
        if (r19 == null) goto L95;
        Promotion r42 = r19.f();
        if (r42 == null) goto L95;
        PromotionProductStruct r43 = r42.getPromotionInfo();
        if (r43 == null) goto L95;
        PromotionProductBaseStruct r44 = r43.getBaseInfo();
        if (r44 == null) goto L95;
        Long r45 = r44.getSales();
    L97:
        if (r45 != null) goto L99;
    L110:
        TextView r46 = this.i;
        if (r46 == null) goto L113;
        r46.setText(null);
    L113:
        TextView r47 = this.i;
        if (r47 == null) goto L116;
        r47.setVisibility(8);
    L116:
        SimilarProductFeedbackView r110 = this.h;
        if (r110 == null) goto L141;
        Intrinsics.checkNotNullParameter(r20, "vm");
        Intrinsics.checkNotNullParameter(r23, "adapter");
        LinearLayout r2 = r110.a;
        if (r2 == null) goto L121;
        r2.removeAllViews();
    L121:
        r110.c = r23;
        r110.d = r22;
        r110.setVisibility(8);
        Iterator<T> r111 = r20.getFeedbackList().iterator();
        int r112 = 0;
    L123:
        if (r111.hasNext() == false) goto L145;
        Object r1 = r111.next();
        int r113 = r112 + 1;
        if (r112 >= 0) goto L127;
        CollectionsKt.throwIndexOverflow();
    L127:
        DislikeType r114 = (DislikeType) r1;
        View r48 = LayoutInflater.from(r110.getContext()).inflate(2131560660, r11);
        r48.setOnClickListener(new com.bytedance.android.shopping.searchsimilar.view.c(r48, r114, r112, r110, r24, r19, r20));
        SimpleDraweeView r3 = r48.findViewById(2131370683);
        TextView r49 = (TextView) r48.findViewById(2131370684);
        String r50 = r114.getIcon();
        if (r50 == null) goto L130;
        r3.setVisibility(0);
        ViewGroup r51 = null;
        y.e(r3, r50, th.a.f(r110.getContext()).getDimensionPixelOffset(2131165719), th.a.f(r110.getContext()).getDimensionPixelOffset(2131165719), null);
    L131:
        String r52 = r114.getName();
        if (r52 == null) goto L134;
        r49.setVisibility(0);
        r49.setText(r52);
    L134:
        LinearLayout.LayoutParams r53 = new LinearLayout.LayoutParams(-2, -2);
        if (r112 == 0) goto L137;
        r53.setMargins(0, com.bytedance.android.shopping.extensions.b.b(20), 0, 0);
    L137:
        LinearLayout r54 = r110.a;
        if (r54 == null) goto L140;
        r54.addView(r48, r53);
    L140:
        r11 = r51;
        r112 = r113;
        goto L123
    L130:
        r51 = null;
        goto L131
    L145:
        return;
    L141:
        return;
    L99:
        if (r45.longValue() == 0) goto L110;
        if (r30 != null) goto L102;
    L104:
        TextView r55 = this.i;
        if (r55 == null) goto L107;
        int r56 = g1.a;
        r55.setText(g1.a.c(getContext(), 2131913980, new Object[]{r45}));
    L107:
        TextView r57 = this.i;
        if (r57 == null) goto L116;
        r57.setVisibility(0);
        goto L116
    L102:
        if (r30.getActivityType() != 8) goto L104;
    L95:
        r45 = null;
    L83:
        r40 = null;
    L70:
        PriceView r58 = this.g;
        if (r58 == null) goto L73;
        r58.C(SimilarProductCardView$setPrice$1.INSTANCE);
    L61:
        r33 = null;
    L54:
        r30 = null;
        goto L55
    L45:
        TextView r59 = this.c;
        if (r59 == null) goto L48;
        r59.setText(r13);
    L41:
        r27 = null;
    L36:
        r25 = null;
    L23:
        r13 = null;
    L13:
        r8 = null;
        goto L14
    }
}
