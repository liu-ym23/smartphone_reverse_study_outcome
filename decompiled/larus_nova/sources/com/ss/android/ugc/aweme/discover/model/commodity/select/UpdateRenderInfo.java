package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/UpdateRenderInfo;", "Ljava/io/Serializable;", "()V", "component", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "getComponent", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "setComponent", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;)V", "path", "", "", "getPath", "()Ljava/util/List;", "setPath", "(Ljava/util/List;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateRenderInfo implements Serializable {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    @SerializedName("component")
    private RenderItem f450562component;

    @SerializedName("path")
    private List<Integer> path;

    public UpdateRenderInfo() {
    }

    public final RenderItem getComponent() {
        return this.f450562component;
    }

    public final List<Integer> getPath() {
        return this.path;
    }

    public final void setComponent(RenderItem r100) {
        this.f450562component = r100;
    }

    public final void setPath(List<Integer> r100) {
        this.path = r100;
    }
}
