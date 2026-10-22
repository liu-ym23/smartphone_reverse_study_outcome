package pp2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lpp2/d;", "", "", "showVerticalRank", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setShowVerticalRank", "(Ljava/lang/Boolean;)V", "showGlobalRank", "b", "setShowGlobalRank", "firstLoad", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setFirstLoad", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("firstLoad")
    private Boolean firstLoad;

    @SerializedName("showGlobalRank")
    private Boolean showGlobalRank;

    @SerializedName("showVerticalRank")
    private Boolean showVerticalRank;

    public d() {
    }

    public final Boolean a() {
        return this.firstLoad;
    }

    public final Boolean b() {
        return this.showGlobalRank;
    }

    public final Boolean c() {
        return this.showVerticalRank;
    }
}
