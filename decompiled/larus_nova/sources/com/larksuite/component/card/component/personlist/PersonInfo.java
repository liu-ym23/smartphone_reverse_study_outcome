package com.larksuite.component.card.component.personlist;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0010¨\u0006("}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonInfo;", "Landroid/os/Parcelable;", "id", "", "type", "avatarKey", "tag", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "getAvatarKey", "setAvatarKey", "(Ljava/lang/String;)V", "getTag", "()Ljava/util/List;", "getContent", "setContent", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonInfo implements Parcelable {
    public static final Parcelable.Creator<PersonInfo> CREATOR = null;
    private String avatarKey;
    private String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f283417id;
    private final List<String> tag;
    private final String type;

    public static final class a implements Parcelable.Creator<PersonInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersonInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new PersonInfo(r100.readString(), r100.readString(), r100.readString(), r100.createStringArrayList(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PersonInfo[] newArray(int r100) {
            return new PersonInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonInfo copy$default(PersonInfo r100, String r101, String r102, String r103, List r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f283417id;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.avatarKey;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.tag;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.content;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.f283417id;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final List<String> component4() {
        return this.tag;
    }

    public final String component5() {
        return this.content;
    }

    public final PersonInfo copy(String r100, String r101, String r110, List<String> r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "type");
        return new PersonInfo(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PersonInfo) == true) goto L8;
        return false;
    L8:
        PersonInfo r101 = (PersonInfo) r100;
        if (Intrinsics.areEqual(this.f283417id, r101.f283417id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.f283417id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.type.hashCode()) * 31;
        String r104 = this.avatarKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.tag;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.content;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "PersonInfo(id=" + this.f283417id + ", type=" + this.type + ", avatarKey=" + this.avatarKey + ", tag=" + this.tag + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f283417id);
        r100.writeString(this.type);
        r100.writeString(this.avatarKey);
        r100.writeStringList(this.tag);
        r100.writeString(this.content);
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.f283417id;
    }

    public final List<String> getTag() {
        return this.tag;
    }

    public final String getType() {
        return this.type;
    }

    public final void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public PersonInfo(String r100, String r101, String r102, List<String> r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f283417id = r100;
        this.type = r101;
        this.avatarKey = r102;
        this.tag = r103;
        this.content = r104;
    }

    public /* synthetic */ PersonInfo(String r100, String r101, String r110, List r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        List r103 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        String r104 = null;
    L14:
        this(r100, r101, r102, r103, r104);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
