package com.bytedance.jedi.arch;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/arch/NestedLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "isLastEventEmittedByParent", "", "()Z", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface NestedLifecycleOwner extends LifecycleOwner {
    boolean isLastEventEmittedByParent();
}
