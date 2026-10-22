package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lkc6/t;", "", "", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "showImage", "Lpy/k;", "getShowImage", "()Lpy/k;", "setShowImage", "(Lpy/k;)V", "", "locked", "Ljava/lang/Boolean;", "getLocked", "()Ljava/lang/Boolean;", "setLocked", "(Ljava/lang/Boolean;)V", "", "bottomText", "Ljava/lang/String;", "getBottomText", "()Ljava/lang/String;", "setBottomText", "(Ljava/lang/String;)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.ShowImageInfo")
public final class t {

    @SerializedName("bottom_text")
    private String bottomText;

    @SerializedName("index")
    private int index;

    @SerializedName("locked")
    private Boolean locked;

    @SerializedName("show_image")
    private py.k showImage;

    public t() {
        this(0);
    }

    public t(int r100) {
        Boolean r101 = Boolean.FALSE;
        this.index = -1;
        this.showImage = null;
        this.locked = r101;
        this.bottomText = null;
    }
}
