package com.ss.android.lark.picker.config;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.config.condition.Condition;
import com.ss.android.lark.picker.config.condition.Condition.Element;
import com.ss.android.lark.picker.config.condition.FoldCondition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u0004\u0018\u00018\u0000*\u0004\u0018\u00018\u0000H\u0086\u0002¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u0004\u0018\u00018\u0000*\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u0004\u0018\u00018\u0000*\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\rJ\u000f\u0010\u0018\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/picker/config/Filter;", "C", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "", "<init>", "()V", "_conditions", "", "conditions", "", "getConditions", "()Ljava/util/List;", "unaryPlus", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "times", "other", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "update", "", "position", "", "condition", "(ILcom/ss/android/lark/picker/config/condition/Condition$Element;)V", "withDefault", "defaultConditions", "()Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Filter<C extends Condition.Element<?>> {
    private final List<C> _conditions;

    public abstract C defaultConditions();

    public abstract C times(C r100, C r101);

    public abstract C withDefault(C r100);

    public final List<C> getConditions() {
        if (this._conditions.isEmpty() == false) goto L10;
        Condition.Element r100 = defaultConditions();
        if (r100 == null) goto L12;
        List<C> r101 = CollectionsKt.mutableListOf(new Condition.Element[]{r100});
        if (r101 == null) goto L12;
        return r101;
    L12:
        return this._conditions;
    L10:
        return this._conditions;
    }

    public Filter() {
        this._conditions = new ArrayList();
    }

    public final C unaryPlus(C r100) {
        Condition.Element r101 = withDefault(r100);
        if (r101 == null) goto L5;
        this._conditions.add((C) r101);
    L5:
        return r100;
    }

    public final void update(int r100, C r101) {
        Intrinsics.checkNotNullParameter(r101, "condition");
        Condition.Element r102 = (Condition.Element) CollectionsKt.getOrNull(this._conditions, r100);
        if (r102 != null) goto L6;
        return;
    L6:
        if ((r102 instanceof FoldCondition) == false) goto L9;
        r101 = (C) ((FoldCondition) r102).replace(r101);
    L17:
        if (r101 != null) goto L19;
        ListProtector.remove(this._conditions, r100);
        return;
    L19:
        ListProtector.set(this._conditions, r100, r101);
        return;
    L9:
        if ((r101 instanceof FoldCondition) == false) goto L14;
        if (((FoldCondition) r101).get(r102.getKey()) != null) goto L17;
        r101 = (C) times(r102, r101);
        goto L17
    L14:
        if (Intrinsics.areEqual(r102.getKey(), r101.getKey()) == true) goto L17;
        r101 = (C) times(r102, r101);
        goto L17
    }
}
