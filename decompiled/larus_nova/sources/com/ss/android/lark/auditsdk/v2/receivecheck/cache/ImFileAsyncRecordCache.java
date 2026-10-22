package com.ss.android.lark.auditsdk.v2.receivecheck.cache;

import c0c.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.tencent.open.SocialConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class ImFileAsyncRecordCache extends c implements com.ss.android.lark.auditsdk.v2.receivecheck.cache.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ImFileAsyncRecord> f409645b;

    public static final class ImFileAsyncRecord {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EntityType f409646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f409647b;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/auditsdk/v2/receivecheck/cache/ImFileAsyncRecordCache$ImFileAsyncRecord$EntityType;", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "MESSAGE", "UNKNOWN", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum EntityType extends Enum<EntityType> {
            public static final EntityType MESSAGE = null;
            public static final EntityType UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ EntityType[] f409648a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f409649b = null;
            private final String desc;

            public static EnumEntries<EntityType> getEntries() {
                return f409649b;
            }

            static {
                EntityType r100 = new EntityType("MESSAGE", 0, "message");
                MESSAGE = r100;
                EntityType r101 = new EntityType("UNKNOWN", 1, "unknown");
                UNKNOWN = r101;
                EntityType[] r102 = {r100, r101};
                f409648a = r102;
                f409649b = EnumEntriesKt.enumEntries(r102);
            }

            public static EntityType[] values() {
                return (EntityType[]) f409648a.clone();
            }

            public final String getDesc() {
                return this.desc;
            }

            public static EntityType valueOf(String r100) {
                return (EntityType) r27.a.a(EntityType.class, r100);
            }

            public EntityType(String r100, int r101, String r102) {
                super(r100, r101);
                this.desc = r102;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ImFileAsyncRecord) == true) goto L8;
            return false;
        L8:
            ImFileAsyncRecord r101 = (ImFileAsyncRecord) r100;
            if (this.f409646a == r101.f409646a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f409647b, r101.f409647b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f409646a.hashCode() * 31) + this.f409647b.hashCode();
        }

        public final String toString() {
            return "ImFileAsyncRecord(type=" + this.f409646a + ", id=" + this.f409647b + ')';
        }

        public final String a() {
            return this.f409646a.getDesc() + '_' + this.f409647b;
        }

        public final EntityType getType() {
            return this.f409646a;
        }

        public ImFileAsyncRecord(EntityType r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "id");
            this.f409646a = r100;
            this.f409647b = r101;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // c0c.c
    public final void c() {
        Log.i("ImFileAuthorityChecker", "async authority clear");
        ((ConcurrentHashMap) this.f409645b).clear();
    }

    public ImFileAsyncRecordCache(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        super(r100);
        this.f409645b = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.auditsdk.v2.receivecheck.cache.a
    public final void h9(ImFileAsyncRecord r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        Log.i("ImFileAuthorityChecker", "record async authority result id = " + r100.a());
        ((ConcurrentHashMap) this.f409645b).put(r100.a(), r100);
    }

    @Override // com.ss.android.lark.auditsdk.v2.receivecheck.cache.a
    public final boolean H1(ImFileAsyncRecord.EntityType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "id");
        String r102 = r100.getDesc() + '_' + r101;
        boolean r103 = ((ConcurrentHashMap) this.f409645b).containsKey(r102);
        Log.i("ImFileAuthorityChecker", "check async authority result id = " + r102 + "， result = " + r103);
        return r103;
    }
}
