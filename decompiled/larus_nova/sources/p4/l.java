package p4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CreateRemoteTaskResponse;", "Lcom/bytedance/ai/bridge/remote/model/BaseApiResponse;", "data", "Lcom/bytedance/ai/bridge/remote/model/CreateRemoteTaskData;", "<init>", "(Lcom/bytedance/ai/bridge/remote/model/CreateRemoteTaskData;)V", "getData", "()Lcom/bytedance/ai/bridge/remote/model/CreateRemoteTaskData;", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l extends a {

    @SerializedName("data")
    private final j data;

    public l() {
        super(0);
        this.data = null;
    }

    @Override // p4.a
    public final String toString() {
        return "CreateRemoteTaskResponse(" + super.toString() + ", data=" + this.data + ')';
    }

    public final j e() {
        return this.data;
    }
}
