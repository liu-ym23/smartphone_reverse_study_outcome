package com.bytedance.ee.bear.templates.preview.announce;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0006\u0010\"\u001a\u00020\bJ\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", "", "name", "objToken", "objType", "", "thumbnailExtra", "Lcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;", "enable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;Z)V", "getId", "()Ljava/lang/String;", "getName", "getObjToken", "getObjType", "()I", "getThumbnailExtra", "()Lcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;", "getEnable", "()Z", "setEnable", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnounceTemplate implements Parcelable, NonProguard {
    public static final Parcelable.Creator<AnnounceTemplate> CREATOR = null;
    private boolean enable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f239131id;
    private final String name;
    private final String objToken;
    private final int objType;
    private final ThumbnailExtra thumbnailExtra;

    public static final class a implements Parcelable.Creator<AnnounceTemplate> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AnnounceTemplate createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            String r103 = r100.readString();
            int r104 = r100.readInt();
            ThumbnailExtra r105 = ThumbnailExtra.CREATOR.createFromParcel(r100);
            if (r100.readInt() == 0) goto L5;
            boolean r106 = true;
        L7:
            return new AnnounceTemplate(r101, r102, r103, r104, r105, r106);
        L5:
            r106 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AnnounceTemplate[] newArray(int r100) {
            return new AnnounceTemplate[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ AnnounceTemplate copy$default(AnnounceTemplate r100, String r101, String r102, String r103, int r104, ThumbnailExtra r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f239131id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.name;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.objToken;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.objType;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.thumbnailExtra;
    L17:
        ThumbnailExtra r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.enable;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.f239131id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.objToken;
    }

    public final int component4() {
        return this.objType;
    }

    public final ThumbnailExtra component5() {
        return this.thumbnailExtra;
    }

    public final boolean component6() {
        return this.enable;
    }

    public final AnnounceTemplate copy(String r100, String r110, String r111, int r112, ThumbnailExtra r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "objToken");
        Intrinsics.checkNotNullParameter(r113, "thumbnailExtra");
        return new AnnounceTemplate(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnnounceTemplate) == true) goto L8;
        return false;
    L8:
        AnnounceTemplate r101 = (AnnounceTemplate) r100;
        if (Intrinsics.areEqual(this.f239131id, r101.f239131id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objToken, r101.objToken) == true) goto L18;
        return false;
    L18:
        if (this.objType == r101.objType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.thumbnailExtra, r101.thumbnailExtra) == true) goto L24;
        return false;
    L24:
        if (this.enable == r101.enable) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.f239131id.hashCode() * 31) + this.name.hashCode()) * 31) + this.objToken.hashCode()) * 31) + this.objType) * 31) + this.thumbnailExtra.hashCode()) * 31;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "AnnounceTemplate(id=" + this.f239131id + ", name=" + this.name + ", objToken=" + this.objToken + ", objType=" + this.objType + ", thumbnailExtra=" + this.thumbnailExtra + ", enable=" + this.enable + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f239131id);
        r100.writeString(this.name);
        r100.writeString(this.objToken);
        r100.writeInt(this.objType);
        this.thumbnailExtra.writeToParcel(r100, r101);
        r100.writeInt(this.enable ? 1 : 0);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getId() {
        return this.f239131id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final ThumbnailExtra getThumbnailExtra() {
        return this.thumbnailExtra;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public AnnounceTemplate(String r100, String r101, String r102, int r103, ThumbnailExtra r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "objToken");
        Intrinsics.checkNotNullParameter(r104, "thumbnailExtra");
        this.f239131id = r100;
        this.name = r101;
        this.objToken = r102;
        this.objType = r103;
        this.thumbnailExtra = r104;
        this.enable = r105;
    }

    public /* synthetic */ AnnounceTemplate(String r100, String r101, String r110, int r111, ThumbnailExtra r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        boolean r102 = true;
    L6:
        this(r100, r101, r110, r111, r112, r102);
        return;
    L5:
        r102 = r113;
        goto L6
    }
}
