package com.bytedance.android.shopping.inflow.detail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.utils.y;
import com.bytedance.android.shopping.feed.event.g;
import com.bytedance.android.shopping.feed.event.l1;
import com.bytedance.android.shopping.feed.utils.l;
import com.bytedance.android.shopping.feed.view.c;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/inflow/detail/widget/AnchorV3ProductBrandView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "d", "Ljava/lang/String;", "getPageType", "()Ljava/lang/String;", "setPageType", "(Ljava/lang/String;)V", "pageType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3ProductBrandView extends LinearLayout implements c {
    public static final /* synthetic */ int f = 0;
    public final ECDraweeView a;
    public final TextView b;
    public PromotionProductStruct c;
    public String d;
    public boolean e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AnchorV3ProductBrandView a;
        public final /* synthetic */ Context b;

        public a(AnchorV3ProductBrandView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            AnchorV3ProductBrandView r6 = this.a;
            if (r6.e == true) goto L6;
            int r0 = l.a;
            PromotionProductStruct r1 = r6.c;
            String r7 = r6.getPageType();
            Context r2 = this.b;
            Intrinsics.checkNotNullParameter("brand_name_click", "eventName");
            int r3 = com.bytedance.android.ec.core.opt.ab.c.a;
            l1 r4 = new l1("brand_name_click");
            r4.a = y.d(r1);
            r4.b = r7;
            g.c(r4, r2, null);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public AnchorV3ProductBrandView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV3ProductBrandView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final String getPageType() {
        return this.d;
    }

    public final void setPageType(String r1) {
        this.d = r1;
    }

    public AnchorV3ProductBrandView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        View r6 = ShoppingAsyncCacheInflater.a.a(r2).aU(2131560434, this, true);
    L6:
        this.a = r6.findViewById(2131362694);
        this.b = (TextView) r6.findViewById(2131362717);
        r6.setOnClickListener(new a(this, r2));
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        r6 = ShoppingAsyncInflater.a.a(r2).aU(2131560434, this, true);
        goto L6
    }

    public /* synthetic */ AnchorV3ProductBrandView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
