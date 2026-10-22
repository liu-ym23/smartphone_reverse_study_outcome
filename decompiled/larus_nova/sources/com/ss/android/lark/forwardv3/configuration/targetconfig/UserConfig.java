package com.ss.android.lark.forwardv3.configuration.targetconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/UserConfig;", "Ljava/io/Serializable;", "<init>", "()V", "value", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "tenant", "getTenant", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$UserType;", "userType", "getUserType", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$UserType;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "shield", "getShield", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "Builder", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserConfig implements Serializable {
    private Condition$Shield shield;
    private Condition$Tenant tenant;
    private Condition$UserType userType;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Condition$Tenant f425255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Condition$UserType f425256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Condition$Shield f425257c;

        public final UserConfig a() {
            UserConfig r100 = new UserConfig();
            UserConfig.access$setTenant$p(r100, this.f425255a);
            UserConfig.access$setUserType$p(r100, this.f425256b);
            UserConfig.access$setShield$p(r100, this.f425257c);
            return r100;
        }

        public a() {
            this.f425255a = Condition$Tenant.ALL;
            this.f425256b = Condition$UserType.ALL;
            this.f425257c = Condition$Shield.ALL;
        }

        public final void b(Condition$Tenant r100) {
            Intrinsics.checkNotNullParameter(r100, "tenant");
            this.f425255a = r100;
        }
    }

    public UserConfig() {
        this.tenant = Condition$Tenant.ALL;
        this.userType = Condition$UserType.ALL;
        this.shield = Condition$Shield.ALL;
    }

    public final Condition$Shield getShield() {
        return this.shield;
    }

    public final Condition$Tenant getTenant() {
        return this.tenant;
    }

    public final Condition$UserType getUserType() {
        return this.userType;
    }

    public static final /* synthetic */ void access$setShield$p(UserConfig r100, Condition$Shield r101) {
        r100.shield = r101;
    }

    public static final /* synthetic */ void access$setTenant$p(UserConfig r100, Condition$Tenant r101) {
        r100.tenant = r101;
    }

    public static final /* synthetic */ void access$setUserType$p(UserConfig r100, Condition$UserType r101) {
        r100.userType = r101;
    }
}
