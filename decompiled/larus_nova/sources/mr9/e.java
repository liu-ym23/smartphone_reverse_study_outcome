package mr9;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.Image;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0014HÆ\u0003J¶\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\rHÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006B"}, d2 = {"Lcom/larus/platform/model/upload/LocalVideoResourceMeta;", "", "fileName", "", LocationMonitorConst.IDENTIFIER, "durationMs", "", "fps", "", "sizeByte", SubInfo.KEY_FORMAT, "codec", "height", "", "width", "bitrate", "colorSpace", "colorModel", "colorRange", "coverImage", "Lcom/larus/im/bean/message/Image;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;)V", "getFileName", "()Ljava/lang/String;", "getIdentifier", "getDurationMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFps", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getSizeByte", "getFormat", "getCodec", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "getBitrate", "getColorSpace", "getColorModel", "getColorRange", "getCoverImage", "()Lcom/larus/im/bean/message/Image;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;)Lcom/larus/platform/model/upload/LocalVideoResourceMeta;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Image f514993a;

    @SerializedName("bitrate")
    private final Integer bitrate;

    @SerializedName("codec")
    private final String codec;

    @SerializedName("color_model")
    private final String colorModel;

    @SerializedName("color_range")
    private final String colorRange;

    @SerializedName("color_space")
    private final String colorSpace;

    @SerializedName("duration_ms")
    private final Long durationMs;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName(SubInfo.KEY_FORMAT)
    private final String format;

    @SerializedName("fps")
    private final Float fps;

    @SerializedName("height")
    private final Integer height;

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private final String identifier;

    @SerializedName("size_byte")
    private final Long sizeByte;

    @SerializedName("width")
    private final Integer width;

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.durationMs, r101.durationMs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fps, r101.fps) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sizeByte, r101.sizeByte) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.format, r101.format) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.codec, r101.codec) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bitrate, r101.bitrate) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.colorSpace, r101.colorSpace) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.colorModel, r101.colorModel) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.colorRange, r101.colorRange) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f514993a, r101.f514993a) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.fileName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.identifier;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.durationMs;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.fps;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.sizeByte;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.format;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.codec;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.height;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.width;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.bitrate;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.colorSpace;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.colorModel;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.colorRange;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Image r140 = this.f514993a;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
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

    public final String toString() {
        return "LocalVideoResourceMeta(fileName=" + this.fileName + ", identifier=" + this.identifier + ", durationMs=" + this.durationMs + ", fps=" + this.fps + ", sizeByte=" + this.sizeByte + ", format=" + this.format + ", codec=" + this.codec + ", height=" + this.height + ", width=" + this.width + ", bitrate=" + this.bitrate + ", colorSpace=" + this.colorSpace + ", colorModel=" + this.colorModel + ", colorRange=" + this.colorRange + ", coverImage=" + this.f514993a + ')';
    }

    public final Integer b() {
        return this.bitrate;
    }

    public final String c() {
        return this.codec;
    }

    public final Long d() {
        return this.durationMs;
    }

    public final String e() {
        return this.fileName;
    }

    public final String f() {
        return this.format;
    }

    public final Float g() {
        return this.fps;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer h() {
        return this.height;
    }

    public final Long i() {
        return this.sizeByte;
    }

    public final Integer j() {
        return this.width;
    }

    public static e a(e r110, Long r210, Float r211, Long r212, String r213, String r214, Integer r215, Integer r216, Integer r217, int r218) {
        Image r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = r110.fileName;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = r110.identifier;
    L11:
        if ((r218 & 4) == 0) goto L13;
        Long r103 = r110.durationMs;
    L15:
        if ((r218 & 8) == 0) goto L17;
        Float r104 = r110.fps;
    L19:
        if ((r218 & 16) == 0) goto L21;
        Long r105 = r110.sizeByte;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r111 = r110.format;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r112 = r110.codec;
    L31:
        if ((r218 & 128) == 0) goto L33;
        Integer r113 = r110.height;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Integer r114 = r110.width;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Integer r115 = r110.bitrate;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r116 = r110.colorSpace;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r117 = r110.colorModel;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        String r118 = r110.colorRange;
    L55:
        if ((r218 & 8192) == 0) goto L58;
        r100 = r110.f514993a;
    L58:
        return new e(r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r116, r117, r118, r100);
    L53:
        r118 = null;
        goto L55
    L49:
        r117 = null;
        goto L51
    L45:
        r116 = null;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r112 = r214;
        goto L31
    L25:
        r111 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ e(String r110, String r210, Long r211, Float r212, Long r213, String r214, String r215, Integer r216, Integer r217, Integer r218, String r219, Image r310, int r311) {
        if ((r311 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r311 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        Float r103 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r311 & 64) == 0) goto L29;
        String r111 = null;
    L31:
        if ((r311 & 128) == 0) goto L33;
        Integer r112 = null;
    L35:
        if ((r311 & 256) == 0) goto L37;
        Integer r113 = null;
    L39:
        if ((r311 & 512) == 0) goto L41;
        Integer r114 = null;
    L43:
        if ((r311 & 4096) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r311 & 8192) == 0) goto L49;
        Image r116 = null;
    L50:
        this(r100, r101, r102, r103, r104, r105, r111, r112, r113, r114, null, null, r115, r116);
        return;
    L49:
        r116 = r310;
        goto L50
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

    public e(String r100, String r101, Long r102, Float r103, Long r104, String r105, String r106, Integer r107, Integer r108, Integer r110, String r111, String r112, String r113, Image r114) {
        this.fileName = r100;
        this.identifier = r101;
        this.durationMs = r102;
        this.fps = r103;
        this.sizeByte = r104;
        this.format = r105;
        this.codec = r106;
        this.height = r107;
        this.width = r108;
        this.bitrate = r110;
        this.colorSpace = r111;
        this.colorModel = r112;
        this.colorRange = r113;
        this.f514993a = r114;
    }
}
