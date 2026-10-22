package com.bytedance.ies.argus.plugin;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/plugin/a;", "", "", "verifyMode", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setVerifyMode", "(Ljava/lang/Integer;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class a {

    @SerializedName("verify_mode")
    private Integer verifyMode;

    public a() {
        this.verifyMode = 2;
    }

    public final Integer a() {
        return this.verifyMode;
    }
}
