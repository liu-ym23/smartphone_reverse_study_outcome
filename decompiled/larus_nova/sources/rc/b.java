package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR2\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lrc/b;", "", "", "Lrc/j;", "rules", "[Lrc/j;", "getRules", "()[Lrc/j;", "setRules", "([Lrc/j;)V", "Ljava/util/ArrayList;", "Lrc/n;", "Lkotlin/collections/ArrayList;", "pageControl", "Ljava/util/ArrayList;", "getPageControl", "()Ljava/util/ArrayList;", "setPageControl", "(Ljava/util/ArrayList;)V", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class b {

    @SerializedName("page_controls")
    private ArrayList<n> pageControl;

    @SerializedName("rules")
    private j[] rules;

    public b() {
        this.rules = new j[0];
        this.pageControl = new ArrayList();
    }
}
