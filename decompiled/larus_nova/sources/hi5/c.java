package hi5;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.bytedance.ee.bear.list.u4;
import com.larus.nova.R;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f485276a = 0;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    static {
    }

    @JvmStatic
    public static final String b(PolicyAgreement r100) {
        Intrinsics.checkNotNullParameter(r100, "policyAgreement");
        String r101 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.k.class, null, null, 6)).getPolicyUrl(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        tt5.a.h("ChoosePolicyUtil", "getPolicyUrl policyAgreement:" + r100 + " url:" + r101);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    @JvmStatic
    public static final void a(TextView r210, Context r211, int r212, String r213, b r214) {
        String r100 = r213;
        Intrinsics.checkNotNullParameter(r100, "contentStr");
        Intrinsics.checkNotNullParameter(r214, "listener");
        if (r210 == 0) goto L30;
        if (r211 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r213) == true) goto L33;
        String r110 = r211.getResources().getString(R.string.Doc_Share_ServiceTerm);
        String r101 = r211.getResources().getString(R.string.Doc_Share_Privacy);
        u4.f229807a.getClass();
        String r111 = u4.a(r211, r212);
        int r112 = r110.length();
        int r113 = r101.length();
        boolean r215 = StringsKt.contains$default(r100, "{{serviceTerm}}", false, 2, null);
        boolean r216 = StringsKt.contains$default(r100, "{{privacy}}", false, 2, null);
        if (r215 == false) goto L11;
        r100 = StringsKt.replace$default(r213, "{{serviceTerm}}", r110, false, 4, null);
    L11:
        String r114 = r100;
        if (r216 == false) goto L14;
        int r102 = 2;
        ?? r103 = 0;
        r114 = StringsKt.replace$default(r114, "{{privacy}}", r101, false, 4, null);
    L16:
        if (StringsKt.contains$default(r114, "{{doc_type}}", r103, r102, 0) == false) goto L18;
        r114 = StringsKt.replace$default(r114, "{{doc_type}}", r111, false, 4, null);
    L18:
        String r104 = r114;
        int r105 = StringsKt.indexOf$default(r104, r101, 0, false, 6, null);
        int r106 = StringsKt.indexOf$default(r104, r110, 0, false, 6, null);
        SpannableString r107 = new SpannableString(r104);
        if (r215 == false) goto L22;
        if (r106 < 0) goto L22;
        r107.setSpan(new y(r211, new hi5.a(r214)), r106, r106 + r112, 33);
    L22:
        if (r216 == false) goto L25;
        if (r105 < 0) goto L25;
        r107.setSpan(new y(r211, new hi5.b(r214)), r105, r105 + r113, 33);
    L25:
        r210.setText(r107);
        if (r215 == true) goto L28;
        if (r216 == true) goto L28;
        return;
    L28:
        r210.setMovementMethod(LinkMovementMethod.getInstance());
        r210.setHighlightColor(r103);
        return;
    L14:
        r103 = 0;
        r102 = 2;
        goto L16
    L33:
        return;
    }
}
