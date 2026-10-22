package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b {

    public static final class a extends b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.office.common.upload.b$b, reason: collision with other inner class name */
    public static final class C0131b extends b {
        public final OfficeUploadDisabledReason a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0131b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0131b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Disabled(reason=" + this.a + ')';
        }

        public C0131b(OfficeUploadDisabledReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class c extends b {
        public final OfficeUploadDisabledReason a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Hidden(reason=" + this.a + ')';
        }

        public c(OfficeUploadDisabledReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class d extends b {
        public final PermissionResponse a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "PermissionAction(response=" + this.a + ')';
        }

        public d(PermissionResponse r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a = r2;
        }
    }

    public b() {
    }
}
