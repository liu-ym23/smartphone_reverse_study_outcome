package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class l implements b0 {

    public static final class a implements e0c.b {
        public a() {
        }

        @Override // e0c.b
        public final e0c.b a(f0 r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            return this;
        }

        @Override // e0c.b
        public final e0c.b b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            return this;
        }

        @Override // e0c.b
        public final e0c.b userSession(UserSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            return this;
        }

        @Override // e0c.b
        public final e0c.a build() {
            throw new RuntimeException("support UserComponent at top level!");
        }
    }

    public static final class b implements e0c.m {
        public b() {
        }

        @Override // e0c.m
        public final e0c.m a(f0 r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            return this;
        }

        @Override // e0c.m
        public final e0c.m b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            return this;
        }

        @Override // e0c.m
        public final e0c.m userSession(UserSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            return this;
        }

        @Override // e0c.m
        public final e0c.l build() {
            throw new RuntimeException("support UserComponent at top level!");
        }
    }

    @Inject
    public l() {
    }

    @Override // com.ss.android.lark.passportc.internal.w
    public final e0c.m a() {
        return new b();
    }

    @Override // com.ss.android.lark.passportc.internal.c
    public final e0c.b b() {
        return new a();
    }
}
