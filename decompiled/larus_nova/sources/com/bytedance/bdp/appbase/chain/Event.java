package com.bytedance.bdp.appbase.chain;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/Event;", "Lcom/bytedance/bdp/appbase/chain/NotThrowException;", "()V", "msg", "", "(Ljava/lang/String;)V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public class Event extends NotThrowException {
    public Event() {
        this("Chain Event NotThrowException");
    }

    public Event(String r100) {
        super(r100);
    }
}
