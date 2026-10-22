package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedLinearLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/ReturnRewardBtn;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedLinearLayout;", "", "themeColor", "", "setRewardLayoutBackground", "", "scale", "setViewScale", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReturnRewardBtn extends ECRoundedLinearLayout {
    public final ProductTextView c;
    public final ECRoundedLinearLayout d;
    public final SimpleDraweeView e;
    public float f;
    public CommonModel$CusTextStyle g;
    public CommonModel$LayoutStyle h;

    public ReturnRewardBtn(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setRewardLayoutBackground(String r4) {
        Intrinsics.checkNotNullParameter(r4, "themeColor");
        this.d.setBackgroundColor(Color.parseColor(r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "an error occurs when parsing color " + r4);
    }

    public final void setViewScale(float r14) {
        this.f = r14;
        ProductTextView r0 = this.c;
        CommonModel$CusTextStyle r2 = this.g;
        if (r2 == null) goto L7;
        Integer r3 = r2.getFontSize();
        if (r3 == null) goto L7;
        int r4 = r3.intValue();
    L8:
        r0.setTextSize(1, r4 * r14);
        ToolsKt.A(this.e, r14, this.h, Integer.valueOf(b0.c(14)), Integer.valueOf(b0.c(14)), null, null, Integer.valueOf(b0.c(2)), null, false, null, 944);
        return;
    L7:
        r4 = 13;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReturnRewardBtn(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 4, 0);
        this.f = 1.0f;
        LayoutInflater.from(r3).inflate(2131564684, this);
        this.c = (ProductTextView) findViewById(2131379502);
        this.d = (ECRoundedLinearLayout) findViewById(2131379504);
        this.e = findViewById(2131379503);
    }
}
