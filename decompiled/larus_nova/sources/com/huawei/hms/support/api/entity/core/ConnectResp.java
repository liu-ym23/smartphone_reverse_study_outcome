package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class ConnectResp implements IMessageEntity {

    @Packed
    public List<Integer> protocolVersion;

    @Packed
    public String sessionId;

    public String toString() {
        StringBuilder r100 = new StringBuilder("protocol version:");
        Iterator<Integer> r101 = this.protocolVersion.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.append(r101.next());
        r100.append(',');
        goto L4
    L7:
        return r100.toString();
    }

    public ConnectResp() {
        this.protocolVersion = Arrays.asList(new Integer[]{1, 2});
    }
}
