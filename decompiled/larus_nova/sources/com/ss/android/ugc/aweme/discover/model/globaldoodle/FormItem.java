package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FormItem;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "key", "getKey", "options", "", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/Option;", "getOptions", "()Ljava/util/List;", "title", "getTitle", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FormItem implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f450567id;

    @SerializedName("key")
    private final String key;

    @SerializedName("options")
    private final List<Option> options;

    @SerializedName("title")
    private final String title;

    public FormItem() {
    }

    public final String getId() {
        return this.f450567id;
    }

    public final String getKey() {
        return this.key;
    }

    public final List<Option> getOptions() {
        return this.options;
    }

    public final String getTitle() {
        return this.title;
    }
}
