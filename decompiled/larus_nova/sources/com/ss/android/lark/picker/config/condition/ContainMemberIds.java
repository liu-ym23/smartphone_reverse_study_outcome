package com.ss.android.lark.picker.config.condition;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u0014\u0015\u0016\u0017B%\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "Lcom/ss/android/lark/picker/config/condition/GroupCondition;", "includes", "", "", "excludes", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "getIncludes", "()Ljava/util/Set;", "getExcludes", "isNone", "", "inter", "other", "union", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", UserProfileEvent.POSITION_NONE, "NEW", AccountType.ALL, "Key", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$ALL;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$NEW;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$NONE;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ContainMemberIds implements GroupCondition<ContainMemberIds> {
    private final Set<String> excludes;
    private final Set<String> includes;
    private final Condition.Key<ContainMemberIds> key;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$ALL;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ALL extends ContainMemberIds {
        public static final ALL INSTANCE = null;

        static {
            INSTANCE = new ALL();
        }

        private ALL() {
            super(SetsKt.emptySet(), SetsKt.emptySet(), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Key implements Condition.Key<ContainMemberIds> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$NEW;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "includes", "", "", "excludes", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NEW extends ContainMemberIds {
        public NEW(Set<String> r100, Set<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "includes");
            Intrinsics.checkNotNullParameter(r101, "excludes");
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r100.iterator();
        L4:
            if (r103.hasNext() == false) goto L8;
            Object r104 = r103.next();
            if ((!r101.contains((String) r104)) == false) goto L4;
            r102.add(r104);
            goto L4
        L8:
            super(CollectionsKt.toSet(r102), r101, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$NONE;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NONE extends ContainMemberIds {
        public static final NONE INSTANCE = null;

        static {
            INSTANCE = new NONE();
        }

        private NONE() {
            super(SetsKt.emptySet(), SetsKt.emptySet(), null);
        }
    }

    public /* synthetic */ ContainMemberIds(Set r100, Set r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        return Intrinsics.areEqual(this, NONE.INSTANCE);
    }

    public final Set<String> getExcludes() {
        return this.excludes;
    }

    public final Set<String> getIncludes() {
        return this.includes;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<ContainMemberIds> getKey() {
        return this.key;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r100) {
        return (E) GroupCondition.DefaultImpls.get(this, r100);
    }

    public ContainMemberIds inter(ContainMemberIds r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((this instanceof NONE) == true) goto L28;
        if ((r100 instanceof NONE) == true) goto L28;
        if ((this instanceof ALL) == false) goto L11;
        return r100;
    L11:
        if ((r100 instanceof ALL) == false) goto L13;
        return this;
    L13:
        Set<String> r101 = this.includes;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L15:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        Set<String> r105 = r100.includes;
        if (r105.contains((String) r104) == false) goto L15;
        r102.add(r104);
        goto L15
    L19:
        Set r106 = CollectionsKt.toSet(r102);
        Set<String> r107 = this.excludes;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L21:
        if (r109.hasNext() == false) goto L26;
        Object r110 = r109.next();
        Set<String> r111 = r100.excludes;
        if (r111.contains((String) r110) == false) goto L21;
        r108.add(r110);
        goto L21
    L26:
        return new NEW(r106, CollectionsKt.toSet(r108));
    L28:
        return NONE.INSTANCE;
    }

    public ContainMemberIds union(ContainMemberIds r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        NONE r101 = NONE.INSTANCE;
        if (Intrinsics.areEqual(this, r101) == false) goto L6;
        return r100;
    L6:
        if (Intrinsics.areEqual(r100, r101) == false) goto L8;
        return this;
    L8:
        ALL r102 = ALL.INSTANCE;
        if (Intrinsics.areEqual(this, r102) == false) goto L11;
    L15:
        return r102;
    L11:
        if (Intrinsics.areEqual(r100, r102) == true) goto L15;
        Set r103 = CollectionsKt.toMutableSet(this.includes);
        r103.addAll(r100.includes);
        Set r104 = CollectionsKt.toMutableSet(this.excludes);
        r104.addAll(r100.excludes);
        return new NEW(r103, r104);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r100) {
        return inter((ContainMemberIds) r100);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r100) {
        return union((ContainMemberIds) r100);
    }

    private ContainMemberIds(Set<String> r100, Set<String> r101) {
        this.includes = r100;
        this.excludes = r101;
        this.key = Key.INSTANCE;
    }
}
