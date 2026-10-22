package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopBrandModuleInfo;", "Ljava/io/Serializable;", "()V", "moduleList", "", "Lcom/bytedance/android/shopping/store/home/entity/ECShopBrandHeaderModule;", "getModuleList", "()Ljava/util/List;", "setModuleList", "(Ljava/util/List;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopBrandModuleInfo implements Serializable {

    @SerializedName("module_list")
    private List<ECShopBrandHeaderModule> moduleList;

    public ECShopBrandModuleInfo() {
    }

    public final List<ECShopBrandHeaderModule> getModuleList() {
        return this.moduleList;
    }

    public final void setModuleList(List<ECShopBrandHeaderModule> r1) {
        this.moduleList = r1;
    }
}
