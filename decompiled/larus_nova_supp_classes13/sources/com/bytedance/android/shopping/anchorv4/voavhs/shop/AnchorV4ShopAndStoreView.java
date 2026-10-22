package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3RecInShopBoxView;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.Border;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.IconsWithSpaceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.LynxCardView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.MediaBoxElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "StarType", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreView extends LinearLayout implements ActionHubAccessor {
    public LongContentLabelComponentView A;
    public TagsScrollBoxComponentView B;
    public LongContentLabelComponentView C;
    public TextElementView D;
    public TextWithOneIconElementView E;
    public TextWithOneIconElementView F;
    public SimpleDraweeView G;
    public ConstraintLayout H;
    public View H0;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b I;
    public AnchorV4VM J;
    public LinearLayout K;
    public LinearLayout L;
    public View L0;
    public LinearLayout M;
    public LinearLayout N;
    public View O;
    public View P;
    public Boolean P0;
    public RoundedFrameLayout Q;
    public TextWithOneIconElementView R;
    public AnchorV4ShopAndStoreMeta S;
    public ECDraweeView T;
    public View U;
    public TextWithOneIconElementView V;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a V0;
    public TagsScrollBoxComponentView W;
    public LinearLayout a;
    public ConstraintLayout b;
    public LinearLayout c;
    public MediaBoxElementView d;
    public TextWithOneIconElementView e;
    public View f;
    public TextWithOneIconElementView g;
    public TextWithOneIconElementView h;
    public TextWithOneIconElementView i;
    public IconsWithSpaceElementView j;
    public LinearLayout k;
    public TextWithOneIconElementView k0;
    public View l;
    public TextElementView m;
    public TextElementView n;
    public View o;
    public LynxCardView p;
    public View p0;
    public TextElementView q;
    public LinearLayout r;
    public View s;
    public TextElementView t;
    public LongContentLabelComponentView u;
    public LongContentLabelComponentView v;
    public LongContentLabelComponentView w;
    public AnchorV3RecInShopBoxView x;
    public TextWithOneIconElementView y;
    public TextElementView z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreView$StarType;", "", "FULL", "HALF", "BLANK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StarType extends Enum<StarType> {
        public static final StarType BLANK = null;
        public static final StarType FULL = null;
        public static final StarType HALF = null;
        public static final /* synthetic */ StarType[] a = null;

        static {
            StarType r1 = new StarType("FULL", 0);
            FULL = r1;
            StarType r2 = new StarType("HALF", 1);
            HALF = r2;
            StarType r3 = new StarType("BLANK", 2);
            BLANK = r3;
            a = new StarType[]{r1, r2, r3};
        }

        public static StarType valueOf(String r1) {
            return (StarType) r27.a.a(StarType.class, r1);
        }

        public static StarType[] values() {
            return (StarType[]) a.clone();
        }

        public StarType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public AnchorV4ShopAndStoreView(Context r4) {
        this(r4, null, 0, 14);
    }

    public AnchorV4ShopAndStoreView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public AnchorV4ShopAndStoreView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.V0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final void a(AnchorV4ShopAndStoreDisplay r19) {
        AnchorV4ShopDetailMainInfo r1 = r19.getShopDetailMainInfo();
        ViewGroup.LayoutParams r4 = null;
        List<TextElement> r5 = null;
        if (r1 == null) goto L45;
        LinearLayout r10 = this.k;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L7:
        r10.setVisibility(8);
        TextWithOneIconElement r13 = r1.getShopRating();
        if (r13 == null) goto L16;
        TextWithOneIconElementView r11 = this.R;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mainInfoScore");
    L12:
        r11.setVisibility(0);
        TextWithOneIconElementView r12 = this.R;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mainInfoScore");
    L15:
        TextWithOneIconElementView.b(r12, r13, null, false, null, 14);
    L20:
        List<TextElement> r2 = r1.getTextArray();
        if (r2 != null) goto L23;
    L41:
        View r3 = this.l;
        if (r3 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowAndSales");
    L44:
        r3.setVisibility(8);
        return;
    L23:
        if ((!r2.isEmpty()) == false) goto L25;
        r5 = r2;
    L25:
        if (r5 == null) goto L41;
        View r6 = this.l;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowAndSales");
    L29:
        r6.setVisibility(0);
        TextElementView r7 = this.m;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("tivFollow");
    L32:
        r7.x((TextElement) CollectionsKt.getOrNull(r5, 0));
        TextElementView r8 = this.n;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("tivSales");
    L35:
        r8.x((TextElement) CollectionsKt.getOrNull(r5, 1));
        if (r5.size() > 1) goto L80;
        View r9 = this.o;
        if (r9 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("followDivider");
    L40:
        r9.setVisibility(8);
        return;
    L80:
        return;
    L16:
        TextWithOneIconElementView r14 = this.R;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mainInfoScore");
    L19:
        r14.setVisibility(8);
        Unit r15 = Unit.INSTANCE;
        goto L20
    L45:
        List<TextElement> r16 = r19.getFollowAndSellInfo();
        if (r16 != null) goto L48;
        return;
    L48:
        if (r16.isEmpty() == false) goto L53;
        View r17 = this.l;
        if (r17 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowAndSales");
    L52:
        r17.setVisibility(8);
        return;
    L53:
        AppCompatTextView r18 = this.m;
        if (r18 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("tivFollow");
    L56:
        ViewGroup.LayoutParams r110 = r18.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L60;
        r4 = r110;
    L60:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r4;
        if (r20 == null) goto L63;
        r20.leftMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r18.setLayoutParams(r20);
    L63:
        TextElementView r21 = this.m;
        if (r21 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("tivFollow");
    L66:
        r21.x((TextElement) CollectionsKt.getOrNull(r16, 0));
        TextElementView r22 = this.n;
        if (r22 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("tivSales");
    L69:
        r22.x((TextElement) CollectionsKt.getOrNull(r16, 1));
        if (r16.size() > 1) goto L75;
        View r23 = this.o;
        if (r23 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("followDivider");
    L74:
        r23.setVisibility(8);
    L75:
        View r24 = this.l;
        if (r24 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowAndSales");
    L78:
        r24.setVisibility(0);
    }

    public final void b(AnchorV4ShopAndStoreDisplay r12) {
        AnchorV4ShopAmbient r13 = r12.getShopAmbient();
        if (r13 == null) goto L68;
        LinearLayout r0 = this.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L7:
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r2 = null;
    L10:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 == null) goto L13;
        r3.topMargin = 0;
        r0.setLayoutParams(r3);
    L13:
        LinearLayout r1 = this.c;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L16:
        r1.setBackground(com.bytedance.commerce.base.drawable.a.a(AnchorV4ShopAndStoreView$bindShopAmbient$1$2.INSTANCE));
        LinearLayout r4 = this.a;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("llShopInfo");
    L19:
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r5 = null;
    L22:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        if (r6 == null) goto L25;
        r6.topMargin = com.bytedance.android.shopping.extensions.b.b(14);
        r4.setLayoutParams(r6);
    L25:
        ConstraintLayout r7 = this.H;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("shopContainer");
    L28:
        ExtensionsKt.j(r7, r13.getBackGround());
        TextWithOneIconElement r8 = r13.getTitle();
        if (r8 == null) goto L37;
        TextWithOneIconElementView r9 = this.E;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientTitle");
    L33:
        r9.setVisibility(0);
        TextWithOneIconElementView r10 = this.E;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientTitle");
    L36:
        TextWithOneIconElementView.b(r10, r8, null, false, null, 14);
    L41:
        TextWithOneIconElement r11 = r13.getSlogan();
        if (r11 == null) goto L50;
        TextWithOneIconElementView r14 = this.F;
        if (r14 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientSlogan");
    L46:
        r14.setVisibility(0);
        TextWithOneIconElementView r15 = this.F;
        if (r15 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientSlogan");
    L49:
        TextWithOneIconElementView.b(r15, r11, null, false, null, 14);
    L54:
        ImageModel r16 = r13.getShading();
        if (r16 == null) goto L63;
        SimpleDraweeView r17 = this.G;
        if (r17 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientShading");
    L59:
        r17.setVisibility(0);
        SimpleDraweeView r18 = this.G;
        if (r18 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientShading");
    L62:
        ImageExtensionsKt.d(r18, r16, null);
        return;
    L63:
        SimpleDraweeView r19 = this.G;
        if (r19 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientShading");
    L66:
        r19.setVisibility(8);
        return;
    L50:
        TextWithOneIconElementView r20 = this.F;
        if (r20 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientSlogan");
    L53:
        r20.setVisibility(8);
        Unit r21 = Unit.INSTANCE;
        goto L54
    L37:
        TextWithOneIconElementView r22 = this.E;
        if (r22 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientTitle");
    L40:
        r22.setVisibility(8);
        Unit r23 = Unit.INSTANCE;
        goto L41
    }

    public final void c(AnchorV4ShopAndStoreDisplay r12) {
        ConstraintLayout r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("clShopInfo");
    L5:
        ExtensionsKt.j(r0, r12.getBasicInfoBg());
        MediaBoxElement r1 = r12.getShopAvatarBorder();
        ViewGroup.LayoutParams r2 = null;
        if (r1 == null) goto L10;
        ImageModel r3 = r1.getImageModel();
        if (r3 == null) goto L10;
        ECUrlModel r4 = r3.getRemote();
    L11:
        if (r4 == null) goto L16;
        ECDraweeView r5 = this.T;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("shopAvatarLive");
    L15:
        y.a(r5, r4);
    L16:
        boolean r6 = true;
        MediaBoxElement r7 = r12.getShopAvatarBorder();     // Catch: Exception -> L30
        if (r7 == null) goto L31;
        Background r8 = r7.getBackground();     // Catch: Exception -> L30
        if (r8 == null) goto L31;
        Border r9 = r8.getBorder();     // Catch: Exception -> L30
        if (r9 == null) goto L31;
        String r10 = r9.getBorderColor();     // Catch: Exception -> L30
        if (r10 == null) goto L31;
        GradientDrawable r11 = new GradientDrawable();     // Catch: Exception -> L30
        r11.setShape(1);     // Catch: Exception -> L30
        r11.setStroke(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), Color.parseColor(r10));     // Catch: Exception -> L30
        View r13 = this.U;     // Catch: Exception -> L30
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("shopAvatarBorder");     // Catch: Exception -> L30
    L28:
        r13.setBackgroundDrawable(r11);     // Catch: Exception -> L30
    L31:
        TextWithOneIconElementView r14 = this.V;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("shopAvatarTag");
    L34:
        TextWithOneIconElementView.b(r14, r12.getShopAvatarTag(), null, false, null, 14);
        TagsScrollBoxComponentView r15 = this.W;
        if (r15 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreIcons");
    L37:
        TagsScrollBoxComponentView.b(r15, r12.getShopScoreIcons(), null, 14);
        TextWithOneIconElement r16 = r12.getShopScoreText();
        int r17 = 0;
        if (r16 == null) goto L56;
        TextElement r18 = r16.getContent();
        if (r18 == null) goto L56;
        String r19 = r18.getText();
        if (r19 == null) goto L56;
        if (StringsKt.contains$default(r19, " ", false, 2, null) == true) goto L56;
        TextWithOneIconElement r20 = r12.getShopScoreText();
        if (r20 == null) goto L56;
        TextElement r21 = r20.getContent();
        if (r21 == null) goto L56;
        TextWithOneIconElement r22 = r12.getShopScoreText();
        if (r22 == null) goto L54;
        TextElement r23 = r22.getContent();
        if (r23 == null) goto L54;
        String r24 = r23.getText();
    L55:
        r21.setText(Intrinsics.stringPlus(r24, " "));
    L54:
        r24 = null;
    L56:
        TextWithOneIconElementView r25 = this.k0;
        if (r25 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreText");
    L59:
        TextWithOneIconElementView.b(r25, r12.getShopScoreText(), null, false, null, 14);
        TextWithOneIconElementView r26 = this.k0;
        if (r26 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreText");
    L62:
        r26.getTextElementView().setTypeface(Typeface.SANS_SERIF, 3);
        TextWithOneIconElementView r27 = this.k0;
        if (r27 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreText");
    L65:
        r27.getTextElementView().setGravity(17);
        TextWithOneIconElementView r28 = this.k0;
        if (r28 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreText");
    L68:
        AppCompatTextView r29 = r28.getTextElementView();
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L71;
        r30 = null;
    L71:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L75;
        r31.bottomMargin = com.bytedance.android.shopping.extensions.b.b(1);
        r29.setLayoutParams(r31);
    L75:
        if (r12.getShopStructOptimize() == false) goto L185;
        View r110 = this.p0;
        if (r110 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListViewDivider");
    L79:
        LongContentLabelComponentView r32 = this.A;
        if (r32 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListView");
    L83:
        if (r32.getVisibility() != 0) goto L85;
        boolean r33 = true;
    L87:
        if (r33 == false) goto L97;
        LynxCardView r34 = this.p;
        if (r34 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("storeReputationLynxView");
    L92:
        if (r34.getVisibility() != 0) goto L94;
        boolean r35 = true;
    L95:
        if (r35 == false) goto L97;
        int r36 = 0;
    L98:
        r110.setVisibility(r36);
        View r111 = this.H0;
        if (r111 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponViewDivider");
    L101:
        LongContentLabelComponentView r37 = this.u;
        if (r37 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponView");
    L105:
        if (r37.getVisibility() != 0) goto L107;
        boolean r38 = true;
    L108:
        if (r38 == false) goto L126;
        LynxCardView r39 = this.p;
        if (r39 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("storeReputationLynxView");
    L113:
        if (r39.getVisibility() != 0) goto L115;
        boolean r40 = true;
    L116:
        if (r40 == true) goto L125;
        LongContentLabelComponentView r41 = this.A;
        if (r41 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListView");
    L121:
        if (r41.getVisibility() != 0) goto L123;
        boolean r42 = true;
    L124:
        if (r42 == false) goto L126;
    L123:
        r42 = false;
    L125:
        int r43 = 0;
    L127:
        r111.setVisibility(r43);
        View r112 = this.L0;
        if (r112 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtraDivider");
    L130:
        LinearLayout r44 = this.c;
        if (r44 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L134:
        if (r44.getVisibility() != 0) goto L136;
        boolean r45 = true;
    L137:
        if (r45 == false) goto L163;
        LynxCardView r46 = this.p;
        if (r46 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("storeReputationLynxView");
    L142:
        if (r46.getVisibility() != 0) goto L144;
        boolean r47 = true;
    L145:
        if (r47 == true) goto L164;
        LongContentLabelComponentView r48 = this.A;
        if (r48 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListView");
    L150:
        if (r48.getVisibility() != 0) goto L152;
        boolean r49 = true;
    L153:
        if (r49 == true) goto L164;
        LongContentLabelComponentView r50 = this.u;
        if (r50 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponView");
    L158:
        if (r50.getVisibility() == 0) goto L161;
        r6 = false;
    L161:
        if (r6 == false) goto L163;
    L152:
        r49 = false;
    L164:
        r112.setVisibility(r17);
        LinearLayout r113 = this.c;
        if (r113 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L167:
        ViewGroup.LayoutParams r51 = r113.getLayoutParams();
        if ((r51 instanceof ViewGroup.MarginLayoutParams) == false) goto L171;
        r2 = r51;
    L171:
        ViewGroup.MarginLayoutParams r52 = (ViewGroup.MarginLayoutParams) r2;
        if (r52 == null) goto L174;
        r52.topMargin = com.bytedance.android.shopping.extensions.b.b(3);
        r113.setLayoutParams(r52);
    L174:
        TextWithOneIconElementView r114 = this.g;
        if (r114 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L177:
        TextWithOneIconElementView r53 = this.g;
        if (r53 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L180:
        ConstraintLayout.LayoutParams r54 = r53.getLayoutParams();
        if (r54 == null) goto L184;
        ConstraintLayout.LayoutParams r55 = r54;
        ((ViewGroup.MarginLayoutParams) r55).topMargin = com.bytedance.android.shopping.extensions.b.b(11);
        Unit r56 = Unit.INSTANCE;
        r114.setLayoutParams(r55);
        return;
    L184:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L144:
        r47 = false;
    L163:
        r17 = 8;
        goto L164
    L136:
        r45 = false;
        goto L137
    L115:
        r40 = false;
    L126:
        r43 = 8;
        goto L127
    L107:
        r38 = false;
        goto L108
    L94:
        r35 = false;
    L97:
        r36 = 8;
        goto L98
    L85:
        r33 = false;
        goto L87
    L185:
        return;
    L10:
        r4 = null;
        goto L11
    }

    public final void d(int r3) {
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = getContext();
        r0.getClass();
        ShoppingAsyncInflater.a.a(r1).aU(r3, this, true);
        this.a = (LinearLayout) findViewById(2131362845);
        this.b = findViewById(2131362869);
        this.c = (LinearLayout) findViewById(2131362842);
        this.d = (MediaBoxElementView) findViewById(2131362817);
        this.e = (TextWithOneIconElementView) findViewById(2131362873);
        this.f = findViewById(2131362874);
        this.g = (TextWithOneIconElementView) findViewById(2131362895);
        this.h = (TextWithOneIconElementView) findViewById(2131362872);
        this.i = (TextWithOneIconElementView) findViewById(2131362894);
        this.j = (IconsWithSpaceElementView) findViewById(2131362824);
        this.k = (LinearLayout) findViewById(2131362841);
        this.l = findViewById(2131362801);
        this.m = (TextElementView) findViewById(2131362791);
        this.n = (TextElementView) findViewById(2131362793);
        this.o = findViewById(2131362790);
        this.p = (LynxCardView) findViewById(2131387412);
        this.q = (TextElementView) findViewById(2131362911);
        this.r = (LinearLayout) findViewById(2131362849);
        this.s = findViewById(2131362871);
        this.t = (TextElementView) findViewById(2131362910);
        this.u = (LongContentLabelComponentView) findViewById(2131362877);
        this.v = (LongContentLabelComponentView) findViewById(2131362876);
        this.w = (LongContentLabelComponentView) findViewById(2131362881);
        this.x = findViewById(2131362758);
        this.y = (TextWithOneIconElementView) findViewById(2131362896);
        this.z = (TextElementView) findViewById(2131362892);
        this.B = (TagsScrollBoxComponentView) findViewById(2131362822);
        this.K = (LinearLayout) findViewById(2131362844);
        this.L = (LinearLayout) findViewById(2131362847);
        this.M = (LinearLayout) findViewById(2131362848);
        this.N = (LinearLayout) findViewById(2131362846);
        this.O = findViewById(2131362882);
        this.P = findViewById(2131362883);
        this.Q = findViewById(2131362748);
        this.A = (LongContentLabelComponentView) findViewById(2131362879);
        this.C = (LongContentLabelComponentView) findViewById(2131362891);
        this.D = (TextElementView) findViewById(2131362890);
        this.E = (TextWithOneIconElementView) findViewById(2131362868);
        this.F = (TextWithOneIconElementView) findViewById(2131362867);
        this.G = findViewById(2131362866);
        this.H = findViewById(2131362870);
        this.R = (TextWithOneIconElementView) findViewById(2131362792);
        this.T = findViewById(2131362819);
        this.U = findViewById(2131362818);
        this.V = (TextWithOneIconElementView) findViewById(2131362820);
        this.W = (TagsScrollBoxComponentView) findViewById(2131362884);
        this.k0 = (TextWithOneIconElementView) findViewById(2131362885);
        this.p0 = findViewById(2131362880);
        this.H0 = findViewById(2131362878);
        this.L0 = findViewById(2131362843);
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.I.e(r2);
        super.draw(r2);
        this.I.d(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.V0 = r2;
    }

    public AnchorV4ShopAndStoreView(Context r9, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        this.V0 = null;
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r13 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.I = r13;
        d(2131560516);
        Action r14 = new Action("root", null, null, null, new JSONObject().put("check_login", true).toString(), 14, null);
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r14);
        r13.f(new Radius(8, 8, 8, 8));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.I.c(r1, r2);
    }
}
