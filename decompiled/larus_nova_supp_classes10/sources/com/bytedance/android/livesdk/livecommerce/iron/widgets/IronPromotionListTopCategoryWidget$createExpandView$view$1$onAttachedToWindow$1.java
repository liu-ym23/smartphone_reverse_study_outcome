package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import com.bytedance.android.livesdk.livecommerce.event.a1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class IronPromotionListTopCategoryWidget$createExpandView$view$1$onAttachedToWindow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IronPromotionListTopCategoryWidget$createExpandView$view$1 this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ IronPromotionListTopCategoryWidget$createExpandView$view$1$onAttachedToWindow$1 a;

        public a(IronPromotionListTopCategoryWidget$createExpandView$view$1$onAttachedToWindow$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new a1(true, this.a.this$0.d.m).k();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public IronPromotionListTopCategoryWidget$createExpandView$view$1$onAttachedToWindow$1(IronPromotionListTopCategoryWidget$createExpandView$view$1 r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m825invoke() {
        oh.a.c("livesdk_list_tab_show", new a(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m825invoke();
        return Unit.INSTANCE;
    }
}
