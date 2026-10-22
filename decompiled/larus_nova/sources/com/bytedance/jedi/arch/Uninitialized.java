package com.bytedance.jedi.arch;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/arch/Uninitialized;", "Lcom/bytedance/jedi/arch/Async;", "", "()V", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Uninitialized extends Async {
    public static final Uninitialized INSTANCE = null;

    static {
        INSTANCE = new Uninitialized();
    }

    private Uninitialized() {
        super(null);
    }
}
