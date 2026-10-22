package com.bytedance.scene.group;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.scene.Scene;

/* JADX INFO: loaded from: classes19.dex */
class GroupRecord implements Parcelable {
    public static final Parcelable.Creator<GroupRecord> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f268647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scene f268648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f268649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f268650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f268651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f268652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f268653g;

    public static class a implements Parcelable.Creator<GroupRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GroupRecord createFromParcel(Parcel r100) {
            return new GroupRecord(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GroupRecord[] newArray(int r100) {
            return new GroupRecord[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public GroupRecord() {
        this.f268647a = -1;
        this.f268650d = false;
        this.f268651e = false;
    }

    public GroupRecord(Parcel r100) {
        this.f268647a = -1;
        boolean r101 = false;
        this.f268650d = false;
        this.f268651e = false;
        this.f268647a = r100.readInt();
        String r102 = r100.readString();
        qa7.g.d(r102, "tag not found in Parcel");
        this.f268649c = r102;
        if (r100.readByte() == 0) goto L5;
        boolean r103 = true;
    L6:
        this.f268650d = r103;
        if (r100.readByte() == 0) goto L9;
        r101 = true;
    L9:
        this.f268651e = r101;
        String r104 = r100.readString();
        qa7.g.d(r104, "class name not found in Parcel");
        this.f268652f = r104;
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f268647a);
        r100.writeString(this.f268649c);
        r100.writeByte(this.f268650d ? 1 : 0);
        r100.writeByte(this.f268651e ? 1 : 0);
        r100.writeString(this.f268652f);
    }
}
