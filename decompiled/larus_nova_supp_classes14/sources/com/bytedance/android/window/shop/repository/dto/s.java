package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/s;", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "", "", "renderDataGroup", "Ljava/util/Map;", "U", "()Ljava/util/Map;", "", "Lmo/a;", "dynamicEventGroup", "T", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s extends WindowV2ProductItemDTO {

    @SerializedName("dynamic_event_data_group")
    private final Map<String, List<mo.a>> dynamicEventGroup;

    @SerializedName("dynamic_render_data_group")
    private final Map<String, String> renderDataGroup;

    public s() {
        super(null);
    }

    public final Map<String, List<mo.a>> T() {
        return this.dynamicEventGroup;
    }

    public final Map<String, String> U() {
        return this.renderDataGroup;
    }
}
