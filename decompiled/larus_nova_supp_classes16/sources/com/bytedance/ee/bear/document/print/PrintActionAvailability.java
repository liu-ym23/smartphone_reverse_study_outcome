package com.bytedance.ee.bear.document.print;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public static final /* synthetic */ DeniedReason[] a = null;

        static {
            DeniedReason r0 = new DeniedReason("NONE", 0);
            NONE = r0;
            DeniedReason r1 = new DeniedReason("MISSING_DOCUMENT", 1);
            MISSING_DOCUMENT = r1;
            DeniedReason r3 = new DeniedReason("MISSING_EXPORT_TOKEN", 2);
            MISSING_EXPORT_TOKEN = r3;
            DeniedReason r5 = new DeniedReason("UNSUPPORTED_TYPE", 3);
            UNSUPPORTED_TYPE = r5;
            DeniedReason r7 = new DeniedReason("PERMISSION_PLATFORM_HIDDEN", 4);
            PERMISSION_PLATFORM_HIDDEN = r7;
            DeniedReason r9 = new DeniedReason("NO_NETWORK", 5);
            NO_NETWORK = r9;
            DeniedReason r11 = new DeniedReason("DELETED_SHORTCUT", 6);
            DELETED_SHORTCUT = r11;
            DeniedReason r13 = new DeniedReason("SECURITY_POLICY", 7);
            SECURITY_POLICY = r13;
            DeniedReason r16 = new DeniedReason("SHORTCUT_PERMISSION", 8);
            SHORTCUT_PERMISSION = r16;
            DeniedReason r14 = new DeniedReason("USER_PERMISSION", 9);
            USER_PERMISSION = r14;
            DeniedReason r12 = new DeniedReason("PERMISSION_PLATFORM", 10);
            PERMISSION_PLATFORM = r12;
            DeniedReason r10 = new DeniedReason("FRONTEND_DISABLED", 11);
            FRONTEND_DISABLED = r10;
            DeniedReason r8 = new DeniedReason("UNKNOWN", 12);
            UNKNOWN = r8;
            a = new DeniedReason[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10, r8};
        }

        public static DeniedReason[] values() {
            return (DeniedReason[]) a.clone();
        }

        public static DeniedReason valueOf(String r1) {
            return (DeniedReason) r27.a.a(DeniedReason.class, r1);
        }

        public DeniedReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum State extends Enum<State> {
        public static final State DISABLED = null;
        public static final State ENABLED = null;
        public static final State HIDDEN = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r0 = new State("HIDDEN", 0);
            HIDDEN = r0;
            State r1 = new State("DISABLED", 1);
            DISABLED = r1;
            State r3 = new State("ENABLED", 2);
            ENABLED = r3;
            a = new State[]{r0, r1, r3};
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final State a;
        public final DeniedReason b;
        public final String c;
        public final PermissionResponse d;
        public final FileAuthResultFrom e;
        public final boolean f;

        public static a b(DeniedReason r8) {
            return new a(State.HIDDEN, r8, null, null, null, false);
        }

        public static a a(DeniedReason r8, String r9, PermissionResponse r10) {
            return new a(State.DISABLED, r8, r9, r10, null, false);
        }

        public a(State r1, DeniedReason r2, String r3, PermissionResponse r4, FileAuthResultFrom r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public PrintActionAvailability() {
    }
}
