package com.bytedance.ee.bear.list.list;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/list/list/BaseListItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/bytedance/ee/bear/list/dto/Document;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areContentsTheSame", "", "oldItemPosition", "newItemPosition", "areItemsTheSame", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseListItemDiffCallback extends DiffUtil.Callback {
    public final List<Document> a;
    public final List<Document> b;

    public final int getNewListSize() {
        List<Document> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final int getOldListSize() {
        List<Document> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseListItemDiffCallback(List<? extends Document> r1, List<? extends Document> r2) {
        this.a = r1;
        this.b = r2;
    }

    public boolean areContentsTheSame(int r8, int r9) {
        List<Document> r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L104;
        List<Document> r2 = this.b;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L104;
        Document r10 = (Document) ListProtector.get(this.a, r8);
        Document r11 = (Document) ListProtector.get(this.b, r9);
        if (Intrinsics.areEqual(r10.a, r11.a) == true) goto L22;
    L102:
        return false;
    L22:
        if (r10.getType() != r11.getType()) goto L102;
        if (Intrinsics.areEqual(r10.F, r11.F) == false) goto L102;
        if (r10.G != r11.G) goto L102;
        if (r10.L != r11.L) goto L102;
        if (r10.z != r11.z) goto L102;
        if (r10.A != r11.A) goto L102;
        if (r10.B != r11.B) goto L102;
        if (r10.L1 != r11.L1) goto L102;
        if (Intrinsics.areEqual(r10.p, r11.p) == false) goto L102;
        if (Intrinsics.areEqual(r10.k1.a, r11.k1.a) == false) goto L102;
        Document.DocumentIcon r4 = r10.k1;
        int r5 = r4.b;
        Document.DocumentIcon r6 = r11.k1;
        if (r5 != r6.b) goto L102;
        if (Intrinsics.areEqual(r4.c, r6.c) == false) goto L102;
        if (Intrinsics.areEqual(r10.i, r11.i) == false) goto L102;
        if (Intrinsics.areEqual(r10.j, r11.j) == false) goto L102;
        if (r10.z != r11.z) goto L102;
        if (r10.x != r11.x) goto L102;
        if (Intrinsics.areEqual(r10.q, r11.q) == false) goto L102;
        if (Intrinsics.areEqual(r10.H, r11.H) == false) goto L102;
        if (Intrinsics.areEqual(r10.I, r11.I) == false) goto L102;
        if (Intrinsics.areEqual(r10.J, r11.J) == false) goto L102;
        if (r10.K != r11.K) goto L102;
        if (Intrinsics.areEqual(r10.V0, r11.V0) == false) goto L102;
        if (r10.h1 != r11.h1) goto L102;
        if (Intrinsics.areEqual(r10.b1, r11.b1) == false) goto L102;
        if (Intrinsics.areEqual(r10.g1, r11.g1) == false) goto L102;
        if (Intrinsics.areEqual(r10.x1, r11.x1) == false) goto L102;
        if (r10.v != r11.v) goto L102;
        if (r10.p0 != r11.p0) goto L102;
        if (r10.H0 != r11.H0) goto L102;
        if (r10.w != r11.w) goto L102;
        if (Intrinsics.areEqual(r10.a(), r11.a()) == false) goto L102;
        if (Intrinsics.areEqual(r10.T1, r11.T1) == false) goto L102;
        if (r10.V1 != r11.V1) goto L102;
        if (r10.g2 != r11.g2) goto L102;
        if (r10.h2 != r11.h2) goto L102;
        if (Intrinsics.areEqual(r10.p2, r11.p2) == false) goto L102;
        if (r10.y2 != r11.y2) goto L102;
        if (Intrinsics.areEqual(r10.E2, r11.E2) == false) goto L102;
        if (r10.y != r11.y) goto L102;
        if (Intrinsics.areEqual(r10.F2, r11.F2) == false) goto L102;
        return true;
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
    L104:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean areItemsTheSame(int r4, int r5) {
        List<Document> r0 = this.a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L20;
        List<Document> r3 = this.b;
        if (r3 != null) goto L13;
    L16:
        if (r1 == true) goto L20;
        return Intrinsics.areEqual(((Document) ListProtector.get(this.a, r4)).d, ((Document) ListProtector.get(this.b, r5)).d);
    L13:
        if (r3.isEmpty() == true) goto L16;
        r1 = false;
    L20:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
