package r14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b2\u00103R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R$\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0007\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00065"}, d2 = {"Lr14/l;", "", "", "bitRate", "I", "", "gearName", "Ljava/lang/String;", "qualityType", "Lt14/a;", "playAddr", "Lt14/a;", "c", "()Lt14/a;", "setPlayAddr", "(Lt14/a;)V", "isH265", "f", "()I", "setH265", "(I)V", "videoExtra", "getVideoExtra", "()Ljava/lang/String;", "setVideoExtra", "(Ljava/lang/String;)V", "playAddr265", "getPlayAddr265", "setPlayAddr265", "isBytevc1", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setBytevc1", "(Ljava/lang/Integer;)V", "playAddrBytevc1", "getPlayAddrBytevc1", "setPlayAddrBytevc1", "hdrType", "getHdrType", "setHdrType", "hdrBit", "getHdrBit", "setHdrBit", "", "fps", "Ljava/lang/Long;", "getFps", "()Ljava/lang/Long;", "setFps", "(Ljava/lang/Long;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class l {

    @SerializedName("bit_rate")
    private int bitRate;

    @SerializedName("FPS")
    private Long fps;

    @SerializedName("gear_name")
    private String gearName;

    @SerializedName("HDR_bit")
    private String hdrBit;

    @SerializedName("HDR_type")
    private String hdrType;

    @SerializedName("is_bytevc1")
    private Integer isBytevc1;

    @SerializedName("is_h265")
    private int isH265;

    @SerializedName("play_addr")
    private t14.a playAddr;

    @SerializedName("play_addr_265")
    private t14.a playAddr265;

    @SerializedName("play_addr_bytevc1")
    private t14.a playAddrBytevc1;

    @SerializedName("quality_type")
    private int qualityType;

    @SerializedName("video_extra")
    private String videoExtra;

    public static final class a {
    }

    static {
    }

    public final String e() {
        t14.a r100 = this.playAddr;
        String r101 = null;
        if (r100 == null) goto L13;
        String r102 = r100.f();
        if (r102 == null) goto L13;
        if (r102.length() != 0) goto L9;
        boolean r103 = true;
    L11:
        if ((!r103) == false) goto L13;
        r101 = r102;
        goto L13
    L9:
        r103 = false;
    L13:
        if (r101 != null) goto L16;
        return "";
    L16:
        return r101;
    }

    public final List<String> g() {
        t14.a r100 = this.playAddr;
        if (r100 == null) goto L7;
        List<String> r101 = r100.g();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    public final String toString() {
        return "BitRate{bitRate=" + this.bitRate + ", gearName='" + this.gearName + "', qualityType=" + this.qualityType + ", isH265=" + this.isH265 + '}';
    }

    public l() {
        this.gearName = "";
    }

    public final int a() {
        return this.bitRate;
    }

    public final String b() {
        return this.gearName;
    }

    public final t14.a c() {
        return this.playAddr;
    }

    public final int d() {
        return this.qualityType;
    }

    public final int f() {
        return this.isH265;
    }
}
