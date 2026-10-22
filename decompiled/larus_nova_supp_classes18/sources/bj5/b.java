package bj5;

import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends c0c.b implements BenefitManagerAPI {
    public final /* synthetic */ BenefitManagerAPI b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<BenefitManagerAPI> d;

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore R7(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        return this.b.R7(r2, r3);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final Object d8(String r7, int r8, String r9, BenefitManagerAPI.CacheType r10, Continuation<? super BenefitStore> r11) {
        return this.b.d8(r7, r8, r9, r10, r11);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final void destroy() {
        this.b.destroy();
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore g7(String r2, int r3, BenefitManagerAPI.CacheType r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "cacheType");
        return this.b.g7(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore n1() {
        return this.b.n1();
    }

    public final void lf(f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
        Intrinsics.checkNotNullParameter(r2, "toState");
        ((BenefitManagerAPI) this.d.c()).destroy();
    }

    public b(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<BenefitManagerAPI> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), BenefitManagerAPI.class), BenefitManagerAPI.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (BenefitManagerAPI) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r1, g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        BenefitManagerAPI r5 = (BenefitManagerAPI) k.b(r3.c(r4), BenefitManagerAPI.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
