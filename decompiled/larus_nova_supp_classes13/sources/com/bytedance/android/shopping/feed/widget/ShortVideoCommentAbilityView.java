package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.ec.core.utils.g1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ShortVideoCommentAbilityView;", "Landroid/widget/FrameLayout;", "", "Landroid/widget/TextSwitcher;", "a", "Landroid/widget/TextSwitcher;", "getTextSwitcher", "()Landroid/widget/TextSwitcher;", "textSwitcher", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortVideoCommentAbilityView extends FrameLayout {
    public final TextSwitcher a;

    public static final class a implements ViewSwitcher.ViewFactory {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public final View makeView() {
            TextView r0 = new TextView(this.a);
            r0.setTextSize(1, 10.0f);
            r0.setIncludeFontPadding(false);
            r0.setGravity(17);
            int r1 = g1.a;
            r0.setTextColor(g1.a.a(this.a, 2131101196));
            return r0;
        }
    }

    public ShortVideoCommentAbilityView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShortVideoCommentAbilityView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final TextSwitcher getTextSwitcher() {
        return this.a;
    }

    public ShortVideoCommentAbilityView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560928, this);
        TextSwitcher r5 = (TextSwitcher) findViewById(2131391169);
        this.a = r5;
        r5.setFactory(new a(r2));
    }

    public /* synthetic */ ShortVideoCommentAbilityView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
