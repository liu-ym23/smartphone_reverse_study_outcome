package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import c63.d;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchGoodsData;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchItemData;
import com.bytedance.android.shopping.anchorv4.dto.business.ProductInfo;
import com.bytedance.android.shopping.anchorv4.dto.business.SameGoodsItem;
import com.bytedance.android.shopping.anchorv4.dto.business.g;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.t;
import com.bytedance.commerce.base.view.b;
import com.facebook.drawee.view.SimpleDraweeView;
import f83.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import th.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4FindSameIndicator;", "Landroid/widget/LinearLayout;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FindSameIndicator extends LinearLayout {
    public final d a;
    public final p b;

    public AnchorV4FindSameIndicator(Context r8) {
        this(r8, null, 0, null, null, 30);
    }

    public AnchorV4FindSameIndicator(Context r8, AttributeSet r9) {
        this(r8, r9, 0, null, null, 28);
    }

    public AnchorV4FindSameIndicator(Context r8, AttributeSet r9, int r10) {
        this(r8, r9, r10, null, null, 24);
    }

    public final void a(com.bytedance.android.shopping.anchorv4.dto.business.d r9, CommonFindSameElement r10, t r11) {
        int r2 = 0;
        if (r9 == null) goto L16;
        List r4 = r9.getFeedStruct();
        if (r4 == null) goto L16;
        if (r4.size() < 3) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L16;
        List r6 = r4.subList(0, 3);
        if (r6 == null) goto L16;
    L29:
        setVisibility(8);
        p r1 = this.b;
        if (r1 == null) goto L32;
        r1.e(null);
    L32:
        if (r6 == null) goto L77;
        ArrayList r3 = new ArrayList();
        Iterator r7 = r6.iterator();
    L35:
        if (r7.hasNext() == false) goto L77;
        Object r8 = r7.next();
        int r12 = r2 + 1;
        if (r2 >= 0) goto L39;
        CollectionsKt.throwIndexOverflow();
    L39:
        Serializable r13 = (Serializable) r8;
        Object r14 = CollectionsKt.getOrNull(b.a(this), r2);
        if ((r14 instanceof SimpleDraweeView) == true) goto L42;
        r14 = null;
    L42:
        SimpleDraweeView r15 = (SimpleDraweeView) r14;
        if (r15 != null) goto L45;
    L67:
        d r16 = this.a;
        if (r16 == null) goto L73;
        if (r10 == null) goto L71;
        Integer r17 = r10.getType();
    L72:
        r16.G(1, null, r17);
        Unit r18 = Unit.INSTANCE;
    L74:
        if (r18 == null) goto L76;
        r3.add(r18);
    L76:
        r2 = r12;
        goto L35
    L71:
        r17 = null;
        goto L72
    L73:
        r18 = null;
        goto L74
    L45:
        if ((r13 instanceof SameGoodsItem) == true) goto L47;
        Serializable r19 = null;
    L48:
        SameGoodsItem r20 = (SameGoodsItem) r19;
        if (r20 == null) goto L56;
        g r21 = r20.getProduct();
        if (r21 == null) goto L56;
        ECUrlModel r22 = r21.a();
        if (r22 == null) goto L56;
        y.a(r15, r22);
    L56:
        if ((r13 instanceof PicSearchGoodsData) == true) goto L58;
        r13 = null;
    L58:
        PicSearchGoodsData r23 = (PicSearchGoodsData) r13;
        if (r23 == null) goto L67;
        PicSearchItemData r24 = r23.getData();
        if (r24 == null) goto L67;
        ProductInfo r25 = r24.getProductInfo();
        if (r25 == null) goto L67;
        String r26 = r25.getImg();
        if (r26 == null) goto L67;
        y.d(r15, r26);
        goto L67
    L47:
        r19 = r13;
    L77:
        setOnClickListener(new f83.b(this, r11, r10, r9));
        return;
    L9:
        r5 = false;
    L16:
        if (r9 == null) goto L28;
        List r27 = r9.getBusinessDataStruct();
        if (r27 == null) goto L28;
        if (r27.size() < 3) goto L22;
        boolean r28 = true;
    L23:
        if (r28 == true) goto L26;
        r27 = null;
    L26:
        if (r27 == null) goto L28;
        r6 = r27.subList(0, 3);
        goto L29
    L22:
        r28 = false;
    L28:
        r6 = null;
        goto L29
    }

    public AnchorV4FindSameIndicator(Context r3, AttributeSet r4, int r5, d r6, p r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = null;
    L14:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = r6;
        this.b = r7;
        a.c(r3, 2131560491, this, true);
        setBackgroundResource(2131233384);
    }
}
