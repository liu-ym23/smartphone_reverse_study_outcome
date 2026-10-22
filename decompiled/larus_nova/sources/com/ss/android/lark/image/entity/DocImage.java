package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public class DocImage implements Key, Serializable {
    private volatile byte[] cacheKeyBytes;
    private ErrorResult errorResult;
    private String token;
    private Trace trace;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{this.token});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.token.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public String getToken() {
        return this.token;
    }

    public Trace getTrace() {
        return this.trace;
    }

    public DocImage(String r100) {
        init(r100);
    }

    private void init(String r100) {
        this.token = r100;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocImage) == true) goto L10;
        return false;
    L10:
        return Objects.equals(this.token, ((DocImage) r100).token);
    }

    public void setErrorResult(ErrorResult r100) {
        this.errorResult = r100;
    }

    public void setTrace(Trace r100) {
        this.trace = r100;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }
}
