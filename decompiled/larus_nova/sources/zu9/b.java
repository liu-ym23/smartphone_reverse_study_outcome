package zu9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/settings/provider/loadiing/ProgressLoadingSpeedConfig;", "", "<init>", "()V", "imageProgress", "", "Lcom/larus/settings/provider/loadiing/LoadingSpeedConfig;", "getImageProgress", "()Ljava/util/List;", "botCreateAvatarProgress", "getBotCreateAvatarProgress", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("bot_create_avatar_progress")
    private final List<a> botCreateAvatarProgress;

    @SerializedName("image_progress")
    private final List<a> imageProgress;

    public b() {
    }
}
