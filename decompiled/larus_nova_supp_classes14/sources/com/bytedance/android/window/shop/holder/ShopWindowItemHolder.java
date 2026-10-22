package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "T", "Lcom/bytedance/android/window/shop/holder/WindowBaseViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopWindowItemHolder<T extends f> extends WindowBaseViewHolder {
    public static final float p = 0.0f;
    public T o;

    public static final class a {
    }

    public abstract void q4(T r1);

    public boolean s4() {
        return this instanceof WindowAnchorCardHolder;
    }

    public void t4() {
    }

    static {
        p = q.a(1);
    }

    public final void o() {
        super.o();
        t4();
        this.o = null;
    }

    public ShopWindowItemHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    public Rect r4(int r2) {
        return new Rect(0, 0, 0, 0);
    }

    public final void b4(Object r2, String r3, k.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        if ((r2 instanceof mp3.c) == false) goto L5;
        Object r0 = ((mp3.c) r2).a();
    L6:
        super.b4(r0, r3, r4);
        if ((r0 instanceof f) == true) goto L9;
        Object r5 = null;
    L10:
        T r6 = (T) r5;
        if (r6 == null) goto L13;
        q4((f) r0);
        this.o = r6;
        return;
    L13:
        ECExceptionMonitor.e(new Exception("window vo data can not be null, holder is " + getClass() + ", data = " + r2));
        return;
    L9:
        r5 = r0;
        goto L10
    L5:
        r0 = r2;
        goto L6
    }
}
