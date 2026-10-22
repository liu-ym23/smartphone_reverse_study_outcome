package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u00011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/i;", "", "", "msg_id", "Ljava/lang/String;", "getMsg_id", "()Ljava/lang/String;", "setMsg_id", "(Ljava/lang/String;)V", "", "action", "Ljava/lang/Integer;", "getAction", "()Ljava/lang/Integer;", "setAction", "(Ljava/lang/Integer;)V", "type", "getType", "setType", "", InvRouter.SCENES, "Ljava/util/List;", "getScenes", "()Ljava/util/List;", "setScenes", "(Ljava/util/List;)V", "forceRefresh", "getForceRefresh", "setForceRefresh", "cardType", "getCardType", "setCardType", "refreshData", "getRefreshData", "setRefreshData", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "Ljava/lang/Long;", "getExpireTime", "()Ljava/lang/Long;", "setExpireTime", "(Ljava/lang/Long;)V", "Lcom/bytedance/locallife/groupon/struct/j;", "updateData", "Lcom/bytedance/locallife/groupon/struct/j;", "getUpdateData", "()Lcom/bytedance/locallife/groupon/struct/j;", "setUpdateData", "(Lcom/bytedance/locallife/groupon/struct/j;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("action")
    private Integer action;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private Integer cardType;

    @SerializedName("expire_time")
    private Long expireTime;

    @SerializedName("force_refresh")
    private Integer forceRefresh;

    @SerializedName("msg_id")
    private String msg_id;

    @SerializedName("refresh_data")
    private String refreshData;

    @SerializedName(InvRouter.SCENES)
    private List<Integer> scenes;

    @SerializedName("type")
    private Integer type;

    @SerializedName("update_data")
    private j updateData;

    public static final class a {
    }

    static {
    }

    public i() {
        this.msg_id = null;
        this.action = null;
        this.type = -1;
        this.scenes = null;
        this.forceRefresh = null;
        this.cardType = null;
        this.refreshData = null;
        this.expireTime = null;
        this.updateData = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.msg_id, r101.msg_id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scenes, r101.scenes) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.forceRefresh, r101.forceRefresh) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cardType, r101.cardType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.refreshData, r101.refreshData) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.expireTime, r101.expireTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.updateData, r101.updateData) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.msg_id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.action;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.type;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Integer> r110 = this.scenes;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.forceRefresh;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.cardType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.refreshData;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.expireTime;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        j r125 = this.updateData;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RefreshStruct(msg_id=" + this.msg_id + ", action=" + this.action + ", type=" + this.type + ", scenes=" + this.scenes + ", forceRefresh=" + this.forceRefresh + ", cardType=" + this.cardType + ", refreshData=" + this.refreshData + ", expireTime=" + this.expireTime + ", updateData=" + this.updateData + ')';
    }

    public final Integer getType() {
        return this.type;
    }
}
