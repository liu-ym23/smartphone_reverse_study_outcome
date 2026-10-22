package com.bytedance.ug.sdk.luckycat.impl.model;

/* JADX INFO: loaded from: classes22.dex */
public final class ProfitRemindModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f271381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f271382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProfitType f271383c;

    public static final enum ProfitType extends Enum<ProfitType> {
        public static final ProfitType APPRENTICE = null;
        public static final ProfitType INVITE_BONUS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProfitType[] f271384a = null;
        private String key;

        static {
            ProfitType r100 = new ProfitType("APPRENTICE", 0, "pop_up_apprentice");
            APPRENTICE = r100;
            ProfitType r101 = new ProfitType("INVITE_BONUS", 1, "pop_up_invite_bonus");
            INVITE_BONUS = r101;
            f271384a = new ProfitType[]{r100, r101};
        }

        public static ProfitType[] values() {
            return (ProfitType[]) f271384a.clone();
        }

        public static /* synthetic */ String access$000(ProfitType r100) {
            return r100.key;
        }

        public static ProfitType valueOf(String r100) {
            return (ProfitType) r27.a.a(ProfitType.class, r100);
        }

        public ProfitType(String r100, int r101, String r102) {
            super(r100, r101);
            this.key = r102;
        }
    }

    public ProfitRemindModel() {
    }

    public ProfitType getType() {
        return this.f271383c;
    }
}
