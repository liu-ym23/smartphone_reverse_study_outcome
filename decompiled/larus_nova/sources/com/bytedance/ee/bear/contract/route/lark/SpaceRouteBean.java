package com.bytedance.ee.bear.contract.route.lark;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class SpaceRouteBean implements Parcelable {
    public static final Parcelable.Creator<SpaceRouteBean> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f217140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f217141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f217143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f217144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DriveBizScene f217145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DriveWatermarkScene f217146g;

    public class a implements Parcelable.Creator<SpaceRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceRouteBean createFromParcel(Parcel r100) {
            return new SpaceRouteBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceRouteBean[] newArray(int r100) {
            return new SpaceRouteBean[r100];
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

    public SpaceRouteBean(Parcel r100) {
        this.f217140a = r100.readInt();
        this.f217141b = r100.readString();
        this.f217142c = r100.readString();
        this.f217143d = r100.readHashMap(getClass().getClassLoader());
        this.f217144e = r100.readBundle(getClass().getClassLoader());
        int r101 = r100.readInt();
        DriveWatermarkScene r102 = null;
        if (r101 != (-1)) goto L5;
        DriveBizScene r103 = null;
    L6:
        this.f217145f = r103;
        int r104 = r100.readInt();
        if (r104 == (-1)) goto L10;
        r102 = DriveWatermarkScene.fromValue(r104);
    L10:
        this.f217146g = r102;
        return;
    L5:
        r103 = DriveBizScene.fromValue(r101);
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f217140a);
        r100.writeString(this.f217141b);
        r100.writeString(this.f217142c);
        r100.writeMap(this.f217143d);
        r100.writeBundle(this.f217144e);
        DriveBizScene r102 = this.f217145f;
        int r103 = -1;
        if (r102 != null) goto L5;
        int r104 = -1;
    L6:
        r100.writeInt(r104);
        DriveWatermarkScene r105 = this.f217146g;
        if (r105 == null) goto L10;
        r103 = r105.getValue();
    L10:
        r100.writeInt(r103);
        return;
    L5:
        r104 = r102.getValue();
        goto L6
    }
}
