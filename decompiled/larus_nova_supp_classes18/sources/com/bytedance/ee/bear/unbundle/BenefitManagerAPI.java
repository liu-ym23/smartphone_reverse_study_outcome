package com.bytedance.ee.bear.unbundle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface BenefitManagerAPI {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/unbundle/BenefitManagerAPI$CacheType;", "", "<init>", "(Ljava/lang/String;I)V", "TOKEN", "OWNER_ID", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CacheType extends Enum<CacheType> {
        public static final CacheType OWNER_ID = null;
        public static final CacheType TOKEN = null;
        public static final /* synthetic */ CacheType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CacheType> getEntries() {
            return b;
        }

        static {
            CacheType r0 = new CacheType("TOKEN", 0);
            TOKEN = r0;
            CacheType r1 = new CacheType("OWNER_ID", 1);
            OWNER_ID = r1;
            CacheType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static CacheType[] values() {
            return (CacheType[]) a.clone();
        }

        public static CacheType valueOf(String r1) {
            return (CacheType) a.a(CacheType.class, r1);
        }

        public CacheType(String r1, int r2) {
            super(r1, r2);
        }
    }

    BenefitStore R7(String r1, int r2);

    Object d8(String r1, int r2, String r3, CacheType r4, Continuation<? super BenefitStore> r5);

    void destroy();

    BenefitStore g7(String r1, int r2, CacheType r3);

    BenefitStore n1();
}
