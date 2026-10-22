package com.bytedance.common.process.cross;

import com.bytedance.common.model.ProcessEnum;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IMethodObserver {
    String getMethodName();

    String onMethodCall(ProcessEnum r100, List r101);
}
