package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kc6.h;
import kc6.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/DefaultDialogIconModelSerializableObjectImpl;", "Lkc6/h;", "Lpy/k;", "giftIcon", "Lpy/k;", "getGiftIcon", "()Lpy/k;", "setGiftIcon", "(Lpy/k;)V", "", "giftName", "Ljava/lang/String;", "getGiftName", "()Ljava/lang/String;", "setGiftName", "(Ljava/lang/String;)V", "giftPriceText", "getGiftPriceText", "Q", "topLeftLabel", "getTopLeftLabel", "b7", "Lkc6/u;", "centerLabel", "Lkc6/u;", "getCenterLabel", "()Lkc6/u;", "T3", "(Lkc6/u;)V", "lockStatus", "getLockStatus", "t8", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DefaultDialogIconModelSerializableObjectImpl implements h {

    @SerializedName("center_label")
    private u centerLabel;

    @SerializedName("gift_icon")
    private k giftIcon;

    @SerializedName("gift_name")
    private String giftName;

    @SerializedName("gift_price_text")
    private String giftPriceText;

    @SerializedName("lock_status")
    private String lockStatus;

    @SerializedName("top_left_label")
    private k topLeftLabel;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/DefaultDialogIconModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(DefaultDialogIconModelSerializableObjectImpl.class);
        }
    }

    public DefaultDialogIconModelSerializableObjectImpl() {
        this.giftName = "";
        this.giftPriceText = "";
        this.lockStatus = "";
    }

    @Override // kc6.h
    public final void Q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.giftPriceText = r100;
    }

    @Override // kc6.h
    public final void T3(u r100) {
        this.centerLabel = r100;
    }

    @Override // kc6.h
    public final void b7(k r100) {
        this.topLeftLabel = r100;
    }

    @Override // kc6.h
    public final void setGiftIcon(k r100) {
        this.giftIcon = r100;
    }

    @Override // kc6.h
    public final void setGiftName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.giftName = r100;
    }

    @Override // kc6.h
    public final void t8(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lockStatus = r100;
    }
}
