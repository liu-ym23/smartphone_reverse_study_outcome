package com.larus.avlink.gallery.business;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f292366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f292367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f292368c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f292366a, r101.f292366a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f292367b, r101.f292367b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f292368c, r101.f292368c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f292366a.hashCode() * 31) + this.f292367b.hashCode()) * 31) + this.f292368c.hashCode();
        }

        public final String toString() {
            return "Deleted(uniqIds=" + this.f292366a + ", paths=" + this.f292367b + ", source=" + this.f292368c + ')';
        }

        public a(List<String> r100, List<String> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "uniqIds");
            Intrinsics.checkNotNullParameter(r101, "paths");
            Intrinsics.checkNotNullParameter(r102, "source");
            this.f292366a = r100;
            this.f292367b = r101;
            this.f292368c = r102;
        }
    }

    public b() {
    }
}
