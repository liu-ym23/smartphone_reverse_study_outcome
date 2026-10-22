package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eH\u0016J\t\u0010 \u001a\u00020\u0018HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntityCollection;", "text", "", "photos", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "doc", "Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;)V", "getDoc", "()Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "getPhotos", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;)Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "describeContents", "", "equals", "", "other", "", "getUriSharersEntities", "", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeMessageContent implements Parcelable, IUriSharerEntityCollection {
    public static final Parcelable.Creator<OfficeMessageContent> CREATOR = null;

    /* JADX INFO: renamed from: doc, reason: collision with root package name */
    private final CloudDocumentEntity f396193doc;
    private final PhotoEntity[] photos;
    private final String text;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<OfficeMessageContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeMessageContent createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            PhotoEntity[] r103 = null;
        L9:
            OfficeMessageContent r104 = new OfficeMessageContent(r102, r103, (CloudDocumentEntity) r100.readParcelable(OfficeMessageContent.class.getClassLoader()));
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
            PhotoEntity[] r109 = new PhotoEntity[r108];
            int r110 = 0;
        L6:
            if (r110 == r108) goto L8;
            r109[r110] = (PhotoEntity) r100.readParcelable(OfficeMessageContent.class.getClassLoader());
            r110 = r110 + 1;
            goto L6
        L8:
            r103 = r109;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeMessageContent[] newArray(int r100) {
            return new OfficeMessageContent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ OfficeMessageContent copy$default(OfficeMessageContent r100, String r101, PhotoEntity[] r102, CloudDocumentEntity r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.photos;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.f396193doc;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.text;
    }

    public final PhotoEntity[] component2() {
        return this.photos;
    }

    public final CloudDocumentEntity component3() {
        return this.f396193doc;
    }

    public final OfficeMessageContent copy(String r100, PhotoEntity[] r101, CloudDocumentEntity r102) {
        return new OfficeMessageContent(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeMessageContent) == true) goto L8;
        return false;
    L8:
        OfficeMessageContent r101 = (OfficeMessageContent) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.photos, r101.photos) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f396193doc, r101.f396193doc) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PhotoEntity[] r104 = this.photos;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CloudDocumentEntity r107 = this.f396193doc;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = Arrays.hashCode(r104);
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeMessageContent(text=" + this.text + ", photos=" + Arrays.toString(this.photos) + ", doc=" + this.f396193doc + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.text);
        PhotoEntity[] r103 = this.photos;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L8:
        r100.writeParcelable(this.f396193doc, r101);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r103.length;
        r100.writeInt(r104);
    L6:
        if (r102 == r104) goto L8;
        r100.writeParcelable(r103[r102], r101);
        r102 = r102 + 1;
        goto L6
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection
    public List<IUriSharerEntity> getUriSharersEntities() {
        PhotoEntity[] r100 = this.photos;
        if (r100 == null) goto L7;
        List<IUriSharerEntity> r101 = ArraysKt.toList(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    public final CloudDocumentEntity getDoc() {
        return this.f396193doc;
    }

    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    public final String getText() {
        return this.text;
    }

    public OfficeMessageContent(String r100, PhotoEntity[] r101, CloudDocumentEntity r102) {
        this.text = r100;
        this.photos = r101;
        this.f396193doc = r102;
    }
}
