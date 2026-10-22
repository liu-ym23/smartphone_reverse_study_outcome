package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u001e\u001f !B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\u0007\u001a\u00020\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "", "orientation", "", "setOrientation", "getMaxItemCount", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$c;", "g", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$c;", "getStateChangeListener", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$c;", "setStateChangeListener", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$c;)V", "stateChangeListener", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$b;", "onBottomViewAttachListener", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$b;", "getOnBottomViewAttachListener", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$b;", "setOnBottomViewAttachListener", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$b;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "d", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExpandableLinearLayoutV4 extends LinearLayout implements View.OnClickListener {
    public final int a;
    public boolean b;
    public View c;
    public TextView d;
    public ImageView e;
    public d f;
    public c g;
    public boolean h;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        void a(d r1);
    }

    public static abstract class d {
        public final int a;
        public final int b;

        public static final class a extends d {
            public a() {
                super(2131896992, 2131234433);
            }
        }

        public static final class b extends d {
            public b() {
                super(2131895701, 2131234434);
            }
        }

        public static final class c extends d {
            public c() {
                super(2131911849, 2131234694);
            }
        }

        public d(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public ExpandableLinearLayoutV4(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ExpandableLinearLayoutV4(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final b getOnBottomViewAttachListener() {
        return null;
    }

    public final void setOnBottomViewAttachListener(b r1) {
    }

    public final void b() {
        List r0 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        TextView r3 = (TextView) ((View) r2.next()).findViewById(2131391606);
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(Integer.valueOf(((TextView) r5.next()).getMeasuredWidth()));
        goto L10
    L12:
        Integer r6 = (Integer) CollectionsKt.maxOrNull(r4);
        if (r6 == null) goto L18;
        int r7 = r6.intValue();
        Iterator r8 = r1.iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        TextView r9 = (TextView) r8.next();
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        r10.width = r7;
        Unit r11 = Unit.INSTANCE;
        r9.setLayoutParams(r10);
    L18:
        int r12 = getChildCount() - 1;
        int r13 = this.a;
    L19:
        if (r13 >= r12) goto L21;
        getChildAt(r13).setVisibility(8);
        r13 = r13 + 1;
        goto L19
    }

    public final int getMaxItemCount() {
        return this.a;
    }

    public final c getStateChangeListener() {
        return this.g;
    }

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        if (this.b == true) goto L5;
        addView(r4);
    L6:
        int r5 = getChildCount();
        int r0 = this.a;
        if (r5 > r0) goto L9;
        return;
    L9:
        if ((r5 - r0) != 1) goto L16;
        if (r5 > r0) goto L12;
        return;
    L12:
        if (this.b == true) goto L18;
        addView(c(this.h));
        this.b = true;
        return;
    L18:
        return;
    L16:
        return;
    L5:
        addView(r4, getChildCount() - 1);
        goto L6
    }

    public final View c(boolean r7) {
        View r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        View r1 = LayoutInflater.from(getContext()).inflate(2131560449, this, false);
        this.c = r1;
        ViewGroup.LayoutParams r2 = null;
        if (r1 == null) goto L8;
        TextView r3 = (TextView) r1.findViewById(2131391628);
    L9:
        this.d = r3;
        View r4 = this.c;
        if (r4 == null) goto L12;
        ImageView r5 = (ImageView) r4.findViewById(2131376003);
    L13:
        this.e = r5;
        View r6 = this.c;
        if (r6 == null) goto L16;
        r6.setOnClickListener(this);
    L16:
        View r8 = this.c;
        if (r8 == null) goto L23;
        if (ViewCompat.isAttachedToWindow(r8) == false) goto L21;
        getOnBottomViewAttachListener();
        goto L23
    L21:
        r8.addOnAttachStateChangeListener(new s(r8, this));
    L23:
        if (r7 == false) goto L40;
        TextView r9 = this.d;
        if (r9 == null) goto L27;
        r9.setTextSize(14.0f);
    L27:
        View r10 = this.c;
        if (r10 == null) goto L36;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        r2 = r11;
    L33:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r2;
        if (r12 == null) goto L36;
        r12.topMargin = com.bytedance.android.shopping.extensions.b.b(5);
        r10.setLayoutParams(r12);
    L36:
        ImageView r13 = this.e;
        if (r13 == null) goto L40;
        r13.setImageResource(2131234637);
    L40:
        if (LargeFontModeUtil.a() <= 1.0f) goto L46;
        TextView r14 = this.d;
        if (((Number) LargeFontModeUtil.a.getValue()).floatValue() <= 1.0d) goto L46;
        if (r14 == null) goto L46;
        r14.getTextSize();
        r14.setTextSize(1, (float) (((double) 14.0f) * 1.15d));
    L46:
        return this.c;
    L12:
        r5 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        d r5 = this.f;
        if ((r5 instanceof d.b) == false) goto L9;
        int r6 = getChildCount() - 1;
        int r0 = this.a;
    L5:
        if (r0 >= r6) goto L7;
        getChildAt(r0).setVisibility(8);
        r0 = r0 + 1;
        goto L5
    L7:
        r5 = new d.a();
    L16:
        this.f = r5;
        if ((r5 instanceof d.c) == true) goto L25;
        TextView r1 = this.d;
        if (r1 == null) goto L22;
        r1.setText(r5.a);
    L22:
        ImageView r2 = this.e;
        if (r2 == null) goto L25;
        r2.setImageResource(r5.b);
    L25:
        c r7 = this.g;
        if (r7 == null) goto L33;
        r7.a(this.f);
        return;
    L33:
        return;
    L9:
        if ((r5 instanceof d.a) == false) goto L15;
        int r8 = this.a;
        int r3 = getChildCount();
    L11:
        if (r8 >= r3) goto L13;
        getChildAt(r8).setVisibility(0);
        r8 = r8 + 1;
        goto L11
    L13:
        r5 = new d.b();
        goto L16
    L15:
        if ((r5 instanceof d.c) == true) goto L16;
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r2) {
        if (r2 == 0) goto L6;
        super.setOrientation(r2);
        return;
    L6:
        throw new IllegalStateException("ExpandableLinearLayout only supports vertical orientation ");
    }

    public final void setStateChangeListener(c r1) {
        this.g = r1;
    }

    public ExpandableLinearLayoutV4(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.f = new d.c();
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130972699});
        this.a = r7.getInt(0, 5);
        r7.recycle();
        setOrientation(1);
    }

    public /* synthetic */ ExpandableLinearLayoutV4(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (getChildCount() > this.a) goto L5;
        return;
    L5:
        if (this.b == true) goto L9;
        addView(c(this.h));
        this.b = true;
        return;
    }
}
