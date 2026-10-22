package com.ss.android.lark.forwardv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "avatarKey", "getAvatarKey", "setAvatarKey", "isCrossTenant", "", "()Z", "setCrossTenant", "(Z)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "constructor", "", "writeToParcel", "flags", "describeContents", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ForwardTargetBaseInfoNew implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f425268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f425269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f425270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f425271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f425272e;

    public static final class a implements Parcelable.Creator<ForwardTargetBaseInfoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetBaseInfoNew createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardTargetBaseInfoNew r101 = new ForwardTargetBaseInfoNew();
            r101.a(r100);
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetBaseInfoNew[] newArray(int r100) {
            return new ForwardTargetBaseInfoNew[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ForwardTargetBaseInfoNew() {
        this.f425268a = "";
        this.f425269b = "";
        this.f425270c = "";
    }

    public int getType() {
        return this.f425272e;
    }

    public final void a(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f425268a = r101;
        String r103 = r100.readString();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f425269b = r103;
        String r104 = r100.readString();
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        this.f425270c = r102;
        if (r100.readByte() == 0) goto L15;
        boolean r105 = true;
    L16:
        this.f425271d = r105;
        b(r100.readInt());
        return;
    L15:
        r105 = false;
        goto L16
    }

    public void b(int r100) {
        this.f425272e = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f425268a);
        r100.writeString(this.f425269b);
        r100.writeString(this.f425270c);
        r100.writeByte(this.f425271d ? 1 : 0);
        r100.writeInt(getType());
    }
}
