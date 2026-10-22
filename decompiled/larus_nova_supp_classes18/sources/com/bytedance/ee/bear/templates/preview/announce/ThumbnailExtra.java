package com.bytedance.ee.bear.templates.preview.announce;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0007J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "decrypt_key", "", "thumbnail", ResourceData.KEY_TYPE, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getDecrypt_key", "()Ljava/lang/String;", "getThumbnail", "getType", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailExtra implements Parcelable, NonProguard {
    public static final Parcelable.Creator<ThumbnailExtra> CREATOR = null;
    private final String decrypt_key;
    private final String thumbnail;
    private final int type;

    public static final class a implements Parcelable.Creator<ThumbnailExtra> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ThumbnailExtra createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new ThumbnailExtra(r4.readString(), r4.readString(), r4.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final ThumbnailExtra[] newArray(int r1) {
            return new ThumbnailExtra[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ThumbnailExtra() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ ThumbnailExtra copy$default(ThumbnailExtra r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.decrypt_key;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.thumbnail;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.type;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.decrypt_key;
    }

    public final String component2() {
        return this.thumbnail;
    }

    public final int component3() {
        return this.type;
    }

    public final ThumbnailExtra copy(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "decrypt_key");
        Intrinsics.checkNotNullParameter(r3, "thumbnail");
        return new ThumbnailExtra(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ThumbnailExtra) == true) goto L8;
        return false;
    L8:
        ThumbnailExtra r6 = (ThumbnailExtra) r5;
        if (Intrinsics.areEqual(this.decrypt_key, r6.decrypt_key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.thumbnail, r6.thumbnail) == true) goto L15;
        return false;
    L15:
        if (this.type == r6.type) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.decrypt_key.hashCode() * 31) + this.thumbnail.hashCode()) * 31) + this.type;
    }

    public String toString() {
        return "ThumbnailExtra(decrypt_key=" + this.decrypt_key + ", thumbnail=" + this.thumbnail + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.decrypt_key);
        r1.writeString(this.thumbnail);
        r1.writeInt(this.type);
    }

    public final String getDecrypt_key() {
        return this.decrypt_key;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final int getType() {
        return this.type;
    }

    public ThumbnailExtra(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "decrypt_key");
        Intrinsics.checkNotNullParameter(r3, "thumbnail");
        this.decrypt_key = r2;
        this.thumbnail = r3;
        this.type = r4;
    }

    public /* synthetic */ ThumbnailExtra(String r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 1;
    L11:
        this(r2, r3, r4);
    }
}
