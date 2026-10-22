package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoCustomTagWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/a;", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tagList", "", "setFlashMaterialInfo", "", "getCurrentContentDescription", "", "a", "I", "getType", "()I", LocationMonitorConst.TYPE, "Loh2/e;", "b", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "c", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroInfoCustomTagWidget extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a {
    public final int a;
    public oh2.e b;
    public oh2.c c;
    public StringBuilder d;
    public List<ECRitTag> e;

    public static final class a {
    }

    static {
    }

    public IntroInfoCustomTagWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroInfoCustomTagWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.d;
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
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

    private final void setFlashMaterialInfo(List<ECRitTag> r12) {
        if ((!Intrinsics.areEqual(this.e, r12)) == false) goto L29;
        this.e = r12;
        removeAllViews();
        this.d = new StringBuilder();
        Iterator<T> r13 = r12.iterator();
        int r2 = 0;
    L6:
        if (r13.hasNext() == false) goto L21;
        Object r3 = r13.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ECRitTag r5 = (ECRitTag) r3;
        List r6 = r5.getText();
        if (r6 == null) goto L19;
        String r7 = (String) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L19;
        ECUIConfig r8 = r5.getUiConfig();
        if (r2 != 0) goto L18;
        addView(b(r7, 0, r8));
        goto L19
    L18:
        View r9 = new View(getContext());
        r9.setTag("divider");
        r9.setBackgroundColor(th.a.a(r9.getContext(), 2131101556));
        setGravity(16);
        Float r10 = Float.valueOf(0.5f);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(r10), UtilityKotlinExtentionsKt.d(Float.valueOf(8.0f)));
        r11.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
        r11.topMargin = UtilityKotlinExtentionsKt.d(r10);
        Unit r14 = Unit.INSTANCE;
        r9.setLayoutParams(r11);
        addView(r9);
        addView(b(r7, r2, r8));
    L19:
        r2 = r4;
        goto L6
    L21:
        if (getChildCount() <= 0) goto L30;
        addView(new Space(getContext()), new LinearLayout.LayoutParams(1, 0));
        return;
    L30:
        return;
    }

    public final void a(List<ECRitTag> r5) {
        if ((!r5.isEmpty()) == true) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L25;
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        ECRitTag r2 = (ECRitTag) r6.next();
        List r3 = r2.getText();
        if (r3 != null) goto L13;
    L15:
        r2 = null;
    L16:
        if (r2 == null) goto L9;
        r0.add(r2);
        goto L9
    L13:
        if (((String) CollectionsKt.firstOrNull(r3)) == null) goto L15;
    L18:
        setFlashMaterialInfo(r0);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setArgument(oh2.e r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setContainerAbility(oh2.c r1) {
        this.c = r1;
    }

    public IntroInfoCustomTagWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 6;
        setOrientation(0);
        setGravity(8388611);
    }

    public final TextView b(String r6, int r7, ECUIConfig r8) {
        TextView r0 = new TextView(getContext());
        StringBuilder r1 = this.d;
        if (r1 == null) goto L5;
        r1.append(r6);
    L5:
        r0.setTag("text");
        r0.setText(r6);
        r0.setMaxLines(1);
        boolean r2 = false;
        r0.setIncludeFontPadding(false);
        String r3 = null;
        if (r8 == null) goto L15;
        Integer r4 = Integer.valueOf(r8.getTextSize());
        if (r4.intValue() <= 0) goto L10;
        r2 = true;
    L10:
        if (r2 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        float r5 = r4.intValue();
    L16:
        r0.setTextSize(1, r5);
        int r9 = s.a;
        if (r8 == null) goto L19;
        r3 = r8.getTextColor();
    L19:
        r0.setTextColor(s.a(r3, th.a.a(r0.getContext(), 2131101596)));
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        if (r7 <= 0) goto L22;
        r10.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L22:
        Unit r11 = Unit.INSTANCE;
        r0.setLayoutParams(r10);
        return r0;
    L15:
        r5 = 12.0f;
        goto L16
    }

    public /* synthetic */ IntroInfoCustomTagWidget(Context r1, AttributeSet r2, int r3, int r4) {
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
