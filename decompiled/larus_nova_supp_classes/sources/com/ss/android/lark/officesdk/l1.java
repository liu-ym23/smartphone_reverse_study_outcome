package com.ss.android.lark.officesdk;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l1 implements GeneratedComponentManagerHolder {
    public final Application a;
    public final ApplicationComponentManager b;

    public static final class a implements ComponentSupplier {
        public final /* synthetic */ l1 a;

        public a(l1 r1) {
            this.a = r1;
        }

        @Override // dagger.hilt.android.internal.managers.ComponentSupplier
        public final Object get() {
            h r0 = new h();
            r0.b = (ApplicationContextModule) Preconditions.checkNotNull(new ApplicationContextModule(this.a.a));
            return r0.a();
        }
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return this.b.generatedComponent();
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final GeneratedComponentManager componentManager() {
        return this.b;
    }

    public l1(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "hostApp");
        this.a = r2;
        this.b = new ApplicationComponentManager(new a(this));
    }
}
