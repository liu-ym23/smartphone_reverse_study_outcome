package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.entity.app.ContactEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactListTarget;", "Landroid/os/Parcelable;", "telephone", "", "", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "([Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getContact", "()[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getTelephone", "()[Ljava/lang/String;", "[Ljava/lang/String;", "component1", "component2", "copy", "([Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/ContactEntity;)Lcom/obric/capabilitykit/common/intent/ContactListTarget;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactListTarget implements Parcelable {
    public static final Parcelable.Creator<ContactListTarget> CREATOR = null;
    private final ContactEntity[] contact;
    private final String[] telephone;

    public static final class a implements Parcelable.Creator<ContactListTarget> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactListTarget createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String[] r102 = r100.createStringArray();
            if (r100.readInt() != 0) goto L5;
            ContactEntity[] r103 = null;
        L9:
            ContactListTarget r104 = new ContactListTarget(r102, r103);
            int r105 = Math.min(r101, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L10:
            if (r107 > r105) goto L12;
            r107 = r107 + 1;
        L12:
            if (r107 > r101) goto L14;
            joa.a.d(r100, r106);
            r107 = r107 + 1;
            goto L12
        L14:
            return r104;
        L5:
            int r108 = r100.readInt();
            ContactEntity[] r109 = new ContactEntity[r108];
            int r110 = 0;
        L6:
            if (r110 == r108) goto L8;
            r109[r110] = (ContactEntity) r100.readParcelable(ContactListTarget.class.getClassLoader());
            r110 = r110 + 1;
            goto L6
        L8:
            r103 = r109;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ContactListTarget[] newArray(int r100) {
            return new ContactListTarget[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ContactListTarget copy$default(ContactListTarget r100, String[] r101, ContactEntity[] r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.telephone;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.contact;
    L9:
        return r100.copy(r101, r102);
    }

    public final String[] component1() {
        return this.telephone;
    }

    public final ContactEntity[] component2() {
        return this.contact;
    }

    public final ContactListTarget copy(String[] r100, ContactEntity[] r101) {
        return new ContactListTarget(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactListTarget) == true) goto L8;
        return false;
    L8:
        ContactListTarget r101 = (ContactListTarget) r100;
        if (Intrinsics.areEqual(this.telephone, r101.telephone) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contact, r101.contact) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String[] r100 = this.telephone;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ContactEntity[] r104 = this.contact;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public String toString() {
        return "ContactListTarget(telephone=" + Arrays.toString(this.telephone) + ", contact=" + Arrays.toString(this.contact) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeStringArray(this.telephone);
        ContactEntity[] r103 = this.contact;
        if (r103 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r103.length;
        r100.writeInt(r104);
    L6:
        if (r102 == r104) goto L10;
        r100.writeParcelable(r103[r102], r101);
        r102 = r102 + 1;
        goto L6
    }

    public final ContactEntity[] getContact() {
        return this.contact;
    }

    public final String[] getTelephone() {
        return this.telephone;
    }

    public ContactListTarget(String[] r100, ContactEntity[] r101) {
        this.telephone = r100;
        this.contact = r101;
    }
}
