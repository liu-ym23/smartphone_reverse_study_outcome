package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityTime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/CountDownLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountDownLayout extends FrameLayout {
    public Map<Integer, View> a;
    public final List<TextView> b;
    public final List<TextView> c;

    public CountDownLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CountDownLayout(Context r3, AttributeSet r4) {
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

    public final void b(ActivityTime r11) {
        if (r11 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        int r2 = c2.h;
        c2 r3 = c2.a.a(getContext(), TimeUnit.SECONDS.toMillis(r11.getEndTime() - (System.currentTimeMillis() / 1000)), false);
        AppCompatTextView r4 = (TextElementView) a(2131362192);
        if (r4 == null) goto L9;
        r4.setVisibility(8);
    L9:
        TextElement r5 = r11.getActivityDesc();
        if (r5 == null) goto L18;
        TextElementView r6 = (TextElementView) a(2131362192);
        if (r6 == null) goto L14;
        r6.x(r5);
    L14:
        AppCompatTextView r7 = (TextElementView) a(2131362192);
        if (r7 == null) goto L18;
        r7.setVisibility(0);
    L18:
        if (r3.a <= 0) goto L40;
        TextView r0 = (TextView) a(2131362165);
        if (r0 == null) goto L22;
        r0.setText(r3.b);
    L22:
        String r1 = r3.b;
        if (r1 == null) goto L25;
        int r8 = r1.length();
    L27:
        if (r8 < 3) goto L31;
        TextView r9 = (TextView) a(2131362165);
        if (r9 == null) goto L34;
        r9.setPadding(com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(0));
    L34:
        TextView r10 = (TextView) a(2131362165);
        if (r10 == null) goto L37;
        r10.setVisibility(0);
    L37:
        TextView r12 = (TextView) a(2131362166);
        if (r12 == null) goto L46;
        r12.setVisibility(0);
    L46:
        TextView r13 = (TextView) a(2131362167);
        if (r13 == null) goto L49;
        r13.setText(r3.c);
    L49:
        TextView r14 = (TextView) a(2131362167);
        if (r14 == null) goto L52;
        r14.setVisibility(0);
    L52:
        TextView r15 = (TextView) a(2131362163);
        if (r15 == null) goto L55;
        r15.setVisibility(0);
    L55:
        TextView r16 = (TextView) a(2131362168);
        if (r16 == null) goto L58;
        r16.setText(r3.d);
    L58:
        TextView r17 = (TextView) a(2131362168);
        if (r17 == null) goto L61;
        r17.setVisibility(0);
    L61:
        TextView r18 = (TextView) a(2131362164);
        if (r18 == null) goto L64;
        r18.setVisibility(0);
    L64:
        TextView r19 = (TextView) a(2131362169);
        if (r19 == null) goto L67;
        r19.setText(r3.e);
    L67:
        TextView r20 = (TextView) a(2131362169);
        if (r20 == null) goto L70;
        r20.setVisibility(0);
    L70:
        FontStyle r21 = r11.getCountDownTextStyle();
        if (r21 == null) goto L85;
        Iterator<T> r22 = this.b.iterator();
    L74:
        if (r22.hasNext() == false) goto L85;
        TextView r23 = (TextView) r22.next();
        if (r23 == null) goto L74;
        r23.setTextSize(r21.getFontSize());
        if (r21.getLine() < 1) goto L81;
        int r24 = r21.getLine();
    L82:
        r23.setMaxLines(r24);
        r23.setEllipsize(TextUtils.TruncateAt.END);
        r23.setTextColor(com.bytedance.android.shopping.extensions.a.a(r21.getTextColor(), 0));
        if (r21.getFontWeight() < 500) goto L74;
        r23.setTypeface(r23.getTypeface(), 1);
        goto L74
    L81:
        r24 = Integer.MAX_VALUE;
    L85:
        final String r110 = r11.getCountDownTextBgColor();
        if (r110 == null) goto L94;
        Iterator<T> r25 = this.c.iterator();
    L89:
        if (r25.hasNext() == false) goto L107;
        TextView r26 = (TextView) r25.next();
        if (r26 == null) goto L89;
        r26.setBackgroundDrawable(com.bytedance.commerce.base.drawable.a.a(new CountDownLayout$bindNumViewBgColor$bgDrawable$1(r110)));
        goto L89
    L107:
        return;
    L94:
        return;
    L31:
        TextView r27 = (TextView) a(2131362165);
        if (r27 == null) goto L34;
        r27.setPadding(com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(0));
        goto L34
    L25:
        r8 = 0;
        goto L27
    L40:
        TextView r28 = (TextView) a(2131362165);
        if (r28 == null) goto L43;
        r28.setVisibility(8);
    L43:
        TextView r29 = (TextView) a(2131362166);
        if (r29 == null) goto L46;
        r29.setVisibility(8);
        goto L46
    }

    public CountDownLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = new LinkedHashMap();
        FrameLayout.inflate(r10, 2131564600, this);
        this.b = CollectionsKt.listOf(new TextView[]{(TextView) a(2131362165), (TextView) a(2131362166), (TextView) a(2131362167), (TextView) a(2131362163), (TextView) a(2131362168), (TextView) a(2131362164), (TextView) a(2131362169)});
        this.c = CollectionsKt.listOf(new TextView[]{(TextView) a(2131362165), (TextView) a(2131362167), (TextView) a(2131362168), (TextView) a(2131362169)});
    }

    public /* synthetic */ CountDownLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
