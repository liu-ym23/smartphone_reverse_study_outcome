package r14;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lr14/k;", "", "", "labelName", "Ljava/lang/String;", "getLabelName", "()Ljava/lang/String;", "setLabelName", "(Ljava/lang/String;)V", "bgColor", "getBgColor", "setBgColor", "whiteBgColor", "getWhiteBgColor", "setWhiteBgColor", "textColor", "getTextColor", "setTextColor", "whiteTextColor", "getWhiteTextColor", "setWhiteTextColor", "", "labelType", "I", "getLabelType", "()I", "setLabelType", "(I)V", "", "showSeconds", FaceService.girlLabel, "getShowSeconds", "()F", "setShowSeconds", "(F)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class k {

    @SerializedName("color")
    private String bgColor;

    @SerializedName("text")
    private String labelName;

    @SerializedName("type")
    private int labelType;

    @SerializedName("show_seconds")
    private float showSeconds;

    @SerializedName("color_text")
    private String textColor;

    @SerializedName("white_color")
    private String whiteBgColor;

    @SerializedName("white_color_text")
    private String whiteTextColor;

    public k() {
    }
}
