package com.bytedance.ee.bear.bitable.core.usercomponent;

import com.bytedance.ee.bear.appsetting.n;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import dagger.Module;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Module
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f210604a = 0;

    public static final class a extends c0c.b implements com.bytedance.ee.bear.bitable.core.usercomponent.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.bitable.core.usercomponent.a f210605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v f210606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.bitable.core.usercomponent.a> f210607d;

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final com.bytedance.ee.bear.bitable.load.cache.a F4() {
            return this.f210605b.F4();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final awa.d J() {
            return this.f210605b.J();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final yr4.f P2() {
            return this.f210605b.P2();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final jdb.g S9() {
            return this.f210605b.S9();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final com.bytedance.ee.bear.bitable.homepage.badge.d Y1() {
            return this.f210605b.Y1();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final com.bytedance.ee.bear.bitable.load.cache.a b5() {
            return this.f210605b.b5();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final n fb() {
            return this.f210605b.fb();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final l g() {
            return this.f210605b.g();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final f k2() {
            return this.f210605b.k2();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final KVRepo xd() {
            return this.f210605b.xd();
        }

        @Override // com.bytedance.ee.bear.bitable.core.usercomponent.a
        public final UserSession z4() {
            return this.f210605b.z4();
        }

        public a(j r100, v r101) {
            UserSession r102 = r100.b();
            if (r102 != null) goto L5;
            r102 = ContainerConstsKt.a();
        L5:
            com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.bitable.core.usercomponent.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), com.bytedance.ee.bear.bitable.core.usercomponent.a.class), com.bytedance.ee.bear.bitable.core.usercomponent.a.class);
            Intrinsics.checkNotNullParameter(r100, "passport");
            Intrinsics.checkNotNullParameter(r101, "accessor");
            Intrinsics.checkNotNullParameter(r103, "proxy");
            super(r100);
            this.f210605b = r103.b();
            this.f210606c = r101;
            this.f210607d = r103;
        }

        @Override // c0c.b
        public final void pf(f0c.g r100, f0c.b r101) {
            Intrinsics.checkNotNullParameter(r101, "toState");
            Intrinsics.checkNotNullParameter(r101, "toState");
            v r102 = this.f210606c;
            f0c.g r103 = r101.a();
            if (r103 == null) goto L6;
            UserSession r104 = r103.f475034b;
            if (r104 == null) goto L6;
        L7:
            com.bytedance.ee.bear.bitable.core.usercomponent.a r105 = (com.bytedance.ee.bear.bitable.core.usercomponent.a) k.b(r102.c(r104), com.bytedance.ee.bear.bitable.core.usercomponent.a.class);
            this.f210607d.e(r105);
            return;
        L6:
            r104 = ContainerConstsKt.a();
            goto L7
        }
    }

    static {
    }
}
