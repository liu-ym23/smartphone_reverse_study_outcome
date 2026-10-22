package io.ktor.websocket;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import io.ktor.util.InternalAPI;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class CloseReason {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f492138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f492139b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\n\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes;", "", "", "code", ExifInterface.LATITUDE_SOUTH, "getCode", "()S", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, EffectConstants.NORMAL, "GOING_AWAY", "PROTOCOL_ERROR", "CANNOT_ACCEPT", "CLOSED_ABNORMALLY", "NOT_CONSISTENT", "VIOLATED_POLICY", "TOO_BIG", "NO_EXTENSION", "INTERNAL_ERROR", "SERVICE_RESTART", "TRY_AGAIN_LATER", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final enum Codes extends Enum<Codes> {
        public static final Codes CANNOT_ACCEPT = null;

        @Deprecated(message = "This code MUST NOT be set as a status code in a Close control frame by an endpoint")
        @InternalAPI
        public static final Codes CLOSED_ABNORMALLY = null;
        public static final a Companion = null;
        public static final Codes GOING_AWAY = null;
        public static final Codes INTERNAL_ERROR = null;
        public static final Codes NORMAL = null;
        public static final Codes NOT_CONSISTENT = null;
        public static final Codes NO_EXTENSION = null;
        public static final Codes PROTOCOL_ERROR = null;
        public static final Codes SERVICE_RESTART = null;
        public static final Codes TOO_BIG = null;
        public static final Codes TRY_AGAIN_LATER = null;
        public static final Codes UNEXPECTED_CONDITION = null;
        public static final Codes VIOLATED_POLICY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<Short, Codes> f492140a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Codes[] f492141b = null;
        private final short code;

        public static final class a {
            public a() {
            }
        }

        public static Codes valueOf(String r100) {
            return (Codes) r27.a.a(Codes.class, r100);
        }

        public static Codes[] values() {
            return (Codes[]) f492141b.clone();
        }

        static {
            int r100 = 0;
            Codes r101 = new Codes(EffectConstants.NORMAL, 0, 1000);
            NORMAL = r101;
            Codes r102 = new Codes("GOING_AWAY", 1, 1001);
            GOING_AWAY = r102;
            Codes r103 = new Codes("PROTOCOL_ERROR", 2, 1002);
            PROTOCOL_ERROR = r103;
            Codes r104 = new Codes("CANNOT_ACCEPT", 3, 1003);
            CANNOT_ACCEPT = r104;
            Codes r105 = new Codes("CLOSED_ABNORMALLY", 4, 1006);
            CLOSED_ABNORMALLY = r105;
            Codes r106 = new Codes("NOT_CONSISTENT", 5, 1007);
            NOT_CONSISTENT = r106;
            Codes r110 = new Codes("VIOLATED_POLICY", 6, 1008);
            VIOLATED_POLICY = r110;
            Codes r111 = new Codes("TOO_BIG", 7, 1009);
            TOO_BIG = r111;
            Codes r112 = new Codes("NO_EXTENSION", 8, 1010);
            NO_EXTENSION = r112;
            Codes r113 = new Codes("INTERNAL_ERROR", 9, 1011);
            INTERNAL_ERROR = r113;
            Codes r107 = new Codes("SERVICE_RESTART", 10, 1012);
            SERVICE_RESTART = r107;
            Codes r108 = new Codes("TRY_AGAIN_LATER", 11, 1013);
            TRY_AGAIN_LATER = r108;
            f492141b = new Codes[]{r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108};
            Companion = new a();
            Codes[] r109 = values();
            LinkedHashMap r114 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r109.length), 16));
            int r115 = r109.length;
        L3:
            if (r100 >= r115) goto L5;
            Codes r116 = r109[r100];
            r114.put(Short.valueOf(r116.code), r116);
            r100 = r100 + 1;
            goto L3
        L5:
            f492140a = r114;
            UNEXPECTED_CONDITION = INTERNAL_ERROR;
        }

        public static final /* synthetic */ Map access$getByCodeMap$cp() {
            return f492140a;
        }

        public final short getCode() {
            return this.code;
        }

        public Codes(String r100, int r101, short r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CloseReason) == true) goto L8;
        return false;
    L8:
        CloseReason r101 = (CloseReason) r100;
        if (this.f492138a == r101.f492138a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f492139b, r101.f492139b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f492138a * 31) + this.f492139b.hashCode();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("CloseReason(reason=");
        Codes.a r101 = Codes.Companion;
        short r102 = this.f492138a;
        r101.getClass();
        Object r103 = (Codes) Codes.access$getByCodeMap$cp().get(Short.valueOf(r102));
        if (r103 != null) goto L5;
        r103 = Short.valueOf(this.f492138a);
    L5:
        r100.append(r103);
        r100.append(", message=");
        r100.append(this.f492139b);
        r100.append(')');
        return r100.toString();
    }

    public CloseReason(Codes r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        this(r100.getCode(), r101);
    }

    public CloseReason(short r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f492138a = r100;
        this.f492139b = r101;
    }
}
