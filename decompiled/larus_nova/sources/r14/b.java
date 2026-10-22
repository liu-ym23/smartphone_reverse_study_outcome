package r14;

import android.text.TextUtils;
import com.bef.effectsdk.RequirementDefine;
import com.bytedance.awemeopen.bizmodels.feed.MvModel;
import com.bytedance.awemeopen.bizmodels.feed.OpenPlatformStruct;
import com.bytedance.awemeopen.bizmodels.feed.VPAInfo;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0002LMB\u0007¢\u0006\u0004\bJ\u0010KR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012R$\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\"\u00109\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010\u0012R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u0014\u0010I\u001a\u00020\f8\u0002X\u0083D¢\u0006\u0006\n\u0004\bI\u0010\u000e¨\u0006N"}, d2 = {"Lr14/b;", "", "", "mvThemeId", "Ljava/lang/String;", "getMvThemeId", "()Ljava/lang/String;", "setMvThemeId", "(Ljava/lang/String;)V", "welfareActivityId", "getWelfareActivityId", "setWelfareActivityId", "", "mvType", "I", "getMvType", "()I", "setMvType", "(I)V", "Lcom/bytedance/awemeopen/bizmodels/feed/MvModel;", "mvInfo", "Lcom/bytedance/awemeopen/bizmodels/feed/MvModel;", "getMvInfo", "()Lcom/bytedance/awemeopen/bizmodels/feed/MvModel;", "setMvInfo", "(Lcom/bytedance/awemeopen/bizmodels/feed/MvModel;)V", "mStatusId", "getMStatusId", "setMStatusId", "mVideoTag", "getMVideoTag", "setMVideoTag", "Lr14/b$b;", "f2ProjectInfo", "Lr14/b$b;", "getF2ProjectInfo", "()Lr14/b$b;", "setF2ProjectInfo", "(Lr14/b$b;)V", "diamondGameId", "getDiamondGameId", "setDiamondGameId", "koiFish", "getKoiFish", "setKoiFish", "Lcom/bytedance/awemeopen/bizmodels/feed/VPAInfo;", "vpaInfo", "Lcom/bytedance/awemeopen/bizmodels/feed/VPAInfo;", "ocrLocation", "getOcrLocation", "setOcrLocation", RequirementDefine.REQUIREMENT_GREEN_SCREEN_VIDEO_TAG, "getGreenScreen", "setGreenScreen", "originalGroupId", "getOriginalGroupId", "setOriginalGroupId", "originalGidDistance", "getOriginalGidDistance", "setOriginalGidDistance", "musicBeginTime", "getMusicBeginTime", "setMusicBeginTime", "Lcom/bytedance/awemeopen/bizmodels/feed/OpenPlatformStruct;", "vimoInfo", "Lcom/bytedance/awemeopen/bizmodels/feed/OpenPlatformStruct;", "getVimoInfo", "()Lcom/bytedance/awemeopen/bizmodels/feed/OpenPlatformStruct;", "setVimoInfo", "(Lcom/bytedance/awemeopen/bizmodels/feed/OpenPlatformStruct;)V", "activityFeedJson", "getActivityFeedJson", "setActivityFeedJson", "isTeenVideo", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f535617a = 0;

    @SerializedName("activity_feed_json")
    private String activityFeedJson;

    @SerializedName("diamond_game_id")
    private String diamondGameId;

    @SerializedName("hproject_info")
    private C7418b f2ProjectInfo;

    @SerializedName("green_screen")
    private int greenScreen;

    @SerializedName("is_teen_video")
    private final int isTeenVideo;

    @SerializedName("koi_fish")
    private int koiFish;

    @SerializedName("status_template_id")
    private String mStatusId;

    @SerializedName("video_tag")
    private int mVideoTag;

    @SerializedName("music_begin_time")
    private String musicBeginTime;

    @SerializedName("mv_info")
    private MvModel mvInfo;

    @SerializedName("mv_id")
    private String mvThemeId;

    @SerializedName("mv_type")
    private int mvType;

    @SerializedName("ocr_location")
    private String ocrLocation;

    @SerializedName("original_gid_distance")
    private int originalGidDistance;

    @SerializedName("original_group_id")
    private String originalGroupId;

    @SerializedName("vimo_info")
    private OpenPlatformStruct vimoInfo;

    @SerializedName("vpa_info")
    public VPAInfo vpaInfo;

    @SerializedName("welfare_activity_id")
    private String welfareActivityId;

    public static final class a {
    }

    /* JADX INFO: renamed from: r14.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lr14/b$b;", "", "Lt14/a;", "iconUrl", "Lt14/a;", "getIconUrl", "()Lt14/a;", "setIconUrl", "(Lt14/a;)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
    public static final class C7418b {

        @SerializedName("icon_url")
        private t14.a iconUrl;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
        private String schemaUrl;

        @SerializedName("title")
        private String title;

        public C7418b() {
        }
    }

    static {
    }

    public final d0 a() {
        if (TextUtils.isEmpty(this.ocrLocation) == false) goto L10;
        return null;
    L10:
        return (d0) new Gson().fromJson(this.ocrLocation, d0.class);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public b() {
        this.vpaInfo = new VPAInfo(false, 0);
        this.originalGroupId = "-1";
    }
}
