package com.larus.settings.provider.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/larus/settings/provider/creation/TitleConfig;", "Landroid/os/Parcelable;", "text", "", "alignment", "", "color", "Lcom/larus/settings/provider/creation/ColorConfig;", "<init>", "(Ljava/lang/String;ILcom/larus/settings/provider/creation/ColorConfig;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getText", "()Ljava/lang/String;", "getAlignment", "()I", "getColor", "()Lcom/larus/settings/provider/creation/ColorConfig;", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleConfig implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("alignment")
    private final int alignment;

    @SerializedName("color")
    private final ColorConfig color;

    @SerializedName("text")
    private final String text;

    public static final class a implements Parcelable.Creator<TitleConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TitleConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new TitleConfig(r100.readString(), r100.readInt(), (ColorConfig) r100.readParcelable(ColorConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final TitleConfig[] newArray(int r100) {
            return new TitleConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TitleConfig() {
        this(null, 0, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TitleConfig) == true) goto L8;
        return false;
    L8:
        TitleConfig r101 = (TitleConfig) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (this.alignment == r101.alignment) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.alignment) * 31;
        ColorConfig r104 = this.color;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TitleConfig(text=" + this.text + ", alignment=" + this.alignment + ", color=" + this.color + ')';
    }

    public final int a() {
        return this.alignment;
    }

    public final ColorConfig b() {
        return this.color;
    }

    public final String c() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.text);
        r100.writeInt(this.alignment);
        r100.writeParcelable(this.color, r101);
    }

    public TitleConfig(String r100, @Alignment int r101, ColorConfig r102) {
        this.text = r100;
        this.alignment = r101;
        this.color = r102;
    }
}
