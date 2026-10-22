package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\b\tB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/widget/SortBarView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SortBarView extends LinearLayout {
    public final List<a> a;
    public final int b;
    public final int c;

    public static final class a {
        public final String a;
        public final Function3<Long, Boolean, String, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r2, Function3<? super Long, ? super Boolean, ? super String, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "func");
            this.a = r2;
            this.b = r3;
        }
    }

    public final class b extends LinearLayout {
        public static final /* synthetic */ int g = 0;
        public final TextView a;
        public final k b;
        public boolean c;
        public final long d;
        public final String e;
        public final /* synthetic */ SortBarView f;

        public final void a(boolean r6, boolean r7) {
            if (r6 == true) goto L8;
            this.a.setTypeface(Typeface.DEFAULT);
            this.a.setTextColor(this.f.c);
            this.c = false;
            com.bytedance.android.shopping.extensions.f.e(this.a, 400);
            k r8 = this.b;
            if (r8 == null) goto L37;
            r8.b(r8.getAscending(), true);
            return;
        L37:
            return;
        L8:
            com.bytedance.android.shopping.extensions.f.e(this.a, 400);
            this.a.setTextColor(this.f.b);
            if (this.c == false) goto L18;
            k r1 = this.b;
            if (r1 == null) goto L32;
            r1.b(true ^ r1.c, false);
            if (r7 == false) goto L32;
            Iterator<T> r9 = this.f.a.iterator();
        L16:
            if (r9.hasNext() == false) goto L32;
            ((a) r9.next()).b.invoke(Long.valueOf(this.d), Boolean.valueOf(r1.getAscending()), this.e);
        L32:
            this.c = r6;
            return;
        L18:
            k r0 = this.b;
            if (r0 == null) goto L27;
            if (r0 == null) goto L32;
            r0.b(r0.getAscending(), false);
            if (r7 == false) goto L32;
            Iterator<T> r10 = this.f.a.iterator();
        L25:
            if (r10.hasNext() == false) goto L32;
            ((a) r10.next()).b.invoke(Long.valueOf(this.d), Boolean.valueOf(r0.getAscending()), this.e);
            goto L25
        L27:
            if (r7 == false) goto L32;
            Iterator<T> r11 = this.f.a.iterator();
        L30:
            if (r11.hasNext() == false) goto L32;
            ((a) r11.next()).b.invoke(Long.valueOf(this.d), null, this.e);
            goto L30
        }

        public b(SortBarView r4, long r5, String r7, boolean r8, boolean r9, Context r10) {
            Intrinsics.checkNotNullParameter(r7, "title");
            Intrinsics.checkNotNullParameter(r10, "context");
            this.f = r4;
            super(r10);
            this.d = r5;
            this.e = r7;
            setGravity(17);
            ViewGroup.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -1);
            setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(3), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(3));
            Unit r11 = Unit.INSTANCE;
            setLayoutParams(r6);
            setOrientation(0);
            TextView r12 = new TextView(r10);
            r12.setText(r7);
            r12.setTextSize(1, 14.0f);
            this.a = r12;
            addView(r12, new LinearLayout.LayoutParams(-2, -2));
            if (r8 == false) goto L6;
            k r13 = new k(r9, r10);
            this.b = r13;
            LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(7), -2);
            r14.setMargins(com.bytedance.android.shopping.extensions.b.b(6), com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), 0, 0);
            addView(r13, r14);
            return;
        }
    }

    public SortBarView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setOrientation(0);
        this.a = new ArrayList();
        this.b = (int) 4294909001L;
        this.c = (int) 2568362019L;
    }

    public final void a(String r4, Function3<? super Long, ? super Boolean, ? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "cb");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((a) r1).a, r4) == false) goto L4;
    L9:
        a r2 = (a) r1;
        if (r2 == null) goto L12;
        ((ArrayList) this.a).remove(r2);
    L12:
        List<a> r3 = this.a;
        ArrayList r6 = (ArrayList) r3;
        r6.add(new a(r4, r5));
        return;
    L8:
        r1 = null;
        goto L9
    }
}
