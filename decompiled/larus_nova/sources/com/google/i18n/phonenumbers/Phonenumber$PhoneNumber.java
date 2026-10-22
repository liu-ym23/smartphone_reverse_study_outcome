package com.google.i18n.phonenumbers;

import java.io.Serializable;

/* JADX INFO: loaded from: classes23.dex */
public class Phonenumber$PhoneNumber implements Serializable {
    private static final long serialVersionUID = 1;
    private CountryCodeSource countryCodeSource_;
    private int countryCode_;
    private String extension_;
    private boolean hasCountryCode;
    private boolean hasCountryCodeSource;
    private boolean hasExtension;
    private boolean hasItalianLeadingZero;
    private boolean hasNationalNumber;
    private boolean hasNumberOfLeadingZeros;
    private boolean hasPreferredDomesticCarrierCode;
    private boolean hasRawInput;
    private boolean italianLeadingZero_;
    private long nationalNumber_;
    private int numberOfLeadingZeros_;
    private String preferredDomesticCarrierCode_;
    private String rawInput_;

    public static final enum CountryCodeSource extends Enum<CountryCodeSource> {
        public static final CountryCodeSource FROM_DEFAULT_COUNTRY = null;
        public static final CountryCodeSource FROM_NUMBER_WITHOUT_PLUS_SIGN = null;
        public static final CountryCodeSource FROM_NUMBER_WITH_IDD = null;
        public static final CountryCodeSource FROM_NUMBER_WITH_PLUS_SIGN = null;
        public static final CountryCodeSource UNSPECIFIED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CountryCodeSource[] f275922a = null;

        static {
            CountryCodeSource r100 = new CountryCodeSource("FROM_NUMBER_WITH_PLUS_SIGN", 0);
            FROM_NUMBER_WITH_PLUS_SIGN = r100;
            CountryCodeSource r101 = new CountryCodeSource("FROM_NUMBER_WITH_IDD", 1);
            FROM_NUMBER_WITH_IDD = r101;
            CountryCodeSource r102 = new CountryCodeSource("FROM_NUMBER_WITHOUT_PLUS_SIGN", 2);
            FROM_NUMBER_WITHOUT_PLUS_SIGN = r102;
            CountryCodeSource r103 = new CountryCodeSource("FROM_DEFAULT_COUNTRY", 3);
            FROM_DEFAULT_COUNTRY = r103;
            CountryCodeSource r104 = new CountryCodeSource("UNSPECIFIED", 4);
            UNSPECIFIED = r104;
            f275922a = new CountryCodeSource[]{r100, r101, r102, r103, r104};
        }

        public static CountryCodeSource[] values() {
            return (CountryCodeSource[]) f275922a.clone();
        }

        public static CountryCodeSource valueOf(String r100) {
            return (CountryCodeSource) r27.a.a(CountryCodeSource.class, r100);
        }

        public CountryCodeSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public Phonenumber$PhoneNumber clearCountryCode() {
        this.hasCountryCode = false;
        this.countryCode_ = 0;
        return this;
    }

    public Phonenumber$PhoneNumber clearCountryCodeSource() {
        this.hasCountryCodeSource = false;
        this.countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
        return this;
    }

    public Phonenumber$PhoneNumber clearExtension() {
        this.hasExtension = false;
        this.extension_ = "";
        return this;
    }

    public Phonenumber$PhoneNumber clearItalianLeadingZero() {
        this.hasItalianLeadingZero = false;
        this.italianLeadingZero_ = false;
        return this;
    }

    public Phonenumber$PhoneNumber clearNationalNumber() {
        this.hasNationalNumber = false;
        this.nationalNumber_ = 0;
        return this;
    }

    public Phonenumber$PhoneNumber clearNumberOfLeadingZeros() {
        this.hasNumberOfLeadingZeros = false;
        this.numberOfLeadingZeros_ = 1;
        return this;
    }

    public Phonenumber$PhoneNumber clearPreferredDomesticCarrierCode() {
        this.hasPreferredDomesticCarrierCode = false;
        this.preferredDomesticCarrierCode_ = "";
        return this;
    }

