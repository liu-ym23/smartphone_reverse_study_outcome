package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorSelectedItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "value", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "getValue", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "setValue", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;)V", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorSelectedItem implements NonProguard {

    @SerializedName("key")
    private String key;

    @SerializedName("value")
    private ColorValueItem value;

    public ColorSelectedItem() {
    }

    public final String getKey() {
        return this.key;
    }

    public final ColorValueItem getValue() {
        return this.value;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setValue(ColorValueItem r100) {
        this.value = r100;
    }
}
