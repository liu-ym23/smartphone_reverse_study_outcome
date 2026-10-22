package com.bytedance.ee.bear.permission.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final class DocUserPermissions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EState f236237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EState f236238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EState f236239c;

    public static final enum EState extends Enum<EState> {
        public static final EState ALLOW = null;
        public static final EState CAC_DENY = null;
        public static final EState DENY = null;
        public static final EState ENCRYPTED = null;
        public static final EState NONE = null;
        public static final EState PARTNER_TENANT_SHARE = null;
        public static final EState PUBLIC_PERM_DENY = null;
        public static final EState SECRET_DENY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EState[] f236240a = null;
        public final int value;

        static {
            EState r100 = new EState(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            EState r101 = new EState("ALLOW", 1, 1);
            ALLOW = r101;
            EState r102 = new EState("DENY", 2, 2);
            DENY = r102;
            EState r103 = new EState("PARTNER_TENANT_SHARE", 3, 132);
            PARTNER_TENANT_SHARE = r103;
            EState r104 = new EState("PUBLIC_PERM_DENY", 4, 133);
            PUBLIC_PERM_DENY = r104;
            EState r105 = new EState("SECRET_DENY", 5, 432);
            SECRET_DENY = r105;
            EState r110 = new EState("CAC_DENY", 6, 2002);
            CAC_DENY = r110;
            EState r111 = new EState("ENCRYPTED", 7, 2301);
            ENCRYPTED = r111;
            f236240a = new EState[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static EState[] values() {
            return (EState[]) f236240a.clone();
        }

        public boolean allow() {
            if (this != ALLOW) goto L5;
            return true;
        L5:
            return false;
        }

        public static EState valueOf(String r100) {
            return (EState) a.a(EState.class, r100);
        }

        public EState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public DocUserPermissions() {
    }
}
