package com.ss.android.lark.officesdk;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.migration.HasCustomInject;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public abstract class Hilt_HiltRoot extends Application implements GeneratedComponentManagerHolder, HasCustomInject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f433085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ApplicationComponentManager f433086b;

    public class a implements ComponentSupplier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Hilt_HiltRoot f433087a;

        @Override // dagger.hilt.android.internal.managers.ComponentSupplier
        public final Object get() {
            h r100 = new h();
            r100.f433227b = (ApplicationContextModule) Preconditions.checkNotNull(new ApplicationContextModule(this.f433087a));
            return r100.a();
        }

        public a(Hilt_HiltRoot r100) {
            this.f433087a = r100;
        }
    }

    @Override // dagger.hilt.android.internal.migration.HasCustomInject
    public final void customInject() {
        if (this.f433085a == true) goto L6;
        this.f433085a = true;
        z r100 = (z) generatedComponent();
        HiltRoot r101 = (HiltRoot) UnsafeCasts.unsafeCast(this);
        r100.g();
        return;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return this.f433086b.generatedComponent();
    }

    public Hilt_HiltRoot() {
        this.f433085a = false;
        this.f433086b = new ApplicationComponentManager(new a(this));
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final GeneratedComponentManager componentManager() {
        return this.f433086b;
    }
}
