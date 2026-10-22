package ut9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/settings/provider/applet/FirstPartyRecordConfig;", "", "enableRecordOgg", "", "<init>", "(Z)V", "getEnableRecordOgg", "()Z", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("enable_record_ogg")
    private final boolean enableRecordOgg;

    public c() {
        this(0);
    }

    public final boolean a() {
        return this.enableRecordOgg;
    }

    public c(int r100) {
        this.enableRecordOgg = false;
    }
}
