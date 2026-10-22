package w4c;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/settings/PasteProtectMIUIWhiteList;", "", "<init>", "()V", "searchWhiteList", "", "", "getSearchWhiteList", "()Ljava/util/List;", "setSearchWhiteList", "(Ljava/util/List;)V", "shareWhiteList", "getShareWhiteList", "setShareWhiteList", "translateWhiteList", "getTranslateWhiteList", "setTranslateWhiteList", "dialWhiteList", "getDialWhiteList", "setDialWhiteList", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("dial")
    private List<String> dialWhiteList;

    @SerializedName("search")
    private List<String> searchWhiteList;

    @SerializedName("share")
    private List<String> shareWhiteList;

    @SerializedName("translate")
    private List<String> translateWhiteList;

    public d() {
        this.searchWhiteList = CollectionsKt.emptyList();
        this.shareWhiteList = CollectionsKt.emptyList();
        this.translateWhiteList = CollectionsKt.emptyList();
        this.dialWhiteList = CollectionsKt.emptyList();
    }
}
