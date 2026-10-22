package io.michaelrocks.libphonenumber.android;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class Phonemetadata$PhoneMetadata implements Externalizable {
    private static final long serialVersionUID = 1;
    private Phonemetadata$PhoneNumberDesc carrierSpecific_;
    private int countryCode_;
    private Phonemetadata$PhoneNumberDesc emergency_;
    private Phonemetadata$PhoneNumberDesc fixedLine_;
    private Phonemetadata$PhoneNumberDesc generalDesc_;
    private boolean hasCarrierSpecific;
    private boolean hasCountryCode;
    private boolean hasEmergency;
    private boolean hasFixedLine;
    private boolean hasGeneralDesc;
    private boolean hasId;
    private boolean hasInternationalPrefix;
    private boolean hasLeadingDigits;
    private boolean hasLeadingZeroPossible;
    private boolean hasMainCountryForCode;
    private boolean hasMobile;
    private boolean hasMobileNumberPortableRegion;
    private boolean hasNationalPrefix;
    private boolean hasNationalPrefixForParsing;
    private boolean hasNationalPrefixTransformRule;
    private boolean hasNoInternationalDialling;
    private boolean hasPager;
    private boolean hasPersonalNumber;
    private boolean hasPreferredExtnPrefix;
    private boolean hasPreferredInternationalPrefix;
    private boolean hasPremiumRate;
    private boolean hasSameMobileAndFixedLinePattern;
    private boolean hasSharedCost;
    private boolean hasShortCode;
    private boolean hasSmsServices;
    private boolean hasStandardRate;
    private boolean hasTollFree;
    private boolean hasUan;
    private boolean hasVoicemail;
    private boolean hasVoip;
    private String id_;
    private String internationalPrefix_;
    private List<Phonemetadata$NumberFormat> intlNumberFormat_;
    private String leadingDigits_;
    private boolean leadingZeroPossible_;
    private boolean mainCountryForCode_;
    private boolean mobileNumberPortableRegion_;
    private Phonemetadata$PhoneNumberDesc mobile_;
    private String nationalPrefixForParsing_;
    private String nationalPrefixTransformRule_;
    private String nationalPrefix_;
    private Phonemetadata$PhoneNumberDesc noInternationalDialling_;
    private List<Phonemetadata$NumberFormat> numberFormat_;
    private Phonemetadata$PhoneNumberDesc pager_;
    private Phonemetadata$PhoneNumberDesc personalNumber_;
    private String preferredExtnPrefix_;
    private String preferredInternationalPrefix_;
    private Phonemetadata$PhoneNumberDesc premiumRate_;
    private boolean sameMobileAndFixedLinePattern_;
    private Phonemetadata$PhoneNumberDesc sharedCost_;
    private Phonemetadata$PhoneNumberDesc shortCode_;
    private Phonemetadata$PhoneNumberDesc smsServices_;
    private Phonemetadata$PhoneNumberDesc standardRate_;
    private Phonemetadata$PhoneNumberDesc tollFree_;
    private Phonemetadata$PhoneNumberDesc uan_;
    private Phonemetadata$PhoneNumberDesc voicemail_;
    private Phonemetadata$PhoneNumberDesc voip_;

    public static final class Builder extends Phonemetadata$PhoneMetadata {
        public Phonemetadata$PhoneMetadata build() {
            return this;
        }

        public Builder() {
        }
    }

    public Phonemetadata$PhoneMetadata clearLeadingZeroPossible() {
        this.hasLeadingZeroPossible = false;
        this.leadingZeroPossible_ = false;
        return this;
    }

    public Phonemetadata$PhoneMetadata clearMainCountryForCode() {
        this.hasMainCountryForCode = false;
        this.mainCountryForCode_ = false;
        return this;
    }

    public Phonemetadata$PhoneMetadata clearMobileNumberPortableRegion() {
        this.hasMobileNumberPortableRegion = false;
        this.mobileNumberPortableRegion_ = false;
        return this;
    }

    public Phonemetadata$PhoneMetadata clearNationalPrefix() {
        this.hasNationalPrefix = false;
        this.nationalPrefix_ = "";
        return this;
    }

    public Phonemetadata$PhoneMetadata clearNationalPrefixTransformRule() {
        this.hasNationalPrefixTransformRule = false;
        this.nationalPrefixTransformRule_ = "";
        return this;
    }

    public Phonemetadata$PhoneMetadata clearPreferredExtnPrefix() {
        this.hasPreferredExtnPrefix = false;
        this.preferredExtnPrefix_ = "";
        return this;
    }

    public Phonemetadata$PhoneMetadata clearPreferredInternationalPrefix() {
        this.hasPreferredInternationalPrefix = false;
        this.preferredInternationalPrefix_ = "";
        return this;
    }

    public Phonemetadata$PhoneMetadata clearSameMobileAndFixedLinePattern() {
        this.hasSameMobileAndFixedLinePattern = false;
        this.sameMobileAndFixedLinePattern_ = false;
        return this;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Phonemetadata$PhoneMetadata clearIntlNumberFormat() {
        this.intlNumberFormat_.clear();
        return this;
    }

    public int intlNumberFormatSize() {
        return this.intlNumberFormat_.size();
    }

    public int numberFormatSize() {
        return this.numberFormat_.size();
    }

    public Phonemetadata$PhoneMetadata() {
        this.generalDesc_ = null;
        this.fixedLine_ = null;
        this.mobile_ = null;
        this.tollFree_ = null;
        this.premiumRate_ = null;
        this.sharedCost_ = null;
        this.personalNumber_ = null;
        this.voip_ = null;
        this.pager_ = null;
        this.uan_ = null;
        this.emergency_ = null;
        this.voicemail_ = null;
        this.shortCode_ = null;
        this.standardRate_ = null;
        this.carrierSpecific_ = null;
        this.smsServices_ = null;
        this.noInternationalDialling_ = null;
        this.id_ = "";
        this.countryCode_ = 0;
        this.internationalPrefix_ = "";
        this.preferredInternationalPrefix_ = "";
        this.nationalPrefix_ = "";
        this.preferredExtnPrefix_ = "";
        this.nationalPrefixForParsing_ = "";
        this.nationalPrefixTransformRule_ = "";
        this.sameMobileAndFixedLinePattern_ = false;
        this.numberFormat_ = new ArrayList();
        this.intlNumberFormat_ = new ArrayList();
        this.mainCountryForCode_ = false;
        this.leadingDigits_ = "";
        this.leadingZeroPossible_ = false;
        this.mobileNumberPortableRegion_ = false;
    }

    public Phonemetadata$PhoneNumberDesc getCarrierSpecific() {
        return this.carrierSpecific_;
    }

    public int getCountryCode() {
        return this.countryCode_;
    }

    public Phonemetadata$PhoneNumberDesc getEmergency() {
        return this.emergency_;
    }

    public Phonemetadata$PhoneNumberDesc getFixedLine() {
        return this.fixedLine_;
    }

    public Phonemetadata$PhoneNumberDesc getGeneralDesc() {
        return this.generalDesc_;
    }

    public String getId() {
        return this.id_;
    }

    public String getInternationalPrefix() {
        return this.internationalPrefix_;
    }

    public String getLeadingDigits() {
        return this.leadingDigits_;
    }

    public boolean getMainCountryForCode() {
        return this.mainCountryForCode_;
    }

    public Phonemetadata$PhoneNumberDesc getMobile() {
        return this.mobile_;
    }

    public String getNationalPrefix() {
        return this.nationalPrefix_;
    }

    public String getNationalPrefixForParsing() {
        return this.nationalPrefixForParsing_;
    }

    public String getNationalPrefixTransformRule() {
        return this.nationalPrefixTransformRule_;
    }

    public Phonemetadata$PhoneNumberDesc getNoInternationalDialling() {
        return this.noInternationalDialling_;
    }

    public Phonemetadata$PhoneNumberDesc getPager() {
        return this.pager_;
    }

    public Phonemetadata$PhoneNumberDesc getPersonalNumber() {
        return this.personalNumber_;
    }

    public String getPreferredExtnPrefix() {
        return this.preferredExtnPrefix_;
    }

    public String getPreferredInternationalPrefix() {
        return this.preferredInternationalPrefix_;
    }

    public Phonemetadata$PhoneNumberDesc getPremiumRate() {
        return this.premiumRate_;
    }

    public boolean getSameMobileAndFixedLinePattern() {
        return this.sameMobileAndFixedLinePattern_;
    }

    public Phonemetadata$PhoneNumberDesc getSharedCost() {
        return this.sharedCost_;
    }

    public Phonemetadata$PhoneNumberDesc getShortCode() {
        return this.shortCode_;
    }

    public Phonemetadata$PhoneNumberDesc getSmsServices() {
        return this.smsServices_;
    }

    public Phonemetadata$PhoneNumberDesc getStandardRate() {
        return this.standardRate_;
    }

    public Phonemetadata$PhoneNumberDesc getTollFree() {
        return this.tollFree_;
    }

    public Phonemetadata$PhoneNumberDesc getUan() {
        return this.uan_;
    }

    public Phonemetadata$PhoneNumberDesc getVoicemail() {
        return this.voicemail_;
    }

    public Phonemetadata$PhoneNumberDesc getVoip() {
        return this.voip_;
    }

    public boolean hasCarrierSpecific() {
        return this.hasCarrierSpecific;
    }

    public boolean hasCountryCode() {
        return this.hasCountryCode;
    }

    public boolean hasEmergency() {
        return this.hasEmergency;
    }

    public boolean hasFixedLine() {
        return this.hasFixedLine;
    }

    public boolean hasGeneralDesc() {
        return this.hasGeneralDesc;
    }

    public boolean hasId() {
        return this.hasId;
    }

    public boolean hasInternationalPrefix() {
        return this.hasInternationalPrefix;
    }

    public boolean hasLeadingDigits() {
        return this.hasLeadingDigits;
    }

    public boolean hasLeadingZeroPossible() {
        return this.hasLeadingZeroPossible;
    }

    public boolean hasMainCountryForCode() {
        return this.hasMainCountryForCode;
    }

    public boolean hasMobile() {
        return this.hasMobile;
    }

    public boolean hasMobileNumberPortableRegion() {
        return this.hasMobileNumberPortableRegion;
    }

    public boolean hasNationalPrefix() {
        return this.hasNationalPrefix;
    }

    public boolean hasNationalPrefixForParsing() {
        return this.hasNationalPrefixForParsing;
    }

    public boolean hasNationalPrefixTransformRule() {
        return this.hasNationalPrefixTransformRule;
    }

    public boolean hasNoInternationalDialling() {
        return this.hasNoInternationalDialling;
    }

    public boolean hasPager() {
        return this.hasPager;
    }

    public boolean hasPersonalNumber() {
        return this.hasPersonalNumber;
    }

    public boolean hasPreferredExtnPrefix() {
        return this.hasPreferredExtnPrefix;
    }

    public boolean hasPreferredInternationalPrefix() {
        return this.hasPreferredInternationalPrefix;
    }

    public boolean hasPremiumRate() {
        return this.hasPremiumRate;
    }

    public boolean hasSameMobileAndFixedLinePattern() {
        return this.hasSameMobileAndFixedLinePattern;
    }

    public boolean hasSharedCost() {
        return this.hasSharedCost;
    }

    public boolean hasShortCode() {
        return this.hasShortCode;
    }

    public boolean hasSmsServices() {
        return this.hasSmsServices;
    }

    public boolean hasStandardRate() {
        return this.hasStandardRate;
    }

    public boolean hasTollFree() {
        return this.hasTollFree;
    }

    public boolean hasUan() {
        return this.hasUan;
    }

    public boolean hasVoicemail() {
        return this.hasVoicemail;
    }

    public boolean hasVoip() {
        return this.hasVoip;
    }

    public List<Phonemetadata$NumberFormat> intlNumberFormats() {
        return this.intlNumberFormat_;
    }

    public boolean isLeadingZeroPossible() {
        return this.leadingZeroPossible_;
    }

    public boolean isMainCountryForCode() {
        return this.mainCountryForCode_;
    }

    public boolean isMobileNumberPortableRegion() {
        return this.mobileNumberPortableRegion_;
    }

    public List<Phonemetadata$NumberFormat> numberFormats() {
        return this.numberFormat_;
    }

    public Phonemetadata$PhoneMetadata addIntlNumberFormat(Phonemetadata$NumberFormat r100) {
        if (r100 == null) goto L6;
        this.intlNumberFormat_.add(r100);
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata addNumberFormat(Phonemetadata$NumberFormat r100) {
        if (r100 == null) goto L6;
        this.numberFormat_.add(r100);
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$NumberFormat getIntlNumberFormat(int r100) {
        return (Phonemetadata$NumberFormat) ListProtector.get(this.intlNumberFormat_, r100);
    }

    public Phonemetadata$NumberFormat getNumberFormat(int r100) {
        return (Phonemetadata$NumberFormat) ListProtector.get(this.numberFormat_, r100);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r100) throws IOException {
        if (r100.readBoolean() == false) goto L6;
        Phonemetadata$PhoneNumberDesc r101 = new Phonemetadata$PhoneNumberDesc();
        r101.readExternal(r100);
        setGeneralDesc(r101);
    L6:
        if (r100.readBoolean() == false) goto L9;
        Phonemetadata$PhoneNumberDesc r102 = new Phonemetadata$PhoneNumberDesc();
        r102.readExternal(r100);
        setFixedLine(r102);
    L9:
        if (r100.readBoolean() == false) goto L12;
        Phonemetadata$PhoneNumberDesc r103 = new Phonemetadata$PhoneNumberDesc();
        r103.readExternal(r100);
        setMobile(r103);
    L12:
        if (r100.readBoolean() == false) goto L15;
        Phonemetadata$PhoneNumberDesc r104 = new Phonemetadata$PhoneNumberDesc();
        r104.readExternal(r100);
        setTollFree(r104);
    L15:
        if (r100.readBoolean() == false) goto L18;
        Phonemetadata$PhoneNumberDesc r105 = new Phonemetadata$PhoneNumberDesc();
        r105.readExternal(r100);
        setPremiumRate(r105);
    L18:
        if (r100.readBoolean() == false) goto L21;
        Phonemetadata$PhoneNumberDesc r106 = new Phonemetadata$PhoneNumberDesc();
        r106.readExternal(r100);
        setSharedCost(r106);
    L21:
        if (r100.readBoolean() == false) goto L24;
        Phonemetadata$PhoneNumberDesc r107 = new Phonemetadata$PhoneNumberDesc();
        r107.readExternal(r100);
        setPersonalNumber(r107);
    L24:
        if (r100.readBoolean() == false) goto L27;
        Phonemetadata$PhoneNumberDesc r108 = new Phonemetadata$PhoneNumberDesc();
        r108.readExternal(r100);
        setVoip(r108);
    L27:
        if (r100.readBoolean() == false) goto L30;
        Phonemetadata$PhoneNumberDesc r109 = new Phonemetadata$PhoneNumberDesc();
        r109.readExternal(r100);
        setPager(r109);
    L30:
        if (r100.readBoolean() == false) goto L33;
        Phonemetadata$PhoneNumberDesc r110 = new Phonemetadata$PhoneNumberDesc();
        r110.readExternal(r100);
        setUan(r110);
    L33:
        if (r100.readBoolean() == false) goto L36;
        Phonemetadata$PhoneNumberDesc r111 = new Phonemetadata$PhoneNumberDesc();
        r111.readExternal(r100);
        setEmergency(r111);
    L36:
        if (r100.readBoolean() == false) goto L39;
        Phonemetadata$PhoneNumberDesc r112 = new Phonemetadata$PhoneNumberDesc();
        r112.readExternal(r100);
        setVoicemail(r112);
    L39:
        if (r100.readBoolean() == false) goto L42;
        Phonemetadata$PhoneNumberDesc r113 = new Phonemetadata$PhoneNumberDesc();
        r113.readExternal(r100);
        setShortCode(r113);
    L42:
        if (r100.readBoolean() == false) goto L45;
        Phonemetadata$PhoneNumberDesc r114 = new Phonemetadata$PhoneNumberDesc();
        r114.readExternal(r100);
        setStandardRate(r114);
    L45:
        if (r100.readBoolean() == false) goto L48;
        Phonemetadata$PhoneNumberDesc r115 = new Phonemetadata$PhoneNumberDesc();
        r115.readExternal(r100);
        setCarrierSpecific(r115);
    L48:
        if (r100.readBoolean() == false) goto L51;
        Phonemetadata$PhoneNumberDesc r116 = new Phonemetadata$PhoneNumberDesc();
        r116.readExternal(r100);
        setSmsServices(r116);
    L51:
        if (r100.readBoolean() == false) goto L53;
        Phonemetadata$PhoneNumberDesc r117 = new Phonemetadata$PhoneNumberDesc();
        r117.readExternal(r100);
        setNoInternationalDialling(r117);
    L53:
        setId(r100.readUTF());
        setCountryCode(r100.readInt());
        setInternationalPrefix(r100.readUTF());
        if (r100.readBoolean() == false) goto L57;
        setPreferredInternationalPrefix(r100.readUTF());
    L57:
        if (r100.readBoolean() == false) goto L60;
        setNationalPrefix(r100.readUTF());
    L60:
        if (r100.readBoolean() == false) goto L63;
        setPreferredExtnPrefix(r100.readUTF());
    L63:
        if (r100.readBoolean() == false) goto L66;
        setNationalPrefixForParsing(r100.readUTF());
    L66:
        if (r100.readBoolean() == false) goto L68;
        setNationalPrefixTransformRule(r100.readUTF());
    L68:
        setSameMobileAndFixedLinePattern(r100.readBoolean());
        int r118 = r100.readInt();
        int r119 = 0;
        int r120 = 0;
    L69:
        if (r120 >= r118) goto L71;
        Phonemetadata$NumberFormat r121 = new Phonemetadata$NumberFormat();
        r121.readExternal(r100);
        this.numberFormat_.add(r121);
        r120 = r120 + 1;
        goto L69
    L71:
        int r122 = r100.readInt();
    L72:
        if (r119 >= r122) goto L74;
        Phonemetadata$NumberFormat r123 = new Phonemetadata$NumberFormat();
        r123.readExternal(r100);
        this.intlNumberFormat_.add(r123);
        r119 = r119 + 1;
        goto L72
    L74:
        setMainCountryForCode(r100.readBoolean());
        if (r100.readBoolean() == false) goto L77;
        setLeadingDigits(r100.readUTF());
    L77:
        setLeadingZeroPossible(r100.readBoolean());
        setMobileNumberPortableRegion(r100.readBoolean());
    }

    public Phonemetadata$PhoneMetadata setCarrierSpecific(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasCarrierSpecific = true;
        this.carrierSpecific_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setCountryCode(int r100) {
        this.hasCountryCode = true;
        this.countryCode_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setEmergency(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasEmergency = true;
        this.emergency_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setFixedLine(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasFixedLine = true;
        this.fixedLine_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setGeneralDesc(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasGeneralDesc = true;
        this.generalDesc_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setId(String r100) {
        this.hasId = true;
        this.id_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setInternationalPrefix(String r100) {
        this.hasInternationalPrefix = true;
        this.internationalPrefix_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setLeadingDigits(String r100) {
        this.hasLeadingDigits = true;
        this.leadingDigits_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setLeadingZeroPossible(boolean r100) {
        this.hasLeadingZeroPossible = true;
        this.leadingZeroPossible_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setMainCountryForCode(boolean r100) {
        this.hasMainCountryForCode = true;
        this.mainCountryForCode_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setMobile(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasMobile = true;
        this.mobile_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setMobileNumberPortableRegion(boolean r100) {
        this.hasMobileNumberPortableRegion = true;
        this.mobileNumberPortableRegion_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setNationalPrefix(String r100) {
        this.hasNationalPrefix = true;
        this.nationalPrefix_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setNationalPrefixForParsing(String r100) {
        this.hasNationalPrefixForParsing = true;
        this.nationalPrefixForParsing_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setNationalPrefixTransformRule(String r100) {
        this.hasNationalPrefixTransformRule = true;
        this.nationalPrefixTransformRule_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setNoInternationalDialling(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasNoInternationalDialling = true;
        this.noInternationalDialling_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setPager(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasPager = true;
        this.pager_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setPersonalNumber(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasPersonalNumber = true;
        this.personalNumber_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setPreferredExtnPrefix(String r100) {
        this.hasPreferredExtnPrefix = true;
        this.preferredExtnPrefix_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setPreferredInternationalPrefix(String r100) {
        this.hasPreferredInternationalPrefix = true;
        this.preferredInternationalPrefix_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setPremiumRate(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasPremiumRate = true;
        this.premiumRate_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setSameMobileAndFixedLinePattern(boolean r100) {
        this.hasSameMobileAndFixedLinePattern = true;
        this.sameMobileAndFixedLinePattern_ = r100;
        return this;
    }

    public Phonemetadata$PhoneMetadata setSharedCost(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasSharedCost = true;
        this.sharedCost_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setShortCode(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasShortCode = true;
        this.shortCode_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setSmsServices(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasSmsServices = true;
        this.smsServices_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setStandardRate(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasStandardRate = true;
        this.standardRate_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setTollFree(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasTollFree = true;
        this.tollFree_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setUan(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasUan = true;
        this.uan_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setVoicemail(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasVoicemail = true;
        this.voicemail_ = r100;
        return this;
    L6:
        throw null;
    }

    public Phonemetadata$PhoneMetadata setVoip(Phonemetadata$PhoneNumberDesc r100) {
        if (r100 == null) goto L6;
        this.hasVoip = true;
        this.voip_ = r100;
        return this;
    L6:
        throw null;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r100) throws IOException {
        r100.writeBoolean(this.hasGeneralDesc);
        if (this.hasGeneralDesc == false) goto L5;
        this.generalDesc_.writeExternal(r100);
    L5:
        r100.writeBoolean(this.hasFixedLine);
        if (this.hasFixedLine == false) goto L8;
        this.fixedLine_.writeExternal(r100);
    L8:
        r100.writeBoolean(this.hasMobile);
        if (this.hasMobile == false) goto L11;
        this.mobile_.writeExternal(r100);
    L11:
        r100.writeBoolean(this.hasTollFree);
        if (this.hasTollFree == false) goto L14;
        this.tollFree_.writeExternal(r100);
    L14:
        r100.writeBoolean(this.hasPremiumRate);
        if (this.hasPremiumRate == false) goto L17;
        this.premiumRate_.writeExternal(r100);
    L17:
        r100.writeBoolean(this.hasSharedCost);
        if (this.hasSharedCost == false) goto L20;
        this.sharedCost_.writeExternal(r100);
    L20:
        r100.writeBoolean(this.hasPersonalNumber);
        if (this.hasPersonalNumber == false) goto L23;
        this.personalNumber_.writeExternal(r100);
    L23:
        r100.writeBoolean(this.hasVoip);
        if (this.hasVoip == false) goto L26;
        this.voip_.writeExternal(r100);
    L26:
        r100.writeBoolean(this.hasPager);
        if (this.hasPager == false) goto L29;
        this.pager_.writeExternal(r100);
    L29:
        r100.writeBoolean(this.hasUan);
        if (this.hasUan == false) goto L32;
        this.uan_.writeExternal(r100);
    L32:
        r100.writeBoolean(this.hasEmergency);
        if (this.hasEmergency == false) goto L35;
        this.emergency_.writeExternal(r100);
    L35:
        r100.writeBoolean(this.hasVoicemail);
        if (this.hasVoicemail == false) goto L38;
        this.voicemail_.writeExternal(r100);
    L38:
        r100.writeBoolean(this.hasShortCode);
        if (this.hasShortCode == false) goto L41;
        this.shortCode_.writeExternal(r100);
    L41:
        r100.writeBoolean(this.hasStandardRate);
        if (this.hasStandardRate == false) goto L44;
        this.standardRate_.writeExternal(r100);
    L44:
        r100.writeBoolean(this.hasCarrierSpecific);
        if (this.hasCarrierSpecific == false) goto L47;
        this.carrierSpecific_.writeExternal(r100);
    L47:
        r100.writeBoolean(this.hasSmsServices);
        if (this.hasSmsServices == false) goto L50;
        this.smsServices_.writeExternal(r100);
    L50:
        r100.writeBoolean(this.hasNoInternationalDialling);
        if (this.hasNoInternationalDialling == false) goto L53;
        this.noInternationalDialling_.writeExternal(r100);
    L53:
        r100.writeUTF(this.id_);
        r100.writeInt(this.countryCode_);
        r100.writeUTF(this.internationalPrefix_);
        r100.writeBoolean(this.hasPreferredInternationalPrefix);
        if (this.hasPreferredInternationalPrefix == false) goto L56;
        r100.writeUTF(this.preferredInternationalPrefix_);
    L56:
        r100.writeBoolean(this.hasNationalPrefix);
        if (this.hasNationalPrefix == false) goto L59;
        r100.writeUTF(this.nationalPrefix_);
    L59:
        r100.writeBoolean(this.hasPreferredExtnPrefix);
        if (this.hasPreferredExtnPrefix == false) goto L62;
        r100.writeUTF(this.preferredExtnPrefix_);
    L62:
        r100.writeBoolean(this.hasNationalPrefixForParsing);
        if (this.hasNationalPrefixForParsing == false) goto L65;
        r100.writeUTF(this.nationalPrefixForParsing_);
    L65:
        r100.writeBoolean(this.hasNationalPrefixTransformRule);
        if (this.hasNationalPrefixTransformRule == false) goto L68;
        r100.writeUTF(this.nationalPrefixTransformRule_);
    L68:
        r100.writeBoolean(this.sameMobileAndFixedLinePattern_);
        int r101 = numberFormatSize();
        r100.writeInt(r101);
        int r102 = 0;
        int r103 = 0;
    L69:
        if (r103 >= r101) goto L71;
        ((Phonemetadata$NumberFormat) ListProtector.get(this.numberFormat_, r103)).writeExternal(r100);
        r103 = r103 + 1;
        goto L69
    L71:
        int r104 = intlNumberFormatSize();
        r100.writeInt(r104);
    L72:
        if (r102 >= r104) goto L74;
        ((Phonemetadata$NumberFormat) ListProtector.get(this.intlNumberFormat_, r102)).writeExternal(r100);
        r102 = r102 + 1;
        goto L72
    L74:
        r100.writeBoolean(this.mainCountryForCode_);
        r100.writeBoolean(this.hasLeadingDigits);
        if (this.hasLeadingDigits == false) goto L77;
        r100.writeUTF(this.leadingDigits_);
    L77:
        r100.writeBoolean(this.leadingZeroPossible_);
        r100.writeBoolean(this.mobileNumberPortableRegion_);
    }
}
