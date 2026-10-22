package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/image/entity/AlbumSerialImage;", "Lcom/bumptech/glide/load/Key;", "Ljava/io/Serializable;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "imageID", "getImageID", "imageID$delegate", "Lkotlin/Lazy;", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "toString", "equals", "", "other", "", "hashCode", "", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumSerialImage implements Key, Serializable {
    private final Lazy imageID$delegate;
    private final String path;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{getImageID()});
    }

    private final String getImageID() {
        return (String) this.imageID$delegate.getValue();
    }

    public String toString() {
        return getImageID();
    }

    public final String getPath() {
        return this.path;
    }

    public AlbumSerialImage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.path = r100;
        this.imageID$delegate = LazyKt.lazy(new AlbumSerialImage$imageID$2(this));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlbumSerialImage) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(getImageID(), ((AlbumSerialImage) r100).getImageID());
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Intrinsics.checkNotNullParameter(r100, "messageDigest");
        r100.update(getImageID().getBytes(Key.CHARSET));
    }
}
