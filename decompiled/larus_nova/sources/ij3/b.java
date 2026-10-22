package ij3;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f490055b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C6274b> f490056a;

    public static final class a {
    }

    /* JADX INFO: renamed from: ij3.b$b, reason: collision with other inner class name */
    public static final class C6274b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f490057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ECUrlModel f490058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f490059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f490060d;

        public C6274b() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C6274b) == false) goto L14;
            C6274b r101 = (C6274b) r100;
            if (Intrinsics.areEqual(this.f490057a, r101.f490057a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f490058b, r101.f490058b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f490059c, r101.f490059c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f490060d, r101.f490060d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f490057a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ECUrlModel r104 = this.f490058b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f490059c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f490060d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "MarqueeBubbleItemVO(nickName=" + this.f490057a + ", userAvatar=" + this.f490058b + ", marqueeText=" + this.f490059c + ", marqueeType=" + this.f490060d + ")";
        }

        public C6274b(String r100, ECUrlModel r101, String r102, Integer r103) {
            this.f490057a = r100;
            this.f490058b = r101;
            this.f490059c = r102;
            this.f490060d = r103;
        }
    }

    static {
    }

    public b(List<C6274b> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f490056a = r100;
    }
}
