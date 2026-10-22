package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.base.view.HollowTextView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.bizmodels.feed.poi.MinorTag;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/poi/MinorTagView;", "Landroid/widget/FrameLayout;", "", "content", "", "setText", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/MinorTag;", "getData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MinorTagView extends FrameLayout {
    public static final Typeface i = null;
    public final AttributeSet a;
    public final int b;
    public MinorTag c;
    public boolean d;
    public boolean e;
    public final TextPaint f;
    public View g;
    public final r h;

    public static final class a {
    }

    public MinorTagView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MinorTagView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        i = Typeface.create("sans-serif-medium", 0);
    }

    public final MinorTag getData() {
        return this.c;
    }

    private final void setText(String r3) {
        AppCompatTextView r0 = this.g;
        if ((r0 instanceof DmtTextView) == false) goto L6;
        ((DmtTextView) r0).setText(r3);
        return;
    L6:
        if ((r0 instanceof HollowTextView) == false) goto L10;
        ((HollowTextView) r0).setText(r3);
        return;
    }

    public static String b(String r1, boolean r2) {
        if (r2 == true) goto L5;
        return r1;
    L5:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.q == false) goto L7;
        String r3 = " · ";
    L9:
        return r1 + r3;
    L7:
        r3 = "·";
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.widget.FrameLayout, com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.MinorTagView] */
    public final void c(MinorTag r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "data");
        this.c = r8;
        this.e = r9;
        this.d = true;
        removeAllViews();
        Resources r2 = Resources.getSystem();
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(2, 11, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        float r4 = r1;
        this.f.setTextSize(r4);
        TextPaint r3 = this.f;
        Typeface r5 = i;
        r3.setTypeface(r5);
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.q == false) goto L5;
    L7:
        ?? r6 = new DmtTextView(getContext(), this.a, this.b);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setSingleLine(true);
        r6.setGravity(16);
        r6.setTypeface(r5);
        r6.setBackgroundColor(0);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextSize(0, r4);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), 2131100347));
        r6.setText(b(r8.a, r9));
        ?? r7 = r6;
    L8:
        this.g = r7;
        addView(r7, new FrameLayout.LayoutParams(-2, -1));
        return;
    L5:
        if ((r8.c instanceof com.bytedance.awemeopen.bizmodels.feed.poi.b.b) == false) goto L7;
        HollowTextView.a r10 = new HollowTextView.a();
        r10.a = r1;
        r10.b = ContextCompat.getColor(getContext(), 2131100273);
        float r11 = 2;
        Resources r12 = Resources.getSystem();
        r10.c = MathKt.roundToInt(TypedValue.applyDimension(1, r11, WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics())));
        r10.f = true;
        r10.e = true;
        r10.g = true;
        r10.d = true;
        HollowTextView r13 = new HollowTextView(getContext(), r10);
        Resources r14 = Resources.getSystem();
        int r0 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics())));
        r13.setPadding(r0, r0, r0, r0);
        r13.setText(b(r8.a, r9));
        r7 = r13;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.r] */
    public MinorTagView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = r3;
        this.b = r4;
        this.f = new TextPaint();
        this.h = new r(this);
    }

    public static void a(final MinorTagView r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        MinorTag r0 = r7.c;
        if (r0 == null) goto L23;
        int r10 = r9 - r8;
        StringBuffer r11 = new StringBuffer();
        List r1 = r0.b;
        int r2 = r1.size();
        Iterator r3 = r1.iterator();
        int r4 = 0;
    L7:
        if (r3.hasNext() == false) goto L18;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        Pair r12 = (Pair) r5;
        String r13 = (String) r12.getFirst();
        int r14 = Math.min(((Number) r12.getSecond()).intValue(), r13.length());
        if (r10 <= 0) goto L16;
        if (r14 < 0) goto L16;
        if (r6 >= r2) goto L16;
        int r15 = r10 + 3;
        int r16 = Math.min(r13.length() - r14, r15);
        r11.append(r13.subSequence(0, r13.length() - r16));
        r11.append("...");
        r10 = r15 - r16;
    L17:
        r4 = r6;
    L16:
        r11.append(r13);
        goto L17
    L18:
        r7.setText(b(r11.toString(), r7.e));
        r7.post(new s(r7));
        return;
    }

    public /* synthetic */ MinorTagView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r10, r11);
        View r12 = this.g;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r7 == false) goto L17;
        MinorTag r13 = this.c;
        if (r13 != null) goto L10;
        return;
    L10:
        if (this.d == true) goto L12;
        return;
    L12:
        if (this.f.measureText(r13.a) <= ((getMeasuredWidth() - r12.getPaddingStart()) - r12.getPaddingEnd())) goto L14;
        float r14 = getMeasuredWidth() - this.f.measureText("...");
    L15:
        TextUtils.ellipsize(r13.a, this.f, r14, TextUtils.TruncateAt.END, false, this.h);
        this.d = false;
        return;
    L14:
        r14 = getMeasuredWidth();
        goto L15
    }
}
