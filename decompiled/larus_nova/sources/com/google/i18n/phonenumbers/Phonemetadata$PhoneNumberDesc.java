package com.google.i18n.phonenumbers;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class Phonemetadata$PhoneNumberDesc implements Externalizable {
    private static final long serialVersionUID = 1;
    private String exampleNumber_;
    private boolean hasExampleNumber;
    private boolean hasNationalNumberPattern;
    private String nationalNumberPattern_;
    private List<Integer> possibleLengthLocalOnly_;
    private List<Integer> possibleLength_;

    public static final class Builder extends Phonemetadata$PhoneNumberDesc {
        public Phonemetadata$PhoneNumberDesc build() {
            return this;
        }

        public Builder() {
        }

        public Builder mergeFrom(Phonemetadata$PhoneNumberDesc r100) {
            if (r100.hasNationalNumberPattern() == false) goto L5;
            setNationalNumberPattern(r100.getNationalNumberPattern());
        L5:
            int r101 = 0;
            int r102 = 0;
        L7:
            if (r102 >= r100.getPossibleLengthCount()) goto L10;
            addPossibleLength(r100.getPossibleLength(r102));
            r102 = r102 + 1;
        L10:
            if (r101 >= r100.getPossibleLengthLocalOnlyCount()) goto L13;
            addPossibleLengthLocalOnly(r100.getPossibleLengthLocalOnly(r101));
            r101 = r101 + 1;
            goto L10
        L13:
            if (r100.hasExampleNumber() == false) goto L15;
            setExampleNumber(r100.getExampleNumber());
        L15:
            return this;
        }
    }

    public Phonemetadata$PhoneNumberDesc clearExampleNumber() {
        this.hasExampleNumber = false;
        this.exampleNumber_ = "";
        return this;
    }

    public Phonemetadata$PhoneNumberDesc clearNationalNumberPattern() {
        this.hasNationalNumberPattern = false;
        this.nationalNumberPattern_ = "";
        return this;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Phonemetadata$PhoneNumberDesc clearPossibleLength() {
        this.possibleLength_.clear();
        return this;
    }

    public Phonemetadata$PhoneNumberDesc clearPossibleLengthLocalOnly() {
        this.possibleLengthLocalOnly_.clear();
        return this;
    }

    public int getPossibleLengthCount() {
        return this.possibleLength_.size();
    }

    public int getPossibleLengthLocalOnlyCount() {
        return this.possibleLengthLocalOnly_.size();
    }

    public Phonemetadata$PhoneNumberDesc() {
        this.nationalNumberPattern_ = "";
        this.possibleLength_ = new ArrayList();
        this.possibleLengthLocalOnly_ = new ArrayList();
        this.exampleNumber_ = "";
    }

    public String getExampleNumber() {
        return this.exampleNumber_;
    }

    public String getNationalNumberPattern() {
        return this.nationalNumberPattern_;
    }

    public List<Integer> getPossibleLengthList() {
        return this.possibleLength_;
    }

    public List<Integer> getPossibleLengthLocalOnlyList() {
        return this.possibleLengthLocalOnly_;
    }

    public boolean hasExampleNumber() {
        return this.hasExampleNumber;
    }

    public boolean hasNationalNumberPattern() {
        return this.hasNationalNumberPattern;
    }

    public Phonemetadata$PhoneNumberDesc addPossibleLength(int r100) {
        this.possibleLength_.add(Integer.valueOf(r100));
        return this;
    }

    public Phonemetadata$PhoneNumberDesc addPossibleLengthLocalOnly(int r100) {
        this.possibleLengthLocalOnly_.add(Integer.valueOf(r100));
        return this;
    }

    public boolean exactlySameAs(Phonemetadata$PhoneNumberDesc r100) {
        if (this.nationalNumberPattern_.equals(r100.nationalNumberPattern_) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.possibleLength_.equals(r100.possibleLength_) == false) goto L11;
        if (this.possibleLengthLocalOnly_.equals(r100.possibleLengthLocalOnly_) == false) goto L11;
        if (this.exampleNumber_.equals(r100.exampleNumber_) == false) goto L11;
        return true;
    }

    public int getPossibleLength(int r100) {
        return ((Integer) ListProtector.get(this.possibleLength_, r100)).intValue();
    }

    public int getPossibleLengthLocalOnly(int r100) {
        return ((Integer) ListProtector.get(this.possibleLengthLocalOnly_, r100)).intValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r100) throws IOException {
        if (r100.readBoolean() == false) goto L5;
        setNationalNumberPattern(r100.readUTF());
    L5:
        int r101 = r100.readInt();
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L8;
        this.possibleLength_.add(Integer.valueOf(r100.readInt()));
        r103 = r103 + 1;
        goto L6
    L8:
        int r104 = r100.readInt();
    L9:
        if (r102 >= r104) goto L12;
        this.possibleLengthLocalOnly_.add(Integer.valueOf(r100.readInt()));
        r102 = r102 + 1;
        goto L9
    L12:
        if (r100.readBoolean() == false) goto L17;
        setExampleNumber(r100.readUTF());
        return;
    }

    public Phonemetadata$PhoneNumberDesc setExampleNumber(String r100) {
        this.hasExampleNumber = true;
        this.exampleNumber_ = r100;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc setNationalNumberPattern(String r100) {
        this.hasNationalNumberPattern = true;
        this.nationalNumberPattern_ = r100;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r100) throws IOException {
        r100.writeBoolean(this.hasNationalNumberPattern);
        if (this.hasNationalNumberPattern == false) goto L5;
        r100.writeUTF(this.nationalNumberPattern_);
    L5:
        int r101 = getPossibleLengthCount();
        r100.writeInt(r101);
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L8;
        r100.writeInt(((Integer) ListProtector.get(this.possibleLength_, r103)).intValue());
        r103 = r103 + 1;
        goto L6
    L8:
        int r104 = getPossibleLengthLocalOnlyCount();
        r100.writeInt(r104);
    L9:
        if (r102 >= r104) goto L11;
        r100.writeInt(((Integer) ListProtector.get(this.possibleLengthLocalOnly_, r102)).intValue());
        r102 = r102 + 1;
        goto L9
    L11:
        r100.writeBoolean(this.hasExampleNumber);
        if (this.hasExampleNumber == false) goto L17;
        r100.writeUTF(this.exampleNumber_);
        return;
    }
}
