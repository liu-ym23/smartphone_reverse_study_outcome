package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentStatStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.z;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0017\u0018\u0019B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowFeedCommentView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "count", "", "setCommentCount", "", "value", "e", "Ljava/lang/Integer;", "getStyle", "()Ljava/lang/Integer;", "setStyle", "(Ljava/lang/Integer;)V", "style", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CommentAdapter", "CommentItemVH", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedCommentView extends FrameLayout implements c {
    public TextView a;
    public ECViewFlipper b;
    public final CommentAdapter c;
    public rd3.a d;
    public Integer e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowFeedCommentView$CommentAdapter;", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class CommentAdapter extends ECViewFlipper.ECViewFlipperAdapter {
        public List<PromotionProductCommentStruct> a;
        public final /* synthetic */ InflowFeedCommentView b;

        public final int getFlipperItemCount() {
            List<PromotionProductCommentStruct> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public CommentAdapter(InflowFeedCommentView r1) {
            this.b = r1;
        }

        public final void onBindViewFlipperHolder(ECViewFlipper.ECViewFlipperHolder r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "holder");
            List<PromotionProductCommentStruct> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if ((r3 instanceof CommentItemVH) == true) goto L7;
            r3 = null;
        L7:
            CommentItemVH r5 = (CommentItemVH) r3;
            if (r5 == null) goto L15;
            PromotionProductCommentStruct r6 = (PromotionProductCommentStruct) ListProtector.get(r0, r4);
            Intrinsics.checkNotNullParameter(r6, "comment");
            View r7 = ((RecyclerView.ViewHolder) r5).itemView;
            if (r7 == null) goto L13;
            InflowFeedCommentItemView r8 = (InflowFeedCommentItemView) r7;
            Intrinsics.checkNotNullParameter(r6, "comment");
            y.a(r8.b, r6.getUserAvatar());
            r8.a.setText(r6.getContent());
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.view.InflowFeedCommentItemView");
        }

        public final ECViewFlipper.ECViewFlipperHolder onCreateViewFlipperHolder(ViewGroup r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "parent");
            return new CommentItemVH(new InflowFeedCommentItemView(this.b.getContext(), null, 6, 0));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowFeedCommentView$CommentItemVH;", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperHolder;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommentItemVH extends ECViewFlipper.ECViewFlipperHolder {
        public CommentItemVH(InflowFeedCommentItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ InflowFeedCommentView a;

        public a(InflowFeedCommentView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r18) {
            InflowFeedCommentView r2 = this.a;
            rd3.a r0 = r2.d;
            if (r0 == null) goto L136;
            Promotion r1 = r0.f();
            if (r1 == null) goto L137;
            PromotionProductStruct r3 = r1.getPromotionInfo();
            if (r3 == null) goto L138;
            PromotionProductCommentsStruct r4 = r3.getCommentInfo();
            if (r4 == null) goto L139;
            List r5 = r4.getComments();
            if (r5 != null) goto L14;
            return;
        L14:
            if (r5.size() < 1) goto L142;
            ECViewFlipper r6 = r2.b;
            if (r6 == null) goto L19;
            int r7 = r6.getCurrentPos();
        L20:
            PromotionProductCommentStruct r8 = (PromotionProductCommentStruct) CollectionsKt.getOrNull(r5, r7);
            if (r8 == null) goto L140;
            Lazy r9 = ECSettingKeys.a;
            int r10 = com.bytedance.android.ec.core.opt.ab.p.a;
            Object r11 = "sslocal://ec_goods_comment/?comment_entrance=product_flow_page&show_header=1";
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L27
            jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L27
            Object r14 = jj4.a.a("ec_commerce_inflow_feed_jump_comment_schema", String.class, "sslocal://ec_goods_comment/?comment_entrance=product_flow_page&show_header=1", false);     // Catch: Throwable -> L27
            if (r14 != null) goto L33;
            Intrinsics.throwNpe();     // Catch: Throwable -> L27
        L33:
            Uri.Builder r15 = UriProtector.parse((String) r14).buildUpon();
            rd3.a r16 = r2.d;
            if (r16 == null) goto L42;
            Promotion r17 = r16.f();
            if (r17 == null) goto L42;
            PromotionProductStruct r19 = r17.getPromotionInfo();
            if (r19 == null) goto L42;
            PromotionProductBaseStruct r20 = r19.getBaseInfo();
            if (r20 == null) goto L42;
            String r21 = r20.getProductId();
        L43:
            r15.appendQueryParameter(PdpOpenThirdParam.KEY_PRODUCT_ID, r21);
            r15.appendQueryParameter("top_comment_ids", String.valueOf(r8.getId()));
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(r2.getContext(), r15.build().toString());
            FeedProductEventTracker r22 = FeedProductEventTracker.a;
            rd3.a r23 = r2.d;
            r22.getClass();
            if (r23 == null) goto L48;
            ProductFeedViewModel r24 = r23.c;
            if (r24 == null) goto L48;
            AnchorV3Param r25 = r24.m907getAnchorV3Param();
        L49:
            String r26 = "";
            if (r25 == null) goto L59;
            String r27 = r25.getEntranceInfo();
            if (r27 == null) goto L59;
            JSONObject r28 = z1.g(r27);
            if (r28 == null) goto L59;
            String r29 = r28.optString("product_source_page", "");
            if (r29 != null) goto L58;
            r29 = "";
        L58:
            String r110 = r29;
        L61:
            if (r23 == null) goto L72;
            Promotion r30 = r23.f();
            if (r30 == null) goto L72;
            PromotionProductStruct r31 = r30.getPromotionInfo();
            if (r31 == null) goto L72;
            PromotionProductBaseStruct r32 = r31.getBaseInfo();
            if (r32 == null) goto L72;
            String r33 = r32.getProductId();
            if (r33 == null) goto L72;
            String r34 = r33;
        L73:
            if (r23 != null) goto L75;
        L77:
            String r35 = "";
        L78:
            if (r25 == null) goto L83;
            String r36 = r25.getAuthorId();
            if (r36 == null) goto L83;
            String r111 = r36;
        L84:
            if (r23 == null) goto L95;
            ProductFeedViewModel r37 = r23.c;
            if (r37 == null) goto L95;
            PromotionProductStruct r38 = r37.getPromotion();
            if (r38 == null) goto L95;
            PromotionProductBaseStruct r39 = r38.getBaseInfo();
            if (r39 == null) goto L95;
            String r40 = r39.getPromotionId();
            if (r40 == null) goto L95;
            String r112 = r40;
        L96:
            if (r23 == null) goto L104;
            ProductFeedViewModel r41 = r23.c;
            if (r41 == null) goto L104;
            PromotionProductStruct r42 = r41.getPromotion();
            if (r42 == null) goto L104;
            PromotionProductBaseStruct r43 = r42.getBaseInfo();
            if (r43 == null) goto L104;
            Integer r44 = r43.getPromotionSource();
        L105:
            String r113 = String.valueOf(r44);
            if (r25 == null) goto L113;
            Integer r45 = r25.getFollowStatus();
            if (r45 == null) goto L113;
            String r46 = String.valueOf(r45.intValue());
            if (r46 == null) goto L113;
            String r114 = r46;
        L114:
            if (r25 == null) goto L119;
            String r47 = r25.getVideoId();
            if (r47 == null) goto L119;
            String r115 = r47;
        L120:
            if (r23 != null) goto L122;
        L124:
            if (r25 == null) goto L131;
            ECLogExtraData r48 = r25.getLogExtraData();
            if (r48 == null) goto L131;
            String r49 = r48.getEComEntranceForm();
            if (r49 == null) goto L131;
            String r116 = r49;
        L132:
            new z(r34, r35, r111, r112, r113, r114, r115, r110, r116).post(null, null);
            return;
        L131:
            r116 = r26;
            goto L132
        L122:
            if (r23.e != true) goto L124;
            r26 = "guess_you_like";
        L119:
            r115 = "";
        L113:
            r114 = "";
        L104:
            r44 = null;
        L95:
            r112 = "";
        L83:
            r111 = "";
            goto L84
        L75:
            if (r23.e != true) goto L77;
            r35 = "guess_you_like_product";
        L72:
            r34 = "";
        L59:
            r110 = "";
        L48:
            r25 = null;
        L42:
            r21 = null;
        L27:
            th = move-exception;
            Result.Companion r50 = Result.Companion;
            Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r51) == true) goto L32;
            r11 = r51;
        L32:
            r14 = r11;
            goto L33
        L140:
            return;
        L19:
            r7 = 0;
            goto L20
        L142:
            return;
        L139:
            return;
        L138:
            return;
        L137:
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public InflowFeedCommentView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowFeedCommentView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final Integer getStyle() {
        return this.e;
    }

    private final void setCommentCount(long r7) {
        long r0 = 100;
        if (1 <= r7) goto L6;
    L8:
        long r2 = 1000;
        if (r0 <= r7) goto L12;
    L14:
        long r1 = 10000;
        if (r2 > r7) goto L21;
        if (r1 <= r7) goto L21;
        StringBuilder r3 = new StringBuilder();
        r3.append((r7 / r2) * r2);
        r3.append('+');
        String r8 = r3.toString();
    L24:
        Integer r9 = this.e;
        if (r9 != null) goto L28;
    L30:
        TextView r10 = this.a;
        if (r10 == null) goto L34;
        r10.setText(r8);
        return;
    L34:
        return;
    L28:
        if (r9.intValue() != 0) goto L30;
        r8 = com.bytedance.android.shopping.extensions.j.c(2131913864) + r8;
    L21:
        if (r7 < r1) goto L23;
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        r8 = String.format("%.1f万+", Arrays.copyOf(new Object[]{Double.valueOf(r7 / 10000.0d)}, 1));
        goto L24
    L23:
        r8 = "";
        goto L24
    L12:
        if (r2 <= r7) goto L14;
        StringBuilder r5 = new StringBuilder();
        r5.append((r7 / r0) * r0);
        r5.append('+');
        r8 = r5.toString();
        goto L24
    L6:
        if (r0 <= r7) goto L8;
        StringBuilder r6 = new StringBuilder();
        r6.append(r7);
        r6.append(26465);
        r8 = r6.toString();
        goto L24
    }

    public final void b(rd3.a r11) {
        Intrinsics.checkNotNullParameter(r11, "anchorInflowFeedItem");
        this.d = r11;
        ProductFeedViewModel r0 = r11.c;
        List<PromotionProductCommentStruct> r1 = null;
        if (r0 == null) goto L9;
        InnerFlowPageStyleDTO r2 = r0.getInnerFlowPageStyle();
        if (r2 == null) goto L9;
        PageStyle r3 = r2.getPageStyle();
        if (r3 == null) goto L9;
        Integer r4 = r3.getCommentStyle();
    L11:
        if (r4 != null) goto L14;
    L16:
        setStyle(0);
    L17:
        ECViewFlipper r5 = this.b;
        if (r5 == null) goto L20;
        r5.scrollToPosition(0);
    L20:
        Promotion r12 = r11.f();
        if (r12 == null) goto L25;
        PromotionProductStruct r13 = r12.getPromotionInfo();
        if (r13 == null) goto L25;
        PromotionProductCommentsStruct r14 = r13.getCommentInfo();
    L26:
        if (r14 == null) goto L47;
        List r6 = r14.getStats();
        if (r6 == null) goto L47;
        Iterator r7 = r6.iterator();
    L31:
        if (r7.hasNext() == false) goto L41;
        Object r8 = r7.next();
        Long r9 = ((PromotionProductCommentStatStruct) r8).getId();
        if (r9 != null) goto L36;
    L38:
        boolean r10 = false;
    L39:
        if (r10 == false) goto L31;
    L42:
        PromotionProductCommentStatStruct r15 = (PromotionProductCommentStatStruct) r8;
        if (r15 == null) goto L47;
        Long r16 = r15.getCount();
        if (r16 == null) goto L47;
        long r17 = r16.longValue();
    L48:
        setCommentCount(r17);
        CommentAdapter r18 = this.c;
        if (r14 == null) goto L51;
        r1 = r14.getComments();
    L51:
        r18.a = r1;
        this.c.notifyDataSetChanged();
        return;
    L36:
        if (r9.longValue() != 3) goto L38;
        r10 = true;
        goto L39
    L41:
        r8 = null;
    L47:
        r17 = 0;
    L25:
        r14 = null;
        goto L26
    L14:
        if (r4.intValue() != 2) goto L16;
        setStyle(1);
    L9:
        r4 = null;
        goto L11
    }

    public final void setStyle(Integer r4) {
        if ((!Intrinsics.areEqual(this.e, r4)) == false) goto L19;
        this.e = r4;
        removeAllViews();
        int r0 = 2131560737;
        if (r4 != null) goto L8;
    L10:
        if (r4 != null) goto L13;
    L15:
        LayoutInflater.from(getContext()).inflate(r0, this);
        this.a = (TextView) findViewById(2131375267);
        TextView r5 = (TextView) findViewById(2131375268);
        ECViewFlipper r6 = findViewById(2131375266);
        this.b = r6;
        if (r6 == null) goto L20;
        r6.setViewFlipperAdapter(this.c);
        return;
    L20:
        return;
    L13:
        if (r4.intValue() != 1) goto L15;
        r0 = 2131560736;
        goto L15
    L8:
        if (r4.intValue() != 0) goto L10;
    }

    public InflowFeedCommentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new CommentAdapter(this);
        setOnClickListener(new a(this));
    }

    public /* synthetic */ InflowFeedCommentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
