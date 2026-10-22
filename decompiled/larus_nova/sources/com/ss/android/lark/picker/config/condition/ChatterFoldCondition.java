package com.ss.android.lark.picker.config.condition;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ChatterFoldCondition;", "Lcom/ss/android/lark/picker/config/condition/ChatterCondition;", "Lcom/ss/android/lark/picker/config/condition/FoldCondition;", "<init>", "()V", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "inter", "other", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterFoldCondition extends FoldCondition<ChatterCondition<?>, ChatterFoldCondition> implements ChatterCondition<ChatterFoldCondition> {
    public static final Key Key = null;
    private final Condition.Key<ChatterFoldCondition> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ChatterFoldCondition$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/ChatterFoldCondition;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Key implements Condition.Key<ChatterFoldCondition> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Key = new Key(null);
    }

    public ChatterFoldCondition() {
        this.key = Key;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<ChatterFoldCondition> getKey() {
        return this.key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatterFoldCondition inter(ChatterFoldCondition r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        ChatterFoldCondition r101 = new ChatterFoldCondition();
        Pair r102 = TuplesKt.to(this, r100);
        FoldCondition r103 = (FoldCondition) r102.component1();
        Condition.Element r104 = (Condition.Element) r102.component2();
        Iterator<C> r105 = r103.iterator();
    L3:
        Condition.Element r106 = null;
        if (r105.hasNext() == false) goto L14;
        Condition.Element r107 = (Condition.Element) r105.next();
        Condition.Element r108 = r104.get(r107.getKey());
        if ((r108 instanceof Condition.Element) == false) goto L8;
        r106 = r108;
    L8:
        if (r106 == null) goto L11;
        r107 = FoldCondition.access$interInternal(r101, r107, r106);
    L11:
        if (r107 == null) goto L3;
        r101.getSet().put(r107.getKey(), r107);
        goto L3
    L14:
        if ((r104 instanceof ChatterFoldCondition) == false) goto L17;
        MapsKt.putAll(r101.getSet(), SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) r104), new FoldCondition$inter$2(r101)), FoldCondition$inter$3.INSTANCE));
    L22:
        return r101;
    L17:
        if ((!r101.getSet().containsKey(r104.getKey())) == true) goto L20;
        r104 = null;
    L20:
        if (r104 == null) goto L22;
        r101.getSet().put(r104.getKey(), r104);
        goto L22
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r100) {
        return inter((ChatterFoldCondition) r100);
    }
}
