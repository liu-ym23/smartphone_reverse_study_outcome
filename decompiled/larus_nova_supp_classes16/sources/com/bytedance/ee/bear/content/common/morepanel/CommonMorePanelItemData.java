package com.bytedance.ee.bear.content.common.morepanel;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u000eH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001a\u0010$\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelItemData;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "iconRes", "", "getIconRes", "()I", "setIconRes", "(I)V", "text", "getText", "setText", "rightIconRes", "getRightIconRes", "setRightIconRes", "righText", "getRighText", "setRighText", "isEnable", "", "()Z", "setEnable", "(Z)V", "rightIconSize", "getRightIconSize", "setRightIconSize", "rightIconTint", "getRightIconTint", "setRightIconTint", "writeToParcel", "", "flags", "describeContents", "CREATOR", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMorePanelItemData implements Parcelable {
    public static final a CREATOR = null;
    public String a;
    public int b;
    public String c;
    public int d;
    public String e;
    public boolean f;
    public int g;
    public int h;

    public static final class a implements Parcelable.Creator<CommonMorePanelItemData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonMorePanelItemData createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            CommonMorePanelItemData r1 = new CommonMorePanelItemData();
            String r0 = r4.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.a = r0;
            r1.b = r4.readInt();
            String r3 = r4.readString();
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r1.c = r3;
            r1.d = r4.readInt();
            String r5 = r4.readString();
            if (r5 == null) goto L12;
            r2 = r5;
        L12:
            r1.e = r2;
            boolean r6 = true;
            if (r4.readInt() == 1) goto L16;
            r6 = false;
        L16:
            r1.f = r6;
            r1.g = r4.readInt();
            r1.h = r4.readInt();
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final CommonMorePanelItemData[] newArray(int r1) {
            return new CommonMorePanelItemData[r1];
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
        this.a = "";
        this.b = -1;
        this.c = "";
        this.d = -1;
        this.e = "";
        this.f = true;
        this.g = -1;
        this.h = -1;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
        r1.writeInt(this.b);
        r1.writeString(this.c);
        r1.writeInt(this.d);
        r1.writeString(this.e);
        r1.writeInt(this.f ? 1 : 0);
        r1.writeInt(this.g);
        r1.writeInt(this.h);
    }
}
