package com.bytedance.scene.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.scene.Scene;

/* JADX INFO: loaded from: classes19.dex */
class Record implements Parcelable {
    public static final Parcelable.Creator<Record> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Scene f268768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f268769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActivityStatusRecord f268770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ja7.i f268771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f268772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public na7.f f268773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f268774g;

    public static class a implements Parcelable.Creator<Record> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Record createFromParcel(Parcel r100) {
            return new Record(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Record[] newArray(int r100) {
            return new Record[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public Record() {
    }

    public Record(Parcel r100) {
        this.f268770c = (ActivityStatusRecord) r100.readParcelable(ActivityStatusRecord.class.getClassLoader());
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f268769b = r101;
        this.f268774g = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f268770c, r101);
        r100.writeByte(this.f268769b ? 1 : 0);
        r100.writeString(this.f268774g);
    }
}
