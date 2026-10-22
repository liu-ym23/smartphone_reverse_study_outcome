package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes42.dex */
public class FastDateFormat extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final FormatCache<FastDateFormat> cache = null;
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    static {
        cache = new AnonymousClass1();
    }

    public static FastDateFormat getInstance() {
        return (FastDateFormat) cache.getInstance();
    }

    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    public String getPattern() {
        return this.printer.getPattern();
    }

    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    public static FastDateFormat getDateInstance(int r100) {
        return (FastDateFormat) cache.getDateInstance(r100, null, null);
    }

    public static FastDateFormat getInstance(String r100) {
        return (FastDateFormat) cache.getInstance(r100, null, null);
    }

    public static FastDateFormat getTimeInstance(int r100) {
        return (FastDateFormat) cache.getTimeInstance(r100, null, null);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof FastDateFormat) == true) goto L7;
        return false;
    L7:
        return this.printer.equals(((FastDateFormat) r100).printer);
    }

    public String format(long r100) {
        return this.printer.format(r100);
    }

    public Date parse(String r100) throws ParseException {
        return this.parser.parse(r100);
    }

    public String format(Calendar r100) {
        return this.printer.format(r100);
    }

    public String format(Date r100) {
        return this.printer.format(r100);
    }

    public static FastDateFormat getDateInstance(int r100, Locale r101) {
        return (FastDateFormat) cache.getDateInstance(r100, null, r101);
    }

    public static FastDateFormat getDateTimeInstance(int r100, int r101) {
        return (FastDateFormat) cache.getDateTimeInstance(r100, r101, null, null);
    }

    public static FastDateFormat getInstance(String r100, Locale r101) {
        return (FastDateFormat) cache.getInstance(r100, null, r101);
    }

    public static FastDateFormat getTimeInstance(int r100, Locale r101) {
        return (FastDateFormat) cache.getTimeInstance(r100, null, r101);
    }

    public StringBuffer applyRules(Calendar r100, StringBuffer r101) {
        return this.printer.applyRules(r100, r101);
    }

    public <B extends Appendable> B format(long r100, B r101) {
        return (B) this.printer.format(r100, r101);
    }

    public Date parse(String r100, ParsePosition r101) {
        return this.parser.parse(r100, r101);
    }

    @Override // java.text.Format
    public Object parseObject(String r100, ParsePosition r101) {
        return this.parser.parseObject(r100, r101);
    }

    public static FastDateFormat getDateInstance(int r100, TimeZone r101) {
        return (FastDateFormat) cache.getDateInstance(r100, r101, null);
    }

    public static FastDateFormat getInstance(String r100, TimeZone r101) {
        return (FastDateFormat) cache.getInstance(r100, r101, null);
    }

    public static FastDateFormat getTimeInstance(int r100, TimeZone r101) {
        return (FastDateFormat) cache.getTimeInstance(r100, r101, null);
    }

    public <B extends Appendable> B format(Calendar r100, B r101) {
        return (B) this.printer.format(r100, r101);
    }

    public <B extends Appendable> B format(Date r100, B r101) {
        return (B) this.printer.format(r100, r101);
    }

    public StringBuffer format(long r100, StringBuffer r101) {
        return this.printer.format(r100, r101);
    }

    public StringBuffer format(Calendar r100, StringBuffer r101) {
        return this.printer.format(r100, r101);
    }

    public StringBuffer format(Date r100, StringBuffer r101) {
        return this.printer.format(r100, r101);
    }

    public FastDateFormat(String r100, TimeZone r101, Locale r102) {
        this(r100, r101, r102, null);
    }

    public static FastDateFormat getDateInstance(int r100, TimeZone r101, Locale r102) {
        return (FastDateFormat) cache.getDateInstance(r100, r101, r102);
    }

    public static FastDateFormat getDateTimeInstance(int r100, int r101, Locale r102) {
        return (FastDateFormat) cache.getDateTimeInstance(r100, r101, null, r102);
    }

    public static FastDateFormat getInstance(String r100, TimeZone r101, Locale r102) {
        return (FastDateFormat) cache.getInstance(r100, r101, r102);
    }

    public static FastDateFormat getTimeInstance(int r100, TimeZone r101, Locale r102) {
        return (FastDateFormat) cache.getTimeInstance(r100, r101, r102);
    }

    @Override // java.text.Format
    public StringBuffer format(Object r100, StringBuffer r101, FieldPosition r102) {
        r101.append(this.printer.format(r100));
        return r101;
    }

    public boolean parse(String r100, ParsePosition r101, Calendar r102) {
        return this.parser.parse(r100, r101, r102);
    }

    public static FastDateFormat getDateTimeInstance(int r100, int r101, TimeZone r102) {
        return getDateTimeInstance(r100, r101, r102, null);
    }

    public FastDateFormat(String r100, TimeZone r101, Locale r102, Date r103) {
        this.printer = new FastDatePrinter(r100, r101, r102);
        this.parser = new FastDateParser(r100, r101, r102, r103);
    }

    public static FastDateFormat getDateTimeInstance(int r100, int r101, TimeZone r102, Locale r103) {
        return (FastDateFormat) cache.getDateTimeInstance(r100, r101, r102, r103);
    }
}
