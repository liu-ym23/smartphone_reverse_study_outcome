package com.ss.android.lark.forwardv3.configuration.targetconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/GroupConfig;", "Ljava/io/Serializable;", "<init>", "()V", "value", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "tenant", "getTenant", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$GroupType;", "groupType", "getGroupType", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$GroupType;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Status;", "status", "getStatus", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Status;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "shield", "getShield", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "Builder", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupConfig implements Serializable {
    private Condition$GroupType groupType;
    private Condition$Shield shield;
    private Condition$Status status;
    private Condition$Tenant tenant;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Condition$Tenant f425246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Condition$GroupType f425247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Condition$Status f425248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Condition$Shield f425249d;

        public final GroupConfig a() {
            GroupConfig r100 = new GroupConfig();
            GroupConfig.access$setTenant$p(r100, this.f425246a);
            GroupConfig.access$setGroupType$p(r100, this.f425247b);
            GroupConfig.access$setStatus$p(r100, this.f425248c);
            GroupConfig.access$setShield$p(r100, this.f425249d);
            return r100;
        }

        public a() {
            this.f425246a = Condition$Tenant.ALL;
            this.f425247b = Condition$GroupType.ALL;
            this.f425248c = Condition$Status.ALL;
            this.f425249d = Condition$Shield.ALL;
        }

        public final void b(Condition$Tenant r100) {
            Intrinsics.checkNotNullParameter(r100, "tenant");
            this.f425246a = r100;
        }
    }

    public GroupConfig() {
        this.tenant = Condition$Tenant.ALL;
        this.groupType = Condition$GroupType.ALL;
        this.status = Condition$Status.ALL;
        this.shield = Condition$Shield.ALL;
    }

    public final Condition$GroupType getGroupType() {
        return this.groupType;
    }

    public final Condition$Shield getShield() {
        return this.shield;
    }

    public final Condition$Status getStatus() {
        return this.status;
    }

    public final Condition$Tenant getTenant() {
        return this.tenant;
    }

    public static final /* synthetic */ void access$setGroupType$p(GroupConfig r100, Condition$GroupType r101) {
        r100.groupType = r101;
    }

    public static final /* synthetic */ void access$setShield$p(GroupConfig r100, Condition$Shield r101) {
        r100.shield = r101;
    }

    public static final /* synthetic */ void access$setStatus$p(GroupConfig r100, Condition$Status r101) {
        r100.status = r101;
    }

    public static final /* synthetic */ void access$setTenant$p(GroupConfig r100, Condition$Tenant r101) {
        r100.tenant = r101;
    }
}
