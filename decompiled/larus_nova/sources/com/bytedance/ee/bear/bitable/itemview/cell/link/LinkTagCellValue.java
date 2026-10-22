package com.bytedance.ee.bear.bitable.itemview.cell.link;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagCellValue;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTableCellValue;", "<init>", "()V", "tagList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagItem;", "Lkotlin/collections/ArrayList;", "getTagList", "()Ljava/util/ArrayList;", "setTagList", "(Ljava/util/ArrayList;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkTagCellValue extends LinkTableCellValue {
    private ArrayList<LinkTagItem> tagList;

    public LinkTagCellValue() {
        this.tagList = new ArrayList();
    }

    public final ArrayList<LinkTagItem> getTagList() {
        return this.tagList;
    }

    public final void setTagList(ArrayList<LinkTagItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tagList = r100;
    }
}
