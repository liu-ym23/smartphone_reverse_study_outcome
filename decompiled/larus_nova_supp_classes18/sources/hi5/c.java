package hi5;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.bytedance.ee.bear.list.u4;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    static {
    }

    @JvmStatic
    public static final String b(PolicyAgreement r3) {
        Intrinsics.checkNotNullParameter(r3, "policyAgreement");
        String r0 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.k.class, null, null, 6)).getPolicyUrl(r3);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        tt5.a.h("ChoosePolicyUtil", "getPolicyUrl policyAgreement:" + r3 + " url:" + r0);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    @JvmStatic
    public static final void a(TextView r22, Context r23, int r24, String r25, b r26) {
        String r2 = r25;
        Intrinsics.checkNotNullParameter(r2, "contentStr");
        Intrinsics.checkNotNullParameter(r26, "listener");
        if (r22 == 0) goto L30;
        if (r23 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r25) == true) goto L33;
        String r10 = r23.getResources().getString(2131888243);
        String r9 = r23.getResources().getString(2131888237);
        u4.a.getClass();
        String r17 = u4.a(r23, r24);
        int r18 = r10.length();
        int r19 = r9.length();
        boolean r20 = StringsKt.contains$default(r2, "{{serviceTerm}}", false, 2, null);
        boolean r21 = StringsKt.contains$default(r2, "{{privacy}}", false, 2, null);
        if (r20 == false) goto L11;
        r2 = StringsKt.replace$default(r25, "{{serviceTerm}}", r10, false, 4, null);
    L11:
        String r11 = r2;
        if (r21 == false) goto L14;
        int r5 = 2;
        ?? r3 = 0;
        r11 = StringsKt.replace$default(r11, "{{privacy}}", r9, false, 4, null);
    L16:
        if (StringsKt.contains$default(r11, "{{doc_type}}", r3, r5, 0) == false) goto L18;
        r11 = StringsKt.replace$default(r11, "{{doc_type}}", r17, false, 4, null);
    L18:
        String r4 = r11;
        int r6 = StringsKt.indexOf$default(r4, r9, 0, false, 6, null);
        int r7 = StringsKt.indexOf$default(r4, r10, 0, false, 6, null);
        SpannableString r8 = new SpannableString(r4);
        if (r20 == false) goto L22;
        if (r7 < 0) goto L22;
        r8.setSpan(new y(r23, new hi5.a(r26)), r7, r7 + r18, 33);
    L22:
        if (r21 == false) goto L25;
        if (r6 < 0) goto L25;
        r8.setSpan(new y(r23, new hi5.b(r26)), r6, r6 + r19, 33);
    L25:
        r22.setText(r8);
        if (r20 == true) goto L28;
        if (r21 == true) goto L28;
        return;
    L28:
        r22.setMovementMethod(LinkMovementMethod.getInstance());
        r22.setHighlightColor(r3);
        return;
    L14:
        r3 = 0;
        r5 = 2;
        goto L16
    L33:
        return;
    }
}
