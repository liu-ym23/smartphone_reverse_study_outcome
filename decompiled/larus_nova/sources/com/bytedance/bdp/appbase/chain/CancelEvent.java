package com.bytedance.bdp.appbase.chain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/CancelEvent;", "Lcom/bytedance/bdp/appbase/chain/NotThrowException;", "msg", "", "(Ljava/lang/String;)V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class CancelEvent extends NotThrowException {
    /* JADX WARN: Multi-variable type inference failed */
    public CancelEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CancelEvent(String r100) {
        super(r100);
    }

    public /* synthetic */ CancelEvent(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "Canceled";
    L5:
        this(r100);
    }
}
