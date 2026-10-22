package com.larus.navigation.api;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f359657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f359658b = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010 \u001a\u00020\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010&\u001a\u00020\nHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010(\u001a\u00020\rHÆ\u0003Jf\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\nHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/larus/navigation/api/NavMockStore$Snapshot;", "", "routePath", "", "endLat", "", "endLng", "startLat", "startLng", "routePlanType", "", "ridingType", "savedAtMs", "", "<init>", "(Ljava/lang/String;DDLjava/lang/Double;Ljava/lang/Double;ILjava/lang/Integer;J)V", "getRoutePath", "()Ljava/lang/String;", "getEndLat", "()D", "getEndLng", "getStartLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getStartLng", "getRoutePlanType", "()I", "getRidingType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSavedAtMs", "()J", HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;DDLjava/lang/Double;Ljava/lang/Double;ILjava/lang/Integer;J)Lcom/larus/navigation/api/NavMockStore$Snapshot;", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("endLat")
        private final double endLat;

        @SerializedName("endLng")
        private final double endLng;

        @SerializedName("ridingType")
        private final Integer ridingType;

        @SerializedName("routePath")
        private final String routePath;

        @SerializedName("routePlanType")
        private final int routePlanType;

        @SerializedName("savedAtMs")
        private final long savedAtMs;

        @SerializedName("startLat")
        private final Double startLat;

        @SerializedName("startLng")
        private final Double startLng;

        public a() {
            this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, 0, null, 255);
        }

        public final String a() {
            Object[] r100 = new Object[4];
            r100[0] = Double.valueOf(this.endLat);
            r100[1] = Double.valueOf(this.endLng);
            r100[2] = Integer.valueOf(this.routePlanType);
            Integer r101 = this.ridingType;
            if (r101 == null) goto L6;
            String r102 = r101.toString();
            if (r102 == null) goto L6;
        L7:
            r100[3] = r102;
            return String.format("%.6f_%.6f_%d_%s", Arrays.copyOf(r100, 4));
        L6:
            r102 = "null";
            goto L7
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.routePath, r101.routePath) == true) goto L12;
            return false;
        L12:
            if (Double.compare(this.endLat, r101.endLat) == 0) goto L15;
            return false;
        L15:
            if (Double.compare(this.endLng, r101.endLng) == 0) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.startLat, r101.startLat) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.startLng, r101.startLng) == true) goto L24;
            return false;
        L24:
            if (this.routePlanType == r101.routePlanType) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.ridingType, r101.ridingType) == true) goto L30;
            return false;
        L30:
            if (this.savedAtMs == r101.savedAtMs) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            String r100 = this.routePath;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            long r103 = Double.doubleToLongBits(this.endLat);
            int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = Double.doubleToLongBits(this.endLng);
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            Double r107 = this.startLat;
            if (r107 != null) goto L9;
            int r108 = 0;
        L10:
            int r109 = (r106 + r108) * 31;
            Double r110 = this.startLng;
            if (r110 != null) goto L13;
            int r111 = 0;
        L14:
            int r112 = (((r109 + r111) * 31) + this.routePlanType) * 31;
            Integer r113 = this.ridingType;
            if (r113 == null) goto L18;
            r101 = r113.hashCode();
        L18:
            int r114 = (r112 + r101) * 31;
            long r115 = this.savedAtMs;
            return r114 + ((int) (r115 ^ (r115 >>> 32)));
        L13:
            r111 = r110.hashCode();
            goto L14
        L9:
            r108 = r107.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Snapshot(routePath=" + this.routePath + ", endLat=" + this.endLat + ", endLng=" + this.endLng + ", startLat=" + this.startLat + ", startLng=" + this.startLng + ", routePlanType=" + this.routePlanType + ", ridingType=" + this.ridingType + ", savedAtMs=" + this.savedAtMs + ')';
        }

        public final String b() {
            return this.routePath;
        }

        public /* synthetic */ a(double r110, double r111, Double r112, Double r210, int r211, Integer r212, int r213) {
            if ((r213 & 2) == 0) goto L5;
            double r100 = 0.0d;
        L7:
            if ((r213 & 4) == 0) goto L9;
            double r101 = 0.0d;
        L11:
            if ((r213 & 8) == 0) goto L13;
            Double r102 = null;
        L15:
            if ((r213 & 16) == 0) goto L17;
            Double r103 = null;
        L19:
            if ((r213 & 32) == 0) goto L21;
            int r113 = 0;
        L23:
            if ((r213 & 64) == 0) goto L25;
            Integer r114 = null;
        L26:
            this(null, r100, r101, r102, r103, r113, r114, 0);
            return;
        L25:
            r114 = r212;
            goto L26
        L21:
            r113 = r211;
            goto L23
        L17:
            r103 = r210;
            goto L19
        L13:
            r102 = r112;
            goto L15
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }

        public a(String r100, double r101, double r102, Double r103, Double r104, int r105, Integer r106, long r110) {
            this.routePath = r100;
            this.endLat = r101;
            this.endLng = r102;
            this.startLat = r103;
            this.startLng = r104;
            this.routePlanType = r105;
            this.ridingType = r106;
            this.savedAtMs = r110;
        }
    }

    static {
        f359657a = LazyKt.lazy(new d());
        f359658b = LazyKt.lazy(new e());
    }
}
