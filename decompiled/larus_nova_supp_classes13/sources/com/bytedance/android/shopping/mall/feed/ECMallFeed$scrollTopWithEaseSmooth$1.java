package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$scrollTopWithEaseSmooth$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VirtualLayoutManager $layoutManager;
    final /* synthetic */ ECHybridRecyclerView $recyclerView;
    final /* synthetic */ Function0 $smoothScrollTop;
    final /* synthetic */ ECMallFeed this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallFeed$scrollTopWithEaseSmooth$1 a;

        public a(ECMallFeed$scrollTopWithEaseSmooth$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.$smoothScrollTop.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECMallFeed$scrollTopWithEaseSmooth$1(ECMallFeed r1, VirtualLayoutManager r2, ECHybridRecyclerView r3, Function0 r4) {
        this.this$0 = r1;
        this.$layoutManager = r2;
        this.$recyclerView = r3;
        this.$smoothScrollTop = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1042invoke() {
        if (this.$layoutManager.findFirstVisibleItemPosition() <= 7) goto L9;
        ECHybridListEngine r0 = this.this$0.J;
        if (r0 == null) goto L11;
        ECHybridListAdapter r1 = r0.a;
        if (r1 == null) goto L12;
        int r2 = Math.min(7, r1.getItemCount());
        this.$recyclerView.scrollToPosition(r2);
        this.$recyclerView.post(new a(this));
        return;
    L12:
        return;
    L11:
        return;
    L9:
        this.$smoothScrollTop.invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1042invoke();
        return Unit.INSTANCE;
    }
}
