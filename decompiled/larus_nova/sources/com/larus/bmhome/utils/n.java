package com.larus.bmhome.utils;

import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class n {

    public static final class a extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Uri> f315067a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f315067a, ((a) r100).f315067a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f315067a.hashCode();
        }

        public final String toString() {
            return "MediaContent(uriList=" + this.f315067a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends Uri> r100) {
            Intrinsics.checkNotNullParameter(r100, "uriList");
            this.f315067a = r100;
        }
    }

    public static final class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f315068a = null;

        static {
            f315068a = new b();
        }

        public b() {
        }
    }

    public static final class c extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f315069a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f315069a, ((c) r100).f315069a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f315069a.hashCode();
        }

        public final String toString() {
            return "TextContent(text=" + this.f315069a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f315069a = r100;
        }
    }

    public n() {
    }
}
