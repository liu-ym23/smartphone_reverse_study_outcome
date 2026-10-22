package com.ss.android.lark.preload.v2.condition;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import g1c.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ConditionSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b<?>> f438810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Operator> f438811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Stack<Boolean> f438812c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/preload/v2/condition/ConditionSet$Operator;", "", "<init>", "(Ljava/lang/String;I)V", "OR", "AND", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Operator extends Enum<Operator> {
        public static final Operator AND = null;
        public static final Operator OR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Operator[] f438813a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f438814b = null;

        public static EnumEntries<Operator> getEntries() {
            return f438814b;
        }

        static {
            Operator r100 = new Operator("OR", 0);
            OR = r100;
            Operator r101 = new Operator("AND", 1);
            AND = r101;
            Operator[] r102 = {r100, r101};
            f438813a = r102;
            f438814b = EnumEntriesKt.enumEntries(r102);
        }

        public static Operator[] values() {
            return (Operator[]) f438813a.clone();
        }

        public static Operator valueOf(String r100) {
            return (Operator) a.a(Operator.class, r100);
        }

        public Operator(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean b() {
        this.f438812c.clear();
        boolean r100 = false;
        if (((ArrayList) this.f438810a).size() > 0) goto L5;
        return false;
    L5:
        this.f438812c.add(Boolean.valueOf(((b) ListProtector.get(this.f438810a, 0)).isValid()));
        int r101 = 1;
    L7:
        if (r101 >= ((ArrayList) this.f438810a).size()) goto L14;
        b r102 = (b) ListProtector.get(this.f438810a, r101);
        if (ListProtector.get(this.f438811b, r101 - 1) != Operator.OR) goto L11;
        this.f438812c.add(Boolean.valueOf(r102.isValid()));
    L12:
        r101 = r101 + 1;
        goto L7
    L11:
        Boolean r103 = this.f438812c.pop();
        this.f438812c.add(Boolean.valueOf(r102.isValid() & r103.booleanValue()));
    L14:
        if (this.f438812c.empty() == true) goto L16;
        r100 = r100 | this.f438812c.pop().booleanValue();
        goto L14
    L16:
        return r100;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        Iterator<T> r101 = this.f438810a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        b r102 = (b) r101.next();
        r100.append(r102.getClass().getSimpleName());
        r100.append(":");
        r100.append(r102.isValid());
        r100.append(", ");
        goto L4
    L6:
        r100.append("primary:");
        r100.append(null);
        return r100.toString();
    }

    public ConditionSet() {
        this.f438810a = new ArrayList();
        this.f438811b = new ArrayList();
        this.f438812c = new Stack();
    }

    public final void a(g1c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        if ((!((ArrayList) this.f438810a).isEmpty()) == false) goto L5;
        ((ArrayList) this.f438811b).add(Operator.AND);
    L5:
        ((ArrayList) this.f438810a).add(r100);
    }
}
