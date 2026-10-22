package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u008f\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0098\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010=J\t\u0010>\u001a\u00020?HÖ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\u0010\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0EH\u0016J\t\u0010F\u001a\u00020?HÖ\u0001J\b\u0010G\u001a\u00020AH\u0016J\u0012\u0010H\u001a\u00020\u00012\b\u0010I\u001a\u0004\u0018\u00010CH\u0016J\t\u0010J\u001a\u00020\u0007HÖ\u0001J\u0019\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020?HÖ\u0001R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006P"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", PickerReporterConstants.KEY.TARGET, "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "name", "", "telephones", "", "Lcom/obric/capabilitykit/common/intent/Telephone;", "company", "note", "email", "identifyCard", "gender", "birthday", "relationship", "address", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getBirthday", "setBirthday", "getCompany", "setCompany", "getEmail", "setEmail", "getGender", "setGender", "getIdentifyCard", "setIdentifyCard", "getName", "setName", "getNote", "setNote", "getRelationship", "setRelationship", "getTarget", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getTelephones", "()[Lcom/obric/capabilitykit/common/intent/Telephone;", "setTelephones", "([Lcom/obric/capabilitykit/common/intent/Telephone;)V", "[Lcom/obric/capabilitykit/common/intent/Telephone;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactsUpdateParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<ContactsUpdateParams> CREATOR = null;
    private String address;
    private String birthday;
    private String company;
    private String email;
    private String gender;
    private String identifyCard;
    private String name;
    private String note;
    private String relationship;
    private ContactEntity target;
    private Telephone[] telephones;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ContactsUpdateParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsUpdateParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            ContactEntity r101 = (ContactEntity) r110.readParcelable(ContactsUpdateParams.class.getClassLoader());
            String r102 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Telephone[] r103 = null;
        L9:
            ContactsUpdateParams r104 = new ContactsUpdateParams(r101, r102, r103, r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
            int r105 = Math.min(r100, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L10:
            if (r107 > r105) goto L12;
            r107 = r107 + 1;
        L12:
            if (r107 > r100) goto L14;
            joa.a.d(r110, r106);
            r107 = r107 + 1;
            goto L12
        L14:
            return r104;
        L5:
            int r108 = r110.readInt();
            Telephone[] r109 = new Telephone[r108];
            int r111 = 0;
        L6:
            if (r111 == r108) goto L8;
            r109[r111] = Telephone.CREATOR.createFromParcel(r110);
            r111 = r111 + 1;
            goto L6
        L8:
            r103 = r109;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsUpdateParams[] newArray(int r100) {
            return new ContactsUpdateParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ContactsUpdateParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ ContactsUpdateParams copy$default(ContactsUpdateParams r110, ContactEntity r111, String r112, Telephone[] r113, String r114, String r115, String r116, String r117, String r210, String r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        ContactEntity r100 = r110.target;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Telephone[] r102 = r110.telephones;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.company;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.note;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.email;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.identifyCard;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.gender;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.birthday;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.relationship;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.address;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final ContactEntity component1() {
        return this.target;
    }

    public final String component10() {
        return this.relationship;
    }

    public final String component11() {
        return this.address;
    }

    public final String component2() {
        return this.name;
    }

    public final Telephone[] component3() {
        return this.telephones;
    }

    public final String component4() {
        return this.company;
    }

    public final String component5() {
        return this.note;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.identifyCard;
    }

    public final String component8() {
        return this.gender;
    }

    public final String component9() {
        return this.birthday;
    }

    public final ContactsUpdateParams copy(ContactEntity r110, String r111, Telephone[] r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214) {
        return new ContactsUpdateParams(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactsUpdateParams) == true) goto L8;
        return false;
    L8:
        ContactsUpdateParams r101 = (ContactsUpdateParams) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.telephones, r101.telephones) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.company, r101.company) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.note, r101.note) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.email, r101.email) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.identifyCard, r101.identifyCard) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.gender, r101.gender) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.birthday, r101.birthday) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.relationship, r101.relationship) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.address, r101.address) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        ContactEntity r100 = this.target;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Telephone[] r107 = this.telephones;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.company;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.note;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.email;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.identifyCard;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.gender;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.birthday;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.relationship;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.address;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
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
        r108 = Arrays.hashCode(r107);
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactsUpdateParams(target=" + this.target + ", name=" + this.name + ", telephones=" + Arrays.toString(this.telephones) + ", company=" + this.company + ", note=" + this.note + ", email=" + this.email + ", identifyCard=" + this.identifyCard + ", gender=" + this.gender + ", birthday=" + this.birthday + ", relationship=" + this.relationship + ", address=" + this.address + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.target, r101);
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

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.target);
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
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

    public final ContactEntity getTarget() {
        return this.target;
    }

    public final Telephone[] getTelephones() {
        return this.telephones;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof ContactsUpdateParams) == true) goto L5;
        return this;
    L5:
        ContactEntity r100 = this.target;
        if (r100 != null) goto L8;
        r100 = ((ContactsUpdateParams) r110).target;
    L8:
        ContactEntity r101 = r100;
        String r102 = this.name;
        if (r102 != null) goto L11;
        r102 = ((ContactsUpdateParams) r110).name;
    L11:
        String r103 = r102;
        Telephone[] r104 = this.telephones;
        if (r104 != null) goto L14;
        r104 = ((ContactsUpdateParams) r110).telephones;
    L14:
        Telephone[] r105 = r104;
        String r106 = this.company;
        if (r106 != null) goto L17;
        r106 = ((ContactsUpdateParams) r110).company;
    L17:
        String r107 = r106;
        String r108 = this.note;
        if (r108 != null) goto L20;
        r108 = ((ContactsUpdateParams) r110).note;
    L20:
        String r109 = r108;
        String r111 = this.email;
        if (r111 != null) goto L23;
        r111 = ((ContactsUpdateParams) r110).email;
    L23:
        String r112 = r111;
        String r113 = this.identifyCard;
        if (r113 != null) goto L26;
        r113 = ((ContactsUpdateParams) r110).identifyCard;
    L26:
        String r114 = r113;
        String r115 = this.gender;
        if (r115 != null) goto L29;
        r115 = ((ContactsUpdateParams) r110).gender;
    L29:
        String r116 = r115;
        String r117 = this.birthday;
        if (r117 != null) goto L32;
        r117 = ((ContactsUpdateParams) r110).birthday;
    L32:
        String r118 = r117;
        String r119 = this.relationship;
        if (r119 != null) goto L35;
        r119 = ((ContactsUpdateParams) r110).relationship;
    L35:
        String r120 = r119;
        String r121 = this.address;
        if (r121 != null) goto L38;
        String r122 = ((ContactsUpdateParams) r110).address;
    L40:
        return new ContactsUpdateParams(r101, r103, r105, r107, r109, r112, r114, r116, r118, r120, r122);
    L38:
        r122 = r121;
        goto L40
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

    public final void setTarget(ContactEntity r100) {
        this.target = r100;
    }

    public final void setTelephones(Telephone[] r100) {
        this.telephones = r100;
    }

    public ContactsUpdateParams(ContactEntity r100, String r101, Telephone[] r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111) {
        this.target = r100;
        this.name = r101;
        this.telephones = r102;
        this.company = r103;
        this.note = r104;
        this.email = r105;
        this.identifyCard = r106;
        this.gender = r107;
        this.birthday = r108;
        this.relationship = r110;
        this.address = r111;
    }

    public /* synthetic */ ContactsUpdateParams(ContactEntity r110, String r111, Telephone[] r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        ContactEntity r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Telephone[] r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
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
