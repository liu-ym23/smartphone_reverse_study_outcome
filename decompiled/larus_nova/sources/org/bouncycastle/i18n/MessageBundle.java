package org.bouncycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes42.dex */
public class MessageBundle extends TextBundle {
    public static final String TITLE_ENTRY = "title";

    public MessageBundle(String r100, String r101) throws NullPointerException {
        super(r100, r101);
    }

    public MessageBundle(String r100, String r101, String r102) throws NullPointerException, UnsupportedEncodingException {
        super(r100, r101, r102);
    }

    public MessageBundle(String r100, String r101, String r102, Object[] r103) throws NullPointerException, UnsupportedEncodingException {
        super(r100, r101, r102, r103);
    }

    public MessageBundle(String r100, String r101, Object[] r102) throws NullPointerException {
        super(r100, r101, r102);
    }

    public String getTitle(Locale r100) throws MissingEntryException {
        return getEntry("title", r100, TimeZone.getDefault());
    }

    public String getTitle(Locale r100, TimeZone r101) throws MissingEntryException {
        return getEntry("title", r100, r101);
    }
}
