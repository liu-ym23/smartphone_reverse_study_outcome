package com.larus.dora.impl.file;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\f2\b\b\u0002\u00103\u001a\u00020\bJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020KHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001b¨\u0006M"}, d2 = {"Lcom/larus/dora/impl/file/DoraFileFetchTask;", "", "id", "", "sn", "remotePath", "localPath", "downloadedBytes", "", "status", "Lcom/larus/dora/impl/file/DoraFileTaskStatus;", "originTrigger", "Lcom/larus/dora/impl/file/DoraTaskTrigger;", "lastTrigger", "triggerHistory", "fileType", "Lcom/larus/dora/impl/file/DoraFileType;", "fileName", "fileMd5", "fileCreateTimeMs", "fileTotalSize", "firmwareVersion", "transportType", "fetchFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/dora/impl/file/DoraFileTaskStatus;Lcom/larus/dora/impl/file/DoraTaskTrigger;Lcom/larus/dora/impl/file/DoraTaskTrigger;Ljava/lang/String;Lcom/larus/dora/impl/file/DoraFileType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSn", "getRemotePath", "getLocalPath", "getDownloadedBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "()Lcom/larus/dora/impl/file/DoraFileTaskStatus;", "getOriginTrigger", "()Lcom/larus/dora/impl/file/DoraTaskTrigger;", "getLastTrigger", "getTriggerHistory", "getFileType", "()Lcom/larus/dora/impl/file/DoraFileType;", "getFileName", "getFileMd5", "getFileCreateTimeMs", "getFileTotalSize", "getFirmwareVersion", "getTransportType", "getFetchFrom", "appendTrigger", "trigger", "timestampMillis", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/dora/impl/file/DoraFileTaskStatus;Lcom/larus/dora/impl/file/DoraTaskTrigger;Lcom/larus/dora/impl/file/DoraTaskTrigger;Ljava/lang/String;Lcom/larus/dora/impl/file/DoraFileType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/dora/impl/file/DoraFileFetchTask;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraFileFetchTask {

    @SerializedName("downloaded_bytes")
    private final Long downloadedBytes;

    @SerializedName("fetch_from")
    private final String fetchFrom;

    @SerializedName("file_create_time_ms")
    private final Long fileCreateTimeMs;

    @SerializedName("file_md5")
    private final String fileMd5;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("file_total_size")
    private final Long fileTotalSize;

    @SerializedName("file_type")
    private final DoraFileType fileType;

    @SerializedName("firmware_version")
    private final String firmwareVersion;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f335699id;

    @SerializedName("last_trigger")
    private final DoraTaskTrigger lastTrigger;

    @SerializedName("local_path")
    private final String localPath;

    @SerializedName("origin_trigger")
    private final DoraTaskTrigger originTrigger;

    @SerializedName("remote_path")
    private final String remotePath;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    @SerializedName("sn")
    private final String f335700sn;

    @SerializedName("status")
    private final DoraFileTaskStatus status;

    @SerializedName("transport_type")
    private final String transportType;

    @SerializedName("trigger_history")
    private final String triggerHistory;

    public DoraFileFetchTask() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ DoraFileFetchTask copy$default(DoraFileFetchTask r110, String r111, String r112, String r210, String r211, Long r212, DoraFileTaskStatus r213, DoraTaskTrigger r214, DoraTaskTrigger r215, String r216, DoraFileType r217, String r218, String r219, Long r310, Long r311, String r312, String r313, String r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.f335699id;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.f335700sn;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = r110.remotePath;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.localPath;
    L19:
        if ((r315 & 16) == 0) goto L21;
        Long r104 = r110.downloadedBytes;
    L23:
        if ((r315 & 32) == 0) goto L25;
        DoraFileTaskStatus r105 = r110.status;
    L27:
        if ((r315 & 64) == 0) goto L29;
        DoraTaskTrigger r106 = r110.originTrigger;
    L31:
        if ((r315 & 128) == 0) goto L33;
        DoraTaskTrigger r107 = r110.lastTrigger;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r113 = r110.triggerHistory;
    L39:
        if ((r315 & 512) == 0) goto L41;
        DoraFileType r114 = r110.fileType;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r110.fileName;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.fileMd5;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        Long r117 = r110.fileCreateTimeMs;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        Long r118 = r110.fileTotalSize;
    L58:
        Long r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        String r119 = r110.firmwareVersion;
    L62:
        String r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        String r120 = r110.transportType;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        String r108 = r110.fetchFrom;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f335699id;
    }

    public final DoraFileType component10() {
        return this.fileType;
    }

    public final String component11() {
        return this.fileName;
    }

    public final String component12() {
        return this.fileMd5;
    }

    public final Long component13() {
        return this.fileCreateTimeMs;
    }

    public final Long component14() {
        return this.fileTotalSize;
    }

    public final String component15() {
        return this.firmwareVersion;
    }

    public final String component16() {
        return this.transportType;
    }

    public final String component17() {
        return this.fetchFrom;
    }

    public final String component2() {
        return this.f335700sn;
    }

    public final String component3() {
        return this.remotePath;
    }

    public final String component4() {
        return this.localPath;
    }

    public final Long component5() {
        return this.downloadedBytes;
    }

    public final DoraFileTaskStatus component6() {
        return this.status;
    }

    public final DoraTaskTrigger component7() {
        return this.originTrigger;
    }

    public final DoraTaskTrigger component8() {
        return this.lastTrigger;
    }

    public final String component9() {
        return this.triggerHistory;
    }

    public final DoraFileFetchTask copy(String r210, String r211, String r212, String r213, Long r214, DoraFileTaskStatus r215, DoraTaskTrigger r216, DoraTaskTrigger r217, String r218, DoraFileType r219, String r310, String r311, Long r312, Long r313, String r314, String r315, String r316) {
        return new DoraFileFetchTask(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraFileFetchTask) == true) goto L8;
        return false;
    L8:
        DoraFileFetchTask r101 = (DoraFileFetchTask) r100;
        if (Intrinsics.areEqual(this.f335699id, r101.f335699id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f335700sn, r101.f335700sn) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.remotePath, r101.remotePath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.localPath, r101.localPath) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.downloadedBytes, r101.downloadedBytes) == true) goto L24;
        return false;
    L24:
        if (this.status == r101.status) goto L27;
        return false;
    L27:
        if (this.originTrigger == r101.originTrigger) goto L30;
        return false;
    L30:
        if (this.lastTrigger == r101.lastTrigger) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.triggerHistory, r101.triggerHistory) == true) goto L36;
        return false;
    L36:
        if (this.fileType == r101.fileType) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.fileMd5, r101.fileMd5) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.fileCreateTimeMs, r101.fileCreateTimeMs) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.fileTotalSize, r101.fileTotalSize) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.firmwareVersion, r101.firmwareVersion) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.transportType, r101.transportType) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.fetchFrom, r101.fetchFrom) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        String r100 = this.f335699id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f335700sn;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.remotePath;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.localPath;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.downloadedBytes;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        DoraFileTaskStatus r116 = this.status;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        DoraTaskTrigger r119 = this.originTrigger;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        DoraTaskTrigger r122 = this.lastTrigger;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.triggerHistory;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        DoraFileType r128 = this.fileType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.fileName;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.fileMd5;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Long r137 = this.fileCreateTimeMs;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Long r140 = this.fileTotalSize;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.firmwareVersion;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.transportType;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.fetchFrom;
        if (r149 == null) goto L71;
        r101 = r149.hashCode();
    L71:
        return r148 + r101;
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
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

    public String toString() {
        return "DoraFileFetchTask(id=" + this.f335699id + ", sn=" + this.f335700sn + ", remotePath=" + this.remotePath + ", localPath=" + this.localPath + ", downloadedBytes=" + this.downloadedBytes + ", status=" + this.status + ", originTrigger=" + this.originTrigger + ", lastTrigger=" + this.lastTrigger + ", triggerHistory=" + this.triggerHistory + ", fileType=" + this.fileType + ", fileName=" + this.fileName + ", fileMd5=" + this.fileMd5 + ", fileCreateTimeMs=" + this.fileCreateTimeMs + ", fileTotalSize=" + this.fileTotalSize + ", firmwareVersion=" + this.firmwareVersion + ", transportType=" + this.transportType + ", fetchFrom=" + this.fetchFrom + ')';
    }

    public final Long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public final String getFetchFrom() {
        return this.fetchFrom;
    }

    public final Long getFileCreateTimeMs() {
        return this.fileCreateTimeMs;
    }

    public final String getFileMd5() {
        return this.fileMd5;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileTotalSize() {
        return this.fileTotalSize;
    }

    public final DoraFileType getFileType() {
        return this.fileType;
    }

    public final String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public final String getId() {
        return this.f335699id;
    }

    public final DoraTaskTrigger getLastTrigger() {
        return this.lastTrigger;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final DoraTaskTrigger getOriginTrigger() {
        return this.originTrigger;
    }

    public final String getRemotePath() {
        return this.remotePath;
    }

    public final String getSn() {
        return this.f335700sn;
    }

    public final DoraFileTaskStatus getStatus() {
        return this.status;
    }

    public final String getTransportType() {
        return this.transportType;
    }

    public final String getTriggerHistory() {
        return this.triggerHistory;
    }

    public final DoraFileFetchTask appendTrigger(DoraTaskTrigger r210, long r211) {
        Intrinsics.checkNotNullParameter(r210, "trigger");
        String r100 = "ts=" + r211 + ':' + r210.name();
        String r101 = this.triggerHistory;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L13;
        r100 = this.triggerHistory + ',' + r100;
    L13:
        return copy$default(this, null, null, null, null, null, null, null, r210, r100, null, null, null, null, null, null, null, null, 130687, null);
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static /* synthetic */ DoraFileFetchTask appendTrigger$default(DoraFileFetchTask r100, DoraTaskTrigger r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = System.currentTimeMillis();
    L6:
        return r100.appendTrigger(r101, r102);
    }

    public DoraFileFetchTask(String r100, String r101, String r102, String r103, Long r104, DoraFileTaskStatus r105, DoraTaskTrigger r106, DoraTaskTrigger r110, String r111, DoraFileType r112, String r113, String r114, Long r115, Long r116, String r117, String r118, String r119) {
        this.f335699id = r100;
        this.f335700sn = r101;
        this.remotePath = r102;
        this.localPath = r103;
        this.downloadedBytes = r104;
        this.status = r105;
        this.originTrigger = r106;
        this.lastTrigger = r110;
        this.triggerHistory = r111;
        this.fileType = r112;
        this.fileName = r113;
        this.fileMd5 = r114;
        this.fileCreateTimeMs = r115;
        this.fileTotalSize = r116;
        this.firmwareVersion = r117;
        this.transportType = r118;
        this.fetchFrom = r119;
    }

    public /* synthetic */ DoraFileFetchTask(String r110, String r210, String r211, String r212, Long r213, DoraFileTaskStatus r214, DoraTaskTrigger r215, DoraTaskTrigger r216, String r217, DoraFileType r218, String r219, String r310, Long r311, Long r312, String r313, String r314, String r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r316 & 16) == 0) goto L21;
        Long r104 = 0L;
    L23:
        if ((r316 & 32) == 0) goto L25;
        DoraFileTaskStatus r105 = DoraFileTaskStatus.PENDING;
    L27:
        if ((r316 & 64) == 0) goto L29;
        DoraTaskTrigger r111 = DoraTaskTrigger.UNKNOWN;
    L31:
        if ((r316 & 128) == 0) goto L33;
        DoraTaskTrigger r112 = r111;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r113 = "";
    L39:
        if ((r316 & 512) == 0) goto L41;
        DoraFileType r114 = DoraFileType.UNKNOWN;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = "";
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r116 = "";
    L51:
        if ((r316 & 4096) == 0) goto L53;
        Long r106 = 0L;
    L54:
        Long r117 = r106;
        if ((r316 & 8192) == 0) goto L57;
        Long r107 = 0L;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((32768 & r316) == 0) goto L65;
        String r109 = "";
    L67:
        if ((r316 & 65536) == 0) goto L69;
        String r118 = "";
    L70:
        this(r100, r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r116, r117, r107, r108, r109, r118);
        return;
    L69:
        r118 = r315;
        goto L70
    L65:
        r109 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r107 = r312;
        goto L59
    L53:
        r106 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r219;
        goto L47
    L41:
        r114 = r218;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r111 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
