package com.ss.android.lark.auditsdk.v2.receivecheck.entity;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.auditsdk.v2.receivecheck.ImFileAuthorityChecker;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AuthorityParam {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f409659j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f409662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f409663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f409664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f409665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f409666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f409667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AuthorityExtraParam f409668i;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/AuthorityParam$AuthorityExtraParam;", "Ljava/io/Serializable;", "isPreMsg", "", "isFromMe", "isMultiResourceMsg", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthorityExtraParam implements Serializable {
        private final boolean isFromMe;
        private final boolean isMultiResourceMsg;
        private final boolean isPreMsg;

        public AuthorityExtraParam(boolean r100, boolean r101) {
            this(r100, r101, false, 4, null);
        }

        public static /* synthetic */ AuthorityExtraParam copy$default(AuthorityExtraParam r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.isPreMsg;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.isFromMe;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.isMultiResourceMsg;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final boolean component1() {
            return this.isPreMsg;
        }

        public final boolean component2() {
            return this.isFromMe;
        }

        public final boolean component3() {
            return this.isMultiResourceMsg;
        }

        public final AuthorityExtraParam copy(boolean r100, boolean r101, boolean r102) {
            return new AuthorityExtraParam(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AuthorityExtraParam) == true) goto L8;
            return false;
        L8:
            AuthorityExtraParam r101 = (AuthorityExtraParam) r100;
            if (this.isPreMsg == r101.isPreMsg) goto L12;
            return false;
        L12:
            if (this.isFromMe == r101.isFromMe) goto L15;
            return false;
        L15:
            if (this.isMultiResourceMsg == r101.isMultiResourceMsg) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = 1231;
            if (this.isPreMsg == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.isFromMe == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.isMultiResourceMsg == true) goto L15;
            r100 = 1237;
        L15:
            return r104 + r100;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            return "AuthorityExtraParam(isPreMsg=" + this.isPreMsg + ", isFromMe=" + this.isFromMe + ", isMultiResourceMsg=" + this.isMultiResourceMsg + ')';
        }

        public final boolean isFromMe() {
            return this.isFromMe;
        }

        public final boolean isMultiResourceMsg() {
            return this.isMultiResourceMsg;
        }

        public final boolean isPreMsg() {
            return this.isPreMsg;
        }

        public AuthorityExtraParam(boolean r100, boolean r101, boolean r102) {
            this.isPreMsg = r100;
            this.isFromMe = r101;
            this.isMultiResourceMsg = r102;
        }

        public /* synthetic */ AuthorityExtraParam(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = false;
        L5:
            this(r100, r101, r102);
        }
    }

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/AuthorityParam$Companion$AuthScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AUTHORITY_PARAM_PATCHER", "IM_FILE_AUTHORITY_INTERCEPTOR", "IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR", "THREAD_MERGE_FORWARD_AUTHORITY_UTIL", "MESSAGE_AUTHORITY_HELPER", "TOP_NOTICE_MESSAGE", "FAVORITE_IM_FILE_AUTHORITY_INTERCEPTOR", "THREAD_DETAIL_FILE_AUTHORITY_INTERCEPTOR", "THREAD_WINDOW_FILE_AUTHORITY_INTERCEPTOR", "FLAG_DATA_INTERCEPTOR", "IM_FILE_AUTH_INTERCEPTOR", "IM_FILE_LIST_AUTH", "toString", "", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum AuthScene extends Enum<AuthScene> {
            public static final AuthScene AUTHORITY_PARAM_PATCHER = null;
            public static final AuthScene FAVORITE_IM_FILE_AUTHORITY_INTERCEPTOR = null;
            public static final AuthScene FLAG_DATA_INTERCEPTOR = null;
            public static final AuthScene IM_FILE_AUTHORITY_INTERCEPTOR = null;
            public static final AuthScene IM_FILE_AUTH_INTERCEPTOR = null;
            public static final AuthScene IM_FILE_LIST_AUTH = null;
            public static final AuthScene IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR = null;
            public static final AuthScene MESSAGE_AUTHORITY_HELPER = null;
            public static final AuthScene THREAD_DETAIL_FILE_AUTHORITY_INTERCEPTOR = null;
            public static final AuthScene THREAD_MERGE_FORWARD_AUTHORITY_UTIL = null;
            public static final AuthScene THREAD_WINDOW_FILE_AUTHORITY_INTERCEPTOR = null;
            public static final AuthScene TOP_NOTICE_MESSAGE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ AuthScene[] f409669a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f409670b = null;
            private final int value;

            public static EnumEntries<AuthScene> getEntries() {
                return f409670b;
            }

            static {
                AuthScene r100 = new AuthScene("AUTHORITY_PARAM_PATCHER", 0, 0);
                AUTHORITY_PARAM_PATCHER = r100;
                AuthScene r101 = new AuthScene("IM_FILE_AUTHORITY_INTERCEPTOR", 1, 1);
                IM_FILE_AUTHORITY_INTERCEPTOR = r101;
                AuthScene r102 = new AuthScene("IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR", 2, 2);
                IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR = r102;
                AuthScene r103 = new AuthScene("THREAD_MERGE_FORWARD_AUTHORITY_UTIL", 3, 3);
                THREAD_MERGE_FORWARD_AUTHORITY_UTIL = r103;
                AuthScene r104 = new AuthScene("MESSAGE_AUTHORITY_HELPER", 4, 4);
                MESSAGE_AUTHORITY_HELPER = r104;
                AuthScene r105 = new AuthScene("TOP_NOTICE_MESSAGE", 5, 5);
                TOP_NOTICE_MESSAGE = r105;
                AuthScene r110 = new AuthScene("FAVORITE_IM_FILE_AUTHORITY_INTERCEPTOR", 6, 6);
                FAVORITE_IM_FILE_AUTHORITY_INTERCEPTOR = r110;
                AuthScene r111 = new AuthScene("THREAD_DETAIL_FILE_AUTHORITY_INTERCEPTOR", 7, 7);
                THREAD_DETAIL_FILE_AUTHORITY_INTERCEPTOR = r111;
                AuthScene r112 = new AuthScene("THREAD_WINDOW_FILE_AUTHORITY_INTERCEPTOR", 8, 8);
                THREAD_WINDOW_FILE_AUTHORITY_INTERCEPTOR = r112;
                AuthScene r113 = new AuthScene("FLAG_DATA_INTERCEPTOR", 9, 9);
                FLAG_DATA_INTERCEPTOR = r113;
                AuthScene r114 = new AuthScene("IM_FILE_AUTH_INTERCEPTOR", 10, 10);
                IM_FILE_AUTH_INTERCEPTOR = r114;
                AuthScene r115 = new AuthScene("IM_FILE_LIST_AUTH", 11, 11);
                IM_FILE_LIST_AUTH = r115;
                AuthScene[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
                f409669a = r106;
                f409670b = EnumEntriesKt.enumEntries(r106);
            }

            public static AuthScene[] values() {
                return (AuthScene[]) f409669a.clone();
            }

            @Override // java.lang.Enum
            public String toString() {
                return name();
            }

            public final int getValue() {
                return this.value;
            }

            public static AuthScene valueOf(String r100) {
                return (AuthScene) r27.a.a(AuthScene.class, r100);
            }

            public AuthScene(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static long a(String r100, AuthScene r101) {
            Intrinsics.checkNotNullParameter(r101, "authScene");
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L10:
            if (r102 == false) goto L17;
            Log.i("AuthorityParam", "param is null or empty for " + r101.name() + '.');
            return 0;
        L17:
            return CastLongProtector.parseLong(r100);
        L15:
            Log.i("AuthorityParam", "number format exception occurs for " + r101.name() + '.');
            return 0;
        L5:
            if (r100.length() == 0) goto L8;
            r102 = false;
            goto L10
        }

        public static void b(AuthScene r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "authScene");
            Intrinsics.checkNotNullParameter(r101, "descriptionTenantId");
            Log.i("AuthorityParam", "authScene is: " + r100.name());
            Log.i("AuthorityParam", "descriptionTenantId is: " + r101 + '.');
        }

        @JvmStatic
        public static IMFileEntity c(AuthorityParam r210, String r211) {
            Intrinsics.checkNotNullParameter(r210, "<this>");
            IMFileEntity r100 = new IMFileEntity("IM_MSG_FILE", ImFileAuthorityChecker.f409627f, "IM_MSG_FILE_READ", r210.f409664e, r210.f409665f, ImFileAuthorityChecker.f409628g, r210.f409663d, r210.f409662c, r210.f409660a, null, null, null, null, null, null, 32256, null);
            int r101 = AuthorityParam.f409659j;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("admin.policycenter.imfilecontrol") == false) goto L5;
            r100.setScopedFileBizDomain(FileBizDomain.FileBizDomainIM);
            r100.setScopedEntityOperate("IM_MSG_FILE_PREVIEW");
            r100.setScopedEntityType("IM_MSG_FILE");
            r100.setFileKey(r211);
        L5:
            return r100;
        }

        @JvmStatic
        public static PolicyModel d(AuthorityParam r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return new PolicyModel("PointKey_IM_MSG_FILE_READ", c(r100, r101), null, 4, null);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f409671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f409672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f409673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f409674d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f409675e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f409676f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Long f409677g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<String> f409678h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public AuthorityExtraParam f409679i;

        public final AuthorityParam a() {
            String r100 = this.f409671a;
            String r101 = this.f409672b;
            Long r102 = this.f409673c;
            Long r103 = this.f409674d;
            long r104 = this.f409675e;
            long r105 = this.f409676f;
            AuthorityExtraParam r110 = this.f409679i;
            return new AuthorityParam(r100, r101, r102, r103, r104, r105, this.f409677g, this.f409678h, r110);
        }

        public a() {
            this.f409677g = 0L;
            this.f409678h = new ArrayList();
            this.f409679i = new AuthorityExtraParam(true, true, false, 4, null);
        }
    }

    static {
    }

    public final String toString() {
        return "AuthorityParam(msgId=" + this.f409660a + ",chatId =" + this.f409661b + ",chatType =" + this.f409666g + ",senderTenantId=" + this.f409662c + ", senderUserId=" + this.f409663d + ", operatorTenantId=" + this.f409664e + ", operatorUid=" + this.f409665f + ", authorityExtraParam=" + this.f409668i + ", fileKeys=" + this.f409667h + ')';
    }

    public AuthorityParam(String r100, String r101, Long r102, Long r103, long r104, long r105, Long r110, List<String> r111, AuthorityExtraParam r112) {
        Intrinsics.checkNotNullParameter(r111, "fileKeys");
        Intrinsics.checkNotNullParameter(r112, "authorityExtraParam");
        this.f409660a = r100;
        this.f409661b = r101;
        this.f409662c = r102;
        this.f409663d = r103;
        this.f409664e = r104;
        this.f409665f = r105;
        this.f409666g = r110;
        this.f409667h = r111;
        this.f409668i = r112;
    }
}
