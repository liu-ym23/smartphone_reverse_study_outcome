package com.ss.android.lark.applink;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010 \u001a\u00020\u0005J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0016\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000e¨\u0006+"}, d2 = {"Lcom/ss/android/lark/applink/AppLink;", "Landroid/os/Parcelable;", "url", "", "source", "", "userSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "traceId", "extraParams", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/passportc/entity/UserSession;Ljava/lang/String;Landroid/os/Bundle;)V", "getUrl", "()Ljava/lang/String;", "getSource", "()I", "getUserSession", "()Lcom/ss/android/lark/passportc/entity/UserSession;", "getTraceId", "getExtraParams", "()Landroid/os/Bundle;", "path", "getPath", "delayForUnregister", "", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "applink_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLink implements Parcelable {
    public static final Parcelable.Creator<AppLink> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f408912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f408913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UserSession f408914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f408915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f408916e;

    public static final class a implements Parcelable.Creator<AppLink> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppLink createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new AppLink(r100.readString(), r100.readInt(), (UserSession) r100.readParcelable(AppLink.class.getClassLoader()), r100.readString(), r100.readBundle(AppLink.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final AppLink[] newArray(int r100) {
            return new AppLink[r100];
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
        if ((r100 instanceof AppLink) == true) goto L8;
        return false;
    L8:
        AppLink r101 = (AppLink) r100;
        if (Intrinsics.areEqual(this.f408912a, r101.f408912a) == true) goto L12;
        return false;
    L12:
        if (this.f408913b == r101.f408913b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f408914c, r101.f408914c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f408915d, r101.f408915d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f408916e, r101.f408916e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f408912a.hashCode() * 31) + this.f408913b) * 31) + this.f408914c.hashCode()) * 31;
        String r101 = this.f408915d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Bundle r105 = this.f408916e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppLink(url=" + this.f408912a + ", source=" + this.f408913b + ", userSession=" + this.f408914c + ", traceId=" + this.f408915d + ", extraParams=" + this.f408916e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f408912a);
        r100.writeInt(this.f408913b);
        r100.writeParcelable(this.f408914c, r101);
        r100.writeString(this.f408915d);
        r100.writeBundle(this.f408916e);
    }

    public AppLink(String r100, int r101, UserSession r102, String r103, Bundle r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "userSession");
        this.f408912a = r100;
        this.f408913b = r101;
        this.f408914c = r102;
        this.f408915d = r103;
        this.f408916e = r104;
    }
}
