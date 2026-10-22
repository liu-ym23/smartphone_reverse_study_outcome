package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.d0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010>\u001a\u00020=\u0012\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004R?\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012Rd\u0010\u001f\u001aD\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012#\u0012!\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR?\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006C"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ToolBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Ldr3/f;", "getHintPopupContentGroup", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "getCurrentLayoutType", "layout", "", "setCurrentLayoutType", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "layoutType", "a", "Lkotlin/jvm/functions/Function1;", "getLayoutChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setLayoutChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "layoutChangeCallback", "Lkotlin/Function2;", "", "actionName", "", "paramsMap", "b", "Lkotlin/jvm/functions/Function2;", "getDoEventAction", "()Lkotlin/jvm/functions/Function2;", "setDoEventAction", "(Lkotlin/jvm/functions/Function2;)V", "doEventAction", "tartFilterType", "c", "getFilterTypeChangeCB", "setFilterTypeChangeCB", "filterTypeChangeCB", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "disposable", "Lcom/bytedance/android/window/shop/widget/SortBarView;", "f", "Lcom/bytedance/android/window/shop/widget/SortBarView;", "getSortBarView", "()Lcom/bytedance/android/window/shop/widget/SortBarView;", "setSortBarView", "(Lcom/bytedance/android/window/shop/widget/SortBarView;)V", "sortBarView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolBarView extends ConstraintLayout {
    public static final /* synthetic */ int l = 0;
    public Function1<? super WindowLayoutType, Unit> a;
    public Function2<? super String, ? super Map<String, String>, Unit> b;
    public Function1<? super String, Unit> c;
    public LifecycleOwner d;
    public Disposable e;
    public SortBarView f;
    public ConstraintLayout g;
    public SimpleDraweeView h;
    public LinearLayout i;
    public e0 j;
    public View k;

    private final dr3.f getHintPopupContentGroup() {
        List r1 = CollectionsKt.listOf(new er3.d.c(3000));
        float r2 = 8;
        fr3.a.c r12 = new fr3.a.c(-2, -2, 11, 0, 0, 7, true, (int) 4281940804L, new fr3.a.C0125a(r2, r2, r2, r2));
        dr3.e[] r3 = new dr3.e[3];
        r3[0] = new dr3.c(new fr3.a.b(12));
        List r4 = CollectionsKt.emptyList();
        fr3.a.C0125a.f.getClass();
        fr3.a.C0125a r17 = fr3.a.C0125a.e;
        e0 r8 = this.j;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
    L5:
        List<com.bytedance.android.window.shop.repository.tab.entity.d> r9 = r8.l;
        if (r9 == null) goto L10;
        com.bytedance.android.window.shop.repository.tab.entity.d r10 = (com.bytedance.android.window.shop.repository.tab.entity.d) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L10;
        String r11 = r10.d;
    L11:
        r3[1] = new dr3.h(r4, new fr3.a.g(-2, 18, 0, r17, 13, -1, com.bytedance.android.shopping.extensions.k.j(r11), true));
        r3[2] = new dr3.c(new fr3.a.b(12));
        return new dr3.f(r1, r12, CollectionsKt.listOf(r3));
    L10:
        r11 = null;
        goto L11
    }

    public final WindowLayoutType getCurrentLayoutType() {
        e0 r0 = this.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
    L6:
        return r0.k;
    }

    public final SortBarView getSortBarView() {
        SortBarView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        Disposable r0 = this.e;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        this.f = (SortBarView) findViewById(2131393301);
        this.g = findViewById(2131393286);
        this.h = findViewById(2131393287);
        this.i = (LinearLayout) findViewById(2131393306);
        this.k = findViewById(2131393288);
    }

    public final Disposable getDisposable() {
        return this.e;
    }

    public final Function2<String, Map<String, String>, Unit> getDoEventAction() {
        return this.b;
    }

    public final Function1<String, Unit> getFilterTypeChangeCB() {
        return this.c;
    }

    public final Function1<WindowLayoutType, Unit> getLayoutChangeCallback() {
        return this.a;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.d;
    }

    public static final /* synthetic */ dr3.f R5(ToolBarView r0) {
        return r0.getHintPopupContentGroup();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(e0 r18) {
        this.j = r18;
        final d0 r1 = r18.j;
        if (r1 == null) goto L31;
        SortBarView r4 = this.f;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L8:
        int r5 = r4.getChildCount();
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L14;
        SortBarView r7 = this.f;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L13:
        r7.getChildAt(r6).setOnClickListener(null);
        r6 = r6 + 1;
        goto L9
    L14:
        SortBarView r8 = this.f;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L17:
        r8.removeAllViews();
        Iterator r9 = ((ArrayList) r1.j).iterator();
    L19:
        if (r9.hasNext() == false) goto L27;
        d0.b r10 = (d0.b) r9.next();
        SortBarView r15 = this.f;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L23:
        long r11 = r10.a;
        String r12 = r10.b;
        boolean r13 = r10.c;
        boolean r14 = r10.d;
        boolean r16 = r10.e;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r12, "title");
        SortBarView.b r17 = new SortBarView.b(r15, r11, r12, r13, r14, r15.getContext());
        r17.setOnClickListener(new l(r15));
        r17.a.setTextColor(r15.c);
        if (r16 == false) goto L26;
        r17.a(true, false);
    L26:
        r15.addView(r17, new LinearLayout.LayoutParams(-2, -1));
        goto L19
    L27:
        SortBarView r2 = this.f;
        if (r2 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L30:
        r2.a("inner_selection", new ToolBarView$initSortBar$2(r1));
    L31:
        e0 r3 = this.j;
        if (r3 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
    L34:
        Function2<? super String, ? super Map<String, String>, Unit> r19 = this.b;
        if (r19 == null) goto L41;
        Pair[] r20 = new Pair[1];
        if (r3.k.isSingleColumn() == false) goto L39;
        String r21 = "single_product";
    L40:
        r20[0] = TuplesKt.to("switch_type", r21);
        Unit r22 = (Unit) r19.invoke("store_product_form_switch_show", MapsKt.mutableMapOf(r20));
        goto L41
    L39:
        r21 = "double_product";
    L41:
        U5(r3.k);
        SimpleDraweeView r23 = this.h;
        if (r23 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlIcon");
    L44:
        r23.setOnClickListener(new o(this, r3));
        ConstraintLayout r24 = this.g;
        if (r24 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlArea");
    L47:
        r24.setVisibility(0);
        List<com.bytedance.android.window.shop.repository.tab.entity.d> r25 = r3.l;
        if (r25 == null) goto L65;
        com.bytedance.android.window.shop.repository.tab.entity.d r26 = (com.bytedance.android.window.shop.repository.tab.entity.d) CollectionsKt.firstOrNull(r25);
        if (r26 == null) goto L66;
        Function2<? super String, ? super Map<String, String>, Unit> r27 = this.b;
        if (r27 == null) goto L54;
        Unit r28 = (Unit) r27.invoke("win_goods_filter_button_show", MapsKt.mapOf(TuplesKt.to("button_type", r26.b)));
    L54:
        LinearLayout r29 = this.i;
        if (r29 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("windowTypeFilterArea");
    L57:
        ExtensionsKt.visible(r29);
        T5(r26);
        setOnClickListener(new p(r26, this));
        return;
    L66:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(com.bytedance.android.window.shop.repository.tab.entity.d r4) {
        ((TextView) findViewById(2131393281)).setText(r4.b);
        ECDraweeView r0 = (ECDraweeView) findViewById(2131393280);
        if (r4.c == false) goto L5;
        int r5 = 2131234864;
    L6:
        ECDraweeView.setPlaceholderImage$default(r0, r5, null, 2, null);
        return;
    L5:
        r5 = 2131234863;
        goto L6
    }

    public final void U5(WindowLayoutType r3) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        if (r3.isDoubleColumn() == false) goto L9;
        SimpleDraweeView r4 = this.h;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlIcon");
    L7:
        r4.setImageResource(2131234875);
        return;
    L9:
        if (r3.isSingleColumn() == false) goto L16;
        SimpleDraweeView r5 = this.h;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlIcon");
    L13:
        r5.setImageResource(2131234923);
        return;
    }

    public final void setCurrentLayoutType(WindowLayoutType r3) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        e0 r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.k = r3;
    }

    public final void setDisposable(Disposable r1) {
        this.e = r1;
    }

    public final void setDoEventAction(Function2<? super String, ? super Map<String, String>, Unit> r1) {
        this.b = r1;
    }

    public final void setFilterTypeChangeCB(Function1<? super String, Unit> r1) {
        this.c = r1;
    }

    public final void setLayoutChangeCallback(Function1<? super WindowLayoutType, Unit> r1) {
        this.a = r1;
    }

    public final void setLifecycleOwner(LifecycleOwner r1) {
        this.d = r1;
    }

    public final void setSortBarView(SortBarView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public ToolBarView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
