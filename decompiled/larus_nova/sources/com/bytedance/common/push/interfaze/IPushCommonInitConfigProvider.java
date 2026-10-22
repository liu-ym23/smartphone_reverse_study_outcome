package com.bytedance.common.push.interfaze;

import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.process.cross.IMethodObserver;
import java.util.List;
import rgc.a;

/* JADX INFO: loaded from: classes3.dex */
public interface IPushCommonInitConfigProvider extends a {
    PushCommonConfiguration getConfiguration();

    List<IMethodObserver> getMethodObservers();
}
