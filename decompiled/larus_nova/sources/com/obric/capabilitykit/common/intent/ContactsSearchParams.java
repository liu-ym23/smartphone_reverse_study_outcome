package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\fHÖ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\fHÖ\u0001J\u0012\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u000101H\u0016J\t\u00105\u001a\u00020\u0004HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006;"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "contactName", "telephone", "telephoneType", "company", "email", "content", "maxCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCompany", "()Ljava/lang/String;", "setCompany", "(Ljava/lang/String;)V", "getContactName", "setContactName", "getContent", "setContent", "getEmail", "setEmail", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getTelephone", "setTelephone", "getTelephoneType", "setTelephoneType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ContactsSearchParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactsSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ContactsSearchParams> CREATOR = null;
    private String company;
    private String contactName;
    private String content;
    private String email;
    private Integer maxCount;
    private String query;
    private String telephone;
    private String telephoneType;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ContactsSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsSearchParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            String r107 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Integer r108 = null;
        L6:
            ContactsSearchParams r109 = new ContactsSearchParams(r101, r102, r103, r104, r105, r106, r107, r108);
            int r111 = Math.min(r100, 0);
            ClassLoader r112 = a.class.getClassLoader();
            int r113 = 1;
        L7:
            if (r113 > r111) goto L9;
            r113 = r113 + 1;
        L9:
            if (r113 > r100) goto L11;
            joa.a.d(r110, r112);
            r113 = r113 + 1;
            goto L9
        L11:
            return r109;
        L5:
            r108 = Integer.valueOf(r110.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsSearchParams[] newArray(int r100) {
            return new ContactsSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ContactsSearchParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ContactsSearchParams copy$default(ContactsSearchParams r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116, Integer r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.query;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.contactName;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.telephone;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.telephoneType;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.company;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.email;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.content;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r108 = r100.maxCount;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.contactName;
    }

    public final String component3() {
        return this.telephone;
    }

    public final String component4() {
        return this.telephoneType;
    }

    public final String component5() {
        return this.company;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.content;
    }

    public final Integer component8() {
        return this.maxCount;
    }

    public final ContactsSearchParams copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Integer r117) {
        return new ContactsSearchParams(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactsSearchParams) == true) goto L8;
        return false;
    L8:
        ContactsSearchParams r101 = (ContactsSearchParams) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contactName, r101.contactName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.telephone, r101.telephone) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.telephoneType, r101.telephoneType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.company, r101.company) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.email, r101.email) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.maxCount, r101.maxCount) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.query;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.contactName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.telephone;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.telephoneType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.company;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.email;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.content;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.maxCount;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "ContactsSearchParams(query=" + this.query + ", contactName=" + this.contactName + ", telephone=" + this.telephone + ", telephoneType=" + this.telephoneType + ", company=" + this.company + ", email=" + this.email + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.query);
        r100.writeString(this.contactName);
        r100.writeString(this.telephone);
        r100.writeString(this.telephoneType);
        r100.writeString(this.company);
        r100.writeString(this.email);
        r100.writeString(this.content);
        Integer r103 = this.maxCount;
        if (r103 == null) goto L6;
        r100.writeInt(1);
        r102 = r103.intValue();
    L6:
        r100.writeInt(r102);
    }

    public final String getCompany() {
        return this.company;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public final String getTelephoneType() {
        return this.telephoneType;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof ContactsSearchParams) == true) goto L5;
        return this;
    L5:
        String r100 = this.query;
        if (r100 != null) goto L8;
        r100 = ((ContactsSearchParams) r110).query;
    L8:
        String r101 = r100;
        String r102 = this.contactName;
        if (r102 != null) goto L11;
        r102 = ((ContactsSearchParams) r110).contactName;
    L11:
        String r103 = r102;
        String r104 = this.telephone;
        if (r104 != null) goto L14;
        r104 = ((ContactsSearchParams) r110).telephone;
    L14:
        String r105 = r104;
        String r106 = this.telephoneType;
        if (r106 != null) goto L17;
        r106 = ((ContactsSearchParams) r110).telephoneType;
    L17:
        String r107 = r106;
        String r108 = this.company;
        if (r108 != null) goto L20;
        r108 = ((ContactsSearchParams) r110).company;
    L20:
        String r109 = r108;
        String r111 = this.email;
        if (r111 != null) goto L23;
        r111 = ((ContactsSearchParams) r110).email;
    L23:
        String r112 = r111;
        String r113 = this.content;
        if (r113 != null) goto L26;
        r113 = ((ContactsSearchParams) r110).content;
    L26:
        String r114 = r113;
        Integer r115 = this.maxCount;
        if (r115 != null) goto L29;
        Integer r116 = ((ContactsSearchParams) r110).maxCount;
    L31:
        return new ContactsSearchParams(r101, r103, r105, r107, r109, r112, r114, r116);
    L29:
        r116 = r115;
        goto L31
    }

    public final void setCompany(String r100) {
        this.company = r100;
    }

    public final void setContactName(String r100) {
        this.contactName = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setEmail(String r100) {
        this.email = r100;
    }

    public final void setMaxCount(Integer r100) {
        this.maxCount = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public final void setTelephone(String r100) {
        this.telephone = r100;
    }

    public final void setTelephoneType(String r100) {
        this.telephoneType = r100;
    }

    public ContactsSearchParams(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107) {
        this.query = r100;
        this.contactName = r101;
        this.telephone = r102;
        this.telephoneType = r103;
        this.company = r104;
        this.email = r105;
        this.content = r106;
        this.maxCount = r107;
    }

    public /* synthetic */ ContactsSearchParams(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Integer r117, int r118, DefaultConstructorMarker r119) {
        Integer r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
