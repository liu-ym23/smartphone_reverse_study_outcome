package com.larus.browsertakeover.render;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class RtpMjpegDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f319526a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/browsertakeover/render/RtpMjpegDecoder$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_BASE64", "EMPTY_DATA", "DATA_TOO_LARGE", "NOT_JPEG", "INVALID_ROTATION", "BOUNDS_DECODE_FAILED", "INVALID_SOURCE_DIMENSIONS", "SOURCE_DIMENSIONS_TOO_LARGE", "DECODE_FAILED", "INVALID_BITMAP_DIMENSIONS", "BITMAP_DIMENSIONS_TOO_LARGE", "ROTATION_FAILED", "OUT_OF_MEMORY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason BITMAP_DIMENSIONS_TOO_LARGE = null;
        public static final Reason BOUNDS_DECODE_FAILED = null;
        public static final Reason DATA_TOO_LARGE = null;
        public static final Reason DECODE_FAILED = null;
        public static final Reason EMPTY_DATA = null;
        public static final Reason INVALID_BASE64 = null;
        public static final Reason INVALID_BITMAP_DIMENSIONS = null;
        public static final Reason INVALID_ROTATION = null;
        public static final Reason INVALID_SOURCE_DIMENSIONS = null;
        public static final Reason NOT_JPEG = null;
        public static final Reason OUT_OF_MEMORY = null;
        public static final Reason ROTATION_FAILED = null;
        public static final Reason SOURCE_DIMENSIONS_TOO_LARGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Reason[] f319527a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319528b = null;

        public static EnumEntries<Reason> getEntries() {
            return f319528b;
        }

        static {
            Reason r100 = new Reason("INVALID_BASE64", 0);
            INVALID_BASE64 = r100;
            Reason r101 = new Reason("EMPTY_DATA", 1);
            EMPTY_DATA = r101;
            Reason r102 = new Reason("DATA_TOO_LARGE", 2);
            DATA_TOO_LARGE = r102;
            Reason r103 = new Reason("NOT_JPEG", 3);
            NOT_JPEG = r103;
            Reason r104 = new Reason("INVALID_ROTATION", 4);
            INVALID_ROTATION = r104;
            Reason r105 = new Reason("BOUNDS_DECODE_FAILED", 5);
            BOUNDS_DECODE_FAILED = r105;
            Reason r110 = new Reason("INVALID_SOURCE_DIMENSIONS", 6);
            INVALID_SOURCE_DIMENSIONS = r110;
            Reason r111 = new Reason("SOURCE_DIMENSIONS_TOO_LARGE", 7);
            SOURCE_DIMENSIONS_TOO_LARGE = r111;
            Reason r112 = new Reason("DECODE_FAILED", 8);
            DECODE_FAILED = r112;
            Reason r113 = new Reason("INVALID_BITMAP_DIMENSIONS", 9);
            INVALID_BITMAP_DIMENSIONS = r113;
            Reason r114 = new Reason("BITMAP_DIMENSIONS_TOO_LARGE", 10);
            BITMAP_DIMENSIONS_TOO_LARGE = r114;
            Reason r115 = new Reason("ROTATION_FAILED", 11);
            ROTATION_FAILED = r115;
            Reason r106 = new Reason("OUT_OF_MEMORY", 12);
            OUT_OF_MEMORY = r106;
            Reason[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
            f319527a = r107;
            f319528b = EnumEntriesKt.enumEntries(r107);
        }

        public static Reason[] values() {
            return (Reason[]) f319527a.clone();
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        public Reason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f319529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f319530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f319531c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f319529a, r101.f319529a) == true) goto L12;
            return false;
        L12:
            if (this.f319530b == r101.f319530b) goto L15;
            return false;
        L15:
            if (this.f319531c == r101.f319531c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f319529a.hashCode() * 31) + this.f319530b) * 31) + this.f319531c;
        }

        public final String toString() {
            return "Decoded(bitmap=" + this.f319529a + ", sourceWidth=" + this.f319530b + ", sourceHeight=" + this.f319531c + ')';
        }

        public a(Bitmap r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
            this.f319529a = r100;
            this.f319530b = r101;
            this.f319531c = r102;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reason f319532a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f319532a == ((b) r100).f319532a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f319532a.hashCode();
        }

        public final String toString() {
            return "Rejected(reason=" + this.f319532a + ')';
        }

        public b(Reason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f319532a = r100;
        }
    }

    public interface c {
    }

    static {
        f319526a = SetsKt.setOf(new Integer[]{0, 90, 180, 270});
    }
}
