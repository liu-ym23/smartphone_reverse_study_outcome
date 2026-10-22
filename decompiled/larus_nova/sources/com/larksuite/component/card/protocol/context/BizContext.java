package com.larksuite.component.card.protocol.context;

import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.google.gson.JsonObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/protocol/context/BizContext;", "Ljava/io/Serializable;", "bizId", "", "bizType", "Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;", "<init>", "(Ljava/lang/String;Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;)V", "getBizId", "()Ljava/lang/String;", "getBizType", "()Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;", "toJson", "Lcom/google/gson/JsonObject;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BizContext implements Serializable {
    private final String bizId;
    private final UniversalCardBizType bizType;

    public abstract JsonObject toJson();

    public final String getBizId() {
        return this.bizId;
    }

    public final UniversalCardBizType getBizType() {
        return this.bizType;
    }

    public BizContext(String r100, UniversalCardBizType r101) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "bizType");
        this.bizId = r100;
        this.bizType = r101;
    }
}
