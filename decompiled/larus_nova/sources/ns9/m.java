package ns9;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B©\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c\u0012\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\tHÆ\u0003J\u0013\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\tHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010M\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u00107J\u0019\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001cHÆ\u0003J\u0019\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001cHÆ\u0003J°\u0002\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\t2\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c2\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001cHÆ\u0001¢\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\u0003HÖ\u0001J\t\u0010V\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010!R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b5\u0010!R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:¨\u0006W"}, d2 = {"Lcom/larus/reach/api/ReachNotify;", "", "appId", "", "type", "", "pushId", "pushScene", "notificationGroup", "", "position", "reachTarget", "Lcom/larus/reach/api/ReachNotifyTarget;", "layout", GXTemplateKey.GAIAX_TEMPLATE_ID, "title", "level", SocialConstants.PARAM_APP_DESC, "iconUrl", "buttons", "Lcom/larus/reach/api/ReachNotifyButton;", SlcCommonAction.KEY_ACTIONS, "Lcom/larus/reach/api/ReachNotifyAction;", "dismissal", "priority", "duration", "", "passThrough", "", "extra", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/reach/api/ReachNotifyTarget;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)V", "getAppId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "()Ljava/lang/String;", "getPushId", "getPushScene", "getNotificationGroup", "()Ljava/util/List;", "getPosition", "getReachTarget", "()Lcom/larus/reach/api/ReachNotifyTarget;", "getLayout", "getTemplateId", "getTitle", "getLevel", "getDesc", "getIconUrl", "getButtons", "getActions", "getDismissal", "getPriority", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPassThrough", "()Ljava/util/Map;", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/reach/api/ReachNotifyTarget;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)Lcom/larus/reach/api/ReachNotify;", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<n> actions;

    @SerializedName("app_id")
    private final Integer appId;

    @SerializedName("buttons")
    private final List<o> buttons;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("dismissal")
    private final String dismissal;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("layout")
    private final Integer layout;

    @SerializedName("level")
    private final String level;

    @SerializedName("notification_group")
    private final List<Integer> notificationGroup;

    @SerializedName("pass_through")
    private final Map<String, String> passThrough;

    @SerializedName("position")
    private final String position;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName("push_id")
    private final String pushId;

    @SerializedName("push_scene")
    private final String pushScene;

    @SerializedName("reach_target")
    private final q reachTarget;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private final String templateId;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final String type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pushId, r101.pushId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pushScene, r101.pushScene) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.notificationGroup, r101.notificationGroup) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.reachTarget, r101.reachTarget) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.layout, r101.layout) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.level, r101.level) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.buttons, r101.buttons) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.dismissal, r101.dismissal) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.passThrough, r101.passThrough) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.appId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.pushId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.pushScene;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<Integer> r113 = this.notificationGroup;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.position;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        q r119 = this.reachTarget;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.layout;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.templateId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.title;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.level;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.desc;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.iconUrl;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<o> r140 = this.buttons;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        List<n> r143 = this.actions;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.dismissal;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.priority;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Long r152 = this.duration;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Map<String, String> r155 = this.passThrough;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        Map<String, String> r158 = this.extra;
        if (r158 == null) goto L83;
        r101 = r158.hashCode();
    L83:
        return r157 + r101;
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
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
        return "ReachNotify(appId=" + this.appId + ", type=" + this.type + ", pushId=" + this.pushId + ", pushScene=" + this.pushScene + ", notificationGroup=" + this.notificationGroup + ", position=" + this.position + ", reachTarget=" + this.reachTarget + ", layout=" + this.layout + ", templateId=" + this.templateId + ", title=" + this.title + ", level=" + this.level + ", desc=" + this.desc + ", iconUrl=" + this.iconUrl + ", buttons=" + this.buttons + ", actions=" + this.actions + ", dismissal=" + this.dismissal + ", priority=" + this.priority + ", duration=" + this.duration + ", passThrough=" + this.passThrough + ", extra=" + this.extra + ')';
    }

    public m() {
        this.appId = null;
        this.type = null;
        this.pushId = null;
        this.pushScene = null;
        this.notificationGroup = null;
        this.position = null;
        this.reachTarget = null;
        this.layout = null;
        this.templateId = null;
        this.title = null;
        this.level = null;
        this.desc = null;
        this.iconUrl = null;
        this.buttons = null;
        this.actions = null;
        this.dismissal = null;
        this.priority = null;
        this.duration = null;
        this.passThrough = null;
        this.extra = null;
    }

    public final List<n> a() {
        return this.actions;
    }

    public final Integer b() {
        return this.appId;
    }

    public final List<o> c() {
        return this.buttons;
    }

    public final String d() {
        return this.desc;
    }

    public final String e() {
        return this.dismissal;
    }

    public final Long f() {
        return this.duration;
    }

    public final Map<String, String> g() {
        return this.extra;
    }

    public final String getType() {
        return this.type;
    }

    public final String h() {
        return this.iconUrl;
    }

    public final Integer i() {
        return this.layout;
    }

    public final String j() {
        return this.level;
    }

    public final List<Integer> k() {
        return this.notificationGroup;
    }

    public final Map<String, String> l() {
        return this.passThrough;
    }

    public final String m() {
        return this.position;
    }

    public final Integer n() {
        return this.priority;
    }

    public final String o() {
        return this.pushId;
    }

    public final String p() {
        return this.pushScene;
    }

    public final q q() {
        return this.reachTarget;
    }

    public final String r() {
        return this.templateId;
    }

    public final String s() {
        return this.title;
    }
}
