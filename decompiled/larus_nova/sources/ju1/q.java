package ju1;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lju1/q;", "Lju1/a;", "", "Lju1/o;", "rules", "Ljava/util/List;", ce.f26395j, "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "Lju1/p;", "scores", ce.f26396k, "setScores", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q extends a {

    @SerializedName("rules")
    private List<o> rules;

    @SerializedName("scores")
    private List<p> scores;

    @Override // ju1.h
    public final String d() {
        return "WeightRuleStrategy";
    }

    public q() {
        this.rules = new ArrayList();
        this.scores = new ArrayList();
    }

    public final List<o> j() {
        return this.rules;
    }

    public final List<p> k() {
        return this.scores;
    }
}
