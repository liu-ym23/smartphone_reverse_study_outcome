package com.suite.lark.component.logger;

import com.suite.component.logger.api.e;
import com.suite.component.logger.api.f;
import com.suite.component.logger.api.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c extends com.suite.component.logger.a {

    public static final class a extends com.suite.component.logger.api.b {
        @Override // com.suite.component.logger.api.b
        public final h a() {
            com.suite.lark.component.logger.a r100 = new com.suite.lark.component.logger.a();
            Intrinsics.checkNotNullParameter(r100, "executor");
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f460100b = r100;
            return new c(this);
        }

        @Override // com.suite.component.logger.api.b
        public final com.suite.component.logger.api.b b() {
            a r100 = new a(getContext());
            List<f> r101 = this.f460102d;
            Intrinsics.checkNotNullParameter(r101, "collectors");
            r100.f460102d.addAll(r101);
            List<com.suite.component.logger.api.d> r102 = this.f460103e;
            Intrinsics.checkNotNullParameter(r102, "interceptors");
            r100.f460103e.addAll(r102);
            List<e> r103 = this.f460104f;
            Intrinsics.checkNotNullParameter(r103, "printers");
            r100.f460104f.addAll(r103);
            return r100;
        }

        public a(com.suite.component.logger.b r100) {
            Intrinsics.checkNotNullParameter(r100, "logContext");
            super(r100);
        }
    }

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        super(r100);
    }
}
