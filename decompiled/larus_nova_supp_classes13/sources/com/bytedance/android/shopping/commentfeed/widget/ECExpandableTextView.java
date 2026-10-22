package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/ECExpandableTextView;", "Landroid/widget/FrameLayout;", "", "text", "", "setContentText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECExpandableTextView extends FrameLayout {
    public static final /* synthetic */ int n = 0;
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public int d;
    public int e;
    public float f;
    public float g;
    public int h;
    public int i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ECExpandableTextView a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ECExpandableTextView r0 = this.a;
            int r1 = ECExpandableTextView.n;
            r0.a();
            this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public a(ECExpandableTextView r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ECExpandableTextView a;

        public c(ECExpandableTextView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ECExpandableTextView r5 = this.a;
            boolean r2 = false;
            if (r5.m == false) goto L5;
            r5.b.setVisibility(8);
            r5.c.setVisibility(0);
            r5.a.setMaxLines(Integer.MAX_VALUE);
            r5.a.setMaxHeight(r5.h);
            r5.setContentText(r5.j);
            r5.a.post(new com.bytedance.android.shopping.commentfeed.widget.b(r5));
        L6:
            r5.m = r2;
            return;
        L5:
            r5.b.setVisibility(0);
            r5.c.setVisibility(8);
            r5.a.setHeight(-2);
            r5.a.setMaxLines(r5.d);
            r5.a.setVerticalScrollBarEnabled(false);
            r5.a.setMovementMethod(null);
            r5.setContentText(r5.j);
            r5.a();
            r2 = true;
            goto L6
        }
    }

    static {
    }

    public ECExpandableTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECExpandableTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (TextUtils.isEmpty(this.j) == false) goto L5;
        return;
    L5:
        if (this.d <= 1) goto L23;
        Layout r0 = this.a.getLayout();
        if (r0 == null) goto L9;
        int r1 = r0.getEllipsisCount(this.a.getLineCount() - 1);
    L11:
        if (r1 <= 0) goto L17;
        this.m = true;
        int r2 = this.a.getLayout().getLineStart(this.d - 1);     // Catch: Exception -> L15
        b(r2, this.a.getLayout().getEllipsisStart(this.d - 1) + r2);     // Catch: Exception -> L15
        this.b.setVisibility(0);     // Catch: Exception -> L15
    L18:
        this.c.setVisibility(8);
        return;
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        this.b.setVisibility(4);
        goto L18
    L17:
        this.b.setVisibility(4);
        goto L18
    L9:
        r1 = 0;
        goto L11
    }

    public final void setContentText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.a.setText(r2);
        this.j = r2;
        this.m = false;
    }

    public final void b(int r6, int r7) {
        if (r6 > 0) goto L4;
        return;
    L4:
        if (r7 >= this.j.length()) goto L20;
        if (r7 <= r6) goto L21;
        StringBuilder r0 = new StringBuilder();
        String r1 = this.j;
        if (r1 == null) goto L18;
        r0.append(r1.substring(r6, r7));
        r0.append("...");
        if ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.a.getPaint().measureText(r0.toString())) >= this.b.getWidth()) goto L12;
        b(r6, r7 - 1);
        return;
    L12:
        TextView r8 = this.a;
        StringBuilder r2 = new StringBuilder();
        String r3 = this.j;
        if (r3 == null) goto L16;
        r2.append(r3.substring(0, r7));
        r2.append("...");
        r8.setText(r2.toString());
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        return;
    }

    public ECExpandableTextView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.d = 4;
        this.e = ColorProtector.parseColor("#161623");
        this.f = UIUtils.dip2Px(r5, 15.0f);
        this.g = UIUtils.dip2Px(r5, 12.0f);
        this.h = com.bytedance.android.shopping.extensions.b.b(220);
        this.i = this.e;
        this.j = "";
        this.k = th.a.f(r5).getString(2131914102);
        this.l = th.a.f(r5).getString(2131914101);
        View r0 = LayoutInflater.from(r5).inflate(2131560681, this);
        TextView r1 = (TextView) r0.findViewById(2131371235);
        this.a = r1;
        TextView r2 = (TextView) r0.findViewById(2131370724);
        this.b = r2;
        TextView r3 = (TextView) r0.findViewById(2131370511);
        this.c = r3;
        TypedArray r8 = r5.obtainStyledAttributes(r6, new int[]{2130969556, 2130969632, 2130969633, 2130969634, 2130969635, 2130969959, 2130970002, 2130970003, 2130970015});
        this.e = r8.getColor(3, this.e);
        this.f = r8.getDimension(4, this.f);
        this.i = r8.getColor(6, this.e);
        this.g = r8.getDimension(7, this.g);
        String r9 = r8.getString(8);
        if (r9 != null) goto L5;
        r9 = this.k;
    L5:
        this.k = r9;
        String r4 = r8.getString(0);
        if (r4 != null) goto L8;
        r4 = this.l;
    L8:
        this.l = r4;
        this.d = r8.getInt(2, 4);
        this.h = (int) r8.getDimension(1, this.h);
        r8.recycle();
        r1.setTextSize(0, this.f);
        r1.setTextColor(this.e);
        r1.setMaxLines(this.d);
        r2.setTextSize(0, this.g);
        r2.setTextColor(this.i);
        r3.setTextSize(0, this.g);
        r3.setTextColor(this.i);
        r2.setText(this.l);
        r3.setText(this.k);
        r1.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        c r10 = new c(this);
        r2.setOnClickListener(r10);
        r3.setOnClickListener(r10);
    }

    public /* synthetic */ ECExpandableTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
