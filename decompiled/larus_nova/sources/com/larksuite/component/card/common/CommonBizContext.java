package com.larksuite.component.card.common;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.google.gson.JsonObject;
import com.larksuite.component.card.protocol.context.BizContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larksuite/component/card/common/CommonBizContext;", "Lcom/larksuite/component/card/protocol/context/BizContext;", "bizId", "", "<init>", "(Ljava/lang/String;)V", "toJson", "Lcom/google/gson/JsonObject;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonBizContext extends BizContext {
    @Override // com.larksuite.component.card.protocol.context.BizContext
    public JsonObject toJson() {
        JsonObject r100 = new JsonObject();
        r100.addProperty(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, getBizId());
        r100.addProperty("biz_type", Integer.valueOf(getBizType().getValue()));
        return r100;
    }

    public CommonBizContext(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        super(r100, UniversalCardBizType.BIZ_TYPE_UNKNOWN);
    }
}
