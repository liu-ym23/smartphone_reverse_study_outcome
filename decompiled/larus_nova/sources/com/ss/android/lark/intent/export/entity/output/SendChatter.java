package com.ss.android.lark.intent.export.entity.output;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0004H\u0016J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006#"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SendChatter;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", "name", "avatar", "Ljava/io/File;", "department", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getAvatar", "()Ljava/io/File;", "getDepartment", "toString", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendChatter implements Serializable, Parcelable {
    public static final Parcelable.Creator<SendChatter> CREATOR = null;
    private final File avatar;
    private final String department;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f428146id;
    private final String name;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SendChatter> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChatter createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SendChatter(r100.readString(), r100.readString(), (File) r100.readSerializable(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChatter createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChatter[] newArray(int r100) {
            return new SendChatter[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChatter[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SendChatter copy$default(SendChatter r100, String r101, String r102, File r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f428146id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.avatar;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.department;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f428146id;
    }

    public final String component2() {
        return this.name;
    }

    public final File component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.department;
    }

    public final SendChatter copy(String r100, String r101, File r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        return new SendChatter(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendChatter) == true) goto L8;
        return false;
    L8:
        SendChatter r101 = (SendChatter) r100;
        if (Intrinsics.areEqual(this.f428146id, r101.f428146id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.department, r101.department) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.f428146id.hashCode() * 31) + this.name.hashCode()) * 31;
        File r101 = this.avatar;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.department;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f428146id);
        r100.writeString(this.name);
        r100.writeSerializable(this.avatar);
        r100.writeString(this.department);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("SendChatter(id='");
        r100.append(this.f428146id);
        r100.append("', name='");
        r100.append(this.name);
        r100.append("', avatar=");
        File r101 = this.avatar;
        if (r101 == null) goto L5;
        Uri r102 = Uri.fromFile(r101);
    L6:
        r100.append(r102);
        r100.append(", department=");
        r100.append(this.department);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final File getAvatar() {
        return this.avatar;
    }

    public final String getDepartment() {
        return this.department;
    }

    public final String getId() {
        return this.f428146id;
    }

    public final String getName() {
        return this.name;
    }

    public SendChatter(String r100, String r101, File r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f428146id = r100;
        this.name = r101;
        this.avatar = r102;
        this.department = r103;
    }
}
