package com.bytedance.ee.bear.document.print;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;

/* JADX INFO: loaded from: classes16.dex */
public final class PrintActionAvailability {

    public static final enum DeniedReason extends Enum<DeniedReason> {
        public static final DeniedReason DELETED_SHORTCUT = null;
        public static final DeniedReason FRONTEND_DISABLED = null;
        public static final DeniedReason MISSING_DOCUMENT = null;
        public static final DeniedReason MISSING_EXPORT_TOKEN = null;
        public static final DeniedReason NONE = null;
        public static final DeniedReason NO_NETWORK = null;
        public static final DeniedReason PERMISSION_PLATFORM = null;
        public static final DeniedReason PERMISSION_PLATFORM_HIDDEN = null;
        public static final DeniedReason SECURITY_POLICY = null;
        public static final DeniedReason SHORTCUT_PERMISSION = null;
        public static final DeniedReason UNKNOWN = null;
        public static final DeniedReason UNSUPPORTED_TYPE = null;
        public static final DeniedReason USER_PERMISSION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DeniedReason[] f221071a = null;

        static {
            DeniedReason r100 = new DeniedReason(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            DeniedReason r101 = new DeniedReason("MISSING_DOCUMENT", 1);
            MISSING_DOCUMENT = r101;
            DeniedReason r102 = new DeniedReason("MISSING_EXPORT_TOKEN", 2);
            MISSING_EXPORT_TOKEN = r102;
            DeniedReason r103 = new DeniedReason("UNSUPPORTED_TYPE", 3);
            UNSUPPORTED_TYPE = r103;
            DeniedReason r104 = new DeniedReason("PERMISSION_PLATFORM_HIDDEN", 4);
            PERMISSION_PLATFORM_HIDDEN = r104;
            DeniedReason r105 = new DeniedReason("NO_NETWORK", 5);
            NO_NETWORK = r105;
            DeniedReason r110 = new DeniedReason("DELETED_SHORTCUT", 6);
            DELETED_SHORTCUT = r110;
            DeniedReason r111 = new DeniedReason("SECURITY_POLICY", 7);
            SECURITY_POLICY = r111;
            DeniedReason r112 = new DeniedReason("SHORTCUT_PERMISSION", 8);
            SHORTCUT_PERMISSION = r112;
            DeniedReason r113 = new DeniedReason("USER_PERMISSION", 9);
            USER_PERMISSION = r113;
            DeniedReason r114 = new DeniedReason("PERMISSION_PLATFORM", 10);
            PERMISSION_PLATFORM = r114;
            DeniedReason r115 = new DeniedReason("FRONTEND_DISABLED", 11);
            FRONTEND_DISABLED = r115;
            DeniedReason r106 = new DeniedReason("UNKNOWN", 12);
            UNKNOWN = r106;
            f221071a = new DeniedReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        }

        public static DeniedReason[] values() {
            return (DeniedReason[]) f221071a.clone();
        }

        public static DeniedReason valueOf(String r100) {
            return (DeniedReason) r27.a.a(DeniedReason.class, r100);
        }

        public DeniedReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum State extends Enum<State> {
        public static final State DISABLED = null;
        public static final State ENABLED = null;
        public static final State HIDDEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f221072a = null;

        static {
            State r100 = new State("HIDDEN", 0);
            HIDDEN = r100;
            State r101 = new State("DISABLED", 1);
            DISABLED = r101;
            State r102 = new State("ENABLED", 2);
            ENABLED = r102;
            f221072a = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) f221072a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final State f221073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DeniedReason f221074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f221075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final PermissionResponse f221076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final FileAuthResultFrom f221077e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f221078f;

        public static a b(DeniedReason r100) {
            return new a(State.HIDDEN, r100, null, null, null, false);
        }

        public static a a(DeniedReason r100, String r101, PermissionResponse r110) {
            return new a(State.DISABLED, r100, r101, r110, null, false);
        }

        public a(State r100, DeniedReason r101, String r102, PermissionResponse r103, FileAuthResultFrom r104, boolean r105) {
            this.f221073a = r100;
            this.f221074b = r101;
            this.f221075c = r102;
            this.f221076d = r103;
            this.f221077e = r104;
            this.f221078f = r105;
        }
    }

    public PrintActionAvailability() {
    }
}
