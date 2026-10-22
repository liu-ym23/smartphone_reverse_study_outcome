package fd2;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class y {

    public static final class a extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KtvMusic f476506a;

        @Override // fd2.y
        public final Long a() {
            KtvMusic.a r100 = KtvMusic.Companion;
            KtvMusic r101 = this.f476506a;
            r100.getClass();
            return Long.valueOf(KtvMusic.a.a(r101) * 1000);
        }

        public final int hashCode() {
            KtvMusic r100 = this.f476506a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "CountDown(music=" + this.f476506a + ")";
        }

        @Override // fd2.y
        public final KtvMusic b() {
            return this.f476506a;
        }

        public a(KtvMusic r100) {
            Intrinsics.checkNotNullParameter(r100, "music");
            this.f476506a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f476506a, ((a) r100).f476506a) == true) goto L13;
            return false;
        L13:
            return true;
        }
    }

    public static final class b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f476507a = null;

        static {
            f476507a = new b();
        }

        public b() {
        }
    }

    public static final class c extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KtvMusic f476508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f476509b;

        @Override // fd2.y
        public final Long a() {
            return Long.valueOf(this.f476509b);
        }

        public final int hashCode() {
            KtvMusic r100 = this.f476508a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = a().longValue();
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "Paused(music=" + this.f476508a + ", durationLeft=" + a() + ")";
        }

        @Override // fd2.y
        public final KtvMusic b() {
            return this.f476508a;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f476508a, r101.f476508a) == true) goto L8;
            return false;
        L8:
            if (a().longValue() == r101.a().longValue()) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public c(KtvMusic r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "music");
            this.f476508a = r100;
            this.f476509b = r101;
        }
    }

    public static final class d extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public KtvMusic f476510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f476511b;

        @Override // fd2.y
        public final Long a() {
            return Long.valueOf(this.f476511b);
        }

        @Override // fd2.y
        public final KtvMusic b() {
            return this.f476510a;
        }

        public d(KtvMusic r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "music");
            this.f476510a = r100;
            this.f476511b = r101;
        }
    }

    public y() {
    }

    public Long a() {
        return null;
    }

    public KtvMusic b() {
        return null;
    }
}
