package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/ButtonNodeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ButtonNodeView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public yd3.a a;
    public final TextView b;
    public rd3.a c;
    public final ImageView d;
    public final View e;

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ButtonNodeView g;
        public final /* synthetic */ Context h;

        public final void a(View r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            yd3.a r11 = this.g.a;
            if (r11 == null) goto L7;
            String r12 = r11.c();
            if (r12 == null) goto L7;
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.h, r12);
        L7:
            rd3.a r1 = this.g.c;
            if (r1 == null) goto L11;
            FeedProductEventTracker.m(FeedProductEventTracker.a, r1, "button", null, null, null, null, null, 124);
            return;
        }

        public a(ButtonNodeView r2, Context r3) {
            this.g = r2;
            this.h = r3;
            super(null, "bind_product_flow_card", 1);
        }
    }

    public static final class b {
    }

    static {
    }

    public ButtonNodeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ButtonNodeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public ButtonNodeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560389, this, true);
        this.d = (ImageView) findViewById(2131365038);
        this.b = (TextView) findViewById(2131365040);
        this.e = findViewById(2131365039);
        setOnClickListener(new a(this, r2));
    }

    public /* synthetic */ ButtonNodeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
