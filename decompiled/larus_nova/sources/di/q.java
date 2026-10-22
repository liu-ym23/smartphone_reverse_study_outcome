package di;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f468713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f468714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f468715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f468716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f468717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f468718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f468719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f468720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f468721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f468722j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L26;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f468713a, r101.f468713a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468714b, r101.f468714b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468715c, r101.f468715c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468716d, r101.f468716d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f468717e, r101.f468717e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f468718f, r101.f468718f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468719g, r101.f468719g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f468720h, r101.f468720h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f468721i, r101.f468721i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468722j, r101.f468722j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f468713a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f468714b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f468715c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f468716d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f468717e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f468718f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f468719g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.f468720h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.f468721i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.f468722j;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "TimeStamp(startTime=" + this.f468713a + ", createStreamStart=" + this.f468714b + ", createStreamFinish=" + this.f468715c + ", requestSentTime=" + this.f468716d + ", responseRecvTime=" + this.f468717e + ", endTime=" + this.f468718f + ", ecNetRequestStart=" + this.f468719g + ", ecNetRequestEnd=" + this.f468720h + ", appLevelRequestStart=" + this.f468721i + ", beforeAllInterceptors=" + this.f468722j + ")";
    }

    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(ILoadStallMonitor.START_TIME, this.f468713a), TuplesKt.to("create_stream_start", this.f468714b), TuplesKt.to("create_stream_finish", this.f468715c), TuplesKt.to("request_sent_time", this.f468716d), TuplesKt.to("response_recv_time", this.f468717e), TuplesKt.to("end_time", this.f468718f), TuplesKt.to("ec_net_request_start", this.f468719g), TuplesKt.to("ec_net_request_end", this.f468720h), TuplesKt.to("app_level_request_start", this.f468721i), TuplesKt.to("before_all_interceptors", this.f468722j)});
    }

    public q(Long r100, Long r101, Long r102, Long r103, Long r104, Long r105, Long r106, Long r107, Long r108, Long r110) {
        this.f468713a = r100;
        this.f468714b = r101;
        this.f468715c = r102;
        this.f468716d = r103;
        this.f468717e = r104;
        this.f468718f = r105;
        this.f468719g = r106;
        this.f468720h = r107;
        this.f468721i = r108;
        this.f468722j = r110;
    }
}
