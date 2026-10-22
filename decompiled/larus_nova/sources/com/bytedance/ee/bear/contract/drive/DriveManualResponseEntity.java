package com.bytedance.ee.bear.contract.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001:Bk\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0013J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\u000bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003Jk\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006;"}, d2 = {"Lcom/bytedance/ee/bear/contract/drive/DriveManualResponseEntity;", "Landroid/os/Parcelable;", "status", "", "objToken", "", "progress", "url", "errorCode", "msg", "fileSize", "", "subType", "showToast", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;JLjava/lang/String;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getStatus", "()I", "getObjToken", "()Ljava/lang/String;", "getProgress", "getUrl", "getErrorCode", "setErrorCode", "(I)V", "getMsg", "setMsg", "(Ljava/lang/String;)V", "getFileSize", "()J", "getSubType", "getShowToast", "()Z", "setShowToast", "(Z)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveManualResponseEntity implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f216987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f216988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f216989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f216990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f216991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f216992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f216993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f216994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f216995i;

    public static final class a implements Parcelable.Creator<DriveManualResponseEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveManualResponseEntity createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            String r101 = r110.readString();
            int r102 = r110.readInt();
            String r103 = r110.readString();
            int r104 = r110.readInt();
            String r105 = r110.readString();
            long r106 = r110.readLong();
            String r111 = r110.readString();
            if (r110.readByte() == 0) goto L5;
            boolean r112 = true;
        L7:
            return new DriveManualResponseEntity(r100, r101, r102, r103, r104, r105, r106, r111, r112);
        L5:
            r112 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DriveManualResponseEntity[] newArray(int r100) {
            return new DriveManualResponseEntity[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DriveManualResponseEntity() {
        this(0, null, 0, null, 0, null, 0, null, 511);
    }

    public DriveManualResponseEntity(int r110, String r111, int r112, String r113) {
        this(r110, r111, r112, r113, 0, null, 0, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT);
    }

    public DriveManualResponseEntity(int r110, String r111, int r112, String r113, int r114, String r115, long r116, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, 256);
    }

    public DriveManualResponseEntity(String r110, String r111, int r112) {
        this(0, r110, 0, r111, r112, null, 0, null, 480);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DriveManualResponseEntity) == true) goto L8;
        return false;
    L8:
        DriveManualResponseEntity r101 = (DriveManualResponseEntity) r100;
        if (this.f216987a == r101.f216987a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f216988b, r101.f216988b) == true) goto L15;
        return false;
    L15:
        if (this.f216989c == r101.f216989c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f216990d, r101.f216990d) == true) goto L21;
        return false;
    L21:
        if (this.f216991e == r101.f216991e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f216992f, r101.f216992f) == true) goto L27;
        return false;
    L27:
        if (this.f216993g == r101.f216993g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f216994h, r101.f216994h) == true) goto L33;
        return false;
    L33:
        if (this.f216995i == r101.f216995i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f216987a * 31;
        String r101 = this.f216988b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f216989c) * 31;
        String r105 = this.f216990d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f216991e) * 31;
        String r108 = this.f216992f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        long r110 = this.f216993g;
        int r111 = (((r107 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.f216994h;
        if (r112 == null) goto L18;
        r102 = r112.hashCode();
    L18:
        int r113 = (r111 + r102) * 31;
        if (this.f216995i == false) goto L21;
        int r114 = 1231;
    L23:
        return r113 + r114;
    L21:
        r114 = 1237;
        goto L23
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DriveManualResponseEntity(status=" + this.f216987a + ", objToken=" + this.f216988b + ", progress=" + this.f216989c + ", url=" + this.f216990d + ", errorCode=" + this.f216991e + ", msg=" + this.f216992f + ", fileSize=" + this.f216993g + ", subType=" + this.f216994h + ", showToast=" + this.f216995i + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f216987a);
        r100.writeString(this.f216988b);
        r100.writeInt(this.f216989c);
        r100.writeString(this.f216990d);
        r100.writeInt(this.f216991e);
        r100.writeString(this.f216992f);
        r100.writeLong(this.f216993g);
        r100.writeString(this.f216994h);
        r100.writeByte(this.f216995i ? 1 : 0);
    }

    public /* synthetic */ DriveManualResponseEntity(int r110, String r111, int r112, String r113, int r114, String r210, long r211, String r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r213 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r213 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r115 = 0;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r116 = "";
    L34:
        this(r100, r101, r102, r103, r104, r105, r115, r116, false);
        return;
    L33:
        r116 = r212;
        goto L34
    L29:
        r115 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public DriveManualResponseEntity(int r100, String r101, int r102, String r103, int r104, String r105, long r106, String r107, boolean r110) {
        this.f216987a = r100;
        this.f216988b = r101;
        this.f216989c = r102;
        this.f216990d = r103;
        this.f216991e = r104;
        this.f216992f = r105;
        this.f216993g = r106;
        this.f216994h = r107;
        this.f216995i = r110;
    }
}
