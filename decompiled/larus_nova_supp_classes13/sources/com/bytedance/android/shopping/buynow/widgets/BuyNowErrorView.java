package com.bytedance.android.shopping.buynow.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.i;
import com.bytedance.android.shopping.buynow.starter.b;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/widgets/BuyNowErrorView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/buynow/widgets/BuyNowErrorView$a;", "callback", "", "setCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowErrorView extends LinearLayout {
    public static final /* synthetic */ int d = 0;
    public Map<Integer, View> a;
    public a b;
    public Long c;

    public interface a {
        void a();

        void b();

        void onQuit();
    }

    public BuyNowErrorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BuyNowErrorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void b(b r7) {
        Intrinsics.checkNotNullParameter(r7, "buyNowPageConfig");
        final com.bytedance.android.ecom.arch.slice.render.context.b r8 = r7.a();
        SimpleDraweeView r1 = a(2131371757);
        ViewGroup.LayoutParams r0 = a(2131371757).getLayoutParams();
        r0.height = SlcDimensExtensionsKt.a(80, r8);
        r0.width = Math.round(SlcDimensExtensionsKt.c(80, r8));
        Unit r2 = Unit.INSTANCE;
        r1.setLayoutParams(r0);
        TextView r3 = (TextView) a(2131371776);
        ViewGroup.LayoutParams r4 = ((TextView) a(2131371776)).getLayoutParams();
        LinearLayout.LayoutParams r5 = null;
        if ((r4 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r4 = null;
    L5:
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r4;
        if (r6 == null) goto L8;
        r6.topMargin = SlcDimensExtensionsKt.a(8, r8);
    L9:
        r3.setLayoutParams(r6);
        i.e((TextView) a(2131371776), 500);
        i.e((TextView) a(2131371770), 400);
        TextView r9 = (TextView) a(2131371750);
        ViewGroup.LayoutParams r10 = ((TextView) a(2131371750)).getLayoutParams();
        if ((r10 instanceof LinearLayout.LayoutParams) == true) goto L12;
        r10 = null;
    L12:
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10;
        if (r11 == null) goto L15;
        r11.topMargin = SlcDimensExtensionsKt.a(40, r8);
        r11.width = SlcDimensExtensionsKt.a(165, r8);
        r11.height = SlcDimensExtensionsKt.a(44, r8);
        r5 = r11;
    L15:
        r9.setLayoutParams(r5);
        i.e((TextView) a(2131371750), 500);
        ViewCompat.setBackground(a(2131371750), com.bytedance.commerce.base.drawable.a.a(new BuyNowErrorView$adapterUIScale$4(this, r8)));
        return;
    L8:
        r6 = null;
        goto L9
    }

    public final void setCallback(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public BuyNowErrorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131559220, this, true);
        setVisibility(8);
        setGravity(17);
        setOrientation(1);
    }

    public /* synthetic */ BuyNowErrorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
