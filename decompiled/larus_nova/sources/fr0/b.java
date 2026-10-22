package fr0;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lfr0/b;", "", "", "Lfr0/b$a;", "entranceInfoList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setEntranceInfoList", "(Ljava/util/List;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("entrances")
    private List<a> entranceInfoList;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\bT\u0010UR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u001d\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR$\u0010B\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR$\u0010H\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR$\u0010Q\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010I\u001a\u0004\bR\u0010K\"\u0004\bS\u0010M¨\u0006V"}, d2 = {"Lfr0/b$a;", "", "", "appId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "name", "h", "setName", "iconUrl", "getIconUrl", "setIconUrl", "schemaUrl", "imageUrl", "summary", "getSummary", "setSummary", "", "gameType", "I", "e", "()I", "setGameType", "(I)V", "", "currentUsers", "J", "getCurrentUsers", "()J", "setCurrentUsers", "(J)V", "uniqueVisitor", "getUniqueVisitor", "setUniqueVisitor", "", "userAvatars", "Ljava/util/List;", "getUserAvatars", "()Ljava/util/List;", "setUserAvatars", "(Ljava/util/List;)V", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "", "disableEntrance", "Z", "c", "()Z", "setDisableEntrance", "(Z)V", "timestamp", "getTimestamp", "setTimestamp", "roomId", "getRoomId", "setRoomId", "startId", "getStartId", "setStartId", DBDefinition.TASK_ID, RXScreenCaptureService.KEY_INDEX, "setTaskId", "extra", "d", "setExtra", "clickNature", "b", "setClickNature", "instantPlayToggleStatus", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "setInstantPlayToggleStatus", "(Ljava/lang/Integer;)V", "instantPlayRequirementEnum", "getInstantPlayRequirementEnum", "setInstantPlayRequirementEnum", "instantPlayOpenStatus", "f", "setInstantPlayOpenStatus", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName(BdpAppEventConstant.PARAMS_MP_ID)
        private String appId;

        @SerializedName("click_nature")
        private String clickNature;

        @SerializedName(Segment.JsonKey.CURRENT)
        private long currentUsers;

        @SerializedName("disable_entrance")
        private boolean disableEntrance;

        @SerializedName("extra")
        private String extra;

        @SerializedName(BdpAppEventConstant.PARAMS_GAME_TYPE)
        private int gameType;

        @SerializedName("icon_url")
        private String iconUrl;

        @SerializedName("image_url")
        public String imageUrl;

        @SerializedName("instant_play_open_status")
        private Integer instantPlayOpenStatus;

        @SerializedName("instant_play_requirement_enum")
        private Integer instantPlayRequirementEnum;

        @SerializedName("instant_play_toggle_status")
        private Integer instantPlayToggleStatus;

        @SerializedName("name")
        private String name;

        @SerializedName("room_id")
        private String roomId;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
        public String schemaUrl;

        @SerializedName("start_id")
        private String startId;

        @SerializedName("summary")
        private String summary;

        @SerializedName(PromotionProductPrivilegesStruct.TAGS)
        private List<String> tags;

        @SerializedName("task_id")
        private String taskId;

        @SerializedName("timestamp")
        private long timestamp;

        @SerializedName("uv")
        private long uniqueVisitor;

        @SerializedName("user_avatars")
        private List<String> userAvatars;

        /* JADX INFO: renamed from: fr0.b$a$a, reason: collision with other inner class name */
        public static final class C5942a {
        }

        static {
        }

        public final String toString() {
            return "MgEntranceInfo(appId='" + this.appId + "', name='" + this.name + "', iconUrl='" + this.iconUrl + "', schemaUrl='" + this.schemaUrl + "', imageUrl='" + this.imageUrl + "', summary='" + this.summary + "', currentUsers=" + this.currentUsers + ", uniqueVisitor=" + this.uniqueVisitor + ", userAvatars=" + this.userAvatars + ", tags=" + this.tags + ", disableEntrance=" + this.disableEntrance + ", timestamp=" + this.timestamp + ", roomId='" + this.roomId + "', startId='" + this.startId + "', extra=" + this.extra + ')';
        }

        public a() {
            this.appId = "";
            this.name = "";
            this.iconUrl = "";
            this.schemaUrl = "";
            this.imageUrl = "";
            this.summary = "";
            this.gameType = 1;
            this.roomId = "";
            this.startId = "";
            this.taskId = "";
            this.instantPlayToggleStatus = 0;
            this.instantPlayRequirementEnum = 0;
            this.instantPlayOpenStatus = 0;
        }

        public final String a() {
            return this.appId;
        }

        public final String b() {
            return this.clickNature;
        }

        public final boolean c() {
            return this.disableEntrance;
        }

        public final String d() {
            return this.extra;
        }

        public final int e() {
            return this.gameType;
        }

        public final Integer f() {
            return this.instantPlayOpenStatus;
        }

        public final Integer g() {
            return this.instantPlayToggleStatus;
        }

        public final String h() {
            return this.name;
        }

        public final String i() {
            return this.taskId;
        }
    }

    public b() {
    }

    public final String toString() {
        return "MgEntranceInfoResponse(entranceInfoList=" + this.entranceInfoList + ')';
    }

    public final List<a> a() {
        return this.entranceInfoList;
    }
}
