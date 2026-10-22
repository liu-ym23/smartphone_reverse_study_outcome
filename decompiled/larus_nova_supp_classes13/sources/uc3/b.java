package uc3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Luc3/b;", "", "", "bizCode", "Ljava/lang/String;", "getBizCode", "()Ljava/lang/String;", "setBizCode", "(Ljava/lang/String;)V", "sceneCode", "getSceneCode", "setSceneCode", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("biz_code")
    private String bizCode;

    @SerializedName("scene_code")
    private String sceneCode;

    public b() {
        this(null, null);
    }

    public b(String r1, String r2) {
        this.bizCode = r1;
        this.sceneCode = r2;
    }
}
