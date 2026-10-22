package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.config.condition.Condition;
import com.ss.android.lark.picker.config.condition.DepartmentCondition;
import com.ss.android.lark.picker.config.condition.DepartmentFoldCondition;
import com.ss.android.lark.picker.config.condition.FoldCondition;
import com.ss.android.lark.picker.config.condition.FoldCondition$inter$2;
import com.ss.android.lark.picker.config.condition.FoldCondition$inter$3;
import com.ss.android.lark.picker.config.condition.ManageStatus;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u0018\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J!\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0096\u0002¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/picker/config/DepartmentFilter;", "Lcom/ss/android/lark/picker/config/Filter;", "Lcom/ss/android/lark/picker/config/condition/DepartmentCondition;", "<init>", "()V", "defaultConditions", "withDefault", "times", "other", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DepartmentFilter extends Filter<DepartmentCondition<?>> {
    public DepartmentCondition<?> withDefault(DepartmentCondition<?> r100) {
        return r100;
    }

    @Override // com.ss.android.lark.picker.config.Filter
    public /* bridge */ /* synthetic */ Condition.Element defaultConditions() {
        return defaultConditions();
    }

    public DepartmentFilter() {
    }

    @Override // com.ss.android.lark.picker.config.Filter
    public DepartmentCondition<?> defaultConditions() {
        return ManageStatus.MY_MANAGE;
    }

    @Override // com.ss.android.lark.picker.config.Filter
    public /* bridge */ /* synthetic */ Condition.Element withDefault(Condition.Element r100) {
        return withDefault((DepartmentCondition) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DepartmentCondition<?> times(DepartmentCondition<?> r100, DepartmentCondition<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        DepartmentFoldCondition r102 = new DepartmentFoldCondition();
        boolean r103 = r100 instanceof DepartmentFoldCondition;
        if (r103 == false) goto L5;
    L13:
        if (r103 == false) goto L15;
        Pair r104 = TuplesKt.to((DepartmentFoldCondition) r100, r101);
    L16:
        FoldCondition r105 = (FoldCondition) r104.component1();
        Condition.Element r106 = (Condition.Element) r104.component2();
        Iterator<C> r107 = r105.iterator();
    L17:
        Condition.Element r108 = null;
        if (r107.hasNext() == false) goto L28;
        Condition.Element r109 = (Condition.Element) r107.next();
        Condition.Element r110 = r106.get(r109.getKey());
        if ((r110 instanceof Condition.Element) == false) goto L22;
        r108 = r110;
    L22:
        if (r108 == null) goto L25;
        r109 = FoldCondition.access$interInternal(r102, r109, r108);
    L25:
        if (r109 == null) goto L17;
        r102.getSet().put(r109.getKey(), r109);
        goto L17
    L28:
        if ((r106 instanceof DepartmentFoldCondition) == false) goto L31;
        MapsKt.putAll(r102.getSet(), SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) r106), new FoldCondition$inter$2(r102)), FoldCondition$inter$3.INSTANCE));
    L36:
        return r102;
    L31:
        if ((!r102.getSet().containsKey(r106.getKey())) == true) goto L34;
        r106 = null;
    L34:
        if (r106 == null) goto L36;
        r102.getSet().put(r106.getKey(), r106);
        goto L36
    L15:
        r104 = TuplesKt.to((DepartmentFoldCondition) r101, r100);
        goto L16
    L5:
        if ((r101 instanceof DepartmentFoldCondition) == true) goto L13;
        if (Intrinsics.areEqual(r100.getKey(), r101.getKey()) == false) goto L12;
        Condition.Element r111 = FoldCondition.access$interInternal(r102, r100, r101);
        if (r111 == null) goto L36;
        r102.getSet().put(r111.getKey(), r111);
        goto L36
    L12:
        r102.getSet().put(r100.getKey(), r100);
        r102.getSet().put(r101.getKey(), r101);
        goto L36
    }

    @Override // com.ss.android.lark.picker.config.Filter
    public /* bridge */ /* synthetic */ Condition.Element times(Condition.Element r100, Condition.Element r101) {
        return times((DepartmentCondition) r100, (DepartmentCondition) r101);
    }
}
