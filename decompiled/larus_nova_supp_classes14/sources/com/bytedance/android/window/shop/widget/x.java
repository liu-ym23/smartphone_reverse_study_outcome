package com.bytedance.android.window.shop.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x implements WindowHotsaleLoadMoreHolder.a {
    public final /* synthetic */ WindowTypeSeparatedAdapter a;
    public final /* synthetic */ ShopWindowItemHolder b;

    public static final class a implements Runnable {
        public final /* synthetic */ x a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;

        public a(x r1, int r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WindowTypeSeparatedAdapter r0 = this.a.a;     // Catch: Throwable -> L4
            int r1 = this.b + 1;     // Catch: Throwable -> L4
            List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r2 = this.c;     // Catch: Throwable -> L4
            fo.a<WindowLayoutType> r3 = WindowTypeSeparatedAdapter.t;     // Catch: Throwable -> L4
            r0.C2(r1, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public x(WindowTypeSeparatedAdapter r1, ShopWindowItemHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder.a
    public final void b(int r3, List<? extends sq3.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        WindowTypeSeparatedAdapter r0 = this.a;
        fo.a<WindowLayoutType> r1 = WindowTypeSeparatedAdapter.t;
        r0.C2(r3, r4);
    }

    @Override // com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder.a
    public final void a(int r3, sq3.e r4, List<? extends sq3.b> r5) {
        Intrinsics.checkNotNullParameter(r4, "loadMoreVO");
        Intrinsics.checkNotNullParameter(r5, "list");
        List r6 = CollectionsKt.toMutableList(r5);
        Integer r7 = Integer.valueOf(((ArrayList) this.a.h).indexOf(r4));
        if (r7.intValue() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r7 = null;
    L9:
        if (r7 == null) goto L12;
        int r8 = r7.intValue();
        ListProtector.set(this.a.h, r8, ListProtector.remove(r6, 0));
        this.a.notifyItemChanged(r8);
    L12:
        if (r6.isEmpty() == false) goto L14;
        return;
    L14:
        ((RecyclerView.ViewHolder) this.b).itemView.post(new a(this, r3, r6));
        return;
    L5:
        r0 = false;
        goto L6
    }
}
