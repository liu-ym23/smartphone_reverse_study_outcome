package io.michaelrocks.libphonenumber.android;

import android.content.Context;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.connect.common.Constants;
import io.michaelrocks.libphonenumber.android.internal.RegexCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes41.dex */
public final class PhoneNumberUtil {
    public static final Pattern A = null;
    public static final Pattern B = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Logger f492201h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<Integer, String> f492202i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<Integer> f492203j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<Integer> f492204k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<Character, Character> f492205l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<Character, Character> f492206m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map<Character, Character> f492207n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map<Character, Character> f492208o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f492209p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f492210q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f492211r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f492212s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f492213t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f492214u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f492215v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f492216w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f492217x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f492218y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f492219z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f492220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, List<String>> f492221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.michaelrocks.libphonenumber.android.internal.a f492222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f492223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RegexCache f492224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f492225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Integer> f492226g;

    public static abstract enum Leniency extends Enum<Leniency> {
        public static final Leniency EXACT_GROUPING = null;
        public static final Leniency POSSIBLE = null;
        public static final Leniency STRICT_GROUPING = null;
        public static final Leniency VALID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Leniency[] f492227a = null;

        public Leniency() {
            throw null;
        }

        public abstract boolean verify(Phonenumber$PhoneNumber r100, CharSequence r101, PhoneNumberUtil r102, PhoneNumberMatcher r103);

        static {
            final String r100 = "POSSIBLE";
            final int r101 = 0;
            Leniency r102 = new AnonymousClass1(r100, r101);
            POSSIBLE = r102;
            final String r103 = "VALID";
            final int r104 = 1;
            Leniency r105 = new AnonymousClass2(r103, r104);
            VALID = r105;
            final String r106 = "STRICT_GROUPING";
            final int r107 = 2;
            Leniency r108 = new AnonymousClass3(r106, r107);
            STRICT_GROUPING = r108;
            final String r109 = "EXACT_GROUPING";
            final int r110 = 3;
            Leniency r111 = new AnonymousClass4(r109, r110);
            EXACT_GROUPING = r111;
            f492227a = new Leniency[]{r102, r105, r108, r111};
        }

        public static Leniency[] values() {
            return (Leniency[]) f492227a.clone();
        }

        public static Leniency valueOf(String r100) {
            return (Leniency) r27.a.a(Leniency.class, r100);
        }

        public Leniency(String r100, int r101, h r102) {
            super(r100, r101);
        }
    }

    public static final enum MatchType extends Enum<MatchType> {
        public static final MatchType EXACT_MATCH = null;
        public static final MatchType NOT_A_NUMBER = null;
        public static final MatchType NO_MATCH = null;
        public static final MatchType NSN_MATCH = null;
        public static final MatchType SHORT_NSN_MATCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MatchType[] f492228a = null;

        static {
            MatchType r100 = new MatchType("NOT_A_NUMBER", 0);
            NOT_A_NUMBER = r100;
            MatchType r101 = new MatchType("NO_MATCH", 1);
            NO_MATCH = r101;
            MatchType r102 = new MatchType("SHORT_NSN_MATCH", 2);
            SHORT_NSN_MATCH = r102;
            MatchType r103 = new MatchType("NSN_MATCH", 3);
            NSN_MATCH = r103;
            MatchType r104 = new MatchType("EXACT_MATCH", 4);
            EXACT_MATCH = r104;
            f492228a = new MatchType[]{r100, r101, r102, r103, r104};
        }

        public static MatchType[] values() {
            return (MatchType[]) f492228a.clone();
        }

        public static MatchType valueOf(String r100) {
            return (MatchType) r27.a.a(MatchType.class, r100);
        }

