package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageTransitionRule;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Editor", "Person", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StageTransitionRule extends Enum<StageTransitionRule> {
    public static final a Companion = null;
    public static final StageTransitionRule Editor = null;
    public static final StageTransitionRule Person = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StageTransitionRule[] f207133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207134b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<StageTransitionRule> getEntries() {
        return f207134b;
    }

    static {
        StageTransitionRule r100 = new StageTransitionRule("Editor", 0, "Editor");
        Editor = r100;
        StageTransitionRule r101 = new StageTransitionRule("Person", 1, "Person");
        Person = r101;
        StageTransitionRule[] r102 = {r100, r101};
        f207133a = r102;
        f207134b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static StageTransitionRule[] values() {
        return (StageTransitionRule[]) f207133a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final StageTransitionRule lookup(String r100) {
        Companion.getClass();
        StageTransitionRule[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        StageTransitionRule r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public static StageTransitionRule valueOf(String r100) {
        return (StageTransitionRule) r27.a.a(StageTransitionRule.class, r100);
    }

    public StageTransitionRule(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
