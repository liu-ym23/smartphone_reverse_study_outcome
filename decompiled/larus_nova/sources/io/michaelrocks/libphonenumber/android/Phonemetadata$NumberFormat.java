package io.michaelrocks.libphonenumber.android;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class Phonemetadata$NumberFormat implements Externalizable {
    private static final long serialVersionUID = 1;
    private String domesticCarrierCodeFormattingRule_;
    private String format_;
    private boolean hasDomesticCarrierCodeFormattingRule;
    private boolean hasFormat;
    private boolean hasNationalPrefixFormattingRule;
    private boolean hasNationalPrefixOptionalWhenFormatting;
    private boolean hasPattern;
    private List<String> leadingDigitsPattern_;
    private String nationalPrefixFormattingRule_;
    private boolean nationalPrefixOptionalWhenFormatting_;
    private String pattern_;

    public static final class Builder extends Phonemetadata$NumberFormat {
        public Phonemetadata$NumberFormat build() {
            return this;
        }

        public Builder() {
        }

        public Builder mergeFrom(Phonemetadata$NumberFormat r100) {
            if (r100.hasPattern() == false) goto L6;
            setPattern(r100.getPattern());
        L6:
            if (r100.hasFormat() == false) goto L8;
            setFormat(r100.getFormat());
        L8:
            int r101 = 0;
        L10:
            if (r101 >= r100.leadingDigitsPatternSize()) goto L13;
            addLeadingDigitsPattern(r100.getLeadingDigitsPattern(r101));
            r101 = r101 + 1;
            goto L10
        L13:
            if (r100.hasNationalPrefixFormattingRule() == false) goto L16;
            setNationalPrefixFormattingRule(r100.getNationalPrefixFormattingRule());
        L16:
            if (r100.hasDomesticCarrierCodeFormattingRule() == false) goto L19;
            setDomesticCarrierCodeFormattingRule(r100.getDomesticCarrierCodeFormattingRule());
        L19:
            if (r100.hasNationalPrefixOptionalWhenFormatting() == false) goto L21;
            setNationalPrefixOptionalWhenFormatting(r100.getNationalPrefixOptionalWhenFormatting());
        L21:
            return this;
        }
    }

    public Phonemetadata$NumberFormat clearNationalPrefixFormattingRule() {
        this.hasNationalPrefixFormattingRule = false;
        this.nationalPrefixFormattingRule_ = "";
        return this;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int leadingDigitsPatternSize() {
        return this.leadingDigitsPattern_.size();
    }

    public Phonemetadata$NumberFormat() {
        this.pattern_ = "";
        this.format_ = "";
        this.leadingDigitsPattern_ = new ArrayList();
        this.nationalPrefixFormattingRule_ = "";
        this.nationalPrefixOptionalWhenFormatting_ = false;
        this.domesticCarrierCodeFormattingRule_ = "";
    }

    public String getDomesticCarrierCodeFormattingRule() {
        return this.domesticCarrierCodeFormattingRule_;
    }

    public String getFormat() {
        return this.format_;
    }

    public String getNationalPrefixFormattingRule() {
        return this.nationalPrefixFormattingRule_;
    }

    public boolean getNationalPrefixOptionalWhenFormatting() {
        return this.nationalPrefixOptionalWhenFormatting_;
    }

    public String getPattern() {
        return this.pattern_;
    }

    public boolean hasDomesticCarrierCodeFormattingRule() {
        return this.hasDomesticCarrierCodeFormattingRule;
    }

    public boolean hasFormat() {
        return this.hasFormat;
    }

    public boolean hasNationalPrefixFormattingRule() {
        return this.hasNationalPrefixFormattingRule;
    }

    public boolean hasNationalPrefixOptionalWhenFormatting() {
        return this.hasNationalPrefixOptionalWhenFormatting;
    }

    public boolean hasPattern() {
        return this.hasPattern;
    }

    public List<String> leadingDigitPatterns() {
        return this.leadingDigitsPattern_;
    }

    public Phonemetadata$NumberFormat addLeadingDigitsPattern(String r100) {
        if (r100 == null) goto L6;
        this.leadingDigitsPattern_.add(r100);
        return this;
    L6:
        throw null;
    }

    public String getLeadingDigitsPattern(int r100) {
        return (String) ListProtector.get(this.leadingDigitsPattern_, r100);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r100) throws IOException {
        setPattern(r100.readUTF());
        setFormat(r100.readUTF());
        int r101 = r100.readInt();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        this.leadingDigitsPattern_.add(r100.readUTF());
        r102 = r102 + 1;
        goto L3
    L6:
        if (r100.readBoolean() == false) goto L9;
        setNationalPrefixFormattingRule(r100.readUTF());
    L9:
        if (r100.readBoolean() == false) goto L11;
        setDomesticCarrierCodeFormattingRule(r100.readUTF());
    L11:
        setNationalPrefixOptionalWhenFormatting(r100.readBoolean());
    }

    public Phonemetadata$NumberFormat setDomesticCarrierCodeFormattingRule(String r100) {
        this.hasDomesticCarrierCodeFormattingRule = true;
        this.domesticCarrierCodeFormattingRule_ = r100;
        return this;
    }

    public Phonemetadata$NumberFormat setFormat(String r100) {
        this.hasFormat = true;
        this.format_ = r100;
        return this;
    }

    public Phonemetadata$NumberFormat setNationalPrefixFormattingRule(String r100) {
        this.hasNationalPrefixFormattingRule = true;
        this.nationalPrefixFormattingRule_ = r100;
        return this;
    }

    public Phonemetadata$NumberFormat setNationalPrefixOptionalWhenFormatting(boolean r100) {
        this.hasNationalPrefixOptionalWhenFormatting = true;
        this.nationalPrefixOptionalWhenFormatting_ = r100;
        return this;
    }

    public Phonemetadata$NumberFormat setPattern(String r100) {
        this.hasPattern = true;
        this.pattern_ = r100;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r100) throws IOException {
        r100.writeUTF(this.pattern_);
        r100.writeUTF(this.format_);
        int r101 = leadingDigitsPatternSize();
        r100.writeInt(r101);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100.writeUTF((String) ListProtector.get(this.leadingDigitsPattern_, r102));
        r102 = r102 + 1;
        goto L3
    L5:
        r100.writeBoolean(this.hasNationalPrefixFormattingRule);
        if (this.hasNationalPrefixFormattingRule == false) goto L8;
        r100.writeUTF(this.nationalPrefixFormattingRule_);
    L8:
        r100.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
        if (this.hasDomesticCarrierCodeFormattingRule == false) goto L11;
        r100.writeUTF(this.domesticCarrierCodeFormattingRule_);
    L11:
        r100.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
    }
}
