package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kc6.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftTipSerializableObjectImpl;", "Lkc6/u;", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", "backgroundColor", "Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "Lpy/k;", "prefixImage", "Lpy/k;", "getPrefixImage", "()Lpy/k;", "setPrefixImage", "(Lpy/k;)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftTipSerializableObjectImpl implements u {

    @SerializedName("back_ground_color")
    private String backgroundColor;

    @SerializedName("display_text")
    private a5 displayText;

    @SerializedName("prefix_image")
    private k prefixImage;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftTipSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftTipSerializableObjectImpl.class);
        }
    }

    public GiftTipSerializableObjectImpl() {
        this.backgroundColor = "";
    }

    @Override // kc6.u
    public final void setBackgroundColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.backgroundColor = r100;
    }

    @Override // kc6.u
    public final void setDisplayText(a5 r100) {
        this.displayText = r100;
    }

    @Override // kc6.u
    public final void setPrefixImage(k r100) {
        this.prefixImage = r100;
    }
}
