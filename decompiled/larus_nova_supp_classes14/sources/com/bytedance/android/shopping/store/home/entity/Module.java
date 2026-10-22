package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR,\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/Module;", "Ljava/io/Serializable;", "()V", "data", "", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "materialId", "getMaterialId", "setMaterialId", "moduleExtra", "", "getModuleExtra", "()Ljava/util/Map;", "setModuleExtra", "(Ljava/util/Map;)V", "name", "getName", "setName", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Module implements Serializable {

    @SerializedName("data")
    private String data;

    @SerializedName("material_id")
    private String materialId;

    @SerializedName("module_extra")
    private Map<String, String> moduleExtra;

    @SerializedName("name")
    private String name;

    public Module() {
        this.name = "";
    }

    public final String getData() {
        return this.data;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final Map<String, String> getModuleExtra() {
        return this.moduleExtra;
    }

    public final String getName() {
        return this.name;
    }

    public final void setData(String r1) {
        this.data = r1;
    }

    public final void setMaterialId(String r1) {
        this.materialId = r1;
    }

    public final void setModuleExtra(Map<String, String> r1) {
        this.moduleExtra = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }
}
