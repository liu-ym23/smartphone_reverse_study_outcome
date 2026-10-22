package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/a;", "", "", "statusCode", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "d", "(Ljava/lang/Integer;)V", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "successToast", "c", "f", "<init>", "()V", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient List<v96.k> f251550a;

    @SerializedName("status_code")
    private Integer statusCode;

    @SerializedName("status_msg")
    private String statusMsg;

    @SerializedName("success_toast")
    private String successToast;

    public a() {
    }

    public final Integer a() {
        return this.statusCode;
    }

    public final String b() {
        return this.statusMsg;
    }

    public final String c() {
        return this.successToast;
    }

    public final void d(Integer r100) {
        this.statusCode = r100;
    }

    public final void e(String r100) {
        this.statusMsg = r100;
    }

    public final void f(String r100) {
        this.successToast = r100;
    }
}
