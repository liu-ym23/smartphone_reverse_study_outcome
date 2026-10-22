package tf0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltf0/a;", "", "", "itemId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "", "Ltf0/t;", "groups", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setGroups", "(Ljava/util/List;)V", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("groups")
    private List<t> groups;

    @SerializedName("item_id")
    private String itemId;

    public final String toString() {
        return "AnimationGroup(itemId=" + this.itemId + ", groups=" + this.groups + ')';
    }

    public final List<t> a() {
        return this.groups;
    }

    public final String b() {
        return this.itemId;
    }

    public a(String r100, List<t> r101) {
        this.itemId = r100;
        this.groups = r101;
    }
}
