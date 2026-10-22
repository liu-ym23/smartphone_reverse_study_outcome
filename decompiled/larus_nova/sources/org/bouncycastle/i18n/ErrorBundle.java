package org.bouncycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes42.dex */
public class ErrorBundle extends MessageBundle {
    public static final String DETAIL_ENTRY = "details";
    public static final String SUMMARY_ENTRY = "summary";

    public ErrorBundle(String r100, String r101) throws NullPointerException {
        super(r100, r101);
    }

    public ErrorBundle(String r100, String r101, String r102) throws NullPointerException, UnsupportedEncodingException {
        super(r100, r101, r102);
    }

    public ErrorBundle(String r100, String r101, String r102, Object[] r103) throws NullPointerException, UnsupportedEncodingException {
        super(r100, r101, r102, r103);
    }

    public ErrorBundle(String r100, String r101, Object[] r102) throws NullPointerException {
        super(r100, r101, r102);
    }

    public String getDetail(Locale r100) throws MissingEntryException {
        return getEntry("details", r100, TimeZone.getDefault());
    }

    public String getDetail(Locale r100, TimeZone r101) throws MissingEntryException {
        return getEntry("details", r100, r101);
    }

    public String getSummary(Locale r100) throws MissingEntryException {
        return getEntry("summary", r100, TimeZone.getDefault());
    }

    public String getSummary(Locale r100, TimeZone r101) throws MissingEntryException {
        return getEntry("summary", r100, r101);
    }
}
