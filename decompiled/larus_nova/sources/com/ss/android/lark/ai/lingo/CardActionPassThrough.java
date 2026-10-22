package com.ss.android.lark.ai.lingo;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/ai/lingo/CardActionPassThrough;", "", "entityId", "", "pinId", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEntityId", "()Ljava/lang/String;", "getPinId", "getType", "ai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardActionPassThrough {
    private final String entityId;
    private final String pinId;
    private final String type;

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getPinId() {
        return this.pinId;
    }

    public final String getType() {
        return this.type;
    }

    public CardActionPassThrough(@JSONField(name = "entityId") String r100, @JSONField(name = "pinId") String r101, @JSONField(name = "type") String r102) {
        this.entityId = r100;
        this.pinId = r101;
        this.type = r102;
    }
}
