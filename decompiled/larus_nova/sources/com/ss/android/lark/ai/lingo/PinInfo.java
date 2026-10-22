package com.ss.android.lark.ai.lingo;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/ai/lingo/PinInfo;", "", "abbrId", "", "requestService", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getAbbrId", "()Ljava/lang/String;", "getRequestService", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PinInfo {
    private final String abbrId;
    private final Boolean requestService;

    public final String getAbbrId() {
        return this.abbrId;
    }

    public final Boolean getRequestService() {
        return this.requestService;
    }

    public PinInfo(@JSONField(name = "abbrId") String r100, @JSONField(name = "requestService") Boolean r101) {
        this.abbrId = r100;
        this.requestService = r101;
    }
}
