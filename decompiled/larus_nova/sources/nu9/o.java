package nu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/settings/provider/dora/DoraXLinkCommonConfig;", "", "<init>", "()V", "android", "Lcom/larus/settings/provider/dora/AndroidConfig;", "getAndroid", "()Lcom/larus/settings/provider/dora/AndroidConfig;", "setAndroid", "(Lcom/larus/settings/provider/dora/AndroidConfig;)V", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: android, reason: collision with root package name */
    @SerializedName("Android")
    private a f520612android;

    public o() {
    }

    public final a a() {
        return this.f520612android;
    }

    public final void b(a r100) {
        this.f520612android = r100;
    }
}
