package com.bytedance.android.window.shop.home.tab.presenter;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements Runnable {
    public final /* synthetic */ ECWindowTabPresenter a;

    public n(ECWindowTabPresenter r1) {
        this.a = r1;
    }

    public final void a() {
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r0 = com.bytedance.android.window.shop.lifecycle.c.a;
        ECWindowTabPresenter r1 = this.a;
        int r2 = ECWindowTabPresenter.C;
        com.bytedance.android.window.shop.lifecycle.f r3 = com.bytedance.android.window.shop.lifecycle.c.a(r1.i0().getLifecycleMonitorId());
        if (r3 == null) goto L5;
        r3.e(this.a.h0().getShopParam(), null, null);
    L5:
        WindowTypeSeparatedAdapter r4 = this.a.e0();
        gr3.e r5 = r4.f;
        com.bytedance.android.window.shop.widget.holderprocessor.c.b r6 = r4.d.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "processor");
        r5.a.remove(r6);
        gr3.e r7 = r4.e;
        com.bytedance.android.window.shop.widget.holderprocessor.c.a r8 = r4.d.d;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "processor");
        r7.a.remove(r8);
        Iterator<Map.Entry<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>, com.bytedance.android.window.shop.widget.holderprocessor.a>> r9 = this.a.e0().d.b.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L16;
        RecyclerView.ViewHolder r10 = r9.next().getKey();
        Intrinsics.checkNotNullParameter(r10, "viewHolder");
        Rect r11 = new Rect();
        if (r10.itemView.getGlobalVisibleRect(r11) == true) goto L11;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == true) goto L7;
        r9.remove();
        goto L7
    L11:
        if (r11.isEmpty() == true) goto L13;
        r12 = true;
        goto L14
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
