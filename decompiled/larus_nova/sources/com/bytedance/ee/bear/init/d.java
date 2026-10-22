package com.bytedance.ee.bear.init;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.a0;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public final class d implements com.bytedance.ee.bear.init.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f227070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s45.c f227071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f227072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f227073d;

    public static final class a implements NetService.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f227074a;

        public a(d r100) {
            this.f227074a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.NetService.b
        public final String s0(String r100) {
            return this.f227074a.f227073d.s0(r100);
        }
    }

    public static final class b implements a0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f227075a;

        public b(d r100) {
            this.f227075a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.a0.a
        public final void a(DocDynamicConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "docDynamicConfig");
            this.f227075a.a(r100);
        }
    }

    public final void a(DocDynamicConfig r100) {
        b0 r101 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        r101.j(r100);
        this.f227070a.b();
        p.a().O7(r101.o(), r101.g().f216918b.f216938c, r101.p());
    }

    @Inject
    public d(NetService r100, s45.c r101, a0 r102, p r103) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "domainCharacteristicService");
        Intrinsics.checkNotNullParameter(r102, "userAccountInfoService");
        Intrinsics.checkNotNullParameter(r103, "spaceKitUrlHelper");
        this.f227070a = r100;
        this.f227071b = r101;
        this.f227072c = r102;
        this.f227073d = r103;
        r100.C7(new a(this));
        r101.dd(false);
        r102.E1(new b(this));
        a(r102.docDynamicConfig());
    }
}
