package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.entity.app.ContactEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactTarget;", "Landroid/os/Parcelable;", "telephone", "", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/lang/String;Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getContact", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getTelephone", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactTarget implements Parcelable {
    public static final Parcelable.Creator<ContactTarget> CREATOR = null;
    private final ContactEntity contact;
    private final String telephone;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ContactTarget> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactTarget createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ContactTarget r102 = new ContactTarget(r100.readString(), (ContactEntity) r100.readParcelable(ContactTarget.class.getClassLoader()));
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final ContactTarget[] newArray(int r100) {
            return new ContactTarget[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ContactTarget copy$default(ContactTarget r100, String r101, ContactEntity r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.telephone;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.contact;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.telephone;
    }

    public final ContactEntity component2() {
        return this.contact;
    }

    public final ContactTarget copy(String r100, ContactEntity r101) {
        return new ContactTarget(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactTarget) == true) goto L8;
        return false;
    L8:
        ContactTarget r101 = (ContactTarget) r100;
        if (Intrinsics.areEqual(this.telephone, r101.telephone) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contact, r101.contact) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.telephone;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ContactEntity r104 = this.contact;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactTarget(telephone=" + this.telephone + ", contact=" + this.contact + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.telephone);
        r100.writeParcelable(this.contact, r101);
    }

    public final ContactEntity getContact() {
        return this.contact;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public ContactTarget(String r100, ContactEntity r101) {
        this.telephone = r100;
        this.contact = r101;
    }
}
