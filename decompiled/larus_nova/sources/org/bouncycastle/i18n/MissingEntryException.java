package org.bouncycastle.i18n;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;

/* JADX INFO: loaded from: classes42.dex */
public class MissingEntryException extends RuntimeException {
    private String debugMsg;
    protected final String key;
    protected final ClassLoader loader;
    protected final Locale locale;
    protected final String resource;

    public MissingEntryException(String r100, String r101, String r102, Locale r103, ClassLoader r104) {
        super(r100);
        this.resource = r101;
        this.key = r102;
        this.locale = r103;
        this.loader = r104;
    }

    public MissingEntryException(String r100, Throwable r101, String r102, String r103, Locale r104, ClassLoader r105) {
        super(r100, r101);
        this.resource = r102;
        this.key = r103;
        this.locale = r104;
        this.loader = r105;
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getDebugMsg() {
        if (this.debugMsg != null) goto L11;
        this.debugMsg = "Can not find entry " + this.key + " in resource file " + this.resource + " for the locale " + this.locale + ".";
        ClassLoader r100 = this.loader;
        if ((r100 instanceof URLClassLoader) == false) goto L11;
        URL[] r101 = ((URLClassLoader) r100).getURLs();
        this.debugMsg += " The following entries in the classpath were searched: ";
        int r102 = 0;
    L8:
        if (r102 == r101.length) goto L11;
        this.debugMsg += r101[r102] + " ";
        r102 = r102 + 1;
    L11:
        return this.debugMsg;
    }

    public String getKey() {
        return this.key;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getResource() {
        return this.resource;
    }
}
