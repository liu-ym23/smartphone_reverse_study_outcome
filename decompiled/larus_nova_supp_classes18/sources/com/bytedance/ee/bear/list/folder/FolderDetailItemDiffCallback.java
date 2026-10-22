package com.bytedance.ee.bear.list.folder;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.BaseListItemDiffCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/list/folder/FolderDetailItemDiffCallback;", "Lcom/bytedance/ee/bear/list/list/BaseListItemDiffCallback;", "oldList", "", "Lcom/bytedance/ee/bear/list/dto/Document;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderDetailItemDiffCallback extends BaseListItemDiffCallback {
    public final List<Document> c;
    public final List<Document> d;

    /* JADX WARN: Multi-variable type inference failed */
    public FolderDetailItemDiffCallback(List<? extends Document> r1, List<? extends Document> r2) {
        super(r1, r2);
        this.c = r1;
        this.d = r2;
    }

    @Override // com.bytedance.ee.bear.list.list.BaseListItemDiffCallback
    public final boolean areContentsTheSame(int r5, int r6) {
        List<Document> r0 = this.c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L40;
        List<Document> r2 = this.d;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L40;
        Document r4 = (Document) ListProtector.get(this.c, r5);
        Document r7 = (Document) ListProtector.get(this.d, r6);
        if (super.areContentsTheSame(r5, r6) == true) goto L22;
    L38:
        return false;
    L22:
        if (r4.n != r7.n) goto L38;
        if (Intrinsics.areEqual(r4.m, r7.m) == false) goto L38;
        if (r4.p1 != r7.p1) goto L38;
        if (r4.v1 != r7.v1) goto L38;
        if (r4.P1 != r7.P1) goto L38;
        if (r4.M1 != r7.M1) goto L38;
        if (r4.U != r7.U) goto L38;
        if (Intrinsics.areEqual(r4.c, r7.c) == false) goto L38;
        return true;
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
    L40:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
