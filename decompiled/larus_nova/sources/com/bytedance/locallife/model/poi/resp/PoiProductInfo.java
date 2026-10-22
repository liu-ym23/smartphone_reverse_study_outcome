package com.bytedance.locallife.model.poi.resp;

import android.text.TextUtils;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class PoiProductInfo implements Serializable {

    @SerializedName("poi_customer_entry")
    public PoiSpu moreStruct;

    @SerializedName("products")
    public List<PoiProduct> products;

    @SerializedName("display_style")
    public int style;

    @SerializedName("supplier_id")
    public String supplierId;

    @SerializedName("sp_source")
    public String supplierSource;

    @SerializedName("title")
    public String title;

    public PoiProductInfo() {
    }

    public int getSize() {
        List<PoiProduct> r100 = this.products;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return 0;
    L12:
        return this.products.size();
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @AllowImpl
    public boolean isMoreUrlEmpty() {
        PoiSpu r100 = this.moreStruct;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(r100.getUrl()) == true) goto L8;
        return false;
    }

    @AllowImpl
    public boolean isValidStyle() {
        int r100 = this.style;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    @AllowImpl
    public String getMoreUrl() {
        if (isMoreUrlEmpty() == false) goto L6;
        return "";
    L6:
        return this.moreStruct.getUrl();
    }
}
