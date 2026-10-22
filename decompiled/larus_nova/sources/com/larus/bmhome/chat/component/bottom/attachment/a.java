package com.larus.bmhome.chat.component.bottom.attachment;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.attachment.a$a, reason: collision with other inner class name */
    public static final class C4030a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298081a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4030a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f298081a, ((C4030a) r100).f298081a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f298081a.hashCode();
        }

        public final String toString() {
            return "Drive(token=" + this.f298081a + ')';
        }

        public C4030a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "token");
            this.f298081a = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f298082a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f298082a, ((b) r100).f298082a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f298082a.hashCode();
        }

        public final String toString() {
            return "Local(uri=" + this.f298082a + ')';
        }

        public b(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            this.f298082a = r100;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298083a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f298083a, ((c) r100).f298083a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f298083a.hashCode();
        }

        public final String toString() {
            return "Remote(url=" + this.f298083a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f298083a = r100;
        }
    }
}
