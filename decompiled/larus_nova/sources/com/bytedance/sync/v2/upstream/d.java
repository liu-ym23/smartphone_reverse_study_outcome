package com.bytedance.sync.v2.upstream;

import com.bytedance.sync.v2.protocal.BsyncHeader;
import com.bytedance.sync.v2.protocal.BsyncTopic;
import com.bytedance.sync.v2.protocal.Flag;
import hg7.h;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements com.bytedance.sync.v2.process.d<Flag> {
    public d() {
    }

    @Override // com.bytedance.sync.v2.process.d
    public final boolean a(Flag r100) {
        if (r100 != Flag.ACK) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.sync.v2.process.d
    public final void b(BsyncHeader r100, List<BsyncTopic> r101) {
        hg7.b r102 = (hg7.b) rgc.b.a(hg7.b.class);
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        BsyncTopic r104 = (BsyncTopic) r103.next();
        r102.c(r104.sync_id.longValue(), r104.new_cursor.longValue());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        ((h) rgc.b.a(h.class)).w0();
    }
}
