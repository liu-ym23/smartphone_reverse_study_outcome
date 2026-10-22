package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kc6.f0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/SelectedDialogIconModelSerializableObjectImpl;", "Lkc6/f0;", "Lpy/k;", "giftIcon", "Lpy/k;", "getGiftIcon", "()Lpy/k;", "setGiftIcon", "(Lpy/k;)V", "", "giftPriceText", "Ljava/lang/String;", "getGiftPriceText", "()Ljava/lang/String;", "Q", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "bottomSendText", "Lcom/bytedance/android/live/base/model/message/a5;", "getBottomSendText", "()Lcom/bytedance/android/live/base/model/message/a5;", "x4", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", "gray", "Z", "getGray", "()Z", "p6", "(Z)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectedDialogIconModelSerializableObjectImpl implements f0 {

    @SerializedName("bottom_send_text")
    private a5 bottomSendText;

    @SerializedName("gift_icon")
    private k giftIcon;

    @SerializedName("gift_price_text")
    private String giftPriceText;

    @SerializedName("gray")
    private boolean gray;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/SelectedDialogIconModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SelectedDialogIconModelSerializableObjectImpl.class);
        }
    }

    public SelectedDialogIconModelSerializableObjectImpl() {
        this.giftPriceText = "";
    }

    @Override // kc6.f0
    public final void Q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.giftPriceText = r100;
    }

    @Override // kc6.f0
    public final void p6(boolean r100) {
        this.gray = r100;
    }

    @Override // kc6.f0
    public final void setGiftIcon(k r100) {
        this.giftIcon = r100;
    }

    @Override // kc6.f0
    public final void x4(a5 r100) {
        this.bottomSendText = r100;
    }
}
