package com.bytedance.android.window.shop.home.tab.presenter;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowPlayAbilityPlugin;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ ECWindowHybridTabPresenter a;
    public final /* synthetic */ com.bytedance.android.window.shop.widget.holderprocessor.d b;

    public e(ECWindowHybridTabPresenter r1, com.bytedance.android.window.shop.widget.holderprocessor.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<Map.Entry<BaseViewHolder, com.bytedance.android.window.shop.widget.holderprocessor.a>> r0 = this.b.b.entrySet().iterator();     // Catch: Throwable -> L17
    L4:
        if (r0.hasNext() == false) goto L13;
        RecyclerView.ViewHolder r1 = r0.next().getKey();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r1, "viewHolder");     // Catch: Throwable -> L17
        Rect r2 = new Rect();     // Catch: Throwable -> L17
        if (r1.itemView.getGlobalVisibleRect(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L4;
        r0.remove();     // Catch: Throwable -> L17
        goto L4
    L8:
        if (r2.top >= dg4.b.b()) goto L10;
        r3 = true;
        goto L11
    L13:
        com.bytedance.android.ec.window.base.utils.playable.controller.b r4 = ((ECWindowPlayAbilityPlugin) this.a.r.getValue()).a;     // Catch: Throwable -> L17
        if (r4 == null) goto L20;
        r4.a();     // Catch: Throwable -> L17
        return;
    L20:
        return;
    L17:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L29;
        throw th;
    }
}
