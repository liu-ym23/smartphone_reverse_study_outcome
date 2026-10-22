package vq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013Jj\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013¨\u0006("}, d2 = {"Lcom/larus/platform/model/mainbot/LocalLifeConfig;", "", "customerMessageDetailHalf", "", "customerMessageDetail", "customerMessageList", "enableLocalLifeSaas", "", "enableOpenDetailDirectJump", "relayEvents", "", "enableLifeLiveInit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;)V", "getCustomerMessageDetailHalf", "()Ljava/lang/String;", "getCustomerMessageDetail", "getCustomerMessageList", "getEnableLocalLifeSaas", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableOpenDetailDirectJump", "getRelayEvents", "()Ljava/util/List;", "getEnableLifeLiveInit", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/platform/model/mainbot/LocalLifeConfig;", "equals", "other", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f556784a = null;

    @SerializedName("customer_message_detail")
    private final String customerMessageDetail;

    @SerializedName("customer_message_detail_half")
    private final String customerMessageDetailHalf;

    @SerializedName("customer_message_list")
    private final String customerMessageList;

    @SerializedName("enable_life_live_init")
    private final Boolean enableLifeLiveInit;

    @SerializedName("enable_locallife_saas")
    private final Boolean enableLocalLifeSaas;

    @SerializedName("enable_open_detail_direct_jump")
    private final Boolean enableOpenDetailDirectJump;

    @SerializedName("relay_events")
    private final List<String> relayEvents;

    public static final class a {
    }

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.customerMessageDetailHalf, r101.customerMessageDetailHalf) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customerMessageDetail, r101.customerMessageDetail) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.customerMessageList, r101.customerMessageList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enableLocalLifeSaas, r101.enableLocalLifeSaas) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enableOpenDetailDirectJump, r101.enableOpenDetailDirectJump) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.relayEvents, r101.relayEvents) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enableLifeLiveInit, r101.enableLifeLiveInit) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.customerMessageDetailHalf;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.customerMessageDetail;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.customerMessageList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.enableLocalLifeSaas;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.enableOpenDetailDirectJump;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.relayEvents;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.enableLifeLiveInit;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "LocalLifeConfig(customerMessageDetailHalf=" + this.customerMessageDetailHalf + ", customerMessageDetail=" + this.customerMessageDetail + ", customerMessageList=" + this.customerMessageList + ", enableLocalLifeSaas=" + this.enableLocalLifeSaas + ", enableOpenDetailDirectJump=" + this.enableOpenDetailDirectJump + ", relayEvents=" + this.relayEvents + ", enableLifeLiveInit=" + this.enableLifeLiveInit + ')';
    }

    static {
        f556784a = CollectionsKt.listOf(new String[]{"flow_life_change_confirm_order", "flow_life_submit_order", "flow_life_submit_order_fail", "flow_life_pay_order_retry_suc"});
    }

    public final String a() {
        return this.customerMessageDetail;
    }

    public final String b() {
        return this.customerMessageDetailHalf;
    }

    public final String c() {
        return this.customerMessageList;
    }

    public final Boolean d() {
        return this.enableLifeLiveInit;
    }

    public final Boolean e() {
        return this.enableLocalLifeSaas;
    }

    public final Boolean f() {
        return this.enableOpenDetailDirectJump;
    }

    public final List<String> g() {
        return this.relayEvents;
    }

    public b(Object r100) {
        List<String> r101 = f556784a;
        Boolean r102 = Boolean.TRUE;
        this.customerMessageDetailHalf = null;
        this.customerMessageDetail = null;
        this.customerMessageList = null;
        this.enableLocalLifeSaas = null;
        this.enableOpenDetailDirectJump = null;
        this.relayEvents = r101;
        this.enableLifeLiveInit = r102;
    }
}
