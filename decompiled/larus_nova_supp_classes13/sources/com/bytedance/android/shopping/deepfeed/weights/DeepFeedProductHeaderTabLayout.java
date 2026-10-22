package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductHeaderTabLayout;", "Landroid/widget/LinearLayout;", "", "f", "Lkotlin/Lazy;", "getMultiTabStyle", "()I", "multiTabStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductHeaderTabLayout extends LinearLayout {
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public final List<AppCompatTextView> a;
    public List<b> b;
    public int c;
    public final LayoutInflater d;
    public int e;
    public final Lazy f;

    public static final class a {
    }

    public static final class b {
        public final String a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((b) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "TabItem(title=" + this.a + ")";
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
        }
    }

    public DeepFeedProductHeaderTabLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductHeaderTabLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getMultiTabStyle() {
        return ((Number) this.f.getValue()).intValue();
    }

    static {
        g = com.bytedance.android.shopping.extensions.b.b(24);
        h = com.bytedance.android.shopping.extensions.b.b(28);
        i = com.bytedance.android.shopping.extensions.b.b(20);
        j = com.bytedance.android.shopping.extensions.b.b(24);
    }

    public final boolean a() {
        if (getMultiTabStyle() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(int r5, int r6) {
        this.e = r5;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        if (a() == false) goto L12;
        int r7 = j;
        ((ViewGroup.MarginLayoutParams) r1).width = -2;
        ((ViewGroup.MarginLayoutParams) r1).height = r7;
        ((ViewGroup.MarginLayoutParams) r1).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = r5;
        r1.startToStart = -1;
        r1.leftToLeft = -1;
        r1.endToEnd = 0;
        r1.rightToRight = 0;
    L19:
        setLayoutParams(r1);
        return;
    L12:
        if (r6 < 4) goto L15;
        int r8 = com.bytedance.android.shopping.extensions.b.b(12);
    L18:
        ((ViewGroup.MarginLayoutParams) r1).width = -1;
        ((ViewGroup.MarginLayoutParams) r1).height = h;
        ((ViewGroup.MarginLayoutParams) r1).leftMargin = r8;
        ((ViewGroup.MarginLayoutParams) r1).rightMargin = r8;
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = r5;
        r1.startToStart = 0;
        r1.leftToLeft = 0;
        r1.endToEnd = 0;
        r1.rightToRight = 0;
        goto L19
    L15:
        if (r6 <= 2) goto L17;
        r8 = com.bytedance.android.shopping.extensions.b.b(24);
        goto L18
    L17:
        r8 = com.bytedance.android.shopping.extensions.b.b(48);
        goto L18
    }

    public final void c(int r10, String r11) {
        if (((ArrayList) this.a).isEmpty() == false) goto L6;
        setVisibility(8);
        return;
    L6:
        this.c = RangesKt.coerceIn(r10, 0, CollectionsKt.getLastIndex(this.a));
        int r12 = ((ArrayList) this.a).size();
        Iterator<T> r0 = this.a.iterator();
        int r2 = 0;
    L8:
        if (r0.hasNext() == false) goto L69;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        AppCompatTextView r5 = (AppCompatTextView) r3;
        if (r2 != this.c) goto L15;
        boolean r6 = true;
    L16:
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        String r8 = null;
        if ((r7 instanceof LinearLayout.LayoutParams) == true) goto L19;
        r7 = null;
    L19:
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) r7;
        if (r9 != null) goto L22;
    L30:
        String r13 = "";
        if (r6 == false) goto L40;
        if (r11 != null) goto L39;
        b r14 = (b) CollectionsKt.getOrNull(this.b, r2);
        if (r14 == null) goto L36;
        r8 = r14.a;
    L36:
        if (r8 == null) goto L44;
    L38:
        r13 = r8;
    L44:
        r5.setText(r13);
        if (a() == true) goto L47;
    L61:
        if (r6 == false) goto L63;
        int r15 = 2131247862;
    L64:
        r5.setBackgroundResource(r15);
        if (r6 == false) goto L67;
        int r16 = ColorProtector.parseColor("#161823");
    L68:
        r5.setTextColor(r16);
        r2 = r4;
        goto L8
    L67:
        r16 = -1;
        goto L68
    L63:
        r15 = 2131247863;
        goto L64
    L47:
        if (r6 == false) goto L54;
        r5.setPadding(com.bytedance.android.shopping.extensions.b.b(10), 0, com.bytedance.android.shopping.extensions.b.b(10), 0);
        if (r2 != 0) goto L52;
        d2.d(r5, 0, 0, com.bytedance.android.shopping.extensions.b.b(5), 0);
        goto L61
    L52:
        if (r2 != (r12 - 1)) goto L61;
        d2.d(r5, com.bytedance.android.shopping.extensions.b.b(5), 0, 0, 0);
        goto L61
    L54:
        if (r2 != 0) goto L57;
        d2.d(r5, com.bytedance.android.shopping.extensions.b.b(10), 0, com.bytedance.android.shopping.extensions.b.b(5), 0);
    L60:
        r5.setPadding(0, 0, 0, 0);
        goto L61
    L57:
        if (r2 != (r12 - 1)) goto L59;
        d2.d(r5, com.bytedance.android.shopping.extensions.b.b(5), 0, com.bytedance.android.shopping.extensions.b.b(10), 0);
        goto L60
    L59:
        d2.d(r5, com.bytedance.android.shopping.extensions.b.b(5), 0, com.bytedance.android.shopping.extensions.b.b(5), 0);
        goto L60
    L39:
        r13 = r11;
        goto L44
    L40:
        b r17 = (b) CollectionsKt.getOrNull(this.b, r2);
        if (r17 == null) goto L43;
        r8 = r17.a;
    L43:
        if (r8 != null) goto L38;
    L22:
        if (a() == false) goto L26;
        if (r6 == false) goto L25;
        int r18 = i;
    L29:
        r9.height = r18;
        r9.gravity = 16;
        r5.setLayoutParams(r9);
        goto L30
    L25:
        r18 = j;
        goto L29
    L26:
        if (r6 == false) goto L28;
        r18 = g;
        goto L29
    L28:
        r18 = h;
        goto L29
    L15:
        r6 = false;
        goto L16
    }

    public DeepFeedProductHeaderTabLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        this.b = CollectionsKt.emptyList();
        this.d = LayoutInflater.from(r2);
        this.e = com.bytedance.android.shopping.extensions.b.b(16);
        this.f = LazyKt.lazy(DeepFeedProductHeaderTabLayout$multiTabStyle$2.INSTANCE);
        setOrientation(0);
        GradientDrawable r5 = new GradientDrawable();
        r5.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(20));
        r5.setColor(ColorProtector.parseColor("#4D262626"));
        r5.setStroke(1, ColorProtector.parseColor("#4DFFFFFF"));
        Unit r6 = Unit.INSTANCE;
        setBackground(r5);
    }

    public /* synthetic */ DeepFeedProductHeaderTabLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
