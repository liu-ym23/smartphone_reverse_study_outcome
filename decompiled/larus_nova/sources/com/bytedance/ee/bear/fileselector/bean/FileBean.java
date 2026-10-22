package com.bytedance.ee.bear.fileselector.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class FileBean implements Serializable, Parcelable {
    public static final Parcelable.Creator<FileBean> CREATOR = null;
    private String compressPath;
    private long duration;
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f226784id;
    private boolean isChecked;
    private boolean isOrigin;
    private String mimeType;
    private int num;
    private String path;
    private String pictureType;
    public int position;
    private long size;
    private String uuid;
    private int width;

    public class a implements Parcelable.Creator<FileBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FileBean createFromParcel(Parcel r100) {
            return new FileBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FileBean[] newArray(int r100) {
            return new FileBean[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int hashCode() {
        int r100 = this.f226784id * 31;
        String r101 = this.path;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.mimeType;
        if (r105 == null) goto L9;
        r102 = r105.hashCode();
    L9:
        long r106 = this.duration;
        return ((r104 + r102) * 31) + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r103 = 0;
        goto L6
    }

    public boolean isVideo() {
        if (TextUtils.isEmpty(this.mimeType) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mimeType.startsWith("video") == false) goto L7;
        return true;
    }

    public FileBean() {
    }

    public String getCompressPath() {
        return this.compressPath;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public int getId() {
        return this.f226784id;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getNum() {
        return this.num;
    }

    public String getPath() {
        return this.path;
    }

    public String getPictureType() {
        return this.pictureType;
    }

    public int getPosition() {
        return this.position;
    }

    public long getSize() {
        return this.size;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isOrigin() {
        return this.isOrigin;
    }

    public FileBean(Parcel r100) {
        this.position = r100.readInt();
        this.f226784id = r100.readInt();
        this.path = r100.readString();
        this.mimeType = r100.readString();
        this.duration = r100.readLong();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isChecked = r102;
        this.num = r100.readInt();
        this.pictureType = r100.readString();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.size = r100.readLong();
        this.compressPath = r100.readString();
        this.uuid = r100.readString();
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.isOrigin = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L31;
        FileBean r101 = (FileBean) r100;
        if (this.f226784id == r101.f226784id) goto L14;
        return false;
    L14:
        if (this.duration == r101.duration) goto L16;
        return false;
    L16:
        String r102 = this.path;
        if (r102 == null) goto L22;
        if (r102.equals(r101.path) == false) goto L23;
    L24:
        String r103 = this.mimeType;
        String r104 = r101.mimeType;
        if (r103 != null) goto L32;
        if (r104 == null) goto L33;
        return false;
    L33:
        return true;
    L32:
        return r103.equals(r104);
    L23:
        return false;
    L22:
        if (r101.path == null) goto L24;
        goto L23
    }

    public void setChecked(boolean r100) {
        this.isChecked = r100;
    }

    public void setCompressPath(String r100) {
        this.compressPath = r100;
    }

    public void setDuration(long r100) {
        this.duration = r100;
    }

    public FileBean setHeight(int r100) {
        this.height = r100;
        return this;
    }

    public void setId(int r100) {
        this.f226784id = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setNum(int r100) {
        this.num = r100;
    }

    public void setOrigin(boolean r100) {
        this.isOrigin = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public void setPictureType(String r100) {
        this.pictureType = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public void setUuid(String r100) {
        this.uuid = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    public FileBean(FileBean r100) {
        this.f226784id = r100.f226784id;
        this.path = r100.path;
        this.mimeType = r100.mimeType;
        this.duration = r100.duration;
        this.isChecked = r100.isChecked;
        this.position = r100.position;
        this.num = r100.num;
        this.pictureType = r100.pictureType;
        this.width = r100.width;
        this.height = r100.height;
        this.size = r100.size;
        this.compressPath = r100.compressPath;
        this.uuid = r100.uuid;
        this.isOrigin = r100.isOrigin;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.position);
        r100.writeInt(this.f226784id);
        r100.writeString(this.path);
        r100.writeString(this.mimeType);
        r100.writeLong(this.duration);
        r100.writeByte(this.isChecked ? 1 : 0);
        r100.writeInt(this.num);
        r100.writeString(this.pictureType);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeLong(this.size);
        r100.writeString(this.compressPath);
        r100.writeString(this.uuid);
        r100.writeByte(this.isOrigin ? 1 : 0);
    }

    public FileBean(int r100, String r101, String r102, long r103, int r104, int r105, long r106) {
        this.f226784id = r100;
        this.path = r101;
        this.mimeType = r102;
        this.duration = r103;
        this.width = r104;
        this.height = r105;
        this.size = r106;
    }
}
