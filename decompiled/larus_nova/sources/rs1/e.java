package rs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000f¨\u0006'"}, d2 = {"Lrs1/e;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "levelGoldIcon", "Ljava/lang/String;", "getLevelGoldIcon", "()Ljava/lang/String;", "setLevelGoldIcon", "(Ljava/lang/String;)V", "levelSliverIcon", "getLevelSliverIcon", "setLevelSliverIcon", "levelGoldAnim", "getLevelGoldAnim", "setLevelGoldAnim", "levelSliverAnim", "getLevelSliverAnim", "setLevelSliverAnim", "levelRedIcon", "getLevelRedIcon", "setLevelRedIcon", "levelBlueIcon", "getLevelBlueIcon", "setLevelBlueIcon", "levelGoldEffectName", "getLevelGoldEffectName", "setLevelGoldEffectName", "levelSliverEffectName", "getLevelSliverEffectName", "setLevelSliverEffectName", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("level_blue_icon")
    private String levelBlueIcon;

    @SerializedName("level_gold_anim")
    private String levelGoldAnim;

    @SerializedName("level_gold_effect_name")
    private String levelGoldEffectName;

    @SerializedName("level_gold_icon")
    private String levelGoldIcon;

    @SerializedName("level_red_icon")
    private String levelRedIcon;

    @SerializedName("level_sliver_anim")
    private String levelSliverAnim;

    @SerializedName("level_sliver_effect_name")
    private String levelSliverEffectName;

    @SerializedName("level_sliver_icon")
    private String levelSliverIcon;

    public e() {
        this.enable = true;
        this.levelGoldIcon = "";
        this.levelSliverIcon = "";
        this.levelGoldAnim = "";
        this.levelSliverAnim = "";
        this.levelRedIcon = "";
        this.levelBlueIcon = "";
        this.levelGoldEffectName = "";
        this.levelSliverEffectName = "";
    }
}
