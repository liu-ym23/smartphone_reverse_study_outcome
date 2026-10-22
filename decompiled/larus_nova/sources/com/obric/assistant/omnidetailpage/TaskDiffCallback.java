package com.obric.assistant.omnidetailpage;

import androidx.recyclerview.widget.DiffUtil;
import ifa.a;
import ifa.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/omnidetailpage/TaskDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskDiffCallback extends DiffUtil.ItemCallback<f> {
    public TaskDiffCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(f r100, f r110) {
        f r101 = r100;
        f r111 = r110;
        Intrinsics.checkNotNullParameter(r101, "oldItem");
        Intrinsics.checkNotNullParameter(r111, "newItem");
        if ((r101 instanceof f.d) == false) goto L10;
        if ((r111 instanceof f.d) == false) goto L10;
        if (Intrinsics.areEqual(((f.d) r101).f489694h, ((f.d) r111).f489694h) == true) goto L10;
        return false;
    L10:
        if ((r101 instanceof f.e) == false) goto L19;
        if ((r111 instanceof f.e) == false) goto L19;
        f.e r102 = (f.e) r101;
        f.e r103 = (f.e) r111;
        if (Intrinsics.areEqual(r102.f489695h, r103.f489695h) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r102.f489696i, r103.f489696i) == true) goto L19;
        return false;
    L19:
        if ((r101 instanceof f.c) == true) goto L21;
    L38:
        boolean r104 = true;
    L40:
        if (Intrinsics.areEqual(r101.f489685b, r111.f489685b) == true) goto L42;
        return false;
    L42:
        if (r101.f489686c == r111.f489686c) goto L44;
        return false;
    L44:
        if (r101.f489687d == r111.f489687d) goto L46;
        return false;
    L46:
        if (r101.f489688e == r111.f489688e) goto L48;
        return false;
    L48:
        if (r101.f489689f == r111.f489689f) goto L50;
        return false;
    L50:
        if (r101.f489690g != r111.f489690g) goto L62;
        if (r104 == false) goto L63;
        return true;
    L63:
        return false;
    L62:
        return false;
    L21:
        if ((r111 instanceof f.c) == false) goto L38;
        f.c r105 = (f.c) r101;
        f.c r106 = (f.c) r111;
        if (Intrinsics.areEqual(r105.f489691h, r106.f489691h) == true) goto L25;
    L37:
        r104 = false;
        goto L40
    L25:
        if (r105.f489692i != r106.f489692i) goto L37;
        List<a> r107 = r105.f489693j;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L28:
        if (r109.hasNext() == false) goto L30;
        a r112 = (a) r109.next();
        r108.add(TuplesKt.to(r112.f489643a, r112.f489646d));
        goto L28
    L30:
        List<a> r113 = r106.f489693j;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r115 = r113.iterator();
    L32:
        if (r115.hasNext() == false) goto L35;
        a r116 = (a) r115.next();
        r114.add(TuplesKt.to(r116.f489643a, r116.f489646d));
        goto L32
    L35:
        if (Intrinsics.areEqual(r108, r114) == false) goto L37;
        goto L37
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(f r100, f r101) {
        f r102 = r100;
        f r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.f489684a == r103.f489684a) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r102.f489685b.getBlockId(), r103.f489685b.getBlockId()) == false) goto L7;
        return true;
    }
}
