package sa5;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends qu5.a {

    public static final class a implements qu5.a.a {
        public final /* synthetic */ com.ss.android.lark.passportc.api.m a;

        public final String getToken() {
            String r0 = this.a.getUser().getSession();
            if (TextUtils.isEmpty(r0) == false) goto L5;
            tt5.a.d("CCMUserCookiesAdapter", "getToken is empty");
        L5:
            if (r0 != null) goto L8;
            return "";
        L8:
            return r0;
        }

        public final Locale getLocale() {
            yob.e.a().getClass();
            int r0 = com.ss.android.lark.language.service.impl.a.f;
            Locale r1 = com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
            if (r1 == null) goto L5;
            return r1;
        L5:
            return Locale.ENGLISH;
        }

        public a(com.ss.android.lark.passportc.api.m r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    static {
    }

    public i(com.ss.android.lark.passportc.api.m r2) {
        Intrinsics.checkNotNullParameter(r2, "passportUserService");
        super(new a(r2));
    }
}
