package com.bytedance.ee.bear.content.common.morepanel;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u000eH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001a\u0010$\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelItemData;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "iconRes", "", "getIconRes", "()I", "setIconRes", "(I)V", "text", "getText", "setText", "rightIconRes", "getRightIconRes", "setRightIconRes", "righText", "getRighText", "setRighText", "isEnable", "", "()Z", "setEnable", "(Z)V", "rightIconSize", "getRightIconSize", "setRightIconSize", "rightIconTint", "getRightIconTint", "setRightIconTint", "writeToParcel", "", "flags", "describeContents", "CREATOR", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMorePanelItemData implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f216780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f216781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f216782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f216783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f216784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f216785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f216786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f216787h;

    public static final class a implements Parcelable.Creator<CommonMorePanelItemData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonMorePanelItemData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            CommonMorePanelItemData r101 = new CommonMorePanelItemData();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f216780a = r102;
            r101.f216781b = r100.readInt();
            String r104 = r100.readString();
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            r101.f216782c = r104;
            r101.f216783d = r100.readInt();
            String r105 = r100.readString();
            if (r105 == null) goto L12;
            r103 = r105;
        L12:
            r101.f216784e = r103;
            boolean r106 = true;
            if (r100.readInt() == 1) goto L16;
            r106 = false;
        L16:
            r101.f216785f = r106;
            r101.f216786g = r100.readInt();
            r101.f216787h = r100.readInt();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final CommonMorePanelItemData[] newArray(int r100) {
            return new CommonMorePanelItemData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public CommonMorePanelItemData() {
        this.f216780a = "";
        this.f216781b = -1;
        this.f216782c = "";
        this.f216783d = -1;
        this.f216784e = "";
        this.f216785f = true;
        this.f216786g = -1;
        this.f216787h = -1;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f216782c = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f216780a);
        r100.writeInt(this.f216781b);
        r100.writeString(this.f216782c);
        r100.writeInt(this.f216783d);
        r100.writeString(this.f216784e);
        r100.writeInt(this.f216785f ? 1 : 0);
        r100.writeInt(this.f216786g);
        r100.writeInt(this.f216787h);
    }
}
