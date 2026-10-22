package com.larus.bmhome.bigimg.download;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class d<T> {

    public static final class a extends d<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f295972a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f295972a, ((a) r100).f295972a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f295972a.hashCode();
        }

        public final String toString() {
            return "Image(url=" + this.f295972a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f295972a = r100;
        }
    }

    public static final class b extends d<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f295973a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f295973a, ((b) r100).f295973a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f295973a.hashCode();
        }

        public final String toString() {
            return "Music(url=" + this.f295973a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f295973a = r100;
        }
    }

    public static final class c extends d<nr9.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final nr9.g f295974a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f295974a, ((c) r100).f295974a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f295974a.hashCode();
        }

        public final String toString() {
            return "Video(data=" + this.f295974a + ')';
        }

        public c(nr9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f295974a = r100;
        }
    }

    public d() {
    }
}
