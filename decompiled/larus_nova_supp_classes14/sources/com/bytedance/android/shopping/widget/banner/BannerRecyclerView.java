package com.bytedance.android.shopping.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feed.banner.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/widget/banner/BannerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "angle", "", "setInterceptAngle", "Lcom/bytedance/android/shopping/feed/banner/b;", "e", "Lcom/bytedance/android/shopping/feed/banner/b;", "getScrollByDragListener", "()Lcom/bytedance/android/shopping/feed/banner/b;", "setScrollByDragListener", "(Lcom/bytedance/android/shopping/feed/banner/b;)V", "scrollByDragListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BannerRecyclerView extends RecyclerView {
    public final int a;
    public int b;
    public float c;
    public float d;
    public b e;

    public BannerRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BannerRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final b getScrollByDragListener() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "e");
        int r0 = r11.getActionMasked();
        if (r0 != 0) goto L5;
        this.c = r11.getX();
        this.d = r11.getY();
        if (this.b <= 0) goto L27;
        getParent().requestDisallowInterceptTouchEvent(true);
        setNestedScrollingEnabled(false);
    L27:
        return super.onInterceptTouchEvent(r11);
    L5:
        if (r0 != 2) goto L27;
        float r1 = Math.abs(r11.getX() - this.c);
        float r3 = Math.abs(r11.getY() - this.d);
        float r4 = this.a;
        if (r1 >= r4) goto L12;
        if (r3 >= r4) goto L12;
    L17:
        if (r1 < this.a) goto L27;
        if (r1 <= r3) goto L27;
        b r2 = this.e;
        if (r2 == null) goto L27;
        r2.b();
    L12:
        if ((((double) r3) / ((double) r1)) <= Math.tan((((double) this.b) * 3.141592653589793d) / ((double) 180))) goto L17;
        if (this.b <= 0) goto L17;
        getParent().requestDisallowInterceptTouchEvent(false);
        setNestedScrollingEnabled(true);
        goto L17
    }

    public final void setInterceptAngle(int r1) {
        this.b = r1;
    }

    public final void setScrollByDragListener(b r1) {
        this.e = r1;
    }

    public BannerRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public /* synthetic */ BannerRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
