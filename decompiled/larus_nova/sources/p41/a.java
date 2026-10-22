package p41;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018¨\u0006$"}, d2 = {"Lp41/a;", "", "", "", "", "rotationConfig", "Ljava/util/Map;", "getRotationConfig", "()Ljava/util/Map;", "setRotationConfig", "(Ljava/util/Map;)V", "", "liveRevlinkLowlatencyScoreAudience", FaceService.girlLabel, "getLiveRevlinkLowlatencyScoreAudience", "()F", "setLiveRevlinkLowlatencyScoreAudience", "(F)V", "", "liveRevlinkAudienceLinkmicListBackupEnable", "Z", "getLiveRevlinkAudienceLinkmicListBackupEnable", "()Z", "setLiveRevlinkAudienceLinkmicListBackupEnable", "(Z)V", "livePkMixGameVideoStreamDefaultEnable", "getLivePkMixGameVideoStreamDefaultEnable", "setLivePkMixGameVideoStreamDefaultEnable", "livePkGameSupportServerMixDefaultEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setLivePkGameSupportServerMixDefaultEnable", "livePkGameSupportIgnoreLossAudioFocusEnable", "getLivePkGameSupportIgnoreLossAudioFocusEnable", "setLivePkGameSupportIgnoreLossAudioFocusEnable", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("live_pk_game_support_ignore_loss_audio_focus_enable")
    private boolean livePkGameSupportIgnoreLossAudioFocusEnable;

    @SerializedName("live_pk_game_support_server_mix_default_enable")
    private boolean livePkGameSupportServerMixDefaultEnable;

    @SerializedName("live_pk_mix_game_video_stream_default_enable")
    private boolean livePkMixGameVideoStreamDefaultEnable;

    @SerializedName("live_revlink_audience_linkmic_list_backup_enable")
    private boolean liveRevlinkAudienceLinkmicListBackupEnable;

    @SerializedName("live_revlink_lowlatency_score_audience")
    private float liveRevlinkLowlatencyScoreAudience;

    @SerializedName("live_rev_link_game_rotation")
    private Map<String, Integer> rotationConfig;

    public a() {
        this.rotationConfig = new HashMap();
        this.liveRevlinkLowlatencyScoreAudience = 8.0f;
        this.liveRevlinkAudienceLinkmicListBackupEnable = true;
        this.livePkMixGameVideoStreamDefaultEnable = true;
        this.livePkGameSupportServerMixDefaultEnable = true;
        this.livePkGameSupportIgnoreLossAudioFocusEnable = true;
    }

    public final boolean a() {
        return this.livePkGameSupportServerMixDefaultEnable;
    }
}
