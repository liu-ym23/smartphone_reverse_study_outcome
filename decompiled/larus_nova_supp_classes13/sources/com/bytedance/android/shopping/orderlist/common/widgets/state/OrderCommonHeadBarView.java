package com.bytedance.android.shopping.orderlist.common.widgets.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.orderlist.common.utils.InflaterPriority;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonViewUtils;
import com.bytedance.ies.xbridge.base.utils.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonHeadBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonHeadBarView$HeadBarStyle;", "style", "", "setStyle", "Lkotlin/Function0;", "action", "setClickIconBackListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "HeadBarStyle", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonHeadBarView extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public Map<Integer, View> a;
    public final View b;
    public final View c;
    public HeadBarStyle d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonHeadBarView$HeadBarStyle;", "", "ORDER_LIST", "ORDER_SEARCH_RESULT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HeadBarStyle extends Enum<HeadBarStyle> {
        public static final HeadBarStyle ORDER_LIST = null;
        public static final HeadBarStyle ORDER_SEARCH_RESULT = null;
        public static final /* synthetic */ HeadBarStyle[] a = null;

        static {
            HeadBarStyle r1 = new HeadBarStyle("ORDER_LIST", 0);
            ORDER_LIST = r1;
            HeadBarStyle r2 = new HeadBarStyle("ORDER_SEARCH_RESULT", 1);
            ORDER_SEARCH_RESULT = r2;
            a = new HeadBarStyle[]{r1, r2};
        }

        public static HeadBarStyle valueOf(String r1) {
            return (HeadBarStyle) r27.a.a(HeadBarStyle.class, r1);
        }

        public static HeadBarStyle[] values() {
            return (HeadBarStyle[]) a.clone();
        }

        public HeadBarStyle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public OrderCommonHeadBarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderCommonHeadBarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setClickIconBackListener(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        ((ImageView) _$_findCachedViewById(2131385334)).setOnClickListener(new a(r3));
    }

    public final void setStyle(HeadBarStyle r3) {
        this.d = r3;
        if (r3 == null) goto L20;
        int r4 = com.bytedance.android.shopping.orderlist.common.widgets.state.a.a[r3.ordinal()];
        if (r4 != 1) goto L8;
        ImageView r5 = (ImageView) _$_findCachedViewById(2131385330);
        if (r5 == null) goto L19;
        r5.setImageResource(2131245947);
        return;
    L19:
        return;
    L8:
        if (r4 != 2) goto L21;
        ImageView r6 = (ImageView) _$_findCachedViewById(2131385330);
        if (r6 == null) goto L17;
        r6.setImageResource(2131245948);
        return;
    L17:
        return;
    L21:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderCommonHeadBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        int r5 = OrderCommonViewUtils.a;
        OrderCommonViewUtils.b(InflaterPriority.ORIGIN_ASYNC_CONTEXT, "OrderCommonHeadBarView", r2, 2131564142, this);
        ConstraintLayout r6 = _$_findCachedViewById(2131374212);
        if (r6 == null) goto L5;
        r6.setPadding(0, c.a(r2), 0, 0);
    L5:
        this.b = _$_findCachedViewById(2131385334);
        this.c = _$_findCachedViewById(2131385330);
    }

    public /* synthetic */ OrderCommonHeadBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(boolean r8, ShowBarType r9, String r10, boolean r11, boolean r12, SlcRenderContext r13) {
        if (r13 == null) goto L8;
        View r0 = this.b;
        View r1 = this.c;
        if (r0 == null) goto L6;
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        r3.height = SlcDimensExtensionsKt.b(44, r13);
        r3.width = SlcDimensExtensionsKt.b(44, r13);
        Unit r4 = Unit.INSTANCE;
        r0.setLayoutParams(r3);
    L6:
        if (r1 == null) goto L8;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.height = SlcDimensExtensionsKt.b(44, r13);
        Unit r14 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
    L8:
        ConstraintLayout r15 = _$_findCachedViewById(2131385329);
        if (r8 == false) goto L11;
        int r5 = 0;
    L12:
        r15.setVisibility(r5);
        ConstraintLayout r6 = _$_findCachedViewById(2131387999);
        if (r11 == false) goto L15;
        int r7 = 0;
    L16:
        r6.setVisibility(r7);
        if (r9 == null) goto L27;
        int r16 = com.bytedance.android.shopping.orderlist.common.widgets.state.a.b[r9.ordinal()];
        if (r16 != 1) goto L22;
        ((ImageView) _$_findCachedViewById(2131385334)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(2131385330)).setVisibility(8);
        ConstraintLayout r17 = _$_findCachedViewById(2131374212);
        int r18 = c.a;
        r17.setPadding(0, c.a(getContext()), 0, 0);
        setStyle(this.d);
    L42:
        if (r8 == true) goto L46;
        if (r11 == true) goto L46;
        setVisibility(8);
        return;
    L46:
        setVisibility(0);
        return;
    L22:
        if (r16 != 2) goto L24;
        ((ImageView) _$_findCachedViewById(2131385334)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(2131385330)).setVisibility(0);
        ConstraintLayout r19 = _$_findCachedViewById(2131374212);
        int r110 = c.a;
        r19.setPadding(0, c.a(getContext()), 0, 0);
        setStyle(this.d);
        goto L42
    L24:
        if (r16 != 3) goto L26;
        ((ImageView) _$_findCachedViewById(2131385334)).setVisibility(8);
        if (Intrinsics.areEqual(r10, BarTheme.DARK.getValue()) == false) goto L33;
        ((ImageView) _$_findCachedViewById(2131385330)).setImageResource(2131245949);
    L36:
        if (r12 == false) goto L38;
        _$_findCachedViewById(2131387999).setBackground(com.bytedance.commerce.base.drawable.a.a(OrderCommonHeadBarView$show$2.INSTANCE));
    L39:
        _$_findCachedViewById(2131374212).setPadding(0, 0, 0, 0);
        ((ImageView) _$_findCachedViewById(2131385330)).setVisibility(0);
        goto L42
    L38:
        _$_findCachedViewById(2131387999).setBackgroundColor(j.b(2131103981));
        goto L39
    L33:
        if (Intrinsics.areEqual(r10, BarTheme.LIGHT.getValue()) == false) goto L35;
        ((ImageView) _$_findCachedViewById(2131385330)).setImageResource(2131245950);
        goto L36
    L35:
        ((ImageView) _$_findCachedViewById(2131385330)).setImageResource(2131245956);
        goto L36
    L26:
        if (r16 != 4) goto L27;
        ((ImageView) _$_findCachedViewById(2131385334)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(2131385330)).setVisibility(8);
        _$_findCachedViewById(2131374212).setPadding(0, 0, 0, 0);
        ((ImageView) _$_findCachedViewById(2131385330)).setImageResource(2131245956);
    L27:
        ((ImageView) _$_findCachedViewById(2131385334)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(2131385330)).setVisibility(0);
        ConstraintLayout r20 = _$_findCachedViewById(2131374212);
        int r111 = c.a;
        r20.setPadding(0, c.a(getContext()), 0, 0);
        setStyle(this.d);
        goto L42
    L15:
        r7 = 8;
        goto L16
    L11:
        r5 = 8;
        goto L12
    }
}
