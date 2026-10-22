package uq6;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.bdpay.counter.outer.CJCallbackOuterManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\"\u0010-\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R\"\u00100\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0012\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016R\"\u00103\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016R$\u00106\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R$\u0010?\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u00107\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R$\u0010B\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u00107\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R$\u0010E\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u00107\u001a\u0004\bF\u00109\"\u0004\bG\u0010;R$\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\b¨\u0006K"}, d2 = {"Luq6/k;", "", "", CJCallbackOuterManager.KEY_RESPONSE_CODE, "Ljava/lang/Integer;", "h", "()Ljava/lang/Integer;", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "(Ljava/lang/Integer;)V", "", "responseMessage", "Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "", "dnsTime", "J", "c", "()J", "u", "(J)V", "connectTime", "getConnectTime", "s", "sslTime", "m", FaceService.girlLabel, RemoteMessageConst.SEND_TIME, ce.f26396k, "C", "receiveTime", "f", "x", "", "isSocketReused", "Z", "q", "()Z", ExifInterface.LONGITUDE_EAST, "(Z)V", "ttfbMs", "p", FaceService.neutralLabel, "totalTime", "o", "G", RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, "l", "D", RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, ce.f26391f, "y", "rttCost", "Ljava/lang/Long;", ce.f26395j, "()Ljava/lang/Long;", "B", "(Ljava/lang/Long;)V", "poxyCost", "e", "w", "tcpCost", OfficeSDKRequestTag.KEY_NEW_USER, "setTcpCost", "headerRecvCost", "d", BaseSwitches.V, "bodyRecvCost", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "r", "connectionInfo", "b", "t", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("page_net_body_recv_cost")
    private Long bodyRecvCost;

    @SerializedName("page_net_connect_cost")
    private long connectTime;

    @SerializedName("page_net_connection_info")
    private Integer connectionInfo;

    @SerializedName("page_net_dns_cost")
    private long dnsTime;

    @SerializedName("page_net_header_recv_cost")
    private Long headerRecvCost;

    @SerializedName("page_net_socket_reused")
    private boolean isSocketReused;

    @SerializedName("page_net_proxy_cost")
    private Long poxyCost;

    @SerializedName("page_net_receive_cost")
    private long receiveTime;

    @SerializedName("page_net_receive_byte_count")
    private long receivedByteCount;

    @SerializedName("page_net_resp_code")
    private Integer responseCode;

    @SerializedName("page_net_resp_message")
    private String responseMessage;

    @SerializedName("page_net_rtt_cost")
    private Long rttCost;

    @SerializedName("page_net_send_cost")
    private long sendTime;

    @SerializedName("page_net_send_byte_count")
    private long sentByteCount;

    @SerializedName("page_net_ssl_cost")
    private long sslTime;

    @SerializedName("page_net_tcp_cost")
    private Long tcpCost;

    @SerializedName("page_net_duration_cost")
    private long totalTime;

    @SerializedName("page_net_ttfb_cost")
    private long ttfbMs;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.responseCode, r101.responseCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.responseMessage, r101.responseMessage) == true) goto L15;
        return false;
    L15:
        if (this.dnsTime == r101.dnsTime) goto L18;
        return false;
    L18:
        if (this.connectTime == r101.connectTime) goto L21;
        return false;
    L21:
        if (this.sslTime == r101.sslTime) goto L24;
        return false;
    L24:
        if (this.sendTime == r101.sendTime) goto L27;
        return false;
    L27:
        if (this.receiveTime == r101.receiveTime) goto L30;
        return false;
    L30:
        if (this.isSocketReused == r101.isSocketReused) goto L33;
        return false;
    L33:
        if (this.ttfbMs == r101.ttfbMs) goto L36;
        return false;
    L36:
        if (this.totalTime == r101.totalTime) goto L39;
        return false;
    L39:
        if (this.sentByteCount == r101.sentByteCount) goto L42;
        return false;
    L42:
        if (this.receivedByteCount == r101.receivedByteCount) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.rttCost, r101.rttCost) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.poxyCost, r101.poxyCost) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.tcpCost, r101.tcpCost) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.headerRecvCost, r101.headerRecvCost) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.bodyRecvCost, r101.bodyRecvCost) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.connectionInfo, r101.connectionInfo) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.responseCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.responseMessage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.dnsTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.connectTime;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.sslTime;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.sendTime;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.receiveTime;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        if (this.isSocketReused == false) goto L13;
        int r117 = 1231;
    L14:
        int r118 = (r116 + r117) * 31;
        long r119 = this.ttfbMs;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.totalTime;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.sentByteCount;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        long r125 = this.receivedByteCount;
        int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
        Long r127 = this.rttCost;
        if (r127 != null) goto L17;
        int r128 = 0;
    L18:
        int r129 = (r126 + r128) * 31;
        Long r130 = this.poxyCost;
        if (r130 != null) goto L21;
        int r131 = 0;
    L22:
        int r132 = (r129 + r131) * 31;
        Long r133 = this.tcpCost;
        if (r133 != null) goto L25;
        int r134 = 0;
    L26:
        int r135 = (r132 + r134) * 31;
        Long r136 = this.headerRecvCost;
        if (r136 != null) goto L29;
        int r137 = 0;
    L30:
        int r138 = (r135 + r137) * 31;
        Long r139 = this.bodyRecvCost;
        if (r139 != null) goto L33;
        int r140 = 0;
    L34:
        int r141 = (r138 + r140) * 31;
        Integer r142 = this.connectionInfo;
        if (r142 == null) goto L39;
        r101 = r142.hashCode();
    L39:
        return r141 + r101;
    L33:
        r140 = r139.hashCode();
        goto L34
    L29:
        r137 = r136.hashCode();
        goto L30
    L25:
        r134 = r133.hashCode();
        goto L26
    L21:
        r131 = r130.hashCode();
        goto L22
    L17:
        r128 = r127.hashCode();
        goto L18
    L13:
        r117 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HttpRequestInfo(responseCode=" + this.responseCode + ", responseMessage=" + this.responseMessage + ", dnsTime=" + this.dnsTime + ", connectTime=" + this.connectTime + ", sslTime=" + this.sslTime + ", sendTime=" + this.sendTime + ", receiveTime=" + this.receiveTime + ", isSocketReused=" + this.isSocketReused + ", ttfbMs=" + this.ttfbMs + ", totalTime=" + this.totalTime + ", sentByteCount=" + this.sentByteCount + ", receivedByteCount=" + this.receivedByteCount + ", rttCost=" + this.rttCost + ", poxyCost=" + this.poxyCost + ", tcpCost=" + this.tcpCost + ", headerRecvCost=" + this.headerRecvCost + ", bodyRecvCost=" + this.bodyRecvCost + ", connectionInfo=" + this.connectionInfo + ')';
    }

    public final Long a() {
        return this.bodyRecvCost;
    }

    public final Integer b() {
        return this.connectionInfo;
    }

    public final long c() {
        return this.dnsTime;
    }

    public final Long d() {
        return this.headerRecvCost;
    }

    public final Long e() {
        return this.poxyCost;
    }

    public final long f() {
        return this.receiveTime;
    }

    public final long g() {
        return this.receivedByteCount;
    }

    public final Integer h() {
        return this.responseCode;
    }

    public final String i() {
        return this.responseMessage;
    }

    public final Long j() {
        return this.rttCost;
    }

    public final long k() {
        return this.sendTime;
    }

    public final long l() {
        return this.sentByteCount;
    }

    public final long m() {
        return this.sslTime;
    }

    public final Long n() {
        return this.tcpCost;
    }

    public final long o() {
        return this.totalTime;
    }

    public final long p() {
        return this.ttfbMs;
    }

    public final boolean q() {
        return this.isSocketReused;
    }

    public k(int r100) {
        this.responseCode = null;
        this.responseMessage = null;
        this.dnsTime = 0;
        this.connectTime = 0;
        this.sslTime = 0;
        this.sendTime = 0;
        this.receiveTime = 0;
        this.isSocketReused = false;
        this.ttfbMs = 0;
        this.totalTime = 0;
        this.sentByteCount = 0;
        this.receivedByteCount = 0;
        this.rttCost = null;
        this.poxyCost = null;
        this.tcpCost = null;
        this.headerRecvCost = null;
        this.bodyRecvCost = null;
        this.connectionInfo = null;
    }

    public final void A(String r100) {
        this.responseMessage = r100;
    }

    public final void B(Long r100) {
        this.rttCost = r100;
    }

    public final void C(long r100) {
        this.sendTime = r100;
    }

    public final void D(long r100) {
        this.sentByteCount = r100;
    }

    public final void E(boolean r100) {
        this.isSocketReused = r100;
    }

    public final void F(long r100) {
        this.sslTime = r100;
    }

    public final void G(long r100) {
        this.totalTime = r100;
    }

    public final void H(long r100) {
        this.ttfbMs = r100;
    }

    public final void r(Long r100) {
        this.bodyRecvCost = r100;
    }

    public final void s(long r100) {
        this.connectTime = r100;
    }

    public final void t(Integer r100) {
        this.connectionInfo = r100;
    }

    public final void u(long r100) {
        this.dnsTime = r100;
    }

    public final void v(Long r100) {
        this.headerRecvCost = r100;
    }

    public final void w(Long r100) {
        this.poxyCost = r100;
    }

    public final void x(long r100) {
        this.receiveTime = r100;
    }

    public final void y(long r100) {
        this.receivedByteCount = r100;
    }

    public final void z(Integer r100) {
        this.responseCode = r100;
    }
}
