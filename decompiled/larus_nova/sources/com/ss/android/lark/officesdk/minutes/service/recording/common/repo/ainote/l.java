package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

/* JADX INFO: loaded from: classes37.dex */
public abstract class l {

    public static final class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f434865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f434866b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f434865a == r101.f434865a) goto L12;
            return false;
        L12:
            if (this.f434866b == r101.f434866b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f434865a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            if (this.f434866b == false) goto L5;
            int r102 = 1231;
        L7:
            return r101 + r102;
        L5:
            r102 = 1237;
            goto L7
        }

        public final String toString() {
            return "AbsTime(absTimeMs=" + this.f434865a + ", useNearestAbsTime=" + this.f434866b + ')';
        }

        public a(long r100) {
            this.f434865a = r100;
            this.f434866b = true;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f434867a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f434867a == ((b) r100).f434867a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f434867a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "RelativeTime(createRelAudioTimeMs=" + this.f434867a + ')';
        }

        public b(long r100) {
            this.f434867a = r100;
        }
    }

    public l() {
    }
}
