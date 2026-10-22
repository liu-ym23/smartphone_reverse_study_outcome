package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.SerCrypto;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public class PassThroughImage implements Key, Serializable {
    private volatile byte[] cacheKeyBytes;
    private SerCrypto crypto;
    private ErrorResult errorResult;
    private ImageSetPassThrough.FileType fileType;
    private String fsUnit;
    private String imageKey;
    private String imageType;
    private long resourceSize;
    private transient Trace trace;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{this.imageKey, this.fsUnit});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.imageKey.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public String toString() {
        return "PassThroughImage{imageKey='" + this.imageKey + "'}";
    }

    public SerCrypto getCrypto() {
        return this.crypto;
    }

    public ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public ImageSetPassThrough.FileType getFileType() {
        return this.fileType;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public String getImageKey() {
        return this.imageKey;
    }

    public String getImageType() {
        return this.imageType;
    }

    public long getResourceSize() {
        return this.resourceSize;
    }

    public Trace getTrace() {
        return this.trace;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PassThroughImage) == true) goto L8;
        return false;
    L8:
        PassThroughImage r101 = (PassThroughImage) r100;
        if (Objects.equals(this.imageKey, r101.imageKey) == true) goto L11;
    L13:
        return false;
    L11:
        if (Objects.equals(this.fsUnit, r101.fsUnit) == false) goto L13;
        return true;
    }

    public void setErrorResult(ErrorResult r100) {
        this.errorResult = r100;
    }

    public void setImageType(String r100) {
        this.imageType = r100;
    }

    public void setResourceSize(long r100) {
        this.resourceSize = r100;
    }

    public void setTrace(Trace r100) {
        this.trace = r100;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }

    public PassThroughImage(String r100, String r101) {
        init(r100, r101, null, null);
    }

    public PassThroughImage(String r100, String r101, SerCrypto r102) {
        init(r100, r101, r102, null);
    }

    public PassThroughImage(String r100, String r101, SerCrypto r102, ImageSetPassThrough.FileType r103) {
        init(r100, r101, r102, r103);
    }

    private void init(String r100, String r101, SerCrypto r102, ImageSetPassThrough.FileType r103) {
        this.imageKey = r100;
        this.fsUnit = r101;
        this.crypto = r102;
        this.fileType = r103;
    }
}
