package com.bytedance.ee.bear.bitable.card.model.stmodel.cell;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Objects;

/* JADX INFO: loaded from: classes15.dex */
public class AttachmentEntity implements NonProguard, Cloneable {
    private String attachmentToken;
    private String availableLocalPath;
    private int category;
    private String extra;
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f207126id;
    private String mimeType;
    private String mountNodeToken;
    private String mountPointType;
    private String name;
    private long size;
    public transient boolean userLocalPathRender;
    private int width;

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.category), this.attachmentToken, this.name, this.f207126id, this.mountPointType, this.mountNodeToken, this.mimeType, Long.valueOf(this.size), Integer.valueOf(this.width), Integer.valueOf(this.height), this.extra, this.availableLocalPath});
    }

    public AttachmentEntity toSetRecordEntity() {
        return new AttachmentEntity(this.category, this.attachmentToken, this.name, this.f207126id, null, null, this.mimeType, this.size, this.width, this.height, this.extra);
    }

    public AttachmentEntity() {
        this.userLocalPathRender = false;
    }

    public AttachmentEntity clone() throws CloneNotSupportedException {
        return (AttachmentEntity) super.clone();
    }

    public String getAttachmentToken() {
        return this.attachmentToken;
    }

    public String getAvailableLocalPath() {
        return this.availableLocalPath;
    }

    public int getCategory() {
        return this.category;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f207126id;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getMountNodeToken() {
        return this.mountNodeToken;
    }

    public String getMountPointType() {
        return this.mountPointType;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8307clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttachmentEntity) == true) goto L8;
        return false;
    L8:
        AttachmentEntity r101 = (AttachmentEntity) r100;
        if (this.category == r101.category) goto L11;
    L33:
        return false;
    L11:
        if (this.size != r101.size) goto L33;
        if (this.width != r101.width) goto L33;
        if (this.height != r101.height) goto L33;
        if (TextUtils.equals(this.attachmentToken, r101.attachmentToken) == false) goto L33;
        if (TextUtils.equals(this.name, r101.name) == false) goto L33;
        if (TextUtils.equals(this.f207126id, r101.f207126id) == false) goto L33;
        if (TextUtils.equals(this.mountPointType, r101.mountPointType) == false) goto L33;
        if (TextUtils.equals(this.mountNodeToken, r101.mountNodeToken) == false) goto L33;
        if (TextUtils.equals(this.mimeType, r101.mimeType) == false) goto L33;
        if (TextUtils.equals(this.extra, r101.extra) == false) goto L33;
        if (TextUtils.equals(this.availableLocalPath, r101.availableLocalPath) == false) goto L33;
        return true;
    }

    public void setAttachmentToken(String r100) {
        this.attachmentToken = r100;
    }

    public void setAvailableLocalPath(String r100) {
        this.availableLocalPath = r100;
    }

    public void setCategory(int r100) {
        this.category = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setId(String r100) {
        this.f207126id = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setMountNodeToken(String r100) {
        this.mountNodeToken = r100;
    }

    public void setMountPointType(String r100) {
        this.mountPointType = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    @JSONCreator
    public AttachmentEntity(@JSONField(name = "category") int r100, @JSONField(name = "attachmentToken") String r101, @JSONField(name = "name") String r102, @JSONField(name = "id") String r103, @JSONField(name = "mountPointType") String r104, @JSONField(name = "mountNodeToken") String r105, @JSONField(name = DBDefinition.MIME_TYPE) String r106, @JSONField(name = "size") long r107, @JSONField(name = "width") int r110, @JSONField(name = "height") int r111, @JSONField(name = "extra") String r112) {
        this.userLocalPathRender = false;
        this.category = r100;
        this.attachmentToken = r101;
        this.name = r102;
        this.f207126id = r103;
        this.mountPointType = r104;
        this.mountNodeToken = r105;
        this.mimeType = r106;
        this.size = r107;
        this.width = r110;
        this.height = r111;
        this.extra = r112;
    }
}
