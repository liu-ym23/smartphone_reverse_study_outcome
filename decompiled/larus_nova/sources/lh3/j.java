package lh3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Llh3/j;", "", "", "Llh3/g;", "laws", "Ljava/util/List;", "b", "()Ljava/util/List;", "setLaws", "(Ljava/util/List;)V", "Llh3/f;", "lawConfigs", "Llh3/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Llh3/f;", "setLawConfigs", "(Llh3/f;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("law_config")
    private f lawConfigs;

    @SerializedName("law_v2")
    private List<g> laws;

    public static final class a {
    }

    static {
    }

    public j() {
    }

    public final f a() {
        return this.lawConfigs;
    }

    public final List<g> b() {
        return this.laws;
    }
}
