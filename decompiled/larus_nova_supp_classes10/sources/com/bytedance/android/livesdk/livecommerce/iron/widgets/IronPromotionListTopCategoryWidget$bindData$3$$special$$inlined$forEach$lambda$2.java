package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0005"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListTopCategoryWidget$bindData$3$1$1$1$1", "com/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$let$lambda$1", "com/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$1"}, k = 3, mv = {1, 4, 3})
final class IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PromotionCategory $category;
    final /* synthetic */ f this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$2 a;

        public a(IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$2(PromotionCategory r1, f r2) {
        this.$category = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m824invoke() {
        oh.a.c("livesdk_list_tab_show", new a(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m824invoke();
        return Unit.INSTANCE;
    }
}
