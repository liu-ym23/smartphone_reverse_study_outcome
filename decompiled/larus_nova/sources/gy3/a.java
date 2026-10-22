package gy3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006!"}, d2 = {"Lgy3/a;", "", "", "riskText", "Ljava/lang/String;", "getRiskText", "()Ljava/lang/String;", "setRiskText", "(Ljava/lang/String;)V", "", "display", "I", "getDisplay", "()I", "setDisplay", "(I)V", "colorType", "getColorType", "setColorType", "iconLightUri", "getIconLightUri", "setIconLightUri", "iconDarkUri", "getIconDarkUri", "setIconDarkUri", "jumpUrl", "getJumpUrl", "setJumpUrl", "sceneId", "getSceneId", "setSceneId", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("risk_color_type")
    private int colorType;

    @SerializedName("risk_display")
    private int display;

    @SerializedName("risk_icon_dark")
    private String iconDarkUri;

    @SerializedName("risk_icon_light")
    private String iconLightUri;

    @SerializedName("risk_url")
    private String jumpUrl;

    @SerializedName("risk_text")
    private String riskText;

    @SerializedName("risk_scene_id")
    private int sceneId;

    public a() {
        this.riskText = "";
        this.display = -1;
        this.iconLightUri = "";
        this.iconDarkUri = "";
        this.jumpUrl = "";
    }
}
