package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001)BO\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b%\u0010&B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b%\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003JQ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b$\u0010\u001f¨\u0006*"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "component1", "component2", "component3", "component4", "component5", "component6", "id", "time", "content", "appName", "packageName", "title", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getTime", "getContent", "getAppName", "getPackageName", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class AppNotification implements Parcelable {
    public static final a CREATOR = null;
    private final String appName;
    private final String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f396869id;
    private final String packageName;
    private final String time;
    private final String title;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<AppNotification> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppNotification createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new AppNotification(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AppNotification[] newArray(int r100) {
            return new AppNotification[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public AppNotification() {
        this(null, null, null, null, null, null, 63, null);
    }

    public AppNotification(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(r100.readString(), r100.readString(), r100.readString(), r100.readString(), r100.readString(), r100.readString());
    }

    public AppNotification(String r100, String r101, String r102, String r103, String r104, String r105) {
        this.f396869id = r100;
        this.time = r101;
        this.content = r102;
        this.appName = r103;
        this.packageName = r104;
        this.title = r105;
    }

    public /* synthetic */ AppNotification(String r100, String r101, String r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }

    public static /* synthetic */ AppNotification copy$default(AppNotification r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f396869id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.time;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.appName;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.packageName;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.title;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.f396869id;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.appName;
    }

    public final String component5() {
        return this.packageName;
    }

    public final String component6() {
        return this.title;
    }

    public final AppNotification copy(String r100, String r110, String r111, String r112, String r113, String r114) {
        return new AppNotification(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppNotification) == true) goto L8;
        return false;
    L8:
        AppNotification r101 = (AppNotification) r100;
        if (Intrinsics.areEqual(this.f396869id, r101.f396869id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.f396869id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String r100 = this.f396869id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.time;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.appName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.packageName;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.title;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AppNotification(id=" + this.f396869id + ", time=" + this.time + ", content=" + this.content + ", appName=" + this.appName + ", packageName=" + this.packageName + ", title=" + this.title + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f396869id);
        r100.writeString(this.time);
        r100.writeString(this.content);
        r100.writeString(this.appName);
        r100.writeString(this.packageName);
        r100.writeString(this.title);
    }
}
