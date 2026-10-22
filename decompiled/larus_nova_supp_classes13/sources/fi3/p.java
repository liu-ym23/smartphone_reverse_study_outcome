package fi3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lfi3/p;", "", "", "eventId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "g", "notes", "e", "url", "h", "", "startTime", "J", "f", "()J", "endTime", "b", "", "alarmMinutes", "I", "a", "()I", "extractPath", "d", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {
    public static final /* synthetic */ int a = 0;

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

    @SerializedName("start_time")
    private final long startTime;

    @SerializedName("title")
    private final String title;

    @SerializedName("url")
    private final String url;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof p) == false) goto L22;
        p r7 = (p) r6;
        if (Intrinsics.areEqual(this.eventId, r7.eventId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r7.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.notes, r7.notes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r7.url) == true) goto L14;
        return false;
    L14:
        if (this.startTime == r7.startTime) goto L16;
        return false;
    L16:
        if (this.endTime == r7.endTime) goto L18;
        return false;
    L18:
        if (this.alarmMinutes == r7.alarmMinutes) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.extractPath, r7.extractPath) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.eventId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.notes;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.url;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        long r13 = this.startTime;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        long r15 = this.endTime;
        int r16 = (((r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31) + this.alarmMinutes) * 31;
        String r17 = this.extractPath;
        if (r17 == null) goto L22;
        r1 = r17.hashCode();
    L22:
        return r16 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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

    public p(String r2, String r3, String r4, String r5, long r6, long r8, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r2, "eventId");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "notes");
        Intrinsics.checkNotNullParameter(r5, "url");
        this.eventId = r2;
        this.title = r3;
        this.notes = r4;
        this.url = r5;
        this.startTime = r6;
        this.endTime = r8;
        this.alarmMinutes = r10;
        this.extractPath = r11;
    }
}
