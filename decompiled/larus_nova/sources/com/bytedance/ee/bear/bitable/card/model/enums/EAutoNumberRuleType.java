package com.bytedance.ee.bear.bitable.card.model.enums;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/enums/EAutoNumberRuleType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "SYSTEM_NUMBER", "FIXED_TEXT", "CREATED_TIME", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EAutoNumberRuleType extends Enum<EAutoNumberRuleType> {
    public static final EAutoNumberRuleType CREATED_TIME = null;
    public static final a Companion = null;
    public static final EAutoNumberRuleType FIXED_TEXT = null;
    public static final EAutoNumberRuleType SYSTEM_NUMBER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, EAutoNumberRuleType> f207080a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EAutoNumberRuleType[] f207081b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207082c = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static EAutoNumberRuleType a(Integer r100) {
            return (EAutoNumberRuleType) EAutoNumberRuleType.access$getValueMap$cp().get(r100);
        }
    }

    public static EnumEntries<EAutoNumberRuleType> getEntries() {
        return f207082c;
    }

    static {
        int r100 = 0;
        EAutoNumberRuleType r101 = new EAutoNumberRuleType("SYSTEM_NUMBER", 0, 1);
        SYSTEM_NUMBER = r101;
        EAutoNumberRuleType r102 = new EAutoNumberRuleType("FIXED_TEXT", 1, 2);
        FIXED_TEXT = r102;
        EAutoNumberRuleType r103 = new EAutoNumberRuleType("CREATED_TIME", 2, 3);
        CREATED_TIME = r103;
        EAutoNumberRuleType[] r104 = {r101, r102, r103};
        f207081b = r104;
        f207082c = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
        f207080a = new HashMap();
        EAutoNumberRuleType[] r105 = values();
        int r106 = r105.length;
    L3:
        if (r100 >= r106) goto L5;
        EAutoNumberRuleType r107 = r105[r100];
        ((HashMap) f207080a).put(Integer.valueOf(r107.value), r107);
        r100 = r100 + 1;
        goto L3
    }

    public static EAutoNumberRuleType[] values() {
        return (EAutoNumberRuleType[]) f207081b.clone();
    }

    public static final /* synthetic */ Map access$getValueMap$cp() {
        return f207080a;
    }

    public final int getValue() {
        return this.value;
    }

    public static EAutoNumberRuleType valueOf(String r100) {
        return (EAutoNumberRuleType) r27.a.a(EAutoNumberRuleType.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public EAutoNumberRuleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
