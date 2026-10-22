package hu9;

import com.google.gson.annotations.SerializedName;
import com.larus.settings.provider.creation.CreationUpdateDialogItemConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/larus/settings/provider/creation/CreationUpdateDialogConfig;", "", "itemList", "", "Lcom/larus/settings/provider/creation/CreationUpdateDialogItemConfig;", "<init>", "(Ljava/util/List;)V", "getItemList", "()Ljava/util/List;", "setItemList", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s {

    @SerializedName("config_list")
    private List<CreationUpdateDialogItemConfig> itemList;

    public s() {
        this(null);
    }

    public final List<CreationUpdateDialogItemConfig> a() {
        return this.itemList;
    }

    public s(Object r100) {
        this.itemList = CollectionsKt.emptyList();
    }
}
