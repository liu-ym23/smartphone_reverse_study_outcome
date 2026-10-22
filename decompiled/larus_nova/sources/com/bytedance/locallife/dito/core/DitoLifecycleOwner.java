package com.bytedance.locallife.dito.core;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/dito/core/DitoLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public interface DitoLifecycleOwner extends LifecycleOwner {
    LifecycleRegistry getLifecycleRegistry();
}
