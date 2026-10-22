package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.android.livesdk.gift.model.h0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kc6.d0;
import kc6.f0;
import kc6.h;
import kc6.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\bF\u0010GR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00101\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b1\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010 \u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR(\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010(\u001a\u0004\bD\u0010*\"\u0004\bE\u0010,¨\u0006I"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/DialogIconSerializableObjectImpl;", "Lkc6/i;", "", "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "", "bannerSchemeUrl", "Ljava/lang/String;", "getBannerSchemeUrl", "()Ljava/lang/String;", "z0", "(Ljava/lang/String;)V", "Lkc6/h;", "defaultDialogIconModel", "Lkc6/h;", "getDefaultDialogIconModel", "()Lkc6/h;", "x5", "(Lkc6/h;)V", "Lkc6/f0;", "selectedDialogIconModel", "Lkc6/f0;", "getSelectedDialogIconModel", "()Lkc6/f0;", "h6", "(Lkc6/f0;)V", "", "diamondCount", "I", "getDiamondCount", "()I", "setDiamondCount", "(I)V", "", "Lcom/bytedance/android/livesdk/gift/model/h0;", "giftGroupList", "Ljava/util/List;", "getGiftGroupList", "()Ljava/util/List;", "setGiftGroupList", "(Ljava/util/List;)V", "selectedDynamicEffect", "getSelectedDynamicEffect", "setSelectedDynamicEffect", "", "isProp", "Z", "()Z", "n5", "(Z)V", "Lkc6/d0;", "propInfo", "Lkc6/d0;", "getPropInfo", "()Lkc6/d0;", "l1", "(Lkc6/d0;)V", "giftType", "getGiftType", "i1", "primaryEffectId", "getPrimaryEffectId", "setPrimaryEffectId", "assetIds", "getAssetIds", "setAssetIds", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DialogIconSerializableObjectImpl implements i {

    @SerializedName("asset_ids")
    private List<Long> assetIds;

    @SerializedName("banner_scheme_url")
    private String bannerSchemeUrl;

    @SerializedName("default_gift_icon")
    private h defaultDialogIconModel;

    @SerializedName("diamond_count")
    private int diamondCount;

    @SerializedName("group_info")
    private List<? extends h0> giftGroupList;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    private long giftId;

    @SerializedName("gift_type")
    private int giftType;

    @SerializedName("is_prop")
    private boolean isProp;

    @SerializedName("primary_effect_id")
    private long primaryEffectId;

    @SerializedName("prop_info")
    private d0 propInfo;

    @SerializedName("selected_gift_icon")
    private f0 selectedDialogIconModel;

    @SerializedName("selected_dynamic_effect")
    private long selectedDynamicEffect;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/DialogIconSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(DialogIconSerializableObjectImpl.class);
        }
    }

    public DialogIconSerializableObjectImpl() {
        this.defaultDialogIconModel = (h) d.c(h.class);
        this.selectedDialogIconModel = (f0) d.c(f0.class);
        this.giftGroupList = d.a();
        this.assetIds = d.a();
    }

    @Override // kc6.i
    public final long getGiftId() {
        return this.giftId;
    }

    @Override // kc6.i
    public final void h6(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectedDialogIconModel = r100;
    }

    @Override // kc6.i
    public final void i1(int r100) {
        this.giftType = r100;
    }

    @Override // kc6.i
    public final void l1(d0 r100) {
        this.propInfo = r100;
    }

    @Override // kc6.i
    public final void n5(boolean r100) {
        this.isProp = r100;
    }

    @Override // kc6.i
    public final void setAssetIds(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.assetIds = r100;
    }

    @Override // kc6.i
    public final void setDiamondCount(int r100) {
        this.diamondCount = r100;
    }

    @Override // kc6.i
    public final void setGiftGroupList(List<? extends h0> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.giftGroupList = r100;
    }

    @Override // kc6.i
    public final void setGiftId(long r100) {
        this.giftId = r100;
    }

    @Override // kc6.i
    public final void setPrimaryEffectId(long r100) {
        this.primaryEffectId = r100;
    }

    @Override // kc6.i
    public final void setSelectedDynamicEffect(long r100) {
        this.selectedDynamicEffect = r100;
    }

    @Override // kc6.i
    public final void x5(h r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.defaultDialogIconModel = r100;
    }

    @Override // kc6.i
    public final void z0(String r100) {
        this.bannerSchemeUrl = r100;
    }
}
