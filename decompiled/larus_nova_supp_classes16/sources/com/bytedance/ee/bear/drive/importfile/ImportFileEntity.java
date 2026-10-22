package com.bytedance.ee.bear.drive.importfile;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImportFileEntity implements Parcelable {
    public static final Parcelable.Creator<ImportFileEntity> CREATOR = null;
    public final String a;
    public final String b;
    public HashMap<String, String> c;
    public boolean d;
    public long e;

    public class a implements Parcelable.Creator<ImportFileEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImportFileEntity createFromParcel(Parcel r2) {
            return new ImportFileEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ImportFileEntity[] newArray(int r1) {
            return new ImportFileEntity[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ImportFileEntity(Parcel r3) {
        this.a = "";
        this.b = "";
        this.c = new HashMap();
        this.a = r3.readString();
        this.b = r3.readString();
        this.c = r3.readHashMap(ImportFileEntity.class.getClassLoader());
        this.d = r3.readBoolean();
        this.e = r3.readLong();
    }

    public ImportFileEntity(String r2, String r3) {
        this.a = "";
        this.b = "";
        this.c = new HashMap();
        this.a = r2;
        this.b = r3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeMap(this.c);
        r3.writeBoolean(this.d);
        r3.writeLong(this.e);
    }
}
