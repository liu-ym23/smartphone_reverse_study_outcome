package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/settings/provider/BotBioEditConfig;", "", "<init>", "()V", "prologueEditable", "", "suggestsEditable", "defaultSuggestSwitch", "bioEditable", "enableAdvance", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class v {

    @SerializedName("bio_editable")
    public final boolean bioEditable;

    @SerializedName("default_suggest_switch")
    public final boolean defaultSuggestSwitch;

    @SerializedName("enable_advance")
    public final boolean enableAdvance;

    @SerializedName("prologue_editable")
    public final boolean prologueEditable;

    @SerializedName("suggests_editable")
    public final boolean suggestsEditable;

    public v() {
        this.prologueEditable = true;
        this.suggestsEditable = true;
        this.defaultSuggestSwitch = true;
        this.bioEditable = true;
        this.enableAdvance = true;
    }
}
