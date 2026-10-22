package sa5;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i extends qu5.a {

    public static final class a implements qu5.a.InterfaceC7393a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.passportc.api.m f541170a;

        @Override // qu5.a.InterfaceC7393a
        public final String getToken() {
            String r100 = this.f541170a.getUser().getSession();
            if (TextUtils.isEmpty(r100) == false) goto L5;
            tt5.a.d("CCMUserCookiesAdapter", "getToken is empty");
        L5:
            if (r100 != null) goto L8;
            return "";
        L8:
            return r100;
        }

        @Override // qu5.a.InterfaceC7393a
        public final Locale getLocale() {
            yob.e.a().getClass();
            int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
            Locale r101 = com.ss.android.lark.language.service.impl.a.b.f431098a.getLanguageSetting();
            if (r101 == null) goto L5;
            return r101;
        L5:
            return Locale.ENGLISH;
        }

        public a(com.ss.android.lark.passportc.api.m r100) {
            this.f541170a = r100;
        }
    }

    public static final class b {
    }

    static {
    }

    public i(com.ss.android.lark.passportc.api.m r100) {
        Intrinsics.checkNotNullParameter(r100, "passportUserService");
        super(new a(r100));
    }
}
