package uq6;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR.\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR$\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR$\u0010@\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR$\u0010C\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0004\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR$\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0016\u001a\u0004\bQ\u0010\u0018\"\u0004\bR\u0010\u001aR$\u0010S\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010\u0004\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\b¨\u0006V"}, d2 = {"Luq6/f;", "", "", "pageNetStartTs", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setPageNetStartTs", "(Ljava/lang/Long;)V", "pageNetCost", "getPageNetCost", "d", "Luq6/k;", "value", "httpRequestInfo", "Luq6/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Luq6/k;", "c", "(Luq6/k;)V", "", "pageNetResponseCode", "Ljava/lang/Integer;", "getPageNetResponseCode", "()Ljava/lang/Integer;", "setPageNetResponseCode", "(Ljava/lang/Integer;)V", "", "pageNetResponseMessage", "Ljava/lang/String;", "getPageNetResponseMessage", "()Ljava/lang/String;", "setPageNetResponseMessage", "(Ljava/lang/String;)V", "pageNetDnsCost", "getPageNetDnsCost", "setPageNetDnsCost", "pageNetSslCost", "getPageNetSslCost", "setPageNetSslCost", "pageNetSendCost", "getPageNetSendCost", "setPageNetSendCost", "pageNetWaitCost", "getPageNetWaitCost", "setPageNetWaitCost", "pageNetReceiveCost", "getPageNetReceiveCost", "setPageNetReceiveCost", "pageReceiveByteCount", "getPageReceiveByteCount", "setPageReceiveByteCount", "pageSendByteCount", "getPageSendByteCount", "setPageSendByteCount", "pageNetRttCost", "getPageNetRttCost", "setPageNetRttCost", "pageNetPoxyCost", "getPageNetPoxyCost", "setPageNetPoxyCost", "pageNetTTFbCost", "getPageNetTTFbCost", "setPageNetTTFbCost", "pageNetTcpCost", "getPageNetTcpCost", "setPageNetTcpCost", "pageNetHeaderRecvCost", "getPageNetHeaderRecvCost", "setPageNetHeaderRecvCost", "pageNetBodyRecvCost", "getPageNetBodyRecvCost", "setPageNetBodyRecvCost", "", "pageNetSocketReuse", "Ljava/lang/Boolean;", "getPageNetSocketReuse", "()Ljava/lang/Boolean;", "setPageNetSocketReuse", "(Ljava/lang/Boolean;)V", "pageNetConnectionInfo", "getPageNetConnectionInfo", "setPageNetConnectionInfo", "pageNetDurationCost", "getPageNetDurationCost", "setPageNetDurationCost", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @Expose
    private transient k httpRequestInfo;

    @SerializedName("page_net_body_recv_cost")
    private Long pageNetBodyRecvCost;

    @SerializedName("page_net_connection_info")
    private Integer pageNetConnectionInfo;

    @SerializedName("page_net_cost")
    private Long pageNetCost;

    @SerializedName("page_net_dns_cost")
    private Long pageNetDnsCost;

    @SerializedName("page_net_duration_cost")
    private Long pageNetDurationCost;

    @SerializedName("page_net_header_recv_cost")
    private Long pageNetHeaderRecvCost;

    @SerializedName("page_net_proxy_cost")
    private Long pageNetPoxyCost;

    @SerializedName("page_net_receive_cost")
    private Long pageNetReceiveCost;

    @SerializedName("page_net_resp_code")
    private Integer pageNetResponseCode;

    @SerializedName("page_net_resp_message")
    private String pageNetResponseMessage;

    @SerializedName("page_net_rtt_cost")
    private Long pageNetRttCost;

    @SerializedName("page_net_send_cost")
    private Long pageNetSendCost;

    @SerializedName("page_net_socket_reused")
    private Boolean pageNetSocketReuse;

    @SerializedName("page_net_ssl_cost")
    private Long pageNetSslCost;

    @SerializedName("page_net_start_ts")
    private Long pageNetStartTs;

    @SerializedName("page_net_ttfb_cost")
    private Long pageNetTTFbCost;

    @SerializedName("page_net_tcp_cost")
    private Long pageNetTcpCost;

    @SerializedName("page_net_wait_cost")
    private Long pageNetWaitCost;

    @SerializedName("page_net_receive_byte_count")
    private Long pageReceiveByteCount;

    @SerializedName("page_net_send_byte_count")
    private Long pageSendByteCount;

    public f() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.pageNetStartTs, r101.pageNetStartTs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageNetCost, r101.pageNetCost) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.pageNetStartTs;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.pageNetCost;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoPageRequestTimingInfo(pageNetStartTs=" + this.pageNetStartTs + ", pageNetCost=" + this.pageNetCost + ')';
    }

    public final k a() {
        return this.httpRequestInfo;
    }

    public final Long b() {
        return this.pageNetStartTs;
    }

    public final void c(k r100) {
        this.httpRequestInfo = r100;
        if (r100 == null) goto L6;
        this.pageNetDnsCost = Long.valueOf(r100.c());
        this.pageNetSslCost = Long.valueOf(r100.m());
        this.pageNetSendCost = Long.valueOf(r100.k());
        this.pageNetWaitCost = Long.valueOf(r100.p());
        this.pageNetReceiveCost = Long.valueOf(r100.f());
        this.pageReceiveByteCount = Long.valueOf(r100.g());
        this.pageSendByteCount = Long.valueOf(r100.l());
        this.pageNetDurationCost = Long.valueOf(r100.o());
        this.pageNetTTFbCost = Long.valueOf(r100.p());
        this.pageNetSocketReuse = Boolean.valueOf(r100.q());
        this.pageNetPoxyCost = r100.e();
        this.pageNetTcpCost = r100.n();
        this.pageNetRttCost = r100.j();
        this.pageNetHeaderRecvCost = r100.d();
        this.pageNetBodyRecvCost = r100.a();
        this.pageNetConnectionInfo = r100.b();
        this.pageNetResponseCode = r100.h();
        this.pageNetResponseMessage = r100.i();
        return;
    }

    public final void d(Long r100) {
        this.pageNetCost = r100;
    }

    public f(Long r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = Long.valueOf(System.currentTimeMillis());
    L5:
        this.pageNetStartTs = r100;
        this.pageNetCost = null;
    }
}
