package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010#\u001a\u00020\u0003H\u0016J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u008c\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00067"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitleItem;", "Ljava/io/Serializable;", "name", "", "time", "", "sourceMsg", "avatarUrl", "avatarKey", "clusterId", "correctedTime", "deviceId", "speakerType", "", "identifyMethod", "userType", "uid", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getTime", "()J", "getSourceMsg", "getAvatarUrl", "getAvatarKey", "getClusterId", "getCorrectedTime", "getDeviceId", "getSpeakerType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIdentifyMethod", "getUserType", "getUid", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitleItem;", "equals", "", "other", "", "hashCode", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmEndWindowSubtitleItem implements Serializable {
    private final String avatarKey;
    private final String avatarUrl;
    private final String clusterId;
    private final long correctedTime;
    private final String deviceId;
    private final String identifyMethod;
    private final String name;
    private final String sourceMsg;
    private final Integer speakerType;
    private final long time;
    private final String uid;
    private final Integer userType;

    public MmEndWindowSubtitleItem() {
        this(null, 0, null, null, null, null, 0, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ MmEndWindowSubtitleItem copy$default(MmEndWindowSubtitleItem r110, String r111, long r112, String r113, String r210, String r211, String r212, long r213, String r214, Integer r215, String r216, Integer r217, String r218, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r310 & 2) == 0) goto L9;
        long r101 = r110.time;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.sourceMsg;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.avatarUrl;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.avatarKey;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.clusterId;
    L27:
        if ((r310 & 64) == 0) goto L29;
        long r106 = r110.correctedTime;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r114 = r110.deviceId;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Integer r115 = r110.speakerType;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = r110.identifyMethod;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Integer r117 = r110.userType;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r107 = r110.uid;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r114, r115, r116, r117, r107);
    L49:
        r107 = r218;
        goto L51
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.identifyMethod;
    }

    public final Integer component11() {
        return this.userType;
    }

    public final String component12() {
        return this.uid;
    }

    public final long component2() {
        return this.time;
    }

    public final String component3() {
        return this.sourceMsg;
    }

    public final String component4() {
        return this.avatarUrl;
    }

    public final String component5() {
        return this.avatarKey;
    }

    public final String component6() {
        return this.clusterId;
    }

    public final long component7() {
        return this.correctedTime;
    }

    public final String component8() {
        return this.deviceId;
    }

    public final Integer component9() {
        return this.speakerType;
    }

    public final MmEndWindowSubtitleItem copy(String r110, long r111, String r210, String r211, String r212, String r213, long r214, String r215, Integer r216, String r217, Integer r218, String r310) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r210, "sourceMsg");
        Intrinsics.checkNotNullParameter(r211, "avatarUrl");
        Intrinsics.checkNotNullParameter(r212, "avatarKey");
        Intrinsics.checkNotNullParameter(r213, "clusterId");
        Intrinsics.checkNotNullParameter(r217, "identifyMethod");
        Intrinsics.checkNotNullParameter(r310, "uid");
        return new MmEndWindowSubtitleItem(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmEndWindowSubtitleItem) == true) goto L8;
        return false;
    L8:
        MmEndWindowSubtitleItem r101 = (MmEndWindowSubtitleItem) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (this.time == r101.time) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceMsg, r101.sourceMsg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clusterId, r101.clusterId) == true) goto L27;
        return false;
    L27:
        if (this.correctedTime == r101.correctedTime) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.speakerType, r101.speakerType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.identifyMethod, r101.identifyMethod) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.userType, r101.userType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = this.name.hashCode() * 31;
        long r101 = this.time;
        int r102 = (((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.sourceMsg.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.avatarKey.hashCode()) * 31) + this.clusterId.hashCode()) * 31;
        long r103 = this.correctedTime;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.deviceId;
        int r106 = 0;
        if (r105 != null) goto L5;
        int r107 = 0;
    L6:
        int r108 = (r104 + r107) * 31;
        Integer r109 = this.speakerType;
        if (r109 != null) goto L9;
        int r110 = 0;
    L10:
        int r111 = (((r108 + r110) * 31) + this.identifyMethod.hashCode()) * 31;
        Integer r112 = this.userType;
        if (r112 == null) goto L15;
        r106 = r112.hashCode();
    L15:
        return ((r111 + r106) * 31) + this.uid.hashCode();
    L9:
        r110 = r109.hashCode();
        goto L10
    L5:
        r107 = r105.hashCode();
        goto L6
    }

    public String toString() {
        return "SubtitleItem(name='" + this.name + "', time=" + this.time + ", avatarUrl='" + this.avatarUrl + "', avatarKey='" + this.avatarKey + "', clusterId='" + this.clusterId + "', correctedTime=" + this.correctedTime + ", deviceId=" + this.deviceId + ", speakerType=" + this.speakerType + ", identifyMethod='" + this.identifyMethod + "', userType=" + this.userType + ", uid='" + this.uid + "')";
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getClusterId() {
        return this.clusterId;
    }

    public final long getCorrectedTime() {
        return this.correctedTime;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getIdentifyMethod() {
        return this.identifyMethod;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSourceMsg() {
        return this.sourceMsg;
    }

    public final Integer getSpeakerType() {
        return this.speakerType;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getUid() {
        return this.uid;
    }

    public final Integer getUserType() {
        return this.userType;
    }

    public MmEndWindowSubtitleItem(String r100, long r101, String r102, String r103, String r104, String r105, long r106, String r110, Integer r111, String r112, Integer r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "sourceMsg");
        Intrinsics.checkNotNullParameter(r103, "avatarUrl");
        Intrinsics.checkNotNullParameter(r104, "avatarKey");
        Intrinsics.checkNotNullParameter(r105, "clusterId");
        Intrinsics.checkNotNullParameter(r112, "identifyMethod");
        Intrinsics.checkNotNullParameter(r114, "uid");
        this.name = r100;
        this.time = r101;
        this.sourceMsg = r102;
        this.avatarUrl = r103;
        this.avatarKey = r104;
        this.clusterId = r105;
        this.correctedTime = r106;
        this.deviceId = r110;
        this.speakerType = r111;
        this.identifyMethod = r112;
        this.userType = r113;
        this.uid = r114;
    }

    public /* synthetic */ MmEndWindowSubtitleItem(String r110, long r111, String r210, String r211, String r212, String r213, long r214, String r215, Integer r216, String r217, Integer r218, String r310, int r311, DefaultConstructorMarker r312) {
        String r100 = "";
        if ((r311 & 1) == 0) goto L5;
        String r101 = "";
    L6:
        long r102 = 0;
        if ((r311 & 2) == 0) goto L9;
        long r103 = 0;
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r311 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r311 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r311 & 32) == 0) goto L25;
        String r112 = "";
    L27:
        if ((r311 & 64) != 0) goto L30;
        r102 = r214;
    L30:
        Integer r113 = null;
        if ((r311 & 128) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r311 & 256) == 0) goto L37;
        Integer r115 = null;
    L39:
        if ((r311 & 512) == 0) goto L41;
        String r116 = "unknown";
    L43:
        if ((r311 & 1024) != 0) goto L47;
        r113 = r218;
    L47:
        if ((r311 & 2048) != 0) goto L50;
        r100 = r310;
    L50:
        this(r101, r103, r104, r105, r106, r112, r102, r114, r115, r116, r113, r100);
        return;
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L25:
        r112 = r213;
        goto L27
    L21:
        r106 = r212;
        goto L23
    L17:
        r105 = r211;
        goto L19
    L13:
        r104 = r210;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
