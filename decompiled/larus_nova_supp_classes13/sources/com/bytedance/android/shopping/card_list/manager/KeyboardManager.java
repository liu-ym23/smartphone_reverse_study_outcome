package com.bytedance.android.shopping.card_list.manager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.components.CardListBodyComponent;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class KeyboardManager implements com.bytedance.android.shopping.card_list.manager.a {
    public c a;
    public final Lazy b;
    public final Lazy c;
    public final CardListObjectContainer d;
    public final RecyclerView e;
    public final View f;
    public final int g;

    public static final class a implements Runnable {
        public final /* synthetic */ KeyboardManager a;

        public a(KeyboardManager r1) {
            this.a = r1;
        }

        public final void a() {
            CardListSliceCustomWidgetAdapterComponent r0 = (CardListSliceCustomWidgetAdapterComponent) this.a.b.getValue();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.g != true) goto L12;
            this.a.d.e.l.a(Boolean.FALSE);
            CardListSliceCustomWidgetAdapterComponent r1 = (CardListSliceCustomWidgetAdapterComponent) this.a.b.getValue();
            if (r1 == null) goto L9;
            r1.g = false;
        L9:
            ((AndroidYaTaInstance) this.a.d.e.c.invoke()).x(null, aa6.a.a.b, null, null);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.card_list.manager.a
    public final void a() {
        this.f.setVisibility(0);
        CardListBodyComponent r0 = (CardListBodyComponent) this.c.getValue();
        if (r0 == null) goto L5;
        r0.m.d.h.setValue(Unit.INSTANCE);
    L5:
        this.e.post(new a(this));
    }

    @Override // com.bytedance.android.shopping.card_list.manager.a
    public final void z() {
        this.f.setVisibility(8);
        CardListBodyComponent r0 = (CardListBodyComponent) this.c.getValue();
        if (r0 == null) goto L5;
        r0.m.d.g.setValue(Unit.INSTANCE);
    L5:
        Iterator r1 = com.bytedance.commerce.base.view.b.a(this.e).iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (((View) r2).hasFocus() == false) goto L7;
    L12:
        View r3 = (View) r2;
        if (r3 == null) goto L19;
        int r4 = this.e.getChildAdapterPosition(r3);
        this.e.scrollToPosition(r4);
        return;
    L19:
        return;
    L11:
        r2 = null;
        goto L12
    }

    public KeyboardManager(CardListObjectContainer r2, RecyclerView r3, View r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Intrinsics.checkNotNullParameter(r3, "bodyWidget");
        Intrinsics.checkNotNullParameter(r4, "footerWidget");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.b = LazyKt.lazy(new KeyboardManager$sliceCustomWidgetAdapterComponent$2(this));
        this.c = LazyKt.lazy(new KeyboardManager$bodyComponent$2(this));
    }
}
