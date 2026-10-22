package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/a;", "", "", "", "annieXBatchFlowBlockList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setAnnieXBatchFlowBlockList", "(Ljava/util/List;)V", "annieXBatchFlowWhiteList", "b", "setAnnieXBatchFlowWhiteList", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("anniex_batch_flow_block_list")
    private List<String> annieXBatchFlowBlockList;

    @SerializedName("anniex_batch_flow_white_list")
    private List<String> annieXBatchFlowWhiteList;

    public a() {
        this.annieXBatchFlowBlockList = CollectionsKt.emptyList();
        this.annieXBatchFlowWhiteList = CollectionsKt.emptyList();
    }

    public final List<String> a() {
        return this.annieXBatchFlowBlockList;
    }

    public final List<String> b() {
        return this.annieXBatchFlowWhiteList;
    }
}
