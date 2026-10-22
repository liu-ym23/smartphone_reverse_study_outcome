package com.google.i18n.phonenumbers;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class Phonemetadata$PhoneMetadataCollection implements Externalizable {
    private static final long serialVersionUID = 1;
    private List<Phonemetadata$PhoneMetadata> metadata_;

    public static final class Builder extends Phonemetadata$PhoneMetadataCollection {
        public Phonemetadata$PhoneMetadataCollection build() {
            return this;
        }

        public Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Phonemetadata$PhoneMetadataCollection clear() {
        this.metadata_.clear();
        return this;
    }

    public int getMetadataCount() {
        return this.metadata_.size();
    }

    public Phonemetadata$PhoneMetadataCollection() {
        this.metadata_ = new ArrayList();
    }

    public List<Phonemetadata$PhoneMetadata> getMetadataList() {
        return this.metadata_;
    }

    public Phonemetadata$PhoneMetadataCollection addMetadata(Phonemetadata$PhoneMetadata r100) {
        if (r100 == null) goto L6;
        this.metadata_.add(r100);
        return this;
    L6:
        throw null;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r100) throws IOException {
        int r101 = r100.readInt();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Phonemetadata$PhoneMetadata r103 = new Phonemetadata$PhoneMetadata();
        r103.readExternal(r100);
        this.metadata_.add(r103);
        r102 = r102 + 1;
        goto L3
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r100) throws IOException {
        int r101 = getMetadataCount();
        r100.writeInt(r101);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Phonemetadata$PhoneMetadata) ListProtector.get(this.metadata_, r102)).writeExternal(r100);
        r102 = r102 + 1;
        goto L3
    }
}
