package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/HotWordFlipperItemView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HotWordFlipperItemView extends LinearLayout {
    public final TextView a;
    public final ECDraweeView b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.view.View, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView] */
    public HotWordFlipperItemView(Context r10) {
        super(r10);
        setOrientation(0);
        setGravity(16);
        TextView r1 = new TextView(getContext());
        r1.setEllipsize(null);
        r1.setMaxLines(1);
        r1.setSingleLine();
        r1.setTextColor((int) 2568362019L);
        r1.setGravity(16);
        r1.setTextSize(2, 14.0f);
        Unit r0 = Unit.INSTANCE;
        this.a = r1;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -1);
        r2.setMargins(0, 0, ExtensionsKt.a(4), 0);
        addView(r1, r2);
        ?? r11 = new ECDraweeView(getContext(), null, 0, 6, null);
        this.b = r11;
        addView(r11, new ViewGroup.LayoutParams(ExtensionsKt.a(14), ExtensionsKt.a(14)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.view.View, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView] */
    public HotWordFlipperItemView(Context r9, AttributeSet r10) {
        super(r9, r10);
        setOrientation(0);
        setGravity(16);
        TextView r0 = new TextView(getContext());
        r0.setEllipsize(null);
        r0.setMaxLines(1);
        r0.setSingleLine();
        r0.setTextColor((int) 2568362019L);
        r0.setGravity(16);
        r0.setTextSize(2, 14.0f);
        Unit r11 = Unit.INSTANCE;
        this.a = r0;
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-2, -1);
        r12.setMargins(0, 0, ExtensionsKt.a(4), 0);
        addView(r0, r12);
        ?? r13 = new ECDraweeView(getContext(), null, 0, 6, null);
        this.b = r13;
        addView(r13, new ViewGroup.LayoutParams(ExtensionsKt.a(14), ExtensionsKt.a(14)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.view.View, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView] */
    public HotWordFlipperItemView(Context r8, AttributeSet r9, int r10) {
        super(r8, r9, r10);
        setOrientation(0);
        setGravity(16);
        TextView r11 = new TextView(getContext());
        r11.setEllipsize(null);
        r11.setMaxLines(1);
        r11.setSingleLine();
        r11.setTextColor((int) 2568362019L);
        r11.setGravity(16);
        r11.setTextSize(2, 14.0f);
        Unit r12 = Unit.INSTANCE;
        this.a = r11;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -1);
        r13.setMargins(0, 0, ExtensionsKt.a(4), 0);
        addView(r11, r13);
        ?? r14 = new ECDraweeView(getContext(), null, 0, 6, null);
        this.b = r14;
        addView(r14, new ViewGroup.LayoutParams(ExtensionsKt.a(14), ExtensionsKt.a(14)));
    }
}
