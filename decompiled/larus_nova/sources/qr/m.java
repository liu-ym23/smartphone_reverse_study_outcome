package qr;

import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lqr/m;", "", "", "authorId", "J", "getAuthorId", "()J", "setAuthorId", "(J)V", "productId", "getProductId", "setProductId", "", "taskType", "I", "getTaskType", "()I", "setTaskType", "(I)V", "product_type", "getProduct_type", "setProduct_type", "expireSeconds", "Ljava/lang/Integer;", "getExpireSeconds", "()Ljava/lang/Integer;", "setExpireSeconds", "(Ljava/lang/Integer;)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534512a;

    @SerializedName("uid")
    private long authorId;

    @SerializedName("expire_seconds")
    private Integer expireSeconds;

    @SerializedName("product_id")
    private long productId;

    @SerializedName("product_type")
    private int product_type;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private int taskType;

    public final String toString() {
        return "LiveMsgPromotionCard(authorId=" + this.authorId + ", productId=" + this.productId + ", taskType=" + this.taskType + ", product_type=" + this.product_type + " visible = false cardSource = " + this.f534512a + ')';
    }

    public m() {
        this.taskType = -1;
        this.expireSeconds = 0;
        this.f534512a = "";
    }
}
