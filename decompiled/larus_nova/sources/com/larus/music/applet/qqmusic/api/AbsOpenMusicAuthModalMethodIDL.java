package com.larus.music.applet.qqmusic.api;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/music/applet/qqmusic/api/AbsOpenMusicAuthModalMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/larus/music/applet/qqmusic/api/AbsOpenMusicAuthModalMethodIDL$OpenMusicAuthModalParamModel;", "Lcom/larus/music/applet/qqmusic/api/AbsOpenMusicAuthModalMethodIDL$OpenMusicAuthModalResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "OpenMusicAuthModalParamModel", "TraceInfo", "OpenMusicAuthModalResultModel", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenMusicAuthModalMethodIDL extends CoreAIBridgeMethod<a, b> {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J±\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00067"}, d2 = {"Lcom/larus/music/applet/qqmusic/api/AbsOpenMusicAuthModalMethodIDL$TraceInfo;", "", "enterMethod", "", "secEnterMethod", "scene", "action", "botId", "appName", "appType", "uniqueKey", "widgetId", com.heytap.mcssdk.constant.b.f276376z, "bindScene", "bindSource", "bindType", "currentPage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnterMethod", "()Ljava/lang/String;", "getSecEnterMethod", "getScene", "getAction", "getBotId", "getAppName", "getAppType", "getUniqueKey", "getWidgetId", "getAppKey", "getBindScene", "getBindSource", "getBindType", "getCurrentPage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TraceInfo {

        @SerializedName("action")
        private final String action;

        @SerializedName("app_key")
        private final String appKey;

        @SerializedName("app_name")
        private final String appName;

        @SerializedName("app_type")
        private final String appType;

        @SerializedName("bind_scene")
        private final String bindScene;

        @SerializedName("bind_source")
        private final String bindSource;

        @SerializedName("bind_type")
        private final String bindType;

        @SerializedName("bot_id")
        private final String botId;

        @SerializedName("current_page")
        private final String currentPage;

        @SerializedName("enter_method")
        private final String enterMethod;

        @SerializedName("scene")
        private final String scene;

        @SerializedName("sec_enter_method")
        private final String secEnterMethod;

        @SerializedName("unique_key")
        private final String uniqueKey;

        @SerializedName("widget_id")
        private final String widgetId;

        public TraceInfo() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        public static /* synthetic */ TraceInfo copy$default(TraceInfo r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, int r310, Object r311) {
            if ((r310 & 1) == 0) goto L5;
            String r100 = r110.enterMethod;
        L7:
            if ((r310 & 2) == 0) goto L9;
            String r101 = r110.secEnterMethod;
        L11:
            if ((r310 & 4) == 0) goto L13;
            String r102 = r110.scene;
        L15:
            if ((r310 & 8) == 0) goto L17;
            String r103 = r110.action;
        L19:
            if ((r310 & 16) == 0) goto L21;
            String r104 = r110.botId;
        L23:
            if ((r310 & 32) == 0) goto L25;
            String r105 = r110.appName;
        L27:
            if ((r310 & 64) == 0) goto L29;
            String r106 = r110.appType;
        L31:
            if ((r310 & 128) == 0) goto L33;
            String r107 = r110.uniqueKey;
        L35:
            if ((r310 & 256) == 0) goto L37;
            String r115 = r110.widgetId;
        L39:
            if ((r310 & 512) == 0) goto L41;
            String r116 = r110.appKey;
        L43:
            if ((r310 & 1024) == 0) goto L45;
            String r117 = r110.bindScene;
        L47:
            if ((r310 & 2048) == 0) goto L49;
            String r118 = r110.bindSource;
        L51:
            if ((r310 & 4096) == 0) goto L53;
            String r119 = r110.bindType;
        L55:
            if ((r310 & 8192) == 0) goto L57;
            String r108 = r110.currentPage;
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
            return this.enterMethod;
        }

        public final String component10() {
            return this.appKey;
        }

        public final String component11() {
            return this.bindScene;
        }

        public final String component12() {
            return this.bindSource;
        }

        public final String component13() {
            return this.bindType;
        }

        public final String component14() {
            return this.currentPage;
        }

        public final String component2() {
            return this.secEnterMethod;
        }

        public final String component3() {
            return this.scene;
        }

        public final String component4() {
            return this.action;
        }

        public final String component5() {
            return this.botId;
        }

        public final String component6() {
            return this.appName;
        }

        public final String component7() {
            return this.appType;
        }

        public final String component8() {
            return this.uniqueKey;
        }

        public final String component9() {
            return this.widgetId;
        }

        public final TraceInfo copy(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310) {
            return new TraceInfo(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TraceInfo) == true) goto L8;
            return false;
        L8:
            TraceInfo r101 = (TraceInfo) r100;
            if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.secEnterMethod, r101.secEnterMethod) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.action, r101.action) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.appType, r101.appType) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.uniqueKey, r101.uniqueKey) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.bindScene, r101.bindScene) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.bindSource, r101.bindSource) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.bindType, r101.bindType) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L50;
            return false;
        L50:
            return true;
        }

        public int hashCode() {
            String r100 = this.enterMethod;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.secEnterMethod;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.scene;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.action;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.botId;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.appName;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.appType;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.uniqueKey;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.widgetId;
            if (r125 != null) goto L37;
            int r126 = 0;
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.appKey;
            if (r128 != null) goto L41;
            int r129 = 0;
        L42:
            int r130 = (r127 + r129) * 31;
            String r131 = this.bindScene;
            if (r131 != null) goto L45;
            int r132 = 0;
        L46:
            int r133 = (r130 + r132) * 31;
            String r134 = this.bindSource;
            if (r134 != null) goto L49;
            int r135 = 0;
        L50:
            int r136 = (r133 + r135) * 31;
            String r137 = this.bindType;
            if (r137 != null) goto L53;
            int r138 = 0;
        L54:
            int r139 = (r136 + r138) * 31;
            String r140 = this.currentPage;
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

        public String toString() {
            return "TraceInfo(enterMethod=" + this.enterMethod + ", secEnterMethod=" + this.secEnterMethod + ", scene=" + this.scene + ", action=" + this.action + ", botId=" + this.botId + ", appName=" + this.appName + ", appType=" + this.appType + ", uniqueKey=" + this.uniqueKey + ", widgetId=" + this.widgetId + ", appKey=" + this.appKey + ", bindScene=" + this.bindScene + ", bindSource=" + this.bindSource + ", bindType=" + this.bindType + ", currentPage=" + this.currentPage + ')';
        }

        public final String getAction() {
            return this.action;
        }

        public final String getAppKey() {
            return this.appKey;
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getAppType() {
            return this.appType;
        }

        public final String getBindScene() {
            return this.bindScene;
        }

        public final String getBindSource() {
            return this.bindSource;
        }

        public final String getBindType() {
            return this.bindType;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getCurrentPage() {
            return this.currentPage;
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final String getScene() {
            return this.scene;
        }

        public final String getSecEnterMethod() {
            return this.secEnterMethod;
        }

        public final String getUniqueKey() {
            return this.uniqueKey;
        }

        public final String getWidgetId() {
            return this.widgetId;
        }

        public TraceInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113, String r114) {
            this.enterMethod = r100;
            this.secEnterMethod = r101;
            this.scene = r102;
            this.action = r103;
            this.botId = r104;
            this.appName = r105;
            this.appType = r106;
            this.uniqueKey = r107;
            this.widgetId = r108;
            this.appKey = r110;
            this.bindScene = r111;
            this.bindSource = r112;
            this.bindType = r113;
            this.currentPage = r114;
        }

        public /* synthetic */ TraceInfo(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, int r310, DefaultConstructorMarker r311) {
            String r100 = null;
            if ((r310 & 1) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r310 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r310 & 4) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r310 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r310 & 16) == 0) goto L21;
            String r105 = null;
        L23:
            if ((r310 & 32) == 0) goto L25;
            String r106 = null;
        L27:
            if ((r310 & 64) == 0) goto L29;
            String r107 = null;
        L31:
            if ((r310 & 128) == 0) goto L33;
            String r108 = null;
        L35:
            if ((r310 & 256) == 0) goto L37;
            String r114 = null;
        L39:
            if ((r310 & 512) == 0) goto L41;
            String r115 = null;
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
        L37:
            r114 = r214;
            goto L39
        L33:
            r108 = r213;
            goto L35
        L29:
            r107 = r212;
            goto L31
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

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "authParams", required = false)
        nl9.a getAuthParams();

        @AIBridgeParamField(keyPath = "authTarget", required = true)
        ArrayList<String> getAuthTarget();

        @AIBridgeParamField(keyPath = "bottomAuthText", required = false)
        String getBottomAuthText();

        @AIBridgeParamField(keyPath = "id", required = false)
        String getId();

        @AIBridgeParamField(keyPath = RemoteMessageConst.MSGID, required = true)
        String getMsgId();

        @AIBridgeParamField(keyPath = "source", required = false)
        String getSource();

        @AIBridgeParamField(keyPath = "subTitle", required = false)
        String getSubTitle();

        @AIBridgeParamField(keyPath = "title", required = false)
        String getTitle();

        @AIBridgeParamField(keyPath = "traceInfo", required = false)
        TraceInfo getTraceInfo();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "authTarget", required = true)
        void setAuthTarget(String r100);

        @AIBridgeParamField(keyPath = "isAuthorized", required = true)
        void setAuthorized(boolean r100);

        @AIBridgeParamField(keyPath = "code", required = true)
        void setCode(int r100);

        @AIBridgeParamField(keyPath = "source_error_code", required = false)
        void setSourceErrorCode(Integer r100);
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return "flow.openMusicAuthModal";
    }

    public AbsOpenMusicAuthModalMethodIDL() {
    }
}