    public Phonenumber$PhoneNumber clearRawInput() {
        this.hasRawInput = false;
        this.rawInput_ = "";
        return this;
    }

    public int hashCode() {
        int r100 = (((((2173 + getCountryCode()) * 53) + Long.valueOf(getNationalNumber()).hashCode()) * 53) + getExtension().hashCode()) * 53;
        int r101 = 1231;
        if (isItalianLeadingZero() == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((r100 + r102) * 53) + getNumberOfLeadingZeros()) * 53) + getRawInput().hashCode()) * 53) + getCountryCodeSource().hashCode()) * 53) + getPreferredDomesticCarrierCode().hashCode()) * 53;
        if (hasPreferredDomesticCarrierCode() == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Country Code: ");
        r100.append(this.countryCode_);
        r100.append(" National Number: ");
        r100.append(this.nationalNumber_);
        if (hasItalianLeadingZero() == false) goto L8;
        if (isItalianLeadingZero() == false) goto L8;
        r100.append(" Leading Zero(s): true");
    L8:
        if (hasNumberOfLeadingZeros() == false) goto L11;
        r100.append(" Number of leading zeros: ");
        r100.append(this.numberOfLeadingZeros_);
    L11:
        if (hasExtension() == false) goto L14;
        r100.append(" Extension: ");
        r100.append(this.extension_);
    L14:
        if (hasCountryCodeSource() == false) goto L17;
        r100.append(" Country Code Source: ");
        r100.append(this.countryCodeSource_);
    L17:
        if (hasPreferredDomesticCarrierCode() == false) goto L20;
        r100.append(" Preferred Domestic Carrier Code: ");
        r100.append(this.preferredDomesticCarrierCode_);
    L20:
        return r100.toString();
    }

    public Phonenumber$PhoneNumber() {
        this.countryCode_ = 0;
        this.nationalNumber_ = 0;
        this.extension_ = "";
        this.italianLeadingZero_ = false;
        this.numberOfLeadingZeros_ = 1;
        this.rawInput_ = "";
        this.preferredDomesticCarrierCode_ = "";
        this.countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
    }

    public final Phonenumber$PhoneNumber clear() {
        clearCountryCode();
        clearNationalNumber();
        clearExtension();
        clearItalianLeadingZero();
        clearNumberOfLeadingZeros();
        clearRawInput();
        clearCountryCodeSource();
        clearPreferredDomesticCarrierCode();
        return this;
    }

    public int getCountryCode() {
        return this.countryCode_;
    }

    public CountryCodeSource getCountryCodeSource() {
        return this.countryCodeSource_;
    }

    public String getExtension() {
        return this.extension_;
    }

    public long getNationalNumber() {
        return this.nationalNumber_;
    }

    public int getNumberOfLeadingZeros() {
        return this.numberOfLeadingZeros_;
    }

    public String getPreferredDomesticCarrierCode() {
        return this.preferredDomesticCarrierCode_;
    }

    public String getRawInput() {
        return this.rawInput_;
    }

    public boolean hasCountryCode() {
        return this.hasCountryCode;
    }

    public boolean hasCountryCodeSource() {
        return this.hasCountryCodeSource;
    }

    public boolean hasExtension() {
        return this.hasExtension;
    }

    public boolean hasItalianLeadingZero() {
        return this.hasItalianLeadingZero;
    }

    public boolean hasNationalNumber() {
        return this.hasNationalNumber;
    }

    public boolean hasNumberOfLeadingZeros() {
        return this.hasNumberOfLeadingZeros;
    }

    public boolean hasPreferredDomesticCarrierCode() {
        return this.hasPreferredDomesticCarrierCode;
    }

    public boolean hasRawInput() {
        return this.hasRawInput;
    }

    public boolean isItalianLeadingZero() {
        return this.italianLeadingZero_;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Phonenumber$PhoneNumber) == true) goto L5;
    L7:
        return false;
    L5:
        if (exactlySameAs((Phonenumber$PhoneNumber) r100) == false) goto L7;
        return true;
    }

    public boolean exactlySameAs(Phonenumber$PhoneNumber r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if (this.countryCode_ == r100.countryCode_) goto L11;
        return false;
    L11:
        if (this.nationalNumber_ == r100.nationalNumber_) goto L13;
        return false;
    L13:
        if (this.extension_.equals(r100.extension_) == true) goto L15;
        return false;
    L15:
        if (this.italianLeadingZero_ == r100.italianLeadingZero_) goto L17;
        return false;
    L17:
        if (this.numberOfLeadingZeros_ == r100.numberOfLeadingZeros_) goto L19;
        return false;
    L19:
        if (this.rawInput_.equals(r100.rawInput_) == true) goto L21;
        return false;
    L21:
        if (this.countryCodeSource_ == r100.countryCodeSource_) goto L23;
        return false;
    L23:
        if (this.preferredDomesticCarrierCode_.equals(r100.preferredDomesticCarrierCode_) == true) goto L25;
        return false;
    L25:
        if (hasPreferredDomesticCarrierCode() != r100.hasPreferredDomesticCarrierCode()) goto L36;
        return true;
    L36:
        return false;
    }

    public Phonenumber$PhoneNumber mergeFrom(Phonenumber$PhoneNumber r100) {
        if (r100.hasCountryCode() == false) goto L6;
        setCountryCode(r100.getCountryCode());
    L6:
        if (r100.hasNationalNumber() == false) goto L9;
        setNationalNumber(r100.getNationalNumber());
    L9:
        if (r100.hasExtension() == false) goto L12;
        setExtension(r100.getExtension());
    L12:
        if (r100.hasItalianLeadingZero() == false) goto L15;
        setItalianLeadingZero(r100.isItalianLeadingZero());
    L15:
        if (r100.hasNumberOfLeadingZeros() == false) goto L18;
        setNumberOfLeadingZeros(r100.getNumberOfLeadingZeros());
    L18:
        if (r100.hasRawInput() == false) goto L21;
        setRawInput(r100.getRawInput());
    L21:
        if (r100.hasCountryCodeSource() == false) goto L24;
        setCountryCodeSource(r100.getCountryCodeSource());
    L24:
        if (r100.hasPreferredDomesticCarrierCode() == false) goto L26;
        setPreferredDomesticCarrierCode(r100.getPreferredDomesticCarrierCode());
    L26:
        return this;
    }

    public Phonenumber$PhoneNumber setCountryCode(int r100) {
        this.hasCountryCode = true;
        this.countryCode_ = r100;
        return this;
    }

    public Phonenumber$PhoneNumber setCountryCodeSource(CountryCodeSource r100) {
        if (r100 == null) goto L6;
        this.hasCountryCodeSource = true;
        this.countryCodeSource_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonenumber$PhoneNumber setExtension(String r100) {
        if (r100 == null) goto L6;
        this.hasExtension = true;
        this.extension_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonenumber$PhoneNumber setItalianLeadingZero(boolean r100) {
        this.hasItalianLeadingZero = true;
        this.italianLeadingZero_ = r100;
        return this;
    }

    public Phonenumber$PhoneNumber setNationalNumber(long r100) {
        this.hasNationalNumber = true;
        this.nationalNumber_ = r100;
        return this;
    }

    public Phonenumber$PhoneNumber setNumberOfLeadingZeros(int r100) {
        this.hasNumberOfLeadingZeros = true;
        this.numberOfLeadingZeros_ = r100;
        return this;
    }

    public Phonenumber$PhoneNumber setPreferredDomesticCarrierCode(String r100) {
        if (r100 == null) goto L6;
        this.hasPreferredDomesticCarrierCode = true;
        this.preferredDomesticCarrierCode_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonenumber$PhoneNumber setRawInput(String r100) {
        if (r100 == null) goto L6;
        this.hasRawInput = true;
        this.rawInput_ = r100;
        return this;
    L6:
        throw null;
    }
}
