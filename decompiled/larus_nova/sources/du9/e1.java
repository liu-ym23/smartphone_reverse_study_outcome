package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/provider/chat/LatestPhotoShortcutConfig;", "", "mainBotEnabled", "", "ugcBotEnabled", "photoTargetSource", "", "skipAttachment", "showDurationMs", "asLatestDurationMs", "<init>", "(ZZIZII)V", "getMainBotEnabled", "()Z", "getUgcBotEnabled", "getPhotoTargetSource", "()I", "getSkipAttachment", "getShowDurationMs", "getAsLatestDurationMs", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e1 {

    @SerializedName("as_latest_duration_ms")
    private final int asLatestDurationMs;

    @SerializedName("main_bot_enabled")
    private final boolean mainBotEnabled;

    @SerializedName("photo_target_source")
    private final int photoTargetSource;

    @SerializedName("show_duration_ms")
    private final int showDurationMs;

    @SerializedName("skip_attachment")
    private final boolean skipAttachment;

    @SerializedName("ugc_bot_enabled")
    private final boolean ugcBotEnabled;

    public e1() {
        this(0);
    }

    public final int a() {
        return this.asLatestDurationMs;
    }

    public final boolean b() {
        return this.mainBotEnabled;
    }

    public final int c() {
        return this.photoTargetSource;
    }

    public final int d() {
        return this.showDurationMs;
    }

    public final boolean e() {
        return this.skipAttachment;
    }

    public final boolean f() {
        return this.ugcBotEnabled;
    }

    public e1(int r100) {
        this.mainBotEnabled = false;
        this.ugcBotEnabled = false;
        this.photoTargetSource = 0;
        this.skipAttachment = false;
        this.showDurationMs = 3000;
        this.asLatestDurationMs = 20000;
    }
}
