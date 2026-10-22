package eub;

import com.bytedance.keva.KevaImpl;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingSource f474154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f474155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f474156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f474157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f474159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f474160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f474161i;

    public f() {
        this(null, null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f474153a, r101.f474153a) == true) goto L12;
        return false;
    L12:
        if (this.f474154b == r101.f474154b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474155c, r101.f474155c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474156d, r101.f474156d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474157e, r101.f474157e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474158f, r101.f474158f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474159g, r101.f474159g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474160h, r101.f474160h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f474161i, r101.f474161i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f474153a.hashCode() * 31) + this.f474154b.hashCode()) * 31) + this.f474155c.hashCode()) * 31) + this.f474156d.hashCode()) * 31;
        String r101 = this.f474157e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f474158f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f474159g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f474160h.hashCode()) * 31;
        String r111 = this.f474161i;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMinutesFileUploadTaskParam(taskId=" + this.f474153a + ", source=" + this.f474154b + ", files=" + this.f474155c + ", recordUuid=" + this.f474156d + ", realtimeRecordingStartMs=" + this.f474157e + ", realtimeRecordingStopMs=" + this.f474158f + ", startTimeZoneOffset=" + this.f474159g + ", extra=" + this.f474160h + ", doubaoBizInfo=" + this.f474161i + ')';
    }

    public final String b() {
        return this.f474161i;
    }

    public final Map<String, String> c() {
        return this.f474160h;
    }

    public final List<d> d() {
        return this.f474155c;
    }

    public final String e() {
        return this.f474156d;
    }

    public final MmRecordingSource f() {
        return this.f474154b;
    }

    public final String g() {
        return this.f474153a;
    }

    public static f a(f r110, String r111, List r112, Map r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r111 = r110.f474153a;
    L5:
        String r100 = r111;
        if ((r114 & 2) == 0) goto L8;
        MmRecordingSource r101 = r110.f474154b;
    L10:
        if ((r114 & 4) == 0) goto L12;
        r112 = r110.f474155c;
    L12:
        List r102 = r112;
        if ((r114 & 8) == 0) goto L15;
        String r103 = r110.f474156d;
    L17:
        if ((r114 & 16) == 0) goto L19;
        String r104 = r110.f474157e;
    L21:
        if ((r114 & 32) == 0) goto L23;
        String r105 = r110.f474158f;
    L25:
        if ((r114 & 64) == 0) goto L27;
        String r106 = r110.f474159g;
    L29:
        if ((r114 & 128) == 0) goto L31;
        r113 = r110.f474160h;
    L31:
        Map r107 = r113;
        if ((r114 & 256) == 0) goto L34;
        String r108 = r110.f474161i;
    L35:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        Intrinsics.checkNotNullParameter(r103, "recordUuid");
        Intrinsics.checkNotNullParameter(r107, "extra");
        return new f(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L34:
        r108 = null;
        goto L35
    L27:
        r106 = null;
        goto L29
    L23:
        r105 = null;
        goto L25
    L19:
        r104 = null;
        goto L21
    L15:
        r103 = null;
        goto L17
    L8:
        r101 = null;
        goto L10
    }

    public f(String r100, MmRecordingSource r101, List<d> r102, String r103, String r104, String r105, String r106, Map<String, String> r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        Intrinsics.checkNotNullParameter(r103, "recordUuid");
        Intrinsics.checkNotNullParameter(r107, "extra");
        this.f474153a = r100;
        this.f474154b = r101;
        this.f474155c = r102;
        this.f474156d = r103;
        this.f474157e = r104;
        this.f474158f = r105;
        this.f474159g = r106;
        this.f474160h = r107;
        this.f474161i = r110;
    }

    public /* synthetic */ f(String r110, MmRecordingSource r111, List r112, String r113, String r114, String r115, String r116, Map r117, String r118, int r210) {
        String r100 = "";
        if ((r210 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r210 & 2) == 0) goto L9;
        MmRecordingSource r102 = MmRecordingSource.FEISHU;
    L11:
        if ((r210 & 4) == 0) goto L13;
        List r103 = CollectionsKt.emptyList();
    L15:
        if ((r210 & 8) != 0) goto L18;
        r100 = r113;
    L18:
        String r104 = null;
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Map r108 = MapsKt.emptyMap();
    L35:
        if ((r210 & 256) != 0) goto L38;
        r104 = r118;
    L38:
        this(r101, r102, r103, r100, r105, r106, r107, r108, r104);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
