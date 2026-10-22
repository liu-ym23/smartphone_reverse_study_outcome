package com.bytedance.android.shopping.mall.feed.output;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.api.mall.feed.d;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0004B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/output/ECMallGulListView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/shopping/api/mall/feed/d;", "a", "Lkotlin/Lazy;", "getMallFeedComponent", "()Lcom/bytedance/android/shopping/api/mall/feed/d;", "mallFeedComponent", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallGulListView extends FrameLayout {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    private final d getMallFeedComponent() {
        return (d) this.a.getValue();
    }

    public ECMallGulListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        new LinkedHashMap();
        this.a = LazyKt.lazy(new ECMallGulListView$mallFeedComponent$2(this));
    }

    public ECMallGulListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        new LinkedHashMap();
        this.a = LazyKt.lazy(new ECMallGulListView$mallFeedComponent$2(this));
    }

    public ECMallGulListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        new LinkedHashMap();
        this.a = LazyKt.lazy(new ECMallGulListView$mallFeedComponent$2(this));
    }
}
