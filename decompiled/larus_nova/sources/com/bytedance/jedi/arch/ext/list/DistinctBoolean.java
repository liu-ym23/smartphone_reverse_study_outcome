package com.bytedance.jedi.arch.ext.list;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", "", "value", "", "(Z)V", "getValue", "()Z", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public final class DistinctBoolean {
    private final boolean value;

    public DistinctBoolean() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public final boolean getValue() {
        return this.value;
    }

    public DistinctBoolean(boolean r100) {
        this.value = r100;
    }

    public /* synthetic */ DistinctBoolean(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100);
    }
}
