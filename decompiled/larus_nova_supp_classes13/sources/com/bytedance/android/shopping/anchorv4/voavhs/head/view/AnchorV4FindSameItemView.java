package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchGoodsData;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchItemData;
import com.bytedance.android.shopping.anchorv4.dto.business.ProductInfo;
import com.bytedance.android.shopping.anchorv4.dto.business.SameGoodsItem;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4FindSameItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "index", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/d;", "headViewAction", "Lcom/bytedance/android/shopping/anchorv4/dto/business/SameGoodsItem;", "sameGoodsItem", "Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchGoodsData;", "picSearchItem", "type", "", "update", "(ILcom/bytedance/android/shopping/anchorv4/voavhs/head/base/d;Lcom/bytedance/android/shopping/anchorv4/dto/business/SameGoodsItem;Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchGoodsData;Ljava/lang/Integer;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FindSameItemView extends ConstraintLayout {
    public final SimpleDraweeView a;
    public final ImageView b;
    public final PriceView c;
    public final ImageView d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AnchorV4FindSameItemView a;
        public final /* synthetic */ SameGoodsItem b;
        public final /* synthetic */ PicSearchGoodsData c;
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.base.d d;
        public final /* synthetic */ int e;
        public final /* synthetic */ Integer f;

        public a(AnchorV4FindSameItemView r1, SameGoodsItem r2, PicSearchGoodsData r3, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r4, int r5, Integer r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            SameGoodsItem r7 = this.b;
            String r0 = null;
            if (r7 == null) goto L8;
            com.bytedance.android.shopping.anchorv4.dto.business.g r8 = r7.getProduct();
            if (r8 == null) goto L8;
            String r9 = r8.b();
            if (r9 == null) goto L8;
        L16:
            if (r9 == null) goto L18;
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.getContext(), p0.d(r9, PdpOpenThirdParam.KEY_SOURCE_PAGE, "pic_sim_recommend"));
        L18:
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r10 = this.d;
            if (r10 == null) goto L39;
            c63.d r11 = r10.t();
            if (r11 == null) goto L40;
            int r1 = this.e + 1;
            SameGoodsItem r2 = this.b;
            if (r2 == null) goto L30;
            com.bytedance.android.shopping.anchorv4.dto.business.g r3 = r2.getProduct();
            if (r3 == null) goto L30;
            String r4 = r3.d();
            if (r4 == null) goto L30;
            r0 = r4;
        L37:
            r11.o(r1, r0, this.f);
            return;
        L30:
            PicSearchGoodsData r5 = this.c;
            if (r5 == null) goto L37;
            PicSearchItemData r12 = r5.getData();
            if (r12 == null) goto L37;
            ProductInfo r13 = r12.getProductInfo();
            if (r13 == null) goto L37;
            r0 = r13.getGid();
            goto L37
        L40:
            return;
        L39:
            return;
        L8:
            PicSearchGoodsData r14 = this.c;
            if (r14 == null) goto L15;
            PicSearchItemData r15 = r14.getData();
            if (r15 == null) goto L15;
            ProductInfo r16 = r15.getProductInfo();
            if (r16 == null) goto L15;
            r9 = r16.getSchema();
        L15:
            r9 = null;
            goto L16
        }
    }

    public AnchorV4FindSameItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4FindSameItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4FindSameItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = th.a.c(r2, 2131560492, this, true);
        this.a = r5.findViewById(2131372550);
        this.b = (ImageView) r5.findViewById(2131372549);
        this.c = r5.findViewById(2131372551);
        this.d = (ImageView) r5.findViewById(2131372548);
    }

    public /* synthetic */ AnchorV4FindSameItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update(int r11, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r12, final SameGoodsItem r13, final PicSearchGoodsData r14, Integer r15) {
        SimpleDraweeView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        ImageView r1 = this.b;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        PriceView r2 = this.c;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        ImageView r3 = this.d;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        if (r13 == null) goto L20;
        com.bytedance.android.shopping.anchorv4.dto.business.g r4 = r13.getProduct();
        if (r4 == null) goto L20;
        ECUrlModel r5 = r4.a();
        if (r5 == null) goto L20;
        y.a(this.a, r5);
    L28:
        PriceView r6 = this.c;
        if (r6 == null) goto L31;
        r6.C(new AnonymousClass3(r13, r14));
    L31:
        if (r12 == null) goto L48;
        c63.d r7 = r12.t();
        if (r7 == null) goto L48;
        int r8 = r11 + 1;
        if (r13 == null) goto L40;
        com.bytedance.android.shopping.anchorv4.dto.business.g r9 = r13.getProduct();
        if (r9 == null) goto L40;
        String r10 = r9.d();
        if (r10 == null) goto L40;
    L47:
        r7.v(r8, r10, r15);
    L40:
        if (r14 == null) goto L46;
        PicSearchItemData r16 = r14.getData();
        if (r16 == null) goto L46;
        ProductInfo r17 = r16.getProductInfo();
        if (r17 == null) goto L46;
        r10 = r17.getGid();
    L46:
        r10 = null;
    L48:
        setOnClickListener(new a(this, r13, r14, r12, r11, r15));
        return;
    L20:
        if (r14 == null) goto L28;
        PicSearchItemData r18 = r14.getData();
        if (r18 == null) goto L28;
        ProductInfo r19 = r18.getProductInfo();
        if (r19 == null) goto L28;
        String r20 = r19.getImg();
        if (r20 == null) goto L28;
        y.d(this.a, r20);
        goto L28
    }
}
