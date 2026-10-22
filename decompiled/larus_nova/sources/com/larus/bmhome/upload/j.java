package com.larus.bmhome.upload;

import com.larus.platform.model.chat.v0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f314779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f314780b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f314781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f314782b;

        public a() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f314781a, r101.f314781a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f314782b, r101.f314782b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f314781a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f314782b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "VideoWH(width=" + this.f314781a + ", height=" + this.f314782b + ')';
        }

        public a(Integer r100, Integer r101) {
            this.f314781a = r100;
            this.f314782b = r101;
        }
    }

    public j() {
    }

    static {
        f314779a = new j();
        f314780b = LazyKt.lazy(new i());
    }

    public static v0 a() {
        return (v0) f314780b.getValue();
    }
}
