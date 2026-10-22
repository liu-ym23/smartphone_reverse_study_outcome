package com.ss.android.lark.conditional.access.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class PrivacyPolicyUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f418469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f418470b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/PrivacyPolicyUtils$PolicyType;", "", "<init>", "(Ljava/lang/String;I)V", "SERVICE_TERM", "PRIVACY", "AGREEMENT", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PolicyType extends Enum<PolicyType> {
        public static final PolicyType AGREEMENT = null;
        public static final PolicyType PRIVACY = null;
        public static final PolicyType SERVICE_TERM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PolicyType[] f418471a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f418472b = null;

        public static EnumEntries<PolicyType> getEntries() {
            return f418472b;
        }

        static {
            PolicyType r100 = new PolicyType("SERVICE_TERM", 0);
            SERVICE_TERM = r100;
            PolicyType r101 = new PolicyType("PRIVACY", 1);
            PRIVACY = r101;
            PolicyType r102 = new PolicyType("AGREEMENT", 2);
            AGREEMENT = r102;
            PolicyType[] r103 = {r100, r101, r102};
            f418471a = r103;
            f418472b = EnumEntriesKt.enumEntries(r103);
        }

        public static PolicyType[] values() {
            return (PolicyType[]) f418471a.clone();
        }

        public static PolicyType valueOf(String r100) {
            return (PolicyType) r27.a.a(PolicyType.class, r100);
        }

        public PolicyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f418473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f418474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<PolicyType, b> f418475c;

        public a(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f418473a = r100;
            this.f418474b = r101;
            LinkedHashMap r102 = new LinkedHashMap();
            this.f418475c = r102;
            String[] r103 = PrivacyPolicyUtils.f418469a;
            int r104 = g8b.b.f480460a;
            g8b.b.a.a().getDependency().getPassportDependency().c(PolicyAgreement.SERVICE_TERM);
            b r105 = new b(r100.getString(R.string.Lark_Conditions_UserAgreement), "");
            r102.put(PolicyType.SERVICE_TERM, r105);
            g8b.b.a.a().getDependency().getPassportDependency().c(PolicyAgreement.PRIVACY);
            b r106 = new b(r100.getString(R.string.Lark_Conditions_PrivacyPrivy), "");
            r102.put(PolicyType.PRIVACY, r106);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f418476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f418477b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f418476a, r101.f418476a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f418477b, r101.f418477b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f418476a.hashCode() * 31) + this.f418477b.hashCode();
        }

        public final String toString() {
            return "Policy(replacement=" + this.f418476a + ", url=" + this.f418477b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "replacement");
            Intrinsics.checkNotNullParameter(r101, "url");
            this.f418476a = r100;
            this.f418477b = r101;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f418478d;

        public final void a() {
            TextView r100 = this.f418478d;
            String[] r101 = PrivacyPolicyUtils.f418469a;
            Intrinsics.checkNotNullParameter(r100, CommonCmd.AIDL_PLATFORM_TYPE_TV);
            r100.setMovementMethod(LinkMovementMethod.getInstance());
            r100.setHighlightColor(0);
            TextView r102 = this.f418478d;
            Context r103 = this.f418473a;
            int r104 = this.f418474b;
            Map<PolicyType, b> r105 = this.f418475c;
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            SpannableStringBuilder r106 = new SpannableStringBuilder();
            r106.append(r103.getString(r104));
            if (r105 == null) goto L6;
            LinkedHashMap r107 = (LinkedHashMap) r105;
            b r108 = (b) r107.get(PolicyType.SERVICE_TERM);
            if (r108 == null) goto L6;
        L7:
            PrivacyPolicyUtils.a(r103, r106, PrivacyPolicyUtils.f418469a, PolicyType.SERVICE_TERM, r108);
            if (r105 == null) goto L11;
            LinkedHashMap r109 = (LinkedHashMap) r105;
            b r110 = (b) r109.get(PolicyType.PRIVACY);
            if (r110 == null) goto L11;
        L12:
            PrivacyPolicyUtils.a(r103, r106, PrivacyPolicyUtils.f418470b, PolicyType.PRIVACY, r110);
            r102.setText(r106);
            return;
        L11:
            int r111 = g8b.b.f480460a;
            g8b.b.a.a().getDependency().getPassportDependency().c(PolicyAgreement.PRIVACY);
            r110 = new b(r103.getString(R.string.Lark_Conditions_PrivacyPrivy), "");
        L6:
            int r112 = g8b.b.f480460a;
            g8b.b.a.a().getDependency().getPassportDependency().c(PolicyAgreement.SERVICE_TERM);
            r108 = new b(r103.getString(R.string.Lark_Conditions_UserAgreement), "");
            goto L7
        }

        public c(TextView r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "textView");
            super(r100.getContext(), r101);
            this.f418478d = r100;
        }
    }

    static {
        f418469a = new String[]{"{{serviceTerm}}", "{{termService}}", "{{UserAgreement}}"};
        f418470b = new String[]{"{{privacy}}", "{{privacyPolicy}}", "{{PrivacyPolicy}}"};
    }

    public static void a(final Context r100, SpannableStringBuilder r101, String[] r102, final PolicyType r110, final b r111) {
        final Function1 r103 = null;
        Function0<CharSequence> r104 = new PrivacyPolicyUtils$mustache$provider$1(r100, r111, r103, r110);
        int r105 = r102.length;
        int r112 = 0;
    L3:
        if (r112 >= r105) goto L9;
        String r113 = r102[r112];
        int r106 = StringsKt.indexOf$default(r101, r113, 0, false, 6, null);
        if (r106 < 0) goto L8;
        r101.replace(r106, r113.length() + r106, r104.invoke());
    L8:
        r112 = r112 + 1;
        goto L3
    }
}
