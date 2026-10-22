package org.bouncycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* JADX INFO: loaded from: classes42.dex */
public class LocaleString extends LocalizedMessage {
    public LocaleString(String r100, String r101) {
        super(r100, r101);
    }

    public LocaleString(String r100, String r101, String r102) throws NullPointerException, UnsupportedEncodingException {
        super(r100, r101, r102);
    }

    public LocaleString(String r100, String r101, String r102, Object[] r103) throws NullPointerException, UnsupportedEncodingException {
        super(r100, r101, r102, r103);
    }

    public String getLocaleString(Locale r100) {
        return getEntry(null, r100, null);
    }
}