        public MatchType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PhoneNumberFormat extends Enum<PhoneNumberFormat> {
        public static final PhoneNumberFormat E164 = null;
        public static final PhoneNumberFormat INTERNATIONAL = null;
        public static final PhoneNumberFormat NATIONAL = null;
        public static final PhoneNumberFormat RFC3966 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PhoneNumberFormat[] f492229a = null;

        static {
            PhoneNumberFormat r100 = new PhoneNumberFormat("E164", 0);
            E164 = r100;
            PhoneNumberFormat r101 = new PhoneNumberFormat("INTERNATIONAL", 1);
            INTERNATIONAL = r101;
            PhoneNumberFormat r102 = new PhoneNumberFormat("NATIONAL", 2);
            NATIONAL = r102;
            PhoneNumberFormat r103 = new PhoneNumberFormat("RFC3966", 3);
            RFC3966 = r103;
            f492229a = new PhoneNumberFormat[]{r100, r101, r102, r103};
        }

        public static PhoneNumberFormat[] values() {
            return (PhoneNumberFormat[]) f492229a.clone();
        }

        public static PhoneNumberFormat valueOf(String r100) {
            return (PhoneNumberFormat) r27.a.a(PhoneNumberFormat.class, r100);
        }

        public PhoneNumberFormat(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PhoneNumberType extends Enum<PhoneNumberType> {
        public static final PhoneNumberType FIXED_LINE = null;
        public static final PhoneNumberType FIXED_LINE_OR_MOBILE = null;
        public static final PhoneNumberType MOBILE = null;
        public static final PhoneNumberType PAGER = null;
        public static final PhoneNumberType PERSONAL_NUMBER = null;
        public static final PhoneNumberType PREMIUM_RATE = null;
        public static final PhoneNumberType SHARED_COST = null;
        public static final PhoneNumberType TOLL_FREE = null;
        public static final PhoneNumberType UAN = null;
        public static final PhoneNumberType UNKNOWN = null;
        public static final PhoneNumberType VOICEMAIL = null;
        public static final PhoneNumberType VOIP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PhoneNumberType[] f492230a = null;

        static {
            PhoneNumberType r100 = new PhoneNumberType("FIXED_LINE", 0);
            FIXED_LINE = r100;
            PhoneNumberType r101 = new PhoneNumberType("MOBILE", 1);
            MOBILE = r101;
            PhoneNumberType r102 = new PhoneNumberType("FIXED_LINE_OR_MOBILE", 2);
            FIXED_LINE_OR_MOBILE = r102;
            PhoneNumberType r103 = new PhoneNumberType("TOLL_FREE", 3);
            TOLL_FREE = r103;
            PhoneNumberType r104 = new PhoneNumberType("PREMIUM_RATE", 4);
            PREMIUM_RATE = r104;
            PhoneNumberType r105 = new PhoneNumberType("SHARED_COST", 5);
            SHARED_COST = r105;
            PhoneNumberType r110 = new PhoneNumberType("VOIP", 6);
            VOIP = r110;
            PhoneNumberType r111 = new PhoneNumberType("PERSONAL_NUMBER", 7);
            PERSONAL_NUMBER = r111;
            PhoneNumberType r112 = new PhoneNumberType("PAGER", 8);
            PAGER = r112;
            PhoneNumberType r113 = new PhoneNumberType("UAN", 9);
            UAN = r113;
            PhoneNumberType r114 = new PhoneNumberType("VOICEMAIL", 10);
            VOICEMAIL = r114;
            PhoneNumberType r115 = new PhoneNumberType("UNKNOWN", 11);
            UNKNOWN = r115;
            f492230a = new PhoneNumberType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        }

        public static PhoneNumberType[] values() {
            return (PhoneNumberType[]) f492230a.clone();
        }

        public static PhoneNumberType valueOf(String r100) {
            return (PhoneNumberType) r27.a.a(PhoneNumberType.class, r100);
        }

        public PhoneNumberType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ValidationResult extends Enum<ValidationResult> {
        public static final ValidationResult INVALID_COUNTRY_CODE = null;
        public static final ValidationResult INVALID_LENGTH = null;
        public static final ValidationResult IS_POSSIBLE = null;
        public static final ValidationResult IS_POSSIBLE_LOCAL_ONLY = null;
        public static final ValidationResult TOO_LONG = null;
        public static final ValidationResult TOO_SHORT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ValidationResult[] f492231a = null;

        static {
            ValidationResult r100 = new ValidationResult("IS_POSSIBLE", 0);
            IS_POSSIBLE = r100;
            ValidationResult r101 = new ValidationResult("IS_POSSIBLE_LOCAL_ONLY", 1);
            IS_POSSIBLE_LOCAL_ONLY = r101;
            ValidationResult r102 = new ValidationResult("INVALID_COUNTRY_CODE", 2);
            INVALID_COUNTRY_CODE = r102;
            ValidationResult r103 = new ValidationResult("TOO_SHORT", 3);
            TOO_SHORT = r103;
            ValidationResult r104 = new ValidationResult("INVALID_LENGTH", 4);
            INVALID_LENGTH = r104;
            ValidationResult r105 = new ValidationResult("TOO_LONG", 5);
            TOO_LONG = r105;
            f492231a = new ValidationResult[]{r100, r101, r102, r103, r104, r105};
        }

        public static ValidationResult[] values() {
            return (ValidationResult[]) f492231a.clone();
        }

        public static ValidationResult valueOf(String r100) {
            return (ValidationResult) r27.a.a(ValidationResult.class, r100);
        }

        public ValidationResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f492232a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f492233b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f492234c = null;

        static {
            int[] r100 = new int[PhoneNumberType.values().length];
            f492234c = r100;
            r100[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L67:
            f492234c[PhoneNumberType.TOLL_FREE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L51:
            f492234c[PhoneNumberType.MOBILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L65:
            f492234c[PhoneNumberType.FIXED_LINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L69:
            f492234c[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L55:
            f492234c[PhoneNumberType.SHARED_COST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L57:
            f492234c[PhoneNumberType.VOIP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L81:
            f492234c[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L47:
            f492234c[PhoneNumberType.PAGER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L75:
            f492234c[PhoneNumberType.UAN.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L79:
            f492234c[PhoneNumberType.VOICEMAIL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L17:
            int[] r101 = new int[PhoneNumberFormat.values().length];
            f492233b = r101;
            r101[PhoneNumberFormat.E164.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L71:
            f492233b[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L53:
            f492233b[PhoneNumberFormat.RFC3966.ordinal()] = 3;     // Catch: NoSuchFieldError -> L41
        L63:
            f492233b[PhoneNumberFormat.NATIONAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L42
        L22:
            int[] r102 = new int[Phonenumber$PhoneNumber.CountryCodeSource.values().length];
            f492232a = r102;
            r102[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L49:
            f492232a[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L73:
            f492232a[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L45
        L83:
            f492232a[Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L46
            return;
        }
    }

    static {
        f492201h = Logger.getLogger(PhoneNumberUtil.class.getName());
        HashMap r100 = new HashMap();
        r100.put(52, "1");
        r100.put(54, Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        f492202i = Collections.unmodifiableMap(r100);
        HashSet r101 = new HashSet();
        r101.add(86);
        f492203j = Collections.unmodifiableSet(r101);
        HashSet r102 = new HashSet();
        r102.add(52);
        r102.add(54);
        r102.add(55);
        r102.add(62);
        r102.addAll(r101);
        f492204k = Collections.unmodifiableSet(r102);
        HashMap r103 = new HashMap();
        r103.put('0', '0');
        r103.put('1', '1');
        r103.put('2', '2');
        r103.put('3', '3');
        r103.put('4', '4');
        r103.put('5', '5');
        r103.put('6', '6');
        r103.put('7', '7');
        r103.put('8', '8');
        r103.put('9', '9');
        HashMap r110 = new HashMap(40);
        r110.put('A', '2');
        r110.put('B', '2');
        r110.put('C', '2');
        r110.put('D', '3');
        r110.put('E', '3');
        r110.put('F', '3');
        r110.put('G', '4');
        r110.put('H', '4');
        r110.put('I', '4');
        r110.put('J', '5');
        r110.put('K', '5');
        r110.put(Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_LT), '5');
        r110.put('M', '6');
        r110.put('N', '6');
        r110.put('O', '6');
        r110.put('P', '7');
        r110.put('Q', '7');
        r110.put(Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_REGULAR), '7');
        r110.put('S', '7');
        r110.put(Character.valueOf(OthersPermission.STICKY), '8');
        r110.put(Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_UT), '8');
        r110.put('V', '8');
        r110.put('W', '9');
        r110.put('X', '9');
        r110.put('Y', '9');
        r110.put(Character.valueOf(Matrix.MATRIX_TYPE_ZERO), '9');
        Map<Character, Character> r104 = Collections.unmodifiableMap(r110);
        f492206m = r104;
        HashMap r105 = new HashMap(100);
        r105.putAll(r104);
        r105.putAll(r103);
        f492207n = Collections.unmodifiableMap(r105);
        HashMap r106 = new HashMap();
        r106.putAll(r103);
        r106.put('+', '+');
        r106.put('*', '*');
        r106.put('#', '#');
        f492205l = Collections.unmodifiableMap(r106);
        HashMap r107 = new HashMap();
        Iterator<Character> r108 = r104.keySet().iterator();
    L4:
        if (r108.hasNext() == false) goto L6;
        char r109 = r108.next().charValue();
        r107.put(Character.valueOf(Character.toLowerCase(r109)), Character.valueOf(r109));
        r107.put(Character.valueOf(r109), Character.valueOf(r109));
        goto L4
    L6:
        r107.putAll(r103);
        r107.put('-', '-');
        r107.put((char) 65293, '-');
        r107.put((char) 8208, '-');
        r107.put((char) 8209, '-');
        r107.put((char) 8210, '-');
        r107.put(Character.valueOf(Typography.ndash), '-');
        r107.put(Character.valueOf(Typography.mdash), '-');
        r107.put((char) 8213, '-');
        r107.put((char) 8722, '-');
        r107.put('/', '/');
        r107.put((char) 65295, '/');
        r107.put(' ', ' ');
        r107.put((char) 12288, ' ');
        r107.put((char) 8288, ' ');
        r107.put('.', '.');
        r107.put((char) 65294, '.');
        f492208o = Collections.unmodifiableMap(r107);
        PatternProtector.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder r111 = new StringBuilder();
        Map<Character, Character> r112 = f492206m;
        r111.append(Arrays.toString(r112.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        r111.append(Arrays.toString(r112.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String r113 = r111.toString();
        f492209p = PatternProtector.compile("[+＋]+");
        f492210q = PatternProtector.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        f492211r = PatternProtector.compile("(\\p{Nd})");
        f492212s = PatternProtector.compile("[+＋\\p{Nd}]");
        f492213t = PatternProtector.compile("[\\\\/] *x");
        f492214u = PatternProtector.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        f492215v = PatternProtector.compile("(?:.*?[A-Za-z]){3}.*");
        f492216w = ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[xｘ#＃~～]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
        f492217x = PatternProtector.compile("(?:;ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[,;xｘ#＃~～]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#)$", 66);
        f492218y = PatternProtector.compile(("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + r113 + "\\p{Nd}]*") + "(?:;ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[,;xｘ#＃~～]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#)?", 66);
        f492219z = PatternProtector.compile("(\\D+)");
        A = PatternProtector.compile("(\\$\\d)");
        B = PatternProtector.compile("\\(?\\$1\\)?");
    }

    public static Phonenumber$PhoneNumber b(Phonenumber$PhoneNumber r100) {
        Phonenumber$PhoneNumber r101 = new Phonenumber$PhoneNumber();
        r101.setCountryCode(r100.getCountryCode());
        r101.setNationalNumber(r100.getNationalNumber());
        if (r100.getExtension().length() <= 0) goto L6;
        r101.setExtension(r100.getExtension());
    L6:
        if (r100.isItalianLeadingZero() == false) goto L8;
        r101.setItalianLeadingZero(true);
        r101.setNumberOfLeadingZeros(r100.getNumberOfLeadingZeros());
    L8:
        return r101;
    }

    public static PhoneNumberUtil c(Context r100) {
        if (r100 == null) goto L6;
        return new PhoneNumberUtil(new f(new io.michaelrocks.libphonenumber.android.a(r100.getAssets())), b.a());
    L6:
        throw new IllegalArgumentException("context could not be null.");
    }

    public static String g(Phonenumber$PhoneNumber r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100.isItalianLeadingZero() == true) goto L5;
    L7:
        r101.append(r100.getNationalNumber());
        return r101.toString();
    L5:
        if (r100.getNumberOfLeadingZeros() <= 0) goto L7;
        char[] r102 = new char[r100.getNumberOfLeadingZeros()];
        Arrays.fill(r102, '0');
        r101.append(new String(r102));
        goto L7
    }

    public static void q(StringBuilder r100) {
        if (f492215v.matcher(r100).matches() == false) goto L12;
        int r101 = r100.length();
        Map<Character, Character> r102 = f492207n;
        StringBuilder r103 = new StringBuilder(r100.length());
        int r104 = 0;
    L6:
        if (r104 >= r100.length()) goto L11;
        Character r105 = r102.get(Character.valueOf(Character.toUpperCase(r100.charAt(r104))));
        if (r105 == null) goto L10;
        r103.append(r105);
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        r100.replace(0, r101, r103.toString());
        return;
    L12:
        r100.replace(0, r100.length(), r(r100, false).toString());
    }

    public final Phonemetadata$PhoneMetadata e(String r100) {
        if (r100 != null) goto L4;
    L6:
        boolean r101 = false;
    L7:
        if (r101 == true) goto L10;
        return null;
    L10:
        f r102 = (f) this.f492220a;
        return r102.f492244c.a(r100, r102.f492245d, r102.f492242a);
    L4:
        if (((HashSet) this.f492225f).contains(r100) == false) goto L6;
        r101 = true;
        goto L7
    }

    public final String j(int r100) {
        List<String> r101 = this.f492221b.get(Integer.valueOf(r100));
        if (r101 != null) goto L6;
        return "ZZ";
    L6:
        return (String) ListProtector.get(r101, 0);
    }

    public final boolean n(Phonenumber$PhoneNumber r100) {
        int r101 = r100.getCountryCode();
        List<String> r102 = this.f492221b.get(Integer.valueOf(r101));
        if (r102 != null) goto L6;
        f492201h.log(Level.INFO, "Missing/invalid country_code (" + r101 + ")");
    L19:
        String r103 = null;
    L20:
        int r104 = r100.getCountryCode();
        Phonemetadata$PhoneMetadata r105 = f(r104, r103);
        if (r105 != null) goto L23;
        return false;
    L23:
        if (AdBaseConstants.InfoErrorCode.WEB_URL_NULL.equals(r103) == true) goto L32;
        Phonemetadata$PhoneMetadata r106 = e(r103);
        if (r106 == null) goto L30;
        if (r104 == r106.getCountryCode()) goto L32;
        return false;
    L30:
        throw new IllegalArgumentException("Invalid region code: " + r103);
    L32:
        if (i(g(r100), r105) == PhoneNumberType.UNKNOWN) goto L44;
        return true;
    L44:
        return false;
    L6:
        if (r102.size() != 1) goto L8;
        r103 = (String) ListProtector.get(r102, 0);
        goto L20
    L8:
        String r107 = g(r100);
        Iterator<String> r108 = r102.iterator();
    L10:
        if (r108.hasNext() == false) goto L19;
        String r109 = r108.next();
        Phonemetadata$PhoneMetadata r110 = e(r109);
        if (r110.hasLeadingDigits() == true) goto L14;
        if (i(r107, r110) == PhoneNumberType.UNKNOWN) goto L10;
    L18:
        r103 = r109;
        goto L20
    L14:
        if (this.f492224e.a(r110.getLeadingDigits()).matcher(r107).lookingAt() == false) goto L10;
        goto L18
    }

    public PhoneNumberUtil(f r100, Map r101) {
        this.f492222c = new io.michaelrocks.libphonenumber.android.internal.a();
        this.f492223d = new HashSet(35);
        this.f492224e = new RegexCache(100);
        this.f492225f = new HashSet(320);
        this.f492226g = new HashSet();
        this.f492220a = r100;
        this.f492221b = r101;
        HashMap r102 = (HashMap) r101;
        Iterator r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        List r105 = (List) r104.getValue();
        if (r105.size() != 1) goto L10;
        if (AdBaseConstants.InfoErrorCode.WEB_URL_NULL.equals(ListProtector.get(r105, 0)) == false) goto L10;
        Set<Integer> r106 = this.f492226g;
        HashSet r107 = (HashSet) r106;
        r107.add(r104.getKey());
    L10:
        this.f492225f.addAll(r105);
        goto L4
    L12:
        if (((HashSet) this.f492225f).remove(AdBaseConstants.InfoErrorCode.WEB_URL_NULL) == false) goto L14;
        f492201h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
    L14:
        this.f492223d.addAll((Collection) r102.get(1));
    }

    public static Phonemetadata$PhoneNumberDesc h(Phonemetadata$PhoneMetadata r100, PhoneNumberType r101) {
        switch(a.f492234c[r101.ordinal()]) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L5;
        };
    L5:
        return r100.getGeneralDesc();
    L7:
        return r100.getVoicemail();
    L9:
        return r100.getUan();
    L11:
        return r100.getPager();
    L13:
        return r100.getPersonalNumber();
    L15:
        return r100.getVoip();
    L17:
        return r100.getSharedCost();
    L19:
        return r100.getFixedLine();
    L21:
        return r100.getMobile();
    L23:
        return r100.getTollFree();
    L25:
        return r100.getPremiumRate();
    }

    public static boolean k(Phonenumber$PhoneNumber r100, Phonenumber$PhoneNumber r101) {
        String r102 = String.valueOf(r100.getNationalNumber());
        String r103 = String.valueOf(r101.getNationalNumber());
        if (r102.endsWith(r103) == false) goto L5;
    L8:
        return true;
    L5:
        if (r103.endsWith(r102) == true) goto L8;
        return false;
    }

    public static MatchType l(Phonenumber$PhoneNumber r100, Phonenumber$PhoneNumber r101) {
        Phonenumber$PhoneNumber r102 = b(r100);
        Phonenumber$PhoneNumber r103 = b(r101);
        if (r102.hasExtension() == true) goto L5;
    L10:
        int r104 = r102.getCountryCode();
        int r105 = r103.getCountryCode();
        if (r104 == 0) goto L24;
        if (r105 == 0) goto L24;
        if (r102.exactlySameAs(r103) == true) goto L16;
        if (r104 != r105) goto L23;
        if (k(r102, r103) == false) goto L23;
        return MatchType.SHORT_NSN_MATCH;
    L23:
        return MatchType.NO_MATCH;
    L16:
        return MatchType.EXACT_MATCH;
    L24:
        r102.setCountryCode(r105);
        if (r102.exactlySameAs(r103) == false) goto L29;
        return MatchType.NSN_MATCH;
    L29:
        if (k(r102, r103) == false) goto L33;
        return MatchType.SHORT_NSN_MATCH;
    L33:
        return MatchType.NO_MATCH;
    L5:
        if (r103.hasExtension() == false) goto L10;
        if (r102.getExtension().equals(r103.getExtension()) == true) goto L10;
        return MatchType.NO_MATCH;
    }

    public static StringBuilder r(CharSequence r100, boolean r101) {
        StringBuilder r102 = new StringBuilder(r100.length());
        int r103 = 0;
    L4:
        if (r103 >= r100.length()) goto L11;
        char r104 = r100.charAt(r103);
        int r105 = Character.digit(r104, 10);
        if (r105 == (-1)) goto L8;
        r102.append(r105);
    L10:
        r103 = r103 + 1;
        goto L4
    L8:
        if (r101 == false) goto L10;
        r102.append(r104);
        goto L10
    L11:
        return r102;
    }

    public final Phonemetadata$NumberFormat a(List<Phonemetadata$NumberFormat> r100, String r101) {
        Iterator<Phonemetadata$NumberFormat> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Phonemetadata$NumberFormat r103 = r102.next();
        int r104 = r103.leadingDigitsPatternSize();
        if (r104 == 0) goto L10;
        if (this.f492224e.a(r103.getLeadingDigitsPattern(r104 - 1)).matcher(r101).lookingAt() == false) goto L4;
    L10:
        if (this.f492224e.a(r103.getPattern()).matcher(r101).matches() == false) goto L4;
        return r103;
    L12:
        return null;
    }

    public final Phonemetadata$PhoneMetadata f(int r100, String r101) {
        if (AdBaseConstants.InfoErrorCode.WEB_URL_NULL.equals(r101) == false) goto L17;
        if (this.f492221b.containsKey(Integer.valueOf(r100)) == false) goto L19;
        f r102 = (f) this.f492220a;
        r102.getClass();
        Map<Integer, List<String>> r103 = b.a();
        HashMap r104 = (HashMap) r103;
        List r105 = (List) r104.get(Integer.valueOf(r100));
        boolean r106 = true;
        if (r105.size() == 1) goto L10;
    L12:
        r106 = false;
    L13:
        if (r106 == true) goto L18;
        return null;
    L18:
        return r102.f492244c.a(Integer.valueOf(r100), r102.f492246e, r102.f492242a);
    L10:
        if (AdBaseConstants.InfoErrorCode.WEB_URL_NULL.equals(ListProtector.get(r105, 0)) == false) goto L12;
    L19:
        return null;
    L17:
        return e(r101);
    }

    public final PhoneNumberType i(String r100, Phonemetadata$PhoneMetadata r101) {
        if (m(r100, r101.getGeneralDesc()) == true) goto L7;
        return PhoneNumberType.UNKNOWN;
    L7:
        if (m(r100, r101.getPremiumRate()) == false) goto L11;
        return PhoneNumberType.PREMIUM_RATE;
    L11:
        if (m(r100, r101.getTollFree()) == false) goto L15;
        return PhoneNumberType.TOLL_FREE;
    L15:
        if (m(r100, r101.getSharedCost()) == false) goto L19;
        return PhoneNumberType.SHARED_COST;
    L19:
        if (m(r100, r101.getVoip()) == false) goto L23;
        return PhoneNumberType.VOIP;
    L23:
        if (m(r100, r101.getPersonalNumber()) == false) goto L27;
        return PhoneNumberType.PERSONAL_NUMBER;
    L27:
        if (m(r100, r101.getPager()) == false) goto L31;
        return PhoneNumberType.PAGER;
    L31:
        if (m(r100, r101.getUan()) == false) goto L35;
        return PhoneNumberType.UAN;
    L35:
        if (m(r100, r101.getVoicemail()) == false) goto L39;
        return PhoneNumberType.VOICEMAIL;
    L39:
        if (m(r100, r101.getFixedLine()) == false) goto L51;
        if (r101.getSameMobileAndFixedLinePattern() == false) goto L45;
        return PhoneNumberType.FIXED_LINE_OR_MOBILE;
    L45:
        if (m(r100, r101.getMobile()) == false) goto L49;
        return PhoneNumberType.FIXED_LINE_OR_MOBILE;
    L49:
        return PhoneNumberType.FIXED_LINE;
    L51:
        if (r101.getSameMobileAndFixedLinePattern() == true) goto L57;
        if (m(r100, r101.getMobile()) == false) goto L57;
        return PhoneNumberType.MOBILE;
    L57:
        return PhoneNumberType.UNKNOWN;
    }

    public final boolean m(String r100, Phonemetadata$PhoneNumberDesc r101) {
        int r102 = r100.length();
        List<Integer> r103 = r101.getPossibleLengthList();
        if (r103.size() <= 0) goto L9;
        if (r103.contains(Integer.valueOf(r102)) == true) goto L9;
        return false;
    L9:
        return this.f492222c.a(r100, r101);
    }

    public static void t(int r100, PhoneNumberFormat r101, StringBuilder r102) {
        int r103 = a.f492233b[r101.ordinal()];
        if (r103 != 1) goto L5;
        r102.insert(0, r100).insert(0, '+');
        return;
    L5:
        if (r103 != 2) goto L7;
        r102.insert(0, " ").insert(0, r100).insert(0, '+');
        return;
    L7:
        if (r103 == 3) goto L9;
        return;
    L9:
        r102.insert(0, "-").insert(0, r100).insert(0, '+').insert(0, "tel:");
    }

    public static ValidationResult u(CharSequence r100, Phonemetadata$PhoneMetadata r101, PhoneNumberType r102) {
        Phonemetadata$PhoneNumberDesc r103 = h(r101, r102);
        if (r103.getPossibleLengthList().isEmpty() == false) goto L5;
        List<Integer> r104 = r101.getGeneralDesc().getPossibleLengthList();
    L6:
        List<Integer> r105 = r103.getPossibleLengthLocalOnlyList();
        if (r102 != PhoneNumberType.FIXED_LINE_OR_MOBILE) goto L36;
        Phonemetadata$PhoneNumberDesc r106 = h(r101, PhoneNumberType.FIXED_LINE);
        if (r106.getPossibleLengthCount() == 1) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        Phonemetadata$PhoneNumberDesc r108 = h(r101, PhoneNumberType.MOBILE);
        if (r108.getPossibleLengthCount() == 1) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == false) goto L36;
        ArrayList r110 = new ArrayList(r104);
        if (r108.getPossibleLengthList().size() != 0) goto L29;
        List<Integer> r111 = r101.getGeneralDesc().getPossibleLengthList();
    L30:
        r110.addAll(r111);
        Collections.sort(r110);
        if (r105.isEmpty() == false) goto L33;
        List<Integer> r112 = r108.getPossibleLengthLocalOnlyList();
    L34:
        r105 = r112;
        r104 = r110;
        goto L36
    L33:
        ArrayList r113 = new ArrayList(r105);
        r113.addAll(r108.getPossibleLengthLocalOnlyList());
        Collections.sort(r113);
        r112 = r113;
        goto L34
    L29:
        r111 = r108.getPossibleLengthList();
        goto L30
    L21:
        if (r108.getPossibleLength(0) != (-1)) goto L24;
        r109 = false;
        goto L25
    L17:
        return u(r100, r101, PhoneNumberType.MOBILE);
    L11:
        if (r106.getPossibleLength(0) != (-1)) goto L14;
        r107 = false;
    L36:
        if (((Integer) ListProtector.get(r104, 0)).intValue() == (-1)) goto L38;
        int r114 = r100.length();
        if (r105.contains(Integer.valueOf(r114)) == true) goto L42;
        int r115 = ((Integer) ListProtector.get(r104, 0)).intValue();
        if (r115 == r114) goto L46;
        if (r115 <= r114) goto L51;
        return ValidationResult.TOO_SHORT;
    L51:
        if (((Integer) ListProtector.get(r104, r104.size() - 1)).intValue() >= r114) goto L55;
        return ValidationResult.TOO_LONG;
    L55:
        if (r104.subList(1, r104.size()).contains(Integer.valueOf(r114)) == false) goto L58;
        return ValidationResult.IS_POSSIBLE;
    L58:
        return ValidationResult.INVALID_LENGTH;
    L46:
        return ValidationResult.IS_POSSIBLE;
    L42:
        return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
    L38:
        return ValidationResult.INVALID_LENGTH;
    L5:
        r104 = r103.getPossibleLengthList();
        goto L6
    }

    public final String d(String r100, Phonemetadata$NumberFormat r101, PhoneNumberFormat r102) {
        String r103 = r101.getFormat();
        Matcher r104 = this.f492224e.a(r101.getPattern()).matcher(r100);
        PhoneNumberFormat r105 = PhoneNumberFormat.NATIONAL;
        String r106 = r101.getNationalPrefixFormattingRule();
        if (r102 != r105) goto L8;
        if (r106 == null) goto L8;
        if (r106.length() <= 0) goto L8;
        String r107 = r104.replaceAll(A.matcher(r103).replaceFirst(r106));
    L10:
        if (r102 != PhoneNumberFormat.RFC3966) goto L16;
        Matcher r108 = f492210q.matcher(r107);
        if (r108.lookingAt() == false) goto L15;
        r107 = r108.replaceFirst("");
    L15:
        return r108.reset(r107).replaceAll("-");
    L16:
        return r107;
    L8:
        r107 = r104.replaceAll(r103);
        goto L10
    }

    public final boolean p(StringBuilder r100, Phonemetadata$PhoneMetadata r110, StringBuilder r111) {
        int r101 = r100.length();
        String r102 = r110.getNationalPrefixForParsing();
        if (r101 != 0) goto L5;
    L37:
        return false;
    L5:
        if (r102.length() == 0) goto L37;
        Matcher r103 = this.f492224e.a(r102).matcher(r100);
        if (r103.lookingAt() == false) goto L37;
        Phonemetadata$PhoneNumberDesc r104 = r110.getGeneralDesc();
        boolean r105 = this.f492222c.a(r100, r104);
        int r106 = r103.groupCount();
        String r112 = r110.getNationalPrefixTransformRule();
        if (r112 != null) goto L12;
    L26:
        if (r105 == true) goto L28;
    L30:
        if (r111 == null) goto L35;
        if (r106 <= 0) goto L35;
        if (r103.group(r106) == null) goto L35;
        r111.append(r103.group(1));
    L35:
        r100.delete(0, r103.end());
        return true;
    L28:
        if (this.f492222c.a(r100.substring(r103.end()), r104) == true) goto L30;
        return false;
    L12:
        if (r112.length() == 0) goto L26;
        if (r103.group(r106) == null) goto L26;
        StringBuilder r107 = new StringBuilder(r100);
        r107.replace(0, r101, r103.replaceFirst(r112));
        if (r105 == true) goto L19;
    L21:
        if (r111 == null) goto L24;
        if (r106 <= 1) goto L24;
        r111.append(r103.group(1));
    L24:
        r100.replace(0, r100.length(), r107.toString());
        return true;
    L19:
        if (this.f492222c.a(r107.toString(), r104) == true) goto L21;
        return false;
    }

    public final int o(CharSequence r100, Phonemetadata$PhoneMetadata r101, StringBuilder r102, boolean r103, Phonenumber$PhoneNumber r110) throws NumberParseException {
        int r104 = 0;
        if (r100.length() != 0) goto L5;
        return 0;
    L5:
        StringBuilder r105 = new StringBuilder(r100);
        if (r101 == null) goto L8;
        String r106 = r101.getInternationalPrefix();
    L9:
        int r107 = 1;
        if (r105.length() != 0) goto L12;
        Phonenumber$PhoneNumber.CountryCodeSource r108 = Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    L27:
        if (r103 == false) goto L30;
        r110.setCountryCodeSource(r108);
    L30:
        if (r108 != Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) goto L32;
        if (r101 == null) goto L67;
        int r109 = r101.getCountryCode();
        String r111 = String.valueOf(r109);
        String r112 = r105.toString();
        if (r112.startsWith(r111) == false) goto L67;
        StringBuilder r113 = new StringBuilder(r112.substring(r111.length()));
        Phonemetadata$PhoneNumberDesc r114 = r101.getGeneralDesc();
        p(r113, r101, null);
        if (this.f492222c.a(r105, r114) == true) goto L61;
        if (this.f492222c.a(r113, r114) == false) goto L61;
    L62:
        r102.append(r113);
        if (r103 == false) goto L65;
        r110.setCountryCodeSource(Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
    L65:
        r110.setCountryCode(r109);
        return r109;
    L61:
        if (u(r105, r101, PhoneNumberType.UNKNOWN) == ValidationResult.TOO_LONG) goto L62;
    L67:
        r110.setCountryCode(0);
        return 0;
    L32:
        if (r105.length() <= 2) goto L52;
        if (r105.length() != 0) goto L36;
    L46:
        if (r104 == 0) goto L50;
        r110.setCountryCode(r104);
        return r104;
    L50:
        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
    L36:
        if (r105.charAt(0) == '0') goto L46;
        int r115 = r105.length();
    L40:
        if (r107 > 3) goto L46;
        if (r107 > r115) goto L46;
        int r116 = CastIntegerProtector.parseInt(r105.substring(0, r107));
        if (this.f492221b.containsKey(Integer.valueOf(r116)) == true) goto L44;
        r107 = r107 + 1;
        goto L40
    L44:
        r102.append(r105.substring(r107));
        r104 = r116;
        goto L46
    L52:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
    L12:
        Matcher r117 = f492209p.matcher(r105);
        if (r117.lookingAt() == false) goto L15;
        r105.delete(0, r117.end());
        q(r105);
        r108 = Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        goto L27
    L15:
        Pattern r118 = this.f492224e.a(r106);
        q(r105);
        Matcher r119 = r118.matcher(r105);
        if (r119.lookingAt() == false) goto L23;
        int r120 = r119.end();
        Matcher r121 = f492211r.matcher(r105.substring(r120));
        if (r121.find() == true) goto L20;
    L22:
        r105.delete(0, r120);
        boolean r122 = true;
    L24:
        if (r122 == false) goto L26;
        r108 = Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
        goto L27
    L26:
        r108 = Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        goto L27
    L20:
        if (r(r121.group(1), false).toString().equals("0") == false) goto L22;
    L23:
        r122 = false;
        goto L24
    L8:
        r106 = "NonMatch";
        goto L9
    }

    public final void s(CharSequence r110, String r111, boolean r112, boolean r210, Phonenumber$PhoneNumber r211) throws NumberParseException {
        if (r110 == null) goto L141;
        if (r110.length() > 250) goto L139;
        StringBuilder r113 = new StringBuilder();
        String r100 = r110.toString();
        int r101 = r100.indexOf(";phone-context=");
        String r102 = "";
        if (r101 < 0) goto L21;
        int r103 = r101 + 15;
        if (r103 < (r100.length() - 1)) goto L11;
    L16:
        int r104 = r100.indexOf("tel:");
        if (r104 < 0) goto L19;
        int r105 = r104 + 4;
    L20:
        r113.append(r100.substring(r105, r101));
    L31:
        int r106 = r113.indexOf(";isub=");
        if (r106 <= 0) goto L35;
        r113.delete(r106, r113.length());
    L35:
        if (r113.length() >= 2) goto L37;
        boolean r107 = false;
    L38:
        if (r107 == false) goto L137;
        if (r210 == false) goto L57;
        if (r111 != null) goto L43;
    L45:
        boolean r108 = false;
    L46:
        if (r108 == false) goto L48;
    L52:
        boolean r109 = true;
    L53:
        if (r109 == true) goto L57;
        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
    L48:
        if (r113.length() != 0) goto L50;
    L51:
        r109 = false;
        goto L53
    L50:
        if (f492209p.matcher(r113).lookingAt() == true) goto L52;
    L43:
        if (((HashSet) this.f492225f).contains(r111) == false) goto L45;
        r108 = true;
    L57:
        if (r112 == false) goto L59;
        r211.setRawInput(r100);
    L59:
        Matcher r114 = f492217x.matcher(r113);
        if (r114.find() == false) goto L73;
        String r115 = r113.substring(0, r114.start());
        if (r115.length() >= 2) goto L64;
        boolean r116 = false;
    L65:
        if (r116 == false) goto L73;
        int r117 = r114.groupCount();
        int r118 = 1;
    L67:
        if (r118 > r117) goto L73;
        if (r114.group(r118) != null) goto L70;
        r118 = r118 + 1;
        goto L67
    L70:
        r102 = r114.group(r118);
        r113.delete(r114.start(), r113.length());
        goto L73
    L64:
        r116 = f492218y.matcher(r115).matches();
    L73:
        if (r102.length() <= 0) goto L75;
        r211.setExtension(r102);
    L75:
        Phonemetadata$PhoneMetadata r119 = e(r111);
        StringBuilder r120 = new StringBuilder();
        int r121 = o(r113, r119, r120, r112, r211);     // Catch: NumberParseException -> L78
    L85:
        if (r121 == 0) goto L89;
        String r122 = j(r121);
        if (r122.equals(r111) == true) goto L95;
        r119 = f(r121, r122);
    L95:
        if (r120.length() < 2) goto L131;
        if (r119 == null) goto L108;
        StringBuilder r123 = new StringBuilder();
        StringBuilder r124 = new StringBuilder(r120);
        p(r124, r119, r123);
        ValidationResult r125 = u(r124, r119, PhoneNumberType.UNKNOWN);
        if (r125 == ValidationResult.TOO_SHORT) goto L108;
        if (r125 == ValidationResult.IS_POSSIBLE_LOCAL_ONLY) goto L108;
        if (r125 == ValidationResult.INVALID_LENGTH) goto L108;
        if (r112 == true) goto L105;
    L107:
        r120 = r124;
        goto L108
    L105:
        if (r123.length() <= 0) goto L107;
        r211.setPreferredDomesticCarrierCode(r123.toString());
    L108:
        int r126 = r120.length();
        if (r126 < 2) goto L129;
        if (r126 > 17) goto L127;
        if (r120.length() > 1) goto L115;
    L124:
        r211.setNationalNumber(CastLongProtector.parseLong(r120.toString()));
        return;
    L115:
        if (r120.charAt(0) != '0') goto L124;
        r211.setItalianLeadingZero(true);
        int r127 = 1;
    L118:
        if (r127 >= (r120.length() - 1)) goto L122;
        if (r120.charAt(r127) != '0') goto L122;
        r127 = r127 + 1;
    L122:
        if (r127 == 1) goto L124;
        r211.setNumberOfLeadingZeros(r127);
        goto L124
    L127:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
    L129:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
    L131:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
    L89:
        q(r113);
        r120.append(r113);
        if (r111 == null) goto L92;
        r211.setCountryCode(r119.getCountryCode());
        goto L95
    L92:
        if (r112 == false) goto L95;
        r211.clearCountryCodeSource();
    L78:
        e = move-exception;
        Matcher r128 = f492209p.matcher(r113);
        if (e.getErrorType() != NumberParseException.ErrorType.INVALID_COUNTRY_CODE) goto L135;
        if (r128.lookingAt() == false) goto L135;
        r121 = o(r113.substring(r128.end()), r119, r120, r112, r211);
        if (r121 != 0) goto L85;
        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
    L135:
        throw new NumberParseException(e.getErrorType(), e.getMessage());
    L137:
        throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
    L37:
        r107 = f492218y.matcher(r113).matches();
        goto L38
    L19:
        r105 = 0;
        goto L20
    L11:
        if (r100.charAt(r103) != '+') goto L16;
        int r129 = r100.indexOf(59, r103);
        if (r129 <= 0) goto L15;
        r113.append(r100.substring(r103, r129));
        goto L16
    L15:
        r113.append(r100.substring(r103));
        goto L16
    L21:
        Matcher r130 = f492212s.matcher(r100);
        if (r130.find() == false) goto L29;
        CharSequence r131 = r100.subSequence(r130.start(), r100.length());
        Matcher r132 = f492214u.matcher(r131);
        if (r132.find() == false) goto L26;
        r131 = r131.subSequence(0, r132.start());
    L26:
        Matcher r133 = f492213t.matcher(r131);
        if (r133.find() == false) goto L30;
        r131 = r131.subSequence(0, r133.start());
    L30:
        r113.append(r131);
        goto L31
    L29:
        r131 = "";
        goto L30
    L139:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
    L141:
        throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
    }
}
