package com.bytedance.lark.view_flow_wrapper;

import com.bytedance.lark.pb.basic.v1.MoltenInvokeMeta;

/* JADX INFO: loaded from: classes20.dex */
public interface e {
    byte[] a(k r100);

    void onInvokeeEnd(Object r100);

    MoltenInvokeMeta onInvokeeStart(byte[] r100);
}
