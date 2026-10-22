package com.bytedance.ee.bear.templates.preview.announce;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0006\u0010\"\u001a\u00020\bJ\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", ResourceData.KEY_ID, "", "name", "objToken", "objType", "", "thumbnailExtra", "Lcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;", "enable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;Z)V", "getId", "()Ljava/lang/String;", "getName", "getObjToken", "getObjType", "()I", "getThumbnailExtra", "()Lcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;", "getEnable", "()Z", "setEnable", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnounceTemplate implements Parcelable, NonProguard {
    public static final Parcelable.Creator<AnnounceTemplate> CREATOR = null;
    private boolean enable;
    private final String id;
    private final String name;
    private final String objToken;
    private final int objType;
    private final ThumbnailExtra thumbnailExtra;

    public static final class a implements Parcelable.Creator<AnnounceTemplate> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AnnounceTemplate createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            String r2 = r9.readString();
            String r3 = r9.readString();
            String r4 = r9.readString();
            int r5 = r9.readInt();
            ThumbnailExtra r6 = ThumbnailExtra.CREATOR.createFromParcel(r9);
            if (r9.readInt() == 0) goto L5;
            boolean r7 = true;
        L7:
            return new AnnounceTemplate(r2, r3, r4, r5, r6, r7);
        L5:
            r7 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AnnounceTemplate[] newArray(int r1) {
            return new AnnounceTemplate[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ AnnounceTemplate copy$default(AnnounceTemplate r4, String r5, String r6, String r7, int r8, ThumbnailExtra r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.name;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.objToken;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.objType;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.thumbnailExtra;
    L17:
        ThumbnailExtra r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.enable;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.id;
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

    public final AnnounceTemplate copy(String r9, String r10, String r11, int r12, ThumbnailExtra r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "objToken");
        Intrinsics.checkNotNullParameter(r13, "thumbnailExtra");
        return new AnnounceTemplate(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AnnounceTemplate) == true) goto L8;
        return false;
    L8:
        AnnounceTemplate r6 = (AnnounceTemplate) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objToken, r6.objToken) == true) goto L18;
        return false;
    L18:
        if (this.objType == r6.objType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.thumbnailExtra, r6.thumbnailExtra) == true) goto L24;
        return false;
    L24:
        if (this.enable == r6.enable) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.objToken.hashCode()) * 31) + this.objType) * 31) + this.thumbnailExtra.hashCode()) * 31;
        if (this.enable == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "AnnounceTemplate(id=" + this.id + ", name=" + this.name + ", objToken=" + this.objToken + ", objType=" + this.objType + ", thumbnailExtra=" + this.thumbnailExtra + ", enable=" + this.enable + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.id);
        r2.writeString(this.name);
        r2.writeString(this.objToken);
        r2.writeInt(this.objType);
        this.thumbnailExtra.writeToParcel(r2, r3);
        r2.writeInt(this.enable ? 1 : 0);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getId() {
        return this.id;
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

    public final void setEnable(boolean r1) {
        this.enable = r1;
    }

    public AnnounceTemplate(String r2, String r3, String r4, int r5, ThumbnailExtra r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "objToken");
        Intrinsics.checkNotNullParameter(r6, "thumbnailExtra");
        this.id = r2;
        this.name = r3;
        this.objToken = r4;
        this.objType = r5;
        this.thumbnailExtra = r6;
        this.enable = r7;
    }

    public /* synthetic */ AnnounceTemplate(String r8, String r9, String r10, int r11, ThumbnailExtra r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        boolean r6 = true;
    L6:
        this(r8, r9, r10, r11, r12, r6);
        return;
    L5:
        r6 = r13;
        goto L6
    }
}
