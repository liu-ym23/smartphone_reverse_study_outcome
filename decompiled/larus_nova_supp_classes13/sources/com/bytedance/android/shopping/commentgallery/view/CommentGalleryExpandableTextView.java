package com.bytedance.android.shopping.commentgallery.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/CommentGalleryExpandableTextView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", "listener", "setExpandBtnClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGalleryExpandableTextView extends FrameLayout {
    public static final /* synthetic */ int p = 0;
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
    public boolean n;
    public Function0<Unit> o;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ CommentGalleryExpandableTextView a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            CommentGalleryExpandableTextView r0 = this.a;
            int r1 = CommentGalleryExpandableTextView.p;
            r0.a();
            this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public a(CommentGalleryExpandableTextView r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CommentGalleryExpandableTextView a;

        public c(CommentGalleryExpandableTextView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommentGalleryExpandableTextView r5 = this.a;
            if (r5.m == false) goto L5;
            r5.b.setVisibility(8);
            boolean r1 = false;
            r5.c.setVisibility(0);
            r5.a.setMaxLines(Integer.MAX_VALUE);
            r5.a.setMaxHeight(r5.h);
            r5.a.setText(r5.j);
            r5.m = false;
            r5.a.post(new cc3.a(r5));
        L6:
            r5.m = r1;
            Function0<Unit> r6 = this.a.o;
            if (r6 == null) goto L10;
            Unit r7 = (Unit) r6.invoke();
            return;
        L10:
            return;
        L5:
            r5.c();
            r1 = true;
            goto L6
        }
    }

    static {
    }

    public CommentGalleryExpandableTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentGalleryExpandableTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (TextUtils.isEmpty(this.j) == false) goto L5;
        return;
    L5:
        if (this.d <= 1) goto L16;
        Layout r0 = this.a.getLayout();
        if (r0 == null) goto L9;
        int r1 = r0.getEllipsisCount(this.a.getLineCount() - 1);
    L10:
        if (r1 <= 0) goto L12;
        this.m = true;
        int r2 = this.a.getLayout().getLineStart(this.d - 1);
        b(r2, this.a.getLayout().getEllipsisStart(this.d - 1) + r2);
        this.b.setVisibility(0);
    L13:
        this.c.setVisibility(8);
        return;
    L12:
        this.b.setVisibility(4);
        goto L13
    L9:
        r1 = 0;
        goto L10
    }

    public final void c() {
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.a.setHeight(-2);
        this.a.setMaxLines(this.d);
        this.a.setVerticalScrollBarEnabled(false);
        this.a.setMovementMethod(null);
        this.a.setText(this.j);
        this.m = false;
        a();
    }

    public final void setExpandBtnClickListener(Function0<Unit> r1) {
        this.o = r1;
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

    public CommentGalleryExpandableTextView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.d = 4;
        this.e = ColorProtector.parseColor("#161623");
        this.f = UIUtils.dip2Px(r6, 15.0f);
        this.g = UIUtils.dip2Px(r6, 12.0f);
        this.h = com.bytedance.android.shopping.extensions.b.b(220);
        this.i = this.e;
        this.j = "";
        this.k = th.a.f(r6).getString(2131914102);
        this.l = th.a.f(r6).getString(2131914101);
        View r0 = LayoutInflater.from(r6).inflate(2131560409, this);
        TextView r1 = (TextView) r0.findViewById(2131371235);
        this.a = r1;
        TextView r2 = (TextView) r0.findViewById(2131370724);
        this.b = r2;
        TextView r3 = (TextView) r0.findViewById(2131370511);
        this.c = r3;
        TypedArray r9 = r6.obtainStyledAttributes(r7, new int[]{2130969556, 2130969632, 2130969633, 2130969634, 2130969635, 2130969959, 2130970002, 2130970003, 2130970015});
        this.e = r9.getColor(3, this.e);
        this.f = r9.getDimension(4, this.f);
        this.i = r9.getColor(6, this.e);
        this.g = r9.getDimension(7, this.g);
        String r4 = r9.getString(8);
        if (r4 != null) goto L5;
        r4 = this.k;
    L5:
        this.k = r4;
        String r5 = r9.getString(0);
        if (r5 != null) goto L8;
        r5 = this.l;
    L8:
        this.l = r5;
        this.d = r9.getInt(2, 4);
        this.h = (int) r9.getDimension(1, this.h);
        this.n = r9.getBoolean(5, false);
        r9.recycle();
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
        if (this.n == false) goto L14;
        int r10 = g1.a;
        r2.setBackgroundColor(g1.a.a(r6, 2131106784));
        r3.setBackgroundColor(g1.a.a(r6, 2131106784));
        if (Build.VERSION.SDK_INT < 28) goto L13;
        r1.setLineHeight(com.bytedance.android.shopping.extensions.b.b(22));
    L13:
        r2.setPadding(0, 0, 0, 0);
        r3.setPadding(0, 0, 0, 0);
        f.e(r2, 600);
        f.e(r3, 600);
    L14:
        c r11 = new c(this);
        r2.setOnClickListener(r11);
        r3.setOnClickListener(r11);
    }

    public /* synthetic */ CommentGalleryExpandableTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
