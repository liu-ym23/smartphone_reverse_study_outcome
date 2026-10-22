package com.bytedance.ies.xelement.defaultimpl.player.impl.entity;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.common.PlayModel;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0007R\u0014\u0010+\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0007R\u0014\u0010-\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0007R\u0014\u0010/\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0007R\u0014\u00101\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0007R\u0014\u00103\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0007R\u0014\u00105\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0007R\u0014\u00108\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010'R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\"¨\u0006?"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/impl/entity/XAudioSrc;", "Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/queue/f;", "", "toString", "mSongId", "Ljava/lang/String;", "getMSongId", "()Ljava/lang/String;", "mSongName", "getMSongName", "mCoverUrl", "getMCoverUrl", "mArtistName", "getMArtistName", "mPlayUrl", "getMPlayUrl", "mLocalPath", "getMLocalPath", "mAlbumName", "getMAlbumName", "", "mDuration", "Ljava/lang/Long;", "getMDuration", "()Ljava/lang/Long;", "", "mCanBackgroundPlay", "Ljava/lang/Boolean;", "getMCanBackgroundPlay", "()Ljava/lang/Boolean;", "", "mEventData", "Ljava/util/Map;", "getMEventData", "()Ljava/util/Map;", "Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/common/PlayModel;", "mPlayModel", "Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/common/PlayModel;", "getMPlayModel", "()Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/common/PlayModel;", "getId", "id", "getPlayUrl", "playUrl", "getLocalPath", "localPath", "getCoverUrl", "coverUrl", "getSongName", "songName", "getArtistName", "artistName", "getAlbumName", "albumName", "getDuration", "()J", "duration", "getPlayModel", "playModel", "getExtras", "extras", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/common/PlayModel;)V", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final class XAudioSrc implements f {

    @SerializedName("album_title")
    private final String mAlbumName;

    @SerializedName("artist")
    private final String mArtistName;

    @SerializedName("can_background_play")
    private final Boolean mCanBackgroundPlay;

    @SerializedName("artwork_url")
    private final String mCoverUrl;

    @SerializedName("playback_duration")
    private final Long mDuration;

    @SerializedName("event_data")
    private final Map<String, String> mEventData;

    @SerializedName("local_path")
    private final String mLocalPath;

    @SerializedName("play_model")
    private final PlayModel mPlayModel;

    @SerializedName("play_url")
    private final String mPlayUrl;

    @SerializedName("id")
    private final String mSongId;

    @SerializedName("title")
    private final String mSongName;

    public XAudioSrc() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public String getAlbumName() {
        String r100 = this.mAlbumName;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getArtistName() {
        String r100 = this.mArtistName;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getCoverUrl() {
        String r100 = this.mCoverUrl;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public long getDuration() {
        Long r100 = this.mDuration;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.longValue();
    }

    public Map<String, String> getExtras() {
        Map<String, String> r100 = this.mEventData;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new HashMap();
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f
    public String getId() {
        String r100 = this.mSongId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f
    public String getLocalPath() {
        String r100 = this.mLocalPath;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f
    public PlayModel getPlayModel() {
        PlayModel r100 = this.mPlayModel;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new PlayModel(null, null, null, 7, null);
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f
    public String getPlayUrl() {
        String r100 = this.mPlayUrl;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getSongName() {
        String r100 = this.mSongName;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String toString() {
        return "XAudioDataSource(mSongId=" + this.mSongId + ", mSongName=" + this.mSongName + ", mCoverUrl=" + this.mCoverUrl + ", mArtistName=" + this.mArtistName + ", mPlayUrl=" + this.mPlayUrl + ", mCoverUrl=" + this.mCoverUrl + ", mAlbumName=" + this.mAlbumName + ", mDuration=" + this.mDuration + ", mCanBackgroundPlay=" + this.mCanBackgroundPlay + ", mEventData=" + this.mEventData + ')';
    }

    public final String getMAlbumName() {
        return this.mAlbumName;
    }

    public final String getMArtistName() {
        return this.mArtistName;
    }

    public final Boolean getMCanBackgroundPlay() {
        return this.mCanBackgroundPlay;
    }

    public final String getMCoverUrl() {
        return this.mCoverUrl;
    }

    public final Long getMDuration() {
        return this.mDuration;
    }

    public final Map<String, String> getMEventData() {
        return this.mEventData;
    }

    public final String getMLocalPath() {
        return this.mLocalPath;
    }

    public final PlayModel getMPlayModel() {
        return this.mPlayModel;
    }

    public final String getMPlayUrl() {
        return this.mPlayUrl;
    }

    public final String getMSongId() {
        return this.mSongId;
    }

    public final String getMSongName() {
        return this.mSongName;
    }

    public XAudioSrc(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Long r107, Boolean r108, Map<String, String> r110, PlayModel r111) {
        this.mSongId = r100;
        this.mSongName = r101;
        this.mCoverUrl = r102;
        this.mArtistName = r103;
        this.mPlayUrl = r104;
        this.mLocalPath = r105;
        this.mAlbumName = r106;
        this.mDuration = r107;
        this.mCanBackgroundPlay = r108;
        this.mEventData = r110;
        this.mPlayModel = r111;
    }

    public /* synthetic */ XAudioSrc(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Long r210, Boolean r211, Map r212, PlayModel r213, int r214, DefaultConstructorMarker r215) {
        String r100 = "";
        if ((r214 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r214 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Long r107 = 0L;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Boolean r108 = Boolean.FALSE;
    L38:
        PlayModel r117 = null;
        if ((r214 & 512) == 0) goto L41;
        Map r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r117 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r100, r107, r108, r118, r117);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r108 = r211;
        goto L38
    L33:
        r107 = r210;
        goto L35
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
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
