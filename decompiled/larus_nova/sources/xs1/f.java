package xs1;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lxs1/f;", "", "", "lowScoreDegradeScore", FaceService.girlLabel, "getLowScoreDegradeScore", "()F", "setLowScoreDegradeScore", "(F)V", "", "dynamicDegradeEnable", "Z", "getDynamicDegradeEnable", "()Z", "setDynamicDegradeEnable", "(Z)V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("dynamic_degrade")
    private boolean dynamicDegradeEnable;

    @SerializedName("low_score_degrade")
    private float lowScoreDegradeScore;

    public f() {
        this.dynamicDegradeEnable = true;
    }
}
