package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkc6/y;", "", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "selectedImage", "Lpy/k;", "getSelectedImage", "()Lpy/k;", "backgroundTop", "getBackgroundTop", "backgroundBottom", "getBackgroundBottom", "topTitle", "getTopTitle", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.PanelBackgroundInfo")
public final class y {

    @SerializedName("background_bottom")
    private final py.k backgroundBottom;

    @SerializedName("background_top")
    private final py.k backgroundTop;

    @SerializedName("selected_image")
    private final py.k selectedImage;

    @SerializedName("top_title")
    private final py.k topTitle;

    public y() {
        this(null, null, null, null);
    }

    public y(py.k r100, py.k r101, py.k r102, py.k r103) {
        this.selectedImage = r100;
        this.backgroundTop = r101;
        this.backgroundBottom = r102;
        this.topTitle = r103;
    }
}
