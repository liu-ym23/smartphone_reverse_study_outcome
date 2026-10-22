package com.bytedance.locallife.model.poi.resp;

import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public class PoiDcdProductItem implements Serializable {
    public String poiId;
    public PoiProductInfo productInfo;

    public String getSpSource() {
        PoiProductInfo r100 = this.productInfo;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.supplierSource;
    }

    public PoiDcdProductItem(PoiProductInfo r100, String r101) {
        this.productInfo = r100;
        this.poiId = r101;
    }
}
