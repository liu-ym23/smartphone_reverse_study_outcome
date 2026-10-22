package vv;

import com.bytedance.android.gamecp.host_api.im.InteractionPlayAuthScene;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lvv/h;", "Lvv/b;", "", "interactionPlayAuthScene", "J", "", "clientKey", "Ljava/lang/String;", "Lvv/t;", "twoElementAgreement", "Lvv/t;", "Lvv/e;", "event_param", "Lvv/e;", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements b {

    @SerializedName("client_key")
    public final String clientKey;

    @SerializedName("event_param")
    public final e event_param;

    @SerializedName("scene")
    public final long interactionPlayAuthScene;

    @SerializedName("two_element_agreement")
    public final t twoElementAgreement;

    public h() {
        this.interactionPlayAuthScene = InteractionPlayAuthScene.InteractionPlayDefaultAuth.getScene();
        this.clientKey = "";
        this.twoElementAgreement = new t(0);
        this.event_param = new e(0);
    }
}
