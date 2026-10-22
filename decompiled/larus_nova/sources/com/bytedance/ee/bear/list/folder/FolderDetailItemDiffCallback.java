package com.bytedance.ee.bear.list.folder;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.BaseListItemDiffCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/list/folder/FolderDetailItemDiffCallback;", "Lcom/bytedance/ee/bear/list/list/BaseListItemDiffCallback;", "oldList", "", "Lcom/bytedance/ee/bear/list/dto/Document;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderDetailItemDiffCallback extends BaseListItemDiffCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Document> f227964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Document> f227965d;

    /* JADX WARN: Multi-variable type inference failed */
    public FolderDetailItemDiffCallback(List<? extends Document> r100, List<? extends Document> r101) {
        super(r100, r101);
        this.f227964c = r100;
        this.f227965d = r101;
    }

    @Override // com.bytedance.ee.bear.list.list.BaseListItemDiffCallback, androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        List<Document> r102 = this.f227964c;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L40;
        List<Document> r104 = this.f227965d;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L40;
        Document r106 = (Document) ListProtector.get(this.f227964c, r100);
        Document r107 = (Document) ListProtector.get(this.f227965d, r101);
        if (super.areContentsTheSame(r100, r101) == true) goto L22;
    L38:
        return false;
    L22:
        if (r106.f227889n != r107.f227889n) goto L38;
        if (Intrinsics.areEqual(r106.f227888m, r107.f227888m) == false) goto L38;
        if (r106.f227893p1 != r107.f227893p1) goto L38;
        if (r106.f227901v1 != r107.f227901v1) goto L38;
        if (r106.P1 != r107.P1) goto L38;
        if (r106.M1 != r107.M1) goto L38;
        if (r106.U != r107.U) goto L38;
        if (Intrinsics.areEqual(r106.f227872c, r107.f227872c) == false) goto L38;
        return true;
    L13:
        if (r104.isEmpty() == true) goto L16;
        r105 = false;
    L40:
        return false;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
