package com.bytedance.locallife.dito.core;

import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/dito/core/IDitoView;", "Lcom/bytedance/locallife/dito/core/DitoLifecycleOwner;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public interface IDitoView extends DitoLifecycleOwner {
    BaseDitoModel<?> hm();

    DitoViewModel uP();
}
