package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kc6.a0;
import kc6.g;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b>\u0010?R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR$\u0010(\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b2\u0010\u0016\u001a\u0004\b3\u0010\u0018R\u001a\u00105\u001a\u0002048\u0006X\u0087D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u0010:\u001a\u0002098\u0006X\u0087D¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftDIYCardModelSerializableObjectImpl;", "Lkc6/n;", "Lpy/k;", n.KEY_ICON_IMG, "Lpy/k;", "getIconImg", "()Lpy/k;", "setIconImg", "(Lpy/k;)V", n.KEY_GIFT_DESCRIBE_IMG, "getGiftDescribeImg", "setGiftDescribeImg", "", "Lkc6/a0;", n.KEY_PLUGINS, "Ljava/util/List;", "y", "()Ljava/util/List;", "setPlugins", "(Ljava/util/List;)V", "", n.KEY_TOTAL_DIAMONDS, "J", "getTotalDiamonds", "()J", "setTotalDiamonds", "(J)V", "giftCellIcon", "getGiftCellIcon", "setGiftCellIcon", "", "cardName", "Ljava/lang/String;", "getCardName", "()Ljava/lang/String;", "setCardName", "(Ljava/lang/String;)V", "configId", "getConfigId", "setConfigId", "configIdStr", "getConfigIdStr", "setConfigIdStr", "Lkc6/g;", "lockInfo", "Lkc6/g;", "getLockInfo", "()Lkc6/g;", "setLockInfo", "(Lkc6/g;)V", "defaultChose", "getDefaultChose", "", "cardType", "I", "getCardType", "()I", "", "notCache", "Z", "getNotCache", "()Z", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftDIYCardModelSerializableObjectImpl implements kc6.n {

    @SerializedName("card_name")
    private String cardName;

    @SerializedName(a.KEY_CARD_TYPE)
    private final int cardType;

    @SerializedName("config_id")
    private long configId;

    @SerializedName("config_id_str")
    private String configIdStr;

    @SerializedName("default_chose_action")
    private final long defaultChose;

    @SerializedName("gift_cell_icon")
    private k giftCellIcon;

    @SerializedName("gift_describe_img")
    private k giftDescribeImg;

    @SerializedName("icon_img")
    private k iconImg;

    @SerializedName("lock_info")
    private g lockInfo;

    @SerializedName("not_cache")
    private final boolean notCache;

    @SerializedName(n.KEY_PLUGINS)
    private List<? extends a0> plugins;

    @SerializedName("total_diamonds")
    private long totalDiamonds;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftDIYCardModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftDIYCardModelSerializableObjectImpl.class);
        }
    }

    public GiftDIYCardModelSerializableObjectImpl() {
        this.plugins = d.a();
    }

    @Override // kc6.n
    public final String getCardName() {
        return this.cardName;
    }

    @Override // kc6.n
    public final long getConfigId() {
        return this.configId;
    }

    @Override // kc6.n
    public final String getConfigIdStr() {
        return this.configIdStr;
    }

    @Override // kc6.n
    public final List<a0> y() {
        return this.plugins;
    }

    @Override // kc6.n
    public final void setConfigId(long r100) {
        this.configId = r100;
    }

    @Override // kc6.n
    public final void setConfigIdStr(String r100) {
        this.configIdStr = r100;
    }
}
