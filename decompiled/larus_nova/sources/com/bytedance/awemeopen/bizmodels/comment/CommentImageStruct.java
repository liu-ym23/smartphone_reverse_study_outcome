package com.bytedance.awemeopen.bizmodels.comment;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import t14.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/comment/CommentImageStruct;", "Ljava/io/Serializable;", "Lt14/a;", "originUrl", "Lt14/a;", "getOriginUrl", "()Lt14/a;", "setOriginUrl", "(Lt14/a;)V", "cropUrl", "getCropUrl", "setCropUrl", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getUploadProgress", "()I", "setUploadProgress", "(I)V", "uploadProgress", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class CommentImageStruct implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f198169a;

    @SerializedName("crop_url")
    private a cropUrl;

    @SerializedName("origin_url")
    private a originUrl;

    public CommentImageStruct() {
        this.f198169a = 100;
    }

    public final a getCropUrl() {
        return this.cropUrl;
    }

    public final a getOriginUrl() {
        return this.originUrl;
    }

    public final int getUploadProgress() {
        return this.f198169a;
    }

    public final void setCropUrl(a r100) {
        this.cropUrl = r100;
    }

    public final void setOriginUrl(a r100) {
        this.originUrl = r100;
    }

    public final void setUploadProgress(int r100) {
        this.f198169a = r100;
    }
}
