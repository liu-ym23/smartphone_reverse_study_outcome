package com.obric.oui.privacy;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f402494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f402495b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f402494a, r101.f402494a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f402495b, r101.f402495b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f402494a.hashCode() * 31) + this.f402495b.hashCode();
        }

        public final String toString() {
            return "PermissionItem(description=" + this.f402494a + ", permissions=" + this.f402495b + ')';
        }

        public a(String r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "description");
            Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
            this.f402494a = r100;
            this.f402495b = r101;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f402496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f402497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f402498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<Boolean, Unit> f402499d;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f402496a, r101.f402496a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f402497b, r101.f402497b) == true) goto L15;
            return false;
        L15:
            if (this.f402498c == r101.f402498c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f402499d, r101.f402499d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r100 = this.f402496a.hashCode() * 31;
            String r101 = this.f402497b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            boolean r105 = this.f402498c;
            ?? r106 = r105;
            if (r105 == false) goto L9;
            r106 = 1;
        L9:
            int r107 = (r104 + r106) * 31;
            Function1<Boolean, Unit> r108 = this.f402499d;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            return r107 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "SwitchItem(title=" + this.f402496a + ", subtitle=" + this.f402497b + ", isChecked=" + this.f402498c + ", onCheckedChange=" + this.f402499d + ')';
        }

        public b(String r100, boolean r101, Function1 r102) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f402496a = r100;
            this.f402497b = null;
            this.f402498c = r101;
            this.f402499d = r102;
        }
    }

    public j() {
    }
}
