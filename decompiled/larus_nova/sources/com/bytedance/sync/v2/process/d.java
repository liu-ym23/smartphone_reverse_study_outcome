package com.bytedance.sync.v2.process;

import com.bytedance.sync.v2.protocal.BsyncHeader;
import com.bytedance.sync.v2.protocal.BsyncTopic;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public interface d<T> {
    boolean a(T r100);

    void b(BsyncHeader r100, List<BsyncTopic> r101);
}
