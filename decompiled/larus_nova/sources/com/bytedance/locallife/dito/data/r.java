package com.bytedance.locallife.dito.data;

import android.content.Context;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes21.dex */
public interface r {
    Function2<DitoViewModel, m, BaseDitoModel<?>> a();

    Function2<Context, m, BaseDitoView<?>> getCreateView();
}
