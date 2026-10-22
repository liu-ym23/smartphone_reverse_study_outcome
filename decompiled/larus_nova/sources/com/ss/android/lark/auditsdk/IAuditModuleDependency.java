package com.ss.android.lark.auditsdk;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface IAuditModuleDependency {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/auditsdk/IAuditModuleDependency$ChatType;", "", "<init>", "(Ljava/lang/String;I)V", "P2P", "GROUP", "UNKNOWN", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatType extends Enum<ChatType> {
        public static final ChatType GROUP = null;
        public static final ChatType P2P = null;
        public static final ChatType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatType[] f409555a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f409556b = null;

        public static EnumEntries<ChatType> getEntries() {
            return f409556b;
        }

        static {
            ChatType r100 = new ChatType("P2P", 0);
            P2P = r100;
            ChatType r101 = new ChatType("GROUP", 1);
            GROUP = r101;
            ChatType r102 = new ChatType("UNKNOWN", 2);
            UNKNOWN = r102;
            ChatType[] r103 = {r100, r101, r102};
            f409555a = r103;
            f409556b = EnumEntriesKt.enumEntries(r103);
        }

        public static ChatType[] values() {
            return (ChatType[]) f409555a.clone();
        }

        public static ChatType valueOf(String r100) {
            return (ChatType) r27.a.a(ChatType.class, r100);
        }

        public ChatType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void onError();

        void onSuccess(String r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f409557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f409558b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f409557a, r101.f409557a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f409558b, r101.f409558b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f409557a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Long r104 = this.f409558b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "MessageSenderInfo(senderUserId=" + this.f409557a + ", senderTenantId=" + this.f409558b + ')';
        }

        public b(Long r100, Long r101) {
            this.f409557a = r100;
            this.f409558b = r101;
        }
    }

    public interface c {
    }

    ChatType getChatTypeByChatId(String r100);

    void getDeviceId(a r100);

    String getDomain();

    b getMessageSenderInfo(String r100);

    owa.b getQuotaLimitDependency();

    owa.c getSecurityComplianceDependency();

    String getTenantId();

    int getUnifiedStorageLimitErrorCode();

    String getUserAgent();

    String getUserId();

    boolean isDoubaoEnterpriseUser();

    boolean isHitStorageQuotaLimit(int r100);

    boolean isLogin();

    void registerAccountChangedListener(c r100);

    boolean showQuotaLimitDialog(Activity r100, int r101);

    void showUnifiedStorageLimitCTADialog(Activity r100);
}
