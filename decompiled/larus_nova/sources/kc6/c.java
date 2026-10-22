package kc6;

import com.bytedance.locallife.groupon.struct.bubble.model.ElementGuideBubbleStruct;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lkc6/c;", "", "", "iconText", "Ljava/lang/String;", "getIconText", "()Ljava/lang/String;", "bubbleText", "getBubbleText", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.CashExchangeInfo")
public final class c {

    @SerializedName("bubble_text")
    private final String bubbleText;

    @SerializedName(ElementGuideBubbleStruct.STYLE_ICON_TEXT_BUBBLE)
    private final String iconText;

    public c() {
        Intrinsics.checkNotNullParameter("", "iconText");
        Intrinsics.checkNotNullParameter("", "bubbleText");
        this.iconText = "";
        this.bubbleText = "";
    }
}
