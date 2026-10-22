package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniProject;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniProjectObserver;", "Lcom/larus/im/internal/jni/observer/Observer;", "onChanged", "", "projects", "", "Lcom/larus/im/internal/jni/bean/OmniProject;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniProjectObserver extends Observer {
    void onChanged(List<OmniProject> r100);
}
