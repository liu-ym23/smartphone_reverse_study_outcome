package com.bytedance.android.shopping.mall.homepage;

import android.os.Looper;
import androidx.core.util.Supplier;
import com.bytedance.android.shopping.api.mall.MallPageName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/opt/e;", "invoke", "()Lcom/bytedance/android/shopping/mall/homepage/opt/e;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ECMallFragment$firstScreenHelp$2 extends Lambda implements Function0<com.bytedance.android.shopping.mall.homepage.opt.e> {
    final /* synthetic */ ECMallFragment this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.ECMallFragment$firstScreenHelp$2$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "firstScreenResp", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ ECMallFragment$firstScreenHelp$2 this$0;

        public AnonymousClass3(ECMallFragment$firstScreenHelp$2 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(final String r4) {
            Intrinsics.checkNotNullParameter(r4, "firstScreenResp");
            ECMallFragment r0 = this.this$0.this$0;
            Function0<Unit> r1 = new AnonymousClass1(this, r4);
            int r5 = ECMallFragment.h4;
            r0.getClass();
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
            r1.invoke();
            return;
        L5:
            r0.P1.postAtFrontOfQueue(new r(r1));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a<T> implements Supplier {
        public final /* synthetic */ ECMallFragment$firstScreenHelp$2 a;

        public a(ECMallFragment$firstScreenHelp$2 r1) {
            this.a = r1;
        }

        public final Object get() {
            return this.a.this$0.L0;
        }
    }

    public ECMallFragment$firstScreenHelp$2(ECMallFragment r1) {
        this.this$0 = r1;
        super(0);
    }

    public final com.bytedance.android.shopping.mall.homepage.opt.e invoke() {
        com.bytedance.android.shopping.mall.homepage.opt.e.a r0 = com.bytedance.android.shopping.mall.homepage.opt.e.f;
        String r1 = this.this$0.d.e();
        a r2 = new a(this);
        Function0<Unit> r3 = new AnonymousClass2(this);
        AnonymousClass3 r4 = new AnonymousClass3(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "pageName");
        Intrinsics.checkNotNullParameter(r3, "onReceiveData");
        Intrinsics.checkNotNullParameter(r4, "mallDrawFirstScreen");
        if (Intrinsics.areEqual(r1, MallPageName.X_TAB_MALL) == false) goto L10;
        Integer r5 = com.bytedance.android.shopping.mall.homepage.opt.e.e.c();
        if (r5 == null) goto L10;
        if ((r5.intValue() & 1) != 1) goto L10;
        return new com.bytedance.android.shopping.mall.homepage.opt.e(r2, r3, r4);
    L10:
        if (Intrinsics.areEqual(r1, "order_homepage") == false) goto L16;
        Integer r6 = com.bytedance.android.shopping.mall.homepage.opt.e.e.c();
        if (r6 == null) goto L16;
        if (((r6.intValue() >> 1) & 1) != 1) goto L16;
        return new com.bytedance.android.shopping.mall.homepage.opt.e(r2, r3, r4);
    L16:
        return null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1151invoke() {
        return invoke();
    }
}
