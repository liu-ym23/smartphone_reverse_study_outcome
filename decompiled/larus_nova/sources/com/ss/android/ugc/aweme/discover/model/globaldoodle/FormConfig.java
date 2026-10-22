package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FormConfig;", "Ljava/io/Serializable;", "()V", "items", "", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FormItem;", "getItems", "()Ljava/util/List;", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FormConfig implements Serializable {

    @SerializedName("items")
    private final List<FormItem> items;

    public FormConfig() {
    }

    public final List<FormItem> getItems() {
        return this.items;
    }
}
