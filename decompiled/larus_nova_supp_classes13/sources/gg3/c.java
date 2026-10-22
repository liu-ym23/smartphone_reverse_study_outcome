package gg3;

import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lgg3/c;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/a;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "yataResponse", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "i", "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "", "version", "I", "h", "()I", "", "firstChunk", "Z", "g", "()Z", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c extends com.bytedance.kmp.ec.yata.common.protocol.data.a {

    @SerializedName("first_chunk")
    private final boolean firstChunk;

    @SerializedName("version")
    private final int version;

    @SerializedName("yata_response")
    private final e yataResponse;

    public final boolean g() {
        return this.firstChunk;
    }

    public final int h() {
        return this.version;
    }

    public final e i() {
        return this.yataResponse;
    }

    public final boolean j() {
        return this.firstChunk;
    }

    public /* synthetic */ c(e r1, int r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 1;
    L5:
        this(r1, r2, false);
    }

    public c(e r1, int r2, boolean r3) {
        this.yataResponse = r1;
        this.version = r2;
        this.firstChunk = r3;
    }
}
