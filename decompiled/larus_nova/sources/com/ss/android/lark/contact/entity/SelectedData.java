package com.ss.android.lark.contact.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class SelectedData implements Serializable, Parcelable {
    public static final Parcelable.Creator<SelectedData> CREATOR = null;
    private static final long serialVersionUID = -5081739513370342806L;
    public String avatarKey;
    public DataType dataType;
    public String description;
    public int descriptionDrawable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f419437id;
    public boolean isRegistered;
    public boolean isShowDescription;
    public String name;

    public static final enum DataType extends Enum<DataType> {
        public static final DataType CHAT = null;
        public static final DataType CHATTER = null;
        public static final DataType DEPARTAMENT = null;
        public static final DataType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f419438a = null;
        private int value;

        static {
            DataType r100 = new DataType("CHATTER", 0, 1);
            CHATTER = r100;
            DataType r101 = new DataType("CHAT", 1, 2);
            CHAT = r101;
            DataType r102 = new DataType("UNKNOWN", 2, 0);
            UNKNOWN = r102;
            DataType r103 = new DataType("DEPARTAMENT", 3, 3);
            DEPARTAMENT = r103;
            f419438a = new DataType[]{r100, r101, r102, r103};
        }

        public static DataType[] values() {
            return (DataType[]) f419438a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static /* synthetic */ int access$000(DataType r100) {
            return r100.value;
        }

        public static DataType forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return UNKNOWN;
        L11:
            return DEPARTAMENT;
        L13:
            return CHAT;
        L15:
            return CHATTER;
        }

        public static DataType valueOf(String r100) {
            return (DataType) r27.a.a(DataType.class, r100);
        }

        public static DataType valueOf(int r100) {
            return forNumber(r100);
        }

        public DataType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public class a implements Parcelable.Creator<SelectedData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectedData createFromParcel(Parcel r100) {
            return new SelectedData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SelectedData[] newArray(int r100) {
            return new SelectedData[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SelectedData() {
        this.isRegistered = true;
    }

    public SelectedData(Parcel r100) {
        boolean r101 = true;
        this.isRegistered = true;
        this.dataType = DataType.forNumber(r100.readInt());
        this.f419437id = r100.readString();
        this.name = r100.readString();
        this.avatarKey = r100.readString();
        if (r100.readInt() != 1) goto L5;
        boolean r102 = true;
    L6:
        this.isRegistered = r102;
        if (r100.readInt() == 1) goto L10;
        r101 = false;
    L10:
        this.isShowDescription = r101;
        this.description = r100.readString();
        this.descriptionDrawable = r100.readInt();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static SelectedData getFromBundle(Bundle r100) {
        return (SelectedData) r100.getParcelable("selected_data");
    }

    public void addToBundle(Bundle r100) {
        r100.putParcelable("selected_data", this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        DataType r102 = this.dataType;
        if (r102 == null) goto L5;
        int r103 = DataType.access$000(r102);
    L6:
        r100.writeInt(r103);
        r100.writeString(this.f419437id);
        r100.writeString(this.name);
        r100.writeString(this.avatarKey);
        r100.writeInt(this.isRegistered ? 1 : 0);
        r100.writeInt(this.isShowDescription ? 1 : 0);
        r100.writeString(this.description);
        r100.writeInt(this.descriptionDrawable);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public SelectedData(DataType r100, String r101, String r102, String r103, boolean r104, boolean r105, String r106, int r107) {
        this.dataType = r100;
        this.f419437id = r101;
        this.name = r102;
        this.avatarKey = r103;
        this.isRegistered = r104;
        this.isShowDescription = r105;
        this.description = r106;
        this.descriptionDrawable = r107;
    }
}
