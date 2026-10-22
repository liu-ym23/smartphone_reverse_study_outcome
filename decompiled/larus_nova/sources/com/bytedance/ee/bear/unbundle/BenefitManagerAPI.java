package com.bytedance.ee.bear.unbundle;

import faceverify.q;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public interface BenefitManagerAPI {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/unbundle/BenefitManagerAPI$CacheType;", "", "<init>", "(Ljava/lang/String;I)V", q.KEY_TOKEN, "OWNER_ID", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CacheType extends Enum<CacheType> {
        public static final CacheType OWNER_ID = null;
        public static final CacheType TOKEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CacheType[] f239801a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f239802b = null;

        public static EnumEntries<CacheType> getEntries() {
            return f239802b;
        }

        static {
            CacheType r100 = new CacheType(q.KEY_TOKEN, 0);
            TOKEN = r100;
            CacheType r101 = new CacheType("OWNER_ID", 1);
            OWNER_ID = r101;
            CacheType[] r102 = {r100, r101};
            f239801a = r102;
            f239802b = EnumEntriesKt.enumEntries(r102);
        }

        public static CacheType[] values() {
            return (CacheType[]) f239801a.clone();
        }

        public static CacheType valueOf(String r100) {
            return (CacheType) a.a(CacheType.class, r100);
        }

        public CacheType(String r100, int r101) {
            super(r100, r101);
        }
    }

    BenefitStore R7(String r100, int r101);

    Object d8(String r100, int r101, String r102, CacheType r103, Continuation<? super BenefitStore> r104);

    void destroy();

    BenefitStore g7(String r100, int r101, CacheType r102);

    BenefitStore n1();
}
