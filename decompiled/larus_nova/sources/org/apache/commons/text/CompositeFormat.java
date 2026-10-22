package org.apache.commons.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

/* JADX INFO: loaded from: classes42.dex */
public class CompositeFormat extends Format {
    private static final long serialVersionUID = -4329119827877627683L;
    private final Format formatter;
    private final Format parser;

    public Format getFormatter() {
        return this.formatter;
    }

    public Format getParser() {
        return this.parser;
    }

    public String reformat(String r100) throws ParseException {
        return format(parseObject(r100));
    }

    public CompositeFormat(Format r100, Format r101) {
        this.parser = r100;
        this.formatter = r101;
    }

    @Override // java.text.Format
    public Object parseObject(String r100, ParsePosition r101) {
        return this.parser.parseObject(r100, r101);
    }

    @Override // java.text.Format
    public StringBuffer format(Object r100, StringBuffer r101, FieldPosition r102) {
        return this.formatter.format(r100, r101, r102);
    }
}
