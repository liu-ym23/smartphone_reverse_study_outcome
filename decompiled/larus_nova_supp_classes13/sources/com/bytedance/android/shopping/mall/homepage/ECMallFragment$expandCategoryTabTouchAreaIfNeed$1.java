package com.bytedance.android.shopping.mall.homepage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFragment$expandCategoryTabTouchAreaIfNeed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECMallFragment this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.ECMallFragment$expandCategoryTabTouchAreaIfNeed$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ ECMallFragment$expandCategoryTabTouchAreaIfNeed$1 a;

        public AnonymousClass1(ECMallFragment$expandCategoryTabTouchAreaIfNeed$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECHybridListEngine r0 = this.a.this$0.H0;     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            BaseViewHolder r1 = r0.e("category_tab_section", "category_tab_section");     // Catch: Throwable -> L10
            if (r1 == null) goto L17;
            final View r2 = ((RecyclerView.ViewHolder) r1).itemView;     // Catch: Throwable -> L10
            if (r2 == null) goto L18;
            kk.d.c(new ECMallFragment$expandCategoryTabTouchAreaIfNeed$1$1$$special$$inlined$let$lambda$1(r2, this));     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public ECMallFragment$expandCategoryTabTouchAreaIfNeed$1(ECMallFragment r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1143invoke() {
        this.this$0.P1.postAtFrontOfQueue(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1143invoke();
        return Unit.INSTANCE;
    }
}
