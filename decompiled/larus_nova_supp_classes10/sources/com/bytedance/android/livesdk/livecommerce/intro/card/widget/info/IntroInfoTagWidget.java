package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoTagWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/a;", "", "getCurrentContentDescription", "", "a", "I", "getType", "()I", LocationMonitorConst.TYPE, "Loh2/e;", "b", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "c", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroInfoTagWidget extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a {
    public final int a;
    public oh2.e b;
    public oh2.c c;
    public StringBuilder d;
    public List<ECRitTag> e;
    public final r f;

    public static final class a {
    }

    static {
    }

    public IntroInfoTagWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroInfoTagWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.d;
        if (r0 == null) goto L5;
        StringsKt.clear(r0);
    L5:
        List<ECRitTag> r1 = this.e;
        if (r1 == null) goto L17;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        List r3 = ((ECRitTag) r2.next()).getText();
        if (r3 == null) goto L9;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L9;
        StringBuilder r5 = this.d;
        if (r5 == null) goto L9;
        r5.append(r4);
    L17:
        StringBuilder r6 = this.d;
        if (r6 == null) goto L20;
        String r7 = r6.toString();
    L21:
        if (r7 != null) goto L33;
        return "";
    L33:
        return r7;
    L20:
        r7 = null;
        goto L21
    }

    public oh2.e getArgument() {
        return this.b;
    }

    public oh2.c getContainerAbility() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public int getType() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setArgument(oh2.e r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setContainerAbility(oh2.c r1) {
        this.c = r1;
    }

    public IntroInfoTagWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 2;
        int r5 = r.h;
        this.f = r.a.b("intro_card_tag_widget");
        setGravity(8388627);
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14)));
    }

    public final ECDraweeView a(ECUrlModel r8, boolean r9, boolean r10) {
        ECDraweeView r6 = new ECDraweeView(getContext(), null, 0, 6, null);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Integer.valueOf(r8.getWidth())), UtilityKotlinExtentionsKt.d(Integer.valueOf(r8.getHeight())));
        Float r1 = Float.valueOf(4.0f);
        int r2 = 0;
        if (r10 == false) goto L5;
        int r11 = UtilityKotlinExtentionsKt.d(r1);
    L6:
        r0.rightMargin = r11;
        if (r9 == false) goto L9;
        r2 = UtilityKotlinExtentionsKt.d(r1);
    L9:
        r0.leftMargin = r2;
        Unit r12 = Unit.INSTANCE;
        r6.setLayoutParams(r0);
        String r13 = r8.getFirstUrl();
        if (r13 != null) goto L12;
        r13 = "";
    L12:
        h0.e(r6, r13, this.f, Integer.valueOf(UtilityKotlinExtentionsKt.d(Integer.valueOf(r8.getWidth()))), Integer.valueOf(UtilityKotlinExtentionsKt.d(Integer.valueOf(r8.getHeight()))), 96);
        return r6;
    L5:
        r11 = 0;
        goto L6
    }

    public final View b(int r8, String r9, ECUIConfig r10) {
        TextView r0 = new TextView(getContext());
        r0.setTag("text");
        r0.setGravity(17);
        boolean r1 = true;
        r0.setMaxLines(1);
        Integer r2 = Integer.valueOf(r10.getTextSize());
        if (r2.intValue() <= 0) goto L5;
        boolean r3 = true;
    L6:
        String r5 = null;
        if (r3 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        float r4 = r2.intValue();
    L13:
        r0.setTextSize(1, r4);
        r0.setPadding(UtilityKotlinExtentionsKt.d(2), 0, UtilityKotlinExtentionsKt.d(2), 0);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14));
        if (r8 <= 0) goto L16;
        int r11 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L17:
        r6.leftMargin = r11;
        Unit r12 = Unit.INSTANCE;
        r0.setLayoutParams(r6);
        r0.setText(r9);
        int r13 = s.a;
        r0.setTextColor(s.a(r10.getTextColor(), th.a.a(r0.getContext(), 2131106238)));
        GradientDrawable r14 = new GradientDrawable();
        r14.setCornerRadius(UtilityKotlinExtentionsKt.c(3));
        r14.setColor(s.a(r10.getTextBgColor(), th.a.a(r0.getContext(), 2131106207)));
        String r15 = r10.getTextBorderColor();
        if (r15 != null) goto L20;
    L29:
        r0.setBackground(r14);
        return r0;
    L20:
        if (r15.length() > 0) goto L23;
        r1 = false;
    L23:
        if (r1 == false) goto L25;
        r5 = r15;
    L25:
        if (r5 == null) goto L29;
        Integer r16 = s.b(r5);
        if (r16 == null) goto L29;
        r14.setStroke(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), r16.intValue());
        goto L29
    L16:
        r11 = 0;
        goto L17
    L12:
        r4 = 10.0f;
        goto L13
    L5:
        r3 = false;
        goto L6
    }

    public /* synthetic */ IntroInfoTagWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        int r8 = getChildCount() - 1;
    L3:
        if (r8 < 0) goto L19;
        View r9 = getChildAt(r8);
        if (r9.getVisibility() == 8) goto L12;
        if ((r9.getLeft() + r9.getMeasuredWidth()) < getMeasuredWidth()) goto L10;
        r9.layout(r4, r5, r4, r7);
        goto L12
    L10:
        if (Intrinsics.areEqual(r9.getTag(), "divider") == false) goto L13;
        r9.layout(r4, r5, r4, r7);
        return;
    L13:
        return;
    L12:
        r8 = r8 - 1;
        goto L3
    }
}
