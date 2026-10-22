package yd3;

import com.bytedance.android.shopping.feed.resourcecard.model.SearchItem;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lyd3/q;", "Lyd3/l;", "Ljava/util/ArrayList;", "Lcom/bytedance/android/shopping/feed/resourcecard/model/SearchItem;", "Lkotlin/collections/ArrayList;", "searchItem", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q extends l {

    @SerializedName("search_item_list")
    private final ArrayList<SearchItem> searchItem;

    public q() {
    }

    public final ArrayList<SearchItem> c() {
        return this.searchItem;
    }
}
