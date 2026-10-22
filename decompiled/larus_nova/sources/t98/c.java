package t98;

import com.larus.avlink.gallery.power.policy.AlbumPowerLevel;
import com.larus.avlink.gallery.power.policy.AlbumThermalLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlbumPowerLevel f545110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f545111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f545112c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f545110a == r101.f545110a) goto L12;
            return false;
        L12:
            if (this.f545111b == r101.f545111b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f545112c, r101.f545112c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f545110a.hashCode() * 31) + this.f545111b) * 31) + this.f545112c.hashCode();
        }

        public final String toString() {
            return "PolicyLane(level=" + this.f545110a + ", threadCount=" + this.f545111b + ", reason=" + this.f545112c + ')';
        }

        public b(AlbumPowerLevel r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "level");
            Intrinsics.checkNotNullParameter(r102, "reason");
            this.f545110a = r100;
            this.f545111b = r101;
            this.f545112c = r102;
        }
    }

    /* JADX INFO: renamed from: t98.c$c, reason: collision with other inner class name */
    public /* synthetic */ class C7700c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f545113a = null;

        static {
            int[] r100 = new int[AlbumThermalLevel.values().length];
            r100[AlbumThermalLevel.CRITICAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[AlbumThermalLevel.EMERGENCY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[AlbumThermalLevel.SHUTDOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[AlbumThermalLevel.SEVERE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[AlbumThermalLevel.MODERATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[AlbumThermalLevel.LIGHT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[AlbumThermalLevel.NONE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[AlbumThermalLevel.UNKNOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f545113a = r100;
        }
    }

    static {
    }

    public c() {
    }
}
