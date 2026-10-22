package com.bytedance.android.ui.ec.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECLoadMoreView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "statusTextView", "Landroid/widget/TextView;", "initLayoutParams", "", "initViews", "setLoadMoreText", "loadMoreText", "", "setLoadMoreTextColor", "color", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLoadMoreView extends LinearLayout {
    private TextView statusTextView;

    public ECLoadMoreView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECLoadMoreView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    private final void initViews() {
        addView(new ECDuxLoadingAnimationView(getContext(), null, 0, 6, null));
        TextView r0 = new TextView(getContext());
        r0.setTextSize(1, 12.0f);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), 2131101736));
        Unit r1 = Unit.INSTANCE;
        this.statusTextView = r0;
        addView(r0);
        setLoadMoreText(getContext().getString(2131896536));
    }

    private final void initLayoutParams() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L5;
        r0.width = -2;
        r0.height = -2;
        setLayoutParams(r0);
    L5:
        setOrientation(0);
    }

    public final void setLoadMoreText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "loadMoreText");
        TextView r0 = this.statusTextView;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setLoadMoreTextColor(int r2) {
        TextView r0 = this.statusTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    public ECLoadMoreView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        initLayoutParams();
        setGravity(17);
        initViews();
    }

    public /* synthetic */ ECLoadMoreView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
