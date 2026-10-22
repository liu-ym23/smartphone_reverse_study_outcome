package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00120\tj\b\u0012\u0004\u0012\u00020\u0012`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lrc/a;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "Ljava/util/ArrayList;", "Lrc/i;", "Lkotlin/collections/ArrayList;", "models", "Ljava/util/ArrayList;", "getModels", "()Ljava/util/ArrayList;", "setModels", "(Ljava/util/ArrayList;)V", "Lrc/m;", "pageControl", "getPageControl", "setPageControl", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class a {

    @SerializedName("bst_enable")
    private boolean enable;

    @SerializedName("models")
    private ArrayList<i> models;

    @SerializedName("page_control")
    private ArrayList<m> pageControl;

    @SerializedName("bst_tag")
    private String tag;

    public a() {
        this.models = new ArrayList();
        this.pageControl = new ArrayList();
        this.tag = "";
    }
}
