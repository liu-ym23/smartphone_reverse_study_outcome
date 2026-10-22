package com.bytedance.ee.bear.templates.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0004J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "type", "", DocCallbackImpl.KEY_THUMBNAIL, "", "decryptKey", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getThumbnail", "()Ljava/lang/String;", "getDecryptKey", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailExtra implements Parcelable, NonProguard {
    public static final Parcelable.Creator<ThumbnailExtra> CREATOR = null;
    private final String decryptKey;
    private final String thumbnail;
    private final int type;

    public static final class a implements Parcelable.Creator<ThumbnailExtra> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ThumbnailExtra createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ThumbnailExtra(r100.readInt(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ThumbnailExtra[] newArray(int r100) {
            return new ThumbnailExtra[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ThumbnailExtra() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ ThumbnailExtra copy$default(ThumbnailExtra r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.thumbnail;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.decryptKey;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.thumbnail;
    }

    public final String component3() {
        return this.decryptKey;
    }

    public final ThumbnailExtra copy(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, DocCallbackImpl.KEY_THUMBNAIL);
        Intrinsics.checkNotNullParameter(r102, "decryptKey");
        return new ThumbnailExtra(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThumbnailExtra) == true) goto L8;
        return false;
    L8:
        ThumbnailExtra r101 = (ThumbnailExtra) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.thumbnail, r101.thumbnail) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.decryptKey, r101.decryptKey) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.type * 31) + this.thumbnail.hashCode()) * 31) + this.decryptKey.hashCode();
    }

    public String toString() {
        return "ThumbnailExtra(type=" + this.type + ", thumbnail=" + this.thumbnail + ", decryptKey=" + this.decryptKey + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.type);
        r100.writeString(this.thumbnail);
        r100.writeString(this.decryptKey);
    }

    public final String getDecryptKey() {
        return this.decryptKey;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final int getType() {
        return this.type;
    }

    public ThumbnailExtra(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, DocCallbackImpl.KEY_THUMBNAIL);
        Intrinsics.checkNotNullParameter(r102, "decryptKey");
        this.type = r100;
        this.thumbnail = r101;
        this.decryptKey = r102;
    }

    public /* synthetic */ ThumbnailExtra(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 2;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
