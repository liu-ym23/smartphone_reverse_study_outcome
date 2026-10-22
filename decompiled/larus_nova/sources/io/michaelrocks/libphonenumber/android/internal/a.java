package io.michaelrocks.libphonenumber.android.internal;

import io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneNumberDesc;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RegexCache f492258a;

    public a() {
        this.f492258a = new RegexCache(100);
    }

    public final boolean a(CharSequence r100, Phonemetadata$PhoneNumberDesc r101) {
        String r102 = r101.getNationalNumberPattern();
        if (r102.length() != 0) goto L5;
        return false;
    L5:
        Matcher r103 = this.f492258a.a(r102).matcher(r100);
        if (r103.lookingAt() == true) goto L9;
        return false;
    L9:
        return r103.matches();
    }
}
