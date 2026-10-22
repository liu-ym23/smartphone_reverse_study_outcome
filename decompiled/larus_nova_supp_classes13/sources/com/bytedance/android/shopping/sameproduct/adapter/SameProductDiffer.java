package com.bytedance.android.shopping.sameproduct.adapter;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import eh3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/adapter/SameProductDiffer;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductDiffer extends DiffUtil.ItemCallback<Object> {
    public SameProductDiffer() {
    }

    public final boolean areContentsTheSame(Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "pre");
        Intrinsics.checkNotNullParameter(r3, "post");
        return Intrinsics.areEqual(r2, r3);
    }

    public final boolean areItemsTheSame(Object r6, Object r7) {
        Intrinsics.checkNotNullParameter(r6, "pre");
        Intrinsics.checkNotNullParameter(r7, "post");
        String r1 = null;
        if ((r6 instanceof rd3.a) == false) goto L23;
        if ((r7 instanceof rd3.a) == false) goto L23;
        Promotion r8 = ((rd3.a) r6).f();
        if (r8 == null) goto L13;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L13;
        PromotionProductBaseStruct r10 = r9.getBaseInfo();
        if (r10 == null) goto L13;
        String r11 = r10.getProductId();
    L14:
        Promotion r12 = ((rd3.a) r7).f();
        if (r12 == null) goto L58;
        PromotionProductStruct r13 = r12.getPromotionInfo();
        if (r13 == null) goto L58;
        PromotionProductBaseStruct r14 = r13.getBaseInfo();
        if (r14 == null) goto L58;
        r1 = r14.getProductId();
    L58:
        return TextUtils.equals(r11, r1);
    L13:
        r11 = null;
    L23:
        if ((r6 instanceof PromotionProductStruct) == false) goto L47;
        if ((r7 instanceof PromotionProductStruct) == false) goto L47;
        PromotionProductStruct r15 = (PromotionProductStruct) r6;
        PromotionProductBaseStruct r0 = r15.getBaseInfo();
        if (r0 == null) goto L29;
        String r2 = r0.getProductId();
    L30:
        PromotionProductStruct r16 = (PromotionProductStruct) r7;
        PromotionProductBaseStruct r4 = r16.getBaseInfo();
        if (r4 == null) goto L33;
        String r5 = r4.getProductId();
    L35:
        if (TextUtils.equals(r2, r5) == false) goto L56;
        PromotionProductBaseStruct r17 = r15.getBaseInfo();
        if (r17 == null) goto L39;
        String r18 = r17.getPromotionId();
    L40:
        PromotionProductBaseStruct r19 = r16.getBaseInfo();
        if (r19 == null) goto L44;
        r1 = r19.getPromotionId();
    L44:
        if (TextUtils.equals(r18, r1) == false) goto L56;
    L50:
        return true;
    L39:
        r18 = null;
    L56:
        return false;
    L33:
        r5 = null;
        goto L35
    L29:
        r2 = null;
    L47:
        if ((r6 instanceof b) == false) goto L52;
        if ((r7 instanceof b) == true) goto L50;
    L52:
        if ((r6 instanceof eh3.a) == false) goto L56;
        if ((r7 instanceof eh3.a) == false) goto L56;
        goto L56
    }
}
