package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.extensions.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/RedDotView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "", "setTextStyle", "", "number", "setNumberStyle", "Landroid/util/AttributeSet;", "a", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RedDotView extends AppCompatTextView {
    public final AttributeSet a;

    public RedDotView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RedDotView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setNumberStyle(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        setBackgroundResource(2131234848);
        setTextSize(1, 10.0f);
        setPadding(0, 0, 0, 0);
        if (1 <= r4) goto L8;
    L10:
        ViewGroup.LayoutParams r1 = getLayoutParams();
        r1.height = b.b(14);
        r1.width = -2;
        setPadding(b.b(4), 0, b.b(4), 0);
        Unit r0 = Unit.INSTANCE;
        if (r4 <= 99) goto L13;
        String r5 = "99+";
    L14:
        setText(r5);
        requestLayout();
        return;
    L13:
        r5 = String.valueOf(r4);
        goto L14
    L8:
        if (9 < r4) goto L10;
        ViewGroup.LayoutParams r2 = getLayoutParams();
        r2.height = b.b(14);
        r2.width = b.b(14);
        Unit r3 = Unit.INSTANCE;
        r5 = String.valueOf(r4);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextStyle(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        setText(r3);
        setTextSize(1, 9.0f);
        setBackgroundResource(2131234848);
        ViewGroup.LayoutParams r4 = getLayoutParams();
        r4.height = b.b(14);
        r4.width = -2;
        setPadding(b.b(4), 0, b.b(4), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RedDotView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = r3;
        setIncludeFontPadding(false);
        setTextColor(-1);
        setGravity(17);
    }

    public /* synthetic */ RedDotView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
