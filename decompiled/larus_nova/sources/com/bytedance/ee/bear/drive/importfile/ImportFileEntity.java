package com.bytedance.ee.bear.drive.importfile;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public class ImportFileEntity implements Parcelable {
    public static final Parcelable.Creator<ImportFileEntity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f224401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f224402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f224403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f224404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f224405e;

    public class a implements Parcelable.Creator<ImportFileEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImportFileEntity createFromParcel(Parcel r100) {
            return new ImportFileEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ImportFileEntity[] newArray(int r100) {
            return new ImportFileEntity[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ImportFileEntity(Parcel r100) {
        this.f224401a = "";
        this.f224402b = "";
        this.f224403c = new HashMap();
        this.f224401a = r100.readString();
        this.f224402b = r100.readString();
        this.f224403c = r100.readHashMap(ImportFileEntity.class.getClassLoader());
        this.f224404d = r100.readBoolean();
        this.f224405e = r100.readLong();
    }

    public ImportFileEntity(String r100, String r101) {
        this.f224401a = "";
        this.f224402b = "";
        this.f224403c = new HashMap();
        this.f224401a = r100;
        this.f224402b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f224401a);
        r100.writeString(this.f224402b);
        r100.writeMap(this.f224403c);
        r100.writeBoolean(this.f224404d);
        r100.writeLong(this.f224405e);
    }
}
