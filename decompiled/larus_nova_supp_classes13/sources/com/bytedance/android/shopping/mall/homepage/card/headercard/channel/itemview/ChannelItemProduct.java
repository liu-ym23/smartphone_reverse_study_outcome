package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.a;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemProduct;", "Landroid/widget/FrameLayout;", "", "", "a", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "b", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "getChannel", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "setChannel", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;)V", "channel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelItemProduct extends FrameLayout {
    public int a;
    public ChannelVO b;
    public final int c;
    public final int d;
    public final SimpleDraweeView e;
    public final AppCompatTextView f;

    public ChannelItemProduct(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelItemProduct(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public ChannelVO getChannel() {
        return this.b;
    }

    public int getIndex() {
        return this.a;
    }

    public void setChannel(ChannelVO r1) {
        this.b = r1;
    }

    public void setIndex(int r1) {
        this.a = r1;
    }

    public ChannelItemProduct(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = -1;
        this.c = ContextCompat.getColor(r10, 2131106104);
        this.d = ContextCompat.getColor(r10, 2131106115);
        View r0 = new SimpleDraweeView(r10);
        this.e = r0;
        AppCompatTextView r1 = new AppCompatTextView(r10);
        BackgroundDrawable r8 = new BackgroundDrawable(r10, r11, false, 4, null);
        r8.setBgColor(ContextCompat.getColor(r10, 2131106121));
        int r13 = c.a;
        r8.setStrokeWidth(c.c(Double.valueOf(0.5d), r10, true));
        r8.setCornerRadius(c.c(100, r10, true));
        r8.setStrokeColor(ContextCompat.getColor(r10, 2131106130));
        r8.invalidate();
        Unit r14 = Unit.INSTANCE;
        r1.setBackground(r8);
        r1.setTextSize(0, c.c(10, r10, true));
        ViewCompat.setPaddingRelative(r1, c.c(5, r10, true), c.c(1, r10, true), c.c(5, r10, true), 0);
        this.f = r1;
        addView(r0, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, c.c(15, r10, true));
        r15.gravity = 81;
        addView(r1, r15);
    }

    public final void a(ChannelVO r8, a r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "channel");
        Intrinsics.checkNotNullParameter(r9, "mallContext");
        setChannel(r8);
        setIndex(r10);
        if (r10 < 0) goto L62;
        ChannelVO r11 = getChannel();
        SpannableStringBuilder r0 = null;
        Typeface r1 = null;
        r1 = null;
        if (r11 == null) goto L8;
        String r12 = r11.getItemImageUrl(r10);
    L9:
        boolean r2 = true;
        if (r12 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L18;
        d0.c(this.e, r12, r9.k);
    L18:
        SpannableStringBuilder r13 = new SpannableStringBuilder();
        int r14 = this.d;
        ChannelVO r4 = getChannel();
        if (r4 == null) goto L21;
        Boolean r5 = Boolean.valueOf(r4.showItemPrice(r10));
    L22:
        ChannelVO r6 = getChannel();
        if (r6 == null) goto L25;
        Boolean r7 = Boolean.valueOf(r6.showItemTag(r10));
    L26:
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r15) == false) goto L29;
        r13.append("¥");
        r14 = this.c;
    L29:
        ChannelVO r16 = getChannel();
        if (r16 == null) goto L32;
        String r17 = r16.getItemPriceOrTag(r10);
    L33:
        if (r17 != null) goto L35;
    L38:
        boolean r18 = true;
    L39:
        if (r18 == true) goto L52;
        r13.append(r17);
        r13.setSpan(new ForegroundColorSpan(r14), 0, r13.length(), 17);
        if (Build.VERSION.SDK_INT >= 28) goto L44;
    L51:
        r0 = r13;
        goto L52
    L44:
        if (Intrinsics.areEqual(r5, r15) == false) goto L47;
        com.bytedance.android.ec.hybrid.a.c();
    L49:
        if (r1 == null) goto L51;
        r13.setSpan(new TypefaceSpan(r1), 0, r13.length(), 17);
        goto L51
    L47:
        if (Intrinsics.areEqual(r7, r15) == false) goto L49;
        r1 = Typeface.create(Typeface.create("PingFang SC", 0), 600, false);
    L52:
        if (r0 != null) goto L54;
    L57:
        if (r2 == true) goto L59;
        this.f.setText(r0);
        this.f.setVisibility(0);
        return;
    L59:
        this.f.setVisibility(8);
        return;
    L54:
        if (r0.length() == 0) goto L57;
        r2 = false;
        goto L57
    L35:
        if (r17.length() == 0) goto L38;
        r18 = false;
        goto L39
    L32:
        r17 = null;
        goto L33
    L25:
        r7 = null;
        goto L26
    L21:
        r5 = null;
        goto L22
    L12:
        if (r12.length() == 0) goto L15;
        r3 = false;
        goto L16
    L8:
        r12 = null;
        goto L9
    }

    public /* synthetic */ ChannelItemProduct(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
