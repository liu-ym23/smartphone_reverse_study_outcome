package com.bytedance.ee.bear.contract.route.lark;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SpaceRouteBean implements Parcelable {
    public static final Parcelable.Creator<SpaceRouteBean> CREATOR = null;
    public int a;
    public final String b;
    public final String c;
    public final Map<String, String> d;
    public final Bundle e;
    public final DriveBizScene f;
    public final DriveWatermarkScene g;

    public class a implements Parcelable.Creator<SpaceRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceRouteBean createFromParcel(Parcel r2) {
            return new SpaceRouteBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceRouteBean[] newArray(int r1) {
            return new SpaceRouteBean[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SpaceRouteBean() {
    }

    public SpaceRouteBean(Parcel r4) {
        this.a = r4.readInt();
        this.b = r4.readString();
        this.c = r4.readString();
        this.d = r4.readHashMap(getClass().getClassLoader());
        this.e = r4.readBundle(getClass().getClassLoader());
        int r0 = r4.readInt();
        DriveWatermarkScene r1 = null;
        if (r0 != (-1)) goto L5;
        DriveBizScene r2 = null;
    L6:
        this.f = r2;
        int r5 = r4.readInt();
        if (r5 == (-1)) goto L10;
        r1 = DriveWatermarkScene.fromValue(r5);
    L10:
        this.g = r1;
        return;
    L5:
        r2 = DriveBizScene.fromValue(r0);
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(this.a);
        r2.writeString(this.b);
        r2.writeString(this.c);
        r2.writeMap(this.d);
        r2.writeBundle(this.e);
        DriveBizScene r4 = this.f;
        int r0 = -1;
        if (r4 != null) goto L5;
        int r5 = -1;
    L6:
        r2.writeInt(r5);
        DriveWatermarkScene r6 = this.g;
        if (r6 == null) goto L10;
        r0 = r6.getValue();
    L10:
        r2.writeInt(r0);
        return;
    L5:
        r5 = r4.getValue();
        goto L6
    }
}
