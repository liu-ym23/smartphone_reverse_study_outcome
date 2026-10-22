package com.bytedance.android.window.shop.innerflow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECControllerViewGroup;", "Landroid/widget/LinearLayout;", "", "Lcom/bytedance/android/window/shop/innerflow/widget/ControllerType;", "getChildControllers", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECControllerViewGroup extends LinearLayout {
    public static final int a = 0;

    public static final class a {
    }

    public static final class b extends AppCompatImageView {
        public ControllerState a;
        public final Map<ControllerState, Integer> b;
        public final ControllerType c;
        public final Function0<Boolean> d;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ Function1 b;
            public final /* synthetic */ Function1 c;

            public a(b r1, Function1 r2, Function1 r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                int r4 = rp.a.a;
                if (rp.a.a(this.a.getId()) == false) goto L6;
                return;
            L6:
                if (((Boolean) this.a.d.invoke()).booleanValue() == true) goto L8;
                return;
            L8:
                b r5 = this.a;
                ControllerState r0 = (ControllerState) this.b.invoke(r5.a);
                Intrinsics.checkNotNullParameter(r0, "state");
                r5.a = r0;
                Integer r1 = r5.b.get(r0);
                if (r1 == null) goto L11;
                r5.setImageResource(r1.intValue());
            L11:
                this.c.invoke(this.a.a);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Context r2, ControllerState r3, Function1<? super ControllerState, ? extends ControllerState> r4, Function1<? super ControllerState, Unit> r5, Map<ControllerState, Integer> r6, ControllerType r7, Function0<Boolean> r8) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "initState");
            Intrinsics.checkNotNullParameter(r4, "stateTransformer");
            Intrinsics.checkNotNullParameter(r5, "stateChangedCallback");
            Intrinsics.checkNotNullParameter(r6, "statedResIds");
            Intrinsics.checkNotNullParameter(r7, "controllerType");
            Intrinsics.checkNotNullParameter(r8, "canClick");
            super(r2);
            this.b = r6;
            this.c = r7;
            this.d = r8;
            this.a = r3;
            setOnClickListener(new a(this, r4, r5));
        }
    }

    static {
        a = com.bytedance.android.shopping.extensions.b.b(24);
    }

    private final List<ControllerType> getChildControllers() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = com.bytedance.commerce.base.view.b.a(this).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        Object r2 = (View) r1.next();
        if ((r2 instanceof b) == true) goto L8;
        r2 = null;
    L8:
        b r3 = (b) r2;
        if (r3 == null) goto L4;
        ControllerType r4 = r3.c;
        if (r4 == null) goto L4;
        r0.add(r4);
        goto L4
    L13:
        return r0;
    }

    public final boolean b(List<? extends ControllerType> r2) {
        Intrinsics.checkNotNullParameter(r2, "controllerTypes");
        return Intrinsics.areEqual(CollectionsKt.sorted(r2), CollectionsKt.sorted(getChildControllers()));
    }

    public ECControllerViewGroup(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
    }

    public final void c(ControllerType r6, ControllerState r7) {
        Intrinsics.checkNotNullParameter(r6, "controllerType");
        Intrinsics.checkNotNullParameter(r7, "state");
        Iterator r1 = com.bytedance.commerce.base.view.b.a(this).iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        Object r2 = (View) r1.next();
        ControllerType r4 = null;
        if ((r2 instanceof b) == true) goto L8;
        Object r3 = null;
    L9:
        b r5 = (b) r3;
        if (r5 == null) goto L12;
        r4 = r5.c;
    L12:
        if (r4 != r6) goto L4;
        b r8 = (b) r2;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "state");
        r8.a = r7;
        Integer r9 = r8.b.get(r7);
        if (r9 == null) goto L4;
        r8.setImageResource(r9.intValue());
        goto L4
    L8:
        r3 = r2;
        goto L9
    }

    public final void a(ControllerType r10, Map<ControllerState, Integer> r11, ControllerState r12, Function1<? super ControllerState, ? extends ControllerState> r13, Function1<? super ControllerState, Unit> r14, Function0<Boolean> r15) {
        Intrinsics.checkNotNullParameter(r10, "controllerType");
        Intrinsics.checkNotNullParameter(r11, "statedResIds");
        Intrinsics.checkNotNullParameter(r12, "initState");
        Intrinsics.checkNotNullParameter(r13, "stateTransformer");
        Intrinsics.checkNotNullParameter(r14, "stateChangedCallback");
        Intrinsics.checkNotNullParameter(r15, "canClick");
        AppCompatImageView r0 = new b(getContext(), r12, r13, r14, r11, r10, r15);
        int r16 = com.bytedance.android.shopping.extensions.b.b(4);
        r0.setPadding(r16, r16, r16, r16);
        Integer r17 = r11.get(r12);
        if (r17 == null) goto L6;
        r0.setImageResource(r17.intValue());
    L6:
        if (getChildCount() <= 0) goto L8;
        ImageView r18 = new ImageView(getContext());
        r18.setImageResource(2131234717);
        Unit r19 = Unit.INSTANCE;
        LinearLayout.LayoutParams r110 = generateDefaultLayoutParams();
        r110.width = com.bytedance.android.shopping.extensions.b.b(1);
        r110.height = com.bytedance.android.shopping.extensions.b.b(12);
        r110.setMargins(com.bytedance.android.shopping.extensions.b.b(4), 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
        addView(r18, r110);
    L8:
        LinearLayout.LayoutParams r111 = generateDefaultLayoutParams();
        int r112 = a;
        r111.width = r112;
        r111.height = r112;
        Unit r113 = Unit.INSTANCE;
        addView(r0, r111);
    }
}
