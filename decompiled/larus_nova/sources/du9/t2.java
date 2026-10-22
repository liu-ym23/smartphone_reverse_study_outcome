package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J`\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006)"}, d2 = {"Lcom/larus/settings/provider/chat/UploadVideoEntityTransConf;", "", "enable", "", "transVideoWidth", "", "transVideoHeight", "transVideoFps", "transVideoBitrate", "", "transVideoCodec", "", "transVideoType", "<init>", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getEnable", "()Z", "getTransVideoWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTransVideoHeight", "getTransVideoFps", "getTransVideoBitrate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTransVideoCodec", "()Ljava/lang/String;", "getTransVideoType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/settings/provider/chat/UploadVideoEntityTransConf;", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t2 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("trans_video_bitrate")
    private final Long transVideoBitrate;

    @SerializedName("trans_video_codec")
    private final String transVideoCodec;

    @SerializedName("trans_video_fps")
    private final Integer transVideoFps;

    @SerializedName("trans_video_height")
    private final Integer transVideoHeight;

    @SerializedName("trans_video_type")
    private final String transVideoType;

    @SerializedName("trans_video_width")
    private final Integer transVideoWidth;

    public t2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t2) == true) goto L8;
        return false;
    L8:
        t2 r101 = (t2) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.transVideoWidth, r101.transVideoWidth) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transVideoHeight, r101.transVideoHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.transVideoFps, r101.transVideoFps) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.transVideoBitrate, r101.transVideoBitrate) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.transVideoCodec, r101.transVideoCodec) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.transVideoType, r101.transVideoType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Integer r102 = this.transVideoWidth;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Integer r106 = this.transVideoHeight;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Integer r109 = this.transVideoFps;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Long r112 = this.transVideoBitrate;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.transVideoCodec;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.transVideoType;
        if (r118 == null) goto L31;
        r103 = r118.hashCode();
    L31:
        return r117 + r103;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "UploadVideoEntityTransConf(enable=" + this.enable + ", transVideoWidth=" + this.transVideoWidth + ", transVideoHeight=" + this.transVideoHeight + ", transVideoFps=" + this.transVideoFps + ", transVideoBitrate=" + this.transVideoBitrate + ", transVideoCodec=" + this.transVideoCodec + ", transVideoType=" + this.transVideoType + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final Long b() {
        return this.transVideoBitrate;
    }

    public final String c() {
        return this.transVideoCodec;
    }

    public final Integer d() {
        return this.transVideoFps;
    }

    public final Integer e() {
        return this.transVideoHeight;
    }

    public final String f() {
        return this.transVideoType;
    }

    public final Integer g() {
        return this.transVideoWidth;
    }

    public t2(int r100) {
        this.enable = true;
        this.transVideoWidth = 720;
        this.transVideoHeight = 720;
        this.transVideoFps = 30;
        this.transVideoBitrate = 3145728L;
        this.transVideoCodec = "h265";
        this.transVideoType = "mp4";
    }
}
