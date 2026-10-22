package com.larus.dora.impl.device.settings.gesture.options;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.dora.impl.model.GestureSettingsKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/options/OptionModel;", "Landroid/os/Parcelable;", "title", "", "subTitle", "key", "Lcom/larus/dora/impl/model/GestureSettingsKey;", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/dora/impl/model/GestureSettingsKey;B)V", "getTitle", "()Ljava/lang/String;", "getSubTitle", "getKey", "()Lcom/larus/dora/impl/model/GestureSettingsKey;", "getValue", "()B", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionModel implements Parcelable {
    public static final Parcelable.Creator<OptionModel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f334449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f334450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GestureSettingsKey f334451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f334452d;

    public static final class a implements Parcelable.Creator<OptionModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OptionModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new OptionModel(r100.readString(), r100.readString(), GestureSettingsKey.valueOf(r100.readString()), r100.readByte());
        }

        @Override // android.os.Parcelable.Creator
        public final OptionModel[] newArray(int r100) {
            return new OptionModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OptionModel) == true) goto L8;
        return false;
    L8:
        OptionModel r101 = (OptionModel) r100;
        if (Intrinsics.areEqual(this.f334449a, r101.f334449a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f334450b, r101.f334450b) == true) goto L15;
        return false;
    L15:
        if (this.f334451c == r101.f334451c) goto L18;
        return false;
    L18:
        if (this.f334452d == r101.f334452d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f334449a.hashCode() * 31) + this.f334450b.hashCode()) * 31) + this.f334451c.hashCode()) * 31) + this.f334452d;
    }

    public final String toString() {
        return "OptionModel(title=" + this.f334449a + ", subTitle=" + this.f334450b + ", key=" + this.f334451c + ", value=" + this.f334452d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f334449a);
        r100.writeString(this.f334450b);
        r100.writeString(this.f334451c.name());
        r100.writeByte(this.f334452d);
    }

    public /* synthetic */ OptionModel(String r100, GestureSettingsKey r101, byte r102) {
        this(r100, "", r101, r102);
    }

    public OptionModel(String r100, String r101, GestureSettingsKey r102, byte r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        Intrinsics.checkNotNullParameter(r102, "key");
        this.f334449a = r100;
        this.f334450b = r101;
        this.f334451c = r102;
        this.f334452d = r103;
    }
}
