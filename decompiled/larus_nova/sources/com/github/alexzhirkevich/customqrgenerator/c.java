package com.github.alexzhirkevich.customqrgenerator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f274245a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f274245a, ((a) r100).f274245a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f274245a.hashCode();
        }

        public final String toString() {
            return "Url(url=" + this.f274245a + ')';
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.c
        public final String encode() {
            return this.f274245a;
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f274245a = r100;
        }
    }

    String encode();
}
