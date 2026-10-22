package com.bytedance.locallife.groupon.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/groupon/model/DiamondCardOperateInfo;", "", "operateType", "", "cardType", "", "uniqueId", GXTemplateKey.GAIAX_ANIMATION, "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getAnimation", "()Z", "getCardType", "()I", "getOperateType", "()Ljava/lang/String;", "getUniqueId", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DiamondCardOperateInfo {

    @SerializedName(GXTemplateKey.GAIAX_ANIMATION)
    private final boolean animation;

    @SerializedName(a.KEY_CARD_TYPE)
    private final int cardType;

    @SerializedName("operate_type")
    private final String operateType;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    private final String uniqueId;

    public DiamondCardOperateInfo() {
        this(null, 0, null, false, 15, null);
    }

    public final boolean getAnimation() {
        return this.animation;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final String getOperateType() {
        return this.operateType;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public DiamondCardOperateInfo(String r100, int r101, String r102, boolean r103) {
        this.operateType = r100;
        this.cardType = r101;
        this.uniqueId = r102;
        this.animation = r103;
    }

    public /* synthetic */ DiamondCardOperateInfo(String r100, int r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = true;
    L14:
        this(r100, r101, r102, r103);
    }
}
