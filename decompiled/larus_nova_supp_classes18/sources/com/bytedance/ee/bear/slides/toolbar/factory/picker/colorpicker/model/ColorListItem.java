package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorListItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", ResourceData.KEY_ID, "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "list", "", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorListItem implements NonProguard {
    private String id;
    private List<ColorValueItem> list;

    public ColorListItem() {
    }

    public final String getId() {
        return this.id;
    }

    public final List<ColorValueItem> getList() {
        return this.list;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setList(List<ColorValueItem> r1) {
        this.list = r1;
    }
}
