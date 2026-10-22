package com.ss.android.lark.image.entity;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public class EncryptImage implements Key, Serializable {
    private static final int DRAFT_RESOURCE_SOURCE_UNKNOWN = 0;
    private volatile transient byte[] cacheKeyBytes;
    private String contextId;
    private final long createTime;
    private ByteString crypto;
    private long decodeStartTime;
    private long decryptTime;
    private int draftResourceSource;
    private final String encryptKey;
    private transient ErrorResult errorResult;
    private String formatHeader;
    private String fsUnit;
    private String imageType;
    private boolean needCollectTrace;
    private String resourceHash;
    private long resourceSize;
    private boolean storeToPrivatePath;
    private transient Trace trace;
    private long waitTime;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{this.encryptKey, Boolean.valueOf(this.storeToPrivatePath)});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.encryptKey.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public Map<String, Object> getLatencyDetail() {
        HashMap r100 = new HashMap();
        Trace r101 = this.trace;
        if (r101 == null) goto L17;
        Iterator<Trace.Span> r102 = r101.spans.iterator();
    L6:
        if (r102.hasNext() == false) goto L17;
        Trace.Span r103 = r102.next();
        if (TextUtils.isEmpty(r103.name) == true) goto L6;
        Long r104 = r103.duration_millis;
        if (r104 == null) goto L6;
        r100.put(r103.name, r104);
        Map<String, String> r105 = r103.attributes;
        if (r105 == null) goto L6;
        if (r105.size() <= 0) goto L6;
        r100.putAll(r103.attributes);
    L17:
        return r100;
    }

    public String toString() {
        return "EncryptImage#key is:" + this.encryptKey;
    }

    public String getContextId() {
        return this.contextId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public ByteString getCrypto() {
        return this.crypto;
    }

    public long getDecodeStartTime() {
        return this.decodeStartTime;
    }

    public long getDecryptTime() {
        return this.decryptTime;
    }

    public int getDraftResourceSource() {
        return this.draftResourceSource;
    }

    public String getEncryptKey() {
        return this.encryptKey;
    }

    public ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public String getFormatHeader() {
        return this.formatHeader;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public String getImageType() {
        return this.imageType;
    }

    public String getResourceHash() {
        return this.resourceHash;
    }

    public long getResourceSize() {
        return this.resourceSize;
    }

    public Trace getTrace() {
        return this.trace;
    }

    public long getWaitTime() {
        return this.waitTime;
    }

    public boolean isNeedCollectTrace() {
        return this.needCollectTrace;
    }

    public boolean storeToPrivatePath() {
        return this.storeToPrivatePath;
    }

    public EncryptImage(String r100) {
        this.needCollectTrace = true;
        this.decryptTime = -1;
        this.draftResourceSource = 0;
        this.encryptKey = r100;
        this.createTime = System.currentTimeMillis();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EncryptImage) == true) goto L8;
        return false;
    L8:
        EncryptImage r101 = (EncryptImage) r100;
        if (this.storeToPrivatePath == r101.storeToPrivatePath) goto L11;
    L13:
        return false;
    L11:
        if (this.encryptKey.equals(r101.encryptKey) == false) goto L13;
        return true;
    }

    public void setContextId(String r100) {
        this.contextId = r100;
    }

    public void setCrypto(ByteString r100) {
        this.crypto = r100;
    }

    public void setDecodeStartTime(long r100) {
        this.decodeStartTime = r100;
    }

    public void setDecryptTime(long r100) {
        this.decryptTime = r100;
    }

    public void setDraftResourceSource(int r100) {
        this.draftResourceSource = r100;
    }

    public void setErrorResult(ErrorResult r100) {
        this.errorResult = r100;
    }

    public void setFormatHeader(String r100) {
        this.formatHeader = r100;
    }

    public void setFsUnit(String r100) {
        this.fsUnit = r100;
    }

    public void setImageType(String r100) {
        this.imageType = r100;
    }

    public void setNeedCollectTrace(boolean r100) {
        this.needCollectTrace = r100;
    }

    public void setResourceHash(String r100) {
        this.resourceHash = r100;
    }

    public void setResourceSize(long r100) {
        this.resourceSize = r100;
    }

    public void setStoreToPrivatePath(boolean r100) {
        this.storeToPrivatePath = r100;
    }

    public void setTrace(Trace r100) {
        this.trace = r100;
    }

    public void setWaitTime(long r100) {
        this.waitTime = r100;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }

    public EncryptImage(Image r100) {
        this(r100.getKey(), r100.getFsUnit(), r100.getCrypto());
    }

    public EncryptImage(String r100, ImageSet r101) {
        this(r100);
        if (r101 == null) goto L23;
        com.bytedance.lark.pb.basic.v1.Image r102 = r101.origin;
        if (r102 == null) goto L7;
        this.fsUnit = r102.fs_unit;
        this.crypto = r102.crypto;
        return;
    L7:
        com.bytedance.lark.pb.basic.v1.Image r103 = r101.middle_webp;
        if (r103 == null) goto L11;
        this.fsUnit = r103.fs_unit;
        this.crypto = r103.crypto;
        return;
    L11:
        com.bytedance.lark.pb.basic.v1.Image r104 = r101.middle;
        if (r104 == null) goto L15;
        this.fsUnit = r104.fs_unit;
        this.crypto = r104.crypto;
        return;
    L15:
        com.bytedance.lark.pb.basic.v1.Image r105 = r101.thumbnail_webp;
        if (r105 == null) goto L19;
        this.fsUnit = r105.fs_unit;
        this.crypto = r105.crypto;
        return;
    L19:
        com.bytedance.lark.pb.basic.v1.Image r106 = r101.thumbnail;
        if (r106 == null) goto L25;
        this.fsUnit = r106.fs_unit;
        this.crypto = r106.crypto;
        return;
    L25:
        return;
    }

    public EncryptImage(String r100, String r101, ByteString r102) {
        this.needCollectTrace = true;
        this.decryptTime = -1;
        this.draftResourceSource = 0;
        this.encryptKey = r100;
        this.fsUnit = r101;
        this.crypto = r102;
        this.createTime = System.currentTimeMillis();
    }
}
