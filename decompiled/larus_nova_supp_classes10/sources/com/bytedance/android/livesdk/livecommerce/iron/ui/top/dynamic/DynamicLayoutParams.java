package com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/dynamic/DynamicLayoutParams;", "Ljava/io/Serializable;", "()V", "elements", "", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/dynamic/DynamicElementLayoutParams;", "getElements", "()Ljava/util/List;", "layoutHeight", "", "getLayoutHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "style", "getStyle", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicLayoutParams implements Serializable {

    @SerializedName("elements")
    private final List<DynamicElementLayoutParams> elements;

    @SerializedName("layout_height")
    private final Integer layoutHeight;

    @SerializedName("style")
    private final Integer style;

    public DynamicLayoutParams() {
    }

    public final List<DynamicElementLayoutParams> getElements() {
        return this.elements;
    }

    public final Integer getLayoutHeight() {
        return this.layoutHeight;
    }

    public final Integer getStyle() {
        return this.style;
    }
}
