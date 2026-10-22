package com.larus.im.internal.network.link.impl.sami.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u009f\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018¨\u0006:"}, d2 = {"Lcom/larus/im/internal/network/link/impl/sami/model/SessionWakeupParam;", "", "query", "", "kw", "", "sn", "version", "cred", "trace", "", "conf", "threshold", "bg", "info_type", "info_endoffset", "engine_version", "fallback_threshold", a.KEY_DID, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IFFFIIFLjava/lang/String;FLjava/lang/String;)V", "getQuery", "()I", "getKw", "()Ljava/lang/String;", "getSn", "getVersion", "getCred", "getTrace", "()F", "getConf", "getThreshold", "getBg", "getInfo_type", "getInfo_endoffset", "getEngine_version", "getFallback_threshold", "getDid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "hashCode", "toString", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionWakeupParam {

    /* JADX INFO: renamed from: bg, reason: collision with root package name */
    @SerializedName("bg")
    private final int f349450bg;

    @SerializedName("conf")
    private final float conf;

    @SerializedName("cred")
    private final int cred;

    @SerializedName(a.KEY_DID)
    private final String did;

    @SerializedName("engine_version")
    private final String engine_version;

    @SerializedName("fallback_threshold")
    private final float fallback_threshold;

    @SerializedName("info_endoffset")
    private final float info_endoffset;

    @SerializedName("info_type")
    private final int info_type;

    /* JADX INFO: renamed from: kw, reason: collision with root package name */
    @SerializedName("kw")
    private final String f349451kw;

    @SerializedName("query")
    private final int query;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    @SerializedName("sn")
    private final String f349452sn;

    @SerializedName("threshold")
    private final float threshold;

    @SerializedName("trace")
    private final float trace;

    @SerializedName("version")
    private final String version;

    public SessionWakeupParam() {
        this(0, null, null, null, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, null, 0.0f, null, 16383, null);
    }

    public static /* synthetic */ SessionWakeupParam copy$default(SessionWakeupParam r110, int r111, String r112, String r113, String r114, int r210, float r211, float r212, float r213, int r214, int r215, float r216, String r217, float r218, String r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        int r100 = r110.query;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.f349451kw;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.f349452sn;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.version;
    L19:
        if ((r310 & 16) == 0) goto L21;
        int r104 = r110.cred;
    L23:
        if ((r310 & 32) == 0) goto L25;
        float r105 = r110.trace;
    L27:
        if ((r310 & 64) == 0) goto L29;
        float r106 = r110.conf;
    L31:
        if ((r310 & 128) == 0) goto L33;
        float r107 = r110.threshold;
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r115 = r110.f349450bg;
    L39:
        if ((r310 & 512) == 0) goto L41;
        int r116 = r110.info_type;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        float r117 = r110.info_endoffset;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.engine_version;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        float r119 = r110.fallback_threshold;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        String r108 = r110.did;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
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

    public final int component1() {
        return this.query;
    }

    public final int component10() {
        return this.info_type;
    }

    public final float component11() {
        return this.info_endoffset;
    }

    public final String component12() {
        return this.engine_version;
    }

    public final float component13() {
        return this.fallback_threshold;
    }

    public final String component14() {
        return this.did;
    }

    public final String component2() {
        return this.f349451kw;
    }

    public final String component3() {
        return this.f349452sn;
    }

    public final String component4() {
        return this.version;
    }

    public final int component5() {
        return this.cred;
    }

    public final float component6() {
        return this.trace;
    }

    public final float component7() {
        return this.conf;
    }

    public final float component8() {
        return this.threshold;
    }

    public final int component9() {
        return this.f349450bg;
    }

    public final SessionWakeupParam copy(int r110, String r111, String r112, String r210, int r211, float r212, float r213, float r214, int r215, int r216, float r217, String r218, float r219, String r310) {
        return new SessionWakeupParam(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SessionWakeupParam) == true) goto L8;
        return false;
    L8:
        SessionWakeupParam r101 = (SessionWakeupParam) r100;
        if (this.query == r101.query) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f349451kw, r101.f349451kw) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f349452sn, r101.f349452sn) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L21;
        return false;
    L21:
        if (this.cred == r101.cred) goto L24;
        return false;
    L24:
        if (Float.compare(this.trace, r101.trace) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.conf, r101.conf) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.threshold, r101.threshold) == 0) goto L33;
        return false;
    L33:
        if (this.f349450bg == r101.f349450bg) goto L36;
        return false;
    L36:
        if (this.info_type == r101.info_type) goto L39;
        return false;
    L39:
        if (Float.compare(this.info_endoffset, r101.info_endoffset) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.engine_version, r101.engine_version) == true) goto L45;
        return false;
    L45:
        if (Float.compare(this.fallback_threshold, r101.fallback_threshold) == 0) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.did, r101.did) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r100 = this.query * 31;
        String r101 = this.f349451kw;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f349452sn;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.version;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((((((((((((r107 + r109) * 31) + this.cred) * 31) + Float.floatToIntBits(this.trace)) * 31) + Float.floatToIntBits(this.conf)) * 31) + Float.floatToIntBits(this.threshold)) * 31) + this.f349450bg) * 31) + this.info_type) * 31) + Float.floatToIntBits(this.info_endoffset)) * 31;
        String r111 = this.engine_version;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + Float.floatToIntBits(this.fallback_threshold)) * 31;
        String r114 = this.did;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
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

    public String toString() {
        return "SessionWakeupParam(query=" + this.query + ", kw=" + this.f349451kw + ", sn=" + this.f349452sn + ", version=" + this.version + ", cred=" + this.cred + ", trace=" + this.trace + ", conf=" + this.conf + ", threshold=" + this.threshold + ", bg=" + this.f349450bg + ", info_type=" + this.info_type + ", info_endoffset=" + this.info_endoffset + ", engine_version=" + this.engine_version + ", fallback_threshold=" + this.fallback_threshold + ", did=" + this.did + ')';
    }

    public final int getBg() {
        return this.f349450bg;
    }

    public final float getConf() {
        return this.conf;
    }

    public final int getCred() {
        return this.cred;
    }

    public final String getDid() {
        return this.did;
    }

    public final String getEngine_version() {
        return this.engine_version;
    }

    public final float getFallback_threshold() {
        return this.fallback_threshold;
    }

    public final float getInfo_endoffset() {
        return this.info_endoffset;
    }

    public final int getInfo_type() {
        return this.info_type;
    }

    public final String getKw() {
        return this.f349451kw;
    }

    public final int getQuery() {
        return this.query;
    }

    public final String getSn() {
        return this.f349452sn;
    }

    public final float getThreshold() {
        return this.threshold;
    }

    public final float getTrace() {
        return this.trace;
    }

    public final String getVersion() {
        return this.version;
    }

    public SessionWakeupParam(int r100, String r101, String r102, String r103, int r104, float r105, float r106, float r107, int r108, int r110, float r111, String r112, float r113, String r114) {
        this.query = r100;
        this.f349451kw = r101;
        this.f349452sn = r102;
        this.version = r103;
        this.cred = r104;
        this.trace = r105;
        this.conf = r106;
        this.threshold = r107;
        this.f349450bg = r108;
        this.info_type = r110;
        this.info_endoffset = r111;
        this.engine_version = r112;
        this.fallback_threshold = r113;
        this.did = r114;
    }

    public /* synthetic */ SessionWakeupParam(int r110, String r111, String r112, String r210, int r211, float r212, float r213, float r214, int r215, int r216, float r217, String r218, float r219, String r310, int r311, DefaultConstructorMarker r312) {
        int r100 = 0;
        if ((r311 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        String r102 = "";
        if ((r311 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r311 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r311 & 16) == 0) goto L21;
        int r106 = 0;
    L22:
        float r107 = 0.0f;
        if ((r311 & 32) == 0) goto L25;
        float r108 = 0.0f;
    L27:
        if ((r311 & 64) == 0) goto L29;
        float r113 = 0.0f;
    L31:
        if ((r311 & 128) == 0) goto L33;
        float r114 = 0.0f;
    L35:
        if ((r311 & 256) == 0) goto L37;
        int r115 = 0;
    L39:
        if ((r311 & 512) != 0) goto L43;
        r100 = r216;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        float r116 = 0.0f;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        String r117 = "";
    L51:
        if ((r311 & 4096) != 0) goto L55;
        r107 = r219;
    L55:
        if ((r311 & 8192) != 0) goto L58;
        r102 = r310;
    L58:
        this(r101, r103, r104, r105, r106, r108, r113, r114, r115, r100, r116, r117, r107, r102);
        return;
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r113 = r213;
        goto L31
    L25:
        r108 = r212;
        goto L27
    L21:
        r106 = r211;
        goto L22
    L17:
        r105 = r210;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
