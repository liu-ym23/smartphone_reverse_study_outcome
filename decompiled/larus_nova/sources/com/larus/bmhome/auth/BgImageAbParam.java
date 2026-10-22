package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\r\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\rJ\u0013\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/auth/BgImageAbParam;", "Landroid/os/Parcelable;", "bgImageSetting", "Lcom/larus/bmhome/auth/BgImageSetting;", "<init>", "(Lcom/larus/bmhome/auth/BgImageSetting;)V", "getBgImageSetting", "()Lcom/larus/bmhome/auth/BgImageSetting;", "getBotGenAddImageSetting", "", "()Ljava/lang/Boolean;", "getIsAiImageWorkflow", "getBgImageOpenMode", "", "()Ljava/lang/Integer;", "getIsImageGuide", "component1", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgImageAbParam implements Parcelable {
    public static final Parcelable.Creator<BgImageAbParam> CREATOR = null;

    @SerializedName("bg_image_setting")
    private final BgImageSetting bgImageSetting;

    public static final class a implements Parcelable.Creator<BgImageAbParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageAbParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            BgImageSetting r101 = null;
        L7:
            return new BgImageAbParam(r101);
        L5:
            r101 = BgImageSetting.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageAbParam[] newArray(int r100) {
            return new BgImageAbParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BgImageAbParam() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BgImageAbParam) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.bgImageSetting, ((BgImageAbParam) r100).bgImageSetting) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        BgImageSetting r100 = this.bgImageSetting;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "BgImageAbParam(bgImageSetting=" + this.bgImageSetting + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        BgImageSetting r102 = this.bgImageSetting;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public final Integer a() {
        BgImageSetting r100 = this.bgImageSetting;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public final Boolean b() {
        BgImageSetting r100 = this.bgImageSetting;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public final Boolean c() {
        BgImageSetting r100 = this.bgImageSetting;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    public final Boolean d() {
        BgImageSetting r100 = this.bgImageSetting;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    public BgImageAbParam(BgImageSetting r100) {
        this.bgImageSetting = r100;
    }
}
