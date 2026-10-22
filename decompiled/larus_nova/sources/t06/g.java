package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lt06/g;", "Lt06/a;", "", "blockAll", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "", "whiteList", "Ljava/util/List;", "c", "()Ljava/util/List;", "blackList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class g extends a {

    @SerializedName("blacklist")
    private final List<String> blackList;

    @SerializedName("block_all")
    private final Boolean blockAll;

    @SerializedName("whitelist")
    private final List<String> whiteList;

    public g() {
    }

    public final List<String> a() {
        return this.blackList;
    }

    public final Boolean b() {
        return this.blockAll;
    }

    public final List<String> c() {
        return this.whiteList;
    }
}
