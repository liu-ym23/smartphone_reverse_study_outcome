package com.mammon.speechaudiosdk.kmp.param.va;

import com.heytap.mcssdk.constant.b;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTokenType;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTransportType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J³\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\rHÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019¨\u0006?"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionContextParam;", "", "url", "", "header", "transportType", "Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTransportType;", "protoVersion", b.f276376z, "tokenType", "Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;", "token", "connectTimeout", "", "enableTransferRetry", "", "retryTimeArray", "", "businessInfo", "connectPoolBusiness", DBDefinition.TASK_ID, "dumpDir", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTransportType;Ljava/lang/String;Ljava/lang/String;Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;Ljava/lang/String;IZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getHeader", "getTransportType", "()Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTransportType;", "getProtoVersion", "getAppKey", "getTokenType", "()Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;", "getToken", "getConnectTimeout", "()I", "getEnableTransferRetry", "()Z", "getRetryTimeArray", "()Ljava/util/List;", "getBusinessInfo", "getConnectPoolBusiness", "getTaskId", "getDumpDir", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionContextParam {
    private final String appKey;
    private final String businessInfo;
    private final String connectPoolBusiness;
    private final int connectTimeout;
    private final String dumpDir;
    private final boolean enableTransferRetry;
    private final String header;
    private final String protoVersion;
    private final List<Integer> retryTimeArray;
    private final String taskId;
    private final String token;
    private final SpeechAudioTokenType tokenType;
    private final SpeechAudioTransportType transportType;
    private final String url;

    public SpeechVoiceAssistantSessionContextParam() {
        this(null, null, null, null, null, null, null, 0, false, null, null, null, null, null, 16383, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpeechVoiceAssistantSessionContextParam copy$default(SpeechVoiceAssistantSessionContextParam r110, String r111, String r112, SpeechAudioTransportType r113, String r114, String r210, SpeechAudioTokenType r211, String r212, int r213, boolean r214, List r215, String r216, String r217, String r218, String r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.url;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.header;
    L11:
        if ((r310 & 4) == 0) goto L13;
        SpeechAudioTransportType r102 = r110.transportType;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.protoVersion;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.appKey;
    L23:
        if ((r310 & 32) == 0) goto L25;
        SpeechAudioTokenType r105 = r110.tokenType;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.token;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r107 = r110.connectTimeout;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r115 = r110.enableTransferRetry;
    L39:
        if ((r310 & 512) == 0) goto L41;
        List r116 = r110.retryTimeArray;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.businessInfo;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.connectPoolBusiness;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r119 = r110.taskId;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        String r108 = r110.dumpDir;
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

    public final String component1() {
        return this.url;
    }

    public final List<Integer> component10() {
        return this.retryTimeArray;
    }

    public final String component11() {
        return this.businessInfo;
    }

    public final String component12() {
        return this.connectPoolBusiness;
    }

    public final String component13() {
        return this.taskId;
    }

    public final String component14() {
        return this.dumpDir;
    }

    public final String component2() {
        return this.header;
    }

    public final SpeechAudioTransportType component3() {
        return this.transportType;
    }

    public final String component4() {
        return this.protoVersion;
    }

    public final String component5() {
        return this.appKey;
    }

    public final SpeechAudioTokenType component6() {
        return this.tokenType;
    }

    public final String component7() {
        return this.token;
    }

    public final int component8() {
        return this.connectTimeout;
    }

    public final boolean component9() {
        return this.enableTransferRetry;
    }

    public final SpeechVoiceAssistantSessionContextParam copy(String r110, String r111, SpeechAudioTransportType r112, String r210, String r211, SpeechAudioTokenType r212, String r213, int r214, boolean r215, List<Integer> r216, String r217, String r218, String r219, String r310) {
        return new SpeechVoiceAssistantSessionContextParam(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechVoiceAssistantSessionContextParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionContextParam r101 = (SpeechVoiceAssistantSessionContextParam) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L15;
        return false;
    L15:
        if (this.transportType == r101.transportType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.protoVersion, r101.protoVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L24;
        return false;
    L24:
        if (this.tokenType == r101.tokenType) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L30;
        return false;
    L30:
        if (this.connectTimeout == r101.connectTimeout) goto L33;
        return false;
    L33:
        if (this.enableTransferRetry == r101.enableTransferRetry) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.retryTimeArray, r101.retryTimeArray) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.businessInfo, r101.businessInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.connectPoolBusiness, r101.connectPoolBusiness) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.dumpDir, r101.dumpDir) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.header;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        SpeechAudioTransportType r107 = this.transportType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.protoVersion;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.appKey;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        SpeechAudioTokenType r116 = this.tokenType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.token;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((r118 + r120) * 31) + this.connectTimeout) * 31;
        if (this.enableTransferRetry == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (r121 + r122) * 31;
        List<Integer> r124 = this.retryTimeArray;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.businessInfo;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        String r130 = this.connectPoolBusiness;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.taskId;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        String r136 = this.dumpDir;
        if (r136 == null) goto L55;
        r101 = r136.hashCode();
    L55:
        return r135 + r101;
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = 1237;
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
        return "SpeechVoiceAssistantSessionContextParam(url=" + this.url + ", header=" + this.header + ", transportType=" + this.transportType + ", protoVersion=" + this.protoVersion + ", appKey=" + this.appKey + ", tokenType=" + this.tokenType + ", token=" + this.token + ", connectTimeout=" + this.connectTimeout + ", enableTransferRetry=" + this.enableTransferRetry + ", retryTimeArray=" + this.retryTimeArray + ", businessInfo=" + this.businessInfo + ", connectPoolBusiness=" + this.connectPoolBusiness + ", taskId=" + this.taskId + ", dumpDir=" + this.dumpDir + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getBusinessInfo() {
        return this.businessInfo;
    }

    public final String getConnectPoolBusiness() {
        return this.connectPoolBusiness;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final String getDumpDir() {
        return this.dumpDir;
    }

    public final boolean getEnableTransferRetry() {
        return this.enableTransferRetry;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getProtoVersion() {
        return this.protoVersion;
    }

    public final List<Integer> getRetryTimeArray() {
        return this.retryTimeArray;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getToken() {
        return this.token;
    }

    public final SpeechAudioTokenType getTokenType() {
        return this.tokenType;
    }

    public final SpeechAudioTransportType getTransportType() {
        return this.transportType;
    }

    public final String getUrl() {
        return this.url;
    }

    public SpeechVoiceAssistantSessionContextParam(String r100, String r101, SpeechAudioTransportType r102, String r103, String r104, SpeechAudioTokenType r105, String r106, int r107, boolean r108, List<Integer> r110, String r111, String r112, String r113, String r114) {
        this.url = r100;
        this.header = r101;
        this.transportType = r102;
        this.protoVersion = r103;
        this.appKey = r104;
        this.tokenType = r105;
        this.token = r106;
        this.connectTimeout = r107;
        this.enableTransferRetry = r108;
        this.retryTimeArray = r110;
        this.businessInfo = r111;
        this.connectPoolBusiness = r112;
        this.taskId = r113;
        this.dumpDir = r114;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionContextParam(String r110, String r111, SpeechAudioTransportType r112, String r113, String r210, SpeechAudioTokenType r211, String r212, int r213, boolean r214, List r215, String r216, String r217, String r218, String r219, int r310, DefaultConstructorMarker r311) {
        String r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        SpeechAudioTransportType r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        SpeechAudioTokenType r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L30:
        boolean r114 = false;
        if ((r310 & 128) == 0) goto L33;
        int r108 = 0;
    L35:
        if ((r310 & 256) != 0) goto L39;
        r114 = r214;
    L39:
        if ((r310 & 512) == 0) goto L41;
        List r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L30
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
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
