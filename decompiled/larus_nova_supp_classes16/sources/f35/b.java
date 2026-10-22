package f35;

import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.jvm.internal.Intrinsics;
import ph5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final int a;

        public final int getType() {
            return this.a;
        }

        public a(String r1, int r2, String r3, String r4) {
            this.a = r2;
        }
    }

    static {
    }

    public static PermissionResponse b(IDocUserPermission r4) {
        Intrinsics.checkNotNullParameter("CONTENT_COPY", "operation");
        Intrinsics.checkNotNullParameter(r4, "iDocUserPermission");
        PermissionRequest r0 = ((c) org.koin.java.a.c(c.class, null, null, 6)).b("CONTENT_COPY");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r0, new UserPermissionEntity(r4, null));
    }

    public static boolean f(DocumentInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "documentInfo");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L7;
        return a(r3, "CONTENT_COPY").getAllow();
    L7:
        return r3.canCopy();
    }

    public static boolean g(DocumentInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "documentInfo");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L7;
        return a(r3, "VIEW").getAllow();
    L7:
        return r3.canRead();
    }

    public static boolean h(IDocUserPermission r4) {
        Intrinsics.checkNotNullParameter(r4, "iDocUserPermission");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L7;
        PermissionRequest r0 = ((c) org.koin.java.a.c(c.class, null, null, 6)).b("PERCEIVE_CONTROL");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r0, new UserPermissionEntity(r4, null)).getAllow();
    L7:
        return r4.matchPerceiveControl();
    }

    public static PermissionResponse a(DocumentInfo r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "documentInfo");
        Intrinsics.checkNotNullParameter(r6, "operation");
        BaseEntity r0 = new BaseEntity(r5.getObjToken(), sbb.e.d(r5.getType()), BizDomain.FileBizDomainCCM, r5.getCreatorTenantId());
        PermissionRequest r7 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).d(r0, r6);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r7, new UserPermissionEntity(r5.getDocPermission().a, null));
    }

    public static PermissionResponse c(DocumentInfo r4, String r5, BizDomain r6) {
        Intrinsics.checkNotNullParameter(r4, "documentInfo");
        Intrinsics.checkNotNullParameter(r5, "operation");
        Intrinsics.checkNotNullParameter(r6, "domain");
        BaseEntity r0 = new BaseEntity(r4.getObjToken(), sbb.e.d(r4.getType()), r6, r4.getCreatorTenantId());
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r0, r5), new UserPermissionEntity(r4.getDocPermission().a, null));
    }

    public static PermissionResponse d(String r9, sbb.e r10, String r11, BizDomain r12, Object r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "token");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "tenantId");
        Intrinsics.checkNotNullParameter("CONTENT_COPY", "operation");
        Intrinsics.checkNotNullParameter(r12, "domain");
        return e(r9, r10, r11, "CONTENT_COPY", r12, r13, r14, null, null);
    }

    public static PermissionResponse e(String r14, sbb.e r16, String r17, String r18, BizDomain r19, Object r110, String r20, FileBizDomain r21, @EntityType String r22) {
        Intrinsics.checkNotNullParameter(r14, "token");
        Intrinsics.checkNotNullParameter(r16, "type");
        Intrinsics.checkNotNullParameter(r17, "tenantId");
        Intrinsics.checkNotNullParameter(r18, "operation");
        Intrinsics.checkNotNullParameter(r19, "domain");
        UniBaseEntity r1 = new UniBaseEntity(r14, r16, r19, r17, r20, null, r21, null, r22, 160, null);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r1, r18), new UserPermissionEntity(r110, null));
    }
}
