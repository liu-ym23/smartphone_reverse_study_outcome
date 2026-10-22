package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.utils.d0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ProductTopicItemView;", "Landroid/widget/FrameLayout;", "", "marginRight", "", "setMarginRight", "marginLeft", "setMarginLeft", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductTopicItemView extends FrameLayout {
    public final ECDraweeView a;
    public final TextView b;
    public final View c;
    public TopicItemInfo d;
    public List<String> e;
    public List<TopicItemInfo> f;
    public AnchorV3Param g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ProductTopicItemView a;
        public final /* synthetic */ Context b;

        public a(ProductTopicItemView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            TopicItemInfo r8 = this.a.d;
            if (r8 == null) goto L11;
            String r1 = r8.getSchema();
            if (r1 == null) goto L11;
            ArrayList<String> r9 = d0.a;
            Context r0 = this.b;
            TopicItemInfo r10 = this.a.d;
            if (r10 == null) goto L9;
            String r11 = r10.getId();
        L10:
            String r2 = r11;
            ProductTopicItemView r12 = this.a;
            d0.b(r0, r1, r2, r12.e, r12.f, r12.g);
            goto L11
        L9:
            r11 = null;
        L11:
            FeedProductEventTracker r13 = FeedProductEventTracker.a;
            Context r3 = this.b;
            TopicItemInfo r4 = this.a.d;
            r13.getClass();
            FeedProductEventTracker.G(r3, "label_click", r4);
        }
    }

    public ProductTopicItemView(Context r2) {
        this(r2, null);
    }

    public final void setMarginLeft(int r3) {
        ViewGroup.LayoutParams r0 = this.c.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L9;
        r1.leftMargin = r3;
        return;
    }

    public final void setMarginRight(int r3) {
        ViewGroup.LayoutParams r0 = this.c.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L9;
        r1.rightMargin = r3;
        return;
    }

    public ProductTopicItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(r2).inflate(2131560646, this);
        this.a = findViewById(2131383150);
        this.b = (TextView) findViewById(2131383158);
        this.c = findViewById(2131383154);
        setOnClickListener(new a(this, r2));
    }
}
