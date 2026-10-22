package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public class ReactionImage implements Key, Serializable {
    private volatile byte[] cacheKeyBytes;
    private String reactionKey;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{this.reactionKey});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.reactionKey.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public String toString() {
        return "Reaction#key is:" + this.reactionKey;
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public ReactionImage(String r100) {
        this.reactionKey = r100;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReactionImage) == true) goto L10;
        return false;
    L10:
        return Objects.equals(this.reactionKey, ((ReactionImage) r100).reactionKey);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }
}
