package com.ss.android.lark.widget.photopicker.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class Photo implements Serializable, Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = null;
    private String camera;
    private String compressPath;
    private long duration;
    public String durationFormat;
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f447476id;
    public boolean isAnimatedImage;
    private boolean isChecked;
    private String mimeType;
    private int num;
    private String path;
    private String pictureType;
    public int position;
    private long size;
    private int width;

    public class a implements Parcelable.Creator<Photo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Photo createFromParcel(Parcel r100) {
            return new Photo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Photo[] newArray(int r100) {
            return new Photo[r100];
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
        int r100 = this.f447476id * 31;
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

    public boolean isHeif() {
        if (TextUtils.isEmpty(this.mimeType) == false) goto L5;
        return false;
    L5:
        if (Objects.equals(this.mimeType, "image/heif") == false) goto L7;
    L8:
        return true;
    L7:
        if (Objects.equals(this.mimeType, "image/heic") == true) goto L8;
        return false;
    }

    public boolean isVideo() {
        if (TextUtils.isEmpty(this.mimeType) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mimeType.startsWith("video") == false) goto L7;
        return true;
    }

    public String toString() {
        return "position=" + this.position + ",id=" + this.f447476id + ",path=" + this.path + ",mimeType=" + this.mimeType + ",duration=" + this.duration + ",isChecked=" + this.isChecked + ",num=" + this.num + ",pictureType=" + this.pictureType + ",width=" + this.width + ",height=" + this.height + ",size=" + this.size + ",compressPath=" + this.compressPath + ",camera=" + this.camera;
    }

    public Photo() {
        this.durationFormat = "";
        this.camera = "";
        this.isAnimatedImage = false;
    }

    public String getCamera() {
        return this.camera;
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
        return this.f447476id;
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

    public int getWidth() {
        return this.width;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public Photo(Parcel r100) {
        this.durationFormat = "";
        this.camera = "";
        boolean r101 = false;
        this.isAnimatedImage = false;
        this.position = r100.readInt();
        this.f447476id = r100.readInt();
        this.path = r100.readString();
        this.mimeType = r100.readString();
        this.duration = r100.readLong();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.isChecked = r101;
        this.num = r100.readInt();
        this.pictureType = r100.readString();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.size = r100.readLong();
        this.compressPath = r100.readString();
        this.camera = r100.readString();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        Photo r101 = (Photo) r100;
        if (this.f447476id == r101.f447476id) goto L14;
        return false;
    L14:
        if (this.duration == r101.duration) goto L17;
        return false;
    L17:
        if (Objects.equals(this.path, r101.path) == true) goto L20;
        return false;
    L20:
        return Objects.equals(this.mimeType, r101.mimeType);
    }

    public void setCamera(String r100) {
        this.camera = r100;
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

    public Photo setHeight(int r100) {
        this.height = r100;
        return this;
    }

    public void setId(int r100) {
        this.f447476id = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setNum(int r100) {
        this.num = r100;
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

    public void setWidth(int r100) {
        this.width = r100;
    }

    public Photo(Photo r100) {
        this.durationFormat = "";
        this.camera = "";
        this.isAnimatedImage = false;
        this.f447476id = r100.f447476id;
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
        this.camera = r100.camera;
    }

    public Photo(String r100) {
        this.durationFormat = "";
        this.camera = "";
        this.isAnimatedImage = false;
        this.path = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.position);
        r100.writeInt(this.f447476id);
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
        r100.writeString(this.camera);
    }

    public Photo(int r100, String r101, String r102, long r103, int r104, int r105, long r106) {
        this.durationFormat = "";
        this.camera = "";
        this.isAnimatedImage = false;
        this.f447476id = r100;
        this.path = r101;
        this.mimeType = r102;
        this.duration = r103;
        this.width = r104;
        this.height = r105;
        this.size = r106;
    }
}
