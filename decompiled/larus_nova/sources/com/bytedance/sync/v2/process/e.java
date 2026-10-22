package com.bytedance.sync.v2.process;

import com.bytedance.sync.v2.protocal.BsyncHeader;
import com.bytedance.sync.v2.protocal.BsyncTopic;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface e<T> {
    boolean a(T r100);

    void b(int r100, BsyncHeader r101, List<BsyncTopic> r102);
}
