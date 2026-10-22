package com.ss.android.lark.auditsdk.wrapper;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.Env;
import com.ss.android.lark.pb.security_event.OperatorEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f409727b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAuditModuleDependency f409728a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f409729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Env f409730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OperatorEntity f409731c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f409729a, r101.f409729a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f409730b, r101.f409730b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f409731c, r101.f409731c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f409729a.hashCode() * 31) + this.f409730b.hashCode()) * 31) + this.f409731c.hashCode();
        }

        public final String toString() {
            return "CommonParams(tenantId=" + this.f409729a + ", env=" + this.f409730b + ", operator=" + this.f409731c + ')';
        }

        public a(String r100, Env r101, OperatorEntity r102) {
            Intrinsics.checkNotNullParameter(r100, "tenantId");
            Intrinsics.checkNotNullParameter(r101, "env");
            Intrinsics.checkNotNullParameter(r102, OnekeyLoginConstants.CU_KEY_OPERATOR);
            this.f409729a = r100;
            this.f409730b = r101;
            this.f409731c = r102;
        }
    }

    public static final class b {
    }

    public interface c {
    }

    static {
    }

    public f() {
        this.f409728a = owa.a.d();
    }

    public final void a(com.ss.android.lark.auditsdk.wrapper.b.RunnableC4766b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        String r101 = this.f409728a.getUserAgent();
        String r102 = this.f409728a.getTenantId();
        String r103 = this.f409728a.getUserId();
        OperatorEntity r104 = new OperatorEntity.Builder().Type(EntityType.EntityUserID).Value(r103).build();
        this.f409728a.getDeviceId(new g(r101, r100, r102, r104));
    }
}
