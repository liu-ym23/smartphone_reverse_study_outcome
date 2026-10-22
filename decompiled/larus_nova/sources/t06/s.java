package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lt06/s;", "", "", "pattern", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "blockEntryList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("block_entry_list")
    private final List<String> blockEntryList;

    @SerializedName("pattern")
    private final String pattern;

    public s() {
        this.pattern = null;
        this.blockEntryList = null;
    }

    public final List<String> a() {
        return this.blockEntryList;
    }

    public final String b() {
        return this.pattern;
    }
}
