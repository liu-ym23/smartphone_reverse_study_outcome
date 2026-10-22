package com.google.i18n.phonenumbers;

/* JADX INFO: loaded from: classes23.dex */
public final class PhoneNumberUtil {

    public static abstract enum Leniency extends Enum<Leniency> {
        public static final Leniency EXACT_GROUPING = null;
        public static final Leniency POSSIBLE = null;
        public static final Leniency STRICT_GROUPING = null;
        public static final Leniency VALID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Leniency[] f275917a = null;

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
            f275917a = new Leniency[]{r102, r105, r108, r111};
        }

        public static Leniency[] values() {
            return (Leniency[]) f275917a.clone();
        }

        public static Leniency valueOf(String r100) {
            return (Leniency) r27.a.a(Leniency.class, r100);
        }

        public Leniency(String r100, int r101, a r102) {
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
        public static final /* synthetic */ MatchType[] f275918a = null;

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
            f275918a = new MatchType[]{r100, r101, r102, r103, r104};
        }

        public static MatchType[] values() {
            return (MatchType[]) f275918a.clone();
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
        public static final /* synthetic */ PhoneNumberFormat[] f275919a = null;

        static {
            PhoneNumberFormat r100 = new PhoneNumberFormat("E164", 0);
            E164 = r100;
            PhoneNumberFormat r101 = new PhoneNumberFormat("INTERNATIONAL", 1);
            INTERNATIONAL = r101;
            PhoneNumberFormat r102 = new PhoneNumberFormat("NATIONAL", 2);
            NATIONAL = r102;
            PhoneNumberFormat r103 = new PhoneNumberFormat("RFC3966", 3);
            RFC3966 = r103;
            f275919a = new PhoneNumberFormat[]{r100, r101, r102, r103};
        }

        public static PhoneNumberFormat[] values() {
            return (PhoneNumberFormat[]) f275919a.clone();
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
        public static final /* synthetic */ PhoneNumberType[] f275920a = null;

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
            f275920a = new PhoneNumberType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        }

        public static PhoneNumberType[] values() {
            return (PhoneNumberType[]) f275920a.clone();
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
        public static final /* synthetic */ ValidationResult[] f275921a = null;

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
            f275921a = new ValidationResult[]{r100, r101, r102, r103, r104, r105};
        }

        public static ValidationResult[] values() {
            return (ValidationResult[]) f275921a.clone();
        }

        public static ValidationResult valueOf(String r100) {
            return (ValidationResult) r27.a.a(ValidationResult.class, r100);
        }

        public ValidationResult(String r100, int r101) {
            super(r100, r101);
        }
    }
}
