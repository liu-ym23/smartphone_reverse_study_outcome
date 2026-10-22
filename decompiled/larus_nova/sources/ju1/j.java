package ju1;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lju1/j;", "Lju1/a;", "", "Lju1/i;", "rules", "Ljava/util/List;", ce.f26395j, "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "", "defaultValueString", "Ljava/lang/String;", "getDefaultValueString", "()Ljava/lang/String;", "setDefaultValueString", "(Ljava/lang/String;)V", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j extends a {

    @SerializedName("default_value_str")
    private String defaultValueString;

    @SerializedName("rules")
    private List<i> rules;

    @Override // ju1.h
    public final String d() {
        return "NormalRuleStrategy";
    }

    public j() {
        this.rules = new ArrayList();
    }

    public final List<i> j() {
        return this.rules;
    }
}
