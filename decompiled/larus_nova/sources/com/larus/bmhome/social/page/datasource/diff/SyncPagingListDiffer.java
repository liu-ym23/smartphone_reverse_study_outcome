package com.larus.bmhome.social.page.datasource.diff;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class SyncPagingListDiffer<DATA> extends PagingListDiffer<DATA> {
    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public final List<DATA> c() {
        return com.larus.utils.h.d(this.f314014d);
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object i(Continuation r100) {
        int r101 = 0;
        int r102 = com.larus.utils.h.f(this.f314014d, 0);
        List<? extends DATA> r103 = this.f314014d;
        int r104 = 0 + r102;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r104 >= 0) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L10;
        r101 = r104;
    L13:
        int r106 = r101 - r102;
        if (r106 <= 0) goto L17;
        j(this.f314014d.subList(r102, r101));
        this.f314016b.onRemoved(r102, r106);
    L17:
        return Unit.INSTANCE;
    L10:
        if (r104 < 0) goto L13;
        r101 = r103.size();
        goto L13
    L5:
        if (r104 > r103.size()) goto L7;
        r105 = true;
        goto L8
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object k(Continuation r100) {
        if (this.f314014d.isEmpty() == false) goto L6;
        e(null, r100);
        throw null;
    L6:
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer, com.larus.bmhome.social.page.datasource.diff.b
    public final /* bridge */ /* synthetic */ Object b(com.larus.bmhome.social.page.datasource.event.a r100, Continuation r101) {
        return f((h) r100, r101);
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object e(List<? extends DATA> r100, Continuation<? super Unit> r101) {
        if (r100.isEmpty() == true) goto L5;
        int r102 = r100.size();
        if (this.f314014d.isEmpty() == false) goto L10;
        j(r100);
        this.f314016b.onInserted(0, r102);
        return Unit.INSTANCE;
    L10:
        int r103 = this.f314014d.size() + 1;
        this.f314016b.onInserted(r103, r102);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object f(h<DATA> r100, Continuation<? super Unit> r101) {
        Object r102 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new SyncPagingListDiffer$collectEvent$2(this, r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object h(List<? extends DATA> r100, Continuation<? super Unit> r101) {
        if (r100.isEmpty() == true) goto L5;
        j(CollectionsKt.plus(r100, this.f314014d));
        this.f314016b.onInserted(0, r100.size());
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public Object insert(int r100, List<? extends DATA> r101, Continuation<? super Unit> r102) {
        if (r101.isEmpty() == false) goto L7;
        return Unit.INSTANCE;
    L7:
        if (this.f314014d.isEmpty() == false) goto L13;
        Object r103 = e(r101, r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r103;
    L12:
        return Unit.INSTANCE;
    L13:
        if (r100 > 0) goto L20;
        Object r104 = h(r101, r102);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r104;
    L18:
        return Unit.INSTANCE;
    L20:
        if (r100 < this.f314014d.size()) goto L26;
        Object r105 = e(r101, r102);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r105;
    L25:
        return Unit.INSTANCE;
    L26:
        List<? extends DATA> r106 = CollectionsKt.toMutableList(this.f314014d);
        r106.addAll(r100, r101);
        j(r106);
        this.f314016b.onInserted(r100, r101.size());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public Object update(int r100, List<? extends DATA> r101, Continuation<? super Unit> r102) {
        if (r101.isEmpty() == true) goto L30;
        if (this.f314014d.isEmpty() == true) goto L30;
        if (com.larus.utils.h.a(this.f314014d, r100) == true) goto L12;
        return Unit.INSTANCE;
    L12:
        if ((r101.size() + r100) <= this.f314014d.size()) goto L14;
        int r103 = this.f314014d.size();
    L15:
        if (r100 > r103) goto L17;
        ArrayList r104 = new ArrayList();
        List r105 = CollectionsKt.toMutableList(this.f314014d);
        int r106 = r100;
    L19:
        if (r106 >= r103) goto L24;
        Object r107 = ListProtector.get(r105, r106);
        Object r108 = ListProtector.get(r101, r106 - r100);
        ListProtector.set(r105, r106, r108);
        DiffUtil.ItemCallback<Item> r109 = this.f314015a;
        Intrinsics.checkNotNull(r108);
        Intrinsics.checkNotNull(r107);
        Object r110 = r109.getChangePayload((Item) r108, (Item) r107);
        if (r110 == null) goto L23;
        r104.add(r110);
    L23:
        r106 = r106 + 1;
        goto L19
    L24:
        j(com.larus.utils.h.d(r105));
        ListUpdateCallback r111 = this.f314016b;
        int r112 = r103 - r100;
        if (r104.isEmpty() == false) goto L27;
        r104 = null;
    L27:
        r111.onChanged(r100, r112, r104);
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L14:
        r103 = r101.size() + r100;
    L30:
        return Unit.INSTANCE;
    }
}
