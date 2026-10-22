package ju1;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lju1/o;", "", "", "expression", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setExpression", "(Ljava/lang/String;)V", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "I", "b", "()I", "setScore", "(I)V", "", "weight", FaceService.girlLabel, "c", "()F", "setWeight", "(F)V", "tag", "getTag", "setTag", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("expression")
    private String expression;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private int score;

    @SerializedName("tag")
    private String tag;

    @SerializedName("weight")
    private float weight;

    public o() {
        this.expression = "";
        this.tag = "";
    }

    public final String a() {
        return this.expression;
    }

    public final int b() {
        return this.score;
    }

    public final float c() {
        return this.weight;
    }
}
