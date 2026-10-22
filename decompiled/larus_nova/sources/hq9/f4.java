package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001BÙ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003JÛ\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0011HÖ\u0001J\t\u00108\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0017R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017¨\u00069"}, d2 = {"Lcom/larus/platform/model/RouterConfig;", "", "enableOuterLinkWhiteListFromNet", "", "enablePushWhiteListFromNet", "enableXOpenWhiteListFromNet", "enablePostSwitchRouting", "outerLinkWhiteList", "", "", "pushWhiteList", "xOpenWhiteList", "outerLinkBlockList", "pushBlockList", "xOpenBlockList", "outerLinkQueryBlockList", "judgeIsFromOuterStrategy", "", "isDeeplinkAutoSendDowngrade", "enableChatSchemaOptions", "<init>", "(ZZZZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IZZ)V", "getEnableOuterLinkWhiteListFromNet", "()Z", "getEnablePushWhiteListFromNet", "getEnableXOpenWhiteListFromNet", "getEnablePostSwitchRouting", "getOuterLinkWhiteList", "()Ljava/util/List;", "getPushWhiteList", "getXOpenWhiteList", "getOuterLinkBlockList", "getPushBlockList", "getXOpenBlockList", "getOuterLinkQueryBlockList", "getJudgeIsFromOuterStrategy", "()I", "getEnableChatSchemaOptions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f4 {

    @SerializedName("chat_schema_options_enable")
    private final boolean enableChatSchemaOptions;

    @SerializedName("router_outer_link_check_enable")
    private final boolean enableOuterLinkWhiteListFromNet;

    @SerializedName("post_switch_route_enable")
    private final boolean enablePostSwitchRouting;

    @SerializedName("router_push_check_enable")
    private final boolean enablePushWhiteListFromNet;

    @SerializedName("router_xopen_check_enable")
    private final boolean enableXOpenWhiteListFromNet;

    @SerializedName("router_auto_send_downgrade")
    private final boolean isDeeplinkAutoSendDowngrade;

    @SerializedName("judge_is_from_outer_strategy")
    private final int judgeIsFromOuterStrategy;

    @SerializedName("block_list_for_outer_link")
    private final List<String> outerLinkBlockList;

    @SerializedName("block_query_list_for_outer_link")
    private final List<String> outerLinkQueryBlockList;

    @SerializedName("white_list_for_outer_link")
    private final List<String> outerLinkWhiteList;

    @SerializedName("block_list_for_push")
    private final List<String> pushBlockList;

    @SerializedName("white_list_for_push")
    private final List<String> pushWhiteList;

    @SerializedName("block_list_for_xopen")
    private final List<String> xOpenBlockList;

    @SerializedName("white_list_for_xopen")
    private final List<String> xOpenWhiteList;

    public f4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f4) == true) goto L8;
        return false;
    L8:
        f4 r101 = (f4) r100;
        if (this.enableOuterLinkWhiteListFromNet == r101.enableOuterLinkWhiteListFromNet) goto L12;
        return false;
    L12:
        if (this.enablePushWhiteListFromNet == r101.enablePushWhiteListFromNet) goto L15;
        return false;
    L15:
        if (this.enableXOpenWhiteListFromNet == r101.enableXOpenWhiteListFromNet) goto L18;
        return false;
    L18:
        if (this.enablePostSwitchRouting == r101.enablePostSwitchRouting) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.outerLinkWhiteList, r101.outerLinkWhiteList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pushWhiteList, r101.pushWhiteList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.xOpenWhiteList, r101.xOpenWhiteList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.outerLinkBlockList, r101.outerLinkBlockList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.pushBlockList, r101.pushBlockList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.xOpenBlockList, r101.xOpenBlockList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.outerLinkQueryBlockList, r101.outerLinkQueryBlockList) == true) goto L42;
        return false;
    L42:
        if (this.judgeIsFromOuterStrategy == r101.judgeIsFromOuterStrategy) goto L45;
        return false;
    L45:
        if (this.isDeeplinkAutoSendDowngrade == r101.isDeeplinkAutoSendDowngrade) goto L48;
        return false;
    L48:
        if (this.enableChatSchemaOptions == r101.enableChatSchemaOptions) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableOuterLinkWhiteListFromNet == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enablePushWhiteListFromNet == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableXOpenWhiteListFromNet == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enablePostSwitchRouting == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        List<String> r109 = this.outerLinkWhiteList;
        int r110 = 0;
        if (r109 != null) goto L21;
        int r111 = 0;
    L22:
        int r112 = (r108 + r111) * 31;
        List<String> r113 = this.pushWhiteList;
        if (r113 != null) goto L25;
        int r114 = 0;
    L26:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.xOpenWhiteList;
        if (r116 != null) goto L29;
        int r117 = 0;
    L30:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.outerLinkBlockList;
        if (r119 != null) goto L33;
        int r120 = 0;
    L34:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.pushBlockList;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        List<String> r125 = this.xOpenBlockList;
        if (r125 != null) goto L41;
        int r126 = 0;
    L42:
        int r127 = (r124 + r126) * 31;
        List<String> r128 = this.outerLinkQueryBlockList;
        if (r128 == null) goto L46;
        r110 = r128.hashCode();
    L46:
        int r129 = (((r127 + r110) * 31) + this.judgeIsFromOuterStrategy) * 31;
        if (this.isDeeplinkAutoSendDowngrade == false) goto L49;
        int r130 = 1231;
    L50:
        int r131 = (r129 + r130) * 31;
        if (this.enableChatSchemaOptions == true) goto L55;
        r100 = 1237;
    L55:
        return r131 + r100;
    L49:
        r130 = 1237;
        goto L50
    L41:
        r126 = r125.hashCode();
        goto L42
    L37:
        r123 = r122.hashCode();
        goto L38
    L33:
        r120 = r119.hashCode();
        goto L34
    L29:
        r117 = r116.hashCode();
        goto L30
    L25:
        r114 = r113.hashCode();
        goto L26
    L21:
        r111 = r109.hashCode();
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RouterConfig(enableOuterLinkWhiteListFromNet=" + this.enableOuterLinkWhiteListFromNet + ", enablePushWhiteListFromNet=" + this.enablePushWhiteListFromNet + ", enableXOpenWhiteListFromNet=" + this.enableXOpenWhiteListFromNet + ", enablePostSwitchRouting=" + this.enablePostSwitchRouting + ", outerLinkWhiteList=" + this.outerLinkWhiteList + ", pushWhiteList=" + this.pushWhiteList + ", xOpenWhiteList=" + this.xOpenWhiteList + ", outerLinkBlockList=" + this.outerLinkBlockList + ", pushBlockList=" + this.pushBlockList + ", xOpenBlockList=" + this.xOpenBlockList + ", outerLinkQueryBlockList=" + this.outerLinkQueryBlockList + ", judgeIsFromOuterStrategy=" + this.judgeIsFromOuterStrategy + ", isDeeplinkAutoSendDowngrade=" + this.isDeeplinkAutoSendDowngrade + ", enableChatSchemaOptions=" + this.enableChatSchemaOptions + ')';
    }

    public final boolean a() {
        return this.enableChatSchemaOptions;
    }

    public final boolean b() {
        return this.isDeeplinkAutoSendDowngrade;
    }

    public /* synthetic */ f4(int r110) {
        this(false, false, false, true, null, null, null, null, null, null, null, 1, true, true);
    }

    public f4(boolean r100, boolean r101, boolean r102, boolean r103, List<String> r104, List<String> r105, List<String> r106, List<String> r107, List<String> r108, List<String> r110, List<String> r111, int r112, boolean r113, boolean r114) {
        this.enableOuterLinkWhiteListFromNet = r100;
        this.enablePushWhiteListFromNet = r101;
        this.enableXOpenWhiteListFromNet = r102;
        this.enablePostSwitchRouting = r103;
        this.outerLinkWhiteList = r104;
        this.pushWhiteList = r105;
        this.xOpenWhiteList = r106;
        this.outerLinkBlockList = r107;
        this.pushBlockList = r108;
        this.xOpenBlockList = r110;
        this.outerLinkQueryBlockList = r111;
        this.judgeIsFromOuterStrategy = r112;
        this.isDeeplinkAutoSendDowngrade = r113;
        this.enableChatSchemaOptions = r114;
    }
}
