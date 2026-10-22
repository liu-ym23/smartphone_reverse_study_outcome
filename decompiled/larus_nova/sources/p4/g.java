package p4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CallMcpToolResponse;", "Lcom/bytedance/ai/bridge/remote/model/BaseApiResponse;", "result", "Lcom/bytedance/ai/bridge/remote/model/CallMcpToolResponseResult;", "<init>", "(Lcom/bytedance/ai/bridge/remote/model/CallMcpToolResponseResult;)V", "getResult", "()Lcom/bytedance/ai/bridge/remote/model/CallMcpToolResponseResult;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g extends a {

    @SerializedName("result")
    private final h result;

    public g() {
        super(0);
        this.result = null;
    }

    public final h e() {
        return this.result;
    }
}
