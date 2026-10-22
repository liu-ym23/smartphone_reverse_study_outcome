package com.bytedance.awemeopen.bizmodels.feed;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/ModelRate;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Hot", "NotRecommended", "CanPublish", "Fresh", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ModelRate extends Enum<ModelRate> {
    private static final /* synthetic */ ModelRate[] $VALUES = null;

    @SerializedName("11")
    public static final ModelRate CanPublish = null;

    @SerializedName("12")
    public static final ModelRate Fresh = null;

    @SerializedName("0")
    public static final ModelRate Hot = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final ModelRate NotRecommended = null;
    private final int value;

    private static final /* synthetic */ ModelRate[] $values() {
        return new ModelRate[]{Hot, NotRecommended, CanPublish, Fresh};
    }

    public static ModelRate valueOf(String r100) {
        return (ModelRate) a.a(ModelRate.class, r100);
    }

    public static ModelRate[] values() {
        return (ModelRate[]) $VALUES.clone();
    }

    static {
        Hot = new ModelRate("Hot", 0, 0);
        NotRecommended = new ModelRate("NotRecommended", 1, 10);
        CanPublish = new ModelRate("CanPublish", 2, 11);
        Fresh = new ModelRate("Fresh", 3, 12);
        $VALUES = $values();
    }

    public final int getValue() {
        return this.value;
    }

    private ModelRate(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
