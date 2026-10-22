package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontItem;", "getValue", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontItem;", "setValue", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontItem;)V", "children", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontData implements NonProguard {

    @SerializedName("children")
    private List<FontItem> children;

    @SerializedName("value")
    private FontItem value;

    public FontData() {
    }

    public final List<FontItem> getChildren() {
        return this.children;
    }

    public final FontItem getValue() {
        return this.value;
    }

    public final void setChildren(List<FontItem> r100) {
        this.children = r100;
    }

    public final void setValue(FontItem r100) {
        this.value = r100;
    }
}
