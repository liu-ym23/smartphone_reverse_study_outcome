package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\u0010\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0016J\t\u0010\"\u001a\u00020\u001aHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MessageContent;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntityCollection;", "text", "", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "note", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/lang/String;Lcom/obric/capabilitykit/entity/app/PhotoEntity;Lcom/obric/capabilitykit/entity/app/NoteEntity;Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getContact", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getNote", "()Lcom/obric/capabilitykit/entity/app/NoteEntity;", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharersEntities", "", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MessageContent implements Parcelable, IUriSharerEntityCollection {
    public static final Parcelable.Creator<MessageContent> CREATOR = null;
    private final ContactEntity contact;
    private final NoteEntity note;
    private final PhotoEntity photo;
    private final String text;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<MessageContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MessageContent createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            MessageContent r102 = new MessageContent(r100.readString(), (PhotoEntity) r100.readParcelable(MessageContent.class.getClassLoader()), (NoteEntity) r100.readParcelable(MessageContent.class.getClassLoader()), (ContactEntity) r100.readParcelable(MessageContent.class.getClassLoader()));
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
        public final MessageContent[] newArray(int r100) {
            return new MessageContent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ MessageContent copy$default(MessageContent r100, String r101, PhotoEntity r102, NoteEntity r103, ContactEntity r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.photo;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.note;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.contact;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.text;
    }

    public final PhotoEntity component2() {
        return this.photo;
    }

    public final NoteEntity component3() {
        return this.note;
    }

    public final ContactEntity component4() {
        return this.contact;
    }

    public final MessageContent copy(String r100, PhotoEntity r101, NoteEntity r102, ContactEntity r103) {
        return new MessageContent(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageContent) == true) goto L8;
        return false;
    L8:
        MessageContent r101 = (MessageContent) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.photo, r101.photo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.note, r101.note) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contact, r101.contact) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection
    public List<IUriSharerEntity> getUriSharersEntities() {
        return CollectionsKt.listOf(new IUriSharerEntity[]{this.photo, this.note, this.contact});
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PhotoEntity r104 = this.photo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        NoteEntity r107 = this.note;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ContactEntity r110 = this.contact;
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
        return "MessageContent(text=" + this.text + ", photo=" + this.photo + ", note=" + this.note + ", contact=" + this.contact + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.text);
        r100.writeParcelable(this.photo, r101);
        r100.writeParcelable(this.note, r101);
        r100.writeParcelable(this.contact, r101);
    }

    public final ContactEntity getContact() {
        return this.contact;
    }

    public final NoteEntity getNote() {
        return this.note;
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final String getText() {
        return this.text;
    }

    public MessageContent(String r100, PhotoEntity r101, NoteEntity r102, ContactEntity r103) {
        this.text = r100;
        this.photo = r101;
        this.note = r102;
        this.contact = r103;
    }
}
