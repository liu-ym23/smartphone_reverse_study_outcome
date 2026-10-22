package w20;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lw20/kc;", "", "", "categoryKey", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setCategoryKey", "(Ljava/lang/String;)V", "subCategoryKey", "e", "setSubCategoryKey", "effectID", "b", "setEffectID", "", "shouldScrollToEffect", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setShouldScrollToEffect", "(Ljava/lang/Boolean;)V", "shouldSelectEffect", "d", "setShouldSelectEffect", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class kc {

    @SerializedName("categoryKey")
    private String categoryKey;

    @SerializedName("effectID")
    private String effectID;

    @SerializedName("shouldScrollToEffect")
    private Boolean shouldScrollToEffect;

    @SerializedName("shouldSelectEffect")
    private Boolean shouldSelectEffect;

    @SerializedName("subCategoryKey")
    private String subCategoryKey;

    public kc() {
    }

    public final String a() {
        return this.categoryKey;
    }

    public final String b() {
        return this.effectID;
    }

    public final Boolean c() {
        return this.shouldScrollToEffect;
    }

    public final Boolean d() {
        return this.shouldSelectEffect;
    }

    public final String e() {
        return this.subCategoryKey;
    }
}
