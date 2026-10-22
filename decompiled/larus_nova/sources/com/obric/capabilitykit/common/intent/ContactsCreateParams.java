package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0083\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0010J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u008c\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u000207HÖ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u000207HÖ\u0001J\u0012\u0010=\u001a\u00020\u00012\b\u0010>\u001a\u0004\u0018\u00010;H\u0016J\t\u0010?\u001a\u00020\u0004HÖ\u0001J\u0019\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u000207HÖ\u0001R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "name", "", "telephones", "", "Lcom/obric/capabilitykit/common/intent/Telephone;", "company", "note", "email", "identifyCard", "gender", "birthday", "relationship", "address", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getBirthday", "setBirthday", "getCompany", "setCompany", "getEmail", "setEmail", "getGender", "setGender", "getIdentifyCard", "setIdentifyCard", "getName", "setName", "getNote", "setNote", "getRelationship", "setRelationship", "getTelephones", "()[Lcom/obric/capabilitykit/common/intent/Telephone;", "setTelephones", "([Lcom/obric/capabilitykit/common/intent/Telephone;)V", "[Lcom/obric/capabilitykit/common/intent/Telephone;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactsCreateParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ContactsCreateParams> CREATOR = null;
    private String address;
    private String birthday;
    private String company;
    private String email;
    private String gender;
    private String identifyCard;
    private String name;
    private String note;
    private String relationship;
    private Telephone[] telephones;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ContactsCreateParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsCreateParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Telephone[] r102 = null;
        L9:
            ContactsCreateParams r103 = new ContactsCreateParams(r101, r102, r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
            int r104 = Math.min(r100, 0);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L10:
            if (r106 > r104) goto L12;
            r106 = r106 + 1;
        L12:
            if (r106 > r100) goto L14;
            joa.a.d(r110, r105);
            r106 = r106 + 1;
            goto L12
        L14:
            return r103;
        L5:
            int r107 = r110.readInt();
            Telephone[] r108 = new Telephone[r107];
            int r109 = 0;
        L6:
            if (r109 == r107) goto L8;
            r108[r109] = Telephone.CREATOR.createFromParcel(r110);
            r109 = r109 + 1;
            goto L6
        L8:
            r102 = r108;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsCreateParams[] newArray(int r100) {
            return new ContactsCreateParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ContactsCreateParams() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ ContactsCreateParams copy$default(ContactsCreateParams r110, String r111, Telephone[] r112, String r113, String r114, String r115, String r116, String r117, String r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Telephone[] r101 = r110.telephones;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.company;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.note;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.email;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.identifyCard;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.gender;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.birthday;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.relationship;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.address;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.address;
    }

    public final Telephone[] component2() {
        return this.telephones;
    }

    public final String component3() {
        return this.company;
    }

    public final String component4() {
        return this.note;
    }

    public final String component5() {
        return this.email;
    }

    public final String component6() {
        return this.identifyCard;
    }

    public final String component7() {
        return this.gender;
    }

    public final String component8() {
        return this.birthday;
    }

    public final String component9() {
        return this.relationship;
    }

    public final ContactsCreateParams copy(String r110, Telephone[] r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212) {
        return new ContactsCreateParams(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactsCreateParams) == true) goto L8;
        return false;
    L8:
        ContactsCreateParams r101 = (ContactsCreateParams) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.telephones, r101.telephones) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.company, r101.company) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.note, r101.note) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.email, r101.email) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.identifyCard, r101.identifyCard) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.gender, r101.gender) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.birthday, r101.birthday) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.relationship, r101.relationship) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.address, r101.address) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Telephone[] r104 = this.telephones;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.company;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.note;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.email;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.identifyCard;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.gender;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.birthday;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.relationship;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.address;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = Arrays.hashCode(r104);
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "ContactsCreateParams(name=" + this.name + ", telephones=" + Arrays.toString(this.telephones) + ", company=" + this.company + ", note=" + this.note + ", email=" + this.email + ", identifyCard=" + this.identifyCard + ", gender=" + this.gender + ", birthday=" + this.birthday + ", relationship=" + this.relationship + ", address=" + this.address + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.name);
        Telephone[] r103 = this.telephones;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L8:
        r100.writeString(this.company);
        r100.writeString(this.note);
        r100.writeString(this.email);
        r100.writeString(this.identifyCard);
        r100.writeString(this.gender);
        r100.writeString(this.birthday);
        r100.writeString(this.relationship);
        r100.writeString(this.address);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r103.length;
        r100.writeInt(r104);
    L6:
        if (r102 == r104) goto L8;
        r103[r102].writeToParcel(r100, r101);
        r102 = r102 + 1;
        goto L6
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCompany() {
        return this.company;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getIdentifyCard() {
        return this.identifyCard;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getRelationship() {
        return this.relationship;
    }

    public final Telephone[] getTelephones() {
        return this.telephones;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof ContactsCreateParams) == true) goto L5;
        return this;
    L5:
        String r100 = this.name;
        if (r100 != null) goto L8;
        r100 = ((ContactsCreateParams) r110).name;
    L8:
        String r101 = r100;
        Telephone[] r102 = this.telephones;
        if (r102 != null) goto L11;
        r102 = ((ContactsCreateParams) r110).telephones;
    L11:
        Telephone[] r103 = r102;
        String r104 = this.company;
        if (r104 != null) goto L14;
        r104 = ((ContactsCreateParams) r110).company;
    L14:
        String r105 = r104;
        String r106 = this.note;
        if (r106 != null) goto L17;
        r106 = ((ContactsCreateParams) r110).note;
    L17:
        String r107 = r106;
        String r108 = this.email;
        if (r108 != null) goto L20;
        r108 = ((ContactsCreateParams) r110).email;
    L20:
        String r109 = r108;
        String r111 = this.identifyCard;
        if (r111 != null) goto L23;
        r111 = ((ContactsCreateParams) r110).identifyCard;
    L23:
        String r112 = r111;
        String r113 = this.gender;
        if (r113 != null) goto L26;
        r113 = ((ContactsCreateParams) r110).gender;
    L26:
        String r114 = r113;
        String r115 = this.birthday;
        if (r115 != null) goto L29;
        r115 = ((ContactsCreateParams) r110).birthday;
    L29:
        String r116 = r115;
        String r117 = this.relationship;
        if (r117 != null) goto L32;
        r117 = ((ContactsCreateParams) r110).relationship;
    L32:
        String r118 = r117;
        String r119 = this.address;
        if (r119 != null) goto L35;
        String r120 = ((ContactsCreateParams) r110).address;
    L37:
        return new ContactsCreateParams(r101, r103, r105, r107, r109, r112, r114, r116, r118, r120);
    L35:
        r120 = r119;
        goto L37
    }

    public final void setAddress(String r100) {
        this.address = r100;
    }

    public final void setBirthday(String r100) {
        this.birthday = r100;
    }

    public final void setCompany(String r100) {
        this.company = r100;
    }

    public final void setEmail(String r100) {
        this.email = r100;
    }

    public final void setGender(String r100) {
        this.gender = r100;
    }

    public final void setIdentifyCard(String r100) {
        this.identifyCard = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setNote(String r100) {
        this.note = r100;
    }

    public final void setRelationship(String r100) {
        this.relationship = r100;
    }

    public final void setTelephones(Telephone[] r100) {
        this.telephones = r100;
    }

    public ContactsCreateParams(String r100, Telephone[] r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110) {
        this.name = r100;
        this.telephones = r101;
        this.company = r102;
        this.note = r103;
        this.email = r104;
        this.identifyCard = r105;
        this.gender = r106;
        this.birthday = r107;
        this.relationship = r108;
        this.address = r110;
    }

    public /* synthetic */ ContactsCreateParams(String r110, Telephone[] r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Telephone[] r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
