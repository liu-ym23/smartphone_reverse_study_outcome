package com.bytedance.lark.lark_markdown_render_android;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInlines;", "", "items", "", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInline;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "component1", "copy", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/MovableRenderUrlPreviewInlines;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MovableRenderUrlPreviewInlines {
    private List<MovableRenderUrlPreviewInline> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MovableRenderUrlPreviewInlines copy$default(MovableRenderUrlPreviewInlines r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.items;
    L6:
        return r100.copy(r101);
    }

    public final List<MovableRenderUrlPreviewInline> component1() {
        return this.items;
    }

    public final MovableRenderUrlPreviewInlines copy(List<MovableRenderUrlPreviewInline> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        return new MovableRenderUrlPreviewInlines(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MovableRenderUrlPreviewInlines) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.items, ((MovableRenderUrlPreviewInlines) r100).items) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "MovableRenderUrlPreviewInlines(items=" + this.items + ')';
    }

    public final lark_markdown_render.proto.MovableRenderUrlPreviewInlines into() {
        List<MovableRenderUrlPreviewInline> r100 = this.items;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(((MovableRenderUrlPreviewInline) r102.next()).into());
        goto L4
    L7:
        return new lark_markdown_render.proto.MovableRenderUrlPreviewInlines(r101);
    }

    public final List<MovableRenderUrlPreviewInline> getItems() {
        return this.items;
    }

    public MovableRenderUrlPreviewInlines(List<MovableRenderUrlPreviewInline> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.items = r100;
    }

    public final void setItems(List<MovableRenderUrlPreviewInline> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.items = r100;
    }
}
