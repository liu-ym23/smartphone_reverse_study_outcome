package com.bytedance.kmp.ec.yata.common.patch;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR0\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0004\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/patch/BasePatchException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "detail", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "patchInfo", "", "", "Lcom/bytedance/kmp/ec/yata/common/patch/PatchInfo;", "getPatchInfo", "()Ljava/util/Map;", "setPatchInfo", "(Ljava/util/Map;)V", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public class BasePatchException extends Exception {
    private final String detail;
    private Map<String, Object> patchInfo;

    public final String getDetail() {
        return this.detail;
    }

    public final Map<String, Object> getPatchInfo() {
        return this.patchInfo;
    }

    public final void setPatchInfo(Map<String, Object> r100) {
        this.patchInfo = r100;
    }

    public BasePatchException(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "detail");
        Intrinsics.checkNotNullParameter(r101, "message");
        super(r101);
        this.detail = r100;
    }
}
