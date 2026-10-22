package com.bytedance.jedi.arch.ext.list;

import com.bytedance.jedi.arch.IReceiver;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/EmptyReceiver;", "Lcom/bytedance/jedi/arch/IReceiver;", "()V", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public final class EmptyReceiver implements IReceiver {
    public static final EmptyReceiver INSTANCE = null;

    private EmptyReceiver() {
    }

    static {
        INSTANCE = new EmptyReceiver();
    }
}
