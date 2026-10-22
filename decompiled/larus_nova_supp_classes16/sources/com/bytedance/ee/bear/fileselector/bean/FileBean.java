package com.bytedance.ee.bear.fileselector.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileBean implements Serializable, Parcelable {
    public static final Parcelable.Creator<FileBean> CREATOR = null;
    private String compressPath;
    private long duration;
    private int height;
    private int id;
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
        public final FileBean createFromParcel(Parcel r2) {
            return new FileBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final FileBean[] newArray(int r1) {
            return new FileBean[r1];
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
        int r0 = this.id * 31;
        String r1 = this.path;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.mimeType;
        if (r5 == null) goto L9;
        r2 = r5.hashCode();
    L9:
        long r6 = this.duration;
        return ((r4 + r2) * 31) + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r3 = 0;
        goto L6
    }

    public boolean isVideo() {
        if (TextUtils.isEmpty(this.mimeType) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mimeType.startsWith(VideoStreamingProcessor.VideoMetaInfo.VIDEO_CODE_TYPE_VALUE) == false) goto L7;
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
        return this.id;
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

    public FileBean(Parcel r6) {
        this.position = r6.readInt();
        this.id = r6.readInt();
        this.path = r6.readString();
        this.mimeType = r6.readString();
        this.duration = r6.readLong();
        boolean r1 = true;
        if (r6.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.isChecked = r0;
        this.num = r6.readInt();
        this.pictureType = r6.readString();
        this.width = r6.readInt();
        this.height = r6.readInt();
        this.size = r6.readLong();
        this.compressPath = r6.readString();
        this.uuid = r6.readString();
        if (r6.readByte() != 0) goto L10;
        r1 = false;
    L10:
        this.isOrigin = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L31;
        FileBean r9 = (FileBean) r8;
        if (this.id == r9.id) goto L14;
        return false;
    L14:
        if (this.duration == r9.duration) goto L16;
        return false;
    L16:
        String r2 = this.path;
        if (r2 == null) goto L22;
        if (r2.equals(r9.path) == false) goto L23;
    L24:
        String r3 = this.mimeType;
        String r10 = r9.mimeType;
        if (r3 != null) goto L32;
        if (r10 == null) goto L33;
        return false;
    L33:
        return true;
    L32:
        return r3.equals(r10);
    L23:
        return false;
    L22:
        if (r9.path == null) goto L24;
        goto L23
    }

    public void setChecked(boolean r1) {
        this.isChecked = r1;
    }

    public void setCompressPath(String r1) {
        this.compressPath = r1;
    }

    public void setDuration(long r1) {
        this.duration = r1;
    }

    public FileBean setHeight(int r1) {
        this.height = r1;
        return this;
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public void setMimeType(String r1) {
        this.mimeType = r1;
    }

    public void setNum(int r1) {
        this.num = r1;
    }

    public void setOrigin(boolean r1) {
        this.isOrigin = r1;
    }

    public void setPath(String r1) {
        this.path = r1;
    }

    public void setPictureType(String r1) {
        this.pictureType = r1;
    }

    public void setPosition(int r1) {
        this.position = r1;
    }

    public void setSize(long r1) {
        this.size = r1;
    }

    public void setUuid(String r1) {
        this.uuid = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }

    public FileBean(FileBean r3) {
        this.id = r3.id;
        this.path = r3.path;
        this.mimeType = r3.mimeType;
        this.duration = r3.duration;
        this.isChecked = r3.isChecked;
        this.position = r3.position;
        this.num = r3.num;
        this.pictureType = r3.pictureType;
        this.width = r3.width;
        this.height = r3.height;
        this.size = r3.size;
        this.compressPath = r3.compressPath;
        this.uuid = r3.uuid;
        this.isOrigin = r3.isOrigin;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.position);
        r3.writeInt(this.id);
        r3.writeString(this.path);
        r3.writeString(this.mimeType);
        r3.writeLong(this.duration);
        r3.writeByte(this.isChecked ? 1 : 0);
        r3.writeInt(this.num);
        r3.writeString(this.pictureType);
        r3.writeInt(this.width);
        r3.writeInt(this.height);
        r3.writeLong(this.size);
        r3.writeString(this.compressPath);
        r3.writeString(this.uuid);
        r3.writeByte(this.isOrigin ? 1 : 0);
    }

    public FileBean(int r1, String r2, String r3, long r4, int r6, int r7, long r8) {
        this.id = r1;
        this.path = r2;
        this.mimeType = r3;
        this.duration = r4;
        this.width = r6;
        this.height = r7;
        this.size = r8;
    }
}
