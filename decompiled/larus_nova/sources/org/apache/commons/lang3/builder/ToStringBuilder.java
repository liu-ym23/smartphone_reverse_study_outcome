package org.apache.commons.lang3.builder;

/* JADX INFO: loaded from: classes42.dex */
public class ToStringBuilder {
    private static volatile ToStringStyle defaultStyle;
    private final StringBuffer buffer;
    private final Object object;
    private final ToStringStyle style;

    static {
        defaultStyle = ToStringStyle.DEFAULT_STYLE;
    }

    public String build() {
        return toString();
    }

    public String toString() {
        if (getObject() != null) goto L5;
        getStringBuffer().append(getStyle().getNullText());
    L7:
        return getStringBuffer().toString();
    L5:
        this.style.appendEnd(getStringBuffer(), getObject());
        goto L7
    }

    public static ToStringStyle getDefaultStyle() {
        return defaultStyle;
    }

    public Object getObject() {
        return this.object;
    }

    public StringBuffer getStringBuffer() {
        return this.buffer;
    }

    public ToStringStyle getStyle() {
        return this.style;
    }

    public ToStringBuilder(Object r100, ToStringStyle r101) {
        this(r100, r101, null);
    }

    public ToStringBuilder append(String r100, Object r101) {
        this.style.append(this.buffer, r100, r101, null);
        return this;
    }

    public ToStringBuilder(Object r100, ToStringStyle r101, StringBuffer r102) {
        if (r101 != null) goto L5;
        r101 = getDefaultStyle();
    L5:
        if (r102 != null) goto L7;
        r102 = new StringBuffer(512);
    L7:
        this.buffer = r102;
        this.style = r101;
        this.object = r100;
        r101.appendStart(r102, r100);
    }

    public ToStringBuilder append(String r100, Object r101, boolean r102) {
        this.style.append(this.buffer, r100, r101, Boolean.valueOf(r102));
        return this;
    }
}
