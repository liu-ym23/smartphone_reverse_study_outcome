package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/HorizontalContainer;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "paddingHorizontal", "", "getPaddingHorizontal", "()Ljava/lang/Integer;", "setPaddingHorizontal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "renderList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderItemKey;", "Lkotlin/collections/ArrayList;", "getRenderList", "()Ljava/util/ArrayList;", "setRenderList", "(Ljava/util/ArrayList;)V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "mode", "getMode", "setMode", "getHorizontalContainerMode", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/HorizontalContainerMode;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalContainer implements NonProguard {
    private String color;
    private Integer mode;
    private Integer paddingHorizontal;
    private ArrayList<RenderItemKey> renderList;

    public final HorizontalContainerMode getHorizontalContainerMode() {
        HorizontalContainerMode.a r100 = HorizontalContainerMode.Companion;
        Integer r101 = this.mode;
        r100.getClass();
        HorizontalContainerMode[] r102 = HorizontalContainerMode.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        HorizontalContainerMode r105 = r102[r104];
        int r106 = HorizontalContainerMode.access$getValue$p(r105);
        if (r101 != null) goto L8;
    L10:
        boolean r107 = false;
    L11:
        if (r107 == true) goto L15;
        r104 = r104 + 1;
    L15:
        if (r105 == null) goto L17;
        return r105;
    L17:
        return HorizontalContainerMode.COMPACT;
    L8:
        if (r106 != r101.intValue()) goto L10;
        r107 = true;
        goto L11
    L14:
        r105 = null;
        goto L15
    }

    public HorizontalContainer() {
        this.paddingHorizontal = 12;
        this.renderList = new ArrayList();
        this.mode = 0;
    }

    public final String getColor() {
        return this.color;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final Integer getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final ArrayList<RenderItemKey> getRenderList() {
        return this.renderList;
    }

    public final void setColor(String r100) {
        this.color = r100;
    }

    public final void setMode(Integer r100) {
        this.mode = r100;
    }

    public final void setPaddingHorizontal(Integer r100) {
        this.paddingHorizontal = r100;
    }

    public final void setRenderList(ArrayList<RenderItemKey> r100) {
        this.renderList = r100;
    }
}
