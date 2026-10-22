package com.ss.android.lark.officesdk;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class l1 implements GeneratedComponentManagerHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f433387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ApplicationComponentManager f433388b;

    public static final class a implements ComponentSupplier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l1 f433389a;

        public a(l1 r100) {
            this.f433389a = r100;
        }

        @Override // dagger.hilt.android.internal.managers.ComponentSupplier
        public final Object get() {
            h r100 = new h();
            r100.f433227b = (ApplicationContextModule) Preconditions.checkNotNull(new ApplicationContextModule(this.f433389a.f433387a));
            return r100.a();
        }
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return this.f433388b.generatedComponent();
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final GeneratedComponentManager componentManager() {
        return this.f433388b;
    }

    public l1(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "hostApp");
        this.f433387a = r100;
        this.f433388b = new ApplicationComponentManager(new a(this));
    }
}
