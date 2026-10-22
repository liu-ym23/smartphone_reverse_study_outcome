package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.f;
import com.bytedance.android.shopping.store.tabkit.model.g;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.GenericDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getECDraweeView", "Landroid/widget/TextView;", "getTextView", "Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView$a;", "c", "Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView$a;", "getOnItemClickListener", "()Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView$a;", "setOnItemClickListener", "(Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView$a;)V", "onItemClickListener", "Landroid/util/AttributeSet;", "d", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", "context", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RightItemView extends LinearLayout {
    public final ArrayList<f> a;
    public final ArrayList<View> b;
    public a c;
    public final AttributeSet d;

    public interface a {
        void a(View r1, f r2);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ RightItemView b;

        public b(f r1, int r2, RightItemView r3) {
            this.a = r1;
            this.b = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            a r0 = this.b.getOnItemClickListener();
            if (r0 == null) goto L6;
            r0.a(r3, this.a);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ RightItemView b;

        public c(f r1, int r2, RightItemView r3) {
            this.a = r1;
            this.b = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            a r0 = this.b.getOnItemClickListener();
            if (r0 == null) goto L6;
            r0.a(r3, this.a);
            return;
        }
    }

    public RightItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RightItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ECDraweeView getECDraweeView() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((View) r1) instanceof ECDraweeView) == false) goto L4;
    L9:
        GenericDraweeView r2 = (View) r1;
        if (r2 != null) goto L12;
        r2 = new ECDraweeView(getContext(), null, 0, 6, null);
        r2.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(24), com.bytedance.android.shopping.extensions.b.b(24)));
    L14:
        return (ECDraweeView) r2;
    L12:
        this.b.remove(r2);
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    private final TextView getTextView() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((View) r1) instanceof TextView) == false) goto L4;
    L9:
        KeyEvent.Callback r2 = (View) r1;
        if (r2 != null) goto L12;
        r2 = new TextView(getContext());
    L14:
        return (TextView) r2;
    L12:
        this.b.remove(r2);
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    public final AttributeSet getAttrs() {
        return this.d;
    }

    public final a getOnItemClickListener() {
        return this.c;
    }

    public final void setOnItemClickListener(a r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View, android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView, com.facebook.drawee.view.GenericDraweeView] */
    public final void a(List<f> r7, g r8) {
        this.a.clear();
        if (r7 == null) goto L5;
        this.a.addAll(r7);
    L5:
        this.b.addAll(com.bytedance.commerce.base.view.b.a(this));
        removeAllViews();
        int r9 = 0;
        if (r8 == null) goto L10;
        Integer r0 = r8.f();
        if (r0 == null) goto L10;
        int r1 = com.bytedance.android.shopping.extensions.b.b(r0);
    L11:
        com.bytedance.android.shopping.extensions.f.d(this, r1, 2);
        Iterator<f> r2 = this.a.iterator();
    L13:
        if (r2.hasNext() == false) goto L45;
        f r3 = r2.next();
        int r4 = r9 + 1;
        if (r9 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        f r5 = r3;
        if (r5.c() == null) goto L21;
        ?? r6 = getECDraweeView();
        e.d(r8, r6);
        h0 r10 = h0.a;
        e.g(r6, r5.c());
        r6.setOnClickListener(new b(r5, r9, this));
        Unit r11 = Unit.INSTANCE;
        addView(r6);
    L44:
        r9 = r4;
        goto L13
    L21:
        if (r5.e() == null) goto L44;
        TextView r12 = getTextView();
        if (r8 == null) goto L27;
        Integer r13 = r8.a();
        if (r13 == null) goto L27;
        ViewExtensionsKt.h(r12, r13.intValue());
    L27:
        r12.setText(r5.e());
        if (r8 == null) goto L32;
        Integer r14 = r8.b();
        if (r14 == null) goto L32;
        int r15 = r14.intValue();
    L33:
        com.bytedance.android.shopping.extensions.f.e(r12, Integer.valueOf(r15));
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L41
        if (r8 == null) goto L38;
        String r17 = r8.g();     // Catch: Throwable -> L41
        if (r17 == null) goto L38;
    L39:
        r12.setTextColor(Color.parseColor(r17));     // Catch: Throwable -> L41
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        r12.setOnClickListener(new c(r5, r9, this));
        Unit r18 = Unit.INSTANCE;
        addView(r12);
    L38:
        r17 = "#FFFFFFFF";
    L41:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L32:
        r15 = 400;
        goto L33
    L45:
        return;
    L10:
        r1 = 0;
        goto L11
    }

    public RightItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = r3;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public /* synthetic */ RightItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
