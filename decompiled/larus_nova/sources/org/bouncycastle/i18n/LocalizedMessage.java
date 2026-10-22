package org.bouncycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.bouncycastle.i18n.filter.Filter;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.i18n.filter.UntrustedUrlInput;

/* JADX INFO: loaded from: classes42.dex */
public class LocalizedMessage {
    public static final String DEFAULT_ENCODING = "ISO-8859-1";
    protected FilteredArguments arguments;
    protected String encoding;
    protected FilteredArguments extraArgs;
    protected Filter filter;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    protected final String f525346id;
    protected ClassLoader loader;
    protected final String resource;

    public class FilteredArguments {
        protected static final int FILTER = 1;
        protected static final int FILTER_URL = 2;
        protected static final int NO_FILTER = 0;
        protected int[] argFilterType;
        protected Object[] arguments;
        protected Filter filter;
        protected Object[] filteredArgs;
        protected boolean[] isLocaleSpecific;
        final /* synthetic */ LocalizedMessage this$0;
        protected Object[] unpackedArgs;

        public FilteredArguments(LocalizedMessage r100) {
            this(r100, new Object[0]);
        }

        public FilteredArguments(LocalizedMessage r100, Object[] r101) {
            this.this$0 = r100;
            this.filter = null;
            this.arguments = r101;
            this.unpackedArgs = new Object[r101.length];
            this.filteredArgs = new Object[r101.length];
            this.isLocaleSpecific = new boolean[r101.length];
            this.argFilterType = new int[r101.length];
            int r102 = 0;
        L4:
            if (r102 >= r101.length) goto L16;
            Object r103 = r101[r102];
            if ((r103 instanceof TrustedInput) == false) goto L9;
            this.unpackedArgs[r102] = ((TrustedInput) r103).getInput();
            this.argFilterType[r102] = 0;
        L15:
            this.isLocaleSpecific[r102] = this.unpackedArgs[r102] instanceof LocaleString;
            r102 = r102 + 1;
            goto L4
        L9:
            if ((r103 instanceof UntrustedInput) == false) goto L14;
            this.unpackedArgs[r102] = ((UntrustedInput) r103).getInput();
            if ((r101[r102] instanceof UntrustedUrlInput) == false) goto L13;
            this.argFilterType[r102] = 2;
            goto L15
        L13:
            this.argFilterType[r102] = 1;
            goto L15
        L14:
            this.unpackedArgs[r102] = r103;
            this.argFilterType[r102] = 1;
            goto L15
        }

