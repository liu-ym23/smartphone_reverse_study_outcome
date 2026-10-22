package com.ss.android.lark.picker.config.condition;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0005\u0013\u0014\u0015\u0016\u0017B\u0017\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0016J\u0006\u0010\r\u001a\u00020\u0000J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u0004\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Folders;", "Lcom/ss/android/lark/picker/config/condition/DocCondition;", "ids", "", "", "<init>", "(Ljava/util/Set;)V", "getIds", "()Ljava/util/Set;", "isNone", "", "inter", "other", "negate", "union", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", UserProfileEvent.POSITION_NONE, "IN", "OUT", AccountType.ALL, "Key", "Lcom/ss/android/lark/picker/config/condition/Folders$ALL;", "Lcom/ss/android/lark/picker/config/condition/Folders$IN;", "Lcom/ss/android/lark/picker/config/condition/Folders$NONE;", "Lcom/ss/android/lark/picker/config/condition/Folders$OUT;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Folders implements DocCondition<Folders> {
    public static final Key Key = null;
    private final Set<String> ids;
    private final Condition.Key<Folders> key;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Folders$ALL;", "Lcom/ss/android/lark/picker/config/condition/Folders;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ALL extends Folders {
        public static final ALL INSTANCE = null;

        static {
            INSTANCE = new ALL();
        }

        private ALL() {
            super(SetsKt.emptySet(), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Folders$IN;", "Lcom/ss/android/lark/picker/config/condition/Folders;", "ids", "", "", "<init>", "(Ljava/util/Set;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IN extends Folders {
        public IN(Set<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "ids");
            super(r100, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Folders$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/Folders;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Key implements Condition.Key<Folders> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Folders$NONE;", "Lcom/ss/android/lark/picker/config/condition/Folders;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NONE extends Folders {
        public static final NONE INSTANCE = null;

        static {
            INSTANCE = new NONE();
        }

        private NONE() {
            super(SetsKt.emptySet(), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Folders$OUT;", "Lcom/ss/android/lark/picker/config/condition/Folders;", "ids", "", "", "<init>", "(Ljava/util/Set;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OUT extends Folders {
        public OUT(Set<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "ids");
            super(r100, null);
        }
    }

    static {
        Key = new Key(null);
    }

    public /* synthetic */ Folders(Set r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        return Intrinsics.areEqual(this, NONE.INSTANCE);
    }

    public final Folders negate() {
        NONE r100 = NONE.INSTANCE;
        if (Intrinsics.areEqual(this, r100) == false) goto L6;
        return ALL.INSTANCE;
    L6:
        if ((this instanceof IN) == false) goto L9;
        return new OUT(this.ids);
    L9:
        if ((this instanceof OUT) == false) goto L12;
        return new IN(this.ids);
    L12:
        if (Intrinsics.areEqual(this, ALL.INSTANCE) == false) goto L15;
        return r100;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final Set<String> getIds() {
        return this.ids;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<Folders> getKey() {
        return this.key;
    }

    private Folders(Set<String> r100) {
        this.ids = r100;
        this.key = Key;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r100) {
        return (E) DocCondition.DefaultImpls.get(this, r100);
    }

    public Folders inter(Folders r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((this instanceof NONE) == true) goto L41;
        if ((r100 instanceof NONE) == true) goto L41;
        if ((this instanceof ALL) == false) goto L11;
        return r100;
    L11:
        if ((r100 instanceof ALL) == false) goto L13;
        return this;
    L13:
        boolean r101 = this instanceof IN;
        if (r101 == false) goto L16;
    L19:
        if (r101 == false) goto L21;
        Pair r102 = TuplesKt.to(this, r100);
    L22:
        Folders r103 = (Folders) r102.component1();
        Folders r104 = (Folders) r102.component2();
        if ((r104 instanceof OUT) == false) goto L31;
        Set<String> r105 = r103.ids;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L26:
        if (r107.hasNext() == false) goto L30;
        Object r108 = r107.next();
        if ((!r104.ids.contains((String) r108)) == false) goto L26;
        r106.add(r108);
        goto L26
    L30:
        IN r109 = new IN(CollectionsKt.toSet(r106));
    L39:
        return r109;
    L31:
        Set<String> r110 = r103.ids;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L33:
        if (r112.hasNext() == false) goto L37;
        Object r113 = r112.next();
        if (r104.ids.contains((String) r113) == false) goto L33;
        r111.add(r113);
        goto L33
    L37:
        r109 = new IN(CollectionsKt.toSet(r111));
        goto L39
    L21:
        r102 = TuplesKt.to(r100, this);
        goto L22
    L16:
        if ((r100 instanceof IN) == true) goto L19;
        LinkedHashSet r114 = new LinkedHashSet();
        r114.addAll(this.ids);
        r114.addAll(r100.ids);
        return new OUT(r114);
    L41:
        return NONE.INSTANCE;
    }

    public Folders union(Folders r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return negate().inter(r100.negate()).negate();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r100) {
        return inter((Folders) r100);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r100) {
        return union((Folders) r100);
    }
}
