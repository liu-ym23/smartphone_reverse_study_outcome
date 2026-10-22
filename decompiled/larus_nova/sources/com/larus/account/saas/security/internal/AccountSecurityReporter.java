package com.larus.account.saas.security.internal;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.larus.account.saas.security.model.AccountSecurityEventType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class AccountSecurityReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccountSecurityObservationStore f286500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f286501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f286502c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;", "", "", "inObservation", "Z", "b", "()Z", "", "observationRemainingSeconds", "J", "c", "()J", "chatMessageCountThreshold", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {

        @SerializedName("chat_message_count_threshold")
        private final long chatMessageCountThreshold;

        @SerializedName("is_in_observation")
        private final boolean inObservation;

        @SerializedName("observation_remaining_seconds")
        private final long observationRemainingSeconds;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.inObservation == r101.inObservation) goto L12;
            return false;
        L12:
            if (this.observationRemainingSeconds == r101.observationRemainingSeconds) goto L15;
            return false;
        L15:
            if (this.chatMessageCountThreshold == r101.chatMessageCountThreshold) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean r100 = this.inObservation;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            long r102 = this.observationRemainingSeconds;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.chatMessageCountThreshold;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        }

        public final String toString() {
            return "AccountSecurityBehaviorResponse(inObservation=" + this.inObservation + ", observationRemainingSeconds=" + this.observationRemainingSeconds + ", chatMessageCountThreshold=" + this.chatMessageCountThreshold + ')';
        }

        public a() {
            this.inObservation = false;
            this.observationRemainingSeconds = 0;
            this.chatMessageCountThreshold = 0;
        }

        public final long a() {
            return this.chatMessageCountThreshold;
        }

        public final boolean b() {
            return this.inObservation;
        }

        public final long c() {
            return this.observationRemainingSeconds;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e48.d f286503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f286504b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f286503a, r101.f286503a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286504b, r101.f286504b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f286503a.hashCode() * 31) + this.f286504b.hashCode();
        }

        public final String toString() {
            return "BehaviorReportPlan(event=" + this.f286503a + ", resultExtras=" + this.f286504b + ')';
        }

        public b(e48.d r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "resultExtras");
            this.f286503a = r100;
            this.f286504b = r101;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001:\u0001\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/account/saas/security/internal/AccountSecurityReporter$c;", "", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;", "data", "Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;", "setData", "(Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;)V", WsConstants.KEY_PAYLOAD, "getPayload", "setPayload", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {

        @SerializedName("code")
        private int code;

        @SerializedName("data")
        private a data;

        @SerializedName("msg")
        private String msg;

        @SerializedName(WsConstants.KEY_PAYLOAD)
        private String payload;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.code == r101.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.code * 31;
            String r101 = this.msg;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            a r105 = this.data;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.payload;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CommonResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", payload=" + this.payload + ')';
        }

        public c() {
            this.code = -999;
            this.msg = "";
            this.data = null;
            this.payload = null;
        }

        public final a a() {
            return this.data;
        }
    }

    public static final class d {
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f286505a = null;

        static {
            int[] r100 = new int[AccountSecurityEventType.values().length];
            r100[AccountSecurityEventType.BROWSE_EXCESSIVE_CHAT_HISTORY.ordinal()] = 1;
            f286505a = r100;
        }
    }

    static {
    }

    public AccountSecurityReporter(AccountSecurityObservationStore r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        this.f286500a = r100;
        this.f286501b = PThreadExecutorsUtils.newSingleThreadExecutor(new g());
        this.f286502c = LazyKt.lazy(AccountSecurityReporter$isReportEnabled$2.INSTANCE);
    }

    public static void a(String r100, e48.d r101, long r102, Map r103) {
        int r104 = com.larus.account.saas.security.internal.c.f286506a;
        com.larus.account.saas.security.internal.c.a(r100, MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", r101.f471001a.getValue()), TuplesKt.to("duration_ms", Long.valueOf(System.currentTimeMillis() - r102))}), r103));
    }
}
