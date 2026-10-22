package com.ss.android.lark.image.compose.android_platform;

import com.ss.android.lark.image.entity.AvatarImage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.image.compose.android_platform.a$a, reason: collision with other inner class name */
    public static final class C5042a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f426248a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5042a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f426248a, ((C5042a) r100).f426248a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f426248a.hashCode();
        }

        public final String toString() {
            return "Custom(platformCustom=" + this.f426248a + ')';
        }

        public C5042a(AvatarImage r100) {
            Intrinsics.checkNotNullParameter(r100, "platformCustom");
            this.f426248a = r100;
        }
    }

    public static final class b implements a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "File(path=null)";
        }
    }

    public static final class c implements a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            ((c) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "Res(id=0)";
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f426249a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f426249a, ((d) r100).f426249a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f426249a.hashCode();
        }

        public final String toString() {
            return "Url(url=" + this.f426249a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f426249a = r100;
        }
    }
}
