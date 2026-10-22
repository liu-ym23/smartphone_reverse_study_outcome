package org.apache.commons.codec.language.bm;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum RuleType extends Enum<RuleType> {
    private static final /* synthetic */ RuleType[] $VALUES = null;
    public static final RuleType APPROX = null;
    public static final RuleType EXACT = null;
    public static final RuleType RULES = null;
    private final String name;

    private static /* synthetic */ RuleType[] $values() {
        return new RuleType[]{APPROX, EXACT, RULES};
    }

    static {
        APPROX = new RuleType("APPROX", 0, "approx");
        EXACT = new RuleType("EXACT", 1, "exact");
        RULES = new RuleType("RULES", 2, "rules");
        $VALUES = $values();
    }

    public static RuleType[] values() {
        return (RuleType[]) $VALUES.clone();
    }

    public String getName() {
        return this.name;
    }

    public static RuleType valueOf(String r100) {
        return (RuleType) a.a(RuleType.class, r100);
    }

    private RuleType(String r100, int r101, String r102) {
        super(r100, r101);
        this.name = r102;
    }
}
