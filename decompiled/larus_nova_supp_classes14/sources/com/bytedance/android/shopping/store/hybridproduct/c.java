package com.bytedance.android.shopping.store.hybridproduct;

import androidx.lifecycle.Lifecycle;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements ti.j {
    public final /* synthetic */ ECShopHybridProductListPresenter a;
    public final /* synthetic */ String b;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.m0().refreshAll();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        dm.a.a("ECShopMemberCardPresenter").a(this.b + ':' + r5.opt("sec_shop_id"));
        if ((!Intrinsics.areEqual(r5.opt("sec_shop_id"), this.a.m0().getStoreParam().getSecShopId())) == false) goto L6;
        return;
    L6:
        if (((QFragmentPresenter) this.a).e.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L8;
        this.a.m0().refreshAll();
        return;
    L8:
        ((ArrayList) this.a.w).add(new a(this));
    }

    public c(ECShopHybridProductListPresenter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
