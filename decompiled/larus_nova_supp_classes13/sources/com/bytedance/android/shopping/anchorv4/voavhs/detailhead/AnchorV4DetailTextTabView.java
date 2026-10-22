package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.anchorv3.utils.c0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailTextTabView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "a", "Lkotlin/Lazy;", "getViewHeight", "()I", "viewHeight", "b", "getMaxViewWidth", "maxViewWidth", "c", "getMinViewWidth", "minViewWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailTextTabView extends AppCompatTextView {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    private final int getMaxViewWidth() {
        return ((Number) this.b.getValue()).intValue();
    }

    private final int getMinViewWidth() {
        return ((Number) this.c.getValue()).intValue();
    }

    private final int getViewHeight() {
        return ((Number) this.a.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        ViewGroup.LayoutParams r0 = getLayoutParams();
        r0.width = -2;
        r0.height = getViewHeight();
        setMaxWidth(getMaxViewWidth());
        setMinWidth(getMinViewWidth());
        setLayoutParams(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4DetailTextTabView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(AnchorV4DetailTextTabView$viewHeight$2.INSTANCE);
        this.b = LazyKt.lazy(new AnchorV4DetailTextTabView$maxViewWidth$2(r2));
        this.c = LazyKt.lazy(AnchorV4DetailTextTabView$minViewWidth$2.INSTANCE);
        c0.a(12.0d);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(17);
    }
}
