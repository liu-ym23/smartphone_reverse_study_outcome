package com.bytedance.android.shopping.card_list.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedStickyConfig;
import com.bytedance.android.shopping.api.mall.feed.d;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.card_list.utils.e;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u00020\u0004¢\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&RA\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0006\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00109\u001a\u0002032\u0006\u00104\u001a\u0002038\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010@\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006H"}, d2 = {"Lcom/bytedance/android/shopping/card_list/widgets/CardListGULView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/api/mall/feed/ECMallFeedStickyConfig;", "getStickyConfig", "", "height", "", "setSafeHeight", "Landroidx/recyclerview/widget/RecyclerView;", "getGULRecyclerView", "Lcom/bytedance/android/shopping/card_list/widgets/b;", "a", "Lcom/bytedance/android/shopping/card_list/widgets/b;", "getViewState", "()Lcom/bytedance/android/shopping/card_list/widgets/b;", "setViewState", "(Lcom/bytedance/android/shopping/card_list/widgets/b;)V", "viewState", "Lcom/bytedance/android/shopping/card_list/widgets/a;", "b", "Lcom/bytedance/android/shopping/card_list/widgets/a;", "getViewAction", "()Lcom/bytedance/android/shopping/card_list/widgets/a;", "setViewAction", "(Lcom/bytedance/android/shopping/card_list/widgets/a;)V", "viewAction", "Lcom/bytedance/android/shopping/api/mall/feed/d;", "e", "Lkotlin/Lazy;", "getMallFeedComponent", "()Lcom/bytedance/android/shopping/api/mall/feed/d;", "mallFeedComponent", "Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "f", "Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "getObjectContainer", "()Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "setObjectContainer", "(Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;)V", "objectContainer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rev", "g", "Lkotlin/jvm/functions/Function1;", "getSetUpCallBack", "()Lkotlin/jvm/functions/Function1;", "setSetUpCallBack", "(Lkotlin/jvm/functions/Function1;)V", "setUpCallBack", "", "value", "h", "Z", "setShow", "(Z)V", "isShow", "i", "I", "getOuterHeight", "()I", "setOuterHeight", "(I)V", "outerHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListGULView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public b a;
    public com.bytedance.android.shopping.card_list.widgets.a b;
    public final boolean c;
    public final Lazy d;
    public final Lazy e;
    public CardListObjectContainer f;
    public Function1<? super RecyclerView, Unit> g;
    public boolean h;
    public int i;

    public static final class a {
    }

    static {
    }

    public CardListGULView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardListGULView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final d getMallFeedComponent() {
        return (d) this.e.getValue();
    }

    private final ECMallFeedStickyConfig getStickyConfig() {
        return new ECMallFeedStickyConfig(new AnonymousClass1(this), new AnonymousClass2(this));
    }

    public final void f() {
        b r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        b r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L8:
        r0.b(r2.c, new CardListGULView$initObserver$1(this), true);
        b r1 = this.a;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L11:
        b r3 = this.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L14:
        r1.b(r3.d, new CardListGULView$initObserver$2(this), true);
        b r4 = this.a;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L17:
        b r5 = this.a;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L20:
        r4.b(r5.e, new CardListGULView$initObserver$3(this), true);
        b r6 = this.a;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L23:
        b r7 = this.a;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L26:
        r6.b(r7.f, new CardListGULView$initObserver$4(this), true);
    }

    public final com.bytedance.android.shopping.card_list.widgets.a getViewAction() {
        com.bytedance.android.shopping.card_list.widgets.a r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r0;
    }

    public final b getViewState() {
        b r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r0;
    }

    private final RecyclerView getGULRecyclerView() {
        return CardListExtentionsKt.e(this);
    }

    public final CardListObjectContainer getObjectContainer() {
        return this.f;
    }

    public final int getOuterHeight() {
        return this.i;
    }

    public final Function1<RecyclerView, Unit> getSetUpCallBack() {
        return this.g;
    }

    public static final /* synthetic */ d a(CardListGULView r0) {
        return r0.getMallFeedComponent();
    }

    public static final /* synthetic */ ECMallFeedStickyConfig b(CardListGULView r0) {
        return r0.getStickyConfig();
    }

    public static final void c(final CardListGULView r4) {
        r4.getClass();
        r4.setSafeHeight(com.bytedance.android.shopping.extensions.b.b(12));
        r4.setShow(false);
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        Function0<Unit> r1 = new CardListGULView$initOrReload$1(r4);
        Intrinsics.checkNotNullParameter(r1, "task");
        Completable.timer(5, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.shopping.card_list.utils.d(r1), new e(null));
    }

    public static final void d(CardListGULView r1) {
        r1.setShow(false);
        r1.setSafeHeight(0);
    }

    public static final void e(CardListGULView r1) {
        r1.setShow(true);
        r1.setSafeHeight(r1.i);
        RecyclerView r2 = r1.getGULRecyclerView();
        if (r2 == null) goto L6;
        CardListExtentionsKt.i(r2);
        return;
    }

    private final void setSafeHeight(int r3) {
        if (getLayoutParams() == null) goto L5;
        getLayoutParams().height = r3;
    L6:
        requestLayout();
        invalidate();
        return;
    L5:
        setLayoutParams(new FrameLayout.LayoutParams(-1, r3));
        goto L6
    }

    private final void setShow(boolean r2) {
        this.h = r2;
        if (r2 == false) goto L9;
        RecyclerView r3 = getGULRecyclerView();
        if (r3 == null) goto L13;
        Function1<? super RecyclerView, Unit> r0 = this.g;
        if (r0 == null) goto L14;
        Unit r4 = (Unit) r0.invoke(r3);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        Function1<? super RecyclerView, Unit> r5 = this.g;
        if (r5 == null) goto L16;
        Unit r6 = (Unit) r5.invoke(null);
        return;
    }

    public final void setObjectContainer(CardListObjectContainer r1) {
        this.f = r1;
    }

    public final void setOuterHeight(int r2) {
        this.i = r2;
        if (this.h == true) goto L5;
        return;
    L5:
        if (getLayoutParams().height == r2) goto L9;
        getLayoutParams().height = r2;
        requestLayout();
        return;
    }

    public final void setSetUpCallBack(Function1<? super RecyclerView, Unit> r1) {
        this.g = r1;
    }

    public final void setViewAction(com.bytedance.android.shopping.card_list.widgets.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setViewState(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public CardListGULView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = true;
        this.d = LazyKt.lazy(new CardListGULView$isInSplitScreen$2(this));
        this.e = LazyKt.lazy(new CardListGULView$mallFeedComponent$2(this, r2));
    }

    public /* synthetic */ CardListGULView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
