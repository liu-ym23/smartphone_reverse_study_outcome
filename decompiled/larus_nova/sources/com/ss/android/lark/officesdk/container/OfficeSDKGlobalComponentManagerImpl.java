package com.ss.android.lark.officesdk.container;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponentManagerImpl;", "Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponentManager;", "builder", "Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent$OfficeSDKGlobalComponentBuilder;", "<init>", "(Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent$OfficeSDKGlobalComponentBuilder;)V", "component", "Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent;", "componentLock", "", "generatedComponent", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKGlobalComponentManagerImpl implements OfficeSDKGlobalComponentManager {
    private final OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder builder;

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private volatile OfficeSDKGlobalComponent f433143component;
    private final Object componentLock;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // dagger.hilt.internal.GeneratedComponentManager
    public OfficeSDKGlobalComponent generatedComponent() {
        if (this.f433143component != null) goto L15;
        Object r100 = this.componentLock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f433143component != null) goto L9;
        this.f433143component = this.builder.build();     // Catch: Throwable -> L12
    L9:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
    L15:
        OfficeSDKGlobalComponent r102 = this.f433143component;
        if (r102 == null) goto L19;
        return r102;
    L19:
        throw new IllegalArgumentException("OfficeSDKGlobalComponent always not null after double check.".toString());
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public /* bridge */ /* synthetic */ OfficeSDKGlobalComponent generatedComponent() {
        return generatedComponent();
    }

    @Inject
    public OfficeSDKGlobalComponentManagerImpl(OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.builder = r100;
        this.componentLock = new Object();
    }
}
