package com.obric.assistant.feedback.upload.bean;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
public final class ReportUploadTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f389282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f389283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Status f389284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f389285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f389286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f389287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Date f389288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f389289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<Boolean, Unit> f389290i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/feedback/upload/bean/ReportUploadTask$Status;", "", "description", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "SUCCESS", "BASIC_SUCCESS", "FAILED", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status BASIC_SUCCESS = null;
        public static final Status FAILED = null;
        public static final Status SUCCESS = null;
        public static final Status UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f389291a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f389292b = null;
        private final String description;

        public static EnumEntries<Status> getEntries() {
            return f389292b;
        }

        static {
            Status r100 = new Status("SUCCESS", 0, "成功");
            SUCCESS = r100;
            Status r101 = new Status("BASIC_SUCCESS", 1, "基本成功");
            BASIC_SUCCESS = r101;
            Status r102 = new Status("FAILED", 2, "失败");
            FAILED = r102;
            Status r103 = new Status("UNKNOWN", 3, PlayerResolution.NAME.UNKNOWN);
            UNKNOWN = r103;
            Status[] r104 = {r100, r101, r102, r103};
            f389291a = r104;
            f389292b = EnumEntriesKt.enumEntries(r104);
        }

        public static Status[] values() {
            return (Status[]) f389291a.clone();
        }

        public final String getDescription() {
            return this.description;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public Status(String r100, int r101, String r102) {
            super(r100, r101);
            this.description = r102;
        }
    }

    public ReportUploadTask() {
        this(null, false, null, false, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReportUploadTask) == true) goto L8;
        return false;
    L8:
        ReportUploadTask r101 = (ReportUploadTask) r100;
        if (Intrinsics.areEqual(this.f389282a, r101.f389282a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f389283b, r101.f389283b) == true) goto L15;
        return false;
    L15:
        if (this.f389284c == r101.f389284c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f389285d, r101.f389285d) == true) goto L21;
        return false;
    L21:
        if (this.f389286e == r101.f389286e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f389287f, r101.f389287f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f389288g, r101.f389288g) == true) goto L30;
        return false;
    L30:
        if (this.f389289h == r101.f389289h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f389290i, r101.f389290i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f389282a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f389283b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Status r107 = this.f389284c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f389285d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.f389286e == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f389287f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((r115 + r117) * 31) + this.f389288g.hashCode()) * 31;
        if (this.f389289h == true) goto L30;
        r113 = 1237;
    L30:
        int r119 = (r118 + r113) * 31;
        Function1<Boolean, Unit> r120 = this.f389290i;
        if (r120 == null) goto L35;
        r101 = r120.hashCode();
    L35:
        return r119 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReportUploadTask(sessionId=" + this.f389282a + ", taskQuery=" + this.f389283b + ", status=" + this.f389284c + ", message=" + this.f389285d + ", haveExtraData=" + this.f389286e + ", extraDataPath=" + this.f389287f + ", createTime=" + this.f389288g + ", needLogcat=" + this.f389289h + ", onReportUploadDone=" + this.f389290i + ')';
    }

    public ReportUploadTask(String r100, boolean r101, List r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r112 & 8) == 0) goto L14;
        r100 = "";
    L14:
        if ((r112 & 16) == 0) goto L17;
        r101 = true;
    L17:
        if ((r112 & 32) == 0) goto L20;
        r110 = null;
    L20:
        if ((r112 & 64) == 0) goto L22;
        Date r104 = new Date(System.currentTimeMillis());
    L24:
        if ((r112 & 128) == 0) goto L26;
        r111 = true;
    L26:
        Intrinsics.checkNotNullParameter(r104, "createTime");
        this.f389282a = r102;
        this.f389283b = r103;
        this.f389284c = null;
        this.f389285d = r100;
        this.f389286e = r101;
        this.f389287f = r110;
        this.f389288g = r104;
        this.f389289h = r111;
        this.f389290i = null;
        return;
    L22:
        r104 = null;
        goto L24
    L9:
        r103 = null;
        goto L11
    L5:
        r102 = null;
        goto L7
    }
}
