package com.ss.android.lark.picker.config.condition;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0004\u0013\u0014\u0015\u0016B\u0017\b\u0004\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u0003\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DocTypes;", "Lcom/ss/android/lark/picker/config/condition/DocCondition;", "Lcom/ss/android/lark/picker/config/condition/WikiCondition;", "types", "", "Lcom/ss/android/lark/picker/config/condition/DocType;", "<init>", "(Ljava/util/Set;)V", "getTypes", "()Ljava/util/Set;", "isNone", "", "inter", "other", "union", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", UserProfileEvent.POSITION_NONE, "NEW", AccountType.ALL, "Key", "Lcom/ss/android/lark/picker/config/condition/DocTypes$ALL;", "Lcom/ss/android/lark/picker/config/condition/DocTypes$NEW;", "Lcom/ss/android/lark/picker/config/condition/DocTypes$NONE;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DocTypes implements DocCondition<DocTypes>, WikiCondition<DocTypes> {
    private final Condition.Key<DocTypes> key;
    private final Set<DocType> types;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DocTypes$ALL;", "Lcom/ss/android/lark/picker/config/condition/DocTypes;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ALL extends DocTypes {
        public static final ALL INSTANCE = null;

        static {
            INSTANCE = new ALL();
        }

        private ALL() {
            super(SetsKt.setOf(DocType.ALL), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DocTypes$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/DocTypes;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Key implements Condition.Key<DocTypes> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DocTypes$NEW;", "Lcom/ss/android/lark/picker/config/condition/DocTypes;", "types", "", "Lcom/ss/android/lark/picker/config/condition/DocType;", "<init>", "(Ljava/util/Set;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NEW extends DocTypes {
        public NEW(Set<? extends DocType> r100) {
            Intrinsics.checkNotNullParameter(r100, "types");
            super(r100, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DocTypes$NONE;", "Lcom/ss/android/lark/picker/config/condition/DocTypes;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NONE extends DocTypes {
        public static final NONE INSTANCE = null;

        static {
            INSTANCE = new NONE();
        }

        private NONE() {
            super(SetsKt.emptySet(), null);
        }
    }

    public /* synthetic */ DocTypes(Set r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        return Intrinsics.areEqual(this, NONE.INSTANCE);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<DocTypes> getKey() {
        return this.key;
    }

    public final Set<DocType> getTypes() {
        return this.types;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DocTypes(Set<? extends DocType> r100) {
        this.types = r100;
        this.key = Key.INSTANCE;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r100) {
        return (E) DocCondition.DefaultImpls.get(this, r100);
    }

    public DocTypes inter(DocTypes r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        NONE r101 = NONE.INSTANCE;
        if (Intrinsics.areEqual(this, r101) == true) goto L24;
        if (Intrinsics.areEqual(r100, r101) == true) goto L24;
        ALL r102 = ALL.INSTANCE;
        if (Intrinsics.areEqual(this, r102) == false) goto L11;
        return r100;
    L11:
        if (Intrinsics.areEqual(r100, r102) == true) goto L30;
        Set<DocType> r103 = this.types;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L15:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        Set<DocType> r107 = r100.types;
        if (r107.contains((DocType) r106) == false) goto L15;
        r104.add(r106);
        goto L15
    L20:
        if (r104.isEmpty() == false) goto L32;
        return NONE.INSTANCE;
    L32:
        return new NEW(CollectionsKt.toSet(r104));
    L30:
        return this;
    L24:
        return r101;
    }

    public DocTypes union(DocTypes r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        LinkedHashSet r101 = new LinkedHashSet();
        r101.addAll(this.types);
        r101.addAll(r100.types);
        return new NEW(r101);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r100) {
        return inter((DocTypes) r100);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r100) {
        return union((DocTypes) r100);
    }
}
