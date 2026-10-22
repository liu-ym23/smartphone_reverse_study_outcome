package com.ss.android.lark.lynxkit.bridge;

import android.content.Context;
import com.lynx.tasm.behavior.LynxContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rH&J\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/ILynxBridgeContext;", "", "getContext", "Landroid/content/Context;", "getLynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "getContainerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "sendGlobalEventToJS", "", "eventName", "", "dataMap", "", "sendDataToJSByModule", "data", "", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILynxBridgeContext {
    ILynxContainerContext getContainerContext();

    Context getContext();

    LynxContext getLynxContext();

    void sendDataToJSByModule(List<? extends Object> r100);

    void sendGlobalEventToJS(String r100, Map<String, ? extends Object> r101);
}
