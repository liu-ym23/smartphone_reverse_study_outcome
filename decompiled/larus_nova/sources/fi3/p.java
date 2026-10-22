package fi3;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lfi3/p;", "", "", com.heytap.mcssdk.constant.b.f276361k, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", ce.f26391f, "notes", "e", "url", "h", "", DyPayConstant.KEY_START_TIME, "J", "f", "()J", "endTime", "b", "", "alarmMinutes", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "extractPath", "d", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477296a = 0;

    @SerializedName("alarm_minutes")
    private final int alarmMinutes;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("event_id")
    private final String eventId;

    @SerializedName("extract_path")
    private final String extractPath;

    @SerializedName("notes")
    private final String notes;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    @SerializedName("title")
    private final String title;

    @SerializedName("url")
    private final String url;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L22;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.eventId, r101.eventId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.notes, r101.notes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L14;
        return false;
    L14:
        if (this.startTime == r101.startTime) goto L16;
        return false;
    L16:
        if (this.endTime == r101.endTime) goto L18;
        return false;
    L18:
        if (this.alarmMinutes == r101.alarmMinutes) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.extractPath, r101.extractPath) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.eventId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.notes;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.url;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.startTime;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.endTime;
        int r116 = (((r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31) + this.alarmMinutes) * 31;
        String r117 = this.extractPath;
        if (r117 == null) goto L22;
        r101 = r117.hashCode();
    L22:
        return r116 + r101;
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
        return "PDPCalendarParams(eventId=" + this.eventId + ", title=" + this.title + ", notes=" + this.notes + ", url=" + this.url + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", alarmMinutes=" + this.alarmMinutes + ", extractPath=" + this.extractPath + ")";
    }

    public p() {
        this("", "", "", "", 0, 0, 15, null);
    }

    public final int a() {
        return this.alarmMinutes;
    }

    public final long b() {
        return this.endTime;
    }

    public final String c() {
        return this.eventId;
    }

    public final String d() {
        return this.extractPath;
    }

    public final String e() {
        return this.notes;
    }

    public final long f() {
        return this.startTime;
    }

    public final String g() {
        return this.title;
    }

    public final String h() {
        return this.url;
    }

    public p(String r100, String r101, String r102, String r103, long r104, long r105, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276361k);
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "notes");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.eventId = r100;
        this.title = r101;
        this.notes = r102;
        this.url = r103;
        this.startTime = r104;
        this.endTime = r105;
        this.alarmMinutes = r110;
        this.extractPath = r111;
    }
}
