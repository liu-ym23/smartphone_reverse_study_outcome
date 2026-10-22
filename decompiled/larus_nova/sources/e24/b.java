package e24;

import android.text.TextUtils;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.ttvideoengine.FeatureManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bq\u0010rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR$\u0010&\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR$\u0010)\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\"\u00100\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\"\u00109\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u00101\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\"\u0010<\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u00101\u001a\u0004\b=\u00103\"\u0004\b>\u00105R$\u0010?\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000b\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR$\u0010B\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0018\u001a\u0004\bC\u0010\u001a\"\u0004\bD\u0010\u001cR\"\u0010E\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u00101\u001a\u0004\bF\u00103\"\u0004\bG\u00105R\"\u0010H\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u00101\u001a\u0004\bI\u00103\"\u0004\bJ\u00105R\"\u0010K\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u00101\u001a\u0004\bL\u00103\"\u0004\bM\u00105R$\u0010N\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u000b\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR$\u0010Q\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u000b\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR$\u0010T\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010\u000b\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000fR(\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00000W8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010^\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010\u0018\u001a\u0004\b_\u0010\u001a\"\u0004\b`\u0010\u001cR$\u0010a\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0018\u001a\u0004\bb\u0010\u001a\"\u0004\bc\u0010\u001cR$\u0010e\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010l\u001a\u00020k8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bl\u0010n\"\u0004\bo\u0010p¨\u0006s"}, d2 = {"Le24/b;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "", "mid", "Ljava/lang/String;", "getMid", "()Ljava/lang/String;", "setMid", "(Ljava/lang/String;)V", "album", "getAlbum", "setAlbum", "musicName", "d", "setMusicName", "Lt14/a;", "converHd", "Lt14/a;", "getConverHd", "()Lt14/a;", "setConverHd", "(Lt14/a;)V", "coverLarge", "getCoverLarge", "setCoverLarge", "coverMedium", "getCoverMedium", "setCoverMedium", "coverThumb", "b", "setCoverThumb", "playUrl", ce.f26391f, "setPlayUrl", "authorName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAuthorName", "schema", "getSchema", "setSchema", "", "source", "I", "getSource", "()I", "setSource", "(I)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "endTime", "getEndTime", "setEndTime", "duration", "getDuration", "setDuration", "extra", "getExtra", "setExtra", "effectsData", "getEffectsData", "setEffectsData", "collectStatus", "getCollectStatus", "setCollectStatus", "userCount", "getUserCount", "setUserCount", "musicStatus", "e", "setMusicStatus", "offlineDesc", "getOfflineDesc", "setOfflineDesc", "ownerId", "f", "setOwnerId", "ownerNickName", "getOwnerNickName", "setOwnerNickName", "", "relatedMusics", "Ljava/util/List;", "getRelatedMusics", "()Ljava/util/List;", "setRelatedMusics", "(Ljava/util/List;)V", "audioTrack", "getAudioTrack", "setAudioTrack", "bodyDanceUrl", "getBodyDanceUrl", "setBodyDanceUrl", "Le24/a;", "matchedPGCSoundInfo", "Le24/a;", "c", "()Le24/a;", "setMatchedPGCSoundInfo", "(Le24/a;)V", "", "isOriginMusic", "Z", "()Z", "setOriginMusic", "(Z)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    @SerializedName("album")
    private String album;

    @SerializedName(FeatureManager.AUDIO_TRACK)
    private t14.a audioTrack;

    @SerializedName("author")
    private String authorName;

    @SerializedName("bodydance_url")
    private t14.a bodyDanceUrl;

    @SerializedName("collect_stat")
    private int collectStatus;

    @SerializedName("cover_hd")
    private t14.a converHd;

    @SerializedName("cover_large")
    private t14.a coverLarge;

    @SerializedName("cover_medium")
    private t14.a coverMedium;

    @SerializedName("cover_thumb")
    private t14.a coverThumb;

    @SerializedName("duration")
    private int duration;

    @SerializedName("effects_data")
    private t14.a effectsData;

    @SerializedName("end_time")
    private int endTime;

    @SerializedName("extra")
    private String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f470817id;

    @SerializedName("is_original")
    private boolean isOriginMusic;

    @SerializedName("matched_pgc_sound")
    private a matchedPGCSoundInfo;

    @SerializedName("id_str")
    private String mid;

    @SerializedName("title")
    private String musicName;

    @SerializedName("status")
    private int musicStatus;

    @SerializedName("offline_desc")
    private String offlineDesc;

    @SerializedName("owner_id")
    private String ownerId;

    @SerializedName("owner_nickname")
    private String ownerNickName;

    @SerializedName("play_url")
    private t14.a playUrl;

    @SerializedName("related_musics")
    private List<b> relatedMusics;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    private String schema;

    @SerializedName("source_platform")
    private int source;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private int startTime;

    @SerializedName("user_count")
    private int userCount;

    public b() {
        this.relatedMusics = new ArrayList();
    }

    public final String a() {
        return this.authorName;
    }

    public final t14.a b() {
        return this.coverThumb;
    }

    public final a c() {
        return this.matchedPGCSoundInfo;
    }

    public final String d() {
        return this.musicName;
    }

    public final int e() {
        return this.musicStatus;
    }

    public final String f() {
        return this.ownerId;
    }

    public final t14.a g() {
        return this.playUrl;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        return TextUtils.equals(((b) r100).mid, this.mid);
    }
}
