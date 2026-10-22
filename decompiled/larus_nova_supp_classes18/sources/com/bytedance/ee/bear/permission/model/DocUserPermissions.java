package com.bytedance.ee.bear.permission.model;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DocUserPermissions {
    public EState a;
    public EState b;
    public EState c;

    public static final enum EState extends Enum<EState> {
        public static final EState ALLOW = null;
        public static final EState CAC_DENY = null;
        public static final EState DENY = null;
        public static final EState ENCRYPTED = null;
        public static final EState NONE = null;
        public static final EState PARTNER_TENANT_SHARE = null;
        public static final EState PUBLIC_PERM_DENY = null;
        public static final EState SECRET_DENY = null;
        public static final /* synthetic */ EState[] a = null;
        public final int value;

        static {
            EState r0 = new EState("NONE", 0, 0);
            NONE = r0;
            EState r1 = new EState("ALLOW", 1, 1);
            ALLOW = r1;
            EState r3 = new EState("DENY", 2, 2);
            DENY = r3;
            EState r5 = new EState("PARTNER_TENANT_SHARE", 3, DocPermissionAction.ACTION_PARTNER_TENANT_SHARE);
            PARTNER_TENANT_SHARE = r5;
            EState r7 = new EState("PUBLIC_PERM_DENY", 4, DocPermissionAction.ACTION_PUBLIC_PERM_DENY);
            PUBLIC_PERM_DENY = r7;
            EState r8 = new EState("SECRET_DENY", 5, DocPermissionAction.ACTION_SECRET_DENY);
            SECRET_DENY = r8;
            EState r10 = new EState("CAC_DENY", 6, 2002);
            CAC_DENY = r10;
            EState r12 = new EState("ENCRYPTED", 7, DocPermissionAction.ACTION_SECRET);
            ENCRYPTED = r12;
            a = new EState[]{r0, r1, r3, r5, r7, r8, r10, r12};
        }

        public static EState[] values() {
            return (EState[]) a.clone();
        }

        public boolean allow() {
            if (this != ALLOW) goto L5;
            return true;
        L5:
            return false;
        }

        public static EState valueOf(String r1) {
            return (EState) a.a(EState.class, r1);
        }

        public EState(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public DocUserPermissions() {
    }
}
