package com.bytedance.applog.priority;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004R\u0017\u0010\u0013\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/applog/priority/NativePriorityEventMetaFactoryImpl;", "Lcom/bytedance/applog/priority/PriorityEventMetaFactory;", "", "eventId", "", "eventName", "", "sentryStainedValue", "eventIndex", "nt", "abSdkVersion", "Lcom/bytedance/applog/priority/j;", "user", "userUserId", "userUid", "userUserIsLogin", "userUserIsAuth", "userUserType", "userUuid", "metaInjector", "Lcom/bytedance/applog/priority/PriorityEventMetaFactory;", "getMetaInjector", "()Lcom/bytedance/applog/priority/PriorityEventMetaFactory;", "<init>", "(Lcom/bytedance/applog/priority/PriorityEventMetaFactory;)V", "priority_release"}, k = 1, mv = {1, 6, 0})
public final class NativePriorityEventMetaFactoryImpl implements PriorityEventMetaFactory {
    private final PriorityEventMetaFactory metaInjector;

    public String abSdkVersion() {
        return this.metaInjector.abSdkVersion();
    }

    public long eventId() {
        return this.metaInjector.eventId();
    }

    public long eventIndex() {
        return this.metaInjector.eventIndex();
    }

    public int nt() {
        return this.metaInjector.nt();
    }

    public j user() {
        return this.metaInjector.user();
    }

    public final long userUid() {
        j r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f;
    }

    public final long userUserId() {
        j r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b;
    }

    public final int userUserIsAuth() {
        j r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d;
    }

    public final int userUserIsLogin() {
        j r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c;
    }

    public final int userUserType() {
        j r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e;
    }

    public final String userUuid() {
        j r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final PriorityEventMetaFactory getMetaInjector() {
        return this.metaInjector;
    }

    public NativePriorityEventMetaFactoryImpl(PriorityEventMetaFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "metaInjector");
        this.metaInjector = r2;
    }

    public int sentryStainedValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return this.metaInjector.sentryStainedValue(r2);
    }
}
