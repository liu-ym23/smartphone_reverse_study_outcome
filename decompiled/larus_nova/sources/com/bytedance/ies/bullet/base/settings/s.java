package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/s;", "", "", "enableUploadLynxSignFailedFile", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnableUploadLynxSignFailedFile", "(Z)V", "", "", "uploadLynxVerifyCodeList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setUploadLynxVerifyCodeList", "(Ljava/util/List;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("enable_upload_lynx_sign_failed_file")
    private boolean enableUploadLynxSignFailedFile;

    @SerializedName("upload_lynx_verify_code")
    private List<Integer> uploadLynxVerifyCodeList;

    public s() {
        this.uploadLynxVerifyCodeList = CollectionsKt.listOf(new Integer[]{-1, 104});
    }

    public final boolean a() {
        return this.enableUploadLynxSignFailedFile;
    }

    public final List<Integer> b() {
        return this.uploadLynxVerifyCodeList;
    }
}
