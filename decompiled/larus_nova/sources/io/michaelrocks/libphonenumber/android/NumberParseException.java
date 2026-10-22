package io.michaelrocks.libphonenumber.android;

/* JADX INFO: loaded from: classes41.dex */
public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;

    public static final enum ErrorType extends Enum<ErrorType> {
        public static final ErrorType INVALID_COUNTRY_CODE = null;
        public static final ErrorType NOT_A_NUMBER = null;
        public static final ErrorType TOO_LONG = null;
        public static final ErrorType TOO_SHORT_AFTER_IDD = null;
        public static final ErrorType TOO_SHORT_NSN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrorType[] f492182a = null;

        static {
            ErrorType r100 = new ErrorType("INVALID_COUNTRY_CODE", 0);
            INVALID_COUNTRY_CODE = r100;
            ErrorType r101 = new ErrorType("NOT_A_NUMBER", 1);
            NOT_A_NUMBER = r101;
            ErrorType r102 = new ErrorType("TOO_SHORT_AFTER_IDD", 2);
            TOO_SHORT_AFTER_IDD = r102;
            ErrorType r103 = new ErrorType("TOO_SHORT_NSN", 3);
            TOO_SHORT_NSN = r103;
            ErrorType r104 = new ErrorType("TOO_LONG", 4);
            TOO_LONG = r104;
            f492182a = new ErrorType[]{r100, r101, r102, r103, r104};
        }

        public static ErrorType[] values() {
            return (ErrorType[]) f492182a.clone();
        }

        public static ErrorType valueOf(String r100) {
            return (ErrorType) r27.a.a(ErrorType.class, r100);
        }

        public ErrorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.errorType + ". " + this.message;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public NumberParseException(ErrorType r100, String r101) {
        super(r101);
        this.message = r101;
        this.errorType = r100;
    }
}
