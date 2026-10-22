package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", "", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorSelectedItem;", "getValue", "()Ljava/util/List;", "setValue", "(Ljava/util/List;)V", "children", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorListItem;", "getChildren", "setChildren", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorData implements NonProguard {

    @SerializedName("children")
    private List<ColorListItem> children;

    @SerializedName("value")
    private List<ColorSelectedItem> value;

    public ColorData() {
    }

    public final List<ColorListItem> getChildren() {
        return this.children;
    }

    public final List<ColorSelectedItem> getValue() {
        return this.value;
    }

    public final void setChildren(List<ColorListItem> r1) {
        this.children = r1;
    }

    public final void setValue(List<ColorSelectedItem> r1) {
        this.value = r1;
    }
}
