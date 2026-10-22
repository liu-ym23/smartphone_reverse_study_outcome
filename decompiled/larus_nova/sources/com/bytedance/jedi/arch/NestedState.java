package com.bytedance.jedi.arch;

import com.bytedance.jedi.arch.State;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bR\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/jedi/arch/NestedState;", "SUB", "Lcom/bytedance/jedi/arch/State;", "substate", "getSubstate", "()Lcom/bytedance/jedi/arch/State;", "newSubstate", "sub", "(Lcom/bytedance/jedi/arch/State;)Lcom/bytedance/jedi/arch/NestedState;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface NestedState<SUB extends State> extends State {
    SUB getSubstate();

    NestedState<SUB> newSubstate(SUB r100);
}
