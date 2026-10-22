package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lw20/y8;", "", "Lcom/google/gson/JsonObject;", "durationTrackExtra", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "setDurationTrackExtra", "(Lcom/google/gson/JsonObject;)V", "", "needAnimation", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setNeedAnimation", "(Ljava/lang/Boolean;)V", "isAnchorIntroduce", "c", "setAnchorIntroduce", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y8 {

    @SerializedName("durationTrackExtra")
    private JsonObject durationTrackExtra;

    @SerializedName("isAnchorIntroduce")
    private Boolean isAnchorIntroduce;

    @SerializedName("needAnimation")
    private Boolean needAnimation;

    public y8() {
    }

    public final JsonObject a() {
        return this.durationTrackExtra;
    }

    public final Boolean b() {
        return this.needAnimation;
    }

    public final Boolean c() {
        return this.isAnchorIntroduce;
    }
}
