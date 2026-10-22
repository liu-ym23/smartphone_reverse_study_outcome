package com.obric.miniapp.alarm;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes33.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f397466a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f397467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f397468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f397469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f397470d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<String> f397471e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f397467a, r101.f397467a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397468b, r101.f397468b) == true) goto L15;
            return false;
        L15:
            if (this.f397469c == r101.f397469c) goto L18;
            return false;
        L18:
            if (this.f397470d == r101.f397470d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f397471e, r101.f397471e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f397467a.hashCode() * 31;
            String r101 = this.f397468b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f397469c == false) goto L9;
            int r104 = 1231;
        L11:
            return ((((r103 + r104) * 31) + this.f397470d) * 31) + this.f397471e.hashCode();
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CombinedResult(ttsContent=" + this.f397467a + ", eventName=" + this.f397468b + ", shouldReport=" + this.f397469c + ", alarmCount=" + this.f397470d + ", alarmIds=" + this.f397471e + ')';
        }

        public a(String r100, String r101, boolean r102, int r103, List<String> r104) {
            Intrinsics.checkNotNullParameter(r100, "ttsContent");
            Intrinsics.checkNotNullParameter(r104, "alarmIds");
            this.f397467a = r100;
            this.f397468b = r101;
            this.f397469c = r102;
            this.f397470d = r103;
            this.f397471e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f397472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f397473b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f397472a, r101.f397472a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397473b, r101.f397473b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f397472a.hashCode() * 31) + this.f397473b.hashCode();
        }

        public final String toString() {
            return "ParsedContent(timePart=" + this.f397472a + ", taskPart=" + this.f397473b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "timePart");
            Intrinsics.checkNotNullParameter(r101, "taskPart");
            this.f397472a = r100;
            this.f397473b = r101;
        }
    }

    static {
        f397466a = new Regex("<([^>]+)>");
    }
}
