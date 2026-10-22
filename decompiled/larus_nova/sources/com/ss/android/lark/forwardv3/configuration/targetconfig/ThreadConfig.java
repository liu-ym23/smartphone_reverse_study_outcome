package com.ss.android.lark.forwardv3.configuration.targetconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/ThreadConfig;", "Ljava/io/Serializable;", "<init>", "()V", "value", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "tenant", "getTenant", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$ThreadType;", "threadType", "getThreadType", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$ThreadType;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Status;", "status", "getStatus", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Status;", "Builder", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadConfig implements Serializable {
    private Condition$Status status;
    private Condition$Tenant tenant;
    private Condition$ThreadType threadType;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Condition$Tenant f425252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Condition$ThreadType f425253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Condition$Status f425254c;

        public final ThreadConfig a() {
            ThreadConfig r100 = new ThreadConfig();
            ThreadConfig.access$setTenant$p(r100, this.f425252a);
            ThreadConfig.access$setThreadType$p(r100, this.f425253b);
            ThreadConfig.access$setStatus$p(r100, this.f425254c);
            return r100;
        }

        public a() {
            this.f425252a = Condition$Tenant.ALL;
            this.f425253b = Condition$ThreadType.ALL;
            this.f425254c = Condition$Status.ALL;
        }

        public final void b(Condition$ThreadType r100) {
            Intrinsics.checkNotNullParameter(r100, "threadType");
            this.f425253b = r100;
        }
    }

    public ThreadConfig() {
        this.tenant = Condition$Tenant.ALL;
        this.threadType = Condition$ThreadType.ALL;
        this.status = Condition$Status.ALL;
    }

    public final Condition$Status getStatus() {
        return this.status;
    }

    public final Condition$Tenant getTenant() {
        return this.tenant;
    }

    public final Condition$ThreadType getThreadType() {
        return this.threadType;
    }

    public static final /* synthetic */ void access$setStatus$p(ThreadConfig r100, Condition$Status r101) {
        r100.status = r101;
    }

    public static final /* synthetic */ void access$setTenant$p(ThreadConfig r100, Condition$Tenant r101) {
        r100.tenant = r101;
    }

    public static final /* synthetic */ void access$setThreadType$p(ThreadConfig r100, Condition$ThreadType r101) {
        r100.threadType = r101;
    }
}
