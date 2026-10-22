package com.bytedance.ee.bear.drive.core.thumbnail;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f224374a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f224374a, ((a) r100).f224374a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f224374a.hashCode();
        }

        public final String toString() {
            return "Hit(file=" + this.f224374a + ')';
        }

        public a(File r100) {
            Intrinsics.checkNotNullParameter(r100, "file");
            this.f224374a = r100;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f224375a = null;

        static {
            f224375a = new b();
        }

        public b() {
        }
    }

    public g() {
    }
}
