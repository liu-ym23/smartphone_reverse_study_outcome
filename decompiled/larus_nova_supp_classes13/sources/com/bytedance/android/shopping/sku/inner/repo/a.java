package com.bytedance.android.shopping.sku.inner.repo;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/repo/a;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/a;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "yataData", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "i", "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "setYataData", "(Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;)V", "", "bizErrorCode", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "Lhd3/d;", "serverTimings", "Lhd3/d;", "h", "()Lhd3/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends com.bytedance.kmp.ec.yata.common.protocol.data.a {

    @SerializedName("biz_error_code")
    private final String bizErrorCode;

    @SerializedName("server_timings")
    private final hd3.d serverTimings;

    @SerializedName("yata_data")
    private com.bytedance.kmp.ec.yata.common.protocol.data.c yataData;

    public a() {
        this(null, 7);
    }

    public final String g() {
        return this.bizErrorCode;
    }

    public final hd3.d h() {
        return this.serverTimings;
    }

    public final com.bytedance.kmp.ec.yata.common.protocol.data.c i() {
        return this.yataData;
    }

    public a(com.bytedance.kmp.ec.yata.common.protocol.data.c r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this.yataData = r2;
        this.bizErrorCode = null;
        this.serverTimings = null;
    }
}
