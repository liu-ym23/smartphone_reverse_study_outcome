package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ServiceEntryInfo;", "Ljava/io/Serializable;", "()V", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "shouldShowInNavbar", "", "getShouldShowInNavbar", "()I", "setShouldShowInNavbar", "(I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ServiceEntryInfo implements Serializable {

    @SerializedName("service_entry_icon")
    private ECUrlModel icon;

    @SerializedName("service_entry_schema")
    private String schema;

    @SerializedName("should_show_in_navbar")
    private int shouldShowInNavbar;

    public ServiceEntryInfo() {
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final int getShouldShowInNavbar() {
        return this.shouldShowInNavbar;
    }

    public final void setIcon(ECUrlModel r1) {
        this.icon = r1;
    }

    public final void setSchema(String r1) {
        this.schema = r1;
    }

    public final void setShouldShowInNavbar(int r1) {
        this.shouldShowInNavbar = r1;
    }
}
