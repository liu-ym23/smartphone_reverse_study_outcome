package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$Api24Impl {
    private AppCompatDelegateImpl$Api24Impl() {
    }

    public static void generateConfigDelta_locale(Configuration r1, Configuration r2, Configuration r3) {
        LocaleList r4 = r1.getLocales();
        LocaleList r0 = r2.getLocales();
        if (r4.equals(r0) == true) goto L6;
        r3.setLocales(r0);
        r3.locale = r2.locale;
        return;
    }
}
