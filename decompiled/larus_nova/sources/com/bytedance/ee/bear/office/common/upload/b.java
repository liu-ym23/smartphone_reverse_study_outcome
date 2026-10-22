package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f235338a = null;

        static {
            f235338a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.office.common.upload.b$b, reason: collision with other inner class name */
    public static final class C3378b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OfficeUploadDisabledReason f235339a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3378b) == true) goto L9;
            return false;
        L9:
            if (this.f235339a == ((C3378b) r100).f235339a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f235339a.hashCode();
        }

        public final String toString() {
            return "Disabled(reason=" + this.f235339a + ')';
        }

        public C3378b(OfficeUploadDisabledReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f235339a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OfficeUploadDisabledReason f235340a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f235340a == ((c) r100).f235340a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f235340a.hashCode();
        }

        public final String toString() {
            return "Hidden(reason=" + this.f235340a + ')';
        }

        public c(OfficeUploadDisabledReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f235340a = r100;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PermissionResponse f235341a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f235341a, ((d) r100).f235341a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f235341a.hashCode();
        }

        public final String toString() {
            return "PermissionAction(response=" + this.f235341a + ')';
        }

        public d(PermissionResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f235341a = r100;
        }
    }

    public b() {
    }
}
