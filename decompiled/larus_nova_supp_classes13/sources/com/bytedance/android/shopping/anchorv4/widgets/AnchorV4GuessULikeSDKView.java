package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/AnchorV4GuessULikeSDKView;", "Landroid/widget/FrameLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "getCurrentRecyclerView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GuessULikeSDKView extends FrameLayout {
    public com.bytedance.android.shopping.api.mall.feed.d a;
    public RecyclerView b;

    public AnchorV4GuessULikeSDKView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4GuessULikeSDKView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final RecyclerView getCurrentRecyclerView() {
        return this.b;
    }

    public AnchorV4GuessULikeSDKView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
    }

    public /* synthetic */ AnchorV4GuessULikeSDKView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
