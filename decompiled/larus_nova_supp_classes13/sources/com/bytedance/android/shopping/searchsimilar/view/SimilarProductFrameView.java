package com.bytedance.android.shopping.searchsimilar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.searchsimilar.model.ProductFrame;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/SimilarProductFrameView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductFrameView extends FrameLayout {
    public final FrameLayout a;
    public final LinearLayout b;
    public final SquareImageView c;
    public final SquareImageView d;
    public boolean e;
    public ProductFrame f;
    public Integer g;
    public SimilarProductVM h;

    public SimilarProductFrameView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SimilarProductFrameView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(boolean r3) {
        this.e = r3;
        if (r3 == false) goto L13;
        LinearLayout r4 = this.b;
        if (r4 == null) goto L7;
        r4.setVisibility(0);
    L7:
        SquareImageView r5 = this.c;
        if (r5 == null) goto L10;
        r5.setVisibility(0);
    L10:
        SquareImageView r6 = this.d;
        if (r6 == null) goto L23;
        r6.setVisibility(8);
        return;
    L23:
        return;
    L13:
        LinearLayout r7 = this.b;
        if (r7 == null) goto L16;
        r7.setVisibility(8);
    L16:
        SquareImageView r8 = this.c;
        if (r8 == null) goto L19;
        r8.setVisibility(8);
    L19:
        SquareImageView r9 = this.d;
        if (r9 == null) goto L25;
        r9.setVisibility(0);
        return;
    }

    public SimilarProductFrameView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560662, this, true);
        this.a = (FrameLayout) findViewById(2131371024);
        this.b = (LinearLayout) findViewById(2131371022);
        this.c = findViewById(2131371021);
        this.d = findViewById(2131371023);
    }

    public /* synthetic */ SimilarProductFrameView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
