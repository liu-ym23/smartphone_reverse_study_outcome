package si4;

import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import com.larus.photopicker.impl.ui.m0;
import ki4.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public interface c<DATA> extends b<DATA> {

    public static abstract class a<DATA> {

        /* JADX INFO: renamed from: si4.c$a$a, reason: collision with other inner class name */
        public static final class C7616a<DATA> extends a<DATA> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final DATA f542230a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f542231b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final MaterialSelectedState f542232c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final a0 f542233d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C7616a) == true) goto L8;
                return false;
            L8:
                C7616a r101 = (C7616a) r100;
                if (Intrinsics.areEqual(this.f542230a, r101.f542230a) == true) goto L12;
                return false;
            L12:
                if (this.f542231b == r101.f542231b) goto L15;
                return false;
            L15:
                if (this.f542232c == r101.f542232c) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f542233d, r101.f542233d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                DATA r100 = this.f542230a;
                if (r100 != null) goto L5;
                int r101 = 0;
            L7:
                return (((((r101 * 31) + this.f542231b) * 31) + this.f542232c.hashCode()) * 31) + this.f542233d.hashCode();
            L5:
                r101 = r100.hashCode();
                goto L7
            }

            public final String toString() {
                return "Content(data=" + this.f542230a + ", position=" + this.f542231b + ", state=" + this.f542232c + ", categoryType=" + this.f542233d + ')';
            }

            public C7616a(DATA r100, int r101, MaterialSelectedState r102, a0 r103) {
                Intrinsics.checkNotNullParameter(r102, "state");
                Intrinsics.checkNotNullParameter(r103, "categoryType");
                this.f542230a = r100;
                this.f542231b = r101;
                this.f542232c = r102;
                this.f542233d = r103;
            }
        }

        public static final class b<DATA> extends a<DATA> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final DATA f542234a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f542235b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final MaterialSelectedState f542236c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final a0 f542237d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f542234a, r101.f542234a) == true) goto L12;
                return false;
            L12:
                if (this.f542235b == r101.f542235b) goto L15;
                return false;
            L15:
                if (this.f542236c == r101.f542236c) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f542237d, r101.f542237d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                DATA r100 = this.f542234a;
                if (r100 != null) goto L5;
                int r101 = 0;
            L7:
                return (((((r101 * 31) + this.f542235b) * 31) + this.f542236c.hashCode()) * 31) + this.f542237d.hashCode();
            L5:
                r101 = r100.hashCode();
                goto L7
            }

            public final String toString() {
                return "Selector(data=" + this.f542234a + ", position=" + this.f542235b + ", state=" + this.f542236c + ", categoryType=" + this.f542237d + ')';
            }

            public b(DATA r100, int r101, MaterialSelectedState r102, a0 r103) {
                Intrinsics.checkNotNullParameter(r102, "state");
                Intrinsics.checkNotNullParameter(r103, "categoryType");
                this.f542234a = r100;
                this.f542235b = r101;
                this.f542236c = r102;
                this.f542237d = r103;
            }
        }

        public a() {
        }
    }

    void d(m0 r100);
}
