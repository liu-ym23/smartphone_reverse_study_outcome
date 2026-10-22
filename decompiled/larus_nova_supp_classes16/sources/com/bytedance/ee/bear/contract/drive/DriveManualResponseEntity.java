package com.bytedance.ee.bear.contract.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001:Bk\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0013J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\u000bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003Jk\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006;"}, d2 = {"Lcom/bytedance/ee/bear/contract/drive/DriveManualResponseEntity;", "Landroid/os/Parcelable;", "status", "", "objToken", "", "progress", "url", "errorCode", "msg", "fileSize", "", "subType", "showToast", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;JLjava/lang/String;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getStatus", "()I", "getObjToken", "()Ljava/lang/String;", "getProgress", "getUrl", "getErrorCode", "setErrorCode", "(I)V", "getMsg", "setMsg", "(Ljava/lang/String;)V", "getFileSize", "()J", "getSubType", "getShowToast", "()Z", "setShowToast", "(Z)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveManualResponseEntity implements Parcelable {
    public static final a CREATOR = null;
    public final int a;
    public final String b;
    public final int c;
    public final String d;
    public int e;
    public final String f;
    public final long g;
    public final String h;
    public final boolean i;

    public static final class a implements Parcelable.Creator<DriveManualResponseEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveManualResponseEntity createFromParcel(Parcel r14) {
            Intrinsics.checkNotNullParameter(r14, "parcel");
            Intrinsics.checkNotNullParameter(r14, "parcel");
            int r2 = r14.readInt();
            String r3 = r14.readString();
            int r4 = r14.readInt();
            String r5 = r14.readString();
            int r6 = r14.readInt();
            String r7 = r14.readString();
            long r8 = r14.readLong();
            String r10 = r14.readString();
            if (r14.readByte() == 0) goto L5;
            boolean r11 = true;
        L7:
            return new DriveManualResponseEntity(r2, r3, r4, r5, r6, r7, r8, r10, r11);
        L5:
            r11 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DriveManualResponseEntity[] newArray(int r1) {
            return new DriveManualResponseEntity[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public DriveManualResponseEntity() {
        this(0, null, 0, null, 0, null, 0, null, 511);
    }

    public DriveManualResponseEntity(int r12, String r13, int r14, String r16) {
        this(r12, r13, r14, r16, 0, null, 0, null, 496);
    }

    public DriveManualResponseEntity(int r12, String r13, int r14, String r16, int r17, String r18, long r19, String r20) {
        this(r12, r13, r14, r16, r17, r18, r19, r20, 256);
    }

    public DriveManualResponseEntity(String r12, String r13, int r14) {
        this(0, r12, 0, r13, r14, null, 0, null, 480);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DriveManualResponseEntity) == true) goto L8;
        return false;
    L8:
        DriveManualResponseEntity r9 = (DriveManualResponseEntity) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e) * 31;
        String r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        long r10 = this.g;
        int r11 = (((r7 + r9) * 31) + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        String r12 = this.h;
        if (r12 == null) goto L18;
        r2 = r12.hashCode();
    L18:
        int r13 = (r11 + r2) * 31;
        if (this.i == false) goto L21;
        int r14 = 1231;
    L23:
        return r13 + r14;
    L21:
        r14 = 1237;
        goto L23
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DriveManualResponseEntity(status=" + this.a + ", objToken=" + this.b + ", progress=" + this.c + ", url=" + this.d + ", errorCode=" + this.e + ", msg=" + this.f + ", fileSize=" + this.g + ", subType=" + this.h + ", showToast=" + this.i + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.a);
        r3.writeString(this.b);
        r3.writeInt(this.c);
        r3.writeString(this.d);
        r3.writeInt(this.e);
        r3.writeString(this.f);
        r3.writeLong(this.g);
        r3.writeString(this.h);
        r3.writeByte(this.i ? 1 : 0);
    }

    public /* synthetic */ DriveManualResponseEntity(int r16, String r17, int r18, String r19, int r110, String r20, long r21, String r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r6 = 0;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r24 & 16) == 0) goto L21;
        int r8 = 0;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r24 & 64) == 0) goto L29;
        long r10 = 0;
    L31:
        if ((r24 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        String r12 = "";
    L34:
        this(r4, r5, r6, r7, r8, r9, r10, r12, false);
        return;
    L33:
        r12 = r23;
        goto L34
    L29:
        r10 = r21;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r110;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public DriveManualResponseEntity(int r1, String r2, int r3, String r4, int r5, String r6, long r7, String r9, boolean r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r9;
        this.i = r10;
    }
}