        private Object filter(int r100, Object r101) {
            Filter r102 = this.filter;
            if (r102 == null) goto L17;
            if (r101 != null) goto L6;
            r101 = "null";
        L6:
            if (r100 == 0) goto L17;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            return null;
        L14:
            return r102.doFilterUrl(r101.toString());
        L16:
            return r102.doFilter(r101.toString());
        L17:
            return r101;
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        public Filter getFilter() {
            return this.filter;
        }

        public Object[] getFilteredArgs(Locale r100) {
            Object[] r101 = new Object[this.unpackedArgs.length];
            int r102 = 0;
        L3:
            Object[] r103 = this.unpackedArgs;
            if (r102 >= r103.length) goto L13;
            Object r104 = this.filteredArgs[r102];
            if (r104 != null) goto L12;
            Object r105 = r103[r102];
            if (this.isLocaleSpecific[r102] == false) goto L11;
            String r106 = ((LocaleString) r105).getLocaleString(r100);
            r104 = filter(this.argFilterType[r102], r106);
            goto L12
        L11:
            r104 = filter(this.argFilterType[r102], r105);
            this.filteredArgs[r102] = r104;
        L12:
            r101[r102] = r104;
            r102 = r102 + 1;
            goto L3
        L13:
            return r101;
        }

        public boolean isEmpty() {
            if (this.unpackedArgs.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void setFilter(Filter r100) {
            if (r100 == this.filter) goto L8;
            int r101 = 0;
        L6:
            if (r101 >= this.unpackedArgs.length) goto L8;
            this.filteredArgs[r101] = null;
            r101 = r101 + 1;
        L8:
            this.filter = r100;
        }
    }

    public LocalizedMessage(String r100, String r101) throws NullPointerException {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.filter = null;
        this.loader = null;
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        this.f525346id = r101;
        this.resource = r100;
        this.arguments = new FilteredArguments(this);
        return;
    L8:
        throw null;
    L7:
        throw null;
    }

    public LocalizedMessage(String r100, String r101, String r102) throws NullPointerException, UnsupportedEncodingException {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.filter = null;
        this.loader = null;
        if (r100 == null) goto L11;
        if (r101 == null) goto L12;
        this.f525346id = r101;
        this.resource = r100;
        this.arguments = new FilteredArguments(this);
        if (Charset.isSupported(r102) == false) goto L10;
        this.encoding = r102;
        return;
    L10:
        throw new UnsupportedEncodingException("The encoding \"" + r102 + "\" is not supported.");
    L12:
        throw null;
    L11:
        throw null;
    }

    public LocalizedMessage(String r100, String r101, String r102, Object[] r103) throws NullPointerException, UnsupportedEncodingException {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.filter = null;
        this.loader = null;
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        if (r103 == null) goto L14;
        this.f525346id = r101;
        this.resource = r100;
        this.arguments = new FilteredArguments(this, r103);
        if (Charset.isSupported(r102) == false) goto L11;
        this.encoding = r102;
        return;
    L11:
        throw new UnsupportedEncodingException("The encoding \"" + r102 + "\" is not supported.");
    L14:
        throw null;
    L13:
        throw null;
    L12:
        throw null;
    }

    public LocalizedMessage(String r100, String r101, Object[] r102) throws NullPointerException {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.filter = null;
        this.loader = null;
        if (r100 == null) goto L8;
        if (r101 == null) goto L9;
        if (r102 == null) goto L10;
        this.f525346id = r101;
        this.resource = r100;
        this.arguments = new FilteredArguments(this, r102);
        return;
    L10:
        throw null;
    L9:
        throw null;
    L8:
        throw null;
    }

    public String addExtraArgs(String r100, Locale r101) {
        if (this.extraArgs == null) goto L11;
        StringBuffer r102 = new StringBuffer(r100);
        Object[] r103 = this.extraArgs.getFilteredArgs(r101);
        int r104 = 0;
    L6:
        if (r104 >= r103.length) goto L9;
        r102.append(r103[r104]);
        r104 = r104 + 1;
        goto L6
    L9:
        return r102.toString();
    L11:
        return r100;
    }

    public String formatWithTimeZone(String r100, Object[] r101, Locale r102, TimeZone r103) {
        MessageFormat r104 = new MessageFormat(" ");
        r104.setLocale(r102);
        r104.applyPattern(r100);
        if (r103.equals(TimeZone.getDefault()) == true) goto L12;
        Format[] r105 = r104.getFormats();
        int r106 = 0;
    L6:
        if (r106 >= r105.length) goto L12;
        Format r107 = r105[r106];
        if ((r107 instanceof DateFormat) == false) goto L10;
        DateFormat r108 = (DateFormat) r107;
        r108.setTimeZone(r103);
        r104.setFormat(r106, r108);
    L10:
        r106 = r106 + 1;
    L12:
        return r104.format(r101);
    }

    public Object[] getArguments() {
        return this.arguments.getArguments();
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getEntry(String r110, Locale r111, TimeZone r112) throws MissingEntryException {
        String r100 = this.f525346id;
        if (r110 == null) goto L5;
        r100 = r100 + "." + r110;
    L5:
        String r101 = r100;
        ClassLoader r113 = this.loader;     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
        if (r113 != null) goto L9;
        ResourceBundle r114 = ResourceBundle.getBundle(this.resource, r111);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
    L10:
        String r115 = r114.getString(r101);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
        if (this.encoding.equals("ISO-8859-1") == true) goto L14;
        r115 = new String(r115.getBytes("ISO-8859-1"), this.encoding);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
    L14:
        if (this.arguments.isEmpty() == true) goto L16;
        r115 = formatWithTimeZone(r115, this.arguments.getFilteredArgs(r111), r111, r112);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
    L16:
        return addExtraArgs(r115, r111);
    L9:
        r114 = ResourceBundle.getBundle(this.resource, r111, r113);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L21:
        String r102 = "Can't find entry " + r101 + " in resource file " + this.resource + ".";
        String r103 = this.resource;
        ClassLoader r116 = this.loader;
        if (r116 != null) goto L26;
        r116 = getClassLoader();
    L26:
        throw new MissingEntryException(r102, r103, r101, r111, r116);
    }

    public Object[] getExtraArgs() {
        FilteredArguments r100 = this.extraArgs;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getArguments();
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String getId() {
        return this.f525346id;
    }

    public String getResource() {
        return this.resource;
    }

    public void setClassLoader(ClassLoader r100) {
        this.loader = r100;
    }

    public void setExtraArgument(Object r100) {
        setExtraArguments(new Object[]{r100});
    }

    public void setExtraArguments(Object[] r100) {
        if (r100 == null) goto L4;
        FilteredArguments r101 = new FilteredArguments(this, r100);
        this.extraArgs = r101;
        r101.setFilter(this.filter);
        return;
    L4:
        this.extraArgs = null;
    }

    public void setFilter(Filter r100) {
        this.arguments.setFilter(r100);
        FilteredArguments r101 = this.extraArgs;
        if (r101 == null) goto L5;
        r101.setFilter(r100);
    L5:
        this.filter = r100;
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("Resource: \"");
        r100.append(this.resource);
        r100.append("\" Id: \"");
        r100.append(this.f525346id);
        r100.append("\" Arguments: ");
        r100.append(this.arguments.getArguments().length);
        r100.append(" normal");
        FilteredArguments r101 = this.extraArgs;
        if (r101 != null) goto L5;
    L7:
        r100.append(" Encoding: ");
        r100.append(this.encoding);
        r100.append(" ClassLoader: ");
        r100.append(this.loader);
        return r100.toString();
    L5:
        if (r101.getArguments().length <= 0) goto L7;
        r100.append(", ");
        r100.append(this.extraArgs.getArguments().length);
        r100.append(" extra");
        goto L7
    }
}
