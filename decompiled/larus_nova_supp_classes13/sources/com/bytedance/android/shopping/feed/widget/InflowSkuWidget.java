package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.feed.adapter.InflowSkuAdapter;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;
import com.bytedance.android.shopping.feed.view.InflowSkuThumbnail;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\b\tB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "SpaceItemDecoration", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowSkuWidget extends LinearLayout {
    public final InflowSkuThumbnail a;
    public final TextView b;
    public VideoProductFeedBanner c;
    public MutableLiveData<SpecDetail> d;
    public final RecyclerView e;
    public final InflowSkuAdapter f;
    public String g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        public final Context a;
        public final float b;

        public SpaceItemDecoration(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = 6.0f;
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            if (r4.getChildAdapterPosition(r3) <= 0) goto L6;
            r2.left = vf4.a.a(this.a, this.b);
            return;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a("main_pic");
    }

    public InflowSkuWidget(Context r2) {
        this(r2, null);
    }

    public final void a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "refId");
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        String r3 = "main_pic";
        if (r0 == false) goto L9;
        String r1 = "main_pic";
    L11:
        if (Intrinsics.areEqual(r1, this.g) == false) goto L13;
        return;
    L13:
        List<SpecDetail> r4 = this.f.a;
        if (r4 == null) goto L23;
        Iterator<SpecDetail> r5 = r4.iterator();
        int r6 = 0;
    L17:
        if (r5.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(String.valueOf(r5.next().getSpecDetailId()), r9) == true) goto L24;
        r6 = r6 + 1;
    L24:
        if (r6 >= 0) goto L37;
        VideoProductFeedBanner r10 = this.c;
        if (r10 != null) goto L28;
    L52:
        RecyclerView r11 = this.e;
        if (r11 == null) goto L55;
        r11.scrollToPosition(r6);
    L55:
        View r12 = ViewExtensionsKt.j(this, this.g);
        View r7 = null;
        if ((r12 instanceof InflowSkuThumbnail) == true) goto L58;
        r12 = null;
    L58:
        InflowSkuThumbnail r13 = (InflowSkuThumbnail) r12;
        if (r13 == null) goto L61;
        r13.c(false);
    L61:
        View r14 = ViewExtensionsKt.j(this, r1);
        if ((r14 instanceof InflowSkuThumbnail) == true) goto L64;
        r14 = null;
    L64:
        InflowSkuThumbnail r15 = (InflowSkuThumbnail) r14;
        if (r15 == null) goto L75;
        r15.c(true);
        MutableLiveData<SpecDetail> r8 = this.d;
        if (r8 == null) goto L70;
        r8.postValue(r15.getSpecDetail());
    L70:
        if ((true ^ Intrinsics.areEqual(r1, "main_pic")) == false) goto L74;
        RecyclerView r2 = this.e;
        if (r2 == null) goto L74;
        r2.smoothScrollBy((r15.getLeft() + (r15.getWidth() / 2)) - (r2.getWidth() / 2), 0);
    L74:
        r3 = r1;
    L82:
        this.g = r3;
        InflowSkuAdapter r16 = this.f;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r16.d = r3;
        return;
    L75:
        View r17 = ViewExtensionsKt.j(this, "main_pic");
        if ((r17 instanceof InflowSkuThumbnail) == false) goto L79;
        r7 = r17;
    L79:
        InflowSkuThumbnail r18 = (InflowSkuThumbnail) r7;
        if (r18 == null) goto L82;
        r18.c(true);
        goto L82
    L28:
        if (r10.t <= r10.i) goto L52;
        List<? extends ECUrlModel> r19 = r10.h;
        if (r19 == null) goto L33;
        int r20 = r19.size();
    L34:
        if (r20 <= 0) goto L52;
        r10.a.scrollToPosition(0);
        goto L52
    L33:
        r20 = 0;
        goto L34
    L37:
        VideoProductFeedBanner r21 = this.c;
        if (r21 == null) goto L52;
        List<? extends ECUrlModel> r22 = r21.h;
        if (r22 == null) goto L42;
        int r23 = r22.size() - r21.i;
    L43:
        int r24 = r23 + r6;
        r21.t = r24;
        if (r24 < 0) goto L52;
        List<? extends ECUrlModel> r25 = r21.h;
        if (r25 == null) goto L48;
        int r26 = r25.size();
    L49:
        if (r24 > r26) goto L52;
        r21.a.scrollToPosition(r24);
        goto L52
    L48:
        r26 = 0;
        goto L49
    L42:
        r23 = 0;
        goto L43
    L22:
        r6 = -1;
        goto L24
    L23:
        r6 = 0;
        goto L24
    L9:
        r1 = r9;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public InflowSkuWidget(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        InflowSkuAdapter r6 = new InflowSkuAdapter();
        this.f = r6;
        this.g = "main_pic";
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).aU(2131560746, this, true);
        this.a = (InflowSkuThumbnail) findViewById(2131379445);
        this.b = (TextView) findViewById(2131386853);
        RecyclerView r0 = findViewById(2131386869);
        this.e = r0;
        if (r0 == null) goto L5;
        r0.setAdapter(r6);
    L5:
        if (r0 == null) goto L7;
        r0.setLayoutManager(new LinearLayoutManager(r4, 0, false));
    L7:
        if (r0 == null) goto L10;
        r0.addItemDecoration(new SpaceItemDecoration(r4));
        return;
    }
}
