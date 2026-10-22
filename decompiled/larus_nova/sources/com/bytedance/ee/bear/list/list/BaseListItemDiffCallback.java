package com.bytedance.ee.bear.list.list;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/list/list/BaseListItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/bytedance/ee/bear/list/dto/Document;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areContentsTheSame", "", "oldItemPosition", "newItemPosition", "areItemsTheSame", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseListItemDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Document> f228451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Document> f228452b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        List<Document> r100 = this.f228452b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        List<Document> r100 = this.f228451a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseListItemDiffCallback(List<? extends Document> r100, List<? extends Document> r101) {
        this.f228451a = r100;
        this.f228452b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int r100, int r101) {
        List<Document> r102 = this.f228451a;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L104;
        List<Document> r104 = this.f228452b;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L104;
        Document r106 = (Document) ListProtector.get(this.f228451a, r100);
        Document r107 = (Document) ListProtector.get(this.f228452b, r101);
        if (Intrinsics.areEqual(r106.f227868a, r107.f227868a) == true) goto L22;
    L102:
        return false;
    L22:
        if (r106.getType() != r107.getType()) goto L102;
        if (Intrinsics.areEqual(r106.F, r107.F) == false) goto L102;
        if (r106.G != r107.G) goto L102;
        if (r106.L != r107.L) goto L102;
        if (r106.f227910z != r107.f227910z) goto L102;
        if (r106.A != r107.A) goto L102;
        if (r106.B != r107.B) goto L102;
        if (r106.L1 != r107.L1) goto L102;
        if (Intrinsics.areEqual(r106.f227891p, r107.f227891p) == false) goto L102;
        if (Intrinsics.areEqual(r106.f227886k1.f227911a, r107.f227886k1.f227911a) == false) goto L102;
        Document.DocumentIcon r108 = r106.f227886k1;
        int r109 = r108.f227912b;
        Document.DocumentIcon r110 = r107.f227886k1;
        if (r109 != r110.f227912b) goto L102;
        if (Intrinsics.areEqual(r108.f227913c, r110.f227913c) == false) goto L102;
        if (Intrinsics.areEqual(r106.f227882i, r107.f227882i) == false) goto L102;
        if (Intrinsics.areEqual(r106.f227883j, r107.f227883j) == false) goto L102;
        if (r106.f227910z != r107.f227910z) goto L102;
        if (r106.f227904x != r107.f227904x) goto L102;
        if (Intrinsics.areEqual(r106.f227895q, r107.f227895q) == false) goto L102;
        if (Intrinsics.areEqual(r106.H, r107.H) == false) goto L102;
        if (Intrinsics.areEqual(r106.I, r107.I) == false) goto L102;
        if (Intrinsics.areEqual(r106.f227867J, r107.f227867J) == false) goto L102;
        if (r106.K != r107.K) goto L102;
        if (Intrinsics.areEqual(r106.V0, r107.V0) == false) goto L102;
        if (r106.f227880h1 != r107.f227880h1) goto L102;
        if (Intrinsics.areEqual(r106.f227870b1, r107.f227870b1) == false) goto L102;
        if (Intrinsics.areEqual(r106.f227877g1, r107.f227877g1) == false) goto L102;
        if (Intrinsics.areEqual(r106.f227905x1, r107.f227905x1) == false) goto L102;
        if (r106.f227900v != r107.f227900v) goto L102;
        if (r106.f227892p0 != r107.f227892p0) goto L102;
        if (r106.H0 != r107.H0) goto L102;
        if (r106.f227903w != r107.f227903w) goto L102;
        if (Intrinsics.areEqual(r106.a(), r107.a()) == false) goto L102;
        if (Intrinsics.areEqual(r106.T1, r107.T1) == false) goto L102;
        if (r106.V1 != r107.V1) goto L102;
        if (r106.f227878g2 != r107.f227878g2) goto L102;
        if (r106.f227881h2 != r107.f227881h2) goto L102;
        if (Intrinsics.areEqual(r106.f227894p2, r107.f227894p2) == false) goto L102;
        if (r106.f227909y2 != r107.f227909y2) goto L102;
        if (Intrinsics.areEqual(r106.E2, r107.E2) == false) goto L102;
        if (r106.f227907y != r107.f227907y) goto L102;
        if (Intrinsics.areEqual(r106.F2, r107.F2) == false) goto L102;
        return true;
    L13:
        if (r104.isEmpty() == true) goto L16;
        r105 = false;
    L104:
        return false;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        List<Document> r102 = this.f228451a;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L20;
        List<Document> r105 = this.f228452b;
        if (r105 != null) goto L13;
    L16:
        if (r103 == true) goto L20;
        return Intrinsics.areEqual(((Document) ListProtector.get(this.f228451a, r100)).f227873d, ((Document) ListProtector.get(this.f228452b, r101)).f227873d);
    L13:
        if (r105.isEmpty() == true) goto L16;
        r103 = false;
    L20:
        return false;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }
}
