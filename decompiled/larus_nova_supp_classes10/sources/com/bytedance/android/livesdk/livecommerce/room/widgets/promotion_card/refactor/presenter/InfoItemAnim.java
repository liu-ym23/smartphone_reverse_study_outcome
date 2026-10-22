package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class InfoItemAnim<T> {
    public T a;
    public final Query b;
    public final Query c;
    public final float d;

    public static final class a {
    }

    static {
    }

    public abstract void a(T r1, Query r2);

    public abstract boolean b(T r1, T r2);

    public final void c(final T r4) {
        T r0 = this.a;
        if (r0 != null) goto L9;
        a(r4, this.b);
        View r1 = this.b.b;
        if (r1 == null) goto L7;
        r1.setAlpha(1.0f);
    L7:
        this.c.g(4);
        this.a = r4;
        return;
    L9:
        if (b(r0, r4) == true) goto L14;
        a(r4, this.b);
        View r2 = this.b.b;
        if (r2 == null) goto L13;
        r2.setAlpha(1.0f);
    L13:
        this.c.g(4);
        this.a = r4;
        return;
    L14:
        a(this.a, this.b);
        a(r4, this.c);
        Query r3 = this.c;
        r3.g(0);
        View r5 = r3.f();
        Function0<Unit> r6 = new InfoItemAnim$updateData$1(this, r4);
        if (r5.getHeight() <= 0) goto L17;
        r6.invoke();
        return;
    L17:
        r5.addOnLayoutChangeListener(new w(r6, r5));
    }

    public InfoItemAnim(Query r2, Query r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "queryHide");
        Intrinsics.checkNotNullParameter(r3, "queryShow");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
