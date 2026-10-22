package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductShopEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.ui.base.widget.icon.IconImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/WindowEntryInfoView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowEntryInfoView extends LinearLayout {
    public final TextView a;

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ WindowEntryInfoView g;
        public final /* synthetic */ PromotionProductStruct h;
        public final /* synthetic */ rd3.a i;

        public final void a(View r9) {
            Intrinsics.checkNotNullParameter(r9, "v");
            com.bytedance.android.ec.sdk.helper.p r10 = com.bytedance.android.ec.sdk.helper.p.a;
            Context r0 = this.g.getContext();
            PromotionProductAuthorEntriesStruct r1 = this.h.getEntryInfo();
            if (r1 == null) goto L7;
            PromotionProductShopEntryStruct r2 = r1.getShopEntry();
            if (r2 == null) goto L7;
            String r3 = r2.getNavLink();
        L8:
            r10.openSchema(r0, r3);
            FeedProductEventTracker r11 = FeedProductEventTracker.a;
            rd3.a r4 = this.i;
            Context r5 = this.g.getContext();
            r11.getClass();
            FeedProductEventTracker.R(r4, r5, null, "product_flow_under_title", null, null, "window", null);
            return;
        L7:
            r3 = null;
            goto L8
        }

        public a(WindowEntryInfoView r1, PromotionProductStruct r2, rd3.a r3) {
            this.g = r1;
            this.h = r2;
            this.i = r3;
            super(null, "bind_product_flow_card", 1);
        }
    }

    public WindowEntryInfoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public WindowEntryInfoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(PromotionProductStruct r5, rd3.a r6) {
        Intrinsics.checkNotNullParameter(r5, "promotion");
        Intrinsics.checkNotNullParameter(r6, "anchorInflowFeedItem");
        TextView r0 = this.a;
        PromotionProductAuthorEntriesStruct r1 = r5.getEntryInfo();
        if (r1 == null) goto L5;
        String r2 = r1.getAuthorName();
    L6:
        r0.setText(Intrinsics.stringPlus(r2, "推荐"));
        FeedProductEventTracker r3 = FeedProductEventTracker.a;
        Context r4 = getContext();
        r3.getClass();
        FeedProductEventTracker.S(r6, r4, null, "product_flow_under_title", "window");
        setOnClickListener(new a(this, r5, r6));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public WindowEntryInfoView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(16));
        r0.gravity = 16;
        Unit r16 = Unit.INSTANCE;
        setLayoutParams(r0);
        TextView r17 = new TextView(r13);
        this.a = r17;
        r17.setTextSize(11.0f);
        Integer r3 = com.bytedance.android.ec.core.utils.s.b("#bf161823");
        if (r3 == null) goto L5;
        r17.setTextColor(r3.intValue());
    L5:
        r17.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams r4 = r17.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L8;
        r4 = null;
    L8:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L11;
        r5.rightMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r17.setLayoutParams(r5);
    L11:
        IconImageView r6 = new IconImageView(r13, null, 0, 6, null);
        r6.setImageDrawable(ContextCompat.getDrawable(r13, 2131234540));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
        r7.setMargins(com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), 0, 0);
        r6.setLayoutParams(r7);
        TextView r8 = new TextView(r13);
        r8.setText("进入橱窗");
        r8.setTextSize(11.0f);
        Integer r18 = com.bytedance.android.ec.core.utils.s.b("#bf161823");
        if (r18 == null) goto L14;
        r8.setTextColor(r18.intValue());
    L14:
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-2, -2);
        r19.setMargins(0, 0, 0, 0);
        r8.setLayoutParams(r19);
        addView(r17);
        addView(r8);
        addView(r6);
    }

    public /* synthetic */ WindowEntryInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
