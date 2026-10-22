package com.bytedance.android.shopping.sku.params.schema;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuCustomParams;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaMapParam;", "()V", "adLogData", "", "getAdLogData", "()Ljava/util/Map;", "cpsTrack", "", "getCpsTrack", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuCustomParams extends SkuSchemaMapParam {
    public SkuCustomParams() {
        super("custom_params");
    }

    public final Map<?, ?> getAdLogData() {
        Object r0 = getMap().get("ad_params");
        if ((r0 instanceof Map) == true) goto L6;
        r0 = null;
    L6:
        return (Map) r0;
    }

    public final String getCpsTrack() {
        Object r0 = getMap().get("cps_params");
        Object r2 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map r1 = (Map) r0;
        if (r1 == null) goto L8;
        Object r3 = r1.get("cps_track");
    L10:
        if ((r3 instanceof String) == false) goto L14;
        r2 = r3;
    L14:
        return (String) r2;
    L8:
        r3 = null;
        goto L10
    }
}
