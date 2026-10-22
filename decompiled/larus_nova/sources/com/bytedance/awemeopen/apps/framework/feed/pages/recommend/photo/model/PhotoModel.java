package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r14.y;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/model/PhotoModel;", "Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "Lr14/y;", "urlStruct", "Lr14/y;", "getUrlStruct", "()Lr14/y;", "setUrlStruct", "(Lr14/y;)V", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class PhotoModel implements Serializable {
    private y urlStruct;

    public PhotoModel() {
    }

    public int hashCode() {
        y r100 = this.urlStruct;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final y getUrlStruct() {
        return this.urlStruct;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(PhotoModel.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.PhotoModel");
        PhotoModel r102 = (PhotoModel) r100;
        if (Intrinsics.areEqual(this.urlStruct, ((PhotoModel) r100).urlStruct) == true) goto L16;
        return false;
    L16:
        return true;
    L17:
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public final void setUrlStruct(y r100) {
        this.urlStruct = r100;
    }
}
