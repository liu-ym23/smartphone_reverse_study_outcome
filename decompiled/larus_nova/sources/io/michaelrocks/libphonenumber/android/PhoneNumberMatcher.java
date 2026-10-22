package io.michaelrocks.libphonenumber.android;

import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import io.michaelrocks.libphonenumber.android.internal.RegexCache;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes41.dex */
public final class PhoneNumberMatcher implements Iterator<g> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f492183j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f492184k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f492185l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f492186m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f492187n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f492188o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern[] f492189p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f492190q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PhoneNumberUtil f492191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f492192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f492193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PhoneNumberUtil.Leniency f492194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f492195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public State f492196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f492197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f492198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RegexCache f492199i;

    public static final enum State extends Enum<State> {
        public static final State DONE = null;
        public static final State NOT_READY = null;
        public static final State READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f492200a = null;

        static {
            State r100 = new State("NOT_READY", 0);
            NOT_READY = r100;
            State r101 = new State("READY", 1);
            READY = r101;
            State r102 = new State("DONE", 2);
            DONE = r102;
            f492200a = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) f492200a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        boolean a(PhoneNumberUtil r100, Phonenumber$PhoneNumber r101, StringBuilder r102, String[] r103);
    }

    static {
        f492184k = PatternProtector.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
        f492185l = PatternProtector.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
        f492186m = PatternProtector.compile("[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");
        f492187n = PatternProtector.compile(":[0-5]\\d");
        f492189p = new Pattern[]{PatternProtector.compile("/+(.*)"), PatternProtector.compile("(\\([^(]*)"), PatternProtector.compile("(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), PatternProtector.compile("[‒-―－]\\p{Z}*(.+)"), PatternProtector.compile("\\.+\\p{Z}*([^.]+)"), PatternProtector.compile("\\p{Z}+(\\P{Z}+)")};
        f492188o = PatternProtector.compile("(?:[(\\[（［])?(?:[^(\\[（［)\\]）］]+[)\\]）］])?[^(\\[（［)\\]）］]+(?:[(\\[（［][^(\\[（［)\\]）］]+[)\\]）］])" + f(0, 3) + "[^(\\[（［)\\]）］]*");
        String r100 = f(0, 2);
        String r101 = f(0, 4);
        String r102 = f(0, 20);
        String r103 = "[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]" + r101;
        String r104 = "\\p{Nd}" + f(1, 20);
        f492190q = PatternProtector.compile("[(\\[（［+＋]");
        f492183j = PatternProtector.compile("(?:[(\\[（［+＋]" + r103 + ")" + r100 + r104 + "(?:" + r103 + r104 + ")" + r102 + "(?:" + PhoneNumberUtil.f492216w + ")?", 66);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f492196f != State.NOT_READY) goto L45;
        int r100 = this.f492198h;
        Matcher r101 = f492183j.matcher(this.f492192b);
    L5:
        g r102 = null;
        if (this.f492195e <= 0) goto L40;
        if (r101.find(r100) == false) goto L40;
        int r103 = r101.start();
        CharSequence r104 = h(PhoneNumberUtil.f492213t, this.f492192b.subSequence(r103, r101.end()));
        if (f492185l.matcher(r104).find() == false) goto L13;
    L37:
        if (r102 != null) goto L40;
        r100 = r103 + r104.length();
        this.f492195e--;
        goto L5
    L13:
        if (f492186m.matcher(r104).find() == true) goto L15;
    L17:
        g r105 = g(r104, r103);
        if (r105 == null) goto L20;
        r102 = r105;
        goto L37
    L20:
        Pattern[] r106 = f492189p;
        int r110 = r106.length;
        int r111 = 0;
    L21:
        if (r111 >= r110) goto L37;
        Matcher r112 = r106[r111].matcher(r104);
        boolean r113 = true;
    L24:
        if (r112.find() == false) goto L36;
        if (this.f492195e <= 0) goto L36;
        if (r113 == false) goto L32;
        g r114 = g(h(PhoneNumberUtil.f492214u, r104.subSequence(0, r112.start())), r103);
        if (r114 != null) goto L34;
        this.f492195e--;
        r113 = false;
    L34:
        r102 = r114;
    L32:
        r114 = g(h(PhoneNumberUtil.f492214u, r112.group(1)), r112.start(1) + r103);
        if (r114 != null) goto L34;
        this.f492195e--;
    L36:
        r111 = r111 + 1;
        goto L21
    L15:
        if (f492187n.matcher(this.f492192b.toString().substring(r104.length() + r103)).lookingAt() == false) goto L17;
    L40:
        this.f492197g = r102;
        if (r102 != null) goto L43;
        this.f492196f = State.DONE;
        goto L45
    L43:
        this.f492198h = r102.f492247a + r102.f492248b.length();
        this.f492196f = State.READY;
    L45:
        if (this.f492196f == State.READY) goto L57;
        return false;
    L57:
        return true;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final g next() {
        if (hasNext() == false) goto L7;
        g r100 = this.f492197g;
        this.f492197g = null;
        this.f492196f = State.NOT_READY;
        return r100;
    L7:
        throw new NoSuchElementException();
    }

    public static boolean d(char r100) {
        if (Character.isLetter(r100) == false) goto L5;
    L7:
        Character.UnicodeBlock r101 = Character.UnicodeBlock.of(r100);
        if (r101.equals(Character.UnicodeBlock.BASIC_LATIN) == false) goto L10;
    L19:
        return true;
    L10:
        if (r101.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) == true) goto L19;
        if (r101.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) == true) goto L19;
        if (r101.equals(Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) == true) goto L19;
        if (r101.equals(Character.UnicodeBlock.LATIN_EXTENDED_B) == true) goto L19;
        if (r101.equals(Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS) == true) goto L19;
        return false;
    L5:
        if (Character.getType(r100) == 6) goto L7;
        return false;
    }

    public static boolean b(Phonenumber$PhoneNumber r100, String r101) {
        int r102 = r101.indexOf(47);
        if (r102 >= 0) goto L5;
        return false;
    L5:
        int r103 = r101.indexOf(47, r102 + 1);
        if (r103 >= 0) goto L9;
        return false;
    L9:
        if (r100.getCountryCodeSource() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L17;
    L20:
        return true;
    L17:
        if (PhoneNumberUtil.r(r101.substring(0, r102), false).toString().equals(Integer.toString(r100.getCountryCode())) == false) goto L20;
        return r101.substring(r103 + 1).contains(HTTP.URL_DEFAULT);
    L11:
        if (r100.getCountryCodeSource() == Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN) goto L14;
        r104 = false;
        goto L15
    }

    public static boolean e(Phonenumber$PhoneNumber r100, PhoneNumberUtil r101) {
        if (r100.getCountryCodeSource() == Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) goto L5;
        return true;
    L5:
        Phonemetadata$PhoneMetadata r102 = r101.e(r101.j(r100.getCountryCode()));
        if (r102 != null) goto L8;
        return true;
    L8:
        String r103 = PhoneNumberUtil.g(r100);
        Phonemetadata$NumberFormat r104 = r101.a(r102.numberFormats(), r103);
        if (r104 != null) goto L11;
    L26:
        return true;
    L11:
        if (r104.getNationalPrefixFormattingRule().length() <= 0) goto L26;
        if (r104.getNationalPrefixOptionalWhenFormatting() == false) goto L15;
        return true;
    L15:
        String r105 = r104.getNationalPrefixFormattingRule();
        if (r105.length() != 0) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L25;
        return true;
    L25:
        return r101.p(new StringBuilder(PhoneNumberUtil.r(r100.getRawInput(), false).toString()), r102, null);
    L18:
        if (PhoneNumberUtil.B.matcher(r105).matches() == true) goto L21;
        r106 = false;
        goto L22
    }

    public static String f(int r100, int r101) {
        if (r100 < 0) goto L8;
        if (r101 <= 0) goto L8;
        if (r101 < r100) goto L8;
        return "{" + r100 + "," + r101 + i.f25855d;
    L8:
        throw new IllegalArgumentException();
    }

    public static CharSequence h(Pattern r100, CharSequence r101) {
        Matcher r102 = r100.matcher(r101);
        if (r102.find() == true) goto L5;
        return r101;
    L5:
        return r101.subSequence(0, r102.start());
    }

    public final g g(CharSequence r100, int r110) {
        if (f492188o.matcher(r100).matches() == false) goto L40;
        if (f492184k.matcher(r100).find() == true) goto L40;
        if (this.f492194d.compareTo(PhoneNumberUtil.Leniency.VALID) < 0) goto L36;
        boolean r101 = false;
        if (r110 > 0) goto L13;
    L25:
        int r102 = r100.length() + r110;     // Catch: NumberParseException -> L41
        if (r102 >= this.f492192b.length()) goto L36;
        char r103 = this.f492192b.charAt(r102);     // Catch: NumberParseException -> L41
        if (r103 != '%') goto L30;
    L31:
        r101 = true;
    L32:
        if (r101 == false) goto L34;
    L35:
        return null;
    L34:
        if (d(r103) == false) goto L36;
    L30:
        if (Character.getType(r103) != 26) goto L32;
    L13:
        if (f492190q.matcher(r100).lookingAt() == true) goto L25;
        char r104 = this.f492192b.charAt(r110 - 1);     // Catch: NumberParseException -> L41
        if (r104 != '%') goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == false) goto L23;
    L24:
        return null;
    L23:
        if (d(r104) == false) goto L25;
    L17:
        if (Character.getType(r104) == 26) goto L20;
        r105 = false;
    L36:
        PhoneNumberUtil r106 = this.f492191a;     // Catch: NumberParseException -> L41
        String r107 = this.f492193c;     // Catch: NumberParseException -> L41
        r106.getClass();     // Catch: NumberParseException -> L41
        Phonenumber$PhoneNumber r108 = new Phonenumber$PhoneNumber();     // Catch: NumberParseException -> L41
        r106.s(r100, r107, true, true, r108);     // Catch: NumberParseException -> L41
        if (this.f492194d.verify(r108, r100, this.f492191a, this) == false) goto L40;
        r108.clearCountryCodeSource();     // Catch: NumberParseException -> L41
        r108.clearRawInput();     // Catch: NumberParseException -> L41
        r108.clearPreferredDomesticCarrierCode();     // Catch: NumberParseException -> L41
        return new g(r110, r100.toString(), r108);
    L40:
        return null;
    }

    public static boolean c(Phonenumber$PhoneNumber r110, String r111, PhoneNumberUtil r112) {
        int r100 = 0;
    L4:
        if (r100 >= (r111.length() - 1)) goto L35;
        char r101 = r111.charAt(r100);
        if (r101 == 'x') goto L8;
        if (r101 == 'X') goto L8;
    L34:
        r100 = r100 + 1;
    L8:
        int r102 = r100 + 1;
        char r103 = r111.charAt(r102);
        if (r103 == 'x') goto L15;
        if (r103 == 'X') goto L15;
        if (PhoneNumberUtil.r(r111.substring(r100), false).toString().equals(r110.getExtension()) == true) goto L34;
        return false;
    L15:
        String r104 = r111.substring(r102);
        r112.getClass();
        Phonenumber$PhoneNumber r113 = new Phonenumber$PhoneNumber();     // Catch: NumberParseException -> L18
        r112.s(r104, "ZZ", false, true, r113);     // Catch: NumberParseException -> L18
        PhoneNumberUtil.MatchType r105 = PhoneNumberUtil.l(r110, r113);     // Catch: NumberParseException -> L18
    L31:
        if (r105 != PhoneNumberUtil.MatchType.NSN_MATCH) goto L32;
        r100 = r102;
        goto L34
    L32:
        return false;
    L18:
        e = move-exception;
        if (e.getErrorType() != NumberParseException.ErrorType.INVALID_COUNTRY_CODE) goto L29;
        String r106 = r112.j(r110.getCountryCode());
        if (r106.equals("ZZ") == true) goto L27;
        Phonenumber$PhoneNumber r114 = new Phonenumber$PhoneNumber();     // Catch: NumberParseException -> L36
        r112.s(r104, r106, false, true, r114);     // Catch: NumberParseException -> L36
        r105 = PhoneNumberUtil.l(r110, r114);     // Catch: NumberParseException -> L36
        if (r105 != PhoneNumberUtil.MatchType.EXACT_MATCH) goto L31;
        r105 = PhoneNumberUtil.MatchType.NSN_MATCH;     // Catch: NumberParseException -> L36
        goto L31
    L27:
        Phonenumber$PhoneNumber r115 = new Phonenumber$PhoneNumber();     // Catch: NumberParseException -> L36
        r112.s(r104, null, false, false, r115);     // Catch: NumberParseException -> L36
        r105 = PhoneNumberUtil.l(r110, r115);     // Catch: NumberParseException -> L36
    L29:
        r105 = PhoneNumberUtil.MatchType.NOT_A_NUMBER;
        goto L31
    L35:
        return true;
    }

    public final boolean a(Phonenumber$PhoneNumber r100, CharSequence r110, PhoneNumberUtil r111, a r112) {
        StringBuilder r113 = PhoneNumberUtil.r(r110, true);
        PhoneNumberUtil.PhoneNumberFormat r101 = PhoneNumberUtil.PhoneNumberFormat.RFC3966;
        r111.getClass();
        if (r100.getNationalNumber() == 0) goto L5;
    L9:
        StringBuilder r102 = new StringBuilder(20);
        r102.setLength(0);
        int r103 = r100.getCountryCode();
        String r104 = PhoneNumberUtil.g(r100);
        PhoneNumberUtil.PhoneNumberFormat r105 = PhoneNumberUtil.PhoneNumberFormat.E164;
        if (r101 != r105) goto L13;
        r102.append(r104);
        PhoneNumberUtil.t(r103, r105, r102);
    L32:
        String r106 = r102.toString();
    L33:
        int r107 = r106.indexOf(59);
        if (r107 >= 0) goto L37;
        r107 = r106.length();
    L37:
        if (r112.a(r111, r100, r113, r106.substring(r106.indexOf(45) + 1, r107).split("-")) == false) goto L39;
        return true;
    L39:
        e r108 = r111.f492220a;
        int r109 = r100.getCountryCode();
        f r114 = (f) r108;
        d r115 = r114.f492244c;
        String r116 = r114.f492243b;
        Set<Integer> r117 = r115.f492241c;
        HashSet r118 = (HashSet) r117;
        if (r118.contains(Integer.valueOf(r109)) == true) goto L42;
        Phonemetadata$PhoneMetadata r119 = null;
    L43:
        String r120 = PhoneNumberUtil.g(r100);
        if (r119 == null) goto L56;
        Iterator<Phonemetadata$NumberFormat> r121 = r119.numberFormats().iterator();
    L47:
        if (r121.hasNext() == false) goto L56;
        Phonemetadata$NumberFormat r122 = r121.next();
        if (r122.leadingDigitsPatternSize() <= 0) goto L54;
        if (this.f492199i.a(r122.getLeadingDigitsPattern(0)).matcher(r120).lookingAt() == false) goto L47;
    L54:
        if (r112.a(r111, r100, r113, r111.d(PhoneNumberUtil.g(r100), r122, PhoneNumberUtil.PhoneNumberFormat.RFC3966).split("-")) == false) goto L47;
        return true;
    L56:
        return false;
    L42:
        r119 = r115.a(Integer.valueOf(r109), r115.f492240b, r116);
        goto L43
    L13:
        if (r111.f492221b.containsKey(Integer.valueOf(r103)) == true) goto L15;
        r102.append(r104);
        goto L32
    L15:
        Phonemetadata$PhoneMetadata r123 = r111.f(r103, r111.j(r103));
        if (r123.intlNumberFormats().size() != 0) goto L18;
    L21:
        List<Phonemetadata$NumberFormat> r124 = r123.numberFormats();
    L22:
        Phonemetadata$NumberFormat r125 = r111.a(r124, r104);
        if (r125 == null) goto L26;
        r104 = r111.d(r104, r125, r101);
    L26:
        r102.append(r104);
        if (r100.hasExtension() == true) goto L29;
    L31:
        PhoneNumberUtil.t(r103, r101, r102);
        goto L32
    L29:
        if (r100.getExtension().length() <= 0) goto L31;
        r102.append(";ext=");
        r102.append(r100.getExtension());
        goto L31
    L18:
        if (r101 == PhoneNumberUtil.PhoneNumberFormat.NATIONAL) goto L21;
        r124 = r123.intlNumberFormats();
        goto L22
    L5:
        if (r100.hasRawInput() == false) goto L9;
        r106 = r100.getRawInput();
        if (r106.length() <= 0) goto L9;
        goto L9
    }

    public PhoneNumberMatcher(PhoneNumberUtil r100, CharSequence r101, String r102, PhoneNumberUtil.Leniency r103, long r104) {
        this.f492196f = State.NOT_READY;
        this.f492197g = null;
        this.f492198h = 0;
        this.f492199i = new RegexCache(32);
        if (r100 == null) goto L15;
        if (r103 != null) goto L6;
        throw null;
    L6:
        if (r104 < 0) goto L14;
        this.f492191a = r100;
        if (r101 != null) goto L11;
        r101 = "";
    L11:
        this.f492192b = r101;
        this.f492193c = r102;
        this.f492194d = r103;
        this.f492195e = r104;
        return;
    L14:
        throw new IllegalArgumentException();
    L15:
        throw null;
    }
}
