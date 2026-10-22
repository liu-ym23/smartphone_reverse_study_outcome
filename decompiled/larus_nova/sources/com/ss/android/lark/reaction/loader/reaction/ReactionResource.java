package com.ss.android.lark.reaction.loader.reaction;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionResource implements Key {
    private volatile byte[] cacheKeyBytes;
    public String reactionKey;

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

    public ReactionResource(String r100) {
        this.reactionKey = r100;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.reactionKey, ((ReactionResource) r100).reactionKey);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }
}
