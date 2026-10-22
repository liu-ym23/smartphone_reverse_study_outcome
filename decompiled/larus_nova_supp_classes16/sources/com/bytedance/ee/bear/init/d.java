package com.bytedance.ee.bear.init;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.a0;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class d implements com.bytedance.ee.bear.init.b {
    public final NetService a;
    public final s45.c b;
    public final a0 c;
    public final p d;

    public static final class a implements NetService.b {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.NetService.b
        public final String s0(String r2) {
            return this.a.d.s0(r2);
        }
    }

    public static final class b implements a0.a {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.a0.a
        public final void a(DocDynamicConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "docDynamicConfig");
            this.a.a(r2);
        }
    }

    public final void a(DocDynamicConfig r4) {
        b0 r0 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        r0.j(r4);
        this.a.b();
        p.a().O7(r0.o(), r0.g().b.c, r0.p());
    }

    @Inject
    public d(NetService r2, s45.c r3, a0 r4, p r5) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        Intrinsics.checkNotNullParameter(r3, "domainCharacteristicService");
        Intrinsics.checkNotNullParameter(r4, "userAccountInfoService");
        Intrinsics.checkNotNullParameter(r5, "spaceKitUrlHelper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        r2.C7(new a(this));
        r3.dd(false);
        r4.E1(new b(this));
        a(r4.docDynamicConfig());
    }
}
