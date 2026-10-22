package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/WelfareCorpLabelDTO;", "Ljava/io/Serializable;", "()V", "welfareCorpLabelLiving", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "getWelfareCorpLabelLiving", "()Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "setWelfareCorpLabelLiving", "(Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;)V", "welfareCorpLabelNormal", "getWelfareCorpLabelNormal", "setWelfareCorpLabelNormal", "welfareCorpLabelReal", "getWelfareCorpLabelReal", "setWelfareCorpLabelReal", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareCorpLabelDTO implements Serializable {

    @SerializedName("welfare_corp_label_living")
    private ECTagListDTO welfareCorpLabelLiving;

    @SerializedName("welfare_corp_label_normal")
    private ECTagListDTO welfareCorpLabelNormal;
    private ECTagListDTO welfareCorpLabelReal;

    public WelfareCorpLabelDTO() {
    }

    public final ECTagListDTO getWelfareCorpLabelLiving() {
        return this.welfareCorpLabelLiving;
    }

    public final ECTagListDTO getWelfareCorpLabelNormal() {
        return this.welfareCorpLabelNormal;
    }

    public final ECTagListDTO getWelfareCorpLabelReal() {
        return this.welfareCorpLabelReal;
    }

    public final void setWelfareCorpLabelLiving(ECTagListDTO r1) {
        this.welfareCorpLabelLiving = r1;
    }

    public final void setWelfareCorpLabelNormal(ECTagListDTO r1) {
        this.welfareCorpLabelNormal = r1;
    }

    public final void setWelfareCorpLabelReal(ECTagListDTO r1) {
        this.welfareCorpLabelReal = r1;
    }
}
