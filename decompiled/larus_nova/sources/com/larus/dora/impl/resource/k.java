package com.larus.dora.impl.resource;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class k {

    public static final class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337889a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f337889a == ((a) r100).f337889a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337889a;
        }

        public final String toString() {
            return "Apk(resourceId=" + this.f337889a + ')';
        }

        public a(int r100) {
            this.f337889a = r100;
            DoraResourceSource r101 = DoraResourceSource.APK;
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f337890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraResourceSource f337891b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f337890a, r101.f337890a) == true) goto L12;
            return false;
        L12:
            if (this.f337891b == r101.f337891b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f337890a.hashCode() * 31) + this.f337891b.hashCode();
        }

        public final String toString() {
            return "FileResource(file=" + this.f337890a + ", source=" + this.f337891b + ')';
        }

        public b(File r100, DoraResourceSource r101) {
            Intrinsics.checkNotNullParameter(r100, "file");
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f337890a = r100;
            this.f337891b = r101;
            if (r101 == DoraResourceSource.APK) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r102 = false;
            goto L6
        }
    }

    public k() {
    }
}
