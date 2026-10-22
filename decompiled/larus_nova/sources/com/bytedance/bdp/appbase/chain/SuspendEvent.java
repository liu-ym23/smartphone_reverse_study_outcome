package com.bytedance.bdp.appbase.chain;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/SuspendEvent;", "Lcom/bytedance/bdp/appbase/chain/NotThrowException;", "Lcom/bytedance/bdp/appbase/chain/f0;", "puppetValue", "Lcom/bytedance/bdp/appbase/chain/f0;", "getPuppetValue", "()Lcom/bytedance/bdp/appbase/chain/f0;", "<init>", "(Lcom/bytedance/bdp/appbase/chain/f0;)V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class SuspendEvent extends NotThrowException {
    private final f0<?> puppetValue;

    public final f0<?> getPuppetValue() {
        return this.puppetValue;
    }

    public SuspendEvent(f0<?> r100) {
        super("suspend");
        this.puppetValue = r100;
    }
}
