package vt9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/settings/provider/audio/SelectVoiceModeConfig;", "", "newStyleEnable", "", "selectVoiceMode", "", "voiceMixFilterEnable", "supportMixLanguage", "", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)V", "getNewStyleEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelectVoiceMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVoiceMixFilterEnable", "getSupportMixLanguage", "()Ljava/util/List;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class x0 {

    @SerializedName("voice_new_style_enable")
    private final Boolean newStyleEnable;

    @SerializedName("edit_voice_mode")
    private final Integer selectVoiceMode;

    @SerializedName("support_mix_language")
    private final List<String> supportMixLanguage;

    @SerializedName("voice_mix_filter_enable")
    private final Boolean voiceMixFilterEnable;

    public x0() {
        this(0);
    }

    public final Boolean a() {
        return this.newStyleEnable;
    }

    public final Integer b() {
        return this.selectVoiceMode;
    }

    public final List<String> c() {
        return this.supportMixLanguage;
    }

    public final Boolean d() {
        return this.voiceMixFilterEnable;
    }

    public /* synthetic */ x0(int r100) {
        Boolean r101 = Boolean.FALSE;
        this(r101, 0, r101, CollectionsKt.emptyList());
    }

    public x0(Boolean r100, Integer r101, Boolean r102, List<String> r103) {
        this.newStyleEnable = r100;
        this.selectVoiceMode = r101;
        this.voiceMixFilterEnable = r102;
        this.supportMixLanguage = r103;
    }
}
